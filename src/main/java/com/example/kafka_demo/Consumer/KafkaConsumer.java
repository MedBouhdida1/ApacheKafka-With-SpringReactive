package com.example.kafka_demo.Consumer;


import com.example.kafka_demo.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {


    //@KafkaListener(topics = "topic1", groupId = "myGroup")
    public void consumeMessage(String message){
        log.info(String.format("Consuming message: %s",message));
        System.out.println(String.format("Consuming message: %s",message));
    }


    @KafkaListener(topics = "topic1", groupId = "myGroup")
    public void consumeJsonMessage(Student student){
        log.info(String.format("Consuming message: %s",student.toString()));
        System.out.println(String.format("Consuming message: %s",student.toString()));
    }
}
