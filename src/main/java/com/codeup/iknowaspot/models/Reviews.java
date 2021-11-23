package com.codeup.iknowaspot.models;

import com.codeup.iknowaspot.models.Spot;
import com.codeup.iknowaspot.models.User;

import javax.persistence.*;

    @Entity
    @Table(name = "reviews")
    public class Reviews {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(columnDefinition = "VARCHAR(200) NOT NULL")
        private String rating;

        @Column(columnDefinition = "VARCHAR(200) NOT NULL")
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

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
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
