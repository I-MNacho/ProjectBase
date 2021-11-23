package com.codeup.iknowaspot.models;

import javax.persistence.*;

@Entity
@Table(name = "favorite_spots")
public class FavoriteSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn (name = "spot_id")
    private Spot spot;

    public FavoriteSpot(){}

    public FavoriteSpot(User user, Spot spot) {
        this.user = user;
        this.spot = spot;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
