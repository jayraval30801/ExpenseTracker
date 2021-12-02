package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.UserBean;
import util.DBConnection;


public class UserDao {
	
	public void insertUser(UserBean userbean) {
	try {
		Connection con = DBConnection.openconnection();
		PreparedStatement pstmt = con.prepareStatement("insert into user (FirstName,email,password) values (?,?,?)");
		pstmt.setString(1, userbean.getFirstName());
		pstmt.setString(2, userbean.getEmail());
		pstmt.setString(3, userbean.getPassword());
		
	int i = pstmt.executeUpdate();
	}catch(Exception e) {
			e.printStackTrace();
		
	}
	}
	
	public ArrayList<UserBean> getAllUser() {
	
		try {
			Connection con = DBConnection.openconnection();
			PreparedStatement pstmt = con.prepareStatement("select * from user");
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<UserBean> users = new ArrayList<>();
			

			while (rs.next()) {
				
				String FirstName = rs.getString("FirstName");
				String email = rs.getString("email");
				String password= rs.getString("password");
				
				UserBean userBean = new UserBean();
				
				userBean.setUserId(rs.getInt("UserId"));
				userBean.setFirstName(FirstName);
				userBean.setEmail(email);
				userBean.setPassword(password);
				
				users.add(userBean);
				
			}
			rs.close();
			return users;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
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