package com.seanwads.film_project.repository;

import com.seanwads.film_project.model.film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface FilmRepository extends CrudRepository<film, Long> {

}
