package io.pivotal.bluebunny;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {

    private Receiver receiver = Receiver.getReceiver();

    @RequestMapping("/request-all")
    public ConsumerResponse produce() {
        try {
            List<String> messages = receiver.getMessages();
            return new ConsumerResponse(messages);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
