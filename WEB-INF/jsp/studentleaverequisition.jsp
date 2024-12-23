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
      
       .thumb-image {
         width:150px;
         height:150px;
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
    
      .clonedInputHide{
      
      display: none;
      
      }
      .clonedInputShow{
      
      display: block;
      
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
      
            <div id="ListDiv" style="display:block;">
               <div class="form-group">
                  <button type="button" class="btn btn-primary btn-custom waves-effect waves-light col-md-3" onclick="showDiv()">Create New Requisition</button>
               </div>
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
               <br>
               <br>
             
               
                                   <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Leave Requisition</b></h4>
                              <br>
                               <table data-toggle="table"
                                 data-show-columns="true"
                                 data-page-list="[5, 10, 20]"
                                 data-page-size="5"
                                 data-search="true"
										   data-show-refresh="true"
										   data-show-toggle="true"
										   data-show-columns="true"
                                 data-pagination="true" data-show-pagination-switch="true"  class="table-bordered" id="datatable">
                              <thead>
                                 <tr>
                                   	<th>Leave type</th>
                                   	<th>Applied Date</th>
                                   	<th>Leave Reason</th>
                               		<th>Leave Date(s)</th>
                                  	<th>Status</th>
                                  	<th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="leaveRequisitionsList">
                              		<c:if test="${!empty studentLeaveRequistions}">
                                      <c:forEach items="${studentLeaveRequistions}" var="studentLeaveRequistion">
                                      		<tr >
		                                  	<td>${studentLeaveRequistion.getStudentLeaveType().getStudentLeaveType()}</td>
		                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${studentLeaveRequistion.getCreatedDate()}" /></td>
		                                    <td>${studentLeaveRequistion.getStudentLeaveReason()}</td>
		                                    
		                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${studentLeaveRequistion.getStudentLeaveStartDate()}" /> - <fmt:formatDate pattern="dd/MM/yyyy" value="${studentLeaveRequistion.getStudentLeaveEndDate()}" /></td>
		                                    <c:if test="${studentLeaveRequistion.getApprovalStatus()=='Pending'}">
		                                    		<td ><span class="label label-table label-danger">
		                                              ${studentLeaveRequistion.getApprovalStatus()}
		                                              </span>
		                                    </td>
		                                    </c:if>
		                                    <td>
		                                    	<a href="#" id="leaveCancel"  type="button" data-href="#" data-id="${studentLeaveRequistion.getStudentLeaveRequisitionId()}" data-toggle="modal" data-target="#leaveCancelConfirmation">
                                                	<span class="glyphicon glyphicon-remove"></span> 
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
                 <br />
               <br />
                    <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Movement Requisition</b></h4>
                              <br>
                               <table data-toggle="table"
                                 data-show-columns="true"
                                 data-page-list="[5, 10, 20]"
                                 data-page-size="5"
                                 data-search="true"
										   data-show-refresh="true"
										   data-show-toggle="true"
										   data-show-columns="true"
                                 data-pagination="true" data-show-pagination-switch="true"  class="table-bordered" id="datatable">
                              <thead>
                                 <tr>
                                   	<th>Applied Date</th>
                                   	<th>Reason</th>
                                   	<th>fromTime</th>
                                   	<th>toTime</th>
                                   	<th>Requisition Date</th>
                                   	<th>Status</th>
                               	 	<th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="movementRequisitionsList">
                              		<c:if test="${!empty studentMovementRequistions}">
                                      <c:forEach items="${studentMovementRequistions}" var="studentMovementRequistion">
                                      		<tr >
		                                  	 <td><fmt:formatDate pattern="dd/MM/yyyy" value="${studentMovementRequistion.getCreatedDate()}" /></td>
		                                    <td>${studentMovementRequistion.getRequestReason()}</td>
		                                    <td>${studentMovementRequistion.getStartTime() }</td>
		                                    <td>${studentMovementRequistion.getEndTime() }</td>
		                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${studentMovementRequistion.getStudentMovementDate()}" /></td>
		                                    <c:if test="${studentMovementRequistion.getApprovalStatus()=='Pending'}">
		                                    		<td ><span class="label label-table label-danger">
		                                              ${studentMovementRequistion.getApprovalStatus()}
		                                              </span>
		                                    </td>
		                                    </c:if>
		                                    <td>
		                                    	<a href="#" id="movementCancel"  type="button" data-href="#" data-id="${studentMovementRequistion.getStudentMovementRequisitionId()}" data-toggle="modal" data-target="#movementCancelConfirmation">
                                                	<span class="glyphicon glyphicon-remove"></span> 
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
                 <br />
               <br />
              
                                <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Leave Requisition Status</b></h4>
                               <table data-toggle="table"
                                 data-show-columns="true"
                                 data-page-list="[5, 10, 20]"
                                 data-page-size="5"
                                 data-search="true"
										   data-show-refresh="true"
										   data-show-toggle="true"
										   data-show-columns="true"
                                 data-pagination="true" data-show-pagination-switch="true"  class="table-bordered">
                              <thead>
                                 <tr>
                                   	<th>Leave type</th>
                                   	<th>Applied Date</th>
                                   	<th>Leave Reason</th>
                               		<th>Leave Date(s)</th>
                               		<th>Comment</th>
                                  	<th>Status</th>
                                   </tr>
                              </thead>
                              <tbody id="studentLeaveRequestApprovedAndRejectedList">
                              		<c:if test="${!empty studentLeaveRequestApprovedAndRejectedLists}">
                                      <c:forEach items="${studentLeaveRequestApprovedAndRejectedLists}" var="studentLeaveRequestApprovedAndRejectedLists">
                                      		<tr >
		                                  	<td>${studentLeaveRequestApprovedAndRejectedLists.getStudentLeaveType().getStudentLeaveType()}</td>
		                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${studentLeaveRequestApprovedAndRejectedLists.getCreatedDate()}" /></td>
		                                    <td>${studentLeaveRequestApprovedAndRejectedLists.getStudentLeaveReason()}</td>
		                                    
		                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${studentLeaveRequestApprovedAndRejectedLists.getStudentLeaveStartDate()}" /> - <fmt:formatDate pattern="dd/MM/yyyy" value="${studentLeaveRequestApprovedAndRejectedLists.getStudentLeaveEndDate()}" /></td>
		                                    <td>${studentLeaveRequestApprovedAndRejectedLists.getApproverComment()}</td>
		                                    <c:if test="${studentLeaveRequestApprovedAndRejectedLists.getApprovalStatus()=='Approved'}">
		                                    		<td ><span class="label label-table label-success">
		                                              ${studentLeaveRequestApprovedAndRejectedLists.getApprovalStatus()}
		                                              </span>
		                                    </td>
		                                    </c:if>
		                                  <c:if test="${studentLeaveRequestApprovedAndRejectedLists.getApprovalStatus()=='Rejected'}">
		                                    		<td ><span class="label label-table label-danger">
		                                              ${studentLeaveRequestApprovedAndRejectedLists.getApprovalStatus()}
		                                              </span>
		                                    </td>
		                                    </c:if>
                                         </tr>
		                              </c:forEach>
                                    </c:if>
                              </tbody>
                           </table>
                        </div>
                       </div>
                 </div>
                 
                      <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Movement Requisition Status</b></h4>
                               <table data-toggle="table"
                                 data-show-columns="true"
                                 data-page-list="[5, 10, 20]"
                                 data-page-size="5"
                                 data-search="true"
										   data-show-refresh="true"
										   data-show-toggle="true"
										   data-show-columns="true"
                                 data-pagination="true" data-show-pagination-switch="true"  class="table-bordered">
                              <thead>
                                 <tr>
                                  	<th>Applied Date</th>
                                   	<th>Reason</th>
                                   	<th>fromTime</th>
                                   	<th>toTime</th>
                                   	<th>Requisition Date</th>
                                   	<th>Comment</th>
                               	 	<th>Status</th>
                                   </tr>
                              </thead>
                              <tbody id="movementRequestApprovedAndRejectedList">
                              		<c:if test="${!empty studentMovementRequestApprovedAndRejectedLists}">
                                      <c:forEach items="${studentMovementRequestApprovedAndRejectedLists}" var="studentMovementRequestApprovedAndRejectedLists">
                                      		<tr >
                                      		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${studentMovementRequestApprovedAndRejectedLists.getCreatedDate()}" /></td>
		                                    <td>${studentMovementRequestApprovedAndRejectedLists.getRequestReason()}</td>
		                                    <td>${studentMovementRequestApprovedAndRejectedLists.getStartTime() }</td>
		                                    <td>${studentMovementRequestApprovedAndRejectedLists.getEndTime() }</td>
		                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${studentMovementRequestApprovedAndRejectedLists.getStudentMovementDate()}" /></td>
		                                    <td>${studentMovementRequestApprovedAndRejectedLists.getApproverComment()}</td>
		                                    <c:if test="${studentMovementRequestApprovedAndRejectedLists.getApprovalStatus()=='Approved'}">
		                                    		<td ><span class="label label-table label-success">
		                                              ${studentMovementRequestApprovedAndRejectedLists.getApprovalStatus()}
		                                              </span>
		                                    </td>
		                                    </c:if>
		                                  <c:if test="${studentMovementRequestApprovedAndRejectedLists.getApprovalStatus()=='Rejected'}">
		                                    		<td ><span class="label label-table label-danger">
		                                              ${studentMovementRequestApprovedAndRejectedLists.getApprovalStatus()}
		                                              </span>
		                                    </td>
		                                    </c:if>
                                         </tr>
		                              </c:forEach>
                                    </c:if>
                              </tbody>
                           </table>
                        </div>
                       </div>
                 </div>
                      </div>
                 
             <div class="modal fade" id="leaveCancelConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
		               <div class="modal-dialog" role="document">
		                  <div class="modal-content">
		                     <div class="modal-header">
		                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
		                     </div>
		                     <div class="modal-body">
		                        <h5>Are you sure ?, You want to cancel your Leave Requisition??</h5>
		                     </div>
		                     <div class="modal-footer">
		                       <form id="cancelstudentform" action="${pageContext.request.contextPath}/student/leave/requisition/studentLeaveRequest/cancel" method="post">
                              <input type="hidden" id="studentLeaveRequisitionId" name="studentLeaveRequisitionId">
                                 <button type="button" id="leaveCancelConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
		                   </form>
		                     </div>
		                  </div>
		               </div>
                </div>
                
                 <div class="modal fade" id="movementCancelConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
		               <div class="modal-dialog" role="document">
		                  <div class="modal-content">
		                     <div class="modal-header">
		                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
		                     </div>
		                     <div class="modal-body">
		                        <h5>Are you sure ?, You want to cancel your Movement Requisition??</h5>
		                     </div>
		                     <div class="modal-footer">
		                       <form id="cancelstudentmovementform" action="${pageContext.request.contextPath}/student/studentMovementRequisition/studentMovementRequest/cancel" method="post">
                              <input type="hidden" id="studentMovementRequisitionId" name="studentMovementRequisitionId">
                                 <button type="button" id="movementCancelConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
		                   </form>
		                     </div>
		                  </div>
		               </div>
                </div>
            
            <div class="modal fade" id="addStudentLeaveRequisitionConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want Request For Leave Requisition ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="addStudentLeaveRequisitionConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            
             <div class="modal fade" id="addStudentMovementRequisitionConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want Request For Movement Requisition ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="addStudentMovementRequisitionConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="addStaffPurchaseRequisitionConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want Request For Purchase ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="addStaffLeaveRequisitionConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="addStaffTravelRequisitionConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want Request For Travel ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="addStaffLeaveRequisitionConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
             <div class="modal fade" id="addStaffFacilityRequisitionConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want Request For Travel ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="addStaffLeaveRequisitionConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div id="FormDiv" style="display:none;">
               <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Create New Requisition</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                  <form class="form-horizontal">
                         
                         
                            <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Requisition Type</label> 
                                       <div class="col-sm-7">
                                          <select name="requisitionType" id="requisitionType" class="selectpicker" data-live-search="true"  data-style="btn-white">
                                             <c:if test="${!empty requisitionTypeList}">
                                          <option value="" disabled selected>Select Requisition Type</option>
                                        <c:forEach items="${requisitionTypeList}" var="requisitionType">
                                          <c:if test="${requisitionType.getRequisitionTypeId()=='1'}">
                                        <option value="${requisitionType.getRequisitionTypeId()}">${requisitionType.getRequisitionType()}</option>
                                      </c:if>
                                      <c:if test="${requisitionType.getRequisitionTypeId()=='2'}">
                                        <option value="${requisitionType.getRequisitionTypeId()}">${requisitionType.getRequisitionType()}</option>
                                      </c:if>
                                        </c:forEach>
                                      </c:if>
                                          </select>
                                       </div>
                                    </div> 
                                    </form>
                                     
               </div></div>
               </div>
                  </div>
               </div>
                <div id="leaverequisition" style="display:none;">
                   <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-info">
                              <div class="panel-heading">
                                  <h4 class="panel-title"><b>Leave Requisition</b></h4>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                       <form class="form-horizontal" id="addStudentLeaveRequisitionForm" action="${pageContext.request.contextPath}/student/leave/requisition/studentLeaveRequest" method="post">
                 <input type="hidden" id="selectedRequisitionTypeId" name="selectedRequisitionTypeId">
                              
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Leave Type<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="studentLeaveType" id="studentLeaveType" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                    <c:if test="${!empty studentLeaveTypeList}">
                                          <option value="" disabled selected>Select Leave Type</option>
                                        <c:forEach items="${studentLeaveTypeList}" var="studentLeaveType">
                                        <option value="${studentLeaveType.getStudentLeaveTypeId()}">${studentLeaveType.getStudentLeaveType()}</option>
                                        </c:forEach>
                                      </c:if>
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Start Date And End Date<span class="at-required-highlight">*</span> </label> 
                                 <div class="col-sm-7"> 
                                       <input type="text"  class="form-control reportrange" id="studentLeaveStartAndEndDate" name="studentLeaveStartAndEndDate" placeholder="" required="required">
                                 </div>
                                 
                              </div>
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reason<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="studentLeaveReason" class="form-control" id="studentLeaveReason" placeholder="" required="required">
                                 </div>
                              </div>
                            
                       
                                <div class="row">
                                  <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                               
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="button" id="addStudentLeaveRequisition" class="btn btn-success btn-custom waves-effect waves-light">Request</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                    <button style="float:right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload();">Cancel</button>
                                                          </div>
                              </div>
                              </form>
                           </div>
                           </div>
                           </div>
                           </div>
                           </div>
                           
                             </div>
                             
                             
                                    <div id="movementrequisition" style="display:none;">
                   <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-primary">
                              <div class="panel-heading">
                                  <h4 class="panel-title"><b>Movement Requisition</b></h4>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                       <form class="form-horizontal" id="addStudentMovementRequisitionForm" action="${pageContext.request.contextPath}/student/studentMovementrequisition/studentMovementRequest" method="post">
                 <input type="hidden" id="selectedMovementRequisitionTypeId" name="selectedMovementRequisitionTypeId">
                              
                       
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Movement Requisition Date<span class="at-required-highlight">*</span> </label> 
                                 <div class="col-sm-7"> 
                                       <input type="text"  class="form-control" id="studentMovementRequisitionDate" name="studentMovementRequisitionDate" placeholder="" required="required">
                                 </div>
                                </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">fromTime<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="studentInTime" class="form-control timedropper" id="studentInTime" required="required">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">toTime<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="studentOutTime" class="form-control timedropper" id="studentOutTime" required="required">
                                 </div>
                              </div>
                            
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reason<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="studentMovementRequisitionReason" class="form-control" id="studentMovementRequisitionReason" placeholder="" required="required">
                                 </div>
                              </div>
                                <div class="row">
                                  <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                               
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="button" id="addStudentMovementRequisition" class="btn btn-success btn-custom waves-effect waves-light">Request</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                    <button style="float:right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload();">Cancel</button>
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
      </div></div>
     
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

<script src="${pageContext.request.contextPath}/resources/themes/script/studentleaverequisition.js" type="text/javascript"></script> 

<script type="text/javascript">
  
    TableManageButtons.init();

</script>
   </body>
</html>