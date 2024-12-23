/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.Id
 *  javax.persistence.Table
 *  org.apache.commons.lang.WordUtils
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang.WordUtils;

@Entity
@Table(name="tbl_currency")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class Currency
implements Serializable {
    private static final long serialVersionUID = 1L;
    private String isoCode;
    private String isoName;

    Currency() {
    }

    public Currency(String isoCode, String isoName) {
        this.isoCode = WordUtils.capitalize((String)isoCode);
        this.isoName = WordUtils.capitalize((String)isoName);
    }

    @Id
    @Column(name="iso", unique=true, nullable=false)
    public String getIsoCode() {
        return this.isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = WordUtils.capitalize((String)isoCode);
    }

    @Column(name="name", unique=true, nullable=false)
    public String getIsoName() {
        return this.isoName;
    }

    public void setIsoName(String isoName) {
        this.isoName = WordUtils.capitalize((String)isoName);
    }
}
