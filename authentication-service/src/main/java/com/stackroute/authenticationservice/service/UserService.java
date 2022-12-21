package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.dao.RoleDao;
import com.stackroute.authenticationservice.dao.UserDao;
import com.stackroute.authenticationservice.exception.UserAlredyExistException;
import com.stackroute.authenticationservice.entity.Role;
import com.stackroute.authenticationservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class UserService implements IUserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void initRoleAndUser() {
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user = new User();
        user.setUserName("miraz123");
        user.setUserPassword(getEncodedPassword("miraz@123"));
        user.setUserFirstName("miraz");
        user.setUserLastName("haque");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }

    @Override
    public User registerNewUser(User user) throws UserAlredyExistException {
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleDao.findById("User").get());
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        Optional<User> optional = userDao.findById(user.getUserName());
        if(optional.isPresent()){
            throw new UserAlredyExistException("user is already exist");
        }
        return userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}