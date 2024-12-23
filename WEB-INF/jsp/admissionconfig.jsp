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
   
      <!-- //chart -->
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
    
         .thumbnail {
         height: 200px;
         overflow: hidden;
         }
         .thumbnail {
         display: block;
         padding: 4px;
         margin-bottom: 20px;
         line-height: 1.42857143;
         background-color: #fff;
         border: 1px solid #00BCD4;
         border-radius: 4px;
         -webkit-transition: border .2s ease-in-out;
         -o-transition: border .2s ease-in-out;
         transition: border .2s ease-in-out;
         }
      </style>
</head> 	<body class="fixed-left">
	           
				<!-- Begin page -->
		<div id="wrapper">
                <%@ include file="master_header.jsp" %>
                <%@ include file="master_menu.jsp" %>
    


			<div class="content-page">
				<!-- Start content -->
				<div class="content">
					<div class="container">

		 <div class="loader" style="display: none"></div>
				<div id="ListDiv" style="display:block;">
                  <div class="form-group">
                        <div class="col-md-4 col-sm-4 col-xs-12"> 
                           <button type="button" class="btn btn-primary btn-custom waves-effect waves-light" onclick="showDiv()"> Create Configuration</button>
                        </div>
                     </div>
               <br />
               <br />
                  <br />      
                    <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Admission Configuration</b></h4>
                               <table data-toggle="table"
                                 data-show-columns="true"
                                 data-page-list="[5, 10, 20]"
                                 data-page-size="5"
                                        data-search="true"
										   data-show-refresh="true"
										   data-show-toggle="true"
										   data-show-columns="true"
                                 data-pagination="true" data-show-pagination-switch="true" class="table-bordered ">
                                 <thead>
                                    <tr>
                                        <th data-field="Application_Code_Format" data-switchable="false"> Application Code Format</th>
                                       <th data-field="Application_Fees">Application Fees</th>
                                       <th data-field="Admission_Year">Admission Year</th>
                                       <th data-field="Application_Process_Status">Admission Process Status</th>
                                       <th data-field="Action">Action</th>
                                     </tr>
                                 </thead>
                                   <tbody id="admissionConfiglist">
                                    <c:if test="${!empty admissionConfigList}">
                                       <c:forEach items="${admissionConfigList}" var="admissionConfig">
                                          <tr>
                                             <td>${admissionConfig.getApplicationCodeFormat()}</td>
                                             <td>${admissionConfig.getApplicationFees()}</td>
                                             <td>${admissionConfig.getAdmissionProcessYear()}</td>
                                             <td>${admissionConfig.getAdmissionProcessStatus().getAdmissionProcessStatusTitle()}</td>
                                             <td >
                                                <a href="#" id="edit"  type="button" data-href="#"  data-id="${admissionConfig.getAdmissionConfigId()}" data-toggle="modal" onclick="showeditDiv()"class="on-default edit-row"><i class="fa fa-pencil" style="margin-right: 15px"></i>
                                          </a>
                                         
                                                <a href="#"  id="delete"  type="button" data-href="#"  data-id="${admissionConfig.getAdmissionConfigId()}" data-toggle="modal" data-target="#confirm-delete"class="on-default remove-row"><i class="fa fa-trash-o"></i>
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
                 </div>
            
            <div id="FormDiv" style="display:none;">
            	      <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Admission Configuration</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                        <form class="form-horizontal" role="form" data-parsley-validate novalidate id="newadmissionConfigForm" action="${pageContext.request.contextPath}/admissions/admissionconfig/add" method="post">
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Admission Application Code Format<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="admissionCodeFormat"  class="form-control" id="" placeholder="" maxlength="50" required="required">
                                 </div>
                              </div>
                                <div class="form-group ">
                                       <label for="" class="col-sm-3 control-label">Select Class<span class="at-required-highlight">*</span></label>
                                       <div class="col-sm-7">
                                          <select name="classId" id="classId" class="selectpicker" multiple="multiple" data-style="btn-white" required="required">
                                          		<c:if test="${!empty classList}">
		                                       			<c:forEach items="${classList}" var="classes">
		                                       					<option value="${classes.getClassId()}" >${classes.getClassName()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Application Fees<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text"  name="admissionApplicationFees" class="form-control" id="" placeholder="" maxlength="10" required="required" onkeypress="return decimalAmount(this, event, 2)">
                                 </div>
                              </div>
                            <!--    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Start Date And End Date <span class="at-required-highlight">*</span></label> 
                                 <div class="col-md-6"> 
                                    <input type="text"  class="form-control form-control-datepicker-range" id="admissionStartAndEndDate"  name="admissionStartAndEndDate" placeholder="" required="required">
                                 </div>
                              </div> -->
                              
                                 <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Admission Start Date<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" required="required" name="admissionstartdate"  maxlength="10" class="form-control form-control-datepicker" id="admissionstartdate" placeholder="">
                                       </div>
                                    </div>
                                   
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Admission End Date<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" required="required" name="admissionenddate" maxlength="10" class="form-control form-control-datepicker" id="admissionenddate" placeholder="">
                                       </div>
                                    </div>
                                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Total No.Of Seats<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="admissionTotalSeats" onkeypress="return isNumber(event)" maxlength="10" class="form-control" id="admissionTotalSeats" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Admission Process Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                 <select name="admissionProcessStatusId" id="selector1" class="selectpicker"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Process Status</option>
                                       <c:if test="${!empty admissionProcessStatusList}">
                                       <c:forEach items="${admissionProcessStatusList}" var="admissionProcessStatus">
                                       		<option value="${admissionProcessStatus.getAdmissionProcessStatusId()}">${admissionProcessStatus.getAdmissionProcessStatusTitle()}</option>
                                       </c:forEach>
                                       </c:if>
                                  </select>
                                 
                                                                  </div>
                              </div>
                                 <div class="form-group">
                                      
                                          <div class="col-sm-offset-4 col-sm-8">
                                             <button style="float:right"  type="button" id="admissionConfigSave" class="btn btn-primary btn-custom waves-effect waves-light ">Save</button>
                                             <button style="float:right" type="reset" id="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                             <button style="float:right" type="button" onclick="location.reload();" class="btn btn-default btn-custom waves-effect waves-light m-l-5">Cancel</button>
                                          </div>
                                       </div>
                        </form>
                        </div>
                        </div>
                  </div>
               </div>
            </div>
            
            
            </div>
            
            <div class="modal fade" id="admissionConfigSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to create new admission Configuration ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="admissionConfigSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            
             <div class="modal fade" id="admissionConfigUpdateConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to update admission Configuration ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="admissionConfigUpdateConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            
             <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to delete this admission Config??</h5>
                     </div>
                     <div class="modal-footer">
                        <a href="" id="confirmcAdmissionConfigDelete"  class="btn btn-primary" type="button">Yes
                         </a>
                     </div>
                  </div>
               </div>
            </div>
            
            <div id="EditFormDiv" style="display:none;">
            	    	      <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Admission Configuration</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                        <form class="form-horizontal" id="updateadmissionConfigForm" action="${pageContext.request.contextPath}/admissions/admissionconfig/update" method="post">
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Admission Application Code Format<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editadmissionCodeFormat" id="editadmissionCodeFormat" class="form-control" id="" placeholder="" maxlength="50" required="required">
                                 </div>
                              </div>
                                <div class="form-group ">
                                       <label for="" class="col-sm-3 control-label">Select Class<span class="at-required-highlight">*</span></label>
                                       <div class="col-sm-7">
                                          <select name="editClassId" id="editClassId" class="selectpicker" multiple="multiple" data-style="btn-white" required="required">
                                          		<c:if test="${!empty classList}">
		                                       			<c:forEach items="${classList}" var="classes">
		                                       					<option value="${classes.getClassId()}" >${classes.getClassName()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Application Fees<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text"  name="editadmissionApplicationFees"  class="form-control" id="editadmissionApplicationFees" maxlength="10" placeholder="" required="required" onkeypress="return decimalAmount(this, event, 2)">
                                 </div>
                              </div>
                               
                                 <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Admission Start Date<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" required="required" name="editadmissionstartdate" class="form-control form-control-datepicker" maxlength="10" id="editadmissionstartdate" placeholder="">
                                       </div>
                                    </div>
                                    
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Admission End Date<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" required="required" name="editadmissionenddate" class="form-control form-control-datepicker"  maxlength="10" id="editadmissionenddate" placeholder="">
                                       </div>
                                    </div>
                                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Total No.Of Seats<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editAdmissionTotalSeats" onkeypress="return isNumber(event)" class="form-control" maxlength="10" id="editAdmissionTotalSeats" placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Admission Process Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                 <select name="editadmissionProcessStatusId" id="editadmissionProcessStatusId" class="selectpicker"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Process Status</option>
                                       <c:if test="${!empty admissionProcessStatusList}">
                                       <c:forEach items="${admissionProcessStatusList}" var="admissionProcessStatus">
                                       		<option value="${admissionProcessStatus.getAdmissionProcessStatusId()}">${admissionProcessStatus.getAdmissionProcessStatusTitle()}</option>
                                       </c:forEach>
                                       </c:if>
                                  </select>
                                 
                                                                  </div>
                              </div>
                            
                               <input type="hidden" name="updateAdmissionConfigId" id="updateAdmissionConfigId">
                                 <div class="form-group">
                                      
                                          <div class="col-sm-offset-4 col-sm-8">
                                             <button style="float:right"  type="button" id="admissionConfigUpdate"  name="admissionConfigUpdate" class="btn btn-primary btn-custom waves-effect waves-light ">Update</button>
                                             <button style="float:right" type="reset" id="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                             <button style="float:right" type="button" onclick="location.reload();" class="btn btn-default btn-custom waves-effect waves-light m-l-5">Cancel</button>
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
         <script src="${pageContext.request.contextPath}/resources/themes/script/admissionconfig.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/geographicalLocation.js"></script>   
     
</body>
</html>