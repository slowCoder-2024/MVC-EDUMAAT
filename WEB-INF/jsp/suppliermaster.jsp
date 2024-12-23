<!DOCTYPE HTML>
<html>
<head>    <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta name="description" content="A fully featured education management system">
      <meta name="author" content="edumaat">
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <link rel="edumaat icon" href="${pageContext.request.contextPath}/resources/themes/assets/images/favicon.ico">
      <title>EMS</title>
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-table/css/bootstrap-table.min.css" rel="stylesheet" type="text/css" />
      <link href="${pageContext.request.contextPath}/resources/themes/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
      <link href="${pageContext.request.contextPath}/resources/themes/assets/css/core.css" rel="stylesheet" type="text/css" />
      <link href="${pageContext.request.contextPath}/resources/themes/assets/css/components.css" rel="stylesheet" type="text/css" />
      <link href="${pageContext.request.contextPath}/resources/themes/assets/css/icons.css" rel="stylesheet" type="text/css" />
      <link href="${pageContext.request.contextPath}/resources/themes/assets/css/pages.css" rel="stylesheet" type="text/css" />
      <link href="${pageContext.request.contextPath}/resources/themes/assets/css/responsive.css" rel="stylesheet" type="text/css" />
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-tagsinput/css/bootstrap-tagsinput.css" rel="stylesheet" />
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/switchery/css/switchery.min.css" rel="stylesheet" />
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/multiselect/css/multi-select.css"  rel="stylesheet" type="text/css" />
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet" />
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-touchspin/css/jquery.bootstrap-touchspin.min.css" rel="stylesheet" />
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/modernizr.min.js"></script>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/edumaatalert/edumaatalert.css"/>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
<%--       <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/jquery.form-advanced.init.js"></script> --%>
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.11.2.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.7.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
      
       <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/timepicker/bootstrap-timepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/clockpicker/css/bootstrap-clockpicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
      
         <c:if test="${!empty alert}">
          <script type="text/javascript">
          $(document).ready(function(){
  			var status='${alert.getStatus()}'
  			var message='${alert.getMessage()}';
  			    if(status=='failure'){
  			    	edumaatAlert({
  			    		 title:"Error!",
  			    		 text:message,
  			    		 type:"error",
  			    	});
  			    }
  			    else if(status=='success'){
  			    	edumaatAlert({
  			    		 title:"Success !",
  			    		 text:message,
  			    		 type:"success",
  			         });
  			    }else
  			    {
 			    	 edumaatAlert({
		    			  title: "Info !",
		    			  text:message,
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
 			    }
  		 }); 
          </script>
         
        </c:if>
        <style type="text/css">
        
        .thumb-image {
         width:200px;
         height:200px;
         display: block;
         padding: 4px;
         margin-bottom: 20px;
         line-height: 1.42857143;
         background-color: #fff;
         border: 1px solid #8470FF;
         border-radius: 4px;
         -webkit-transition: border .2s ease-in-out;
         -o-transition: border .2s ease-in-out;
         transition: border .2s ease-in-out;
         }
         #secondstep{
         display:none
         }
        .loader {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url('${pageContext.request.contextPath}/resources/themes/images/page-loader.gif') 50% 50% no-repeat rgba(255, 255, 255, 0.71);
}
        </style>
    
     
</head> 
   </head>
<body class="fixed-left">
	           
				<!-- Begin page -->
		<div id="wrapper">
                <%@ include file="master_header.jsp" %>
                <%@ include file="master_menu.jsp" %>
    	<div class="content-page">
				<!-- Start content -->
				<div class="content">
<div class="container">
      <div class="loader"  style="display: none"></div>
                <div id="ListDiv" style="display:block;">
            <%--    	<security:authorize access="hasRole('section/add')"> --%>
               		<div class="form-group">
                     <button type="button" class="btn btn-primary col-md-3 btn-custom waves-effect waves-light" onclick="showDiv()">Add New Supplier Master</button>
                  </div>
                  <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                   <br />
              <%--  	</security:authorize>
               	 --%>
              <%--  	<security:authorize access="hasRole('section/viewlist')"> --%>
               		 <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Supplier Master List</b></h4>
                        <table data-toggle="table"
                                 data-show-columns="true"
                                 data-page-list="[5, 10, 20]"
                                 data-page-size="5"
                                 data-search="true"
										   data-show-refresh="true"
										   data-show-toggle="true"
										   data-show-columns="true"
                                 data-pagination="true" data-show-pagination-switch="true"  class="table-bordered ">
                           <thead>
                              <tr>
                              	 <th>S.NO</th>
                                 <th>Supplier Name</th>
                                 <th>Supplier Code</th>
                                 <th>Gender</th>
                                 <th>Contact No</th>
                                 <th>Email</th>
                               	 <th>Bank Name</th>
                                 <th>Bank Account No</th>
                                 <th>TIN No</th>
                                 <th>Status</th>
                                <%--  <security:authorize access="hasAnyRole('section/view','section/delete')"> --%>
                                 	<th>Action</th>
                              <%--    </security:authorize> --%>
                              </tr>
                           </thead>
                          <tbody id="supplierMasterlist">
                          
                         <c:if test="${!empty suppliermasterlist}">
                              <c:set var="sno" value="1"/>
                              <c:forEach items="${suppliermasterlist}" var="suppliermaster">
                                <tr>
                                    <td>${sno}</td>
                                    <td>${suppliermaster.getSupplierName()}</td>
                                       <td>${suppliermaster.getSupplierCode()}</td>
                                     <td>${suppliermaster.getGender()}</td>
                                      <td>${suppliermaster.getContactNumber()}</td>
                                       <td>${suppliermaster.getEmail()}</td>
                                        <td>${suppliermaster.getBankName()}</td>
                                         <td>${suppliermaster.getBankAccountNo()}</td>
                                          <td>${suppliermaster.getTinNumber()}</td>
                                            <td>
				                                    	<c:if test="${suppliermaster.getStatus()==0}">In Active</c:if> 
					                                    <c:if test="${suppliermaster.getStatus()==1}">Active</c:if> 
					                                </td>
                                  <%--   <security:authorize access="hasAnyRole('section/view','section/delete')"> --%>
	                                    <td>
	                                   <%--  <security:authorize access="hasRole('section/view')"> --%>
	                                   		<a href="#" id="edit"  type="button"data-href="#" data-id="${suppliermaster.getSupplierId()}" data-toggle="modal" onclick="showeditDiv()">
	                                       	  <i class="fa fa-pencil" style="margin-right: 15px"></i>
	                                        </a>
	                                <%--     </security:authorize>
	                                    <security:authorize access="hasRole('section/delete')"> --%>
	                                    	<a href="#"  id="delete"  type="button" data-href="#"  data-id="${suppliermaster.getSupplierId()}" data-toggle="modal" data-target="#deletesuppliermasterconfirmation">
	                                      <i class="fa fa-trash-o"></i>
	                                       </a>
	                                  <%--   </security:authorize> --%>
	                                    </td>
                                	<%-- </security:authorize> --%>
                                 </tr>
                                 <c:set var="sno" value="${sno+1}"/>
                              </c:forEach>
                           </c:if> 
                          
                          </tbody>
                        </table>
                        </div>
                         </div>
                  </div>
             <%--   	</security:authorize> --%>
                
               </div>
              
               <div class="modal fade" id="deletesuppliermasterconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure you want to delete this supplier ?</h5>
                        </div>
                        <div class="modal-footer">
                           <form id="deletesuppliermasterform" action="${pageContext.request.contextPath}/inventoryandpurchase/suppliermaster/delete" method="post">
                              <input type="hidden" id="deleteSupplierMasterId" name="deleteSupplierMasterId">
                              <button type="button" id="confirmdeletesuppliermaster"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="modal fade" id="suppliermasterupdateconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure you want to update this supplier ?</h5>
                        </div>
                        <div class="modal-footer">
                           <button type="button" name="suppliermasterUpdateConfirm" id="suppliermasterUpdateConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                        </div>
                     </div>
                  </div>
               </div>
               <div id="FormDiv" style="display: none">
                   <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Create New Supplier Master</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="addsupplierform" action="${pageContext.request.contextPath}/inventoryandpurchase/suppliermaster/add" method="post">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Supplier Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="supplierName" class="form-control" id="supplierName" placeholder="" required maxlength="50">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Contact Person Name</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="contactPersonName" class="form-control" id="contactPersonName" placeholder="" maxlength="50">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Description</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="supplierDescription" class="form-control" id="supplierDescription" placeholder="" maxlength="100">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Gender<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                          <select name="supplierGender" id="supplierGender" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Gender</option>
                                             <option value="Male">Male</option>
                                             <option value="Female">Female</option>
                                             <option value="Others">Others</option>
                                          </select>
                                       </div>
                              </div>
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Contact Number<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="supplierContactNumber" class="form-control" id="supplierContactNumber" placeholder="" required="required" maxlength="51">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="supplierEMail" class="form-control" id="supplierEmail" placeholder="" required="required" maxlength="50">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">FAX<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="supplierFAX" class="form-control" id="supplierFAX" placeholder="" required="required" maxlength="50">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 1<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="supplierAddressLine1" class="form-control" id="supplierAddressLine1" placeholder="" required="required" maxlength="225">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 2<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="supplierAddressLine2" class="form-control" id="supplierAddressLine2" placeholder="" required="required" maxlength="225">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="supplierCountry" id="geographicallocation" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Country </option>
                                             <c:if test="${!empty countries}">
		                                       		<c:forEach items="${countries}" var="country">
		                                       			<option value="${country.getName()}">${country.getName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>      
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">State<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="supplierState" id="geographicallocationstate" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>No Country Selected</option>
                                          </select>
                                       </div>
                                    </div> 
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">City<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="supplierCity" id="geographicallocationcity" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>No State Selected</option>
                                          </select>
                                       </div>
                                    </div>      
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Post Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="supplierPostCode" class="form-control" id="supplierPostCode" placeholder="" maxlength="6" required="required" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              
                                  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="supplierBankName" class="form-control" id="supplierBankName" required="required" placeholder="" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Account No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="supplierBankAccountNo" class="form-control" id="supplierBankAccountNo" required="required" placeholder="" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank IFSC Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="supplierBankIFSC" class="form-control" id="supplierBankIFSC" required="required" placeholder="" maxlength="100">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">PAN No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="supplierPANNo" class="form-control" id="supplierPANNo" required="required" placeholder="" maxlength="50">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">TIN No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="supplierTINNo" class="form-control" id="supplierTINNo" required="required" placeholder="" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">CST No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="supplierCSTNo" class="form-control" id="supplierCSTNo" required="required" placeholder="" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Service Tax No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="supplierServiceTaxNo" class="form-control" id="supplierServiceTaxNo" required="required" placeholder="" maxlength="100">
                                 </div>
                              </div>
                             
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="supplierStatus" id="supplierStatus" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
                                 </div>
                               </div>
	                              	<div class="row">
	                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
	                                 <div class="col-sm-offset-3">
	                                    <button style="float:right"  type="button" id="saveSupplier" class="btn btn-success btn-custom waves-effect waves-light">Save</button>
	                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
	                                    <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload();">Cancel</button>
	                                 </div>
	                              </div>
                             
                           </form>
                           </div>
                           </div>
                           
                           
                          
                        </div>
                     </div>
                  </div>
                  <div class="modal fade" id="suppliersaveconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure you want to add this supplier ?</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="suppliersaveconfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div id="EditFormDiv" style="display:none;" >
                     <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Edit Supplier Master Details</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="updatesuppliermasterform" action="${pageContext.request.contextPath}/inventoryandpurchase/suppliermaster/update" method="post">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Supplier Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editSupplierName" class="form-control" id="editSupplierName" placeholder="" required maxlength="50">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Contact Person Name</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editContactPersonName" class="form-control" id="editContactPersonName" placeholder="" maxlength="50">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Description</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editSupplierDescription" class="form-control" id="editSupplierDescription" placeholder="" maxlength="100">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Gender<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                          <select name="editSupplierGender" id="editSupplierGender" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Gender</option>
                                             <option value="Male">Male</option>
                                             <option value="Female">Female</option>
                                             <option value="Others">Others</option>
                                          </select>
                                       </div>
                              </div>
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Contact Number<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editSupplierContactNumber" class="form-control" id="editSupplierContactNumber" placeholder="" required="required" maxlength="51">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editSupplierEmail" class="form-control" id="editSupplierEmail" placeholder="" required="required" maxlength="50">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">FAX<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editSupplierFAX" class="form-control" id="editSupplierFAX" placeholder="" required="required" maxlength="50">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 1<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editSupplierAddressLine1" class="form-control" id="editSupplierAddressLine1" placeholder="" required="required" maxlength="225">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 2<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editSupplierAddressLine2" class="form-control" id="editSupplierAddressLine2" placeholder="" required="required" maxlength="225">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editSupplierCountry" id="geographicallocation1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Country </option>
                                             <c:if test="${!empty countries}">
		                                       		<c:forEach items="${countries}" var="country">
		                                       			<option value="${country.getName()}">${country.getName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>      
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">State<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editSupplierState" id="geographicallocationstate1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            <option value="" disabled selected>Select State </option>
                                             <c:if test="${!empty stateList}">
		                                       		<c:forEach items="${stateList}" var="stateList">
		                                       			<option value="${stateList.getName()}">${stateList.getName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div> 
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">City<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editSupplierCity" id="geographicallocationcity1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                          <option value="" disabled selected>Select City</option>
                                             <c:if test="${!empty cityList}">
		                                       		<c:forEach items="${cityList}" var="cityList">
		                                       			<option value="${cityList.getName()}">${cityList.getName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>      
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Post Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editSupplierPostCode" class="form-control" id="editSupplierPostCode" placeholder="" maxlength="6" required="required" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              
                                  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editSupplierBankName" class="form-control" id="editSupplierBankName" required="required" placeholder="" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Account No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editSupplierBankAccountNo" class="form-control" id="editSupplierBankAccountNo" required="required" placeholder="" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank IFSC Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editSupplierBankIFSC" class="form-control" id="editSupplierBankIFSC" required="required" placeholder="" maxlength="100">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">PAN No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editSupplierPANNo" class="form-control" id="editSupplierPANNo" required="required" placeholder="" maxlength="50">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">TIN No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editSupplierTINNo" class="form-control" id="editSupplierTINNo" required="required" placeholder="" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">CST No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editSupplierCSTNo" class="form-control" id="editSupplierCSTNo" required="required" placeholder="" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Service Tax No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editSupplierServiceTaxNo" class="form-control" id="editSupplierServiceTaxNo" required="required" placeholder="" maxlength="100">
                                 </div>
                              </div>
                             
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="editSupplierStatus" id="editSupplierStatus" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
                                 </div>
                               </div>
                              <input type="hidden" id="updateSupplierMasterId" name="updateSupplierMasterId">
                             <%--  <security:authorize access="hasRole('section/update')"> --%>
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3"> 
                                    <a href="#" id="updateSupplierMaster" style="float:right" class="btn btn-success btn-custom waves-effect waves-light" type="button" data-id="">
                                    Update
                                    </a>   
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                    <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                 </div>
                              </div>
                             <%--  </security:authorize> --%>
                              
                           </form>
                           </div>
                           </div>
                           </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
      </div>
      
       <script>
         var resizefunc = [];
      </script>
      <!-- jQuery  -->
<%-- <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.min.js"></script> --%>
<script src="${pageContext.request.contextPath}/resources/edumaatalert/edumaatalert.js"></script>
 <script src="${pageContext.request.contextPath}/resources/themes/assets/js/bootstrap.min.js"></script> 
  <script src="${pageContext.request.contextPath}/resources/themes/assets/js/detect.js"></script>
    <script src="${pageContext.request.contextPath}/resources/themes/assets/js/fastclick.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/multiselect/js/jquery.multi-select.js"></script>
   <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-select/js/bootstrap-select.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.slimscroll.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.blockUI.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/waves.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/wow.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.nicescroll.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.scrollTo.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-table/js/bootstrap-table.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/pages/jquery.bs-table.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-tagsinput/js/bootstrap-tagsinput.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/switchery/js/switchery.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-quicksearch/jquery.quicksearch.js"></script>
       <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-filestyle/js/bootstrap-filestyle.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-touchspin/js/jquery.bootstrap-touchspin.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-maxlength/bootstrap-maxlength.min.js" type="text/javascript"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.mockjax.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.autocomplete.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/countries.js"></script>
    <%--   <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/select2/js/select2.min.js" type="text/javascript"></script> --%>
     <%--  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/autocomplete.js"></script> --%>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.core.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.app.js"></script>
      
       <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/moment/moment.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/timepicker/bootstrap-timepicker.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/clockpicker/js/bootstrap-clockpicker.min.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/jquery.form-pickers.init.js"></script>
      
               <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-validation/js/jquery.validate.min.js"></script>
          
      <script src="${pageContext.request.contextPath}/resources/themes/script/suppliermaster.js" type="text/javascript"></script>
          <script src="${pageContext.request.contextPath}/resources/themes/script/geographicallocation.js"></script>
    
   </body>
</html>

