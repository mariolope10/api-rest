package com.svlada.dao;

import com.svlada.entity.Moneda;
import com.svlada.entity.UserMoneda;
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
public class MonedaDAO implements IMonedaDAO {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void addMoneda(Moneda moneda) {
        entityManager.persist(moneda);
    }

    @Override
    public void updateMoneda(Moneda moneda) {
        Moneda moncl = getMonedaById(moneda.getId());
        moncl.setPais(moneda.getPais());
        moncl.setMotivo(moneda.getMotivo());
        entityManager.flush();
    }

    @Override
    public void deleteMoneda(int idMoneda) {
        entityManager.remove(getMonedaById(idMoneda));
    }

    @Override
    public Moneda getMonedaById(int idMoneda) {
        return entityManager.find(Moneda.class, idMoneda);
    }
    
    @Override
    public List<Moneda> getAllMonedas() {
        String hql = "FROM MonedaConmemorativa ORDER BY id";
        return (List<Moneda>) entityManager.createQuery(hql).getResultList();
    }
    
    @Override
    public List<Moneda> getAllMonedasConmemorativasByPais(String pais) {
        String hql = "FROM Moneda WHERE tipo.id = 2 AND pais.codigo = :codigo";
        return (List<Moneda>) entityManager.createQuery(hql)
                .setParameter("codigo", pais)
                .getResultList();
    }
    
    @Override
    public List<Moneda> getAllMonedasConmemorativasByAno(int ano) {
        String hql = "FROM Moneda WHERE tipo.id = 2 AND ano = ? ORDER BY id";
        return (List<Moneda>) entityManager.createQuery(hql)
                .setParameter(1, ano)
                .getResultList();
    }
    
    // OPERACIONES DEL USUARIO
    
    @Override
    public List<Moneda> getAllMonedasConmemorativasByPaisUser(String pais, long idUser) {
        String hql = "SELECT m FROM Moneda m "
                + "LEFT JOIN m.user_monedas um "
                + "WHERE m.pais.codigo = ? "
                + "AND m.tipo.id = 2 "
                + "AND (um.user.id = ? OR um = null)";
        
        return (List<Moneda>) entityManager.createQuery(hql)
                .setParameter(1, pais)
                .setParameter(2, idUser)
                .getResultList();
    }
    
    @Override
    public List<Moneda> getAllMonedasConmemorativasByAnoUser(int ano, long idUser) {
        String hql = "SELECT m FROM Moneda m "
                + "LEFT JOIN m.user_monedas um "
                + "WHERE m.ano = ? "
                + "AND m.tipo.id = 2 "
                + "AND (um.user.id = ? OR um = null)";
        
        return (List<Moneda>) entityManager.createQuery(hql)
                .setParameter(1, ano)
                .setParameter(2, idUser)
                .getResultList();
    }
}
