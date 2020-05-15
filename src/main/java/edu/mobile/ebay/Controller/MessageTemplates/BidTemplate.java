package edu.mobile.ebay.Controller.MessageTemplates;

import java.util.Date;

public class BidTemplate {

    private int quantity;

    private Date date_set;

    private String product;

    public BidTemplate() {
    }

    public BidTemplate(int quantity, Date endDate, String product) {
        this.quantity = quantity;
        this.date_set = endDate;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getEndDate() {
        return date_set;
    }

    public void setEndDate(Date date_set) {
        this.date_set = date_set;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "BidTemplate [endDate=" + date_set + ", product=" + product + ", quantity=" + quantity + "]";
    }
}