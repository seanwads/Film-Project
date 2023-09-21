package com.seanwads.film_project.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "film_category")
public class FilmCategory implements Serializable {

    @EmbeddedId
    private FilmCategoryPK id;

    public FilmCategoryPK getId() {
        return id;
    }

    public void setCategoryCat(Category categoryCat) {
        this.categoryCat = categoryCat;
    }

    @ManyToOne
    @MapsId("film_id")
    @JoinColumn(name="film_id")
    private Film filmCat;

    public Film getFilmCat() {
        return filmCat;
    }

    public void setFilmCat(Film filmCat) {
        this.filmCat = filmCat;
    }

    @ManyToOne
    @MapsId("category_id")
    @JoinColumn(name="category_id")
    private Category categoryCat;

    public Category getCategoryCat() {
        return categoryCat;
    }

    public void setId(FilmCategoryPK id) {
        this.id = id;
    }

    @Column(name = "last_update")
    private Time lastUpdate;

    public Time getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Time lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
