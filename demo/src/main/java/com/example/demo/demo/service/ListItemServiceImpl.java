package com.example.demo.demo.service;

import com.example.demo.demo.model.List;
import com.example.demo.demo.model.ListItem;
import com.example.demo.demo.repository.ListItemRepository;
import com.example.demo.demo.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListItemServiceImpl implements ListItemService {

    @Autowired ListItemRepository listItemRepository;
    @Autowired ListRepository listRepository;

    @Override public Optional<ListItem> findListItemById(int Id) {
        return listItemRepository.findById(Id);
    }

    @Override public Iterable<ListItem> findAllListItemsByListId(int Id) {

        return null;
    }

    @Override public void saveListItem(ListItem listItem) {

    }

    @Override public void deleteListItem(ListItem listItem) {

    }
}
