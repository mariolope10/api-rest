package com.svlada.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.svlada.entity.Moneda;
import com.svlada.dao.IMonedaDAO;

/**
 *
 * @author mario.lope
 */
@Service
public class MonedaService implements IMonedaService {

    @Autowired
    private IMonedaDAO monedaDAO;
    
    @Override
    public boolean addMoneda(Moneda moneda) {
        monedaDAO.addMoneda(moneda);
    	return true;
    }

    @Override
    public void updateMoneda(Moneda moneda) {
        monedaDAO.updateMoneda(moneda);
    }

    @Override
    public void deleteMoneda(int idMoneda) {
        monedaDAO.deleteMoneda(idMoneda);
    }

    @Override
    public Moneda getMonedaById(int idMoneda) {
        return monedaDAO.getMonedaById(idMoneda);
    }
    
    @Override
    public List<Moneda> getAllMonedas() {
        return monedaDAO.getAllMonedas();
    }
    
    @Override
    public List<Moneda> getAllMonedasConmemorativasByPais(String pais) {
        return monedaDAO.getAllMonedasConmemorativasByPais(pais);
    }
    
    @Override
    public List<Moneda> getAllMonedasConmemorativasByAno(int ano) {
        return monedaDAO.getAllMonedasConmemorativasByAno(ano);
    }
    
    // USER ////////////////////////////////////////////////////////////////////
    
    @Override
    public List<Moneda> getAllMonedasConmemorativasByPaisUser(String pais, long idUser) {
        return monedaDAO.getAllMonedasConmemorativasByPaisUser(pais, idUser);
    }
    
    @Override
    public List<Moneda> getAllMonedasConmemorativasByAnoUser(int ano, long idUser) {
        return monedaDAO.getAllMonedasConmemorativasByAnoUser(ano, idUser);
    }

}
