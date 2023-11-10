package com.rev.springbootjpa.service;

import com.rev.springbootjpa.model.AppUser;
import com.rev.springbootjpa.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser login(AppUser appUser){
        AppUser user=appUserRepository.findUserByUserNameAndPassword
                (appUser.getUname(),appUser.getUpassword());
        return user;
    }

    public AppUser register(AppUser appUser){
        appUserRepository.save(appUser);
        return appUser;
    }
}
