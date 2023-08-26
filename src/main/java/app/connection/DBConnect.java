package app.connection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnect {
	
	private Connection conn = null;

	public DBConnect() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String driver = "jdbc:ucanaccess://C:/Users/joshu/eclipse-workspace/CricketDB/CricketDB.accdb";
			conn = DriverManager.getConnection(driver);
			System.out.print("Connection successful");
//			JOptionPane.showMessageDialog(null, "Connection successful");

		} catch (Exception e) {
			System.out.print("Cannot connect to database.\n" + e);
//			JOptionPane.showMessageDialog(null, "Cannot connect to database.\n"+e);
		}
	}

	public ResultSet executeSelect(String query) {

		ResultSet resultSet = null;

		try {
			Statement stmt = conn.createStatement();
			String selectSql = query;
			resultSet = stmt.executeQuery(selectSql);
		} catch (SQLException e) {
			System.out.print("Error:.\n" + e);
//			JOptionPane.showMessageDialog(null, "Error:.\n"+e);
		}

		return resultSet;
	}

	public void executeQuery(String query) {
		try {
			PreparedStatement prepsInsertProduct = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			prepsInsertProduct.execute();

			System.out.println("Database insert completed successfully ");
		} catch (SQLException e) {
			System.out.print("Error:.\n" + e);
//			JOptionPane.showMessageDialog(null, "Error:.\n"+e);
		}
	}
}
