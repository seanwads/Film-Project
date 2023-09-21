package com.seanwads.film_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="category")
public class Category {
    @Id
    @Column(name="category_id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "last_update")
    private Time lastUpdate;

    public Time getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Time lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @OneToMany(mappedBy = "categoryCat", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JsonIgnore
    private Set<FilmCategory> filmSet = new HashSet<>();

    public Set<FilmCategory> getFilmSet() {
        return filmSet;
    }

    public void setFilmSet(Set<FilmCategory> filmSet) {
        this.filmSet = filmSet;
    }
}