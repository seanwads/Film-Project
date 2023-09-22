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
class FilmControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    FilmController mockFilmController;



    @Test
    void testFilterFilm() throws Exception {

        Iterable<Film> film1Iterable = mockFilmController.filterFilm(1);
        int film1Size = 0;
        for(Film film: film1Iterable){
            film1Size ++;
        }

        Iterable<Film> film2Iterable = mockFilmController.filterFilm(2);
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

    @Test
    void testDeleteFilmByID() throws Exception {
        Film filmToDelete = new Film(1, "FILM_TO_DELETE", "film to delete", 2023, 1);

        when(mockFilmController.deleteFilmByID(1)).thenReturn("Film: FILM_TO_DELETE has been deleted");

        MvcResult result = mockMvc.perform(get("/demo/deleteFilmByID?id=1")).andReturn();

        String resultContent = result.getResponse().getContentAsString();

        assert(resultContent).contains("Film: FILM_TO_DELETE has been deleted");
    }

    @Test
    void testCreateFilm() throws Exception {
        Film filmToCreate = new Film(1, "FILM_TO_CREATE", "film to create", 2023, 1);

        when(mockFilmController.createFilm(filmToCreate)).thenReturn(Optional.of(filmToCreate));

        mockMvc.perform(post("/demo/createFilm")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"title\": \"FILM_TO_CREATE\",\n" +
                        "    \"description\": \"film to create\",\n" +
                        "    \"releaseYear\": 2023,\n" +
                        "    \"languageId\": 1\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("FILM_TO_CREATE"));
    }

    @Test
    void testUpdateFilm() throws Exception {
        Film filmToUpdate = new Film(1, "FILM_TO_UPDATE", "film to update", 2023, 1);

        when(mockFilmController.updateFilm(filmToUpdate)).thenReturn(Optional.of(filmToUpdate));

        mockMvc.perform(put("/demo/updateFilm")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"title\": \"FILM_TO_UPDATE\",\n" +
                        "    \"description\": \"film to update\",\n" +
                        "    \"releaseYear\": 2023,\n" +
                        "    \"languageId\": 1\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("FILM_TO_UPDATE"));
    }
}