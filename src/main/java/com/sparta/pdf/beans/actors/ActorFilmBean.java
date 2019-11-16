package com.sparta.pdf.beans.actors;

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
public class ActorFilmBean implements Serializable {
    private List<Film> filmList;
    @Inject
    FilmActorRetriever filmActorRetriever;

    public void setFilmList(Actor actor){
        filmList = filmActorRetriever.getFilmsByActorId(actor.getActorId());
    }

    public List<Film> getFilmList(){
        return filmList;
    }

}
