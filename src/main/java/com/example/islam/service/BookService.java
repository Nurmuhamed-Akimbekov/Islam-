package com.example.islam.service;



import com.example.islam.entity.Book;

import java.util.List;

public interface BookService {

    void saveBook(Long userId, Book newBook);
    List<Book> findAllBooks();
    Book findByIdBook(Long bookId);
    void updateBookById(Long bookId, Book newBook);
    void deleteById(Long bookId);
    List<Book> BookSearch(String word);
}
