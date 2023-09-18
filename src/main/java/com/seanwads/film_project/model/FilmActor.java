package com.seanwads.film_project.model;

import jakarta.persistence.*;

@Entity
@Table(name="film_actor")
public class FilmActor {
    @EmbeddedId
    private FilmActorPK id;

    public FilmActorPK getId() {
        return id;
    }

    public void setId(FilmActorPK id) {
        this.id = id;
    }

    @ManyToOne
    @MapsId("film_id")
    @JoinColumn(name="film_id")
    private Film film;

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @ManyToOne
    @MapsId("actor_id")
    @JoinColumn(name="actor_id")
    private Actor actor;

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
