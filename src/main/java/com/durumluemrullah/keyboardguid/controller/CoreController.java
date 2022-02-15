package com.durumluemrullah.keyboardguid.controller;

import com.durumluemrullah.keyboardguid.business.abstracts.BaseService;
import com.durumluemrullah.keyboardguid.common.utills.result.DataResult;
import com.durumluemrullah.keyboardguid.common.utills.result.Result;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class CoreController<S extends BaseService<E>,E> {

    private S service;

    public CoreController(S service){
        this.service= service;
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<E>>> getAll (){

        return  ResponseEntity.ok(service.getAll());
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<DataResult<E>> getById(@PathVariable("id") int id){
        DataResult<E> dataResult = service.getById(id);
        if(dataResult.isStatus()){
            return ResponseEntity.ok(dataResult);
        }

        return ResponseEntity.badRequest().body(dataResult);
    }

    @PostMapping("create")
    public ResponseEntity<Result>  create (@RequestBody E entity){
        Result result = service.create(entity);
        if(result.isStatus()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/update")
    public ResponseEntity<Result> update (@RequestBody E entity){
        Result updateResult = service.update(entity);

        if(updateResult.isStatus()){
            return ResponseEntity.ok(updateResult);
        }
        return ResponseEntity.badRequest().body(updateResult);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Result> delete( @PathVariable("id") int id){
        Result deleteResult = service.delete(id);
        if(deleteResult.isStatus()){
            return ResponseEntity.ok(deleteResult);
        }
        return ResponseEntity.badRequest().body(deleteResult);
    }
}
