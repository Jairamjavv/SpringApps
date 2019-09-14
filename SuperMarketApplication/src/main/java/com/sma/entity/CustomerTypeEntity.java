package com.sma.entity;

import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="customertypes")
@NamedNativeQuery(
	    name = "CustomerTypeEntity.findAll",
	    query = "SELECT * FROM atp_players",
	    resultClass = CustomerTypeEntity.class)
public class CustomerTypeEntity {
	private String customerType;
	private double minimumBill;
	private double maximumBill;

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public double getMinimumBill() {
		return minimumBill;
	}

	public void setMinimumBill(double minimumBill) {
		this.minimumBill = minimumBill;
	}

	public double getMaximumBill() {
		return maximumBill;
	}

	public void setMaximumBill(double maximumBill) {
		this.maximumBill = maximumBill;
	}

}
