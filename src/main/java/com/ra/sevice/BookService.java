package com.ra.sevice;

import com.ra.model.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    boolean create(Book book);
    boolean update(Book book);
    void delete(Integer id);
    Book findById(Integer id);
}
