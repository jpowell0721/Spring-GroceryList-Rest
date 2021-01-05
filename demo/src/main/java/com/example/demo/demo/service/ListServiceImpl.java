package com.example.demo.demo.service;

import com.example.demo.demo.model.List;
import com.example.demo.demo.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    private ListRepository listRepository;

    @Override
    public Optional<List> findListById(int Id) {
        return listRepository.findById(Id);
    }

    @Override
    public Iterable<List> findAllLists() {

        return listRepository.findAll();
    }

    @Override
    public void saveList(List list) {
        listRepository.save(list);
    }

    @Override
    public void deleteList(List list) {
        listRepository.delete(list);
    }
}
