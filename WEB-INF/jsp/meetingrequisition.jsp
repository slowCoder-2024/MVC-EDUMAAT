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
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Meeting Requisition</b></h4>
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
                              <tbody id="meetingRequisitionsList">
                              		<c:if test="${!empty meetingRequisitions}">
                                      <c:forEach items="${meetingRequisitions}" var="meetingRequisition">
                                      		<tr >
		                                  	 <td><fmt:formatDate pattern="dd/MM/yyyy" value="${meetingRequisition.getCreatedDate()}" /></td>
		                                    <td>${meetingRequisition.getRequestReason()}</td>
		                                    <td>${meetingRequisition.getStartTime() }</td>
		                                    <td>${meetingRequisition.getEndTime() }</td>
		                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${meetingRequisition.getRequisitionDate()}" /></td>
		                                    <c:if test="${meetingRequisition.getApprovalStatus()=='Pending'}">
		                                    		<td ><span class="label label-table label-danger">
		                                              ${meetingRequisition.getApprovalStatus()}
		                                              </span>
		                                    </td>
		                                    </c:if>
		                                    <td>
		                                    	<a href="#" id="meetingCancel"  type="button" data-href="#" data-id="${meetingRequisition.getMeetingRequisitionId()}" data-toggle="modal" data-target="#meetingCancelConfirmation">
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
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Meeting Requisition Status</b></h4>
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
                              <tbody id="meetingRequestApprovedAndRejectedList">
                              	<c:if test="${!empty meetingRequisitionApprovedAndRejectedLists}">
                                      <c:forEach items="${meetingRequisitionApprovedAndRejectedLists}" var="meetingRequisitionApprovedAndRejectedList">
                                      		<tr >
                                      		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${meetingRequisitionApprovedAndRejectedList.getCreatedDate()}" /></td>
		                                    <td>${meetingRequisitionApprovedAndRejectedList.getRequestReason()}</td>
		                                    <td>${meetingRequisitionApprovedAndRejectedList.getStartTime() }</td>
		                                    <td>${meetingRequisitionApprovedAndRejectedList.getEndTime() }</td>
		                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${meetingRequisitionApprovedAndRejectedList.getRequisitionDate()}" /></td>
		                                    <td>${meetingRequisitionApprovedAndRejectedList.getApproverComment()}</td>
		                                    <c:if test="${meetingRequisitionApprovedAndRejectedList.getApprovalStatus()=='Approved'}">
		                                    		<td ><span class="label label-table label-success">
		                                              ${meetingRequisitionApprovedAndRejectedList.getApprovalStatus()}
		                                              </span>
		                                    </td>
		                                    </c:if>
		                                  <c:if test="${meetingRequisitionApprovedAndRejectedList.getApprovalStatus()=='Rejected'}">
		                                    		<td ><span class="label label-table label-danger">
		                                              ${meetingRequisitionApprovedAndRejectedList.getApprovalStatus()}
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
           
            
             <div class="modal fade" id="meetingCancelConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
		               <div class="modal-dialog" role="document">
		                  <div class="modal-content">
		                     <div class="modal-header">
		                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
		                     </div>
		                     <div class="modal-body">
		                        <h5>Are you sure ?, You want to cancel your Requisition??</h5>
		                     </div>
		                     <div class="modal-footer">
		                       <form id="cancelmeetingform" action="${pageContext.request.contextPath}/staff/requisition/meetingRequest/cancel" method="post">
                              <input type="hidden" id="meetingRequisitionId" name="meetingRequisitionId">
                                 <button type="button" id="meetingCancelConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
		                   </form>
		                     </div>
		                  </div>
		               </div>
                </div>
            
         
             <div class="modal fade" id="addRequisitionConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want Request For Requisition ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="addRequisitionConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
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
                                         <c:if test="${requisitionType.getRequisitionTypeId()=='4'}">
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
                    <div id="meetingrequisition" style="display:none;">
                   <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-primary">
                              <div class="panel-heading">
                                  <h4 class="panel-title"><b>Meeting Requisition</b></h4>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                       <form class="form-horizontal" id="addMeetingRequisitionForm" action="${pageContext.request.contextPath}/staff/requisition/meetingRequest" method="post">
                 <input type="hidden" id="selectedMeetingRequisitionTypeId" name="selectedMeetingRequisitionTypeId">
                              
                       
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Requisition Date<span class="at-required-highlight">*</span> </label> 
                                 <div class="col-sm-7"> 
                                       <input type="text"  class="form-control" id="meetingRequisitionDate" name="meetingRequisitionDate" placeholder="" required="required">
                                 </div>
                                </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">fromTime<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="fromTime" class="form-control timedropper" id="fromTime" required="required">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">toTime<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="toTime" class="form-control timedropper" id="toTime" required="required">
                                 </div>
                              </div>
                            
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reason<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="meetingRequisitionReason" class="form-control" id="meetingRequisitionReason" placeholder="" required="required">
                                 </div>
                              </div>
                                <div class="row">
                                  <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                               
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="button" id="addMeetingRequisition" class="btn btn-success btn-custom waves-effect waves-light">Request</button>
                                   
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
                              <div id="bookingfacilityrequisition" style="display:none;">
                               <br>
                <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br>
                                       <h4>Facility Booking Request</h4> 
				<form class="form-horizontal" id="addStaffFacilityRequisitionForm">
                             
                               <!--  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Building Type</label> 
                                 <div class="col-sm-7"> 
                                   <select name="selector1" id="selector1" class="selectpicker" data-live-search="true"  data-style="btn-white">
                                       <option value="" disabled selected>Select Type</option>
                                       <option>Block A</option>
                                       <option>Block B</option>
                                    </select>
                                 </div>
                              </div> -->
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Facility Category</label> 
                                 <div class="col-sm-7">
                                    <select name="selector1" id="selector1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Category</option>
                                             <option>Academic</option>
                                       <option>Non-Academic</option>
                                      
                                    </select>
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Facility Type</label> 
                                 <div class="col-sm-7">
                                    <select name="selector2" id="selector2" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Type</option>
                                         <option>Lab</option>
                                       <option>Class Room</option>
                                    </select>
                                 </div>
                              </div>
                              
                          <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Facility No</label> 
                                 <div class="col-sm-7"> 
                                 
											
												<input class="form-control" type="text" id="fno"placeholder="" required="required">
											
                                 </div>
                              </div>
                
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Facility Name</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="name1" name="fname"placeholder="" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> No Of Seats</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="noofseats" name="noofseats" placeholder="" required="required">
                                 </div>
                              </div>
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Start Date And End Date </label> 
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="date" class="form-control" id="1" placeholder="From"  name="fstart"required="required">
                                 </div>
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="date" class="form-control" id="2" placeholder="To" name="fend"required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Start Time And End Time </label> 
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="time" class="form-control" id="3" placeholder="From" name="ftimestart"required="required">
                                 </div>
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="time" class="form-control" id="4" placeholder="To" name="ftimeend"required="required">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reason</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="reason" placeholder="" name="freason" required="required">
                                 </div>
                              </div>
                              
                      
                                 <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Upload File</label>
                                       <div class="col-sm-7">
                                          <input type="file" id="exampleInputFile" name="f_file"required="required"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                              
                                       
                           
                                <div class="row">
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="submit" id="addStaffFacilityRequisition" class="btn btn-success btn-custom waves-effect waves-light">Request</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                                          </div>
                              </div>
                              </form>
                             </div>
                              <div id="purchaserequisition" style="display:none;">
                               <br>
                <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br>
                              <h4>Purchase Requisition</h4> 
                           
                               
                              <form class="form-horizontal" id="addStaffPurchaseRequisitionForm">
                          <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Item Group</label> 
                                 <div class="col-sm-7"> 
                                 
											
												<input class="form-control" type="text" placeholder="" name="p_item_group" required="required">
											
                                 </div>
                              </div>
              
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Item Name</label> 
                                 <div class="col-sm-7"> 
                                 
											
												<input class="form-control" type="text" placeholder="" name="p_item_name" required="required">
											
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Quantity</label> 
                                 <div class="col-sm-7"> 
                                 
											
												<input class="form-control" type="text" placeholder="" name="p_qty"required="required">
											
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">When Required?</label> 
                                 <div class="col-sm-7"> 
                                 
								 
                                
                                    <input type="date" class="form-control" id="rqd" placeholder="" name="p_required" required="required">
                              
                               
                              </div>
											
                                 </div>
                             
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reason</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="p_reason" name="p_reason" placeholder="" required="required">
                                 </div>
                              </div>
                              
                      
                                 <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Upload File</label>
                                       <div class="col-sm-7">
                                          <input type="file" id="exampleInputFile" required="required" name="p_file"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                              
                                 
                                <div class="row">
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="submit" id="addStaffPurchaseRequisition" class="btn btn-success btn-custom waves-effect waves-light">Request</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                                          </div>
                                                          
                              </div>
                            </form>
                              </div>
                               <div id="travelrequisition" style="display:none;">
                                <br>
                <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br>
                              <h4>Travel Requisition</h4>   
                              <form class="form-horizontal" id="addStaffTravelRequisitionForm">
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Travel Type</label> 
                                 <div class="col-sm-7"> 
                                  <select name="selector1" id="selector1" class="selectpicker" data-live-search="true"  data-style="btn-white" name="t_type"required="required">
                                    <option value="" disabled selected>Select Type </option>
                                          
                                             </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Start Date And End Date </label> 
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="date" class="form-control" id="" placeholder="From" name="t_start"required="required">
                                 </div>
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="date" class="form-control" id="" placeholder="To" name="t_end"required="required">
                                 </div>
                              </div>
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Start Time And End Time </label> 
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="time" class="form-control" id="" placeholder="From" name="t_start_time"required="required">
                                 </div>
                                 <div class="col-md-3 col-sm-3 col-xs-12"> 
                                    <input type="time" class="form-control" id="" placeholder="To" name="t_end_time"required="required">
                                 </div>
                              </div>
                             
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Travel Mode</label> 
                                 <div class="col-sm-7"> 
                                   <select  id="selector6" class="selectpicker" data-live-search="true"  data-style="btn-white" name="travel_mode"required="required">
                                    <option value="" disabled selected>Select Type </option>
                                          
                                             </select>
                                 </div>
                              </div>
                       <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reason</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="" placeholder="" name="t_reason"required="required">
                                 </div>
                              </div>
                                 <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="exampleInputFile">Upload File</label>
                                       <div class="col-sm-7">
                                          <input type="file" id="exampleInputFile" name="t_file"required="required"> 
                                          <p class="help-block">Example block-level help text here.</p>
                                       </div>
                                    </div>
                              
                                 
                                   
                                    
                        
                          
                                   
                             
                              
                               
                                    
                            
                           
                                <div class="row">
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right"  type="submit" id="addStaffTravelRequisition" class="btn btn-success btn-custom waves-effect waves-light">Request</button>
                                   
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                                          </div>
                              </div>
                              </form>
                              </div>
                      
       
                    
            </div>
            <div id="EditFormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">View Details</h3>
                     <br />
                     <br />
                     <br />
                         <div class="col-md-8 compose-right widget-shadow">
					<div class="panel-default">
					
						<div class="panel-body">
							<div class="alert alert-info">
								No Available
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
      
       <script src="${pageContext.request.contextPath}/resources/themes/script/meetingrequisition.js" type="text/javascript"></script>
     <script type="text/javascript">
  
    TableManageButtons.init();

</script>
   </body>
</html>