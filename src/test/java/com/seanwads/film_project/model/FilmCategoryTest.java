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
        assertEquals(category, filmCategory.getCategoryCat());
    }

    @Test
    void setFilmCat() {
        FilmCategory filmCategory = new FilmCategory();
        Film film = new Film();
        filmCategory.setFilmCat(film);
        assertEquals(film, filmCategory.getFilmCat());
    }

    @Test
    void setId() {
        FilmCategory filmCategory = new FilmCategory();
        FilmCategoryPK pk = new FilmCategoryPK();
        filmCategory.setId(pk);
        assertEquals(pk, filmCategory.getId());
    }

    @Test
    void setLastUpdate() {
        FilmCategory filmCategory = new FilmCategory();
        filmCategory.setLastUpdate(Time.valueOf(LocalTime.now()));
        assertEquals(Time.valueOf(LocalTime.now()), filmCategory.getLastUpdate());
    }
}