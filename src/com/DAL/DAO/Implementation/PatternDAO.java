package com.DAL.DAO.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.DAL.DAO.Interface.IPatternDAO;
import com.DTO.PatternDTO;
import com.DTO.RootDTO;

public class PatternDAO implements IPatternDAO {

    @Override
    public Collection<PatternDTO> getAllPatterns() {
        String query = "SELECT id, form FROM patterns";
        Collection<PatternDTO> patterns = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String form = rs.getString("form");
                // You can fetch applicable roots later if you have a join table
                patterns.add(new PatternDTO(id, form, new ArrayList<RootDTO>()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patterns;
    }

    @Override
    public boolean addPattern(PatternDTO dto) {
        String query = "INSERT INTO patterns (form) VALUES (?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, dto.getForm());
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updatePattern(PatternDTO dto) {
        String query = "UPDATE patterns SET form = ? WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, dto.getForm());
            stmt.setInt(2, dto.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletPattern(PatternDTO dto) {
        String query = "DELETE FROM patterns WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, dto.getId());
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}