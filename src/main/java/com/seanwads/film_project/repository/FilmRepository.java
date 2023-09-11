package com.seanwads.film_project.repository;

import com.seanwads.film_project.model.Film;
import com.seanwads.film_project.model.FilmList;
import org.springframework.data.repository.CrudRepository;


public interface FilmRepository extends CrudRepository<FilmList, Integer> {

}
