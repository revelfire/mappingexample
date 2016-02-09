package com.revelfire.example.repository;

import com.revelfire.example.model.Account;
import com.revelfire.example.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cmathias on 2/9/16.
 */
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query("select u from User u where u.accountId = ?")
    List<User> getUsersForAccount(long accountId);
}
