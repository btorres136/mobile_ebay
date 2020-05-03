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
    @Column(name = "automotiveID", length = 11, nullable= false)
    private Long automotiveID;

    @Column(name = "AutoDescription", length = 250, nullable = false)
    private String autoDescription;

    @ManyToMany(mappedBy = "automotiveProducts")
    private Set<Products> productsID;

    public Automotive() {
    }

    public Automotive(Long automotiveID, String autoDescription, Set<Products> productsID) {
        this.automotiveID = automotiveID;
        this.autoDescription = autoDescription;
        this.productsID = productsID;
    }

    public Long getAutomotiveID() {
        return automotiveID;
    }

    public void setAutomotiveID(Long automotiveID) {
        this.automotiveID = automotiveID;
    }

    public String getAutoDescription() {
        return autoDescription;
    }

    public void setAutoDescription(String autoDescription) {
        this.autoDescription = autoDescription;
    }

    public Set<Products> getProductsID() {
        return productsID;
    }

    public void setProductsID(Set<Products> productsID) {
        this.productsID = productsID;
    }

    @Override
    public String toString() {
        return "Automotive [autoDescription=" + autoDescription + ", automotiveID=" + automotiveID + ", productsID="
                + productsID + "]";
    }
}