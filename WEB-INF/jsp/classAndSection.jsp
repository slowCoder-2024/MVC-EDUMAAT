

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
        <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/custombox/css/custombox.css" rel="stylesheet">
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
      
      
       <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.colVis.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/fixedColumns.dataTables.min.css" rel="stylesheet" type="text/css"/>
      
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
               <div class="loader"  style="display: none"></div>
                  <div id="ListDiv" style="display:block;">
                     <div class="form-group">
                        <div class="col-md-4 col-sm-4 col-xs-12"> 
                           <button type="button" class="btn btn-primary waves-effect waves-light" onclick="showClassAndSectionDiv()"> New Course(Class) And Semester/Year(Section)</button>
                        </div>
                     </div>
                     <br>
                     <br><br>
                     <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Course(s)</b></h4>
                              <table data-toggle="table"
                                 data-show-columns="false"
                                 data-page-list="[5, 10, 20]"
                                 data-page-size="5"
                                 data-pagination="true" data-show-pagination-switch="true" class="table-bordered ">
                                 <thead>
                                    <tr>
                                       <th data-field="Class_Name" data-switchable="false">Course Name</th>
                                       <th data-field="No_of_Sections">No of Semester/Year(s)</th>
                                       <th data-field="Action">Action</th>
                                    </tr>
                                 </thead>
                                 <tbody id="classList">
                                    <c:if test="${!empty classList}">
                                       <c:forEach items="${classList}" var="clazz">
                                          <tr>
                                             <td>${clazz.getClassName()}</td>
                                             <td>${clazz.getClassSections().size()}</td>
                                             <td>
                                                <a href="#" id="edit"  type="button"data-href="#" data-id="${clazz.getClassId()}" data-toggle="modal"onclick="showeditclassandsectionDiv()"
                                                   class="on-default edit-row"><i class="fa fa-pencil" style="margin-right: 15px"></i> 
                                                </a>
                                                <a href="#"  id="delete"  type="button" data-href="#"  data-id="${clazz.getClassId()}" data-toggle="modal" data-target="#confirm_delete_class"  class="on-default remove-row"><i class="fa fa-trash-o"></i>
                                                </a>
                                             </td>
                                          </tr>
                                       </c:forEach>
                                    </c:if>
                                 </tbody>
                              </table>
                           </div>
                        </div>
                     </div>
                     <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Semester/Year(s)</b></h4>
                              <table data-toggle="table"
                                 data-show-columns="false"
                                 data-page-list="[5, 10, 20]"
                                 data-page-size="5"
                                 data-pagination="true" data-show-pagination-switch="true" class="table-bordered ">
                                 <thead>
                                    <tr>
                                       <th data-field="Section_Name" data-switchable="false">Semester/Year Name</th>
                                       <th data-field="Action">Action</th>
                                    </tr>
                                 </thead>
                                 <tbody id="sectionList">
                                    <c:if test="${!empty sectionList}">
                                       <c:forEach items="${sectionList}" var="section">
                                          <tr>
                                             <td>${section.getSectionName()}</td>
                                             <td><a href="#" id="edit"  type="button"data-href="#" data-id="${section.getSectionId()}" onclick="showeditsectionDiv()"data-toggle="modal"
                                                class="on-default edit-row"><i class="fa fa-pencil" style="margin-right: 15px"></i>
                                                </a>
                                                <a href="#"  id="delete"  type="button" data-href="#"  data-id="${section.getSectionId()}" data-toggle="modal" data-target="#confirm_delete_class_section"
                                                   class="on-default remove-row"><i class="fa fa-trash-o"></i> 
                                                </a>
                                             </td>
                                          </tr>
                                       </c:forEach>
                                    </c:if>
                                 </tbody>
                              </table>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div id="confirm_delete_class" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="custom-width-modalLabel" aria-hidden="true" style="display: none;"data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                              <h4 class="modal-title" >Confirm</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure, You want to delete this course ?</h5>
                           </div>
                           <div class="modal-footer">
                              <form id="deleteClassForm" action="${pageContext.request.contextPath}/class/deleteClassWithConfig" method="post">
                                 <input type="hidden" id="deleteClassId" name="dedeleteClassId">
                                 <button type="button" id="confirmDeleteClass" class="btn btn-primary waves-effect waves-light" data-dismiss="modal">Yes</button>
                              </form>
                           </div>
                        </div>
                        <!-- /.modal-content -->
                     </div>
                     <!-- /.modal-dialog -->
                  </div>
                  <!-- /.modal -->     
                  <div id="confirm_delete_class_section" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="custom-width-modalLabel" aria-hidden="true" style="display: none;"data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                              <h4 class="modal-title" >Confirm</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure, You want to delete this semester/year ?</h5>
                           </div>
                           <div class="modal-footer">
                              <form id="deleteSectionForm" action="${pageContext.request.contextPath}/section/delete" method="post">
                                 <input type="hidden" id="deleteSectionId" name="deleteSectionId">
                                 <button type="button" id="deleteSectionConfirm" class="btn btn-primary waves-effect waves-light" data-dismiss="modal">Yes</button>
                              </form>
                           </div>
                        </div>
                        <!-- /.modal-content -->
                     </div>
                     <!-- /.modal-dialog -->
                  </div>
                  <!-- /.modal -->
                  <div id="classAndSectionDiv" style="display:none;">
                     <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Create Course and Semester/Year</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                    <form class="form-horizontal" action="${pageContext.request.contextPath}/classSection/classconfig" method="post" id="createclassform">
                                       <div class="form-group">
                                          <label for="className" class="col-sm-3 control-label">Course Name*</label>
                                          <div class="col-sm-7 col-md-6">
                                             <input type="text" required class="form-control" id="className" name="className"  maxlength="50">
                                             <span id="errorclassName" class="error"></span>
                                          </div>
                                          <button  style="float:right" id="addsection"  type="button" class="btn btn-warning waves-effect waves-light"><i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp; Add New Semester/Year(Section)</button>
                                       </div>
                                       <div class="form-group">
                                          <label for="sections" class="col-sm-3 control-label">Semester/Year Name*</label>
                                          <div class="col-sm-6">
                                             <select class="selectpicker" id="sections" multiple="multiple" name="sections" required="required" data-live-search="true"  data-style="btn-white" data-selected-text-format="count >3">
                                                <c:if test="${!empty sectionList}">
                                                   <c:forEach items="${sectionList}" var="section">
                                                      <option id="test" value="${section.getSectionId()}">${section.getSectionName()}</option>
                                                   </c:forEach>
                                                </c:if>
                                             </select>
                                             <span id="errorsections" class="error"></span>
                                          </div>
                                       </div>
                                              <div class="form-group">
                                 <label for="selectedClassStaff" class="col-sm-3 control-label">Class-Teacher / Coordinator<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="selectedClassStaff" id="selectedClassStaff" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                        <option disabled selected>Select Staff</option>
                                                      <c:if test="${!empty staffLists}">
                                                         <c:forEach items="${staffLists}" var="staffList">
                                                            <option value="${staffList.getStaffId()}">${staffList.getFirstName()}${staffList.getLastName()}</option>
                                                         </c:forEach>
                                                      </c:if>
                                    </select>
                                
                                 </div>
                              </div>
                                       <div class="form-group">
                                      
                                          <div class="col-sm-offset-4 col-sm-8">
                                             <button style="float:right"  type="button" id="classandsectionsavebutton" class="btn btn-primary btn-custom waves-effect waves-light ">Save</button>
                                             <button style="float:right" type="reset" id="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                             <button style="float:right" type="button" onclick="location.reload();" class="btn btn-default btn-custom waves-effect waves-light m-l-5">Cancel</button>
                                          </div>
                                       </div>
                                    </form>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  <!-- end row -->
                  <div id="classAndSectionAddingConfirmation" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="custom-width-modalLabel" aria-hidden="true" style="display: none;"data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                              <h4 class="modal-title" >Confirm</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure, You want to add this course ?</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="confirmAddClass" class="btn btn-primary waves-effect waves-light" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                        <!-- /.modal-content -->
                     </div>
                     <!-- /.modal-dialog -->
                  </div>
                  <!-- /.modal -->
                  <div id="sectionAddingConfirmation" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="custom-width-modalLabel" aria-hidden="true" style="display: none;"data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                              <h4 class="modal-title" >Confirm</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure, You want to add this semester/year ?</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="confirmAddSection" class="btn btn-primary waves-effect waves-light" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                        <!-- /.modal-content -->
                     </div>
                     <!-- /.modal-dialog -->
                  </div>
                  <!-- /.modal -->
                  <div id="addSectionPopup" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="custom-width-modalLabel" aria-hidden="true" style="display: none;"data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog">
                        <form action="${pageContext.request.contextPath}/section/add" id="classandsectionsettingform" method="post">
                           <div class="modal-content">
                              <div class="modal-header">
                                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                 <h4 class="modal-title" id="exampleModalLabel" >Create New Semester/Year</h4>
                              </div>
                              <div class="modal-body">
                                 <div class="form-group">
                                    <label for="sectionName" class="col-sm-3 control-label">Semester/Year Name*</label>
                                    <div class="col-sm-7">
                                       <input type="text" required class="form-control" id="sectionName" name="sectionName"  maxlength="50">
                                       <span id="errorsectionName" class="error"></span>
                                    </div>
                                 </div>
                              </div>
                              <br>
                              <div class="modal-footer">
                                 <button type="submit" id="createnewsection" class="btn btn-primary waves-effect waves-light">Yes</button>
                              </div>
                           </div>
                           <!-- /.modal-content -->
                        </form>
                     </div>
                     <!-- /.modal-dialog -->
                  </div>
                  <!-- /.modal -->
                  <div id="update_Class_Section_Confirmation" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="custom-width-modalLabel" aria-hidden="true" style="display: none;"data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                              <h4 class="modal-title" >Confirm</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure, you want to update this Course ?</h5>
                           </div>
                           <div class="modal-footer">
                           
                              <button type="button" id="saveConfirm" class="btn btn-primary waves-effect waves-light" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                        <!-- /.modal-content -->
                     </div>
                     <!-- /.modal-dialog -->
                  </div>
                  <!-- /.modal -->
                  <div id="update_Section_Confirmation" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="custom-width-modalLabel" aria-hidden="true" style="display: none;"data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                              <h4 class="modal-title" >Confirm</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure, you want to update Semester/Year ?</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="updateSectionConfirm" class="btn btn-primary waves-effect waves-light" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                        <!-- /.modal-content -->
                     </div>
                     <!-- /.modal-dialog -->
                  </div>
                  <!-- /.modal -->
                  <div id="EditClassFormDiv" style="display:none;">
                     <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Edit Course</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                    <form class="form-horizontal" action="${pageContext.request.contextPath}/class/update" method="post" id="updateClassAndSectionForm">
                                       <div class="form-group">
                                          <label for="editClassName" class="col-sm-3 control-label">Course Name*</label>
                                          <div class="col-sm-6">
                                             <input type="text" required="required" class="form-control" id="editClassName" name="editClassName"  maxlength="50">
                                             <span id="erroreditClassName" class="error"></span>
                                          </div>
                                       </div>
                                       <div class="form-group">
                                          <label for="editSections" class="col-sm-3 control-label">Semester/Year Name*</label>
                                          <div class="col-sm-6">
                                             <select class="selectpicker" id="editSections" multiple="multiple" name="editSections" required="required" data-live-search="true"  data-style="btn-white" data-selected-text-format="count >3">
                                                <c:if test="${!empty sectionList}">
                                                   <c:forEach items="${sectionList}" var="section">
                                                      <option id="${section.getSectionId()}" value="${section.getSectionId()}">${section.getSectionName()}</option>
                                                   </c:forEach>
                                                </c:if>
                                             </select>
                                             <span id="erroreditSections" class="error"></span>
                                          </div>
                                       </div>
                                                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Class-Teacher / Coordinator<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                    <select name="editSelectedClassStaff" id="editSelectedClassStaff"class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                        <option disabled selected>Select Staff</option>
                                                      <c:if test="${!empty staffLists}">
                                                         <c:forEach items="${staffLists}" var="staffList">
                                                            <option value="${staffList.getStaffId()}">${staffList.getFirstName()}${staffList.getLastName()}</option>
                                                         </c:forEach>
                                                      </c:if>
                                    </select>
                                
                                 </div>
                                 <input id="updateClassId" name="updateClassId" type="hidden">
                              </div>
                                       <div class="form-group">
                                          
                                           <input id="classSectionIdUpdate" name="classSectionIdUpdate" type="hidden">
                                          <div class="col-sm-offset-4 col-sm-8">
                                             <a href="#" id="updateClassAndSection" style="float:right" class="btn btn-primary waves-effect waves-light" type="button" data-id="" >
                                             Update
                                             </a>                                 <button style="float:right" type="reset" id="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                             <button style="float:right" type="button" onclick="location.reload();" class="btn btn-default btn-custom waves-effect waves-light m-l-5">Cancel</button>
                                          </div>
                                       </div>
                                    </form>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div id="EditSectionFormDiv" style="display:none;">
                     <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Edit Semester/Year</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                    <form class="form-horizontal" action="${pageContext.request.contextPath}/section/update" method="post" id="updateSectionForm">
                                       <div class="form-group">
                                          <label for="editSectionName" class="col-sm-3 control-label">Semester/Year Name*</label>
                                          <div class="col-sm-7">
                                             <input type="text" required class="form-control" id="editSectionName" name="editSectionName"  maxlength="50">
                                          </div>
                                       </div>
                                       <div class="form-group">
                                          <input id="updateSectionId" name="updateSectionId" type="hidden">
                                          <div class="col-sm-offset-4 col-sm-8">
                                             <a href="#" id="updateSection" style="float:right" class="btn btn-primary waves-effect waves-light" type="submit" data-id="" >
                                             Update
                                             </a>                                 <button style="float:right" type="reset" id="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                             <button style="float:right" type="button" onclick="location.reload();" class="btn btn-default btn-custom waves-effect waves-light m-l-5">Cancel</button>
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
               <!-- container -->
            </div>
            <!-- content -->
         </div>
      </div>
      <!-- END wrapper -->
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
     <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/custombox/js/custombox.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/custombox/js/legacy.min.js"></script>
           
     <script type="text/javascript">
  
    TableManageButtons.init();
    
    
  

    </script>
     <script src="${pageContext.request.contextPath}/resources/themes/script/classandsection.js" type="text/javascript"></script>

   </body>
</html>

