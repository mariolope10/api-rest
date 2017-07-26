package com.svlada.dao;

import com.svlada.entity.UserMoneda;
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
public class UserMonedaDAO implements IUserMonedaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUserMoneda(UserMoneda userMoneda) {
        entityManager.persist(userMoneda);
    }

    @Override
    public void updateUserMoneda(UserMoneda userMoneda) {
        UserMoneda um = getUserMonedaById(userMoneda.getId());
        um.setCirc_coleccion(userMoneda.getCirc_coleccion());
        um.setCirc_intercambio(userMoneda.getCirc_intercambio());
        um.setSc_coleccion(userMoneda.getSc_coleccion());
        um.setSc_intercambio(userMoneda.getSc_intercambio());
        um.setBu_coleccion(userMoneda.getBu_coleccion());
        um.setBu_intercambio(userMoneda.getBu_intercambio());
        um.setProof_coleccion(userMoneda.getProof_coleccion());
        um.setProof_intercambio(userMoneda.getProof_intercambio());

        entityManager.flush();
    }

    @Override
    public void deleteUserMoneda(int id) {
        entityManager.remove(getUserMonedaById(id));
    }

    @Override
    public UserMoneda getUserMonedaById(int id) {
        return entityManager.find(UserMoneda.class, id);
    }
}
