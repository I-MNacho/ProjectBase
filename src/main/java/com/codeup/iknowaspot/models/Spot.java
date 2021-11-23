package com.codeup.iknowaspot.models;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    public Spot() {
    }

    public Spot(String title, String body) {
        this.title = title;
        this.description = body;
    }
    public Spot(String title, String body, User user) {
        this.title = title;
        this.description = body;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}