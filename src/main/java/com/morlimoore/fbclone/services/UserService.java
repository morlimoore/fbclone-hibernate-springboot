package com.morlimoore.fbclone.services;

import com.morlimoore.fbclone.entities.User;

import java.util.List;
import java.util.Optional;

/**
 * An abstraction of the user services offered by the application
 */
public interface UserService {

    List<User> getAllUsers();
    void addUser(User user);
    Optional<User> findUserById(Long id);
}
