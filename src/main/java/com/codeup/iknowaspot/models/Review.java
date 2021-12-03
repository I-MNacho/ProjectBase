package com.codeup.iknowaspot.models;

import javax.persistence.*;

    @Entity
    @Table(name = "reviews")
    public class Review {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(columnDefinition = "INTEGER NOT NULL")
        private int rating;

        @Column(columnDefinition = "TEXT NOT NULL")
        private String body;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne
        @JoinColumn(name = "spot_id")
        private Spot spot;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
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
    }
