package com.seanwads.film_project.model;

import jakarta.persistence.*;


@Table(name = "film_category")
public class FilmCategory {

    @ManyToOne
    @JoinColumn(name="film_id", nullable = false)
    private Film film;

    public Film getFilm() {
        return film;
    }

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    public Category getCategory() { return category; }
}
