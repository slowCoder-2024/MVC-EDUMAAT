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
              <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/animate/animate.min.css" rel="stylesheet" type="text/css" />
        
         <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.colVis.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/fixedColumns.dataTables.min.css" rel="stylesheet" type="text/css"/>
     
       <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/animate/animate.min.css" rel="stylesheet" type="text/css" />
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/assets/plugins/magnific-popup/css/magnific-popup.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-datatables-editable/datatables.css" />
   
        
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
   
   
   
     <c:choose>         
                 <c:when test="${!empty classes}">
               <div id="ListDiv" style="display:block;">
            
                 <div class="form-group">
                              
                  <button type="button" style="float: left" class="btn btn-primary btn-custom waves-effect waves-light" onclick="showDiv()">Create Student Appraisal</button>
                  </div>
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
              
                 
                       	 <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-warning">
                              <div class="panel-heading">
                                <h2 class="panel-title">
			View And Edit Student Appraisal
		           </h2>
                                </div>
                              <div class="panel-body">
               <form class="form-horizontal" id="getDetails">
                <div class="form-three widget-shadow">
                
                         <div class="form-group form-group-groupcriteria" style="display: block">
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Class<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="class" id="class" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                  <option value="" disabled selected>Select Class</option>
                                  <c:if test="${!empty classes}">
                                  	  <c:forEach items="${classes}" var="clazz">
                                       		<option value="${clazz.getClassId()}">${clazz.getClassName()}</option>
                                       </c:forEach>
                                   </c:if>
                                    </select>
                                 </div>
                               
                              </div>
                             
                              <div class="form-group form-group-section" style="display: none">
                                 <label for="" class="col-sm-3 control-label"> Section <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="section" id="section" class="selectpicker" multiple data-style="btn-white"  data-live-search="true" required="required">
                                            <option value="" disabled selected>Select Class First</option>
                                         </select>
                                 </div>
                              </div>
                               </div>
                                <div class="form-group form-group-studentid" style="display:block;">
                                 <label for="" class="col-sm-3 control-label">Admission No (Unique Student Id)<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <input type="text" id="admissionNumber" name="admissionNumber" class="form-control" required="required"/>
                                 </div>
                              </div>
                               <div class="row">
                                 <div class="col-sm-offset-3">
                                      <button style="float:right"  type="button" id="getStudentAppraisal" class="btn btn-success btn-custom waves-effect waves-light">Get Details</button>
                                        <button style="float: right" class="btn btn-danger btn-custom waves-effect waves-light" type="button" onclick="location.reload(true)">Cancel</button>
                               
                                 </div>
                              </div>                              
                     <br/>
                     <br/>
               
                       
                           </div>
                      </form>
                      </div>
                      </div>
                      </div>
                      </div>
                      
                       	 <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-success">
                              <div class="panel-heading">
                                <h2 class="panel-title">
		
		           </h2>
                                </div>
                              <div class="panel-body">
                         <div class="tables">
                     <div class="table-responsive bs-example ">
                         <table class="table table-bordered" id="datatable">
                              <thead >
                                 <tr>
                                 <th>Student Admission Number</th>
                                  <th>Academic Year</th>
                                 <th>Student Name</th>
                                   <th>Class/Section</th>
                                   	<th>Appraisal Term</th>
                               		<th>Appraisal Status</th>
                                  	<th>Action</th>
                                 </tr>
                              </thead>
                              <tbody id="studentAppraisalList">
                         
                              </tbody>
                           </table>
                         
                        </div>
                        </div>
                        </div>
                        </div>
                        </div>
                        </div>
                        
                       </div>
                       
                       
                         </c:when>
				
           <c:otherwise>
            <div class="alert alert-success">
							<h5>Messages:</h5>
                                    <p>"No Classes Available"</p>
                  							</div>
                  							
           					
             </c:otherwise>
              </c:choose>
                       
                     </div>
                 
                  <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Please Confirm Action</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure to delete?</h5>
                     </div>
                     <div class="modal-footer">
                      <form id="deletestudentappraisalform" action="${pageContext.request.contextPath}/student/studentappraisaldelete" method="post">
                              <input type="hidden" id="deleteStudentAppraisalId" name="deleteStudentAppraisalId">
                              <button type="button" id="confirmDelete"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                      
                     </div>
                  </div>
               </div>
            </div>
             <div class="modal fade" id="deletestudentappraisalconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure you want to delete this student appraisal?</h5>
                     </div>
                     <div class="modal-footer">
                      <form id="deletestudentappraisalform" action="${pageContext.request.contextPath}/student/studentappraisaldelete" method="post">
                              <input type="hidden" id="deleteStudentAppraisalId" name="deleteStudentAppraisalId">
                              <button type="button" id="confirmdeletestudentappraisal"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                           </div>
                  </div>
               </div>
            </div>
             <div id="EditFormDiv" style="display:none;">
             
                            	 <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-info">
                              <div class="panel-heading">
                                <h2 class="panel-title">
				Student Appraisal
		           </h2>
                                </div>
                              <div class="panel-body">
                        <form class="form-horizontal" id="editAppraisal" action="${pageContext.request.contextPath}/student/updateStudentAppraisal" method="post">
                        <input type="hidden" name="updateStudentAppraisalId" id="updateStudentAppraisalId"/>
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student Admission Number<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                 <select name="editStudentAdmissionNumber" id="editStudentAdmissionNumber" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                          <c:if test="${!empty studentList}">
                                          <option value="" disabled selected>Select Student Admission Number</option>
                                          <c:forEach items="${studentList}" var="studentList">
                                             <option value="${studentList.getAdmissionNo()}">${studentList.getAdmissionNo()}</option>
                                          </c:forEach>
                                       </c:if>
                                         </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Appraisal Term<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="editAppraisalTerm" id="editAppraisalTerm" required="required" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Relationship Rating<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="editRelationshipRating" id="editRelationshipRating" required="required" class="selectpicker" data-style="btn-white"  data-live-search="true">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Relationship Comments<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="editRelationshipComments" id="editRelationshipComments" required="required" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Attitude Rating<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="editAttitudeRating" id="editAttitudeRating" required="required" class="selectpicker" data-style="btn-white"   data-live-search="true">
                                       <option value="" disabled selected>Select Rating</option>
                                     <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                                 
                                 
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Attitude Comments<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="editAttitudeComments" required="required" id="editAttitudeComments" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Rating<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                     <select name="editAcademicRating" id="editAcademicRating" required="required" class="selectpicker" data-style="btn-white"  data-live-search="true">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Comments<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="editAcademicComments" id="editAcademicComments" required="required" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Initiative Rating<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="editInitiativeRating" id="editInitiativeRating" required="required" class="selectpicker" data-style="btn-white"  data-live-search="true">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Initiative Comments<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="editInitiativeComments" id="editInitiativeComments" required="required" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Creativity Rating<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                     <select name="editCreativityRating" id="editCreativityRating" required="required" class="selectpicker" data-style="btn-white"  data-live-search="true">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Creativity Comments<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="editCreativityComments" id="editCreativityComments" required="required" placeholder="">
                                 </div>
                              </div>
                            <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Punctuality Rating<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="editPunctualityRating" id="editPunctualityRating" required="required" class="selectpicker" data-style="btn-white"  data-live-search="true">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Punctuality Comments<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="editPunctualityComments" id="editPunctualityComments" required="required" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Sports And Social Rating<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="editSportsAndSocialRating" id="editSportsAndSocialRating" required="required" class="selectpicker" data-style="btn-white"  data-live-search="true">
                                       <option value="" disabled selected>Select Rating</option>
                                       <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Sports And Social Comments<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="editSportsAndSocialComments" id="editSportsAndSocialComments" required="required" placeholder="">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Recommendations<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="editRecommentation" id="editRecommentation" required="required" placeholder="">
                                 </div>
                              </div>
                             <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Appraisal Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="editAppraisalStatus" id="editAppraisalStatus" required="required" class="selectpicker" data-style="btn-white"  data-live-search="true">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Completed</option>
                                       <option value="0">In-Process</option>
                                  
                                    </select>
                                 </div>
                              </div>
                               <div class="row">
                              <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                          
                                 <div class="col-sm-offset-3">     
                                  <a href="#" id="updateStudentAppraisal" style="float:right" class="btn btn-success btn-custom waves-effect waves-light" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>     
                                    <button style="float: right" class="btn btn-danger btn-custom waves-effect waves-light" type="button" onclick="location.reload(true)">Cancel</button>
                                 </div>
                              </div>
                           </form>
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
										<h4 class="modal-title" id="exampleModalLabel">Please Confirm Your Action</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure?</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="saveConfirm" id="saveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						</div>
                  <div id="FormDiv" style="display:none;">
                         	 <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                <h2 class="panel-title">
				Student Appraisal
		           </h2>
                                </div>
                              <div class="panel-body">
                        <form class="form-horizontal" id="appraisal" action="${pageContext.request.contextPath}/student/addStudentAppraisal" method="post">
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student Admission Number<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="studentAdmissionNumber" id="studentAdmissionNumber" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                          <c:if test="${!empty studentList}">
                                          <option value="" disabled selected>Select Student Admission Number</option>
                                          <c:forEach items="${studentList}" var="studentList">
                                             <option value="${studentList.getAdmissionNo()}">${studentList.getAdmissionNo()}</option>
                                          </c:forEach>
                                       </c:if>
                                         </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Appraisal Term<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="appraisalTerm" required="required"  id="appraisalTerm" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Relationship Rating<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="relationshipRating" id="relationshipRating" required="required" class="selectpicker" data-style="btn-white"  data-live-search="true">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Relationship Comments<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="relationshipComments" id="relationshipComments" required="required" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Attitude Rating<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="attitudeRating" id="attitudeRating" required="required" class="selectpicker" data-style="btn-white"  data-live-search="true">
                                       <option value="" disabled selected>Select Rating</option>
                                     <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                                 
                                 
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Attitude Comments<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="attitudeComments" id="attitudeComments" required="required" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Rating<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                     <select name="academicRating" id="academicRating" required="required" class="selectpicker" data-style="btn-white"  data-live-search="true">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Comments<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="academicComments" id="academicComments" required="required" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Initiative Rating<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="initiativeRating" id="initiativeRating" required="required" class="selectpicker" data-style="btn-white"  data-live-search="true">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Initiative Comments<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="initiativeComments" id="initiativeComments" required="required" placeholder="">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Creativity Rating<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                     <select name="creativityRating" id="creativityRating" required="required" class="selectpicker" data-style="btn-white"  data-live-search="true">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Creativity Comments<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="creativityComments" id="creativityComments" required="required" placeholder="">
                                 </div>
                              </div>
                            <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Punctuality Rating<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="punctualityRating" id="punctualityRating" required="required" class="selectpicker" data-style="btn-white"  data-live-search="true">
                                       <option value="" disabled selected>Select Rating</option>
                                      <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Punctuality Comments<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="punctualityComments" id="punctualityComments" required="required" placeholder="">
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Sports And Social Rating<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="sportsAndSocialRating" id="sportsAndSocialRating" required="required" class="selectpicker" data-style="btn-white"  data-live-search="true">
                                       <option value="" disabled selected>Select Rating</option>
                                       <option value="1">1</option>
                                       <option value="2">2</option>
                                          <option value="3">3</option>
                                             <option value="4">4</option>
                                               <option value="5">5</option>
                                  
                                    </select>
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Sports And Social Comments<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="sportsAndSocialComments" id="sportsAndSocialComments" required="required" placeholder="">
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Recommendations<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" class="form-control" name="recommentation" id="recommentation" required="required" placeholder="">
                                 </div>
                              </div>
                             <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Appraisal Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="appraisalStatus" id="appraisalStatus" required="required" class="selectpicker" data-style="btn-white"  data-live-search="true">
                                       <option value="" disabled selected>Select Status</option>
                                       <option value="1">Completed</option>
                                       <option value="0">In-Process</option>
                                  
                                    </select>
                                 </div>
                              </div>
                                 <div class="row">
                                                                  <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                            
                                 <div class="col-sm-offset-3">
                                  
                                    <button style="float:right"  type="button" id="addStudentAppraisal" class="btn btn-success btn-custom waves-effect waves-light">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                    <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()"  >Cancel</button>
                                    
                                 </div>
                              </div>
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
    
    
     <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/tiny-editable/mindmup-editabletable.js"></script>
	    <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/tiny-editable/numeric-input-example.js"></script>
	     <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-datatables-editable/jquery.dataTables.js"></script> 
	    <script src="${pageContext.request.contextPath}/resources/themes/assets/pages/datatables.editable.init.js"></script>
	    
	       <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/notifyjs/js/notify.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/notifications/notify-metro.js"></script>
	     <script type="text/javascript">
  
    TableManageButtons.init();

</script>

<script src="${pageContext.request.contextPath}/resources/themes/script/studentappraisalbystaff.js"></script>

</body>
</html>