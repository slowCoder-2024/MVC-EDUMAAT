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
     
     
     <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/custombox/css/custombox.css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/animationeffect/css/component.css" />
      <%--  <link href="${pageContext.request.contextPath}/resources/themes/user/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"> --%>
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
       
          
                   <div class="modal fade" id="updateconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                      <h5>Are you sure you want to update this details ?</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" name="studentupdateconfirm" id="studentupdateconfirm" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            
    
                             
                             <div class="row">
                            <div class="col-md-4 col-lg-12 " id="profileindex" style="display:block;">
                                <div class="profile-detail card-box demo-3">
                              <div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="main-title">
				                    <img src="..${student.getUser().getProfilePicturePath()}"  class="img-circle" alt="profile-image">
                                
                                    <div class="contact-card"  >
                                    	  <div class="member-info">
                                          <!--  <div class="contact-action">
                                            	<button id="editDetails" class="btn btn-success btn-sm btn-success btn-custom waves-effect waves-light"><i class="md md-mode-edit"></i></button>
                                            	<a href="#" class="btn btn-danger btn-sm btn-success btn-custom waves-effect waves-light"><i class="md md-close"></i></a>
                                            </div> -->
                                         </div>
                                        <hr>
                                        <div class="text-left">
                                            <p class="text-muted font-13"><strong>Name :</strong> <span class="m-l-15">${student.getFirstName()} ${student.getLastName()}</span></p>

											<p class="text-muted font-13"><strong>Gender :</strong> <span class="m-l-15">${student.getSex()}</span></p>
                                            
                                            <p class="text-muted font-13"><strong>Mobile :</strong><span class="m-l-15">${student.getContact()}</span></p>

                                            <p class="text-muted font-13"><strong>Email :</strong> <span class="m-l-15">${student.getEmail()}</span></p>

                                            <p class="text-muted font-13"><strong>Address :</strong> <span class="m-l-15">${student.getAddressLine1()} , ${student.getAddressLine2()}</span></p>

                                        </div>
								 <div class="text-right">
                                            <p class="text-muted font-13"> <span class="m-l-15">${student.getParentGuardianFirstName()} ${student.getParentGuardianLastName()}</span> <strong> : Parent or Guardian Name</strong></p>

                                            <p class="text-muted font-13"><span class="m-l-15">${student.getParentContact()}</span><strong> : Parent or Guardian Mobile</strong></p>

                                            <p class="text-muted font-13"> <span class="m-l-15">${student.getParentGuardianEmail()}</span><strong> : Parent or Guardian Email</strong></p>

                                          </div>
									    <div class="button-list m-t-20">
                                          <!--   <button type="button" class="btn btn-facebook waves-effect waves-light">
                                               <i class="fa fa-facebook"></i>
                                               </button> -->
 <a href="#" class="btn btn-facebook waves-effect waves-light" onclick="window.open('http://www.facebook.com/add.a.link')"><i class="fa fa-facebook"></i></a>
                                            
                                          <!--   <button type="button" class="btn btn-twitter waves-effect waves-light">
                                             
                                            </button> -->
 <a href="#" class="btn btn-twitter waves-effect waves-light" onclick="window.open('https://twitter.com/login')">  <i class="fa fa-twitter"></i></a>       
                                           <!--  <button type="button" class="btn btn-linkedin waves-effect waves-light">
                                            </button> -->
   <a href="#" class="btn btn-linkedin waves-effect waves-light" onclick="window.open('https://in.linkedin.com/')"><i class="fa fa-linkedin"></i></a>       
                                     
                                           
<button id="editDetails" class="btn btn-success btn-sm btn-success btn-custom waves-effect waves-light"><i class="md md-mode-edit"></i></button>
                                        </div>
                                    </div>

                               

                          
				</div>
                            </div>


                        
                           </div>
                           </div>            
 
                        </div>

          <div id="editDetailss" style="display:none;">
           
        <form class="form-horizontal" id="updateStudentForm" action="${pageContext.request.contextPath}/student/profile/update" method="post" enctype="multipart/form-data">
   
   <ul id="myTabs" class="nav nav-tabs" role="tablist">
      <li role="presentation" class="active"><a href="#edit-personal-information" id="edit-personal-information-tab" role="tab" data-toggle="tab" aria-controls="edit-personal-information" aria-expanded="true"><i class="fa fa-user" aria-hidden="true"></i>
      Personal Information</a></li>
      <li role="presentation" class=""><a href="#edit-contact-information" role="tab" id="edit-contact-information-tab" data-toggle="tab" aria-controls="edit-contact-information" aria-expanded="false"><i class="fa fa-tty" aria-hidden="true"></i>
      Contact Information</a></li>
      <li role="presentation" class=""><a href="#edit-user-information" role="tab" id="edit-user-information-tab" data-toggle="tab" aria-controls="edit-user-information" aria-expanded="false"><i class="fa fa-university nav_icon"></i>User Information</a></li>
      <li role="presentation" class=""><a href="#edit-other-information" role="tab" id="edit-other-information-tab" data-toggle="tab" aria-controls="edit-other-information" aria-expanded="false"><i class="fa fa-info" aria-hidden="true"></i>
      Other Information</a></li>
   </ul>
   <div id="myTabContent" class="tab-content">
      <div role="tabpanel" class="tab-pane fade active in" id="edit-personal-information" aria-labelledby="edit-personal-information-tab">
      <br>
      <div class="form-group">
                          	      <label for="" class="col-sm-3 control-label">First Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editFirstName" name="editFirstName" placeholder="" required="required" maxlength="100" value="${student.getFirstName()}">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Last Name</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editLastName"  name="editLastName" placeholder="" maxlength="100" value="${student.getLastName()}">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian First Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editParentOrGuardianFirstName" name="editParentOrGuardianFirstName" required="required" placeholder="" maxlength="100" value="${student.getParentGuardianFirstName()}">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian Last Name</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editParentOrGuardianLastName" name="editParentOrGuardianLastName" placeholder="" maxlength="100" value="${student.getParentGuardianLastName()}">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent/Guardian Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="email" class="form-control" id="editParentOrGuardianEmail"  name="editParentOrGuardianEmail" placeholder="" required="required" maxlength="100" value="${student.getParentGuardianEmail()}">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Gender<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                 <!-- getSex -->
                                  <select name="editStudentGender" id="editStudentGender" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Gender</option>
                                            <c:if test="${student.getSex()=='Male'}"> <option selected value="Male">Male</option><option value="Female">Female</option>  <option value="Others">Others</option></c:if> 
                      					<c:if test="${student.getSex()=='Female'}"><option value="Male">Male</option><option selected value="Female">Female</option>  <option value="Others">Others</option></c:if> 
                 						<c:if test="${student.getSex()=='Others'}"><option value="Male">Male</option><option value="Female">Female</option>  <option selected value="Others">Others</option></c:if> 
                 
                                          </select>                                 </div>
                              </div>
                             <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Date of Birth<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-control-birth-datepicker" id="editDateOfBirth" name="editDateOfBirth" placeholder="" required="required" maxlength="10" value="${student.getBirthDate()}">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="email" class="form-control" id="editEMail"  name="editEMail" placeholder="" required="required" maxlength="100" value="${student.getEmail()}">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student Contact<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editContact" required="required" name="editContact" placeholder=""  onkeypress="return isNumber(event)" maxlength="20" value="${student.getContact()}">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent Contact<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editParentContact" required="required" name="editParentContact" placeholder=""  onkeypress="return isNumber(event)" maxlength="20" value="${student.getParentContact()}">
                                 </div>
                              </div>
                                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">AadharCard Number</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editAadharCardNumber" name="editAadharCardNumber" placeholder=""  onkeypress="return isNumber(event)" maxlength="100">
                                 </div>
                              </div>
                                   <div class="form-group">

                                 <label for="" class="col-sm-3 control-label">Father Income In lakhs(Std. Currency)</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editFatherIncome" name="editFatherIncome" placeholder="" onkeypress="return decimalAmount(this, event, 2)" maxlength="255" value="${student.getFathersIncome()}">
                                 </div>
                                 </div>
                                 <div class="form-group">

                                 <label for="" class="col-sm-3 control-label">Mother Income In lakhs(Std. Currency)</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editMotherIncome" name="editMotherIncome" placeholder=""onkeypress="return decimalAmount(this, event, 2)" maxlength="255" value="${student.getMothersIncome()}">
                                 </div>
                                 </div>
                                 <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                     <button style="float:right" type="reset" class="btn btn-info btn-success btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-success btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
      </div>
      <div role="tabpanel" class="tab-pane fade" id="edit-contact-information" aria-labelledby="edit-contact-information-tab">
      <br>
        <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 1<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStudentAddressLine1" class="form-control" id="editStudentAddressLine1" placeholder="" required="required" maxlength="225" value="${student.getAddressLine1()}">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 2<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStudentAddressLine2" class="form-control" id="editStudentAddressLine2" placeholder="" required="required" maxlength="225" value="${student.getAddressLine2()}">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                         <%--  <select name="editStudentCountry" id="geographicallocation1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Country </option>
                                             <c:if test="${!empty countries}">
		                                       		<c:forEach items="${countries}" var="country">
		                                       			<c:if test="${student.getCountry()== country.getName()}">
		                                       			<option id="${country.getGeographicalLocationId()}" value="${country.getName()}" selected>${country.getName()}</option>
		                                       				</c:if>
					                                    	<c:if test="${student.getCountry()!=country.getName()}">
		                                       				<option id="${country.getName()}" value="${country.getName()}">${country.getName()}</option>
		                                       				</c:if>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select> --%>
                                                   <input type="text" name="editStudentCountry" class="form-control" id="geographicallocation1" placeholder="" required="required" maxlength="225" value="${student.getCountry()}">
                            
                                       </div>
                                    </div>      
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">State<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                        <%--   <select name="editStudentState" id="geographicallocationstate1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                          <option value="" disabled selected>Select State </option>
                                             <c:if test="${!empty stateList}">
		                                       		<c:forEach items="${stateList}" var="stateList">
		                                       			<c:if test="${student.getState()==stateList.getName()}">
		                                       			<option id="${stateList.getName()}" value="${stateList.getName()}" selected>${stateList.getName()}</option>
		                                       			
					                                    	</c:if>
		                                        	</c:forEach>
	                                       		</c:if>
                                         </select> --%>
                                                  <input type="text" name="editStudentState" class="form-control" id="geographicallocationstate1" placeholder="" required="required" maxlength="225" value="${student.getState()}">
                            
                                       </div>
                                    </div> 
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">City<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                        <%--   <select name="editStudentCity" id="geographicallocationcity1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                         <option value="" disabled selected>Select City</option>
                                             <c:if test="${!empty cityList}">
		                                       		<c:forEach items="${cityList}" var="cityList">
		                                       		<c:if test="${student.getCity()==cityList.getName()}">
		                                       			<option id="${cityList.getName()}" value="${cityList.getName()}" selected>${cityList.getName()}</option>
		     
					                                    	</c:if>
					                                    	
		                                        	</c:forEach>
	                                       		</c:if>
                                         </select> --%>
                                                  <input type="text" name="editStudentCity" class="form-control" id="geographicallocationcity1" placeholder="" required="required" maxlength="225" value="${student.getCity()}">
                            
                                       </div>
                                    </div>      
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Post Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStudentPostCode" class="form-control" id="editStudentPostCode" placeholder="" maxlength="6" required="required" onkeypress="return isNumber(event)" value="${student.getPostcode()}">
                                 </div>
                              </div>
                              
                               <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                     <button style="float:right" type="reset" class="btn btn-info btn-success btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-success btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
        </div>
          <div role="tabpanel" class="tab-pane fade" id="edit-user-information" aria-labelledby="edit-user-information-tab">
      <br>
                                                          <div class="form-group ">
                                                    <label class="col-sm-3 control-label " for="adminName">Name <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input class="required form-control" id="adminName" name="adminName" required="required" type="text" maxlength="100" value="${student.getUser().getName()}">
                                                    </div>
                                                </div>
                                               
                                                <div class="form-group ">
                                                    <label class="col-sm-3 control-label " for="adminPassword"> Password <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="adminPassword" name="adminPassword" type="password" required="required" class="required form-control" value="${student.getUser().getPassword()}" onChange="checkPasswordMatch();">

                                                    </div>
                                                </div>

                                                <div class="form-group ">
                                                    <label class="col-sm-3 control-label " for="adminConfirmPassword">Confirm Password<span>*</span> </label>
                                                    <div class="col-sm-7">
                                                        <input id="adminConfirmPassword" name="adminConfirmPassword" required="required" type="password" class="required form-control" maxlength="100" onChange="checkPasswordMatch();" value="${student.getUser().getPassword()}">
                                                    </div>
                                            
                                                </div>
                                                <div class="error1" style="margin-left:200px;color:red"></div>
                                            
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                     <button style="float:right" type="reset" class="btn btn-info btn-success btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-success btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
                                
      
      </div>
                               <div role="tabpanel" class="tab-pane fade" id="edit-other-information" aria-labelledby="edit-other-information-tab">
      <br>
      
      
       
                            <div class="form-group">
                                 <label for="studentProfilePic" class="col-sm-3 control-label">Upload Photo</label> 
                                 <div class="col-sm-7">
                                    <input name="editStudentProfilePic" class="filestyle" data-size="md" id="editStudentProfilePic" type="file" />
                                    <br>
                                    <div class="viewimage1" >
                                   <img src="..${student.getUser().getProfilePicturePath()}" id="editStudentImage" class="thumb-image"  ></img>
                                     
                                    </div>
                                 </div>
                              </div>
                                   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Upload Scanned Signature</label> 
                                 <div class="col-sm-7">
                                    <input class="filestyle" data-size="md" name="editScannedSignature" id="editScannedSignature" type="file"/>  <br>
                                    <div class="viewimage2">
                                        <img src="..${student.getScannedSignature()}" id="editStudentSignature" class="thumb-image"></img>
                                 
                                    </div>
                                    
                                 </div>
                              </div>
      
    						  <div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Passport No</label> 
	                                 <div class="col-sm-7"> 
	                                    <input type="text" class="form-control" id="editPassportNo"  name="editPassportNo" placeholder="" maxlength="100" value="${student.getPassportNumber()}">
	                                 </div>
	                              </div>
                                <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Blood Group</label> 
                                       <div class="col-sm-7">
                                           <select name="editBloodGroupId" id=editBloodGroupId class="selectpicker" data-live-search="true"  data-style="btn-white">
                                                <option value="" disabled selected>Select Blood Group </option>
                                        		<c:if test="${!empty bloodGroups}">
		                                       			<c:forEach items="${bloodGroups}" var="bloodGroup">
		                                       				<c:if test="${student.getBloodGroup().getBloodGroupId()== bloodGroup.getBloodGroupId()}">
		                                       				<option value="${bloodGroup.getBloodGroupId()}" selected>${bloodGroup.getBloodGroupName()}</option>
		                                       				</c:if>
					                                    	<c:if test="${student.getBloodGroup().getBloodGroupId()!=bloodGroup.getBloodGroupId()}">
		                                       				<option value="${bloodGroup.getBloodGroupId()}" >${bloodGroup.getBloodGroupName()}</option>
		                                       				</c:if>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
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
                                         
                                          </tbody>
                                       </table>
                         <br>
                               <input type="hidden" id="updateStudentId" name="updateStudentId" value="${student.getStudentId()}">
                               <input type="hidden" id="updateUserId" name="updateUserId" value="${student.getUser().getUserId()}">
                                     <input type="hidden" id="documentsCount" name="documentsCount"> 
                           <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                <a href="#" id="updateStudent" style="float:right" class="btn btn-success btn-success btn-custom waves-effect waves-light" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>     
                                       <button style="float:right" type="reset" class="btn btn-info btn-success btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-success btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
       </div>
     </div>
   </form>
           </div>
          <div id="profile-page-content" class="row" style="display:none;">
                <div id="profile-page-wall" class="col lg12 m12">
                <div id="profile-page-wall-share" class="row">
                  <div class="col s12">
                    <ul class="tabs tab-profile z-depth-1 light-blue">
                      <li class="tab col s3"><a class="white-text waves-effect waves-light active" href="#viewDetails"><i class="glyphicon glyphicon-eye-open"></i> View Details </a>
                      </li>
                     </ul>
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
        
     
      
  

      <script src="${pageContext.request.contextPath}/resources/themes/script/studentprofile.js" type="text/javascript"></script>
<%--    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/user/js/materialize.js"></script> --%>
   <%--    <script src="${pageContext.request.contextPath}/resources/themes/script/geographicallocation.js"></script> --%>


  <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/custombox/js/custombox.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/custombox/js/legacy.min.js"></script>
        
         <script src="${pageContext.request.contextPath}/resources/themes/animationeffect/js/TweenLite.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/animationeffect/js/EasePack.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/animationeffect/js/rAF.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/animationeffect/js/demo-3.js"></script>
    <%--   <script src="${pageContext.request.contextPath}/resources/themes/animationeffect/js/index.js"></script> --%>
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



<script type="text/javascript">
  
    TableManageButtons.init();

</script>
   </body>
</html>