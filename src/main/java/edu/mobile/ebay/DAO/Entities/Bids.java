package edu.mobile.ebay.DAO.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Bids")
public class Bids {
    @Id
    @GeneratedValue
    @Column(name = "BidID")
    private Long BidID;

    @Column(name = "BidQuantity", nullable = false, length = 10)
    private int BidQuantity;

    @Column(name = "BidTimeSet", nullable = false)
    private Date BidTimeSet;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customers CustomerID;

    @OneToOne
    @JoinColumn(name = "ProductsID", nullable = false)
    private Products ProductsID;

    public Bids() {
    }

    public Bids(Long bidID, int bidQuantity, Date bidTimeSet, Customers customerID, Products productsID) {
        BidID = bidID;
        BidQuantity = bidQuantity;
        BidTimeSet = bidTimeSet;
        CustomerID = customerID;
        ProductsID = productsID;
    }

    public Long getBidID() {
        return BidID;
    }

    public void setBidID(Long bidID) {
        BidID = bidID;
    }

    public int getBidQuantity() {
        return BidQuantity;
    }

    public void setBidQuantity(int bidQuantity) {
        BidQuantity = bidQuantity;
    }

    public Date getBidTimeSet() {
        return BidTimeSet;
    }

    public void setBidTimeSet(Date bidTimeSet) {
        BidTimeSet = bidTimeSet;
    }

    public Customers getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Customers customerID) {
        CustomerID = customerID;
    }

    public Products getProductsID() {
        return ProductsID;
    }

    public void setProductsID(Products productsID) {
        ProductsID = productsID;
    }

    @Override
    public String toString() {
        return "Bids [BidID=" + BidID + ", BidQuantity=" + BidQuantity + ", BidTimeSet=" + BidTimeSet + ", CustomerID="
                + CustomerID + ", ProductsID=" + ProductsID + "]";
    }

    
}