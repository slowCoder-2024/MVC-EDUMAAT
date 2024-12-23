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

import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.InventoryCategory;
import in.jdsoft.educationmanagement.school.model.InventoryItemIssueMaster;
import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
import in.jdsoft.educationmanagement.school.model.InventoryItemReturnMaster;
import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrder;
import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrderDetails;
import in.jdsoft.educationmanagement.school.model.InventoryReceipt;
import in.jdsoft.educationmanagement.school.model.InventoryReceiptDetails;
import in.jdsoft.educationmanagement.school.model.InventoryRequisition;
import in.jdsoft.educationmanagement.school.model.InventoryType;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.PaymentMode;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.PurchaseRequisition;
import in.jdsoft.educationmanagement.school.model.RequisitionType;
import in.jdsoft.educationmanagement.school.model.SupplierMaster;
import in.jdsoft.educationmanagement.school.model.TaxClass;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.GeographicalLocationService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.InventoryCategoryService;
import in.jdsoft.educationmanagement.school.services.InventoryItemIssueAndReturnMasterService;
import in.jdsoft.educationmanagement.school.services.InventoryItemMasterService;
import in.jdsoft.educationmanagement.school.services.InventoryPurchaseOrderService;
import in.jdsoft.educationmanagement.school.services.InventoryReceiptService;
import in.jdsoft.educationmanagement.school.services.InventoryRequisitionService;
import in.jdsoft.educationmanagement.school.services.InventoryTypeService;
import in.jdsoft.educationmanagement.school.services.PaymentModeService;
import in.jdsoft.educationmanagement.school.services.PurchaseRequisitionService;
import in.jdsoft.educationmanagement.school.services.RequisitionTypeService;
import in.jdsoft.educationmanagement.school.services.SupplierMasterService;
import in.jdsoft.educationmanagement.school.services.TaxClassService;
import in.jdsoft.educationmanagement.school.services.UserService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
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

@Controller(value="inventoryPurchaseController")
@RequestMapping(value={"/inventoryandpurchase"})
public class InventoryAndPurchaseController {
    private Logger log = LogManager.getLogger((String)InventoryAndPurchaseController.class.getName());
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private InventoryCategoryService inventoryCategoryService;
    @Autowired
    private InventoryTypeService inventoryTypeService;
    @Autowired
    private InventoryItemMasterService inventoryItemMasterService;
    @Autowired
    private InventoryReceiptService inventoryReceiptService;
    @Autowired
    PaymentModeService paymentModeService;
    @Autowired
    private InventoryRequisitionService inventoryRequisitionService;
    @Autowired
    private PurchaseRequisitionService purchaseRequisitionService;
    @Autowired
    private SupplierMasterService supplierMasterService;
    @Autowired
    private TaxClassService taxClassService;
    @Autowired
    private UserService userService;
    @Autowired
    private RequisitionTypeService requisitionTypeService;
    @Autowired
    private AcademicYearService academicYearService;
    @Autowired
    private GeographicalLocationService geographicalLocationService;
    @Autowired
    private InventoryItemIssueAndReturnMasterService inventoryItemIssueAndReturnMasterService;
    @Autowired
    private InventoryPurchaseOrderService inventoryPurchaseOrderService;

    @RequestMapping(method={RequestMethod.GET}, value={"/approvals"})
    public ModelAndView displayInventoryAndPurchaseApprovalsPage(HttpServletRequest request) {
        try {
            String email = request.getSession().getAttribute("username").toString();
            ModelAndView modelandview = new ModelAndView("inventoryapprovals");
            modelandview.addObject("inventoryApprovePendingList", this.inventoryRequisitionService.pendingInventoryRequisitionListByApproverEmail(email));
            modelandview.addObject("purchaseApprovePendingList", this.purchaseRequisitionService.pendingPurchaseRequisitionListByApproverEmail(email));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/item"})
    public ModelAndView displayInventoryItemPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("inventoryitem");
            modelandview.addObject("inventoryTypeList", this.inventoryTypeService.inventoryTypeList());
            modelandview.addObject("inventoryCategoryList", this.inventoryCategoryService.inventoryCategoryList());
            modelandview.addObject("taxClassList", this.taxClassService.taxClassList());
            modelandview.addObject("inventoryItemMasterList", this.inventoryItemMasterService.inventoryItemMasterList());
            modelandview.addObject("userList", this.userService.userList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/item/add"})
    public String createInventoryItem(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create Inventory Item"));
            String itemName = request.getParameter("itemName");
            String itemDescription = request.getParameter("itemDescription");
            String itemLocation = request.getParameter("location");
            Long inventoryTypeId = Long.parseLong(request.getParameter("inventoryTypeId"));
            Long inventoryCategoryId = Long.parseLong(request.getParameter("inventoryCategoryId"));
            InventoryType inventoryType = this.inventoryTypeService.inventoryTypeById(inventoryTypeId);
            InventoryCategory inventoryCategory = this.inventoryCategoryService.inventoryCategoryById(inventoryCategoryId);
            boolean purchaseItem = true;
            if (request.getParameter("purchaserateoption") != null) {
                purchaseItem = request.getParameter("purchaserateoption").equals("yes");
            }
            boolean salesItem = true;
            Double saleRate = 0.0;
            if (request.getParameter("salerateoption") != null) {
                if (request.getParameter("salerateoption").equals("yes")) {
                    salesItem = true;
                    saleRate = Double.parseDouble(request.getParameter("salerate"));
                } else {
                    salesItem = false;
                }
            }
            boolean inventoryItem = true;
            if (request.getParameter("inventoryitemoption") != null) {
                inventoryItem = request.getParameter("inventoryitemoption").equals("yes");
            }
            boolean assetItem = true;
            if (request.getParameter("fixedassetoption") != null) {
                assetItem = request.getParameter("fixedassetoption").equals("yes");
            }
            String applicationRootPath = request.getRealPath("/");
            String imagelocation = "/resources/themes/images/inventory-item-barcode-image/";
            String barCodeImageLocation = String.valueOf(applicationRootPath) + "@" + imagelocation;
            String createdBy = request.getSession().getAttribute("username").toString();
            Long userId = Long.parseLong(request.getParameter("userId"));
            User inChargeUser = this.userService.userById(userId);
            InventoryItemMaster inventoryItemMaster = new InventoryItemMaster(itemName, inventoryType, inventoryCategory, itemDescription, purchaseItem, assetItem, salesItem, saleRate, inventoryItem, itemLocation, createdBy, createdBy, inChargeUser);
            inventoryItemMaster.setItemBarImage(barCodeImageLocation);
            this.inventoryItemMasterService.createInventoryItemMaster(inventoryItemMaster);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Item Created Successfully...!"));
            return "redirect:/inventoryandpurchase/item";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/item";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/item/{id}"})
    @ResponseBody
    public InventoryItemMaster inventoryItemMasterById(@PathVariable(value="id") Long inventoryItemId, HttpServletRequest request) {
        InventoryItemMaster inventoryItemMaster = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving inventory item master with id=" + inventoryItemId));
            inventoryItemMaster = this.inventoryItemMasterService.inventoryItemMasterById(inventoryItemId);
            return inventoryItemMaster;
        }
        catch (Exception e) {
            return inventoryItemMaster;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/item/delete"})
    public String deleteInventoryItemMaster(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long inventoryItemMasterId = Long.parseLong(request.getParameter("deleteInventoryItemMasterId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting inventory item master with id=" + inventoryItemMasterId));
            this.inventoryItemMasterService.deleteInventoryItemMaster(inventoryItemMasterId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Item Deleted Successfully...!"));
            return "redirect:/inventoryandpurchase/item";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/item";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/item/update"})
    public String updateInventoryItemMaster(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long inventoryItemMasterId = Long.parseLong(request.getParameter("updateInventoryItemMasterId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating inventory type with id=" + inventoryItemMasterId));
            InventoryItemMaster inventoryItemMaster = this.inventoryItemMasterService.inventoryItemMasterById(inventoryItemMasterId);
            String itemName = request.getParameter("editItemName");
            String itemDescription = request.getParameter("editItemDescription");
            String itemLocation = request.getParameter("editLocation");
            Long inventoryTypeId = Long.parseLong(request.getParameter("editInventoryTypeId"));
            Long inventoryCategoryId = Long.parseLong(request.getParameter("editInventoryCategoryId"));
            boolean purchaseItem = true;
            if (request.getParameter("editpurchaserateoption") != null) {
                purchaseItem = request.getParameter("editpurchaserateoption").equals("yes");
            }
            boolean salesItem = true;
            Double saleRate = 0.0;
            if (request.getParameter("editsalerateoption") != null) {
                if (request.getParameter("editsalerateoption").equals("yes")) {
                    salesItem = true;
                    saleRate = Double.parseDouble(request.getParameter("editsalerate"));
                } else {
                    salesItem = false;
                }
            }
            boolean inventoryItem = true;
            if (request.getParameter("editinventoryitemoption") != null) {
                inventoryItem = request.getParameter("editinventoryitemoption").equals("yes");
            }
            boolean assetItem = true;
            if (request.getParameter("editfixedassetoption") != null) {
                assetItem = request.getParameter("editfixedassetoption").equals("yes");
            }
            InventoryType inventoryType = this.inventoryTypeService.inventoryTypeById(inventoryTypeId);
            InventoryCategory inventoryCategory = this.inventoryCategoryService.inventoryCategoryById(inventoryCategoryId);
            inventoryItemMaster.setItemName(itemName);
            inventoryItemMaster.setItemDescription(itemDescription);
            inventoryItemMaster.setLocation(itemLocation);
            inventoryItemMaster.setInventoryCategory(inventoryCategory);
            inventoryItemMaster.setInventoryType(inventoryType);
            inventoryItemMaster.setAssetItem(assetItem);
            inventoryItemMaster.setInventoryItem(inventoryItem);
            inventoryItemMaster.setPurchaseItem(purchaseItem);
            inventoryItemMaster.setSalesItem(salesItem);
            inventoryItemMaster.setSalesRate(saleRate);
            this.inventoryItemMasterService.updateInventoryItemMaster(inventoryItemMaster);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Item Updated Successfully...!"));
            return "redirect:/inventoryandpurchase/item";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/item";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/type"})
    public ModelAndView displayInventoryTypePage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("inventorytype");
            modelandview.addObject("inventoryTypeList", this.inventoryTypeService.inventoryTypeList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/type/add"})
    public String createInventoryType(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create InventoryType"));
            String inventoryTypeName = request.getParameter("inventoryTypeName");
            this.inventoryTypeService.createInventoryType(new InventoryType(inventoryTypeName));
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Inventory Type Created Successfully...!"));
            return "redirect:/inventoryandpurchase/type";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/type";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/type/{id}"})
    @ResponseBody
    public InventoryType inventoryTypeById(@PathVariable(value="id") Long inventoryTypeId, HttpServletRequest request) {
        InventoryType inventoryType = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving inventory type with id=" + inventoryTypeId));
            inventoryType = this.inventoryTypeService.inventoryTypeById(inventoryTypeId);
            return inventoryType;
        }
        catch (Exception e) {
            return inventoryType;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/type/delete"})
    public String deleteInventoryType(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long inventoryTypeId = Long.parseLong(request.getParameter("deleteInventoryTypeId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting inventory type with id=" + inventoryTypeId));
            this.inventoryTypeService.deleteInventoryType(inventoryTypeId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Inventory Type Deleted Successfully...!"));
            return "redirect:/inventoryandpurchase/type";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/type";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/type/update"})
    public String updateInventoryType(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long inventoryTypeId = Long.parseLong(request.getParameter("updateInventoryTypeId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating inventory type with id=" + inventoryTypeId));
            InventoryType inventoryType = this.inventoryTypeService.inventoryTypeById(inventoryTypeId);
            String updatedInventoryName = request.getParameter("editInventoryType");
            inventoryType.setInventoryType(updatedInventoryName);
            this.inventoryTypeService.updateInventoryType(inventoryType);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Inventory Type Updated Successfully...!"));
            return "redirect:/inventoryandpurchase/type";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/type";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/category"})
    public ModelAndView displayInventoryCategoryPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("inventorycategory");
            modelandview.addObject("inventoryCategoryList", this.inventoryCategoryService.inventoryCategoryList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/category/add"})
    public String createInventoryCategory(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create InventoryCategory"));
            String inventoryCategoryName = request.getParameter("inventoryCategoryName");
            this.inventoryCategoryService.createInventoryCategory(new InventoryCategory(inventoryCategoryName));
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Inventory Category Created Successfully...!"));
            return "redirect:/inventoryandpurchase/category";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/category";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/category/{id}"})
    @ResponseBody
    public InventoryCategory inventoryCategoryById(@PathVariable(value="id") Long inventoryCategoryId, HttpServletRequest request) {
        InventoryCategory inventoryCategory = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving inventory Category with id=" + inventoryCategoryId));
            inventoryCategory = this.inventoryCategoryService.inventoryCategoryById(inventoryCategoryId);
            return inventoryCategory;
        }
        catch (Exception e) {
            return inventoryCategory;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/category/delete"})
    public String deleteInventoryCategory(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long inventoryCategoryId = Long.parseLong(request.getParameter("deleteInventoryCategoryId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting inventory Category with id=" + inventoryCategoryId));
            this.inventoryCategoryService.deleteInventoryCategory(inventoryCategoryId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Inventory Category Deleted Successfully...!"));
            return "redirect:/inventoryandpurchase/category";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/category";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/category/update"})
    public String updateInventoryCategory(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long inventoryCategoryId = Long.parseLong(request.getParameter("updateInventoryCategoryId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating inventory Category with id=" + inventoryCategoryId));
            InventoryCategory inventoryCategory = this.inventoryCategoryService.inventoryCategoryById(inventoryCategoryId);
            String updatedInventoryCategoryName = request.getParameter("editInventoryCategoryName");
            inventoryCategory.setInventoryCategoryName(updatedInventoryCategoryName);
            this.inventoryCategoryService.updateInventoryCategory(inventoryCategory);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Inventory Category Updated Successfully...!"));
            return "redirect:/inventoryandpurchase/category";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/category";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/taxclass"})
    public ModelAndView displayTaxClassPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("taxclass");
            modelandview.addObject("taxClassList", this.taxClassService.taxClassList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/taxclass/add"})
    public String createTaxClass(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create Tax Class"));
            String taxClassName = request.getParameter("taxClassName");
            Double taxRate = Double.parseDouble(request.getParameter("taxRate"));
            this.taxClassService.createTaxClass(new TaxClass(taxClassName, taxRate));
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Tax Class Created Successfully...!"));
            return "redirect:/inventoryandpurchase/taxclass";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/taxclass";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/taxclass/{id}"})
    @ResponseBody
    public TaxClass taxClassById(@PathVariable(value="id") Long taxClassId, HttpServletRequest request) {
        TaxClass taxClass = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving tax class with id=" + taxClassId));
            taxClass = this.taxClassService.taxClassById(taxClassId);
            return taxClass;
        }
        catch (Exception e) {
            return taxClass;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/taxclass/delete"})
    public String deleteTaxClass(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long taxClassId = Long.parseLong(request.getParameter("deleteTaxClassId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting tax class with id=" + taxClassId));
            this.taxClassService.deleteTaxClass(taxClassId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Tax Class Deleted Successfully...!"));
            return "redirect:/inventoryandpurchase/taxclass";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/taxclass";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/taxclass/update"})
    public String updateTaxClass(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long taxClassId = Long.parseLong(request.getParameter("updateTaxClassId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating tax class with id=" + taxClassId));
            String taxClassName = request.getParameter("editTaxClassName");
            Double taxRate = Double.parseDouble(request.getParameter("editTaxRate"));
            TaxClass taxClass = this.taxClassService.taxClassById(taxClassId);
            taxClass.setTaxTypeName(taxClassName);
            taxClass.setTaxRate(taxRate);
            this.taxClassService.updateTaxClass(taxClass);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Tax Class Updated Successfully...!"));
            return "redirect:/inventoryandpurchase/taxclass";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/taxclass";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/suppliermaster"})
    public ModelAndView displaySupplierMasterPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("suppliermaster");
            modelandview.addObject("countries", this.geographicalLocationService.countryList());
            modelandview.addObject("stateList", this.geographicalLocationService.stateList());
            modelandview.addObject("cityList", this.geographicalLocationService.cityList());
            modelandview.addObject("suppliermasterlist", this.supplierMasterService.supplierMasterList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/suppliermaster/add"})
    public String createSupplierMaster(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create supplier master"));
            String createdBy = request.getSession().getAttribute("username").toString();
            String supplierName = request.getParameter("supplierName");
            String contactPersonName = request.getParameter("contactPersonName");
            String gender = request.getParameter("supplierGender");
            String addressLine1 = request.getParameter("supplierAddressLine1");
            String addressLine2 = request.getParameter("supplierAddressLine2");
            String country = request.getParameter("supplierCountry");
            String state = request.getParameter("supplierState");
            String city = request.getParameter("supplierCity");
            String postcode = request.getParameter("supplierPostCode");
            String email = request.getParameter("supplierEMail");
            String contact = request.getParameter("supplierContactNumber");
            String supplierPANNumber = request.getParameter("supplierPANNo");
            String tinNumber = request.getParameter("supplierTINNo");
            String bankName = request.getParameter("supplierBankName");
            String description = request.getParameter("supplierDescription");
            String cstNumber = request.getParameter("supplierCSTNo");
            String fax = request.getParameter("supplierFAX");
            String servicetaxnumber = request.getParameter("supplierServiceTaxNo");
            Integer status = Integer.parseInt(request.getParameter("supplierStatus"));
            String bankAccountNo = null;
            if (request.getParameter("supplierBankAccountNo") != null) {
                bankAccountNo = request.getParameter("supplierBankAccountNo");
            }
            String bankIFSCCode = request.getParameter("supplierBankIFSC");
            SupplierMaster supplierMaster = new SupplierMaster(supplierName, contactPersonName, gender, contact, email, fax, addressLine1, addressLine2, country, state, city, postcode, tinNumber, cstNumber, servicetaxnumber, bankName, bankAccountNo, bankIFSCCode, supplierPANNumber, description, createdBy, createdBy, status);
            this.supplierMasterService.createSupplierMaster(supplierMaster);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Supplier Master Created Successfully...!"));
            return "redirect:/inventoryandpurchase/suppliermaster";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/suppliermaster";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/suppliermaster/{id}"})
    @ResponseBody
    public SupplierMaster supplierMasterById(@PathVariable(value="id") Long supplierMasterId, HttpServletRequest request) {
        SupplierMaster supplierMaster = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving suppliermaster with id=" + supplierMasterId));
            supplierMaster = this.supplierMasterService.supplierMasterById(supplierMasterId);
            return supplierMaster;
        }
        catch (Exception e) {
            return supplierMaster;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/suppliermaster/delete"})
    public String deleteSupplierMaster(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long supplierMasterId = Long.parseLong(request.getParameter("deleteSupplierMasterId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting supplierMaster with id=" + supplierMasterId));
            this.supplierMasterService.deleteSupplierMaster(supplierMasterId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Supplier Master Deleted Successfully...!"));
            return "redirect:/inventoryandpurchase/suppliermaster";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/suppliermaster";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/suppliermaster/update"})
    public String updateSupplierMaster(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long supplierMasterId = Long.parseLong(request.getParameter("updateSupplierMasterId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating supplier master with id=" + supplierMasterId));
            String createdBy = request.getSession().getAttribute("username").toString();
            String supplierName = request.getParameter("editSupplierName");
            String contactPersonName = request.getParameter("editContactPersonName");
            String gender = request.getParameter("editSupplierGender");
            String addressLine1 = request.getParameter("editSupplierAddressLine1");
            String addressLine2 = request.getParameter("editSupplierAddressLine2");
            String country = request.getParameter("editSupplierCountry");
            String state = request.getParameter("editSupplierState");
            String city = request.getParameter("editSupplierCity");
            String postcode = request.getParameter("editSupplierPostCode");
            String email = request.getParameter("editSupplierEmail");
            String contact = request.getParameter("editSupplierContactNumber");
            String supplierPANNumber = request.getParameter("editSupplierPANNo");
            String tinNumber = request.getParameter("editSupplierTINNo");
            String bankName = request.getParameter("editSupplierBankName");
            String description = request.getParameter("editSupplierDescription");
            String cstNumber = request.getParameter("editSupplierCSTNo");
            String fax = request.getParameter("editSupplierFAX");
            String servicetaxnumber = request.getParameter("editSupplierServiceTaxNo");
            Integer status = Integer.parseInt(request.getParameter("editSupplierStatus"));
            String bankAccountNo = null;
            if (request.getParameter("editSupplierBankAccountNo") != null) {
                bankAccountNo = request.getParameter("editSupplierBankAccountNo");
            }
            String bankIFSCCode = request.getParameter("editSupplierBankIFSC");
            SupplierMaster supplierMaster = this.supplierMasterService.supplierMasterById(supplierMasterId);
            supplierMaster.setSupplierName(supplierName);
            supplierMaster.setContactPersonName(contactPersonName);
            supplierMaster.setGender(gender);
            supplierMaster.setContactNumber(contact);
            supplierMaster.setAddressLine1(addressLine1);
            supplierMaster.setAddressLine2(addressLine2);
            supplierMaster.setCountry(country);
            supplierMaster.setState(state);
            supplierMaster.setCity(city);
            supplierMaster.setEmail(email);
            supplierMaster.setDescription(description);
            supplierMaster.setPostCode(postcode);
            supplierMaster.setPanNumber(supplierPANNumber);
            supplierMaster.setTinNumber(tinNumber);
            supplierMaster.setCstNumber(cstNumber);
            supplierMaster.setFax(fax);
            supplierMaster.setBankName(bankName);
            supplierMaster.setBankAccountNo(bankAccountNo);
            supplierMaster.setBankIFSCCode(bankIFSCCode);
            supplierMaster.setServiceTaxNumber(servicetaxnumber);
            supplierMaster.setStatus(status);
            supplierMaster.setModifiedBy(createdBy);
            this.supplierMasterService.updateSupplierMaster(supplierMaster);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Supplier Master Updated Successfully...!"));
            return "redirect:/inventoryandpurchase/suppliermaster";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/suppliermaster";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/purchasereceipt"})
    public ModelAndView displayPurchaseReceiptPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("purchasereceipt");
            modelandview.addObject("purchaseOrderLists", this.inventoryPurchaseOrderService.inventoryPurchaseOrderList());
            modelandview.addObject("taxClassList", this.taxClassService.taxClassList());
            modelandview.addObject("paymentModes", this.paymentModeService.paymentModeList());
            modelandview.addObject("inventoryReceiptLists", this.inventoryReceiptService.inventoryReceiptList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/purchaseorder"})
    public ModelAndView displayPurchaseOrderPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("purchaseorder");
            modelandview.addObject("supplierLists", this.supplierMasterService.supplierMasterList());
            modelandview.addObject("itemLists", this.inventoryItemMasterService.inventoryItemMasterList());
            modelandview.addObject("purchaseOrderLists", this.inventoryPurchaseOrderService.inventoryPurchaseOrderList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/goodsissueandreturn"})
    public ModelAndView displayGoodsIssueAndReturnPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("goodsissueandreturn");
            modelandview.addObject("inventoryItemMasterList", this.inventoryRequisitionService.inventoryRequisitionApprovedInventoryItemMasterList());
            modelandview.addObject("userList", this.inventoryRequisitionService.inventoryRequisitionApprovedUserList());
            modelandview.addObject("returnedUserList", this.userService.userList());
            modelandview.addObject("inventoryItemIssueMasterList", this.inventoryItemIssueAndReturnMasterService.inventoryItemIssueAndReturnMasterList());
            modelandview.addObject("inventoryItemReturnMasterList", this.inventoryItemIssueAndReturnMasterService.inventoryItemReturnMasterList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/goodsissueandreturn/{id}"})
    @ResponseBody
    public List<InventoryItemReturnMaster> inventoryItemReturnMasterById(@PathVariable(value="id") Long inventoryItemReturnMasterId, HttpServletRequest request) {
        List<InventoryItemReturnMaster> inventoryItemReturnMaster = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving inventoryItemReturnMaster with id=" + inventoryItemReturnMasterId));
            inventoryItemReturnMaster = this.inventoryItemIssueAndReturnMasterService.inventoryItemReturnMasterByInventoryItemIssueMasterId(inventoryItemReturnMasterId);
            return inventoryItemReturnMaster;
        }
        catch (Exception e) {
            return inventoryItemReturnMaster;
        }
    }

    @RequestMapping(value={"/goodsissueandreturn/deleteitemissue"}, method={RequestMethod.POST})
    public String deleteInventoryItemIssue(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long deleteInventoryItemIssueMasterId = Long.parseLong(request.getParameter("deleteInventoryItemIssueMasterId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting inventoryItemIssueMaster with id=" + deleteInventoryItemIssueMasterId));
            this.inventoryItemIssueAndReturnMasterService.deleteInventoryItemIssueAndReturnMaster(deleteInventoryItemIssueMasterId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Goods Issue Deleted Successfully...!"));
            return "redirect:/inventoryandpurchase/goodsissueandreturn";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/goodsissueandreturn";
        }
    }

    @RequestMapping(value={"/goodsissueandreturn/newitemissue"}, method={RequestMethod.POST})
    public String addNewItemIssue(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String location = request.getParameter("location");
            Long inventoryItemMasterId = Long.parseLong(request.getParameter("inventoryItem"));
            InventoryItemMaster inventoryItemMaster = this.inventoryItemMasterService.inventoryItemMasterById(inventoryItemMasterId);
            Long userId = Long.parseLong(request.getParameter("userId"));
            User issueToUser = this.userService.userById(userId);
            String email = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmail(email);
            Double quantity = Double.parseDouble(request.getParameter("noOfQuantityIssue"));
            Double totalQuantityInStock = inventoryItemMaster.getTotalQuantityInStock();
            totalQuantityInStock = totalQuantityInStock - quantity;
            inventoryItemMaster.setTotalQuantityInStock(totalQuantityInStock);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date issueDate = formatter.parse(formatter.format(new Date()));
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            InventoryItemIssueMaster inventoryItemIssueAndReturnMaster = new InventoryItemIssueMaster(location, email, issueDate, quantity, issueToUser, user, inventoryItemMaster, academicYear);
            this.inventoryItemIssueAndReturnMasterService.createInventoryItemIssueAndReturnMaster(inventoryItemIssueAndReturnMaster, inventoryItemMaster);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Goods Issued Successfully...!"));
            return "redirect:/inventoryandpurchase/goodsissueandreturn";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/goodsissueandreturn";
        }
    }

    @RequestMapping(value={"/goodsissueandreturn/itemreturn"}, method={RequestMethod.POST})
    public String itemReturn(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long inventoryItemIssueAndReturnMasterId = Long.parseLong(request.getParameter("inventoryItemIssueAndReturnMasterId"));
            InventoryItemIssueMaster inventoryItemIssueAndReturnMaster = this.inventoryItemIssueAndReturnMasterService.inventoryItemIssueAndReturnMasterById(inventoryItemIssueAndReturnMasterId);
            InventoryItemMaster inventoryItemMaster = inventoryItemIssueAndReturnMaster.getInventoryItemMaster();
            Long userId = Long.parseLong(request.getParameter("returnedUserId"));
            User itemReturnedUser = this.userService.userById(userId);
            String email = request.getSession().getAttribute("username").toString();
            Double quantity = Double.parseDouble(request.getParameter("noOfQuantityReturn"));
            Double totalQuantityInStock = inventoryItemMaster.getTotalQuantityInStock();
            totalQuantityInStock = totalQuantityInStock + quantity;
            inventoryItemMaster.setTotalQuantityInStock(totalQuantityInStock);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date returnedDate = formatter.parse(formatter.format(new Date()));
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            InventoryItemReturnMaster inventoryItemReturnMaster = new InventoryItemReturnMaster(email, email, returnedDate, quantity, itemReturnedUser, academicYear, inventoryItemIssueAndReturnMaster);
            this.inventoryItemIssueAndReturnMasterService.updateInventoryItemReturnMaster(inventoryItemReturnMaster, inventoryItemMaster);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Goods Returned Successfully...!"));
            return "redirect:/inventoryandpurchase/goodsissueandreturn";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/goodsissueandreturn";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/requisition"})
    public ModelAndView displayInventoryAndPurchaseRequisitionPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("inventoryrequisition");
            String email = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(email);
            modelandview.addObject("requisitionTypeList", this.requisitionTypeService.requisitionTypeListInventoryAndPurchaseByUser(user));
            modelandview.addObject("inventoryItemMasterList", this.inventoryItemMasterService.inventoryItemMasterList());
            modelandview.addObject("inventoryRequisitions", this.inventoryRequisitionService.pendingInventoryRequisitionListByRequesterEmail(email));
            modelandview.addObject("inventoryRequisitionApprovedAndRejectedLists", this.inventoryRequisitionService.approvedAndRejectedInventoryRequisitionListByRequesterEmail(email));
            modelandview.addObject("purchaseRequisitions", this.purchaseRequisitionService.pendingPurchaseRequisitionListByRequesterEmail(email));
            modelandview.addObject("purchaseRequisitionApprovedAndRejectedLists", this.purchaseRequisitionService.approvedAndRejectedPurchaseRequisitionListByRequesterEmail(email));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/requisition/inventoryRequest/cancel"}, method={RequestMethod.POST})
    public String cancelInventoryRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long inventoryRequisitionId = Long.parseLong(request.getParameter("inventoryRequisitionId"));
            InventoryRequisition inventoryRequisition = this.inventoryRequisitionService.inventoryRequisitionByIdEager(inventoryRequisitionId);
            inventoryRequisition.setApprovalStatus("Cancelled");
            this.inventoryRequisitionService.cancelInventoryRequisition(inventoryRequisition);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Inventory Request Cancelled Successfully...!"));
            return "redirect:/inventoryandpurchase/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/requisition";
        }
    }

    @RequestMapping(value={"/requisition/inventoryRequest"}, method={RequestMethod.POST})
    public String addInventoryAndPurchaseRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String approvalStatus = "Pending";
            String requisitionReason = request.getParameter("requisitionReason");
            String requisitionDescription = request.getParameter("requisitionDescription");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            User requester = this.userService.userByEmailEager(request.getSession().getAttribute("username").toString());
            User approver = null;
            approver = this.userService.tcApprover(institutionId);
            Long itemMasterId = Long.parseLong(request.getParameter("inventoryItem"));
            InventoryItemMaster inventoryItemMaster = this.inventoryItemMasterService.inventoryItemMasterById(itemMasterId);
            Double quantity = Double.parseDouble(request.getParameter("quantity"));
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(approver);
            PortalTask portalTask = new PortalTask("Inventory Requisition Approval", "Inventory Requisition Approval", addUser, 1, "/inventoryandpurchase/approvals", request.getSession().getAttribute("username").toString(), institution);
            InventoryRequisition inventoryRequisition = new InventoryRequisition(inventoryItemMaster, quantity, requisitionDescription, requisitionReason, requester, approvalStatus, approver, portalTask);
            this.inventoryRequisitionService.createInventoryRequisition(inventoryRequisition, portalTask);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Inventory Requisition Request Sent Successfully...!"));
            return "redirect:/inventoryandpurchase/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/requisition";
        }
    }

    @RequestMapping(value={"/approvals/inventory/updatestatus"}, method={RequestMethod.POST})
    public String updateInventoryApprovalsStatus(HttpServletRequest request) {
        try {
            Long inventoryRequisitionId = Long.parseLong(request.getParameter("requisitionId"));
            String approverComment = request.getParameter("approverComment");
            String status = request.getParameter("requisitionStatus");
            InventoryRequisition inventoryRequisition = this.inventoryRequisitionService.inventoryRequisitionByIdEager(inventoryRequisitionId);
            String email = request.getSession().getAttribute("username").toString();
            inventoryRequisition.setApprovedBy(email);
            inventoryRequisition.setApprovalStatus(status);
            inventoryRequisition.setApproverComment(approverComment);
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(inventoryRequisition.getInventoryRequistionBy());
            PortalTask portalTask = new PortalTask("Inventory Requisition " + status, "Inventory Requisition " + status, addUser, 1, "/inventoryandpurchase/requisition", inventoryRequisition.getInventoryRequisitionApproverBy().getEmail(), inventoryRequisition.getInventoryRequisitionApproverBy().getInstitution());
            this.inventoryRequisitionService.updateInventoryRequisition(inventoryRequisition, portalTask);
            return "redirect:/inventoryandpurchase/approvals";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/approvals";
        }
    }

    @RequestMapping(value={"/add/po"}, method={RequestMethod.POST})
    public String addPurchaseOrder(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            Long supplierId = Long.parseLong(request.getParameter("supplierId"));
            SupplierMaster supplierMaster = this.supplierMasterService.supplierMasterById(supplierId);
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create purchase order"));
            String createdAndModifiedBy = request.getSession().getAttribute("username").toString();
            boolean isPurchased = Boolean.parseBoolean("false");
            LinkedHashSet<InventoryPurchaseOrderDetails> inventoryPurchaseOrderDetails = new LinkedHashSet<InventoryPurchaseOrderDetails>();
            String[] pos = request.getParameterValues("poDetails");
            double totalqty = 0.0;
            String[] stringArray = pos;
            int n = pos.length;
            int n2 = 0;
            while (n2 < n) {
                String[] poDetails;
                String po = stringArray[n2];
                String[] stringArray2 = poDetails = po.split(",");
                int n3 = poDetails.length;
                int n4 = 0;
                while (n4 < n3) {
                    String poDetail = stringArray2[n4];
                    String[] pOrder = poDetail.split("-");
                    Double quantity = Double.parseDouble(pOrder[1]);
                    Long itemMasterId = Long.parseLong(pOrder[0]);
                    totalqty += quantity.doubleValue();
                    InventoryItemMaster inventoryItemMaster = this.inventoryItemMasterService.inventoryItemMasterById(itemMasterId);
                    InventoryPurchaseOrderDetails inventoryPurchaseOrderDetail = new InventoryPurchaseOrderDetails(quantity, inventoryItemMaster, createdAndModifiedBy, createdAndModifiedBy);
                    inventoryPurchaseOrderDetails.add(inventoryPurchaseOrderDetail);
                    ++n4;
                }
                ++n2;
            }
            InventoryPurchaseOrder inventoryPurchaseOrder = new InventoryPurchaseOrder(supplierMaster, academicYear, createdAndModifiedBy, createdAndModifiedBy, institution, isPurchased, totalqty);
            this.inventoryPurchaseOrderService.createInventoryPurchaseOrder(inventoryPurchaseOrder, inventoryPurchaseOrderDetails);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Purchase Order Created Successfully...!"));
            return "redirect:/inventoryandpurchase/purchaseorder";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/purchaseorder";
        }
    }

    @RequestMapping(value={"/requisition/purchaseRequest/cancel"}, method={RequestMethod.POST})
    public String cancelPurchaseRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long purchaseRequisitionId = Long.parseLong(request.getParameter("purchaseRequisitionId"));
            PurchaseRequisition purchaseRequisition = this.purchaseRequisitionService.purchaseRequisitionByIdEager(purchaseRequisitionId);
            purchaseRequisition.setApprovalStatus("Cancelled");
            this.purchaseRequisitionService.cancelPurchaseRequisition(purchaseRequisition);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Purchase Request Cancelled Successfully...!"));
            return "redirect:/inventoryandpurchase/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/requisition";
        }
    }

    @RequestMapping(value={"/requisition/purchaseRequest"}, method={RequestMethod.POST})
    public String addPurchaseRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            RequisitionType requisitionType = this.requisitionTypeService.requisitionTypeById(Long.parseLong(request.getParameter("selectedRequisitionTypeId")));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String date = request.getParameter("expectedDate");
            Date expectedDate = formatter.parse(date);
            String approvalStatus = "Pending";
            String requisitionReason = request.getParameter("purchaseRequisitionReason");
            String requisitionDescription = request.getParameter("purchaseRequisitionDescription");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            User requester = this.userService.userByEmailEager(request.getSession().getAttribute("username").toString());
            User approver = null;
            approver = this.userService.tcApprover(institutionId);
            String inventoryItemMaster = request.getParameter("purchaseInventoryItem");
            Double quantity = Double.parseDouble(request.getParameter("purchaseQuantity"));
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(approver);
            PortalTask portalTask = new PortalTask("Purchase Requisition Approval", "Purchase Requisition Approval", addUser, 1, "/inventoryandpurchase/approvals", request.getSession().getAttribute("username").toString(), institution);
            PurchaseRequisition purchaseRequisition = new PurchaseRequisition(quantity, inventoryItemMaster, requisitionDescription, requisitionReason, requester, approver, approvalStatus, expectedDate, portalTask, requisitionType);
            this.purchaseRequisitionService.createPurchaseRequisition(purchaseRequisition, portalTask);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Purchase Requisition Request Sent Successfully...!"));
            return "redirect:/inventoryandpurchase/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/requisition";
        }
    }

    @RequestMapping(value={"/approvals/purchase/updatestatus"}, method={RequestMethod.POST})
    public String updatePurchaseApprovalsStatus(HttpServletRequest request) {
        try {
            Long purchaseRequisitionId = Long.parseLong(request.getParameter("requisitionId"));
            String approverComment = request.getParameter("approverComment");
            String status = request.getParameter("requisitionStatus");
            PurchaseRequisition purchaseRequisition = this.purchaseRequisitionService.purchaseRequisitionByIdEager(purchaseRequisitionId);
            String email = request.getSession().getAttribute("username").toString();
            purchaseRequisition.setApprovedBy(email);
            purchaseRequisition.setApprovalStatus(status);
            purchaseRequisition.setApproverComment(approverComment);
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(purchaseRequisition.getPurchaseRequistionBy());
            PortalTask portalTask = new PortalTask("Purchase Requisition " + status, "Purchase Requisition " + status, addUser, 1, "/inventoryandpurchase/requisition", purchaseRequisition.getPurchaseApproverBy().getEmail(), purchaseRequisition.getPurchaseRequistionBy().getInstitution());
            this.purchaseRequisitionService.updatePurchaseRequisition(purchaseRequisition, portalTask);
            return "redirect:/inventoryandpurchase/approvals";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/approvals";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/po/delete"})
    public String deleteInventoryPurchaseOrder(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long POId = Long.parseLong(request.getParameter("deletePOId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting inventory po with id=" + POId));
            this.inventoryPurchaseOrderService.deleteInventoryPurchaseOrder(POId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Purchase Order Deleted Successfully...!"));
            return "redirect:/inventoryandpurchase/purchaseorder";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/purchaseorder";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/pr/delete"})
    public String deleteInventoryPurchaseReceipt(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long PRId = Long.parseLong(request.getParameter("deletePRId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting inventory pr with id=" + PRId));
            this.inventoryReceiptService.deleteInventoryReceipt(PRId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Purchase Receipt Deleted Successfully...!"));
            return "redirect:/inventoryandpurchase/purchasereceipt";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/inventoryandpurchase/purchasereceipt";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"purchaseOrderEager/{id}"})
    @ResponseBody
    public InventoryPurchaseOrder purchaseOrderEagerByPurchaseOrderId(@PathVariable(value="id") Long purchaseOrderId, HttpServletRequest request) throws Exception {
        try {
            return this.inventoryPurchaseOrderService.inventoryPurchaseOrderEager(purchaseOrderId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"/generate/purchaseReceipt"}, method={RequestMethod.POST})
    public String generateReceipt(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        InventoryReceipt inventoryReceipt;
        String modifiedBy;
        SimpleDateFormat formatter;
        Long paymentModeId;
        LinkedHashSet<InventoryReceiptDetails> inventoryReceiptDetails;
        String tallyrefno;
        String narration;
        double grandAmount;
        TaxClass taxClass;
        String receiptNumber;
        String invoiceNumber;
        InventoryPurchaseOrder inventoryPurchaseOrder;
        AcademicYear academicYear;
        block9: {
            block8: {
                try {
                    academicYear = this.academicYearService.getActiveAcademicYear();
                    Long purchaseOrderId = Long.parseLong(request.getParameter("purchaseOrderId"));
                    inventoryPurchaseOrder = this.inventoryPurchaseOrderService.inventoryPurchaseOrderById(purchaseOrderId);
                    String[] ItemDetailsInPRs = request.getParameterValues("itemDetailsInPR");
                    String createdAndModifiedBy = request.getSession().getAttribute("username").toString();
                    invoiceNumber = request.getParameter("invoiceNumber");
                    receiptNumber = request.getParameter("receiptNumber");
                    Long taxClassId = Long.parseLong(request.getParameter("taxClass"));
                    taxClass = this.taxClassService.taxClassById(taxClassId);
                    grandAmount = Double.parseDouble(request.getParameter("totalamount"));
                    narration = null;
                    if (!request.getParameter("narration").isEmpty()) {
                        narration = request.getParameter("narration");
                    }
                    tallyrefno = request.getParameter("tallyrefno");
                    inventoryReceiptDetails = new LinkedHashSet<InventoryReceiptDetails>();
                    String[] stringArray = ItemDetailsInPRs;
                    int n = ItemDetailsInPRs.length;
                    int n2 = 0;
                    while (n2 < n) {
                        String[] itemDetails;
                        String ItemDetailsInPR = stringArray[n2];
                        String[] stringArray2 = itemDetails = ItemDetailsInPR.split(",");
                        int n3 = itemDetails.length;
                        int n4 = 0;
                        while (n4 < n3) {
                            String itemDetail = stringArray2[n4];
                            String[] item = itemDetail.split("-");
                            Double quantity = Double.parseDouble(item[2]);
                            Long itemMasterId = Long.parseLong(item[0]);
                            Integer unitOfMeasure = Integer.parseInt(item[1]);
                            double itemAmount = Double.parseDouble(item[3]);
                            InventoryItemMaster inventoryItemMaster = this.inventoryItemMasterService.inventoryItemMasterById(itemMasterId);
                            InventoryReceiptDetails inventoryReceiptDetail = new InventoryReceiptDetails(inventoryItemMaster, unitOfMeasure, quantity, itemAmount, createdAndModifiedBy, createdAndModifiedBy);
                            inventoryReceiptDetails.add(inventoryReceiptDetail);
                            ++n4;
                        }
                        ++n2;
                    }
                    paymentModeId = Long.parseLong(request.getParameter("paymentMode"));
                    formatter = new SimpleDateFormat("dd/MM/yyyy");
                    if (paymentModeId != 1L) break block8;
                    PaymentMode paymentMode = this.paymentModeService.paymentModeById(paymentModeId);
                    InventoryReceipt inventoryReceipt2 = new InventoryReceipt(inventoryPurchaseOrder, invoiceNumber, paymentMode, receiptNumber, taxClass, grandAmount, createdAndModifiedBy, tallyrefno, createdAndModifiedBy, narration, academicYear);
                    this.inventoryReceiptService.createInventoryReceiptByCash(inventoryReceipt2, inventoryReceiptDetails);
                    redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Purchase Order Receipt Generated Successfully...!"));
                    return "redirect:/inventoryandpurchase/purchasereceipt";
                }
                catch (Exception e) {
                    redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
                    e.printStackTrace();
                    return "redirect:/inventoryandpurchase/purchasereceipt";
                }
            }
            if (paymentModeId != 2L) break block9;
            PaymentMode paymentMode = this.paymentModeService.paymentModeById(paymentModeId);
            String chequeNo = request.getParameter("chequeNo");
            Date chequeDate = formatter.parse(request.getParameter("chequeDate"));
            String chequeBankName = request.getParameter("chequeBankName");
            String chequeBranchName = request.getParameter("chequeBranchName");
            String createdBy = request.getSession().getAttribute("username").toString();
            modifiedBy = request.getSession().getAttribute("username").toString();
            inventoryReceipt = new InventoryReceipt(inventoryPurchaseOrder, invoiceNumber, receiptNumber, tallyrefno, paymentMode, taxClass, grandAmount, chequeNo, chequeDate, chequeBankName, chequeBranchName, createdBy, modifiedBy, narration, academicYear);
            this.inventoryReceiptService.createInventoryReceiptByCheque(inventoryReceipt, inventoryReceiptDetails);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Purchase Order Receipt Generated Successfully...!"));
            return "redirect:/inventoryandpurchase/purchasereceipt";
        }
        if (paymentModeId == 3L) {
            PaymentMode paymentMode = this.paymentModeService.paymentModeById(paymentModeId);
            String ddNo = request.getParameter("ddNo");
            Date ddDate = formatter.parse(request.getParameter("ddDate"));
            String ddBankName = request.getParameter("ddBankName");
            String ddBranchName = request.getParameter("ddBranchName");
            String createdBy = request.getSession().getAttribute("username").toString();
            modifiedBy = request.getSession().getAttribute("username").toString();
            inventoryReceipt = new InventoryReceipt(inventoryPurchaseOrder, invoiceNumber, receiptNumber, tallyrefno, paymentMode, taxClass, grandAmount, ddNo, ddDate, ddBankName, ddBranchName, createdBy, modifiedBy, narration, academicYear);
            this.inventoryReceiptService.createInventoryReceiptByDD(inventoryReceipt, inventoryReceiptDetails);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Purchase Order Receipt Generated Successfully...!"));
            return "redirect:/inventoryandpurchase/purchasereceipt";
        }
        return "redirect:/inventoryandpurchase/purchasereceipt";
    }
}
