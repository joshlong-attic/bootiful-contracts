package com.example.fraudservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FraudController {

    private final Source source;

    public FraudController(Source source) {
        this.source = source;
    }

    @GetMapping("/fraud")
    public ResponseEntity<List<String>> frauds() {
        return ResponseEntity.status(200)
                .body(Arrays.asList("marcin", "josh"));
    }

    @PostMapping("/message")
    public void message() {
        this.source.output().send(MessageBuilder.withPayload(new Fraud("Bob")).build());
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Fraud {
    private String surname;
}