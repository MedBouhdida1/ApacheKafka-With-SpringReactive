package com.example.kafka_demo.Controller;


import com.example.kafka_demo.payload.Student;
import com.example.kafka_demo.producer.KafkaJsonProducer;
import com.example.kafka_demo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {

    private final KafkaProducer producer;
    private final KafkaJsonProducer kafkaJsonProducer;

    public MessageController(KafkaProducer producer, KafkaJsonProducer kafkaJsonProducer) {

        this.producer = producer;
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    @PostMapping
    public ResponseEntity<String>sendMessage(@RequestBody String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the Kafka Topic Successfully");
    }


    @PostMapping("/json")
    public ResponseEntity<String>sendJsonMessage(@RequestBody Student student){
        kafkaJsonProducer.sendMessage(student);
        return ResponseEntity.ok("Message sent to the Kafka Topic Successfully");
    }
}
