package com.sparta.pdf.services;

import com.sparta.pdf.components.Category;
import com.sparta.pdf.components.Film;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Named
@Stateless
public class FilmSearcher implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Film> doSearch(String searchQuery){
        Query query = entityManager.createNamedQuery("getFilmByName");
        query.setParameter("searchTitle", searchQuery);
        List<Film> results = query.getResultList();
        return results;
    }

    @Deprecated
    public List<Category> getCategories(int filmId){
        Query query = entityManager.createNamedQuery("getFilmCategories");
        query.setParameter("filmId",filmId);
        List<Category> results = query.getResultList();
        return results;
    }
}
