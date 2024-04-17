package com.fernando.crud.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fernando.crud.RabbitMQProducer;
import com.fernando.crud.Dto.UserDto;
import com.fernando.crud.model.Funcionario;
import com.fernando.crud.service.FuncionarioService;

@Service
public class RabbitMQConsumer {
	private Funcionario funcionario;
	private RabbitMQProducer mqProducer;
	private FuncionarioService funcionarioService;
	
	private final static Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);
	
	public RabbitMQConsumer(FuncionarioService funcionarioService,RabbitMQProducer mqProducer) {
		this.funcionarioService = funcionarioService;
		this.mqProducer= mqProducer; 
	}

	@RabbitListener(queues= {"${rabbitmq.queue.name}"})
	public void  consume(UserDto userDto){
		funcionario = new Funcionario();
		funcionario.setPrimeiroNome(userDto.firstName());
		funcionario.setUltimoNome(userDto.lastName());
		funcionario.setEmail(userDto.email());
		LOGGER.info(String.format("UserDto received: %s", userDto));
		funcionarioService.salvarFuncionario(funcionario);
		mqProducer.sendEmail(userDto.email());
	}
}
