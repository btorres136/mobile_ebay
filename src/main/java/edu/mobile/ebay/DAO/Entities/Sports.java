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
    @Column(name = "SportsID", length = 11, nullable = false)
    private Long SportsID;

    @ManyToMany(mappedBy = "sportsProducts")
    private Set<Products> ProductsID;

}