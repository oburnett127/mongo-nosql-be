package com.oburnett127.socialmedia.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.oburnett127.socialmedia.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  
  Optional<User> findByEmail(String email);

  @Query("SELECT u FROM User u WHERE u.firstName = :firstName AND u.lastName = :lastName")
  Optional<User> findByfullName(@Param("firstName") String firstName, @Param("lastName") String lastName);
  
}
