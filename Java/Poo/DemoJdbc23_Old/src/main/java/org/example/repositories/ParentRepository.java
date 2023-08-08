package org.example.repositories;

import org.example.exceptions.CustomiserNotFound;
import org.example.models.entities.Customiser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParentRepository<T> {
    public T getOne(Integer id,String tableName,String idName) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "postgres", "postgres");
            String query = ("SELECT * FROM $tableName WHERE $id = ?").replace("$tableName",tableName).replace("$id",idName);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new CustomiserNotFound();
            }
            connection.close();
            return buildObject(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<T> getMany(String tableName) {
        List<T> objectList = new ArrayList<>();
        String query = ("SELECT * FROM $tableName").replace("$tableName",tableName);
        // si entre () -> fermeture auto de la connexion
        try{
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "postgres", "postgres");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query); // -> Contient les données
            while (resultSet.next()){
                objectList.add(buildObject(resultSet));
            }
            connection.close();
            return objectList;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    public boolean delete(Integer id,String tableName,String idName) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "postgres", "postgres");
            String query = ("DELETE FROM $tableName WHERE $id = ?").replace("$tableName",tableName).replace("$id",idName);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int nbrRow = preparedStatement.executeUpdate();
            connection.close();
            return nbrRow == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public T add(T object) {
        return null;
    }

    public boolean update(T object, Integer id) {
        return false;
    }

    public T buildObject(ResultSet resultSet) {
        return null;
    }

}
