package com.morlimoore.fbclone.services;

import com.morlimoore.fbclone.entities.Post;

import java.util.List;

/**
 * An abstraction of the post services offered by the application
 */
public interface PostService {

    List<Post> getAllPosts();

    void likeUserPost(Long postID, Long userID);
    void addPost(Post post);
}
