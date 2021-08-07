package org.accountManagerService;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountManagerApplicationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldPass_getAccountListAPICheck() throws Exception {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/getAccountList",String.class),containsString("56798787"));
      }

      @Test
    public void shouldPass_getAccountListbyCustomerIDCheck() throws Exception {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/getAccountListbyCustomerID/56798787",String.class),containsString("56798787"));
    }

    @Test
    public void shouldPass_getTransactionListAPICheck() throws Exception {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/getTransactionList",String.class),containsString("321143048"));
    }

    @Test
    public void shouldPass_getTransactionListbyAccountNumberCheck() throws Exception {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/getTransactionListbyAccountNumber/321143048",String.class),containsString("321143048"));
    }

}
