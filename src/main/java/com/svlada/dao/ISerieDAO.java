package com.svlada.dao;

import com.svlada.entity.Serie;
import java.util.List;

/**
 *
 * @author mario.lope
 */
public interface ISerieDAO {

    List<Serie> getAllSeries();
    
    List<Serie> getAllSeriesByPais(int idPais);

    Serie getSerieById(int idSerie);

    void addSerie(Serie serie);

    void updateSerie(Serie serie);

    void deleteSerie(int idSerie);
}
