package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.dao.RoleDao;
import com.stackroute.authenticationservice.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
