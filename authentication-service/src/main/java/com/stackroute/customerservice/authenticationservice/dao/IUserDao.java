package com.stackroute.customerservice.authenticationservice.dao;

import com.stackroute.customerservice.authenticationservice.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends CrudRepository<User, String> {
}
