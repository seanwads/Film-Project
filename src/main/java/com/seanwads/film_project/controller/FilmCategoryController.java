package com.seanwads.film_project.controller;

import com.seanwads.film_project.model.FilmCategory;
import com.seanwads.film_project.repository.FilmCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class FilmCategoryController {

    @Autowired
    private FilmCategoryRepository filmCategoryRepository;

    @RequestMapping("/getFilmCats")
    private @ResponseBody Iterable<FilmCategory> getFilmCats(){
        return filmCategoryRepository.findAll();
    }
}
