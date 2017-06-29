package com.svlada.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.svlada.entity.User;

/**
 * UserRepository
 * 
 * @author vladimir.stankovic
 *
 * Aug 16, 2016
 */
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsername(@Param("username") String username);
}
