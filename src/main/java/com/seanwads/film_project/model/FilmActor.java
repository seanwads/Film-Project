package com.seanwads.film_project.model;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="film_actor")
public class FilmActor {
    @EmbeddedId
    private FilmActorPK id;

    @ManyToOne
    @MapsId("film_id")
    @JoinColumn(name="film_id")
    private Film film;

    @ManyToOne
    @MapsId("actor_id")
    @JoinColumn(name="actor_id")
    private Actor actor;

    public void setId(FilmActorPK id) {
        this.id = id;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
