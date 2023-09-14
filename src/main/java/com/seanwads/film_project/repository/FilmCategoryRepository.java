package com.seanwads.film_project.repository;

import com.seanwads.film_project.model.FilmCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmCategoryRepository extends JpaRepository<FilmCategory, Integer> {
}
