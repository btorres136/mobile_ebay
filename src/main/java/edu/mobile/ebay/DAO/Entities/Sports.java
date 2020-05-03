package edu.mobile.ebay.DAO.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Sports")
public class Sports {
    
    @Id
    @GeneratedValue
    @Column(name = "sportsID", length = 11, nullable = false)
    private Long sportsID;

    @ManyToMany(mappedBy = "sportsProducts")
    private Set<Products> productsID;

    public Sports() {
    }

    public Sports(Long sportsID, Set<Products> productsID) {
        this.sportsID = sportsID;
        this.productsID = productsID;
    }

    public Long getSportsID() {
        return sportsID;
    }

    public void setSportsID(Long sportsID) {
        this.sportsID = sportsID;
    }

    public Set<Products> getProductsID() {
        return productsID;
    }

    public void setProductsID(Set<Products> productsID) {
        this.productsID = productsID;
    }

    @Override
    public String toString() {
        return "Sports [productsID=" + productsID + ", sportsID=" + sportsID + "]";
    }
}