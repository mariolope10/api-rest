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
    public void addSerie(Serie serie) {
        entityManager.persist(serie);
    }

    @Override
    public void updateSerie(Serie serie) {
        Serie sercl = getSerieById(serie.getId());
        sercl.setPais(serie.getPais());
        entityManager.flush();
    }

    @Override
    public void deleteSerie(int idSerie) {
        entityManager.remove(getSerieById(idSerie));
    }
    
    @Override
    public Serie getSerieById(int idSerie) {
        return entityManager.find(Serie.class, idSerie);
    }

    @Override
    public List<Serie> getAllSeries() {
        String hql = "FROM Serie ORDER BY id";
        return (List<Serie>) entityManager.createQuery(hql).getResultList();
    }
    
    @Override
    public List<Serie> getAllSeriesByPais(String codigo) {
        String hql = "FROM Serie WHERE pais.codigo = :codigo";
        return (List<Serie>) entityManager.createQuery(hql)
                .setParameter("codigo", codigo)
                .getResultList();
    }
    
    // USER ////////////////////////////////////////////////////////////////////
    
    @Override
    public List<Serie> getAllSeriesByPaisUser(String codigo, long idUser) {
        String hql = "SELECT moneda.serie_ano.serie FROM Moneda moneda "
                + "LEFT JOIN moneda.user_monedas um "
                + "WHERE moneda.serie_ano.serie.pais.codigo = ? "
                + "AND moneda.tipo.id = 1 "
                + "AND (um.user.id = ? OR um = null) "
                + "GROUP BY moneda.serie_ano.serie";
        
        return (List<Serie>) entityManager.createQuery(hql)
                .setParameter(1, codigo)
                .setParameter(2, idUser)
                .getResultList();
    }
    
    @Override
    public List<Serie> getAllSeriesByAnoUser(int ano, long idUser) {
        String hql = "SELECT moneda.serie_ano.serie FROM Moneda moneda "
                + "LEFT JOIN moneda.user_monedas um "
                + "WHERE :ano BETWEEN moneda.serie_ano.serie.fecha_desde AND moneda.serie_ano.serie.fecha_hasta "
                + "AND moneda.tipo.id = 1 "
                + "AND (um.user.id = :id_user OR um = null) "
                + "GROUP BY moneda.serie_ano.serie";
        
        return (List<Serie>) entityManager.createQuery(hql)
                .setParameter("ano", ano)
                .setParameter("id_user", idUser)
                .getResultList();
    }
}
