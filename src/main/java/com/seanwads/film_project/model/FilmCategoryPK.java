package com.seanwads.film_project.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class FilmCategoryPK implements Serializable {

    @Column(name="film_id")
    private Integer filmId;

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    @Column(name="category_id")
    private Integer categoryId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
