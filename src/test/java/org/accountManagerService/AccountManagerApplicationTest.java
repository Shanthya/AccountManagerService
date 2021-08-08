package org.accountManagerService;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

import org.accountManagerService.service.TransactionListService;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountManagerApplicationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TransactionListService transactionListService;

    @Test
    public void shouldPass_getAccountListAPICheck() throws Exception {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/getAccountList",String.class),containsString("56798787"));
      }

    @Test
    public void shouldFail_getAccountListAPICheck() throws Exception {
        String response = restTemplate.getForObject("http://localhost:" + port + "/getAccountList",String.class);
        assertFalse("Invalid account number",response.equals("Shanthya"));
    }

    @Test
    public void shouldPass_validHeader() throws Exception {
        ResponseEntity<String> apiResponse = restTemplate.getForEntity("http://localhost:" + port + "/getAccountList", String.class);
        assertEquals(apiResponse.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
    }

    @Test
    public void shouldPass_validateStatusCodeis200() throws Exception {
        ResponseEntity<String> apiResponse = restTemplate.getForEntity("http://localhost:" + port + "/getAccountList",String.class);
        assertEquals(HttpStatus.OK, apiResponse.getStatusCode());
    }

    @Test
    public void shouldPass_responseisNotNull() throws Exception {
        ResponseEntity<String> apiResponse = restTemplate.getForEntity("http://localhost:" + port + "/getAccountList",String.class);
        assertNotNull(apiResponse);
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

    @Test
    public void shouldPass_SelectAccountIDandValidateTransactionList() throws Exception
    {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/getAccountList",String.class),containsString("56798787"));
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/getAccountListbyCustomerID/56798787",String.class),containsString("56798787"));
        assertEquals(1,transactionListService.getTransactionListCountByAccountNumber("321143048"));
    }

    @Test
    public void shouldPass_validPayload() throws Exception {
        //TODO: Once the request is changed from get to Post implement the test to check if the payload in the body is valid
    }

    @Test
    public void shouldFail_accountNumberisValid() throws Exception {
        //TODO: Check if the account number is valid 8 digit number
    }

    @Test
    public void shouldFail_accountNumbernotNull() throws Exception {
        //TODO: Check if the account number is valid 8 digit number
    }

    @Test
    public void shouldPass_dataCorruption() throws Exception {
        //TODO: This will be implemented along with update function. Putting a place holder as the scope is only a read functionality
    }

    @Test
    public void shouldFail_TooBigPayload() throws Exception {
        //TODO: This is a non functional testing scenario, when payload is too large
    }

    @Test
    public void shouldFail_deadlock() throws Exception {
        //TODO: This will be implemented along with update function. Putting a place holder as the scope is only a read functionality
    }

    @Test
    public void shouldPass_verifyMandatoryFields() throws Exception {
        //TODO: This will be implemented along with update function. Putting a place holder as the scope is only a read functionality
    }

    @Test
    public void shouldPass_verifyAccountIDisUnique() throws Exception {
        //TODO: This will be implemented along with update function. Putting a place holder as the scope is only a read functionality
    }

    @Test
    public void shouldPass_verifyFieldsAcceptsNull() throws Exception {
        //TODO: This will be implemented along with update function. Putting a place holder as the scope is only a read functionality
    }

    @Test
    public void shouldPass_validateAuthorization() throws Exception {
        //TODO: This will be implemented when the authorisation is enabled by passing an invalid token and checking if the call to back end api is not allowed

    }
    @Test
    public void shouldFail_verifyFieldswithIncorrectDatatype() throws Exception {
        //TODO: This will be implemented along with update function to validate if passing incorrect datatype fails the insert
    }

    @Test
    public void shouldFail_validatedatefield() throws Exception {
        //TODO: This will be implemented along with update function to check valid fields in the incoming request
    }

    @Test
    public void shouldFail_brokenDBConnection() throws Exception {
        //TODO: This will be implemented along with update function. Putting a place holder as the scope is only a read functionality
    }

    @Test
    public void shouldPass_validateprimaryKey() throws Exception {
      //TODO: Insert duplicate value and the record should not pesist
    }

    @Test
    public void shouldPass_validateDataSourceisReadOnly() throws Exception {
        //TODO: Check if retrieval of the date is not changing the state of the data
    }

    @Test
    public void shouldPass_validateAccountIDSize() throws Exception {
        //TODO: Check if the account id size is appropriate
    }



}
