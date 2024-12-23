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
            
      
      
      </style>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/edumaatalert/edumaatalert.css"/>
 </head>        <body class="fixed-left">
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
				                <button style="float:right;display:none;" type="button"  id="backButton" onclick="window.location.reload();" class="btn btn-info btn-custom waves-effect waves-light">Back</button>
	<br>
		               <div id="ListDiv" style="display:block;">
		               
		               <div id="reportForm">

		
		
	 <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-info">
                              <div class="panel-heading">
                               <h2 class="panel-title">
					Student Wise Refund Report
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 
						<div class="panel-body">
		 
		  <form class="form-horizontal" id="studentReportForm">
		  	<div class="row">
		  	  <div class="col-sm-9">
		  	  
		  	   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Criteria<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="criteria" id="criteria" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                            <option value="" disabled selected>Select Criteria</option>
                                            <option value="academicYear" >Academic Year</option>
                                            <option value="dateRange" >Date Range</option>
                                   </select>
                                 </div>
                              </div>
		  	  
		  	  		 <div class="form-group" id="academicYearFormGroup" style="display: none">
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
                               <div id="dateRange"  style="display: none">
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
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Report Type<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="reportType" id="reportType" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                            <option value="" disabled selected>Select Report Type</option>
                                            <option value="refund" >Refund Students</option>
                                   </select>
                                 </div>
                              </div>
                             <div class="form-group" id="feesCategoryListDiv">
                                 <label for="" class="col-sm-3 control-label">Fees Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="feesCategoryList" id="feesCategoryList"  class="selectpicker" data-style="btn-white"  data-live-search="true" multiple required="required">
                                            <c:if test="${!empty feesCategories}">
	                                          <c:forEach items="${feesCategories}" var="feesCategory">
	                                      			 <option value="${feesCategory.getFeesTermId()}">${feesCategory.getFeesTermName()}</option>
	                                           </c:forEach>
                                           </c:if>
                                   </select>
                                 </div>
                              </div>
                              
                               <div class="form-group" id="feesItemListDiv" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Fees Item<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="feesItemList" id="feesItemList" multiple class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                           <c:if test="${!empty feesItems}">
	                                          <c:forEach items="${feesItems}" var="feesItem">
	                                      			 <option value="${feesItem.getFeesItemId()}">${feesItem.getFeesItemName()}</option>
	                                           </c:forEach>
                                           </c:if>
                                   </select>
                                 </div>
                              </div>
                                <div class="form-group">
                                <div class="row">
                               
                                    <button style="float:right" type="button"  id="getStudentReport" class="btn btn-success btn-custom waves-effect waves-light">Get Report</button>
                                
                                         </div>                           
                              </div>
		  	     </div>
		  	     <div class="col-sm-3">
				  	  <div class="radio radio-info">
		  					<input type="radio" name="option" value="byFeesCategory" checked="checked"><label>By Fees Category</label>
					   </div>
					   <div class="radio radio-info">
		  					<input type="radio" name="option" value="byFeesItem"><label>Fees Item</label>
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
	    </div>
        <br/>
                  <div id="pendingFeesByFeesCategory" style="display:none;">     
                	 <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                               <h2 class="panel-title">
				List Of Students With Amount Refund
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 
						<div class="panel-body">
                             <table class="table table-bordered" id="pendingFeesByFeesCategoryTable">
                              <thead>
                                 <tr>
                                    <th>Student Name</th>
                                    <th>Admission No</th>
                                    <th>Current Class/section</th>
                                    <th>Fees Category</th>
                                    <th>Refund Amount</th>
                                </tr>
                              </thead>
                               <!-- <tfoot>
            <tr>
                <th colspan="4" style="text-align:right">Totals</th>
                <th></th>
                
            </tr>
        </tfoot> --> <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="feescategorypendinggrandtotal" style="text-align:center;border: none;"></th>
                      </tr>
               <tr style=" background-color:silver;">
            <th style="border: none;"> </th>
              <th style="border: none;"> </th>
                <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="feescategorypendingpagetotal" style="text-align:center;border: none;"></th>
                   </tr>
         
            </tfoot>
                           </table>
                        </div>
                        </div>
                   </div></div>
                   </div>
                   </div>
                   </div>
                   
                  </div>
                  
                    <div id="paidFeesByFeesCategory" style="display:none;">     
                   
                      	 <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                             <h2 class="panel-title">
				   List Of Students With No Outstanding
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 
						<div class="panel-body">
                             <table class="table table-bordered" id="paidFeesByFeesCategoryTable">
                              <thead>
                                 <tr>
                                    <th>Student Name</th>
                                    <th>Admission No</th>
                                    <th>Current Class/section</th>
                                    <th>Fees Category</th>
                                      <th>Paid Amount</th>
                                </tr>
                              </thead>
                              <!--  <tfoot>
            <tr>
                <th colspan="4" style="text-align:right">Totals</th>
                <th></th>
               
            </tr>
        </tfoot> -->
                <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="feescategorypaidgrandtotal" style="text-align:center;border: none;"></th>
                      </tr>
               <tr style=" background-color:silver;">
            <th style="border: none;"> </th>
              <th style="border: none;"> </th>
                <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="feescategorypaidpagetotal" style="text-align:center;border: none;"></th>
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
                  
                  <div id="pendingFeesByFeesItem" style="display:none;">     
                      
                     	 <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                <h2 class="panel-title">
				List Of Students With Amount Refund
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 
						<div class="panel-body">
                             <table class="table table-bordered" id="pendingFeesByFeesItemTable">
                              <thead>
                                 <tr>
                                    <th>Student Name</th>
                                    <th>Admission No</th>
                                    <th>Current Class/section</th>
                                    <th>Fees Category</th>
                                    <th>Fees Item</th>
                                    <th>Refund Amount</th>
                                </tr>
                              </thead>
                       <!--        <tfoot>
                              <tr>
                <th colspan="5" style="text-align:right">Totals</th>
                <th></th>
               
            </tr>
        </tfoot> -->
          <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="feesitempendinggrandtotal" style="text-align:center;border: none;"></th>
                      </tr>
               <tr style=" background-color:silver;">
            <th style="border: none;"> </th>
              <th style="border: none;"> </th>
                <th style="border: none;"> </th>
                  <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="feesitempendingpagetotal" style="text-align:center;border: none;"></th>
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
                  
                    <div id="paidFeesByFeesItem" style="display:none;">     
                     
                	 <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                             <h2 class="panel-title">
				  List Of Students With No Outstanding
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 
						<div class="panel-body">
                             <table class="table table-bordered" id="paidFeesByFeesItemTable">
                              <thead>
                                 <tr>
                                    <th>Student Name</th>
                                    <th>Admission No</th>
                                    <th>Current Class/section</th>
                                    <th>Fees Category</th>
                                    <th>Fees Item</th>
                                    <th>Amount</th>
                                </tr>
                              </thead>
                             <!--  <tfoot>
                              <tr>
                <th colspan="5" style="text-align:right">Totals</th>
                <th></th>
               
            </tr>
        </tfoot> --> 
        <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                 <th style="border: none;"> </th>
                   <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="feesitempaidgrandtotal" style="text-align:center;border: none;"></th>
                      </tr>
               <tr style=" background-color:silver;">
            <th style="border: none;"> </th>
              <th style="border: none;"> </th>
                <th style="border: none;"> </th>
                  <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="feesitempaidpagetotal" style="text-align:center;border: none;"></th>
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
	     <script type="text/javascript">
  
    TableManageButtons.init();

</script>
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
      
		
	<script src="${pageContext.request.contextPath}/resources/themes/script/studentwisefeesrefundreport.js"></script>
   
       	
</body>
</html>