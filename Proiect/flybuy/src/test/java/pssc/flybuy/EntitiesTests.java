package pssc.flybuy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import pssc.flybuy.entities.Product;
import pssc.flybuy.entities.User;

import java.util.ArrayList;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class EntitiesTests {

    @Test
    public void testProduct(){
        Product product = new Product();
        product.setId("1");
        product.setName("aragaz");
        product.setCategory("electrocasnice");
        product.setDescription("aragaz cu 4 ochiuri si cuptor");
        product.setPrice(1000);

        Assert.assertEquals("1", product.getId());
        Assert.assertEquals("aragaz", product.getName());
        Assert.assertEquals("electrocasnice", product.getCategory());
        Assert.assertEquals("aragaz cu 4 ochiuri si cuptor", product.getDescription());
        Assert.assertEquals(1000, product.getPrice(), 0); // delta - the maximum delta between expected and actual
        // for which both numbers are still considered equal.
    }

    @Test
    public void testUser(){
        User user = new User();
        user.setAddress("B-dul Eroilor de la Tisa, bl.10-12, apt.11");
        user.setAge(23);
        user.setName("Mihaela");
        user.setProducts(new ArrayList<>());

        Assert.assertEquals("B-dul Eroilor de la Tisa, bl.10-12, apt.11", user.getAddress());
        Assert.assertEquals("Mihaela", user.getName());
        Assert.assertEquals(java.util.Optional.of(23), Optional.ofNullable(user.getAge()));
        Assert.assertEquals(new ArrayList<>(), user.getProducts());
    }
}
