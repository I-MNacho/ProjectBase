package com.codeup.iknowaspot.models;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "spots")
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "VARCHAR(200) NOT NULL")
    private String title;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String tags;

    @Column(columnDefinition = "DOUBLE")
    private double latitude;

    @Column(columnDefinition = "DOUBLE")
    private double longitude;

    @Value("${file-upload-path}")
    private String uploadPath;


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spot")
//    private List<Tag> tags;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    public Spot() {
    }

<<<<<<< HEAD
    public Spot(String title, String description, Double latitude, Double longitude, User user) {
=======
    public Spot(String title, String description, Double latitude, Double longitude, User user, String tags) {
>>>>>>> 695deb0aaa8229dfa70c58c54d858559a3c64017
        this.title = title;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.user = user;
<<<<<<< HEAD
=======
        this.tags = tags;
>>>>>>> 695deb0aaa8229dfa70c58c54d858559a3c64017
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String body) {
        this.description = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user){
        this.user = user;
    }

//    public Set<User> getUser() {
//        return users;
//    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

//    public double getGithubId() {
//        return githubId;
//    }
//
//    public void setGithubId(int githubId) {
//        this.githubId = githubId;
//    }

    public void setUser(User user) {
        this.user = user;
    }
}