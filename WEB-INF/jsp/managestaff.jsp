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
      <!--//Metis Menu -->
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
                  <button type="button" class="btn btn-primary btn-custom waves-effect waves-light col-md-3" onclick="showDiv()">Add New Staff</button>
               </div>
               <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
               		     <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Staff</b></h4>
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
                                   	<th>Staff Code</th>
                               		<th>Staff Name</th>
                               		<th>Staff Type</th>
                               		<th>Staff Designation</th>
                               		<th>Staff Status</th>
                                  	<th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="teachingstafflist" >
                              		 <c:if test="${!empty staffs}">
		                                   <c:forEach items="${staffs}" var="staff">
		                                       	 <tr >
				                                  	<td>${staff.getStaffCode()}</td>
				                                    <td>${staff.getFirstName()} ${staff.getLastName()}</td>
				                                    <td>${staff.getStaffType().getStaffTypeName()}</td>
				                                    <td>${staff.getStaffDesignation().getStaffDesignationName()}</td>
				                                    <td>
				                                    	<c:if test="${staff.getStatus()==0}">In Active</c:if> 
					                                    <c:if test="${staff.getStatus()==1}">Active</c:if> 
					                                </td>
				                                   <td>
				                                    	<a href="#" id="edit"  type="button"data-href="#" data-id="${staff.getStaffId()}" data-toggle="modal" onclick="showeditDiv()">
				                                    	<i class="fa fa-pencil" style="margin-right: 15px"></i>
				                                    	</a>
				                                   		 <a href="#"  id="delete"  type="button" data-href="#"  data-id="${staff.getStaffId()}" data-toggle="modal" data-target="#deletestaffconfirmation">
				                                    			<i class="fa fa-trash-o"></i>
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
            <div class="modal fade" id="deletestaffconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure you want to delete this staff ?</h5>
                     </div>
                     <div class="modal-footer">
                      <form id="deletestaffform" action="${pageContext.request.contextPath}/staff/delete" method="post">
                              <input type="hidden" id="deleteStaffId" name="deleteStaffId">
                              <button type="button" id="confirmdeletestaff"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                           </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="staffsaveconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure you want to add this staff ?</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" id="staffsaveconfirm" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
                   <div class="modal fade" id="staffUpdateConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                      <h5>Are you sure you want to update this staff ?</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" name="staffUpdateConfirm" id="staffUpdateConfirm" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Staff</h3>
                     <div class="form-three widget-shadow">
     
                   <form class="form-horizontal" id="addstaffform" action="${pageContext.request.contextPath}/staff/add" method="post" enctype="multipart/form-data">
   
   <ul id="myTabs" class="nav nav-tabs" role="tablist">
      <li role="presentation" class="active"><a href="#personal-information" id="personal-information-tab" role="tab" data-toggle="tab" aria-controls="personal-information" aria-expanded="true"><i class="fa fa-user" aria-hidden="true"></i>
      Personal Information</a></li>
      <li role="presentation" class=""><a href="#contact-information" role="tab" id="contact-information-tab" data-toggle="tab" aria-controls="contact-information" aria-expanded="false"><i class="fa fa-tty" aria-hidden="true"></i>
      Contact Information</a></li>
      <li role="presentation" class=""><a href="#account-information" role="tab" id="account-information-tab" data-toggle="tab" aria-controls="account-information" aria-expanded="false"><i class="fa fa-credit-card-alt" aria-hidden="true"></i>
      Account Information</a></li>
      <li role="presentation" class=""><a href="#academic-information" role="tab" id="academic-information-tab" data-toggle="tab" aria-controls="academic-information" aria-expanded="false"><i class="fa fa-university nav_icon"></i>Academic Information</a></li>
            <li role="presentation" class=""><a href="#experience-information" role="tab" id="experience-information-tab" data-toggle="tab" aria-controls="experience-information" aria-expanded="false"><i class="fa fa-shield" aria-hidden="true"></i>
            Experience Information</a></li>
      <li role="presentation" class=""><a href="#other-information" role="tab" id="other-information-tab" data-toggle="tab" aria-controls="other-information" aria-expanded="false"><i class="fa fa-info" aria-hidden="true"></i>
      Other Information</a></li>
   </ul>
   <div id="myTabContent" class="tab-content">
      <div role="tabpanel" class="tab-pane fade active in" id="personal-information" aria-labelledby="personal-information-tab">
      <br>
      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">First Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="staffFirstName" class="form-control" id="staffFirstName" placeholder="" required="required" maxlength="100" >
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Last Name</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="staffLastName" class="form-control" id="staffLastName" placeholder="" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian First Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="staffParentOrGuardianFirstName" class="form-control" id="staffParentOrGuardianFirstName" placeholder="" maxlength="100" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian Last Name</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="staffParentOrGuardianLastName" class="form-control" id="staffParentOrGuardianLastName" placeholder="" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Gender<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                          <select name="staffGender" id="staffGender" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Gender</option>
                                             <option value="Male">Male</option>
                                             <option value="Female">Female</option>
                                             <option value="Others">Others</option>
                                          </select>
                                       </div>
                              </div>
                              
                             
                               
                               
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Date of Birth<span class="at-required-highlight">*</span></label> 
                                <div class="col-sm-7"> 
                                          <input type="text" name="staffDOB" class="form-control form-control-birth-datepicker" id="staffDOB" placeholder="" required="required">
                                       </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="email" name="staffEmail" class="form-control" id="staffEmail" placeholder="" required="required" autocomplete="off" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Mobile No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="staffContact" class="form-control" id="staffContact" placeholder="" onkeypress="return isNumber(event)" maxlength="20" required="required">
                                 </div>
                              </div>
                             <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Category<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="categoryId" id="categoryId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                          			<option value="" disabled selected>Select Category </option>
	                                          	<c:if test="${!empty categories}">
		                                       		<c:forEach items="${categories}" var="category">
		                                       			<option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div> 
                                    <div class="form-group">
                                 <label for="studentProfilePic" class="col-sm-3 control-label">Photo</label> 
                                 <div class="col-sm-7">
                                    <input  class="filestyle" data-size="md" name="staffProfilePic" id="staffProfilePic" type="file" maxlength="225"/>
                                    <br>
                                    <div class="viewimage1" >
                                    
                                    </div>
                                 </div>
                              </div>
                               <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                     <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
      
  
      </div>
      <div role="tabpanel" class="tab-pane fade" id="contact-information" aria-labelledby="contact-information-tab">
      <br>
        <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 1<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="staffAddressLine1" class="form-control" id="staffAddressLine1" placeholder="" required="required" maxlength="225">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 2<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="staffAddressLine2" class="form-control" id="staffAddressLine2" placeholder="" required="required" maxlength="225">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                         <%--  <select name="staffCountry" id="geographicallocation" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Country </option>
                                             <c:if test="${!empty countries}">
		                                       		<c:forEach items="${countries}" var="country">
		                                       			<option value="${country.getName()}">${country.getName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select> --%>
                                                <input type="text" name="staffCountry" class="form-control" id="geographicallocation" placeholder="" required="required" maxlength="225">
                        
                                       </div>
                                    </div>      
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">State<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                        <!--   <select name="staffState" id="geographicallocationstate" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>No Country Selected</option>
                                          </select> -->
                                                      <input type="text" name="staffState" class="form-control" id="geographicallocationstate" placeholder="" required="required" maxlength="225">
                        
                                       </div>
                                    </div> 
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">City<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                         <!--  <select name="staffCity" id="geographicallocationcity" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>No State Selected</option>
                                          </select> -->
                                                      <input type="text" name="staffCity" class="form-control" id="geographicallocationcity" placeholder="" required="required" maxlength="225">
                        
                                       </div>
                                    </div>      
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Post Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="staffPostCode" class="form-control" id="staffPostCode" placeholder="" maxlength="6" required="required" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              
                               <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                     <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
      
     
      
      </div>
      <div role="tabpanel" class="tab-pane fade" id="account-information" aria-labelledby="account-information-tab"><br>
      
      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Name</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="staffBankName" class="form-control" id="staffBankName" placeholder="" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Account No</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="staffBankAccountNo" class="form-control" id="staffBankAccountNo" placeholder="" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank IFSC Code</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="staffBankIFSC" class="form-control" id="staffBankIFSC" placeholder="" maxlength="100">
                                 </div>
                              </div>
       <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                     <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
      
     
      </div>
      <div role="tabpanel" class="tab-pane fade" id="academic-information" aria-labelledby="academic-information-tab">
      <br>
              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Staff Type<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="staffTypeId" id="staffTypeId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Type</option>
                                             <c:if test="${!empty staffTypes}">
		                                       		<c:forEach items="${staffTypes}" var="staffType">
		                                       			<option value="${staffType.getStaffTypeId()}">${staffType.getStaffTypeName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                     
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Staff Designation<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                          
                          
                          
                                          <select name="staffDesignationId" id="staffDesignationId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Designation</option>
                                             
                                          </select>
                                       </div>
                                    </div>
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Staff Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                 		<input class="form-control" name="staffCode" id="staffCode" type="text" placeholder="" maxlength="50" required="required">
								 </div>
                              </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Approver<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="approverId" id="approverId" class="selectpicker" data-live-search="true"   data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Approver</option>
                                             <!-- <option value="0">Self Approver</option> -->
                                             <c:if test="${!empty approvers}">
		                                       		<c:forEach items="${approvers}" var="approver">
		                                       			<option value="${approver.getUserId()}" >${approver.getName()}  [${approver.getEmail()}]</option>
		                                        	</c:forEach>
	                                       	</c:if>
                                          </select>
                                       </div>
                                     </div>
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">User Role<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="userRoleId" id="userRoleId" class="selectpicker" data-live-search="true"   data-style="btn-white"   required="required" style="width: 585px">
                                   		     <c:if test="${!empty userRoles}">
		                                       		<c:forEach items="${userRoles}" var="userRole">
		                                       			<option value="${userRole.getRoleId()}" >${userRole.getRoleName()}</option>
		                                        	</c:forEach>
	                                       	</c:if>
                                            </select>
                                       </div>
                                     </div>
                                     
                                   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Access No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                 		<input class="form-control" name="staffAccessId" id="staffAccessId" type="text" placeholder="" maxlength="50" required="required">
								 </div>
                              </div>
                               
                                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Joined date</label> 
                                 <div class="col-sm-7"> 
                                     <input type="text" name="staffJoinedDate" class="form-control form-control-datepicker" id="staffJoinedDate" placeholder="">
                                 </div>
                                 </div>
                                 <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                
                                     <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
       
    
      
      </div>
      <div role="tabpanel" class="tab-pane fade" id="experience-information" aria-labelledby="experience-information-tab">
      <br>
   
                 <div class="alert alert-info" role="alert" style="display: block">
						<strong>Info!</strong>&nbsp;You want to add your experience details, Please click "Add More Experience Details" button.
						
					</div>          
                          
      <div class="experiencedetails" id="experiencedetails">
      </div>
      

       <br>
               <div class="row" id="expdelete">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="button" class="btn btn-success btn-custom waves-effect waves-light btnAdd">Add More Experience Details</button>
                                  <button style="float:right" type="button" class="btn btn-danger btn-custom waves-effect waves-light btnDel">Delete Experience</button>
                                      <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
                                 
                                    
                           
      
      
      </div>
      <div role="tabpanel" class="tab-pane fade" id="other-information" aria-labelledby="other-information-tab">
      <br>
      
      
       
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">PAN No</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="staffPANNo" class="form-control" id="staffPANNo" placeholder="" maxlength="50">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">PF Account No</label> 
                                       <div class="col-sm-7">
                                           <input type="text" name="staffPFAccountNo" class="form-control" id="staffPFAccountNo" placeholder="" maxlength="50">
                                       </div>
                                    </div>
                                <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Blood Group</label> 
                                       <div class="col-sm-7">
                                          <select name="staffBloodGroupId" id="staffBloodGroupId" class="selectpicker" data-live-search="true"  data-style="btn-white">
                                             <option value="" disabled selected>Select Blood Group</option>
                                             <c:if test="${!empty bloodGroups}">
		                                       		<c:forEach items="${bloodGroups}" var="bloodGroup">
		                                       			<option value="${bloodGroup.getBloodGroupId()}">${bloodGroup.getBloodGroupName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>    
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Staff Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="staffStatus" id="staffStatus" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
                                 </div>
                               </div>
                               
                                                              <div id="dynamicdocument" style="display: none;">
                                <input type="hidden" id="idforappending" name="idforappending">
     <input type="hidden" id="documenttypes" name="documenttypes">
                                </div>
                                                <div class="row">
                               <div class="col-sm-12">
                                 <div class="col-sm-offset-3">
                                 <button  style="float:right"  type="button" class="btn btn-success btn-custom waves-effect waves-light btnadd-document"><i class="fa fa-plus-circle" aria-hidden="true"></i></button>
                                 <button  style="float:right" type="button"  class="btn btn-danger btn-custom waves-effect waves-light btndel-document" disabled="disabled"><i class="fa fa-times-circle" aria-hidden="true"></i></button>     
                                 </div>
                              </div>
                                 </div>
                                 <br>
                             
                              <table class="table table-striped table-bordered" >
                                          <thead>
                                             <tr>
                                                <th>Document Type</th>
                                                <th>Upload Document</th>
                                             </tr>
                                          </thead>
                                          <tbody id="documentinfo">
                                             <tr id="clonedinputdocument" class="clonedinputdocument">
                                                
                                             </tr>
                                          </tbody>
                                       </table>
                         <br>
                                <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="button" id="savestaff" class="btn btn-success btn-custom waves-effect waves-light">Save</button>
                                     <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
      
      </div>
      
   </div>

    
       </form>
       <div class="clearfix"> </div>
                     </div>
                     
                  </div>
               </div>
            </div>
            
            <div id="EditFormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Edit Staff Details</h3>
                     <div class="form-three widget-shadow">
     
                   <form class="form-horizontal" id="updateStaffForm" action="${pageContext.request.contextPath}/staff/update" method="post" enctype="multipart/form-data">
   
   <ul id="myTabs" class="nav nav-tabs" role="tablist">
      <li role="presentation" class="active"><a href="#edit-personal-information" id="edit-personal-information-tab" role="tab" data-toggle="tab" aria-controls="edit-personal-information" aria-expanded="true"><i class="fa fa-user" aria-hidden="true"></i>
      Personal Information</a></li>
      <li role="presentation" class=""><a href="#edit-contact-information" role="tab" id="edit-contact-information-tab" data-toggle="tab" aria-controls="edit-contact-information" aria-expanded="false"><i class="fa fa-tty" aria-hidden="true"></i>
      Contact Information</a></li>
      <li role="presentation" class=""><a href="#edit-account-information" role="tab" id="edit-account-information-tab" data-toggle="tab" aria-controls="edit-account-information" aria-expanded="false"><i class="fa fa-credit-card-alt" aria-hidden="true"></i>
      Account Information</a></li>
      <li role="presentation" class=""><a href="#edit-academic-information" role="tab" id="edit-academic-information-tab" data-toggle="tab" aria-controls="edit-academic-information" aria-expanded="false"><i class="fa fa-university nav_icon"></i>Academic Information</a></li>
            <li role="presentation" class=""><a href="#edit-experience-information" role="tab" id="edit-experience-information-tab" data-toggle="tab" aria-controls="edit-experience-information" aria-expanded="false"><i class="fa fa-shield" aria-hidden="true"></i>
            Experience Information</a></li>
         
      <li role="presentation" class=""><a href="#edit-other-information" role="tab" id="edit-other-information-tab" data-toggle="tab" aria-controls="edit-other-information" aria-expanded="false"><i class="fa fa-info" aria-hidden="true"></i>
      Other Information</a></li>
   </ul>
   <div id="myTabContent" class="tab-content">
      <div role="tabpanel" class="tab-pane fade active in" id="edit-personal-information" aria-labelledby="edit-personal-information-tab">
      <br>
      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">First Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStaffFirstName" class="form-control" id="editStaffFirstName" placeholder="" required="required" maxlength="100" >
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Last Name</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStaffLastName" class="form-control" id="editStaffLastName" placeholder="" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian First Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStaffParentOrGuardianFirstName" class="form-control" id="editStaffParentOrGuardianFirstName" placeholder="" maxlength="100" required="required">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian Last Name</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStaffParentOrGuardianLastName" class="form-control" id="editStaffParentOrGuardianLastName" placeholder="" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Gender<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                          <select name="editStaffGender" id="editStaffGender" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Gender</option>
                                             <option value="Male">Male</option>
                                             <option value="Female">Female</option>
                                             <option value="Others">Others</option>
                                          </select>
                                       </div>
                              </div>
                              
                             
                               
                               
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Date of Birth<span class="at-required-highlight">*</span></label> 
                                <div class="col-sm-7"> 
                                          <input type="text" name="editStaffDOB" class="form-control form-control-birth-datepicker" id="editStaffDOB" placeholder="" required="required">
                                       </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="email" name="editStaffEmail" class="form-control" id="editStaffEmail" placeholder="" required="required" autocomplete="off" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Mobile No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStaffContact" class="form-control" id="editStaffContact" placeholder="" onkeypress="return isNumber(event)" maxlength="20" required="required">
                                 </div>
                              </div>
                             <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Category<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editCategoryId" id="editCategoryId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                          			<option value="" disabled selected>Select Category </option>
	                                          	<c:if test="${!empty categories}">
		                                       		<c:forEach items="${categories}" var="category">
		                                       			<option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div> 
                                    <div class="form-group">
                                 <label for="staffProfilePic" class="col-sm-3 control-label">Photo</label> 
                                 <div class="col-sm-7">
                                    <input  class="filestyle" data-size="md" name="editStaffProfilePic" id="editStaffProfilePic" type="file" maxlength="225"/>
                                    <br>
                                    <div class="viewimage2" >
                                    
                                   <img src="#" id="editStaffImage" class="thumb-image" alt="" style="display:none;"></img>
                                     
                                   
                                    </div>
                                 </div>
                              </div>
                               <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                     <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
      
  
      </div>
      <div role="tabpanel" class="tab-pane fade" id="edit-contact-information" aria-labelledby="edit-contact-information-tab">
      <br>
        <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 1<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStaffAddressLine1" class="form-control" id="editStaffAddressLine1" placeholder="" required="required" maxlength="225">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 2<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStaffAddressLine2" class="form-control" id="editStaffAddressLine2" placeholder="" required="required" maxlength="225">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                         <%--  <select name="editStaffCountry" id="geographicallocation1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Country </option>
                                             <c:if test="${!empty countries}">
		                                       		<c:forEach items="${countries}" var="country">
		                                       			<option value="${country.getName()}">${country.getName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select> --%>
                                                 <input type="text" name="editStaffCountry" class="form-control" id="geographicallocation1" placeholder="" required="required" maxlength="225">
                             
                                       </div>
                                    </div>      
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">State<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                         <%--  <select name="editStaffState" id="geographicallocationstate1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                               <option value="" disabled selected>Select State </option>
                                             <c:if test="${!empty stateList}">
		                                       		<c:forEach items="${stateList}" var="stateList">
		                                       			<option value="${stateList.getName()}">${stateList.getName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select> --%>
                                                 <input type="text" name="editStaffState" class="form-control" id="geographicallocationstate1" placeholder="" required="required" maxlength="225">
                             
                                       </div>
                                    </div> 
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">City<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                        <%--   <select name="editStaffCity" id="geographicallocationcity1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                              <option value="" disabled selected>Select City</option>
                                             <c:if test="${!empty cityList}">
		                                       		<c:forEach items="${cityList}" var="cityList">
		                                       			<option value="${cityList.getName()}">${cityList.getName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select> --%>
                                                 <input type="text" name="editStaffCity" class="form-control" id="geographicallocationcity1" placeholder="" required="required" maxlength="225">
                             
                                       </div>
                                    </div>      
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Post Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStaffPostCode" class="form-control" id="editStaffPostCode" placeholder="" maxlength="6" required="required" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              
                               <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                     <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
      
     
      
      </div>
      <div role="tabpanel" class="tab-pane fade" id="edit-account-information" aria-labelledby="edit-account-information-tab"><br>
      
      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Name</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStaffBankName" class="form-control" id="editStaffBankName" placeholder="" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank Account No</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStaffBankAccountNo" class="form-control" id="editStaffBankAccountNo" placeholder="" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Bank IFSC Code</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStaffBankIFSC" class="form-control" id="editStaffBankIFSC" placeholder="" maxlength="100">
                                 </div>
                              </div>
       <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                     <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
      
     
      </div>
      <div role="tabpanel" class="tab-pane fade" id="edit-academic-information" aria-labelledby="edit-academic-information-tab">
      <br>
              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Staff Type<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editStaffTypeId" id="editStaffTypeId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Type</option>
                                             <c:if test="${!empty staffTypes}">
		                                       		<c:forEach items="${staffTypes}" var="staffType">
		                                       			<option value="${staffType.getStaffTypeId()}">${staffType.getStaffTypeName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                     
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Staff Designation<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                          
                             <select name="editStaffDesignationId" id="editStaffDesignationId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Designation</option>
                                             <c:if test="${!empty staffDesignations}">
		                                       		<c:forEach items="${staffDesignations}" var="editStaffDesignation">
		                                       			<option value="${editStaffDesignation.getStaffDesignationId()}">${editStaffDesignation.getStaffDesignationName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Staff Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                 		<input class="form-control" name="editStaffCode" id="editStaffCode" type="text" placeholder="" maxlength="50" required="required">
								 </div>
                              </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Approver<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editApproverId" id="editApproverId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Approver</option>
                                             <!-- <option value="0">Self Approver</option> -->
                                             <c:if test="${!empty approvers}">
		                                       		<c:forEach items="${approvers}" var="approver">
		                                       			<option value="${approver.getUserId()}" >${approver.getName()}  [${approver.getEmail()}]</option>
		                                        	</c:forEach>
	                                       	</c:if>
                                          </select>
                                       </div>
                                       
                                     </div>
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">User Role<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editUserRoleId" id="editUserRoleId" class="selectpicker" data-live-search="true"  data-style="btn-white"  required="required" >
                                   		     <c:if test="${!empty userRoles}">
		                                       		<c:forEach items="${userRoles}" var="userRole">
		                                       			<option value="${userRole.getRoleId()}" >${userRole.getRoleName()}</option>
		                                        	</c:forEach>
	                                       	</c:if>
                                            </select>
                                       </div>
                                     </div>
                                     
                                   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Access No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                 		<input class="form-control" name="editStaffAccessId" id="editStaffAccessId" type="text" placeholder="" maxlength="50" required="required">
								 </div>
                              </div>
                               
                                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Joined date</label> 
                                 <div class="col-sm-7"> 
                                     <input type="text" name="editStaffJoinedDate" class="form-control form-control-datepicker" id="editStaffJoinedDate" placeholder="">
                                 </div>
                                 </div>
                                 <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                
                                     <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
       
    
      
      </div>
      <div role="tabpanel" class="tab-pane fade" id="edit-experience-information" aria-labelledby="edit-experience-information-tab">
      <br>
   
                     
                          
      <div class="editexperiencedetails" id="editexperiencedetails">
      </div>
      
   <br>
       <br>
               <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="button" class="btn btn-success btn-custom waves-effect waves-light editbtnAdd">Add More Experience Details</button>
                                  
                                      <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
                                 
                                    
                           
      
      
      </div>
                     
      <div role="tabpanel" class="tab-pane fade" id="edit-other-information" aria-labelledby="edit-other-information-tab">
      <br>
      
      
       
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">PAN No</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStaffPANNo" class="form-control" id="editStaffPANNo" placeholder="" maxlength="50">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">PF Account No</label> 
                                       <div class="col-sm-7">
                                           <input type="text" name="editStaffPFAccountNo" class="form-control" id="editStaffPFAccountNo" placeholder="" maxlength="50">
                                       </div>
                                    </div>
                                <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Blood Group</label> 
                                       <div class="col-sm-7">
                                          <select name="editStaffBloodGroupId" id="editStaffBloodGroupId" class="selectpicker" data-live-search="true"  data-style="btn-white">
                                             <option value="" disabled selected>Select Blood Group</option>
                                             <c:if test="${!empty bloodGroups}">
		                                       		<c:forEach items="${bloodGroups}" var="bloodGroup">
		                                       			<option value="${bloodGroup.getBloodGroupId()}">${bloodGroup.getBloodGroupName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>    
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Staff Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="editStaffStatus" id="editStaffStatus" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
                                 </div>
                               </div>
                               
                                <div class="form-group ">
                                                    <label class="col-sm-3 control-label " for="adminName">User Name <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input class="required form-control" id="adminName" name="adminName" required="required" type="text" maxlength="100" >
                                                    </div>
                                                </div>
                                               
                                                <div class="form-group ">
                                                    <label class="col-sm-3 control-label " for="adminPassword">User Password <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="adminPassword" name="adminPassword" type="password" class="required form-control" required="required" onChange="checkPasswordMatch();">

                                                    </div>
                                                </div>

                                                <div class="form-group ">
                                                    <label class="col-sm-3 control-label " for="adminConfirmPassword">User Confirm Password<span>*</span> </label>
                                                    <div class="col-sm-7">
                                                        <input id="adminConfirmPassword" name="adminConfirmPassword" type="password"  required="required" class="required form-control" maxlength="100" onChange="checkPasswordMatch();" >
                                                    </div>
                                            
                                                </div>
                                                <div class="error1" style="margin-left:200px;color:red;display: none;"></div>
                                                
                                                <div id="editdynamicdocument" style="display: none;">
                                <input type="hidden" id="editidforappending" name="editidforappending">
     <input type="hidden" id="editdocumenttypes" name="editdocumenttypes">
                                </div>
                                                <div class="row">
                               <div class="col-sm-12">
                                 <div class="col-sm-offset-3">
                                 <button  style="float:right"  type="button" class="btn btn-success btn-custom waves-effect waves-light edit-btnadd-document"><i class="fa fa-plus-circle" aria-hidden="true"></i></button>
                                 <button  style="float:right" type="button"  class="btn btn-danger btn-custom waves-effect waves-light edit-btndel-document" ><i class="fa fa-times-circle" aria-hidden="true"></i></button>     
                                 </div>
                              </div>
                                 </div>
                                 <br>
                             
                              <table class="table table-striped table-bordered" >
                                          <thead>
                                             <tr>
                                                <th>Document Type</th>
                                                <th>Upload Document</th>
                                             </tr>
                                          </thead>
                                          <tbody id="editdocumentinfo">
                                             <tr id="editclonedinputdocument" class="editclonedinputdocument">
                                                
                                             </tr>
                                          </tbody>
                                       </table>
                         <br>
                                                
                                                <input type="hidden" id="updateStaffId" name="updateStaffId">
                                                 <input type="hidden" id="updateUserId" name="updateUserId">
                                                   <input type="hidden" id="updateStaffBankDetailId" name="updateStaffBankDetailId">
                             				 <input type="hidden" id="staffExperienceIdArray" name="staffExperienceIdArray">
                                  <input type="hidden" id="documentsCount" name="documentsCount"> 
                          
                                <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <a href="#" id="updateStaff" style="float:right" class="btn btn-success btn-custom waves-effect waves-light" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>    
                                     <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
      </div>
   </div>
       </form>
       <div class="clearfix"> </div>
                     </div>
                     
                  </div>
               </div>
            </div>
         </div>
      </div>
      </div>
      </div>
       <script> 
        	 
    function selectimage(i)
	 {
    	 $("#divimage"+i).append('<input class="filestyle img" data-size="md" name="documents" id="document'+i+'" type="file" required="required"/>');
    	 $("#document"+i).filestyle('clear');
	 }
    function editselectimage(i)
	 {
  		$("#divimage"+i).append('<input class="filestyle img" data-size="md" name="documents" id="document'+i+'" type="file" />  <label for="imagepath'+i+'" id="imagepath'+i+'"></label>');
  	 	$("#document"+i).filestyle('clear');
	 }
    </script>
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

      <script src="${pageContext.request.contextPath}/resources/themes/script/managestaff.js" type="text/javascript"></script>
    <%--   <script src="${pageContext.request.contextPath}/resources/themes/script/geographicallocation.js"></script> --%>
    <script type="text/javascript">
  
    TableManageButtons.init();

</script>
   </body>
</html>