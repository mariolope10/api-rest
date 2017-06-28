package com.svlada.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.svlada.entity.Serie;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mario.lope
 */

@Transactional
@Repository
public class SerieDAO implements ISerieDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Serie> getAllSeries() {
        String hql = "FROM Serie ORDER BY id";
        return (List<Serie>) entityManager.createQuery(hql).getResultList();
    }
    
    @Override
    public List<Serie> getAllSeriesByPais(String pais) {
        String hql = "FROM Serie WHERE pais = ? ORDER BY id";
        return (List<Serie>) entityManager.createQuery(hql)
                .setParameter(1, pais)
                .getResultList();
    }
    
    @Override
    public Serie getSerieById(int idSerie) {
        return entityManager.find(Serie.class, idSerie);
    }

    @Override
    public void addSerie(Serie serie) {
        entityManager.persist(serie);
    }

    @Override
    public void updateSerie(Serie serie) {
        Serie sercl = getSerieById(serie.getId());
        sercl.setPais(serie.getPais());
        sercl.setOrden(serie.getOrden());
        entityManager.flush();
    }

    @Override
    public void deleteSerie(int idSerie) {
        entityManager.remove(getSerieById(idSerie));
    }
}
