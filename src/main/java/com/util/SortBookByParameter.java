package com.util;

import com.entity.Book;

import java.util.*;
public class SortBookByParameter implements Comparator<Book>{

    String sortByParameter;
    String sortMethod;
    public SortBookByParameter(String sortByParameter,String sortMethod) {
        this.sortByParameter = sortByParameter;
        this.sortMethod = sortMethod;
    }

    public int compare(Book book1,Book book2){
        int order = 0;
            if(Constant.Name.equals(sortByParameter)) {
                order = book1.getBookName().compareTo(book2.getBookName());
            }
            else if(Constant.Author.equals(sortByParameter)) {
                order = book1.getBookAuthor().compareTo(book2.getBookAuthor());
            }
            else if(Constant.Language.equals(sortByParameter)) {
                order = book1.getBookLanguage().compareTo(book2.getBookLanguage());
            }
            else if(Constant.ThumbnailImage.equals(sortByParameter)) {
                order = book1.getBookThumbnailImage().compareTo(book2.getBookThumbnailImage());
            }
            else if(Constant.PublicationDate.equals(sortByParameter)) {
                order = book1.getBookPublicationDate().compareTo(book2.getBookPublicationDate());
            }
            else {
                order = book1.getBookPrice().compareTo(book2.getBookPrice());
            }
        return Constant.Ascending.equals(sortMethod) == true? order : -order;
    }
}

