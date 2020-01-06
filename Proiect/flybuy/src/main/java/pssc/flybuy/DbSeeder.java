package pssc.flybuy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pssc.flybuy.entities.Product;
import pssc.flybuy.entities.User;
import pssc.flybuy.repositories.ProductRepository;
import pssc.flybuy.repositories.UserRepository;

import java.util.Arrays;
import java.util.List;


@Component
public class DbSeeder implements CommandLineRunner {

    private UserRepository userRepository;
    private ProductRepository productRepository;

    public DbSeeder(UserRepository userRepository, ProductRepository productRepository){
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }


    @Override
    public void run (String... strings) throws Exception {
        Product acerHelios = new Product("Laptop", "Electronics", 4200, "i7-8750h, 16 ram, blabla");
        Product dior = new Product("Parfume",  "Cosmetics", 50, "Cu efect de durata de pana la 9213 ore.");
        Product mia3 = new Product("Phone", "Electronics", 1560, "Snapdragon 655, 2 GB ram, blabla.");
        Product baseballBat = new Product("Baseball Bat", "Sport", 55, "1.5m, lemn lacuit, etc...");
        Product lightbulb = new Product("Light Bulb", "Home", 55, "Set 6 becuri LED Philips, E27, 11W (75W), 1055 lm, A+, lumina calda Adevarata lumina alba calda, asemanatoare luminii incandescente");
        Product compressor = new Product("Black&Decker Compressor", "Auto", 750, "Baterie de tip Slide-Pack de 18V, interschimbabila cu alte produse fara fir de 18V Black & Decker");
        Product radio = new Product("Radio Akai", "Auto", 350, "CD/MP3 player auto, 500 g");


        User andrei = new User(
                        "Andrei",
                35,
               "France, Paris, nr 120",
                        Arrays.asList(
                                new Product("Blender", "Appliances", 60, "Eficient rapid si practic, blabla."),
                                new Product("Laptop", "Electronics", 1560, "i5, 8 GB ram, blabla."),
                                new Product("Parfume",  "Cosmetics", 50, "Cu efect de durata de pana la 9213 ore.")
                        )
                );

        User marcel = new  User(
                        "Marcel",
                30,
                "Bucharest, Romania, nr 1231",
                        Arrays.asList(
                                new Product("Mixer", "Appliances", 80, "Eficient rapid si practic, blabla."),
                                new Product("Telefon", "Electronics", 1560, "Snapdragon 855, 8 GB ram, blabla."),
                                new Product("Bike", "Sport", 1060, "Schimbator x, frane y, cadru aluminiu."),
                                new Product("Balm",  "Cosmetics", 25, "Cu efect de durata de pana la 9213 ore.")
                        )
                );

        User mihaela = new  User(
                        "Mihaela",
                23,
                "Rome, Italy, nr 221",
                        Arrays.asList(
                                new Product("Coffee Maker", "Appliances", 130, "Eficient rapid si practic, blabla."),
                                new Product("Computer", "Electronics", 2300, "i5, 8 GB ram, blabla."),
                                new Product("makeup",  "Cosmetics", 30, "Produse din ... .")
                        )
                );

        this.userRepository.deleteAll();
        this.productRepository.deleteAll();

        List<Product> products = Arrays.asList(acerHelios, dior, mia3, baseballBat, lightbulb, compressor, radio);
        this.productRepository.saveAll(products);

        List<User> users = Arrays.asList(andrei, marcel, mihaela);
        this.userRepository.saveAll(users);
//        this.userRepository.save(andrei);
//        this.userRepository.save(marcel);
//        this.userRepository.save(mihaela);
    }
}
