package edu.mobile.ebay.DAO.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productOwnerID")
@Entity
@Table(name = "ProductOwners")
public class ProductOwners {

    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "productOwnerID", length = 11, nullable = false)
    private Long productOwnerID;

    @Column(name = "rating", length = 11, nullable = false)
    private int rating;

    @Column(name = "description", length = 255, nullable = false)
    private String description;

    @Column(name = "salesMade", length = 20, nullable = false)
    private int salesMade;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "customerID")
    private Customers customerID;

    @Transient
    private String customerIdStr;


    public ProductOwners() {
    }

    public ProductOwners(Long productOwnerID, int rating, String description, int salesMade, Customers customerID, String customerIdStr) {
        this.productOwnerID = productOwnerID;
        this.rating = rating;
        this.description = description;
        this.salesMade = salesMade;
        this.customerID = customerID;
        this.customerIdStr = customerIdStr;
    }

    public Long getProductOwnerID() {
        return productOwnerID;
    }

    public void setProductOwnerID(Long productOwnerID) {
        this.productOwnerID = productOwnerID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSalesMade() {
        return salesMade;
    }

    public void setSalesMade(int salesMade) {
        this.salesMade = salesMade;
    }

    public Customers getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customers customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "ProductOwners [customerID=" + customerID + ", description=" + description + ", productOwnerID="
                + productOwnerID + ", rating=" + rating + ", salesMade=" + salesMade + "]";
    }

    public String getCustomerIdStr() {
        return customerIdStr;
    }

    public void setCustomerIdStr(String customerIdStr) {
        this.customerIdStr = customerIdStr;
    }
}