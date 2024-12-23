/*
 * Decompiled with CFR 0.152.
 */
package in.jdsoft.educationmanagement.school.model;

import in.jdsoft.educationmanagement.school.model.FeesItem;
import java.util.LinkedHashSet;
import java.util.Set;

public class FeesTermAndFeesItems {
    private Long feesTermId;
    private Set<FeesItem> feesItems = new LinkedHashSet<FeesItem>();

    public FeesTermAndFeesItems(Long feesTermId, Set<FeesItem> feesItems) {
        this.feesTermId = feesTermId;
        this.feesItems = feesItems;
    }

    public Long getFeesTermId() {
        return this.feesTermId;
    }

    public void setFeesTermId(Long feesTermId) {
        this.feesTermId = feesTermId;
    }

    public Set<FeesItem> getFeesItems() {
        return this.feesItems;
    }

    public void setFeesItems(Set<FeesItem> feesItems) {
        this.feesItems = feesItems;
    }
}
