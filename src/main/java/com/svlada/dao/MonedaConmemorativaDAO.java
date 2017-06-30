package com.svlada.dao;

import com.svlada.entity.MonedaConmemorativa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mario.lope
 */

@Transactional
@Repository
public class MonedaConmemorativaDAO implements IMonedaConmemorativaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MonedaConmemorativa> getAllMonedas() {
        String hql = "FROM MonedaConmemorativa ORDER BY id";
        return (List<MonedaConmemorativa>) entityManager.createQuery(hql).getResultList();
    }
    
    @Override
    public List<MonedaConmemorativa> getAllMonedasByPais(String pais) {
        String hql = "SELECT mc FROM MonedaConmemorativa mc INNER JOIN mc.pais p WHERE p.codigo = :codigo ORDER BY id";
        return (List<MonedaConmemorativa>) entityManager.createQuery(hql)
                .setParameter("codigo", pais)
                .getResultList();
    }
    
    @Override
    public List<MonedaConmemorativa> getAllMonedasByAno(int ano) {
        String hql = "FROM MonedaConmemorativa WHERE YEAR(fecha_emision) = ? ORDER BY id";
        return (List<MonedaConmemorativa>) entityManager.createQuery(hql)
                .setParameter(1, ano)
                .getResultList();
    }
    
    @Override
    public MonedaConmemorativa getMonedaById(int idMoneda) {
        return entityManager.find(MonedaConmemorativa.class, idMoneda);
    }

    @Override
    public void addMoneda(MonedaConmemorativa moneda) {
        entityManager.persist(moneda);
    }

    @Override
    public void updateMoneda(MonedaConmemorativa moneda) {
        MonedaConmemorativa moncl = getMonedaById(moneda.getId());
        moncl.setPais(moneda.getPais());
        moncl.setMotivo(moneda.getMotivo());
        entityManager.flush();
    }

    @Override
    public void deleteMoneda(int idMoneda) {
        entityManager.remove(getMonedaById(idMoneda));
    }
}
