package edu.mobile.ebay.DAO.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Bids")
public class Bids {
    @Id
    @GeneratedValue
    @Column(name = "BidID")
    private Long BidID;

    @Column(name = "BidQuantity", nullable = false, length = 10)
    private int BidQuantity;

    @Column(name = "BidTimeSet", nullable = false)
    private Date BidTimeSet;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customers CustomerID;

    @OneToOne
    @JoinColumn(name = "ProductsID", nullable = false)
    private Products ProductsID;
}