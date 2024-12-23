/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.dialect.MySQL5Dialect
 *  org.hibernate.exception.spi.ViolatedConstraintNameExtracter
 */
package in.jdsoft.educationmanagement.school.components;

import java.sql.SQLException;
import org.hibernate.exception.spi.ViolatedConstraintNameExtracter;

public class MySQL5Dialect
extends org.hibernate.dialect.MySQL5Dialect {
    private ViolatedConstraintNameExtracter constraintNameExtracter = new ConstraintNameExtractor();

    public ViolatedConstraintNameExtracter getViolatedConstraintNameExtracter() {
        return this.constraintNameExtracter;
    }

    private class ConstraintNameExtractor
    implements ViolatedConstraintNameExtracter {
        private ConstraintNameExtractor() {
        }

        public String extractConstraintName(SQLException sqle) {
            String msg = sqle.getMessage();
            String constraintName = msg.substring(msg.indexOf("key") + 3, msg.length()).replace("'", "").trim();
            return constraintName;
        }
    }
}
