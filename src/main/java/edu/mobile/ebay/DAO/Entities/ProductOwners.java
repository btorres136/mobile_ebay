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

}