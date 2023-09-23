package com.seanwads.film_project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmCategoryPKTest {

    @Test
    void setFilm_id() {
        FilmCategoryPK pk = new FilmCategoryPK();
        pk.setFilm_id(1);
        assertEquals(pk.getFilm_id(), 1);
    }

    @Test
    void setCategory_id() {
        FilmCategoryPK pk = new FilmCategoryPK();
        pk.setCategory_id(1);
        assertEquals(pk.getCategory_id(), 1);
    }
}