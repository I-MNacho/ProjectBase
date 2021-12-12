package com.codeup.iknowaspot.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spot")
//    private Set<Event> events = new HashSet<>();
//    // Many users can save many spots to their profile
//    // Uses set so that you don't accidentally save the same spot more than once
//    @ManyToMany
//    private Set<User> saved = new HashSet<>();

    public Spot() {
    }

    public Spot(String title, String description, Double latitude, Double longitude, User user, String tags, Set<User> saved, Set<Event> events) {
        this.title = title;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.user = user;
        this.tags = tags;
        this.spotPhotoURL = spotPhotoURL;
//        this.saved = saved;
//        this.events = events;
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

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

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

//    public Set<User> getSaved() {
//        return saved;
//    }
//
//    public void setSaved(Set<User> saved) {
//        this.saved = saved;
//    }
//
//    public Set<User> favorite(User user) {
//        saved.add(user);
//        return saved;
//    }
//
//    public Set<User> unfavorite(User user) {
//        saved.remove(user);
//        return saved;
//    }
//
//    public Set<Event> getEvents() {
//        return events;
//    }
//
//    public void setEvents(Set<Event> events) {
//        this.events = events;
//    }
//
//    public Set<Event> addEvent(Event event) {
//        events.add(event);
//        return events;
//    }
//
//    public Set<Event> removeEvent(Event event) {
//        events.remove(event);
//        return events;
//    }
}