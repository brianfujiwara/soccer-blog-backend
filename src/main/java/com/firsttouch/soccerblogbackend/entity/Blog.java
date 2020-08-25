package com.firsttouch.soccerblogbackend.entity;


import lombok.Data;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;


@Entity
@Data
@Table(name="blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "writer")
    private String writer;

    @Column(name = "content")
    private String content;

    @Column(name = "imgurl")
    private String imgurl;

//    public Blog() {  }
//    public Blog(String title, String content){
//        this.title= title;
//        this.content= content;
//    }
//
//   public Blog(int id, String title, String content){
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }

}
