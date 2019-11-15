package com.sparta.pdf.beans;

import com.sparta.pdf.components.Film;
import com.sparta.pdf.services.FilmSearcher;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class FilmListBean {
    @Inject
    private FilmSearcher filmSearcher;
    private String searchQuery="";
    private List<Film> searchResults;



    public String performSearch(){
        searchResults = filmSearcher.doSearch(searchQuery);
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
