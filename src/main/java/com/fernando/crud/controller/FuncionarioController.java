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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.crud.model.Funcionario;
import com.fernando.crud.service.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
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
	@Operation(summary = "Salva o funcionario no sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description="Salva o Funcionario no banco de dados"),
			@ApiResponse(responseCode = "400", description="Requisição malformada ou erro de sintaxe",
			content=@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,examples=@ExampleObject(value="BAD_REQUEST"))),
			@ApiResponse(responseCode="500",description="Foi gerada uma exceção",
			content=@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,examples=@ExampleObject(value="INTERNAL_SERVER_ERROR")))
	})
	@PostMapping
	public ResponseEntity<Funcionario> salvarFuncionario(@RequestBody Funcionario funcionario){
		return new ResponseEntity<Funcionario>(funcionarioService.salvarFuncionario(funcionario),HttpStatus.CREATED);
	}
	//buscar funcionarios Rest api
	@Operation(summary = "Lista todos os funcionarios do sistema")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",description="Retorna a lista de funcionario"),
			@ApiResponse(responseCode="400",description="Requisição mal formatada ou erro de sintaxe",
			content=@Content(mediaType= MediaType.APPLICATION_JSON_VALUE,examples=@ExampleObject(value="BAD_REQUEST"))),
			@ApiResponse(responseCode="500",description="Foi gerada uma exceção",
			content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE,examples=@ExampleObject(value="INTRNAL_SERCER_ERROR")))
	})
	@GetMapping
	public List<Funcionario> obterFuncionarios(){
		return funcionarioService.obterFuncionarios();
	}
	@Operation(summary = "Retorna o funcionario pelo id.")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",description="Retorna o funcionario"),
			@ApiResponse(responseCode="400",description="Requisição mal formatada ou erro de sintaxe",
			content=@Content(mediaType= MediaType.APPLICATION_JSON_VALUE,examples=@ExampleObject(value="BAD_REQUEST"))),
			@ApiResponse(responseCode="500",description="Foi gerada uma exceção",
			content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE,examples=@ExampleObject(value="INTRNAL_SERCER_ERROR")))
	})
	@GetMapping("{id}")
	public ResponseEntity<Funcionario> obterFuncionarioPorId(@PathVariable("id") Long id ){
		return new ResponseEntity<Funcionario>(funcionarioService.obterFuncionarioPorId(id),HttpStatus.OK);
	}
	@Operation(summary = "Atualiza o funcionario no sitema")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",description="Atualiza o funcionario"),
			@ApiResponse(responseCode="400",description="Requisição mal formatada ou erro de sintaxe",
			content=@Content(mediaType= MediaType.APPLICATION_JSON_VALUE,examples=@ExampleObject(value="BAD_REQUEST"))),
			@ApiResponse(responseCode="500",description="Foi gerada uma exceção",
			content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE,examples=@ExampleObject(value="INTRNAL_SERCER_ERROR")))
	})
	@PutMapping("{id}")
	public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable("id") Long id,@RequestBody Funcionario funcionario){
		return new ResponseEntity<Funcionario>(funcionarioService.atualiazarFuncionario(funcionario,id), HttpStatus.OK);
	}
	@Operation(summary = "Remove o funcionario do sitema")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",description="Remove o funcionario"),
			@ApiResponse(responseCode="400",description="Requisição mal formatada ou erro de sintaxe",
			content=@Content(mediaType= MediaType.APPLICATION_JSON_VALUE,examples=@ExampleObject(value="BAD_REQUEST"))),
			@ApiResponse(responseCode="500",description="Foi gerada uma exceção",
			content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE,examples=@ExampleObject(value="INTRNAL_SERCER_ERROR")))
	})
	@DeleteMapping("{id}")
	public ResponseEntity<String> removerFuncionario(@PathVariable("id")  Long id) {
		funcionarioService.removerFuncionario(id);
		return new ResponseEntity<String>("Funcionario deletado com sucesso.", HttpStatus.OK);
	}
	
	
	

}
