package com.morlimoore.fbclone.servicesImpl;

import com.morlimoore.fbclone.repositories.UserRepository;
import com.morlimoore.fbclone.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * An implementation of the login services offered by the application.
 * It is injected to the controller, to offer its services.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String getUserEmailInDb(String email) {
        String response = userRepository.getUserEmailInDb(email);
        return response;
    }

    @Override
    public String getUserHashInDb(String email) {
        String response = userRepository.getUserHashInDb(email);
        return response;
    }
}
