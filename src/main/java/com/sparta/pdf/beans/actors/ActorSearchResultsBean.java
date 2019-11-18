package com.sparta.pdf.beans.actors;

import com.sparta.pdf.components.Actor;
import com.sparta.pdf.components.Film;
import com.sparta.pdf.services.ActorSearcher;
import com.sparta.pdf.services.FilmActorRetriever;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
//@ViewScoped
@ConversationScoped
public class ActorSearchResultsBean implements Serializable {
    @Inject
    private ActorSearcher actorSearcher;
    @Inject
    private FilmActorRetriever filmActorRetriever;
    private List<Actor> searchResults=new ArrayList<>();
    private Map<Actor,List<Film>> films;

    @Inject
    private Conversation conversation;

    public void performSearch(String searchQuery){
        searchResults = actorSearcher.doSearch(searchQuery);
        conversation.begin();
        populateFilms();
    }

    private void populateFilms(){
        films = new HashMap<>();
        for(Actor actor:searchResults){
            films.put(actor,filmActorRetriever.getLimitedFilmsByActorId(actor.getActorId(),5));
        }
    }

    public List<Actor> getSearchResults(){
        return searchResults;
    }


    public Map<Actor,List<Film>> getFilms(){
        return films;
    }


}
