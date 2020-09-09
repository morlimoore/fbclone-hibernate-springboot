package com.morlimoore.fbclone.servicesImpl;

import com.morlimoore.fbclone.entities.Post;
import com.morlimoore.fbclone.entities.User;
import com.morlimoore.fbclone.repositories.PostRepository;
import com.morlimoore.fbclone.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * An implementation of the post services offered by the application.
 * It is injected to the controller, to offer its services.
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void likeUserPost(Long postID, Long userID) {
        postRepository.likeUserPost(postID, userID);
    }

    @Override
    public void addPost(Post post) {
        this.postRepository.save(post);
    }
}
