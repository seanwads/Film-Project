package com.seanwads.film_project.controller;

import com.seanwads.film_project.model.Category;
import com.seanwads.film_project.model.Film;
import com.seanwads.film_project.model.FilmCategory;
import com.seanwads.film_project.repository.FilmRepository;
import org.assertj.core.util.Lists;
import org.junit.Assert;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class FilmRepositoryTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    FilmController filmController;

    @MockBean
    FilmRepository filmRepository;

    @Test
    void testGetFilmByID() throws Exception {

        Film film = new Film(1, "ABSOLUTE DINOSAUR", "A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies", 2006, 1);

        when(filmRepository.findById(1)).thenReturn(Optional.of(film));

        mockMvc.perform(get("/demo/getFilmByID?id=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(film.getId()))
                .andExpect(jsonPath("$.title").value(film.getTitle()))
                .andExpect(jsonPath("$.description").value(film.getDescription()))
                .andExpect(jsonPath("$.releaseYear").value(film.getReleaseYear()))
                .andExpect(jsonPath("$.languageId").value(film.getLanguageId()))
                .andDo(print());
    }

    @Test
    void testGetAllFilms() throws Exception {

        Film film1 = new Film(1, "ABSOLUTE DINOSAUR", "A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies", 2006, 1);

        Film film2 = new Film(2, "ACE ADMINISTRATOR", "A Astounding Epistle of a Database Administrator And a Explorer who must Find a Car in Ancient China", 2006, 1);

        doReturn(Lists.newArrayList(film1, film2)).when(filmRepository).findAll();


        mockMvc.perform(get("/demo/allFilms")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(film1.getId()))
                .andExpect(jsonPath("$[1].id").value(film2.getId()))
                .andExpect(jsonPath("$[0].title").value(film1.getTitle()))
                .andExpect(jsonPath("$[1].title").value(film2.getTitle()))
                .andExpect(jsonPath("$", hasSize(2)));

    }


    @Test
    void testFilterFilm() throws Exception {

        Iterable<Film> film1Iterable = filmController.filterFilm(1);
        int film1Size = 0;
        for(Film film: film1Iterable){
            film1Size ++;
        }

        Iterable<Film> film2Iterable = filmController.filterFilm(2);
        int film2Size = 0;
        for(Film film: film2Iterable){
            film2Size ++;
        }

        mockMvc.perform(get("/demo/filterFilmsByCategory?id=1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(film1Size)));

        mockMvc.perform(get("/demo/filterFilmsByCategory?id=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(film2Size)));
    }
}