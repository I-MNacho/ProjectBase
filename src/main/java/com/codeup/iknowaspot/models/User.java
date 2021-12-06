package com.codeup.iknowaspot.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String username;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String email;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String password;

    @Column(columnDefinition = "VARCHAR(500) NOT NULL")
    private String bio;

    @Column(columnDefinition = "VARCHAR(500) NOT NULL")
    private String profilePhotoURL;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Spot> spots;


    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
        bio = copy.bio;
        profilePhotoURL = copy.profilePhotoURL;
//        spots = copy.spots;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Spot> getSpots() {
        return spots;
    }

        public String getBio () {
            return bio;
        }

        public void setBio (String bio){
            this.bio = bio;
        }

        public String getProfilePhotoURL () {
            return profilePhotoURL;
        }

        public void setProfilePhotoURL (String profilePhotoURL){
            this.profilePhotoURL = profilePhotoURL;
        }

    }

//    hi
