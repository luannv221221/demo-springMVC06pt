package com.ra.sevice;

import com.ra.model.dao.BookDAO;
import com.ra.model.dao.BookDAOImpl;
import com.ra.model.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> getAll() {
        return bookDAO.getAll();
    }

    @Override
    public boolean create(Book book) {
        return false;
    }

    @Override
    public boolean update(Book book) {
        return false;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Book findById(Integer id) {
        return null;
    }
}
