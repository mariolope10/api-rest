package com.svlada.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.svlada.dao.IUserDAO;
import com.svlada.entity.User;

/**
 *
 * @author mario.lope
 */

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;
    
    @Override
    public boolean addUser(User user) {
        userDAO.addUser(user);
    	return true;
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }
    
    @Override
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }
}
