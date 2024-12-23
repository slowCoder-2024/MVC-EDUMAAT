/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Component
 */
package in.jdsoft.educationmanagement.school.components;

import java.util.HashSet;
import org.springframework.stereotype.Component;

@Component
public class ExceptionComparator {
    public String containsWord(String sentence) {
        HashSet<String> hwords = new HashSet<String>();
        hwords.add("exam_template_name");
        hwords.add("term_name");
        hwords.add("term_exam_name");
        hwords.add("time_table_name");
        hwords.add("time_table_template_day_name");
        hwords.add("time_table_template_hour_name");
        hwords.add("grade_system_name");
        hwords.add("grade_title");
        hwords.add("role_name");
        hwords.add("class_name");
        hwords.add("section_name");
        hwords.add("special_category_name");
        hwords.add("ledger_account_name");
        hwords.add("ledger_reference_number");
        hwords.add("academic_year_title");
        hwords.add("template_item_name");
        hwords.add("template_name");
        hwords.add("admission_no");
        hwords.add("email");
        hwords.add("roll_no");
        hwords.add("class_id");
        hwords.add("section_id");
        hwords.add("fees_term_name");
        hwords.add("fees_term_order");
        hwords.add("duplicate_fees_term");
        hwords.add("duplicate_order_no");
        hwords.add("institution_id");
        for (String word : hwords) {
            if (!sentence.contains(word)) continue;
            return word;
        }
        return null;
    }
}
