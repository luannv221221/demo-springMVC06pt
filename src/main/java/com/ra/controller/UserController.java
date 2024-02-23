package com.ra.controller;

import com.ra.model.entity.User;
import com.ra.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/register")
    public String register(Model model, User user){
        model.addAttribute("user",user);
        return "user/register";
    }
    @PostMapping("/post-register")
    public String postRegister(@ModelAttribute("user") User user){
        if(userService.register(user)){
            return "redirect:/login";
        }
        return "redirect:/register";
    }
    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @PostMapping("/login")
    public String postLogin(
            @RequestParam("email") String email,
            @RequestParam("password") String password){
        if(userService.login(email,password)){

            return "redirect:/";
        }
        return "redirect:/login?err";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("user");
        return "redirect:/";
    }
}
