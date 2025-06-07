# Kafka Demo

This project is a minimal Spring Boot application that demonstrates how to publish and consume messages with Apache Kafka.

It provides REST endpoints to send plain text or JSON messages which are then produced to a Kafka topic. A consumer listens on the same topic and logs received messages.

## Building

Use the provided Maven wrapper to build the project:

```bash
./mvnw clean package
```

## Running

Start a local Kafka broker on `localhost:9092` and then run:

```bash
./mvnw spring-boot:run
```

By default the application runs on port `8083`.

## Sending messages

Send a plain text message:

```bash
curl -X POST -H "Content-Type: text/plain" \
     -d 'hello world' \
     http://localhost:8083/api/v1/message
```

Send a JSON message representing a `Student`:

```bash
curl -X POST -H "Content-Type: application/json" \
     -d '{"id":1,"firstName":"John","lastName":"Doe"}' \
     http://localhost:8083/api/v1/message/json
```

