package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnection2;

public class CategoryDao {
	
	public int insertCategory(String categoryName,String subcategoryName,String expense) {
		int i = -1;
		try {
			Connection con = DBConnection2.openconnection();
			PreparedStatement pstmt = con.prepareStatement("insert into category (categoryName,subcategoryName,expense) values (?,?,?)");
			pstmt.setString(1, categoryName);
			pstmt.setString(2, subcategoryName);
			pstmt.setString(3, expense);
			
			i = pstmt.executeUpdate();
		}catch(Exception e) {
				e.printStackTrace();
			
		}
			return i;
		}
	public ResultSet getAllCategory() {
		ResultSet rs = null;
		try {
			Connection con = DBConnection2.openconnection();
			PreparedStatement pstmt = con.prepareStatement("select * from category");
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public void deleteCategory(int categoryId) {

		try (Connection con = DBConnection2.openconnection();
				PreparedStatement pstmt = con.prepareStatement("delete from category where categoryId = ?");

		) {

			pstmt.setInt(1, categoryId);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getCategoryById(int categoryId) {
		ResultSet rs = null;
		try {
			Connection con = DBConnection2.openconnection();
			// insert query
			// Statement , PreparedStatement* , CallableStatement
			PreparedStatement pstmt = con.prepareStatement("select * from category where categoryId = ?");
			pstmt.setInt(1, categoryId);
			// execute
			rs = pstmt.executeQuery();// select

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public void updateCategory(int categoryId,String categoryName, String subcategoryName,String expense ) {

		try (Connection con = DBConnection2.openconnection();
				PreparedStatement pstmt = con
						.prepareStatement("update category set categoryName = ? , subcategoryName = ? ,expense = ? where categoryId = ? ");) {

			pstmt.setString(1, categoryName);
			pstmt.setString(2, subcategoryName);
			pstmt.setString(3, expense);
			pstmt.setInt(4, categoryId);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("category update");
			} else {
				System.out.println("category updation failed...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
