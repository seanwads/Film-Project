package com.seanwads.film_project.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.sql.Time;

@Getter
@Entity
@Table(name = "film_category")
public class FilmCategory implements Serializable {

    @EmbeddedId
    private FilmCategoryPK id;

    @ManyToOne
    @MapsId("film_id")
    @JoinColumn(name="film_id")
    private Film filmCat;

    @ManyToOne
    @MapsId("category_id")
    @JoinColumn(name="category_id")
    private Category categoryCat;

    @Column(name = "last_update")
    private Time lastUpdate;

    public void setFilmCat(Film filmCat) {
        this.filmCat = filmCat;
    }

    public void setCategoryCat(Category categoryCat) {
        this.categoryCat = categoryCat;
    }

    public void setId(FilmCategoryPK id) {
        this.id = id;
    }

    public void setLastUpdate(Time lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
