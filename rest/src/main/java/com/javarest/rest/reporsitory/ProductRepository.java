/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javarest.rest.reporsitory;

import com.javarest.rest.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Denny
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{
    
   @Query(value =" Select * from product where cp_fk = ?1 ",nativeQuery = true)
   public List<Product> findByCpfk(Integer cpfk); 
}
