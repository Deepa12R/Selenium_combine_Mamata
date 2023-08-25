package generics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DataBaseUtility implements IAutoConstants {
	public Connection connection;
	/**
	 * This method is used to establish the database connection 
	 * @param url
	 * @param username
	 * @param password
	 */
	public void establishingTheConnection() {
		try {
			connection = DriverManager.getConnection(JDBC_URL,JDBC_UN,JDBC_PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * This method is used to read the data from database and returning list type 
	 * @param query
	 * @param columnName
	 * @return
	 */
	public List<String> readingDataFromDatabase(String query, String columnName) {
		Statement statement=null;
		ResultSet value =null;

		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			value = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> data=new ArrayList<String>();
		try {
			while (value.next()) {
				data.add(value.getString(columnName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;

	}
	/**
	 * This method is used to close the database connections
	 */
	public void CLosingDatabase() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
