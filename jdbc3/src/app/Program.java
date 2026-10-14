package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
//			st = conn.prepareStatement(
//					"UPDATE department "
//					+ "SET Name = 'RH' " 
//					+ "WHERE "
//					+ "Id = 6"
//					);
			
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BirthDate = DATE_ADD(BirthDate, INTERVAL 2 MONTH) "
					+ "WHERE "
					+ "DepartmentId = 5"
					);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
