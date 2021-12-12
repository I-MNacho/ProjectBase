package com.codeup.iknowaspot.repositories;

import com.codeup.iknowaspot.models.Event;
import com.codeup.iknowaspot.models.Spot;
import com.codeup.iknowaspot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByUser(User user);
    List<Event> findAllBySaved(User user);
    List<Event> findAllByAttending(User user);
    List<Event> findEventByEndTimeAfterOrderByStartTime(long datetime);
}
