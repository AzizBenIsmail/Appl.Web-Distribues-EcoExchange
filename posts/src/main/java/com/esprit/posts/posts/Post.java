package com.esprit.posts.posts;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Post implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String content;
    private String image_url;
    private int user_id;
    private String created_at;
    private String updated_at;

    
}
