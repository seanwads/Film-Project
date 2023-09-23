package com.seanwads.film_project.controller;

import com.seanwads.film_project.model.Category;
import com.seanwads.film_project.model.Film;
import com.seanwads.film_project.model.FilmCategory;
import com.seanwads.film_project.repository.FilmRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class FilmControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    FilmController filmController;

    @MockBean
    FilmRepository filmRepository;


    @Test
    void testGetAllFilms() throws Exception {
        Film film1 = new Film(1, "ABSOLUTE DINOSAUR", "A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies", 2006, 1);

        Film film2 = new Film(2, "ACE ADMINISTRATOR", "A Astounding Epistle of a Database Administrator And a Explorer who must Find a Car in Ancient China", 2006, 1);

        doReturn(Lists.newArrayList(film1, film2)).when(filmRepository).findAll();


        mockMvc.perform(get("/demo/allFilms")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].film_id").value(film1.getFilm_id()))
                .andExpect(jsonPath("$[1].film_id").value(film2.getFilm_id()))
                .andExpect(jsonPath("$[0].title").value(film1.getTitle()))
                .andExpect(jsonPath("$[1].title").value(film2.getTitle()))
                .andExpect(jsonPath("$", hasSize(2)));
    }



    @Test
    void testGetFilmByID() throws Exception {
        Film film = new Film(1, "ABSOLUTE DINOSAUR", "A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies", 2006, 1);

        when(filmRepository.findById(1)).thenReturn(Optional.of(film));

        mockMvc.perform(get("/demo/getFilmByID?id=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.film_id").value(film.getFilm_id()))
                .andExpect(jsonPath("$.title").value(film.getTitle()))
                .andExpect(jsonPath("$.description").value(film.getDescription()))
                .andExpect(jsonPath("$.releaseYear").value(film.getReleaseYear()))
                .andExpect(jsonPath("$.languageId").value(film.getLanguageId()))
                .andDo(print());
    }


    @Test
    void testFilterFilm() throws Exception {

        Category action = new Category();
        action.setCategory_id(1);
        Category family = new Category();
        family.setCategory_id(2);

        Film film1 = new Film(1, "ACTION FILM", "action film", 2023, 1);
        Film film2 = new Film(2, "FAMILY FILM", "family film", 2023, 1);

        FilmCategory actionFilmCategory = new FilmCategory();
        actionFilmCategory.setCategoryCat(action);
        actionFilmCategory.setFilmCat(film1);
        film1.setCategorySet(new HashSet<>(List.of(actionFilmCategory)));
        action.setFilmSet(new HashSet<>(List.of(actionFilmCategory)));

        FilmCategory familyFilmCategory = new FilmCategory();
        familyFilmCategory.setCategoryCat(family);
        actionFilmCategory.setFilmCat(film2);
        film2.setCategorySet(new HashSet<>(List.of(familyFilmCategory)));
        family.setFilmSet(new HashSet<>(List.of(actionFilmCategory)));

        Iterable<Film> actionFilms = List.of(film1);
        Iterable<Film> familyFilms = List.of(film2);

        when(filmController.filterFilm(1)).thenReturn(actionFilms);
        when(filmController.filterFilm(2)).thenReturn(familyFilms);

        mockMvc.perform(get("/demo/filterFilmsByCategory?id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title").value(film1.getTitle()));

        mockMvc.perform(get("/demo/filterFilmsByCategory?id=2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title").value(film2.getTitle()));
    }


    @Test
    void testDeleteFilmByID() throws Exception {
        Film filmToDelete = new Film(1, "FILM_TO_DELETE", "film to delete", 2023, 1);

        filmRepository.save(filmToDelete);

        doNothing().when(filmRepository).deleteById(1);

        mockMvc.perform(get("/demo/deleteFilmByID?id=1"))
                .andExpect(status().isNotFound());
    }
}