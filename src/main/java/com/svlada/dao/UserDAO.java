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
        return (UserMoneda) entityManager.createQuery(hql)
                .setParameter(1, idUser)
                .setParameter(2, idMoneda)
                .getSingleResult();
    }
}
