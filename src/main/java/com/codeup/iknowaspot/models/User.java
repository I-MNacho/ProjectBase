package com.codeup.iknowaspot.models;

import org.springframework.lang.Nullable;

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

    @Column(columnDefinition = "VARCHAR(500) NULL")
    private String bio;

    @Column(columnDefinition = "VARCHAR(500) NULL")
    private String profilePhotoURL;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Spot> spots;

    // Many users can save many spots to their profile
    // Uses set so that you don't accidentally save the same spot more than once
    @ManyToMany
    private Set<Spot> savedSpots;


    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
        spots = copy.spots;
        bio = copy.bio;
        profilePhotoURL = copy.profilePhotoURL;
        savedSpots = copy.savedSpots;
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

        return spots; }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public Set<Spot> getSavedSpots() {

        return savedSpots; }

    public void setSavedSpots(Set<Spot> savedSpots) {
        this.savedSpots = savedSpots;
    }

    public Set<Spot> addSpot(Spot spot) {
        savedSpots.add(spot);
        return savedSpots;
    }

    public Set<Spot> removeSpot(Spot spot) {
        savedSpots.remove(spot);
        return savedSpots;
    }

    public String getBio() {
            return bio;
        }

    public void setBio(String bio){
            this.bio = bio;
        }

    public String getProfilePhotoURL () {
            return profilePhotoURL;
        }

    public void setProfilePhotoURL (String profilePhotoURL){
            this.profilePhotoURL = profilePhotoURL;
        }

    }


