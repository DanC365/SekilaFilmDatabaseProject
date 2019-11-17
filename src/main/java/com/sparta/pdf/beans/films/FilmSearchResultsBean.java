package com.sparta.pdf.beans.films;

import com.sparta.pdf.components.Actor;
import com.sparta.pdf.components.Category;
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
    private Map<Film,List<Category>> categories;

    public void performSearch(String searchQuery){
        searchResults = filmSearcher.doSearch(searchQuery);
        populateActors();
        populateCategories();
    }

    public Map<Film, List<Category>> getCategories() {
        return categories;
    }



    private void populateCategories() {
        categories = new HashMap<>();
        for(Film film:searchResults){
            categories.put(film,filmSearcher.getCategories(film.getFilmId()));
        }
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
        List<Category> categoryList = categories.get(film);
        for(int i=0;i<categoryList.size();i++){
            output+=categoryList.get(i).getName();
            if(i<categoryList.size()-1){
                output+="/";
            }

        }
        return output;

    }
}
