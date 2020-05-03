package edu.mobile.ebay.DAO.Entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productsID", length = 11, nullable = false)
    private Long productsID;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column( name = "startBid", nullable = false, length = 10)
    private Date startBid;

    @Column(name = "endBid", nullable = false, length = 10)
    private Date endBid;

    @Column(name = "state", nullable = false, length = 30)
    private String state;

    @Column(name = "imagePath", length = 255)
    private String imagePath;

    @Column(name = "quantity", nullable = false, length = 10)
    private int quantity;

    @Column(name = "title", nullable=false, length = 30)
    private String title;

    @ManyToOne
    @JoinColumn(name = "productOwnerID", nullable = false)
    private ProductOwners productOwnersID;

    @ManyToMany
    @JoinTable(name="SportsProducts",
    joinColumns = @JoinColumn(name="productsID"), inverseJoinColumns = @JoinColumn(name = "sportsID"))
    private Set<Sports> sportsProducts;

    @ManyToMany
    @JoinTable(name="ElectronicsProducts", joinColumns = @JoinColumn(name = "productsID"), inverseJoinColumns = @JoinColumn(name = "electronicsID"))
    private Set<Electronics> electronicsProducts;

    @ManyToMany
    @JoinTable(name="AutomotiveProducts", joinColumns = @JoinColumn(name = "productsID"), inverseJoinColumns = @JoinColumn(name = "automotiveID"))
    private Set<Automotive> automotiveProducts;

    @OneToOne(mappedBy = "productsID")
    private Bids productsBids;

    public Products() {
    }

    public Products(Long productsID, String description, Date startBid, Date endBid, String state, String imagePath,
            int quantity, String title, ProductOwners productOwnersID, Set<Sports> sportsProducts,
            Set<Electronics> electronicsProducts, Set<Automotive> automotiveProducts, Bids productsBids) {
        this.productsID = productsID;
        this.description = description;
        this.startBid = startBid;
        this.endBid = endBid;
        this.state = state;
        this.imagePath = imagePath;
        this.quantity = quantity;
        this.title = title;
        this.productOwnersID = productOwnersID;
        this.sportsProducts = sportsProducts;
        this.electronicsProducts = electronicsProducts;
        this.automotiveProducts = automotiveProducts;
        this.productsBids = productsBids;
    }

    public Long getProductsID() {
        return productsID;
    }

    public void setProductsID(Long productsID) {
        this.productsID = productsID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartBid() {
        return startBid;
    }

    public void setStartBid(Date startBid) {
        this.startBid = startBid;
    }

    public Date getEndBid() {
        return endBid;
    }

    public void setEndBid(Date endBid) {
        this.endBid = endBid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductOwners getProductOwnersID() {
        return productOwnersID;
    }

    public void setProductOwnersID(ProductOwners productOwnersID) {
        this.productOwnersID = productOwnersID;
    }

    public Set<Sports> getSportsProducts() {
        return sportsProducts;
    }

    public void setSportsProducts(Set<Sports> sportsProducts) {
        this.sportsProducts = sportsProducts;
    }

    public Set<Electronics> getElectronicsProducts() {
        return electronicsProducts;
    }

    public void setElectronicsProducts(Set<Electronics> electronicsProducts) {
        this.electronicsProducts = electronicsProducts;
    }

    public Set<Automotive> getAutomotiveProducts() {
        return automotiveProducts;
    }

    public void setAutomotiveProducts(Set<Automotive> automotiveProducts) {
        this.automotiveProducts = automotiveProducts;
    }

    public Bids getProductsBids() {
        return productsBids;
    }

    public void setProductsBids(Bids productsBids) {
        this.productsBids = productsBids;
    }

    @Override
    public String toString() {
        return "Products [automotiveProducts=" + automotiveProducts + ", description=" + description
                + ", electronicsProducts=" + electronicsProducts + ", endBid=" + endBid + ", imagePath=" + imagePath
                + ", productOwnersID=" + productOwnersID + ", productsBids=" + productsBids + ", productsID="
                + productsID + ", quantity=" + quantity + ", sportsProducts=" + sportsProducts + ", startBid="
                + startBid + ", state=" + state + ", title=" + title + "]";
    }

}