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
               <security:authorize access="hasRole('managestudent/add')">
               <div class="form-group">
                  <button type="button" class="btn btn-primary btn-custom waves-effect waves-light col-md-3" onclick="showDiv()">Add New Student</button>
               </div>
               <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
               </security:authorize>
                 <security:authorize access="hasRole('managestudent/viewlist')">
               <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Select Student(s)</b></h4>
               		    <form class="form-horizontal" id="getDetails" name="getDetails" method="post">
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Class<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                <select name="classList" id="classList" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                                <option value="" disabled selected>Select Class</option>
                                                <option value="all">ALL</option>
                                           		 <c:if test="${!empty classes}">
		                                       			<c:forEach items="${classes}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}(${clazz.getInstitution().getInstitutionCode()})</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                 </div>
                               
                              </div>
                             
                              <div class="form-group" id="secionDIV" style="display:none">
                                 <label for="" class="col-sm-3 control-label"> Section<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="sectionList" id="sectionList" class="selectpicker" multiple data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                          </select>
                                 </div>
                              </div>
                               <div class="form-group" id="categoryDIV" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Criteria<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="categoryList" id="categoryList" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            <option value="" disabled selected>Select Category</option>
                                            <option value="all">All</option>
                                             <option value="specificstudent">Specific Student</option>
                                             <option value="specialcategory">Special Category</option>
                                          </select>
                                    
                                 </div>
                              </div>
                               <div class="form-group form-group-student-id" style="display: none">
                                 <label for="" class="col-sm-3 control-label">Admission No (Unique Student Id)<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <input type="text" id="selectedAdmissionNo" name="selectedAdmissionNo" class="form-control" required="required" />
                                 </div>
                              </div>
                              <div class="form-group form-group-special-category "style="display: none">
                                 <label for="" class="col-sm-3 control-label">Special Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="specialCategoryList" id="specialCategoryList" class="selectpicker" data-live-search="true"  data-style="btn-white"  required="required">
                                      <option value="" disabled selected>Select Special Category </option>
                                       <c:if test="${!empty specialCategories}">
                                          <c:forEach items="${specialCategories}" var="specialCategory">
                                             <option value="${specialCategory.getSpecialCategoryId()}">${specialCategory.getSpecialCategoryName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                    
                                 </div>
                              </div>
                               
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                 <button style="float:right" type="button"  id="getDetailsFromSelectedCriteria" class="btn btn-success btn-custom waves-effect waves-light">Get List</button>
                                  <button style="float:right;margin-right: 20px"  type="button" name="studentDataExcel" id="studentDataExcel" class="btn btn-danger btn-custom waves-effect waves-light">Download Excel</button>
                                 <a  style="float:right;margin-right: 20px"id="upload" href="#" class="btn btn-info btn-custom waves-effect waves-light"  type="button" data-href="#"  data-id="" data-toggle="modal" data-target="#browse-file1">Upload ModifiedExcel</a>
                                 </div>
                              </div>
                                <!-- <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div> -->
            </form>
            </div>
            </div>
            </div>
                        <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box table-responsive">
                              <!-- <h4 class="m-t-0 header-title" style="color:purple;"><b>Applicant Details</b></h4> -->
                              <br>
                           
                           <form class="form-horizontal" id="deleteStudentForms" action="${pageContext.request.contextPath}/student/bulkdelete" method="post">
                                 <table class="table table-striped table-bordered" id="studentsList">
                              <thead>
                                 <tr>
                                   <th><div class="checkbox checkbox-primary"> <input name="select_all" value="1" id="example-select-all" type="checkbox"/> <label for="example-select-all"></label></div>
                                   </th>
                                    <th>Admission No</th>
                                   <th>Student Name</th>
                                   <th>Current Class/Section</th>
                                    	<th>Student Contact Tel</th>
                                   	<th>Parent Contact Tel</th>
                                  	<th>Action</th>
                              </tr>
                              </thead>
                              <tbody >
                              		<%--  <c:if test="${!empty studentList}">
		                                   <c:forEach items="${studentList}" var="studentLists">
		                                       	 <tr >
		                                       	 <td><input type="checkbox" value="${studentLists.getStudentId()}" name="${studentLists.getStudentId()}" class="case" id="${studentLists.getStudentId()}"></input></td>
				                                    <td>${studentLists.getFirstName()} ${studentLists.getLastName()}</td>
				                                    
				                                      <td>${studentLists.getStudentClass().getClassName()}/${studentLists.getSection().getSectionName()}</td>
				                                  
				                                    <td>${studentLists.getContact()}</td>
				                                      <security:authorize access="hasAnyRole('managestudent/view','managestudent/delete')">
                                    <td>
                                    <security:authorize access="hasRole('managestudent/view')">
                                                    	<a href="#" id="edit"  type="button"data-href="#" data-id="${studentLists.getStudentId()}" data-toggle="modal" onclick="showeditDiv()">
				                                    		<span class="glyphicon glyphicon-edit"></span> 
				                                    	</a>
				                  </security:authorize>
				                     <security:authorize access="hasRole('managestudent/delete')">
                                   
				                                   		 <a href="#"  id="delete"  type="button" data-href="#"  data-id="${studentLists.getStudentId()}" data-toggle="modal" data-target="#deletestudentconfirmation">
				                                    			<span class="glyphicon glyphicon-trash"></span> 
				                                    	 </a>
				                                    	 </security:authorize>
				                                    </td>
				                                    </security:authorize>
                                   				</tr>
		                                    </c:forEach>
	                                 </c:if> --%>
                              </tbody>
                           </table>
                               <input id="selectedStudentIds" name="selectedStudentIds" type="hidden">
                           </form>
                        </div>
                        </div>  
                        </div>
                        
                    
               <security:authorize access="hasRole('managestudent/delete')">
                    <div class="row">
                                 <div class="col-sm-offset-3">
                                   <button style="float:right" type="button" id="deleteStudents" class="btn btn-success btn-custom waves-effect waves-light">Delete Selected Student</button>
                                 </div>
                              </div>
                              </security:authorize>
                        </security:authorize>
            </div>
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
	<input id="studentExcelfile" class="filestyle" data-size="md" name="studentExcelfile" required="required" type="file">
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
               <div class="forms">
                  <div class="row">
                    <!--  <h3 class="title1">Create New Student</h3> -->
                     <div class="form-three widget-shadow">
     <div class="row">
<div class="col-sm-offset-3">
<form class="form-horizontal" id="addstudentform1" action="${pageContext.request.contextPath}/student/studentExcelFormat" method="get">
<button id="downloadStudentExcelFormat" class="btn btn-success btn-custom waves-effect waves-light" style="float:right" type="submit">Download Format</button>
</form>
<a class="btn btn-info btn-custom waves-effect waves-light" style="float:right;margin-right: 20px" href="#" type="button" data-href="#" data-id="" data-toggle="modal" data-target="#browse-file">Browse the bulk upload excel sheet </a>
</div>
</div>
                   <form class="form-horizontal" id="addstudentform" action="${pageContext.request.contextPath}/student/add" method="post" enctype="multipart/form-data">
   
   <ul id="myTabs" class="nav nav-tabs" role="tablist">
      <li role="presentation" class="active"><a href="#personal-information" id="personal-information-tab" role="tab" data-toggle="tab" aria-controls="personal-information" aria-expanded="true"><i class="fa fa-user" aria-hidden="true"></i>
      Personal Information</a></li>
      <li role="presentation" class=""><a href="#contact-information" role="tab" id="contact-information-tab" data-toggle="tab" aria-controls="contact-information" aria-expanded="false"><i class="fa fa-tty" aria-hidden="true"></i>
      Contact Information</a></li>
      <li role="presentation" class=""><a href="#academic-information" role="tab" id="academic-information-tab" data-toggle="tab" aria-controls="academic-information" aria-expanded="false"><i class="fa fa-university nav_icon"></i>Academic Information</a></li>
      <li role="presentation" class=""><a href="#other-information" role="tab" id="other-information-tab" data-toggle="tab" aria-controls="other-information" aria-expanded="false"><i class="fa fa-info" aria-hidden="true"></i>
      Other Information</a></li>
   </ul>
   <div id="myTabContent" class="tab-content">
      <div role="tabpanel" class="tab-pane fade active in" id="personal-information" aria-labelledby="personal-information-tab">
      <br>
    	<div class="form-group">
                          	
                           
                                 <label for="" class="col-sm-3 control-label">First Name<span class="at-required-highlight">*</span></label> 
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
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian First Name<span class="at-required-highlight">*</span></label> 
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
                                 <label for="" class="col-sm-3 control-label">Parent/Guardian Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="email" class="form-control" id="parentOrGuardianEmail"  name="parentOrGuardianEmail" placeholder="" required="required" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Gender<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="studentGender" id="studentGender" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Gender</option>
                                             <option value="Male">Male</option>
                                             <option value="Female">Female</option>

                                             
                                              <option value="Others">Others</option>
                                          </select>                                 </div>
                              </div>
                              
                               
                               
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Date of Birth<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-control-birth-datepicker" id="dateOfBirth" name="dateOfBirth" placeholder="" required="required" maxlength="10">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="email" class="form-control" id="eMail"  name="eMail" placeholder="" required="required" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student Contact<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="contact" name="contact" placeholder=""  required="required" onkeypress="return isNumber(event)" maxlength="20">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent Contact<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="parentContact" name="parentContact" placeholder=""  required="required" onkeypress="return isNumber(event)" maxlength="20">
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
                                       <label for="" class="col-sm-3 control-label">Special Category<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="specialCategoryId" id="specialCategoryId" class="selectpicker" data-live-search="true"  data-style="btn-white" multiple="multiple" required="required"  required="required">
                                       <c:if test="${!empty specialCategories}">
                                          <c:forEach items="${specialCategories}" var="specialCategory">
                                             <option value="${specialCategory.getSpecialCategoryId()}">${specialCategory.getSpecialCategoryName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                       </div>
                                    </div> 
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">AadharCard Number</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="aadharCardNumber" name="aadharCardNumber" placeholder=""   onkeypress="return isNumber(event)" maxlength="100">
                                 </div>
                              </div>
                                      <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">House<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="houseId" id="houseId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required"  required="required">
                                       <option value="" disabled selected>Select House</option>
                                       <c:if test="${!empty houseList}">
                                          <c:forEach items="${houseList}" var="house">
                                             <option value="${house.getHouseId()}">${house.getHouseName()}</option>
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
                                 <label for="" class="col-sm-3 control-label">Address Line 1<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="addressLine1"  name="addressLine1" placeholder="" required="required" maxlength="255">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 2<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="addressLine2" name="addressLine2" placeholder="" required="required" maxlength="255">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                        <%--   <select  data-size="5" name="country" id="geographicallocation" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             	<option value="" disabled selected>Select Country </option>
                                             <c:if test="${!empty countries}">
		                                       		<c:forEach items="${countries}" var="country">
		                                       			<option value="${country.getName()}">${country.getName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                             </select>      --%>
                                                    <input type="text" class="form-control" id="geographicallocation" name="country" placeholder="" required="required" maxlength="255">
                            
                                       </div>
                                    </div>   
                                       <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">State <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">                                   
                                   <!--   <select  data-size="5" name="state" id="geographicallocationstate" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required" >
                                    	 <option value="" disabled selected>Select Country First</option>
                                    </select> -->
                                                   <input type="text" class="form-control" id="geographicallocationstate" name="state" placeholder="" required="required" maxlength="255">
                            
                                 </div>
                              </div>   
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">City <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">                                   
                                  <!--    <select  data-size="5" name="city" id="geographicallocationcity" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                     	<option value="" disabled selected>Select State First </option>
                                     </select> -->
                                                            <input type="text" class="form-control" id="geographicallocationcity" name="city" placeholder="" required="required" maxlength="255">
                            
                                 </div>
                              </div>   
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Post Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="postCode" name="postCode" placeholder="" maxlength="6" required="required" onkeypress="return isNumber(event)">
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
                                       <label for="" class="col-sm-3 control-label">Joining Class<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="joinedClass" id="joinedClass" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
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
                                       <label for="" class="col-sm-3 control-label">Section<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="joinedSection" id="joinedSection" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                          </select>
                                       </div>
                                    </div>
                              
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Joined Academic Year<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="academicYearId" id="academicYearId"  class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Academic Year</option>
                                       <c:if test="${!empty academicYears}">
		                                       			<c:forEach items="${academicYears}" var="academicYear">
		                                       		<option value="${academicYear.getAcademicYearId()}">${academicYear.getAcademicYearTitle()}</option>
		                                       			</c:forEach>
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
                                 <label for="" class="col-sm-3 control-label">Joined date<span class="at-required-highlight">*</span></label> 
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
                                 <label for="" class="col-sm-3 control-label">Admission No<span class="at-required-highlight">*</span></label> 
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
                                    <input name="studentProfilePic"  id="studentProfilePic" type="file"  class="filestyle" data-size="md" />
                                    <br>
                                    <div class="viewimage1" >
                                    
                                    </div>
                                 </div>
                              </div>
                                   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Upload Scanned Signature</label> 
                                 <div class="col-sm-7">
                                    <input class="filestyle" data-size="md" name="studentSignature" id="studentSignature" type="file"/>  <br>
                                    <div class="viewimage2"></div>
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
                                        		<c:if test="${!empty bloodGroups}">
		                                       			<c:forEach items="${bloodGroups}" var="bloodGroup">
		                                       					<option value="${bloodGroup.getBloodGroupId()}" >${bloodGroup.getBloodGroupName()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="studentStatus" id="studentStatus" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                                <option value="" disabled selected>Select Student Status </option>
                                        		<c:if test="${!empty studentStatus}">
		                                       			<c:forEach items="${studentStatus}" var="studentStatus">
		                                       					<option value="${studentStatus.getStudentStatusId()}" >${studentStatus.getStatusTitle()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                         
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
                                    <button style="float:right"  type="button" id="saveStudent" class="btn btn-success btn-custom waves-effect waves-light">Save</button>
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
                     <h3 class="title1">Edit Student</h3>
                     <div class="form-three widget-shadow">
                         
        <form class="form-horizontal" id="updateStudentForm" action="${pageContext.request.contextPath}/student/update" method="post" enctype="multipart/form-data">
   
   <ul id="myTabs" class="nav nav-tabs" role="tablist">
      <li role="presentation" class="active"><a href="#edit-personal-information" id="edit-personal-information-tab" role="tab" data-toggle="tab" aria-controls="edit-personal-information" aria-expanded="true"><i class="fa fa-user" aria-hidden="true"></i>
      Personal Information</a></li>
      <li role="presentation" class=""><a href="#edit-contact-information" role="tab" id="edit-contact-information-tab" data-toggle="tab" aria-controls="edit-contact-information" aria-expanded="false"><i class="fa fa-tty" aria-hidden="true"></i>
      Contact Information</a></li>
      <li role="presentation" class=""><a href="#edit-academic-information" role="tab" id="edit-academic-information-tab" data-toggle="tab" aria-controls="edit-academic-information" aria-expanded="false"><i class="fa fa-university nav_icon"></i>Academic Information</a></li>
      <li role="presentation" class=""><a href="#edit-user-information" role="tab" id="edit-user-information-tab" data-toggle="tab" aria-controls="edit-user-information" aria-expanded="false"><i class="fa fa-child" aria-hidden="true"></i>
      User Information</a></li>
      <li role="presentation" class=""><a href="#edit-parentuser-information" role="tab" id="edit-parentuser-information-tab" data-toggle="tab" aria-controls="edit-parentuser-information" aria-expanded="false"><i class="fa fa-user-circle" aria-hidden="true"></i>
    Parent User Information</a></li>
      
      <li role="presentation" class=""><a href="#edit-other-information" role="tab" id="edit-other-information-tab" data-toggle="tab" aria-controls="edit-other-information" aria-expanded="false"><i class="fa fa-info" aria-hidden="true"></i>
      Other Information</a></li>
       
   </ul>
   <div id="myTabContent" class="tab-content">
      <div role="tabpanel" class="tab-pane fade active in" id="edit-personal-information" aria-labelledby="edit-personal-information-tab">
      <br>
      <div class="form-group">
                          	
                           
                                 <label for="" class="col-sm-3 control-label">First Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editFirstName" name="editFirstName" placeholder="" required="required" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Last Name</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editLastName"  name="editLastName" placeholder="" maxlength="100">
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian First Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editParentOrGuardianFirstName" name="editParentOrGuardianFirstName" required="required" placeholder="" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent or Guardian Last Name</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editParentOrGuardianLastName" name="editParentOrGuardianLastName" placeholder="" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent/Guardian Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="email" class="form-control" id="editParentOrGuardianEmail"  name="editParentOrGuardianEmail" placeholder="" required="required" maxlength="100">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Gender<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="editStudentGender" id="editStudentGender" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Gender</option>
                                             <option value="Male">Male</option>
                                             <option value="Female">Female</option>

                                             
                                              <option value="Others">Others</option>
                                          </select>                                 </div>
                              </div>
                              
                               
                               
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Date of Birth<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control form-control-birth-datepicker" id="editDateOfBirth" name="editDateOfBirth" placeholder="" required="required" maxlength="10">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Email<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="email" class="form-control" id="editEMail"  name="editEMail" placeholder="" required="required" maxlength="100">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student Contact<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editContact" name="editContact" required="required" placeholder=""  onkeypress="return isNumber(event)" maxlength="20">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent Contact<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editParentContact" required="required" name="editParentContact" placeholder=""  onkeypress="return isNumber(event)" maxlength="20">
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
                                       <label for="" class="col-sm-3 control-label">Special Category<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                        <select name="editSpecialCategoryId" id="editSpecialCategoryId" data-live-search="true"  data-style="btn-white" class="selectpicker" multiple="multiple" required="required">
                                      <option value="" disabled selected>Select Special Category </option>
                                       <c:if test="${!empty specialCategories}">
                                          <c:forEach items="${specialCategories}" var="specialCategory">
                                             <option value="${specialCategory.getSpecialCategoryId()}">${specialCategory.getSpecialCategoryName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                       </div>
                                    </div> 
                                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">AadharCard Number</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editAadharCardNumber" name="editAadharCardNumber" placeholder=""  onkeypress="return isNumber(event)" maxlength="100">
                                 </div>
                              </div>
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">House<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editHouseId" id="editHouseId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required"  required="required">
                                         <option value="" disabled selected>Select House</option>
                                       <c:if test="${!empty houseList}">
                                          <c:forEach items="${houseList}" var="house">
                                             <option value="${house.getHouseId()}">${house.getHouseName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                       </div>
                                    </div> 
                                     <div class="form-group">

                                 <label for="" class="col-sm-3 control-label">Father Income In lakhs(Std. Currency)</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editFatherIncome" name="editFatherIncome" placeholder="" onkeypress="return decimalAmount(this, event, 2)" maxlength="255">
                                 </div>
                                 </div>
                                 <div class="form-group">

                                 <label for="" class="col-sm-3 control-label">Mother Income In lakhs(Std. Currency)</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editMotherIncome" name="editMotherIncome" placeholder=""onkeypress="return decimalAmount(this, event, 2)" maxlength="255">
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
                                    <input type="text" name="editStudentAddressLine1" class="form-control" id="editStudentAddressLine1" placeholder="" required="required" maxlength="225">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Address Line 2<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStudentAddressLine2" class="form-control" id="editStudentAddressLine2" placeholder="" required="required" maxlength="225">
                                 </div>
                              </div>
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                        <%--   <select name="editStudentCountry" id="geographicallocation1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Country </option>
                                             <c:if test="${!empty countries}">
		                                       		<c:forEach items="${countries}" var="country">
		                                       			<option value="${country.getName()}">${country.getName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select> --%>
                                                      <input type="text" name="editStudentCountry" class="form-control" id="geographicallocation1" placeholder="" required="required" maxlength="225">
                        
                                       </div>
                                    </div>      
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">State<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                         <%--  <select name="editStudentState" id="geographicallocationstate1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                          <option value="" disabled selected>Select State </option>
                                             <c:if test="${!empty stateList}">
		                                       		<c:forEach items="${stateList}" var="stateList">
		                                       			<option value="${stateList.getName()}">${stateList.getName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                         </select> --%>
                                                              <input type="text" name="editStudentState" class="form-control" id="geographicallocationstate1" placeholder="" required="required" maxlength="225">
                        
                                       </div>
                                    </div> 
                              <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">City<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                         <%--  <select name="editStudentCity" id="geographicallocationcity1" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                         <option value="" disabled selected>Select City</option>
                                             <c:if test="${!empty cityList}">
		                                       		<c:forEach items="${cityList}" var="cityList">
		                                       			<option value="${cityList.getName()}">${cityList.getName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                         </select> --%>
                                                              <input type="text" name="editStudentCity" class="form-control" id="geographicallocationcity1" placeholder="" required="required" maxlength="225">
                        
                                       </div>
                                    </div>      
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Post Code<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editStudentPostCode" class="form-control" id="editStudentPostCode" placeholder="" maxlength="6" required="required" onkeypress="return isNumber(event)">
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
                                       <label for="" class="col-sm-3 control-label">Joining Class<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editJoinedClass" id="editJoinedClass" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                                <option value="" disabled selected>Select Class</option>
                                           		 <c:if test="${!empty joinedclasses}">
		                                       			<c:forEach items="${classes}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                     
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Current Class<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editStudentClass" id="editStudentClass" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
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
                                       <label for="" class="col-sm-3 control-label">Section<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="editJoinedSection" id="editJoinedSection" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Section</option>
                                            	<c:if test="${!empty sections}">
		                                       			<c:forEach items="${sections}" var="sections">
		                                       				<option value="${sections.getSectionId()}">${sections.getSectionName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Joined Academic Year<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="editAcademicYearId" id="editAcademicYearId"  class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Academic Year</option>
                                         <c:if test="${!empty academicYears}">
		                                       			<c:forEach items="${academicYears}" var="academicYear">
		                                       		<option value="${academicYear.getAcademicYearId()}">${academicYear.getAcademicYearTitle()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                      </select>
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class Roll No (unique)</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editRollNo" name="editRollNo" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Joined date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" required="required" class="form-control form-control-datepicker" id="editJoinedDate" name="editJoinedDate" placeholder="" maxlength="10">
                                 </div>
                                 </div>
                                
                                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Access No</label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editStudentAccessNo" name="editStudentAccessNo" placeholder="" maxlength="50">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Admission No<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" id="editStudentAdmissionNo"  required="required" name="editStudentAdmissionNo" placeholder="" maxlength="50">
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
               <div role="tabpanel" class="tab-pane fade" id="edit-user-information" aria-labelledby="edit-user-information-tab">
      <br>
                                                          <div class="form-group ">
                                                    <label class="col-sm-3 control-label " for="adminName">Name <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input class="required form-control" id="adminName" name="adminName" required="required" type="text" maxlength="100" >
                                                    </div>
                                                </div>
                                               
                                                <div class="form-group ">
                                                    <label class="col-sm-3 control-label " for="adminPassword"> Password <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="adminPassword" name="adminPassword" type="password" class="required form-control" required="required" onChange="checkPasswordMatch();">

                                                    </div>
                                                </div>

                                                <div class="form-group ">
                                                    <label class="col-sm-3 control-label " for="adminConfirmPassword">Confirm Password<span>*</span> </label>
                                                    <div class="col-sm-7">
                                                        <input id="adminConfirmPassword" name="adminConfirmPassword" type="password"  required="required" class="required form-control" maxlength="100" onChange="checkPasswordMatch();" >
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
                               
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                     <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
                                
      
      </div>
      
                     <div role="tabpanel" class="tab-pane fade" id="edit-parentuser-information" aria-labelledby="edit-parentuser-information-tab">
      <br>
                                                          <div class="form-group ">
                                                    <label class="col-sm-3 control-label " for="parentAdminName">Parent User Name <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input class="required form-control" id="parentAdminName" name="parentAdminName" required="required" type="text" maxlength="100" >
                                                    </div>
                                                </div>
                                               
                                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Upload Parent Profile </label> 
                                 <div class="col-sm-7">
                                    <input class="filestyle" data-size="md" name="editParentProfilePic" id="editParentProfilePic" type="file"/>  <br>
                                    <div class="viewimage3">
                                        <img src="#" id="editParentProfile" class="thumb-image" alt="" style="display:none;"></img>
                                    </div>
                                 </div>
                              </div>
                                               
                                                <div class="form-group ">
                                                    <label class="col-sm-3 control-label " for="parentAdminPassword">Parent User Password <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="parentAdminPassword" name="parentAdminPassword" type="password" required="required" class="required form-control" onChange="parentCheckPasswordMatch();">

                                                    </div>
                                                </div>

                                                <div class="form-group ">
                                                    <label class="col-sm-3 control-label " for="adminConfirmPassword">Parent User Confirm Password<span>*</span> </label>
                                                    <div class="col-sm-7">
                                                        <input id="parentAdminConfirmPassword" name="parentAdminConfirmPassword" required="required" type="password" class="required form-control" maxlength="100" onChange="parentCheckPasswordMatch();" >
                                                    </div>
                                            
                                                </div>
                                                 
                                                <div class="error2" style="margin-left:200px;color:red"></div>
                                            <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Parent Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="parentStatus" id="parentStatus" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Active</option>
                                       <option value="0">Inactive</option>
                                    </select>
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
      <div role="tabpanel" class="tab-pane fade" id="edit-other-information" aria-labelledby="edit-other-information-tab">
      <br>
      
      
       
                            <div class="form-group">
                                 <label for="studentProfilePic" class="col-sm-3 control-label">Upload Photo</label> 
                                 <div class="col-sm-7">
                                    <input name="editStudentProfilePic" class="filestyle" data-size="md" id="editStudentProfilePic" type="file" />
                                    <br>
                                    <div class="viewimage1" >
                                   <img src="#" id="editStudentImage" class="thumb-image" alt="" style="display:none;"></img>
                                     
                                    </div>
                                 </div>
                              </div>
                                   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Upload Scanned Signature</label> 
                                 <div class="col-sm-7">
                                    <input class="filestyle" data-size="md" name="editScannedSignature" id="editScannedSignature" type="file"/>  <br>
                                    <div class="viewimage2">
                                        <img src="#" id="editStudentSignature" class="thumb-image" alt="" style="display:none;"></img>
                                 
                                    </div>
                                    
                                 </div>
                              </div>
      
      						<div class="form-group">
	                                 <label for="" class="col-sm-3 control-label">Passport No</label> 
	                                 <div class="col-sm-7"> 
	                                    <input type="text" class="form-control" id="editPassportNo"  name="editPassportNo" placeholder="" maxlength="100">
	                                 </div>
	                              </div>
                                <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Blood Group</label> 
                                       <div class="col-sm-7">
                                           <select name="editBloodGroupId" id=editBloodGroupId class="selectpicker" data-live-search="true"  data-style="btn-white">
                                                <option value="" disabled selected>Select Blood Group </option>
                                        		<c:if test="${!empty bloodGroups}">
		                                       			<c:forEach items="${bloodGroups}" var="bloodGroup">
		                                       					<option value="${bloodGroup.getBloodGroupId()}" >${bloodGroup.getBloodGroupName()}</option>
		                                       			</c:forEach>
		                                       	</c:if>
                                          </select>
                                       </div>
                                    </div><div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="editStudentStatus" id="editStudentStatus" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Status</option>
                                      	<c:if test="${!empty studentStatus}">
		                                       			<c:forEach items="${studentStatus}" var="studentStatus">
		                                       					<option value="${studentStatus.getStudentStatusId()}" >${studentStatus.getStatusTitle()}</option>
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
                                                
                                             </tr>
                                          </tbody>
                                       </table>
                         <br>
                               <input type="hidden" id="updateStudentId" name="updateStudentId">
                               <input type="hidden" id="updateUserId" name="updateUserId">
                                <input type="hidden" id="updateParentUserId" name="updateParentUserId">
                                <input type="hidden" id="documentsCount" name="documentsCount"> 
                             <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                   <security:authorize access="hasRole('managestudent/update')">
                          
                                <a href="#" id="updateStudent" style="float:right" class="btn btn-success btn-custom waves-effect waves-light" type="submit" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>     
                                    			      </security:authorize>
      
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
   </div></div>
    <script> 
        	 
    function selectimage(i)
	 {
    	 $("#divimage"+i).append('<input class="filestyle img" data-size="md" name="documents" id="document'+i+'" type="file" required="required"/> ');
    	 $("#document"+i).filestyle('clear');
	 }
    function editselectimage(i)
	 {
   		$("#divimage"+i).append('<input class="filestyle img" data-size="md" name="documents" id="document'+i+'" type="file" />  <label for="imagepath'+i+'" id="imagepath'+i+'"></label>');
   	 	$("#document"+i).filestyle('clear');
	 }
        	 function selectdropdown(i)
        	 {
        		/*  var name=$("#idforappending").val(); */
        		 $("#div"+i).append('<select name="documentType" id="documentType'+i+'" data-live-search="true" class="selectpicker"  data-style="btn-white" required="required">'+
                ' <option value="" disabled selected>Select DocumentType</option>'+
                 '<c:if test="${!empty documentTypeList}">'+
                  '  <c:forEach items="${documentTypeList}" var="documentTypeList">'+
                     '  <option value="${documentTypeList.getDocumentTypeId()}">${documentTypeList.getDocumentTypeTitle()}</option>'+
                   ' </c:forEach>'+
                ' </c:if>'+
              '</select>');
        		
        	 }
       
         </script> 
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
                    	   $('#studentSignature').filestyle('clear');
                       edumaatAlert({
 		    			  title: "Info !",
 		    			  text: "This browser does not support FileReader.",
 		    			  type: "info",
 		    			  confirmButtonText: "Cool"
 		    			});
                     }
                   } else {
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
                    	 $('#studentProfilePic').filestyle('clear');
                    	 edumaatAlert({
     		    			  title: "Info !",
     		    			  text: "This browser does not support FileReader.",
     		    			  type: "info",
     		    			  confirmButtonText: "Cool"
     		    			});
                     }
                   } else {
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
                 $("#editStudentProfilePic").on('change', function() {
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
                    	  $('#editStudentProfilePic').filestyle('clear');
                    	  edumaatAlert({
     		    			  title: "Info !",
     		    			  text: "This browser does not support FileReader.",
     		    			  type: "info",
     		    			  confirmButtonText: "Cool"
     		    			});
                     }
                   } else {
                	   $('#editStudentProfilePic').filestyle('clear');
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
                 $("#editScannedSignature").on('change', function() {
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
                    	  $('#editScannedSignature').filestyle('clear');
                    	  edumaatAlert({
  		    			  title: "Info !",
  		    			  text: "This browser does not support FileReader.",
  		    			  type: "info",
  		    			  confirmButtonText: "Cool"
  		    			});
                     }
                   } else {
                	   $('#editScannedSignature').filestyle('clear');
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
                    	  $('#parentProfilePic').filestyle('clear');
                    	  edumaatAlert({
     		    			  title: "Info !",
     		    			  text: "This browser does not support FileReader.",
     		    			  type: "info",
     		    			  confirmButtonText: "Cool"
     		    			});
                     }
                   } else {
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
      
      <script> 
         $(document).ready(function() {
                 $("#editParentProfilePic").on('change', function() {
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
                    	  $('#editParentProfilePic').filestyle('clear');
                    	  edumaatAlert({
     		    			  title: "Info !",
     		    			  text: "This browser does not support FileReader.",
     		    			  type: "info",
     		    			  confirmButtonText: "Cool"
     		    			});
                     }
                   } else {
                	   $('#editParentProfilePic').filestyle('clear');
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
        
     
      
       <script src="${pageContext.request.contextPath}/resources/themes/script/managestudent.js" type="text/javascript"></script>
     <%--  <script src="${pageContext.request.contextPath}/resources/themes/script/geographicallocation.js"></script>
      --%> <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/jquery.dataTables.min.js"></script>
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