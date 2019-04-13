package subbusinesstier.entities;

import java.util.ArrayList;


public class ShoppingBag {
    
    private ArrayList<Product> products;

    public ShoppingBag() {
        products = new ArrayList();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    
    public void addProduct(Product product){
        if(products.contains(product) == true){
            System.out.println("Warning: You added product twice!!!");
        }
        else{
            products.add(product);
        }
    }
    
    public void removeProduct(Product product){
        if(products.contains(product)){
            products.remove(product);
        }
    }

    @Override
    public String toString() {
        return "ShoppingBag{" + "products=" + products + '}';
    }
    
   
}
