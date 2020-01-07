package pssc.flybuy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import pssc.flybuy.controller.ProductController;
import pssc.flybuy.entities.Product;
import pssc.flybuy.entities.User;
import pssc.flybuy.repositories.ProductRepository;
import pssc.flybuy.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTests {

    private final String PRODUCTS_ALL_URL = "/products/all/";

    @Autowired
    private ProductController productController;

    public ProductControllerTests() {
    }

    @Test
    public void contextLoads() throws Exception {
        Assert.assertNotNull(productController);
    }

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setup(){
        Product product = new Product();
        product.setId("1asdf");
        product.setName("aragaz");
        product.setCategory("electrocasnice");
        product.setDescription("aragaz cu 4 ochiuri si cuptor");
        product.setPrice(1000);

        Product product1 = new Product();
        product.setId("2qwerty");
        product.setName("bicicleta");
        product.setCategory("sport");
        product.setDescription("bicicleta cu 2 roti");
        product.setPrice(1000);

        List<Product> productsList = new ArrayList<>();
        productsList.add(product);
        productsList.add(product1);
        User user = new User();
        user.setAddress("B-dul Eroilor de la Tisa, bl.10-12, apt.11");
        user.setAge(23);
        user.setName("Mihaela");
        user.setProducts(productsList);

        productRepository.saveAll(productsList);
        userRepository.save(user);
    }

    @Test
    public void testProductsAll() throws Exception {

        ResponseEntity<String> result = restTemplate.getForEntity(PRODUCTS_ALL_URL, String.class);

        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains("products"));
    }

    @Test
    public void testAddProduct() throws Exception {

        ResponseEntity<String> result = restTemplate.getForEntity("/products/addProduct", String.class);

        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains("products"));
    }

    @Test
    public void testAddProductToUser() throws Exception {

        ResponseEntity<String> result = restTemplate.getForEntity("/products/addProductToUser?userId=1", String.class);

        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains("Products"));
    }


}
