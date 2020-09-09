package com.morlimoore.fbclone.services;

/**
 * An abstraction of the login services offered by the application
 */
public interface LoginService {

    String getUserEmailInDb(String email);
    String getUserHashInDb(String email);

}
