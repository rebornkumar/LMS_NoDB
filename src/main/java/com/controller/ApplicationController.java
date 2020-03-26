package com.controller;

import com.entity.Book;
import com.serviceImpl.AdminImpl;
import com.serviceImpl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/book")
public class ApplicationController {

    @Autowired
    private UserImpl userImpl;

    @Autowired
    private AdminImpl adminImpl;

    @PostMapping(value = "/add")
    public HashMap<String,String> addBooks(@RequestBody List<Book> bookList) {
        boolean success = adminImpl.addBooks(bookList);
        HashMap<String,String> response = new HashMap<String,String>();
        if(success == true) {
            response.put("status", "Success");
        }
        else {
            response.put("status", "Failed");
        }
        return response;
    }

    @DeleteMapping(value = "/remove")
    public HashMap<String, String> removeBook(@RequestParam String name, @RequestParam String author) {
        boolean success = adminImpl.removeBook(name,author);
        HashMap<String,String> response = new HashMap<String,String>();
        if(success == true) {
            response.put("message", "Book " + name + " is Deleted");
            response.put("status", "Success");
        }
        else {
            response.put("status", "Failed");
        }
        return response;
    }

    @GetMapping(value = "/get")
    public List<Book> getBooks(@RequestParam String name, @RequestParam String author, @RequestParam String language, @RequestParam String thumbnailImage, @RequestParam Integer price) {
        return userImpl.getAll(name, author, language, thumbnailImage,price);
    }

    @GetMapping(value = "/sort")
    public List<Book> sortBooks(@RequestParam String sortByParameter, @RequestParam String sortMethod) {
        return userImpl.getSortedBooks(sortByParameter, sortMethod);
    }

    @GetMapping(value = "/search")
    public List<Book> searchBook(@RequestParam String bookProperty, @RequestParam String bookValue) {
        return userImpl.searchBooks(bookProperty, bookValue);
    }
}
