package com.seanwads.film_project.repository;

import com.seanwads.film_project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
