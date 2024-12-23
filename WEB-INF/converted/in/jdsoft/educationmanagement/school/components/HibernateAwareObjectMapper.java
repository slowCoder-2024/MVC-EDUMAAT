/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.Module
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module
 */
package in.jdsoft.educationmanagement.school.components;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper
extends ObjectMapper {
    private static final long serialVersionUID = 1L;

    public HibernateAwareObjectMapper() {
        Hibernate4Module hm = new Hibernate4Module();
        this.registerModule((Module)hm);
    }
}
