package com.seanwads.film_project.controller;

import com.seanwads.film_project.model.Film;
import com.seanwads.film_project.model.FilmList;
import com.seanwads.film_project.model.Rating;
import com.seanwads.film_project.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping(path="/demo")
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;

    @GetMapping(path="/allFilms")
    public @ResponseBody Iterable<FilmList> getAllFilms() {
        return filmRepository.findAll();
    }

    @GetMapping(path="/getFilmByID")
    public @ResponseBody Optional<FilmList> getFilmByID(@RequestParam Integer id){
        return filmRepository.findById(id);
    }

    @GetMapping(path="/deleteFilmByID")
    public @ResponseBody String deleteFilmByID(@RequestParam Integer id){
        if(getFilmByID(id).isPresent()){
            FilmList filmToDelete = getFilmByID(id).get();
            String filmTitle = filmToDelete.getTitle();

            filmRepository.deleteById(id);
            return "Film: " + filmTitle + " has been deleted";
        }
        else{
            return "Requested film not found";
        }
    }

//    @PostMapping(path="/addFilm")
//    public @ResponseBody Optional<FilmList> addFilm(@RequestParam Integer id, @RequestParam String title,
//                                                    @RequestParam String description, @RequestParam String category,
//                                                    @RequestParam Double price, @RequestParam Rating rating,
//                                                    @RequestParam String actors){
//        FilmList film = new FilmList();
//        film.setFilmId(id);
//        film.setTitle(title);
//        film.setDescription(description);
//        film.setCategory(category);
//        film.setPrice(price);
//        film.setRating(rating);
//        film.setActors(actors);
//
//        filmRepository.save(film);
//
//        return getFilmByID(id);
//    }
}
