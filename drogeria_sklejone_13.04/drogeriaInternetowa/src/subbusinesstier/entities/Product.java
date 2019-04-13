package subbusinesstier.entities;


public class Product {
    private String name;
    private Subcategory subcategory;
    private String type;
    private String brand;
    private String allergen;
    private String photo;//to think! 
    private double price;
    private int barCode;
    private String size;//gramatura np. ml,kg,g
 
    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAllergen() {
        return allergen;
    }

    public void setAllergen(String allergen) {
        this.allergen = allergen;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    
    
    
    
    
    @Override
    public String toString(){
        return "Product{";/* + getName() +" ,category: "
                +" ,subcategory:"+getSubcategory().getName()
                +", type: "+getType()
                +" ,brand: "+getBrand()+", bar code:"+getBarCode()+"\n";*/
    }
    
 
}
