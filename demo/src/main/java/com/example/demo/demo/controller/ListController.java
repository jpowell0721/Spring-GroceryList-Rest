package com.example.demo.demo.controller;

import com.example.demo.demo.model.List;
import com.example.demo.demo.model.ListItem;
import com.example.demo.demo.repository.ListItemRepository;
import com.example.demo.demo.service.ListService;
import com.example.demo.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/lists") // This means URL's start with /demo (after Application path)
public class ListController {

    @Autowired
    private ListService listService;
    @Autowired
    private ListItemRepository listItemRepository;
    @Autowired
    private UserService userService;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public ResponseEntity<List> addNewList(@RequestParam String name, @RequestParam Integer Id) {

        List l = new List();
        l.setName(name);
        l.setUser(userService.findById(Id).get());
        listService.saveList(l);

        return new ResponseEntity<List>(l, HttpStatus.CREATED);
    }

    @GetMapping(path = "")
    public ResponseEntity<Iterable<List>> getAllLists() {
        // This returns a JSON or XML with the users
        return listService.findAllLists();
    }

    @GetMapping(path = "/{id}/items")
    public @ResponseBody
    Iterable<ListItem> getAllListItems(@PathVariable("id") Integer Id) {
        return listItemRepository.findAllByListId(Id);
    }

    @PostMapping(path = "/{id}")
    public @ResponseBody
    String addNewListItem(@RequestParam String name, @PathVariable("id") Integer Id) {
        ListItem listItem = new ListItem();
        listItem.setName(name);
        listItem.setList(listService.findListById(Id).get());

        listItemRepository.save(listItem);

        return "Saved";
    }

}
