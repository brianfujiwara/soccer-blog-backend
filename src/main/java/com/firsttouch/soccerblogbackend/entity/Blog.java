package com.firsttouch.soccerblogbackend.entity;


import lombok.Data;

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
