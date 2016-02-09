package com.revelfire.example.service;

import com.revelfire.example.Application;
import com.revelfire.example.model.Account;
import com.revelfire.example.model.Address;
import com.revelfire.example.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by cmathias on 2/9/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Test
    public void testUserPersistence() {
        Account userAccount = new Account();
        userAccount.setName("Test Account");
        userAccount = accountService.save(userAccount);
        assertNotNull(userAccount.getName());
        assertNotNull(userAccount.getId());

        User user = new User();
        user.setName("Joe Bar");
        user.setAddress(new Address());
        user.getAddress().setLine1("123 Main St");
        user.getAddress().setStateAbbr("TX");
        user.getAddress().setPostal("78745");

        User saved = userService.save(user, userAccount);
        User updated = userService.read(user.getId());

        assertEquals(saved, updated);

        userService.delete(user.getId());
        User deleted = userService.read(user.getId());
        assertNull(deleted);
    }

}
