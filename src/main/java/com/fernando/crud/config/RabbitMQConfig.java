package com.fernando.crud.config;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Value("${rabbitmq.queue.name}")
	private String queue;
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	@Value("${rabbitmq.routingkey}")
	private String routingKey;
	
	@Value("${rabbitmq.queueEmail.name}")
	private String queueEmail;
	@Value("${rabbitmq.exchangeEmail.name}")
	private String exchangeEmail;
	@Value("${rabbitmq.routingkeyEmail}")
	private String routingKeyEmail;
	
	@Bean
	public Queue queue() {
		return new Queue(queue);
	}
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}
	
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue())
				.to(exchange())
				.with(routingKey);
	}
	
	@Bean
	public Queue queueEmail() {
		return new Queue(queueEmail);
	}
	
	@Bean
	public TopicExchange exchangeEmail() {
		return new TopicExchange(exchangeEmail);
	}
	
	@Bean
	public Binding binding2() {
		return BindingBuilder.bind(queueEmail())
				.to(exchangeEmail())
				.with(routingKeyEmail);
	}
	
	@Bean
	public MessageConverter convert() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(convert());
		return rabbitTemplate;
	}
	
}
