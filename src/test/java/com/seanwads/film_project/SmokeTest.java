package com.seanwads.film_project;

import com.seanwads.film_project.controller.FilmController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private FilmController filmController;

    @Test
    public void contextLoads() throws Exception{
        assertThat(filmController).isNotNull();
    }
}
