package edu.mobile.ebay.DAO.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    @Column(name = "accountCreated", nullable = false)
    private Date accountCreated;

    public Customers() {
    }

    public Customers(String customerID, ProductOwners productOwnersID, String name, int rating, Date accountCreated) {
        this.customerID = customerID;
        this.productOwnersID = productOwnersID;
        this.name = name;
        this.rating = rating;
        this.accountCreated = accountCreated;
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

    @Override
    public String toString() {
        return "Customers [accountCreated=" + accountCreated + ", customerID=" + customerID + ", name=" + name
                + ", productOwnersID=" + productOwnersID + ", rating=" + rating + "]";
    }
}