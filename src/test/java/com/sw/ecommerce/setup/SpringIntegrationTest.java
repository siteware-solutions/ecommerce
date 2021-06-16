package com.sw.ecommerce.setup;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@CucumberContextConfiguration
@SpringBootTest
public class SpringIntegrationTest {
    private String urlPadrao  = "http://localhost:8082";

    @Autowired
    public RestTemplate restTemplate;

    public Double executeGet(String path) {
        return restTemplate.getForObject(urlPadrao + path, Double.class);
    }

    public void executePost(String path, Map<String,Object> body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
        restTemplate.postForEntity(urlPadrao + path, entity, String.class);
    }

    public void executePost(String path) {
        executePost(path, new HashMap<>());
    }

    public void executePut(String path, Object body) {
        restTemplate.put(urlPadrao + path, body, String.class);
    }
}
