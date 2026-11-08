package com.example.productmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

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
}
