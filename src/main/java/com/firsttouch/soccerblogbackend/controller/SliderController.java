package com.firsttouch.soccerblogbackend.controller;


import com.firsttouch.soccerblogbackend.entity.Blog;
import com.firsttouch.soccerblogbackend.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogs")
public class SliderController {


    private BlogRepository blogRepository;
    public SliderController(BlogRepository blogRepository){
        this.blogRepository=blogRepository;
    }

    @GetMapping("/slider")
    Collection<Blog> sliders(){

        List<Blog> allpost = blogRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        Collection<Blog> top3 = new ArrayList<Blog>() ;

        for(int i =0 ; i<=2; i++){
            top3.add(allpost.get(i));

        }


        return top3;

    }

    @GetMapping("/passpost")
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
