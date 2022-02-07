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
public class CategoryController {

    // REFACTOR EDILECEK !!

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<Category>>> getAll (){

        return  ResponseEntity.ok(categoryService.getAll());
    }

    @PostMapping("create")
    public ResponseEntity<Result>  create (@RequestBody Category category){
        Result result = categoryService.create(category);
        if(result.isStatus()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/update")
    public ResponseEntity<Result> update (@RequestBody Category category){
        Result updateResult = categoryService.update(category);

        if(updateResult.isStatus()){
            return ResponseEntity.ok(updateResult);
        }
        return ResponseEntity.badRequest().body(updateResult);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Result> delete( @PathVariable("id") int id){
        Result deleteResult = categoryService.delete(id);
        if(deleteResult.isStatus()){
            return ResponseEntity.ok(deleteResult);
        }
        return ResponseEntity.badRequest().body(deleteResult);
    }

}
