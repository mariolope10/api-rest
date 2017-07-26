package com.svlada.dao;

import com.svlada.entity.Serie;
import java.util.List;

/**
 *
 * @author mario.lope
 */
public interface ISerieDAO {

    void addSerie(Serie serie);

    void updateSerie(Serie serie);

    void deleteSerie(int idSerie);
    
    Serie getSerieById(int idSerie);

    List<Serie> getAllSeries();
    
    List<Serie> getAllSeriesByPais(String pais);
    
    // USER ////////////////////////////////////////////////////////////////////

    List<Serie> getAllSeriesByPaisUser(String pais, long idUser);
    
    List<Serie> getAllSeriesByAnoUser(int ano, long idUser);
}
