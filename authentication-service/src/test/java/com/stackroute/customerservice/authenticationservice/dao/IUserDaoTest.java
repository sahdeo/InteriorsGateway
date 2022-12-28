package com.stackroute.customerservice.authenticationservice.dao;

import com.stackroute.customerservice.authenticationservice.entity.User;
import com.stackroute.customerservice.authenticationservice.enums.Roles;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class IUserDaoTest {
    @Autowired
    private IUserDao IUserDao;

    private User user;

    @BeforeEach
    public void setUp(){
        user = new User("Miraz@123","Mirazul", "Haque","miraz@123456", Roles.ADMIN);
    }

    @AfterEach
    public void tearDown(){
        user=null;
        IUserDao.deleteAll();
    }

//    public void givenUserToSaveReturnUser(){
//        userDao.save(user);
//        Optional<User> optional= userDao.findById(user.getUserName());
//        User user1 = optional.get();
//        assert(user1, user);
//    }
}
