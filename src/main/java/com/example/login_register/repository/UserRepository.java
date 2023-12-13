package com.example.login_register.repository;

import com.example.login_register.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,Long> {
  /*  @Query(value = "{}", sort = "{ 'id' : -1 }")
    User findTopByOrderByIdDesc();*/
  Optional<User> findByEmailAndPassword(String email, String password);

}
