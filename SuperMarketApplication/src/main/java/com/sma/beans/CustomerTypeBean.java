package com.sma.beans;

public class CustomerTypeBean {
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
