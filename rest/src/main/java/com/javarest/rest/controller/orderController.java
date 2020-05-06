/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javarest.rest.controller;


import com.javarest.rest.entity.Customer;
import com.javarest.rest.entity.Product;
import com.javarest.rest.reporsitory.CustomerRepository;
import com.javarest.rest.reporsitory.ProductRepository;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Denny
 */

@RestController
@RequestMapping("/v1")
public class orderController {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private ProductRepository productRepository;   
    
    @GetMapping("/palindrome/{var}")
    @ApiOperation(value="Input palindorme ", notes="Input palindorme", response=Customer.class)
    public boolean palindorme(@PathVariable(value="var") String var){    
        String temp ="";      
        for(int i=var.length()-1; i>=0; i--) {
            temp = temp + var.charAt(i);
        }          
                
        if (var == temp) {
           return true;
        }  else {
           return false;
        }
             
    }    
    
    
    @PostMapping("/placeOrder")
    @ApiOperation(value="ADD An Order ", notes="Provide For ADD To Order", response=Customer.class)
    public Customer placeOrder(@Valid @RequestBody Customer request){
       return customerRepository.save(request);        
    }    
    
    @PutMapping("/updateOrder/{id}")
    @ApiOperation(value="UPDATE Order By Id", notes="Provide Id For UPDATE From Order", response=Customer.class)
    public Optional<Customer> placeOrder(@PathVariable(value="id") Integer id,@Valid @RequestBody Customer request){ 
        
        Customer cs = new Customer();
        cs.setId(id);
        cs.setName(request.getName());
        cs.setEmail(request.getEmail());
        cs.setGender(request.getGender());
        List<Product> getAll = productRepository.findByCpfk(id);
        cs.setProducts(getAll);
        customerRepository.save(cs); 
        int i=0;
        for(Product st : getAll) {            
            Product pr = new Product();
            pr.setPid(st.getPid());
            pr.setPrice(request.getProducts().get(i).getPrice());
            pr.setProductName(request.getProducts().get(i).getProductName());
            pr.setQty(request.getProducts().get(i).getQty());
            productRepository.save(pr);   
            i++;
        } 
                
      return   customerRepository.findById(id);        

    }
    
    @DeleteMapping("/deleteOrder/{id}")
    @ApiOperation(value="DELETE Order By Id", notes="Provide Id For DELETE From Order", response=Customer.class)
    public void deleteOrder(@PathVariable(value="id") Integer id){
        customerRepository.deleteById(id);
    }
    
    @GetMapping("/findAllOrder/{id}")
    @ApiOperation(value="GET Order By Id", notes="Provide Id For GET From Order", response=Customer.class)
    public Optional<Customer> getOrder(@PathVariable(value="id") Integer id){
        
        
       return customerRepository.findById(id);
    }
    
    @GetMapping("/findAllOrder")
    @ApiOperation(value="VIEW All List Of Order", notes="Provide Id For VIEW All From Order", response=Customer.class)
    public List<Customer> finAllOrder(){
        return customerRepository.findAll();
    }
}
