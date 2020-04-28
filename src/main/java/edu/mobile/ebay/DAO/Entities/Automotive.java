package edu.mobile.ebay.DAO.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Automotive")
public class Automotive {

    @Id
    @GeneratedValue
    @Column(name = "AutomotiveID", length = 11, nullable= false)
    private Long AutomotiveID;

    @ManyToMany(mappedBy = "automotiveProducts")
    private Set<Products> ProductsID;

    public Automotive() {
    
    }

    public Automotive(Long automotiveID, Set<Products> productsID) {
        AutomotiveID = automotiveID;
        ProductsID = productsID;
    }

    public Long getAutomotiveID() {
        return AutomotiveID;
    }

    public void setAutomotiveID(Long automotiveID) {
        AutomotiveID = automotiveID;
    }

    public Set<Products> getProductsID() {
        return ProductsID;
    }

    public void setProductsID(Set<Products> productsID) {
        ProductsID = productsID;
    }

    @Override
    public String toString() {
        return "Automotive [AutomotiveID=" + AutomotiveID + ", ProductsID=" + ProductsID + "]";
    }
    
    
    
}