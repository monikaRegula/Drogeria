package subbusinesstier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import subbusinesstier.entities.Category;
import subbusinesstier.entities.Client;
import subbusinesstier.entities.Order;
import subbusinesstier.entities.OrderStatus;
import subbusinesstier.entities.Product;
import subbusinesstier.entities.ShoppingBag;
import subbusinesstier.entities.Subcategory;


public class Factory {

    public Factory() {
    }
    
    public Client createClient(String[] data){
        Client client = new Client();
        ShoppingBag shoppingBag = new ShoppingBag();
        client.setShoppingBag(shoppingBag);
        client.setEmial(data[0]);
        client.setFirstName(data[1]);
        client.setLastName(data[2]);
        client.setPhoneNumber(data[3]);
        client.setCode(data[4]);
        client.setCity(data[5]);
        client.setStreet(data[6]);
        client.setNumber(data[7]);       
        
        return client;
    }
    
    public Product createProduct(String[] data){
        Product product = new Product();
        product.setName(data[0]);
        product.setPrice(Integer.parseInt(data[1]));
        product.setAllergen(data[2]);
        product.setBrand(data[3]);
        product.setType(data[4]);
        product.setPhoto(data[5]);
        product.setBarCode(Integer.parseInt(data[6]));
        
        return product;
    }
    
    //zmienione
    public Order createOrder(Client client, LocalDate localDate, ShoppingBag shoppingBag){
        
        Order order = new Order();
        order.setClient(client);
        order.setLocalDate(localDate);
        order.setShoppingBag(shoppingBag);
        order.setOrderStatus(OrderStatus.PLACED);
        return order;  
         
    }
    
    
   
    public Category createCategory(String name){
        Category category = new Category();
        category.setName(name);
        return category;
    }
    
  
 
}
