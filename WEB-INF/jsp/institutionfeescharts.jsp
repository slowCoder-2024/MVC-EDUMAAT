<!DOCTYPE html>
<html>
<head>
		      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta name="description" content="A fully featured education management system">
      <meta name="author" content="edumaat">
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <link rel="edumaat icon" href="${pageContext.request.contextPath}/resources/themes/assets/images/favicon.ico">
      <title>EMS</title>
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
           
		
		  <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/hopscotch/css/hopscotch.min.css" rel="stylesheet" type="text/css" />
		 <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-circliful/css/jquery.circliful.css" rel="stylesheet" type="text/css" />
	  
	  
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
	        	

 
				<!-- Begin page -->
		<div id="wrapper">
                <%@ include file="master_header.jsp" %>
                <%@ include file="master_menu.jsp" %>
    

			<div class="content-page">
				
				
				<!-- Start content -->
				<div class="content">
		 
		 
		           			<div class="container">
				

        
	<%-- <security:authorize access="hasRole('feesManagement')">            --%>     
 		<div class="row">
				<div class="col-sm-6">
								<div class="portlet">
									<!-- /primary heading -->
									<div class="portlet-heading">
										<h4 class="m-t-0 m-b-30 header-title"><b>(Active Academic Year)Class Wise Students Paid And Pending </b></h4>
											<div class="clearfix"></div>
									</div>
									<div id="bg-default2" class="panel-collapse collapse in">
										<div class="portlet-body">
											<div class="text-center">
												<ul class="list-inline chart-detail-list">
													<li>
														<h5><i class="fa fa-circle m-r-5" style="color: #7e57c2;"></i>Paid</h5>
													</li>
													<li>
														<h5><i class="fa fa-circle m-r-5" style="color: #ebeff2;"></i>Pending</h5>
													</li>
												</ul>
											</div>
											<div id="morris-bar-stacked" style="height: 300px;"></div>
												
										</div>
									</div>
								</div>
								<!-- /Portlet -->
							</div>
						<div class="col-lg-6">
							<div class="card-box" style="height: 445px">
									<h4 class="m-t-0 m-b-35 header-title"><b>AcademicYear Wise Fees Paid And Pending Student Count</b>    </h4>
								
									<div class="form-horizontal" id="academicYearDiv" style="display:block;">
									       <div class="form-group">
                                          <div class="col-sm-6">
                                          <select name="academicYearWiseFeesPaidAndPending" id="academicYearWiseFeesPaidAndPending" class="selectpicker"  data-live-search="true" required="required" data-style="btn-warning btn-custom">
                                       <c:if test="${!empty academicYearList}">
                                    		<c:forEach items="${academicYearList}" var="academicYear">
                                    			<option  value="${academicYear.getAcademicYearId()}">${academicYear.getAcademicYearTitle()}</option>
                                    		</c:forEach>
                                    		</c:if>
                                    </select>
                                    </div>
                                    <div class="col-sm-6">
                                             <select id="chart-type-academicYear" class="selectpicker" data-style="btn-primary btn-custom">
														<option value="bar">Bar</option>
													<option value="donut">Donut</option>
													<option value="pie">Pie</option>
												
												</select>                           
                                        </div>
                                       </div>
                                       </div>
							<div class="doughnut-grid" id="academicYearChart" style="display:block;">
									<div id="donut-chart-academicYear"></div>
								</div>
								           <div id="academicYearImage" style="width:400px; height: 400px;display:none;">
						<br><br><br>
					<br><br><br><br>
						<div class="col-sm-12 col-md-12 col-xs-8">
						<div class="alert alert-info" style="margin-left: 200px">
						 <p style="text-align: center;">No Data Available</p>
                  							</div>
						</div>
							</div>
								</div>
							</div>
								
						
						</div>
					<%-- 	</security:authorize> --%>
					<%-- 	<security:authorize access="hasRole('dashboard/admin')">     
				<div class="row">
						
						
							
					<div class="col-sm-6">
								<div class="portlet">
									<!-- /primary heading -->
									<div class="portlet-heading">
									<h4 class="m-t-0 m-b-30 header-title"><b>Today's Class Wise Attendance Status</b></h4>
										
										<div class="clearfix"></div>
									</div>
									<div id="bg-default1" class="panel-collapse collapse in">
										<div class="portlet-body">
											<div class="text-center">
												<ul class="list-inline chart-detail-list">
													<li>
														<h5><i class="fa fa-circle m-r-5" style="color: #7e57c2;"></i>Present</h5>
													</li>
													<li>
														<h5><i class="fa fa-circle m-r-5" style="color: #34d3eb;"></i>OnDuty</h5>
													</li>
													<li>
														<h5><i class="fa fa-circle m-r-5" style="color: #ebeff2;"></i>Absent</h5>
													</li>
												</ul>
											</div>
											<div id="morris-bar-example" style="height: 300px;"></div>
										</div>
									</div>
								</div>
								<!-- /Portlet -->
							</div>
					 
    
						</div>
						  </security:authorize> --%>

					  </div> <!-- container -->
                               
                </div> <!-- content -->

             

         	<c:if test="${!empty institution}">     
                     <input id="institutionId" name="institutionId" type="hidden" value="${institution.getInstitutionId()}">
                   </c:if>
</div>
            

        </div>
        <!-- END wrapper -->

        <script>
            var resizefunc = [];
        </script>

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
      
               <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-validation/js/jquery.validate.min.js"></script>
        
  
      	   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/script/institutionfeescharts.js"></script>
          <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/d3/d3.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/c3/c3.min.js"></script> 
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/morris/morris.min.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/raphael/raphael-min.js"></script>
	  <%--   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/morris.init.js"></script> --%>
	    
         <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/script/institutionfeeschartsmorris.js"></script>
    <!--     <script src="assets/pages/jquery.flot.init.js"></script> -->
  
      </body>
</html>