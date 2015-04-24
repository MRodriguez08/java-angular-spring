package com.gymadmin.services;

import java.util.List;
import java.util.Map;

import com.gymadmin.persistence.entities.CustomerEntity;

/**
 *
 * @author mrodriguez
 */
public interface CustomerService {
    
    public List<CustomerEntity> findAll();
    
    public CustomerEntity create(CustomerEntity e) throws Exception;
    
    public CustomerEntity edit(CustomerEntity e) throws Exception;
    
    public CustomerEntity get(Integer Id) throws Exception;
    
    public void delete(Integer Id) throws Exception;
    
}
