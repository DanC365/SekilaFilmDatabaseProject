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
    @Inject
    FilmSearcher filmSearcher;

    public String setActiveFilm(Film film){
        activeFilm = film;
        return "filmDetails";
    }

    public Film getActiveFilm() {
        return activeFilm;
    }




    public String getCategoriesString() {
        String output = "";

        for(int i=0;i<activeFilm.getCategories().size();i++){
            output+=activeFilm.getCategories().get(i).getName();
            if(i<activeFilm.getCategories().size()-1){
                output+="/";
            }

        }
        return output;

    }

}
