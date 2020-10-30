package com.example.demo;

import com.example.demo.restservice.CreditCheckEndpoint;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class CreditCheckEndpointIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testStatusOkIfBodyPayloadIsCorrect() throws Exception {
        String body = "{\"referenceId\": \"Bob\", \"companyId\" : \"Acme-XYZ\"}";

        mockMvc.perform(MockMvcRequestBuilders.get("/credit-check")
                .content(body)
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(APPLICATION_JSON_VALUE));
    }

    @Test
    public void testBadRequestIfReferenceIdIsMissing() throws Exception {
        String body = "{\"referenceId\": \"\", \"companyId\" : \"bob@domain.com\"}";

        mockMvc.perform(MockMvcRequestBuilders.get("/credit-check")
                .content(body)
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.referenceId", Is.is("Reference Id may not be blank")))
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(APPLICATION_JSON_VALUE));
    }
}