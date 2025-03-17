package com.kochetkov.newpalette.repository;

import com.kochetkov.newpalette.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("""
    SELECT u
    FROM User u
    WHERE u.name = :name
    AND u.deletedAt IS NULL
    """)
    Optional<User> findByName(String name);
}
