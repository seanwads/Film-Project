package com.seanwads.film_project.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class FilmCategoryPK implements Serializable {

    @Column(name="film_id")
    private Integer film_id;

    public Integer getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Integer film_id) {
        this.film_id = film_id;
    }

    @Column(name="category_id")
    private Integer category_id;

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
