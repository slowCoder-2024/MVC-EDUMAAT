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
<%--        <link rel="icon" href="${pageContext.request.contextPath}/resources/themes/images/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/printpage/css/style.css" /> --%>
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
            <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
                 <script src="${pageContext.request.contextPath}/resources/themes/printpage/js/jquery.printPage.js"></script>
    
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
      
		
		<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
		 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/css/monthly.css" type="text/css" /> 
 <script src="${pageContext.request.contextPath}/resources/themes/js/monthly.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/jquery.mtz.monthpicker.js"></script>

      
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

header {
  padding: 10px 0;
  margin-bottom: 1px;
   border-top: 2px solid  #000000;
  border-left: 2px solid  #000000;
border-right: 2px solid  #000000;
border-bottom: 2px solid  #000000;


}
.clearfix:after {
  content: "";
  display: table;
  clear: both;
}
#logo {
  float:left;
  margin-bottom: 10px;
  
}

#project {
  float: left;
 font-size: 13px;
  
  
}

#project span {
margin-left:10px;
  color: #ff0080;
  text-align: right;
  width: 52px;
  margin-right: 10px;
  display: initial;
  font-size: 12px;
}
#company span {
  color: #ff0080;
  text-align: right;
  width: 52px;
  margin-right: 10px;
  display: initial;
  font-size: 12px;
}
#company1 span {
  color: #ff0080;
  text-align: right;
  width: 52px;
  margin-right: 10px;
  display: initial;
  font-size: 12px;
}


#company {
	
  float: right;
  text-align: right;
margin-right: 10px;
font-size: 14px;
  
}

#project div,
#company div {
  white-space: normal;        
}
#company1 {
	
  float: right;
  text-align: right;
margin-right: 5px;
font-size: 13px;
  
}

#project div,
#company1 div {
  white-space: normal;        
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
	             
                  <div class="col-lg-4 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="showmodulewiseattendance();">
                                    <i class="md  md-assignment-ind  text-primary"></i>
                                    <h4 class="m-0 text-dark counter font-600">Generate Student ID Card</h4>
                                    <div class="text-muted m-t-5">Class And Section Wise</div>
                                </div>
                            </div>
                            
                            <div class="col-lg-4 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="showmonthwiseattendance();">
                                    <i class="ion ion-edit  text-pink"></i>
                                    <h4 class="m-0 text-dark counter font-600">View Student ID Card</h4>
                                    <div class="text-muted m-t-5">Class And Section Wise</div>
                                </div>
                            </div>
                            
                              <div class="col-lg-4 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="showdeleteidcard();">
                                    <i class="fa fa-trash  text-warning"></i>
                                    <h4 class="m-0 text-dark counter font-600">Delete Student ID Card</h4>
                                    <div class="text-muted m-t-5">Class And Section Wise</div>
                                </div>
                            </div>
                            
                               <div class="col-lg-4 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="showtransportidcardgeneration();">
                                    <i class="md md-directions-bus text-warning"></i>
                                    <h4 class="m-0 text-dark counter font-600">Generate Transport ID Card</h4>
                                    <div class="text-muted m-t-5">Admission Number Wise</div>
                                </div>
                            </div>
                            
                            <div class="col-lg-4 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="showtransportidcardview();">
                                    <i class="md md-create text-primary "></i>
                                    <h4 class="m-0 text-dark counter font-600">View Transport ID Card</h4>
                                    <div class="text-muted m-t-5">Class And Section Wise</div>
                                </div>
                            </div>
                            
                              <div class="col-lg-4 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="showtransportidcarddelete();">
                                    <i class="md md-cancel text-pink "></i>
                                    <h4 class="m-0 text-dark counter font-600">Delete Student ID Card</h4>
                                    <div class="text-muted m-t-5">Class And Section Wise</div>
                                </div>
                            </div>
                            
                               <div class="col-lg-4 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="showhostelidcardgeneration();">
                                    <i class="md md-hotel text-pink "></i>
                                    <h4 class="m-0 text-dark counter font-600">Generate Hostel ID Card</h4>
                                    <div class="text-muted m-t-5">Class And Section Wise</div>
                                </div>
                            </div>
                            
                            <div class="col-lg-4 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="showhostelidcardview();">
                                    <i class="icon icon-pencil  text-warning"></i>
                                    <h4 class="m-0 text-dark counter font-600">View Hostel ID Card</h4>
                                    <div class="text-muted m-t-5">Class And Section Wise</div>
                                </div>
                            </div>
                            
                              <div class="col-lg-4 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="showhostelidcarddelete();">
                                    <i class="md md-delete  text-primary"></i>
                                    <h4 class="m-0 text-dark counter font-600">Delete Hostel ID Card</h4>
                                    <div class="text-muted m-t-5">Class And Section Wise</div>
                                </div>
                            </div>
                 
  </div>
  <div class="modal fade" id="recprint" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>You want to print this id card</h5>
                     </div>
                     <div class="modal-footer">
                     <a type="button" class="btn btn-primary" id="printrec" href="">Print</a>
                        
                     </div>
                 </div>
               </div>
            </div>
    					<input type="hidden" name="currentselectedcriteriaid" id="currentselectedcriteriaid">		                      
                         <input type="hidden" name="currentselectedclassid" id="currentselectedclassid">
                         <input type="hidden" name="currentselectedsectionid" id="currentselectedsectionid">
                           <input type="hidden" name="currentselectedcriteriaid" id="currentselectedcriteriaid">
                             <input type="hidden" name="currentselectedfeestermid" id="currentselectedfeestermid">    
                          <input type="hidden" name="currentselectedacademicyearid" id="currentselectedacademicyearid">    
       <div id="OpenModuleAttendanceDiv" style="display:none;">
                                <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-primary">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Student ID Card Generation</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="moduleattendanceform" action="${pageContext.request.contextPath}/student/studentidcardgeneration/add" method="post">
                           
                            <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Year<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="moduleAcademicYearId" id="moduleAcademicYearId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
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
                                 <label for="" class="col-sm-3 control-label">Class <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="moduleClassId" id="moduleClassId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Class</option>
                                                <!--  <option value="all">All</option> -->
                                                <c:if test="${!empty classes}">
		                                       			<c:forEach items="${classes}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}(${clazz.getInstitution().getInstitutionCode()})</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                    </select>                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Section <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                          <select name="moduleSectionId" id="moduleSectionId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                          </select>                                 </div>
                              </div>
                             
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="getModuleAttendanceDetails"  class="btn btn-success btn-custom waves-effect waves-light">Generate Id Card</button>
                                    <button style="float:right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this);">Cancel</button>
                                    </div>
                              </div>
                           </form>
                        </div>
                        </div>
                        </div>
                      </div>
                  </div>
                   <div id="moduleattendancedetails" style="display:none;">
                    
                              
                              </div>
   </div>
   
        <div id="OpenOverAllDiv" style="display:none;">
                                <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">View Student ID Card</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="overallattendanceform">
                          
                                   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Year<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="overAllAcademicYearId" id="overAllAcademicYearId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
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
                                 <label for="" class="col-sm-3 control-label">Class <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="overAllClassId" id="overAllClassId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Class</option>
                                                <!--  <option value="all">All</option> -->
                                                <c:if test="${!empty classes}">
		                                       			<c:forEach items="${classes}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}(${clazz.getInstitution().getInstitutionCode()})</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                    </select>                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Section <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                          <select name="overAllSectionId" id="overAllSectionId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                          </select>                                 </div>
                              </div>
                             
                                     
                            
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="getOverAllDetails"  class="btn btn-success btn-custom waves-effect waves-light">Get Student ID Cards</button>
                                    <button style="float:right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this);">Cancel</button>
                                    </div>
                              </div>
                           </form>
                        </div>
                        </div>
                        </div>
                      </div>
                  </div>
                  
                      <div id="overallattendancedetails" style="display:none;">
                               <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box table-responsive">
                             <h4 class="m-t-0 header-title" style="color:purple;">Student ID Card Details</h4>
                      <br>
                       <div class="row">
                                 <div class="col-sm-offset-3">
                                   <a style="float:right" href="" id="preview" class="btn btn-info btn-custom waves-effect waves-light" type="button" data-href="#"  target="_blank" data-toggle="modal">
                                            Preview       </a>
                                <!--     <button style="float:right" id="preview" type="button" class="btn btn-info btn-custom waves-effect waves-light">Preview</button> -->
                                    <button style="float:right" id="print" type="button" class="btn btn-primary btn-custom waves-effect waves-light" >Print</button>
                                    </div>
                              </div>
                               <br>
                                <br>
                                <div id="studentIDCardGenerationDiv">
                               </div>
                               
                               
                               
                            
                              </div>
                              </div>
                              </div>
                              
                              </div>
                                <a style="display:none;" type="button" class="btn btn-primary" id="printpreview" target="_blank" href="">Print</a>
                               
                 
   </div>
   
      <div id="OpenDeleteIDCardDiv" style="display:none;">
                                <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-warning">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Delete Student ID Card</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="deleteidcardform" action="${pageContext.request.contextPath}/student/studentidcardgeneration/delete" method="post">
                           
                            <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Year<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="academicYearId" id="academicYearId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
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
                                 <label for="" class="col-sm-3 control-label">Class <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="classId" id="classId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Class</option>
                                                <!--  <option value="all">All</option> -->
                                                <c:if test="${!empty classes}">
		                                       			<c:forEach items="${classes}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}(${clazz.getInstitution().getInstitutionCode()})</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                    </select>                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Section <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                          <select name="sectionId" id="sectionId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                          </select>                                 </div>
                              </div>
                             
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="getDeleteIDCardDetails"  class="btn btn-success btn-custom waves-effect waves-light">Delete Id Card(s)</button>
                                    <button style="float:right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this);">Cancel</button>
                                    </div>
                              </div>
                           </form>
                        </div>
                        </div>
                        </div>
                      </div>
                  </div>
              
   </div>
   
   
   
   
    <div id="showtransportidgenerateDiv" style="display:none;">
                                <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-warning">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Student Transport ID Card Generation</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="generatestudenttransportidcardform" action="${pageContext.request.contextPath}/student/studenttrasportidcardgeneration/add" method="post">
                          
                            <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Criteria<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="transportidgenerationcriteriaId" id="transportidgenerationcriteriaId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Criteria</option>
                                         <option value="academicyear">Academic Year</option>
                                          <option value="feescategory">Fees Category</option>
                                     </select>
                                 </div>
                              </div>
                           
                            <div class="form-group form-group-academic-year" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Academic Year<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="transportIDCardGenerationAcademicYearId" id="transportIDCardGenerationAcademicYearId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Academic Year</option>
                                        <c:if test="${!empty academicYears}">
                                         <c:forEach items="${academicYears}" var="academicYear">
                                      			 <option value="${academicYear.getAcademicYearId()}">${academicYear.getAcademicYearTitle()}</option>
                                           </c:forEach>
                                      	</c:if>
                                     </select>
                                 </div>
                              </div>
                          
                           <div class="form-group form-group-fees-category" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Fees Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="transportIDCardGenerationFeesTermId" id="transportIDCardGenerationFeesTermId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Fees Category</option>
                                        <c:if test="${!empty feesTerms}">
                                         <c:forEach items="${feesTerms}" var="feesTerm">
                                      			 <option value="${feesTerm.getFeesTermId()}">${feesTerm.getFeesTermName()}</option>
                                           </c:forEach>
                                      	</c:if>
                                     </select>
                                 </div>
                              </div>
                          <div class="form-group" >
                                 <label for="" class="col-sm-3 control-label">Student Admission Number<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <input type="text" id="transportIDCardGenerationAdmissionNumber" name="transportIDCardGenerationAdmissionNumber" class="form-control" required="required">
                                 </div>
                              </div>
                             
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="generateStudentTrasportIDCard"  class="btn btn-success btn-custom waves-effect waves-light">Generate Id Card</button>
                                    <button style="float:right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this);">Cancel</button>
                                    </div>
                              </div>
                           </form>
                        </div>
                        </div>
                        </div>
                      </div>
                  </div>
                   <div id="moduleattendancedetails" style="display:none;">
                    
                              
                              </div>
   </div>
   
        <div id="showtransportidviewDiv" style="display:none;">
                                <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-primary">
                              <div class="panel-heading">
                                 <h2 class="panel-title">View Student Transport ID Card</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="viewStudentTrasportIDCardForm">
                          
                                     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Criteria<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="transportidviewcriteriaId" id="transportidviewcriteriaId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Criteria</option>
                                         <option value="academicyear">Academic Year</option>
                                          <option value="feescategory">Fees Category</option>
                                     </select>
                                 </div>
                              </div>
                           
                            <div class="form-group form-group-academic-year" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Academic Year<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="transportIDCardViewAcademicYearId" id="transportIDCardViewAcademicYearId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Academic Year</option>
                                        <c:if test="${!empty academicYears}">
                                         <c:forEach items="${academicYears}" var="academicYear">
                                      			 <option value="${academicYear.getAcademicYearId()}">${academicYear.getAcademicYearTitle()}</option>
                                           </c:forEach>
                                      	</c:if>
                                     </select>
                                 </div>
                              </div>
                          
                           <div class="form-group form-group-fees-category" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Fees Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="transportIDCardViewFeesTermId" id="transportIDCardViewFeesTermId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Fees Category</option>
                                        <c:if test="${!empty feesTerms}">
                                         <c:forEach items="${feesTerms}" var="feesTerm">
                                      			 <option value="${feesTerm.getFeesTermId()}">${feesTerm.getFeesTermName()}</option>
                                           </c:forEach>
                                      	</c:if>
                                     </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="transportIDCardViewClassId" id="transportIDCardViewClassId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Class</option>
                                                <!--  <option value="all">All</option> -->
                                                <c:if test="${!empty classes}">
		                                       			<c:forEach items="${classes}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}(${clazz.getInstitution().getInstitutionCode()})</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                    </select>                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Section <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                          <select name="transportIDCardViewSectionId" id="transportIDCardViewSectionId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                          </select>                                 </div>
                              </div>
                             
                                     
                            
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="viewStudentTrasportIDCard"  class="btn btn-success btn-custom waves-effect waves-light">Get Student ID Cards</button>
                                    <button style="float:right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this);">Cancel</button>
                                    </div>
                              </div>
                           </form>
                        </div>
                        </div>
                        </div>
                      </div>
                  </div>
                  
                      <div id="viewstudenttransportidcarddetails" style="display:none;">
                               <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box table-responsive">
                             <h4 class="m-t-0 header-title" style="color:purple;">Student Transport ID Card Details</h4>
                      <br>
                       <div class="row">
                                 <div class="col-sm-offset-3">
                                   <a style="float:right" href="" id="transportidcardpreview" class="btn btn-info btn-custom waves-effect waves-light" type="button" data-href="#"  target="_blank" data-toggle="modal">
                                            Preview       </a>
                                <!--     <button style="float:right" id="preview" type="button" class="btn btn-info btn-custom waves-effect waves-light">Preview</button> -->
                                    <button style="float:right" id="transportidcardprint" type="button" class="btn btn-primary btn-custom waves-effect waves-light" >Print</button>
                                    </div>
                              </div>
                               <br>
                                <br>
                                <div id="studentTransportIDCardViewDiv">
                               </div>
                               
                               
                               
                            
                              </div>
                              </div>
                              </div>
                              
                              </div>
                                <a style="display:none;" type="button" class="btn btn-primary" id="printpreview" target="_blank" href="">Print</a>
                               <div class="modal fade" id="recprint" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>You want to print this id card</h5>
                     </div>
                     <div class="modal-footer">
                     <a type="button" class="btn btn-primary" id="printrec" href="">Print</a>
                        
                     </div>
                 </div>
               </div>
            </div>
                 
   </div>
   
      <div id="showtransportiddeleteDiv" style="display:none;">
                                <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Delete Student Transport ID Card</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="deletetransportidcardform" action="${pageContext.request.contextPath}/student/studenttransportidcardgeneration/delete" method="post">
                           
                                    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Criteria<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="transportiddeletecriteriaId" id="transportiddeletecriteriaId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Criteria</option>
                                         <option value="academicyear">Academic Year</option>
                                          <option value="feescategory">Fees Category</option>
                                     </select>
                                 </div>
                              </div>
                           
                            <div class="form-group form-group-academic-year" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Academic Year<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="transportIDCardDeleteAcademicYearId" id="transportIDCardDeleteAcademicYearId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Academic Year</option>
                                        <c:if test="${!empty academicYears}">
                                         <c:forEach items="${academicYears}" var="academicYear">
                                      			 <option value="${academicYear.getAcademicYearId()}">${academicYear.getAcademicYearTitle()}</option>
                                           </c:forEach>
                                      	</c:if>
                                     </select>
                                 </div>
                              </div>
                          
                           <div class="form-group form-group-fees-category" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Fees Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="transportIDCardDeleteFeesCategoryId" id="transportIDCardDeleteFeesCategoryId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                        <option value="" disabled selected>Select Fees Category</option>
                                        <c:if test="${!empty feesTerms}">
                                         <c:forEach items="${feesTerms}" var="feesTerm">
                                      			 <option value="${feesTerm.getFeesTermId()}">${feesTerm.getFeesTermName()}</option>
                                           </c:forEach>
                                      	</c:if>
                                     </select>
                                 </div>
                              </div>
                             <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="transportIDCardDeleteClassId" id="transportIDCardDeleteClassId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Class</option>
                                                <!--  <option value="all">All</option> -->
                                                <c:if test="${!empty classes}">
		                                       			<c:forEach items="${classes}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}(${clazz.getInstitution().getInstitutionCode()})</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                    </select>                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Section <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                          <select name="transportIDCardDeleteSectionId" id="transportIDCardDeleteSectionId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                          </select>                                 </div>
                              </div>
                             
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="deleteTransportIDCardDetails"  class="btn btn-success btn-custom waves-effect waves-light">Delete Id Card(s)</button>
                                    <button style="float:right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this);">Cancel</button>
                                    </div>
                              </div>
                           </form>
                        </div>
                        </div>
                        </div>
                      </div>
                  </div>
              
   </div>
   
   
   
    <div id="showhostelidgenerateDiv" style="display:none;">
                                <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Student Hostel ID Card Generation</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="generatestudenthostelidcardform" action="${pageContext.request.contextPath}/student/studenthostelidcardgeneration/add" method="post">
                           
                            <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Criteria<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="hostelidgenerationcriteriaId" id="hostelidgenerationcriteriaId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Criteria</option>
                                         <option value="academicyear">Academic Year</option>
                                          <option value="feescategory">Fees Category</option>
                                     </select>
                                 </div>
                              </div>
                           
                            <div class="form-group form-group-academic-year" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Academic Year<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="hostelIDCardGenerationAcademicYearId" id="hostelIDCardGenerationAcademicYearId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Academic Year</option>
                                        <c:if test="${!empty academicYears}">
                                         <c:forEach items="${academicYears}" var="academicYear">
                                      			 <option value="${academicYear.getAcademicYearId()}">${academicYear.getAcademicYearTitle()}</option>
                                           </c:forEach>
                                      	</c:if>
                                     </select>
                                 </div>
                              </div>
                          
                           <div class="form-group form-group-fees-category" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Fees Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="hostelIDCardGenerationFeesTermId" id="hostelIDCardGenerationFeesTermId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                        <option value="" disabled selected>Select Fees Category</option>
                                        <c:if test="${!empty feesTerms}">
                                         <c:forEach items="${feesTerms}" var="feesTerm">
                                      			 <option value="${feesTerm.getFeesTermId()}">${feesTerm.getFeesTermName()}</option>
                                           </c:forEach>
                                      	</c:if>
                                     </select>
                                 </div>
                              </div>
                          <div class="form-group" >
                                 <label for="" class="col-sm-3 control-label">Student Admission Number<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <input type="text" id="hostelIDCardGenerationAdmissionNumber" name="hostelIDCardGenerationAdmissionNumber" class="form-control" required="required">
                                 </div>
                              </div>
                             
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="generateStudentHostelIDCard"  class="btn btn-success btn-custom waves-effect waves-light">Generate Id Card</button>
                                    <button style="float:right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this);">Cancel</button>
                                    </div>
                              </div>
                           </form>
                        </div>
                        </div>
                        </div>
                      </div>
                  </div>
                  <!--  <div id="moduleattendancedetails" style="display:none;">
                    
                              
                              </div> -->
   </div>
   
        <div id="showhostelidviewDiv" style="display:none;">
                                <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-warning">
                              <div class="panel-heading">
                                 <h2 class="panel-title">View Student Hostel ID Card</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="viewStudentHostelIDCardForm">
                          
                                   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Criteria<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="hostelidviewcriteriaId" id="hostelidviewcriteriaId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Criteria</option>
                                         <option value="academicyear">Academic Year</option>
                                          <option value="feescategory">Fees Category</option>
                                     </select>
                                 </div>
                              </div>
                           
                            <div class="form-group form-group-academic-year" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Academic Year<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="hostelIDCardViewAcademicYearId" id="hostelIDCardViewAcademicYearId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Academic Year</option>
                                        <c:if test="${!empty academicYears}">
                                         <c:forEach items="${academicYears}" var="academicYear">
                                      			 <option value="${academicYear.getAcademicYearId()}">${academicYear.getAcademicYearTitle()}</option>
                                           </c:forEach>
                                      	</c:if>
                                     </select>
                                 </div>
                              </div>
                          
                           <div class="form-group form-group-fees-category" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Fees Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="hostelIDCardViewFeesTermId" id="hostelIDCardViewFeesTermId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Fees Category</option>
                                        <c:if test="${!empty feesTerms}">
                                         <c:forEach items="${feesTerms}" var="feesTerm">
                                      			 <option value="${feesTerm.getFeesTermId()}">${feesTerm.getFeesTermName()}</option>
                                           </c:forEach>
                                      	</c:if>
                                     </select>
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="hostelIDCardViewClassId" id="hostelIDCardViewClassId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Class</option>
                                                <!--  <option value="all">All</option> -->
                                                <c:if test="${!empty classes}">
		                                       			<c:forEach items="${classes}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}(${clazz.getInstitution().getInstitutionCode()})</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                    </select>                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Section <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                          <select name="hostelIDCardViewSectionId" id="hostelIDCardViewSectionId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                          </select>                                 </div>
                              </div>
                             
                                     
                            
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="viewStudentHostelIDCard"  class="btn btn-success btn-custom waves-effect waves-light">Get Student ID Cards</button>
                                    <button style="float:right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this);">Cancel</button>
                                    </div>
                              </div>
                           </form>
                        </div>
                        </div>
                        </div>
                      </div>
                  </div>
                  
                      <div id="viewstudenthostelidcarddetails" style="display:none;">
                               <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box table-responsive">
                             <h4 class="m-t-0 header-title" style="color:purple;">Student Hostel ID Card Details</h4>
                      <br>
                       <div class="row">
                                 <div class="col-sm-offset-3">
                                   <a style="float:right" href="" id="hostelidcardpreview" class="btn btn-info btn-custom waves-effect waves-light" type="button" data-href="#"  target="_blank" data-toggle="modal">
                                            Preview       </a>
                                <!--     <button style="float:right" id="preview" type="button" class="btn btn-info btn-custom waves-effect waves-light">Preview</button> -->
                                    <button style="float:right" id="hostelidcardprint" type="button" class="btn btn-primary btn-custom waves-effect waves-light" >Print</button>
                                    </div>
                              </div>
                               <br>
                                <br>
                                <div id="studentHostelIDCardViewDiv">
                               </div>
                               
                               
                               
                            
                              </div>
                              </div>
                              </div>
                              
                              </div>
                                <a style="display:none;" type="button" class="btn btn-primary" id="printpreview" target="_blank" href="">Print</a>
                               <div class="modal fade" id="recprint" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>You want to print this id card</h5>
                     </div>
                     <div class="modal-footer">
                     <a type="button" class="btn btn-primary" id="printrec" href="">Print</a>
                        
                     </div>
                 </div>
               </div>
            </div>
                 
   </div>
   
      <div id="showhosteliddeleteDiv" style="display:none;">
                                <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-primary">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Delete Student Hostel ID Card</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="deletehostelidcardform" action="${pageContext.request.contextPath}/student/studenthostelidcardgeneration/delete" method="post">
                           
                                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Criteria<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="hosteliddeletecriteriaId" id="hosteliddeletecriteriaId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Criteria</option>
                                         <option value="academicyear">Academic Year</option>
                                          <option value="feescategory">Fees Category</option>
                                     </select>
                                 </div>
                              </div>
                           
                            <div class="form-group form-group-academic-year" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Academic Year<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="hostelIDCardDeleteAcademicYearId" id="hostelIDCardDeleteAcademicYearId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Academic Year</option>
                                        <c:if test="${!empty academicYears}">
                                         <c:forEach items="${academicYears}" var="academicYear">
                                      			 <option value="${academicYear.getAcademicYearId()}">${academicYear.getAcademicYearTitle()}</option>
                                           </c:forEach>
                                      	</c:if>
                                     </select>
                                 </div>
                              </div>
                          
                           <div class="form-group form-group-fees-category" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Fees Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="hostelIDCardDeleteFeesCategoryId" id="hostelIDCardDeleteFeesCategoryId"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Fees Category</option>
                                        <c:if test="${!empty feesTerms}">
                                         <c:forEach items="${feesTerms}" var="feesTerm">
                                      			 <option value="${feesTerm.getFeesTermId()}">${feesTerm.getFeesTermName()}</option>
                                           </c:forEach>
                                      	</c:if>
                                     </select>
                                 </div>
                              </div>
                             <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <select name="hostelIDCardDeleteClassId" id="hostelIDCardDeleteClassId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Class</option>
                                                <!--  <option value="all">All</option> -->
                                                <c:if test="${!empty classes}">
		                                       			<c:forEach items="${classes}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}(${clazz.getInstitution().getInstitutionCode()})</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                    </select>                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Section <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                          <select name="hostelIDCardDeleteSectionId" id="hostelIDCardDeleteSectionId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                          </select>                                 </div>
                              </div>
                             
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="deleteHostelIDCardDetails"  class="btn btn-success btn-custom waves-effect waves-light">Delete Id Card(s)</button>
                                    <button style="float:right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this);">Cancel</button>
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
         
         <script src="${pageContext.request.contextPath}/resources/themes/script/studentidcardgeneration.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script>


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

	