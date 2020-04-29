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
    @Column(name = "ProductsID", length = 11, nullable = false)
    private Long ProductsID;

    @Column(name = "Description", nullable = false, length = 255)
    private String Description;

    @Column( name = "StartBid", nullable = false, length = 10)
    private Date StartBid;

    @Column(name = "EndBid", nullable = false, length = 10)
    private Date EndBid;

    @Column(name = "State", nullable = false, length = 30)
    private String State;

    @Column(name = "ImagePath", length = 255)
    private String ImagePath;

    @Column(name = "Quantity", nullable = false, length = 10)
    private int Quantity;

    @Column(name = "Title", nullable=false, length = 30)
    private String Title;

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

    public Products() {
    }

    public Products(Long productsID, String description, Date startBid, Date endBid, String state, String imagePath,
            int quantity, String title, ProductOwners productOwnersID, Set<Sports> sportsProducts,
            Set<Electronics> electronicsProducts, Set<Automotive> automotiveProducts, Bids productsBids) {
        ProductsID = productsID;
        Description = description;
        StartBid = startBid;
        EndBid = endBid;
        State = state;
        ImagePath = imagePath;
        Quantity = quantity;
        Title = title;
        ProductOwnersID = productOwnersID;
        this.sportsProducts = sportsProducts;
        this.electronicsProducts = electronicsProducts;
        this.automotiveProducts = automotiveProducts;
        this.productsBids = productsBids;
    }

    public Long getProductsID() {
        return ProductsID;
    }

    public void setProductsID(Long productsID) {
        ProductsID = productsID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getStartBid() {
        return StartBid;
    }

    public void setStartBid(Date startBid) {
        StartBid = startBid;
    }

    public Date getEndBid() {
        return EndBid;
    }

    public void setEndBid(Date endBid) {
        EndBid = endBid;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public ProductOwners getProductOwnersID() {
        return ProductOwnersID;
    }

    public void setProductOwnersID(ProductOwners productOwnersID) {
        ProductOwnersID = productOwnersID;
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
        return "Products [Description=" + Description + ", EndBid=" + EndBid + ", ImagePath=" + ImagePath
                + ", ProductOwnersID=" + ProductOwnersID + ", ProductsID=" + ProductsID + ", Quantity=" + Quantity
                + ", StartBid=" + StartBid + ", State=" + State + ", Title=" + Title + ", automotiveProducts="
                + automotiveProducts + ", electronicsProducts=" + electronicsProducts + ", productsBids=" + productsBids
                + ", sportsProducts=" + sportsProducts + "]";
    }
}