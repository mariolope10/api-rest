package com.svlada.service;

import com.svlada.entity.Serie;
import com.svlada.entity.User;
import java.util.List;

/**
 *
 * @author mario.lope
 */
public interface ISerieService {

    boolean addSerie(Serie serie);

    void updateSerie(Serie serie);

    void deleteSerie(int idSerie);
    
    Serie getSerieById(int idSerie);
    
    List<Serie> getAllSeries();
    
    List<Serie> getAllSeriesByPais(String pais);
    
    // USER ////////////////////////////////////////////////////////////////////
    
    List<Serie> getAllSeriesByPaisUser(String pais, User user);
    
    List<Serie> getAllSeriesByAnoUser(int ano, User user);

}
