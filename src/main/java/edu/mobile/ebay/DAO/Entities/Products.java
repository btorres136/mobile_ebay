package edu.mobile.ebay.DAO.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "Products")
public class Products {


    @Id
    @Column(name = "productsID", length = 255, nullable = false)
    private String productsID;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startBid;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endBid;

    @Column(name = "state", nullable = false, length = 30)
    private String state;

    @Column(name = "imagePath", length = 255)
    private String imagePath;

    @Column(name = "title", nullable=false, length = 30)
    private String title;

    @Column(name = "itemPath", nullable = false, length = 255)
    private String itemPath;

    @Column(name = "enable", nullable = false, length = 2)
    private int enable;

    @ManyToOne
    @JoinColumn(name = "productOwnerID", nullable = false)
    private ProductOwners productOwnersID;

    @ManyToOne
    @JoinColumn(name = "departmentId", nullable = false)
    private Departments departmentId;

    @OneToMany(mappedBy = "productsID")
    private List<Bids> Bids;

    public Products() {
    }

    public Products(String productsID, String description, Date startBid, Date endBid, String state, String imagePath,
            String title, String itemPath, int enable, ProductOwners productOwnersID, Departments departmentId,
            List<edu.mobile.ebay.DAO.Entities.Bids> bids) {
        this.productsID = productsID;
        this.description = description;
        this.startBid = startBid;
        this.endBid = endBid;
        this.state = state;
        this.imagePath = imagePath;
        this.title = title;
        this.itemPath = itemPath;
        this.enable = enable;
        this.productOwnersID = productOwnersID;
        this.departmentId = departmentId;
        Bids = bids;
    }

    public String getProductsID() {
        return productsID;
    }

    public void setProductsID(String productsID) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getItemPath() {
        return itemPath;
    }

    public void setItemPath(String itemPath) {
        this.itemPath = itemPath;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public ProductOwners getProductOwnersID() {
        return productOwnersID;
    }

    public void setProductOwnersID(ProductOwners productOwnersID) {
        this.productOwnersID = productOwnersID;
    }

    public Departments getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Departments departmentId) {
        this.departmentId = departmentId;
    }

    public List<Bids> getBids() {
        return Bids;
    }

    public void setBids(List<Bids> bids) {
        Bids = bids;
    }

    @Override
    public String toString() {
        return "Products [Bids=" + Bids + ", departmentId=" + departmentId + ", description=" + description
                + ", enable=" + enable + ", endBid=" + endBid + ", imagePath=" + imagePath + ", itemPath=" + itemPath
                + ", productOwnersID=" + productOwnersID + ", productsID=" + productsID + ", startBid=" + startBid
                + ", state=" + state + ", title=" + title + "]";
    }
}