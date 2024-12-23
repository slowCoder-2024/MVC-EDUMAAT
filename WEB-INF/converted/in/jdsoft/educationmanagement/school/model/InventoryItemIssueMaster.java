/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.CascadeType
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
import in.jdsoft.educationmanagement.school.model.InventoryItemReturnMaster;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_inventory_item_issue_master")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class InventoryItemIssueMaster
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long inventoryItemIssueAndReturnMasterId;
    private String location;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;
    private Date itemIssueDate;
    private Double noOfQtyIssue;
    private User issueToUser;
    private User inCharge;
    private InventoryItemMaster inventoryItemMaster;
    private AcademicYear academicYear;
    private Set<InventoryItemReturnMaster> inventoryItemReturnMaster = new LinkedHashSet<InventoryItemReturnMaster>();

    public InventoryItemIssueMaster(String location, String createdBy, Date itemIssueDate, Double noOfQtyIssue, User issueToUser, User inCharge, InventoryItemMaster inventoryItemMaster, AcademicYear academicYear) {
        this.location = location;
        this.createdBy = createdBy;
        this.itemIssueDate = itemIssueDate;
        this.noOfQtyIssue = noOfQtyIssue;
        this.issueToUser = issueToUser;
        this.inCharge = inCharge;
        this.inventoryItemMaster = inventoryItemMaster;
        this.academicYear = academicYear;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    InventoryItemIssueMaster() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="inventory_item_issue_master_id", unique=true, nullable=false)
    public Long getInventoryItemIssueAndReturnMasterId() {
        return this.inventoryItemIssueAndReturnMasterId;
    }

    public void setInventoryItemIssueAndReturnMasterId(Long inventoryItemIssueAndReturnMasterId) {
        this.inventoryItemIssueAndReturnMasterId = inventoryItemIssueAndReturnMasterId;
    }

    @Column(name="location", nullable=false, length=255)
    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name="created_by", nullable=false, length=100)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="modified_by", nullable=true, length=100)
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="created_date", nullable=false)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="modified_date", nullable=false, columnDefinition="timestamp")
    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="item_issue_date", nullable=true)
    public Date getItemIssueDate() {
        return this.itemIssueDate;
    }

    public void setItemIssueDate(Date itemIssueDate) {
        this.itemIssueDate = itemIssueDate;
    }

    @Column(name="no_of_qty_issue", nullable=true)
    public Double getNoOfQtyIssue() {
        return this.noOfQtyIssue;
    }

    public void setNoOfQtyIssue(Double noOfQtyIssue) {
        this.noOfQtyIssue = noOfQtyIssue;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="issue_to_user_id", nullable=true, referencedColumnName="user_id")
    public User getIssueToUser() {
        return this.issueToUser;
    }

    public void setIssueToUser(User issueToUser) {
        this.issueToUser = issueToUser;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="in_charge_user_id", nullable=true, referencedColumnName="user_id")
    public User getInCharge() {
        return this.inCharge;
    }

    public void setInCharge(User inCharge) {
        this.inCharge = inCharge;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="inventory_item_master_id", nullable=false, referencedColumnName="item_id")
    public InventoryItemMaster getInventoryItemMaster() {
        return this.inventoryItemMaster;
    }

    public void setInventoryItemMaster(InventoryItemMaster inventoryItemMaster) {
        this.inventoryItemMaster = inventoryItemMaster;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="inventoryItemIssueMaster", cascade={CascadeType.REMOVE})
    @ForeignKey(name="inventoryItemIssueMasterInInventoryItemReturnMaster")
    public Set<InventoryItemReturnMaster> getInventoryItemReturnMaster() {
        return this.inventoryItemReturnMaster;
    }

    public void setInventoryItemReturnMaster(Set<InventoryItemReturnMaster> inventoryItemReturnMaster) {
        this.inventoryItemReturnMaster = inventoryItemReturnMaster;
    }
}
