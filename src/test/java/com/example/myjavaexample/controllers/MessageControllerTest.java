package com.example.myjavaexample.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.myjavaexample.models.Message;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageControllerTest {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAll() throws Exception {

        RequestEntity<Void> request = RequestEntity
                .get(URI.create("http://localhost:" + port + "/messages"))
                .accept(MediaType.APPLICATION_JSON)
                .build();

        ResponseEntity<List<Message>> response = restTemplate
                .exchange(request, new ParameterizedTypeReference<List<Message>>() {
                });
        List<Message> messages = response.getBody();

        assertTrue(messages.size() > 0);

    }

    @Test
    public void testGet() throws Exception {

        Message result = this.restTemplate.getForObject("http://localhost:" + port + "/message/{id}", Message.class, 1);

        assertTrue(result != null);

    }
}