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
    public List<Serie> getAllSeries() {
        return serieDAO.getAllSeries();
    }
    
    @Override
    public List<Serie> getAllSeriesByPais(int idPais) {
        return serieDAO.getAllSeriesByPais(idPais);
    }

    @Override
    public Serie getSerieById(int idSerie) {
        return serieDAO.getSerieById(idSerie);
    }

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

}
