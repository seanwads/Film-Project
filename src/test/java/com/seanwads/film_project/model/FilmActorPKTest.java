package com.seanwads.film_project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmActorPKTest {

    @Test
    void setFilmId() {
        FilmActorPK pk = new FilmActorPK();
        pk.setFilmId(1);
        assertEquals(1, pk.getFilmId());
    }

    @Test
    void setActorId() {
        FilmActorPK pk = new FilmActorPK();
        pk.setActorId(1);
        assertEquals(1, pk.getActorId());
    }
}