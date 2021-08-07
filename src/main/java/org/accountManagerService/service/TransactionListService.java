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
        List<TransactionListEntity> accountList = repository.findAll();

        if(accountList.size() > 0) {
            return accountList;
        } else {
            return new ArrayList<TransactionListEntity>();
        }
    }

    /**
     * Retrieves all the Transaction details for a given @param account Number
     * @return List of Transaction Details for the given account Number
     */
    public List<TransactionListEntity> getTransactionListbyAccountNumber(Long id) throws RecordNotFoundException
    {
        List<Long> accountId = new ArrayList();
        accountId.add(id);
        Iterable<TransactionListEntity> transactionListIterable = repository.findAllById(accountId);
        Iterator <TransactionListEntity> iterator = transactionListIterable.iterator();
        List<TransactionListEntity> transactionList = new ArrayList();
        while (iterator.hasNext())
        {
            transactionList.add(iterator.next());
        }

        if(transactionList.size() > 0) {
            return transactionList;
        } else {
            return new ArrayList<TransactionListEntity>();
        }
    }



    /*
     public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }


   public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repository.findById(entity.getId());
         
        if(employee.isPresent())
        {
            EmployeeEntity newEntity = employee.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    }
     
    public void deleteEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repository.findById(id);
         
        if(employee.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }*/
}