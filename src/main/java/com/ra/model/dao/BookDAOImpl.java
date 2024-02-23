package com.ra.model.dao;

import com.ra.model.entity.Book;
import com.ra.util.ConnectionDataBase;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO{
    @Override
    public List<Book> getAll() {
        Connection connection = ConnectionDataBase.openConnection();
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM books");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setBookName(resultSet.getString("bookName"));
                book.setPrice(resultSet.getDouble("price"));
                book.setAuthor(resultSet.getString("author"));
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return books;
    }

    @Override
    public boolean create(Book book) {
       Connection connection = ConnectionDataBase.openConnection();
       String sql = "INSERT INTO books(bookName,price,author) VALUES (?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,book.getBookName());
            statement.setDouble(2,book.getPrice());
            statement.setString(3,book.getAuthor());
            if(statement.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean update(Book book) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "UPDATE books SET bookName = ?,price = ?,author=? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,book.getBookName());
            statement.setDouble(2,book.getPrice());
            statement.setString(3,book.getAuthor());
            statement.setInt(4,book.getId());
            if(statement.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return false;
    }

    @Override
    public void delete(Integer id) {
        Connection connection = ConnectionDataBase.openConnection();
        String sql = "DELETE FROM books WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
    }

    @Override
    public Book findById(Integer id) {
        Connection connection = ConnectionDataBase.openConnection();

        String sql = "SELECT * FROM books WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setBookName(resultSet.getString("bookName"));
                book.setPrice(resultSet.getDouble("price"));
                book.setAuthor(resultSet.getString("author"));
                return book;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
