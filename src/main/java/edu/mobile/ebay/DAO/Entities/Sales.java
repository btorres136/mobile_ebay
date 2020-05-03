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
    @Column(name = "salesID", nullable = false, length=11)
    private Long salesID;

    @Column(name = "transactionTime", nullable = false)
    private Date transactionTime;

    @OneToOne
    private Products selledProduct;

    @OneToOne
    private ProductOwners seller;

    @OneToOne
    private Customers buyer;

    public Sales() {
    }

    public Sales(Long salesID, Date transactionTime, Products selledProduct, ProductOwners seller, Customers buyer) {
        this.salesID = salesID;
        this.transactionTime = transactionTime;
        this.selledProduct = selledProduct;
        this.seller = seller;
        this.buyer = buyer;
    }

    public Long getSalesID() {
        return salesID;
    }

    public void setSalesID(Long salesID) {
        this.salesID = salesID;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
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
        return "Sales [buyer=" + buyer + ", salesID=" + salesID + ", selledProduct=" + selledProduct + ", seller="
                + seller + ", transactionTime=" + transactionTime + "]";
    }
}