package edu.mobile.ebay.DAO.Entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productsID")
@Entity
@Table(name = "Products")
public class Products {

    
    @Id
    @Column(name = "productsID", length = 255, nullable = false)
    private String productsID;

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

    @Column(name = "title", nullable=false, length = 30)
    private String title;

    @Column(name = "itemPath", nullable = false, length = 255)
    private String itemPath;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "productOwnerID", nullable = false)
    private ProductOwners productOwnersID;

    @Transient
    private String ProductOwnersIdStr;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "departmentId", nullable = false)
    private Departments departmentId;

    @Transient
    private String departmentIdStr;
    
    @JsonIgnore
    @OneToOne(mappedBy = "productsID")
    private Bids productsBids;

    @Transient
    private String productsBidsStr;

    public Products() {
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

    public Bids getProductsBids() {
        return productsBids;
    }

    public void setProductsBids(Bids productsBids) {
        this.productsBids = productsBids;
    }

    //@JsonValue
    public String toJson(){
        
        String bidid ="none";
        

        return "{ \"prductsID\": " + productsID+
                ", description: " + description+
                ", departmentID: " + departmentId.getDepartmentId()+
                ", endBid: "+ endBid+
                ", startBid: " + startBid+
                ", imagePath: " + imagePath+
                ", itemPath: " + itemPath+
                ", productOwnersId: " + productOwnersID.getProductOwnerID() +
                ", productsBids: " + productsBids +
                ", state: " + state +
                ", title: " + title+"}";
                
    }
    @Override
    public String toString() {
        return "Products [departmentId=" + departmentId + ", description=" + description + ", endBid=" + endBid
                + ", imagePath=" + imagePath + ", itemPath=" + itemPath + ", productOwnersID=" + productOwnersID 
                + ", productsBids=" + productsBids + ", productsID=" + productsID + ", startBid=" + startBid
                + ", state=" + state + ", title=" + title + "]";
    }

    public String getProductOwnersIdStr() {
        return ProductOwnersIdStr;
    }

    public void setProductOwnersIdStr(String productOwnersIdStr) {
        ProductOwnersIdStr = productOwnersIdStr;
    }

    public String getDepartmentIdStr() {
        return departmentIdStr;
    }

    public void setDepartmentIdStr(String departmentIdStr) {
        this.departmentIdStr = departmentIdStr;
    }

    public String getProductsBidsStr() {
        return productsBidsStr;
    }

    public void setProductsBidsStr(String productsBidsStr) {
        this.productsBidsStr = productsBidsStr;
    }

    public Products(String productsID, String description, Date startBid, Date endBid, String state, String imagePath,
            String title, String itemPath, ProductOwners productOwnersID, String productOwnersIdStr,
            Departments departmentId, String departmentIdStr, Bids productsBids, String productsBidsStr) {
        this.productsID = productsID;
        this.description = description;
        this.startBid = startBid;
        this.endBid = endBid;
        this.state = state;
        this.imagePath = imagePath;
        this.title = title;
        this.itemPath = itemPath;
        this.productOwnersID = productOwnersID;
        ProductOwnersIdStr = productOwnersIdStr;
        this.departmentId = departmentId;
        this.departmentIdStr = departmentIdStr;
        this.productsBids = productsBids;
        this.productsBidsStr = productsBidsStr;
    }

    
}