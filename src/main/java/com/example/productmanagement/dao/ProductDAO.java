package com.example.productmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.productmanagement.model.Product;

public class ProductDAO {
	private static final String URL =
	        "jdbc:mysql://localhost:3306/product_management?serverTimezone=Asia/Tokyo&characterEncoding=UTF-8";

	private static final String USER = "root";
	private static final String PASSWORD = "khcoqfjcdh359";

	public void insert(Product product) throws Exception {

		// MySQL JDBCドライバーを読み込む
	    Class.forName("com.mysql.cj.jdbc.Driver");

	    String sql = "INSERT INTO products "
	        + "(name, price, reservation, stock, caption) "
	        + "VALUES (?, ?, ?, ?, ?)";

	    try (Connection conn =
	        DriverManager.getConnection(URL, USER, PASSWORD);
	        PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setString(1, product.getName());
	            pstmt.setInt(2, product.getPrice());

	            if (product.getReservation() == null
	                    || product.getReservation().isBlank()) {

	                pstmt.setNull(3, java.sql.Types.TIMESTAMP);

	            } else {

	                String reservation = product.getReservation().replace("T", " ");

	                if (reservation.length() == 16) {
	                    reservation += ":00";
	                }

	                pstmt.setTimestamp(3, Timestamp.valueOf(reservation));
	            }

	            pstmt.setInt(4, product.getStock());
	            pstmt.setString(5, product.getCaption());

	            pstmt.executeUpdate();
	        }
    }

	//一覧画面に表示する
	public List<Product> findAll() throws Exception {

		// MySQL JDBCドライバーを読み込む
	    Class.forName("com.mysql.cj.jdbc.Driver");

	    List<Product> productList = new ArrayList<>();

	    String sql = "SELECT * FROM products ORDER BY id DESC";

	    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) {

	        while (rs.next()) {
	            Product product = new Product();

	            product.setId(rs.getInt("id"));
	            product.setName(rs.getString("name"));
	            product.setPrice(rs.getInt("price"));

	            Timestamp reservation = rs.getTimestamp("reservation");
	            if (reservation != null) {
	                product.setReservation(reservation.toString());
	            }

	            product.setStock(rs.getInt("stock"));
	            product.setCaption(rs.getString("caption"));

	            productList.add(product);
	        }
	    }

	    return productList;
	}

	//詳細画面の処理
	public Product findById(int id) throws Exception {

	    Class.forName("com.mysql.cj.jdbc.Driver");

	    String sql = "SELECT * FROM products WHERE id = ?";

	    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setInt(1, id);

	        try (ResultSet rs = pstmt.executeQuery()) {

	            if (rs.next()) {
	                Product product = new Product();

	                product.setId(rs.getInt("id"));
	                product.setName(rs.getString("name"));
	                product.setPrice(rs.getInt("price"));

	                Timestamp reservation = rs.getTimestamp("reservation");
	                if (reservation != null) {
	                    product.setReservation(reservation.toString());
	                }

	                product.setStock(rs.getInt("stock"));
	                product.setCaption(rs.getString("caption"));

	                return product;
	            }
	        }
	    }

	    return null;
	}
}
