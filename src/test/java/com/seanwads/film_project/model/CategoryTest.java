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
        cat.setCategory_id(1);
        assertEquals(cat.getCategory_id(), 1);
    }

    @Test
    void setName() {
        Category cat = new Category();
        cat.setName("name");
        assertEquals(cat.getName(), "name");
    }

    @Test
    void setLastUpdate() {
        Category cat = new Category();
        cat.setLastUpdate(Time.valueOf(LocalTime.now()));
        assertEquals(cat.getLastUpdate(), Time.valueOf(LocalTime.now()));
    }

    @Test
    void setFilmSet() {
        FilmCategory filmCategory = new FilmCategory();
        Set<FilmCategory> set = new HashSet<>(List.of(filmCategory));
        Category cat = new Category();
        cat.setFilmSet(set);
        assertEquals(cat.getFilmSet(), set);
    }
}