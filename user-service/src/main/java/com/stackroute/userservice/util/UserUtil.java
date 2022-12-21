package com.stackroute.userservice.util;

import com.stackroute.userservice.dto.UserDetails;
import com.stackroute.userservice.entity.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserUtil {


    public UserDetails toUserDetails(User user){
        UserDetails desired=new UserDetails();
        desired.setId(user.getId());
        desired.setUserName(user.getUserName());
        desired.setEmailId(user.getEmailId());
        desired.setPassword(user.getPassword());
        desired.setConfirmPassword(user.getConfirmPassword());
        desired.setMobileNo(user.getMobileNo());
//        desired.setRole(Role.valueOf(user.getRole().toString()));

        return desired;
    }

    public List<UserDetails> toUserDetailsList(Collection<User> customers){
        List<UserDetails>list=  customers.stream()
                .map(this::toUserDetails)
                .collect(Collectors.toList());
        return list;
    }

  /*  public Role getRoleType(String type) throws InvalidArgumentException{
        if(type==null || type.isBlank()){
            throw new InvalidArgumentException("Type cannot be null or empty");
        }
        Role[] role = Role.values();
        Optional<Role> optional = Stream.of(role).filter(role1 -> role1.toString().equalsIgnoreCase(type)).findAny();
        if (optional.isEmpty()){
            throw new InvalidArgumentException("Role is not valid");
        }
        return optional.get();
    }*/



}
