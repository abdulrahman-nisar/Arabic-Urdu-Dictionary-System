package com.DAL.DAO.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.DAL.DAO.Interface.IPatternDAO;
import com.DTO.PatternDTO;
import com.DTO.RootDTO;

public class PatternDAO implements IPatternDAO {

	@Override
	public Collection<PatternDTO> getAllPatterns() {
		String query = """
				SELECT p.id AS pattern_id, p.form, r.id AS root_id, r.root_letters
				FROM patterns p
				LEFT JOIN roots_patterns rp ON p.id = rp.pattern_id
				LEFT JOIN roots r ON rp.root_id = r.id
				""";

		Map<Integer, PatternDTO> patternMap = new HashMap<>();

		try (Connection connection = DatabaseConfig.getConnection();
				PreparedStatement stmt = connection.prepareStatement(query);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				int patternId = rs.getInt("pattern_id");
				String form = rs.getString("form");
				int rootId = rs.getInt("root_id");
				String rootLetters = rs.getString("root_letters");

				// If we haven't seen this pattern yet, add it
				PatternDTO pattern = patternMap.get(patternId);
				if (pattern == null) {
					pattern = new PatternDTO(patternId, form, new ArrayList<>());
					patternMap.put(patternId, pattern);
				}

				// If a root exists, add it to the pattern’s list
				if (rootId > 0 && rootLetters != null) {
					RootDTO root = new RootDTO(rootId, rootLetters);
					pattern.getApplicableRoots().add(root);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patternMap.values();
	}

	@Override
	public boolean addPattern(PatternDTO dto) {
		if (isPatternExist(dto.getForm()))
			return false;

		String insertPatternQuery = "INSERT INTO patterns (form) VALUES (?)";
		String insertRootPatternQuery = "INSERT INTO roots_patterns (root_id, pattern_id) VALUES (?, ?)";

		try (Connection connection = DatabaseConfig.getConnection()) {
			// Disable auto-commit for transaction control
			connection.setAutoCommit(false);
			int patternId;
			// Step 1: Insert pattern and get generated ID
			try (PreparedStatement patternStmt = connection.prepareStatement(insertPatternQuery,
					Statement.RETURN_GENERATED_KEYS)) {
				patternStmt.setString(1, dto.getForm());
				int rowsAffected = patternStmt.executeUpdate();

				if (rowsAffected == 0) {
					connection.rollback();
					return false;
				}

				try (ResultSet generatedKeys = patternStmt.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						patternId = generatedKeys.getInt(1);
					} else {
						connection.rollback();
						return false;
					}
				}
			}

			// Step 2: Insert into roots_patterns for each applicable root
			if (dto.getApplicableRoots() != null && !dto.getApplicableRoots().isEmpty()) {
				try (PreparedStatement rootPatternStmt = connection.prepareStatement(insertRootPatternQuery)) {
					for (RootDTO root : dto.getApplicableRoots()) {
						rootPatternStmt.setInt(1, root.getId());
						rootPatternStmt.setInt(2, patternId);
						rootPatternStmt.addBatch();
					}
					rootPatternStmt.executeBatch();
				}
			}

			// Step 3: Commit if everything succeeded
			connection.commit();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean isPatternExist(String form) {
		String sql = "SELECT 1 FROM patterns WHERE form = ?";

		try (Connection connection = DatabaseConfig.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, form);
			ResultSet resultSet = statement.executeQuery();

			return resultSet.next(); // true if any row exists

		} catch (SQLException e) {
			e.printStackTrace();
			return false; // return false if an error occurs
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
	public boolean deletePattern(PatternDTO dto) {
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