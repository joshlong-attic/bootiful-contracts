package com.example.fraudservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by jlong on 6/20/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FraudServiceApplication.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class FraudControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void should_have_a_message_endpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/message"))
                .andExpect(MockMvcResultMatchers.status().is(200))
        .andDo(MockMvcRestDocumentation.document("messages"));
    }
}
