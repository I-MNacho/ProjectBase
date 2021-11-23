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

    //constructors
    public Tag() {
    }

    public Tag(long id, String title) {
        this.id = id;
        this.title = title;
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
