<!DOCTYPE HTML>
<html>
   <head>
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
		  <style>
         .thumbnail {
         height: 200px;
         overflow: hidden;
         }
         .thumbnail {
         display: block;
         padding: 4px;
         margin-bottom: 20px;
         line-height: 1.42857143;
         background-color: #fff;
         border: 1px solid #00BCD4;
         border-radius: 4px;
         -webkit-transition: border .2s ease-in-out;
         -o-transition: border .2s ease-in-out;
         transition: border .2s ease-in-out;
         }
      </style>
      <!--//Metis Menu -->
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
                
                <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                              <h2 class="m-t-0 header-title" style="color:purple;">University Profile</h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						
						<div class="panel-body">
						  <div class="form-group">
             <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
             
                        <img  id="img-rounded"class="img-responsive" src="${pageContext.request.contextPath}/resources/themes/images/mua.jpg" alt="">                                                                         
                </div>
                               <div class="custom welcome">
	<p style="text-align: justify;"><span style="font-size: 16pt; color: #f5911f; font-family: impact; letter-spacing: 2px;">Welcome to Management University of Africa (MUA)</span></p>
                        </div>
                   
                       
                           <p style="text-align: justify;">The Management University of Africa (MUA) is a premier private university that aims at providing innovation, leadership and management solutions to industries and communities in Africa and beyond. The distinct focus of the Management University of Africa is to be the centre of excellence in capacity building in management, leadership, governance and entrepreneurship.</p>                          
                           <p style="text-align: justify;">At MUA we believe that it is only people who have mastered themselves and discovered their potential, who are best equipped to contribute responsibly and effectively towards the sustainable development of this country. To this end, we have made every effort to create an environment for our students to discover their inherent talents and to equip them with the necessary skills and capacity to employ the same effectively.</p>
                           <p style="text-align: justify;">MUA is Located on Popo Road, South C Nairobi, Nairobi Kenya. The University also owns 80 acres of land in Kisaju, Kitengela for future development.</p>
                           <p style="text-align: justify;"><strong><span style="color: #ff0000;">Our Vision</span><br></strong><span>MUA's Vision is to be a premier university providing management and transformative leadership solutions worldwide&nbsp;</span><span style="font-size: 12pt; font-family: 'Times New Roman', serif;"><br></span></p>
                           <p style="text-align: justify;"><strong><span style="color: #ff0000;">Our Mission</span><br></strong>MUA's mission is to pursue excellence in provision of quality education through innovative teaching and distinguished research to mould leaders, change agents and entreprenuers with a global impact.&nbsp;<span style="font-size: 16pt; line-height: 115%; font-family: 'Book Antiqua', serif;"><br></span></p>
                     <div class="col-sm-offset-3">
                      <a  style="float:right" type="button" class="btn btn-primary btn-custom waves-effect waves-light " target="_blank" href="http://www.mua.ac.ke/">Read More</a>
                   </div>
            </div>
							
						</div>
					</div>
                                 </div>
                                 </div>
                                 </div>
                                 </div>
                                 </div>
          
        
           <br />
           <br />
           <br />
              <!--  <div class="forms">
                  <div class="row">
                  
                     <div class="form-three widget-shadow"  style="height:500px;">
                       <div class="custom welcome">
	<p style="text-align: justify;"><span style="font-size: 16pt; color: #f5911f; font-family: impact; letter-spacing: 2px;">Welcome to Management University of Africa (MUA)</span></p>
                        </div>
                   
                       
                           <p style="text-align: justify;">The Management University of Africa (MUA) is a premier private university that aims at providing innovation, leadership and management solutions to industries and communities in Africa and beyond. The distinct focus of the Management University of Africa is to be the centre of excellence in capacity building in management, leadership, governance and entrepreneurship.</p>                          
                           <p style="text-align: justify;">At MUA we believe that it is only people who have mastered themselves and discovered their potential, who are best equipped to contribute responsibly and effectively towards the sustainable development of this country. To this end, we have made every effort to create an environment for our students to discover their inherent talents and to equip them with the necessary skills and capacity to employ the same effectively.</p>
                           <p style="text-align: justify;">MUA is Located on Popo Road, South C Nairobi, Nairobi Kenya. The University also owns 80 acres of land in Kisaju, Kitengela for future development.</p>
                           <p style="text-align: justify;"><strong><span style="color: #ff0000;">Our Vision</span><br></strong><span>MUA's Vision is to be a premier university providing management and transformative leadership solutions worldwide&nbsp;</span><span style="font-size: 12pt; font-family: 'Times New Roman', serif;"><br></span></p>
                           <p style="text-align: justify;"><strong><span style="color: #ff0000;">Our Mission</span><br></strong>MUA's mission is to pursue excellence in provision of quality education through innovative teaching and distinguished research to mould leaders, change agents and entreprenuers with a global impact.&nbsp;<span style="font-size: 16pt; line-height: 115%; font-family: 'Book Antiqua', serif;"><br></span></p>
                     <div class="col-sm-offset-3">
                      <a  style="float:right" type="button" class="btn btn-info" href="http://www.mua.ac.ke/">Read More</a>
                                     
                     </div>
              </div>   
              
            </div>
         </div> -->
      </div>
      </div>
      </div>
      </div>
      <!-- Classie -->
    <%--   <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
      <script>
      $(document).ready(
    		  
    		  /* This is the function that will get executed after the DOM is fully loaded */
    		  function () {
    		    $( "#datepicker" ).datepicker({
    		      changeMonth: true,//this option for allowing user to select month
    		      changeYear: true //this option for allowing user to select from year range
    		    });
    		  }

    		);
      
      
         var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
         	showLeftPush = document.getElementById( 'showLeftPush' ),
         	body = document.body;
         	
         showLeftPush.onclick = function() {
         	classie.toggle( this, 'active' );
         	classie.toggle( body, 'cbp-spmenu-push-toright' );
         	classie.toggle( menuLeft, 'cbp-spmenu-open' );
         	disableOther( 'showLeftPush' );
         };
         
         function disableOther( button ) {
         	if( button !== 'showLeftPush' ) {
         		classie.toggle( showLeftPush, 'disabled' );
         	}
         }
      </script> --%>
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
       
   </body>
</html>