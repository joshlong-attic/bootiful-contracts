package com.example.fraudservice;


import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest (classes = FraudServiceApplication.class)
@RunWith(SpringRunner.class )
@AutoConfigureMessageVerifier
public class BaseClass {

    @Autowired
    private FraudController fraudController;

    public void triggerMessage() {
        fraudController.message();
    }

    @Before
    public void before() throws Throwable {
        RestAssuredMockMvc.standaloneSetup(this.fraudController);
    }
}
