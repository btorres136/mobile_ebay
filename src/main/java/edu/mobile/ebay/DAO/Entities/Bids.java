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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bidID")
@Entity
@Table(name = "Bids")
public class Bids {
    @Id
    @GeneratedValue
    @Column(name = "bidID")
    private Long bidID;

    @Column(name = "bidQuantity", nullable = false, length = 10)
    private int bidQuantity;

    @Column(name = "bidTimeSet", nullable = false)
    private Date bidTimeSet;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customerID", nullable = false)
    private Customers customerID;

    @Transient
    private String customerIdStr;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "productsID", nullable = false)
    private Products productsID;

    @Transient
    private String productsIdStr;

    public Bids() {
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
                + customerID.getCustomerID() + ", productsID=" + productsID.getProductsID() + "]";
    }

    public String getCustomerIdStr() {
        return customerIdStr;
    }

    public void setCustomerIdStr(String customerIdStr) {
        this.customerIdStr = customerIdStr;
    }

    public String getProductsIdStr() {
        return productsIdStr;
    }

    public void setProductsIdStr(String productsIdStr) {
        this.productsIdStr = productsIdStr;
    }

    public Bids(Long bidID, int bidQuantity, Date bidTimeSet, Customers customerID, String customerIdStr,
            Products productsID, String productsIdStr) {
        this.bidID = bidID;
        this.bidQuantity = bidQuantity;
        this.bidTimeSet = bidTimeSet;
        this.customerID = customerID;
        this.customerIdStr = customerIdStr;
        this.productsID = productsID;
        this.productsIdStr = productsIdStr;
    }

    
}