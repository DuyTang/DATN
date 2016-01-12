package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {

	private final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final String DRIVER_URL = "jdbc:sqlserver://localhost; databaseName=QuanLyLapTop;";
	private final String DB_USERNAME = "sa";
	private final String DB_PASSWORD = "12345678";

	public Connection con = null;

	public void openConnection() {
		try {
			Class.forName(DRIVER_CLASS);
			con = DriverManager.getConnection(DRIVER_URL, DB_USERNAME,
					DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		}
	}

	/**
	 * 
	 * @param sqlQuery
	 * @return ResultSet object after executing sqlQuery (ResultSet)
	 * @author Fresher234
	 */
	public ResultSet exeQuery(String sqlQuery) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sqlQuery);
			return rs;
		} catch (Exception e) {
			// if an exception raised, try to close connection
			e.printStackTrace();
			if (con != null) {
				closeConnection();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param sqlQuery
	 * @param param
	 * @return ResultSet object after executing sqlQuery (ResultSet)
	 * @author Fresher234
	 */
	public ResultSet exeQueryWithStringParam(String sqlQuery, String[] param) {
		try {
			PreparedStatement preSt = con.prepareStatement(sqlQuery);
			for (int i = 0; i < param.length; i++) {
				preSt.setString(i + 1, param[i]);
			}
			ResultSet rs = preSt.executeQuery();
			// preSt.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			// if an exception raised, try to close connection
			if (con != null) {
				closeConnection();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param sqlQuery
	 * @return number of affected row(s) after executing sqlQuery
	 * @throws SQLException
	 * @author Fresher234
	 */
	public int exeUpdate(String sqlQuery) throws SQLException {
		Statement st = con.createStatement();
		try {
			return st.executeUpdate(sqlQuery);
		} catch (Exception e) {
			e.printStackTrace();
			// if an exception raised, try to close connection
			if (con != null) {
				closeConnection();
			}
			return -1;
		}
	}

	/**
	 * 
	 * @param sqlQuery
	 * @param param
	 * @return number of affected row(s) after executing sqlQuery
	 * @author Fresher234
	 */
	public int exeUpdateWithStringParam(String sqlQuery, String[] param) {
		try {
			PreparedStatement preSt = con.prepareStatement(sqlQuery);
			for (int i = 0; i < param.length; i++) {
				preSt.setString(i + 1, param[i]);
			}
			return preSt.executeUpdate();
			// preSt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// if an exception raised, try to close connection
			if (con != null) {
				closeConnection();
			}
		}
		return -1;
	}

	public boolean exeBatch(PreparedStatement[] preSt) {

		return false;
	}

	public void closeConnection() {
		// TODO Auto-generated method stub
		try {
			if (!(con == null)) {
				con.close();
				System.out.println("DB connection is closed.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}