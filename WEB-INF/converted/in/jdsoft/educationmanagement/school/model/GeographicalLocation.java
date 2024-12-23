/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.Table
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_geographical_location")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class GeographicalLocation
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long geographicalLocationId;
    private String name;
    private int geographicalLocationType;
    private int parentId;
    private int isVisible;

    GeographicalLocation() {
    }

    public GeographicalLocation(String name, int geographicalLocationType, int parentId, int isVisible) {
        this.name = name;
        this.geographicalLocationType = geographicalLocationType;
        this.parentId = parentId;
        this.isVisible = isVisible;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="location_id", unique=true, nullable=false)
    public Long getGeographicalLocationId() {
        return this.geographicalLocationId;
    }

    public void setGeographicalLocationId(Long geographicalLocationId) {
        this.geographicalLocationId = geographicalLocationId;
    }

    @Column(name="name", nullable=false, length=30)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="location_type", nullable=false)
    public int getGeographicalLocationType() {
        return this.geographicalLocationType;
    }

    public void setGeographicalLocationType(int geographicalLocationType) {
        this.geographicalLocationType = geographicalLocationType;
    }

    @Column(name="parent_id", nullable=false)
    public int getParentId() {
        return this.parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Column(name="is_visible", nullable=false)
    public int getIsVisible() {
        return this.isVisible;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }
}
