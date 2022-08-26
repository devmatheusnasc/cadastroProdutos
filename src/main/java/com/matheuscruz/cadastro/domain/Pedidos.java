package com.matheuscruz.cadastro.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


@Table(name= "pedidos")
@Entity
public class Pedidos implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column
	private Integer number;
	
	@Column
	@CreationTimestamp
	private Timestamp date;
	
	@Column
	private double percentualDiscount;
	
	@Column
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
