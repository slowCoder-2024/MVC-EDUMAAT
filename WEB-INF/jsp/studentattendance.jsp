<!DOCTYPE HTML>
<html>
   <head>
          <meta charset="utf-8">
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
      
        <script src="${pageContext.request.contextPath}/resources/themes/js/datedropper/datedropper.js"></script>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/js/datedropper/datedropper.css"> 
        <script src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/timedropper.js"></script> 
         <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/js/datepicker/css/timedropper.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/js/datepicker/css/timedropper.min.css">
   <%--     <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/timepicker/bootstrap-timepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/clockpicker/css/bootstrap-clockpicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
       --%>
      
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
    <style>
    .redBackground{
    background-color: red;  
}

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
 </head> 
    
<body class="fixed-left">
		<div id="wrapper">
                <%@ include file="master_header.jsp" %>
                <%@ include file="master_menu.jsp" %>
    <div class="content-page">
				<!-- Start content -->
				<div class="content">
<div class="container">
		 <div class="loader"  style="display: none"></div>
             <div id="TimeTableTemplateDiv" style="display:block;">
                     <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-warning">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Today Movement Requisition Apply Student List</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                             <table data-toggle="table"
                                       data-show-columns="true"
                                       data-page-list="[5, 10, 20]"
                                       data-page-size="5"
                                       data-search="true"
                                       data-show-refresh="true"
                                       data-show-toggle="true"
                                       data-show-columns="true"
                                       data-pagination="true" data-show-pagination-switch="true" class="table table-striped table-bordered"  id="staffModuleList">
                                              <thead>
                                 <tr>
                                  	<th>Class Name</th>
                                  	<th>Section Name</th>
                                  	<th>Student Id</th>
                                   	<th>Student Name</th>
                                   	<th>Requisition Date</th>
                                   	<th>fromTime</th>
                                   	<th>toTime</th>
                                   </tr>
                              </thead>
                              <tbody id="movementRequestApprovedList">
                              		<c:if test="${!empty studentMovementRequestApprovedLists}">
                                      <c:forEach items="${studentMovementRequestApprovedLists}" var="studentMovementRequestApprovedLists">
                                      		<tr >
                                      		 <td>${studentMovementRequestApprovedLists.getStudentClass().getClassName()}</td>
                                      		  <td>${studentMovementRequestApprovedLists.getSection().getSectionName()}</td>
                                      		    <td>${studentMovementRequestApprovedLists.getStudent().getStudentId()}</td>
                                      		  <td>${studentMovementRequestApprovedLists.getStudent().getFirstName()} ${studentMovementRequestApprovedLists.getStudent().getLastName()}</td>
                                      		 <td><fmt:formatDate pattern="dd/MM/yyyy" value="${studentMovementRequestApprovedLists.getStudentMovementDate()}" /></td>
		                                   <td>${studentMovementRequestApprovedLists.getStartTime() }</td>
		                                    <td>${studentMovementRequestApprovedLists.getEndTime() }</td>
		                                    </tr>
		                              </c:forEach>
                                    </c:if>
                              </tbody>
                                    </table>
                                 </div>
                                 </div>
                                 </div>
                                 </div>
                                 </div>
           <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-info">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Upload Student Attendance</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
             
               <form id="studentAttendanceUploadForm"  enctype="multipart/form-data" action="${pageContext.request.contextPath}/studentattendance/bulkupload" method="post">
               		<div class="form-group">
	<label class="col-sm-2 control-label" for="">Select Excel File <span class="at-required-highlight">*</span></label>
	<div class="col-sm-7">
	<input id="studentAttendanceExcelfile" class="filestyle" data-size="md" name="studentAttendanceExcelfile" required="required" type="file">
	</div>
	</div>
	 
               </form>
               <form class="form-horizontal" id="studentattendancedownloadform" action="${pageContext.request.contextPath}/studentattendance/studentAttendanceExcelFormat" method="POST">
          <div class="row">
	         <div class="col-sm-offset-3">
	                    <button  style="float:right;" type="button" id="uploadStudentAttendance" class="btn btn-info btn-custom waves-effect waves-light ">Upload</button>
        <button style="float:right;" type="submit" name="studentDataExcel" id="studentDataExcel" class="btn btn-danger btn-custom waves-effect waves-light">Download Excel</button>
    
	          </div>
              </div>
         </form>
                    </div>
                    </div>
                    </div>
                    </div>
                    </div>
          <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Record Student Attendance</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                        <form class="form-horizontal" id="studentAttendanceForm" action="${pageContext.request.contextPath}/studentattendance/add" method="post">
 
								 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Class<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                <select name="class" id="class" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                  	<option value="" disabled selected>Select Class</option>
                                   		 <c:if test="${!empty classes}">
		                                   		      	<c:forEach items="${classes}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                 </div>
                               
                              </div>
                             
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Section<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="section" id="section" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                   </select>
                                 </div>
                              </div>
                              
                              <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Attendance Date<span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-7"> 
                                 <input type="text" name="attendanceDate" class="form-control form-control-firststep" id="attendanceDate" required="required" maxlength="50">
                                <span id="errorclassName" class="error"></span>
                              </div>
                              
                            </div>
 								 <div class="form-group ">
                            <label for="" class="col-sm-3 control-label">Attendance Time <span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-7"> 
                                 <input type="text" name="attendanceTime" class="form-control timedropper" id="attendanceTime" required="required" maxlength="50">
                              </div> 
                              </div>
 						        <div class="row">
                              <div class="col-sm-offset-3">
                                 <button style="float:right"  type="button" id="getstudentlist" class="btn btn-info btn-custom waves-effect waves-light">Get Student List</button>
                                  
                              </div>
                           </div>
                           <br/>
                           <div id="tableview" style="display: none;">
                         
                                 <table class="table table-striped table-bordered" id="studentAttendanceList">
                              <thead >
                                 <tr>
                                   <th>Student Id</th>
                                   	<th>Student Name</th>
                               		<th>Attendance</th>
                               		<th>Attendance Type</th>
                                 </tr>
                              </thead>
                            
                           </table>
                         <input type="hidden" id="attendanceStudentId" name="attendanceStudentId">
                           <div class="row">
                              <div class="col-sm-offset-3">
                                 <button style="float:right"  type="button" id="updateStudentAttendance" class="btn btn-success btn-custom waves-effect waves-light">Update Student Attendance</button>
                                  
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
       
 
              
                <div class="modal fade" id="updateStudentAttendanceConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ? You want to update Student Attendance??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="updateStudentAttendanceConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
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
    <%--   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.mockjax.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.autocomplete.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/countries.js"></script> --%>
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

<script src="${pageContext.request.contextPath}/resources/themes/script/studentattendance.js" type="text/javascript"></script> 
<script type="text/javascript">
  
    TableManageButtons.init();

</script>
</body>
</html>