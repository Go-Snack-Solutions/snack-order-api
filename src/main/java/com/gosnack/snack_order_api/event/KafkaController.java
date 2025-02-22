package com.gosnack.snack_order_api.event;

import com.gosnack.snack_order_api.event.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducer producer;

    public KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/send")
    public void sendMessage() {
        producer.sendEvent("snack-order", "Testando envio de mensagem.");
    }
}