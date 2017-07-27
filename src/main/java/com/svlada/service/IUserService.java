package com.svlada.service;

import com.svlada.entity.User;

/**
 *
 * @author mario.lope
 */
public interface IUserService {

    boolean addUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
    
    User getUserById(Long id);
    
    User getUserByUsername(String username);
    
    User getUserByUsername();
}
