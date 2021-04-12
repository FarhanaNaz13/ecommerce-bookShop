package com.adminportal.service;


import com.adminportal.domain.ShippingAddress;
import com.adminportal.domain.User;
import com.adminportal.domain.security.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {
    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User save(User user);
    
    List<User> findAll();
   

    User findOne(Long id);

    void removeOne(Long id);
}
