package com.svlada.service;

import com.svlada.dao.ISerieDAO;
import com.svlada.entity.Serie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mario.lope
 */

@Service
public class SerieService implements ISerieService {

    @Autowired
    private ISerieDAO serieDAO;
    
    @Override
    public boolean addSerie(Serie serie) {
        serieDAO.addSerie(serie);
    	return true;
    }

    @Override
    public void updateSerie(Serie serie) {
        serieDAO.updateSerie(serie);
    }

    @Override
    public void deleteSerie(int idSerie) {
        serieDAO.deleteSerie(idSerie);
    }
    
    @Override
    public Serie getSerieById(int idSerie) {
        return serieDAO.getSerieById(idSerie);
    }

    @Override
    public List<Serie> getAllSeries() {
        return serieDAO.getAllSeries();
    }
    
    @Override
    public List<Serie> getAllSeriesByPais(String pais) {
        return serieDAO.getAllSeriesByPais(pais);
    }
    
    //////////////////////////////////////////////////////
    
    @Override
    public List<Serie> getAllSeriesByPaisUser(String pais, long idUser) {
        return serieDAO.getAllSeriesByPaisUser(pais, idUser);
    }
    
    @Override
    public List<Serie> getAllSeriesByAnoUser(int ano, long idUser) {
        return serieDAO.getAllSeriesByAnoUser(ano, idUser);
    }

}
