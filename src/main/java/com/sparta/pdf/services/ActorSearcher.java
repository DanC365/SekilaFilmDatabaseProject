package com.sparta.pdf.services;

import com.sparta.pdf.components.Actor;
import com.sparta.pdf.components.Film;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Named
@Stateless
public class ActorSearcher {


    @PersistenceContext
    private EntityManager entityManager;


    public List<Actor> doSearch(String searchQuery){
        Query query = entityManager.createNamedQuery("getActorByName");
        query.setParameter("enteredName", searchQuery);
        List<Actor> results = query.getResultList();
        return results;
    }
}
