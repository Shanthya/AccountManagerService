package org.accountManagerService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.accountManagerService.model.AccountListEntity;
import org.accountManagerService.repository.AccountListRepository;


import java.util.*;

@Service
public class AccountListService {
     
    @Autowired
    AccountListRepository repository;

    /**
     * Retrieves all the account Details
     * @return List of Account Details
     */
    public List<AccountListEntity> getAllAccountList() {
        try {
            List<AccountListEntity> accountList = repository.findAll();

            if (accountList.size() > 0) {
                return accountList;
            } else {
                return new ArrayList<AccountListEntity>();
            }
        } catch (Exception e) {
            return new ArrayList<AccountListEntity>();
        }
    }


    /**
     * Retrieves all the account Details for a given @param customer ID
     * @return List of Account Details for the given customer ID
     */
    public List<AccountListEntity> getAccountListByCustomerId(Long id) {
        try {
            List<Long> customerId = new ArrayList();
            customerId.add(id);
            Iterable<AccountListEntity> accountListIterable = repository.findAllById(customerId);
            Iterator<AccountListEntity> iterator = accountListIterable.iterator();
            List<AccountListEntity> accountList = new ArrayList();
            while (iterator.hasNext()) {
                accountList.add(iterator.next());
            }

            if (accountList.size() > 0) {
                return accountList;
            } else {
                return new ArrayList<AccountListEntity>();
            }
        } catch (Exception e) {
            return new ArrayList<AccountListEntity>();
        }
    }


}