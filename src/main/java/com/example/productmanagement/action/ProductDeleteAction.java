package com.example.productmanagement.action;

import com.example.productmanagement.dao.ProductDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDeleteAction extends ActionSupport {

    private int id;

    @Override
    public String execute() throws Exception {

        ProductDAO dao = new ProductDAO();
        dao.delete(id);

        addActionMessage("商品を削除しました。");

        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
