package com.svlada.dao;

import com.svlada.entity.User;

/**
 *
 * @author mario.lope
 */
public interface IUserDAO {

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
    
    User getUserById(Long id);
    
    User getUserByUsername(String username);
}
