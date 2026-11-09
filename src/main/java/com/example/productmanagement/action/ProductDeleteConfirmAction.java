package com.example.productmanagement.action;

import com.example.productmanagement.dao.ProductDAO;
import com.example.productmanagement.model.Product;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDeleteConfirmAction extends ActionSupport {

    private int id;
    private Product product;

    @Override
    public String execute() throws Exception {

        ProductDAO dao = new ProductDAO();
        product = dao.findById(id);

        if (product == null) {
            addActionError("削除対象の商品が見つかりません。");
            return ERROR;
        }

        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
