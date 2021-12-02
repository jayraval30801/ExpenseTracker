package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.CategoryBean;
import util.DBConnection2;

public class CategoryDao {
	
	public void insertCategory(CategoryBean categorybean) {
		
		try {
			Connection con = DBConnection2.openconnection();
			PreparedStatement pstmt = con.prepareStatement("insert into category (categoryName,subcategoryName,expense) values (?,?,?)");
			pstmt.setString(1, categorybean.getCategoryName());
			pstmt.setString(2, categorybean.getSubcategoryName());
			pstmt.setString(3, categorybean.getExpense());
			
			 int i = pstmt.executeUpdate();
		}catch(Exception e) {
				e.printStackTrace();
			
		}
		}
	public ArrayList<CategoryBean> getAllCategory() {
		try {
			Connection con = DBConnection2.openconnection();
			PreparedStatement pstmt = con.prepareStatement("select * from category");
			ResultSet rs = pstmt.executeQuery();
			ArrayList<CategoryBean> category = new ArrayList<>();
			
	while (rs.next()) {
				
				String CategoryName = rs.getString("categoryName");
				String SubCategoryName = rs.getString("subcategoryName");
				String Expense= rs.getString("expense");
				
			CategoryBean  categoryBean = new CategoryBean();
				
				categoryBean.setCategoryId(rs.getInt("CategoryId"));
				categoryBean.setCategoryName(CategoryName);
				categoryBean.setSubcategoryName(SubCategoryName);
				categoryBean.setExpense(Expense);
				
				category.add(categoryBean);
				
			}
			rs.close();
			return category;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
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
