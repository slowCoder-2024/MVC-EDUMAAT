

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--    <script src="${pageContext.request.contextPath}/resources/themes/assets/js/customjs.js"></script>  --%>
<!-- ========== Left Sidebar Start ========== -->
<div class="left side-menu" >
   <div class="sidebar-inner slimscrollleft">
      <!--- Divider -->
      <div id="sidebar-menu">
         <ul>
           <%--  <security:authorize access="hasAnyRole('dashboard/admin','dashboard/staff','dashboard/student','dashboard/parent','dashboard/admissioncandidate')"> --%>
               <li class="has_sub">
                  <a href="<c:url value='/home'/>" class="waves-effect"><i class="ti-home"></i> <span> Dashboard </span></a>
               </li>
           <%--  </security:authorize> --%>
           
           
             
             
            <security:authorize access="hasRole('institution')">
               <li class="has_sub">
                  <a id="menuinstitution" href="javascript:void(0);" class="waves-effect multi"><i class="md md-account-balance"></i><span class="menu-arrow"></span><span> Institution (Department)</span> </a>
                  <ul class="list-unstyled">
                     <security:authorize access="hasRole('dashboard/superadmin')">
                        <li><a href="<c:url value='/institution/manageinstitution'/>"> Manage Institution</a></li>
                     </security:authorize>
                     <security:authorize access="hasRole('editinstitution')">
               <li>
                  <a href="<c:url value='/institution/editinstitution'/>">Institution Profile</a>
               </li>
             </security:authorize>
                   
                     <security:authorize access="hasRole('class')">
                        <li>
                           <a href="<c:url value='/class/classnandsection'/>">Course Basis(Class)</a>
                        </li>
                     </security:authorize>
                 
                   <%--   <security:authorize access="hasRole('module')">
                        <li>
                           <a href="<c:url value='/module'/>"> Module / Subject</a>
                        </li>
                     </security:authorize>--%>
                     <security:authorize access="hasRole('section')">
                        <li>
                           <a href="<c:url value='/house'/>"> House / Group</a>
                        </li>
                     </security:authorize>
                      <security:authorize access="hasRole('section')">
                        <li>
                           <a href="<c:url value='/document/type'/>"> Document Type</a>
                        </li>
                     </security:authorize>
                     <security:authorize access="hasRole('specialcategory')">
                        <li>
                           <a href="<c:url value='/specialCategory'/>"> Special Categories</a>
                        </li>
                     </security:authorize>
              
                     <security:authorize access="hasAnyRole('dashboard/superadmin')">
                        <li>
                           <a href="<c:url value='/academicYear'/>"> Academic Year</a>
                        </li>
                     </security:authorize>
                  </ul>
               </li>
            </security:authorize>
            <security:authorize access="hasRole('student')">
               <li class="has_sub">
                  <a id="menustudent" href="javascript:void(0);" class="waves-effect multi"><i class="md md-account-child"></i><span class="menu-arrow"></span><span> Student </span></a>
                  <ul class="list-unstyled">
                     <security:authorize access="hasRole('managestudent')">
                        <li>
                           <a href="<c:url value='/student/managestudent'/>"> Manage Student</a>
                        </li>
                     </security:authorize>
                      <security:authorize access="hasRole('student/studentidcardgeneration')">
                     <li>
                        <a href="<c:url value='/student/studentidcardgeneration'/>">ID Card Generation</a>
                     </li>
                     </security:authorize>
               <%--        <security:authorize access="hasRole('studentattendance')">
                     <li>
                        <a href="<c:url value='/studentattendance'/>"> Student Attendance</a>
                     </li>
                     </security:authorize>
                    
                      <security:authorize access="hasRole('studentattendance/managestudentattendancereport')">
                     <li>
                        <a href="<c:url value='/studentattendance/managestudentattendancereport'/>">Manage Student Attendance</a>
                     </li>
                     </security:authorize> --%>
                     <security:authorize access="hasRole('student/studentpromotion')">
                     <li>
                        <a href="<c:url value='/student/studentpromotion'/>">Student Promotion</a>
                     </li>
                     </security:authorize>
                  </ul>
               </li>
            </security:authorize>
            <security:authorize access="hasRole('student/profile')">
               <li>
                  <a href="<c:url value='/student/profile'/>" class="waves-effect"><i class="md  md-account-circle"></i><span>My Profile</span></a>
               </li>
            </security:authorize>
        <%--     <security:authorize access="hasRole('dashboard/staff')">
               <li>
                  <a href="<c:url value='/student/leave/approvals'/>"class="waves-effect"><i class="md md-thumbs-up-down"></i><span>Approvals</span></a>
               </li>
            </security:authorize> --%>
         <%--    <security:authorize access="hasRole('student/leave/requisition')">
               <li>
                  <a href="<c:url value='/student/leave/requisition'/>" class="waves-effect"><i class="ti-bar-chart"></i><span>Requisition</span></a>
               </li>
            </security:authorize> --%>
   <%--          <security:authorize access="hasAnyRole('staff/meeting/approvals')">
               <li>
                  <a href="<c:url value='/staff/meeting/approvals'/>"class="waves-effect"><i class="md md-verified-user"></i><span>Meeting Approvals</span></a>
               </li>
            </security:authorize> --%>
         
            
           <%--    <security:authorize access="hasAnyRole('dashboard/admin','dashboard/student','dashboard/staff','inventoryandasset')">
                         <li>
                           <a href="<c:url value='/inventoryandpurchase/requisition'/>" class="waves-effect"><i class="ion-ios7-paperplane"></i><span>Material Requisition</span></a>
                        </li>
                        </security:authorize> --%>
<%--             <security:authorize access="hasAnyRole('inventoryandasset','dashboard/admin')">
               <li class="has_sub">
                  <a href="javascript:void(0);" class="waves-effect multi"><i class="fa fa-cart-plus"></i><span class="menu-arrow"></span><span> Inventory And Purchase </span> </a>
                  <ul class="list-unstyled">
                     <security:authorize access="hasAnyRole('inventoryandpurchase/approvals','dashboard/admin')">
                        <li>
                           <a href="<c:url value='/inventoryandpurchase/approvals'/>"class="waves-effect"><span>Material Approvals</span></a>
                        </li>
                     </security:authorize>
                   
                      
                  
                     <security:authorize access="hasAnyRole('inventoryandpurchase/item')">
                        <li>
                           <a href="<c:url value='/inventoryandpurchase/item'/>" class="waves-effect"><span>Inventory Item</span></a>
                        </li>
                        <li>
                           <a href="<c:url value='/inventoryandpurchase/type'/>" class="waves-effect"><span>Inventory Type</span></a>
                        </li>
                        <li>
                           <a href="<c:url value='/inventoryandpurchase/category'/>" class="waves-effect"><span>Inventory Category</span></a>
                        </li>
                        <li>
                           <a href="<c:url value='/inventoryandpurchase/taxclass'/>" class="waves-effect"><span>Tax Class</span></a>
                        </li>
                        <li>
                           <a href="<c:url value='/inventoryandpurchase/suppliermaster'/>" class="waves-effect"><span>Supplier Master</span></a>
                        </li>
                        <li>
                           <a href="<c:url value='/inventoryandpurchase/purchaseorder'/>" class="waves-effect"><span>Purchase Order</span></a>
                        </li>
                        <li>
                           <a href="<c:url value='/inventoryandpurchase/purchasereceipt'/>" class="waves-effect"><span>Purchase Receipt</span></a>
                        </li>
                        <li>
                           <a href="<c:url value='/inventoryandpurchase/goodsissueandreturn'/>" class="waves-effect"><span>Goods Issue And Return</span></a>
                        </li>
                     </security:authorize>
                  </ul>
               </li>
           
               <li class="has_sub">
                  <a href="javascript:void(0);" class="waves-effect multi"><i class="md md-subtitles"></i><span class="menu-arrow"></span><span> Asset Management </span> </a>
                  <ul class="list-unstyled">
                   
                        <li>
                           <a href="<c:url value='/asset/type'/>" class="waves-effect"><span>Asset Type</span></a>
                        </li>
                        <li>
                           <a href="<c:url value='/asset/category'/>" class="waves-effect"><span>Asset Category</span></a>
                        </li>
                        <li>
                           <a href="<c:url value='/asset/manageasset'/>" class="waves-effect"><span>Manage Asset</span></a>
                        </li>
                  
                  </ul>
               </li>
            </security:authorize> --%>
<%--             <security:authorize access="hasRole('student/timetable')">
               <li>
                  <a href="<c:url value='/student/timetable'/>"class="waves-effect"><i class="fa fa-hourglass-2"></i><span>TimeTable</span></a>
               </li>
            </security:authorize>
            <security:authorize access="hasAnyRole('student/studentattendancedetails','parent/studentattendancedetails')">
               <li>
                  <a href="<c:url value='/student/studentattendancedetails'/>"class="waves-effect"><i class="md  md-assignment"></i><span>Attendance Details</span></a>
               </li>
            </security:authorize>
            <security:authorize access="hasRole('parent/timetable')">
               <li>
                  <a href="<c:url value='/student/parenttimetable'/>"class="waves-effect"><i class="fa fa-hourglass-2"></i><span>TimeTable</span></a>
               </li>
            </security:authorize>
            <security:authorize access="hasRole('dashboard/parent')">
               <li>
                  <a href="<c:url value='/student/transfercertificate/requisition'/>"class="waves-effect"><i class="ti-bar-chart"></i><span>TC Requisition</span></a>
               </li>
            </security:authorize> --%>
            <security:authorize access="hasRole('staff/profile')">
               <li>
                  <a href="<c:url value='/staff/profile'/>"class="waves-effect"><i class="md  md-account-circle"></i><span>My Profile</span></a>
               </li>
            </security:authorize>
       <%--      <security:authorize access="hasRole('staff/timetable')">
               <li>
                  <a href="<c:url value='/staff/timetable'/>"class="waves-effect"><i class="fa fa-hourglass-2"></i><span>Weekly TimeTable</span></a>
               </li>
            </security:authorize> --%>
      <%--       <security:authorize access="hasRole('staff/moduleattendance')">
               <li class="has_sub">
                  <a href="javascript:void(0);" class="waves-effect multi"><i class="md md-view-module"></i><span class="menu-arrow"></span><span> Module </span> </a>
                  <ul class="list-unstyled">
                     <li>
                        <a href="<c:url value='/staff/moduleattendance'/>"> Modules Attendance</a>
                     </li>
                     <li>
                        <a href="<c:url value='/staff/moduleattendancereport'/>">Manage Module Attendance</a>
                     </li>
                     <li>
                        <a href="<c:url value='/staff/moduleattendancepercentagereport'/>">Module Attendance Percentage Reports</a>
                     </li>
                     <li>
                        <a href="<c:url value='/staff/modulemarkupdate'/>"> Mark Update</a>
                     </li>
                  </ul>
               </li>
            </security:authorize> --%>
        <%--     <security:authorize access="hasAnyRole('staff/staffattendancedetails','dashboard/principal')">
               <li>
                  <a href="<c:url value='/staff/staffattendancedetails'/>"class="waves-effect"><i class="md  md-assignment"></i><span> My Attendance</span></a>
               </li>
            </security:authorize> --%>
            <security:authorize access="hasRole('humanresource')">
               <li class="has_sub">
                  <a href="javascript:void(0);" class="waves-effect multi"><i class="md md-account-box"></i><span> Human Resource </span> <span class="menu-arrow"></span></a>
                  <ul class="list-unstyled">
                     <security:authorize access="hasRole('staff')">
                        <li>
                           <a href="<c:url value='/staff'/>"> Manage Staff</a>
                        </li>
                     </security:authorize>
                     <security:authorize access="hasRole('staffdesignation')">
                        <li>
                           <a href="<c:url value='/staffdesignation'/>"> Staff Designation</a>
                        </li>
                     </security:authorize>
                   <%--   <li>
                        <a href="<c:url value='/staffattendance/configuration'/>"> Staff Attendance Configuration</a>
                     </li>
                     <li>
                        <a href="<c:url value='/staffattendance'/>"> Staff Attendance</a>
                     </li> --%>
                  </ul>
               </li>
            </security:authorize>
           <security:authorize access="hasRole('feesManagement')">
             <li>
                  <a href="<c:url value='/staff/feesdashboard'/>"class="waves-effect"><i class="glyphicon glyphicon-screenshot"></i><span>Charts</span></a>
               </li>
           </security:authorize>
            <security:authorize access="hasRole('feesManagement')">
               <li class="has_sub">
                  <a href="javascript:void(0);" class="waves-effect multi"><i class="md md-credit-card"></i><span> Fees Management </span> <span class="menu-arrow"></span></a>
                  <ul class="list-unstyled">
                     <li>
                     <a href="<c:url value='/feesStructure/feespenaltysetting'/>">Penalty Setting</a>
                     </li>
                         <li>
                           <a href="<c:url value='/inventoryandpurchase/taxclass'/>" class="waves-effect"><span>Tax Class</span></a>
                        </li>
                          <security:authorize access="hasRole('institution/ledgerAccounts')">
                     <li><a href="<c:url value='/institution/ledgerAccounts'/>">Ledger Heads</a></li>
                     </security:authorize> 
                     <security:authorize access="hasRole('feesterm')">
                        <li>
                           <a href="<c:url value='/feesTerm'/>"> Fees Categories</a>
                        </li>
                     </security:authorize>
                      <security:authorize access="hasRole('feesitem')">
                        <li><a href="<c:url value='/feesItem'/>"> Fees Items</a></li>
                     </security:authorize>
                     <security:authorize access="hasRole('feesstructure')">
                        <li><a href="<c:url value='/feesStructure'/>"> Fees Structure</a></li>
                     </security:authorize>
                     <security:authorize access="hasRole('feesManagment/generateFees')">
                        <li>
                           <a href="<c:url value='/invoice'/>"> Generate Invoices</a>
                        </li>
                     </security:authorize>
                     <security:authorize access="hasRole('feesManagement/collectFees')">
                        <li>
                           <a href="<c:url value='/receipt/generate'/>"> Receipts</a>
                        </li>
                     </security:authorize>
                       <li>
                     <a href="<c:url value='/receipt/refund'/>">Refund</a>
                     </li>
                     <security:authorize access="hasRole('feesManagement/reconcillation')">
                        <li>
                           <a href="<c:url value='/receipt/reconcillation'/>"> Reconcillation</a>
                        </li>
                     </security:authorize>
                     <security:authorize access="hasRole('feesManagement/manageInvoices')">
                        <li>
                           <a href="<c:url value='/invoice/manage'/>"> Manage Invoices</a>
                        </li>
                     </security:authorize>
                     <security:authorize access="hasRole('feesManagement/manageReceipts')">
                        <li>
                           <a href="<c:url value='/receipt/manage'/>"> Manage Receipts</a>
                        </li>
                     </security:authorize>
                      <li>
                           <a href="<c:url value='/receipt/manage/refund'/>"> Manage Refund</a>
                        </li>
                  </ul>
               </li>
            </security:authorize>
    <%--         <security:authorize access="hasAnyRole('approvals/admin','staff/approvals')">
               <li>
                  <a href="<c:url value='/staff/approvals'/>"class="waves-effect"><i class="md md-thumbs-up-down"></i><span>Approvals</span></a>
               </li>
            </security:authorize>
            <security:authorize access="hasAnyRole('requisition/staff','staff/requisition')">
               <li>
                  <a href="<c:url value='/staff/requisition'/>" class="waves-effect"><i class="ti-bar-chart"></i><span>Requisition</span></a>
               </li>
            </security:authorize> --%>
          <%--   <security:authorize access="hasRole('exam')">
               <li>
                  <a href="javascript:void(0);" class="waves-effect multi"><i class="md md-assessment"></i><span> Exam Management </span> <span class="menu-arrow"></span></a>
                  <ul class="list-unstyled">
                     <security:authorize access="hasRole('examtemplate')">
                        <li>
                           <a href="<c:url value='/exam/template'/>"> Create Exam / Assessment Template</a>
                        </li>
                     </security:authorize>
                     <security:authorize access="hasRole('gradetemplate')">
                        <li>
                           <a href="<c:url value='/gradesystem/template'/>"> Create Grade Map / System</a>
                        </li>
                     </security:authorize>
                     <security:authorize access="hasRole('resultsystem')">
                     <li>
                        <a href="<c:url value='/exam'/>">Result System Map</a>
                     </li>
                     </security:authorize>
                  </ul>
               </li>
            </security:authorize> --%>
 <%--            <security:authorize access="hasRole('timetable')">
               <li>
                  <a href="javascript:void(0);" class="waves-effect multi"><i class="md md-access-time"></i><span>TimeTable Management</span> <span class="menu-arrow"></span></a>
                  <ul class="list-unstyled">
                     <security:authorize access="hasRole('timetabletemplate')">
                        <li>
                           <a href="<c:url value='/timetable/template'/>"> Create Time Table</a>
                        </li>
                     </security:authorize>
                     <security:authorize access="hasRole('timetablegenerator')">
                        <li>
                           <a href="<c:url value='/timetable/generator'/>"> Generate Time Table</a>
                        </li>
                     </security:authorize>
                     <security:authorize access="hasRole('timetablegenerator')">
                        <li>
                           <a href="<c:url value='/timetable/generator/automatic'/>"> Automatic Time Table Generate</a>
                        </li>
  						<li>
                          <a href="<c:url value='/timetable/generator/substitute'/>">Substitute Time Table Generate</a>
                        </li>
                     </security:authorize>
                  </ul>
               </li>
            </security:authorize> --%>
            <security:authorize access="hasAnyRole('usermanagement','rolemanagement')">
               <li class="has_sub">
                  <a href="<c:url value='/rolemanagement'/>" class="waves-effect"><i class="md md-accessibility"></i><span> Role Management </span> </a>
               </li>
            </security:authorize>
          <%--   <security:authorize access="hasAnyRole('dashboard/admin','dashboard/principal')">
               <li class="has_sub">
                  <a href="<c:url value='/staff/inventorycharts'/>" class="waves-effect"><i class="fa  fa-area-chart"></i><span>Inventory Charts </span> </a>
               </li>
            </security:authorize> --%>
         <%--    <security:authorize access="hasAnyRole('class','dashboard/principal')">
               <li class="has_sub">
                  <a href="<c:url value='/staff/feescharts'/>" class="waves-effect"><i class="typcn typcn typcn-chart-pie "></i><span>Charts </span> </a>
               </li>
            </security:authorize> --%>
       
              <security:authorize access="hasAnyRole('class','dashboard/principal')">
               <li class="has_sub">
                  <a href="<c:url value='/staff/feescharts'/>" class="waves-effect"><i class="typcn typcn typcn-chart-pie "></i><span>Charts </span> </a>
               </li>
            </security:authorize>
              <security:authorize access="hasAnyRole('dashboard/superadmin')">
               <li class="has_sub">
                  <a href="<c:url value='/staff/charts'/>" class="waves-effect"><i class="typcn typcn typcn-chart-pie "></i><span>Charts </span> </a>
               </li>
</security:authorize>
            <security:authorize access="hasAnyRole('reports','dashboard/principal')">
            <li>
               <a href="javascript:void(0);"class="waves-effect multi"><i class="ti-bar-chart"></i><span>Reports </span> <span class="menu-arrow"></span></a>
               <ul class="list-unstyled">
               
     <%--            <security:authorize access="hasAnyRole('dashboard/admin')">
                  <li class="has_sub">
                     <a href="javascript:void(0);" class="waves-effect"><span>Attendance Reports</span>  <span class="menu-arrow"></span></a>
                     <ul style="">
                        <li>
                           <a href="<c:url value='/staff/attendancereport'/>">Student Attendance Reports</a>
                        </li>
                        <li>
                           <a href="<c:url value='/staff/attendancepercentagereport'/>">Attendance Percentage Reports</a>
                        </li>
                     </ul>
                  </li>
                  </security:authorize> --%>
                  
                  <security:authorize access="hasAnyRole('feesreports','dashboard/principal','dashboard/superadmin','dashboard/admin')">
                  <li class="has_sub">
                     <a href="javascript:void(0);" class="waves-effect"><span>Fees Reports</span>  <span class="menu-arrow"></span></a>
                     <ul style="">
                      
                        <li>
                           <a href="<c:url value='/report/studentWise'/>">Student Wise Fees Report</a>
                        </li>
                      
                       <li>
                           <a href="<c:url value='/report/studentWise/refund'/>">Student Wise Fees Refund Report</a>
                        </li>
                        <li>
                           <a href="<c:url value='/invoice/invoiceAndReceipt'/>">Invoice / FCR</a>
                        </li>
                      
                          
                        <li>
                           <a href="<c:url value='/report/academicfeesreport'/>">Academic Fees Report</a>
                        </li>
                       
                        <li>
                           <a href="<c:url value='/report/academicfeesreportbasedtaxclass'/>">Academic Fees Report (TAX Class)</a>
                        </li>
                       
                        <li>
                           <a href="<c:url value='/report/accountingfeesreport'/>">Accounting Fees Report</a>
                        </li>
                        <li>
                           <a href="<c:url value='/report/accountingfeesreportbasedtaxclass'/>">Accounting Fees Report (TAX Class)</a>
                        </li>
                       
                        <li>
                           <a href="<c:url value='/report/paymentmodewisefeesreport'/>">Payment Mode Wise Fees Report</a>
                        </li>
                       
                     </ul>
                  </li>
                  </security:authorize>
                  
                   
   <%--                 <security:authorize access="hasAnyRole('dashboard/admin','dashboard/principal')">
                  <li class="has_sub">
                     <a href="javascript:void(0);" class="waves-effect"><span>TC Related Reports</span>  <span class="menu-arrow"></span></a>
                     <ul style="">
                        <li>
                           <a href="<c:url value='/staff/tcapprovedreport'/>">TC Approved List</a>
                        </li>
<security:authorize access="hasAnyRole('dashboard/staff')">
                            <li>
                           <a href="<c:url value='/staff/tcapprovedlist/reports'/>"><i class="fa fa-snowflake-o"></i><span>TC Approved List</span></a>
                        </li>
</security:authorize>
                     </ul>
                  </li>
                  </security:authorize> --%>
               </ul>
            </li>
            </security:authorize>
           <%--  <security:authorize access="hasRole('dashboard/student)">
               <li>
                  <a href="<c:url value='/student/leave/requisition'/>" class="waves-effect"><i class="ti-bar-chart"></i><span>Requisition</span></a>
               </li>
            </security:authorize> --%>
   <%--          <security:authorize access="hasRole('visitormanagement')">
               <li class="has_sub">
                  <a href="<c:url value='/visitormanagement'/>" class="waves-effect"><i class="md  md-visibility"></i><span>Visitor Management</span></a>
               </li>
            </security:authorize> --%>
       <%--      <security:authorize access="hasAnyRole('dashboard/admin','dashboard/principal')">
            <li class="has_sub">
               <a href="javascript:void(0);" class="waves-effect multi"><i class="fa fa-ambulance"></i><span>SickRoom Management</span> <span class="menu-arrow"></span></a>
               <ul class="list-unstyled">
                 <security:authorize access="hasAnyRole('dashboard/admin')">
                     <li class="has_sub">
                        <a href="<c:url value='/sickroomvisitor'/>" class="waves-effect"><span>SickRoom Visitors</span></a>
                     </li>
               </security:authorize>
               
                     <li class="has_sub">
                        <a href="<c:url value='/sickroomvisitor/managesickroomvisitor'/>" class="waves-effect"><span>Manage SickRoom Visitors</span></a>
                     </li>
           
               </ul>
            </li> 
            </security:authorize> --%>
<%--        <security:authorize access="hasAnyRole('communication/admin','communication/staff','communication/student','communication/parent','communication/feesadmin','communication/inventoryandassetadmin','communication/libraryadmin')">
           
               <li>
                  <a href="<c:url value='/staff/meeting/requisition'/>" class="waves-effect"><i class="md  md-party-mode"></i><span>Meeting Requisition</span></a>
               </li>
            </security:authorize>
            
            <li class="has_sub">
               <a href="javascript:void(0);" class="waves-effect multi"><i class="md md-report-problem"></i><span>Complaint Management</span> <span class="menu-arrow"></span></a>
               <ul class="list-unstyled">
                <security:authorize access="hasAnyRole('dashboard/principal')">
                     <li class="has_sub">
                        <a href="<c:url value='/complaintManagement/approvals'/>" class="waves-effect"><span>Complaint Approver</span></a>
                     </li>
                </security:authorize>
                   <security:authorize access="hasAnyRole('communication/admin','communication/staff','communication/student','communication/parent','communication/feesadmin','communication/inventoryandassetadmin','communication/libraryadmin')">
           
                     <li class="has_sub">
                        <a href="<c:url value='/complaintManagement/requisition'/>" class="waves-effect"><span>Complaint Requester</span></a>
                     </li>
             </security:authorize>
               </ul>
            </li>
              <security:authorize access="hasAnyRole('dashboard/admin')">
            <li class="has_sub">
               <a href="javascript:void(0);" class="waves-effect multi"><i class="fa fa-reorder (alias)"></i><span>Appraisal Management</span> <span class="menu-arrow"></span></a>
               <ul class="list-unstyled">
                  <security:authorize access="hasAnyRole('dashboard/admin')">
                     <li class="has_sub">
                        <a href="<c:url value='/staff/staffappraisal'/>" class="waves-effect"><span>Staff Appraisal</span></a>
                     </li>
                  </security:authorize>
                  <security:authorize access="hasAnyRole('dashboard/admin','dashboard/staff')">
                     <li class="has_sub">
                        <a href="<c:url value='/student/studentappraisal'/>" class="waves-effect"><span>Student Appraisal</span></a>
                     </li>
                  </security:authorize>
  <security:authorize access="hasAnyRole('dashboard/staff')">
                          <li class="has_sub">
                                <a href="<c:url value='/student/studentappraisal/reports'/>" class="waves-effect"><span>Student Appraisal</span></a>
                             </li>
</security:authorize>
               </ul>
            </li>
            </security:authorize> --%>
             <security:authorize access="hasAnyRole('dashboard/superadmin')">
                 <li>
               <a href="<c:url value='/staff/transactiondetails'/>" class="waves-effect"><i class="md  md-control-point-duplicate"></i><span>Transaction Management </span></a>
               </li>
             </security:authorize>
             <security:authorize access="hasAnyRole('dashboard/admin')">
                 <li>
               <a href="<c:url value='/smsgatewaydetails'/>" class="waves-effect"><i class="md md-chat"></i><span>SMS Gateway Details</span></a>
               </li>
             </security:authorize>
              <security:authorize access="hasAnyRole('communication/admin','communication/staff','communication/student','communication/parent','communication/principal','communication/feesadmin','communication/inventoryandassetadmin','communication/libraryadmin')">
               <li>
                  <a href="<c:url value='/communication'/>"class="waves-effect"><i class="md md-settings-input-antenna"></i><span>Communication</span></a>
               </li>
            </security:authorize>
            <security:authorize access="hasRole('admissionmanagement')">
               <li class="has_sub">
                  <a href="javascript:void(0);" class="waves-effect multi"><i class="glyphicon glyphicon-asterisk"></i><span>Admissions </span> <span class="menu-arrow"></span></a>
                  <ul class="list-unstyled">
                   <%--   <li><a href="<c:url value='/admissions/admissiondashboard'/>"> Admissions Dashboard</a></li> --%>
                     <li><a href="<c:url value='/admissions/admissionconfig'/>"> Admissions Configuration</a></li>
                     <li><a href="<c:url value='/admissions/finalization'/>"> Finalization</a></li>
                     <li><a href="<c:url value='/admissions/newadmission'/>"> (New) Student Registration</a></li>
                    <%--  <li><a href="<c:url value='/trainingcentre/newenquiryregister'/>"> (New) Enquiry Registration</a></li> --%>
                     <li><a href="<c:url value='/admissions/admissioncandidatedetails'/>"> Admission Details</a></li>
                  </ul>
               </li>
            </security:authorize>
            <security:authorize access="hasRole('admissioncandidate')">
               <li class="has_sub">
                  <a href="<c:url value='/admissions/candidate/unversityprofile'/>" class="waves-effect"><i class="fa fa-shield nav_icon"></i><span> University Profile </span></a>
               </li>
               <li class="has_sub">
                  <a href="<c:url value='/admissions/candidate/applyforadmission'/>" class="waves-effect"><i class="fa fa-pencil nav_icon"></i><span> Apply For Admission </span></a>
               </li>
               <li class="has_sub">
                  <a href="<c:url value='/admissions/candidate/admissioncourses'/>" class="waves-effect"><i class="fa fa-book nav_icon"></i><span> Classes </span></a>
               </li>
               <li class="has_sub">
                  <a href="<c:url value='/admissions/candidate/statusandcommunication'/>" class="waves-effect"><i class="fa fa-comments-o nav_icon"></i><span> Admission Notifications </span></a>
               </li>
            </security:authorize>
            <security:authorize access="hasRole('backup')">
               <li class="has_sub">
                  <a href="<c:url value='/BackupAndRestore'/>" class="waves-effect"><i class="md md-backup"></i><span> Backup </span></a>
               </li>
            </security:authorize>
            
         </ul>
         <div class="clearfix"></div>
      </div>
      <div class="clearfix"></div>
   </div>
</div>
<!-- Left Sidebar End -->

