package edu.mobile.ebay.Controller.MessageTemplates;

public class DepartmentTemplate {

    private Long departmentId;

    private String departmentName;

    public DepartmentTemplate() {
    }

    public DepartmentTemplate(Long departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
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

    @Override
    public String toString() {
        return "DepartmentTemplate [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
    }
}