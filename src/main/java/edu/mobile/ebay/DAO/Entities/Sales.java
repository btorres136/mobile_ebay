package edu.mobile.ebay.DAO.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "salesID")
@Entity
@Table(name = "Sales")
public class Sales {

    @Id
    @GeneratedValue
    @Column(name = "salesID", nullable = false, length=11)
    private Long salesID;

    @Column(name = "transactionTime", nullable = false)
    private Date transactionTime;

    @JsonIgnore
    @OneToOne
    private Products selledProduct;

    @Transient
    private String selledProductIdStr;

    @JsonIgnore
    @OneToOne
    private ProductOwners seller;

    @Transient
    private String sellerIdStr;

    @JsonIgnore
    @OneToOne
    private Customers buyer;

    @Transient
    private String buyerIdStr;


    public Sales() {
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

    public String getSelledProductIdStr() {
        return selledProductIdStr;
    }

    public void setSelledProductIdStr(String selledProductIdStr) {
        this.selledProductIdStr = selledProductIdStr;
    }

    public String getSellerIdStr() {
        return sellerIdStr;
    }

    public void setSellerIdStr(String sellerIdStr) {
        this.sellerIdStr = sellerIdStr;
    }

    public String getBuyerIdStr() {
        return buyerIdStr;
    }

    public void setBuyerIdStr(String buyerIdStr) {
        this.buyerIdStr = buyerIdStr;
    }

    public Sales(Long salesID, Date transactionTime, Products selledProduct, String selledProductIdStr,
            ProductOwners seller, String sellerIdStr, Customers buyer, String buyerIdStr) {
        this.salesID = salesID;
        this.transactionTime = transactionTime;
        this.selledProduct = selledProduct;
        this.selledProductIdStr = selledProductIdStr;
        this.seller = seller;
        this.sellerIdStr = sellerIdStr;
        this.buyer = buyer;
        this.buyerIdStr = buyerIdStr;
    }
}