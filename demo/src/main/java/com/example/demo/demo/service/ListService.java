package com.example.demo.demo.service;

import com.example.demo.demo.model.List;

import java.util.Optional;

public interface ListService {
    Optional<List> findListById(int Id);
    Iterable<List> findAllLists();
    void saveList(List list);
    void deleteList(List list);

}
