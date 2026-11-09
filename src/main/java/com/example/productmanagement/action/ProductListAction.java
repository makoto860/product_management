package com.example.productmanagement.action;

import java.util.List;

import com.example.productmanagement.dao.ProductDAO;
import com.example.productmanagement.model.Product;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport {

	private List<Product> productList;

    @Override
    public String execute() throws Exception {

        ProductDAO dao = new ProductDAO();
        productList = dao.findAll();

        return SUCCESS;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
