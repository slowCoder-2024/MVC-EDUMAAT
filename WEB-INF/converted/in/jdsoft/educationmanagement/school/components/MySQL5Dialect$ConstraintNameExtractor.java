/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.exception.spi.ViolatedConstraintNameExtracter
 */
package in.jdsoft.educationmanagement.school.components;

import java.sql.SQLException;
import org.hibernate.exception.spi.ViolatedConstraintNameExtracter;

private class MySQL5Dialect.ConstraintNameExtractor
implements ViolatedConstraintNameExtracter {
    private MySQL5Dialect.ConstraintNameExtractor() {
    }

    public String extractConstraintName(SQLException sqle) {
        String msg = sqle.getMessage();
        String constraintName = msg.substring(msg.indexOf("key") + 3, msg.length()).replace("'", "").trim();
        return constraintName;
    }
}
