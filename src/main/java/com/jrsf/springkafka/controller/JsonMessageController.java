package com.jrsf.springkafka.controller;


import com.jrsf.springkafka.kafka.JsonKafkaProducer;
import com.jrsf.springkafka.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer jsonProducer;

    public JsonMessageController(JsonKafkaProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        jsonProducer.sendMessage(user);
        return ResponseEntity.ok(String.format("Message sent json to topic -> %s", user.toString()));
    }
}
