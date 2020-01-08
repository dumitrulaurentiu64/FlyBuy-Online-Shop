package pssc.flybuy.listener;

import org.springframework.stereotype.Component;
import pssc.flybuy.entities.User;
import pssc.flybuy.repositories.UserRepository;

import java.util.List;
import java.util.Map;

@Component
public class ProductMessageListener {
    private UserRepository userRepository;

    public ProductMessageListener(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void receiveMessage(Map<String, String> message) {
        System.out.println("======================  RECEIVING...  ========================");
        List<User> usersList = userRepository.findAll();

        for(User user : usersList) {
            user.setMessageReceived(true);
            user.setMessageCount(user.getMessageCount() + 1);
        }
        userRepository.saveAll(usersList);

        System.out.println("======================  MESSAGE SAVED  ========================");
    }
}
