package com.seanwads.film_project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "film_list")
public class FilmList {

    @Id
    @Column(name="FID")
    private Integer filmId;

    public Integer getFilmId() {
        return filmId;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    private String category;

    public String getCategory() {
        return category;
    }

    private Double price;

    public Double getPrice() {
        return price;
    }

    private String rating;

    public String getRating() {
        return rating;
    }

    private String actors;

    public String getActors() {
        return actors;
    }
}
