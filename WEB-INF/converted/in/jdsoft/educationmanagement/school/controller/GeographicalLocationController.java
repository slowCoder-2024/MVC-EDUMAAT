/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.ResponseBody
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.model.GeographicalLocation;
import in.jdsoft.educationmanagement.school.services.GeographicalLocationService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value={"/geographicallocation"})
public class GeographicalLocationController {
    private Logger log = LogManager.getLogger((String)GeographicalLocationController.class.getName());
    @Autowired
    GeographicalLocationService geographicalLocationService;

    @RequestMapping(value={"state"}, method={RequestMethod.GET})
    @ResponseBody
    public List<GeographicalLocation> getGeographicalStateFromCountry(HttpServletRequest request) {
        try {
            String countryName = request.getParameter("country");
            Long countryId = this.geographicalLocationService.geographicalLocationByName(countryName).getGeographicalLocationId();
            List<GeographicalLocation> states = this.geographicalLocationService.stateList(countryId);
            this.log.info((Object)"State list of country reterived");
            return states;
        }
        catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value={"city"}, method={RequestMethod.GET})
    @ResponseBody
    public List<GeographicalLocation> getGeographicalCityFromState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String stateName = request.getParameter("state");
            Long stateId = this.geographicalLocationService.geographicalLocationByName(stateName).getGeographicalLocationId();
            List<GeographicalLocation> cities = this.geographicalLocationService.cityList(stateId);
            this.log.info((Object)"city list of state reterived");
            return cities;
        }
        catch (Exception e) {
            return null;
        }
    }
}
