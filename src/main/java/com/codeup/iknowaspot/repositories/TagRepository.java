package com.codeup.iknowaspot.repositories;

import com.codeup.iknowaspot.models.Event;
import com.codeup.iknowaspot.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
