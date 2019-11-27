package Entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class DbSeeder implements CommandLineRunner {

    private UserRepository userRepository;

    public DbSeeder(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run (String... strings) throws Exception {
        User andrei = new User(
                "Andrei",
                35,
                "Torontarului",
                Arrays.asList(
                        new Product("Blender", "Electronice", 60, "Eficient rapid si practic, blabla."),
                        new Product("Laptop", "Electronice", 1560, "i5, 8 GB ram, blabla."),
                        new Product("Parfum",  "Cosmetice", 50, "Cu efect de durata de pana la 9213 ore.")
                )
        );

        User marcel = new  User(
                "Marcel",
                 30,
                "Aradului",
                Arrays.asList(
                        new Product("Mixer", "Electronice", 80, "Eficient rapid si practic, blabla."),
                        new Product("Telefon", "Electronice", 1560, "Snapdragon 855, 8 GB ram, blabla."),
                        new Product("Balsam",  "Cosmetice", 25, "Cu efect de durata de pana la 9213 ore.")
                )
        );

        User mihaela = new  User(
                "Mihaela",
                23,
                "Milcov",
                Arrays.asList(
                        new Product("Cafetiera", "Electronice", 130, "Eficient rapid si practic, blabla."),
                        new Product("Calculator", "Electronice", 2300, "i5, 8 GB ram, blabla."),
                        new Product("Farduri",  "Cosmetice", 30, "Produse din ... .")
                )
        );

        this.userRepository.deleteAll();

        List<User> users = Arrays.asList(andrei, marcel, mihaela);
        this.userRepository.save(users);
    }
}
