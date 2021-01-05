package com.example.demo.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.demo.model.ListItem;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ListItemRepository extends CrudRepository<ListItem, Integer> {
    Iterable<ListItem> findAllByListId(Integer Id);
}