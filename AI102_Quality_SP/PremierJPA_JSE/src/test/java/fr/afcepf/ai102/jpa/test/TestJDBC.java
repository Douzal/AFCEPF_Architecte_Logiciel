package fr.afcepf.ai102.jpa.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/ai102_jpa", "root", "formation");
			
			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
