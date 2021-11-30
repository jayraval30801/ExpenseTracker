package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnection;


public class UserDao {
	
	public int insertUser(String FirstName,String email,String password) {
	int i = -1;
	try {
		Connection con = DBConnection.openconnection();
		PreparedStatement pstmt = con.prepareStatement("insert into user (FirstName,email,password) values (?,?,?)");
		pstmt.setString(1, FirstName);
		pstmt.setString(2, email);
		pstmt.setString(3, password);
		
		i = pstmt.executeUpdate();
	}catch(Exception e) {
			e.printStackTrace();
		
	}
		return i;
	}
	
	public ResultSet getAllUser() {
		ResultSet rs = null;
		try {
			Connection con = DBConnection.openconnection();
			PreparedStatement pstmt = con.prepareStatement("select * from user");
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void deleteUser(int userId) {

		try (Connection con = DBConnection.openconnection();
				PreparedStatement pstmt = con.prepareStatement("delete from user where userId = ?");

		) {

			pstmt.setInt(1, userId);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ResultSet getUserById(int userId) {
		ResultSet rs = null;
		try {
			Connection con = DBConnection.openconnection();
			// insert query
			// Statement , PreparedStatement* , CallableStatement
			PreparedStatement pstmt = con.prepareStatement("select * from user where userId = ?");
			pstmt.setInt(1, userId);
			// execute
			rs = pstmt.executeQuery();// select

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void updateUser(int userId,String FirstName,String email,String password) {

		try (Connection con = DBConnection.openconnection();
				PreparedStatement pstmt = con
						.prepareStatement("update user set FirstName = ?, email = ? , password = ? where userId = ? ");) {

			pstmt.setString(1, FirstName);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setInt(4, userId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("User Updated");
			} else {
				System.out.println("User updation failed...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public ResultSet getUserByName(String FirstName) {

		ResultSet rs = null;
		try {

			Connection con = DBConnection.openconnection();
			PreparedStatement pstmt = con.prepareStatement("select * from user where FirstName like ?");
			pstmt.setString(1, FirstName);

			rs = pstmt.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}