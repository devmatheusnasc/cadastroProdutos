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


@Table(name = " ITEMSPEDIDOS")
@Entity
public class ItemsPedidos implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column
	private UUID orderId;
	
	@Column
	private UUID itemId;
	
	@Column	
	private double quantity;
	
	@Column
	private double totalValue;
	
	
	public ItemsPedidos() {
		
	}

	
	public ItemsPedidos(UUID id, UUID orderId, UUID itemId, double quantity, double totalValue) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.totalValue = totalValue;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getOrder() {
		return orderId;
	}

	public void setOrder(UUID orderId) {
		this.orderId = orderId;
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
		ItemsPedidos other = (ItemsPedidos) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
