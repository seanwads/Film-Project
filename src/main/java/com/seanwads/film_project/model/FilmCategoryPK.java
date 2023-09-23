package com.seanwads.film_project.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Embeddable
public class FilmCategoryPK implements Serializable {

    @Column(name="film_id")
    private Integer film_id;

    @Column(name="category_id")
    private Integer category_id;

    public void setFilm_id(Integer film_id) {
        this.film_id = film_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
