package com.matheuscruz.cadastro.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;

import com.matheuscruz.cadastro.domain.ItensPedidos;

public class ItensPedidosDTO implements Serializable {
	private static final long serialVersionUID = 4384391168434254251L;
	
	
	private UUID id;
	
	@NotEmpty(message="Preenchimento  obrigatório")
	private UUID order;
	
	@NotEmpty(message="Preenchimento  obrigatório")
	private UUID itemId;
	
	@NotEmpty(message="Preenchimento  obrigatório")
	private double quantity;
	
	@NotEmpty(message="Preenchimento  obrigatório")
	private double totalValue;


	public ItensPedidosDTO() {
		
	}
	
	public ItensPedidosDTO(ItensPedidos obj) {
		id = obj.getId();
		order = obj.getOrder();
		itemId = obj.getItemId();
		quantity = obj.getQuantity();
		totalValue = obj.getTotalValue();
		
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getOrder() {
		return order;
	}

	public void setOrder(UUID order) {
		this.order = order;
	}

	public UUID getItemId() {
		return itemId;
	}

	public void setItemId(UUID itemId) {
		this.itemId = itemId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	

	

}
