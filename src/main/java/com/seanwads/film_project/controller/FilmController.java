package com.seanwads.film_project.controller;

import com.seanwads.film_project.model.Film;
import com.seanwads.film_project.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping(path="/demo")
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;

    @GetMapping(path="/allFilms")
    public @ResponseBody Iterable<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @GetMapping(path="/getFilmByID")
    public @ResponseBody Optional<Film> getFilmByID(@RequestParam Integer id){
        return filmRepository.findById(id);
    }

    @GetMapping(path="/deleteFilmByID")
    public @ResponseBody String deleteFilmByID(@RequestParam Integer id){
        if(getFilmByID(id).isPresent()){
            Film filmToDelete = getFilmByID(id).get();
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
