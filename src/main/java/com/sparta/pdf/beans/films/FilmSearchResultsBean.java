package com.sparta.pdf.beans.films;

import com.sparta.pdf.components.Actor;
import com.sparta.pdf.components.Film;
import com.sparta.pdf.services.FilmActorRetriever;
import com.sparta.pdf.services.FilmSearcher;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
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
public class FilmSearchResultsBean implements Serializable {
    @Inject
    private FilmSearcher filmSearcher;
    @Inject
    private FilmActorRetriever filmActorRetriever;
    private List<Film> searchResults=new ArrayList<>();
    private Map<Film,List<Actor>> actors;
    //private Map<Film,List<Category>> categories;

    @Inject
    private Conversation conversation;

    public void performSearch(String searchQuery){
        searchResults = filmSearcher.doSearch(searchQuery);
        conversation.begin();
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

    public String getCategoriesString(Film film) {
        String output = "";

        for(int i=0;i<film.getCategories().size();i++){
            output+=film.getCategories().get(i).getName();
            if(i<film.getCategories().size()-1){
                output+="/";
            }

        }
        return output;

    }
}
