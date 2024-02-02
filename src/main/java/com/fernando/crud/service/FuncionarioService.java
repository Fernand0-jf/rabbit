package com.fernando.crud.service;

import java.util.List;

import com.fernando.crud.model.Funcionario;

public interface FuncionarioService {
	Funcionario salvarFuncionario(Funcionario funcionario);
	List<Funcionario> obterFuncionarios();
	Funcionario obterFuncionarioPorId(Long id);
	Funcionario atualiazarFuncionario(Funcionario funcionario,Long id);
	void removerFuncionario(Long id);

}
