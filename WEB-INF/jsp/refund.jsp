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
      
.pure-checkbox input[type="checkbox"],
.pure-radiobutton input[type="checkbox"],
.pure-checkbox input[type="radio"],
.pure-radiobutton input[type="radio"] {
  border: 0;
  clip: rect(0 0 0 0);
  height: 1px;
  margin: -1px;
  overflow: hidden;
  padding: 0;
  position: absolute;
  width: 1px;
}
.pure-checkbox input[type="checkbox"]:focus + label:before,
.pure-radiobutton input[type="checkbox"]:focus + label:before,
.pure-checkbox input[type="radio"]:focus + label:before,
.pure-radiobutton input[type="radio"]:focus + label:before,
.pure-checkbox input[type="checkbox"]:hover + label:before,
.pure-radiobutton input[type="checkbox"]:hover + label:before,
.pure-checkbox input[type="radio"]:hover + label:before,
.pure-radiobutton input[type="radio"]:hover + label:before {
  border-color: #4f8196;
  background-color: #f2f2f2;
}
.pure-checkbox input[type="checkbox"]:active + label:before,
.pure-radiobutton input[type="checkbox"]:active + label:before,
.pure-checkbox input[type="radio"]:active + label:before,
.pure-radiobutton input[type="radio"]:active + label:before {
  transition-duration: 0s;
}
.pure-checkbox input[type="checkbox"] + label,
.pure-radiobutton input[type="checkbox"] + label,
.pure-checkbox input[type="radio"] + label,
.pure-radiobutton input[type="radio"] + label {
  position: relative;
  padding-left: 2em;
  vertical-align: middle;
  user-select: none;
  cursor: pointer;
}
.pure-checkbox input[type="checkbox"] + label:before,
.pure-radiobutton input[type="checkbox"] + label:before,
.pure-checkbox input[type="radio"] + label:before,
.pure-radiobutton input[type="radio"] + label:before {
  box-sizing: content-box;
  content: '';
  color: #4f8196;
  position: absolute;
  top: 50%;
  left: 0;
  width: 14px;
  height: 14px;
  margin-top: -9px;
  border: 2px solid #4f8196;
  text-align: center;
  transition: all 0.4s ease;
}
.pure-checkbox input[type="checkbox"] + label:after,
.pure-radiobutton input[type="checkbox"] + label:after,
.pure-checkbox input[type="radio"] + label:after,
.pure-radiobutton input[type="radio"] + label:after {
  box-sizing: content-box;
  content: '';
  background-color: #4f8196;
  position: absolute;
  top: 50%;
  left: 4px;
  width: 10px;
  height: 10px;
  margin-top: -5px;
  transform: scale(0);
  transform-origin: 50%;
  transition: transform 200ms ease-out;
}
.pure-checkbox input[type="checkbox"]:disabled + label:before,
.pure-radiobutton input[type="checkbox"]:disabled + label:before,
.pure-checkbox input[type="radio"]:disabled + label:before,
.pure-radiobutton input[type="radio"]:disabled + label:before {
  border-color: #cccccc;
}
.pure-checkbox input[type="checkbox"]:disabled:focus + label:before,
.pure-radiobutton input[type="checkbox"]:disabled:focus + label:before,
.pure-checkbox input[type="radio"]:disabled:focus + label:before,
.pure-radiobutton input[type="radio"]:disabled:focus + label:before,
.pure-checkbox input[type="checkbox"]:disabled:hover + label:before,
.pure-radiobutton input[type="checkbox"]:disabled:hover + label:before,
.pure-checkbox input[type="radio"]:disabled:hover + label:before,
.pure-radiobutton input[type="radio"]:disabled:hover + label:before {
  background-color: inherit;
}
.pure-checkbox input[type="checkbox"]:disabled:checked + label:before,
.pure-radiobutton input[type="checkbox"]:disabled:checked + label:before,
.pure-checkbox input[type="radio"]:disabled:checked + label:before,
.pure-radiobutton input[type="radio"]:disabled:checked + label:before {
  background-color: #cccccc;
}
.pure-checkbox input[type="checkbox"] + label:after,
.pure-radiobutton input[type="checkbox"] + label:after {
  background-color: transparent;
  top: 50%;
  left: 4px;
  width: 8px;
  height: 3px;
  margin-top: -4px;
  border-style: solid;
  border-color: #ffffff;
  border-width: 0 0 3px 3px;
  border-image: none;
  transform: rotate(-45deg) scale(0);
}
.pure-checkbox input[type="checkbox"]:checked + label:after,
.pure-radiobutton input[type="checkbox"]:checked + label:after {
  content: '';
  transform: rotate(-45deg) scale(1);
  transition: transform 200ms ease-out;
}
.pure-checkbox input[type="radio"]:checked + label:before,
.pure-radiobutton input[type="radio"]:checked + label:before {
  animation: borderscale 300ms ease-in;
  background-color: white;
}
.pure-checkbox input[type="radio"]:checked + label:after,
.pure-radiobutton input[type="radio"]:checked + label:after {
  transform: scale(1);
}
.pure-checkbox input[type="radio"] + label:before,
.pure-radiobutton input[type="radio"] + label:before,
.pure-checkbox input[type="radio"] + label:after,
.pure-radiobutton input[type="radio"] + label:after {
  border-radius: 50%;
}
.pure-checkbox input[type="checkbox"]:checked + label:before,
.pure-radiobutton input[type="checkbox"]:checked + label:before {
  animation: borderscale 200ms ease-in;
  background: #4f8196;
}
.pure-checkbox input[type="checkbox"]:checked + label:after,
.pure-radiobutton input[type="checkbox"]:checked + label:after {
  transform: rotate(-45deg) scale(1);
}
@keyframes borderscale {
  50% {
    box-shadow: 0 0 0 2px #4f8196;
  }
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
      <c:if test="${!empty receiptId}">
      <script type="text/javascript">
          $(document).ready(function(){
        	  var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
        	  var receiptId=${receiptId}
        		 $('#invprint').modal('show');
        		 
 			        	$('#printinv,#printpreview').attr("href",ctx+"/receipt/refund/printPage?receiptId="+receiptId);
 			        
 			        	
 			        		 $("#printinv").printPage();
 			        		$("#printinv").click(function() {
 			         			$('#invprint').modal('hide');
 			   				
 			   			});
 			        		 
 			        			
 			        	
  		}); 
          </script>
      </c:if>
      
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
		 <div class="loader"  style="display: none"></div>
		
			<c:if test="${!empty currencycode}">
		<input id="currecyCodeData" type="hidden" value="${currencycode}">
        </c:if>
          <div id="FormDiv" style="display:block;">
                <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-custom">
                              <div class="panel-heading">
                               <h2 class="panel-title">
						 REFUND
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 
						<div class="panel-body">
                       <form class="form-horizontal" id="getDetailsForm">
                                  <div class="form-group form-group-groupcriteria" style="display: block">
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Class<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="class" id="class" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                  <option value="" disabled selected>Select Class</option>
                                  
                                  <c:if test="${!empty classes}">
                                  		<c:forEach items="${classes}" var="clazz">
                                       		<option value="${clazz.getClassId()}">${clazz.getClassName()}(${clazz.getInstitution().getInstitutionCode()})</option>
                                       </c:forEach>
                                   </c:if>
                                    </select>
                                 </div>
                               
                              </div>
                             
                              <div class="form-group form-group-section" style="display: none">
                                 <label for="" class="col-sm-3 control-label"> Section <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="section" id="section" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                            <option value="" disabled selected>Select Class First</option>
                                   </select>
                                 </div>
                              </div>
                              
                              <div class="form-group form-group-student" style="display: none">
                                 <label for="" class="col-sm-3 control-label"> Student<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="students" id="students" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                            <option value="" disabled selected>Select Class and Section First</option>
                                   </select>
                                 </div>
                              </div>
                              
                              </div>
                                <div class="form-group form-group-studentid" id="admissionNoBlock" style="display:block">
                                 <label for="" class="col-sm-3 control-label">Admission No (Unique Student Id)<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <input type="text" id="admissionNo" name="admissionNo" class="form-control" required="required"/>
                                 </div>
                              </div>
                                <div class="row">
                                   <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                             
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button"  id="getdetails" class="btn btn-success btn-custom waves-effect waves-light">Get Fees Details</button>
                                
                                              <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this);">Cancel</button>
	                                                       </div>
                              </div>
            
               </form>
               </div>
               </div>
               </div>
               </div>
               
           </div>
                </div> </div>
                               </div>
                              
    <div id="invoicedetailsdiv" style="display:none;">   
     <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-warning">
                              <div class="panel-heading">
                                <h2 class="panel-title">
						Student Details
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 
						<div class="panel-body">
                             <table class="table table-bordered">
                             <thead>
                             <tr><th colspan="4" class="panel-title m-t-0 header-title" style="color:purple;">Student Details</th></tr>
                             </thead>
							 <tbody>
                             	<tr>
                             		<th>Student Name</th>
                             		<td id="displayStudentName"></td>
                             		<th>Admission No</th>
                             		<td id="displayAdmissionNo"></td>
                             	</tr>
                             	<tr>
                             		<th>Class</th>
                             		<td id="displayClassName"></td>
                             		<th>Section</th>
                             		<td id="displaySectionName"></td>
                             	</tr>
                             	<tr>
                             		<th>Gender</th>
                             		<td id="displayGender"></td>
                             		<th>D.O.B</th>
                             		<td id="displayDOB"></td>
                             	</tr>
                             </tbody>
                            </table>
                            
                              <br>
                 <div class="row">
                               <div class="col-sm-offset-3">
                                  <button style="float:right" type="button" onclick="location.reload();" class="btn btn-success btn-custom waves-effect waves-light">Cancel</button>						      </div>
                          </div>
                </div>
                </div>
                </div>
                </div>
                </div>
                </div>
                </div>
                
                        <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-primary">
                              <div class="panel-heading">
                               <h2 class="panel-title">
						 Fees Details
		           </h2>
                                </div>
						<div class="panel-body">
                            <table class="table table-bordered" id="studentReceiptListTable">
                              <thead>
                                 <tr>
                                    <th>Academic Year</th>
                                    <th>Fees Category</th>
                                  <!-- 	<th>Invoiced Amount</th>
                                  	<th>Pending Amount</th>
                                  	<th>Paid Amount</th> -->
                                  <th>Details</th>
                                  <%--  <security:authorize access="hasRole('institution')"> --%>
                                   <th>Refund Type</th>
                                  <%--  </security:authorize> --%>
                                 <th>Refund</th>
                               	</tr>
                              </thead>
         <%--              <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
                  <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="invoicesamountgrandtotal" style="text-align:center;border: none;"></th>
                   <th id="invoicespendingamountgrandtotal" style="text-align:center;border: none;"></th> 
                     <th id="invoicespaidamountgrandtotal" style="text-align:center;border: none;"></th> 
                   <th style="border: none;"> </th>
                    <th style="border: none;"> </th>
              <th style="border: none;"> </th>
                  </tr>
               <tr style=" background-color:silver;">
              <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="invoicesamountpagetotal" style="text-align:center;border: none;"></th>
                   <th id="invoicespendingamountpagetotal" style="text-align:center;border: none;"></th> 
                    <th id="invoicespaidamountpagetotal" style="text-align:center;border: none;"></th>
                   <th style="border: none;"> </th>
                    <th style="border: none;"> </th>
              <th style="border: none;"> </th>
               </tr>
         
            </tfoot> --%>
                           </table>
                           </div>
                           </div>
                           </div>
                           </div>
                       
                  </div>
                 
                 
                 
                 
                 
             <div id="feesItemFormDiv" style="display:none;">
                           <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                               <h2 class="panel-title">
						Fees Item Details
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 
						<div class="panel-body">
                             		<table class="table table-bordered" id="studentInvoiceFeesItems">
			                              <thead>
			                                 <tr>
			                                    <th>Serial No</th>
			                                  	<th>Fees Item Name</th>
			                                 	<th>Fees Amount</th>
			                                 	<th>Paid Amount</th>
			                                </tr>
			                              </thead>
			                               <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
                  <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="feesitemgrandtotal" style="text-align:center;border: none;"></th>
                   <th id="feesitempaidgrandtotal" style="text-align:center;border: none;"></th>
                  </tr>
               <tr style=" background-color:silver;">
              <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="feesitempagetotal" style="text-align:center;border: none;"></th>
                   <th id="feesitempaidpagetotal" style="text-align:center;border: none;"></th>
                   
               </tr>
         
            </tfoot>
                           			</table>
                           			<br>
                           			  <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" onclick="showStudentFeesDiv();"  class="btn btn-success btn-custom waves-effect waves-light">Back</button>
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
             
             
             
             
             
             	<div id="confirmedInvoiceFormDiv" style="display:none;">
                             <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-danger">
                              <div class="panel-heading">
                              <h2 class="panel-title " >Detailed Fees</h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 <!--  <h4 class="panel-title">
						Fees Details
		           </h4> -->
						<div class="panel-body">
                     					<form class="form-horizontal" id="paymentDetailsForm" >
                     					
                    			
                    			
                      	<br>
                      	<h5 class="m-t-0 header-title" style="color:purple;font-size: 20px;">Please Select Fees Item(s) Before Proceeding To Refund</h5>
                            							
                      							<div class="tables">
							                         <div class="table-responsive bs-example ">
							                             <table class="table table-bordered" id="finalPaymentDetailTable">
							                              <thead>
							                                 <tr>
							                                 <th></th>
							                                    <th><div class="checkbox checkbox-primary"> <input name="select_all" value="1" id="example-select-all" type="checkbox"/> <label for="example-select-all"></label></div>
                                   								</th>
                                   					  <th>Fees Item</th>
							                                  	<th>Amount</th>
							                                 	<th>Flat Discount Amount</th>
							                                 	<th>Refund Amount</th>
							                                </tr>
							                              </thead>
							                           </table>
							                        </div>
							                        <div id="hiddenPaidInvoices">
							                        </div>
							                     </div>
                            					<br>  
                            					
                            					<input type="hidden" id="currentstudentinvoiceid" name="currentstudentinvoiceid">
                            					 <div class="row">
                            	
	                                 <div class="col-sm-offset-3">
	                               		 <!--  <a href="#" id="discountType" style="float:right"  class="btn btn-success" type="button" data-id="" data-toggle="modal">
	                                   		Apply Discount
	                                   	 </a> -->
	                                   	 <button style="float:right" type="button" id="proceed"  class="btn btn-info btn-custom waves-effect waves-light">Proceed</button>
	                               		<%-- <security:authorize access="hasAnyRole('fees/discount')">
	                                   	 <button style="float:right" type="button" id="discountType"  class="btn btn-success btn-custom waves-effect waves-light">Apply Discount</button>
	                               		 <button style="float: right;display: none" id="cancelDiscount" type="button" class="btn btn-success btn-custom waves-effect waves-light">Cancel Discount</button>
	                               		</security:authorize> --%>
	                               		
	                               		<button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this);">Cancel</button>
	                                
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
             
             	<div id="paymentDetailsPanel"  style="display:none;" >
             	<div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-success">
                              <div class="panel-heading">
                                  <h2 class="panel-title">Payment Mode Details</h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						<!--   <h4 class="panel-title">
						Student Fees Details
		           </h4> -->
						<div class="panel-body">
             				<form class="form-horizontal" id="paymentDetailsPanelForm" action="${pageContext.request.contextPath}/receipt/refund/payment" method="post">
             					  <div class="form-three widget-shadow">
                
             
                  <br>
             					 <div class="form-group">
                                	 <label for="" class="col-sm-3 control-label">Total Amount</label> 
                                 	<div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="amount" name="amount" placeholder="" readonly="readonly">
                                 </div>
                                </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Payment Mode<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                 <select name="paymentMode" id="paymentMode" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                 	<c:if test="${!empty paymentModes}">
                                 		<option value="" disabled selected>Select Mode</option>
                                       	<c:forEach items="${paymentModes}" var="paymentmode">
                                       	<c:if test="${paymentmode.getPaymentModeId()==1}">
                                       		<option value="${paymentmode.getPaymentModeId()}" selected>${paymentmode.getPaymentModeTitle()}</option>
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
                                 <label for="" class="col-sm-3 control-label">Cheque No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-group-cheque-input" id="chequeNo" name="chequeNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group form-group-cheque" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Cheque Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-control-datepicker form-group-cheque-input" id="" name="chequeDate" placeholder="" >
                                 </div>
                                 
                              </div>
                               
                                 <div class="form-group form-group-dd" style="display: none">
                                 <label for="" class="col-sm-3 control-label">DD/EFT No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-group-dd-input" id="ddNo" name="ddNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group form-group-dd" style="display: none">
                                 <label for="" class="col-sm-3 control-label">DD/EFT Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-control-datepicker form-group-dd-input" id="ddDate" name="ddDate" placeholder="">
                                 </div>
                                 
                              </div>
                               
                               
                               <div class="form-group form-group-cheque" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Cheque Bank Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-group-cheque-input" id="chequeBankName"  name="chequeBankName" placeholder="">
                                 </div>
                              </div><div class="form-group form-group-cheque" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Cheque Bank Branch Name/IFSC Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-group-cheque-input" id="chequeBranchName"  name="chequeBranchName" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group form-group-dd" style="display: none">
                                 <label for="" class="col-sm-3 control-label">DD/EFT Bank Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-group-dd-input" id="ddBankName" name="ddBankName" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group form-group-dd" style="display: none">
                                 <label for="" class="col-sm-3 control-label">DD/EFT Bank Branch Name/IFSC code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-group-dd-input" id="ddBranchName" name="ddBranchName" placeholder="">
                                 </div>
                              </div>
                              
                            <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Given Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-control-datepicker" id="receivedDate" name="receivedDate" placeholder="" required="required">
                                 </div>
                                 
                              </div>
                               <!--  <div class="form-group">
                                   <label for="" class="col-sm-3 control-label">Fine Calculation<span class="at-required-highlight">*</span></label> 
                               <div class="col-sm-7">
                               
                                <div class="radio radio-warning">
		  					<input type="radio" name="fineautomaticcalculation" value="automaticcalculation" checked="checked"><label>Automatic Calculation</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					  
		  					<input  type="radio" name="fineautomaticcalculation" value="custom"><label>Custom</label>
						</div>
						</div>
						</div> -->
                              <div class="form-group" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Fine</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="fineAmount" name="fineAmount" onkeypress="return decimalAmount(this, event, 2)" placeholder="">
                                 </div>
                              </div>
                             <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Narration</label> 
	                                 <div class="col-sm-7"> 
	                                    <textarea  class="form-control"  rows="3" id="narration" name="narration" placeholder=""></textarea>
	                                 </div>
	                          </div>
	                                        <div class="form-group">
                                   <label for="" class="col-sm-3 control-label">Export Mode</label> 
                               
                               <div class="col-sm-7">
                               
				  
						
						
						
					<div class="checkbox checkbox-info">
		                                            <input id="checkemail" name="exportmode" type="checkbox" value="email" checked="checked">
		                                            <label >
		                                                Email
		                                            </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                                            <input id="checksms" name="exportmode" type="checkbox" value="sms">
		                                            <label >
		                                                SMS
		                                            </label>
</div>
				</div>
				</div>
				
				
				
				
				
				
				
	                          		             
	                          <div id="dataTobeSubmitted">
	                            <input value="0" id="isDiscountAppliedHF" name="isDiscountAppliedHF" type="hidden"></input>
	                            <input value="" id="disTypeHF"  name="disTypeHF" type="hidden"></input>
	                            <input value="" id="disPerHF" name="disPerHF" type="hidden"></input>
	                          </div>
	                          
	                            <input type="hidden" id="selectedCheckBoxEmailId" name="selectedCheckBoxEmailId">
	                              <input type="hidden" id="selectedCheckBoxSmsId" name="selectedCheckBoxSmsId">
                             
	                            <input  id="firstname" name="firstname" type="hidden"></input>
	                              <input  id="email" name="email" type="hidden"></input>
	                                <input  id="phone" name="phone" type="hidden"></input>
	                                  <input id="productinfo" name="productinfo" type="hidden"></input>
	                                    <input  id="surl" name="surl" type="hidden"></input>
	                                      <input  id="furl" name="furl" type="hidden"></input>
	                                         <input  id="pg" name="pg" type="hidden"></input>
	                                           <input  id="checkPaymentType" name="checkPaymentType" type="hidden"></input>
	                           <div class="row">
	                              <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                             
                                 <div class="col-sm-offset-3">
                                  <button style="float:right" type="button" id="generateFCR"  class="btn btn-success btn-custom waves-effect waves-light">Generate Receipt</button>
                                 
                                   <!--  <button style="float:right" type="button" id="paymentgatewaytesting"  class="btn btn-info btn-custom waves-effect waves-light">Payment Gateway Testing</button>
                                -->
                                 
                                    <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload();">Cancel</button>
                                   
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
             
             
             <div class="modal fade" id="discount_type" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                <form class="form-horizontal" id="discountForm">
	                
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Discount</h4>
                     </div>
                         <div class="modal-body">
		                     
		                     	<div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Discount Type<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-7"> 
	                                  <select name="selectedDiscount" id="selectedDiscount" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
	                                  		 <option value="" disabled selected>Select Discount Type</option>
	                                  		 <option value="flat">Flat</option>
	                                  		 <option value="percentage">Percentage</option>
	                                    </select>
	                                 </div>
	                          </div>
	                          
	                          <div class="form-group" id="percentageBox" style="display: none;">
	                                 <label for="" class="col-sm-3 control-label">Percentage<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-7"> 
	                                    <input type="text" required="required" class="form-control" id="discountPercentage"  onkeypress="return decimalAmount(this, event, 2)" onchange="handleChange(this);" name="discountPercentage" placeholder="">
	                                 </div>
	                                 </div>
	                         
		                 </div>
	                     <div class="modal-footer">
	                     		  <input type="hidden" id="discountPercentage"  name="discountPercentage" >
	                     		  <button type="button" id="applyDiscount" class="btn btn-success btn-custom waves-effect waves-light" >Apply</button>
	                     		<!-- <a href="#" id="applyDiscount" style="float:right"  class="btn btn-success" type="button" data-id="" >
                                    Apply
                                   </a> --> 
	                     </div>
                    
                  </div>
                   </form>
               </div>
            </div>
             
             
             
             
             
             
             
           
            
       <div class="modal fade" id="${printReceipt}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirm</h4>
                     </div>
                     <div class="modal-body">
                        <h5>You want to print this receipt?</h5>
                     </div>
                     <div class="modal-footer">
                     	<a type="button" class="btn btn-primary" id="print" href="${pageContext.request.contextPath}/receipt/print?receiptId=${printReceipt}">Print</a>
                     </div>
                 </div>
               </div>
            </div>
        <div class="modal fade" id="invprint" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirm</h4>
                     </div>
                     <div class="modal-body">
                        <h5>You want to print and preview this receipt?</h5>
                     </div>
                     <div class="modal-footer">
                                          <a href="" id="printpreview" target="__blank" class="btn btn-info" type="button"data-href="#" data-id="" data-toggle="modal" >Preview</a>
                     
                     <a type="button" class="btn btn-primary" id="printinv" href="">Print</a>
                        
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
       		<script src="${pageContext.request.contextPath}/resources/themes/script/refund.js"></script>
       <script type="text/javascript">
  
    TableManageButtons.init();

</script>
       
</body>
</html>