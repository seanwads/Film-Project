package com.seanwads.film_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class film {

    @Id
    private Long film_id;

    public Long getFilm_id() {
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
}
