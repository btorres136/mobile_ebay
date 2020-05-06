package edu.mobile.ebay.DAO.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Departments")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "departmentId", nullable = false, length = 11)
    private Long departmentId;

    @Column(name = "departmentName", nullable = false, length = 30)
    private String departmentName;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    public Departments() {
    }

    public Departments(Long departmentId, String departmentName, String description) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.description = description;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Departments [departmentId=" + departmentId + ", departmentName=" + departmentName + ", description="
                + description + "]";
    }
}

    