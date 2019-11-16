package com.sparta.pdf.components;


import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "film_actor")
@Entity
@NamedQueries({
        @NamedQuery(
                name = "getActorsByFilmId",
                query = "SELECT a FROM Actor a JOIN FilmActor b ON b.actorId=a.actorId WHERE b.filmId = :filmId"
        ),
        @NamedQuery(
                name = "getFilmsByActorId",
                query = "SELECT a FROM Film a JOIN FilmActor b ON b.filmId=a.filmId WHERE b.actorId = :actorId"
        )
})
public class FilmActor {
    @Id
    @Column(name = "actor_id")
    private int actorId;
    @Id
    @Column(name = "film_id")
    private int filmId;
    @Column(name = "last_update")
    private LocalDateTime lastUpdated;

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
