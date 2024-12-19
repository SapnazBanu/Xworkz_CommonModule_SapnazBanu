package com.xworkz.commonmodule.controller;

import com.xworkz.commonmodule.dto.UserDTO;
import com.xworkz.commonmodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping("/")
@EnableWebMvc
public class UserController {

    @Autowired
    private UserService service;
    public UserController()
    {
        System.out.println("ModuleController Running");
    }


    @PostMapping("/SignupServlet")
    public String onSignup(UserDTO dto, Model model) {
        System.out.println("save is Running in ModuleController");
        System.out.println(dto);
        boolean result=service.validateAndSave(dto);
        model.addAttribute("name","SignupSuccess");
        return "Signup";
        }

    @PostMapping("/SigninServlet")
    public  String save(@RequestParam String email, @RequestParam String password, Model model)
    {
        String valid = service.getNameByEmailAndPassword(email,password);
        System.out.println("is it working"+valid);
        model.addAttribute("msg","SiginSuccess");
        return "Signin";
    }
    }

