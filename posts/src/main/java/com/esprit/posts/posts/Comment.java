package com.esprit.posts.posts;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Comment implements Serializable{
        @Id
    @GeneratedValue
    private int id;
    private String text;
    private int user_id;
    private int post_it;
    private String created_at;
    private String updated_at;
    
}
