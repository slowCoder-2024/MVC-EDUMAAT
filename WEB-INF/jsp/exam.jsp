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
       <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-circliful/css/jquery.circliful.css" rel="stylesheet" type="text/css" />
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
    <script src="${pageContext.request.contextPath}/resources/${theme}/js/skycons.js"></script>
<!--//skycons-icons-->
<!--circlechart-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.circlechart.js"></script>
      
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
            
        <div class="row">
                            <div class="col-lg-3 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="showemarkuploadDiv();">
                                  
                                  
                                     <i class="md  md-mode-edit text-primary"></i>
                                    <h4 class="m-0 text-dark counter font-600">STUDENT M/G</h4>
                                    <div class="text-muted m-t-5">Upload Or Update</div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="showGeneratorRepotCardDiv();">
                                    <i class="ion ion-ios7-cog  text-pink"></i>
                                    <h4 class="m-0 text-dark counter font-600">REPORT CARD</h4>
                                    <div class="text-muted m-t-5">Generator</div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="showDisplayReportCardDiv();">
                                    <i class="md  md-face-unlock text-info"></i>
                                    <h4 class="m-0 text-dark counter font-600">REPORT CARD(S)</h4>
                                    <div class="text-muted m-t-5">Display</div>
                                </div>
                            </div>
                            
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
            <div class="modal fade" id="savestudentmarkconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Confirmation ?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure you want to  update this student marks ?</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="savestudentmarkconfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
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
              <div class="modal fade" id="getStudentMarkDetailsConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation ?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure you want to generate GP and CGPA ?</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="getStudentMarkDetailsConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
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
            <div id="Markupload" style="display:none;">
                     <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h5 class="m-t-0 header-title" style="color:purple;">MARK OR GRADE UPDATE</h5>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 
                                  <form class="form-horizontal" id="markorgradeuploaddetailsform">
 
								 <div class="form-group">
                                 <label for="" class="col-sm-2 control-label"> Class <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-3"> 
                                <select name="class" id="class" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                		                                   		        	<option value="" disabled selected>Select Class</option>
                                
                                           		 <c:if test="${!empty classes}">
                                   
		                                       			<c:forEach items="${classes}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                 </div>
                               
                              
                                 <label for="" class="col-sm-2 control-label"> Section <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-3"> 
                                  <select name="section" id="section" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                   </select>
                                 </div>
                              </div>
                        
                                <div class="row">
                              <div class="col-sm-offset-3">
                                 <button style="float:right"  type="button" id="getdetailsinupload" class="btn btn-success btn-custom waves-effect waves-light">Get Details</button>
                                  
                              </div>
                           </div>
                           
                           </form>
                           <br>
                           
                           <div id="showMarksUploadDiv" style="display: none">
                             <div class="x_title">
                                    <div class="clearfix">
                                    </div>
                                 </div>
                                 
                                 
                                 <br>
                                  <form class="form-horizontal"  id="markupdateform">
                                 
                                                  <div class="card-box" style="box-shadow: 0 0px 8px 0 rgba(94, 194, 179, 0.67), 0 1px 0px 0 rgba(12, 236, 133, 0)">
            <div>
              <h1 class="m-t-0 header-title" style="color:purple;" id="studentName"></h1>
               <input type="hidden" id="studentId" name="studentId">
                <input type="hidden" id="classId" name="classId">
                 <input type="hidden" id="sectionId" name="sectionId">
            </div>
            
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img  id="studentPhoto"alt="User Pic" src="http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png" class="img-circle img-responsive"> </div>
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                    
                      <tr style="border-top: hidden">
                        <th style="text-align: left; color:#e69d6e">ADMISSION NO &nbsp;</th>
                        <td id="studentAdmissionNo"></td>
                      </tr>
                       <tr>
                        <th style="text-align: left; color: #e69d6e">ROLL NO &nbsp;</th>
                        <td id="studentRollNo"></td>
                      </tr>
                      
                      <tr>
                        <th style="text-align: left;color: #e69d6e">DATE OF BIRTH &nbsp;</th>
                        <td id="studentDateOfBirth"></td>
                      </tr>
                   
                         <tr>
                             <tr>
                        <th style="text-align: left;color: #e69d6e">GENDER &nbsp;</th>
                        <td id="studentGender"></td>
                      </tr>
                     
                      <tr>
                        <th style="text-align: left;color: #e69d6e">EMAIL&nbsp;</th>
                        <td><a  id="studentEmail"></a></td>
                      </tr>
                      <tr>
                        <th style="text-align: left;color: #e69d6e">PHONE NUMBER&nbsp;</th>
                        <td id="studentPhoneNumber">
                              </td>
                           
                      </tr>
                        
                      <tr>
                        <th style="text-align: left;color: #e69d6e">JOINED ACADEMIC YEAR &nbsp;</th>
                        <td id="joinedAcademicYear"></td>
                      </tr>
                      <tr>
                        <th style="text-align: left;color: #e69d6e">STUDENT STATUS&nbsp;</th>
                        <td id="studentStatus"></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
             </div>
                 <div class="panel-footer">
                        <a type="button" target="_blank" href="${pageContext.request.contextPath}/communication" class="btn btn-info btn-rounded waves-effect waves-light"><i class="glyphicon glyphicon-envelope"></i></a>
                        <span class="pull-right">
                        <button type="button" id="detailsbackward" class="btn btn-warning btn-rounded waves-effect waves-light" disabled="disabled">
                                                   <span class="btn-label"><i class="fa fa-arrow-left"></i>
                                                   </span>
                                                   Back
                                                </button>
                       <button type="button" id="detailsforward" class="btn btn-success btn-rounded waves-effect waves-light">Next
                                                   <span class="btn-label btn-label-right"><i class="fa fa-arrow-right"></i>
                                                   </span>
                                                </button>
                             
                             
                       
                        </span>
                    </div>
                    </div>
                    <div class="card-box" style="box-shadow: 0 0px 8px 0 rgba(94, 194, 179, 0.67), 0 1px 0px 0 rgba(12, 236, 133, 0)">
                    
                     <div>
              <h3 class="m-t-0 header-title" style="color:purple;">Student Mark / Grade Update</h3>
            </div>
            <br>
            <div class="form-horizontal">
            <div class="form-group">
                                 <label for="" class="col-sm-2 control-label">Assessment Type  <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-3"> 
                                  <select name="assessmentType" id="assessmentType" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class And Section First</option>
                                   </select>
                                 </div>
                            
                                 <label for="" class="col-sm-2 control-label">Term Exam <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-3"> 
                                  <select name="classSectionTermExamId" id="classSectionTermExamId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                          <option value="" disabled selected>Select Class And Section First</option>
                                   </select>
                                 </div>
                              </div>
            <div id="showtabledata" style="display: none">
            
            
           
                    
                                  <table class="table table-striped table-bordered" id="marksandgradeupload">
                                  
                              <thead id="tableheaddata">
                                
                              </thead>
                              <tbody id="studentmarksdata">
                             
                         
                              </tbody>
                              
                           </table>
                        
                      
                       
                       
            
            </div>
            
            
            
            </div>
                    </div> 
            <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                   <input type="hidden" id="moduleBasedMarksUpdateDetails" name="moduleBasedMarksUpdateDetails">
                                    <button style="float:right" type="button" id="updatemarksvalid" value="submit"  class="btn btn-success btn-custom waves-effect waves-light">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                    <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                <button style="float: right" type="button"class="btn btn-warning btn-custom waves-effect waves-light" onclick="showBackMarkAndGradeCardDiv();">Back</button>
                                 
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
         
            <div id="generatereportcard" style="display:none;">
       
       
       
        <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h5 class="m-t-0 header-title" style="color:purple;">Report Card Generator</h5>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                      <form class="form-horizontal" id="studentGPAndCGPACalculationForm" action="${pageContext.request.contextPath}/exam/studentGPAndCGPACalculation" method="post">
                         
                              			  <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Class <span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="currClass" id="currClass" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
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
                                       <label for="" class="col-sm-3 control-label">Section <span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="currSection" id="currSection" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                          </select>
                                       </div>
                                    </div>
                              <div class="form-group assessment" style=" display: none;" >
                                       <label for="" class="col-sm-3 control-label">Formative Assessment <span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="formativeassessment" id="formativeassessment" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required" multiple="multiple">
                                                <option value="" disabled >Select Class And Section First</option>
                                           		 
                                          </select>
                                       </div>
                                    </div><div class="form-group assessment" style=" display: none;">
                                       <label for="" class="col-sm-3 control-label">Summative Assessment <span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="summativeassessment" id="summativeassessment" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required" multiple="multiple">
                                                <option value="" disabled>Select Class And Section First</option>
                                           		 
                                          </select>
                                       </div>
                                    </div>
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="getStudentMarkDetails"  class="btn btn-success btn-custom waves-effect waves-light">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                    <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                    <button style="float: right" type="button"class="btn btn-warning btn-custom waves-effect waves-light" onclick="showbackreportcarddiv();">Back</button>
                                    
                                    </div>
                              </div>
                           </form>
                                
                                
                                
                                
                                </div>
                                </div>
                                </div>
                                </div>
                                </div>
                                
       
            
                  </div>
         
         
         <div id="displayreportcard" style="display:none;">
        
        
            <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h5 class="m-t-0 header-title" style="color:purple;"> Display Report Card</h5>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 
                                 
                                  <form class="form-horizontal" id="getDisplayStudentMarkDetailForm" action="${pageContext.request.contextPath}" method="post">
         <div class="row">
         
         			  <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Class<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="classId" id="displayClass" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
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
                                       <div class="col-sm-6">
                                          <select name="section" id="displaySection" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                          </select>
                                       </div>
                                    </div>
        
        
        </div>
      
        
             <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="getDisplayStudentMarkDetails"  class="btn btn-success btn-custom waves-effect waves-light">Get</button>
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                    <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                    <button style="float: right" type="button"class="btn btn-warning btn-custom waves-effect waves-light" onclick="showBackDisReportCardDiv();">Back</button>
                                    
                                    </div>
                     
                     
                             </div>
                             </form>
                                      <div class="row"  style="display: none" id="reportcardtablediv">
               <h3 class="m-t-0 header-title" style="color:purple;">Student Report Card List's</h3>
               
                 <br>
                   
                                 <table class="table table-striped table-bordered" id="reportcardtable" >
                                    <thead>
                                            <tr>
                                 
                                 
                                 <th>Admission No</th>
                                   <th>Student Name</th>
                                  	
                                   	<th>Student Contact Tel</th>
                                   	<th>Parent Contact Tel</th>
                                   	
                                  
                                  	
                               		<th>Action</th>
                                 </tr>
                                    </thead>
                            
                                 </table>
                             
                       </div>
                                 
                                 </div>
                                 </div>
                                 </div>
                                 </div>
                                 </div>
                                
        
         
       
        
   
    
        
        
       
        
        
        
     
       
        </div>
         
         
             <div id="viewreportcard" style="display:none; ">
                      <br>
                      <br>
							<h2 class="title1" style="text-align: center;color:#F66D6D">REPORT BOOK</h2>
							<br>
							<div class="card-box" style="box-shadow: 0 0px 8px 0 rgba(94, 194, 179, 0.67), 0 1px 0px 0 rgba(12, 236, 133, 0)">
												<h4 class="title" style="color:#4A148C">STUDENT PROFILE:</h4>
			
										       <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img  id="reportCardStudentPhoto"alt="User Pic" src="http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png" class="img-circle img-responsive"> </div>
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                    
                      <tr style="border-top: hidden">
                        <th style="text-align: left; color:#e69d6e">NAME OF THE STUDENT &nbsp;</th>
                        <td id="reportCardStudentName" style="color:#00BCD4"></td>
                      </tr>
                       <tr>
                        <th style="text-align: left; color: #e69d6e">ADDMISSION NO &nbsp;</th>
                        <td id="reportCardStudentAdmissionNo" style="color:#00BCD4"></td>
                      </tr>
                      
                      <tr>
                        <th style="text-align: left;color: #e69d6e">DATE OF BIRTH &nbsp;</th>
                        <td id="reportCardStudentDateOfBirth" style="color:#00BCD4"></td>
                      </tr>
                   
                         <tr>
                             <tr>
                        <th style="text-align: left;color: #e69d6e">GENDER &nbsp;</th>
                        <td id="reportCardStudentGender" style="color:#00BCD4"></td>
                      </tr>
                     <tr>
                        <th style="text-align: left;color: #e69d6e">PARENT/GUARDIN NAME&nbsp;</th>
                        <td id="reportCardPGName" style="color:#00BCD4"></td>
                      </tr>
                      <tr>
                        <th style="text-align: left;color: #e69d6e">ADDRESS &nbsp;</th>
                        <td id="reportCardAddress" style="color:#00BCD4"></td>
                      </tr>
                      <tr>
                        <th style="text-align: left;color: #e69d6e">EMAIL&nbsp;</th>
                        <td><a  id="reportCardStudentEmail"></a></td>
                      </tr>
                      <tr>
                        <th style="text-align: left;color: #e69d6e">PHONE NUMBER&nbsp;</th>
                        <td id="reportCardStudentPhoneNumber" style="color:#00BCD4">
                              </td>
                      </tr>
                        
                      <tr>
                        <th style="text-align: left;color: #e69d6e">JOINED ACADEMIC YEAR &nbsp;</th>
                        <td id="reportCardJoinedAcademicYear" style="color:#00BCD4"></td>
                      </tr>
                      <tr>
                        <th style="text-align: left;color: #e69d6e">STUDENT STATUS&nbsp;</th>
                        <td id="reportCardStudentStatus" style="color:#00BCD4"></td>
                      </tr>
                      
                    </tbody>
                  </table>
                
                </div>
                     <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
              </div>
           
									
										  <h4 class="title" style="color:#4A148C">ATTENDANCE:</h4>
										  
					 <div class="row">
                                        <div class="col-sm-6 col-lg-4 text-center">
                                            <div class="p-20">
                                                <input class="knob" data-width="150" data-height="150" data-angleOffset="90" data-linecap="round" data-fgColor="#ffbd4a" value="85" data-readOnly=true />
                                                <h5 class="font-600 text-muted">Total Working Days</h5>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 col-lg-4 text-center">
                                            <div class="p-20">
                                                <input class="knob" data-width="150" data-height="150" data-min="0" data-displayPrevious=true data-max="100" data-step="1" value="75" data-fgColor="#7266ba" data-readOnly=true/>
                                                <h5 class="font-600 text-muted">Total Attendance</h5>
                                            </div>
                                        </div>
                                        
                                        <div class="col-sm-6 col-lg-4 text-center">
                                            <div class="p-20">
                                                <input data-readOnly=true  class="knob" data-width="150" data-height="150" data-displayPrevious=true data-fgColor="#5d9cec" data-skin="tron" data-cursor=false value="75" data-thickness=".3" data-angleOffset=-125 data-angleArc=250 value="44"/>
                                                <h5 class="font-600 text-muted">Percentage Of Attendance</h5>
                                            </div>
                                        </div>
                                    </div>
									       <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
									<h4 class="title" style="text-align: center;" >ACADEMIC PERFORMANCE</h4>
									<h4 class="title" style="color:#4A148C"> PART-1:SCHOLASTIC AREAS:</h4>
									<div class="panel-group tool-tips widget-shadow" id="accordion" style="background-color: " role="tablist" aria-multiselectable="false">
										<h4 class="title">MODULES</h4>
									<div class="row" id="appendModule">
				  
				  </div>
				  
				  
				  
				  
				  
				  
				  		
				  
				  
				  
				  
				  
				  
				  </div>
				    		<div class="col-md-6 weather-grids weather-right" style="width: 100%;">
						<h4 class="title1" style="color:red">Module Wise Overall Percentage</h4>
					<div class="row" id="overallpercentmodule">
					
					
					
					</div>
						
						
						 
						
					</div>
				  	<div class="col-md-6 weather-grids weather-right" style="width: 100%;">
						<h4 class="title" style="color:red">Overall Percentage</h4>
						<div class="row" id="overallpercent">
					
					
					
					</div>
					
						
						
					</div>
		
					<div class="clearfix"> </div>
					
						<h4 class="title" style="color:#4A148C"> PART-II:CO-SCHOLASTIC AREAS:</h4>
						
					<div class="panel-group tool-tips widget-shadow" id="accordion2" style="background-color: " role="tablist" aria-multiselectable="true">
										<h4 class="title">2(A):Life Skills</h4>
									<div class="row">
				  <div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne" style="background-color: #1bb4af;">
					  <h4 class="panel-title">
						<a style="color:white;text-align:center" role="button" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
						  Self Awareness
						</a>
					  </h4>
					</div>
					<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
					  <div class="panel-body">
<table class="table table-bordered">
							<thead>
								<tr>
									<th>Semester</th>
									<th>Grade</th>
									
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>SA1</td>
									<td>C</td>
								</tr>
								<tr>
									<td>SA2</td>
									<td>B</td>
								</tr>
								
							</tbody>
						</table> 					  </div>
					</div>
				  </div>
				  <div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo" style="background-color: #1bb4af;">
					  <h4 class="panel-title">
						<a  style="color:white;text-align:center" class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
							Problem Solving
						</a>
					  </h4>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
					  <div class="panel-body">
<table class="table table-bordered">
							<thead>
								<tr>
									<th>Semester</th>
									<th>Grade</th>
									
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>SA1</td>
									<td>A</td>
								</tr>
								<tr>
									<td>SA2</td>
									<td>B</td>
								</tr>
								
							</tbody>
						</table> 					  </div>
					</div>
				  </div>
				  <div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingThree" style="background-color: #1bb4af;">
					  <h4 class="panel-title">
						<a style="color:white;text-align:center;" class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
							Decision Making
						</a>
					  </h4>
					</div>
					<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
					  <div class="panel-body">
<table class="table table-bordered">
							<thead>
								<tr>
									<th>Semester</th>
									<th>Grade</th>
									
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>SA1</td>
									<td>A</td>
								</tr>
								<tr>
									<td>SA2</td>
									<td>B</td>
								</tr>
								
							</tbody>
						</table> 					  </div>
					</div>
				  </div>
						</div>
						<br>
										<h4 class="title">2(B):Visual and Performing Arts</h4>
									<div class="row">
				  <div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOnevi1" style="background-color: #1bb4af;">
					  <h4 class="panel-title">
						<a style="color:white;text-align:center" role="button" data-toggle="collapse" data-parent="#accordion2" href="#collapseOnevi1" aria-expanded="true" aria-controls="collapseOnevi1">
						  Dance
						</a>
					  </h4>
					</div>
					<div id="collapseOnevi1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOnevi1">
					  <div class="panel-body"><table class="table table-bordered">
							<thead>
								<tr>
									<th>Semester</th>
									<th>Grade</th>
									
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>SA1</td>
									<td>A</td>
								</tr>
								<tr>
									<td>SA2</td>
									<td>B</td>
								</tr>
								
							</tbody>
						</table> </div>
					</div>
				  </div>
				  <div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwovi2" style="background-color: #1bb4af;">
					  <h4 class="panel-title">
						<a  style="color:white;text-align:center" class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwovi2" aria-expanded="false" aria-controls="collapseTwovi2">
							Drawing
						</a>
					  </h4>
					</div>
					<div id="collapseTwovi2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwovi2">
					  <div class="panel-body">
<table class="table table-bordered">
							<thead>
								<tr>
									<th>Semester</th>
									<th>Grade</th>
									
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>SA1</td>
									<td>D</td>
								</tr>
								<tr>
									<td>SA2</td>
									<td>B</td>
								</tr>
								
							</tbody>
						</table> 					  </div>
					</div>
				  </div>

						</div>
						</div>
						
						
								<h4 class="title" style="color:#4A148C"> PART-III:CO-SCHOLASTIC ACTIVITIES:</h4>
						
					<div class="panel-group tool-tips widget-shadow" id="accordion3" style="background-color: " role="tablist" aria-multiselectable="true">
										<h4 class="title">3(A):CO-SCHOLASTIC ACTIVITIES</h4>
									<div class="row">
				  <div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne31" style="background-color: #1bb4af;">
					  <h4 class="panel-title">
						<a style="color:white;text-align:center" role="button" data-toggle="collapse" data-parent="#accordion3" href="#collapseOne31" aria-expanded="true" aria-controls="collapseOne31">
						Literary Skills
						</a>
					  </h4>
					</div>
					<div id="collapseOne31" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne31">
					  <div class="panel-body">
	<table class="table table-bordered">
							<thead>
								<tr>
									<th>Semester</th>
									<th>Grade</th>
									
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>SA1</td>
									<td>B</td>
								</tr>
								<tr>
									<td>SA2</td>
									<td>B</td>
								</tr>
								
							</tbody>
						</table> 					  </div>
					</div>
				  </div>
				  <div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo31" style="background-color: #1bb4af;">
					  <h4 class="panel-title">
						<a  style="color:white;text-align:center" class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion3" href="#collapseTwo31" aria-expanded="false" aria-controls="collapseTwo31">
							Scientific And ICT Skills
						</a>
					  </h4>
					</div>
					<div id="collapseTwo31" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo31">
					  <div class="panel-body">
<table class="table table-bordered">
							<thead>
								<tr>
									<th>Semester</th>
									<th>Grade</th>
									
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>SA1</td>
									<td>A</td>
								</tr>
								<tr>
									<td>SA2</td>
									<td>B</td>
								</tr>
								
							</tbody>
						</table> 					  </div>
					</div>
				  </div>
			
						</div>
						<br>
										<h4 class="title">3(B):Health And Physical Education</h4>
									<div class="row">
				  <div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne131" style="background-color: #1bb4af;">
					  <h4 class="panel-title">
						<a style="color:white;text-align:center" role="button" data-toggle="collapse" data-parent="#accordion3" href="#collapseOne131" aria-expanded="true" aria-controls="collapseOne131">
						  Swimming
						</a>
					  </h4>
					</div>
					<div id="collapseOne131" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne131">
					  <div class="panel-body">
<table class="table table-bordered">
							<thead>
								<tr>
									<th>Semester</th>
									<th>Grade</th>
									
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>SA1</td>
									<td>C</td>
								</tr>
								<tr>
									<td>SA2</td>
									<td>B</td>
								</tr>
								
							</tbody>
						</table> 					  </div>
					</div>
				  </div>
				  <div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo231" style="background-color: #1bb4af;">
					  <h4 class="panel-title">
						<a  style="color:white;text-align:center" class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion3" href="#collapseTwo231" aria-expanded="false" aria-controls="collapseTwo231">
							Physical Education
						</a>
					  </h4>
					</div>
					<div id="collapseTwo231" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo231">
					  <div class="panel-body">
<table class="table table-bordered">
							<thead>
								<tr>
									<th>Semester</th>
									<th>Grade</th>
									
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>SA1</td>
									<td>A</td>
								</tr>
								<tr>
									<td>SA2</td>
									<td>B</td>
								</tr>
								
							</tbody>
						</table> 					  </div>
					</div>
				  </div>

						</div>
						</div>
						
						
						
						
						
									<h4 class="title" style="text-align: center">SELF AWARENESS</h4>
						
					<div class="panel-group tool-tips widget-shadow" id="accordion4" style="background-color: " role="tablist" aria-multiselectable="true">
										
									<div class="row">
				  <div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne3141" style="background-color: #1bb4af;">
					  <h4 class="panel-title">
						<a style="color:white;text-align:center" role="button" data-toggle="collapse" data-parent="#accordion4" href="#collapseOne3141" aria-expanded="true" aria-controls="collapseOne3141">
						My Goals
						</a>
					  </h4>
					</div>
					<div id="collapseOne3141" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne3141">
					  <div class="panel-body">
						Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. apiente ea proident. Ad vegan excepteur butcher vice lomo.  labore sustainable VHS.
					  </div>
					</div>
				  </div>
				  <div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo3141" style="background-color: #1bb4af;">
					  <h4 class="panel-title">
						<a  style="color:white;text-align:center" class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion4" href="#collapseTwo3141" aria-expanded="false" aria-controls="collapseTwo3141">
							My Strength
						</a>
					  </h4>
					</div>
					<div id="collapseTwo3141" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo3141">
					  <div class="panel-body">
						Eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Anim pariatur cliche reprehenderit, enim  Food truck quinoa nesciunt laborum eiusmod. apiente ea proident. Ad vegan excepteur butcher vice lomo.  labore sustainable VHS.
					  </div>
					</div>
				  </div>
				  <div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo43141" style="background-color: #1bb4af;">
					  <h4 class="panel-title">
						<a  style="color:white;text-align:center" class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion4" href="#collapseTwo43141" aria-expanded="false" aria-controls="collapseTwo43141">
							My Interests And Hobbies
						</a>
					  </h4>
					</div>
					<div id="collapseTwo43141" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo43141">
					  <div class="panel-body">
						Eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Anim pariatur cliche reprehenderit, enim  Food truck quinoa nesciunt laborum eiusmod. apiente ea proident. Ad vegan excepteur butcher vice lomo.  labore sustainable VHS.
					  </div>
					</div>
				  </div>	  <div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo43141" style="background-color: #1bb4af;">
					  <h4 class="panel-title">
						<a  style="color:white;text-align:center" class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion4" href="#collapseTwo43141" aria-expanded="false" aria-controls="collapseTwo43141">
							Responsibilities Discharged / Exceptional Achievements
						</a>
					  </h4>
					</div>
					<div id="collapseTwo43141" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo43141">
					  <div class="panel-body">
						Eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Anim pariatur cliche reprehenderit, enim  Food truck quinoa nesciunt laborum eiusmod. apiente ea proident. Ad vegan excepteur butcher vice lomo.  labore sustainable VHS.
					  </div>
					</div>
				  </div>
						</div>
						
							
						</div>
						
						
						
						
						<div class="typography">
						
						
							<div class="grid_3 grid_5 widget-shadow">
					<h4 class="hdg">GRADE SYSTEM</h4>
					<div class="col-md-6">
						<p>(Grading on 9 point scale)</p>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Grade</th>
									<th>Marks Range</th>
									<th>Grade Point</th>
									
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>A1</td>
									<td>91 - 100</td>
									<td>10.0</td>
								</tr>
								<tr>
									<td>A2</td>
									<td>81 - 90</td>
									<td>9.0</td>
								</tr>
								<tr>
									<td>B1</td>
									<td>71 - 80</td>
									<td>8.0</td>
								</tr>
								<tr>
									<td>B2</td>
									<td>61 - 70</td>
									<td>7.0</td>
								</tr>
								<tr>
									<td>C1</td>
									<td>51 - 60</td>
									<td>6.0</td>
								</tr>
								<tr>
									<td>C2</td>
									<td>41 - 50</td>
									<td>5.0</td>
								</tr>
								<tr>
									<td>D</td>
									<td>33 - 40</td>
									<td>4.0</td>
								</tr>
								<tr>
									<td>E1</td>
									<td>21 - 32</td>
									<td>3.0</td>
								</tr>
								<tr>
									<td>E2</td>
									<td>00 - 20</td>
									<td>2.0</td>
								</tr>
								
							</tbody>
						</table>                    
					</div>
					<div class="col-md-6">
						<p>(Grading on 5 point scale)</p>
							<table class="table table-bordered">
							<thead>
								<tr>
									<th>Grade</th>
									<th>Grade Point</th>
									
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>A</td>
									<td>4.1 - 5.0</td>
								</tr>
								<tr>
									<td>B</td>
									<td>3.1 - 4.0</td>
								</tr>
								<tr>
									<td>C</td>
									<td>2.1 - 3.0</td>
								</tr>
								<tr>
									<td>D</td>
									<td>1.1 - 2.0</td>
								</tr>
								<tr>
									<td>E</td>
									<td>0 - 1.0</td>
								</tr>
								
							</tbody>
						</table> 
					</div>
				   <div class="clearfix"> </div>
				</div>	
						
						
						<div class="grid_3 grid_5 widget-shadow">
					<h4 class="hdg">NOTE :</h4>
					<div class="alert alert-success" role="alert">
						<strong>FIRST SEMESTER :</strong>FA1 (10%) + FA2 (10%) + SA1 (30%) = 50%
					</div>
					
					<div class="alert alert-info" role="alert">
						<strong>SECOND SEMESTER :</strong> FA3 (10%) + FA4 (10%) + SA2 (30%) = 50%
					</div>
					
					<div class="alert alert-warning" role="alert">
						Student must obtain the qualifying grade <strong>(Minimum Grade D )</strong> in all the subjects under <strong>Scholastic and Co-Scholastic Domains</strong>
					</div>
					<br><br>
				</div>
						</div>
						
						
						
									  <div class="row">
                               
                                 <div class="col-sm-offset-3">
                                   
                                   
                                    <button style="float: right" type="button"class="btn btn-info" onclick="showBackDisReportCardDiv()">Back</button>
                                    
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
     <script src="${pageContext.request.contextPath}/resources/themes/script/studentjson.js" type="text/javascript"></script> 
    <!-- EASY PIE CHART JS -->
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery.easy-pie-chart/dist/easypiechart.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery.easy-pie-chart/dist/jquery.easypiechart.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/pages/easy-pie-chart.init.js"></script>

        <!-- KNOB JS -->
        <!--[if IE]>
        <script type="text/javascript" src="assets/plugins/jquery-knob/excanvas.js"></script>
        <![endif]-->
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-knob/jquery.knob.js"></script>


        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-circliful/js/jquery.circliful.min.js"></script>
        <script>
			$(function() {
				$(".knob").knob();
                $('.circliful-chart').circliful();
			});
		</script>
    <script src="${pageContext.request.contextPath}/resources/themes/script/exam.js" type="text/javascript"></script>     
     <script type="text/javascript">
  
    TableManageButtons.init();
    
    
  

    </script>
   </body>
</html>

