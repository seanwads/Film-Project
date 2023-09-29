package com.seanwads.film_project.model;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void setCategory_id() {
        Category cat = new Category();
        cat.setCategoryId(1);
        assertEquals(1, cat.getCategoryId());
    }

    @Test
    void setName() {
        Category cat = new Category();
        cat.setName("name");
        assertEquals("name", cat.getName());
    }

    @Test
    void setLastUpdate() {
        Category cat = new Category();
        cat.setLastUpdate(Time.valueOf(LocalTime.now()));
        assertEquals(Time.valueOf(LocalTime.now()), cat.getLastUpdate());
    }

    @Test
    void setFilmSet() {
        FilmCategory filmCategory = new FilmCategory();
        Set<FilmCategory> set = new HashSet<>(List.of(filmCategory));
        Category cat = new Category();
        cat.setFilmSet(set);
        assertEquals(set, cat.getFilmSet());
    }
}