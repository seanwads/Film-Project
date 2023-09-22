package com.seanwads.film_project.controller;

import com.seanwads.film_project.model.Film;
import com.seanwads.film_project.repository.CategoryRepository;
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

    @Autowired
    FilmController filmController;

    @MockBean
    FilmRepository filmRepository;


    @Test
    void testGetAllFilmsMapping() throws Exception {
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
        Film filmToGet = new Film(1, "ABSOLUTE DINOSAUR", "A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies", 2006, 1);

        Optional<Film> resultOptional = filmController.getFilmByID(1);

        Film result = resultOptional.orElseThrow(() -> {
                    return new Exception("Film not found");
        });

        assertAll(
                () -> assertEquals(result.getFilm_id(), filmToGet.getFilm_id()),
                () -> assertEquals(result.getTitle(), filmToGet.getTitle())
        );
    }

    @Test
    void testGetFilmByNullID(){

        Optional<Film> resultOptional = filmController.getFilmByID(-1);

        assert(resultOptional.isEmpty());

    }

    @Test
    void testGetFilmByIDMapping() throws Exception {
        Film film = new Film(1, "ABSOLUTE DINOSAUR", "A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies", 2006, 1);

        when(filmRepository.findById(1)).thenReturn(Optional.of(film));

        mockMvc.perform(get("/demo/getFilmByID?id=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(film.getFilm_id()))
                .andExpect(jsonPath("$.title").value(film.getTitle()))
                .andExpect(jsonPath("$.description").value(film.getDescription()))
                .andExpect(jsonPath("$.releaseYear").value(film.getReleaseYear()))
                .andExpect(jsonPath("$.languageId").value(film.getLanguageId()))
                .andDo(print());
    }


    @Test
    void testFilterFilm() throws Exception {

        Iterable<Film> film1Iterable = filmController.filterFilm(1);
        int film1Size = 0;
        for(Film film: film1Iterable){
            film1Size ++;
        }

        System.out.println(film1Size);

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

    @Test
    void testFilterFilmAll() throws Exception {
        Iterable<Film> filmIterable = filmController.filterFilm(0);
        int filmCount = 0;
        for(Film film: filmIterable){
            filmCount++;
        }

    }

    @Test
    void testDeleteFilmByID() throws Exception {
        Film filmToDelete = new Film(1, "FILM_TO_DELETE", "film to delete", 2023, 1);

        when(filmController.deleteFilmByID(1)).thenReturn("Film: FILM_TO_DELETE has been deleted");

        MvcResult result = mockMvc.perform(get("/demo/deleteFilmByID?id=1")).andReturn();

        String resultContent = result.getResponse().getContentAsString();

        assert(resultContent).contains("Film: FILM_TO_DELETE has been deleted");
    }



    @Test
    void testUpdateFilm() throws Exception {
//        Film filmToUpdate = new Film(1, "FILM_TO_UPDATE", "film to update", 2023, 1);
//
//        mockFilmController.updateFilm(filmToUpdate);
//
//        assert(mockFilmController.getFilmByID(1).equals(Optional.of(filmToUpdate)));


    }

    @Test
    void testCreateFilm() {
//        Film filmToCreate = new Film(1, "FILM_TO_CREATE", "film to create", 2023, 1);
//
//        mockFilmController.createFilm(filmToCreate);


    }
}