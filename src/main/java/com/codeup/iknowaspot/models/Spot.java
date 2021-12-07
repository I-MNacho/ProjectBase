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

    @Column(columnDefinition = "VARCHAR(500)")
    private String spotPhotoURL;


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spot")
//    private List<Tag> tags;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;


    public Spot() {
    }


    public Spot(String title, String description, Double latitude, Double longitude, User user, String tags) {
        this.title = title;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.user = user;
        this.tags = tags;
        this.spotPhotoURL = spotPhotoURL;
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

    public void setDescription(String description) {
        this.description = description;
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

    public String getSpotPhotoURL() {
        return spotPhotoURL;
    }

    public void setSpotPhotoURL(String spotPhotoURL) {
        this.spotPhotoURL = spotPhotoURL;
    }
}