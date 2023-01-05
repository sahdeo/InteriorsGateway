package com.stackroute.userservice.service;

import com.stackroute.userservice.dto.AddUser;
import com.stackroute.userservice.dto.UserDetails;
import com.stackroute.userservice.entity.Role;
import com.stackroute.userservice.entity.User;
import com.stackroute.userservice.exception.*;
import com.stackroute.userservice.repository.IUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private User user1;

    private AddUser user2;

    private UserDetails userDetails1, userDetails;

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        user1 = new User("Ravi@gmail.com", "Ravi1", "Ravi", "Gelda", "Ravi@123", "Ravi@123", "7879644891", Role.CUSTOMER);
        UserDetails userDetails1 = new UserDetails("Ravi@gmail.com", "Ravi1", "Ravi", "Gelda", "Ravi@123", "Ravi@123", "7879644891", Role.CUSTOMER);
        user2 = new AddUser("Ravi@gmail.com", "Ravi1", "Ravi", "Gelda", "Ravi@123", "Ravi@123", "7879644891", Role.CUSTOMER);


       /* product2 = new Product(2, "mobile", productDetails2);
        productDetails2 = new ProductDetails(102, "samsung", 100);


        */
    }

    @AfterEach
    public void tearDown() {

        user1 = null;
        //product2 = null;
        userDetails1= null;
        //productDetails2 = null;
    }

    @Test
    public void givenRegisterToSaveUser() throws UserNameAlreadyExists, UserNotFoundException, PasswordDoesNotMatchException, InvalidArgumentException, MobileNoNotValidException, EmailAlreadyExists {
        when(userRepository.findByUserName(user1.getUserName())).thenReturn(Optional.empty());
        when(userRepository.save(user1)).thenReturn(user1);
        assertEquals(user1, userService.register(user2));
        verify(userRepository, times(1)).save(any());
        verify(userRepository, times(1)).findByUserName(any());
    }

    @Test
    public void givenRegisterToSaveUserFailure() {
        when(userRepository.findByUserName(user1.getUserName())).thenReturn(Optional.ofNullable(user1));
        assertThrows(UserNameAlreadyExists.class, () -> userService.register(user2));
        verify(userRepository, times(0)).save(any());
        verify(userRepository, times(1)).findById(any());

    }

    @Test
    public void givenUserToDeleteShouldDeleteSuccess() throws UserNotFoundException, InvalidArgumentException {

        when(userRepository.findByEmailId(user1.getEmailId())).thenReturn(Optional.ofNullable(user1));
        boolean flag = userService.deleteUserByUsername(user1.getEmailId());
        assertTrue(flag);
        verify(userRepository, times(1)).findByEmailId(anyString());
        verify(userRepository, times(1)).deleteById(anyString());

    }


}
