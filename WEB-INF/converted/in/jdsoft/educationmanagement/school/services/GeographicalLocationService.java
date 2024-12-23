/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.GeographicalLocation;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GeographicalLocationService {
    public static final Logger log = LogManager.getLogger((String)GeographicalLocationService.class.getName());

    public GeographicalLocation geographicalLocationById(Long var1);

    public List<GeographicalLocation> countryList();

    public List<GeographicalLocation> stateList();

    public List<GeographicalLocation> cityList();

    public List<GeographicalLocation> stateList(Long var1);

    public List<GeographicalLocation> cityList(Long var1);

    public GeographicalLocation geographicalLocationByName(String var1);
}
