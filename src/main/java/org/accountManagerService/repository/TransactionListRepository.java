package org.accountManagerService.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.accountManagerService.model.TransactionListEntity;

import java.util.List;

@Repository
public interface TransactionListRepository
        extends CrudRepository<TransactionListEntity, Long> {

    @Override
    List<TransactionListEntity> findAll();


}
