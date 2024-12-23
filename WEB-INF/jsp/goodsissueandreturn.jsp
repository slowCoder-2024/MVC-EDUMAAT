<!DOCTYPE HTML>
<html>
<head>    <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta name="description" content="A fully featured education management system">
      <meta name="author" content="edumaat">
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
     
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
      
       <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.colVis.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/fixedColumns.dataTables.min.css" rel="stylesheet" type="text/css"/>
      
      
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
               		<div class="form-group">
                     <button type="button" class="btn btn-primary col-md-3 btn-custom waves-effect waves-light" onclick="showGoodsIssue()">Goods Issue</button>
                  </div>
                  <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                   <br />
               		 <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Goods Issue List</b></h4>
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
                              	 <th>Item Name</th>
                                 <th>Quantity Issued</th>
                                  <th>Issued To</th>
                                   <th>Issued By</th>
                                    <th>Issued AcademicYear</th>
                                  <th>Date Of Issue</th>
                                  <th>Quantity Returned</th>
                                  <th>Return</th>
                                 </tr>
                           </thead>
                          <tbody id="goodsissueandreturnlist">
                          
                         <c:if test="${!empty inventoryItemIssueMasterList}">
                          
                              <c:forEach items="${inventoryItemIssueMasterList}" var="inventoryItemIssueAndReturnMaster">
                              <c:set var="noofquantityissued" value="0.0"/>
                         
                               <c:forEach items="${inventoryItemIssueAndReturnMaster.getInventoryItemReturnMaster()}" var="inventoryItemReturnMaster">
                             <c:set var="noofquantityissued" value="${noofquantityissued+inventoryItemReturnMaster.getNoOfQtyReturn()}"/>
                           </c:forEach>
                            <c:if test="${noofquantityissued<inventoryItemIssueAndReturnMaster.getNoOfQtyIssue()}">
                                <tr>
                                    <td>${inventoryItemIssueAndReturnMaster.getInventoryItemMaster().getItemName()}</td>
                                     <td>${inventoryItemIssueAndReturnMaster.getNoOfQtyIssue()}</td>
                                      <td>${inventoryItemIssueAndReturnMaster.getIssueToUser().getName()}</td>
                                       <td>${inventoryItemIssueAndReturnMaster.getInCharge().getName()}</td>
                                        <td>${inventoryItemIssueAndReturnMaster.getAcademicYear().getAcademicYearTitle()}</td>
                                         <td><fmt:formatDate pattern="dd/MM/yyyy" value="${inventoryItemIssueAndReturnMaster.getItemIssueDate()}" /></td>
                                       <td>${noofquantityissued}</td>
                                        <td>
	                                  		<a href="#" id="edit"  type="button"data-href="#" data-id="${inventoryItemIssueAndReturnMaster.getInventoryItemIssueAndReturnMasterId()}" data-toggle="modal" onclick="showGoodsReturn()">
	                                       	  <i class="fa fa-pencil" style="margin-right: 15px"></i>
	                                        </a>
	                                     <a href="#"  id="goodsdelete"  type="button" data-href="#"  data-id="${inventoryItemIssueAndReturnMaster.getInventoryItemIssueAndReturnMasterId()}" data-toggle="modal" data-target="deletegoodsissueconfirmation">
	                                      <i class="fa fa-trash-o"></i>
	                                       </a>
	                                    </td>
                                 </tr>
                                 </c:if>
                              </c:forEach>
                           </c:if> 
                          
                          </tbody>
                        </table>
                        </div>
                         </div>
                  </div>
            <br>
            <br>
             		 <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Goods Return List</b></h4>
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
                              	 <th>Item Name</th>
                                 <th>Quantity Issued</th>
                                  <th>Issued To</th>
                                   <th>Issued By</th>
                                    <th>Issued AcademicYear</th>
                                  <th>Date Of Issue</th>
                                   <th>Total Quantity Returned</th>
                                 <th>Return Details</th>
                                    </tr>
                           </thead>
                          <tbody id="goodsreturnlist">
                          
                                <c:if test="${!empty inventoryItemIssueMasterList}">
                          
                              <c:forEach items="${inventoryItemIssueMasterList}" var="inventoryItemIssueAndReturnMaster">
                              <c:set var="noofquantityissued" value="0.0"/>
                         
                               <c:forEach items="${inventoryItemIssueAndReturnMaster.getInventoryItemReturnMaster()}" var="inventoryItemReturnMaster">
                             <c:set var="noofquantityissued" value="${noofquantityissued+inventoryItemReturnMaster.getNoOfQtyReturn()}"/>
                           </c:forEach>
                                <c:if test="${noofquantityissued>0.0}">
                                <tr>
                                    <td>${inventoryItemIssueAndReturnMaster.getInventoryItemMaster().getItemName()}</td>
                                     <td>${inventoryItemIssueAndReturnMaster.getNoOfQtyIssue()}</td>
                                      <td>${inventoryItemIssueAndReturnMaster.getIssueToUser().getName()}</td>
                                       <td>${inventoryItemIssueAndReturnMaster.getInCharge().getName()}</td>
                                        <td>${inventoryItemIssueAndReturnMaster.getAcademicYear().getAcademicYearTitle()}</td>
                                         <td><fmt:formatDate pattern="dd/MM/yyyy" value="${inventoryItemIssueAndReturnMaster.getItemIssueDate()}" /></td>
                                        <td>${noofquantityissued}</td>
                                        <td>
	                                  		<a href="#" id="viewgoodsreturndetails"  type="button"data-href="#" data-id="${inventoryItemIssueAndReturnMaster.getInventoryItemIssueAndReturnMasterId()}" data-toggle="modal" onclick="viewGoodsReturnList()">
	                                       	    <span class="glyphicon glyphicon-list-alt"></span> 
	                                        </a>
	                                     
	                                    </td>
                                 </tr>
                                 </c:if>
                                   </c:forEach>
                           </c:if> 
                          
                          </tbody>
                        </table>
                        </div>
                         </div>
                  </div>
              <%--  	</security:authorize> --%>
                
               </div>
              
               <div class="modal fade" id="deletegoodsissueconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure you want to delete this goods issue ?</h5>
                        </div>
                        <div class="modal-footer">
                           <form id="deletegoodsissueform" action="${pageContext.request.contextPath}/inventoryandpurchase/goodsissueandreturn/deleteitemissue" method="post">
                              <input type="hidden" id="deleteInventoryItemIssueMasterId" name="deleteInventoryItemIssueMasterId">
                              <button type="button" id="confirmdeletegoodsissue"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="modal fade" id="itemupdateconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure you want to update this goods return ?</h5>
                        </div>
                        <div class="modal-footer">
                           <button type="button" name="itemUpdateConfirm" id="itemUpdateConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                        </div>
                     </div>
                  </div>
               </div>
               <div id="FormDiv" style="display: none">
                   <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Create New Goods Issue</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="additemissueform" action="${pageContext.request.contextPath}/inventoryandpurchase/goodsissueandreturn/newitemissue" method="post">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Item Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                 	 <select name="inventoryItem" id="inventoryItem" class="selectpicker"  required="required" data-live-search="true"  data-style="btn-white">
                                              <option value="" disabled selected>Select Item Name</option>
                                             <c:if test="${!empty inventoryItemMasterList}">
                                        <c:forEach items="${inventoryItemMasterList}" var="inventoryItemMasterList">
                                         <option value="${inventoryItemMasterList.getItemId()}">${inventoryItemMasterList.getItemName()}</option>
                                        </c:forEach>
                                      </c:if>
                                          </select>
								  </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">No.Of Quantity Issue<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="noOfQuantityIssue" class="form-control" id="noOfQuantityIssue" placeholder="" onkeypress="return isNumber(event)" required maxlength="50">
                                 </div>
                              </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Location<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="location" class="form-control" id="location" placeholder="" required="required">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="userId" id="userId" class="selectpicker"  required="required" data-live-search="true"  data-style="btn-white">
                                              <option value="" disabled selected>Select User Email</option>
                                             <c:if test="${!empty userList}">
                                        <c:forEach items="${userList}" var="userList">
                                         <option value="${userList.getUserId()}">${userList.getEmail()}</option>
                                        </c:forEach>
                                      </c:if>
                                          </select>
                                 </div>
                              </div>
                               	<div class="row">
	                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
	                                 <div class="col-sm-offset-3">
	                                    <button style="float:right"  type="button" id="saveitemissue" class="btn btn-success btn-custom waves-effect waves-light">Save</button>
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
                  <div class="modal fade" id="itemissuesaveconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure you want to add this goods issue ?</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="itemissuesaveconfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div id="goodsreturnhistorydiv" style="display: none" >
                <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-success">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Goods Return History</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                            <table class="table table-striped table-bordered" id="goodsreturnhistoryList">
                              <thead>
                                 <tr>
                                 <th>Quantity Returned</th>
                                  <th>Returned By</th>
                                   <th>Returned AcademicYear</th>
                                 <th>Date Of Return</th>
                                 </tr>
                              </thead>
                              <tbody>
                         
                              </tbody>
                           </table>
                             
                           <div class="row">
                              <div class="col-sm-offset-3">
                           
                               <button style="float: right" type="button" onclick="location.reload(this)" class="btn btn-danger  btn-custom waves-effect waves-light">Cancel</button>       
                              </div>
                           </div>
                           </div>
                           </div>
                           </div>
                           </div>
                           </div>
                           
               </div>
               <div id="goodsreturndiv" style="display: none" >
                  <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Goods Return</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="addreturnitemform" action="${pageContext.request.contextPath}/inventoryandpurchase/goodsissueandreturn/itemreturn" method="post">
                                <input type="hidden" id="inventoryItemIssueAndReturnMasterId" name="inventoryItemIssueAndReturnMasterId">
                       <input type="hidden" id="itemQuantityIssued" name="itemQuantityIssued">
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">No.Of Quantity Return<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="noOfQuantityReturn" class="form-control" id="noOfQuantityReturn" onkeypress="return isNumber(event)" placeholder="" required maxlength="50">
                                 </div>
                              </div>
                              
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Returned User Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="returnedUserId" id="returnedUserId" class="selectpicker"  required="required" data-live-search="true"  data-style="btn-white">
                                              <option value="" disabled selected>Select User Email</option>
                                             <c:if test="${!empty returnedUserList}">
                                        <c:forEach items="${returnedUserList}" var="userList">
                                         <option value="${userList.getUserId()}">${userList.getEmail()}</option>
                                        </c:forEach>
                                      </c:if>
                                          </select>
                                 </div>
                              </div>
                              
	                              	<div class="row">
	                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
	                                 <div class="col-sm-offset-3">
	                                    <button style="float:right"  type="button" id="savereturnitem" class="btn btn-success btn-custom waves-effect waves-light">Update</button>
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
          
      <script src="${pageContext.request.contextPath}/resources/themes/script/goodsissueandreturn.js" type="text/javascript"></script>
     <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/buttons.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/jszip.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/pdfmake.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/vfs_fonts.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/buttons.html5.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/buttons.print.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.fixedHeader.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.keyTable.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/responsive.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.scroller.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.colVis.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.fixedColumns.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/assets/pages/datatables.init.js"></script>



<script type="text/javascript">
  
    TableManageButtons.init();

</script>
   </body>
</html>

