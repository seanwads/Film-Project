package com.seanwads.film_project.controller;

import com.seanwads.film_project.model.Category;
import com.seanwads.film_project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/demo")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/getCategories")
    private @ResponseBody Iterable<Category> getCategories(){
        return categoryRepository.findAll();
    }
}
