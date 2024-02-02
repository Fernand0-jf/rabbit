package com.fernando.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String resourceNome;
	private String campoNome;
	private Object campoValor;
	
	public ResourceNotFoundException(String resourceNome, String campoNome, Object campoValor) {
		super(String.format("%s não encontrado com %s : %s", resourceNome,campoNome,campoValor));
		this.resourceNome = resourceNome;
		this.campoNome = campoNome;
		this.campoValor = campoValor;
	}

	public String getResourceNome() {
		return resourceNome;
	}

	public void setResourceNome(String resourceNome) {
		this.resourceNome = resourceNome;
	}

	public String getCampoNome() {
		return campoNome;
	}

	public void setCampoNome(String campoNome) {
		this.campoNome = campoNome;
	}

	public Object getCampoValor() {
		return campoValor;
	}

	public void setCampoValor(Object campoValor) {
		this.campoValor = campoValor;
	}
	
	
	
	
	

}
