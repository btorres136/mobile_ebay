package edu.mobile.ebay.DAO.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customers {

    @Id
    @GeneratedValue
    @Column(name= "CustomerID", length = 11, nullable = false)
    private Long CustomerID;

    @OneToOne(mappedBy = "CustomerID")
    private ProductOwners ProductOwnersID;

    @Column(name = "Name", nullable = false, length = 50)
    private String Name;

    @Column(name = "Rating", nullable = false, length = 10)
    private int Rating;

    @Column(name = "AccountCreated", nullable = false)
    private Date AccountCreated;

}