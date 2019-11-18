package com.sparta.pdf.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class LoginService {
    @PersistenceContext
    EntityManager entityManager;
    private String login(String searchQuery) {
        Query query = entityManager.createNamedQuery("getUsernameAndPassword");
        query.setParameter("usernameInput", searchQuery);
        query.setParameter("userPasswordInput", searchQuery);
        if (query.getFirstResult() > 0) {
            return "welcome";
        } else {
            return "signIn";
        }
    }
}
