package com.durumluemrullah.keyboardguid.controller;


import com.durumluemrullah.keyboardguid.business.abstracts.CategoryService;
import com.durumluemrullah.keyboardguid.common.utills.result.DataResult;
import com.durumluemrullah.keyboardguid.common.utills.result.Result;
import com.durumluemrullah.keyboardguid.model.pojos.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController extends CoreController<CategoryService,Category> {


    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        super(categoryService);
        this.categoryService = categoryService;
    }



}
