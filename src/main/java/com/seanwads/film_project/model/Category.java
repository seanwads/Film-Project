package com.seanwads.film_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name="category")
public class Category {
    @Id
    @Column(name="category_id")
    private Integer category_id;

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    @Column(name="name")
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "last_update")
    private Time lastUpdate;

    public void setLastUpdate(Time lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @OneToMany(mappedBy = "categoryCat", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JsonIgnore
    private Set<FilmCategory> filmSet = new HashSet<>();

    public void setFilmSet(Set<FilmCategory> filmSet) {
        this.filmSet = filmSet;
    }
}