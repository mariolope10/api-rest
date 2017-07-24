package com.svlada.service;

import com.svlada.entity.Serie;
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
    
    ////////////////////////////////////////////
    
    List<Serie> getAllSeriesByPaisUser(String pais, long idUser);
    
    List<Serie> getAllSeriesByAnoUser(int ano, long idUser);

}
