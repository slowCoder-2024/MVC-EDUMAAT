/*
 * Decompiled with CFR 0.152.
 */
package in.jdsoft.educationmanagement.school.model;

public class FeesTermAndFeesStructure {
    private Long feesTermId;
    private Long feesStructureId;

    public FeesTermAndFeesStructure(Long feesTermId, Long feesStructureId) {
        this.feesTermId = feesTermId;
        this.feesStructureId = feesStructureId;
    }

    public Long getFeesTermId() {
        return this.feesTermId;
    }

    public void setFeesTermId(Long feesTermId) {
        this.feesTermId = feesTermId;
    }

    public Long getFeesStructureId() {
        return this.feesStructureId;
    }

    public void setFeesStructureId(Long feesStructureId) {
        this.feesStructureId = feesStructureId;
    }
}
