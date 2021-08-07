package org.accountManagerService.controller;

import org.accountManagerService.service.AccountListService;
import org.accountManagerService.service.TransactionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.accountManagerService.exception.RecordNotFoundException;
import org.accountManagerService.model.AccountListEntity;
import org.accountManagerService.model.TransactionListEntity;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountListService accountListService;
    @Autowired
    TransactionListService transactionListService;

    @GetMapping("/getAccountList")
    public ResponseEntity<List<AccountListEntity>> getAllAccountList() {
        List<AccountListEntity> list = accountListService.getAllAccountList();

        return new ResponseEntity<List<AccountListEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getAccountListbyCustomerID/{id}")
    public ResponseEntity<List<AccountListEntity>> getAccountListbyCustomerID(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        List<AccountListEntity> entity = accountListService.getAccountListByCustomerId(id);
        return new ResponseEntity<List<AccountListEntity>>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getTransactionList")
    public ResponseEntity<List<TransactionListEntity>> getAllTransactionList() {
        List<TransactionListEntity> list = transactionListService.getAllTransactionList();
        return new ResponseEntity<List<TransactionListEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getTransactionListbyAccountNumber/{id}")
    public ResponseEntity<List<TransactionListEntity>> getTransactionListbyAccountNumber(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        List<TransactionListEntity> entity = transactionListService.getTransactionListbyAccountNumber(id);
        return new ResponseEntity<List<TransactionListEntity>>(entity, new HttpHeaders(), HttpStatus.OK);
    }

}
