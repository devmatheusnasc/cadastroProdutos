package com.matheuscruz.cadastro.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;

import com.matheuscruz.cadastro.domain.Pedidos;

public class PedidosDTO implements Serializable {
	private static final long serialVersionUID = 4384391168434254251L;
	
	
	private UUID id;

	@NotEmpty(message="Preenchimento  obrigatório")
	private Integer number;
	
	@NotEmpty(message="Preenchimento  obrigatório")
	private Timestamp date;
	
	@NotEmpty(message="Preenchimento  obrigatório")
	private double percentualDiscount;
	
	private double totalValue;


	public PedidosDTO() {
		
	}
	
	public PedidosDTO(Pedidos obj) {
		id = obj.getId();
		number = obj.getNumber();
		date = obj.getDate();
		percentualDiscount = obj.getPercentualDiscount();
		totalValue = obj.getTotalValue();
		
	}


	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public double getPercentualDiscount() {
		return percentualDiscount;
	}

	public void setPercentualDiscount(double percentualDiscount) {
		this.percentualDiscount = percentualDiscount;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
}
