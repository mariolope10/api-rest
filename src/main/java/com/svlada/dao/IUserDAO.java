package com.svlada.dao;

import com.svlada.entity.User;
import com.svlada.entity.UserMoneda;
import java.util.List;

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
    
    //////////////////////////////
    
    UserMoneda getUserMonedaById(int idUserMoneda);
    
    List<UserMoneda> getAllMonedasByUser(Long id);
    
    UserMoneda getMonedaByUser(int idMoneda, Long idUser);
    
    void addUserMoneda(UserMoneda userMoneda);
    
    void updateUserMoneda(UserMoneda userMoneda);
    
    void deleteUserMoneda(int idUserMoneda);
}
