package com.seanwads.film_project.controller;

import com.seanwads.film_project.model.FilmCategory;
import com.seanwads.film_project.repository.FilmCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class FilmCategoryController {

    @Autowired
    private FilmCategoryRepository filmCategoryRepository;

}
