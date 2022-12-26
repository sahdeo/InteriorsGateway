package com.stackroute.authenticationservice.dao;

import com.stackroute.authenticationservice.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends CrudRepository<User, String> {
}
