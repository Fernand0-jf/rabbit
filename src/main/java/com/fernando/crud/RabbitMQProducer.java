package com.fernando.crud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fernando.crud.Dto.MailStructure;

@Service
public class RabbitMQProducer {
	@Value("${rabbitmq.exchangeEmail.name}")
	private String exchangeEmail;
	@Value("${rabbitmq.routingkeyEmail}")
	private String routingKeyEmail;
	
	private final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendEmail(String email) {
		LOGGER.info(String.format("send request email: %s", email));
		rabbitTemplate.convertAndSend(exchangeEmail, routingKeyEmail, email);
	}
	
}
