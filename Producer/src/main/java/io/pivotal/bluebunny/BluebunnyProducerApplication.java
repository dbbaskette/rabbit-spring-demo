package io.pivotal.bluebunny;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BluebunnyProducerApplication {

    final static String queueName = "bluebunny";

    @Bean
    Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
    TopicExchange exchange() {
		return new TopicExchange("bunny");
	}

	@Bean
    Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(queueName);
	}

    public static void main(String[] args) {
		SpringApplication.run(BluebunnyProducerApplication.class, args);
	}
}
