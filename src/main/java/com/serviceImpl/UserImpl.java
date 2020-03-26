package com.serviceImpl;

import com.entity.Book;
import com.service.User;
import com.util.Constant;
import com.util.SortBookByParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserImpl implements User {

    private final Logger logger = LoggerFactory.getLogger(UserImpl.class);

    @Override
    public List<Book> getAll(String name, String author, String language, String thumbnailImage, Integer price) {
        List<Book> books = new ArrayList<Book>();
        for(Book book : Book.globalBookList) {
            if (book.getBookName().equals(name) && book.getBookAuthor().equals(author) && book.getBookLanguage().equals(language) && book.getBookThumbnailImage().equals(thumbnailImage) && book.getBookPrice() == price) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<Book> getSortedBooks(String sortByParameter, String sortMethod) {

        Collections.sort(Book.globalBookList,new SortBookByParameter(sortByParameter,sortMethod));
        List<Book> books = new ArrayList<Book>();
        books.addAll(Book.globalBookList);
        return books;
    }
    @Override
    public List<Book> searchBooks(String bookProperty, String bookValue) {
        List<Book> books = new ArrayList<Book>();
        switch(bookProperty) {
            case Constant.Name :
                for(Book book : Book.globalBookList) {
                    if (book.getBookName().equals(bookValue)) {
                        books.add(book);
                    }
                }
                break;
            case Constant.Author:
                for(Book book : Book.globalBookList) {
                    if (book.getBookAuthor().equals(bookValue)) {
                        books.add(book);
                    }
                }
                break;

            case Constant.Language :
                for(Book book : Book.globalBookList) {
                    if (book.getBookLanguage().equals(bookValue)) {
                        books.add(book);
                    }
                }
                break;
            case Constant.ThumbnailImage :
                for(Book book : Book.globalBookList) {
                    if (book.getBookThumbnailImage().equals(bookValue)) {
                        books.add(book);
                    }
                }
                break;
            case Constant.PublicationDate :
                for(Book book : Book.globalBookList) {
                    if (book.getBookPublicationDate().equals(bookValue)) {
                        books.add(book);
                    }
                }
                break;
            case Constant.Price :
                for(Book book : Book.globalBookList) {
                    if (book.getBookPrice().equals(bookValue)) {
                        books.add(book);
                    }
                }
                break;
            default:
                logger.info("Please enter correct parameter");
                break;
        }
        return books;
    }
}


