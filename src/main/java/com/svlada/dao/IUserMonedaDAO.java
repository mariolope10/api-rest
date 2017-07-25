package com.svlada.dao;

import com.svlada.entity.UserMoneda;

/**
 *
 * @author mario.lope
 */
public interface IUserMonedaDAO {
    
    void addUserMoneda(UserMoneda userMoneda);
    
    void updateUserMoneda(UserMoneda userMoneda);
    
    void deleteUserMoneda(int id);
    
    UserMoneda getUserMonedaById(int id);
}
