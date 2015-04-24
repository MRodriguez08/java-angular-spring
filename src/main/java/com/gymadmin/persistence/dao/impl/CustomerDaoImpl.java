package com.gymadmin.persistence.dao.impl;

import org.springframework.stereotype.Component;

import com.gymadmin.persistence.dao.CustomerDao;
import com.gymadmin.persistence.entities.CustomerEntity;

/**
 *
 * @author mrodriguez
 */
@Component("customerDao")
public class CustomerDaoImpl extends DaoImpl<Integer , CustomerEntity> implements CustomerDao {
    
}
