package com.xl.data.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Investment {
	@Column(name = "NAME")
	protected String name;

	@Column(name = "ISSUER")
	protected String issuer;

	@Column(name = "PURCHASE_DATE")
	protected Date purchaseDate;

	public String getName() {
		return name;
	}

	public String getIssuer() {
		return issuer;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

}