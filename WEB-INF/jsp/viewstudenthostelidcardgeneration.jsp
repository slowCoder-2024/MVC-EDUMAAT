<!DOCTYPE HTML>
<html>
   <head>
          <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta name="description" content="A fully featured education management system">
      <meta name="author" content="edumaat">
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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

      
   </head>

<body class="fixed-left">
	    	<div id="wrapper">
  <div class="content-page">
				<!-- Start content -->
				<div class="content">
<div class="container">

    <c:if test="${!empty studentHostelIDCardGenerationLists}">
	       <c:forEach items="${studentHostelIDCardGenerationLists}" var="studentHostelIDCardGenerationList">
	<div class="row"  >
	<div style="height:450px;border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black; " class="col-lg-5 col-sm-6">
	<br/>
	<table class="table table-responsive" >
	<thead >
	<tr >
	<td style="text-align:left;">
	<img width="120px" height="100px" src="${pageContext.request.contextPath}${studentHostelIDCardGenerationList.getInstitution().getInstitutionLogo()}"></img>
	</td>
	<td style="margin-left:-150px;">
	<h4 >
	<label >${fn:toUpperCase(studentHostelIDCardGenerationList.getInstitution().getInstitutionName())}</label>
	</h4>
	<h5 ><label >${studentHostelIDCardGenerationList.getInstitution().getInstitutionAddressline1()},${studentHostelIDCardGenerationList.getInstitution().getInstitutionAddressline2()},${studentHostelIDCardGenerationList.getInstitution().getInstitutionCity()}-${studentHostelIDCardGenerationList.getInstitution().getInstitutionPostcode()}</label>
	</h5>
	</td>
	</tr>
	</thead>
	<tbody>
	</tbody>
	</table>
	<div  style="border-top:2px solid black;">
	<table class="table table-responsive">
	<tbody style="height:201px;">
	<tr>
	<td style="text-align:center;" colspan="2">
	<h5>
	<label>
	${fn:toUpperCase("Student Hostel Id Card")}
	</label>
	</h5>
	</td>
	</tr>
	<tr>
	<td rowspan="6">
	<img width="180px" height="150px" src="${pageContext.request.contextPath}${studentHostelIDCardGenerationList.getStudent().getUser().getProfilePicturePath()}"></img>
	</td>
	<td style="text-align:left;">Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">${studentHostelIDCardGenerationList.getStudent().getFirstName()}${studentHostelIDCardGenerationList.getStudent().getLastName()}</label></td>
	</tr>
	<tr>
	<td style="text-align:left;">Class Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">${studentHostelIDCardGenerationList.getStudentClass().getClassName()}</label></td>
	</tr>
	<tr>
	<td style="text-align:left;">Section Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">${studentHostelIDCardGenerationList.getSection().getSectionName()}</label></td>
	</tr>
	<tr>
	<td style="text-align:left;">Admission No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">${studentHostelIDCardGenerationList.getStudent().getAdmissionNo()}</label></td>
	</tr>
	<tr>
	<td style="text-align:center;"><img width="200px" height="40px" src="${pageContext.request.contextPath}${studentHostelIDCardGenerationList.getInstitution().getAuthorizedSignature()}"></img><br/>Authorized Signature</td>
	</tr>
	</tbody>
	</table>
	</div>
	</div>
	<div class="col-lg-5 col-sm-6" style="height:450px;border-top:2px solid black;border-left:2px solid black;border-bottom:2px solid black;border-right:2px solid black;"><br/>
	<table class="table table-responsive">
	<tbody>
	<tr>
	<td>
	<img width="150px" height="150px" src="${pageContext.request.contextPath}/resources/themes/images/hostel.png"></img>
	</td>
	</tr>
	<tr>
	<td style="text-align:left;">Address&nbsp;&nbsp;:&nbsp;&nbsp;<label>${studentHostelIDCardGenerationList.getStudent().getAddressLine1()},${studentHostelIDCardGenerationList.getStudent().getAddressLine2()}</label></td>
	</tr>
	<tr>
	<td style="text-align:left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style="text-align:right;">${studentHostelIDCardGenerationList.getStudent().getCity() } - ${studentHostelIDCardGenerationList.getStudent().getPostcode()}</label>
	</td>
	</tr>
	<tr>
	<td style="text-align:left;">Student Contact No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">${studentHostelIDCardGenerationList.getStudent().getContact()}</label></td>
	</tr>
	<tr>
	<td style="text-align:left;">Parent Contact No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">${studentHostelIDCardGenerationList.getStudent().getParentContact()}</label></td>
	</tr>
	<tr>
	<td><img width="250px" height="50px" src="${pageContext.request.contextPath}${studentHostelIDCardGenerationList.getBarCodeImage()}"></img><br/>${studentHostelIDCardGenerationList.getBarCode()}</td>
	</tr>
	</tbody>
	</table>
	</div>
	</div>
	<br/>
		        </c:forEach>		 		
     		</c:if>
    
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

	