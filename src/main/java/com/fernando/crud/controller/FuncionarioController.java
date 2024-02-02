package com.fernando.crud.controller;

import java.util.List;

import org.hibernate.Remove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.crud.model.Funcionario;
import com.fernando.crud.service.FuncionarioService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
	
	private FuncionarioService funcionarioService;
	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		super();
		this.funcionarioService = funcionarioService;
	}
	//salvar funcionario Rest api
	@PostMapping
	public ResponseEntity<Funcionario> salvarFuncionario(@RequestBody Funcionario funcionario){
		return new ResponseEntity<Funcionario>(funcionarioService.salvarFuncionario(funcionario),HttpStatus.CREATED);
	}
	//buscar funcionarios Rest api
	@GetMapping
	public List<Funcionario> obterFuncionarios(){
		return funcionarioService.obterFuncionarios();
	}
	@GetMapping("{id}")
	public ResponseEntity<Funcionario> obterFuncionarioPorId(@PathVariable("id") Long id ){
		return new ResponseEntity<Funcionario>(funcionarioService.obterFuncionarioPorId(id),HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable("id") Long id,@RequestBody Funcionario funcionario){
		return new ResponseEntity<Funcionario>(funcionarioService.atualiazarFuncionario(funcionario,id), HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> removerFuncionario(@PathVariable("id")  Long id) {
		funcionarioService.removerFuncionario(id);
		return new ResponseEntity<String>("Funcionario deletado com sucesso.", HttpStatus.OK);
	}
	
	
	

}
