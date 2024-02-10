package com.fernando.crud.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.fernando.crud.model.Funcionario;
import com.fernando.crud.service.FuncionarioService;

@ExtendWith(MockitoExtension.class)
class FuncionarioControllerTest {
	@Mock
	private FuncionarioService funcionarioService;
	@InjectMocks
	private FuncionarioController funcionarioController;
	
	@Test
	public void salvarFuncionario() {
		Funcionario func1 = criarUsuario1();
		when(funcionarioService.salvarFuncionario(func1)).thenReturn(func1);
		ResponseEntity<Funcionario> resposta =  funcionarioController.salvarFuncionario(func1);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		assertEquals(func1,resposta.getBody());
		
	}
	@Test
	public void salvarFuncionarioErro() {
		Funcionario func = criarUsuario1();
		when(funcionarioService.salvarFuncionario(func)).thenThrow(new RuntimeException("erro ao salvar usuario"));
		assertThrows(RuntimeException.class,()->funcionarioController.salvarFuncionario(func));
	}
	
	@Test
	public void obterFuncionarios() {
		Funcionario func = criarUsuario1();
		Funcionario func2 = criarUsuario2();
		List<Funcionario> funcs = new ArrayList<>();
		funcs.add(func2);funcs.add(func);
				
		when(funcionarioService.obterFuncionarios()).thenReturn(funcs);
		List<Funcionario> result = funcionarioController.obterFuncionarios();
		assertTrue(result.containsAll(funcs));
	}
	
	@Test
	public void obterFuncionariosErro() {
		when(funcionarioService.obterFuncionarios()).thenThrow(new  RuntimeException("erro ao obter funcionarios"));
		assertThrows(RuntimeException.class, ()->funcionarioController.obterFuncionarios());
	}
	
	@Test
	public void obterFuncionarioPorId() {
		Funcionario func = criarUsuario1();
		when(funcionarioService.obterFuncionarioPorId(1L)).thenReturn(func);
		ResponseEntity<Funcionario> result = funcionarioController.obterFuncionarioPorId(1L);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(func, result.getBody());
	}
	@Test
	public void obterFuncionarioPorIdErro() {
		when(funcionarioService.obterFuncionarioPorId(anyLong())).thenThrow(new RuntimeException("erro ao obter funcionario por id"));
		assertThrows(RuntimeException.class, ()->funcionarioController.obterFuncionarioPorId(anyLong()));
	}
	
	@Test
	public void atualizarFuncionario() {
		Funcionario func = criarUsuario1();
		Funcionario func2 = criarUsuario2();
		when(funcionarioService.atualiazarFuncionario(func2, 1L)).thenReturn(func2);
		ResponseEntity<Funcionario> result = funcionarioController.atualizarFuncionario(1L, func2);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(func2, result.getBody());
	}
	@Test
	public void atualizarFuncionarioErro() {
		when(funcionarioService.atualiazarFuncionario(any(), anyLong())).thenThrow(new RuntimeException("erro ao atualizar funcionario"));
		assertThrows(RuntimeException.class, ()->funcionarioController.atualizarFuncionario(anyLong(), any()));
	}
	
	@Test
	public void removerFuncionario() {
		Funcionario func = criarUsuario1();
		ResponseEntity<String> result = funcionarioController.removerFuncionario(1L);
		assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Funcionario deletado com sucesso.", result.getBody());
	}
	
	 @Test
	    void removerFuncionarioErro() {
	        doThrow(new RuntimeException("Erro ao remover funcionário")).when(funcionarioService).removerFuncionario(1L);
	        RuntimeException exception = assertThrows(RuntimeException.class, () -> funcionarioController.removerFuncionario(1L));
	        assertEquals("Erro ao remover funcionário", exception.getMessage());

	    }
	
	
	
	public Funcionario criarUsuario1() {
		Funcionario funcionario = new Funcionario();
		funcionario.setId(1L);
		funcionario.setPrimeiroNome("luiz");
		funcionario.setUltimoNome("silva");
		funcionario.setEmail("luiz@aragao.com");
		return funcionario;
	}
	public Funcionario criarUsuario2() {
		Funcionario funcionario = new Funcionario();
		funcionario.setId(2L);
		funcionario.setPrimeiroNome("ana");
		funcionario.setUltimoNome("oliveira");
		funcionario.setEmail("ana@sou.com");
		return funcionario;
	}
}
