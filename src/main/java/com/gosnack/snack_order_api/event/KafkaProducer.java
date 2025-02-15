package com.gosnack.snack_order_api.event;

import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final Logger logger = getLogger(KafkaProducer.class);

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(String topic, String message) {
        kafkaTemplate.send(topic, message);
        logger.info("Mensagem enviada com sucesso.");
    }
}
