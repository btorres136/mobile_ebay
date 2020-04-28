package edu.mobile.ebay.DAO.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Sales")
public class Sales {

    @Id
    @GeneratedValue
    @Column(name = "SalesID", nullable = false, length=11)
    private Long SalesID;

    @Column(name = "TransactionTime", nullable = false)
    private Date TransactionTime;

    @OneToOne
    private Products selledProduct;

    @OneToOne
    private ProductOwners seller;

    @OneToOne
    private Customers buyer;

    public Sales() {
    }

    public Sales(Long salesID, Date transactionTime, Products selledProduct, ProductOwners seller, Customers buyer) {
        SalesID = salesID;
        TransactionTime = transactionTime;
        this.selledProduct = selledProduct;
        this.seller = seller;
        this.buyer = buyer;
    }

    public Long getSalesID() {
        return SalesID;
    }

    public void setSalesID(Long salesID) {
        SalesID = salesID;
    }

    public Date getTransactionTime() {
        return TransactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        TransactionTime = transactionTime;
    }

    public Products getSelledProduct() {
        return selledProduct;
    }

    public void setSelledProduct(Products selledProduct) {
        this.selledProduct = selledProduct;
    }

    public ProductOwners getSeller() {
        return seller;
    }

    public void setSeller(ProductOwners seller) {
        this.seller = seller;
    }

    public Customers getBuyer() {
        return buyer;
    }

    public void setBuyer(Customers buyer) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "Sales [SalesID=" + SalesID + ", TransactionTime=" + TransactionTime + ", buyer=" + buyer
                + ", selledProduct=" + selledProduct + ", seller=" + seller + "]";
    }

    
}