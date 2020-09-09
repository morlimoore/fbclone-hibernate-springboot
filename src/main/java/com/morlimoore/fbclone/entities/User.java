package com.morlimoore.fbclone.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    private String fName;

    private String lName;

    private String email;

    private String hash;

    private String dateOfBirth;

    private String gender;

    private String createdAt;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    Set<Post> post = new HashSet<>();



    @Transient
    private int postID;

    @Transient
    private String password;
}
