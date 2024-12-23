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

import in.jdsoft.educationmanagement.school.model.FeesItem;
import in.jdsoft.educationmanagement.school.model.InstituteLedgerAccount;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.TaxClass;
import in.jdsoft.educationmanagement.school.services.FeesItemService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.TaxClassService;
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
@RequestMapping(value={"/feesItem"})
public class FeesItemController {
    private Logger log = LogManager.getLogger((String)FeesItemController.class.getName());
    @Autowired
    private FeesItemService feesItemService;
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private TaxClassService taxClassService;

    @RequestMapping(method={RequestMethod.GET})
    @PreAuthorize(value="hasAuthority('feesitem')")
    public ModelAndView displayFeesItemPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed feesItem page"));
            ModelAndView modelandview = new ModelAndView("feesitem");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("feesItems", this.feesItemService.feesItemList(institutionId));
            modelandview.addObject("ledgerAccounts", this.institutionService.ledgerAccountListByInstitution(institutionId));
            modelandview.addObject("taxClassList", this.taxClassService.taxClassList());
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/add"})
    @PreAuthorize(value="hasAuthority('feesitem/add')")
    public String createFeesItem(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create feesItem"));
            String feesItemName = request.getParameter("feesItemName");
            Double feesItemPrice = Double.parseDouble(request.getParameter("feesItemPrice"));
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            Long ledgerAccountId = Long.parseLong(request.getParameter("ledgerAccountId"));
            InstituteLedgerAccount ledgerAccount = this.institutionService.ledgerAccountById(ledgerAccountId);
            Double originalFeesItemPrice = feesItemPrice;
            Double GSTTaxAmount = 0.0;
            Double gstPercentage = 0.0;
            String[] taxClassIds = request.getParameterValues("taxClassId");
            HashSet<TaxClass> taxClasses = new HashSet<TaxClass>();
            String[] stringArray = taxClassIds;
            int n = taxClassIds.length;
            int n2 = 0;
            while (n2 < n) {
                String taxClassId = stringArray[n2];
                TaxClass taxClass = this.taxClassService.taxClassById(Long.parseLong(taxClassId));
                gstPercentage = gstPercentage + taxClass.getTaxRate();
                GSTTaxAmount = GSTTaxAmount + feesItemPrice * (taxClass.getTaxRate() / 100.0);
                taxClasses.add(taxClass);
                ++n2;
            }
            feesItemPrice = Math.round(feesItemPrice + GSTTaxAmount);
            FeesItem feesItem = new FeesItem(feesItemName, feesItemPrice, ledgerAccount, originalFeesItemPrice, gstPercentage, institution, taxClasses);
            this.feesItemService.createFeesItem(feesItem);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Fees Item Created Successfully...!"));
            return "redirect:/feesItem";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/feesItem";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/{id}"})
    @ResponseBody
    @PreAuthorize(value="hasAuthority('feesitem/view')")
    public FeesItem feesItemById(@PathVariable(value="id") Long feesItemId, HttpServletRequest request) {
        FeesItem feesItem = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving feesItem with id=" + feesItemId));
            feesItem = this.feesItemService.feesItemById(feesItemId);
            return feesItem;
        }
        catch (Exception e) {
            return feesItem;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/delete"})
    @PreAuthorize(value="hasAuthority('feesitem/delete')")
    public String deleteFeesItem(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long feesItemId = Long.parseLong(request.getParameter("deleteFeesItemId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting feesItem with id=" + feesItemId));
            this.feesItemService.deleteFeesItem(feesItemId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Fees Item Deleted Successfully...!"));
            return "redirect:/feesItem";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/feesItem";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/update"})
    @PreAuthorize(value="hasAuthority('feesitem/update')")
    public String updateFeesItem(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long feesItemId = Long.parseLong(request.getParameter("updateFeesItemId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating feesItem with id=" + feesItemId));
            FeesItem feesItem = this.feesItemService.feesItemById(feesItemId);
            Double updatedFeesItemPrice = Double.parseDouble(request.getParameter("editFeesItemPrice"));
            Long ledgerAccountId = Long.parseLong(request.getParameter("editLedgerAccountId"));
            InstituteLedgerAccount ledgerAccount = this.institutionService.ledgerAccountById(ledgerAccountId);
            String[] taxClassIds = request.getParameterValues("editTaxClassId");
            Double GSTTaxAmount = 0.0;
            HashSet<TaxClass> taxClasses = new HashSet<TaxClass>();
            String[] stringArray = taxClassIds;
            int n = taxClassIds.length;
            int n2 = 0;
            while (n2 < n) {
                String taxClassId = stringArray[n2];
                TaxClass taxClass = this.taxClassService.taxClassById(Long.parseLong(taxClassId));
                GSTTaxAmount = GSTTaxAmount + updatedFeesItemPrice * (taxClass.getTaxRate() / 100.0);
                taxClasses.add(taxClass);
                ++n2;
            }
            updatedFeesItemPrice = Math.round(updatedFeesItemPrice + GSTTaxAmount);
            feesItem.setFeesItemPrice(updatedFeesItemPrice);
            feesItem.setLedgerAccount(ledgerAccount);
            feesItem.setTaxClasses(taxClasses);
            this.feesItemService.updateFeesItem(feesItem);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Fees Item Updated Successfully...!"));
            return "redirect:/feesItem";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/feesItem";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/viewFeesItemList"})
    @ResponseBody
    public List<FeesItem> feesStructureByList(HttpServletRequest request) {
        List<FeesItem> feesItems = null;
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving feesItem by institution id=" + institutionId));
            feesItems = this.feesItemService.feesItemList(institutionId);
            return feesItems;
        }
        catch (Exception e) {
            return feesItems;
        }
    }
}
