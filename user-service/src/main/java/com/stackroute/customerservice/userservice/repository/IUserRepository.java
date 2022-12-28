package com.stackroute.customerservice.userservice.repository;

import com.stackroute.customerservice.userservice.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IUserRepository extends MongoRepository<User,String> {

    Optional<User> findByUserName(String username);


    Optional<User> findByEmailId(String emailId);


}
