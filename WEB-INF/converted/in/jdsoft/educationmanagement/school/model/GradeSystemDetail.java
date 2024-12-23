/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIdentityInfo
 *  com.fasterxml.jackson.annotation.JsonIdentityReference
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.ObjectIdGenerators$IntSequenceGenerator
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.GradeSystem;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_grade_system_detail", uniqueConstraints={@UniqueConstraint(columnNames={"grade_title", "grade_system_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class GradeSystemDetail
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long gradeSystemDetailId;
    private GradeSystem gradeSystem;
    private String gradeTitle;
    private double fromMarks;
    private double toMarks;
    private double gradePoint;

    GradeSystemDetail() {
    }

    public GradeSystemDetail(GradeSystem gradeSystem, String gradeTitle, double fromMarks, double toMarks, double gradePoint) {
        this.gradeSystem = gradeSystem;
        this.gradeTitle = gradeTitle;
        this.fromMarks = fromMarks;
        this.toMarks = toMarks;
        this.gradePoint = gradePoint;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="grade_system_detail_id", nullable=false)
    public Long getGradeSystemDetailId() {
        return this.gradeSystemDetailId;
    }

    public void setGradeSystemDetailId(Long gradeSystemDetailId) {
        this.gradeSystemDetailId = gradeSystemDetailId;
    }

    @Column(name="grade_title", nullable=false, length=10)
    public String getGradeTitle() {
        return this.gradeTitle;
    }

    public void setGradeTitle(String gradeTitle) {
        this.gradeTitle = gradeTitle;
    }

    @Column(name="from_mark", nullable=false)
    public double getFromMarks() {
        return this.fromMarks;
    }

    public void setFromMarks(double fromMarks) {
        this.fromMarks = fromMarks;
    }

    @Column(name="to_marks", nullable=false)
    public double getToMarks() {
        return this.toMarks;
    }

    public void setToMarks(double toMarks) {
        this.toMarks = toMarks;
    }

    @Column(name="grade_point", nullable=false)
    public Double getGradePoint() {
        return this.gradePoint;
    }

    public void setGradePoint(Double gradePoint) {
        this.gradePoint = gradePoint;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="grade_system_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@gradeSystemDetails")
    @JsonIdentityReference(alwaysAsId=true)
    @ForeignKey(name="gradeSystemInGradeSystemDetail")
    public GradeSystem getGradeSystem() {
        return this.gradeSystem;
    }

    public void setGradeSystem(GradeSystem gradeSystem) {
        this.gradeSystem = gradeSystem;
    }
}
