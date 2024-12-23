<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
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
              
		<c:if test="${!empty currencycode}">
		<input id="currecyCodeData" type="hidden" value="${currencycode}">
        </c:if>
		   <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                <h2 class="panel-title ">
						RECONCILLATION
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						
						<div class="panel-body">
		   <form class="form-horizontal" id="reconcillationCriteriaForm">
                          <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Payment Mode<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="paymentModeId" id="paymentModeId" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                  	<c:if test="${!empty paymentModes}">
                                  		 <option value="" disabled selected>Select PaymentMode</option>
                                      		<c:forEach items="${paymentModes}" var="paymentMode">
                                      		 	<option value="${paymentMode.getPaymentModeId()}">${paymentMode.getPaymentModeTitle()}</option>
                                      		 </c:forEach>
                                          </c:if>
                                    </select>
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Payment Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="paymentStatusId" id="paymentStatusId" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                  		 <option value="" disabled selected>Select Payment Status</option>
                                    </select>
                                 </div>
                              </div>
                              
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="submit" id="getReceiptsRecords"  class="btn btn-success btn-custom waves-effect waves-light">Get Receipt Records</button>
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
               	        <div id="receiptdetailsdiv" style="display:none;">  
               	          <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                              <h4 class="panel-title">
						Receipts
		           </h4>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						  
						<div class="panel-body">
                     <div class="tables" id="cashReconPendingTable" style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="cashReconPending">
                              <thead>
                                 <tr>
                                 	<th><div class="checkbox checkbox-primary"> <input name="select_all" value="1" id="example-select-all-cash-recon" type="checkbox"/> <label for="example-select-all-cash-recon"></label></div>
                                    <th>Transaction No</th>
                                 	<th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>Received Date</th>
                                 	<th>Received By</th>
                                 	<th>Fees Amount</th>
                                 	<th>Fine</th>
                                 	<th>Total</th>
                                </tr>
                              </thead>
                            <!--   <tfoot>
            <tr>
                <th colspan="6" style="text-align:right">Totals</th>
                <th ></th>
                <th></th>
                 <th></th>
                 
            </tr>
          
        </tfoot> -->     <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)</th>
                  <th id="cashpendinggrandfeestotal" style="text-align:center;border: none;"></th>
                   <th id="cashpendinggrandfineamount" style="text-align:center;border: none;"></th> 
                  <th id="cashpendinggrandtotal" style="text-align:center;border: none;"></th> 
                    </tr>
               <tr style=" background-color:silver;">
            <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="cashpendingpagefeestotal" style="text-align:center;border: none;"></th>
                   <th id="cashpendingpagefineamount" style="text-align:center;border: none;"></th> 
                  <th id="cashpendingpagetotal" style="text-align:center;border: none;"></th> 
                   </tr>
         
            </tfoot>
                           </table>
                          
                          
                        </div>
                        
                        <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="submit" id="cashReconReceiptId"  class="btn btn-info btn-custom waves-effect waves-light" data-toggle="modal">Select and Update Status</button>
                                  </div>
                              </div>
                        </div>
                        <div class="tables" id="cashReconClearedTable" style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="cashReconCleared">
                              <thead>
                                 <tr>
                                    <th>Transaction No</th>
                                 	<th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>Cash Cleared Date</th>
                                 	<th>Cleared By</th>
                                 	<th>Fees Amount</th>
                                 	<th>Fine</th>
                                 	<th>Total</th>
                                 </tr>
                              </thead>
                          <!--      <tfoot>
            <tr>
                <th colspan="5" style="text-align:right">Totals</th>
                 <th></th>
                 <th></th>
                 <th></th>
                 
            </tr>
          
        </tfoot> -->
         <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>) </th>
                  <th id="cashclearedgrandfeestotal" style="text-align:center;border: none;"></th>
                   <th id="cashclearedgrandfineamount" style="text-align:center;border: none;"></th> 
                  <th id="cashclearedgrandtotal" style="text-align:center;border: none;"></th> 
                    </tr>
               <tr style=" background-color:silver;">
            <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                     <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="cashclearedpagefeestotal" style="text-align:center;border: none;"></th>
                   <th id="cashclearedpagefineamount" style="text-align:center;border: none;"></th> 
                  <th id="cashclearedpagetotal" style="text-align:center;border: none;"></th> 
                   </tr>
         
            </tfoot>
                           </table>
                        </div>
                        </div>
                        
                         <div class="tables" id="chequeReconPendingTable" style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="chequeReconPending">
                              <thead>
                                 <tr>
                                    <th><div class="checkbox checkbox-primary"> <input name="select_all" value="1" id="example-select-all-cheque-recon" type="checkbox"/> <label for="example-select-all-cheque-recon"></label></div></th>
                                    <th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>Cheque No</th>
                                 	<th>Received Date</th>
                                 	<th>Bank Name</th>
                                 	<th>Branch Name/IFSC Code</th>
                                 	<th>Received By</th>
                                    <th>Fees Amount</th>
                                 	<th>Fine</th>
                                 	<th>Total</th>
                                 	
                                </tr>
                              </thead>
                            <!--    <tfoot>
            <tr>
                <th colspan="8" style="text-align:right">Totals</th>
                <th ></th>
                <th></th>
                 <th></th>
                
            </tr>
          
        </tfoot> -->
         <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                      <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="chequependinggrandfeestotal" style="text-align:center;border: none;"></th>
                   <th id="chequependinggrandfineamount" style="text-align:center;border: none;"></th> 
                  <th id="chequependinggrandtotal" style="text-align:center;border: none;"></th> 
                    </tr>
               <tr style=" background-color:silver;">
            <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                      <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="chequependingpagefeestotal" style="text-align:center;border: none;"></th>
                   <th id="chequependingpagefineamount" style="text-align:center;border: none;"></th> 
                  <th id="chequependingpagetotal" style="text-align:center;border: none;"></th> 
                   </tr>
         
            </tfoot>
                           </table>
                        </div>
                          <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="submit" id="chequeReconReceipt"  class="btn btn-info btn-custom waves-effect waves-light" data-toggle="modal">Select and Update Status</button>
                                  </div>
                              </div>
                        </div>
                        
                         <div class="tables" id="chequeReconClearedTable" style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="chequeReconCleared">
                              <thead>
                                 <tr>
                                    <th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>Cheque No</th>
                                 	<th>Cheque Cleared Date</th>
                                 	<th>Bank Name</th>
                                 	<th>Branch Name/IFSC Code</th>
                                 	<th>Cleared By</th>
                                 		<th>Fees Amount</th>
                                 	<th>Fine</th>
                                 	<th>Total</th>
                                </tr>
                              </thead>
                               <!--  <tfoot>
            <tr>
                <th colspan="7" style="text-align:right">Totals</th>
                <th ></th>
                <th></th>
                 <th></th>
            </tr></tfoot> -->
            <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                      <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="chequeclearedgrandfeestotal" style="text-align:center;border: none;"></th>
                   <th id="chequeclearedgrandfineamount" style="text-align:center;border: none;"></th> 
                  <th id="chequeclearedgrandtotal" style="text-align:center;border: none;"></th> 
                    </tr>
               <tr style=" background-color:silver;">
            <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                      <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="chequeclearedpagefeestotal" style="text-align:center;border: none;"></th>
                   <th id="chequeclearedpagefineamount" style="text-align:center;border: none;"></th> 
                  <th id="chequeclearedpagetotal" style="text-align:center;border: none;"></th> 
                   </tr>
         
            </tfoot>
                           </table>
                        </div>
                        </div>
                        
                        <div class="tables" id="chequeReconBouncedTable" style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="chequeReconBounced">
                              <thead>
                                 <tr>
                                    <th>Student Name</th>
                                 	<th>Admission No</th>
                                 		<th>Cheque No</th>
                                 	<th>Bank Name</th>
                                 	<th>Branch Name/IFSC Code</th>
                                 	<th>Cleared By</th>
                                 	<th>Fees Amount</th>
                                 	<th>Fine</th>
                                 	<th>Total</th>
                                </tr>
                              </thead>
                          <!--      <tfoot>
            <tr>
                <th colspan="6" style="text-align:right">Totals</th>
                <th ></th>
                <th></th>
                 <th></th>
                
            </tr></tfoot> -->  <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="chequebouncedgrandfeestotal" style="text-align:center;border: none;"></th>
                   <th id="chequebouncedgrandfineamount" style="text-align:center;border: none;"></th> 
                  <th id="chequebouncedgrandtotal" style="text-align:center;border: none;"></th> 
                    </tr>
               <tr style=" background-color:silver;">
            <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="chequebouncedpagefeestotal" style="text-align:center;border: none;"></th>
                   <th id="chequebouncedpagefineamount" style="text-align:center;border: none;"></th> 
                  <th id="chequebouncedpagetotal" style="text-align:center;border: none;"></th> 
                   </tr>
         
            </tfoot>
                         
                           </table>
                        </div>
                        </div>
                        
                         <div class="tables" id="ddReconPendingTable"  style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="ddReconPending">
                              <thead>
                                 <tr>
                                 	<th><div class="checkbox checkbox-primary"> <input name="select_all" value="1" id="example-select-all-dd-recon" type="checkbox"/> <label for="example-select-all-dd-recon"></label></div></th>
                                      <th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>DD/EFT No</th>
                                 	<th>DD/EFT Received Date</th>
                                 	<th>Bank Name</th>
                                 	<th>Branch Name/IFSC Code</th>
                                 		<th>Received By</th>
                                 	<th>Fees Amount</th>
                                 	<th>Fine</th>
                                 	<th>Total</th>
                                 
                                </tr>
                              </thead>
                               <!-- <tfoot>
            <tr>
                <th colspan="8" style="text-align:right">Totals</th>
                <th ></th>
                <th></th>
                 <th></th>
                     </tr></tfoot> -->
                         
                          <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                      <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="ddpendinggrandfeestotal" style="text-align:center;border: none;"></th>
                   <th id="ddpendinggrandfineamount" style="text-align:center;border: none;"></th> 
                  <th id="ddpendinggrandtotal" style="text-align:center;border: none;"></th> 
                    </tr>
               <tr style=" background-color:silver;">
            <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                      <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="ddpendingpagefeestotal" style="text-align:center;border: none;"></th>
                   <th id="ddpendingpagefineamount" style="text-align:center;border: none;"></th> 
                  <th id="ddpendingpagetotal" style="text-align:center;border: none;"></th> 
                   </tr>
         
            </tfoot>
                           </table>
                        </div>
                         <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="submit" id="ddReconReceiptButton"  class="btn btn-info btn-custom waves-effect waves-light" data-toggle="modal">Select and Update Status</button>
                                  </div>
                              </div>
                        </div>
                        
                        <div class="tables" id="ddReconClearedTable"  style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="ddReconCleared">
                              <thead>
                                 <tr>
                                    <th>Receipt No</th>
                                  	<th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>DD/EFT No</th>
                                 	<th>DD/EFT Cleared Date</th>
                                 	<th>Bank Name</th>
                                 	<th>Branch Name/IFSC Code</th>
                                 	<th>Cleared By</th>
                                 	<th>Fees Amount</th>
                                 	<th>Fine</th>
                                 	<th>Total</th>
                                 	
                                </tr>
                              </thead>
                              <!--  <tfoot>
            <tr>
                <th colspan="8" style="text-align:right">Totals</th>
                <th ></th>
                <th></th>
                 <th></th>
               
            </tr></tfoot> -->
                           <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                      <th style="border: none;"> </th>
                       <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="ddclearedgrandfeestotal" style="text-align:center;border: none;"></th>
                   <th id="ddclearedgrandfineamount" style="text-align:center;border: none;"></th> 
                  <th id="ddclearedgrandtotal" style="text-align:center;border: none;"></th> 
                    </tr>
               <tr style=" background-color:silver;">
            <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                      <th style="border: none;"> </th>
                       <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="ddclearedpagefeestotal" style="text-align:center;border: none;"></th>
                   <th id="ddclearedpagefineamount" style="text-align:center;border: none;"></th> 
                  <th id="ddclearedpagetotal" style="text-align:center;border: none;"></th> 
                   </tr>
         
            </tfoot>
                        
                           </table>
                        </div>
                        </div>
                        
                         <div class="tables" id="ddReconBouncedTable"  style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="ddReconBounced">
                              <thead>
                                 <tr>
                                    <th>Receipt No</th>
                                  	<th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>DD/EFT No</th>
                                 	<th>Bank Name</th>
                                 	<th>Branch Name/IFSC Code</th>
                                 	<th>Cleared By</th>
                                 	<th>Fees Amount</th>
                                 	<th>Fine</th>
                                 	<th>Total</th>
                                 	
                                </tr>
                              </thead>
                            <!--    <tfoot>
            <tr>
                <th colspan="7" style="text-align:right">Totals</th>
                <th ></th>
                <th></th>
                 <th></th>
                 
            </tr></tfoot> -->
                          <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                      <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="ddbouncedgrandfeestotal" style="text-align:center;border: none;"></th>
                   <th id="ddbouncedgrandfineamount" style="text-align:center;border: none;"></th> 
                  <th id="ddbouncedgrandtotal" style="text-align:center;border: none;"></th> 
                    </tr>
               <tr style=" background-color:silver;">
            <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                     <th style="border: none;"> </th>
                      <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="ddbouncedpagefeestotal" style="text-align:center;border: none;"></th>
                   <th id="ddbouncedpagefineamount" style="text-align:center;border: none;"></th> 
                  <th id="ddbouncedpagetotal" style="text-align:center;border: none;"></th> 
                   </tr>
         
            </tfoot>
                           </table>
                        </div>
                        </div>
                        
                      <!--   <div class="tables" id="paymentGatewayReconPendingTable"  style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="paymentGatewayReconPending">
                              <thead>
                                 <tr>
                                    <th>Serial No</th>
                                    <th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>Amount</th>
                                  	<th>Gateway Name</th>
                                 	<th>Gateway Payment Mode</th>
                                 	<th>Transaction No</th>
                                 	<th>Payment Date</th>
                                 	<th>Action</th>
                               	</tr>
                              </thead>
                           </table>
                        </div>
                        </div>
                        
                        <div class="tables" id="paymentGatewayReconClearedTable"  style="display:none;">
                         <div class="table-responsive bs-example widget-shadow">
                             <table class="table table-bordered" id="paymentGatewayReconCleared">
                              <thead>
                                 <tr>
                                    <th>Serial No</th>
                                    <th>Student Name</th>
                                 	<th>Admission No</th>
                                 	<th>Amount</th>
                                  	<th>Gateway Name</th>
                                 	<th>Gateway Payment Mode</th>
                                 	<th>Transaction No</th>
                                 	<th>Payment Cleared Date</th>
                                </tr>
                              </thead>
                           </table>
                        </div>
                        </div> -->
                        
                 </div>
                 
                  </div>
                           </div>
                           </div>
                           </div>
                           </div>
                           </div>
                           </div>
                 
               <div class="modal fade" id="cash_recon_update_status" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" id="closeCashReconModal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Reconcillation:</h4>
                     </div>
                     <form class="form-horizontal" id="updateCashReconForm" action="${pageContext.request.contextPath}/receipt/cashRecon" method="post">
	                     <div class="modal-body">
		                     
		                     	<div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Payment Status<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-7"> 
	                                  <select name="cashReconPaymentStatusId" id="cashReconPaymentStatusId" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
	                                  		 <option value="" disabled selected>Select Payment Status</option>
	                                    </select>
	                                 </div>
	                          </div>
	                          
	                          <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Date<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-7"> 
	                                    <input type="text" required="required" class="form-control form-control-datepicker" id="cashReconClearanceDate" name="clearanceDate" placeholder="">
	                                 </div>
	                                 </div>
	                         <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Comments</label> 
	                                 <div class="col-sm-7"> 
	                                    <textarea  class="form-control" rows="3" id="cashReconComment" name="cashReconComment" placeholder=""></textarea>
	                                 </div>
	                          </div>
		                 </div>
	                     <div class="modal-footer">
	                     		<a href="#" id="updateCashRecon" style="float:right"  class="btn btn-success btn-custom waves-effect waves-light" type="button" data-id="" >
                                    Update
                                   </a> 
	                     </div>
                     </form>
                  </div>
               </div>
            </div>
            
            <!-- Cheque -->
            
            <div class="modal fade" id="cheque_recon_update_status" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" id="closeChequeReconModal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Reconcillation:</h4>
                     </div>
                     <form class="form-horizontal" id="updateChequeReconForm" action="${pageContext.request.contextPath}/receipt/chequeRecon" method="post">
	                     <div class="modal-body">
		                     
		                     	<div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Payment Status<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-7"> 
	                                  <select name="chequeReconPaymentStatusId" id="chequeReconPaymentStatusId" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
	                                  		 <option value="" disabled selected>Select Payment Status</option>
	                                    </select>
	                                 </div>
	                          </div>
	                          
	                          <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Date<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-7"> 
	                                    <input type="text" required="required" class="form-control form-control-datepicker" id="chequeReconClearanceDate" name="chequeReconClearanceDate" placeholder="">
	                                 </div>
	                                 </div>
	                         <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Comments</label> 
	                                 <div class="col-sm-7"> 
	                                    <textarea  class="form-control"  rows="3" id="chequeReconComment" name="chequeReconComment" placeholder=""></textarea>
	                                 </div>
	                          </div>
		                 </div>
	                     <div class="modal-footer">
	                     		<a href="#" id="updateChequeRecon" style="float:right"  class="btn btn-success btn-custom waves-effect waves-light" type="button" data-id="" >
                                    Update
                                   </a> 
	                     </div>
                     </form>
                  </div>
               </div>
            </div>
            
            
            <!-- DD -->
            
            <div class="modal fade" id="dd_recon_update_status" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" id="closeddReconModal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Reconcillation:</h4>
                     </div>
                     <form class="form-horizontal" id="updateDdReconForm" action="${pageContext.request.contextPath}/receipt/ddRecon" method="post">
	                     <div class="modal-body">
		                     
		                     	<div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Payment Status<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-7"> 
	                                  <select name="ddReconPaymentStatusId" id="ddReconPaymentStatusId" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
	                                  		 <option value="" disabled selected>Select Payment Status</option>
	                                    </select>
	                                 </div>
	                          </div>
	                          
	                          <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Date<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-7"> 
	                                    <input type="text" required="required" class="form-control form-control-datepicker" id="ddReconClearanceDate" name="ddReconClearanceDate" placeholder="">
	                                 </div>
	                                 </div>
	                         <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Comments</label> 
	                                 <div class="col-sm-7"> 
	                                    <textarea  class="form-control" rows="3" id="ddReconComment" name="ddReconComment" placeholder=""></textarea>
	                                 </div>
	                          </div>
		                 </div>
	                     <div class="modal-footer">
	                     		<a href="#" id="updateDdRecon" style="float:right"  class="btn btn-success btn-custom waves-effect waves-light" type="button" data-id="" >
                                    Update
                                   </a> 
	                     </div>
                     </form>
                  </div>
               </div>
            </div>
            
         </div>
		</div>
		
	</div>
		    <input type="hidden" class="form-control form-control-datepicker" id="test" name="test" placeholder="">

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
	    
	   <!--  <script>
			$('#studentReceiptListTable').editableTableWidget().numericInputExample().find('td:first').focus();
		</script>   -->
       <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/moment/moment.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/timepicker/bootstrap-timepicker.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/clockpicker/js/bootstrap-clockpicker.min.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/jquery.form-pickers.init.js"></script>
      
               <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-validation/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/themes/script/reconcillation.js"> </script>
     <script type="text/javascript">
  
    TableManageButtons.init();

</script>
</body>
</html>