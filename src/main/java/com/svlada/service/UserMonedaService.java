package com.svlada.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.svlada.dao.IUserMonedaDAO;
import com.svlada.entity.UserMoneda;

/**
 *
 * @author mario.lope
 */
@Service
public class UserMonedaService implements IUserMonedaService {

    @Autowired
    private IUserMonedaDAO userMonedaDAO;
    
    @Override
    public boolean addUserMoneda(UserMoneda userMoneda) {
        userMonedaDAO.addUserMoneda(userMoneda);
    	return true;
    }

    @Override
    public void updateUserMoneda(UserMoneda userMoneda) {
        userMonedaDAO.updateUserMoneda(userMoneda);
    }
    
    @Override
    public void deleteUserMoneda(int id) {
        userMonedaDAO.deleteUserMoneda(id);
    }
}
