package com.revelfire.example.service;

import com.revelfire.example.model.Account;
import com.revelfire.example.model.User;
import com.revelfire.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cmathias on 2/9/16.
 */
@Service
public class AccountService extends CrudService<Account> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    protected CrudRepository<Account, Long> getRepository() {
        return accountRepository;
    }

    public List<User> getUsersForAccount(Account account) {
        return accountRepository.getUsersForAccount(account.getId());
    }
}
