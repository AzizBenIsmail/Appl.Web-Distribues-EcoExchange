package com.esprit.posts.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "comment")
public class CommentRestAPI {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/hello")
    public String sayHello() {
        return "Salem patron";
    }

    @PostMapping(value = "/addComment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        comment.setCreated_at(String.valueOf(new Date(System.currentTimeMillis())));
        comment.setUpdated_at(String.valueOf(new Date(System.currentTimeMillis())));
        return new ResponseEntity<>(commentService.addComment(comment), HttpStatus.CREATED);
    }

    @GetMapping(value = "/getOne/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> getOneComment(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(commentService.getCommentById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Comment> >getAllComments() {
        return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.OK);
    }

    @PutMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> updateComment(@PathVariable(value = "id") int id, @RequestBody Comment updatedComment) {
        updatedComment.setId(id);
        updatedComment.setUpdated_at(String.valueOf(new Date(System.currentTimeMillis())));
        return new ResponseEntity<>(commentService.updateComment(updatedComment), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteComment(@PathVariable(value = "id") int id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }
}
