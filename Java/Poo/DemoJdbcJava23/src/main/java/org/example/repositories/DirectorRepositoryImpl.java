package org.example.repositories;

import org.example.exception.EntityException;
import org.example.models.entities.Author;
import org.example.models.entities.Director;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectorRepositoryImpl extends BaseRepositoryImpl<Director> implements DirectorRepository {
    public DirectorRepositoryImpl() {
        super("DIRECTOR", "DIRECTOR_ID");
    }

    @Override
    protected Director buildEntity(ResultSet rs) {
        try {
            return Director.builder()
                    .id(rs.getInt("DIRECTOR_ID"))
                    .firstname(rs.getString("FIRSTNAME"))
                    .lastname(rs.getString("LASTNAME"))
                    .pseudo(rs.getString("PSEUDO"))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Director add(Director director) {
        return add(director,openConnection());
    }
    @Override
    public Director add(Director director, Connection conn) {
        try{
            PreparedStatement psmt = conn.prepareStatement("INSERT INTO DIRECTOR (FIRSTNAME,LASTNAME,PSEUDO) VALUES (?,?,?) RETURNING *");
            psmt.setString(1, director.getFirstname());
            psmt.setString(2, director.getLastname());
            psmt.setString(3, director.getPseudo());
            ResultSet rs = psmt.executeQuery();
            if (!rs.next())
                throw new EntityException("Failed");

            return buildEntity(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean update(Integer id, Director director) {
        try {
            Connection conn = openConnection();
            PreparedStatement psmt = conn.prepareStatement("UPDATE DIRECTOR SET FIRSTNAME = ?, LASTNAME = ?,PSEUDO = ? WHERE DIRECTOR_ID = ?");
            psmt.setString(1, director.getFirstname());
            psmt.setString(2, director.getLastname());
            psmt.setString(3, director.getPseudo());
            psmt.setInt(4, id);

            int nbRows = psmt.executeUpdate();

            conn.close();

            return nbRows == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public List<Director> getByKeyword(String keyword) {
        try {
            Connection conn = openConnection();
            PreparedStatement psmt = conn.prepareStatement("Select * from DIRECTOR WHERE FIRSTNAME like %?% " +
                    "or FIRSTNAME like %?%" +
                    "or PSEUDO like %?%");
            psmt.setString(1, keyword);
            psmt.setString(2, keyword);
            psmt.setString(3, keyword);

            ResultSet resultSet = psmt.executeQuery();
            List<Director> directorList = new ArrayList<>();
            while (resultSet.next()) {
                directorList.add(buildEntity(resultSet));
            }
            conn.close();
            return directorList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
