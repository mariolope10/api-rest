package com.svlada.dao;

import com.svlada.entity.User;

/**
 *
 * @author mario.lope
 */
public interface IUserDAO {

    User getUserById(Long idUser);
    
    User getUserByUsername(String username);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long idUser);
}
