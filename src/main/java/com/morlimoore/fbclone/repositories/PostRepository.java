package com.morlimoore.fbclone.repositories;

import com.morlimoore.fbclone.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * This allows us use JPA SQL queries, as well as define our custom queries like we did
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value="UPDATE posts SET likes = likes + 1 WHERE postID = ?1 AND userID = ?2", nativeQuery = true)
    void likeUserPost(Long postID, Long userID);
}
