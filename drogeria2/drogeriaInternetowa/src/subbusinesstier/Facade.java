package subbusinesstier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import subbusinesstier.entities.Category;
import subbusinesstier.entities.Client;
import subbusinesstier.entities.Order;
import subbusinesstier.entities.Product;
import subbusinesstier.entities.ShoppingBag;
import subbusinesstier.entities.Subcategory;

public class Facade {

    private ArrayList<Client> clients;
    private ArrayList<Order> orders;
    private ArrayList<Category> categories;


    public Facade() {
        clients = new ArrayList();
        categories = new ArrayList();
        orders = new ArrayList();
    }

   
    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

   

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }
    
    public String addCategory(String name) {
Category category = new Category(name);
if (searchCategory(category) == null) {
categories.add(category);
return category.toString();
}
return "Proba dodania takiej samej kategorii";
}
    
    
public Category searchCategory(Category cat){
int idx;
if ((idx = categories.indexOf(cat)) != -1) {
return categories.get(idx);
}
return null;
}
 

    public String Categoryitems() {
           ArrayList<String> dane = new ArrayList();
            for (Category p : categories) {
            dane.add(p.toString()+"\n");
            }
        return dane.toString();
}
    
    
    
    public String addClient(String[] data){
        Factory factory = new Factory();
        Client client = factory.createClient(data);
        if (Facade.this.searchClient(client) == null) {
            clients.add(client);
            return client.toString();
        }
        return null;
    }
    
    
    public Client searchClient(Client client){
        int idx;
        if ((idx = clients.indexOf(client)) != -1) {
            client = clients.get(idx);
            return client;
        }
        return null;
    }

//    //to dodalam
//    public String addProductToShoppingBag(String[] data1, String[] data2) {
//        Factory factory = new Factory();
//
//        Product helpProduct = factory.createProduct(data1), product;
//        Client helpClient = factory.createClient(data2), client;
//
//        product = searchProduct(helpProduct);
//        client = searchClient(helpClient);
//
//        if (client != null && product != null) {
//            client.addProductToShoppingBag(product);
//            return "Product has been added";
//        } else {
//            return "Product has not been added";
//        }
//    }
////
//     //to dodalam
//     public String removeProductFromShoppingBag(String[] data1, String[] data2) {
//        Factory factory = new Factory();
//
//        Product helpProduct = factory.createProduct(data1), product;
//        Client helpClient = factory.createClient(data2), client;
//
//        product = searchProduct(helpProduct);
//        client = searchClient(helpClient);
//
//        if (client != null && product != null) {
//            client.removeProductFromShoppingBag(product);
//            return "Product has been removed";
//        } else {
//            return "Product has not been removed";
//        }
//    }

    //to zmienilam, tak ze do zamowienia jest dodany koszyk i jak sie uda to klient dostaje nowy koszyk
    public String addOrder(String[] data1, String[] data2) {

        Factory factory = new Factory();

        LocalDate helpLocalDate = LocalDate.now();
        LocalDate localDate = LocalDate.of(Integer.parseInt(data1[0]), Integer.parseInt(data1[1]), Integer.parseInt(data1[2]));

        Client helpClient = factory.createClient(data2), client;
        Order order;
        Order helpOrder;

        if (helpLocalDate.isBefore(localDate)) {
            client = this.searchClient(helpClient);
            if (client != null && !client.getShoppingBag().getProducts().isEmpty()) {
                helpOrder = factory.createOrder(client, localDate, client.getShoppingBag());
                if (Facade.this.searchOrder(helpOrder) == null) {
                    order = factory.createOrder(client, localDate, client.getShoppingBag());
                    client.setShoppingBag(new ShoppingBag());
                    return order.toString();
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }

    }
    
    // public String addOrder(String[] data1, String[] data2){
        
    //     Factory factory = new Factory();
       
    //     LocalDate helpLocalDate = LocalDate.now();
    //     LocalDate localDate = LocalDate.of(Integer.parseInt(data1[0]), Integer.parseInt(data1[1]), Integer.parseInt(data1[2]));
       
    //     Client helpClient = factory.createClient(data2), client; 
    //     Order order;
    //     Order helpOrder;
       
    //     if(helpLocalDate.isBefore(localDate)){
    //        client = this.searchClient(helpClient);
    //             if (client != null) {
    //                 helpOrder = factory.createOrder(client, localDate);
    //                 if(Facade.this.searchOrder(helpOrder) == null){
    //                     order = factory.createOrder(client, localDate);           
    //                     return order.toString();
    //                 }else{
    //                     return null;
    //                 }                   
    //             }else{
    //                 return null;
    //             }
    //     }else{
    //         return null;
    //     }
        
    // }
    
    public Order searchOrder(Order order){
        int idx;
        if ((idx = orders.indexOf(order)) != -1) {
            order = orders.get(idx);
            return order;
        }
        return null;
    }
       

    //wyszukiwanie po podkategoriach
    //zwraca liste produktów dla podkategorii
     public List<Product> searchBySubcategory(String subcategory,String categoryName){
        Category help = new Category(categoryName),existCategory;
        Subcategory sub = new Subcategory(subcategory);
          if ((existCategory=searchCategory(help)) != null) {
              return existCategory.searchSubcategory(sub).getProducts();
          }
        return null;
    }
     
     //wyszukiwanie po kategoriaach
     //zwraca listę podkategorii dla kategorii
     public List<Subcategory> searchByCategory(Category toFind){
         int idx;
        // Category toFind = new Category(category);
        if((idx = categories.indexOf(toFind)) != -1){
             toFind = categories.get(idx);
            return toFind.getSubcategories();
        }
        return null;
    }
     
     
     public String addProduct(String datacategory,String datasubcategory, String []dataproduct)
{ Category category = new Category(datacategory),existcategory;
if ((existcategory=searchCategory(category)) != null) {
return existcategory.addProduct(datasubcategory, dataproduct);
}
return "Brak takiej kategorii";
}
     
       
       public String addSubCategory(String datacategory,String datasubcategory)
{
    Category category = new Category(datacategory),existcategory;
    if ((existcategory=searchCategory(category)) != null) {
    return existcategory.addSubcategory(datasubcategory);
    }
    return "Brakuje podanej kategorii";
}
       
   
     
    public static void main(String[] args) {
     
Facade facade = new Facade();
String c1 = "Make up";
String c2 = "Hair";
System.out.println(facade.addCategory(c1));
System.out.println(facade.addCategory(c2));
System.out.println(facade.addCategory(c1));
System.out.println("Kategorie...");
System.out.println(facade.Categoryitems());
String subc1 ="Lips";
String subc2 ="Eyes";
String subc3 ="conditioner";
String subc4 ="shampoo";
System.out.println("Podkategorie...");
System.out.println(facade.addSubCategory(c1,subc1));
System.out.println(facade.addSubCategory(c1,subc2));
System.out.println(facade.addSubCategory(c1,subc1));
System.out.println(facade.addSubCategory(c2,subc3));
System.out.println(facade.addSubCategory(c2,subc4));
System.out.println(facade.addSubCategory(c2,subc4));
System.out.println(facade.addSubCategory(c2+"n",subc4));
System.out.println("Produkty...");
String[] exampleProduct1 = {"pomadka", "39", "No allergens", "Mac", "czerwona extra super lipsss", ".jpg","222000111", "Make up","Lips", };
String[] exampleProduct2 = {"tusz do rzęs", "39", "No allergens", "Maybelline", "Extra long", ".jpg","222000111", "Make up", "Eyes", };
System.out.println(facade.addProduct(c1,subc1,exampleProduct1));
System.out.println(facade.addProduct(c1,subc2,exampleProduct2));
System.out.println(facade.addProduct(c1,subc1,exampleProduct1));
System.out.println(facade.addProduct(c2,subc1,exampleProduct1));
System.out.println(facade.addProduct(c2+"n",subc1,exampleProduct1));
     

    }
}
