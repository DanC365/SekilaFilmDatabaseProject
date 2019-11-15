package com.sparta.pdf.services;

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
public class FilmSearcher {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Film> doSearch(String searchQuery){
        List<Film> filmList = new ArrayList<>();
        Query query = entityManager.createNamedQuery("getFilmByName");
        query.setParameter("searchTitle", searchQuery);
        List<Film> results = query.getResultList();
        System.out.println(results.size());
        for (Film f: results) {
            System.out.println(f.getTitle());
        }
        return results;
    }
}
