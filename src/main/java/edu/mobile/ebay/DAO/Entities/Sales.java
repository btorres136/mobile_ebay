package edu.mobile.ebay.DAO.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Sales")
public class Sales {

    @Id
    @GeneratedValue
    @Column(name = "SalesID", nullable = false, length=11)
    private Long SalesID;

    @Column(name = "TransactionTime", nullable = false)
    private Date TransactionTime;

    @OneToOne
    private Products selledProduct;

    @OneToOne
    private ProductOwners seller;

    @OneToOne
    private Customers buyer;

}