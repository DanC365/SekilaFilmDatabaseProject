package com.sparta.pdf.beans.films;

import com.sparta.pdf.components.Actor;
import com.sparta.pdf.components.Category;
import com.sparta.pdf.components.Film;
import com.sparta.pdf.services.FilmActorRetriever;
import com.sparta.pdf.services.FilmSearcher;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class FilmBean {

    private Film activeFilm;
    private List<Category> filmCategories;
    @Inject
    FilmSearcher filmSearcher;

    public String setActiveFilm(Film film){
        activeFilm = film;
        filmCategories = filmSearcher.getCategories(film.getFilmId());
        return "filmDetails";
    }

    public Film getActiveFilm() {
        return activeFilm;
    }

    public List<Category> getFilmCategories(){
        return filmCategories;
    }


    public String getCategoriesString() {
        String output = "";
        for(int i=0;i<filmCategories.size();i++){
            output+=filmCategories.get(i).getName();
            if(i<filmCategories.size()-1){
                output+="/";
            }

        }
        return output;

    }

}
