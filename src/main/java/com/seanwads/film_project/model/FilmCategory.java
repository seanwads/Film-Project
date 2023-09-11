package com.seanwads.film_project.model;

import jakarta.persistence.*;


@Table(name = "film_category")
public class FilmCategory {
    private Integer film_id;

    public Integer getFilm_id() {
        return film_id;
    }

    private Integer category_id;

    public Integer getCategory_id() {
        return category_id;
    }
}
