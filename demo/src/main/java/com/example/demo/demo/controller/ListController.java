package com.example.demo.demo.controller;

import com.example.demo.demo.model.List;
import com.example.demo.demo.model.ListItem;
import com.example.demo.demo.repository.ListItemRepository;
import com.example.demo.demo.service.ListService;
import com.example.demo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/lists")
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
    public Iterable<List> getAllLists() {

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
