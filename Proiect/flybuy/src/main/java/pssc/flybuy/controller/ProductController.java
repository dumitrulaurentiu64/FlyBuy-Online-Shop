package pssc.flybuy.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pssc.flybuy.entities.User;
import pssc.flybuy.repositories.ProductRepository;
import pssc.flybuy.entities.Product;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        List<Product> productsList = this.productRepository.findAll();
        model.addAttribute("productsList", productsList);
        return "products";
    }

    @GetMapping("/addProductToUser")
    public String seeProductsForAdding(@RequestParam("userId") String theId, Model model) {
        List<Product> productsList = this.productRepository.findAll();
        model.addAttribute("userId", theId);
        model.addAttribute("productsList", productsList);
        return "addProductToUser";
    }

    @GetMapping("/addProduct")
    public String addProducts(Model theModel) {

        // create model attribute to bind form data
        Product theProduct = new Product();

        theModel.addAttribute("product", theProduct);

        return "addProduct";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("product") Product theProduct) {

        this.productRepository.save(theProduct); //update & insert
        // use a redirect to prevent duplicate submissions
        return "redirect:all";
    }

    @PostMapping("/removeProduct")
    public String deleteUser(@RequestParam("productId") String productId) {

        Optional<Product> result = this.productRepository.findById(productId);
        Product theProduct = null;

        if (result.isPresent()) {
            theProduct = result.get();

        }
        else {
            // n-am gasit user-ul
            throw new RuntimeException("N-am gasit id pt user - " + productId);
        }

        this.productRepository.delete(theProduct);
        // use a redirect to prevent duplicate submissions
        return "redirect:all";
    }
}
