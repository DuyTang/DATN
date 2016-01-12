package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	public Connection cn =null;
	public void ConnectionData() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost; databaseName=QuanLyLapTop";
			this.cn = DriverManager.getConnection(url, "sa", "12345678");
			System.out.println("success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
