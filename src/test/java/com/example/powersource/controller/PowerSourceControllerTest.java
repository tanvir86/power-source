package com.example.powersource.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest
@AutoConfigureWebTestClient
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PowerSourceControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {

        webTestClient.post()
                .uri("/powersource/add")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("[ { \"name\": \"bettary-1\", \"postcode\": 1200, \"capacityInWatt\": 10.5 }," +
                        " { \"name\": \"bettary-2\", \"postcode\": 1201, \"capacityInWatt\": 15 } ]")
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$[0].name").isEqualTo("bettary-1")
                .jsonPath("$[0].id").isNumber();
    }

    @Test
    void testCreateForInvalidInput() {

        webTestClient.post()
                .uri("/powersource/add")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("[ { \"name\": \"bettary-1\", \"postcode\": 1200, \"capacityInWatt\": -10.5 }," +
                        " { \"name\": \"bettary-2\", \"postcode\": 1201, \"capacityInWatt\": 15 } ]")
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void testGetAllPowerSources() {
        webTestClient.get()
                .uri("/powersource")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$[0]").doesNotExist();
    }
}