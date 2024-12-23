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
               		<div class="form-group">
                     <button type="button" class="btn btn-primary col-md-3 btn-custom waves-effect waves-light" onclick="showDiv()">Generate Receipt</button>
                  </div>
                  <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                   <br /> 
              
               	
               
               		 <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Purchase Receipt History</b></h4>
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
                              <th>Generate Date</th>
                               <th>PR Number</th>
                                <th>PO Number</th>
                                <th>Supplier Name</th>
                                  
                                    <th>Academic Year</th>
                                    <th>Tally Reference No</th>
                                     <th>Payment Mode</th>
                      
                                        <th>Total Of Quantity</th>
                                          <th> Total Amount</th>
                                              
                               
                                 	<th>Action</th>
                             
                              </tr>
                           </thead>
                          <tbody id="inventoryReceiptList">
                          
                         <c:if test="${!empty inventoryReceiptLists}">
                              <c:set var="sno" value="1"/>
                              <c:forEach items="${inventoryReceiptLists}" var="inventoryReceiptList">
                                <tr>
                                    <td>${sno}</td>
                      <td><fmt:formatDate pattern="dd/MM/yyyy" value="${inventoryReceiptList.getInventoryReceiptGenerateDate()}"/></td>
                                    
                                  
                                     <td>${inventoryReceiptList.getReceiptNumber()}</td>
                                      <td>${inventoryReceiptList.getInvoiceNumber()}</td>
                                       <td>${inventoryReceiptList.getSupplierMaster().getSupplierName()}</td>
                                        <td>${inventoryReceiptList.getAcademicYear().getAcademicYearTitle()}</td>
                                           <td>${inventoryReceiptList.getTallyReferenceNumber()}</td>
                                              <td>${inventoryReceiptList.getPaymentMode().getPaymentModeTitle()}</td>
                                              <td>${inventoryReceiptList.getQuantity()}</td>
                                              <td>${inventoryReceiptList.getAmount()}</td>
                                
	                                    <td>
	                               
	                                   	
	                                 
	                                    	<a href="#"  id="delete"  type="button" data-href="#"  data-id="${inventoryReceiptList.getInventoryReceiptId()}" data-toggle="modal" data-target="#deletereceiptconfirmation">
	                                      <i class="fa fa-trash-o"></i>
	                                       </a>
	                                 
	                                    </td>
                              
                                 </tr>
                                 <c:set var="sno" value="${sno+1}"/>
                              </c:forEach>
                           </c:if> 
                          
                          </tbody>
                        </table>
                        </div>
                         </div>
                  </div>
              <%--  	</security:authorize>
                 --%>
               </div>
              
               <div class="modal fade" id="deletereceiptconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure you want to delete this purchase receipt ?</h5>
                        </div>
                        <div class="modal-footer">
                           <form id="deletereceiptform" action="${pageContext.request.contextPath}/inventoryandpurchase/pr/delete" method="post">
                              <input type="hidden" id="deletePRId" name="deletePRId">
                              <button type="button" id="confirmdeletereceipt"  class="btn btn-primary" data-dismiss="modal">Yes</button>
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
                                 <h2 class="panel-title">Generate New Receipt</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="receiptform" action="${pageContext.request.contextPath}/inventoryandpurchase/generate/purchaseReceipt" method="post">
                             
                             <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Purchase Order Number <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
 <select name="purchaseOrderId" id="purchaseOrderId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                      <option value="" disabled selected>Select Purchase Order </option>
                                      <c:if test="${!empty purchaseOrderLists}">
                                           <c:forEach items="${purchaseOrderLists}" var="purchaseOrderList">
                                           <c:if test="${purchaseOrderList.isPurchased()==false}" >
                                                                                        <option value="${purchaseOrderList.getPurchaseOrderId()}">${purchaseOrderList.getPurchaseOrderNo()}</option>
                                           
                                           </c:if>
                                          </c:forEach>
                                          
                                       </c:if>
                                    
                                    </select>                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Invoice Number <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="invoiceNumber" class="form-control" id="invoiceNumber" placeholder="" required maxlength="50">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Receipt Number <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="receiptNumber" class="form-control" id="receiptNumber" placeholder="" required maxlength="50">
                                 </div>
                              </div>
                              <br>
                               <h3 class="m-t-0 header-title" style="color:purple;"> Purchase Order Details</h3>
                                 <div class="row">
                               <div class="col-sm-12">
                                
                              </div>
                                 </div>
                                 <br>
                             
                                	<table class="table table-bordered" id="inventoryItemLists">
			                              <thead>
			                                 <tr style="background-color: #91caf5">
			                                 <th>Item ID</th>
			                                    <th>Item Code</th>
			                                     <th>Item Name</th>
			                                     	<th>Unit Of Measure</th>
			                                  	<th>Quantity</th>
			                                  	<th>Per Price</th>
			                                  	<th>Total Price</th>
			                                 
			                                </tr>
			                              </thead>
		
                           			</table>
                           			<br>
                           			<br>
             					  <div class="form-three widget-shadow">
                
             
                  <br>
                  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Tax Class <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                 <select name="taxClass" id="taxClass" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                 	
                                       <option value="" selected disabled>Select Tax Class </option>
                                      <c:if test="${!empty taxClassList}">
                                           <c:forEach items="${taxClassList}" var="taxClassList">
                                             <option value="${taxClassList.getTaxId()}">${taxClassList.getTaxTypeName()}(${taxClassList.getTaxRate()})</option>
                                          </c:forEach>
                                          
                                       </c:if>
                                       
                                  </select>
                                 
                                                                  </div>
                              </div>
             					 <div class="form-group">
                                	 <label for="" class="col-sm-3 control-label">Total Amount</label> 
                                 	<div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="totalamount" name="totalamount" placeholder="" readonly="readonly">
                                 </div>
                                </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Payment Mode <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                 <select name="paymentMode" id="paymentMode" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                 	<c:if test="${!empty paymentModes}">
                                 		<option value="" disabled selected>Select Mode</option>
                                       	<c:forEach items="${paymentModes}" var="paymentmode">
                                       	<c:if test="${paymentmode.getPaymentModeId()==1}">
                                       		<option value="${paymentmode.getPaymentModeId()}">${paymentmode.getPaymentModeTitle()}</option>
                                       	</c:if>
                                       		<c:if test="${paymentmode.getPaymentModeId() !=1}">
                                       		<option value="${paymentmode.getPaymentModeId()}">${paymentmode.getPaymentModeTitle()}</option>
                                       		</c:if>
                                       	</c:forEach>
                                     </c:if>
                                       
                                       
                                  </select>
                                 
                                                                  </div>
                              </div>
                               
                               
                               <div class="form-group form-group-cheque" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Cheque No <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-group-cheque-input" id="chequeNo" name="chequeNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group form-group-cheque" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Cheque Date <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-control-datepicker form-group-cheque-input" id="" name="chequeDate" placeholder="" >
                                 </div>
                                 
                              </div>
                               
                                 <div class="form-group form-group-dd" style="display: none">
                                 <label for="" class="col-sm-3 control-label">DD/EFT No <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-group-dd-input" id="ddNo" name="ddNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group form-group-dd" style="display: none">
                                 <label for="" class="col-sm-3 control-label">DD/EFT Date <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-control-datepicker form-group-dd-input" id="ddDate" name="ddDate" placeholder="">
                                 </div>
                                 
                              </div>
                               
                               
                               <div class="form-group form-group-cheque" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Cheque Bank Name <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-group-cheque-input" id="chequeBankName"  name="chequeBankName" placeholder="">
                                 </div>
                              </div><div class="form-group form-group-cheque" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Cheque Bank Branch Name/IFSC Code <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-group-cheque-input" id="chequeBranchName"  name="chequeBranchName" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group form-group-dd" style="display: none">
                                 <label for="" class="col-sm-3 control-label">DD/EFT Bank Name <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-group-dd-input" id="ddBankName" name="ddBankName" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group form-group-dd" style="display: none">
                                 <label for="" class="col-sm-3 control-label">DD/EFT Bank Branch Name/IFSC code <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-group-dd-input" id="ddBranchName" name="ddBranchName" placeholder="">
                                 </div>
                              </div>
                              
                           
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Tally Reference Number <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="tallyrefno" name="tallyrefno"placeholder="" required="required">
                                 </div>
                              </div>
                             <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Narration</label> 
	                                 <div class="col-sm-7"> 
	                                    <textarea  class="form-control"  rows="3" id="narration" name="narration" placeholder=""></textarea>
	                                 </div>
	                          </div>
	                      
	                        
	                            </div>
                              <input type="hidden" id="itemDetailsInPR" name="itemDetailsInPR">
             		</form>
             		<br>
	                              	<div class="row">
	                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
	                                 <div class="col-sm-offset-3">
	                                   
	                                    <button style="float:right"  type="button" id="generatereceipt" class="btn btn-success btn-custom waves-effect waves-light">Generate</button>
	                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
	                                    <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload();">Cancel</button>
	                                 </div>
	                              </div>
                             
                           
                           </div>
                           </div>
                           
                           
                          
                        </div>
                     </div>
                  </div>
                  <div class="modal fade" id="generatereceiptconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure you want to generate receipt ?</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="generatereceiptconfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
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
                                 <h2 class="panel-title">Edit Section</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="updatesectionform" action="${pageContext.request.contextPath}/section/update" method="post">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Section Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editSectionName" class="form-control" id="editSectionName" placeholder="" required maxlength="40">
                                 </div>
                              </div>
                              <input type="hidden" id="updateSectionId" name="updateSectionId">
                              <security:authorize access="hasRole('section/update')">
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3"> 
                                    <a href="#" id="updatesection" style="float:right" class="btn btn-success btn-custom waves-effect waves-light" type="button" data-id="">
                                    Update
                                    </a>   
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                    <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                 </div>
                              </div>
                              </security:authorize>
                              
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
          
      <script src="${pageContext.request.contextPath}/resources/themes/script/purchasereceipt.js" type="text/javascript"></script>
    
   </body>
</html>

