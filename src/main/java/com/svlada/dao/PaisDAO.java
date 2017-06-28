package com.svlada.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.svlada.entity.Pais;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mario.lope
 */

@Transactional
@Repository
public class PaisDAO implements IPaisDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Pais> getAllPaises() {
        String hql = "FROM Pais ORDER BY id";
        return (List<Pais>) entityManager.createQuery(hql).getResultList();
    }
    
    @Override
    public Pais getPaisById(int idPais) {
        return entityManager.find(Pais.class, idPais);
    }

    @Override
    public void addPais(Pais pais) {
        entityManager.persist(pais);
    }

    @Override
    public void updatePais(Pais pais) {
        Pais pacl = getPaisById(pais.getId());
        pacl.setCodigo(pais.getCodigo());
        pacl.setNombre(pais.getNombre());
        entityManager.flush();
    }

    @Override
    public void deletePais(int idPais) {
        entityManager.remove(getPaisById(idPais));
    }
}
