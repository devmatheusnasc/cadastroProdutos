package com.matheuscruz.cadastro.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

public class Pedidos implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private UUID id;
	
	
	private Integer number;
	private Timestamp date;
	private double percentualDiscount;
	private double totalValue;
	
	
	public Pedidos() {
		
	}

	public Pedidos(UUID id, Integer number, Timestamp date, double percentualDiscount, double totalValue) {
		super();
		this.id = id;
		this.number = number;
		this.date = date;
		this.percentualDiscount = percentualDiscount;
		this.totalValue = totalValue;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	

	@Override
	public String toString() {
		return "Pedidos [id=" + id + ", number=" + number + ", date=" + date + ", percentualDiscount="
				+ percentualDiscount + ", totalValue=" + totalValue + "]";
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
		Pedidos other = (Pedidos) obj;
		return Objects.equals(id, other.id);
	}
	
}
