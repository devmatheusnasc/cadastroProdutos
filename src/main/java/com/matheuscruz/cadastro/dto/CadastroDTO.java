package com.matheuscruz.cadastro.dto;

import java.io.Serializable;
import java.util.UUID;

import com.matheuscruz.cadastro.domain.Cadastro;

public class CadastroDTO implements Serializable {
	private static final long serialVersionUID = 4384391168434254251L;
	
	
	private UUID id;
	private String description;
	private double value;
	private char type;

	public CadastroDTO() {
		
	}
	
	public CadastroDTO(Cadastro obj) {
		id = obj.getId();
		description = obj.getDescription();
		value = obj.getValue();
		type = obj.getType();
		
	}
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}
	
	

}
