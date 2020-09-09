package com.morlimoore.fbclone.repositories;

import com.morlimoore.fbclone.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * This allows us use JPA SQL queries, as well as define our custom queries like we did
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT email FROM users WHERE email = ?1", nativeQuery = true)
    String getUserEmailInDb(String email);

    @Query(value = "SELECT hash FROM users WHERE email = ?1", nativeQuery = true)
    String getUserHashInDb(String email);
}
