package com.esprit.posts.posts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class PostService {
@Autowired
private PostRepository postRepository;

@Autowired
WebClient webClient;

@Autowired
UserClient userClient;

public Post addPost(Post post) {
    return postRepository.save(post);
}

public Post updatePost(Post post) {
    return postRepository.save(post);
}

public void deletePost(int postId) {
    postRepository.deleteById(postId);
}

public PostRespose getPostById(int postId) {
    Post p= postRepository.findById(postId).orElse(null);
    PostRespose postRespose=new PostRespose(p);
    // postRespose.setUserResponse(getUserById(p.getUser_id()));
    postRespose.setUser(userClient.getById(p.getUser_id()));

    return postRespose;
}

public List<PostRespose> getAllPosts() {
    List<Post> posts = postRepository.findAll();
    List<PostRespose> postResponses = new ArrayList<>();

    for (Post post : posts) {
        PostRespose postResponse = new PostRespose(post);
        // Fetch user information for the post
        UserResponse userResponse = userClient.getById(post.getUser_id());
        postResponse.setUser(userResponse);
        postResponses.add(postResponse);
    }

    return postResponses;
}


public UserResponse getUserById(long userId){
    Mono<UserResponse> userResponse= webClient.get().uri("/"+userId).retrieve().bodyToMono(UserResponse.class);
    return userResponse.block();
}

}
