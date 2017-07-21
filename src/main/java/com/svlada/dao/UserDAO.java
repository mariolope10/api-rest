package com.svlada.dao;

import com.svlada.entity.User;
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
public class UserDAO implements IUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserById(Long idUser) {
        return entityManager.find(User.class, idUser);
    }

    @Override
    public User getUserByUsername(String username) {
        String hql = "FROM User WHERE username = ?";
        return (User) entityManager.createQuery(hql)
                .setParameter(1, username)
                .getSingleResult();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        User uscl = getUserById(user.getId());
        uscl.setFirstname(user.getFirstname());
        uscl.setLastname(user.getLastname());
        entityManager.flush();
    }

    @Override
    public void deleteUser(Long idUser) {
        entityManager.remove(getUserById(idUser));
    }

    ////////////////////////////////////////////////////////////////////////////
    @Override
    public List<UserMoneda> getAllMonedasByUser(Long id) {
        String hql = "FROM UserMoneda WHERE user.id = ?";
        return (List<UserMoneda>) entityManager.createQuery(hql)
                .setParameter(1, id)
                .getResultList();
    }

    @Override
    public UserMoneda getMonedaByUser(int idMoneda, Long idUser) {
        String hql = "FROM UserMoneda WHERE user.id = ? AND moneda.id = ?";

        UserMoneda userMoneda;

        List results = (List) entityManager.createQuery(hql)
                .setParameter(1, idUser)
                .setParameter(2, idMoneda)
                .getResultList();

        if (results.isEmpty()) {
            // NO EXISTE EL REGISTRO
            userMoneda = new UserMoneda(idUser, Long.valueOf(idMoneda));
        } else {
            // EXISTE EL REGISTRO
            userMoneda = (UserMoneda) results.get(0);
        }

        return userMoneda;
    }

    @Override
    public UserMoneda getUserMonedaById(int idUserMoneda) {
        return entityManager.find(UserMoneda.class, idUserMoneda);
    }

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

            // SI TODO ES 0 ELIMINAMOS DE BBDD
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
    public void deleteUserMoneda(int idUserMoneda) {
        entityManager.remove(getUserMonedaById(idUserMoneda));
    }
}
