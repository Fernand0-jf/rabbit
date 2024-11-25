package com.fernando.crud.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.crud.RabbitMQProducer;
import com.fernando.crud.exception.ResourceNotFoundException;
import com.fernando.crud.model.Funcionario;
import com.fernando.crud.repository.FuncionarioRepository;
import com.fernando.crud.service.FuncionarioService;
@Service
public class FuncionarioServiceImpl implements FuncionarioService{
	
	private FuncionarioRepository funcionarioRepository;
	private RabbitMQProducer mqProducer;
	
	@Autowired
	public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository,RabbitMQProducer mqProducer) {
		super();
		this.funcionarioRepository = funcionarioRepository;
		this.mqProducer = mqProducer;
	}


	@Override
	public Funcionario salvarFuncionario(Funcionario funcionario) {
		
		mqProducer.sendEmail(funcionario.getEmail());
		return funcionarioRepository.save(funcionario);
	}


	@Override
	public List<Funcionario> obterFuncionarios() {
		return funcionarioRepository.findAll();
	}


	@Override
	public Funcionario obterFuncionarioPorId(Long id) {
		return funcionarioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Funcionario", "Id",id));
	}


	@Override
	public Funcionario atualiazarFuncionario(Funcionario funcionario, Long id) {
		Funcionario funcionarioExistente = this.obterFuncionarioPorId(id);
		funcionarioExistente.setPrimeiroNome(funcionario.getPrimeiroNome());
		funcionarioExistente.setUltimoNome(funcionario.getUltimoNome());
		funcionario.setEmail(funcionario.getEmail());
		return this.salvarFuncionario(funcionarioExistente);
	}


	@Override
	public void removerFuncionario(Long id) {
		Funcionario funcionario = this.obterFuncionarioPorId(id);
		funcionarioRepository.deleteById(id);
	}			
	
	
}
