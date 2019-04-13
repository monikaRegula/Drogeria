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
public class Category {
    private String name;
    private List<Subcategory> subcategories;

    public Category() {
        this.subcategories = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Category other = (Category) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

 
    public Category(String name) {
        this.name = name;
        this.subcategories = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    
    
    @Override
    public String toString(){
        String result = "Category: "+name;
        result += " Subcategories: "+subcategories.toString();
        return result;
    }
    
    
       
       public Subcategory searchSubcategory(Subcategory subcategory){
       int idx;
        if ((idx = subcategories.indexOf(subcategory)) != -1) {
           return subcategories.get(idx);
        }
        return null;
    }

    public String addSubcategory(String name) {
        Subcategory subcategory = new Subcategory(name);
       if(searchSubcategory(subcategory) == null){
           subcategories.add(subcategory);
           subcategory.setCategory(this);
           return toString();
       }
       return "Próba dodania takiej samej podkategorii";
    }
 
      
      public String addProduct(String datasubcategory, String []dataproduct)
{ Subcategory subcategory = new Subcategory(datasubcategory),existsubcategory;
if ((existsubcategory=searchSubcategory(subcategory)) != null) {
return existsubcategory.addProduct(dataproduct);
}
return "Brak podkategorii";
}

}
