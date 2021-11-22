package com.codeup.iknowaspot.repositories;

import com.codeup.iknowaspot.models.Spot;
import com.codeup.iknowaspot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
