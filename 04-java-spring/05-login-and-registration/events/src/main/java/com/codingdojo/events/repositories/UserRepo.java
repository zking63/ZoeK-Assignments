package com.codingdojo.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.events.models.User;


@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
