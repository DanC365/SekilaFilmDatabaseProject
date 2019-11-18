package com.sparta.pdf.services;

import com.sparta.pdf.components.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class LoginService {
    @PersistenceContext
    EntityManager entityManager;
    public String validateUser(User user) {
        Query query = entityManager.createNamedQuery("getUsernameAndPassword");
        query.setParameter("usernameInput", user.getUsername());
        query.setParameter("userPasswordInput", user.getUserPassword());
        if (query.getFirstResult() > 0) {
            return "welcome";
        } else {
            return "signIn";
        }
    }
}
