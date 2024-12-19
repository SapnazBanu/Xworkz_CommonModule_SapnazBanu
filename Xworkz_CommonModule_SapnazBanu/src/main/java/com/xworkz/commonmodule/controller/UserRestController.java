package com.xworkz.commonmodule.controller;

import com.xworkz.commonmodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserRestController {
    @Autowired
    private UserService service;

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onName(@PathVariable String name) {
        System.out.println("name=" + name);
        Long count = this.service.countName(name);
        if (count == 0) {
            System.out.println("does not exist");
        } else {
            System.out.println("exists");
        }
        return null;
    }

    @GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onEmail(@PathVariable String email) {
        System.out.println("email=" + email);
        Long count = this.service.countByEmail(email);
        if (count == 0) {
            System.out.println("does not exist");
        } else {
            System.out.println("exists");
        }
        return null;
    }

    @GetMapping(value = "/altEmail/{altEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onAltEmail(@PathVariable String altEmail) {
        System.out.println("altEmail=" + altEmail);
        Long count = this.service.countByAltEmail(altEmail);
        if (count == 0) {
            System.out.println("does not exist");
        } else {
            System.out.println("exists");
        }
        return null;
    }

    @GetMapping(value = "/phone/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onPhone(@PathVariable String phone) {
        System.out.println("phone=" + phone);
        Long count = this.service.countByPhone(phone);
        if (count == 0) {
            System.out.println("does not exist");
        } else {
            System.out.println("exists");
        }
        return null;
    }

    @GetMapping(value = "/altPhone/{altPhone}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onAltPhone(@PathVariable String altPhone) {
        System.out.println("altPhone=" + altPhone);
        Long count = this.service.countByAltPhone(altPhone);
        if (count == 0) {
            System.out.println("does not exist");
        } else {
            System.out.println("exists");
        }
        return null;
    }

    @GetMapping(value = "/location/{location}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onLocation(@PathVariable String location) {
        System.out.println("location=" + location);
        Long count = this.service.countByLocation(location);
        if (count == 0) {
            System.out.println("does not exist");
        } else {
            System.out.println("exists");
        }
        return null;
    }
}


