package com.example.kafka_demo.producer;



import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String,String>kafkaTemplate;


    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        log.info(String.format("Producing message: %s",message));
        kafkaTemplate.send("topic1",message);
    }
}
