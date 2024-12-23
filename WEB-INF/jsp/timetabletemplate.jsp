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
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.11.2.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.7.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/modernizr.min.js"></script>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/edumaatalert/edumaatalert.css"/>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/timepicker/bootstrap-timepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/clockpicker/css/bootstrap-clockpicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/timedropper.js"></script> 
         <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/js/datepicker/css/timedropper.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/js/datepicker/css/timedropper.min.css">
      
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
        
        .dismiss {
    padding: 15px;
    margin-bottom: -20px;
    border: 1px solid transparent;
    border-radius: 4px;
}
        
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
              <security:authorize access="hasRole('timetabletemplate/add')">
                  <div class="form-group">
                     <button type="button" class="btn btn-primary btn-custom waves-effect waves-light col-md-3" onclick="showTimeTableTemplateDiv()">Add New Time Table Template</button>
                  </div>
                 
                  <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div> 	
                  </security:authorize>
                  <br />
                   <security:authorize access="hasRole('timetabletemplate/viewlist')">
         <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Time Table Template</b></h4>
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
                                          <th>Time Table Template Id</th>
                                          <th>Time Table Template Name</th>
                                          <security:authorize access="hasAnyRole('timetabletemplate/view','timetabletemplate/delete')">
                                          <th>Action</th>
                                           </security:authorize>
                                       </tr>
                                    </thead>
                                    <tbody id="timeTableTemplateList">
                                       <c:if test="${!empty timeTableTemplateList}">
                                          <c:forEach items="${timeTableTemplateList}" var="timeTableTemplateList">
                                             <tr>
                                                <td>${timeTableTemplateList.getTimeTableTemplateId()}</td>
                                                <td>${timeTableTemplateList.getTimeTableName()}</td>
                                                   <security:authorize access="hasAnyRole('timetabletemplate/view','gradetemplate/delete')">
                                                <td>
                                                 <security:authorize access="hasRole('timetabletemplate/view')">
                                                   <a href="#" id="edit"  type="button"data-href="#" data-id="${timeTableTemplateList.getTimeTableTemplateId()}" data-toggle="modal" onclick="editTimeTableTemplateDiv()">
                                                    <i class="fa fa-pencil" style="margin-right: 15px"></i>
                                                   </a>
                                                   </security:authorize>
                                                    <security:authorize access="hasRole('timetabletemplate/delete')">
                                                   <a href="#"  id="delete"  type="button" data-href="#"  data-id="${timeTableTemplateList.getTimeTableTemplateId()}" data-toggle="modal" data-target="#confirm_delete_timeTableTemplate">
                                                  <i class="fa fa-trash-o"></i>
                                                   </a>
                                                   </security:authorize>
                                                </td>
                                                </security:authorize>
                                             </tr>
                                          </c:forEach>
                                       </c:if>
                                    </tbody>
                                 </table>
                              </div>
                       </div>
                        </div>
                         	</security:authorize>
               </div>
                <div class="modal fade" id="confirm_delete_timeTableTemplate" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                           <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                 <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                                 </div>
                                 <div class="modal-body">
                                    <h5>Are you sure you want to delete this time table template?</h5>
                                 </div>
                                  <div class="modal-footer">
                                 <form id="deleteTimeTableTemplateForm" action="${pageContext.request.contextPath}/timetable/template/delete" method="post">
                              <input type="hidden" id="deleteTimeTableTemplateId" name="deleteTimeTableTemplateId">
                              <button type="button" id="confirmDeleteTimeTableTemplate"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                           </div>
                              </div>
                           </div>
                        </div>
               <div id="TimeTableTemplateDiv" style="display:none;">
                      
                            <h4 class="m-t-0 header-title" style="color:purple;"><b>Create Time Table Template</b></h4>
                              
                                
                             
                             <div class="row" >
                       <br>
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="timeTableTemplateForm" action="${pageContext.request.contextPath}/timetable/template/add" method="post">
                    
                                      <ul id="myTabs" class="nav nav-tabs" role="tablist">
      <li role="presentation" class="active"><a href="#timetabletemplate-information" id="timetabletemplate-information-tab" role="tab" data-toggle="tab" aria-controls="timetabletemplate-information" aria-expanded="true"><i class="fa fa fa-table" aria-hidden="true"></i>
      Time Table Template Information</a></li>
      <li role="presentation" class=""><a href="#timetabletemplatedays-information" role="tab" id="timetabletemplatedays-information-tab" data-toggle="tab" aria-controls="timetabletemplatedays-information" aria-expanded="false"><i class="fa fa-calendar-plus-o" aria-hidden="true"></i>
      Time Table Days Information</a></li>
      <li role="presentation" class=""><a href="#timetabletemplatehours-information" role="tab" id="timetabletemplatehours-information-tab" data-toggle="tab" aria-controls="timetabletemplatehours-information" aria-expanded="false"><i class="fa fa-hourglass-2" aria-hidden="true"></i>
      Time Table Hours Information</a></li>
   </ul>
                        
                           <div id="myTabContent" class="tab-content">
      <div role="tabpanel" class="tab-pane fade active in" id="timetabletemplate-information" aria-labelledby="timetabletemplate-information-tab">
      <br>
				<div class="dismiss">
                          
                	
                            <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Time Table Template Name <span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-6"> 
                                 <input type="text" name="timeTableTemplateName" class="form-control" id="timeTableTemplateName" required="required" maxlength="150">
                              </div>
                               </div>
                              
                                <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                     <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
                           </div>
      </div>
      <div role="tabpanel" class="tab-pane fade" id="timetabletemplatedays-information" aria-labelledby="timetabletemplatedays-information-tab">
      <br>
                 <div id="timeTableDay1"> 
                                      <div class="dismiss">
                                      <div class="form-group">
                                    <div  class="col-sm-offset-3"> 
                                 <button style="float:right"  type="button" id="addTimeTableDay" class="btn btn-success btn-custom waves-effect waves-light" > <i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp;Add Time Table Day</button>
                                </div>
                                 
                              </div>
                            
                                       
                                        <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Day Name <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6"> 
                                  <select name="timeTableDay1dayName1" id="timeTableDay1dayName1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Day</option>
                                             <option value="Sunday">Sunday</option>
                                             <option value="Monday">Monday</option>
												 <option value="Tuesday">Tuesday</option>
												  <option value="Wednesday">Wednesday</option>
                                             <option value="Thursday">Thursday</option>
												 <option value="Friday">Friday</option>
												  <option value="Saturday">Saturday</option>
                                          </select>                                 
                                          </div>
                              </div>
                             
                          </div>
                           
                           
                          </div>
                          <div class="Days">
                          </div>
                          <br>
                          <div class="row">
                          
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                   <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
      </div>
   
      <div role="tabpanel" class="tab-pane fade" id="timetabletemplatehours-information" aria-labelledby="timetabletemplatehours-information-tab">
      <br>
      
      <div id="timeTableHour1">
                          <div class="dismiss">
                          <div class="form-group">
                                    <div class="col-sm-offset-3"> 
                              <button style="float:right"  type="button" id="addHour" class="btn btn-success btn-custom waves-effect waves-light"><i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp;Add Hour</button>    </div>
                              </div>
                          
                      
                	
                            
                            <div class="form-group ">
                            <label for="" class="col-sm-3 control-label">Hour Name <span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-6"> 
                                 <input type="text" name="timeTableHour1hourName1" class="form-control" id="timeTableHour1hourName1" required="required" maxlength="150">
                              </div> 
                              </div>
                               <div class="form-group ">
                            <label for="" class="col-sm-3 control-label">Hour Start Time <span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-6"> 
                                 <input type="text" name="timeTableHour1startTime1" class="form-control timedropper" id="timeTableHour1startTime1" required="required" maxlength="50">
                              </div> 
                              </div>
                               <div class="form-group ">
                            <label for="" class="col-sm-3 control-label">Hour End Time <span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-6"> 
                                 <input type="text" name="timeTableHour1endTime1" class="form-control timedropper" id="timeTableHour1endTime1" required="required" maxlength="50">
                              </div> 
                              </div>
                              
                           
                                </div>
						
      
      </div>
       <div class="Hours">
                          </div>
                          <input id="timeTableDayIds" name="timeTableDayIds" type="hidden">
                            <input id="timeTableHourIds" name="timeTableHourIds" type="hidden">
                          
			
   <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="timeTableTemplateSave"  class="btn btn-success btn-custom waves-effect waves-light">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                    <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                    </div>
                              </div>
      
   </div>
                        
                        </div>
                    
                    
                    
                    
                    
                           
                           </form>
                        </div>
                        
                     
                  </div>
                 
               </div>
              
               <div id="EditTimeTableTemplateDiv" style="display:none;">
                           <div class="row">
                        <div class="col-lg-12">
                           
                              
                                 
                                  <form class="form-horizontal" action="${pageContext.request.contextPath}/timetable/template/update" method="post" id="updateTimeTableTemplateForm">
                            
                             <ul id="myTabs" class="nav nav-tabs" role="tablist">
      <li role="presentation" class="active"><a href="#edittimetabletemplate-information" id="edittimetabletemplate-information-tab" role="tab" data-toggle="tab" aria-controls="edittimetabletemplate-information" aria-expanded="true"><i class="fa fa fa-table" aria-hidden="true"></i>
      Time Table Template Information</a></li>
      <li role="presentation" class=""><a href="#edittimetabletemplatedays-information" role="tab" id="edittimetabletemplatedays-information-tab" data-toggle="tab" aria-controls="edittimetabletemplatedays-information" aria-expanded="false"><i class="fa fa-calendar-plus-o" aria-hidden="true"></i>
      Time Table Days Information</a></li>
      <li role="presentation" class=""><a href="#edittimetabletemplatehours-information" role="tab" id="edittimetabletemplatehours-information-tab" data-toggle="tab" aria-controls="edittimetabletemplatehours-information" aria-expanded="false"><i class="fa fa-hourglass-2" aria-hidden="true"></i>
      Time Table Hours Information</a></li>
   </ul>
                        
                           <div id="editmyTabContent" class="tab-content">
      <div role="tabpanel" class="tab-pane fade active in" id="edittimetabletemplate-information" aria-labelledby="edittimetabletemplate-information-tab">
      <br>
				<div class="dismiss">
                        
                	
                            <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Time Table Template Name <span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-6"> 
                                 <input type="text" name="edittimeTableTemplateName" class="form-control" id="edittimeTableTemplateName" required="required" maxlength="150">
                              </div>
                               </div>
                              
                                <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                      <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
                           </div>
      </div>
      <div role="tabpanel" class="tab-pane fade" id="edittimetabletemplatedays-information" aria-labelledby="edittimetabletemplatedays-information-tab">
      <br>
           <div class="dismiss">
      		 <div class="form-group">
                                    <div class="col-sm-offset-3"> 
                                 <button style="float:right"  type="button" id="editaddTimeTableDay" class="btn btn-success btn-custom waves-effect waves-light" > <i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp;Add Time Table Day</button>
                                  </div>
                              </div>
                              </div>
              
                          <div class="editDays">
                          </div>
                          <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                       <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
      </div>
   
      <div role="tabpanel" class="tab-pane fade" id="edittimetabletemplatehours-information" aria-labelledby="edittimetabletemplatehours-information-tab">
      <br>
       <div class="dismiss">
                          <div class="form-group">
                                    <div  class="col-sm-offset-3"> 
                              <button style="float:right"  type="button" id="editaddHour" class="btn btn-success btn-custom waves-effect waves-light"><i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp;Add Hour</button>    </div>
                              </div>
                               </div>
     	
       <div class="editHours">
                          </div>
                          <input id="edittimeTableDayIds" name="edittimeTableDayIds" type="hidden">
                            <input id="edittimeTableHourIds" name="edittimeTableHourIds" type="hidden">
                        
                             <input type="hidden" id="updatetimeTableTemplateId" name="updatetimeTableTemplateId">
                                 
						<div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                <%--   <security:authorize access="hasRole('timetabletemplate/update')">
                          
                                        <a href="#" id="updateTimeTableTemplate" style="float:right" class="btn btn-success btn-custom waves-effect waves-light" type="submit" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>     
                                    			</security:authorize> --%>
 
                               <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
     
   </div>
                        
                        </div>

                             </form>
                          
                        
                     </div>
                  </div>
               </div>
                <div class="modal fade" id="timeTableTemplateSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure you want to add this time table template ?</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="timeTableTemplateSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                     </div>
                  </div>
                <div class="modal fade" id="timeTableTemplateUpdateConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure you want to update this time table template ?</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="timeTableTemplateUpdateConfirm" id="timeTableTemplateUpdateConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
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


  <script src="${pageContext.request.contextPath}/resources/themes/assets/js/bootstrap3.3.4.js"> </script>

 <script src="${pageContext.request.contextPath}/resources/edumaatalert/edumaatalert.js"></script>
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
       <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/moment/moment.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/timepicker/bootstrap-timepicker.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/clockpicker/js/bootstrap-clockpicker.min.js"></script>
     	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/jquery.form-pickers.init.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-validation/js/jquery.validate.min.js"></script>
       <script src="${pageContext.request.contextPath}/resources/themes/script/timeTableTemplate.js" type="text/javascript"></script> 
    
   </body>
</html>

