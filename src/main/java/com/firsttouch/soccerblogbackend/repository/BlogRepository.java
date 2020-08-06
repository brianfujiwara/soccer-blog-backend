package com.firsttouch.soccerblogbackend.repository;

import com.firsttouch.soccerblogbackend.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
