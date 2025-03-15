package com.kochetkov.newpalette.repository;

import com.kochetkov.newpalette.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    User getUserByName(String name);
}
