/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.GeographicalLocationDAO;
import in.jdsoft.educationmanagement.school.model.GeographicalLocation;
import in.jdsoft.educationmanagement.school.services.GeographicalLocationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="geographicalLocationService")
public class GeographicalLocationServiceImpl
implements GeographicalLocationService {
    @Autowired
    GeographicalLocationDAO geographicalLocationDAO;

    @Override
    public GeographicalLocation geographicalLocationById(Long geographicalLocationId) {
        try {
            GeographicalLocation geographicalLocation = this.geographicalLocationDAO.getGeographicalLocationById(geographicalLocationId);
            if (geographicalLocation != null) {
                log.info((Object)("geographical location with id=" + geographicalLocationId + " has been reterived"));
                return geographicalLocation;
            }
            log.info((Object)("No geographical location with  id=" + geographicalLocationId + " is available"));
            return geographicalLocation;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving geographical location by id=" + geographicalLocationId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<GeographicalLocation> countryList() {
        try {
            List<GeographicalLocation> geographicalLocations = this.geographicalLocationDAO.getGeographicalLocationCountryList();
            Integer geographicalLocationsSize = geographicalLocations.size();
            if (geographicalLocationsSize > 0) {
                log.info((Object)(geographicalLocationsSize + " country records where reterived"));
            } else {
                log.info((Object)"No country available");
            }
            return geographicalLocations;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving country list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<GeographicalLocation> stateList() {
        try {
            List<GeographicalLocation> geographicalLocations = this.geographicalLocationDAO.getGeographicalLocationStateList();
            Integer geographicalLocationsSize = geographicalLocations.size();
            if (geographicalLocationsSize > 0) {
                log.info((Object)(geographicalLocationsSize + " state records where reterived"));
            } else {
                log.info((Object)"No state available");
            }
            return geographicalLocations;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving state list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<GeographicalLocation> cityList() {
        try {
            List<GeographicalLocation> geographicalLocations = this.geographicalLocationDAO.getGeographicalLocationCityList();
            Integer geographicalLocationsSize = geographicalLocations.size();
            if (geographicalLocationsSize > 0) {
                log.info((Object)(geographicalLocationsSize + " city records where reterived"));
            } else {
                log.info((Object)"No city available");
            }
            return geographicalLocations;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving city list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<GeographicalLocation> stateList(Long countryId) {
        try {
            List<GeographicalLocation> geographicalLocations = this.geographicalLocationDAO.getStateListByCountry(countryId);
            Integer geographicalLocationsSize = geographicalLocations.size();
            if (geographicalLocationsSize > 0) {
                log.info((Object)(geographicalLocationsSize + " states records in country Id=" + countryId + "  where reterived"));
            } else {
                log.info((Object)"No state available for this country");
            }
            return geographicalLocations;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving state list of country", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<GeographicalLocation> cityList(Long stateId) {
        try {
            List<GeographicalLocation> geographicalLocations = this.geographicalLocationDAO.getCityListByState(stateId);
            Integer geographicalLocationsSize = geographicalLocations.size();
            if (geographicalLocationsSize > 0) {
                log.info((Object)(geographicalLocationsSize + " city records in state Id=" + stateId + " where reterived"));
            } else {
                log.info((Object)"No city available for this state");
            }
            return geographicalLocations;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving city list of state", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public GeographicalLocation geographicalLocationByName(String geographicalLocationName) {
        try {
            GeographicalLocation geographicalLocation = this.geographicalLocationDAO.getGeographicalLocationByName(geographicalLocationName);
            if (geographicalLocation != null) {
                log.info((Object)("geographical location with name=" + geographicalLocationName + " has been reterived"));
                return geographicalLocation;
            }
            log.info((Object)("No geographical location with  name=" + geographicalLocationName + " is available"));
            return geographicalLocation;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving geographical location by name=" + geographicalLocationName), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
