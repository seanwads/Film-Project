//package com.seanwads.film_project;
//
//import com.seanwads.film_project.controller.FilmController;
//import com.seanwads.film_project.repository.FilmRepository;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//
//
//
//
//@SpringBootTest
//class FilmProjectApplicationTests {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Mock
//	private FilmRepository filmRepository;
//
//	@Test
//	public void getAllFilmsTest() throws Exception{
//		mockMvc.perform(MockMvcRequestBuilders
//					.get("/demo/getAllFilms")
//					.accept(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.films").exists())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.films[*].id").isNotEmpty());
//
//	}
//
//}
