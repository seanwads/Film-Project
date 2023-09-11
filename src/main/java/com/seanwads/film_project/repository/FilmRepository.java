package com.seanwads.film_project.repository;

import com.seanwads.film_project.model.Film;
import org.springframework.data.repository.CrudRepository;


public interface FilmRepository extends CrudRepository<Film, Integer> {

}
