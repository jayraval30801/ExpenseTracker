package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection2 {
	public static void main(String args[]) {
		DBConnection.openconnection();
	
}

public static Connection openconnection() {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tracker";
	String username = "root";
	String password = "root";
	Connection con = null;
	try {
	Class.forName(driver);
	con = DriverManager.getConnection(url,username,password);
	}catch(Exception e) {
		System.out.println("Error : "+e.getMessage());
	}
	if(con == null) {
		System.out.println("Error");
	}else {
		System.out.println("DB connected");
	}
	return con;
}


}
