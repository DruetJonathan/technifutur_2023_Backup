package org.example.repositories;

import org.example.exceptions.BookException;
import org.example.exceptions.CustomiserException;
import org.example.exceptions.CustomiserNotFound;
import org.example.models.entities.Book;
import org.example.models.entities.Customiser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomiserRepositoryImpl extends ParentRepository<Customiser>{

    @Override
    public Customiser add(Customiser object) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "postgres", "postgres");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CUSTOMISER (LOGIN,PSWD) VALUES(?,?) RETURNING *");
            preparedStatement.setString(1, object.getLogin());
            preparedStatement.setString(2, object.getPswd());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                throw new CustomiserException("Failed");
            return buildObject(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Customiser object,Integer id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "postgres", "postgres");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE CUSTOMISER SET LOGIN = ?,PSWD = ? WHERE CUSTOMISER_ID = ?");
            preparedStatement.setString(1,object.getLogin());
            preparedStatement.setString(2,object.getPswd());
            preparedStatement.setInt(3,id);
            int nbrRow = preparedStatement.executeUpdate();
            connection.close();
            return nbrRow == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customiser buildObject(ResultSet resultSet) {
        try {
            return  Customiser.builder()
                    .id(resultSet.getInt("CUSTOMISER_ID"))
                    .login("LOGIN")
                    .pswd("PSWD")
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
