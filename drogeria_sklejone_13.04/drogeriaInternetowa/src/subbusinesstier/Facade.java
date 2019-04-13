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

    //to dodalam
    public String addProductToShoppingBag(String[] data1, String[] data2) {
        Factory factory = new Factory();

        Product helpProduct = factory.createProduct(data1), product;
        Client helpClient = factory.createClient(data2), client;

        product = searchProduct(helpProduct);
        client = searchClient(helpClient);

        if (client != null && product != null) {
            client.addProductToShoppingBag(product);
            return "Product has been added";
        } else {
            return "Product has not been added";
        }
    }

     //to dodalam
     public String removeProductFromShoppingBag(String[] data1, String[] data2) {
        Factory factory = new Factory();

        Product helpProduct = factory.createProduct(data1), product;
        Client helpClient = factory.createClient(data2), client;

        product = searchProduct(helpProduct);
        client = searchClient(helpClient);

        if (client != null && product != null) {
            client.removeProductFromShoppingBag(product);
            return "Product has been removed";
        } else {
            return "Product has not been removed";
        }
    }

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
       
 
    public Category searchCategory(Category help){
       int idx;
        if ((idx = categories.indexOf(help)) != -1) {
           help = categories.get(idx);
            return help;
        }
        return null;
    }
    
 
     public String addCategory(String name){
       Category category = new Category(name);
        if (searchCategory(category) == null) {
           this.categories.add(category);
            return categories.toString();
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
     
   
      //dodając subkattegorie ustawiam jej kategorie
       public String addSubcategory(String categoryName, String subcategory){
           Category help = new Category(categoryName),existcatgory;
           if((existcatgory=searchCategory(help)) != null){
               return existcatgory.addSubcategory(subcategory);
//               System.out.println("Facade >>addSubcategory");
           }
            return null;
           
       }

       
    public String addProduct(String[] data){
      // Factory factory = new Factory();
       Category help = new Category(data[7]);
       Category existCategory;
       if((existCategory = searchCategory(help)) != null){
           existCategory.addProduct(data);
       }
        return null;
    }
     
    public static void main(String[] args) {
        //przykładowe produkty
      String[] exampleProduct = {"pomadka","39","No allergens","Mac","czerwona extra super lipsss",".jpg","222000111","Make up","Lips"};
      String[] exampleProduct2 = {"tusz do rzęs","39","No allergens","Maybelline","Extra long",".jpg","Make up","Eyes","222000111"};
    
      Facade facade  = new Facade();  
        
 
        System.out.println(facade.addCategory("Make up"));
        System.out.println(facade.addSubcategory("Make up","Eyes"));
        System.out.println(facade.addProduct(exampleProduct));
      
     // System.out.println("Category added: "+facade.addCategory(makeUp.getName()));
     // System.out.println("Searching by category: "+ facade.searchByCategory(makeUp));
     // System.out.println(facade.searchBySubcategory("Eyes", "Make up"));
      
      
  
     
 
    }
}
