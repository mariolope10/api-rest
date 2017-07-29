package com.svlada.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.svlada.entity.Serie;
import com.svlada.entity.User;
import javax.transaction.Transactional;
import org.hibernate.Filter;
import org.hibernate.Session;
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
    public List<Serie> getAllSeriesByPaisUser(String codigo, User user) {
        Filter filter = (Filter) entityManager.unwrap(Session.class).enableFilter("filterByUserId");
        filter.setParameter("id", user.getId());

        String hql = "SELECT moneda.serie_ano.serie FROM Moneda moneda "
                + "LEFT JOIN moneda.user_monedas um "
                + "WHERE moneda.serie_ano.serie.pais.codigo = :codigo "
                + "AND moneda.tipo.id = 1 "
                + "AND (um.user.id = :idUser OR um = null) "
                + "GROUP BY moneda.serie_ano.serie";

        List<Serie> listadoSeries = (List<Serie>) entityManager.createQuery(hql)
                .setParameter("codigo", codigo)
                .setParameter("idUser", user.getId())
                .getResultList();

        //entityManager.unwrap(Session.class).disableFilter("filterByUserId");
        return listadoSeries;
    }

    @Override
    public List<Serie> getAllSeriesByAnoUser(int ano, User user) {
        Filter filter = (Filter) entityManager.unwrap(Session.class).enableFilter("filterByUserId");
        filter.setParameter("id", user.getId());
        
        String hql = "SELECT moneda.serie_ano.serie FROM Moneda moneda "
                + "LEFT JOIN moneda.user_monedas um "
                + "WHERE :ano BETWEEN moneda.serie_ano.serie.fecha_desde AND moneda.serie_ano.serie.fecha_hasta "
                + "AND moneda.tipo.id = 1 "
                + "AND (um.user.id = :idUser OR um = null) "
                + "GROUP BY moneda.serie_ano.serie";

        List<Serie> listadoSeries = (List<Serie>) entityManager.createQuery(hql)
                .setParameter("ano", ano)
                .setParameter("idUser", user.getId())
                .getResultList();
        
        //entityManager.unwrap(Session.class).disableFilter("filterByUserId");
        return listadoSeries;
    }
}
