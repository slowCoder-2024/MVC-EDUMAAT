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
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.11.2.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.7.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/modernizr.min.js"></script>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/edumaatalert/edumaatalert.css"/>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/timepicker/bootstrap-timepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/clockpicker/css/bootstrap-clockpicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/timedropper.js"></script> 
         <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/js/datepicker/css/timedropper.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/js/datepicker/css/timedropper.min.css">
      
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
        
        .dismiss {
    padding: 15px;
    margin-bottom: -20px;
    border: 1px solid transparent;
    border-radius: 4px;
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
 <security:authorize access="hasRole('examtemplate/add')">
                   <div class="form-group">
                     <button type="button" class="btn btn-primary btn-custom waves-effect waves-light col-md-3" onclick="showExamTemplateDiv()">Add New Exam / Assessment Template</button>
                  </div>
                 
                  <div class="x_title">
                     <div class="clearfix">
                     </div>
                  </div> 	
                  </security:authorize>
                  <br />
                    <security:authorize access="hasRole('examtemplate/viewlist')">
         <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Exam / Assessment Template</b></h4>
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
                                       <th>Exam / Assessment Template Id</th>
                              <th>Exam / Assessment Template Name</th>
                             <security:authorize access="hasAnyRole('examtemplate/view','examtemplate/delete')">
                              <th>Action</th>
                             </security:authorize>
                                       </tr>
                                    </thead>
                                    <tbody id="examTemplateList">
                                       <c:if test="${!empty examTemplateList}">
                                          <c:forEach items="${examTemplateList}" var="examTemplateList">
                                             <tr>
                                                 <td>${examTemplateList.getExamTemplateId()}</td>
                                                 <td>${examTemplateList.getExamTemplateName()}</td>
                                                <security:authorize access="hasAnyRole('examtemplate/view','examtemplate/delete')">
                                                <td>
                                                <security:authorize access="hasRole('examtemplate/view')">
                                                   <a href="#" id="edit"  type="button"data-href="#" data-id="${examTemplateList.getExamTemplateId()}" data-toggle="modal" onclick="editExamTemplateDiv()">
                                                    <i class="fa fa-pencil" style="margin-right: 15px"></i>
                                                   </a>
                                                   </security:authorize>
                                                     <security:authorize access="hasRole('examtemplate/delete')">
                                                   <a href="#"  id="delete"  type="button" data-href="#"  data-id="${examTemplateList.getExamTemplateId()}" data-toggle="modal" data-target="#confirm_delete_examTemplate">
                                                  <i class="fa fa-trash-o"></i>
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
               </div>
                <div class="modal fade" id="confirm_delete_examTemplate" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                           <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                 <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="exampleModalLabel">Confirm</h4>
                                 </div>
                                 <div class="modal-body">
                                    <h5>Are you sure you want to delete this this exam template ?</h5>
                                 </div>
                                  <div class="modal-footer">
                                 <form id="deleteExamTemplateForm" action="${pageContext.request.contextPath}/exam/template/delete" method="post">
                              <input type="hidden" id="deleteExamTemplateId" name="deleteExamTemplateId">
                              <button type="button" id="confirmDeleteExamTemplate"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                           </div>
                              </div>
                           </div>
                        </div>
               <div id="ExamTemplateDiv" style="display:none;">
                      
                              
                              
                              <form class="form-horizontal" action="${pageContext.request.contextPath}/exam/template/add" method="post" id="examTemplateForm">
                              <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Create New Exam / Assessment  Template</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">


  
                                                
                                      
                        
                           
    
    
				<div class="dismiss">
                          
                	
                            <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Exam / Assessment  Template Name <span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-6"> 
                                 <input type="text" name="examTemplateName" class="form-control" id="examTemplateName" required="required" maxlength="50">
                              </div>
                               </div>
                              
                            
                           </div>
                           
     		<div class="dismiss">
                       
                	
                            <div class="form-group">
                              
                              <div class="col-sm-offset-3"> 
                              <button style="float:right"  type="button" id="addTerm" class="btn btn-success btn-custom waves-effect waves-light"><i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp;Add Term</button>    </div>
                              </div>
                               </div>
                              
                              
                              <br>
                                    <div class="card-box" style="box-shadow: 0 0px 8px 0 rgba(94, 194, 179, 0.67), 0 1px 0px 0 rgba(12, 236, 133, 0)">  
                             
                            <h4 class="m-t-0 header-title" style="color:purple;"><b>Exam / Assessment Template Details</b></h4>
                             <div class="row" >
                       
                                 <div class="col-lg-12">
                                 
                                    <div id="term1"> 
                                      <div class="dismiss">
                                    <h3 class="title"></h3>
                              <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Term Name<span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-6"> 
                                 <input type="text" name="term1termName1" class="form-control" id="term1termName1" required="required" maxlength="50">
                               </div>
                                </div>
                             
                               </div>
                          <div id="termExam1">
                          <div class="dismiss">
                            <h3 class="title"><button style="float:right"  type="button" id="addTermExam" class="btn btn-success btn-custom waves-effect waves-light"><i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp;Add Term Exam</button></h3>
                            <div class="form-group ">
                            <label for="" class="col-sm-3 control-label">Term Exam / Assessment Name <span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-6"> 
                                 <input type="text" name="termExam1termExamName1" class="form-control" id="termExam1termExamName1" required="required" maxlength="50">
                              </div> 
                              </div>
                                 <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Term Exam / Assessment Weight (Percentage)<span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-6"> 
                                 <input type="text" name="termExam1termExamPercentage1" class="form-control" id="termExam1termExamPercentage1" required="required" maxlength="50" onkeypress="return isFloatNumber(this,event)">
                               </div>
                                </div>
                              </div>
                             </div>
                          </div>
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 </div>
                                 </div>
                                 </div>
                              
                              
                              
                               <div class="terms">
                          </div>
                        
                           <input id="termIds" name="termIds" type="hidden">
                            <input id="termExamIds" name="termExamIds" type="hidden">
                              <div class="dismiss">
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="examTemplateSave"  class="btn btn-success btn-custom waves-effect waves-light">Save</button>
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                    <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                    </div>
                              </div>
                              
                              
                              </div>
                           
                           </div>
      
   </div>
    
     </div>
     
     
     
     

                                 
     </form>
      
                       
						
      
      
       
                          
			
                            
      
  
                        
                       
                    
                    
                    
                    
                    
                           
                           
                       
                        
                     
                  </div>
                 
               </div>
              
               <div id="EditExamTemplateDiv" style="display:none;">
    
    
    
                       <form class="form-horizontal" action="${pageContext.request.contextPath}/exam/template/update" method="post" id="updateExamTemplateForm">
                              <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Edit Exam / Assessment  Template</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">


  
                                                
                                      
                        
                           
    
    
				<div class="dismiss">
                          
                	
                            <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Exam Template Name <span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-6"> 
                                 <input type="text" name="editExamTemplateName" class="form-control" id="editExamTemplateName" required="required" maxlength="50">
                              </div>
                               </div>
                              
                            
                           </div>
                           
     		<div class="dismiss">
                       
                	
                            <div class="form-group">
                              
                              <div class="col-sm-offset-3"> 
                              <button style="float:right"  type="button" id="editaddTerm" class="btn btn-success btn-custom waves-effect waves-light"><i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp;Add Term</button>    </div>
                              </div>
                               </div>
                              
                              
                              <br>
                          
                              
                              
                              
                               <div class="editterms">
                          </div>
                        
                           <input id="editExamTemplateId" name="editExamTemplateId" type="hidden">
                            <input id="edittermIds" name="edittermIds" type="hidden">
                            <input id="edittermExamIds" name="edittermExamIds" type="hidden">
                              <div class="dismiss">
                                <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                   <%-- <security:authorize access="hasRole('examtemplate/update')">
                          
                                       
                                    			
                                    			    <button style="float:right"  type="button" id="updateTimeTableTemplate" class="btn btn-success btn-custom waves-effect waves-light">Update</button>   
                                    			</security:authorize> --%>
 
                               <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                       <button style="float: right" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                                          </div>
                              </div>
                              
                              
                              </div>
                           
                           </div>
      
   </div>
    
     </div>
     
     
     
     

                                 
     </form>
    
    
    

               </div>
                <div class="modal fade" id="examTemplateSaveConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title">Confirmation?</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure you want to add this exam template ?</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="examTemplateSaveConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                     </div>
                  </div>
                <div class="modal fade" id="examTemplateUpdateConfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title">Confirmation?</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure you want to update this exam template ?</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="examTemplateUpdateConfirm" id="examTemplateUpdateConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
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


  <script src="${pageContext.request.contextPath}/resources/themes/assets/js/bootstrap3.3.4.js"> </script>

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
        <script src="${pageContext.request.contextPath}/resources/themes/script/examTemplate.js" type="text/javascript"></script> 
   </body>
</html>

