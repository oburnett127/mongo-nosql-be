package com.oburnett127.socialmedia.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.oburnett127.socialmedia.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByEmail(String email);
}
