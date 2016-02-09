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
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @Test
    public void testAccountPersistence() {
        Account account = new Account();
        account.setName("Test Account");
        Account saved = accountService.save(account);
        assertNotNull(saved.getName());
        assertNotNull(saved.getId());

        saved.setName("Updated Test Account");
        accountService.save(saved);
        Account updated = accountService.read(account.getId());

        assertEquals(saved, updated);

        accountService.delete(account.getId());
        Account deleted = accountService.read(account.getId());
        assertNull(deleted);
    }

    @Test
    public void testFindUsersForAccount() {
        Account account = new Account();
        account.setName("Test Account");
        Account saved = accountService.save(account);
        assertNotNull(saved.getName());
        assertNotNull(saved.getId());

        User user1 = new User();
        user1.setName("Joe Bar");
        user1.setAddress(new Address());
        user1.getAddress().setLine1("123 Main St");
        user1.getAddress().setStateAbbr("TX");
        user1.getAddress().setPostal("78745");

        userService.save(user1, account);

        User user2 = new User();
        user2.setName("John Baz");
        user2.setAddress(new Address());
        user2.getAddress().setLine1("123 Broadway Ave");
        user2.getAddress().setStateAbbr("TX");
        user2.getAddress().setPostal("78745");

        userService.save(user2, account);

        assertEquals(2, accountService.getUsersForAccount(account).size());

    }

}
