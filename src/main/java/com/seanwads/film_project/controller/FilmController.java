package com.seanwads.film_project.controller;

import com.seanwads.film_project.model.Film;
import com.seanwads.film_project.model.FilmList;
import com.seanwads.film_project.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/demo")
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<FilmList> getAllFilms() {
        return filmRepository.findAll();
    }

    @GetMapping(path="/getID")
    public @ResponseBody Optional<FilmList> getFilmByID(@RequestParam Integer id){
        return filmRepository.findById(id);
    }

    @GetMapping(path="/delete")
    public @ResponseBody String deleteFilm (@RequestParam Integer id){
        if(filmRepository.findById(id).isPresent()){
            FilmList filmToDelete = filmRepository.findById(id).get();
            String filmName = filmToDelete.getTitle();
            filmRepository.deleteById(id);
            return "Film: " + filmName + " deleted";
        }
        else {
            return "Requested film not found";
        }
    }
}
