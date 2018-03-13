package com.example.BookStore.repository;

import com.example.BookStore.model.Category;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(String name);

}
