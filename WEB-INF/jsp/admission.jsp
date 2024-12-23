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
  
       <div class="loader" style="display: none"></div>
        <div id="ListDiv" style="display:block;">
        <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                              <h2 class="panel-title">
                              Apply For Admission
		           </h2>
						
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						  <div class="panel-body">
						   <form class="form-horizontal" id="getDetails" name="getDetails" method="post">
							  <c:choose>
          	 	<c:when test="${!empty admissionConfig}">
          	 			
               <div class="form-group">
                  <button  type="button" id="studentAdmissionDetailsExcel" class="btn btn-info btn-custom waves-effect waves-light col-md-4">Download Application Form</button>
                                             <button   type="button" onclick="showDiv()" class="btn btn-primary btn-custom waves-effect waves-light col-md-4">Apply for Admission</button>
                                         </div>
             <br />
               <br />
               <br />
               <br />
                   <h4 class="m-t-0 header-title" style="color:purple;"><b>Status of My Applications</b></h4>
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
                                      <th data-field="Applicant_Id" data-switchable="false">Applicant Id</th>
                                   	<th data-field="Applicant_Code's">Applicant Code</th>
                               		<th data-field="Applicant_Status">Applicant Status</th>
                                    <th data-field="Action">Action</th>
                                    </tr>
                                 </thead>
                                 <tbody  id="applicationList" >
                            <c:if test="${!empty appliedApplicationsList}">
                                       <c:forEach items="${appliedApplicationsList}" var="appliedApplications">
                                       		 <tr class="active" id="applicationList">
                                       		 <td>${appliedApplications.getAdmissionId()}</td>
                                  				<td>${appliedApplications.getAdmissionCode()}</td>
                                    			<td>${appliedApplications.getAdmissionStatus().getAdmissionStatusTitle()}</td>
                                 				<td>
                                    				<a href="#" id="edit"  type="button" data-href="#" data-id="${appliedApplications.getAdmissionId()}" onclick="showeditDiv()" data-toggle="modal"class="on-default edit-row"><i class="fa fa-pencil" style="margin-right: 15px"></i>
	                                        </a>
                                   				</td>
                                 			</tr>
                                       </c:forEach>
                                	</c:if>
                                	 </tbody>
                              </table>
                         
       
         
         
            
            	</c:when>
            	<c:otherwise>
            		<div class="alert alert-info">
							<h5>Admissions:</h5>
                                  <p>"Admissions are not opened !! You Will be Notified Once Admission Process Starts. Thank You."</p>
                  			</div>
			  </c:otherwise>
          </c:choose>
				</form>		
						</div>
					</div>  </div>
                                 </div>
                                 </div>
                                 </div>
                                   </div>
                                 </div>
         <div class="modal fade" id="browse-file" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
              						 <div class="modal-dialog" role="document">
              						 <form id="studentBulkUpdateForm" action="${pageContext.request.contextPath}/admissions/uploadStudentAdmissionExcel" method="post" enctype="multipart/form-data">
                  						<div class="modal-content">
                  					     	<div class="modal-header">
                        						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        							<h4 class="modal-title" id="exampleModalLabel">Browse the File</h4>
                     						</div>
                     						<div class="modal-body">
                     						
                     							<div class="form-group">
                                 					<label for="" class="col-sm-2 control-label">Upload</label> 
                                 				<div class="col-sm-7">
                                    				<input class="filestyle" data-size="md" name="studentBulkUpdate" required="required" id="studentBulkUpdate" type="file"/>
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
           <div id="FormDiv" style="display:none;">
            
             
                       <form class="form-horizontal" id="newadmissionForm" role="form" data-parsley-validate novalidate method="post" action="${pageContext.request.contextPath}/admissions/candidate/newAdmission/save" enctype='multipart/form-data'>
                        <div class="row">
                                 <div class="col-sm-offset-3">
  
                        <button style="float:right"  class="btn btn-info btn-custom waves-effect waves-light" type="button" name="admissionSave" id="admissionSave">
      								<i class="fa fa-floppy-o"></i>
      								 </button>
      								
      								<button type="button" style="float:right" class="btn btn-primary btn-custom waves-effect waves-light" onclick="location.reload()">
      								<i class="fa fa-times" aria-hidden="true"></i>
    				     </button>
    				     <a class="btn btn-warning btn-custom waves-effect waves-light" style="float:right;margin-right: 20px" href="#" type="button" data-href="#" data-id="" data-toggle="modal" data-target="#browse-file">Browse the bulk upload excel sheet </a>
    				     <br/>
    				     </div>
    				     </div>
                        <ul id="myTabs" class="nav nav-tabs" role="tablist">
                           <li role="presentation" class="active">
                              <a href="#generalinstructions" id="generalinstructions-tab" role="tab" data-toggle="tab" aria-controls="generalinstructions" aria-expanded="true"><i class="fa fa-info" aria-hidden="true"></i>General Instructions</a>
                           </li>
                           <li role="presentation">
                              <a href="#personalinformation" id="personalinformation-tab" role="tab" data-toggle="tab" aria-controls="personalinformation" aria-expanded="false"><i class="fa fa-user" aria-hidden="true"></i>Personal Information</a>
                           </li>
                           <li role="presentation" >
                              <a href="#contactdetails" role="tab" id="contactdetails-tab" data-toggle="tab" aria-controls="contactdetails" aria-expanded="false"><i class="fa fa-tty" aria-hidden="true"></i>Contact Details</a>
                           </li>
                           
                           <li role="presentation" >
                              <a href="#educationalqualifications" role="tab" id="educationalqualifications-tab" data-toggle="tab" aria-controls="educationalqualifications" aria-expanded="false"><i class="fa fa-university nav_icon"></i>Educational Qualifications</a>
                           </li>
                           <li role="presentation" >
                              <a href="#course" role="tab" id="course-tab" data-toggle="tab" aria-controls="course" aria-expanded="false"><i class="fa fa-book nav_icon"></i>Apply for Class</a>
                           </li>
                           <li role="presentation" >
                              <a href="#document" role="tab" id="document-tab" data-toggle="tab" aria-controls="document" aria-expanded="false"><i class="md md-file-upload nav_icon"></i>Upload Documents</a>
                           </li>
                           <li role="presentation" >
                              <a href="#payment" role="tab" id="payment-tab" data-toggle="tab" aria-controls="payment" aria-expanded="false"><i class="ion-cash nav_icon"></i>Payment</a>
                           </li>
                        </ul>
                        <div id="myTabContent" class="tab-content scrollbar1">
                           <div role="tabpanel" class="tab-pane fade active in" id="generalinstructions" aria-labelledby="generalinstructions-tab">
                              <p style="text-align: justify;">Applicants applying through online to their preferred course should pay application fees using net banking or debit/credit cards (only VISA cards) during step 4 in Admission for ${admissionConfig.getAdmissionProcessYear()} academic year by selecting online payment.</p>
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="personalinformation" aria-labelledby="personalinformation-tab">
                              <div class="form-body">
                                
                                 
                                  <h4 class="m-t-0 header-title" style="color:purple;">Applicant Information</h4>  
                                 
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant's First Name<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text"  name="candidateFirstName" class="form-control" id="candidateFirstName" maxlength="50" placeholder="" required="required">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant's Last Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="candidateLastName" class="form-control" maxlength="50" id="candidateLastName" placeholder="">
                                       </div>
                                    </div>
                                   
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Gender<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="candidateGender" id="candidateGender" class="selectpicker"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Gender</option>
                                             <option value="Male">Male</option>
                                             <option value="Female">Female</option>
                                              <option value="Others">Others</option>
                                          </select>         
                                       </div>
                                    </div>
                                       
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Date Of Birth<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" required="required" name="dateOfBirth" class="form-control form-control-datepicker" maxlength="10" id="dateOfBirth" placeholder="">
                                       </div>
                                    </div>
                                   
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant Religion<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="religionId" id="religionId" required="required" class="selectpicker" data-style="btn-white">
                                          		<option value="" disabled selected>Select Religion</option>
		                                          <c:if test="${!empty religionList}">
		                                       		<c:forEach items="${religionList}" var="religion">
		                                       			<option value="${religion.getReligionId()}">${religion.getReligionName()}</option>
		                                       		</c:forEach>
		                                       	  </c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant Category<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="categoryId" id="categoryId" required="required" class="selectpicker" data-style="btn-white">
                                          		<option value="" disabled selected>Select Category</option>
		                                          <c:if test="${!empty categoryList}">
		                                       		<c:forEach items="${categoryList}" var="category">
		                                       			<option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
		                                       		</c:forEach>
		                                       	  </c:if>
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant Special Category<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="specialCategoryId" id="specialCategoryId" required="required" class="selectpicker" data-style="btn-white">
                                             <option value="" disabled selected>Select Special Category</option>
                                             	<c:if test="${!empty specialCategoryList}">
		                                       		<c:forEach items="${specialCategoryList}" var="specialCategory">
		                                       			   <option value="${specialCategory.getSpecialCategoryId()}">${specialCategory.getSpecialCategoryName()}</option>
		                                       		</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Passport or ID No.</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="passportNo" class="form-control" id="passportNo" maxlength="30" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country ID Issued</label> 
                                       <div class="col-sm-7"> 
                                              <select name="passportissuedCountryId" id="passportissuedCountryId" data-live-search="true"  class="selectpicker" data-style="btn-white">
                                             	<option value="" disabled selected>Select Country </option>
                                             		<c:if test="${!empty countryList}">
		                                       			<c:forEach items="${countryList}" var="country">
		                                       				<option value="${country.getGeographicalLocationId()}">${country.getName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                              
                                             </select>                                      </div>
                                    </div>
                                    
                                      <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Studied here before?</label> 
                                       <div class="col-sm-7">
                                          <select name="IsStudiedBefore" id="IsStudiedBefore" class="selectpicker" data-style="btn-white">
                                             <option value="" disabled selected>Select Yes/No</option>
                                             <option value="Yes">Yes</option>
                                             <option value="No">No</option>
                                          </select>
                                       </div>
                                    </div>
                                    
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Previous Student ID of this institute</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="previousStudentId" class="form-control" maxlength="60" id="previousStudentId" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Who will sponsor your studies here?</label> 
                                       <div class="col-sm-7">
                                          <select name="sponserId" id="sponserId" class="selectpicker" data-style="btn-white">
                                             <option value="" disabled selected>Sponsored by</option>
                                             	<c:if test="${!empty sponserList}">
		                                       			<c:forEach items="${sponserList}" var="sponser">
		                                       				<option value="${sponser.getSponserId()}">${sponser.getSponserTitle()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Do you have any disability?<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="isDisability" required="required" id="isDisability" class="selectpicker" data-style="btn-white">
                                             <option value="" disabled selected>Select Yes/No</option>
                                             <option value="Yes">Yes</option>
                                             <option value="No">No</option>
                                          </select>
                                       </div>
                                    </div>
                                    
                     <h4 class="m-t-0 header-title" style="color:purple;">Parents and Guardian</h4>                 
                        <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Father's First Name<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="fatherFirstName" class="form-control" maxlength="50" required="required" id="fatherFirstName" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Father's Last Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="fatherLastName" class="form-control" maxlength="50" id="fatherLastName" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Father's Occupation</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="fatherOccupation" class="form-control" maxlength="50" id="fatherOccupation" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mother's First Name<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="motherFirstName" class="form-control" maxlength="50" required="required" id="motherFirstName" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mother's Last Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="motherLastName" class="form-control" maxlength="50" id="motherLastName" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mother's Occupation</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text"  name="motherOccupation"class="form-control" maxlength="50" id="motherOccupation" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Father Income</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="fatherIncome" class="form-control" id="fatherIncome" maxlength="15" placeholder="" onkeypress="return decimalAmount(this, event, 2)">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mother Income</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="motherIncome" class="form-control" id="motherIncome" maxlength="15" placeholder="" onkeypress="return decimalAmount(this, event, 2)">
                                       </div>
                                    </div>
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Guardian's First Name<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text"  name="guardianFirstName" class="form-control" id="guardianFirstName" maxlength="50" required="required" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Guardian's Last Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="guardianLastName" class="form-control" id="guardianLastName" maxlength="50"  placeholder="">
                                       </div>
                                    </div>
                                                
                                    
                                  <h4 class="m-t-0 header-title" style="color:purple;">Details of References</h4>  
                                    <div class="form-group">
                                     <label for="" class="col-sm-2 control-label "><span>Reference 1</span></label> 
                                    </div>
                                      
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">First Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="reference1FirstName" class="form-control" maxlength="50" id="reference1FirstName" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Last Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text"  name="reference1LastName" class="form-control"  maxlength="50"id="reference1LastName" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                         <label for="" class="col-sm-3 control-label">E-Mail</label>
                                       <div class="col-sm-7"> 
                                      
                                          <input type="text" name="reference1Email" maxlength="50" class="form-control form-control-email" id="reference1Email" placeholder="">
                                       </div>
                                       </div>
                                       <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Mobile No</label>
                                       <div class="col-sm-7"> 
                                       
                                          <input type="text" name="reference1Mobile" maxlength="20" class="form-control" id="reference1Mobile" placeholder="" onkeypress="return isNumber(event)" maxlength="15">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="" class="col-sm-3 control-label ">Address Line 1</label>
                                        <div class="col-sm-7"> 
                                          <input type="text" name="reference1AddressLine1" maxlength="100" class="form-control" id="reference1AddressLine1" placeholder="">
                                         </div>
                                        </div> 
                                        <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 2</label>
                                       <div class="col-sm-7"> 
                                        
                                          <input type="text" name="reference1AddressLine2" maxlength="100" class="form-control" id="reference1AddressLine2" placeholder="">
                                       </div>
                                       </div>
                                        <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country</label> 
                                       <div class="col-sm-7">
                                          <select name="reference1CountryId" id="reference1CountryId" data-live-search="true" class="selectpicker" data-style="btn-white">
                                             <option value="" disabled selected>Select Country </option>
                                            <c:if test="${!empty countryList}">
		                                       			<c:forEach items="${countryList}" var="country">
		                                       				<option value="${country.getGeographicalLocationId()}">${country.getName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>                                        
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">PIN (ZIP) code</label>
                                       <div class="col-sm-7"> 
                                          <input type="text" name="reference1Pincode" maxlength="10" class="form-control" id="reference1Pincode" placeholder="" onkeypress="return isNumber(event)" maxlength="6">
                                       </div>
                                       </div>
                                       
                                  
                                <div class="form-group">     
                           <label for="" class="col-sm-2 control-label"><span>Reference 2</span></label>
                           </div>            
                                
                                     

                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">First Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="reference2FirstName" maxlength="50" class="form-control" id="reference2FirstName" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Last Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="reference2LastName" maxlength="50" class="form-control" id="reference2LastName" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                          <label for="" class="col-sm-3 control-label">E-Mail</label>
                                        
                                       <div class="col-sm-7"> 
                                          <input type="text" name="reference2Email" maxlength="50"  class="form-control form-control-email" id="reference2Email" placeholder="">
                                       </div>
                                       </div>
                                        <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Mobile No</label>
                                       <div class="col-sm-7"> 
                                        <input type="text" name="reference2Mobile" maxlength="20" class="form-control" id="reference2Mobile" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 1</label>
                                         <div class="col-sm-7"> 
                                          <input type="text" name="reference2AddressLine1" maxlength="100" class="form-control" id="reference2AddressLine1" placeholder="">
                                         </div>
                                      </div>
                                       <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 2</label>
                                        <div class="col-sm-7"> 
                                          <input type="text" name="reference2AddressLine2" maxlength="100" class="form-control" id="reference2AddressLine2" placeholder="">
                                       </div>
                                       </div>
                                        <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country</label> 
                                       <div class="col-sm-7">
                                          <select name="reference2CountryId" id="reference2CountryId" data-live-search="true" class="selectpicker" data-style="btn-white">
                                             <option value="" disabled selected>Select Country </option>
                                            	<c:if test="${!empty countryList}">
		                                       			<c:forEach items="${countryList}" var="country">
		                                       				<option value="${ country.getGeographicalLocationId()}">${country.getName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>                                
                                        <div class="form-group">
                                         <label for="" class="col-sm-3 control-label">PIN (ZIP) code</label>
                                       <div class="col-sm-7"> 
                                       
                                          <input type="text" name="reference2Pincode" maxlength="10" class="form-control" id="reference2Pincode" placeholder="" onkeypress="return isNumber(event)" maxlength="6">
                                       </div>
                                       </div>
                                        
            						<h4 class="m-t-0 header-title" style="color:purple;">Additional Data</h4>                             
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">How did you hear about us?</label> 
                                       <div class="col-sm-7">
                                          <select name="hearedUsid" id="hearedUsid" class="selectpicker" data-style="btn-white">
                                             <option value="" disabled selected>Select</option>
                                             <c:if test="${!empty hearedUsType}">
		                                       		<c:forEach items="${hearedUsType}" var="hearedUs">
		                                       			<option value="${hearedUs.getHearedUsId()}">${hearedUs.getHearedUsTitle()}</option>
		                                       		</c:forEach>
		                                       </c:if>
		                                  </select>
                                       </div>
                                    </div>
                                    
                       <h4 class="m-t-0 header-title" style="color:purple;">Upload Photo and Signature</h4> 
                                    
                                    <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="">Upload Photo</label>
                                       <div class="col-sm-7">
                                          <input type="file" name="candidateProfilePicture" class="filestyle" data-size="md" id="candidateProfilePicture"> 
                                            
                                            <br>
                                          <div id="image-holder1">
                                          </div>
                                          </div>
                                    </div>
                                    <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="">Upload Scanned Signature</label>
                                       <div class="col-sm-7">
                                          <input type="file" name="candidateSignature" class="filestyle" data-size="md" id="candidateSignature"> 
                                          <br>
                                           <div id="image-holder2">
                                          </div>
                                        </div>
                                    </div>
                              </div>
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="contactdetails" aria-labelledby="contactdetails-tab">
                              <div class="form-body">
                                     <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 1<span class="at-required-highlight">*</span></label>
                                         <div class="col-sm-7"> 
                                          <input type="text" name="candidateAddressLine1" class="form-control" maxlength="100" required="required" id="candidateAddressLine1" placeholder="">
                                         </div>
                                      </div>
                                       <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 2<span class="at-required-highlight">*</span></label>
                                        <div class="col-sm-7"> 
                                          <input type="text" name="candidateAddressLine2" class="form-control" maxlength="100" required="required" id="candidateAddressLine2" placeholder="">
                                       </div>
                                       </div>
                                       
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mobile Number<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="mobileNumber" class="form-control" maxlength="20" required="required" id="mobileNumber" maxlength="15" placeholder="" onkeypress="return isNumber(event)">
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">E-Mail<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="candidateEmail" maxlength="50" class="form-control form-control-email" id="candidateEmail" placeholder="" required="required">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select  name="candidateCountryid" id="geographicallocation" data-live-search="true" class="selectpicker" data-style="btn-white" required="required">
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
                                       <label for="" class="col-sm-3 control-label">State<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="candidateStateid" id="geographicallocationstate" data-live-search="true" class="selectpicker" data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Country First </option>
                                          </select>
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">City<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="candidateCityid" id="geographicallocationcity" data-live-search="true" class="selectpicker" data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select State First </option>
                                          </select>
                                       </div>
                                    </div>
                                   
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Post Code<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="candidatePostCode" maxlength="10" class="form-control" id="candidatePostCode" placeholder="" required="required" onkeypress="return isNumber(event)" maxlength="6">
                                       </div>
                                    </div>
                                    
                                
                              </div>
                           </div>
                           
                           <div role="tabpanel" class="tab-pane fade" id="educationalqualifications" aria-labelledby="educationalqualifications-tab">
                              <div class="form-body">
                                 
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Education Level<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <select name="educationLevelId" id="educationLevelId" class="selectpicker" data-style="btn-white" required="required">
                                             	<option value="" disabled selected>Select Level</option>
                                             	<c:if test="${!empty  educationQualificationLevelList}">
		                                       		<c:forEach items="${educationQualificationLevelList}" var="educationQualificationLevel">
		                                       				<option value="${educationQualificationLevel.getEducationLevelId()}">${educationQualificationLevel.getEducationLevelTitle()}</option>
		                                       		</c:forEach>
		                                       	</c:if>
                                          </select>                                       
                                          </div>
                                    </div> 
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Name of Degree/Course<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="nameofDegree" maxlength="100" class="form-control" id="nameofDegree" required="required" placeholder="">
                                       </div>
                                    </div>
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Board And University Name<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="boardAndUniversity" maxlength="100" class="form-control" id="boardAndUniversity" placeholder="" required="required">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Institution Name<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="institutionName" maxlength="100" class="form-control" id="institutionName" placeholder="" required="required">
                                       </div>
                                    </div>
                                   
                              
                                          <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select  name="institutionCountryId" id="institutionCountryId" data-live-search="true" class="selectpicker" data-style="btn-white" required="required">
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
                                       <label for="" class="col-sm-3 control-label">State<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="institutionStateId" id="institutionStateId" data-live-search="true" class="selectpicker" data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Country First </option>
                                          </select>
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">City<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="institutionCityId" id="institutionCityId" data-live-search="true" class="selectpicker" data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select State First </option>
                                          </select>
                                       </div>
                                    </div>
                                      <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Academic Start Date<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" required="required" maxlength="10" name="startDate" class="form-control form-control-datepicker" id="startDate" placeholder="">
                                       </div>
                                    </div>
                                      <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Academic End Date<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" required="required" maxlength="10" name="endDate" class="form-control form-control-datepicker" id="endDate" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Year Of Passing<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="yearOfPassing" maxlength="20" class="form-control" id="yearOfPassing" placeholder="" onkeypress="return isNumber(event)" required="required">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Marks Type<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="markType" id="markType" class="selectpicker" data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Marks Type </option>
                                             <option value="Percentage">Percentage</option>
                                              <option value="CGPA">CGPA</option>
                                               </select>
                                       </div>
                                    </div>
                                     <div id="educationLevelSubject"></div>
                                   <!--   <div class="form-group form-control-sslc" style="display: none;">
                                       <label for="" class="col-sm-3 control-label">Subject1</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="marksObtainedForSSLCSubject1" class="form-control form-control-sslc" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group form-control-sslc" style="display: none;">
                                       <label for="" class="col-sm-3 control-label">Subject2</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="marksObtainedForSSLCSubject2" class="form-control form-control-sslc" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group form-control-sslc" style="display: none;">
                                       <label for="" class="col-sm-3 control-label">Subject3</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="marksObtainedForSSLCSubject3" class="form-control form-control-sslc" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group form-control-sslc" style="display: none;">
                                       <label for="" class="col-sm-3 control-label">Subject4</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="marksObtainedForSSLCSubject4" class="form-control form-control-sslc" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group form-control-sslc" style="display: none;">
                                       <label for="" class="col-sm-3 control-label">Subject5</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="marksObtainedForSSLCSubject5" class="form-control form-control-sslc" id="" placeholder="">
                                       </div>
                                    </div>
                                    
                                    
                                    
                                       <div class="form-group form-control-hsc" style="display: none;">
                                       <label for="" class="col-sm-3 control-label">Physics</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="marksObtainedForHSCPhysics" class="form-control form-control-hsc" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group form-control-hsc" style="display: none;">
                                       <label for="" class="col-sm-3 control-label">Chemistry</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="marksObtainedForHSCChemistry" class="form-control form-control-hsc" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group form-control-hsc" style="display: none;">
                                       <label for="" class="col-sm-3 control-label">Biology/Botany/Others</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="marksObtainedForHSCBiologyBotanyOthers" class="form-control form-control-hsc" id="" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group form-control-hsc" style="display: none;">
                                       <label for="" class="col-sm-3 control-label">Maths/Zoology/Others</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="marksObtainedForHSCMathsZoologyOthers" class="form-control form-control-hsc" id="" placeholder="">
                                       </div>
                                    </div> -->
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">(OverAll) Marks Obtained<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="marksObtained" maxlength="50" class="form-control" required="required" id="marksObtained" placeholder="" onkeypress="return decimal(this,event,2)">
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Registration Number<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" maxlength="50" name="registrationNumber" class="form-control" required="required" id="registrationNumber" placeholder="">
                                       </div>
                                    </div>
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Certificate Number</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" maxlength="50" name="certificateNumber" class="form-control" id="certificateNumber" placeholder="">
                                       </div>
                                    </div>
                                    
                                   
                                 
                              </div>
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="course" aria-labelledby="course-tab">
                              <div class="form-body">
                                      <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Class<span class="at-required-highlight">*</span></label>
                                       <div class="col-sm-7">
                                          <select name="classId" id="classId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                          	<option value="" disabled selected>Select Class</option>
                                        	<c:if test="${!empty classList}">
		                                       			<c:forEach items="${classList}" var="classes">
		                                       					<option value="${classes.getClassId()}" >${classes.getClassName()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                 
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Admission Code <span class="at-required-highlight">*</span></label >
                                       <div class="col-sm-7">
                                          <select name="admissionCodeFormat" id="admissionCodeFormat" class="selectpicker" data-style="btn-white" required="required">
                                                <option value="" disabled selected>Select Class First</option>
                                        		<%-- <c:if test="${!empty admissionConfigList}">
		                                       			<c:forEach items="${admissionConfigList}" var="admissionConfigList">
		                                       					<option value="${admissionConfigList.getAdmissionConfigId()}" >${admissionConfigList.getApplicationCodeFormat()}</option>
		                                       			</c:forEach>
		                                       	</c:if> --%>
                                          </select>
                                       </div>
                                    </div>
                               
                                
                                    
                                
                              </div>
                              
                            <!--     <div class="col-sm-offset-3">
                                       <button style="float:right" id="admissionSave" type="button" name="admissionSave" class="btn btn-success">Save and Add Another Entry</button>
                                    </div> -->
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="document" aria-labelledby="document-tab">
                                    <table data-toggle="table"
                                 data-show-columns="false"
                                 data-page-list="[5, 10, 20]"
                                 data-page-size="5"
                                 data-pagination="true" data-show-pagination-switch="true" class="table-bordered ">
                                       <thead>
                                          <tr>
                                             <th data-field="Document_Title" data-switchable="false">Document Title</th>
                                             <th data-field="Upload_Document_File">Upload Document File</th>
                                             <th  data-field="Document_View">Document View</th>
                                          </tr>
                                       </thead>
                                       <tbody>
                                       		<c:if test="${!empty admissionDocumentTypeList}">
		                                       	<c:forEach items="${admissionDocumentTypeList}" var="admissionDocumentType">
		                                       		<tr class="active">
                                             				<td scope="row">${admissionDocumentType.getDocumentTypeTitle()}</td>
                                             				<td>
                                             				<c:if test="${ admissionDocumentType.getDocumentTypeId()==1 }">
	                                                			<div class="col-sm-7" >
	                                                   				<input type="file" class="filestyle" data-size="md" id="candidateSSLCCertificate" name="candidateSSLCCertificate"> 
	                                                   					<br>
	                                                   					 <div id="image-holder3">
                                          </div>
	                                                			</div>
	                                                			</c:if>
	                                                				<c:if test="${ admissionDocumentType.getDocumentTypeId()==2 }">
	                                                			<div class="col-sm-7" >
	                                                   				<input type="file" class="filestyle" data-size="md" id="candidateHSCertificate" name="candidateHSCertificate"> 
	                                                   					<br>
	                                                   					 <div id="image-holder4">
                                          </div>
	                                                			</div>
	                                                			</c:if>
	                                                				<c:if test="${ admissionDocumentType.getDocumentTypeId()==3 }">
	                                                			<div class="col-sm-7" >
	                                                   				<input type="file" class="filestyle" data-size="md" id="candidateTransferCertificate" name="candidateTransferCertificate"> 
	                                                   					<br>
	                                                   					 <div id="image-holder5">
                                          </div>
	                                                			</div>
	                                                			</c:if>
	                                                			<c:if test="${ admissionDocumentType.getDocumentTypeId()==4 }">
	                                                			<div class="col-sm-7" >
	                                                   				<input type="file" class="filestyle" data-size="md" id="candidatePreviousMarkSheetCertificate" name="candidatePreviousMarkSheetCertificate"> 
	                                                   					<br>
	                                                   					 <div id="image-holder6">
                                          </div>
	                                                			</div>
	                                                			</c:if>
                                             				</td>
                                             				<td>
				                                                <div class="thumbnail" style="height: 70%; width:70%">
				                                                   <img id="thumbnil" style="width:100%;  display: block;" src="${pageContext.request.contextPath}/resources/themes/images/edumaatlogo1.png" alt="" alt="image" />
				                                                </div>
                                             				</td>
                                          			</tr>
		                                       	</c:forEach>
		                                      </c:if>
                                       </tbody>
                                    </table>
                              
                             
                              
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="payment" aria-labelledby="payment-tab">
                           
                            <div class="custom welcome">
	<p style="text-align: justify;"><span style="font-size: 12pt; color: #f5911f;">Fees are payable to MANAGEMENT UNIVERSITY OF AFRICA at:</span></p>
                        
                            <p style="margin-left:150px">          Co-operative Bank A/c No. 01129504445300, Mombasa Road Branch</p>  
							<p style="margin-left:150px">           Equity Bank A/C No. 0550298813541, Westland's Branch</p>		  
                            <p style="margin-left:150px">            M-PESA Business No. 247247 Account no .0550298813541</p>
                                       
                            <p style="margin-left:150px">           Barclays Bank A/C No. 010-2023842818 Parkside Branch</p>
                           
                           </div>
                              <div class="form-group">
                                <%--  <button type="button" class="btn btn-info btn-custom waves-effect waves-light col-md-4" id="payumoney_button"><img src="${pageContext.request.contextPath}/resources/themes/images/payu_money.png" alt="Payu Money"></button>
                                --%>  <button  style="margin-left:10%" type="button"class="btn btn-success btn-custom waves-effect waves-light col-md-4">Pay Through Bank</button>
                              <button  type="button" class="btn btn-info btn-custom waves-effect waves-light col-md-4" id="rzp-button1">Pay Online</button>
                              </div>
                           </div>
                        </div>
                       </form>
                       </div>
            
            <div id="editFormDiv" style="display:none;">
               
                     
                       <form class="form-horizontal" id="editadmissionForm" method="post" action="${pageContext.request.contextPath}/admissions/candidate/newAdmission/save">
                        <div class="row">
                          <div class="col-sm-offset-3">
                                   <!--  <button  class="btn btn-info" type="button" id="admissionEdit">
      								<i class="fa fa-floppy-o"></i>
      								 </button> --><button  style="float: right;" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">
      								<i class="fa fa-times" aria-hidden="true"></i>
    				     </button>
      					</div>			
    				      </div>
                        <ul id="editmyTabs" class="nav nav-tabs" role="tablist">
                           <li role="presentation" class="active">
                              <a href="#editgeneralinstructions" id="editgeneralinstructions-tab" role="tab" data-toggle="tab" aria-controls="editgeneralinstructions" aria-expanded="true">General Instructions</a>
                           </li>
                           <li role="presentation">
                              <a href="#editpersonalinformation" id="editpersonalinformation-tab" role="tab" data-toggle="tab" aria-controls="editpersonalinformation" aria-expanded="false">Personal Information</a>
                           </li>
                           <li role="presentation" >
                              <a href="#editcontactdetails" role="tab" id="editcontactdetails-tab" data-toggle="tab" aria-controls="editcontactdetails" aria-expanded="false">Contact Details</a>
                           </li>
                           
                           <li role="presentation" >
                              <a href="#editeducationalqualifications" role="tab" id="editeducationalqualifications-tab" data-toggle="tab" aria-controls="editeducationalqualifications" aria-expanded="false">Educational Qualifications</a>
                           </li>
                           <li role="presentation" >
                              <a href="#editcourse" role="tab" id="editcourse-tab" data-toggle="tab" aria-controls="editcourse" aria-expanded="false">Apply for Course</a>
                           </li>
                           <li role="presentation" >
                              <a href="#editdocument" role="tab" id="editdocument-tab" data-toggle="tab" aria-controls="editdocument" aria-expanded="false">Upload Documents</a>
                           </li>
                           <li role="presentation" >
                              <a href="#editpayment" role="tab" id="editpayment-tab" data-toggle="tab" aria-controls="editpayment" aria-expanded="false">Payment</a>
                           </li>
                        </ul>
                        <div id="editmyTabContent" class="tab-content scrollbar1">
                           <div role="tabpanel" class="tab-pane fade active in" id="editgeneralinstructions" aria-labelledby="editgeneralinstructions-tab">
                              <p style="text-align: justify;">Applicants applying through online to their preferred course should pay application fees using net banking or debit/credit cards (only VISA cards) during step 4 in Admission for ${admissionConfig.getAdmissionProcessYear()} academic year by selecting online payment.</p>
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="editpersonalinformation" aria-labelledby="editpersonalinformation-tab">
                              <div class="form-body">
                                
                                 
                                  <h4 class="m-t-0 header-title" style="color:purple;">Applicant Information</h4>  
                                 
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant's First Name<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text"  name="editcandidateFirstName" class="form-control" id="editcandidateFirstName" placeholder="" required="required">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant's Last Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editcandidateLastName" class="form-control" id="editcandidateLastName" placeholder="">
                                       </div>
                                    </div>
                                   
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Gender<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select required="required" name="editcandidateGender" id="editcandidateGender" class="selectpicker" data-style="btn-white">
                                             <option value="" disabled selected>Select Gender</option>
                                              <option value="Male">Male</option>
                                             <option value="Female">Female</option>
                                              <option value="Others">Others</option>
                                          </select>
                                       </div>
                                    </div>
                                    
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Date Of Birth<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" required="required" name="editdateOfBirth" class="form-control form-control-datepicker" id="editdateOfBirth" placeholder="">
                                       </div>
                                    </div>
                                   
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">religion<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editreligionId" id="editreligionId" required="required" class="selectpicker" data-style="btn-white">
                                          		<option value="" disabled selected>Select Category</option>
		                                          <c:if test="${!empty religionList}">
		                                       		<c:forEach items="${religionList}" var="religion">
		                                       			<option value="${religion.getReligionId()}">${religion.getReligionName()}</option>
		                                       		</c:forEach>
		                                       	  </c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant Category<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editcategoryId" id="editcategoryId" required="required" class="selectpicker" data-style="btn-white">
                                          		<option value="" disabled selected>Select Category</option>
		                                          <c:if test="${!empty categoryList}">
		                                       		<c:forEach items="${categoryList}" var="category">
		                                       			<option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
		                                       		</c:forEach>
		                                       	  </c:if>
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Applicant Special Category<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editspecialCategoryId" id="editspecialCategoryId" required="required" class="selectpicker" data-style="btn-white">
                                             <option value="" disabled selected>Select Special Category</option>
                                             	<c:if test="${!empty specialCategoryList}">
		                                       		<c:forEach items="${specialCategoryList}" var="specialCategory">
		                                       			   <option value="${specialCategory.getSpecialCategoryId()}">${specialCategory.getSpecialCategoryName()}</option>
		                                       		</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Passport or ID No.</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editpassportNo" class="form-control" id="editpassportNo" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country ID Issued</label> 
                                       <div class="col-sm-7"> 
                                              <select name="editpassportissuedCountryId" id="editpassportissuedCountryId" class="selectpicker" data-style="btn-white">
                                             	<option value="" disabled selected>Select Country </option>
                                             		<c:if test="${!empty countryList}">
		                                       			<c:forEach items="${countryList}" var="country">
		                                       				<option value="${country.getGeographicalLocationId()}">${country.getName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                              
                                             </select>                                      </div>
                                    </div>
                                    
                                      <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Studied here before?</label> 
                                       <div class="col-sm-7">
                                          <select name="editIsStudiedBefore" id="editIsStudiedBefore" class="selectpicker" data-style="btn-white">
                                             <option value="" disabled selected>Select Yes/No</option>
                                             <option value="Yes">Yes</option>
                                             <option value="No">No</option>
                                          </select>
                                       </div>
                                    </div>
                                    
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Previous Student ID of this institute</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editpreviousStudentId" class="form-control" id="editpreviousStudentId" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Who will sponsor your studies here?</label> 
                                       <div class="col-sm-7">
                                          <select name="editsponserId" id="editsponserId" class="selectpicker" data-style="btn-white">
                                             <option value="" disabled selected>Sponsored by</option>
                                             	<c:if test="${!empty sponserList}">
		                                       			<c:forEach items="${sponserList}" var="sponser">
		                                       				<option value="${sponser.getSponserId()}">${sponser.getSponserTitle()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Do you have any disability?<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editisDisability" required="required" id="editisDisability" class="selectpicker" data-style="btn-white">
                                             <option value="" disabled selected>Select Yes/No</option>
                                             <option value="Yes">Yes</option>
                                             <option value="No">No</option>
                                          </select>
                                       </div>
                                    </div>
                                    
                     <h4 class="m-t-0 header-title" style="color:purple;">Parents and Guardian</h4>                 
                        <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Father's First Name<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editfatherFirstName" class="form-control" required="required" id="editfatherFirstName" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Father's Last Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editfatherLastName" class="form-control" id="editfatherLastName" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Father's Occupation</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editfatherOccupation" class="form-control" id="editfatherOccupation" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mother's First Name<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editmotherFirstName" class="form-control" required="required" id="editmotherFirstName" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mother's Last Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editmotherLastName" class="form-control" id="editmotherLastName" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mother's Occupation</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text"  name="editmotherOccupation"class="form-control" id="editmotherOccupation" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Father Income</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editfatherIncome" class="form-control" id="editfatherIncome" placeholder="" onkeypress="return isFloatNumber(this,event)">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mother Income</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editmotherIncome" class="form-control" id="editmotherIncome" placeholder="" onkeypress="return isFloatNumber(this,event)">
                                       </div>
                                    </div>
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Guardian's First Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text"  name="editguardianFirstName" class="form-control" id="editguardianFirstName" required="required" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Guardian's Last Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editguardianLastName" class="form-control" id="editguardianLastName"  placeholder="">
                                       </div>
                                    </div>
                                                
                                    
                                  <h4 class="m-t-0 header-title" style="color:purple;">Details of References</h4>  
                                    <div class="form-group">
                                     <label for="" class="col-sm-2 control-label "><span>Reference 1</span></label> 
                                    </div>
                                      
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">First Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editreference1FirstName" class="form-control" id="editreference1FirstName" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Last Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text"  name="editreference1LastName" class="form-control" id="editreference1LastName" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                         <label for="" class="col-sm-3 control-label">E-Mail</label>
                                       <div class="col-sm-7"> 
                                      
                                          <input type="text" name="editreference1Email" class="form-control form-control-email" id="editreference1Email" placeholder="">
                                       </div>
                                       </div>
                                       <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Mobile No</label>
                                       <div class="col-sm-7"> 
                                       
                                          <input type="text" name="editreference1Mobile" class="form-control" id="editreference1Mobile" placeholder="" onkeypress="return isNumber(event)" maxlength="15">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="" class="col-sm-3 control-label ">Address Line 1</label>
                                        <div class="col-sm-7"> 
                                          <input type="text" name="editreference1AddressLine1" class="form-control" id="editreference1AddressLine1" placeholder="">
                                         </div>
                                        </div> 
                                        <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 2</label>
                                       <div class="col-sm-7"> 
                                        
                                          <input type="text" name="editreference1AddressLine2" class="form-control" id="editreference1AddressLine2" placeholder="">
                                       </div>
                                       </div>
                                        <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country</label> 
                                       <div class="col-sm-7">
                                          <select name="editreference1CountryId" id="editreference1CountryId" class="selectpicker" data-style="btn-white">
                                             <option value="" disabled selected>Select Country </option>
                                            <c:if test="${!empty countryList}">
		                                       			<c:forEach items="${countryList}" var="country">
		                                       				<option value="${country.getGeographicalLocationId()}">${country.getName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>                                        
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">PIN (ZIP) code</label>
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editreference1Pincode" class="form-control" id="editreference1Pincode" placeholder="" onkeypress="return isNumber(event)" maxlength="6">
                                       </div>
                                       </div>
                                       
                                  
                                <div class="form-group">     
                           <label for="" class="col-sm-2 control-label"><span>Reference 2</span></label>
                           </div>            
                                
                                     

                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">First Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editreference2FirstName" class="form-control" id="editreference2FirstName" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Last Name</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editreference2LastName" class="form-control" id="editreference2LastName" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                          <label for="" class="col-sm-3 control-label">E-Mail</label>
                                        
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editreference2Email"  class="form-control form-control-email" id="editreference2Email" placeholder="">
                                       </div>
                                       </div>
                                        <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Mobile No</label>
                                       <div class="col-sm-7"> 
                                        <input type="text" name="editreference2Mobile" class="form-control" id="editreference2Mobile" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 1</label>
                                         <div class="col-sm-7"> 
                                          <input type="text" name="editreference2AddressLine1" class="form-control" id="editreference2AddressLine1" placeholder="">
                                         </div>
                                      </div>
                                       <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 2</label>
                                        <div class="col-sm-7"> 
                                          <input type="text" name="editreference2AddressLine2" class="form-control" id="editreference2AddressLine2" placeholder="">
                                       </div>
                                       </div>
                                        <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country</label> 
                                       <div class="col-sm-7">
                                          <select name="editreference2CountryId" id="editreference2CountryId" class="selectpicker" data-style="btn-white">
                                             <option value="" disabled selected>Select Country </option>
                                            	<c:if test="${!empty countryList}">
		                                       			<c:forEach items="${countryList}" var="country">
		                                       				<option value="${ country.getGeographicalLocationId()}">${country.getName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>                                
                                        <div class="form-group">
                                         <label for="" class="col-sm-3 control-label">PIN (ZIP) code</label>
                                       <div class="col-sm-7"> 
                                       
                                          <input type="text" name="editreference2Pincode" class="form-control" id="editreference2Pincode" placeholder="" onkeypress="return isNumber(event)" maxlength="6">
                                       </div>
                                       </div>
                                        
            						<h4 class="m-t-0 header-title" style="color:purple;">Additional Data</h4>                             
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">How did you hear about us?</label> 
                                       <div class="col-sm-7">
                                          <select name="edithearedUsid" id="edithearedUsid" class="selectpicker" data-style="btn-white">
                                             <option value="" disabled selected>Select</option>
                                             <c:if test="${!empty hearedUsType}">
		                                       		<c:forEach items="${hearedUsType}" var="hearedUs">
		                                       			<option value="${hearedUs.getHearedUsId()}">${hearedUs.getHearedUsTitle()}</option>
		                                       		</c:forEach>
		                                       </c:if>
		                                  </select>
                                       </div>
                                    </div>
                                    
                       <h4 class="m-t-0 header-title" style="color:purple;">Upload Photo and Signature</h4> 
                                    
                                    <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="">Upload Photo</label>
                                       <div class="col-sm-7">
                                          <input type="file" name="editphotoFile" class="filestyle" data-size="md" id="editphotoFile"> 
                                           
                                           <br> <div id="editimage-holder1" >

                                    <img src="#" id="editcandidateProfilePhotoImage" class="thumb-image"></img>
                                    </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                       <label  class="col-sm-3 control-label" for="">Upload Scanned Signature</label>
                                       <div class="col-sm-7">
                                          <input type="file" name="editsignatureFile" class="filestyle" data-size="md" id="editsignatureFile"> 
                                          
                                          <br>  <div id="editimage-holder2" >

                                    <img src="#" id="editcandidateSignatureImage" class="thumb-image"></img>
                                    </div>
                                       </div>
                                    </div>
                              </div>
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="editcontactdetails" aria-labelledby="editcontactdetails-tab">
                              <div class="form-body">
                                     <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 1<span class="at-required-highlight">*</span></label>
                                         <div class="col-sm-7"> 
                                          <input type="text" name="editcandidateAddressLine1" class="form-control" required="required" id="editcandidateAddressLine1" placeholder="">
                                         </div>
                                      </div>
                                       <div class="form-group">
                                        <label for="" class="col-sm-3 control-label">Address Line 2<span class="at-required-highlight">*</span></label>
                                        <div class="col-sm-7"> 
                                          <input type="text" name="editcandidateAddressLine2" class="form-control" required="required" id="editcandidateAddressLine2" placeholder="">
                                       </div>
                                       </div>
                                       
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Mobile Number<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editmobileNumber" class="form-control" required="required" id="editmobileNumber" maxlength="15" placeholder="" onkeypress="return isNumber(event)">
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">E-Mail<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editcandidateEmail" class="form-control form-control-email" id="editcandidateEmail" placeholder="" required="required">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select  name="editcandidateCountryid" id="editgeographicallocation" data-live-search="true" class="selectpicker" data-style="btn-white" required="required">
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
                                       <label for="" class="col-sm-3 control-label">State<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editcandidateStateid" id="editgeographicallocationstate" data-live-search="true" class="selectpicker" data-style="btn-white" required="required">
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
                                       <label for="" class="col-sm-3 control-label">City<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editcandidateCityid" id="editgeographicallocationcity" data-live-search="true" class="selectpicker" data-style="btn-white" required="required">
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
                                       <label for="" class="col-sm-3 control-label">Post Code<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editcandidatePostCode" class="form-control" id="editcandidatePostCode" placeholder="" required="required" onkeypress="return isNumber(event)" maxlength="6">
                                       </div>
                                    </div>
                                    
                                
                              </div>
                           </div>
                           
                           <div role="tabpanel" class="tab-pane fade" id="editeducationalqualifications" aria-labelledby="editeducationalqualifications-tab">
                              <div class="form-body">
                                 
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Education Level<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <select name="editeducationLevelId" id="editeducationLevelId" class="selectpicker" data-style="btn-white" required="required">
                                             	<option value="" disabled selected>Select Level</option>
                                             	<c:if test="${!empty  educationQualificationLevelList}">
		                                       		<c:forEach items="${educationQualificationLevelList}" var="educationQualificationLevel">
		                                       				<option value="${educationQualificationLevel.getEducationLevelId()}">${educationQualificationLevel.getEducationLevelTitle()}</option>
		                                       		</c:forEach>
		                                       	</c:if>
                                          </select>                                       
                                          </div>
                                    </div> 
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Name of Degree/Course<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editnameofDegree" class="form-control" id="editnameofDegree" required="required" placeholder="">
                                       </div>
                                    </div>
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Board And University Name<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editboardAndUniversity" class="form-control" id="editboardAndUniversity" placeholder="" required="required">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Institution Name<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editinstitutionName" class="form-control" id="editinstitutionName" placeholder="" required="required">
                                       </div>
                                    </div>
                                   
                              
                                          <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select  name="editinstitutionCountryId" id="editinstitutionCountryId" data-live-search="true" class="selectpicker" data-style="btn-white" required="required">
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
                                       <label for="" class="col-sm-3 control-label">State<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editinstitutionStateId" id="editinstitutionStateId" data-live-search="true" class="selectpicker" data-style="btn-white" required="required">
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
                                       <label for="" class="col-sm-3 control-label">City<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editinstitutionCityId" id="editinstitutionCityId" data-live-search="true"  class="selectpicker" data-style="btn-white" required="required">
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
                                       <label for="" class="col-sm-3 control-label">Academic Start Date<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" required="required" name="editstartDate" class="form-control form-control-datepicker" id="editstartDate" placeholder="">
                                       </div>
                                    </div>
                                      <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Academic End Date<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" required="required" name="editendDate" class="form-control form-control-datepicker" id="editendDate" placeholder="">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Year Of Passing<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="edityearOfPassing" class="form-control" id="edityearOfPassing" placeholder="" onkeypress="return isNumber(event)" required="required">
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Marks Type<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editmarkType" id="editmarkType" class="selectpicker" data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Marks Type </option>
                                             <option value="Percentage">Percentage</option>
                                              <option value="CGPA">CGPA</option>
                                               </select>
                                       </div>
                                    </div>
                                     <div id="editeducationLevelSubject"></div>
                            
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">(OverAll) Marks Obtained<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editmarksObtained" class="form-control" required="required" id="editmarksObtained" placeholder=""onkeypress="return isNumber(event)">
                                       </div>
                                    </div>
                                    
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Registration Number<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editregistrationNumber" class="form-control" required="required" id="editregistrationNumber" placeholder="">
                                       </div>
                                    </div>
                                     <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Certificate Number</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="editcertificateNumber" class="form-control" id="editcertificateNumber" placeholder="">
                                       </div>
                                    </div>
                                    
                                   <!--   <div class="col-sm-offset-3">
                                       <button style="float:right" id="updateEducationLevel" name="updateEducationLevel" class="btn btn-success">Save and Add Another Entry</button>
                                    </div> -->
                                 
                              </div>
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="editcourse" aria-labelledby="editcourse-tab">
                              <div class="form-body">
                                 
                                 
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Class<span class="at-required-highlight">*</span></label>
                                       <div class="col-sm-7">
                                          <select name="editclassId" id="editclassId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                          	<option value="" disabled selected>Select Class</option>
                                        	<c:if test="${!empty classList}">
		                                       			<c:forEach items="${classList}" var="classes">
		                                       					<option value="${classes.getClassId()}" >${classes.getClassName()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                  <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Admission Code <span class="at-required-highlight">*</span></label >
                                       <div class="col-sm-7">
                                          <select name="editadmissionCodeFormat" id="editadmissionCodeFormat" class="selectpicker" data-style="btn-white" required="required">
                                                <option value="" disabled selected>Select Admission Code</option>
                                        		<c:if test="${!empty admissionConfigList}">
		                                       			<c:forEach items="${admissionConfigList}" var="admissionConfigList">
		                                       					<option value="${admissionConfigList.getAdmissionConfigId()}" >${admissionConfigList.getApplicationCodeFormat()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                 </div>
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="editdocument" aria-labelledby="editdocument-tab">
                              <div class="tables">
                                 <div class="table-responsive bs-example widget-shadow">
                                    <table class="table">
                                       <thead>
                                          <tr>
                                             <th>Document Title</th>
                                             <th>Upload Document File</th>
                                             <th>Document View</th>
                                          </tr>
                                       </thead>
                                       <tbody>
                                       		<c:if test="${!empty admissionDocumentTypeList}">
		                                       	<c:forEach items="${admissionDocumentTypeList}" var="admissionDocumentType">
		                                       		<tr class="active">
                                             				<td scope="row">${admissionDocumentType.getDocumentTypeTitle()}</td>
                                             				<td>
	                                                			<c:if test="${ admissionDocumentType.getDocumentTypeId()==1 }">
	                                                			<div class="col-sm-7" >
	                                                   				<input type="file" class="filestyle" data-size="md" id="editcandidateSSLCCertificate" name="editcandidateSSLCCertificate"> 
	                                                   					<br> <div id="editimage-holder3">
	                                                   					   <img src="#" id="editcandidateSSLCCertificateImage" class="thumb-image"></img>
                                          </div>		</div>
	                                                			</c:if>
	                                                				<c:if test="${ admissionDocumentType.getDocumentTypeId()==2 }">
	                                                			<div class="col-sm-7" >
	                                                   				<input type="file" id="editcandidateHSCertificate" class="filestyle" data-size="md" name="editcandidateHSCertificate"> 
	                                                   				<br>	 <div id="editimage-holder4">
	                                                   					   <img src="#" id="editcandidateHSCertificateImage" class="thumb-image"></img>
                                          </div>   			</div>
	                                                			</c:if>
	                                                				<c:if test="${ admissionDocumentType.getDocumentTypeId()==3 }">
	                                                			<div class="col-sm-7" >
	                                                   				<input type="file" id="editcandidateTransferCertificate" class="filestyle" data-size="md" name="editcandidateTransferCertificate"> 
	                                                   				<br>	 <div id="editimage-holder5">
	                                                   					   <img src="#" id="editcandidateTransferCertificateImage" class="thumb-image"></img>
                                          </div>   			</div>
	                                                			</c:if>
	                                                				<c:if test="${ admissionDocumentType.getDocumentTypeId()==4 }">
	                                                			<div class="col-sm-7" >
	                                                   				<input type="file" class="filestyle" data-size="md" id="editcandidatePreviousMarkSheetCertificate" name="editcandidatePreviousMarkSheetCertificate"> 
	                                                   					<br>
	                                                   				 <div id="editimage-holder6">
	                                                   					   <img src="#" id="editcandidatePreviousMarkSheetCertificateImage" class="thumb-image"></img>
                                          </div> 
	                                                			</div>
	                                                			</c:if>
                                             				</td>
                                             				<td>
				                                                <div class="thumbnail" style="height: 70%; width:70%">
				                                                   <img id="thumbnil" style="width:100%;  display: block;" src="${pageContext.request.contextPath}/resources/themes/images/edumaatlogo3.png" alt="" alt="image" />
				                                                </div>
                                             				</td>
                                          			</tr>
		                                       	</c:forEach>
		                                      </c:if>
                                       </tbody>
                                    </table>
                                 </div>
                              </div>
                             
                              
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="editpayment" aria-labelledby="editpayment-tab">
                           
                            <div class="custom welcome">
	<p style="text-align: justify;"><span style="font-size: 12pt; color: #f5911f;">Fees are payable to MANAGEMENT UNIVERSITY OF AFRICA at:</span></p>
                        
                            <p style="margin-left:150px">          Co-operative Bank A/c No. 01129504445300, Mombasa Road Branch</p>  
							<p style="margin-left:150px">           Equity Bank A/C No. 0550298813541, Westland's Branch</p>		  
                            <p style="margin-left:150px">            M-PESA Business No. 247247 Account no .0550298813541</p>
                                       
                            <p style="margin-left:150px">           Barclays Bank A/C No. 010-2023842818 Parkside Branch</p>
                           
                           </div>
                              <div class="form-group">
                                 <%-- <button type="button" class="btn btn-info btn-custom waves-effect waves-light col-md-4" id="rzp-button1"><img src="${pageContext.request.contextPath}/resources/themes/images/payu_money.png" alt="Payu Money"></button>
                                 <button  style="margin-left:10%" type="button"class="btn btn-success btn-custom waves-effect waves-light col-md-4">Pay Through Bank</button>
                               --%>
                               <button  style="margin-left:10%" type="button"class="btn btn-success btn-custom waves-effect waves-light col-md-4">Pay Through Bank</button>
                              <button  type="button" class="btn btn-info btn-custom waves-effect waves-light col-md-4" id="rzp-button2">Pay Online</button>
                            </div>
                           </div>
                        </div>
                       </form>
                   
            </div>
              <div class="modal fade" id="admissionSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure? you want to save your application??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="admissionSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
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
        <%--  <script src="${pageContext.request.contextPath}/resources/themes/script/studentregistration.js" type="text/javascript"></script> --%>
  <script src="${pageContext.request.contextPath}/resources/themes/script/admission.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/geographicallocation.js"></script>
      
    
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script>
var options = {
    "key": "rzp_test_zDuv2PVFTKPRkT",
    "amount": "20000", // 2000 paise = INR 20
    "name": "Anand",
    "description": "Admission Fee",
    "image": "${pageContext.request.contextPath}/resources/themes/images/edumaatlogo1.png",
    "handler": function (response){
       // alert(response.razorpay_payment_id);
        if(response.razorpay_payment_id)
        {
        	 edumaatAlert({
   			  title: "Success !",
   			  text: "Transaction Succesfully Completed...!",
   			  type: "success",
   			  confirmButtonText: "Done"
   			});
        }
        else
        {
        	edumaatAlert({
     			  title: "Failed !",
     			  text: "Transaction Failed...!",
     			  type: "failed",
     			  confirmButtonText: "Done"
     			});
        }
       
    },
    "prefill": {
        "name": "Harshil Mathur",
        "email": "joanand009@gmail.com"
    },
    "notes": {
        "address": "Hello World"
    },
    "theme": {
        "color": "#F37254"
    }
};
var rzp1 = new Razorpay(options);

document.getElementById('rzp-button1').onclick = function(e){
    rzp1.open();
    e.preventDefault();
}
</script>
<script>
var options = {
    "key": "rzp_test_zDuv2PVFTKPRkT",
    "amount": "20000", // 2000 paise = INR 20
    "name": "Anand",
    "description": "Admission Fee",
    "image": "${pageContext.request.contextPath}/resources/themes/images/edumaatlogo1.png",
    "handler": function (response){
       // alert(response.razorpay_payment_id);
        if(response.razorpay_payment_id)
        {
        	 edumaatAlert({
   			  title: "Success !",
   			  text: "Transaction Succesfully Completed...!",
   			  type: "success",
   			  confirmButtonText: "Done"
   			});
        }
        else
        {
        	edumaatAlert({
     			  title: "Failed !",
     			  text: "Transaction Failed...!",
     			  type: "failed",
     			  confirmButtonText: "Done"
     			});
        }
       
    },
    "prefill": {
        "name": "Harshil Mathur",
        "email": "joanand009@gmail.com"
    },
    "notes": {
        "address": "Hello World"
    },
    "theme": {
        "color": "#F37254"
    }
};
var rzp1 = new Razorpay(options);

document.getElementById('rzp-button2').onclick = function(e){
    rzp1.open();
    e.preventDefault();
}
</script>
   </body>
</html>