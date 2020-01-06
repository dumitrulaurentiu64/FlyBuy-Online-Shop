package pssc.flybuy.entities;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "Users")
public class User {
    @Id
    private String userId;
    private String name;

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;
    @Indexed(direction = IndexDirection.ASCENDING)
    private Integer age;

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    //@
    private List<Product> products;

    public User() { this.products = new ArrayList();}


    public User(String name, Integer age, String address, List<Product> products){
        this.name = name;
        this.address = address;
        this.age = age;
        this.products = products;
    }

//    public List<Product> getProductsForReal()
//    {
//        List<Product> stupidList = new ArrayList<>();
//        for(int i = 0; i < this.products.size(); i++){
//            Product product = new Product(products.get(i).getId(), products.get(i).getName(),
//                    products.get(i).getCategory(), products.get(i).getPrice(), products.get(i).getDescription());
//            stupidList.add(product);
//        }
//        return stupidList;
//    }



    public String getUserId() { return userId; }
    public String getName() { return name; }
    public Integer getAge() { return age; }

    public void updateUserProductList(Product product)
    {
        this.getProducts().add(product);
    }

    public String getAddress() {
        return address;
    }

    public List<Product> getProducts() { return products;}

    public String getProductsToString() {
        return products.toString();
    }

    public void setName(String name) { this.name = name; }
    public void setAge(Integer age) { this.age = age; }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}

