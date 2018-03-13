package com.example.BookStore.repository;

import com.example.BookStore.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>{

    User findByUsername(String username);
}