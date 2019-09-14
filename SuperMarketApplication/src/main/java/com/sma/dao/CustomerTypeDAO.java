package com.sma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sma.entity.CustomerTypeEntity;

@RepositoryDefinition(idClass = Integer.class, domainClass = CustomerTypeEntity.class)
@Transactional(value = "txmanager")
public interface CustomerTypeDAO {
	@Query(value="SELECT customerType FROM customerTypes", nativeQuery=true)
	public List<String> getCustomerTypes();
}
