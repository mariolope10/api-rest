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
        if (userMoneda.getCirc_coleccion() == 0
                && userMoneda.getCirc_intercambio() == 0
                && userMoneda.getSc_coleccion() == 0
                && userMoneda.getSc_intercambio() == 0
                && userMoneda.getBu_coleccion() == 0
                && userMoneda.getBu_intercambio() == 0
                && userMoneda.getProof_coleccion() == 0
                && userMoneda.getProof_intercambio() == 0) {

            // SI TODO ES '0' ELIMINAMOS DE BBDD
            deleteUserMoneda(userMoneda.getId());
            
        } else {
            // HA INTRODUCIDO AL MENOS 1 MONEDA ENTONCES GUARDAMOS
            UserMoneda um1 = getUserMonedaById(userMoneda.getId());
            um1.setCirc_coleccion(userMoneda.getCirc_coleccion());
            um1.setCirc_intercambio(userMoneda.getCirc_intercambio());
            um1.setSc_coleccion(userMoneda.getSc_coleccion());
            um1.setSc_intercambio(userMoneda.getSc_intercambio());
            um1.setBu_coleccion(userMoneda.getBu_coleccion());
            um1.setBu_intercambio(userMoneda.getBu_intercambio());
            um1.setProof_coleccion(userMoneda.getProof_coleccion());
            um1.setProof_intercambio(userMoneda.getProof_intercambio());
            
            entityManager.flush();
        }
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
