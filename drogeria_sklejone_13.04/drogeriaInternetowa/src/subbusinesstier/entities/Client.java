
package subbusinesstier.entities;


public class Client {
    private ShoppingBag shoppingBag;
    private String emial;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String code;
    private String city;
    private String street;
    private String number;

    public Client() {
       
    }

    public ShoppingBag getShoppingBag() {
        return shoppingBag;
    }

    public void setShoppingBag(ShoppingBag shoppingBag) {
        this.shoppingBag = shoppingBag;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    //dodane
    public void addProductToShoppingBag(Product product) {        
        shoppingBag.addProduct(product);
    }

    //dodane
    public void removeProductFromShoppingBag(Product product) {
         getShoppingBag().removeProduct(product);                
    }

    @Override
    public String toString() {
        return "Client{" + "shoppingBag=" + shoppingBag + ", emial=" + emial + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", code=" + code + ", city=" + city + ", street=" + street + ", number=" + number + '}';
    }
                   
    
}
