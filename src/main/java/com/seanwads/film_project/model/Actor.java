package com.seanwads.film_project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name="actor")
public class Actor {

    @Id
    @Column(name="actor_id")
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }
}
