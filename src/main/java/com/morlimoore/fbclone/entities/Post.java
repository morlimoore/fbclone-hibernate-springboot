package com.morlimoore.fbclone.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postID;

    private String message;

    private int likes;

    private String createdAt;

    @ManyToOne
    @JoinColumn(name="userID")
    private User user;
}
