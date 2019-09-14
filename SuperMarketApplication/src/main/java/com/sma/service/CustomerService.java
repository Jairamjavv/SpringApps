package com.sma.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.sma.beans.CustomerBean;

public interface CustomerService {	
	public List<CustomerBean> getCustomerDetails(Date startDate, Date endDate) throws Exception;
	public Integer addCustomer(CustomerBean customerBean) throws Exception;
	public Map<String, String> getCustomerTypes() throws Exception;
}