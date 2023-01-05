package com.stackroute.userservice.repository;

import com.stackroute.userservice.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {

    Optional<User> findByUserName(String username);
    Optional<User> findByEmailId(String emailId);

}
