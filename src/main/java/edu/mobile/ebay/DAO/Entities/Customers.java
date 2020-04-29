package edu.mobile.ebay.DAO.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customers {

    @Id
    @GeneratedValue
    @Column(name= "CustomerID", length = 11, nullable = false)
    private Long CustomerID;

    @OneToOne(mappedBy = "CustomerID")
    private ProductOwners ProductOwnersID;

    @Column(name = "Name", nullable = false, length = 50)
    private String Name;

    @Column(name = "Rating", nullable = false, length = 10)
    private int Rating;

    @Column(name = "AccountCreated", nullable = false)
    private Date AccountCreated;

    public Customers() {
    }

    public Customers(Long customerID, ProductOwners productOwnersID, String name, int rating, Date accountCreated) {
        CustomerID = customerID;
        ProductOwnersID = productOwnersID;
        Name = name;
        Rating = rating;
        AccountCreated = accountCreated;
    }

    public Long getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Long customerID) {
        CustomerID = customerID;
    }

    public ProductOwners getProductOwnersID() {
        return ProductOwnersID;
    }

    public void setProductOwnersID(ProductOwners productOwnersID) {
        ProductOwnersID = productOwnersID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public Date getAccountCreated() {
        return AccountCreated;
    }

    public void setAccountCreated(Date accountCreated) {
        AccountCreated = accountCreated;
    }

    @Override
    public String toString() {
        return "Customers [AccountCreated=" + AccountCreated + ", CustomerID=" + CustomerID + ", Name=" + Name + ", ProductOwnersID=" + ProductOwnersID + ", Rating=" + Rating + "]";
    }

    
}