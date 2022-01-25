package com.durumluemrullah.keyboardguid.controller;


import com.durumluemrullah.keyboardguid.model.pojos.Category;
import com.durumluemrullah.keyboardguid.repository.abstracts.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;


    @GetMapping("/create")
    public ResponseEntity<List<Category>> Create (){

        Category category = new Category();
        category.setCategoryName("Frontend");

        categoryDao.create(category);



        System.out.println(categoryDao.getAll());

        category.setCategoryId(BigInteger.TWO);
        category.setCategoryName("Frontend update");
        categoryDao.update(category);
        categoryDao.delete(category);

        return  ResponseEntity.ok(categoryDao.getAll());
    }

    @GetMapping("/ctrl")
    public String herokuControl(){
        return "OK";
    }
}
