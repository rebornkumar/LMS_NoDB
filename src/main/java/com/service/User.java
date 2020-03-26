package com.service;

import com.entity.Book;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface User {

    List<Book> getAll(String name, String author, String language, String thumbnailImage, Integer price);

    List<Book> getSortedBooks(String sortByParameter, String sortMethod);

    List<Book> searchBooks(String bookProperty, String bookValue);

}
