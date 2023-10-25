package com.esprit.posts.posts;

public class PostRespose {
    private int id;
    private String title;
    private String content;
    private String image_url;
    private String created_at;
    private String updated_at;
    private UserResponse user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters and Setters for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getters and Setters for content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public PostRespose(Post PostRespose) {
        this.id = PostRespose.getId();
        this.title = PostRespose.getTitle();
        this.content = PostRespose.getContent();
        this.image_url = PostRespose.getImage_url();
        this.created_at = PostRespose.getCreated_at();
        this.updated_at = PostRespose.getUpdated_at();
    }
}
