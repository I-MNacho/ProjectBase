package com.codeup.iknowaspot.repositories;

import com.codeup.iknowaspot.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Review, Long> {
}
