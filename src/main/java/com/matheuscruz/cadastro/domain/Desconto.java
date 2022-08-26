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

@Table(name = "DESCONTO")
@Entity
public class Desconto implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID orderId;
	
	@Column
	private double percentualDiscount;
	
	public Desconto() {
		
	}

	public Desconto(UUID orderId, double percentualDiscount) {
		super();
		this.orderId = orderId;
		this.percentualDiscount = percentualDiscount;
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

	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Desconto other = (Desconto) obj;
		return Objects.equals(orderId, other.orderId);
	}
	
	

}
