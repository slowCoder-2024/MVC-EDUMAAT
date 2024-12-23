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
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/custombox/css/custombox.css" rel="stylesheet">
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
             <security:authorize access="hasRole('class/add')">
               <div class="form-group">
                  <div class="col-md-4 col-sm-4 col-xs-12"> 
                     <button type="button" class="btn btn-success btn-custom waves-effect waves-light col-md-12 col-xs-12" onclick="showClassAndSectionDiv()">CONFIGURE CLASS WITH ASSESSMENT METHOD / TYPE</button>
                  </div>
               </div>
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br>
               </security:authorize>
               
              
               
              <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Class List WithOut Exam Configured</b></h4>
                              <br>
                     <table class="table table-striped table-bordered" id="classListWithOutExamConfigDataTable">
                        <thead>
                           <tr>
                              <th>Class Name</th>
                              <th>No Of Sections</th>
                             
                              <th>Action</th>
                            
                             
                              <th >Exam Configuration</th>
                            
                           </tr>
                        </thead>
                        <tbody id="classlistswithoutexamconfig">
                           <c:if test="${!empty classListWithOutExamConfigured}">
                              <c:forEach items="${classListWithOutExamConfigured}" var="clazzwithoutexamconfig">
                                 <tr>
                                    <td>${clazzwithoutexamconfig.getClassName()}</td>
                                    <td  >
                                      <c:forEach items="${clazzwithoutexamconfig.getClassSections()}" var="clazzwithoutexamconfigddd">
                                    ${clazzwithoutexamconfigddd.getSectionClass().getSectionName()}<span>&nbsp;(Exam Not Configured)</span><br>
                                     </c:forEach>
                                     </td>
                                    
                                    
                                    <td>
                                       <a href="#"  id="delete"  type="button" data-href="#"  data-id="${clazzwithoutexamconfig.getClassId()}" data-toggle="modal" data-target="#deleteclassconfirmation">
                                    	<i class="fa fa-trash-o"></i>
                                       </a>
                                    </td>
                                  
                                   
                                    <td><a href="#" id="examconfiguration"  type="button"data-href="#" data-id="${clazzwithoutexamconfig.getClassId()}" data-toggle="modal"onclick="showConfigurationDiv()">
                                       <span class="glyphicon glyphicon-new-window"></span>
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
               
               <br>
                 <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>	
                
               <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Class List With Exam Configured</b></h4>
                              <br>
                     <table class="table table-striped table-bordered" id="classListWithExamConfigDataTable">
                        <thead>
                           <tr>
                              <th>Class Name</th>
                              <th>No of Sections</th>
                                
                              <th>Action</th>
                             
                              
                           </tr>
                        </thead>
                        <tbody id="classlistswithexamconfig">
                           <c:if test="${!empty classListWithExamConfigured}">
                              <c:forEach items="${classListWithExamConfigured}" var="clazzwithexamconfig">
                                 <tr>
                                    <td>${clazzwithexamconfig.getClassName()}</td>
                                    <td>${clazzwithexamconfig.getClassSections().size()}</td>
                                    
                                    <td>
                                       <a href="#"  id="dedeflete"  type="button" data-href="#"  data-id="${clazzwithexamconfig.getClassId()}" data-toggle="modal" data-target="#dedfsleteclassconfirmation">
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
            
            	<div id="newclasscreate-modal" class="modal-demo" >
			    <button type="button" class="close" onclick="Custombox.close();">
			        <span>&times;</span><span class="sr-only">Close</span>
			    </button>
			    <h4 class="custom-modal-title">Create New Class</h4>
			    <div class="custom-modal-text">
			    
			       <form class="form-horizontal" action="${pageContext.request.contextPath}/class/add" method="post" id="addclassform">
			         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class Name <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="className" class="form-control" id="className" required="required" maxlength="50" >
                                   
                                 </div>
                              </div>
                              
                               <div class="row">
                            
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  id="addclass" type="button" class="btn btn-success btn-custom waves-effect waves-light">Submit</button>
                                    <button style="float: right" class="btn btn-info btn-custom waves-effect waves-light" type="reset">Clear</button>
                                 </div>
                              </div>
                              </form>
			    </div>
			</div>
                  <div class="modal fade" id="dedfsleteclassconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation ?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure you want to delete this class?</h5>
                     </div>
                     <div class="modal-footer">
                        <form id="deddeleteclassform" action="${pageContext.request.contextPath}/class/deleteClassWithConfig" method="post">
                           <input type="hidden" id="dedeleteClassId" name="dedeleteClassId">
                           <button type="button" id="confirmdefdeleteclass"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                        </form>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="deleteclassconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Confirmation ?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure you want to delete this class?</h5>
                     </div>
                     <div class="modal-footer">
                        <form id="deleteclassform" action="${pageContext.request.contextPath}/class/deleteClassWithOutConfig" method="post">
                           <input type="hidden" id="deleteClassId" name="deleteClassId">
                           <button type="button" id="confirmdeleteclass"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                        </form>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="classsaveconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure you want to add this class ?</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="classsaveconfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="classsectiontermexamactivitysaveconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure you want to add term exam activity in this class and section ?</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="classsectiontermexamactivitysaveconfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
              <div class="modal fade" id="classsectiontermexamandassessmenttypeexamactivitysaveconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure you want to add term exam and assessment type exam activity in this class and section ?</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="classsectiontermexamandassessmenttypeexamactivitysaveconfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="classsaveconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure you want to add this class ?</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="classsaveconfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div id="classAndSectionDiv" style="display:none;">
                     <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h5 class="panel-title">CONFIGURE CLASS AND SECTION WITH ASSESSMENT METHOD / TYPE  </h5>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 
                                 
                                        <div class="row">
                                    <div class="col-sm-offset-3">
                                       <a href="#newclasscreate-modal" style="float:right" class="btn btn-primary waves-effect waves-light" data-animation="rotatedown" data-plugin="custommodal" 
                                                    	data-overlaySpeed="100" data-overlayColor="#36404a">Create New Class</a>
                                    </div>
                                 </div>
                                 
                                
                        <form class="form-horizontal" action="${pageContext.request.contextPath}/class/configureClassWithAssessmentType" method="post" id="configureClassWithAssessmentTypeForm">
                           <fieldset id="firststep" class="" >
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="selectedClass" id="selectedClass" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
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
                                 <label for="" class="col-sm-3 control-label">Section Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="section"id="section" class="selectpicker" data-live-search="true"  data-style="btn-white"  required="required">
                                       
                                       <option value="" disabled selected>Select Section</option>
                                       <c:if test="${!empty sections}">
                                          <c:forEach items="${sections}" var="section">
                                             <option value="${section.getSectionId()}">${section.getSectionName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    </select>
                                 
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Exam / Assessment Template<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="examTemplate" id="examTemplate"class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Exam Template</option>
                                       <c:if test="${!empty examTemplates}">
                                          <c:forEach items="${examTemplates}" var="examTemplate">
                                             <option value="${examTemplate.getExamTemplateId()}">${examTemplate.getExamTemplateName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    </select>
                                
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class-Teacher / Coordinator<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="selectedClassStaff" id="selectedClassStaff"class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                        <option value="" disabled selected>Select Staff</option>
                                                      <c:if test="${!empty staffLists}">
                                                         <c:forEach items="${staffLists}" var="staffList">
                                                            <option value="${staffList.getStaffId()}">${staffList.getFirstName()}${staffList.getLastName()}</option>
                                                         </c:forEach>
                                                      </c:if>
                                    </select>
                                
                                 </div>
                              </div>
                              <br>
                              <h4 class="m-t-0 header-title" style="color:purple;">Assessment Methods / Type</h4>
                              <br>
                             
                                    <table class="table table-striped table-bordered" id="example">
                                       <thead>
                                          <tr>
                                             <th> <i class="fa fa-check-square-o" aria-hidden="true"></i></th>
                                             <th>Assessment Type</th>
                                             <th>Is Included In Grade Method</th>
                                             <th>Grades Mapping</th>
                                             <th>Assessment Indicator Threshold</th>
                                          </tr>
                                       </thead>
                                       <tbody id="assessmenttype">
                                          <tr>
                                             <td>
                                             <div class="checkbox checkbox-warning">
		                                            <input  type="checkbox" name="co-ScholasticArea" class="case" id="co-ScholasticArea">
		                                            <label></label>
		                                        </div>
                                             </td>
                                             <td>CoScholasticArea
                                             </td>
                                             <td>
                                                <div class="col-sm-12">
                                                   <select name="coScholasticAreaGradeMethod" id="coScholasticAreaGradeMethod" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                                      <option value="" disabled selected>Select Option</option>
                                                      <option value="true">Yes</option>
                                                      <option value="false">No</option>
                                                   </select>
                                                </div>
                                             </td>
                                             <td>
                                                <div class="col-sm-12">
                                                   <select name="coScholasticAreaGradeSystem" id="coScholasticAreaGradeSystem" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                                      <option value="" disabled selected>Select Grade System</option>
                                                      <c:if test="${!empty gradeSystems}">
                                                         <c:forEach items="${gradeSystems}" var="gradeSystem">
                                                            <option value="${gradeSystem.getGradeSystemId()}">${gradeSystem.getGradeSystemName()}</option>
                                                         </c:forEach>
                                                      </c:if>
                                                   </select>
                                                </div>
                                             </td>
                                             <td>
                                                <div class="col-sm-12">
                                                   <input type="text" name="" class="form-control form-control-firststep" id="" onkeypress="return isNumber(event)" maxlength="50">
                                                </div>
                                             </td>
                                          </tr>
                                          <tr>
                                             <td>
                                             
                                             <div class="checkbox checkbox-warning">
		                                            <input  type="checkbox" name="co-ScholasticActivity" class="case" id="co-ScholasticActivity">
		                                            <label></label>
		                                        </div>
                                            
                                             </td>
                                             <td>CoScholasticActivity
                                             </td>
                                             <td>
                                                <div class="col-sm-12">
                                                   <select name="coScholasticActivitiesGradeMethod" id="coScholasticActivitiesGradeMethod" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                                      <option value="" disabled selected>Select Option</option>
                                                      <option value="ture">Yes</option>
                                                      <option value="false">No</option>
                                                   </select>
                                                </div>
                                             </td>
                                             <td>
                                                <div class="col-sm-12">
                                                   <select name="coScholasticActivitiesGradeSystem" id="coScholasticActivitiesGradeSystem" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                                      <option value="" disabled selected>Select Grade System</option>
                                                      <c:if test="${!empty gradeSystems}">
                                                         <c:forEach items="${gradeSystems}" var="gradeSystem">
                                                            <option value="${gradeSystem.getGradeSystemId()}">${gradeSystem.getGradeSystemName()}</option>
                                                         </c:forEach>
                                                      </c:if>
                                                   </select>
                                                </div>
                                             </td>
                                             <td>
                                                <div class="col-sm-12">
                                                   <input type="text" name="sa" class="form-control form-control-firststep" id="sa" onkeypress="return isNumber(event)" maxlength="50">
                                                </div>
                                             </td>
                                          </tr>
                                          <tr>
                                             <td>
                                               <div class="checkbox checkbox-warning">
		                                            <input  type="checkbox" name="modulesBased" class="case" id="modulesBased">
		                                            <label></label>
		                                        </div>
                                             
                                             
                                             
                                             </td>
                                             <td>ModulesBased 
                                             </td>
                                             <td>
                                                <div class="col-sm-12">
                                                   <select name="modulesBasedGradeMethod" id="modulesBasedGradeMethod" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                                      <option value="" disabled selected>Select Option</option>
                                                      <option value="true">Yes</option>
                                                      <option value="false">No</option>
                                                   </select>
                                                </div>
                                             </td>
                                             <td>
                                                <div class="col-sm-12">
                                                   <select name="modulesBasedGradeSystem" id="modulesBasedGradeSystem" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                                      <option value="" disabled selected>Select Grade System</option>
                                                      <c:if test="${!empty gradeSystems}">
                                                         <c:forEach items="${gradeSystems}" var="gradeSystem">
                                                            <option value="${gradeSystem.getGradeSystemId()}">${gradeSystem.getGradeSystemName()}</option>
                                                         </c:forEach>
                                                      </c:if>
                                                   </select>
                                                </div>
                                             </td>
                                             <td>Not Applicable</td>
                                          </tr>
                                          <tr>
                                             <td>
                                               <div class="checkbox checkbox-warning">
		                                            <input  type="checkbox" name="moduleAndSkillBased" class="case" id="moduleAndSkillBased">
		                                            <label></label>
		                                        </div>
                                             
                                             
                                           
                                             </td>
                                             <td>ModuleAndSkillBased
                                             </td>
                                             <td>
                                                <div class="col-sm-12">
                                                   <select name="moduleAndSkillBasedGradeMethod" id="moduleAndSkillBasedGradeMethod" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                                      <option value="" disabled selected>Select Option</option>
                                                      <option value="true">Yes</option>
                                                      <option value="false">No</option>
                                                   </select>
                                                </div>
                                             </td>
                                             <td>
                                                <div class="col-sm-12">
                                                   <select name="moduleAndSkillBasedGradeSystem" id="moduleAndSkillBasedGradeSystem" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                                      <option value="" disabled selected>Select Grade System</option>
                                                      <c:if test="${!empty gradeSystems}">
                                                         <c:forEach items="${gradeSystems}" var="gradeSystem">
                                                            <option value="${gradeSystem.getGradeSystemId()}">${gradeSystem.getGradeSystemName()}</option>
                                                         </c:forEach>
                                                      </c:if>
                                                   </select>
                                                </div>
                                             </td>
                                             <td>Not Applicable</td>
                                          </tr>
                                       </tbody>
                                    </table>
                                
                                 <input type="hidden" id="assessmentDetails" name="assessmentDetails">
                             
                              <br>
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                
                                    <button style="float:right"  id="nextstep1" class="btn btn-success btn-custom waves-effect waves-light" type="button">Next <span class="btn-label btn-label-right"><i class="fa fa-arrow-right"></i>
                                                   </span></button>
                                    <button style="float: right" class="btn btn-info btn-custom waves-effect waves-light" type="reset">Clear</button>
                                    <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(true)">Cancel</button>
                                 </div>
                              </div>
                           </fieldset>
                           <fieldset id="secondstep">
                           
                           
                           <div id="modules-based-div" style="display:none;">
                                 <h3 class="m-t-0 header-title" style="color:purple;">Modules Based</h3>
                                 <div class="row">
                               <div class="col-sm-12">
                                 <div class="col-sm-offset-3">
                                 
                            
                                 <button  style="float:right"  type="button" class="btn btn-success btn-custom waves-effect waves-light btnadd-modules-based"><i class="fa fa-plus-circle" aria-hidden="true"></i></button>
                                 <button  style="float:right" type="button"  class="btn btn-danger btn-custom waves-effect waves-light btndel-modules-based" disabled="disabled"><i class="fa fa-times-circle" aria-hidden="true"></i></button>     
                                 </div>
                              </div>
                                 </div>
                                 <br>
                             
                                       <table class="table table-striped table-bordered" >
                                          <thead>
                                             <tr>
                                                <th>Module Name</th>
                                                <th>Allocate Staff</th>
                                             </tr>
                                          </thead>
                                          <tbody id="modulesbasedinfo">
                                             <tr id="clonedinputmodulesbased"class="clonedinputmodulesbased">
                                                <td>
                                                   <select name="modulesBasedModule" id="modulesBasedModule" data-live-search="true" class="form-control"  data-style="btn-white" required="required">
                                                      <option value="" disabled selected>Select Module</option>
                                                      <c:if test="${!empty moduleLists}">
                                                         <c:forEach items="${moduleLists}" var="moduleList">
                                                            <option value="${moduleList.getModuleId()}">${moduleList.getModuleName()}</option>
                                                         </c:forEach>
                                                      </c:if>
                                                   </select>
                                                </td>
                                                <td>
                                                   <select name="modulesBasedStaff" id="modulesBasedStaff" data-live-search="true" class="form-control"  data-style="btn-white" required="required">
                                                      <option value="" disabled selected>Select Staff</option>
                                                      <c:if test="${!empty staffLists}">
                                                         <c:forEach items="${staffLists}" var="staffList">
                                                            <option value="${staffList.getStaffId()}">${staffList.getFirstName()}${staffList.getLastName()}</option>
                                                         </c:forEach>
                                                      </c:if>
                                                   </select>
                                                </td>
                                             </tr>
                                          </tbody>
                                       </table>
                                  
                                 <div class="x_title">
                                    <div class="clearfix">
                                    </div>
                                 </div>
                                 <input type="hidden" id="modulesBasedDetails" name="modulesBasedDetails">
</div>
                           
                           
                           
                           
                      <%--         <div id="modules-based-div" style="display:none;">
                                 <h3 class="m-t-0 header-title" style="color:purple;">Modules Based</h3>
                                
                                    <div  class="modulesbasedclonepersection" id="modulesbasedclonepersection">
                                    <br>
                                    <br>
                                    <div class="row">
                               <div class="col-sm-12">
                                 <div class="col-sm-offset-3">
                                 
                                <label class="text-custom" style="font-size: 18px">SECTION :&nbsp;&nbsp;&nbsp;<span  class="sectionname text-success"></span></label>
                                 <button  style="float:right"  type="button" class="btn btn-success btn-custom waves-effect waves-light btnadd-modules-based"><i class="fa fa-plus-circle" aria-hidden="true"></i></button>
                                 <button  style="float:right" type="button"  class="btn btn-danger btn-custom waves-effect waves-light btndel-modules-based" disabled="disabled"><i class="fa fa-times-circle" aria-hidden="true"></i></button>     
                                 </div>
                              </div>
                                 </div>
                                 
                                 <br>
                                 
                                 
                                    
                                       <table class="table table-striped table-bordered modulebasedonly" >
                                          <thead>
                                             <tr>
                                                <th>Module Name</th>
                                                <th>Allocate Staff</th>
                                             </tr>
                                          </thead>
                                          <tbody id="modulesbasedinfo">
                                          
                                             <tr id="clonedinputmodulesbased-" class="clonedinputmodulesbased-">
                                                <td>
                                                  <div class="col-sm-12">
                                                   <select name="modulesBasedModule" id="modulesBasedModule" class="form-control" data-live-search="true"  data-style="btn-white" required="required">
                                                      <option value="" disabled selected>Select Module</option>
                                                      <c:if test="${!empty moduleLists}">
                                                         <c:forEach items="${moduleLists}" var="moduleList">
                                                            <option value="${moduleList.getModuleId()}">${moduleList.getModuleName()}</option>
                                                         </c:forEach>
                                                      </c:if>
                                                   </select>
                                                   </div>
                                                </td>
                                                <td>
                                                  <div class="col-sm-12">
                                                   <select name="modulesBasedStaff" id="modulesBasedStaff" data-live-search="true" class="form-control"  data-style="btn-white" required="required">
                                                      <option value="" disabled selected>Select Staff</option>
                                                      <c:if test="${!empty staffLists}">
                                                         <c:forEach items="${staffLists}" var="staffList">
                                                            <option value="${staffList.getStaffId()}">${staffList.getFirstName()}${staffList.getLastName()}</option>
                                                         </c:forEach>
                                                      </c:if>
                                                   </select>
                                                   </div>
                                                </td>
                                             </tr>
                                          </tbody>
                                       </table>
                                    
                                
                                 <div class="x_title">
                                    <div class="clearfix">
                                    </div>
                                 </div>
                                 
                              </div>
                              <input type="hidden" id="modulesBasedDetails" name="modulesBasedDetails">
                              </div> --%>
                              <br>
                              <div id="co-scholastic-area-div" style="display:none;">
                                 <h3 class="m-t-0 header-title" style="color:purple;">Co-Scholastic Areas</h3>
                                 
                                       <div class="row">
                               <div class="col-sm-12">
                                 <div class="col-sm-offset-3">
                                 
                                   <button  style="float:right" type="button" class="btn btn-success btn-custom waves-effect waves-light btnadd-co-scholastic-area"><i class="fa fa-plus-circle" aria-hidden="true"></i></button>
                                    <button  style="float:right" type="button" class="btn btn-danger btn-custom waves-effect waves-light  btndel-co-scholastic-area" disabled="disabled"><i class="fa fa-times-circle" aria-hidden="true"></i></button>
                                 
                                 
                                 
                                 </div>
                                 </div>
                                 </div>
                                 
                                   <br>
                           
                                  
                                    
                                    
                                       <table class="table table-striped table-bordered">
                                          <thead>
                                             <tr>
                                                <th>Co-Scholastic Area Name</th>
                                             </tr>
                                          </thead>
                                          <tbody id="coscholasticareasinfo">
                                             <tr id="clonedInputCo-Scholastic-Areas" class="clonedInputCo-Scholastic-Areas">
                                                <td>
                                                   <div class="col-sm-12 control-label">
                                                      <select name="co-scholastic-area" id="co-scholastic-area" data-live-search="true" class="form-control"  data-style="btn-white" required="required">
                                                         <option value="" disabled selected>Select Co-Scholastic Area</option>
                                                         <c:if test="${!empty coScholasticAreaServices}">
                                                            <c:forEach items="${coScholasticAreaServices}" var="coScholasticAreaService">
                                                               <option value="${coScholasticAreaService.getCoScholasticAreaId()}">${coScholasticAreaService.getcoScholasticAreaName()}</option>
                                                            </c:forEach>
                                                         </c:if>
                                                      </select>
                                                   </div>
                                                </td>
                                             </tr>
                                          </tbody>
                                       </table>
                                  
                                 <div class="x_title">
                                    <div class="clearfix">
                                    </div>
                                 </div>
                                 <input type="hidden" id="coScholasticAreaDetails" name="coScholasticAreaDetails">
                              </div>
                              <br>
                              <div id="co-scholastic-activities-div" style="display:none;">
                                 <h3  class="m-t-0 header-title" style="color:purple;">Co-Scholastic Activities</h3>
                                
                                
                                      <div class="row">
                               <div class="col-sm-12">
                                 <div class="col-sm-offset-3">
                                    <button  style="float:right" type="button" class="btn btn-success btn-custom waves-effect waves-light btnadd-co-scholastic-activities"><i class="fa fa-plus-circle" aria-hidden="true"></i></button>
                                    <button style="float:right" type="button" class="btn btn-danger  btn-custom waves-effect waves-light btndel-co-scholastic-activities" disabled="disabled"><i class="fa fa-times-circle" aria-hidden="true"></i>
                                    </button>
                                    </div>
                                    </div>
                                    </div>
                                    <br>
                                       <table class="table table-striped table-bordered">
                                          <thead>
                                             <tr>
                                                <th>Co-Scholastic Activities Name</th>
                                             </tr>
                                          </thead>
                                          <tbody id="coscholasticactivitiesinfo">
                                             <tr class="clonedinputco-scholastic-activities">
                                                <td>
                                                   <div class="col-sm-12 control-label">
                                                      <select name="coScholasticActivities" id="coScholasticActivities" data-live-search="true" class="form-control"  data-style="btn-white" required="required">
                                                         <option value="" disabled selected>Select Co-Scholastic Activities</option>
                                                         <c:if test="${!empty coScholasticActivityServices}">
                                                            <c:forEach items="${coScholasticActivityServices}" var="coScholasticActivityService">
                                                               <option value="${coScholasticActivityService.getCoScholasticActivityId()}">${coScholasticActivityService.getCoScholasticActivityName()}</option>
                                                            </c:forEach>
                                                         </c:if>
                                                      </select>
                                                   </div>
                                                </td>
                                             </tr>
                                          </tbody>
                                       </table>
                                  
                                 <div class="x_title">
                                    <div class="clearfix">
                                    </div>
                                 </div>
                                 <input type="hidden" id="coScholasticActivityDetails" name="coScholasticActivityDetails">
                              </div>
                              <br>
                              <div id="module-and-skill-based-div" style="display:none;">
                                 <h3  class="m-t-0 header-title" style="color:purple;">Modules And Skill Based</h3>
                                <div class="row">
                               <div class="col-sm-12">
                                 <div class="col-sm-offset-3">
                                    <button  style="float:right" type="button" class="btn btn-success btn-custom waves-effect waves-light btnadd-module-and-skill-based"><i class="fa fa-plus-circle" aria-hidden="true"></i></button>
                                    <button style="float:right" id="delete" type="button" class="btn btn-danger btn-custom waves-effect waves-light  btndel-module-and-skill-based" disabled="disabled"><i class="fa fa-times-circle" aria-hidden="true"></i>
                                    </button>
                                    </div>
                                    </div>
                                    </div>
                                   <br>
                                       <table class="table table-striped table-bordered">
                                          <thead>
                                             <tr>
                                                <th>Module Name</th>
                                                <th>Module Skill Name</th>
                                                <th>Allocate Staff</th>
                                             </tr>
                                          </thead>
                                          <tbody id="moduleandskillbasedinfo">
                                             <tr id="clonedinput-module-and-skill-based" class="clonedinput-module-and-skill-based">
                                                <td>
                                                   <div class="col-sm-12 control-label">
                                                      <select name="module-and-skill-based-module" id="module-and-skill-based-module" data-live-search="true" class="form-control"  data-style="btn-white" required="required">
                                                         <option value="" disabled selected>Select Module</option>
                                                         <c:if test="${!empty moduleLists}">
                                                            <c:forEach items="${moduleLists}" var="moduleList">
                                                               <option value="${moduleList.getModuleId()}">${moduleList.getModuleName()}</option>
                                                            </c:forEach>
                                                         </c:if>
                                                      </select>
                                                   </div>
                                                </td>
                                                <td>
                                                   <div class="form-group">
                                                      <div class="col-sm-12 control-label">
                                                         <select name="module-and-skill-based-skill" multiple id="module-and-skill-based-skill"data-live-search="true" class="form-control module-and-skill-based-skill-data"  data-style="btn-white" required="required">
                                                            <c:if test="${!empty moduleSkillServices}">
                                                               <c:forEach items="${moduleSkillServices}" var="moduleSkillService">
                                                                  <option value="${moduleSkillService.getModuleSkillId()}">${moduleSkillService.getModuleSkillName()}</option>
                                                               </c:forEach>
                                                            </c:if>
                                                         </select>
                                                      </div>
                                                   </div>
                                                </td>
                                                <td>
                                                   <div class="col-sm-12 control-label">
                                                      <select name="module-and-skill-based-staff" id="module-and-skill-based-staff" data-live-search="true" class="form-control"  data-style="btn-white" required="required">
                                                         <option value="" disabled selected>Select Staff</option>
                                                         <c:if test="${!empty staffLists}">
                                                            <c:forEach items="${staffLists}" var="staffList">
                                                               <option value="${staffList.getStaffId()}">${staffList.getFirstName()}${staffList.getLastName()}</option>
                                                            </c:forEach>
                                                         </c:if>
                                                      </select>
                                                   </div>
                                                </td>
                                             </tr>
                                          </tbody>
                                       </table>
                                   
                                 <div class="x_title">
                                    <div class="clearfix">
                                    </div>
                                 </div>
                                 <input type="hidden" id="moduleAndSkillBasedDetails" name="moduleAndSkillBasedDetails">
                              </div>
                              <br>
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  id="nextstep2" type="button" class="btn btn-success btn-custom waves-effect waves-light">Submit</button>
                                    <button style="float: right" class="btn btn-info btn-custom waves-effect waves-light" type="reset">Clear</button>
                                    <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                    <button style="float:right"class="btn btn-warning btn-custom waves-effect waves-light" type="button"  onclick="backtodiv()"><span class="btn-label"><i class="fa fa-arrow-left"> </i>
                                                  </span>Back </button>
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
            <div id="examconfigurationdiv" style="display:none;">
              
                     <h3 class="m-t-0 header-title" style="color:purple;">Exam Activity Configuration</h3>
                          <div class="row" >
                       <br>
                                 <div class="col-lg-12">
                        
                         <form  class="form-horizontal" id="savetermandassessmenttypeexamactivityform" action="${pageContext.request.contextPath}/classSection/addTermExamActivityAndAssessmentTypeExamActivity" method="post">
                       
                       <ul id="myTabs" class="nav nav-tabs" role="tablist">
                           <li role="presentation" class="active"><a href="#term-exam-activity-information" id="term-exam-activity-information-tab" role="tab" data-toggle="tab" aria-controls="term-exam-activity-information" aria-expanded="true">
                              1.Term Exam Activity</a>
                           </li>
                           <li role="presentation" class=""><a href="#assessment-type-exam-activity-information" role="tab" id="assessment-type-exam-activity-information-tab" data-toggle="tab" aria-controls="assessment-type-exam-activity-information" aria-expanded="false">
                              2.Assessment Type Exam Activity</a>
                        </ul>
                        <div id="myTabContent" class="tab-content">                                                
                           <div role="tabpanel" class="tab-pane fade active in" id="term-exam-activity-information" aria-labelledby="term-exam-activity-information-tab">
                              <br>
                              <br>
                              <div >
                                 <div class="form-group">
                                    <label for="" class="col-sm-3 control-label">Section<span class="at-required-highlight">*</span></label> 
                                    <div class="col-sm-7">
                                       <select name="sectionId" id="sectionId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                          <option value="" disabled selected>Select Section</option>
                                       </select>
                                    </div>
                                 </div>
                                 </div>	
                                  <div class="x_title">
                                    <div class="clearfix">
                                    </div>
                                 </div>
                                 <div id="term-exam-activity-dynamic-div">
                                 </div>
                            
                                 <input type="hidden" id="classId" name="classId">
                                 <input type="hidden" id="termExamActivityDetails" name="termExamActivityDetails">
                              
                           </div>
                           <div role="tabpanel" class="tab-pane fade" id="assessment-type-exam-activity-information" aria-labelledby="assessment-type-exam-activity-information-tab">
                              
                              <br>
                          
                                 
                                 
                                 <div id="assessmenttype-modulesbased-exam-activity-dynamic-div" style="display: none">
                                 <h3 class="m-t-0 header-title" style="color:#dd8433">Modules Based Exam Activity</h3>
                                 <br>
                                   
                            
                                 <table class="table table-striped table-bordered">
                                    <thead>
                                       <tr>
                                          
                                          <th>Module Name</th>
                                          
                                          <th>Evaluation Period</th>
                                           
                                       </tr>
                                    </thead>
                                    <tbody id="modulesbaseddata" class="assmbexactada"> 
                                    </tbody>
                                 </table>
                              
                       <br>
                        
                         
                                 </div>
                                          <div id="assessmenttype-moduleandskillbased-exam-activity-dynamic-div" style="display: none">
                                 <h3 class="m-t-0 header-title" style="color:#dd8433">Module And Skill Based Exam Activity</h3>
                                 <br>
                                 
                             
                                 <table class="table table-striped table-bordered">
                                    <thead>
                                       <tr>
                                          
                                          <th>Module Name</th>
                                          
                                          <th>Evaluation Period</th>
                                           
                                       </tr>
                                    </thead>
                                    <tbody id="moduleandskillbaseddata" class="assmsbexactada"> 
                                    </tbody>
                                 </table>
                            
                       
                       
                        <br>
                                 </div> 
                                 
                                           <div id="assessmenttype-coscholasticarea-exam-activity-dynamic-div" style="display: none">
                                 <h3 class="m-t-0 header-title" style="color:#dd8433">Co-Scholastic Area Exam Activity</h3>
                                 <br>
                                    
                            
                                 <table class="table table-striped table-bordered">
                                    <thead>
                                       <tr>
                                          
                                          <th>Co-Scholastic Area Name</th>
                                          
                                          <th>Evaluation Period</th>
                                           
                                       </tr>
                                    </thead>
                                    <tbody id="coscholasticareadata" class="asscosareaexactada"> 
                                    </tbody>
                                 </table>
                              
                        <br>
                                                
                        
                                 </div>
                                 
                                 
                                 
                                           <div id="assessmenttype-coscholasticactivity-exam-activity-dynamic-div" style="display: none">
                                 <h3 class="m-t-0 header-title" style="color:#dd8433;">Co-Scholastic Activity Exam Activity</h3>
                                 <br>
                                  
                                 <table class="table table-striped table-bordered">
                                    <thead>
                                       <tr>
                                          
                                          <th>Co-Scholastic Activity Name</th>
                                          
                                          <th>Evaluation Period</th>
                                           
                                       </tr>
                                    </thead>
                                    <tbody id="coscholasticactivitydata" class="asscosactivityexactada"> 
                                    </tbody>
                                 </table>
                             
                        <br>
                        
                                 </div>
                             
                                   <div class="x_title">
                                    <div class="clearfix">
                                    </div>
                                 </div>
                                   <div class="row">
                                    <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                    <div class="col-sm-offset-3">
                                       <button style="float:right"  id="savetermexamandassessmenttypeexamactivity" class="btn btn-success btn-custom waves-effect waves-light" type="button">Save</button>
                                       <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(true)">Cancel</button>
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
    
    </div></div>
     <script>
         var resizefunc = [];
      </script>
      <!-- jQuery  -->
 <script src="${pageContext.request.contextPath}/resources/themes/assets/js/bootstrap.min.js"></script> 
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
     <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/custombox/js/custombox.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/custombox/js/legacy.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/class.js" type="text/javascript"></script>  
      <script src="${pageContext.request.contextPath}/resources/themes/script/classclone.js" type="text/javascript"></script>  
      <script src="${pageContext.request.contextPath}/resources/themes/script/classsectionexamactivity.js" type="text/javascript"></script>        
     <script type="text/javascript">
  
    TableManageButtons.init();
    
    
  

    </script>
   </body>
</html>

