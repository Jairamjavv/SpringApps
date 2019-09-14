package com.sma.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sma.beans.CustomerBean;
import com.sma.beans.CustomerTypeBean;
import com.sma.dao.CustomerDAOWrapper;

@Service
public class CustomerServiceImpl{
	
	@Autowired
	CustomerDAOWrapper customerDaoWrapper;

	public List<CustomerBean> getCustomerDetails(Date startDate, Date endDate) throws Exception{
		List<CustomerBean> lcb = new ArrayList<CustomerBean>();
		lcb = customerDaoWrapper.getCustomerDetails(startDate, endDate);
		if(lcb.isEmpty()) {
			throw new Exception();
		}
		else {
			return lcb;
		}
	}

	public Integer addCustomer(CustomerBean customerBean) throws Exception {
		CustomerTypeBean ctb = customerDaoWrapper.getCustomerTypeDetails(customerBean.getCustomerType());
		Integer i=0;
		if((customerBean.getBill() > ctb.getMinimumBill()) && (customerBean.getBill() < ctb.getMaximumBill())) {
			i = customerDaoWrapper.addCustomer(customerBean);
		}
		else{
			throw new Exception();
		}
		
		return i;
	}

	public Map<String, String> getCustomerTypes() throws Exception{
		List<String> lstr = customerDaoWrapper.getCustomerTypes();
		Map<String, String> mapss = new HashMap<String, String>();
		for(String s : lstr) {
			switch(s.charAt(0)) {
			case 'P' : mapss.put(s, "Platinum");break;
			case 'G' : mapss.put(s, "Gold");break;
			case 'S' : mapss.put(s, "Silver");break;
			}
		}
		return mapss;
	}

	
}
