package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import db.DB;

public class Program {

	public static void main(String[] args) {
		 
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DB.getConnection();
			
//			statement = connection.prepareStatement(
//				"INSERT INTO department (Name) VALUES ('TI')",
//				Statement.RETURN_GENERATED_KEYS
//					);
			
			statement = connection.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentID)"
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS
					);
			
			statement.setString(1, "Alan Dev");
			statement.setString(2, "alan@ti.com");
			
			LocalDate birth = LocalDate.parse("07/05/1998", fmt);
			statement.setDate(3, java.sql.Date.valueOf(birth));
			statement.setDouble(4, 3500.0);
			statement.setInt(5, 5);
					
			int rowsChanged = statement.executeUpdate();
			
			if (rowsChanged > 0) {
				ResultSet result = statement.getGeneratedKeys();
				while (result.next()) {
					int id = result.getInt(1); //indice da coluna
					System.out.println("Done! Id: " + id);
				}
			} else {
				System.out.println("No rows affected");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(statement);
			DB.closeConnection();
		}
	}

}
