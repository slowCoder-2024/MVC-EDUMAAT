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
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/assets/plugins/magnific-popup/css/magnific-popup.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-datatables-editable/datatables.css" />
      
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
           <%--     	<security:authorize access="hasRole('section/add')"> --%>
               		<div class="form-group">
                     <button type="button" class="btn btn-primary col-md-3 btn-custom waves-effect waves-light" onclick="showDiv()">Add New Purchase Order</button>
                  </div>
                  <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                   <br />
               <%-- 	</security:authorize> --%>
               	
              <%--  	<security:authorize access="hasRole('section/viewlist')"> --%>
               		 <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Purchase Order</b></h4>
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
                              <th>Purchase Order Date</th>
                              <th>Supplier Name</th>
                                <th>Purchase Order No</th>
                                <th>Total Quantity</th>
                                  <th>Is Purchased</th>
                                
                               
                                  <th>Academic Year</th>
                                 
                                 
                              
                                 	<th>Action</th>
                              
                              </tr>
                           </thead>
                          <tbody id="purchaseOrderlists">
                          
                         <c:if test="${!empty purchaseOrderLists}">
                              
                              <c:forEach items="${purchaseOrderLists}" var="purchaseOrderList">
                                <tr>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${purchaseOrderList.getPurchaseOrderDate()}"/></td>
                                <td>${purchaseOrderList.getSupplierMaster().getSupplierName()}</td>
                                    <td>${purchaseOrderList.getPurchaseOrderNo()}</td>
                                    <td>${purchaseOrderList.getTotalQuantity()}</td>
                                    
                                    <c:if test="${purchaseOrderList.isPurchased()=='false'}">
		                                    		<td ><span class="label label-table label-danger">
		                                              No
		                                              </span>
		                                    </td>
		                                    </c:if>
		                                    <c:if test="${purchaseOrderList.isPurchased()=='true'}">
		                                    <td ><span class="label label-table label-success">
		                                              Yes
		                                              </span>
		                                    </td></c:if>
                                  
                                     
                                       <td>${purchaseOrderList.getAcademicYear().getAcademicYearTitle()}</td>
                                        
                                        
                                 
                                  
	                                    <td>
	                                   		<a href="#" id="edit"  type="button"data-href="#" data-id="${purchaseOrderList.getPurchaseOrderId()}" data-toggle="modal" onclick="showeditDiv()">
	                                       	  <i class=" glyphicon glyphicon-th-list" style="margin-right: 15px"></i>
	                                        </a>
	                                  
	                                    	<a href="#"  id="delete"  type="button" data-href="#"  data-id="${purchaseOrderList.getPurchaseOrderId()}" data-toggle="modal" data-target="#deleteconfirmation">
	                                      <i class="fa fa-trash-o"></i>
	                                       </a>
	                                 
	                                    </td>
                               
                                 </tr>
                                
                              </c:forEach>
                           </c:if> 
                          
                          </tbody>
                        </table>
                        </div>
                         </div>
                  </div>
               <%-- 	</security:authorize> --%>
                
               </div>
              
               <div class="modal fade" id="deleteconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure you want to delete this Purchase Order ?</h5>
                        </div>
                        <div class="modal-footer">
                           <form id="deletePOform" action="${pageContext.request.contextPath}/inventoryandpurchase/po/delete" method="post">
                              <input type="hidden" id="deletePOId" name="deletePOId">
                              <button type="button" id="confirmdeletepo"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="modal fade" id="sectionupdateconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure you want to update this section ?</h5>
                        </div>
                        <div class="modal-footer">
                           <button type="button" name="sectionUpdateConfirm" id="sectionUpdateConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                        </div>
                     </div>
                  </div>
               </div>
               <div id="FormDiv" style="display: none">
                   <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Create New Purchase Order</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="purchaseOrderForm" action="${pageContext.request.contextPath}/inventoryandpurchase/add/po" method="post">
                             
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Supplier Name <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
 <select name="supplierId" id="supplierId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                      <option value="" disabled selected>Select Supplier </option>
                                      <c:if test="${!empty supplierLists}">
                                           <c:forEach items="${supplierLists}" var="supplierList">
                                             <option value="${supplierList.getSupplierId()}">${supplierList.getSupplierName()}  (${supplierList.getSupplierCode()})</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>                                 </div>
                              </div>
                               
                        
                             
                              
                                <h3 class="m-t-0 header-title" style="color:purple;">Item Details</h3>
                                 <div class="row">
                               <div class="col-sm-12">
                                 <div class="col-sm-offset-3">
                                 
                            
                                 <button  style="float:right"  type="button" class="btn btn-success btn-custom waves-effect waves-light btnadd-item"><i class="fa fa-plus-circle" aria-hidden="true"></i></button>
                                 <button  style="float:right" type="button"  class="btn btn-danger btn-custom waves-effect waves-light btndel-item" disabled="disabled"><i class="fa fa-times-circle" aria-hidden="true"></i></button>     
                                 </div>
                              </div>
                                 </div>
                                 <br>
                             
                                       <table class="table table-striped table-bordered" >
                                          <thead>
                                             <tr>
                                                <th>Item Code/Name</th>
                                                <th>Quantity</th>
                                             </tr>
                                          </thead>
                                          <tbody id="iteminfo">
                                             <tr id="clonedinputitem"class="clonedinputitem">
                                                <td>
                                                   <select name="inventoryItem" id="inventoryItem" data-live-search="true" class="form-control"  data-style="btn-white" required="required">
                                                      <option value="" disabled selected>Select Item</option>
                                                      <c:if test="${!empty itemLists}">
                                                         <c:forEach items="${itemLists}" var="itemList">
                                                            <option value="${itemList.getItemId()}">${itemList.getItemName()}(${itemList.getItemCode()})</option>
                                                         </c:forEach>
                                                      </c:if>
                                                   </select>
                                                </td>
                                                <td>
                                                                                      <input type="text" name="quantity" class="form-control" id="quantity" placeholder="" onkeypress="return isNumber(event)" required maxlength="50">

                                                </td>
                                             </tr>
                                          </tbody>
                                       </table>
                               
                               
						<br>
						 
	                              	<div class="row">
	                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
	                                 <div class="col-sm-offset-3">
	                                 <input type="hidden" id="poDetails" name="poDetails">
	                                    <button style="float:right"  type="button" id="savepurchaseorder" class="btn btn-success btn-custom waves-effect waves-light">Save</button>
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
                  <div class="modal fade" id="posaveconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure you want to add this Purchase Order ?</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="posaveconfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
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
                               <h2 class="panel-title m-t-0 header-title" style="color:purple;">
						Purchase Order Details
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 
						<div class="panel-body">
                             		<table class="table table-bordered" id="inventoryItemLists">
			                              <thead>
			                                 <tr>
			                                    <th>Item Code</th>
			                                        <th>Item Name</th>
			                                  	<th>Quantity</th>
			                                 
			                                </tr>
			                              </thead>
		
                           			</table>
                           			<br>
                           			  <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" onclick="backtolist();"  class="btn btn-success btn-custom waves-effect waves-light">Back</button>
                                 </div>
                              </div>
                        		</div>
                        	 </div>
                        	 </div>
                        	 </div>
                        	 
                        	 <br>
               
                 
                        </div>
                </div> </div>
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
    <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.core.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.app.js"></script>
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
    
    
     <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/tiny-editable/mindmup-editabletable.js"></script>
	    <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/tiny-editable/numeric-input-example.js"></script>
	     <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-datatables-editable/jquery.dataTables.js"></script> 
	    <script src="${pageContext.request.contextPath}/resources/themes/assets/pages/datatables.editable.init.js"></script>
       <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/moment/moment.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/timepicker/bootstrap-timepicker.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/clockpicker/js/bootstrap-clockpicker.min.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/jquery.form-pickers.init.js"></script>
      
               <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-validation/js/jquery.validate.min.js"></script>
          
      <script src="${pageContext.request.contextPath}/resources/themes/script/inventorypurchaseorder.js" type="text/javascript"></script>
  
    
   </body>
</html>

