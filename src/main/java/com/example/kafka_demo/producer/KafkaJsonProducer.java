package com.example.kafka_demo.producer;


import com.example.kafka_demo.payload.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class KafkaJsonProducer {


    private final KafkaTemplate<String, Student> kafkaTemplate;


    public void sendMessage(Student student){
        Message<Student> message= MessageBuilder.withPayload(student).setHeader(KafkaHeaders.TOPIC,"topic1").build();
        kafkaTemplate.send(message);
    }
}
