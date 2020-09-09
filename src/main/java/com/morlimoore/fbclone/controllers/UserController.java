package com.morlimoore.fbclone.controllers;

//import com.morlimoore.fbclone.services.UserService;
import com.morlimoore.fbclone.entities.User;
import com.morlimoore.fbclone.services.LoginService;
import com.morlimoore.fbclone.services.UserService;
import com.morlimoore.fbclone.servicesImpl.UserServiceImpl;
import com.morlimoore.fbclone.utils.BCrypt;
import com.morlimoore.fbclone.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * This class, serving as a spring controller, handles all that has to do with the user.
 * It controls the entry point of the application.
 * It handles user registration, login and the authentication in between.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @GetMapping("/")
    public String showWelcomePage(Model model) {
        model.addAttribute("user", new User());
        return "welcomePage";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result, Model model) {
        String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setHash(hash);
        user.setCreatedAt(DateUtil.getCurrentDate());
        model.addAttribute("user", user);
        userService.addUser(user);
        return "redirect:/dashboard";
    }

    @PostMapping("/login")
    public String loginUser(@Valid User user, Model model) {
        String response = "redirect:/";
        if(loginService.getUserEmailInDb(user.getEmail()) != null && BCrypt.checkpw(user.getPassword(), loginService.getUserHashInDb(user.getEmail()))) {
            model.addAttribute("user", user);
            response = "redirect:/dashboard";
        }
        return response;
    }

}


