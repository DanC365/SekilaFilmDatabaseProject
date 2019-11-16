package com.sparta.pdf.beans;

import com.sparta.pdf.components.Actor;
import com.sparta.pdf.components.Film;
import com.sparta.pdf.services.FilmActorRetriever;
import com.sparta.pdf.services.FilmSearcher;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class FilmSearchResultsBean implements Serializable {
    @Inject
    private FilmSearcher filmSearcher;
    @Inject
    private FilmActorRetriever filmActorRetriever;
    private List<Film> searchResults=new ArrayList<>();
    private Map<Film,List<Actor>> actors;

    public void performSearch(String searchQuery){
        searchResults = filmSearcher.doSearch(searchQuery);
        populateActors();
    }

    private void populateActors(){
        actors = new HashMap<>();
        for(Film film:searchResults){
            actors.put(film,filmActorRetriever.getLimitedActorsByFilmId(film.getFilmId(),5));
        }
    }

    public List<Film> getSearchResults(){
        return searchResults;
    }


    public Map<Film,List<Actor>> getActors(){
        return actors;
    }
}
