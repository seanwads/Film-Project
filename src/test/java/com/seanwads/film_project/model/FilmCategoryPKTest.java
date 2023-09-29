package com.seanwads.film_project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmCategoryPKTest {

    @Test
    void setFilm_id() {
        FilmCategoryPK pk = new FilmCategoryPK();
        pk.setFilm_id(1);
        assertEquals(1, pk.getFilm_id());
    }

    @Test
    void setCategory_id() {
        FilmCategoryPK pk = new FilmCategoryPK();
        pk.setCategory_id(1);
        assertEquals(1, pk.getCategory_id());
    }
}