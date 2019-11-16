package com.sparta.pdf.beans.films;

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
    @Inject
    FilmActorRetriever filmActorRetriever;

    public String setActiveFilm(Film film){
        activeFilm = film;
        return "filmDetails";
    }

    public Film getActiveFilm() {
        return activeFilm;
    }



}
