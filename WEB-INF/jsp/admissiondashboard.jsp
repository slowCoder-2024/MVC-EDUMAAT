<!DOCTYPE HTML>
<html>
<head>
<title>EMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="${pageContext.request.contextPath}/resources/${theme}/css/font-awesome.css" rel="stylesheet"> 
<link href="${pageContext.request.contextPath}/resources/${theme}/css/jqvmap.css" rel='stylesheet' type='text/css' />
<!-- //font-awesome icons -->
 <!-- js-->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/modernizr.custom.js"></script>
<!--webfonts-->
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
<!--//webfonts--> 
<!--animate-->
<link href="${pageContext.request.contextPath}/resources/${theme}/css/animate.css" rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/${theme}/css/clndr.css" type="text/css" />
<script src="${pageContext.request.contextPath}/resources/${theme}/js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->

<!-- Metis Menu -->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
<link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
<!-- chart -->
<script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
<script src="${pageContext.request.contextPath}/resources/themes/script/dashboard.js"></script>

      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/assets/plugins/morris/morris.css">
	 <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/c3/c3.min.css" rel="stylesheet" type="text/css"  />
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
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/jquery.form-advanced.init.js"></script>
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.11.2.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.7.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
<!-- //chart -->
<style>

.chart-legend li span{
    display: inline-block;
    width: 12px;
    height: 12px;
    margin-right: 5px;
}

</style>
<!--//Metis Menu -->
</head> 
               
<body class="fixed-left">
	<div class="wrapper">
		  <%@ include file="master_menu.jsp" %>
                <%@ include file="master_header.jsp" %>
		<!-- main content start-->
		<div class="content-page">
				<!-- Start content -->
				<div class="content">
					<div class="container">
					
						 <div class="row">
                            <div class="col-sm-12">
                                <!-- <div class="btn-group pull-right m-t-15">
                                    <button type="button" class="btn btn-default dropdown-toggle waves-effect" data-toggle="dropdown" aria-expanded="false">Settings <span class="m-l-5"><i class="fa fa-cog"></i></span></button>
                                    <ul class="dropdown-menu drop-menu-right" role="menu">
                                        <li><a href="#">Action</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a></li>
                                    </ul>
                                </div> -->

                                <h4 class="page-title">Admissions Dashboard</h4>
                                <br><br>
                            </div>
                        </div>
					
			<div class="row">
				
				<div class="charts">
				<div class="col-lg-6">
					<div class="card-box">
				<!-- 	<div class="col-md-6 charts chrt-page-grids"> -->
					<h4 class="m-t-0 m-b-30 header-title"><b> Admission Seat's Availability</b></h4>
						<div class="radar-grid">
							<canvas id="radar" ></canvas>
							
						</div>
						<div id="r-legend" class="chart-legend"></div>	
					<!-- </div> -->
					</div>
					</div>
					<div class="col-lg-6">
					<div class="card-box">
					<!-- <div class="col-md-6 charts chrt-page-grids chrt-right "> -->
						<h4 class="m-t-0 m-b-30 header-title"><b>Applicant Category Distribution</b></h4>
						<div class="pie-grid">
							<canvas id="pie"></canvas>
						<div id="p-legend" class="chart-legend"></div>
						</div>
					<!-- </div> -->
					</div>
					</div>
					</div>
					
					<script>
					var radarChartData = {
							labels : ["Computer Science","Mechanical","Civil","Leadership Management","Commerce","Development Studies","Physics"],
							datasets : [
										{
											fillColor : "rgba(239, 85, 58, 0.87)",
											strokeColor : "#e94e02",
											pointColor : "#e94e02",
											pointStrokeColor : "#fff",
											data : [65,59,90,81,56,55,40],
											label:"Available Seats"
										},
										{
											fillColor : "rgba(79, 82, 186, 0.87)",
											strokeColor : "#4F52BA",
											pointColor : "#4F52BA",
											pointStrokeColor : "#fff",
											data : [28,48,40,19,96,27,100],
											label:"Applications"
										}
									]
							
						};
					var barChartData = {
							labels : ["Computer Science","Mechanical","Civil","Leadership Management","Commerce","Development Studies","Physics"],
							datasets : [
								{
									fillColor : "rgb(51, 204, 51)",
									strokeColor : "#33cc33",
									highlightFill: "#33cc33",
									data : [65,59,90,81,56,55,40],
									label:"Registered"
								},
								{
									fillColor : "rgb(255, 51, 0)",
									strokeColor : "#ff3300",
									highlightFill: "#ff3300",
									data : [50,65,60,50,70,70,80],
									label:"Selected"
								},
								{
									fillColor : "rgb(255, 255, 0)",
									strokeColor : "#ffff00",
									highlightFill: "#ffff00",
									data : [28,48,40,19,96,27,100],
									label:"Waiting List"
								},
								{
									fillColor : "rgba(88, 88, 88, 0.83)",
									strokeColor : "#585858",
									highlightFill: "#585858",
									data : [98,88,40,58,46,27,10],
									label:"Rejected"
								}
							]
							
						};
			
					var pieData = [
									{
										value: 30,
										color:"#4F52BA",
										label:"Scheduled Caste"
									},
									{
										value : 50,
										color : "#585858",
										label:"Scheduled Tribe"
									},
									{
										value : 100,
										color : "#e94e02",
										label:"Disadvantaged"
									},
									{
										value : 100,
										color : "#66ccff",
										label:"Normal"
									}
								
								];
					var r=new Chart(document.getElementById("radar").getContext("2d")).Radar(radarChartData);
					var p=new Chart(document.getElementById("pie").getContext("2d")).Pie(pieData);
					document.getElementById('r-legend').innerHTML = r.generateLegend();
					document.getElementById('p-legend').innerHTML = p.generateLegend();
					</script>
					
					
			</div>	
					
					
				<!-- 	
						<div class="row">
				<div class="col-sm-6">
								<div class="portlet">
									/primary heading
									<div class="portlet-heading">
										<h4 class="m-t-0 m-b-30 header-title"><b>Admission Seat's Availability</b></h4>
											<div class="clearfix"></div>
									</div>
									<div id="bg-default2" class="panel-collapse collapse in">
										<div class="portlet-body">
											<div class="text-center">
												<ul class="list-inline chart-detail-list">
													<li>
														<h5><i class="fa fa-circle m-r-5" style="color: #7e57c2;"></i>Available Seats</h5>
													</li>
													<li>
														<h5><i class="fa fa-circle m-r-5" style="color: #ebeff2;"></i>Applications</h5>
													</li>
												</ul>
											</div>
											<div id="morris-bar-stacked" style="height: 300px;"></div>
												
										</div>
									</div>
								</div>
							</div>
						
								
						
						</div> -->
				
					
				
					
					
					
					
					
			
					
					
			</div>
						</div>	
				</div>
					<div class="clearfix"> </div>
							
							
			</div>	
					<c:if test="${!empty institution}">     
                     <input id="institutionId" name="institutionId" type="hidden" value="${institution.getInstitutionId()}">
                   </c:if>
				
        <script>
            var resizefunc = [];
        </script>	
			
		
	
	
	
<script src="${pageContext.request.contextPath}/resources/themes/script/dashboard.js"></script>
 <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/js/detect.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/js/fastclick.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.slimscroll.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.blockUI.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/js/waves.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/js/wow.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.nicescroll.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.scrollTo.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-tagsinput/js/bootstrap-tagsinput.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/switchery/js/switchery.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/multiselect/js/jquery.multi-select.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-quicksearch/jquery.quicksearch.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/select2/js/select2.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-select/js/bootstrap-select.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-filestyle/js/bootstrap-filestyle.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-touchspin/js/jquery.bootstrap-touchspin.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-maxlength/bootstrap-maxlength.min.js" type="text/javascript"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.mockjax.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.autocomplete.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/countries.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/autocomplete.js"></script>
  
        <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.core.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.app.js"></script>
         <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/d3/d3.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/c3/c3.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/pages/jquery.c3-chart.init.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/morris/morris.min.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/raphael/raphael-min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/script/admissiondashboardmorris.js"></script>
	</body>
</html>