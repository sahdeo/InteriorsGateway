//package com.stackroute.authenticationservice.service;
//
//import com.stackroute.authenticationservice.dao.IUserDao;
//import com.stackroute.authenticationservice.entity.User;
//import com.stackroute.authenticationservice.enums.Roles;
//import com.stackroute.authenticationservice.exception.UserNotFoundException;
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//
//import org.junit.jupiter.api.function.Executable;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mock.*;
//import org.mockito.junit.jupiter.MockitoExtension;
//import static org.mockito.Mockito.*;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Optional;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class UserServiceImpUnitTest {
//    @Mock
//    IUserDao userDao;
//
//    @InjectMocks
//    UserServiceImp userServiceImp;
//
//    /**
//     * Scenario: user exists and found
//     * input: username Miraz
//     * verifying: userDao.findById(username) called once
//     */
//    @Test
//    public void findByUserName_1() throws Exception{
//        String userName = "Miraz";
//        User user = mock(User.class);
//        Optional<User> optional = Optional.of(user);
//        when(userDao.findById(userName)).thenReturn(optional);
//        User result = userServiceImp.findByUsername(userName);
//        assertEquals(user,result);
//        verify(userDao).findById(userName);
//    }
//
//    /**
//     * Scenario: user not found
//     */
//
//    @Test
//    public void findByUserName_2() throws Exception{
//        String userName = "Shambhu";
//        Optional<User> optional = Optional.empty();
//        when(userDao.findById(userName)).thenReturn(optional);
//        Executable execute =()->userServiceImp.findByUsername(userName);
//        assertThrows(UserNotFoundException.class,execute);
//    }
//
//    @Test
//    public void registerNewUserTest(){
//        User user = new User("Miraz123", "Mirazul", "Haque","Miraz@123456", Roles.ADMIN);
//        User mockUser = mock(User.class);
//
//        when(userDao.save(user)).thenReturn(user);
//        User result = userServiceImp.registerNewUser(user);
//        assertEquals(user,result);
//        verify(userDao).save(user);
//    }
//}
