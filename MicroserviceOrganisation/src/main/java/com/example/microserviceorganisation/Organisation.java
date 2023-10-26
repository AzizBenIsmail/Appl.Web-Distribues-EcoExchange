package com.example.microserviceorganisation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity

public class Organisation implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private int user_id;
    private String title,description,category;

    public Organisation() {
    }

    public Organisation(String title, String description, String category) {
        this.title = title;
        this.description = description;
        this.category = category;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
