package com.projectname.util.Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class DatabaseConnection {

	public static Connection getConnection() throws IOException {
		try {
			Properties props = new Properties();
			String dbPropfile = System.getProperty("user.dir")
					+ ".\\src\\main\\java\\com\\payroll\\config\\db.properties";
			FileInputStream in = new FileInputStream(dbPropfile);
			props.load(in);
			in.close();
			String dbUrl = props.getProperty("DB_URL");
			String dbUser = props.getProperty("DB_USERNAME");
			String dbPass = props.getProperty("DB_PASSWORD");
			String dbName = props.getProperty("DB_NAME");
			boolean winAuth = props.getProperty("WINDOWS_AUTH").equals("YES") ? true : false;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			if (winAuth) {
				String JDBC_URL = "jdbc:sqlserver://" + dbUrl + ";databaseName=" + dbName + ";integratedSecurity=true";
				return DriverManager.getConnection(JDBC_URL);
			} else {
				String JDBC_URL = "jdbc:sqlserver://" + dbUrl + ";databaseName=" + dbName;
				return DriverManager.getConnection(JDBC_URL, dbUser, dbPass);
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<String> getVendorRoute(String id) throws IOException {
		Connection con = DatabaseConnection.getConnection();

		Statement stmt;
		ArrayList<String> vendorapproverlist = new ArrayList<String>();
		try {
			stmt = con.createStatement();

			String SQL = "select * from  Requestapproverdetail where approvaltypeid=11 and requestid=" + id
					+ "order by RouteGroupID,GroupOrderID,OrderID";
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.println(rs.getString("ApproverName"));
				vendorapproverlist.add(rs.getString("ApproverName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vendorapproverlist;
	}
}