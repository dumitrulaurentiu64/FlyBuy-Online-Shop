package pssc.flybuy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pssc.flybuy.repositories.ProductRepository;
import pssc.flybuy.repositories.UserRepository;
import pssc.flybuy.entities.Product;
import pssc.flybuy.entities.User;
import pssc.flybuy.services.UserService;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    public UserController(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/all")
    public String getAll(Model model) {
        List<User> userList = this.userRepository.findAll();
        model.addAttribute("usersList", userList);
        return "users";
    }




    @GetMapping("/register")
    public String register(Model theModel) {

        // create model attribute to bind form data
        User theUser = new User();

        theModel.addAttribute("user", theUser);

        return "register";
    }



    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User theUser) {

        this.userRepository.save(theUser); //update & insert
        // use a redirect to prevent duplicate submissions
        return "redirect:all";
    }

    @GetMapping("/removeUserProducts")
    public String seeUserProducts(@RequestParam("userId") String userId, Model model) {
        Optional<User> result = this.userRepository.findById(userId);
        User theUser = null;

        if (result.isPresent()) {
            theUser = result.get();

        }
        else {
            // n-am gasit user-ul
            throw new RuntimeException("N-am gasit id pt user - " + userId);
        }
        List<Product> productsList = theUser.getProducts();
        model.addAttribute("userId", userId);
        model.addAttribute("productsList", productsList);

        return "removeProductFromUser";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("userId") String userId) {

        Optional<User> result = this.userRepository.findById(userId);
        User theUser = null;

        if (result.isPresent()) {
            theUser = result.get();

        }
        else {
            // n-am gasit user-ul
            throw new RuntimeException("N-am gasit id pt user - " + userId);
        }

        this.userRepository.delete(theUser);
        // use a redirect to prevent duplicate submissions
        return "redirect:all";
    }

    @PostMapping("/deleteProduct")
    public String updateWithoutProduct(@RequestParam("userId") String userId, @RequestParam("productName") String productName) {

        Optional<User> result = this.userRepository.findById(userId);

        User theUser;

        if (result.isPresent()) {
            theUser = result.get();;
        }
        else {
            // n-am gasit user-ul
            throw new RuntimeException("N-am gasit id pt user - " + userId);
        }
        List<Product> productsList = theUser.getProducts();

        Iterator i = productsList.iterator();
        Product prod;
        while (i.hasNext()) {
            prod = (Product) i.next();
            if (prod.getName().equals(productName)) {
                i.remove();
                break;
            }
        }

        theUser.setProducts(productsList);

        this.userRepository.save(theUser);
        // use a redirect to prevent duplicate submissions
        return "redirect:all";
    }

    @PostMapping("/update")
    public String updateWithNewProduct(@RequestParam("userId") String userId, @RequestParam("productId") String productId) {

        Optional<User> firstResult = this.userRepository.findById(userId);
        Optional<Product> secondResult = this.productRepository.findById(productId);

        User theUser = null;
        Product theProduct = null;

        if (firstResult.isPresent() && secondResult.isPresent()) {
            theUser = firstResult.get();
            theProduct = secondResult.get();
        }
        else {
            // n-am gasit user-ul
            throw new RuntimeException("N-am gasit id pt user - " + userId);
        }
        theUser.updateUserProductList(theProduct);

        this.userRepository.save(theUser); //update & insert
        // use a redirect to prevent duplicate submissions
        return "redirect:all";
    }


    public Optional<User> getById(@PathVariable("id") String id) {
        return this.userRepository.findById(id);
    }

    @PutMapping
    public void insert(@ModelAttribute("user") User user) {
        this.userRepository.insert(user); // insert

    }

    @GetMapping("/getDiscounts")
    public String indexProduct(){
        String stupidString = "argh";
        userService.sendUserMessage(stupidString);
        return "redirect:all";
    }


}
