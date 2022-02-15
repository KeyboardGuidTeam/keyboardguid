package com.durumluemrullah.keyboardguid.controller;

import com.durumluemrullah.keyboardguid.business.abstracts.PostService;

import com.durumluemrullah.keyboardguid.model.pojos.Post;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/posts")
public class PostContoller extends CoreController<PostService,Post>{


    private PostService postService;

    @Autowired
    public PostContoller(PostService postService){
        super(postService);
        this.postService=postService;
    }

}
