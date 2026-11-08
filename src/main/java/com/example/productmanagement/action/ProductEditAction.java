package com.example.productmanagement.action;

import com.example.productmanagement.dao.ProductDAO;
import com.example.productmanagement.model.Product;
import com.opensymphony.xwork2.ActionSupport;

public class ProductEditAction extends ActionSupport {
	private int id;
    private String name;
    private int price;
    private String reservation;
    private int stock;
    private String caption;

    @Override
    public String execute() throws Exception {

        ProductDAO dao = new ProductDAO();
        Product product = dao.findById(id);

        if (product == null) {
            addActionError("商品が見つかりません。");
            return ERROR;
        }

        this.name = product.getName();
        this.price = product.getPrice();

        if (product.getReservation() != null
                && !product.getReservation().isBlank()) {
            this.reservation =
                    product.getReservation().substring(0, 16).replace(" ", "T");
        }

        this.stock = product.getStock();
        this.caption = product.getCaption();

        return SUCCESS;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public String getReservation() { return reservation; }
    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getCaption() { return caption; }
    public void setCaption(String caption) { this.caption = caption; }
}
