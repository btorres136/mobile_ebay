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
    @Column(name = "electronicsID", length = 11, nullable = false)
    private Long electronicsID;

    @ManyToMany(mappedBy = "electronicsProducts")
    private Set<Products> productsID;

    public Electronics() {
    }

    public Electronics(Long electronicsID, Set<Products> productsID) {
        this.electronicsID = electronicsID;
        this.productsID = productsID;
    }

    public Long getElectronicsID() {
        return electronicsID;
    }

    public void setElectronicsID(Long electronicsID) {
        this.electronicsID = electronicsID;
    }

    public Set<Products> getProductsID() {
        return productsID;
    }

    public void setProductsID(Set<Products> productsID) {
        this.productsID = productsID;
    }

    @Override
    public String toString() {
        return "Electronics [electronicsID=" + electronicsID + ", productsID=" + productsID + "]";
    }
}