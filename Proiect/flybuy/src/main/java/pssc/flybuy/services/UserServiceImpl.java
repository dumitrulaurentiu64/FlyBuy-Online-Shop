package pssc.flybuy.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pssc.flybuy.FlybuyApplication;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public UserServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;}

    @Override
    public void sendUserMessage(String id) {
        Map<String, String> actionmap = new HashMap<>();
        actionmap.put("id", id);
        System.out.println("======================  CONVERTING...  ========================");
        rabbitTemplate.convertAndSend(FlybuyApplication.SFG_MESSAGE_QUEUE, actionmap);

        System.out.println("======================  CONVERTED  ========================");
    }
}
