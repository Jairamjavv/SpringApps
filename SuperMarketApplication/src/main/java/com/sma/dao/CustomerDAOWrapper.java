package com.sma.dao;

import java.sql.Date;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sma.beans.CustomerBean;
import com.sma.beans.CustomerTypeBean;
import com.sma.entity.CustomerEntity;
import com.sma.entity.CustomerTypeEntity;

@Repository
@Transactional(value = "txManager")
public class CustomerDAOWrapper {

	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private CustomerTypeDAO customerTypeDAO;

	@PersistenceContext
	private EntityManager entityManager;

	public List<CustomerBean> getCustomerDetails(Date startDate, Date endDate) throws Exception {
		List<CustomerBean> list = new ArrayList<CustomerBean>();
		try {
			List<CustomerEntity> listEntity = customerDAO.getCustomerDetails(startDate, endDate);
			for (CustomerEntity ce : listEntity) {
				CustomerBean cb = convertEntityToBean(ce);
				list.add(cb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<String> getCustomerTypes() {
		List<String> list = new ArrayList<String>();
		try {
			List<String> listEntity = customerTypeDAO.getCustomerTypes();
			for (String str : listEntity) {
				list.add(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public CustomerTypeBean getCustomerTypeDetails(String customerType) {
		String str = "SELECT * FROM customerTypes WHERE customerType = " + customerType;
		CustomerTypeBean ctb = new CustomerTypeBean();
		try {

			List<CustomerTypeEntity> list = entityManager.createNativeQuery(str).getResultList();
			for (CustomerTypeEntity cte : list) {
				ctb = convertTypeEntityToBean(cte);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ctb;
	}

	public Integer addCustomer(CustomerBean customerBean) {

		CustomerEntity ce = convertBeanToEntity(customerBean);
		try {
			entityManager.persist(ce);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ce.getCustomerId();
	}

	// Utility Methods.......
	public static CustomerBean convertEntityToBean(CustomerEntity entity) {
		CustomerBean customerBean = new CustomerBean();
		BeanUtils.copyProperties(entity, customerBean);
		return customerBean;
	}

	public static CustomerTypeBean convertTypeEntityToBean(CustomerTypeEntity entity) {
		CustomerTypeBean customerBean = new CustomerTypeBean();
		BeanUtils.copyProperties(entity, customerBean);
		return customerBean;
	}

	public static CustomerEntity convertBeanToEntity(CustomerBean bean) {
		CustomerEntity entity = new CustomerEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}

}
