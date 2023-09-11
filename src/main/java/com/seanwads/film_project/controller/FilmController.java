package com.seanwads.film_project.controller;

import com.seanwads.film_project.model.Film;
import com.seanwads.film_project.model.FilmList;
import com.seanwads.film_project.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<FilmList> getAllFilms() {
        return filmRepository.findAll();
    }
}
