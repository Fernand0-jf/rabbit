package com.fernando.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.crud.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long>{

}
