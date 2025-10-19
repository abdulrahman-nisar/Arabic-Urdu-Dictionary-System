package com.DAL.DAO.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAL.DAO.Interface.IWordDAO;
import com.DTO.WordDTO;


public class WordDAO implements IWordDAO{

	//Function to add a new word to the database
	public boolean addWord(WordDTO word) {
		String query = 
				"INSERT INTO words (arabic_form,base_form,urdu_meaning,part_of_speech,root_id) VALUES (?,?,?,?,?)";
		try {
			Connection connection = DatabaseConfig.getConnection();
			 PreparedStatement stmt = connection.prepareStatement(query);
			 stmt.setString(1, word.getArabic_form());
			 stmt.setString(2, word.getBase_form());
			 stmt.setString(3, word.getUrdu_meaning());
			 stmt.setString(4, word.getPart_of_speech());
			 stmt.setInt(5, word.getRoot_id());
			 int rowsAffected = stmt.executeUpdate();
		 		return rowsAffected > 0;
		}
		catch (SQLException e) {	
			e.printStackTrace();
			return false;
		}
	}

	public List<WordDTO> getAllWords() {
		String query = "SELECT * FROM words";
		List<WordDTO> words = new ArrayList<>();
		try {
			Connection connection = DatabaseConfig.getConnection();
			PreparedStatement stmt = connection .prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				WordDTO word = new WordDTO(
						rs.getString("arabic_form"),
						rs.getString("base_form"),
						rs.getString("urdu_meaning"),
						rs.getString("part_of_speech"),
						rs.getInt("root_id")
						);
				words.add(word);
			}	
			return words;			
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}

	public WordDTO getWordByArabicForm(String arabic_form) {
		String query = "SELECT * FROM words WHERE arabic_form = ?";
		try {
			Connection connection = DatabaseConfig.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, arabic_form);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				WordDTO word = new WordDTO(
						rs.getString("arabic_form"),
						rs.getString("base_form"),
						rs.getString("urdu_meaning"),
						rs.getString("part_of_speech"),
						rs.getInt("root_id")
						);
				return word;
			}	
			return null;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean deleteWord(String arabic_form) {
		String query = "DELETE FROM words WHERE arabic_form = ?";
		try {
			Connection connection = DatabaseConfig.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, arabic_form);
			int rows_affected = stmt.executeUpdate();
			return rows_affected > 0;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean upateWordMeaning(String arabic_form, String newUrduMeaning) {
		String query = "UPDATE words SET urdu_meaning = ? WHERE arabic_form = ?";
		try {
			Connection connection = DatabaseConfig.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, newUrduMeaning);
			stmt.setString(2, arabic_form);
			int rows_affected = stmt.executeUpdate();
			return rows_affected > 0;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateWordPartOfSpeech(String arabic_form, String newPartOfSpeech) {
		String query = "UPDATE words SET part_of_speech = ? WHERE arabic_form = ?";
		try {
			Connection connection = DatabaseConfig.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, newPartOfSpeech);
			stmt.setString(2, arabic_form);
			int rows_affected = stmt.executeUpdate();
			return rows_affected > 0;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateWordRootId(String arabic_form, int newRootId) {
		String query = "UPDATE words SET root_id = ? WHERE arabic_form = ?";
		try {
			Connection connection = DatabaseConfig.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, newRootId);
			stmt.setString(2, arabic_form);
			int rows_affected = stmt.executeUpdate();
			return rows_affected > 0;
		} catch(SQLException e) {
			System.out.println("Error updating word root ID in database.");
			e.printStackTrace();
			return false;
		}
	}

}
