package com.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String bookName;

    private String bookAuthor;

    private String bookPublicationDate = LocalDate.now().toString();

    private String bookLanguage;

    private String bookThumbnailImage;

    private Integer bookPrice;

    public static final List<Book> globalBookList = new ArrayList<Book>();
}
