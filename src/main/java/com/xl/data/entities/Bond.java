package com.xl.data.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BOND")
public class Bond extends Investment {
	@Column(name = "VALUE")
	private BigDecimal value;

	@Column(name = "INTEREST_RATE")
	private BigDecimal interestRate;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "MATURITY_DATE")
	private Date maturityDate;

	public BigDecimal getValue() {
		return value;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
}
