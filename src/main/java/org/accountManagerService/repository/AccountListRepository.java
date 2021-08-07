package org.accountManagerService.repository;

import org.accountManagerService.model.AccountListEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountListRepository
        extends CrudRepository<AccountListEntity, Long> {

    @Override
    List<AccountListEntity> findAll();

}
