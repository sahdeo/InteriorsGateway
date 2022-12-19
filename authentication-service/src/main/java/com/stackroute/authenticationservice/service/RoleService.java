package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.dao.RoleDao;
import com.stackroute.authenticationservice.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
