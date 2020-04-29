package edu.mobile.ebay.DAO.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mobile.ebay.DAO.Repositories.AutomotiveRepo;


@Entity
@Table(name = "Automotive")
public class Automotive {


    @Id
    @GeneratedValue
    @Column(name = "AutomotiveID", length = 11, nullable= false)
    private Long AutomotiveID;

    @Column(name = "AutoDescription", length = 250, nullable = false)
    private String AutoDescription;

    @ManyToMany(mappedBy = "automotiveProducts")
    private Set<Products> ProductsID;

    public Automotive() {
    
    }

    public Automotive(Long automotiveID, String autoDescription, Set<Products> productsID) {
        AutomotiveID = automotiveID;
        AutoDescription = autoDescription;
        ProductsID = productsID;
    }

    public Long getAutomotiveID() {
        return AutomotiveID;
    }

    public void setAutomotiveID(Long automotiveID) {
        AutomotiveID = automotiveID;
    }

    public String getAutoDescription() {
        return AutoDescription;
    }

    public void setAutoDescription(String autoDescription) {
        AutoDescription = autoDescription;
    }

    public Set<Products> getProductsID() {
        return ProductsID;
    }

    public void setProductsID(Set<Products> productsID) {
        ProductsID = productsID;
    }

    @Override
    public String toString() {
        return "Automotive [AutoDescription=" + AutoDescription + ", AutomotiveID=" + AutomotiveID + ", ProductsID="
                + ProductsID + "]";
    }

    
    
    
}