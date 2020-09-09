package com.morlimoore.fbclone.servicesImpl;

import com.morlimoore.fbclone.entities.User;
import com.morlimoore.fbclone.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    void getAllUsers() {
       List<User> users = userService.getAllUsers();
       assertEquals(0, users.size());
    }


}