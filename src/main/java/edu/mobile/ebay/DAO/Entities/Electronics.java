package edu.mobile.ebay.DAO.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Electronics")
public class Electronics {

    @Id
    @GeneratedValue
    @Column(name = "ElectronicsID", length = 11, nullable = false)
    private Long ElectronicsID;

    @ManyToMany(mappedBy = "electronicsProducts")
    private Set<Products> ProductsID;

    public Electronics() {
    }

    public Electronics(Long electronicsID, Set<Products> productsID) {
        ElectronicsID = electronicsID;
        ProductsID = productsID;
    }

    public Long getElectronicsID() {
        return ElectronicsID;
    }

    public void setElectronicsID(Long electronicsID) {
        ElectronicsID = electronicsID;
    }

    public Set<Products> getProductsID() {
        return ProductsID;
    }

    public void setProductsID(Set<Products> productsID) {
        ProductsID = productsID;
    }

    @Override
    public String toString() {
        return "Electronics [ElectronicsID=" + ElectronicsID + ", ProductsID=" + ProductsID + "]";
    }

    
    
}