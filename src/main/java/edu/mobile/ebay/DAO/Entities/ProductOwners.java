package edu.mobile.ebay.DAO.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



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

    @Column(name = "enable", nullable = false, length = 2)
    private int enable;

    @OneToOne
    @JoinColumn(name = "customerID", nullable = false)
    private Customers customerID;

    public ProductOwners() {
    }

    public ProductOwners(Long productOwnerID, int rating, String description, int salesMade, int enable,
            Customers customerID) {
        this.productOwnerID = productOwnerID;
        this.rating = rating;
        this.description = description;
        this.salesMade = salesMade;
        this.enable = enable;
        this.customerID = customerID;
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
	
    public void setalgo(){
	System.out.println("Hello World");
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

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public Customers getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customers customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "ProductOwners [customerID=" + customerID + ", description=" + description + ", enable=" + enable
                + ", productOwnerID=" + productOwnerID + ", rating=" + rating + ", salesMade=" + salesMade + "]";
    }
}
