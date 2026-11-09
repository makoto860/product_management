package com.example.productmanagement.action;

import com.example.productmanagement.dao.ProductDAO;
import com.example.productmanagement.model.Product;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {

	private String name;
	private int price;
	private String reservation;
	private int stock;
	private String caption;

	public String execute() {

        try {
            Product product = new Product();

            product.setName(name);
            product.setPrice(price);
            product.setReservation(reservation);
            product.setStock(stock);
            product.setCaption(caption);

            ProductDAO dao = new ProductDAO();
            dao.insert(product);

            return SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            addActionError("商品登録に失敗しました。");
            return INPUT;
        }
    }

	// getter / setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
