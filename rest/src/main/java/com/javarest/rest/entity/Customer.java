/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javarest.rest.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 *
 * @author Denny
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "customer")
@ApiModel(description = "All details about the Customer. ")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    @ApiModelProperty(notes = "The Database Generated Customer ID.")
    private int id;   
    
    @ApiModelProperty(notes = "The Customer Name.")
    private String name;   
    
    @ApiModelProperty(notes = "The Customer Email.")
    private String email;    
    
    @ApiModelProperty(notes = "The Customer Gender.")
    private String gender;
    
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name="cp_fk", referencedColumnName = "id")
    private List<Product> products;
  

}
