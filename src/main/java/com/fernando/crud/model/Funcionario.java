package com.fernando.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tb_funcionarios")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="primeiro_nome",nullable = false)
	private String primeiroNome;
	@Column(name="ultimo_nome",nullable = false)
	private String ultimoNome;
	@Column(name="email")
	private String email;

}
