package com.example.microserviceitem;

public class ItemRespose {

    private int id;
    private String title;
    private String category;
    private String description;
    private String state;
    private UserResponse user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemRespose(Item ItemRespose) {
        this.id = ItemRespose.getId();
        this.title = ItemRespose.getTitle();
        this.description = ItemRespose.getDescription();
        this.category = ItemRespose.getCategory();
        this.state = ItemRespose.getState();
    }
}
