<!DOCTYPE HTML>
<html>
   <head>
          <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta name="description" content="A fully featured education management system">
      <meta name="author" content="edumaat">
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
      <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
      
      
         <script src="${pageContext.request.contextPath}/resources/themes/js/datedropper/datedropper.js"></script>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/js/datedropper/datedropper.css"> 
        <script src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/timedropper.js"></script> 
         <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/js/datepicker/css/timedropper.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/js/datepicker/css/timedropper.min.css">
       <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/timepicker/bootstrap-timepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/clockpicker/css/bootstrap-clockpicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
      
         <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/admin/css/zoomeffect.css">
      
       <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.colVis.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/fixedColumns.dataTables.min.css" rel="stylesheet" type="text/css"/>
  
       <%-- <script src="${pageContext.request.contextPath}/resources/themes/printpage/js/jquery.PrintArea.js"></script> --%>
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
    .redBackground{
    background-color: red;  
}
        
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
@media print
{
body * { visibility: hidden; }
.div2 * { visibility: visible; }
.div2 { position: absolute; top: 40px; left: 30px; }
}

        </style>
        	
   <script type="text/javascript">

    function PrintElem(elem)
    {
        Popup($(elem).html());
    }

    function Popup(data)
    {
        var mywindow = window.open('', 'new div', 'height=400,width=600');
        mywindow.document.write('<html> <head><title>DMS</title>'+
        '<style>'+
        		'table, td, th {'+
        		   ' border: 1px solid black;'+
        		'}'+

        		'table {'+
        		  '  border-collapse: collapse;'+
        		 '   width: 100%;'+
        		'}'+

        		'td {'+
        		   ' height: 50px;'+
        		   ' vertical-align: bottom;'+
        		'}'+
        	'	</style>');
        /*optional stylesheet*/ //mywindow.document.write('<link rel="stylesheet" href="main.css" type="text/css" />');
        mywindow.document.write('</head><body >');
        mywindow.document.write(data);
        mywindow.document.write('</body></html>');

        mywindow.print();
        mywindow.close();

        return true;
    }

</script>
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
                              	 <security:authorize access="hasRole('timetablegenerator/viewlist')">
         <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Regular Time Table </b></h4>
                                 <table data-toggle="table"
                                 data-show-columns="true"
                                 data-page-list="[5, 10, 20]"
                                 data-page-size="5"
                                 data-search="true"
										   data-show-refresh="true"
										   data-show-toggle="true"
										   data-show-columns="true"
                                 data-pagination="true" data-show-pagination-switch="true"  class="table-bordered ">
                                    <thead>
                                       <tr>
                                          <th>Time Table Generator Id</th>
                                          <th>Class</th>
                                          <th>Section</th>
                                         <security:authorize access="hasAnyRole('timetablegenerator/view','timetablegenerator/delete')">
                                          <th>Action</th>
                                             </security:authorize>
                                       </tr>
                                    </thead>
                                    <tbody id="timeTableGeneratorList">
                                       <c:if test="${!empty timeTableGeneratorList}">
                                          <c:forEach items="${timeTableGeneratorList}" var="timeTableGeneratorList">
                                             <tr>
                                                <td>${timeTableGeneratorList.getTimeTableGeneratorId()}</td>
                                                <td>${timeTableGeneratorList.getClassSection().getClassSection().getClassName()}</td>
                                                 <td>${timeTableGeneratorList.getClassSection().getSectionClass().getSectionName()}</td>
                                                  <security:authorize access="hasAnyRole('timetablegenerator/view')">
                                                <td>
                                                  <security:authorize access="hasRole('timetablegenerator/view')">
                                                   <a href="#" id="edit"  type="button"data-href="#" data-id="${timeTableGeneratorList.getTimeTableGeneratorId()}" data-toggle="modal" onclick="editTimeTableGeneratorDiv()">
                                                    <i class="glyphicon glyphicon-eye-open" style="margin-right: 15px"></i>
                                                   </a>
                                                    </security:authorize>
                                                </td>
                                                </security:authorize>
                                             </tr>
                                          </c:forEach>
                                       </c:if>
                                    </tbody>
                                 </table>
                              </div>
                       </div>
                        </div>
                         	</security:authorize>
                         	
                         	      <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Substitute Time Table </b></h4>
                                 <table data-toggle="table"
                                 data-show-columns="true"
                                 data-page-list="[5, 10, 20]"
                                 data-page-size="5"
                                 data-search="true"
										   data-show-refresh="true"
										   data-show-toggle="true"
										   data-show-columns="true"
                                 data-pagination="true" data-show-pagination-switch="true"  class="table-bordered ">
                                    <thead>
                                       <tr>
                                          <th>Class Name</th>
                                          <th>Section Name</th>
                                            <th>Day Name/Hour Time</th>
                                              <th>Module Name</th>
                                                <th>Staff</th>
                                                 <th>Substitute Date</th>
                                        <security:authorize access="hasAnyRole('timetablegenerator/view')">
                                          <th>Action</th>
                                             </security:authorize>
                                       </tr>
                                    </thead>
                                    <tbody id="substituteTimeTableGeneratorList">
                                       <c:if test="${!empty substituteTimeTableGeneratorList}">
                                          <c:forEach items="${substituteTimeTableGeneratorList}" var="substituteTimeTableGeneratorList">
                                             <tr>
                                                <td>${substituteTimeTableGeneratorList.getTimeTableClass().getClassName()}</td>
                                                 <td>${substituteTimeTableGeneratorList.getSection().getSectionName()}</td>
                                                  <td>${substituteTimeTableGeneratorList.getDayName()}/${substituteTimeTableGeneratorList.getHourTitle()}</td>
                                                <td>${substituteTimeTableGeneratorList.getModule().getModuleName()}</td>
                                                 <td>${substituteTimeTableGeneratorList.getStaff().getFirstName()} ${substituteTimeTableGeneratorList.getStaff().getLastName()}</td>
                                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${substituteTimeTableGeneratorList.getSubstituteStartDate()}" /> - <fmt:formatDate pattern="dd/MM/yyyy" value="${substituteTimeTableGeneratorList.getSubstituteEndDate()}" /></td>
		                                  
                                                  <security:authorize access="hasAnyRole('timetablegenerator/view')">
                                                <td>
                                                    <security:authorize access="hasAnyRole('timetablegenerator/delete')">
                                                 
                                                   
                                                     <a href=""  id="delete"  type="button" data-href="#"  data-id="${substituteTimeTableGeneratorList.getSubstituteTimTableGeneratorHourId()}" data-toggle="modal" data-target="#confirm_delete_substituteTimeTableGenerator">
                                                 <span class="fa fa-trash-o"></span>
                                                   </a>
                                                    </security:authorize>
                                                </td>
                                                </security:authorize>
                                             </tr>
                                          </c:forEach>
                                       </c:if>
                                    </tbody>
                                 </table>
                              </div>
                       </div>
                        </div>
               </div>
                <div class="modal fade" id="confirm_delete_timeTableGenerator" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                           <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                 <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title">Confirmation?</h4>
                                 </div>
                                 <div class="modal-body">
                                    <h5>Are you sure you want to delete this time table generator ?</h5>
                                 </div>
                                  <div class="modal-footer">
                                 <form id="deleteTimeTableGeneratorForm" action="${pageContext.request.contextPath}/timetable/generator/automatic/delete" method="post">
                              <input type="hidden" id="deleteTimeTableGeneratorId" name="deleteTimeTableGeneratorId">
                              <button type="button" id="confirmDeleteTimeTableGenerator"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                           </div>
                              </div>
                           </div>
                        </div>
                        
                        <div class="modal fade" id="confirm_delete_substituteTimeTableGenerator" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                           <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                 <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title">Confirmation?</h4>
                                 </div>
                                 <div class="modal-body">
                                    <h5>Are you sure you want to delete this time table ?</h5>
                                 </div>
                                  <div class="modal-footer">
                                 <form id="deleteSubstituteTimeTableGeneratorForm" action="${pageContext.request.contextPath}/timetable/generator/substitute/delete" method="post">
                              <input type="hidden" id="deleteSubstituteTimeTableGeneratorId" name="deleteSubstituteTimeTableGeneratorId">
                              <button type="button" id="confirmDeleteSubstituteTimeTableGenerator"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                           </div>
                              </div>
                           </div>
                        </div>
               <div id="TimeTableGeneratorDiv" style="display:none;">
                       <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Time Table Generator</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="timeTableGeneratorForm" action="${pageContext.request.contextPath}/timetable/generator/automatic/add" method="post">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                     <select name="classId" id="classId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Class</option>
                                                <c:if test="${!empty classes}">
		                                       			<c:forEach items="${classes}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                    </select>                                 </div>
                              </div>
                           <!--    <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Section <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                   <select name="sectionId" id="sectionId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Class First</option>
                                                
                                    </select>                                  </div>
                              </div> -->
                          <!--    <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Select Module And Staff</label> 
                              <div class="col-sm-7"> 
                             	<select  id="moduleId" name="moduleId" multiple class="selectpicker" data-live-search="true"  data-style="btn-white" required="required" >
 			        				 <option value="" disabled >Select Module And Staff </option>
			        					
 			        					</select>
 			        			 </div>
                           </div> -->
                        <!--     <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Select Staff</label> 
                              <div class="col-sm-7"> 
                             	<select  id="staffId" name="staffId" multiple  class="selectpicker" data-live-search="true"  data-style="btn-white" required="required" >
 			        				 <option value="" disabled >Select Staff</option>
			        					
 			        					</select>
 			        			 </div>
                           </div> -->
                               <!--   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">No of Day's per Week</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="numberofday" class="form-control" required="required" maxlength="1" onkeypress="return isNumber(event)" id="numberofday" placeholder="">
                                       </div>
                                    </div>
                                       <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">No of Hour's Per Day</label> 
                                       <div class="col-sm-7"> 
                                          <input type="text" name="numberofhour" class="form-control" required="required" maxlength="2" onkeypress="return isNumber(event)" id="numberofhour" placeholder="">
                                       </div>
                                    </div> -->
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">TimeTableTemplate<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                   <select name="timetabletemplate" id="timetabletemplate" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required" >
                                     
                                     <option value="" disabled selected>Select TimeTableTemplate</option>
                                      <c:if test="${!empty timeTableTemplateList}">
		                                       			<c:forEach items="${timeTableTemplateList}" var="timeTableTemplateList">
		                                       				<option id="${timeTableTemplateList.getTimeTableName()}" value="${timeTableTemplateList.getTimeTableTemplateId()}">${timeTableTemplateList.getTimeTableName()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
		                                       		   </select> 
		                    </div>
                              </div>
                               
                              <div class="row">
                                 <div class="col-sm-offset-3">
                                   <button style="float:right" id="generatetimetable" name="generatetimetable" type="button" class="btn btn-success btn-custom waves-effect waves-light">Generate TimeTable</button>
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                    <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                    </div>
                              </div>
                                <div id="timetablemodule" align="center">
                              </div>
                              <br>
                              <br>
                              <div id="timetableview" class="table-responsive" > 
                              </div>
                                <div id="editor"></div>
                                
                                
                                 <input id="timeTableDays" name="timeTableDays" type="hidden">
                           <input id="timeTableHourSubjects" name="timeTableHourSubjects" type="hidden">
                              <input id="timeTableHourTitles" name="timeTableHourTitles" type="hidden">
                                   <div class="row" id="row" style="display:none;">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                               
                                    <button style="float:right" type="button" id="savetimetable"  class="btn btn-success btn-custom waves-effect waves-light">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                    <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                    </div>
                              </div>
                           </form>
                        </div>
                        </div>
                        </div>
                      </div>
                  </div>
                 
               </div>
              
               <div id="EditTimeTableGeneratorDiv" style="display:none;">
                           <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">View/Edit Time Table</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="updateTimeTableGeneratorForm" action="${pageContext.request.contextPath}/timetable/generator/substitute/add" method="post">
                          
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Substitute Start Date And End Date<span class="at-required-highlight">*</span> </label> 
                                 <div class="col-sm-7"> 
                                       <input type="text"  class="form-control reportrange" id="substituteStartAndEndDate" name="substituteStartAndEndDate" placeholder="" required="required">
                                 </div>
                                 
                              </div>
                          <div id="edittimetableview" class="table-responsive" > 
                          
                              </div>
                                <input id="editTimeTableDays" name="editTimeTableDays" type="hidden">
                           <input id="editTimeTableHourSubjects" name="editTimeTableHourSubjects" type="hidden">
                              <input type="hidden" id="updateTimeTableGeneratorId" name="updateTimeTableGeneratorId">
                        <input id="timeTableDayIds" name="timeTableDayIds" type="hidden">
                           <input id="timeTableHourIds" name="timeTableHourIds" type="hidden">
                         
                                <security:authorize access="hasRole('timetablegenerator/update')">
                              <div class="row">
                                 <div class="col-sm-offset-3">
                                 				
                               <!--   <input type="button" value="Print" onclick="PrintElem('#edittimetableview')" /> -->
                               

                                   <a href="#" id="updateTimeTableGenerator" style="float:right" class="btn btn-success btn-custom waves-effect waves-light" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Substitute
                                    			</a>   
                                     <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                 <button style="float:right;align:center;" type="button" class="btn btn-primary btn-custom waves-effect waves-light glyphicon glyphicon-download " onclick="PrintElem('#edittimetableview')">Print</button>
                               
                                 </div>
                              </div>
                                </security:authorize>
                           </form>
                           </div>
                           </div>
                          
                        </div>
                     </div>
                  </div>
               </div>
                <div class="modal fade" id="timeTableSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title">Confirmation?</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure you want to save this time table ?</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="timeTableSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                     </div>
                  </div>
                <div class="modal fade" id="timeTableGeneratorUpdateConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title">Confirmation?</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure you want to update time table ?</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="timeTableGeneratorUpdateConfirm" id="timeTableGeneratorUpdateConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
									</div>
								</div>
							</div>
						</div>
						
						
						
						   <div class="modal edumaat-animate-zoom" id="editModulePopup" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                     <form id="editselectmoduleform">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title">Time Table Generator</h4>
                           </div>
                           <div class="modal-body">
                             <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Select Module</label> 
                              <div class="col-sm-6"> 
                             	<select  id="editModuleId" name="editModuleId"  class="selectpicker" data-live-search="true"  data-style="btn-white" required="required" >
 			        				 <option value="" disabled selected>Select Module </option>
			        					<%-- <c:if test="${!empty modules}">
 			        						<c:forEach items="${modules}" var="module">
 			        								<option value="${module.getModuleName()}">${module.getModuleName()}	</option>
 			        							</c:forEach>
 			        		  			</c:if> --%>
 			        					</select>
 			        			 </div>
                           </div>
                           </div>
                           <br>
                           <div class="modal-footer">
                              <button type="button" id="editconfirm" class="btn btn-primary" data-dismiss="modal">Confirm</button>
                           </div>
                        </div>
                        </form>
                     </div>
                  </div>
						
						
						
						
						   <div class="modal edumaat-animate-zoom" id="addModulePopup" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                     <form id="selectmoduleform">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title">Time Table Generator</h4>
                           </div>
                          <%--  <div class="modal-body">
                             <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Select Module</label> 
                              <div class="col-sm-6"> 
                             	<select  id="moduleId" name="moduleId"  class="selectpicker" data-live-search="true"  data-style="btn-white" required="required" >
 			        				 <option value="" disabled selected>Select Module </option>
			        					<c:if test="${!empty modules}">
 			        						<c:forEach items="${modules}" var="module">
 			        								<option value="${module.getModuleName()}">${module.getModuleName()}	</option>
 			        							</c:forEach>
 			        		  			</c:if>
 			        					</select>
 			        			 </div>
                           </div>
                           </div> --%>
                           <br>
                           <div class="modal-footer">
                              <button type="button" id="confirm" class="btn btn-primary" data-dismiss="modal">Confirm</button>
                           </div>
                        </div>
                        </form>
                     </div>
                  </div>	
						
						
						
            </div>
         </div>
      </div>
      </div>
     <script>
         var resizefunc = [];
      </script>
     	 <script type="text/javascript">
    function modules(id){
    	var idd=id+"module";
           	 				 $("#"+id).append('<div class="col-sm-6"> '
           	 						+'<select  id="'+idd+'"  class="form-control"  >'
 			        				+' <option value="" disabled selected>Select Module </option>'
			        					+'<c:if test="${!empty modules}">'
 			        						+'<c:forEach items="${modules}" var="module">'
 			        								+'<option value="<c:out value="${module.getModuleName()}"/>">'
 			        		         				+'<c:out value="${module.getModuleName()}"/>'
 			        		         			+'</option>'
 			        							+'</c:forEach>'
 			        		  			+'</c:if>'
 			        					+'</select>' 
 			        				+'</div>');
			           		 
    } 
         
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
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.mockjax.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.autocomplete.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/countries.js"></script>
   
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
         
      <script src="${pageContext.request.contextPath}/resources/themes/script/substitutetimetablegenerator.js" type="text/javascript"></script> 
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/printpage/js/jspdf.debug.js"></script>
    
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

