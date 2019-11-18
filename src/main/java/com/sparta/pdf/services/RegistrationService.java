package com.sparta.pdf.services;

import com.sparta.rho.components.User;


import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class RegistrationService {
    @PersistenceContext
    private EntityManager em;

    public String registerUser(User user) {
        em.persist(user);
        return "newUserRegistered";
    }

}

