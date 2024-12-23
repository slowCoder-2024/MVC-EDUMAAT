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
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.11.2.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.7.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
     <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/timepicker/bootstrap-timepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/clockpicker/css/bootstrap-clockpicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
	
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/edumaatalert/edumaatalert.css"/>
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
      
      </style>
      <!--//Metis Menu -->
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
            <div class="modal fade" id="deletestudentconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure you want to delete this student ?</h5>
                     </div>
                     <div class="modal-footer">
                      <form id="deletestudentform" action="${pageContext.request.contextPath}/student/delete" method="post">
                              <input type="hidden" id="deleteStudentId" name="deleteStudentId">
                              <button type="button" id="confirmdeletestudent"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                           </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="studentsaveconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure you want to add this student ?</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" id="studentsaveconfirm" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
                   <div class="modal fade" id="updateconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                      <h5>Are you sure you want to update this student ?</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" name="studentupdateconfirm" id="studentupdateconfirm" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
              <div class="modal fade" id="bulkConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure? You want to delete this Students Details ?? </h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="bulkConfirm" id="bulkConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						</div>
               <div id="browse-file" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog" role="document">
	<div class="modal-content">
	<form id="studentExcelUploadForm" class="form-horizontal" enctype="multipart/form-data" action="${pageContext.request.contextPath}/student/uploadStudentExcel" method="post">
	<div class="modal-header">
	<button class="close" type="button" data-dismiss="modal" aria-label="Close">
	<span aria-hidden="true">×</span>
	</button>
	<h4 id="exampleModalLabel" class="modal-title">Student Bulk Upload</h4>
	</div>
	<div class="modal-body">
	<div class="form-group">
	<label class="col-sm-2 control-label" for="">Excel File</label>
	<div class="col-sm-7">
	<input id="studentExcelfile" class="" name="studentExcelfile" required="required" type="file">
	</div>
	</div>
		<br>
	</div>
	<div class="modal-footer">
	<button id="confirmExcelUpload" class="btn btn-primary" type="submit">Upload</button>
	</div>
	</form>
	</div>
	</div>
	</div>
	 <div class="modal fade" id="browse-file1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
              						 <div class="modal-dialog" role="document">
              						 <form id="studentBulkUpdateForm" action="${pageContext.request.contextPath}/student/updateStudentExcel" method="post" enctype="multipart/form-data">
                  						<div class="modal-content">
                  					     	<div class="modal-header">
                        						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        							<h4 class="modal-title" id="exampleModalLabel">Browse the File</h4>
                     						</div>
                     						<div class="modal-body">
                     						
                     							<div class="form-group">
                                 					<label for="" class="col-sm-2 control-label">Upload</label> 
                                 				<div class="col-sm-7">
                                    				<input class="" name="studentBulkUpdate" required="required" id="studentBulkUpdate" type="file"/>
                                  				</div>
                              			</div>
                     			<br>
                      </div>
                     <div class="modal-footer">
                        <button type="submit" id="studentBulkUpdateSave" class="btn btn-primary">Update</button>
                     </div>
                  </div>
                  </form>
               </div>
            </div>
            <div id="FormDiv" style="display:block;">
             
    
                   <form class="form-horizontal" id="addstudentform" role="form" data-parsley-validate novalidate action="${pageContext.request.contextPath}/student/add" method="post" enctype="multipart/form-data">
   
   <ul id="myTabs" class="nav nav-tabs" role="tablist">
      <li role="presentation" class="active"><a href="#personal-information" id="personal-information-tab" role="tab" data-toggle="tab" aria-controls="personal-information" aria-expanded="true"><i class="fa fa-user" aria-hidden="true"></i>
      Personal Information</a></li>
      <li role="presentation" class=""><a href="#contact-information" role="tab" id="contact-information-tab" data-toggle="tab" aria-controls="contact-information" aria-expanded="false"><i class="fa fa-tty" aria-hidden="true"></i>
      Contact Information</a></li>
      <li role="presentation" class=""><a href="#academic-information" role="tab" id="academic-information-tab" data-toggle="tab" aria-controls="academic-information" aria-expanded="false"><i class="fa fa-university nav_icon"></i>Academic Information</a></li>
      <li role="presentation" class=""><a href="#other-information" role="tab" id="other-information-tab" data-toggle="tab" aria-controls="other-information" aria-expanded="false"><i class="fa fa-info" aria-hidden="true"></i>Other Information</a></li>
      <li role="presentation" class=""><a href="#specific-information" role="tab" id="specific-information-tab" data-toggle="tab" aria-controls="specific-information" aria-expanded="false"><i class="fa fa-info" aria-hidden="true"></i>Specific Information</a></li>
   </ul>
   <div id="myTabContent" class="tab-content">
      <div role="tabpanel" class="tab-pane fade active in" id="personal-information" aria-labelledby="personal-information-tab">
      <br>
         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution(franchises) Code/Name <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
								   <select name="institutionCode" id="institutionCode" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            
                                              <option value="">Select Institution</option>
                                          </select> 
								 </div>
                              </div>
    	<div class="form-group">
                          	   <label for="" class="col-sm-3 control-label">First Name <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" required="required" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Last Name</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="lastName"  name="lastName" placeholder="" maxlength="100">
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian First Name <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="parentOrGuardianFirstName" name="parentOrGuardianFirstName" required="required" placeholder="" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian Last Name</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="parentOrGuardianLastName" name="parentOrGuardianLastName" placeholder="" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent/Guardian Email <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="email" class="form-control" id="parentOrGuardianEmail"  name="parentOrGuardianEmail" placeholder="" required="required" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Gender <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="studentGender" id="studentGender" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Gender</option>
                                             <option value="Male">Male</option>
                                             <option value="Female">Female</option>

                                             
                                              <option value="Others">Others</option>
                                          </select>                                 </div>
                              </div>
                              
                               
                               
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Date of Birth <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-control-birth-datepicker" id="dateOfBirth" name="dateOfBirth" placeholder="" required="required" maxlength="10">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Email <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="email" class="form-control" id="eMail"  name="eMail" placeholder="" required="required" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student Contact <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="contact" name="contact" placeholder=""  required="required" onkeypress="return isNumber(event)" maxlength="25">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent Contact <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="parentContact" name="parentContact" placeholder=""  required="required" onkeypress="return isNumber(event)" maxlength="25">
                                 </div>
                              </div>
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Category <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                     <select name="categoryId" id="categoryId" class="selectpicker" data-live-search="true" data-style="btn-white" required="required">
                                      <option value="" disabled selected>Select Category </option>
                                      <c:if test="${!empty categoryList}">
                                           <c:forEach items="${categoryList}" var="category">
                                             <option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                 </div>
                              </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Special Category <span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="specialCategoryId" id="specialCategoryId" data-live-search="true" class="selectpicker"  data-style="btn-white" required="required" >
                                       <c:if test="${!empty specialCategoryList}">
                                          <c:forEach items="${specialCategoryList}" var="specialCategory">
                                             <option value="${specialCategory.getSpecialCategoryId()}">${specialCategory.getSpecialCategoryName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                       </div>
                                    </div> 
                                     <div class="form-group">

                                 <label for="" class="col-sm-3 control-label">Father Income In lakhs(Std. Currency)</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="fatherIncome" name="fatherIncome" placeholder="" onkeypress="return decimalAmount(this, event, 2)" maxlength="255">
                                 </div>
                                 </div>
                                 <div class="form-group">

                                 <label for="" class="col-sm-3 control-label">Mother Income In lakhs(Std. Currency)</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="motherIncome" name="motherIncome" placeholder="" onkeypress="return decimalAmount(this, event, 2)" maxlength="255">
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
                                 <label for="" class="col-sm-3 control-label">Address Line 1 <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="addressLine1"  name="addressLine1" placeholder="" required="required" maxlength="255">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 2 <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="addressLine2" name="addressLine2" placeholder="" required="required" maxlength="255">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country <span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="country" id="geographicallocation" class="selectpicker" data-live-search="true"   data-style="btn-white" required="required">
                                             	<option value="" disabled selected>Select Country </option>
                                             <c:if test="${!empty countryList}">
		                                       		<c:forEach items="${countryList}" var="country">
		                                       			<option value="${country.getName()}">${country.getName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                             </select>     
                                       </div>
                                    </div>   
                                       <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">State <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">                                   
                                     <select name="state" id="geographicallocationstate" class="selectpicker"  data-live-search="true" data-style="btn-white" required="required" >
                                    	 <option value="" disabled selected>Select State</option>
                                             <c:if test="${!empty stateList}">
		                                       			<c:forEach items="${stateList}" var="stateList">
		                                       				<option value="${stateList.getName()}">${stateList.getName()}</option>
		                                       			</c:forEach>
		                                       </c:if>
                                    </select>
                                 </div>
                              </div>   
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">City <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">                                   
                                     <select name="city" id="geographicallocationcity" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                     	 <option value="" disabled selected>Select City</option>
                                             <c:if test="${!empty cityList}">
		                                       			<c:forEach items="${cityList}" var="cityList">
		                                       				<option value="${cityList.getName()}">${cityList.getName()}</option>
		                                       			</c:forEach>
		                                       </c:if>
                                     </select>
                                 </div>
                              </div>   
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Post Code <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="postCode" name="postCode" placeholder="" maxlength="6" required="required" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                           
     <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                     <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light ">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
      
      </div>
   
      <div role="tabpanel" class="tab-pane fade" id="academic-information" aria-labelledby="academic-information-tab">
      <br>
             						  <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Joining Course/Class <span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="joinedClass" id="joinedClass" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                                <option value="" disabled selected>Select Course/Class</option>
                                           		 <c:if test="${!empty classList}">
		                                       			<c:forEach items="${classList}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                     
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Section <span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="joinedSection" id="joinedSection" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                          </select>
                                       </div>
                                    </div>
                              
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Joined Academic Year <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="academicYearId" id="academicYearId"  class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Academic Year</option>
                                      <c:if test="${!empty academicYearList}">
                                      		<option value="${academicYearList.getAcademicYearId()}">${academicYearList.getAcademicYearTitle()}</option>
                                      	</c:if>
                                     </select>
                                 </div>
                              </div>
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class Roll No (unique)</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="rollNo" name="rollNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Joined date <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" required="required" class="form-control form-control-datepicker" id="joinedDate" name="joinedDate" placeholder="" maxlength="10">
                                 </div>
                                 </div>
                                
                                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Access No</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="studentAccessNo" name="studentAccessNo" placeholder="" maxlength="50">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Admission No <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="studentAdmissionNo"  required="required" name="studentAdmissionNo" placeholder="" maxlength="50">
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

      <div role="tabpanel" class="tab-pane fade" id="other-information" aria-labelledby="other-information-tab">
      <br>
      <div class="form-group">
                                 <label for="studentProfilePic" class="col-sm-3 control-label">Upload Photo</label> 
                                 <div class="col-sm-7">
                                    <input name="studentProfilePic" class="filestyle" data-size="md" id="studentProfilePic" type="file" />
                                    <br>
                                    <div class="viewimage1" >
                                     <img src="#" id="editStudentImage" class="thumb-image" alt="" style="display:none;"></img>
                                    </div>
                                 </div>
                              </div>
                                   <div class="form-group" >
                                 <label for="" class="col-sm-3 control-label">Upload Scanned Signature</label> 
                                 <div class="col-sm-7">
                                    <input class="filestyle" data-size="md" name="studentSignature" id="studentSignature" type="file"/>  <br>
                                    <div class="viewimage2">
                                      <img src="#" id="editStudentSignature" class="thumb-image" alt="" style="display:none;"></img>
                                    </div>
                                    
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Upload Parent Profile </label> 
                                 <div class="col-sm-7">
                                    <input class="filestyle" data-size="md" name="parentProfilePic" id="parentProfilePic" type="file"/>  <br>
                                    <div class="viewimage3">
                                    </div>
                                 </div>
                              </div>
                           
      
      <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Passport No</label> 
	                                 <div class="col-sm-7"> 
	                                    <input type="text" class="form-control" id="passportNo"  name="passportNo" placeholder="" maxlength="100">
	                                 </div>
	                              </div>
                                <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Blood Group</label> 
                                       <div class="col-sm-7">
                                           <select name="bloodGroupId" id="bloodGroupId" class="selectpicker" data-live-search="true"  data-style="btn-white">
                                                <option value="" disabled selected>Select Blood Group </option>
                                        		<c:if test="${!empty bloodGroupList}">
		                                       			<c:forEach items="${bloodGroupList}" var="bloodGroup">
		                                       					<option value="${bloodGroup.getBloodGroupId()}" >${bloodGroup.getBloodGroupName()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div><div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student Status <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="studentStatus" id="studentStatus" class="selectpicker"  data-live-search="true" data-style="btn-white" required="required">
                                                <option value="" disabled selected>Select Student Status </option>
                                        		<c:if test="${!empty studentStatusList}">
		                                       			<c:forEach items="${studentStatusList}" var="studentStatus">
		                                       					<option value="${studentStatus.getStudentStatusId()}" >${studentStatus.getStatusTitle()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                         
                                    </select>
                                 </div>
                               </div>
                          
      
      </div>
      <div role="tabpanel" class="tab-pane fade" id="specific-information" aria-labelledby="specific-information-tab">
      <br>
      <div class="form-group">
        <label for="" class="col-sm-3 control-label">School / College Name </label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="schoolOrCollegName" name="schoolOrCollegName" placeholder=""  maxlength="255">
                                 </div>
                                 </div>
                                 <div class="form-group">
                                  <label for="" class="col-sm-3 control-label">School / College Principal Name </label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="schoolOrCollegePrincipalName" name="schoolOrCollegePrincipalName" placeholder=""  maxlength="100">
                                 </div>
                                 </div>
                                  <div class="form-group">
                                <label for="" class="col-sm-3 control-label">Standard /Course at School / College</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="standardOrCourseAtSchoolOrCollege" name="standardOrCourseAtSchoolOrCollege" placeholder=""  maxlength="100">
                                 </div>
                                 </div>
                                    <div class="form-group">
                                <label for="" class="col-sm-3 control-label"> Class Teacher / HOD Name</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="classTeacherOrHODName" name="classTeacherOrHODName" placeholder="" maxlength="100">
                                 </div>
                                 </div>
                                        <div class="form-group">
                                  <label for="" class="col-sm-3 control-label">School / College Address</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="schoolOrCollegeAddress" name="schoolOrCollegeAddress" placeholder=""  maxlength="255">
                                 </div>
                                 </div>
                                       <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">School / College Telephone No </label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="SchoolOrCollegeTelePhoneNo" name="SchoolOrCollegeTelePhoneNo" placeholder=""   onkeypress="return isNumber(event)" maxlength="25">
                                 </div>
                              </div>
                               <div class="form-group">
                                  <label for="" class="col-sm-3 control-label">Parent / Guardian Occupation </label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="parentOrGuardianOccupation" name="parentOrGuardianOccupation" placeholder=""  maxlength="100">
                                 </div>
                                 </div>
                              	<div class="form-group">
                                   <label for="" class="col-sm-3 control-label">is The Child Suffering From Any learning difficulty Or Disability</label> 
                               
                               <div class="col-sm-7">
                               
				  	  <div class="radio radio-success">
		  					<input type="radio" name="option1" value="yes" ><label>Yes</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					  
		  					<input  type="radio" name="option1" value="no" checked="checked"><label>No</label>
						</div>
				</div>
				</div>
				      <div class="form-group optionData1Div">
                                       <label for="" class="col-sm-3 control-label"></label>
                                        <div class="col-sm-7"> 
                                    <textarea rows="6" class="form-control" placeholder="" name="optionData1" id="optionData1"></textarea>
                                    </div>
                                </div>
                              
                                      	<div class="form-group">
                                   <label for="" class="col-sm-3 control-label">If any one of the parent OR close relative : is in teaching or training profession, please give full details of name, name

of the organisation, subject handled, position and years of service</label> 
                               
                               <div class="col-sm-7">
                               
				  	  <div class="radio radio-info">
		  					<input type="radio" name="option2" value="yes" ><label>Yes</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					  
		  					<input  type="radio" name="option2" value="no" checked="checked"><label>No</label>
						</div>
				</div>
				</div>
				      <div class="form-group optionData2Div">
                                       <label for="" class="col-sm-3 control-label"></label>
                                        <div class="col-sm-7"> 
                                    <textarea rows="6" class="form-control" placeholder="" name="optionData2" id="optionData2"></textarea>
                                    </div>
                                </div>
                              
                                      	
				      <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">No. of classes recommended for the course</label>
                                        <div class="col-sm-7"> 
                                    <textarea rows="6" class="form-control" placeholder="" name="optionData3" id="optionData3"></textarea>
                                    </div>
                                </div>
                                      <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="button" id="saveStudent" class="btn btn-success btn-custom waves-effect waves-light">Save</button>
                                     <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
                              </div>
                              
      
   </div>
 
       </form>
   
            </div>
         
         </div>
      </div>
   </div>
   </div>
       <script> 
         $(document).ready(function() {
                 $("#studentSignature").on('change', function() {
                   //Get count of selected files
                   var countFiles = $(this)[0].files.length;
                   var imgPath = $(this)[0].value;
                  
                   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
                   var image_holder = $(".viewimage2");
                   
                   image_holder.empty();
                   if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
                     if (typeof(FileReader) != "undefined") {
                       //loop for each file selected for uploaded.
                       for (var i = 0; i < countFiles; i++) 
                       {
                         var reader = new FileReader();
                         reader.onload = function(e) {
                           $("<img />", {
                             "src": e.target.result,
                             "class": "thumb-image"
                           }).appendTo(image_holder);
                         }
                         image_holder.show();
                         reader.readAsDataURL($(this)[0].files[i]);
                       }
                     } else {
                    	/*  $('#studentSignature').val('');  */
                    	 	$('#studentSignature').filestyle('clear');
                    	 	edumaatAlert({
 		    			  title: "Info !",
 		    			  text: "This browser does not support FileReader.",
 		    			  type: "info",
 		    			  confirmButtonText: "Cool"
 		    			});
                     }
                   } else {
                	 /*   $('#studentSignature').val('');  */
                	 	$('#studentSignature').filestyle('clear');
                     edumaatAlert({
		    			  title: "Info !",
		    			  text: "Please select only images",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
                   }
                 });
               });
      </script>
 <script> 
         $(document).ready(function() {
                 $("#studentProfilePic").on('change', function() {
                   //Get count of selected files
                   var countFiles = $(this)[0].files.length;
                   var imgPath = $(this)[0].value;
                  
                   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
                   var image_holder = $(".viewimage1");
                   
                   image_holder.empty();
                   if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
                     if (typeof(FileReader) != "undefined") {
                       //loop for each file selected for uploaded.
                       for (var i = 0; i < countFiles; i++) 
                       {
                         var reader = new FileReader();
                         reader.onload = function(e) {
                           $("<img />", {
                             "src": e.target.result,
                             "class": "thumb-image"
                           }).appendTo(image_holder);
                         }
                         image_holder.show();
                         reader.readAsDataURL($(this)[0].files[i]);
                       }
                     } else {
                    	/*  $('#studentProfilePic').val('');  */
                    	 	$('#studentProfilePic').filestyle('clear');
                    	 	edumaatAlert({
     		    			  title: "Info !",
     		    			  text: "This browser does not support FileReader.",
     		    			  type: "info",
     		    			  confirmButtonText: "Cool"
     		    			});
                     }
                   } else {
                	  /*  $('#studentProfilePic').val('');  */
                	 	$('#studentProfilePic').filestyle('clear');
                	 	edumaatAlert({
 		    			  title: "Info !",
 		    			  text: "Please select only images",
 		    			  type: "info",
 		    			  confirmButtonText: "Cool"
 		    			});
                   }
                 });
                 
                 
                 
                 
                 
               });
      </script>
      
  
      
      <script> 
         $(document).ready(function() {
                 $("#parentProfilePic").on('change', function() {
                   //Get count of selected files
                   var countFiles = $(this)[0].files.length;
                   var imgPath = $(this)[0].value;
                  
                   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
                   var image_holder = $(".viewimage3");
                   
                   image_holder.empty();
                   if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
                     if (typeof(FileReader) != "undefined") {
                       //loop for each file selected for uploaded.
                       for (var i = 0; i < countFiles; i++) 
                       {
                         var reader = new FileReader();
                         reader.onload = function(e) {
                           $("<img />", {
                             "src": e.target.result,
                             "class": "thumb-image"
                           }).appendTo(image_holder);
                         }
                         image_holder.show();
                         reader.readAsDataURL($(this)[0].files[i]);
                       }
                     } else {
                    	/*  $('#parentProfilePic').val('');  */
                    	 	$('#parentProfilePic').filestyle('clear');
                    	 	edumaatAlert({
     		    			  title: "Info !",
     		    			  text: "This browser does not support FileReader.",
     		    			  type: "info",
     		    			  confirmButtonText: "Cool"
     		    			});
                     }
                   } else {
                	  /*  $('#parentProfilePic').val('');  */
                	 	$('#parentProfilePic').filestyle('clear');
                	 	edumaatAlert({
 		    			  title: "Info !",
 		    			  text: "Please select only images",
 		    			  type: "info",
 		    			  confirmButtonText: "Cool"
 		    			});
                   }
                 });
               });
      </script>
      
 
      
      
      <!-- Bootstrap Core JavaScript -->
       
   <script>
         var resizefunc = [];
      </script>
      <!-- jQuery  -->
           
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/edumaatalert/edumaatalert.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/bootstrap.min.js"></script> 
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/detect.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/fastclick.js"></script>
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
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/multiselect/js/jquery.multi-select.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-quicksearch/jquery.quicksearch.js"></script>
 <%--      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/select2/js/select2.min.js" type="text/javascript"></script> --%>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-select/js/bootstrap-select.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-filestyle/js/bootstrap-filestyle.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-touchspin/js/jquery.bootstrap-touchspin.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-maxlength/bootstrap-maxlength.min.js" type="text/javascript"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.mockjax.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.autocomplete.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/countries.js"></script>
    <%--   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/autocomplete.js"></script> --%>
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
         <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/parsleyjs/parsley.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/script/newenquiryregister.js" type="text/javascript"></script>
       <script src="${pageContext.request.contextPath}/resources/themes/script/geographicalLocation.js" type="text/javascript"></script>
   </body>
</html>