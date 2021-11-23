package com.codeup.iknowaspot.repositories;

import com.codeup.iknowaspot.models.Event;
import com.codeup.iknowaspot.models.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
