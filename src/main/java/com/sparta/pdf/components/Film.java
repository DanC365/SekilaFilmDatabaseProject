package com.sparta.pdf.components;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "film")
@NamedQueries({
        @NamedQuery(

                name = "getFilmByName",
                query = "SELECT a FROM Film a WHERE a.title LIKE CONCAT('%',:searchTitle,'%') "
        )
})

public class Film {

    @Id
    @Column(name = "film_id")
    private int filmId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "release_year")
    private int releaseYear;
    //language id
    @Column(name = "rental_duration")
    private int rentalDuration;
    @Column(name = "rental_rate")
    private double rentalRate;
    @Column(name = "Length")
    private int length;
    @Column(name = "replacement_cost")
    private double replacementCost;
    @Column(name = "rating")
    private String ageRating;
    @Column(name = "special_features")
    private String specialFeatures;
    @Column(name = "last_update")
    private LocalDateTime lastUpdated;

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
