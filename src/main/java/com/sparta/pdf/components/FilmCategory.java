package com.sparta.pdf.components;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "film_category")
@NamedQuery(
        name = "getFilmCategories",
        query = "SELECT a FROM Category a JOIN FilmCategory b ON b.categoryId = a.categoryId WHERE b.filmId = :filmId"
)
@Deprecated
public class FilmCategory {
    @Id
    @Column(name = "film_id")
    private int filmId;
    @Id
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "last_update")
    private LocalDateTime  lastUpdate;


    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
