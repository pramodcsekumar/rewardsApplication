package com.rewards.ControllerIntegrationTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for the RewardsController REST API.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RewardsControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetRewards_returnsValidResponse() {
        ResponseEntity<Map> response = restTemplate.getForEntity("/api/rewards", Map.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().containsKey("C1"));
        assertTrue(response.getBody().containsKey("C2"));
    }

    @Test
    public void testNegativeScenario_invalidEndpoint_shouldReturn404() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/rewards/invalid", String.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}

