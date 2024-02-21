package com.ra.model.dao;

import com.ra.model.entity.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getAll();
    boolean create(Book book);
    boolean update(Book book);
    void delete(Integer id);
    Book findById(Integer id);
}
