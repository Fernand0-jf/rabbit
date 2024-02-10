package com.fernando.crud.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;

import com.fernando.crud.exception.ResourceNotFoundException;
import com.fernando.crud.model.Funcionario;
import com.fernando.crud.repository.FuncionarioRepository;

@ExtendWith(MockitoExtension.class)
class FuncionarioServiceImplTest {
	@Mock
	private FuncionarioRepository funcionarioRepository;

	@InjectMocks
	private FuncionarioServiceImpl funcionarioServiceImpl;
	
	
	@Test
	@DisplayName("Retornar sucesso apos salvar")
	public void salvarFuncionarioCase1() {
		Funcionario funcionario = criarUsuario1();
		when(funcionarioRepository.save(funcionario)).thenReturn(funcionario);
		Funcionario result = funcionarioServiceImpl.salvarFuncionario(funcionario);
		assertEquals(funcionario, result);
	}
	@Test
	@DisplayName("Retornar erro por nao conseguir salvar")
	public void salvarFuncionarioCase2() {
		Funcionario funcionario = criarUsuario1();
		when(funcionarioRepository.save(funcionario)).thenThrow(new RuntimeException("Erro ao salvar") );
		assertThrows(RuntimeException.class, ()->funcionarioServiceImpl.salvarFuncionario(funcionario));
		
	}
	@Test
	@DisplayName("Obtem todos os funcionarios com sucesso")
	public void obterFuncionariosCase1() {
		Funcionario func1 = criarUsuario1();
		Funcionario func2 = criarUsuario2();
		List<Funcionario> funcs =new ArrayList<>();
		funcs.add(func2);funcs.add(func1);
		when(funcionarioRepository.findAll()).thenReturn(funcs);
		List<Funcionario> result = funcionarioServiceImpl.obterFuncionarios();
		assertEquals(2, result.size());
	}
	@Test
	@DisplayName("Obtem todos os funcionarios com fracasso")
	public void obterFuncionariosCase2() {
		Funcionario func1 = criarUsuario1();
		Funcionario func2 = criarUsuario2();
		List<Funcionario> funcs =new ArrayList<>();
		funcs.add(func2);funcs.add(func1);
		when(funcionarioRepository.findAll()).thenThrow(new RuntimeException("erro ao obter os funcionarios"));
		
		assertThrows(RuntimeException.class, ()-> funcionarioServiceImpl.obterFuncionarios());
		
		
	}
	@Test
	@DisplayName("Obtem funcionario pelo id")
	public void obterFuncionarioPorIdCase1() {
		Funcionario func = criarUsuario1();
		when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(func));
		Funcionario result = funcionarioServiceImpl.obterFuncionarioPorId(1L);
		assertEquals(func, result);
		
	}
	@Test
	@DisplayName("Fracassa em obter funcionario pelo id")
	public void obterFuncionarioPorIdCase2() {
		Funcionario func = criarUsuario1();
		when(funcionarioRepository.findById(1L)).thenReturn(Optional.empty());
		assertThrows(ResourceNotFoundException.class,()->funcionarioServiceImpl.obterFuncionarioPorId(1L));
		
	}
	@Test
	@DisplayName("remove funcionario pelo id")
	public void removerFuncionarioCase1() {
		Funcionario func = criarUsuario1();
		when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(func));
		funcionarioServiceImpl.removerFuncionario(1L);
		verify(funcionarioRepository).deleteById(1L);
		
	}
	
	@Test
	@DisplayName("Fracassa em obter funcionario pelo id")
	public void removerFuncionarioCase2() {
		Funcionario func = criarUsuario1();
		when(funcionarioRepository.findById(1L)).thenThrow(new RuntimeException("Nao encontrado o id"));
		assertThrows(RuntimeException.class,()->funcionarioServiceImpl.obterFuncionarioPorId(1L));
		
	}
	@Test
	@DisplayName("atualiza um funcionario com sucesso")
	public void atualizarFuncionarioCase1() {
		Funcionario func = criarUsuario1();
		Funcionario func2 = criarUsuario1();
		when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(func));
		when(funcionarioRepository.save(func2)).thenReturn(func2);
		Funcionario result = funcionarioServiceImpl.atualiazarFuncionario(func2, 1L);
		assertEquals(func2, result);
	}
	@Test
	@DisplayName("Retorna erro( encontrar por id) ao tentar atualizar usuario")
	public void atulizarFuncionarioCase2() {
		Funcionario func = criarUsuario1();
		Funcionario func2 = criarUsuario1();
		when(funcionarioRepository.findById(1L)).thenThrow(new RuntimeException("Erro ao tentar encontar funcioanrio"));
		assertThrows(RuntimeException.class,()->funcionarioServiceImpl.atualiazarFuncionario(func2, 1L));
	
	}
	@Test
	@DisplayName("Retorna erro (salvar usuario ) ao tentar atualizar usuario")
	public void  atualizarFuncionarioCase3() {
		Funcionario func = criarUsuario1();
		Funcionario func2 = criarUsuario2();
		when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(func));
		when(funcionarioRepository.save(func2)).thenThrow(new RuntimeException("erro ao salvar no banco de dados"));
		assertThrows(RuntimeException.class, ()->funcionarioServiceImpl.atualiazarFuncionario(func2, 1L));
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
