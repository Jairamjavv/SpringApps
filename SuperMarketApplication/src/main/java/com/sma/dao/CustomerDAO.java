package com.sma.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.sma.entity.CustomerEntity;

@RepositoryDefinition(idClass = Integer.class, domainClass = CustomerEntity.class)
@Transactional(value = "txManager")
// name of TransactionManger can be any thing
public interface CustomerDAO {
	@Query(value = "SELECT * FROM customer", nativeQuery = true)
	List<CustomerEntity> getCustomerDetails(Date startDate, Date endDate);
}
