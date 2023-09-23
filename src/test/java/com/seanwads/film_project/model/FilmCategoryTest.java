package com.seanwads.film_project.model;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class FilmCategoryTest {

    @Test
    void setCategoryCat() {
        FilmCategory filmCategory = new FilmCategory();
        Category category = new Category();
        filmCategory.setCategoryCat(category);
        assertEquals(filmCategory.getCategoryCat(), category);
    }

    @Test
    void setFilmCat() {
        FilmCategory filmCategory = new FilmCategory();
        Film film = new Film();
        filmCategory.setFilmCat(film);
        assertEquals(filmCategory.getFilmCat(), film);
    }

    @Test
    void setId() {
        FilmCategory filmCategory = new FilmCategory();
        FilmCategoryPK pk = new FilmCategoryPK();
        filmCategory.setId(pk);
        assertEquals(filmCategory.getId(), pk);
    }

    @Test
    void setLastUpdate() {
        FilmCategory filmCategory = new FilmCategory();
        filmCategory.setLastUpdate(Time.valueOf(LocalTime.now()));
        assertEquals(filmCategory.getLastUpdate(), Time.valueOf(LocalTime.now()));
    }
}