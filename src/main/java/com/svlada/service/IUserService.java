package com.svlada.service;

import com.svlada.entity.User;

/**
 *
 * @author mario.lope
 */
public interface IUserService {

    User getUserById(Long idUser);
    
    User getUserByUsername(String username);

    boolean addUser(User user);

    void updateUser(User user);

    void deleteUser(Long idUser);
}
