package com.codeup.iknowaspot.repositories;

import com.codeup.iknowaspot.models.Event;
import com.codeup.iknowaspot.models.Spot;
import com.codeup.iknowaspot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpotRepository extends JpaRepository<Spot, Long> {
    List<Spot> findAllByUser(User user);
    List<Spot> findAllBySaved(User user);
}
