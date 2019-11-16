package com.sparta.pdf.beans.films;

import com.sparta.pdf.components.Actor;
import com.sparta.pdf.components.Film;
import com.sparta.pdf.services.FilmActorRetriever;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class FilmActorBean implements Serializable {

    private List<Actor> actorList;
    @Inject
    FilmActorRetriever filmActorRetriever;

    public void setActorList(Film film){
        actorList = filmActorRetriever.getActorsByFilmId(film.getFilmId());
    }

    public List<Actor> getActorList(){
        return actorList;
    }
}
