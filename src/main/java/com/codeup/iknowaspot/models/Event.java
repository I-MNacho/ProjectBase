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
    @JoinColumn(name="spot_id")
    private Spot spot;

    @Column
    private long startTime;

    @Column
    private long endTime;

    //constructors
    public Event() {
    }

    public Event(long id, String title, String description, User user, Spot spot, long startTime, long endTime) {
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

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
