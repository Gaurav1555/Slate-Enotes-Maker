package com.Db;
import com.Db.DBConnect;
import com.User.UserDetails;
import com.DAO.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection conn;

	public static Connection getConn() {
		try {
			if (conn == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes2", "root","Gaurav@2002");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

}