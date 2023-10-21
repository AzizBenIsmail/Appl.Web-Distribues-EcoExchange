package com.esprit.posts.posts;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
