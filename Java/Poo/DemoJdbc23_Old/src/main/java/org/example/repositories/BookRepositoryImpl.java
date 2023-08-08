package org.example.repositories;

import org.example.exceptions.BookException;
import org.example.exceptions.BookNotFoundException;
import org.example.models.entities.Book;
import org.example.models.entities.Customiser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl extends ParentRepository<Book> {
    private Book buildBook(ResultSet resultSet){
        try {
            return  Book.builder()
                    .id(resultSet.getInt("BOOK_ID"))
                    .title(resultSet.getString("TITLE"))
                    .description((resultSet.getString("DESCRIPTION")))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book add(Book book) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo.Jdbc", "postgres", "postgres");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO BOOK (TITLE,DESCRIPTION) VALUES(?,?) RETURNING *");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getDescription());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                throw new BookException("Failed");
            return buildBook(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Book object,Integer id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo.Jdbc", "postgres", "postgres");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE BOOK SET TITLE = ?,DESCRIPTION = ? WHERE BOOK_ID = ?");
            preparedStatement.setString(1,object.getTitle());
            preparedStatement.setString(2,object.getDescription());
            preparedStatement.setInt(3,id);
            int nbrRow = preparedStatement.executeUpdate();
            connection.close();
            return nbrRow == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
