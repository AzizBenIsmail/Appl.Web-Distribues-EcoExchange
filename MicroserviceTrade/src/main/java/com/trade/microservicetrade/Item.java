package com.trade.microservicetrade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Item {



        @Id
        @GeneratedValue
        private int id;
        private String title,description,category,state;

        public Item() {
        }

        public Item(String title, String description, String category, String state) {
            this.title = title;
            this.description = description;
            this.category = category;
            this.state = state;
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

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }


