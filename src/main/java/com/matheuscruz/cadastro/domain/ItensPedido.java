package com.matheuscruz.cadastro.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Table(name="itens_pedido")
@Entity
public class ItensPedido implements Serializable{
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
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "ITENS_PEDIDOS",
			joinColumns = @JoinColumn(name = "Itens_id"),
			inverseJoinColumns = @JoinColumn(name = "pedidos_id")	
	)
	private List<Pedidos> pedidos = new ArrayList<>();
	
	
	public ItensPedido() {
		
	}

	public ItensPedido(UUID id, UUID order, UUID itemId, double quantity, double totalValue) {
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
	
	public List<Pedidos> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
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
		ItensPedido other = (ItensPedido) obj;
		return Objects.equals(id, other.id) && Objects.equals(itemId, other.itemId);
	}

	
	
	
}
