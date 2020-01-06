package pssc.flybuy.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Document(collection = "Products")
public class Product {
    @Id
    private String productId;
    private String name;
    private String category;
    private double price;
    private String description;

    public Product(String name, String category, double price, String description) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }

//    public Product(String id, String name, String category, double price, String description) {
//        this.productId = id;
//        this.name = name;
//        this.category = category;
//        this.price = price;
//        this.description = description;
//    }




    public Product() { }
    public String getId() {
        return productId;
    }

    public void setId(String id) {
        this.productId = id;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return "Product { " +
                " name= " + name +
                ", category= " + category +
                " , price= " + price +
                " , description= " + description +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
