package com.rev.springbootjpa.controller;

import com.rev.springbootjpa.model.AppUser;
import com.rev.springbootjpa.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

    @PostMapping("/login")
    public AppUser loginUser(@RequestBody AppUser appUser){
        return  appUserService.login(appUser);
    }
    @PostMapping("/register")
    public AppUser registerUser(@RequestBody AppUser appUser){
        return  appUserService.register(appUser);
    }


}
