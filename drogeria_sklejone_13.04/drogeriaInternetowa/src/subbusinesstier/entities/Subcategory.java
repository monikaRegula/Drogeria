/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstier.entities;

import java.util.ArrayList;
import java.util.List;
import subbusinesstier.Factory;

/**
 *
 * @author asus
 */
public class Subcategory {
    private String name;
    List<Product> products;
    private Category category;

    public Subcategory() {
        products = new ArrayList<>();
    }

    public Subcategory(String name) {
       this.name=name;
        products = new ArrayList<>();
    }

  
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
     public Product searchProduct(Product product){
        int idx;
        if ((idx = products.indexOf(product)) != -1) {
             product= products.get(idx);
            return product;
        }
        return null;
    }
     
      
    public String addProduct(String[] data){
       Factory factory = new Factory();
       Product product = factory.createProduct(data);
       if(searchProduct(product) == null){
           this.products.add(product);
           product.setSubcategory(this);
           return product.toString();
       }
       
        return null;
    }
    
    @Override
    public String toString(){
        String result = "Name:"+getName();
        result += "Category:"+category.getName();
        return result;
    }
    }
