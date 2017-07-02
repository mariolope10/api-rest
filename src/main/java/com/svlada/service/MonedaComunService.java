package com.svlada.service;

import com.svlada.entity.MonedaComun;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.svlada.dao.IMonedaComunDAO;

/**
 *
 * @author mario.lope
 */

@Service
public class MonedaComunService implements IMonedaComunService {

    @Autowired
    private IMonedaComunDAO monedaDAO;

    @Override
    public List<MonedaComun> getAllMonedas() {
        return monedaDAO.getAllMonedas();
    }
    
    @Override
    public List<MonedaComun> getAllMonedasByPais(String pais) {
        return monedaDAO.getAllMonedasByPais(pais);
    }

    @Override
    public MonedaComun getMonedaById(int idMoneda) {
        return monedaDAO.getMonedaById(idMoneda);
    }

    @Override
    public boolean addMoneda(MonedaComun moneda) {
        monedaDAO.addMoneda(moneda);
    	return true;
    }

    @Override
    public void updateMoneda(MonedaComun moneda) {
        monedaDAO.updateMoneda(moneda);
    }

    @Override
    public void deleteMoneda(int idMoneda) {
        monedaDAO.deleteMoneda(idMoneda);
    }

}
