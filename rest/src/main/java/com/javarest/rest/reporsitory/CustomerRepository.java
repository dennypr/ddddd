/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javarest.rest.reporsitory;

import com.javarest.rest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Denny
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
  // public List<Customer> findOneById(Integer id);
}
