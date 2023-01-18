package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Product;
import com.util.DBUtil;

public class ProductDALImpl implements ProductDAL {
	
	private Connection con;
	private Statement stmt;
	private ResultSet rset;
	
	private PreparedStatement pstmt1,pstmt2,psmt3;
	
	
	public ProductDALImpl() throws SQLException {
		// TODO Auto-generated constructor stub
		
		con=DBUtil.getCon();
		stmt=con.createStatement();
		System.out.println("---statement created for static queries");
		
		pstmt1=con.prepareStatement("insert into product values (?,?,?,?)");
		pstmt2=con.prepareStatement("update product set prodName=?,company=?,price=? where productId=?" );
		psmt3=con.prepareStatement("delete from product where productId=?");
		
		
		System.out.println("Prepared statement created");
		
		System.out.println("---Product DAL Implementation created---");
		
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		try {
			List<Product> allProducts=new ArrayList<Product>();
			
			rset=stmt.executeQuery("select * from product");
			
			while(rset.next()) {
				allProducts.add(new Product(rset.getInt("productId"), rset.getString("prodName"), rset.getString("company"), rset.getDouble("price")));
			}
			
			return allProducts;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public int addProduct(Product obj) {
		// TODO Auto-generated method stub
		
		try {
			pstmt1.setInt(1, obj.getProductId());
			pstmt1.setString(2, obj.getProdName());
			
			pstmt1.setString(3, obj.getCompany());
			pstmt1.setDouble(4, obj.getPrice());
			
			
			int i=pstmt1.executeUpdate();
			System.out.println("---inserted product:"+obj);
			return i;
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateProduct(Product obj) {
		//prodName=?,company=?,price=? where productId=?" );
		// TODO Auto-generated method stub
		try {
			pstmt2.setString(1,obj.getProdName());
			pstmt2.setString(2,obj.getCompany());
			pstmt2.setDouble(3,obj.getPrice());
			pstmt2.setInt(4,obj.getProductId());
			
			int i=pstmt2.executeUpdate();
			System.out.println("----updated obj:"+obj);
			return i;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		try {//productId=?
			psmt3.setInt(1,id);
			int i=psmt3.executeUpdate();
			return i;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
