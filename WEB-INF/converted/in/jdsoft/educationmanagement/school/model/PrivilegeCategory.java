/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.OneToMany
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.Privilege;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="tbl_privilege_category")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class PrivilegeCategory
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long privilegeCategoryId;
    private String privilegeCategoryName;
    private String aliasName;
    private Set<Privilege> privileges = new LinkedHashSet<Privilege>();

    private PrivilegeCategory() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="privilege_category_id", nullable=false)
    public Long getPrivilegeCategoryId() {
        return this.privilegeCategoryId;
    }

    public void setPrivilegeCategoryId(Long privilegeCategoryId) {
        this.privilegeCategoryId = privilegeCategoryId;
    }

    @Column(name="privilege_category_name", length=255)
    public String getPrivilegeCategoryName() {
        return this.privilegeCategoryName;
    }

    public void setPrivilegeCategoryName(String privilegeCategoryName) {
        this.privilegeCategoryName = privilegeCategoryName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="privilegeCategory")
    @OrderBy(value="privilegeId ASC")
    public Set<Privilege> getPrivileges() {
        return this.privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

    @Column(name="privilege_category_alias_name", nullable=true, length=255)
    public String getAliasName() {
        return this.aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }
}
