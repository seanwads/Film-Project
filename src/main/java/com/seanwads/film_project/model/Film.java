package com.seanwads.film_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Year;

@Entity
@Table(name = "film")
public class Film {

    @Id
    private Integer film_id;

    public Integer getFilm_id() {
        return film_id;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    private Year release_year;

    public Year getRelease_year() {
        return release_year;
    }

    private Integer language_id;

    public Integer getLanguage_id() {
        return language_id;
    }


}
