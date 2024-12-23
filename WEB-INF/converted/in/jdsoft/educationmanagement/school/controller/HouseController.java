/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.model.Houses;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.services.HousesService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value="houseController")
@RequestMapping(value={"/house"})
public class HouseController {
    private Logger log = LogManager.getLogger((String)HouseController.class.getName());
    @Autowired
    private HousesService housesService;
    @Autowired
    private InstitutionService institutionService;

    @RequestMapping(method={RequestMethod.GET})
    public ModelAndView displayHousePage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed house page"));
            ModelAndView modelandview = new ModelAndView("house");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("houses", this.housesService.housesList(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/add"})
    public String createHouse(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create house"));
            String houseName = request.getParameter("houseName");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            Houses houses = new Houses(houseName, institution);
            this.housesService.createHouses(houses);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "House Created Successfully...!"));
            return "redirect:/house";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/house";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/{id}"})
    @ResponseBody
    public Houses houseById(@PathVariable(value="id") Long houseId, HttpServletRequest request) {
        Houses house = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving house with id=" + houseId));
            house = this.housesService.housesById(houseId);
            return house;
        }
        catch (Exception e) {
            return house;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/delete"})
    public String deleteHouse(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long houseId = Long.parseLong(request.getParameter("deleteHouseId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting house with id=" + houseId));
            this.housesService.deleteHouses(houseId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "House Deleted Successfully...!"));
            return "redirect:/house";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/house";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/update"})
    public String updateHouse(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long houseId = Long.parseLong(request.getParameter("updateHouseId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating house with id=" + houseId));
            Houses house = this.housesService.housesById(houseId);
            String updatedHouseName = request.getParameter("editHouseName");
            house.setHouseName(updatedHouseName);
            this.housesService.updateHouses(house);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "House Updated Successfully...!"));
            return "redirect:/house";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/house";
        }
    }
}
