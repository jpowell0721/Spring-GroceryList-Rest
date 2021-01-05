package com.example.demo.demo.service;

import com.example.demo.demo.model.ListItem;

import java.util.Optional;

public interface ListItemService {
    Optional<ListItem> findListItemById(int Id);
    Iterable<ListItem> findAllListItemsByListId(int Id);
    void saveListItem(ListItem listItem);
    void deleteListItem(ListItem listItem);
}