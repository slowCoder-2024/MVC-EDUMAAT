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
               <script src="${pageContext.request.contextPath}/resources/themes/printpage/js/jquery.printPage.js"></script>
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
      <style>
  
      .loader {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url('${pageContext.request.contextPath}/resources/themes/images/page-loader.gif') 50% 50% no-repeat rgba(255, 255, 255, 0.71);
}
     caption {
    margin: 0; 
    font-weight: bold; 
    font-size: 1.3em; 
    background: #eee;
    padding: 10px;
    border: 1px solid #ddd; 
 }       
      
      
      </style>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/edumaatalert/edumaatalert.css"/>
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
        
		<div class="loader"  style="display: none"></div>
		               <div id="ListDiv" style="display:block;">
		                <button style="float:right;display: none" type="button"  id="backButton" onclick="window.location.reload();" class="btn btn-info btn-custom waves-effect waves-light">Back</button>
		              <br>
		              <br>
		               <div id="reportForm">
<div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                               <h2 class="panel-title">
					View and Print Invoice / Fee Collection Record (FCR)
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 
						<div class="panel-body">
		  <form class="form-horizontal" id="getDetailsForm">
		  	<div class="row">
		  	  <div class="col-sm-9">
		  	  
		  	  		 <div class="form-group" id="academicYearFormGroup">
                                 <label for="" class="col-sm-3 control-label">Academic Year<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="academicYearId" id="academicYearId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Academic Year</option>
                                        <c:if test="${!empty academicYears}">
                                         <c:forEach items="${academicYears}" var="academicYear">
                                      			 <option value="${academicYear.getAcademicYearId()}">${academicYear.getAcademicYearTitle()}</option>
                                           </c:forEach>
                                      	</c:if>
                                     </select>
                                 </div>
                              </div>
                              
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Invoice / FCR<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="invoiceandfcr" id="invoiceandfcr" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                            <option value="" disabled selected>Select Invoice/FCR</option>
                                            <option value="invoice">Invoice</option>
                                             <option value="fcr">Receipts</option>
                                            
                                          </select>
                                    
                                 </div>
                              </div>
                              
                               <div id="classWise" style="display: none">
                               		<div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Class<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="class" id="class" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                  <c:if test="${!empty classes}">
                                  		<option value="" disabled selected>Select Class</option>
                                  		<option value="all">All</option>
                                       <c:forEach items="${classes}" var="clazz">
                                       		<option value="${clazz.getClassId()}">${clazz.getClassName()}(${clazz.getInstitution().getInstitutionCode()})</option>
                                       </c:forEach>
                                   </c:if>
                                    </select>
                                 </div>
                               
                              </div>
                             
                              <div class="form-group" id="sectionDiv" style="display: none">
                                 <label for="" class="col-sm-3 control-label"> Section <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="section" id="section" class="selectpicker" multiple data-style="btn-white"  data-live-search="true" required="required">
                                            <option value="" disabled selected>Select Class</option>
                                   </select>
                                 </div>
                              </div>
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Criteria<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="criteria" id="criteria" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                            <option value="" disabled selected>Select Category</option>
                                            <option value="all">All</option>
                                            <option value="specialcategory">Special Category</option>
                                          </select>
                                    
                                 </div>
                              </div>
                              <div class="form-group form-group-special-category "style="display: none">
                                 <label for="" class="col-sm-3 control-label">Special Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="specialCategoryId" id="specialCategoryId" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                  	<c:if test="${!empty specialCategories}">
                                  		 <option value="" disabled selected>Select Special Category</option>
                                      		 <c:forEach items="${specialCategories}" var="specialCategory">
                                      			 <option value="${specialCategory.getSpecialCategoryId()}">${specialCategory.getSpecialCategoryName()}</option>
                                            </c:forEach>
                                      </c:if>
                                    </select>
                                    
                                 </div>
                              </div>
                               </div>
                              
                              <div id="admissionNoWise" style="display: block">
	                              <div class="form-group form-group-student-id" >
	                                 <label for="" class="col-sm-3 control-label">Admission No (Unique Student Id)<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-7"> 
	                                  <input type="text" id="admissionNo" name="admissionNo" class="form-control" required="required"/>
	                                 </div>
	                              </div>
                              </div>
                              
                              <div id="dateRange" style="display: none">
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">From Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" required="required" class="form-control form-control-datepicker" id="fromDate" name="fromDate" placeholder="" maxlength="10">
                                 </div>
                                 </div>
                                  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">To Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" required="required" class="form-control form-control-datepicker" id="toDate" name="toDate" placeholder="" maxlength="10">
                                 </div>
                                 </div>
                              </div>
                              
                              
                              
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button"  id="getdetailsfromselectedcriteria" class="btn btn-success btn-custom waves-effect waves-light">Get Details</button>
                                
                                                                     </div>
                              </div>
		  	     </div>
		  	     <div class="col-sm-3">
				  	  <div class="radio radio-info">
		  					<input type="radio" name="option" value="byadmissionno" checked="checked"><label>Admission No</label>
					   </div>
					   <div class="radio radio-info">
		  					<input type="radio" name="option" value="byclass"><label>Class</label>
						</div>
						<div class="radio radio-info">
		  					<input type="radio" name="option" value="byDateRange"><label>Period</label>
						</div>
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
               <div id="invoicedetailsdiv" style="display:none;">     
                    <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                            <h2 class="panel-title">
						Invoice Details
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 
						<div class="panel-body">
                          <h4 class="title1" id="visibilityForInvoiceDate" style="display: none" >From Date : <label for="defaultInvoiceFromDate"  id="defaultInvoiceFromDate"></label>  To Date : <label for="defaultInvoiceToDate" id="defaultInvoiceToDate"></label>    </h4>                                     
                   
                             <table class="table table-bordered" id="invoicedatatable">
                           <thead>
                             <tr>
                                 	<th>Invoice No</th>
                                 	<th>Academic Year</th>
                                 	<th>Fees Category</th>
                                    <th>Admission No</th>
                                    <th>Student Name</th>
                                    <th>Class/Section</th>
                                    <th>Invoice Date</th>
                                    <th>Fees Amount</th>
                                    
                                  	<th>Action</th>
                                 </tr>
                             </thead> 
                                 <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"></th> <th style="border: none;"></th> <th  style="border: none;"></th> <th style="border: none;"></th> <th  style="border: none;"></th> <th  style="border: none;"></th>
                <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>) </th>
                  <th id="invoicegrandtotal" style="text-align:center;border: none;"></th>
                  <th style="border: none;"></th>
                
            </tr>
               <tr style=" background-color:silver;">
             <th style="border: none;"></th> <th style="border: none;"></th> <th  style="border: none;"></th> <th style="border: none;"></th> <th  style="border: none;"></th> <th  style="border: none;"></th>
                <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="invoicepagetotal" style="text-align:center;border: none;"></th>
                  <th style="border: none;"></th>
                
            </tr>
         
            </tfoot>
                           
                           
                           </table>
                           </div>
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
                              <h2 class="panel-title">
					 Receipt Details
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 
						<div class="panel-body">
                           <h4 class="title1" id="visibilityForReceiptDate" style="display: none">From Date : <label for="defaultReceiptFromDate" id="defaultReceiptFromDate"></label> To Date : <label for="defaultReceiptToDate" id="defaultReceiptToDate"></label>    </h4>                                     
                  
                             <table class="table table-bordered" id="receiptdatatable">
                              <thead>
                                 <tr>
                                    <th>Receipt No</th>
                                    <th>Fees Category</th>
                                    <th>Admission No</th>
                                    <th>Student Name</th>
                                    <th>Class/section</th>
                                    <th>Payment Received Date</th>
                                    <th>Payment Mode</th>
                                    <th>Payment Status</th>
                                    <th>Discount Amount</th>
                               		<th>Fees Amount</th>
                               		<th>Fine Amount</th>
                               		<th>Action</th>
                               		
                                 </tr>
                              </thead>
                              <!--  <tfoot>
            <tr>
                <th colspan="8" style="text-align:right">Totals</th>
                  <th></th>
                  <th></th>
                   <th></th>
            </tr></tfoot> -->
            
                 <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"><th style="border: none;"></th><th style="border: none;"></th> <th  style="border: none;"></th> <th style="border: none;"></th> <th  style="border: none;"></th> <th  style="border: none;"></th>
                <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>) </th>
                   <th id="receiptgrandtotaldiscountamount" style="text-align:center;border: none;"></th>
                  <th id="receiptgrandtotalamount" style="text-align:center;border: none;"></th>
                    <th id="receiptgrandtotalfineamount" style="text-align:center;border: none;"></th>
                  <th style="border: none;"></th>
                
            </tr>
               <tr style=" background-color:silver;">
             <th style="border: none;"><th style="border: none;"></th><th style="border: none;"></th> <th  style="border: none;"></th> <th style="border: none;"></th> <th  style="border: none;"></th> <th  style="border: none;"></th>
                <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>) </th>
                  <th id="receiptpagetotaldiscountamount" style="text-align:center;border: none;"></th>
                  <th id="receiptpagetotalamount" style="text-align:center;border: none;"></th>
                   <th id="receiptpagetotalfineamount" style="text-align:center;border: none;"></th>
                  <th style="border: none;"></th>
                
            </tr>
         
            </tfoot>
                           </table>
                           </div>
                           </div>
                           </div>
                           </div>
                           </div>
                           
                        </div>
                        </div>
                   
                    
                     
						 
             
       
                             
        </div>
        </div>
                    
                              <div class="modal fade" id="invprint" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>You want to print this invoice.</h5>
                     </div>
                     <div class="modal-footer">
                     <a type="button" class="btn btn-primary " id="printinv" href="">Print</a>
                        
                     </div>
                 </div>
               </div>
            </div>
             <div class="modal fade" id="recprint" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>You want to print this receipt.</h5>
                     </div>
                     <div class="modal-footer">
                     <a type="button" class="btn btn-primary" id="printrec" href="">Print</a>
                        
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
       	
		<script src="${pageContext.request.contextPath}/resources/themes/script/invoiceandreceipt.js"></script>
   
 <script type="text/javascript">
  
    TableManageButtons.init();

</script>
</body>
</html>