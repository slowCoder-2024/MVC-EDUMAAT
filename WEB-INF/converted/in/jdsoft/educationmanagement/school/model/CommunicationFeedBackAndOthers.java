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
 *  javax.persistence.CascadeType
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.JoinTable
 *  javax.persistence.ManyToMany
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
 *  javax.persistence.OneToOne
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersArchive;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersHistory;
import in.jdsoft.educationmanagement.school.model.CommunicationMessageMode;
import in.jdsoft.educationmanagement.school.model.CommunicationTargetGroup;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.PortalMessage;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_communication_feedback_and_others")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class CommunicationFeedBackAndOthers
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long communicationFeedBackAndOthersId;
    private String communicationFeedBackAndOthersSubject;
    private String communicationFeedBackAndOthersMessage;
    private String createdBy;
    private Date createdDate;
    private Integer status;
    private CommunicationTargetGroup communicationTargetGroup;
    private CommunicationMessageMode communicationMessageMode;
    private Set<User> targetUsers = new LinkedHashSet<User>();
    private Institution institution;
    private Set<CommunicationFeedBackAndOthersHistory> communicationFeedBackAndOthersHistory = new LinkedHashSet<CommunicationFeedBackAndOthersHistory>();
    private PortalMessage portalMessage;
    private CommunicationFeedBackAndOthersArchive communicationFeedBackAndOthersArchive;

    public CommunicationFeedBackAndOthers(String communicationFeedBackAndOthersSubject, String communicationFeedBackAndOthersMessage, String createdBy, Integer status, CommunicationTargetGroup communicationTargetGroup, CommunicationMessageMode communicationMessageMode, Set<User> targetUsers, Institution institution) {
        this.communicationFeedBackAndOthersSubject = communicationFeedBackAndOthersSubject;
        this.communicationFeedBackAndOthersMessage = communicationFeedBackAndOthersMessage;
        this.createdBy = createdBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.status = status;
        this.communicationTargetGroup = communicationTargetGroup;
        this.communicationMessageMode = communicationMessageMode;
        this.targetUsers = targetUsers;
        this.institution = institution;
    }

    CommunicationFeedBackAndOthers() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="communication_feedback_and_others_id", unique=true, nullable=false)
    public Long getCommunicationFeedBackAndOthersId() {
        return this.communicationFeedBackAndOthersId;
    }

    public void setCommunicationFeedBackAndOthersId(Long communicationFeedBackAndOthersId) {
        this.communicationFeedBackAndOthersId = communicationFeedBackAndOthersId;
    }

    @Column(name="communication_feedback_and_others_subject", nullable=true, length=255)
    public String getCommunicationFeedBackAndOthersSubject() {
        return this.communicationFeedBackAndOthersSubject;
    }

    public void setCommunicationFeedBackAndOthersSubject(String communicationFeedBackAndOthersSubject) {
        this.communicationFeedBackAndOthersSubject = communicationFeedBackAndOthersSubject;
    }

    @Column(name="communication_feedback_and_others_message", nullable=true, length=255)
    public String getCommunicationFeedBackAndOthersMessage() {
        return this.communicationFeedBackAndOthersMessage;
    }

    public void setCommunicationFeedBackAndOthersMessage(String communicationFeedBackAndOthersMessage) {
        this.communicationFeedBackAndOthersMessage = communicationFeedBackAndOthersMessage;
    }

    @Column(name="created_by", nullable=true, length=100)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="created_date", nullable=true, length=19)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="tbl_communication_feedback_and_others_users", joinColumns={@JoinColumn(name="communication_feedback_and_others_id", updatable=true, nullable=true)}, inverseJoinColumns={@JoinColumn(name="target_user_id", referencedColumnName="user_id", updatable=true, nullable=true)})
    @ForeignKey(name="communicationFeedBackAndOthersInUser")
    public Set<User> getTargetUsers() {
        return this.targetUsers;
    }

    public void setTargetUsers(Set<User> targetUsers) {
        this.targetUsers = targetUsers;
    }

    @Column(name="communication_feedback_and_others_status", nullable=false, length=10)
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="communication_target_group_id", nullable=false)
    @ForeignKey(name="communicationFeedBackAndOthersInCommunicationTargetGroup")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationFeedBackAndOthers")
    @JsonIdentityReference(alwaysAsId=true)
    public CommunicationTargetGroup getCommunicationTargetGroup() {
        return this.communicationTargetGroup;
    }

    public void setCommunicationTargetGroup(CommunicationTargetGroup communicationTargetGroup) {
        this.communicationTargetGroup = communicationTargetGroup;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="communication_message_mode_id", nullable=false)
    @ForeignKey(name="communicationFeedBackAndOthersInCommunicationMessageMode")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationFeedBackAndOthers")
    @JsonIdentityReference(alwaysAsId=true)
    public CommunicationMessageMode getCommunicationMessageMode() {
        return this.communicationMessageMode;
    }

    public void setCommunicationMessageMode(CommunicationMessageMode communicationMessageMode) {
        this.communicationMessageMode = communicationMessageMode;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="communicationFeedBackAndOthersInInstitution")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationFeedBackAndOthers")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="communicationFeedBackAndOthers", cascade={CascadeType.ALL})
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationFeedBackAndOthers")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<CommunicationFeedBackAndOthersHistory> getCommunicationFeedBackAndOthersHistory() {
        return this.communicationFeedBackAndOthersHistory;
    }

    public void setCommunicationFeedBackAndOthersHistory(Set<CommunicationFeedBackAndOthersHistory> communicationFeedBackAndOthersHistory) {
        this.communicationFeedBackAndOthersHistory = communicationFeedBackAndOthersHistory;
    }

    @OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
    @ForeignKey(name="communicationFeedBackAndOthersInPotalMessage")
    @JoinColumn(name="portal_message_id", nullable=true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationFeedBackAndOthers")
    @JsonIdentityReference(alwaysAsId=true)
    public PortalMessage getPortalMessage() {
        return this.portalMessage;
    }

    public void setPortalMessage(PortalMessage portalMessage) {
        this.portalMessage = portalMessage;
    }

    @OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
    @ForeignKey(name="communicationFeedBackAndOthersInCommunicationFeedBackAndOthersArchive")
    @JoinColumn(name="communication_feedback_and_others_archive_id", nullable=true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationFeedBackAndOthers")
    @JsonIdentityReference(alwaysAsId=true)
    public CommunicationFeedBackAndOthersArchive getCommunicationFeedBackAndOthersArchive() {
        return this.communicationFeedBackAndOthersArchive;
    }

    public void setCommunicationFeedBackAndOthersArchive(CommunicationFeedBackAndOthersArchive communicationFeedBackAndOthersArchive) {
        this.communicationFeedBackAndOthersArchive = communicationFeedBackAndOthersArchive;
    }
}
