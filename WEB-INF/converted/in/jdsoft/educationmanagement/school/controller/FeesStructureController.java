/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.security.access.prepost.PreAuthorize
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.exceptions.FeesPenaltySettingException;
import in.jdsoft.educationmanagement.school.model.FeesItem;
import in.jdsoft.educationmanagement.school.model.FeesPenaltySetting;
import in.jdsoft.educationmanagement.school.model.FeesStructure;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.services.FeesItemService;
import in.jdsoft.educationmanagement.school.services.FeesPenaltySettingService;
import in.jdsoft.educationmanagement.school.services.FeesStructureService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import java.util.HashSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value={"/feesStructure"})
public class FeesStructureController {
    private Logger log = LogManager.getLogger((String)FeesStructureController.class.getName());
    @Autowired
    private FeesStructureService feesStructureService;
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private FeesItemService feesItemService;
    @Autowired
    private FeesPenaltySettingService feesPenaltySettingService;

    @RequestMapping(method={RequestMethod.GET})
    @PreAuthorize(value="hasAuthority('feesstructure')")
    public ModelAndView displayFeesStructurePage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed feesStructure page"));
            ModelAndView modelandview = new ModelAndView("feesstructure");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("feesStructures", this.feesStructureService.feesStructureListEager(institutionId));
            modelandview.addObject("feesItems", this.feesItemService.feesItemList(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/feespenaltysetting"})
    public ModelAndView displayFeesPenaltySettingPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed feesPenaltySetting page"));
            ModelAndView modelandview = new ModelAndView("feespenaltysetting");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("feesPenaltySettingList", this.feesPenaltySettingService.feesPenaltySettingListByInstitution(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/add"})
    @PreAuthorize(value="hasAuthority('feesstructure/add')")
    public String createFeesStructure(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create feesStructure"));
            String feesStructureName = request.getParameter("feesStructureName");
            String[] feesItemsId = request.getParameterValues("feesItemList");
            HashSet<FeesItem> feesItems = new HashSet<FeesItem>();
            String[] stringArray = feesItemsId;
            int n = feesItemsId.length;
            int n2 = 0;
            while (n2 < n) {
                String feesItemId = stringArray[n2];
                feesItems.add(this.feesItemService.feesItemById(Long.parseLong(feesItemId)));
                ++n2;
            }
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            this.feesStructureService.createFeesStructure(new FeesStructure(feesStructureName, institution, feesItems));
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Fees Structure Created Successfully...!"));
            return "redirect:/feesStructure";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/feesStructure";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/{id}"})
    @ResponseBody
    @PreAuthorize(value="hasAuthority('feesstructure/view')")
    public FeesStructure feesStructureById(@PathVariable(value="id") Long feesStructureId, HttpServletRequest request) {
        FeesStructure feesStructure = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving feesStructure with id=" + feesStructureId));
            feesStructure = this.feesStructureService.feesStructureByIdEager(feesStructureId);
            return feesStructure;
        }
        catch (Exception e) {
            return feesStructure;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/delete"})
    @PreAuthorize(value="hasAuthority('feesstructure/delete')")
    public String deleteFeesStructure(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long feesStructureId = Long.parseLong(request.getParameter("deleteFeesStructureId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting feesStructure with id=" + feesStructureId));
            this.feesStructureService.deleteFeesStructure(feesStructureId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Fees Structure Deleted Successfully...!"));
            return "redirect:/feesStructure";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/feesStructure";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/update"})
    @PreAuthorize(value="hasAuthority('feesstructure/update')")
    public String updateFeesStructure(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long feesStructureId = Long.parseLong(request.getParameter("updateFeesStructureId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating feesStructure with id=" + feesStructureId));
            FeesStructure feesStructure = this.feesStructureService.feesStructureById(feesStructureId);
            String updatedFeesStructureName = request.getParameter("editFeesStructureName");
            String[] feesItemsId = request.getParameterValues("editFeesItemList");
            HashSet<FeesItem> feesItems = new HashSet<FeesItem>();
            String[] stringArray = feesItemsId;
            int n = feesItemsId.length;
            int n2 = 0;
            while (n2 < n) {
                String feesItemId = stringArray[n2];
                feesItems.add(this.feesItemService.feesItemById(Long.parseLong(feesItemId)));
                ++n2;
            }
            feesStructure.setFeesStructureName(updatedFeesStructureName);
            feesStructure.setFeesItems(feesItems);
            this.feesStructureService.updateFeesStructure(feesStructure);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Fees Structure Updated Successfully...!"));
            return "redirect:/feesStructure";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/feesStructure";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/viewFeesStructureList"})
    @ResponseBody
    public List<FeesStructure> feesStructureByList(HttpServletRequest request) {
        List<FeesStructure> feesStructure = null;
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving feesStructure by institution id=" + institutionId));
            feesStructure = this.feesStructureService.feesStructureListEager(institutionId);
            return feesStructure;
        }
        catch (Exception e) {
            return feesStructure;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/feespenaltysetting/add"})
    public String createFeesPenaltySetting(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create fees penalty setting"));
            String penaltyCriteria = request.getParameter("penaltycriteriaid");
            Long dueDays = Long.parseLong(request.getParameter("duedays"));
            String penaltyCategory = request.getParameter("penaltycategoryid");
            String penaltyType = request.getParameter("penaltytypeid");
            Double percentage = 0.0;
            Double amount = 0.0;
            if (penaltyType.equals("percentage")) {
                percentage = Double.parseDouble(request.getParameter("percentage"));
            } else if (penaltyType.equals("amount")) {
                amount = Double.parseDouble(request.getParameter("amount"));
            }
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            if (this.feesPenaltySettingService.feesPenaltySettingByFeesPenaltySettingTypeAndInstitution(penaltyCriteria, institutionId) != null) {
                throw new FeesPenaltySettingException(new Message("failure", "Already Exist"));
            }
            FeesPenaltySetting feesPenaltySetting = new FeesPenaltySetting(dueDays, penaltyCategory, penaltyType, percentage, amount, penaltyCriteria, institution);
            this.feesPenaltySettingService.createFeesPenaltySetting(feesPenaltySetting);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Fees Penalty Setting Created Successfully...!"));
            return "redirect:/feesStructure/feespenaltysetting";
        }
        catch (Exception e) {
            if (e.getClass().equals(FeesPenaltySettingException.class)) {
                FeesPenaltySettingException se = (FeesPenaltySettingException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)se.getCustomMessage());
                return "redirect:/feesStructure/feespenaltysetting";
            }
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            this.log.error((Object)"Exception", e.getCause());
            e.printStackTrace();
            return "redirect:/feesStructure/feespenaltysetting";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/feesPenaltySetting/{id}"})
    @ResponseBody
    public FeesPenaltySetting feesPenaltySettingById(@PathVariable(value="id") Long feesPenaltySettingId, HttpServletRequest request) {
        FeesPenaltySetting feesPenaltySetting = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving FeesPenaltySetting with id=" + feesPenaltySettingId));
            feesPenaltySetting = this.feesPenaltySettingService.feesPenaltySettingById(feesPenaltySettingId);
            return feesPenaltySetting;
        }
        catch (Exception e) {
            return feesPenaltySetting;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/feesPenaltySetting/delete"})
    public String deleteFeesPenaltySetting(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long deleteFeesPenaltySettingId = Long.parseLong(request.getParameter("deletefeespenaltysettingId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting feesPenaltySetting with id=" + deleteFeesPenaltySettingId));
            this.feesPenaltySettingService.deleteFeesPenaltySetting(deleteFeesPenaltySettingId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Fees Penalty Setting Deleted Successfully...!"));
            return "redirect:/feesStructure/feespenaltysetting";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/feesStructure/feespenaltysetting";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/feesPenaltySetting/update"})
    public String updateFeesPenaltySetting(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long feesPenaltySettingId = Long.parseLong(request.getParameter("updateFeesPenaltySettingId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating feesPenaltySetting with id=" + feesPenaltySettingId));
            FeesPenaltySetting feesPenaltySetting = this.feesPenaltySettingService.feesPenaltySettingById(feesPenaltySettingId);
            String penaltyCriteria = request.getParameter("editpenaltycriteriaid");
            Long dueDays = Long.parseLong(request.getParameter("editduedays"));
            String penaltyCategory = request.getParameter("editpenaltycategoryid");
            String penaltyType = request.getParameter("editpenaltytypeid");
            Double percentage = 0.0;
            Double amount = 0.0;
            if (penaltyType.equals("percentage")) {
                percentage = Double.parseDouble(request.getParameter("editpercentage"));
            } else if (penaltyType.equals("amount")) {
                amount = Double.parseDouble(request.getParameter("editamount"));
            }
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            feesPenaltySetting.setAmount(amount);
            feesPenaltySetting.setPercentage(percentage);
            feesPenaltySetting.setFeesPenaltySettingType(penaltyCriteria);
            feesPenaltySetting.setInstitution(institution);
            feesPenaltySetting.setPenaltyType(penaltyType);
            feesPenaltySetting.setPenaltyCategory(penaltyCategory);
            feesPenaltySetting.setDueDays(dueDays);
            this.feesPenaltySettingService.updateFeesPenaltySetting(feesPenaltySetting);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Fees Penalty Setting Updated Successfully...!"));
            return "redirect:/feesStructure/feespenaltysetting";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/feesStructure/feespenaltysetting";
        }
    }
}
