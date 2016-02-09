package com.revelfire.example.repository;

import com.revelfire.example.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cmathias on 2/9/16.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
