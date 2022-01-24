package com.durumluemrullah.keyboardguid.controller;


import com.durumluemrullah.keyboardguid.model.pojos.Category;
import com.durumluemrullah.keyboardguid.repository.abstracts.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;


    @GetMapping("/create")
    public String Create (){

        Category category = new Category();
        category.setCategoryName("Backend");

        categoryDao.create(category);

        return "Eklendi";
    }
}
