/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 */
package in.jdsoft.educationmanagement.school.reports.model;

import in.jdsoft.educationmanagement.school.controller.SectionController;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log {
    private static Logger log = LogManager.getLogger((String)SectionController.class.getName());

    public static void main(String[] args) {
        log.error((Object)"Oh My God");
    }
}
