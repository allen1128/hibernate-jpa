package com.xl.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.xl.data.entities.ids.CurrencyId;

//not recommended to use composite keys, use surrogate keys instead.
@Entity
@IdClass(CurrencyId.class)
public class Currency {

	@Id
	@Column(name="NAME")
	private String name;

	@Id
	@Column(name="COUNTRY_NAME")
	private String countryName;

	@Column(name="SYMBOL")
	private String symbol;

	public String getName() {
		return name;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
}