package com.seanwads.film_project.model;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FilmTest {

    @Test
    void setFilm_id() {
        Film film = new Film();
        film.setFilm_id(1);
        assertEquals(film.getFilm_id(), 1);
    }

    @Test
    void setTitle() {
        Film film = new Film();
        film.setTitle("title");
        assertEquals(film.getTitle(), "title");
    }

    @Test
    void setDescription() {
        Film film = new Film();
        film.setDescription("desc");
        assertEquals(film.getDescription(), "desc");
    }

    @Test
    void setReleaseYear() {
        Film film = new Film();
        film.setReleaseYear(2023);
        assertEquals(film.getReleaseYear(), 2023);
    }

    @Test
    void setLanguageId() {
        Film film = new Film();
        film.setLanguageId(1);
        assertEquals(film.getLanguageId(), 1);
    }

    @Test
    void setOriginalLanguageId() {
        Film film = new Film();
        film.setOriginalLanguageId(1);
        assertEquals(film.getOriginalLanguageId(), 1);
    }

    @Test
    void setRentalDuration() {
        Film film = new Film();
        film.setRentalDuration(1);
        assertEquals(film.getRentalDuration(), 1);
    }

    @Test
    void setRentalRate() {
        Film film = new Film();
        film.setRentalRate(1.50);
        assertEquals(film.getRentalRate(), 1.50);
    }

    @Test
    void setLength() {
        Film film = new Film();
        film.setLength(1);
        assertEquals(film.getLength(), 1);
    }

    @Test
    void setReplacementCost() {
        Film film = new Film();
        film.setReplacementCost(1.50);
        assertEquals(film.getReplacementCost(), 1.50);
    }

    @Test
    void setRating() {
        Film film = new Film();
        film.setRating(Rating.R);
        assertEquals(film.getRating(), Rating.R);
    }

    @Test
    void setSpecialFeatures() {
        Film film = new Film();
        film.setSpecialFeatures("Subtitles");
        assertEquals(film.getSpecialFeatures(), "Subtitles");
    }

    @Test
    void setLastUpdate() {
        Film film = new Film();
        film.setLastUpdate(Time.valueOf(LocalTime.now()));
        assertEquals(film.getLastUpdate(), Time.valueOf(LocalTime.now()));
    }

    @Test
    void setCategorySet() {
        FilmCategory filmCategory = new FilmCategory();
        Set<FilmCategory> set = new HashSet<>(List.of(filmCategory));
        Film film = new Film();
        film.setCategorySet(set);
        assertEquals(film.getCategorySet(), set);
    }

    @Test
    void setActors() {
        FilmActor actor = new FilmActor();
        Set<FilmActor> set = new HashSet<>(List.of(actor));
        Film film = new Film();
        film.setActors(set);
        assertEquals(film.getActors(), set);
    }

    @Test
    void testConstructor() {
        Film film = new Film(1, "title", "desc", 2023, 1);

        assertAll(
                () -> assertEquals(film.getFilm_id(), 1),
                () -> assertEquals(film.getTitle(), "title"),
                () -> assertEquals(film.getDescription(), "desc"),
                () -> assertEquals(film.getReleaseYear(), 2023),
                () -> assertEquals(film.getLanguageId(), 1)
        );
    }
}