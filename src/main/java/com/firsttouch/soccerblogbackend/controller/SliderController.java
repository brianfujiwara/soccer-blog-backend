package com.firsttouch.soccerblogbackend.controller;


import com.firsttouch.soccerblogbackend.entity.Blog;
import com.firsttouch.soccerblogbackend.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/blogs")
public class SliderController {


    private BlogRepository blogRepository;
    public SliderController(BlogRepository blogRepository){
        this.blogRepository=blogRepository;
    }

    @GetMapping("/slider") //For the carrousel
    Collection<Blog> sliders(){

        List<Blog> allpost = blogRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        Collection<Blog> top3 = new ArrayList<Blog>() ;

        for(int i =0 ; i<=2; i++){
            top3.add(allpost.get(i));

        }


        return top3;

    }

    @GetMapping("/passpost")  //For the post on bottom
    Collection<Blog> passPost(){
        List<Blog> allpost = blogRepository.findAll();
        Collection<Blog> top3 = new ArrayList<Blog>() ;
        for(int i =0 ; i<=2; i++){
            top3.add(allpost.get(i));

        }
        return top3;
    }

    @GetMapping("{id}")
    ResponseEntity<?> getCategory(@PathVariable Integer id) {
        Optional<Blog> category = blogRepository.findById(id);
        return category.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
