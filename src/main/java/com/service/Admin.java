package com.service;

import com.entity.Book;
import java.util.List;

public interface Admin {

    boolean addBooks(List<Book>books);
    boolean removeBook(String name,String author);
}
