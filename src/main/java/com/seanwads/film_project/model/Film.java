package com.seanwads.film_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @Column(name="film_id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Year release_year;

    public Year getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Year release_year) {
        this.release_year = release_year;
    }

    private Integer language_id;

    public Integer getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(Integer language_id) {
        this.language_id = language_id;
    }

    private Integer original_language_id;

    public Integer getOriginal_language_id() {
        return original_language_id;
    }

    public void setOriginal_language_id(Integer original_language_id) {
        this.original_language_id = original_language_id;
    }

    private Integer rental_duration;

    public Integer getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(Integer rental_duration) {
        this.rental_duration = rental_duration;
    }

    private Double rental_rate;

    public Double getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(Double rental_rate) {
        this.rental_rate = rental_rate;
    }

    private Integer length;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    private Double replacement_cost;

    public Double getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(Double replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    @Column (columnDefinition = "ENUM('G', 'PG', 'R', 'PG13', NC17)")
    @Enumerated(EnumType.STRING)
    private Rating rating;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    private String special_features;

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }

    private Time last_update;

    public Time getLast_update() {
        return last_update;
    }

    public void setLast_update(Time last_update) {
        this.last_update = last_update;
    }

    @OneToMany(mappedBy = "filmCat")
    @JsonIgnore
    private Set<FilmCategory> categorySet = new HashSet<>();

    public Set<FilmCategory> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<FilmCategory> categorySet) {
        this.categorySet = categorySet;
    }
}
