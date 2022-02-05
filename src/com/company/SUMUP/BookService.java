package com.company.SUMUP;

import java.util.Arrays;
import java.util.Objects;

public class BookService {

    public Book[] filterBooksByAuthor(Author author, Book[] books){
       if(author == null || books == null){
           return new Book[0];
       }

        Book[] filteredBooks = Arrays.stream(books)
                .filter(book -> book.hasAuthor(author))
                .toArray(Book[]::new);
        return filteredBooks;
    }

    public Book[] filterBooksByPublisher(Publisher publisher, Book[] books){

        if(publisher == null || books == null)
            return new Book[0];

        Book[] filteredBook =  Arrays.stream(books)
                .filter(Objects::nonNull)
                .filter(book -> book.getPublisher().equals(publisher))
                .toArray(Book[]::new);
        return filteredBook;
    }

    public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books){
        if(yearFromInclusively < 0 || books == null)
            return new Book[0];

        return Arrays.stream(books)
                .filter(Objects::nonNull)
                .filter(book -> book.getPublishingYear() > yearFromInclusively)
                .toArray(Book[]::new);
    }
}
