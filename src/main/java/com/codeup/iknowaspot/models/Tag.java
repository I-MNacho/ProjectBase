package com.codeup.iknowaspot.models;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {

    //variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "VARCHAR(200) NOT NULL")
    private String title;

    @ManyToOne
    @JoinColumn (name = "spot_id")
    private Spot spot;

    //constructors
    public Tag() {
    }

    public Tag(String title, Spot spot) {
        this.title = title;
        this.spot = spot;
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
}
