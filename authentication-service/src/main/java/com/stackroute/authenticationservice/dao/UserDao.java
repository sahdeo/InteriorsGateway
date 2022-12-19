package com.stackroute.authenticationservice.dao;

import com.stackroute.authenticationservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
