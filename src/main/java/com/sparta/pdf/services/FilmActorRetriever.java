package com.sparta.pdf.services;

import com.sparta.pdf.components.Actor;
import com.sparta.pdf.components.Film;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Named
@Stateless
public class FilmActorRetriever {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Actor> getActorsByFilmId(int filmId){
        Query query = entityManager.createNamedQuery("getActorsByFilmId");
        query.setParameter("filmId",filmId);
        return query.getResultList();
    }

    public List<Film> getFilmsByActorId(int actorId){
        Query query = entityManager.createNamedQuery("getFilmsByActorId");
        query.setParameter("actorId",actorId);
        return query.getResultList();
    }

    public List<Actor> getLimitedActorsByFilmId(int filmId,int numberOfElements){
        List<Actor> allActors = getActorsByFilmId(filmId);
        return allActors.size()<=numberOfElements?allActors:allActors.subList(0,numberOfElements);
    }

    public List<Film> getLimitedFilmsByActorId(int actorId,int numberOfElements){
        List<Film> allFilms = getFilmsByActorId(actorId);
        return allFilms.size()<=numberOfElements?allFilms:allFilms.subList(0,numberOfElements);
    }


}
