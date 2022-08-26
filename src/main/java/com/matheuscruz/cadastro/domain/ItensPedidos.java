package com.matheuscruz.cadastro.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="itens")
@Entity
public class ItensPedidos implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column
	private UUID order;
	
	@Column
	private UUID itemId;
	
	@Column
	private double quantity;
	
	@Column
	private double totalValue;
	
	
	@ElementCollection
	@CollectionTable(name = "DESCONTO")
	private Set<String> percentualDescont = new HashSet<>();
	
	public ItensPedidos() {
		
	}

	public ItensPedidos(UUID id, UUID order, UUID itemId, double quantity, double totalValue) {
		super();
		this.id = id;
		this.order = order;
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
	

	@Override
	public int hashCode() {
		return Objects.hash(id, itemId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensPedidos other = (ItensPedidos) obj;
		return Objects.equals(id, other.id) && Objects.equals(itemId, other.itemId);
	}

	
	
	
}