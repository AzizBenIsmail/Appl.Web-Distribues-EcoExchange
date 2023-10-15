package com.esprit.posts.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
@Autowired
private PostRepository postRepository;

public Post addPost(Post post) {
    return postRepository.save(post);
}

public Post updatePost(Post post) {
    return postRepository.save(post);
}

public void deletePost(int postId) {
    postRepository.deleteById(postId);
}

public Post getPostById(int postId) {
    return postRepository.findById(postId).orElse(null);
}

public List<Post> getAllPosts() {
    return postRepository.findAll();
}


}
