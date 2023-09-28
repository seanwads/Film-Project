package com.seanwads.film_project.controller;

import com.seanwads.film_project.model.Category;
import com.seanwads.film_project.model.Film;
import com.seanwads.film_project.model.FilmCategory;
import com.seanwads.film_project.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public @ResponseBody Iterable<Film> defaultMethod() {return filmRepository.findAll();}

    @RequestMapping(path = "/allFilms", method = RequestMethod.GET)
    public @ResponseBody Iterable<Film> getAllFilms() {return filmRepository.findAll();}

    @RequestMapping(path = "/getFilmByID", method = RequestMethod.GET)
    public @ResponseBody Optional<Film> getFilmByID(@RequestParam Integer id) {return filmRepository.findById(id);}

    @RequestMapping(path = "/filterFilmsByCategory", method = RequestMethod.GET)
    public @ResponseBody Iterable<Film> filterFilm(@RequestParam Integer id) {

        if (id == 0) {
            return filmRepository.findAll();
        }
        else {

            Iterable<Film> filmIterable = getAllFilms();
            List<Film> filmList = new ArrayList<Film>();
            filmIterable.forEach(filmList::add);

            List<Film> filmsToRemove = new ArrayList<Film>();

            for (Film film : filmList) {

                Set<FilmCategory> filmCategories = film.getCategorySet();

                boolean hasFilterCategory = false;

                for (FilmCategory filmCat : filmCategories) {
                    Category category = filmCat.getCategoryCat();

                    if (category.getCategory_id() == id ) {
                        hasFilterCategory = true;
                    }
                }

                if (!hasFilterCategory) {
                    filmsToRemove.add(film);
                }

            }

            filmList.removeAll(filmsToRemove);
            return filmList;
        }
    }

    @RequestMapping(path = "/deleteFilmByID", method = RequestMethod.DELETE)
    public @ResponseBody String deleteFilmByID(@RequestParam Integer id) {
        if (getFilmByID(id).isPresent()) {
            Film filmToDelete = getFilmByID(id).get();
            String filmTitle = filmToDelete.getTitle();

            filmRepository.deleteById(id);
            return "Film: " + filmTitle + " has been deleted";
        } else {
            return "Requested film not found";
        }
    }

    @RequestMapping(path="/createFilm", method = RequestMethod.POST)
    public @ResponseBody Optional<Film> createFilm(@RequestBody Film filmParam){
        try{
            Film film = filmRepository.save(new Film(filmParam.getFilm_id(), filmParam.getTitle(), filmParam.getDescription(), filmParam.getReleaseYear(), filmParam.getLanguageId()));

            if(getFilmByID(film.getFilm_id()).isPresent()){
                return Optional.of(film);
            }
            else{
                return Optional.empty();
            }

        } catch (Exception e){
            return Optional.empty();
        }
    }

    @RequestMapping(path="/updateFilm", method = RequestMethod.PUT)
    public @ResponseBody Optional<Film> updateFilm(@RequestBody Film filmParam){
        Optional<Film> filmOptional = getFilmByID(filmParam.getFilm_id());

        if(filmOptional.isPresent()){
            Film film = filmOptional.get();
            film.setTitle(filmParam.getTitle());
            film.setDescription(filmParam.getDescription());
            filmRepository.save(film);
            return Optional.of(film);
        }
        else {
            return Optional.empty();
        }
    }
}
