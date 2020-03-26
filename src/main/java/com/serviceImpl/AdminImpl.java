package com.serviceImpl;

import com.entity.Book;
import com.service.Admin;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminImpl implements Admin {

    @Override
    public boolean addBooks(List<Book> books) {
        if(books.isEmpty()) {
            return false;
        }
        else {
            Book.globalBookList.addAll(books);
            return true;
        }
    }

    @Override
    public boolean removeBook(String name, String author) {
        for(Book book : Book.globalBookList) {
            if(book.getBookName().equals(name) && book.getBookAuthor().equals(author)) {
                Book.globalBookList.remove(book);
                return true;
            }
        }
        return false;
    }
}
