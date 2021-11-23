package com.codeup.iknowaspot.models;

import com.mysql.cj.protocol.ColumnDefinition;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {

    //variables
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

    @ManyToOne
    @JoinColumn (name = "spot_id")
    private Spot spot;

    @Column(columnDefinition = "VARCHAR(30)", nullable = true)
    private String startTime;

    @Column(columnDefinition = "VARCHAR(30)", nullable = true)
    private String endTime;

    //constructors
    public Event() {
    }

    public Event(long id, String title, String description, User user, Spot spot, String startTime, String endTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
        this.spot = spot;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
