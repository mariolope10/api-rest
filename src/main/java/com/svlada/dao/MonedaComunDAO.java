package com.svlada.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.svlada.entity.MonedaComun;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mario.lope
 */

@Transactional
@Repository
public class MonedaComunDAO implements IMonedaComunDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MonedaComun> getAllMonedas() {
        String hql = "FROM MonedaComun ORDER BY id";
        return (List<MonedaComun>) entityManager.createQuery(hql).getResultList();
    }
    
    @Override
    public List<MonedaComun> getAllMonedasByPais(String pais) {
        String hql = "FROM MonedaComun WHERE pais = ? ORDER BY id";
        return (List<MonedaComun>) entityManager.createQuery(hql)
                .setParameter(1, pais)
                .getResultList();
    }
    
    @Override
    public MonedaComun getMonedaById(int idMoneda) {
        return entityManager.find(MonedaComun.class, idMoneda);
    }

    @Override
    public void addMoneda(MonedaComun moneda) {
        entityManager.persist(moneda);
    }

    @Override
    public void updateMoneda(MonedaComun moneda) {
        MonedaComun moncl = getMonedaById(moneda.getId());
        moncl.setPais(moneda.getPais());
        moncl.setValor(moneda.getValor());
        entityManager.flush();
    }

    @Override
    public void deleteMoneda(int idMoneda) {
        entityManager.remove(getMonedaById(idMoneda));
    }

    /*@Override
    public boolean monedaExists(String valor, String pais) {
        String hql = "FROM moneda WHERE valor = ? and pais = ?";
        int count = entityManager.createQuery(hql)
                .setParameter(1, valor)
                .setParameter(2, pais)
                .getResultList().size();
        
        return count > 0;
    }*/
}
