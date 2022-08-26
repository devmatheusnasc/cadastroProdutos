package com.matheuscruz.cadastro.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.matheuscruz.cadastro.domain.tyoe.TipoCadastro;

@Table(name = "cadastro")
@Entity
public class Cadastro implements Serializable {
	private static final long serialVersionUID = 4384391168434254251L;

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column
	private String description;
	
	@Column
	private double value;
	
	@Column
	private char type;
	
	
	public Cadastro() {
		
	}

	public Cadastro(UUID id, String description, double value, TipoCadastro type) {
		super();
		this.id = id;
		this.description = description;
		this.value = value;
		this.type = type.getDescricao();
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

	public void setType(TipoCadastro type) {
		this.type = type.getDescricao();
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastro other = (Cadastro) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
}
