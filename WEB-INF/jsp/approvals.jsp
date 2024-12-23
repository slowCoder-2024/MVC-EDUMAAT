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
                <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Leave Request(s)</b></h4>
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
                                   	<th>Staff Name</th>
                                   	<th>Applied Date</th>
                                   	<th>Leave Reason</th>
                               		<th>Leave type</th>
                               		<th>Leave Date(s)</th>
                               		<th>Comment</th>
                                  	<th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="approvalsList">
                              	<c:if test="${!empty leaveApporvalsList}">
                                     <c:forEach items="${leaveApporvalsList}" var="leaveApporvals">
                                     	<tr >
		                                  	<td>${leaveApporvals.getStaff().getFirstName()} ${leaveApporvals.getStaff().getLastName()}</td>
		                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${leaveApporvals.getCreatedDate()}" /></td>
		                                    <td>${leaveApporvals.getStaffLeaveReason()}</td>
		                                    <td>${leaveApporvals.getStaffLeaveType().getStaffLeaveType()}</td>
		                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${leaveApporvals.getStaffLeaveStartDate()}" /> - <fmt:formatDate pattern="dd/MM/yyyy" value="${leaveApporvals.getStaffLeaveStartDate()}" /></td>
		                                   <td> 
	                                    <input  class="form-control"  required="required" id="approverComment${leaveApporvals.getStaffLeaveRequisitionId()}" name="approverComment${leaveApporvals.getStaffLeaveRequisitionId()}" placeholder="" />
	                              </td>
		                                   	<td>
		                                   	  	<a href="#" id="staffLeaveApprove"  type="button" data-href="#" data-id="${leaveApporvals.getStaffLeaveRequisitionId()}" >
                                               <span class="label label-table label-success"> 	<i class="fa fa-thumbs-o-up" aria-hidden="true"></i></span>
                                                </a>
                                                 	<a href="#" id="staffLeaveRejection"  type="button" data-href="#" data-id="${leaveApporvals.getStaffLeaveRequisitionId()}">
                                                	<span class="label label-table label-danger"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i></span>
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
                  
             
                       
                       
                              <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Movement Request(s)</b></h4>
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
                                   	<th>Staff Name</th>
                                   	<th>Applied Date</th>
                                   	<th>Reason</th>
                                   	<th>fromTime</th>
                                   	<th>toTime</th>
                                   	<th>Requisition Date</th>
                               		<th>Comment</th>
                                  	<th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="movementapprovalsList">
                     	<c:if test="${!empty movementApprovalsList}">
                                     <c:forEach items="${movementApprovalsList}" var="movementApporvals">
                                     	<tr >
		                                  	<td>${movementApporvals.getStaff().getFirstName()} ${movementApporvals.getStaff().getLastName()}</td>
		                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${movementApporvals.getCreatedDate()}" /></td>
		                                    <td>${movementApporvals.getRequestReason()}</td>
		                                     <td>${movementApporvals.getStartTime() }</td>
		                                    <td>${movementApporvals.getEndTime() }</td>
		                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${movementApporvals.getStaffMovementRequisitionDate()}" /> </td>
		                                    <td> 
	                                    <input  class="form-control"  required="required" id="movementApproverComment${movementApporvals.getStaffMovementRequisitionId()}" name="movementApproverComment${movementApporvals.getStaffMovementRequisitionId()}" placeholder="" />
	                             		 </td>
		                                   	<td>
		                                   	  	<a href="#" id="staffMovementApprove"  type="button" data-href="#" data-id="${movementApporvals.getStaffMovementRequisitionId()}" >
                                               <span class="label label-table label-success"> 	<i class="fa fa-thumbs-o-up" aria-hidden="true"></i></span>
                                                </a>
                                                 	<a href="#" id="staffMovementRejection"  type="button" data-href="#" data-id="${movementApporvals.getStaffMovementRequisitionId()}">
                                                	<span class="label label-table label-danger"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i></span>
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
                  
                              <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Transfer Certificate Request(s)</b></h4>
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
                                 	<th>Admission No</th>
                                   	<th>Student Name</th>
                                   	<th>Class Name</th>
                                   	<th>Section Name</th>
                                   	<th>Applied Date</th>
                                   	<th>Reason</th>
                               		<th>Comment</th>
                                  	<th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="transfercertificateapprovalsList">
                              	<c:if test="${!empty tcApprovalsList}">
                                     <c:forEach items="${tcApprovalsList}" var="tcApprovals">
                                     	<tr >
                                     	<td>${tcApprovals.getStudent().getAdmissionNo()}</td>
		                                  	<td>${tcApprovals.getStudent().getFirstName()} ${tcApprovals.getStudent().getLastName()}</td>
		                                  	<td>${tcApprovals.getStudentClass().getClassName()} </td>
		                                  	<td>${tcApprovals.getSection().getSectionName()} </td>
		                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${tcApprovals.getCreatedDate()}" /></td>
		                                    <td>${tcApprovals.getRequestReason()}</td>
		                                   <td> 
	                                    <input  class="form-control"  required="required" id="tcApproverComment${tcApprovals.getTransferCertificateRequisitionId()}" name="tcApproverComment${tcApprovals.getTransferCertificateRequisitionId()}" placeholder="" />
	                              </td>
		                                   	<td>
		                                   	  	<a href="#" id="tcApprove"  type="button" data-href="#" data-id="${tcApprovals.getTransferCertificateRequisitionId()}" >
                                               <span class="label label-table label-success"> 	<i class="fa fa-thumbs-o-up" aria-hidden="true"></i></span>
                                                </a>
                                                 	<a href="#" id="tcRejection"  type="button" data-href="#" data-id="${tcApprovals.getTransferCertificateRequisitionId()}">
                                                	<span class="label label-table label-danger"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i></span>
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
                      <div class="modal fade" id="partially_leave_update_status" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" id="closeddReconModal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Approve:</h4>
                     </div>
                     <form class="form-horizontal" id="updatePartiallyLeaveForm" action="${pageContext.request.contextPath}/staff/requisition/partiallyleaveapprove" method="post">
	                     <div class="modal-body">
		                     
		                     	<div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Start Date<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-7"> 
	                                    <input type="text" required="required" class="form-control form-control-datepicker" id="partiallyLeaveStartDate" name="partiallyLeaveStartDate" placeholder="">
	                                 </div>
	                                 </div>
	                          
	                          <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">End Date<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-7"> 
	                                    <input type="text" required="required" class="form-control form-control-datepicker" id="partiallyLeaveEndDate" name="partiallyLeaveEndDate" placeholder="">
	                                 </div>
	                                 </div>
	                         <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Comments<span class="at-required-highlight">*</span></label> 
	                                 <div class="col-sm-7"> 
	                                    <textarea  class="form-control" required="required" rows="3" id="comment" name="comment" placeholder=""></textarea>
	                                 </div>
	                          </div>
		                 </div>
	                     <div class="modal-footer">
	                     		<a href="#" id="updatePartiallyLeaveApprove" style="float:right"  class="btn btn-success btn-custom waves-effect waves-light" type="button" data-id="" >
                                    Update
                                   </a> 
	                     </div>
                     </form>
                  </div>
               </div>
            </div>
            
            <div class="modal fade" id="confirm-rejected" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirm?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure you want to Reject this Approvals?</h5>
                     </div>
                     <div class="modal-footer">
                       <form id="rejectedLeaveRequisition" action="${pageContext.request.contextPath}/staff/approvals/updatestatus" method="post">
                             <!--  <input type="hidden" id="staffLeaveRequisitionId" name="staffLeaveRequisitionId">
                               <input type="hidden" id="staffLeaveRequisitionStatus" name="staffLeaveRequisitionStatus"> -->
                              <button type="button" id="confirmation-rejected" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                     
                     </div>
                  </div>
               </div>
            </div>
            
            <div class="modal fade" id="confirm-approved" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to Accept this Approvals ??</h5>
                     </div>
                     <div class="modal-footer">
                       <form id="approvedLeaveRequisition" action="${pageContext.request.contextPath}/staff/approvals/updatestatus" method="post">
                              <input type="hidden" id="staffLeaveRequisitionId" name="staffLeaveRequisitionId">
                                <input type="hidden" id="approverComment" name="approverComment">
                               <input type="hidden" id="staffLeaveRequisitionStatus" name="staffLeaveRequisitionStatus">
                                 <button type="button" id="confirmation-approved" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                      
                     </div>
                  </div>
               </div>
            </div>
            
                
             <div class="modal fade" id="movementconfirm-rejected" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to Reject this Approvals ??</h5>
                     </div>
                     <div class="modal-footer">
                       <form id="rejectedMovementRequisition" action="${pageContext.request.contextPath}/staff/approvals/updatestatus" method="post">
                             <!--  <input type="hidden" id="staffLeaveRequisitionId" name="staffLeaveRequisitionId">
                               <input type="hidden" id="staffLeaveRequisitionStatus" name="staffLeaveRequisitionStatus"> -->
                              <button type="button" id="movementconfirmation-rejected" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                     
                     </div>
                  </div>
               </div>
            </div>
            
            <div class="modal fade" id="movementconfirm-approved" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to Accept this Approvals ??</h5>
                     </div>
                     <div class="modal-footer">
                       <form id="approvedMovementRequisition" action="${pageContext.request.contextPath}/staff/approvals/staffMovement/updatestatus" method="post">
                              <input type="hidden" id="staffMovementRequisitionId" name="staffMovementRequisitionId">
                               <input type="hidden" id="staffMovementRequisitionStatus" name="staffMovementRequisitionStatus">
                                  <input type="hidden" id="staffMovementApproverComment" name="staffMovementApproverComment">
                              
                                 <button type="button" id="movementconfirmation-approved" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                      
                     </div>
                  </div>
               </div>
            </div>
            
            
                <div class="modal fade" id="tcconfirm-rejected" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to Reject this Approvals ??</h5>
                     </div>
                     <div class="modal-footer">
                       <form id="rejectedTCRequisition" action="${pageContext.request.contextPath}/staff/approvals/updatestatus" method="post">
                              <button type="button" id="tcconfirmation-rejected" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                     
                     </div>
                  </div>
               </div>
            </div>
            
            <div class="modal fade" id="tcconfirm-approved" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to Accept this Approvals ??</h5>
                     </div>
                     <div class="modal-footer">
                       <form id="approvedTCRequisition" action="${pageContext.request.contextPath}/staff/approvals/transfercertificate/updatestatus" method="post">
                              <input type="hidden" id="tcRequisitionId" name="tcRequisitionId">
                                <input type="hidden" id="tcApproverComment" name="tcApproverComment">
                               <input type="hidden" id="tcRequisitionStatus" name="tcRequisitionStatus">
                                 <button type="button" id="tcconfirmation-approved" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                      
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
      
      <script src="${pageContext.request.contextPath}/resources/themes/script/approvals.js" type="text/javascript"></script>
     <script src="${pageContext.request.contextPath}/resources/themes/script/geographicallocation.js"></script>
     
   </body>
</html>