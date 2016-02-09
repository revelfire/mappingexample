package com.revelfire.example.service;

import com.revelfire.example.model.Account;
import com.revelfire.example.model.User;
import com.revelfire.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by cmathias on 2/9/16.
 */
@Service
public class UserService extends CrudService<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected CrudRepository<User, Long> getRepository() {
        return userRepository;
    }

    public User save(User user, Account account) {
        user.setAccountId(account.getId());
        return save(user);
    }
}
