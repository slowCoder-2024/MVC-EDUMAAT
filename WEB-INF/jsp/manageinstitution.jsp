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
        <style type="text/css">
        
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
   <div class="loader" style="display: none"></div>
            <div id="ListDiv" style="display:block;">
                  <security:authorize access="hasRole('manageinstitution/add')">
                
               <div class="form-group">
                  <button type="button" class="btn btn-primary btn-custom waves-effect waves-light col-md-3" onclick="showDiv()">Add New Institution</button>
               </div>
               
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                  </security:authorize>
                  
                  <br />
                   <security:authorize access="hasRole('manageinstitution/viewlist')">
 
          
                  <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Institutions</b></h4>
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
                                      <th>Institution Id</th>
                                      <th>Institution Name</th>
	                                  <th>Institution Country</th>
                                      <th>Institution Contact</th>
                                        <security:authorize access="hasAnyRole('manageinstitution/view','manageinstitution/delete')">
                                      <th>Action</th>
                                      </security:authorize>
                                 </tr>
                              </thead>
                              <tbody id="institutionlist">
                               <c:if test="${!empty institutionList}">
                               
                               
                                       <c:forEach items="${institutionList}" var="institution">
                                       
                                          <tr>
                                             <td>${institution.getInstitutionId()}</td>
                                             <td>${institution.getInstitutionName()}</td>
                                             <td>${institution.getInstitutionCountry()}</td>
                                             <td>${institution.getInstitutionContact()}</td>
                                           <security:authorize access="hasAnyRole('manageinstitution/view','manageinstitution/delete')">
                                             <td>
                                                <security:authorize access="hasRole('manageinstitution/view')">                                              
 									<a href="#" id="edit"  type="button"data-href="#" data-id="${institution.getInstitutionId()}" data-toggle="modal" onclick="showeditDiv()">
                                    				<i class="fa fa-pencil" style="margin-right: 15px"></i>
                                    			</a>
                                    			</security:authorize>
                                    			   <security:authorize access="hasRole('manageinstitution/delete')">
                                     
	                                   			<a href="#"  id="delete"  type="button" data-href="#"  data-id="${institution.getInstitutionId()}" data-toggle="modal" data-target="#confirm-delete">
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
                    <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
			               <div class="modal-dialog" role="document">
			                  <div class="modal-content">
			                     <div class="modal-header">
			                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
			                     </div>
			                     <div class="modal-body">
			                        <h5>Are you sure ?, You want to delete this Institution??</h5>
			                     </div>
			                     <div class="modal-footer">
			                       <form id="deleteInstitutionForm" action="${pageContext.request.contextPath}/institution/manageinstitution/delete" method="post">
                           <input type="hidden" id="deleteInstitutionId" name="deleteInstitutionId">
                           <button type="button" id="confirmInstitutionDelete"  class="btn btn-primary" data-dismiss="modal">Yes</button>
							</form>
			                     </div>
			                  </div>
			               </div>
           			 </div>
                     
                    
                     
                     
                 
             
            </div>
              <div id="EditFormDiv" style="display:none;">
            <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Edit Institution</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                         <form class="form-horizontal" id="updateInstitutionDetails" action="${pageContext.request.contextPath}/institution/manageinstitution/update" method="post" enctype='multipart/form-data'>
                        <fieldset id="editFirstStep" class="" >
                        
                     
                          <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editInstitutionCode" class="form-control" id="editInstitutionCode" placeholder="" required="required" maxlength="255">
                                 </div>
                              </div>
                                       <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editInstitutionName" class="form-control" id="editInstitutionName" placeholder="" required="required" maxlength="255">
                                 </div>
                              </div>
                          
                                <div class="form-group">
                                 <label for="institutionProfilePic" class="col-sm-3 control-label">Institution Logo</label> 
                                <div class="col-sm-7">
                                    <input name="editInstitutionProfilePic" id="editInstitutionProfilePic" class="filestyle" data-size="md" type="file"/>
                                    <br> 
                                    <div id="image-holder1">
                                 
                                    <img src="#" id="institutionImage" class="thumb-image"></img>
                                    </div>
									</div>
								</div>
								 <div class="form-group">
                                 <label for="institutionProfilePic" class="col-sm-3 control-label">Institution Authorized Signature</label> 
                                <div class="col-sm-7">
                                    <input name="editInstitutionAuthorizedSignaturePic" id="editInstitutionAuthorizedSignaturePic" class="filestyle" data-size="md" type="file"/>
                                    <br> 
                                    <div id="image-aholder1">
                                 
                                    <img src="#" id="institutionAuthorizedSignatureImage" class="thumb-image"></img>
                                    </div>
									</div>
								</div>
                            
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                     <input type="text" name="editInstitutionEmail" class="required email form-control" id="editInstitutionEmail" placeholder=""  required="required" maxlength="100">
                                   
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Contact<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                     <input type="text" name="editInstitutionContact" class="form-control" id="editInstitutionContact" placeholder="" required="required" onkeypress="return isNumber(event)" maxlength="20">
                                   
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Address Line 1 <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                     <input type="text" name="editInstitutionAddressLine1" class="form-control" id="editInstitutionAddressLine1" placeholder="" required="required" maxlength="255">
                                   
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Address Line 2<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                     <input type="text" name="editInstitutionAddressLine2" class="form-control" id="editInstitutionAddressLine2" placeholder="" required="required" maxlength="255">
                                   
                                 </div>
                              </div>
                              
                          	<div class="form-group">
                                                  <label for="" class="col-sm-3 control-label">Institution Country<span class="at-required-highlight">*</span></label>
                                                      <div class="col-sm-7">   
                                                        <select name="editInstitutionCountry" id="geographicallocation1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
					                                       <c:if test="${!empty geographicallocationList}">
					                                          <option value="" disabled selected>Select Country </option>
					                                          <c:forEach items="${geographicallocationList}" var="geographicallocation">
					                                             <option id="${geographicallocation.getName()}" value="${geographicallocation.getName()}">${geographicallocation.getName()}</option>
					                                          </c:forEach>
					                                       </c:if>
                                    					</select>
                                                    </div>
                                                </div>
												<div class="form-group">
                                                   <label for="" class="col-sm-3 control-label">Institution State<span class="at-required-highlight">*</span> </label>
                                                       <div class="col-sm-7">   
                                                        <select name="editInstitutionState" id="geographicallocationstate1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                    	 						<c:if test="${!empty geographicallocationStateList}">
                                          <option value="" disabled selected>Select State</option>
                                          <c:forEach items="${geographicallocationStateList}" var="geographicallocation">
                                             <option id="${geographicallocation.getName()}" value="${geographicallocation.getName()}" >${geographicallocation.getName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    					</select>
                                                    </div>
                                                </div>
												<div class="form-group ">
                                                    <label for="" class="col-sm-3 control-label">Institution City<span class="at-required-highlight">*</span> </label>
                                                      <div class="col-sm-7">   
                                                        <select name="editInstitutionCity" id="geographicallocationcity1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                     						  <c:if test="${!empty geographicallocationCityList}">
                                          <option value="" disabled selected>Select City </option>
                                          <c:forEach items="${geographicallocationCityList}" var="geographicallocation">
                                             <option id="${geographicallocation.getName()}" value="${geographicallocation.getName()}">${geographicallocation.getName()}</option>
                                          </c:forEach>
                                       </c:if>
                                     					</select>
                                                    </div>
                                                </div>
                              
                     					    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Currency<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="editCurrencyCode" id="editCurrencyCode" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <c:if test="${!empty currencyList}">
                                          <option value="" disabled selected>Select Currency</option>
                                          <c:forEach items="${currencyList}" var="currency">
                                             <option  value="${currency.getIsoCode()}">${currency.getIsoCode()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                 </div>
                              </div>
                               
									   
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Post Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                     <input type="text" name="editInstitutionPostCode" class="form-control" id="editInstitutionPostCode" placeholder="" required="required" onkeypress="return isNumber(event)" maxlength="6">
                                   
                                 </div>
                              </div>     
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="editInstitutionStatus" id="editInstitutionStatus" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Collect Receipts InOrder<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="editCollectReceiptsInOrder" id="editCollectReceiptsInOrder" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Collect Receipts InOrder</option>
                                       <option value="1">Yes</option>
                                       <option value="0">No</option>
                                      </select>
                                 </div>
                              </div>
                               <div class="row">
                                  <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  id="editNextButton" class="btn btn-success btn-custom waves-effect waves-light" type="button">Next</button>
                                    <button style="float: right" class="btn btn-info btn-custom waves-effect waves-light" type="reset">Clear</button>
                                   <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                    
                                 </div>
                              </div>
                            </fieldset>
                                <fieldset id="editSecondStep" class="" style="display:none;">
                                                         <h4 class="m-t-0 header-title" style="color:purple;">Edit Staff Details</h4>
                                                        		    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Admin<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="editAdmin" id="editAdmin" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                    </select>
                                 </div>
                              </div>
                       <div id="currentstaff" style="display:none;">       
              <h4 class="m-t-0 header-title" style="color:purple;"> Personal Information:</h4>
                                                         
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
                                    <input name="editStaffProfilePic" id="editStaffProfilePic" type="file" class="filestyle" data-size="md" maxlength="225"/>
                                    <br>
                                    <div class="viewimage1" id="image-holder4">
                                    
                                   <img src="#" id="editStaffImage" class="thumb-image" alt="" style="display:none;"></img>
                                     
                                   
                                    </div>
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
                             <h4 class="m-t-0 header-title" style="color:purple;">Contact Information:</h4>
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
                                          <select name="editStaffCountry" id="staffgeographicallocation" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Country </option>
                                             <c:if test="${!empty geographicallocationList}">
		                                       		<c:forEach items="${geographicallocationList}" var="country">
		                                       			<option value="${country.getName()}">${country.getName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>      
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">State<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editStaffState" id="staffgeographicallocationstate" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                               <option value="" disabled selected>Select State </option>
                                             <c:if test="${!empty geographicallocationStateList}">
		                                       		<c:forEach items="${geographicallocationStateList}" var="stateList">
		                                       			<option value="${stateList.getName()}">${stateList.getName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div> 
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">City<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editStaffCity" id="staffgeographicallocationcity" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                              <option value="" disabled selected>Select City</option>
                                             <c:if test="${!empty geographicallocationCityList}">
		                                       		<c:forEach items="${geographicallocationCityList}" var="cityList">
		                                       			<option value="${cityList.getName()}">${cityList.getName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>      
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Post Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStaffPostCode" class="form-control" id="editStaffPostCode" placeholder="" maxlength="6" required="required" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                              
       <h4 class="m-t-0 header-title" style="color:purple;">Account Information:</h4>
                                           <br>
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
          <h4 class="m-t-0 header-title" style="color:purple;">Academic Information:</h4>
                                          <br>
                                  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Staff Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                 		<input class="form-control" name="editStaffCode" id="editStaffCode" type="text" placeholder="" maxlength="50" required="required">
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
                                 
                                  <h4 class="m-t-0 header-title" style="color:purple;">Experience Information:</h4>
                                          <br>
                               <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="button" class="btn btn-success btn-custom waves-effect waves-light editbtnAdd">Add More Experience Details</button>
                                                               </div>
                              </div>
                               <br>
      
      <div class="editexperiencedetails" id="editexperiencedetails">
      
      </div>
       <br>
                               
                                  <h4 class="m-t-0 header-title" style="color:purple;">User Information:</h4>
                                  <br>
                                                    <div class="form-group ">
                                                    <label class="col-sm-3 control-label " for="editAdminPassword">User Password <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="editAdminPassword" name="editAdminPassword" type="password" class="required form-control" required="required" onChange="editCheckPasswordMatch();">

                                                    </div>
                                                </div>

                                                <div class="form-group ">
                                                    <label class="col-sm-3 control-label " for="editAdminConfirmPassword">User Confirm Password<span>*</span> </label>
                                                    <div class="col-sm-7">
                                                        <input id="editAdminConfirmPassword" name="editAdminConfirmPassword" type="password"  required="required" class="required form-control" maxlength="100" onChange="editCheckPasswordMatch();" >
                                                    </div>
                                            
                                                </div>
                                                <div class="error2" style="margin-left:200px;color:red;display: none;"></div>
                                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="editStaffStatus" id="editStaffStatus" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
                                 </div>
                               </div>
                                                <input type="hidden" id="updateStaffId" name="updateStaffId">
                                                    <input type="hidden" id="updateStaffBankDetailId" name="updateStaffBankDetailId">
                             				 <input type="hidden" id="editStaffExperienceIdArray" name="editStaffExperienceIdArray">
                           <input type="hidden" id="updateInstitutionId" name="updateInstitutionId">
                       		   <input type="hidden" id="updateUserId" name="updateUserId">	
                                
                              <div class="row">
                              
                                <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                              
                                 <div class="col-sm-offset-3">
                            <security:authorize access="hasRole('manageinstitution/update')">
                             
                                  <a href="#" id="updateInstitution" style="float:right" class="btn btn-success btn-custom waves-effect waves-light" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>     
                                    			     </security:authorize>
                           
                        <button style="float:right"  id="editBackButton" type="button" class="btn btn-info btn-custom waves-effect waves-light">Back</button>
					   <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this);">Cancel</button>
                                 </div>
                              </div>
                               </div>
                           </fieldset>
                        
                        </form>
                        </div>
                        </div>
                        
                     </div>
                  </div>
               </div>
            </div>
            <div id="FormDiv" style="display:none;">
           
                       <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Create New Institution</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                        <form class="form-horizontal" id="newInstitutionForm" action="${pageContext.request.contextPath}/institution/manageinstitution/add" method="post" enctype='multipart/form-data'>
                    <fieldset id="firststep" class="" >
                        
                        <h4 class="m-t-0 header-title" style="color:purple;">Institution Details</h4>
                            <div>
                            
                                                            <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="institutionName"> Institution Code <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="institutionCode" name="institutionCode" type="text" class="required form-control" maxlength="100">
                                                    </div>
                                                </div>
								                                                <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="institutionName"> Institution Name <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="institutionName" name="institutionName" type="text" class="required form-control" maxlength="255">
                                                    </div>
                                                </div>
                                                
                                                    <div class="form-group clearfix">
                                 <label for="institutionProfilePic" class="col-sm-3 control-label">Institution Logo<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <input name="institutionProfilePic" id="institutionProfilePic" type="file" class="filestyle" data-size="md" required="required"/>
                                   <br>
                                    <div id="image-holder3">
                                    </div>
                                 </div>
                              </div>
 								<div class="form-group">
                                 <label for="institutionProfilePic" class="col-sm-3 control-label">Institution Authorized Signature</label> 
                                <div class="col-sm-7">
                                    <input name="institutionAuthorizedSignaturePic" id="institutionAuthorizedSignaturePic" class="filestyle" data-size="md" type="file"/>
                                    <br> 
                                    <div id="image-aaholder1">
                                 
                                   </div>
									</div>
								</div>
                                                <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="institutionEmail">Institution Email <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="institutionEmail" name="institutionEmail" type="text" class="required email form-control" maxlength="100">
                                                    </div>
                                                </div>
										<div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="institutionContact"> Institution Contact <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="institutionContact" name="institutionContact" type="text" class=" required form-control" onkeypress="return isNumber(event)" maxlength="20">

                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="institutionAddressLine1">Address Line 1 <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="institutionAddressLine1" name="institutionAddressLine1" type="text" class="required form-control" maxlength="255">
                                                    </div>
                                                </div>
												
												<div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="institutionAddressLine2">Address Line 2 <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="institutionAddressLine2" name="institutionAddressLine2" type="text" class="required form-control" maxlength="255">
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="institutionCountry">Country <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <select name="institutionCountry" id="geographicallocation" required="required" class="selectpicker" data-live-search="true"  data-style="btn-white">
					                                       <c:if test="${!empty geographicallocationList}">
					                                          <option value="" disabled selected>Select Country </option>
					                                          <c:forEach items="${geographicallocationList}" var="geographicallocation">
					                                             <option id="${geographicallocation.getName()}" value="${geographicallocation.getName()}">${geographicallocation.getName()}</option>
					                                          </c:forEach>
					                                       </c:if>
                                    					</select>
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="institutionState">State <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <select name="institutionState" id="geographicallocationstate" required="required" class="selectpicker" data-live-search="true"  data-style="btn-white">
                                    	 						<option value="" disabled selected>Select Country First</option>
                                    					</select>
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="institutionCity">City <span>*</span> </label>
                                                    <div class="col-sm-7">
                                                        <select name="institutionCity" id="geographicallocationcity" required="required" class="selectpicker" data-live-search="true"  data-style="btn-white">
                                     						<option value="" disabled selected>Select State First </option>
                                     					</select>
                                                    </div>
                                                </div>
                                                    <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="institutionPostCode"> Post Code <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="institutionPostCode" name="institutionPostCode" type="text" class="required form-control" onkeypress="return isNumber(event)" maxlength="6">

                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="institutionCurrencyCode">Currency Code <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <select name="institutionCurrencyCode" id="institutionCurrency" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
					                                       <c:if test="${!empty currencyList}">
					                                          <option value="" disabled selected>Select Currency </option>
					                                          <c:forEach items="${currencyList}" var="currency">
					                                             <option  value="${currency.getIsoCode()}">${currency.getIsoCode()}</option>
					                                          </c:forEach>
					                                       </c:if>
                                    					</select>
                                                    </div>
                                                </div> 
                                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="institutionStatus" id="institutionStatus" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Collect Receipts InOrder<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="collectReceiptsInOrder" id="collectReceiptsInOrder" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Collect Receipts InOrder</option>
                                       <option value="1">Yes</option>
                                       <option value="0">No</option>
                                      </select>
                                 </div>
                              </div>
                                                 <div class="row">
                                  <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  id="NextButton" class="btn btn-success btn-custom waves-effect waves-light" type="button">Next</button>
                                    <button style="float: right" class="btn btn-info btn-custom waves-effect waves-light" type="reset">Clear</button>
                                   <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                    
                                 </div>
                              </div>                                                     
                                        </div>
                                  </fieldset>
                           <fieldset id="secondstep" class="" >
                                                <h4 class="m-t-0 header-title" style="color:purple;">Staff Administrator Details</h4>
                                           <br/>
                                             <div>
                                               <h4 class="m-t-0 header-title" style="color:purple;"> Personal Information:</h4>
                                          <br>
                                                <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="staffFirstName"> First Name <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="staffFirstName" name="staffFirstName" type="text" class="required form-control" maxlength="100">
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="staffLastName"> Last Name</label>
                                                    <div class="col-sm-7">
                                                        <input id="staffLastName" name="staffLastName" type="text" class="form-control" maxlength="100">
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="staffParentOrGuardianFirstName"> Parent or Guardian First Name <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="staffParentOrGuardianFirstName" name="staffParentOrGuardianFirstName" type="text" class="required form-control" maxlength="100">
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="staffParentOrGuardianLastName">Parent or Guardian Last Name</label>
                                                    <div class="col-sm-7">
                                                        <input id="staffParentOrGuardianLastName" name="staffParentOrGuardianLastName" type="text" class="form-control" maxlength="100">
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="staffGender">Gender<span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <select name="staffGender" id="staffGender" required="required" class="selectpicker" data-live-search="true"  data-style="btn-white">
					                                         <option value="" disabled selected>Select Gender</option>
				                                             <option value="Male">Male</option>
				                                             <option value="Female">Female</option>
				                                             <option value="Others">Others</option>
                                    					</select>
                                                    </div>
                                                </div>
                                                  <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="staffDOB">Date of Birth<span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="staffDOB" name="staffDOB" type="text" required="required" class="form-control form-control-birth-datepicker">
                                                    </div>
                                                </div>
                                                
                                                 <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="staffEmail">Email<span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="staffEmail" name="staffEmail" type="text" required="required" class="form-control" maxlength="100" autocomplete="off">
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="staffContact"> Mobile No<span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="staffContact" name="staffContact" type="text" required="required" class="form-control" maxlength="20" onkeypress="return isNumber(event)">
                                                    </div>
                                                </div>
                                                
                                                 <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="categoryId">Category<span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <select name="categoryId" id="categoryId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
					                                         <option value="" disabled selected>Select Category</option>
				                                             <c:if test="${!empty categories}">
		                                       		         <c:forEach items="${categories}" var="category">
		                                       			       <option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
		                                        	          </c:forEach>
	                                       		</c:if>
                                    					</select>
                                                    </div>
                                                </div>
                                                                    <div class="form-group clearfix">
                                 <label for="institutionProfilePic" class="col-sm-3 control-label">Photo</label> 
                                 <div class="col-sm-7">
                                    <input name="staffProfilePic" id="staffProfilePic" type="file" class="filestyle" data-size="md" maxlength="225"/>
                                   <br>
                                    <div id="image-holder7">
                                    </div>
                                 </div>
                              </div>
                              
                               <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="staffBloodGroupId">Blood Group</label>
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
                             
                           				  <h4 class="m-t-0 header-title" style="color:purple;">Contact Information:</h4>
											  <br>
											  
											    <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="staffAddressLine1">Address Line 1 <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="staffAddressLine1" name="staffAddressLine1" type="text" required="required" class="form-control" maxlength="255">
                                                    </div>
                                                </div>
												
												<div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="staffAddressLine2">Address Line 2 <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="staffAddressLine2" name="staffAddressLine2" type="text" required="required" class="form-control" maxlength="255">
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="staffCountry">Country <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <select name="staffCountry" id="geographicallocationstaff" required="required" class="selectpicker" data-live-search="true"  data-style="btn-white">
					                                       <c:if test="${!empty geographicallocationList}">
					                                          <option value="" disabled selected>Select Country </option>
					                                          <c:forEach items="${geographicallocationList}" var="geographicallocation">
					                                             <option id="${geographicallocation.getName()}" value="${geographicallocation.getName()}">${geographicallocation.getName()}</option>
					                                          </c:forEach>
					                                       </c:if>
                                    					</select>
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="staffState">State <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <select name="staffState" id="geographicallocationstatestaff" required="required" class="selectpicker" data-live-search="true"  data-style="btn-white">
                                    	 						<option value="" disabled selected>Select Country First</option>
                                    					</select>
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="staffCity">City <span>*</span> </label>
                                                    <div class="col-sm-7">
                                                        <select name="staffCity" id="geographicallocationcitystaff" required="required" class="selectpicker" data-live-search="true"  data-style="btn-white">
                                     						<option value="" disabled selected>Select State First </option>
                                     					</select>
                                                    </div>
                                                </div>
                                                    <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="staffPostCode"> Post Code <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="staffPostCode" name="staffPostCode" type="text" required="required" class="form-control" onkeypress="return isNumber(event)" maxlength="6">

                                                    </div>
                                                </div>
										   <h4 class="m-t-0 header-title" style="color:purple;">Account Information:</h4>
                                           <br>
                                            <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="staffBankName">Bank Name</label>
                                                    <div class="col-sm-7">
                                                        <input id="staffBankName" name="staffBankName" type="text" class="form-control" maxlength="100">
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="staffBankAccountNo">Bank Account No</label>
                                                    <div class="col-sm-7">
                                                        <input id="staffBankAccountNo" name="staffBankAccountNo" type="text" class="form-control" maxlength="100">
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="staffBankIFSC">Bank IFSC Code</label>
                                                    <div class="col-sm-7">
                                                        <input id="staffBankIFSC" name="staffBankIFSC" type="text" class="form-control" maxlength="100">
                                                    </div>
                                                </div>
                                                
                                                 <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="staffPANNo">PAN No</label>
                                                    <div class="col-sm-7">
                                                        <input id="staffPANNo" name="staffPANNo" type="text" class="form-control" maxlength="50">
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="staffPFAccountNo">PF Account No</label>
                                                    <div class="col-sm-7">
                                                        <input id="staffPFAccountNo" name="staffPFAccountNo" type="text" class="form-control" maxlength="50">
                                                    </div>
                                                </div>
                                           
                                            
                                           <h4 class="m-t-0 header-title" style="color:purple;">Academic Information:</h4>
                                          <br>
                                                                                           <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="staffCode">Staff Code<span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="staffCode" name="staffCode" type="text" required="required" class="form-control" maxlength="50">
                                                    </div>
                                                </div>                                             
                                           
                                             
                                                  <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="staffAccessId">Access No <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="staffAccessId" name="staffAccessId" type="text" required="required" class=" form-control" maxlength="50">
                                                    </div>
                                                </div>
                                               <div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label" for="staffJoinedDate">Joined date</label>
                                                    <div class="col-sm-7">
                                                        <input id="staffJoinedDate" name="staffJoinedDate" type="text" class="form-control form-control-datepicker">
                                                    </div>
                                                </div>
                                              <h4 class="m-t-0 header-title" style="color:purple;">User Information:</h4>
                                          <br>    
                                                 <div class="form-group ">
                                                    <label class="col-sm-3 control-label " for="adminPassword"> Password <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="adminPassword" name="adminPassword" type="password"  class="form-control" required="required" onChange="checkPasswordMatch();">

                                                    </div>
                                                </div>

                                                <div class="form-group ">
                                                    <label class="col-sm-3 control-label " for="adminConfirmPassword">Confirm Password<span>*</span> </label>
                                                    <div class="col-sm-7">
                                                        <input id="adminConfirmPassword" name="adminConfirmPassword" type="password" required="required" class="form-control" maxlength="100" onChange="checkPasswordMatch();">
                                                    </div>
                                            
                                                </div>
                                                <div class="error1" style="margin-left:200px;color:red"></div>
                                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">User Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="userStatus" id="userStatus" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
                                 </div>
                              </div>
                                             <h4 class="m-t-0 header-title" style="color:purple;">Experience Information:</h4>
                                          <br>
                                          <div class="form-group text-right m-b-0" id="expdelete">
                                         
											<button style="float:right" class="btn btn-primary col-md-3 btn-custom waves-effect waves-light btnAdd" type="button">
												Add Experience
											</button>
											
										</div>
                                    
   									<br>
                          
      <div class="experiencedetails" id="experiencedetails">
      <div class="alert alert-info" role="alert" style="display: block">
						<strong>Info!</strong>&nbsp;You want to add your experience details, Please click "Add More Experience Details" button.
						</div>
      </div>
                                           
                                             <br>  
                                               <br>   
                                            </div>
                                            	 <input type="hidden" id="staffExperienceIdArray" name="staffExperienceIdArray">
                                                    <div class="row">
                               <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                               
                                 <div class="col-sm-offset-3">
                                 
                                    <button style="float:right"  type="button" id="institutionSave" class="btn btn-success btn-custom waves-effect waves-light">Save</button>
                                        <button style="float:right"  id="BackButton" type="button" class="btn btn-info btn-custom waves-effect waves-light">Back</button>
                                <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this);">Cancel</button>
                                 </div>
                              </div>
                              
                               </fieldset>
                             </form>
                             </div>
                             </div>
                             
                     </div>
                  </div>
               </div>
                  <div class="modal fade" id="institutionSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure ?, You want to add this Institution ??</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="institutionSaveConfirm" id="institutionsSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						</div>
            </div>
             <div class="modal fade" id="saveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure ?, You want to update this Institution??</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="saveConfirm" id="saveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						</div>
           
         </div>
		</div>
		</div>
	</div>
		   <script type="text/javascript">
         $(document).ready(function(){
         
         	$("#NextButton").click(function()
         			{
         		
        		if( $("#newInstitutionForm").valid())
         		{ 
         				current_fs = $('#firststep');
         				next_fs = $('#secondstep');
         				next_fs.show(); 
         				current_fs.hide();
          		} 
        		else{
         			if( $("#newInstitutionForm").valid()){}
         	    }
         
         });
         
         	
         
         	$('#BackButton').click(function(){
             	current_fs = $('#secondstep');
             	next_fs = $('#firststep');
             	next_fs.show(); 
             	current_fs.hide();
             	 }); 
         	
         	
         
         
         });
        
      </script>
		   <script type="text/javascript">
         $(document).ready(function(){
         
         	$("#editNextButton").click(function(){
         		if( $("#updateInstitutionDetails").valid())
         		{
         				current_fs = $('#editFirstStep');
         				next_fs = $('#editSecondStep');
         				next_fs.show(); 
         				current_fs.hide();
         				
        		}		
         		else{
         			if( $("#updateInstitutionDetails").valid()){}
         		}
         
         });
         
         	
         
         	$('#editBackButton').click(function(){
             	current_fs = $('#editSecondStep');
             	next_fs = $('#editFirstStep');
             	next_fs.show(); 
             	current_fs.hide();
              }); 
         	});
        
      </script>
		
 <script> 
         $(document).ready(function() {
                 $("#editInstitutionProfilePic").on('change', function() {
                   //Get count of selected files
                   var countFiles = $(this)[0].files.length;
                   var imgPath = $(this)[0].value;
                  
                   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
                   var image_holder = $("#image-holder1");
                   
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
                    	 $('#editInstitutionProfilePic').filestyle('clear');
                       edumaatAlert({
             			  title: "Info !",
             			  text: "This browser does not support FileReader!",
             			  type: "info",
             			  confirmButtonText: "Cool"
             			});
                     }
                   } else {
                	  $('#editInstitutionProfilePic').filestyle('clear');
                   //  alert("Please select only images");
                     edumaatAlert({
           			  title: "Info !",
           			  text: "Please select only images!",
           			  type: "info",
           			  confirmButtonText: "Cool"
           			});
                   }
                 });
               });
      </script>
      
   
      <script> 
         $(document).ready(function() {
                 $("#editStaffProfilePic").on('change', function() {
                   //Get count of selected files
                   var countFiles = $(this)[0].files.length;
                   var imgPath = $(this)[0].value;
                  
                   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
                   var image_holder = $("#image-holder4");
                   
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
                    	$('#editStaffProfilePic').filestyle('clear');
                      // alert("This browser does not support FileReader.");
                       edumaatAlert({
             			  title: "Info !",
             			  text: "This browser does not support FileReader!",
             			  type: "info",
             			  confirmButtonText: "Cool"
             			});
                     }
                   } else {
                	  $('#editStaffProfilePic').filestyle('clear');
                     //alert("Please select only images");
                     edumaatAlert({
           			  title: "Info !",
           			  text: "Please select only images!",
           			  type: "info",
           			  confirmButtonText: "Cool"
           			});
                   }
                 });
               });
      </script>
      
        <script> 
         $(document).ready(function() {
                 $("#editInstitutionAuthorizedSignaturePic").on('change', function() {
                   //Get count of selected files
                   var countFiles = $(this)[0].files.length;
                   var imgPath = $(this)[0].value;
                  
                   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
                   var image_holder = $("#image-aholder1");
                   
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
                    	$('#editInstitutionAuthorizedSignaturePic').filestyle('clear');
                      // alert("This browser does not support FileReader.");
                       edumaatAlert({
             			  title: "Info !",
             			  text: "This browser does not support FileReader!",
             			  type: "info",
             			  confirmButtonText: "Cool"
             			});
                     }
                   } else {
                	  $('#editInstitutionAuthorizedSignaturePic').filestyle('clear');
                     //alert("Please select only images");
                     edumaatAlert({
           			  title: "Info !",
           			  text: "Please select only images!",
           			  type: "info",
           			  confirmButtonText: "Cool"
           			});
                   }
                 });
               });
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
          <script src="${pageContext.request.contextPath}/resources/themes/script/manageinstitution.js"></script>	
          
</body>
</html>