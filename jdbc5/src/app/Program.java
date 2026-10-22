package app;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 1200 WHERE DepartmentId = 1");
			
//			int y = 1;
//			if (y < 2) {
//				throw new SQLException("Fake error");
//			}
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 5000 WHERE DepartmentId = 2");
			
			conn.commit();
			
			System.out.println("Rows affected in operation #1 = " + rows1);
			System.out.println("Rows affected in operation #2 = " + rows2);
		}
		catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back! Cause by " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Transaction partially executed; rollback was not possible. " + e1.getMessage());
			}
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
