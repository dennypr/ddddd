/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javarest.rest.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="product")
@ApiModel(description = "All details about the Product. ")
public class Product {
   @Id  
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @ApiModelProperty(notes = "The Database Generated Product ID.")
   private int pid; 
   
   @ApiModelProperty(notes = "The Product Name.")
   private String productName;  
   
   @ApiModelProperty(notes = "The Product Qty.")
   private int qty;  
   
   @ApiModelProperty(notes = "The Product Price.")
   private int price;  

        
}
