package com.DAL.DAO.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAL.DAO.Interface.IRootDAO;
import com.DTO.RootDTO;

public class RootDAO implements IRootDAO {
	
	private Connection connection;
	
	public RootDAO() {
		try {
			this.connection = DatabaseConfig.getConnection();
		} catch (SQLException e) {
			System.out.println("Error establishing database connection in RootDAO.");
			e.printStackTrace();
		}
	}

	@Override
	public List<RootDTO> getAllRoots() {
		String query = "SELECT * FROM roots";
		List<RootDTO> roots = new ArrayList<>();
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				roots.add(new RootDTO(rs.getString("root_letters")));
			}
			return roots;
		} catch (SQLException e) {
			System.out.println("Error retrieving all roots from database.");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RootDTO getRootById(int rootId) {
		String query = "SELECT * FROM roots WHERE id = ?";
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setInt(1, rootId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new RootDTO(rs.getString("root_letters"));
			}
			return null;
		} catch (SQLException e) {
			System.out.println("Error retrieving root by ID from database.");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addRoot(RootDTO root) {
		String query = "INSERT INTO roots (root_letters) VALUES (?)";

		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, root.getRootLetters());

			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.out.println("Error adding new root to database.");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteRoot(String rootLetters) {
		String query = "DELETE FROM roots WHERE root_letters = ?";

		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, rootLetters);

			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.out.println("Error deleting root from database.");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateRoot(String oldRootLetters, String newRootLetters) {
		String query = "UPDATE roots SET root_letters = ? WHERE root_letters = ?";

		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, newRootLetters);
			stmt.setString(2, oldRootLetters);

			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.out.println("Error updating root in database.");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int getRootIdByLetters(String rootLetters) {
		String query = "SELECT id FROM roots WHERE root_letters = ?";

		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setString(1, rootLetters);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("id");
			}
			return -1; // Return -1 if root not found
		} catch (SQLException e) {
			System.out.println("Error retrieving root ID by letters from database.");
			e.printStackTrace();
			return -1;
		}
	}
	
}
