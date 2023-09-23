package com.seanwads.film_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "film")
public class Film {

    public Film(Integer film_id, String title, String description, Integer releaseYear, Integer languageId){
        setFilm_id(film_id);
        setTitle(title);
        setDescription(description);
        setReleaseYear(releaseYear);
        setLanguageId(languageId);
    }

    public Film(){

    }

    @Id
    @Column(name="film_id")
    private Integer film_id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "language_id")
    private Integer languageId;

    @Column(name = "original_language_id")
    private Integer originalLanguageId;

    @Column(name = "rental_duration")
    private Integer rentalDuration;

    @Column(name = "rental_rate")
    private Double rentalRate;

    @Column(name = "replacement_cost")
    private Double replacementCost;

    @Column (columnDefinition = "ENUM('G', 'PG', 'R', 'PG13', NC17)", name = "rating")
    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column(name = "length")
    private Integer length;

    @Column(name = "special_features")
    private String specialFeatures;

    @Column(name = "last_update")
    private Time lastUpdate;

    @OneToMany(mappedBy = "filmCat", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, orphanRemoval = true )
    @JsonIgnore
    private Set<FilmCategory> categorySet = new HashSet<>();

    @OneToMany(mappedBy ="film", cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, orphanRemoval = true )
    @JsonIgnore
    private Set<FilmActor> actors;


    public void setFilm_id(Integer film_id) {
        this.film_id = film_id;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }


    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }


    public void setOriginalLanguageId(Integer originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }


    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }


    public void setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
    }


    public void setLength(Integer length) {
        this.length = length;
    }


    public void setReplacementCost(Double replacementCost) {
        this.replacementCost = replacementCost;
    }


    public void setRating(Rating rating) {
        this.rating = rating;
    }


    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }


    public void setLastUpdate(Time lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    public void setCategorySet(Set<FilmCategory> categorySet) {
        this.categorySet = categorySet;
    }


    public void setActors(Set<FilmActor> actors){
        this.actors = actors;
    }




}
