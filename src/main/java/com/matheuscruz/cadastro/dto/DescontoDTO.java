package com.matheuscruz.cadastro.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;

import com.matheuscruz.cadastro.domain.Desconto;

public class DescontoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@NotEmpty(message="Preenchimento  obrigatório")
	private UUID orderId;
	
	@NotEmpty(message="Preenchimento  obrigatório")
	private double percentualDiscount;
	
	public DescontoDTO() {
		
	}
	
	public DescontoDTO(Desconto obj) {
		orderId = obj.getOrderId();
		percentualDiscount = obj.getPercentualDiscount();
		
	}

	public UUID getOrderId() {
		return orderId;
	}

	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}

	public double getPercentualDiscount() {
		return percentualDiscount;
	}

	public void setPercentualDiscount(double percentualDiscount) {
		this.percentualDiscount = percentualDiscount;
	}
	
	

}
