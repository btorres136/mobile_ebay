package edu.mobile.ebay.DAO.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue
    @Column(name = "ProductsID", length = 11, nullable = false)
    private Long ProductsID;

    @Column(name = "Description", nullable = false, length = 255)
    private String Description;

    @Column( name = "StartBid", nullable = false, length = 10)
    private int StartBid;

    @Column(name = "EndBid", nullable = false, length = 10)
    private int EndBid;

    @Column(name = "State", nullable = false, length = 30)
    private String State;

    @Column(name = "ImagePath", nullable = false, length = 255)
    private String ImagePath;

    @Column(name = "Quantity", nullable = false, length = 10)
    private int Quantity;

    @ManyToOne
    @JoinColumn(name = "ProductOwnerID", nullable = false)
    private ProductOwners ProductOwnersID;

    @ManyToMany
    @JoinTable(name="SportsProducts",
    joinColumns = @JoinColumn(name="ProductsID"), inverseJoinColumns = @JoinColumn(name = "SportsID"))
    private Set<Sports> sportsProducts;

    @ManyToMany
    @JoinTable(name="ElectronicsProducts", joinColumns = @JoinColumn(name = "ProductsID"), inverseJoinColumns = @JoinColumn(name = "ElectronicsID"))
    private Set<Electronics> electronicsProducts;

    @ManyToMany
    @JoinTable(name="AutomotiveProducts", joinColumns = @JoinColumn(name = "ProductsID"), inverseJoinColumns = @JoinColumn(name = "AutomotiveID"))
    private Set<Automotive> automotiveProducts;

    @OneToOne(mappedBy = "ProductsID")
    private Bids productsBids;
}