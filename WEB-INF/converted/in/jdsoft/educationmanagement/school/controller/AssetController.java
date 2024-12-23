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

import in.jdsoft.educationmanagement.school.model.AssetCategory;
import in.jdsoft.educationmanagement.school.model.AssetType;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.services.AssetCategoryService;
import in.jdsoft.educationmanagement.school.services.AssetTypeService;
import in.jdsoft.educationmanagement.school.services.InventoryItemMasterService;
import in.jdsoft.educationmanagement.school.services.SupplierMasterService;
import in.jdsoft.educationmanagement.school.services.TaxClassService;
import in.jdsoft.educationmanagement.school.services.UserService;
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

@Controller(value="assetController")
@RequestMapping(value={"/asset"})
public class AssetController {
    private Logger log = LogManager.getLogger((String)AssetController.class.getName());
    @Autowired
    private AssetCategoryService assetCategoryService;
    @Autowired
    private AssetTypeService assetTypeService;
    @Autowired
    private TaxClassService taxClassService;
    @Autowired
    private InventoryItemMasterService inventoryItemMasterService;
    @Autowired
    private SupplierMasterService supplierMasterService;
    @Autowired
    private UserService userService;

    @RequestMapping(method={RequestMethod.GET}, value={"/type"})
    public ModelAndView displayAssetTypePage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("assettype");
            modelandview.addObject("assetTypeList", this.assetTypeService.assetTypeList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/manageasset"})
    public ModelAndView displayAssetPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("asset");
            modelandview.addObject("assetTypeList", this.assetTypeService.assetTypeList());
            modelandview.addObject("assetCategoryList", this.assetCategoryService.assetCategoryList());
            modelandview.addObject("taxClassList", this.taxClassService.taxClassList());
            modelandview.addObject("inventoryItemMasterList", this.inventoryItemMasterService.getAssetListsFromInventoryItemMaster());
            modelandview.addObject("supplierMasterlist", this.supplierMasterService.supplierMasterList());
            modelandview.addObject("userList", this.userService.userList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/type/add"})
    public String createAssetType(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create AssetType"));
            String assetTypeName = request.getParameter("assetTypeName");
            this.assetTypeService.createAssetType(new AssetType(assetTypeName));
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Asset Type Created Successfully...!"));
            return "redirect:/asset/type";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/asset/type";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/type/{id}"})
    @ResponseBody
    public AssetType assetTypeById(@PathVariable(value="id") Long assetTypeId, HttpServletRequest request) {
        AssetType assetType = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving asset type with id=" + assetTypeId));
            assetType = this.assetTypeService.assetTypeById(assetTypeId);
            return assetType;
        }
        catch (Exception e) {
            return assetType;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/type/delete"})
    public String deleteAssetType(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long assetTypeId = Long.parseLong(request.getParameter("deleteAssetTypeId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting asset type with id=" + assetTypeId));
            this.assetTypeService.deleteAssetType(assetTypeId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Asset Type Deleted Successfully...!"));
            return "redirect:/asset/type";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/asset/type";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/type/update"})
    public String updateAssetType(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long assetTypeId = Long.parseLong(request.getParameter("updateAssetTypeId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating asset type with id=" + assetTypeId));
            AssetType assetType = this.assetTypeService.assetTypeById(assetTypeId);
            String updatedAssetName = request.getParameter("editAssetType");
            assetType.setAssetType(updatedAssetName);
            this.assetTypeService.updateAssetType(assetType);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Asset Type Updated Successfully...!"));
            return "redirect:/asset/type";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/asset/type";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/category"})
    public ModelAndView displayAssetCategoryPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("assetcategory");
            modelandview.addObject("assetCategoryList", this.assetCategoryService.assetCategoryList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/category/add"})
    public String createAssetCategory(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create AssetCategory"));
            String assetCategoryName = request.getParameter("assetCategoryName");
            this.assetCategoryService.createAssetCategory(new AssetCategory(assetCategoryName));
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Asset Category Created Successfully...!"));
            return "redirect:/asset/category";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/asset/category";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/category/{id}"})
    @ResponseBody
    public AssetCategory assetCategoryById(@PathVariable(value="id") Long assetCategoryId, HttpServletRequest request) {
        AssetCategory assetCategory = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving asset Category with id=" + assetCategoryId));
            assetCategory = this.assetCategoryService.assetCategoryById(assetCategoryId);
            return assetCategory;
        }
        catch (Exception e) {
            return assetCategory;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/category/delete"})
    public String deleteAssetCategory(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long assetCategoryId = Long.parseLong(request.getParameter("deleteAssetCategoryId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting asset Category with id=" + assetCategoryId));
            this.assetCategoryService.deleteAssetCategory(assetCategoryId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Asset Category Deleted Successfully...!"));
            return "redirect:/asset/category";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/asset/category";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/category/update"})
    public String updateAssetCategory(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long assetCategoryId = Long.parseLong(request.getParameter("updateAssetCategoryId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating asset Category with id=" + assetCategoryId));
            AssetCategory assetCategory = this.assetCategoryService.assetCategoryById(assetCategoryId);
            String updatedAssetCategoryName = request.getParameter("editAssetCategoryName");
            assetCategory.setAssetCategoryName(updatedAssetCategoryName);
            this.assetCategoryService.updateAssetCategory(assetCategory);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Asset Category Updated Successfully...!"));
            return "redirect:/asset/category";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/asset/category";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/manageasset/register"})
    public String createAsset(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create Asset"));
            String assetName = request.getParameter("assetName");
            String assetDescription = request.getParameter("assetDescription");
            String assetLocation = request.getParameter("location");
            Long assetTypeId = Long.parseLong(request.getParameter("inventoryTypeId"));
            Long inventoryCategoryId = Long.parseLong(request.getParameter("inventoryCategoryId"));
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Asset Registered Successfully...!"));
            return "redirect:/asset/manageasset";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Registered...!"));
            e.printStackTrace();
            return "redirect:/asset/manageasset";
        }
    }
}
