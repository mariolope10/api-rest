package com.svlada.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.svlada.dao.IMonedaConmemorativaDAO;
import com.svlada.entity.MonedaConmemorativa;

/**
 *
 * @author mario.lope
 */

@Service
public class MonedaConmemorativaService implements IMonedaConmemorativaService {

    @Autowired
    private IMonedaConmemorativaDAO monedaDAO;

    @Override
    public List<MonedaConmemorativa> getAllMonedas() {
        return monedaDAO.getAllMonedas();
    }
    
    @Override
    public List<MonedaConmemorativa> getAllMonedasByPais(String pais) {
        return monedaDAO.getAllMonedasByPais(pais);
    }
    
    @Override
    public List<MonedaConmemorativa> getAllMonedasByAno(int ano) {
        return monedaDAO.getAllMonedasByAno(ano);
    }

    @Override
    public MonedaConmemorativa getMonedaById(int idMoneda) {
        return monedaDAO.getMonedaById(idMoneda);
    }

    @Override
    public boolean addMoneda(MonedaConmemorativa moneda) {
        monedaDAO.addMoneda(moneda);
    	return true;
    }

    @Override
    public void updateMoneda(MonedaConmemorativa moneda) {
        monedaDAO.updateMoneda(moneda);
    }

    @Override
    public void deleteMoneda(int idMoneda) {
        monedaDAO.deleteMoneda(idMoneda);
    }

}
