package com.seanwads.film_project.repository;

import com.seanwads.film_project.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FilmRepository extends JpaRepository<Film, Integer> {

}
