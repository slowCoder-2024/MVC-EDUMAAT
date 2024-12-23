<!DOCTYPE HTML>
<html>
<head>
<title>EMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- Bootstrap Core CSS -->
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/bootstrap.css" rel='stylesheet' type='text/css' />
      <!-- Custom CSS -->
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/style.css" rel='stylesheet' type='text/css' />
      <!-- font CSS -->
      <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
      <!-- font-awesome icons -->
      <link href="http://fontawesome.io/assets/font-awesome/css/font-awesome.css" rel="stylesheet"> 
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/jqvmap.css" rel='stylesheet' type='text/css' />
      <!-- //font-awesome icons -->
      <!-- js-->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
      <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/modernizr.custom.js"></script>
      <!--webfonts-->
      <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
      <!--//webfonts--> 
      <!--animate-->
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/animate.css" rel="stylesheet" type="text/css" media="all">
    
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/css/select2.min.css" type="text/css" />
      
      
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
      
      <!--//end-animate-->
      <!-- Metis Menu -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
      <!-- chart -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
        <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script> 
         <script src="${pageContext.request.contextPath}/resources/themes/js/image.js"></script>
          <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
</head> 
                <%@ include file="master_menu.jsp" %>
                <%@ include file="master_header.jsp" %>
<body class="cbp-spmenu-push">
	<div class="main-content">
		 
		<!-- main content start-->
		<div id="page-wrapper">
		<div class="main-page">
            <div id="ListDiv" style="display:block;">
               <h1 style="color: red;font-weight: bold;" class="title1">${denied}</h1>
                <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div>
                <h4 class="title1">${message}</h4>
            </div>
         </div>
		</div>
		
	</div>
		
	<!-- Bootstrap Core JavaScript -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script> 
     
          <script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script>  
<!-- Classie -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
      <!--scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>
    
      <!--//scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/site.js" type="text/javascript"></script>
</body>
</html>