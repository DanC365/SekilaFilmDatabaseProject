package com.sparta.pdf.beans;

import com.sparta.pdf.components.Actor;
import com.sparta.pdf.components.Film;
import com.sparta.pdf.services.FilmActorRetriever;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class FilmBean {

    private Film activeFilm;
    private List<Actor> actorList;
    @Inject
    FilmActorRetriever filmActorRetriever;

    public String setActiveFilm(Film film){
        activeFilm = film;
        setActorList();
        return "filmDetails";
    }

    public Film getActiveFilm() {
        return activeFilm;
    }

    private void setActorList(){
        actorList = filmActorRetriever.getActorsByFilmId(activeFilm.getFilmId());
    }

    public List<Actor> getActorList(){
        return actorList;
    }

}
