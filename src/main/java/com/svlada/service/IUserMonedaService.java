package com.svlada.service;

import com.svlada.entity.UserMoneda;

/**
 *
 * @author mario.lope
 */
public interface IUserMonedaService {
    
    boolean addUserMoneda(UserMoneda userMoneda);
    
    void updateUserMoneda(UserMoneda userMoneda);
    
    void deleteUserMoneda(int id);
}
