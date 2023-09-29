package com.seanwads.film_project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmActorTest {

    @Test
    void setId() {
        FilmActor filmActor = new FilmActor();
        FilmActorPK pk = new FilmActorPK();
        filmActor.setId(pk);
        assertEquals(pk,filmActor.getId());
    }

    @Test
    void setFilm() {
        FilmActor filmActor = new FilmActor();
        Film film = new Film();
        filmActor.setFilm(film);
        assertEquals(film, filmActor.getFilm());
    }

    @Test
    void setActor() {
        FilmActor filmActor = new FilmActor();
        Actor actor = new Actor();
        filmActor.setActor(actor);
        assertEquals(actor, filmActor.getActor());
    }
}