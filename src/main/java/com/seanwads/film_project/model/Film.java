package com.seanwads.film_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {

    public Film(Integer id, String title, String description, Integer releaseYear, Integer languageId){
        setId(id);
        setTitle(title);
        setDescription(description);
        setReleaseYear(releaseYear);
        setLanguageId(languageId);
    }

    @Id
    @Column(name="film_id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "release_year")
    private Integer releaseYear;

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Column(name = "language_id")
    private Integer languageId;

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    @Column(name = "original_language_id")
    private Integer originalLanguageId;

    public Integer getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Integer originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    @Column(name = "rental_duration")
    private Integer rentalDuration;

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    @Column(name = "rental_rate")
    private Double rentalRate;

    public Double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
    }

    @Column(name = "length")
    private Integer length;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Column(name = "replacement_cost")
    private Double replacementCost;

    public Double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(Double replacementCost) {
        this.replacementCost = replacementCost;
    }

    @Column (columnDefinition = "ENUM('G', 'PG', 'R', 'PG13', NC17)", name = "rating")
    @Enumerated(EnumType.STRING)
    private Rating rating;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Column(name = "special_features")
    private String specialFeatures;

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    @Column(name = "last_update")
    private Time lastUpdate;

    public Time getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Time lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @OneToMany(mappedBy = "filmCat", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, orphanRemoval = true )
    @JsonIgnore
    private Set<FilmCategory> categories = new HashSet<>();

    public Set<FilmCategory> getCategorySet() {
        return categories;
    }

    public void setCategorySet(Set<FilmCategory> categorySet) {
        this.categories = categorySet;
    }


    @OneToMany(mappedBy ="film", cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, orphanRemoval = true )
    @JsonIgnore
    private Set<FilmActor> actors;

    public Set<FilmActor> getActors(){return actors;}
    public void setActors(Set<FilmActor> actors){
        this.actors = actors;
    }




}
