package com.firsttouch.soccerblogbackend.repository;

import com.firsttouch.soccerblogbackend.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


//@CrossOrigin("http://localhost:3000")
public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
