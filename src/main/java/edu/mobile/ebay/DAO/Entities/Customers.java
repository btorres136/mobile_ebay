package edu.mobile.ebay.DAO.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Customers")
public class Customers {

    @Id
    @Column(name= "customerID", length = 11, nullable = false)
    private String customerID;

    @OneToOne(mappedBy = "customerID")
    private ProductOwners productOwnersID;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "rating", nullable = false, length = 10)
    private int rating;

    @Temporal(TemporalType.TIMESTAMP)
    private Date accountCreated;

    @Column(name = "enable", nullable = false, length = 2)
    private int enable;

    public Customers() {
    }

    public Customers(String customerID, ProductOwners productOwnersID, String name, int rating, Date accountCreated,
            int enable) {
        this.customerID = customerID;
        this.productOwnersID = productOwnersID;
        this.name = name;
        this.rating = rating;
        this.accountCreated = accountCreated;
        this.enable = enable;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public ProductOwners getProductOwnersID() {
        return productOwnersID;
    }

    public void setProductOwnersID(ProductOwners productOwnersID) {
        this.productOwnersID = productOwnersID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(Date accountCreated) {
        this.accountCreated = accountCreated;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "Customers [accountCreated=" + accountCreated + ", customerID=" + customerID + ", enable=" + enable
                + ", name=" + name + ", productOwnersID=" + productOwnersID + ", rating=" + rating + "]";
    }
}