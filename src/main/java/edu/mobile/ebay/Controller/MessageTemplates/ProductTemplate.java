package edu.mobile.ebay.Controller.MessageTemplates;

import java.util.Date;

public class ProductTemplate {

    private String Owner;

    private String id;

    private String Description;

    private Date endBid;

    private String state;

    private String imagePath;

    private String title;

    private String itemPath;

    private String Department;

    private int Bid;

    public ProductTemplate() {
    }

    public ProductTemplate(String owner, String id, String description, Date endBid, String state, String imagePath,
            String title, String itemPath, String department, int bid) {
        Owner = owner;
        this.id = id;
        Description = description;
        this.endBid = endBid;
        this.state = state;
        this.imagePath = imagePath;
        this.title = title;
        this.itemPath = itemPath;
        Department = department;
        Bid = bid;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public int getBid() {
        return Bid;
    }

    public void setBid(int bid) {
        Bid = bid;
    }

    @Override
    public String toString() {
        return "ProductTemplate [Bid=" + Bid + ", Department=" + Department + ", Description=" + Description
                + ", Owner=" + Owner + ", endBid=" + endBid + ", id=" + id + ", imagePath=" + imagePath + ", itemPath="
                + itemPath + ", state=" + state + ", title=" + title + "]";
    }
}