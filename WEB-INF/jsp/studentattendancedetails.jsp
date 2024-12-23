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
        <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/hopscotch/css/hopscotch.min.css" rel="stylesheet" type="text/css" />
	
         <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-circliful/css/jquery.circliful.css" rel="stylesheet" type="text/css" />
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/assets/plugins/morris/morris.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/assets/plugins/chartist/css/chartist.min.css">
       <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/c3/c3.min.css" rel="stylesheet" type="text/css"  />
	
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
  <script src="${pageContext.request.contextPath}/resources/themes/script/studentattendancedetails.js"></script>
      
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

   /*  .ui-datepicker-calendar {
            display: none;
        }   */
    .absent{
   color: red;  
}
 .present{
   color: green;  
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
                                    <i class="typcn typcn typcn-social-dribbble-circular  text-primary"></i>
                                    <h4 class="m-0 text-dark counter font-600">  View Attendance Details</h4>
                                    <div class="text-muted m-t-5">Module Wise</div>
                                </div>
                            </div>
                            
                            <div class="col-lg-4 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="showmonthwiseattendance();">
                                    <i class="typcn typcn typcn-puzzle-outline text-pink"></i>
                                    <h4 class="m-0 text-dark counter font-600">View Attendance Details</h4>
                                    <div class="text-muted m-t-5">Date Wise</div>
                                </div>
                            </div>
                            
                              <div class="col-lg-4 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="showoverallmodulewiseattendancepercentage();">
                                    <i class="typcn  typcn typcn-chart-pie   text-info"></i>
                                    <h4 class="m-0 text-dark counter font-600">OverAll Attendance Percentage</h4>
                                    <div class="text-muted m-t-5">Module Wise</div>
                                </div>
                            </div>
                            
                            <div class="col-lg-4 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="showoveralldatewiseattendancepercentage();">
                                    <i class="typcn  typcn typcn-spanner-outline  text-warning"></i>
                                    <h4 class="m-0 text-dark counter font-600">OverAll Attendance Percentage</h4>
                                    <div class="text-muted m-t-5">Date Wise</div>
                                </div>
                            </div>
                  </div>
       <div id="OpenFormDiv" style="display:none;">
			        <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">View Module Wise Attendance Details</h2>
                              </div>
                              <div class="panel-body">
                      <form class="form-horizontal" id="attendance">
                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Report Type<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="reportType" id="reportType" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                      <option value="" disabled selected>Select Report Type</option>
                                   		<option value="dateRange">Date</option>
                                   		<option value="monthly">Month</option>
		                                    </select>
                                 </div>
                                </div>
                                 <div id="dateRange" style="display: none">
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">From Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" required="required" class="form-control form-control-datepicker" id="fromDate" name="fromDate" placeholder="" maxlength="10">
                                 </div>
                                 </div>
                                  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">To Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" required="required" class="form-control form-control-datepicker" id="toDate" name="toDate" placeholder="" maxlength="10">
                                 </div>
                                 </div>
                              </div>
                              <div id="monthly" style="display:none;">
                         <div class="form-group">
                            <label for="" class="col-sm-3 control-label">Select Month<span class="at-required-highlight">*</span></label> 
                            <div class="col-sm-7"> 
                               <input type="text" class="form-control " name="monthDate" required="required" id="monthDate" placeholder="Month">
                            </div>
                         </div>
                       </div>
                         <div class="row">
                            <div class="col-sm-offset-3">
                             
                               <button style="float:right" type="button" id="getDetails"   class="btn btn-success btn-custom waves-effect waves-light">Get Details</button>
                                <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                            </div>
                         </div>
                      
                  
                     
                      </form>
                      </div>
                      </div>
                      </div>
                      
                        <div class="tables" id="attendancedetails" style="display:none;">
                             
                             
                            <div class="col-lg-12">
                           <div class="panel panel-border panel-info">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Attendance Details</h2>
                              </div>
                              <div class="panel-body">
                                  <table class="table table-bordered" id="attendancedetailslist">
                                     <thead >
                                        <tr>
                                           <th>Date</th>
                                           <th>Module Name</th>
                                            <th>Hour Time</th>
                                            <th>Attendance Status</th>
                                        </tr>
                                     </thead>
                                     <tbody>
                                       
                                     </tbody>
                                  </table>
                               </div>
                               </div>
                               </div>
                              
                              </div>
                      
                      </div>
             </div>
          
             
               <div id="OpenMonthDiv" style="display:none;">
			  <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">View Date Wise Attendance Details</h2>
                              </div>
                              <div class="panel-body">
                      <form class="form-horizontal" id="monthattendance">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Report Type<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="studentReportType" id="studentReportType" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                      <option value="" disabled selected>Select Report Type</option>
                                   		<option value="dateRange">Date</option>
                                   		<option value="monthly">Month</option>
		                                    </select>
                                 </div>
                                </div>
                                 <div id="studentDateRange" style="display: none">
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">From Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" required="required" class="form-control form-control-datepicker" id="studentFromDate" name="studentFromDate" placeholder="" maxlength="10">
                                 </div>
                                 </div>
                                  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">To Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" required="required" class="form-control form-control-datepicker" id="studentToDate" name="studentToDate" placeholder="" maxlength="10">
                                 </div>
                                 </div>
                              </div>
                              <div id="studentMonthly" style="display:none;">
                         <div class="form-group">
                            <label for="" class="col-sm-3 control-label">Select Month<span class="at-required-highlight">*</span></label> 
                            <div class="col-sm-7"> 
                               <input type="text" class="form-control " name="studentMonthDate" required="required" id="studentMonthDate" placeholder="Month">
                            </div>
                         </div>
                       </div>
                         <div class="row">
                            <div class="col-sm-offset-3">
                            <button style="float:right" type="button" id="getMonthDetails"   class="btn btn-success btn-custom waves-effect waves-light">Get Details</button>
                              <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                               
                            </div>
                         </div>
                      
                       </form>
                      </div>
                      </div>
                      </div>
                        <div class="tables" id="monthattendancedetails" style="display:none;">
                           
                            <div class="col-lg-12">
                           <div class="panel panel-border panel-info">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Attendance Details</h2>
                              </div>
                              <div class="panel-body">
                                  <table class="table table-bordered" id="monthattendancedetailslist">
                                     <thead >
                                        <tr>
                                           <th>Date</th>
                                           <th>Attendance Status</th>
                                        </tr>
                                     </thead>
                                     <tbody>
                                       
                                     </tbody>
                                  </table>
                                  </div>
                                  </div>
                                  </div>
                                 
                               </div>
                     
             </div>
             </div>
             
             
             
                    <div id="overAllDateWiseAttendnacePercentage" style="display:none;">
			        <div class="row"  >
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">View Date Wise Attendance Percentage Details</h2>
                              </div>
                              <div class="panel-body">
                      <form class="form-horizontal" id="overalldatewiseattendancepercentageform">
                        
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
                              
                         <div class="row">
                            <div class="col-sm-offset-3">
                               <button style="float:right" type="button" id="getOverAllDateWiseAttendancePercentageDetails"   class="btn btn-success btn-custom waves-effect waves-light">Get Details</button>
                                <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this)">Cancel</button>
                            </div>
                         </div>
                      
                  
                     
                      </form>
                      </div>
                      </div>
                      </div>
                       
                        
                          <div class="tables" id="overalldatewiseattendancepercentagedetails" style="display:none;">
                            <div class="col-lg-12">
                           <div class="panel panel-border panel-info">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Attendance Details</h2>
                              </div>
                              <div class="panel-body">
                               <div class="row">
								  <div class="col-md-12">
                                   <div class="row text-center">
                                       <div class="col-sm-6 col-lg-5">
                                       </div>
                                         <div class="col-sm-6 col-lg-5">
                                            <div id="chartpercentage" class="circliful-chart2 m-b-30 " data-dimension="200" data-text="0%" data-info="No Data Found" data-width="30" data-fontsize="24" data-percent="0" data-fgcolor="#5fbeaa" data-bgcolor="#ebeff2" ></div>
                                        </div>
                                         
                                        <div class="col-sm-6 col-lg-5">
                                       </div>
                                         </div>
                                        </div>
                                        </div>
                                      
                                  <table class="table table-bordered" id="overalldatewiseattendancepercentagedetailslist">
                                     <thead >
                                        <tr>
                                          <th>Class/Section</th>
                                   <th>Academic Year</th>
                                   <th>Total Present</th>
                                   	<th>Total Absent</th>
                                   	<th>Total OnDuty</th>
                                  	<th>Total Working Days</th>
                                  	<th>Over All Percentage</th>
                                        </tr>
                                     </thead>
                                     <tbody>
                                       
                                     </tbody>
                                  </table>
                                 
                                   
                               </div>
                               </div>
                               </div>
                              
                              </div>
                               </div>
             </div>
             
             
             
                    <div id="overAllModuleWiseAttendnacePercentage" style="display:none;">
			        <div class="row"  >
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">View Module Wise Attendance Percentage Details</h2>
                              </div>
                              <div class="panel-body">
                      <form class="form-horizontal" id="overallmodulewiseattendancepercentageform">
                        
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
                              
                         <div class="row">
                            <div class="col-sm-offset-3">
                               <button style="float:right" type="button" id="getOverAllModuleWiseAttendancePercentageDetails"   class="btn btn-success btn-custom waves-effect waves-light">Get Details</button>
                                <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this)">Cancel</button>
                            </div>
                         </div>
                      
                  
                     
                      </form>
                      </div>
                      </div>
                      </div>
                       
                        
                          <div class="tables" id="overallmodulewiseattendancepercentagedetails" style="display:none;">
                            <div class="col-lg-12">
                           <div class="panel panel-border panel-info">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Attendance Details</h2>
                              </div>
                              <div class="panel-body">
                              
                               <div class="row">
								  <div class="col-md-12">
                                   <div class="row text-center">
                                      
                                       <div class="easypie">
                                     
                                       </div>
                                          </div>
                                        </div>
                                        </div>
                                        
                                  <table class="table table-bordered" id="overallmodulewiseattendancepercentagedetailslist">
                                     <thead >
                                        <tr>
                                          <th>Module Code</th>
                                   <th>Module Name</th>
                                   <th>Total Present</th>
                                   	<th>Total Absent</th>
                                   	<th>Total OnDuty</th>
                                  	<th>Total Working Hours</th>
                                  	<th>Over All Percentage</th>
                                        </tr>
                                     </thead>
                                     <tbody>
                                       
                                     </tbody>
                                  </table>
                               </div>
                               </div>
                               </div>
                              
                              </div>
                               </div>
             </div>
             
             
             </div>
             
             </div></div>
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
               <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-validation/js/jquery.validate.min.js"></script>
         
   

 <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script>

     <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery.easy-pie-chart/dist/easypiechart.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery.easy-pie-chart/dist/jquery.easypiechart.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/pages/easy-pie-chart.init.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-knob/jquery.knob.js"></script>


        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-circliful/js/jquery.circliful.min.js"></script>
        <script>
			$(function() {
				$(".knob").knob();
				 $('.circliful-chart').circliful();
			});
		</script>



</body>
</html>