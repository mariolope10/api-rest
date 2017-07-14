package com.svlada.service;

import com.svlada.entity.User;
import com.svlada.entity.UserMoneda;
import java.util.List;

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
    
    ////////////////////////////////
    
    List<UserMoneda> getAllMonedasByUser(Long id);
    
    UserMoneda getMonedaByUser(int idMoneda, Long idUser);
}
