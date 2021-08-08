package org.accountManagerService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.accountManagerService.exception.RecordNotFoundException;
import org.accountManagerService.model.TransactionListEntity;
import org.accountManagerService.repository.TransactionListRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TransactionListService {
     
    @Autowired
    TransactionListRepository repository;

    /**
     * Retrieves all the Transaction details
     * @return List of Transaction Details
     */
    public List<TransactionListEntity> getAllTransactionList()
    {
        try {
            List<TransactionListEntity> accountList = repository.findAll();

            if (accountList.size() > 0) {
                return accountList;
            } else {
                return new ArrayList<TransactionListEntity>();
            }
        }
        catch (Exception e) {
            return new ArrayList<TransactionListEntity>();
        }
    }

    /**
     * Retrieves all the Transaction details for a given @param account Number
     * @return List of Transaction Details for the given account Number
     */
    public List<TransactionListEntity> getTransactionListbyAccountNumber(Long id) throws RecordNotFoundException {
        try {
            List<Long> accountId = new ArrayList();
            accountId.add(id);
            Iterable<TransactionListEntity> transactionListIterable = repository.findAllById(accountId);
            Iterator<TransactionListEntity> iterator = transactionListIterable.iterator();
            List<TransactionListEntity> transactionList = new ArrayList();
            while (iterator.hasNext()) {
                transactionList.add(iterator.next());
            }

            if (transactionList.size() > 0) {
                return transactionList;
            } else {
                return new ArrayList<TransactionListEntity>();
            }
        }
        catch (Exception e) {
            return new ArrayList<TransactionListEntity>();
        }
    }

    public int getTransactionListCountByAccountNumber(String account_number) throws RecordNotFoundException {
        try {
            Long id = Long.valueOf(account_number);
            List<Long> accountId = new ArrayList();
            accountId.add(id);
            Iterable<TransactionListEntity> transactionListIterable = repository.findAllById(accountId);
            Iterator<TransactionListEntity> iterator = transactionListIterable.iterator();
            List<TransactionListEntity> transactionList = new ArrayList();
            while (iterator.hasNext()) {
                transactionList.add(iterator.next());
            }
            return transactionList.size();
        }
        catch (Exception e) {
            return 0;
        }
    }
}