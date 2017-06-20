package com.example.carrental;

import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarRentalApplicationTests {

    @Rule
    public StubRunnerRule stubRunnerRule = new StubRunnerRule()
            .downloadStub("com.example", "fraud-detection")
            .withPort(8080)
            .workOffline(true);

    @Test
    public void should_return_list_of_frauds_integration_test() throws Throwable {

        String json = "[\"marcin\",\"josh\"]";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("http://localhost:8080/frauds", String.class);

        BDDAssertions.then(responseEntity.getStatusCode().value()).isEqualTo(201);
        BDDAssertions.then(responseEntity.getBody()).isEqualTo(json);
    }

}
