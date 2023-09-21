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
@RequestMapping(path="/demo")
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;

    @GetMapping(path = "/allFilms")
    public @ResponseBody Iterable<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @GetMapping(path = "/getFilmByID")
    public @ResponseBody Optional<Film> getFilmByID(@RequestParam Integer id) {

        return filmRepository.findById(id);
    }

    @GetMapping(path = "/filterFilmsByCategory")
    public @ResponseBody Iterable<Film> filterFilm(@RequestParam Integer id) {

        if (id == 0) {
            return getAllFilms();
        } else {
            Iterable<Film> filmIterable = getAllFilms();
            List<Film> filmList = new ArrayList<Film>();
            filmIterable.forEach(filmList::add);

            List<Film> filmsToRemove = new ArrayList<Film>();

            for (Film film : filmList) {

                Set<FilmCategory> filmCategories = film.getCategorySet();

                boolean hasFilterCategory = false;

                for (FilmCategory filmCat : filmCategories) {
                    Category category = filmCat.getCategoryCat();

                    if (category.getId().equals(id)) {
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

    @GetMapping(path = "/deleteFilmByID")
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

    @PostMapping(path="/createFilm")
    public @ResponseBody Optional<Film> createFilm(@RequestBody Film filmParam){
        try{
            Film film = filmRepository.save(new Film(filmParam.getId(), filmParam.getTitle(), filmParam.getDescription(), filmParam.getReleaseYear(), filmParam.getLanguageId()));

            if(getFilmByID(film.getId()).isPresent()){
                return Optional.of(film);
            }
            else{
                return Optional.empty();
            }

        } catch (Exception e){
            return Optional.empty();
        }
    }

    @GetMapping(path="/nextID")
    public @ResponseBody Integer nextId(){
        Iterable<Film> films = getAllFilms();
        List<Film> filmList = new ArrayList<Film>();
        films.forEach(filmList::add);

        Film lastFilm = filmList.get(filmList.size() - 1);
        Integer lastId = lastFilm.getId();

        return lastId + 1;
    }

    @DeleteMapping(path="/deleteFilm")
    public @ResponseBody Optional<Film> deleteFilm(@RequestParam Integer id){

        if(getFilmByID(id).isPresent()){

            Film film = getFilmByID(id).get();
            film.detachCategories();
            film.detachActors();
            filmRepository.deleteById(id);

            Optional<Film> deletedFilm = getFilmByID(id);

            if(deletedFilm.isEmpty()){
                return deletedFilm;
            }
            else{
                return Optional.empty();
            }
        }
        else{
            return Optional.empty();
        }
    }

    @PutMapping(path="/updateFilm")
    public @ResponseBody Optional<Film> updateFilm(@RequestBody Film filmParam){
        Optional<Film> filmOptional = getFilmByID(filmParam.getId());

        if(filmOptional.isPresent()){
            Film film = filmOptional.get();
            film.setTitle(filmParam.getTitle());
            filmRepository.save(film);
            return Optional.of(film);
        }
        else {
            return Optional.empty();
        }
    }
}
