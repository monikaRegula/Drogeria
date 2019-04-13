package subbusinesstier.entities;

import java.time.LocalDate;


public class Order {
    
    private Client client;
    private LocalDate localDate;
    private ShoppingBag shoppingBag;
    private OrderStatus orderStatus;

    public Order() {
        
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public ShoppingBag getShoppingBag() {
        return shoppingBag;
    }

    public void setShoppingBag(ShoppingBag shoppingBag) {
        this.shoppingBag = shoppingBag;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" + "client=" + client + ", localDate=" + localDate + ", orderStatus=" + orderStatus + '}';
    }
    
  
}
