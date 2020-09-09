package com.morlimoore.fbclone.servicesImpl;

import com.morlimoore.fbclone.entities.User;
import com.morlimoore.fbclone.services.UserService;
import com.morlimoore.fbclone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * An implementation of the user services offered by the application.
 * It is injected to the controller, to offer its services.
 */
@Service
public class UserServiceImpl implements UserService {

    //This annotation enables us to inject the UserRepository dependency in our class
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }


}
