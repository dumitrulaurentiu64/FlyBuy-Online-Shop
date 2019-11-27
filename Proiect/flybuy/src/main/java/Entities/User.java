package Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Contract;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "Accounts")
public class User {
    @Id
    private String id;
    private String name;
    @Indexed(direction = IndexDirection.ASCENDING)
    private Integer age;
    private String adress;
    private List<Product> products;

    @Contract(pure = true)
    protected User() { this.products = new ArrayList();}

    @org.jetbrains.annotations.Contract(pure = true)
    public User(String name, Integer age, String adress, List<Product> products){
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.products = products;
    }
}
