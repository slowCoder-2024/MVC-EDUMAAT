/*
 * Decompiled with CFR 0.152.
 */
package in.jdsoft.educationmanagement.school.components;

import in.jdsoft.educationmanagement.school.model.Admission;
import java.util.Comparator;

class AdmissionRuleHandler.1
implements Comparator<Admission> {
    AdmissionRuleHandler.1() {
    }

    @Override
    public int compare(Admission o1, Admission o2) {
        return o1.getTotal().compareTo(o2.getTotal());
    }
}
