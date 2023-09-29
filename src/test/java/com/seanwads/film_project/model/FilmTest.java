package com.seanwads.film_project.model;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FilmTest {

    @Test
    void setFilm_id() {
        Film film = new Film();
        film.setFilmId(1);
        assertEquals(1, film.getFilmId());
    }

    @Test
    void setTitle() {
        Film film = new Film();
        film.setTitle("title");
        assertEquals("title", film.getTitle());
    }

    @Test
    void setDescription() {
        Film film = new Film();
        film.setDescription("desc");
        assertEquals("desc", film.getDescription());
    }

    @Test
    void setReleaseYear() {
        Film film = new Film();
        film.setReleaseYear(2023);
        assertEquals(2023, film.getReleaseYear());
    }

    @Test
    void setLanguageId() {
        Film film = new Film();
        film.setLanguageId(1);
        assertEquals(1, film.getLanguageId());
    }

    @Test
    void setOriginalLanguageId() {
        Film film = new Film();
        film.setOriginalLanguageId(1);
        assertEquals(1, film.getOriginalLanguageId());
    }

    @Test
    void setRentalDuration() {
        Film film = new Film();
        film.setRentalDuration(1);
        assertEquals(1, film.getRentalDuration());
    }

    @Test
    void setRentalRate() {
        Film film = new Film();
        film.setRentalRate(1.50);
        assertEquals(1.50, film.getRentalRate());
    }

    @Test
    void setLength() {
        Film film = new Film();
        film.setLength(1);
        assertEquals(1, film.getLength());
    }

    @Test
    void setReplacementCost() {
        Film film = new Film();
        film.setReplacementCost(1.50);
        assertEquals(1.50, film.getReplacementCost());
    }

    @Test
    void setRating() {
        Film film = new Film();
        film.setRating(Rating.R);
        assertEquals(Rating.R, film.getRating());
    }

    @Test
    void setSpecialFeatures() {
        Film film = new Film();
        film.setSpecialFeatures("Subtitles");
        assertEquals("Subtitles", film.getSpecialFeatures());
    }

    @Test
    void setLastUpdate() {
        Film film = new Film();
        film.setLastUpdate(Time.valueOf(LocalTime.now()));
        assertEquals(Time.valueOf(LocalTime.now()), film.getLastUpdate());
    }

    @Test
    void setCategorySet() {
        FilmCategory filmCategory = new FilmCategory();
        Set<FilmCategory> set = new HashSet<>(List.of(filmCategory));
        Film film = new Film();
        film.setCategorySet(set);
        assertEquals(set, film.getCategorySet());
    }

    @Test
    void setActors() {
        FilmActor actor = new FilmActor();
        Set<FilmActor> set = new HashSet<>(List.of(actor));
        Film film = new Film();
        film.setActors(set);
        assertEquals(set, film.getActors());
    }

    @Test
    void testConstructor() {
        Film film = new Film(1, "title", "desc", 2023, 1);

        assertAll(
                () -> assertEquals(film.getFilmId(), 1),
                () -> assertEquals(film.getTitle(), "title"),
                () -> assertEquals(film.getDescription(), "desc"),
                () -> assertEquals(film.getReleaseYear(), 2023),
                () -> assertEquals(film.getLanguageId(), 1)
        );
    }
}