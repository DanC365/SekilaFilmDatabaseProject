package com.sparta.pdf.beans;

import com.sparta.pdf.components.Film;
import com.sparta.pdf.services.FilmSearcher;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class FilmListBean{

    @Inject
    private FilmSearcher filmSearcher;
    private List<Film> searchResults=new ArrayList<>();
    private String searchQuery="";


    public String performSearch(){
        //searchResults = filmSearcher.doSearch(searchQuery);
        return "filmResultsPage";
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public List<Film> getSearchResults() {
        return searchResults;
    }

//    public void setSearchResults(List<Film> searchResults) {
//        this.searchResults = searchResults;
//    }
}
