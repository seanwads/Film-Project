package com.seanwads.film_project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Embeddable
public class FilmActorPK implements Serializable {

    @Column(name="film_id")
    private Integer filmId;

    @Column(name="actor_id")
    private Integer actorId;

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }


    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }
}
