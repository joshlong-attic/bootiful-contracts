package com.example.carrental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@EnableBinding(Sink.class)
@SpringBootApplication
public class CarRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarRentalApplication.class, args);
    }
}

@Component
@Slf4j
class FraudListener {

    String name;

    @StreamListener(Sink.INPUT)
    public void onNewFraudMessageDoSomethingPleaseKThanks(Fraud f) {
        this.name = f.getSurname();
        log.info ( "NAME: {}", this.name);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Fraud {
    private String surname;
}