package com.sparta.pdf.beans.users;

import com.sparta.pdf.components.User;
import com.sparta.pdf.services.LoginService;
import com.sparta.pdf.services.RegistrationService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
@RequestScoped
public class UserBean {
    @Inject
    private RegistrationService registrationService;
    @Inject
    private LoginService loginService;
    private User user= new User();


    public User getUser() {
        return user;
    }

    @Transactional
    public String registerUser(){
        return registrationService.registerUser(user);
    }
     @Transactional
    public String validateUser() {
        return loginService.validateUser(user);
    }
}
