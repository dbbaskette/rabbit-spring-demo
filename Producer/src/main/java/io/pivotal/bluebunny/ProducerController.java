package io.pivotal.bluebunny;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private final RabbitTemplate rabbitTemplate;

    public ProducerController(RabbitTemplate template) {
        this.rabbitTemplate = template;
    }

    @RequestMapping("/produce-once")
    public ProduceResponse produce(
            @RequestParam(value="message", required=false, defaultValue="random-message") String message) {
        this.rabbitTemplate.convertAndSend(BluebunnyProducerApplication.queueName, message);
        return new ProduceResponse(message);
    }
}
