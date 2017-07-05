package com.svlada.service;

import com.svlada.entity.Serie;
import java.util.List;

/**
 *
 * @author mario.lope
 */
public interface ISerieService {

    List<Serie> getAllSeries();
    
    List<Serie> getAllSeriesByPais(int idPais);

    Serie getSerieById(int idSerie);

    boolean addSerie(Serie serie);

    void updateSerie(Serie serie);

    void deleteSerie(int idSerie);
}
