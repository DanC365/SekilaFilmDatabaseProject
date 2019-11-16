package com.sparta.pdf.beans;

import com.sparta.pdf.components.Film;
import com.sparta.pdf.services.FilmSearcher;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class FilmSearchResultsBean implements Serializable {
    @Inject
    private FilmSearcher filmSearcher;
    private List<Film> searchResults=new ArrayList<>();


    public void performSearch(String searchQuery){
        searchResults = filmSearcher.doSearch(searchQuery);
    }

    public List<Film> getSearchResults(){
        return searchResults;
    }
}
