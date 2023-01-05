package com.stackroute.userservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.userservice.dto.AddUser;
import com.stackroute.userservice.dto.UserDetails;
import com.stackroute.userservice.entity.Role;
import com.stackroute.userservice.entity.User;
import com.stackroute.userservice.exception.UserNameAlreadyExists;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.service.UserServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.AggregationExpression;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Cond.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UsertestController {

    @Autowired
    MockMvc mockMvc;

    @Mock
    UserServiceImpl userService;

    @InjectMocks
    RegistrationController registrationController;

    AddUser user1,user2,user3;

    UserDetails userDetails1,userDetails2,userDetails3;


    @BeforeEach
    public void setUp(){

        user1 = new AddUser("Nirali","Nirali@gmail.com","Nirali","Gelda","Ravi@123","Ravi@123","7879644891",Role.CUSTOMER);
        UserDetails userDetails1 = new UserDetails("Nirali@gmail.com","Nirali","Nirali","Gelda","Ravi@123","Ravi@123","7879644891",Role.CUSTOMER);

        /*user1 = new AddUser("Ritika_14","Ritika@gmail.com","Ritika","Tiwari","Ritika@123","Ritika@123","7879644891",Role.CUSTOMER);
        UserDetails userDetails1 = new UserDetails("ritika@gmil.com","Ritika_14","Ritika","Tiwari","Ritika@123","Ritika@123","7879644891",Role.CUSTOMER);

        user2 = new AddUser();
        UserDetails userDetails2 = new UserDetails("Emily@123","Emily_23","Emily","Clark","Emily@34","Emily@34","8965734251",Role.DESIGNER);

        user3 = new AddUser();
        UserDetails userDetails3 = new UserDetails("designer@gmail.com","John_19","John","Doe","John@567","John@567","9865319876",Role.ADMIN);
*/
        mockMvc= MockMvcBuilders.standaloneSetup(registrationController).build();
    }

    @AfterEach
    public void tearDown(){
        user1=null;
        user2=null;
        user3=null;
        userDetails1=null;
        userDetails2=null;
        userDetails3=null;
    }

    @Test
    public void registerUserTest() throws Exception{
          Mockito.when(userService.register(user1)).thenReturn(userDetails1);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(user1)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(userService, times(1)).register(any());

    }

    @Test
    public void givenRegisterToSaveRegisterFailure() throws Exception {
        Mockito.when(userService.register(any())).thenThrow(UserNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(user1)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
        verify(userService, times(1)).register(any());

    }

    @Test
    public void giveEmailDeleteUser() throws Exception {

        Mockito.when(userService.deleteUserByUsername(anyString())).thenReturn(true);
        mockMvc.perform(delete("/user/removeUser/Ravi@gmail.com")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(userService, times(1)).deleteUserByUsername(anyString());
    }




    private static String jsonToString(final Object o) throws JsonProcessingException {

        String result;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonContent = mapper.writeValueAsString(o);
            result = jsonContent;
            return result;

        } catch (JsonProcessingException e) {
            result = "JsonProcessingException";
        }
        return result;

    }

}
