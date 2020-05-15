package edu.mobile.ebay.DAO.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Bids")
public class Bids {
    @Id
    @GeneratedValue
    @Column(name = "bidID")
    private Long bidID;

    @Column(name = "bidQuantity", nullable = false, length = 10)
    private int bidQuantity;

    @Temporal(TemporalType.TIMESTAMP)
    private Date bidTimeSet;

    @ManyToOne
    @JoinColumn(name = "customerID", nullable = false)
    private Customers customerID;

    @ManyToOne
    @JoinColumn(name = "productsID", nullable = false)
    private Products productsID;

    public Bids() {
    }

    public Bids(Long bidID, int bidQuantity, Date bidTimeSet, Customers customerID, Products productsID) {
        this.productsID = productsID;
    }

    public Long getBidID() {
        return bidID;
    }

    public void setBidID(Long bidID) {
        this.bidID = bidID;
    }

    public int getBidQuantity() {
        return bidQuantity;
    }

    public void setBidQuantity(int bidQuantity) {
        this.bidQuantity = bidQuantity;
    }

    public Date getBidTimeSet() {
        return bidTimeSet;
    }

    public void setBidTimeSet(Date bidTimeSet) {
        this.bidTimeSet = bidTimeSet;
    }

    public Customers getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customers customerID) {
        this.customerID = customerID;
    }

    public Products getProductsID() {
        return productsID;
    }

    public void setProductsID(Products productsID) {
        this.productsID = productsID;
    }

    @Override
    public String toString() {
        return "Bids [bidID=" + bidID + ", bidQuantity=" + bidQuantity + ", bidTimeSet=" + bidTimeSet + ", customerID="
                + customerID + ", productsID=" + productsID + "]";
    }
}