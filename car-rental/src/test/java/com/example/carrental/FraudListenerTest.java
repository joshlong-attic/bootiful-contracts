package com.example.carrental;

import org.assertj.core.api.BDDAssertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;


@AutoConfigureStubRunner(workOffline = true, ids = "com.example:fraud-detection")
@SpringBootTest
@RunWith(SpringRunner.class)
public class FraudListenerTest {

    @Autowired
    private FraudListener listener;

    @Autowired
    private Sink sink;

    @Autowired
    private StubTrigger stubTrigger ;

    @Before
    public void setUp() throws Throwable {
        this.listener.name = "";
    }


    @Test
    public void should_receive_new_fraud_message_integration() throws Throwable {
        String name = "Long";
        this.stubTrigger.trigger("fraud_message");
        BDDAssertions.then(this.listener.name).isEqualTo(name);
    }
}
