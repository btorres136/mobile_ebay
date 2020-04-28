package edu.mobile.ebay.DAO.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ProductOwners")
public class ProductOwners {

    @Id
    @GeneratedValue
    @Column(name = "ProductOwnerID", length = 11, nullable = false)
    private Long ProductOwnerID;

    @Column(name = "Rating", length = 11, nullable = false)
    private int Rating;

    @Column(name = "Description", length = 255, nullable = false)
    private String Description;

    @Column(name = "SalesMade", length = 20, nullable = false)
    private int SalesMade;

    @OneToOne
    @JoinColumn(name = "CustomerID")
    private Customers CustomerID;

    public ProductOwners() {
    }

    public ProductOwners(Long productOwnerID, int rating, String description, int salesMade, Customers customerID) {
        ProductOwnerID = productOwnerID;
        Rating = rating;
        Description = description;
        SalesMade = salesMade;
        CustomerID = customerID;
    }

    public Long getProductOwnerID() {
        return ProductOwnerID;
    }

    public void setProductOwnerID(Long productOwnerID) {
        ProductOwnerID = productOwnerID;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getSalesMade() {
        return SalesMade;
    }

    public void setSalesMade(int salesMade) {
        SalesMade = salesMade;
    }

    public Customers getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Customers customerID) {
        CustomerID = customerID;
    }

    @Override
    public String toString() {
        return "ProductOwners [CustomerID=" + CustomerID + ", Description=" + Description + ", ProductOwnerID="
                + ProductOwnerID + ", Rating=" + Rating + ", SalesMade=" + SalesMade + "]";
    }

    

}