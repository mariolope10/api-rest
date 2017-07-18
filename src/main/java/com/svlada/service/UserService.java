package com.svlada.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.svlada.dao.IUserDAO;
import com.svlada.entity.User;
import com.svlada.entity.UserMoneda;
import java.util.List;

/**
 *
 * @author mario.lope
 */

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public User getUserById(Long idUser) {
        return userDAO.getUserById(idUser);
    }
    
    @Override
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

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
    public void deleteUser(Long idUser) {
        userDAO.deleteUser(idUser);
    }
    
    @Override
    public List<UserMoneda> getAllMonedasByUser(Long id) {
        return userDAO.getAllMonedasByUser(id);
    }
    
    @Override
    public UserMoneda getMonedaByUser(int idMoneda, Long idUser) {
        return userDAO.getMonedaByUser(idMoneda, idUser);
    }
    
    @Override
    public boolean addUserMoneda(UserMoneda userMoneda) {
        userDAO.addUserMoneda(userMoneda);
    	return true;
    }

    @Override
    public void updateUserMoneda(UserMoneda userMoneda) {
        userDAO.updateUserMoneda(userMoneda);
    }
}
