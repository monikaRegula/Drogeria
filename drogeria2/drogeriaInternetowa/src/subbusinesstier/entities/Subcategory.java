/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstier.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import subbusinesstier.Factory;

/**
 *
 * @author asus
 */
public class Subcategory {
    private String name;
    List<Product> products;
    private Category category;


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
       
        return "Próba dodania tego sameg produktu";
    }
    
   
    @Override
    public String toString(){
        String result = "Name:"+getName();
        return result;
    }
    
    @Override
public boolean equals(Object obj) {
if (this == obj) {
return true;
}
if (obj == null) {
return false;
}
if (getClass() != obj.getClass()) {
return false;
}
final Subcategory other = (Subcategory) obj;
if (!Objects.equals(this.name, other.name)) {
return false;
}
return true;
}
    }
