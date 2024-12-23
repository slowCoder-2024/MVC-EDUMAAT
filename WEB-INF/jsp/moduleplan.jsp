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
      <script src="${pageContext.request.contextPath}/resources/themes/js/datedropper/datedropper.js"></script>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/js/datedropper/datedropper.css"> 
      <!--webfonts-->
      <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
      <!--//webfonts--> 
      <!--animate-->
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/animate.css" rel="stylesheet" type="text/css" media="all">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/css/select2.min.css" type="text/css" />
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/wow.min.js"></script>
      <script>
         new WOW().init();
      </script>
      <!--//end-animate-->
            <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/${theme}/css/datatables.min.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/${theme}/js/datatables.min.js"></script>
      <!-- Metis Menu -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
      <!-- chart -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
             <script src="${pageContext.request.contextPath}/resources/themes/js/image.js"></script>  
      
        <script src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/datepicker.js"></script> 
       <script src="${pageContext.request.contextPath}/resources/themes/js/datatables.js"> </script>
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/validator/css/validate.css">
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/jquery.validate.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script> 
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/edumaatalert/edumaatalert.css"/>
      
            <style>
         .x_title {
         border-bottom: 3px solid #E91E63;
         padding: 1px 5px 6px;
         margin-bottom: 10px;
         }
         #secondstep{
         display:none
         }
         .thumb-image {
         width:250px;
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
   <%@ include file="master_menu.jsp" %>
   <%@ include file="master_header.jsp" %>
   <body class="cbp-spmenu-push">
      <!-- main content start-->
      <div id="page-wrapper">
         <div class="main-page">
            <div id="ListDiv" style="display:block;">
               <div class="form-group">
               <div class="col-md-3 col-sm-3 col-xs-12"> 
                  <button type="button" class="btn btn-info" onclick="showDiv()">Create New Module Plan</button>
                  </div>
                  <div class="col-md-3 col-sm-3 col-xs-12"> 
                  <button type="button" class="btn btn-success" onclick="showsetupDiv()">Create New Module Plan Schedule</button>
                  </div> 
               </div>
               <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
              
                  
                      
                         <h3 class="title1">Module Plan </h3> 
                       
                       
                        <div class="tables">
                        <div class="table-responsive  bs-example widget-shadow">
                               <table class="table table-bordered" id="datatable">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                   	<th>Document Id</th>
                                   	<th>Class Name</th>
                               		<th>Section Name</th>
                                  	<th>Module Name</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr class="active">
                                  	<td>Column content</td>
                                    <td>Column content</td>
                                    <td>Column content</td>
                                    <td>Column content</td>
                                   	<td>
                                    	<a href="#" id="edit"  type="button"data-href="#" data-id="" data-toggle="modal" onclick="showeditDiv()">
                                    			<span class="glyphicon glyphicon-eye-open"></span>
                                    	</a>
                                   		 <a href="#"  id="delete"  type="button" data-href="#"  data-id="" data-toggle="modal" data-target="#confirm-delete">
                                    			<span class="glyphicon glyphicon-download-alt"></span>
                                    	 </a>
                                    </td>
                                   </tr>
                              </tbody>
                           </table>
                        </div>
                        </div>
                   
                
                <br />
               <br />
               <div class="x_title">
                  <div class="clearfix">
                  </div>
               </div>
               <br />
                      <h3 class="title1">Module Plan Schedule</h3> 
                       
                       
                        <div class="tables">
                        <div class="table-responsive  bs-example widget-shadow">
                               <table class="table table-bordered" id="datatable2">
                              <thead style="background-color:#673AB7;color:#ffffff;">
                                 <tr>
                                   	<th>Module Plan Id</th>
                                   	<th>Module Plan Name</th>
                               		<th>Start And End Date</th>
                                  	<th>Status</th>
                                    <th>Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr class="active">
                                 
                                  	<td>Column content</td>
                                    <td>Column content</td>
                                    <td>Column content</td>
                                    <td>Column content</td>
                                   	<td>
                                    	<a href="#" id="edit"  type="button"data-href="#" data-id="" data-toggle="modal" onclick="showeditDiv()">
                                    			<span class="glyphicon glyphicon-eye-open"></span>
                                    	</a>
                                   		 <a href="#"  id="delete"  type="button" data-href="#"  data-id="" data-toggle="modal" data-target="#confirm-delete">
                                    			<span class="glyphicon glyphicon-trash"></span>
                                    	 </a>
                                    </td>
                                   </tr>
                              </tbody>
                           </table>
                        </div>
                        </div>
            </div>
            <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to download this Document ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div class="modal fade" id="confirm-save" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ?, You want to add this Plan ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
            <div id="FormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Module Plan</h3>
                     <div class="form-three widget-shadow">
                 
                 
            
                 	<form class="form-horizontal" id="moduleplanform">
                                
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Module<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                     <select name="moduleId" id="moduleId" class="form-control1" required="required">
                                      <option value="" disabled selected>Select Module </option>
                                      <c:if test="${!empty modules}">
                                           <c:forEach items="${modules}" var="module">
                                             <option value="${module.getModuleId()}">${module.getModuleName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                 </div>
                              </div>
                           
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Name or Purpose<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" name="nameOrPurpose" id="nameOrPurpose" placeholder="" required="required">
                                   
                                 </div>
                              </div>  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Objectives<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="objectives" name="objectives" placeholder="" required="required">
                                   
                                 </div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Teacher Procedure<span class="at-required-highlight">*</span></label> 
                                 <div class="col-md-6 col-sm-6 col-xs-12"> 
                                    <input type="text" class="form-control" name="teacherProcedure" id="teacherProcedure" placeholder="" required="required">
                                 </div>
                              </div> 
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Student Activities<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="studentActivities" name="studentActivities" placeholder="" required="required">
                                   
                                 </div>
                              </div>
                             
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Assessment<span class="at-required-highlight">*</span> </label> 
                                 <div class="col-md-6 col-sm-6 col-xs-12"> 
                                    <input type="text" class="form-control" name="assessment" id="assessment" placeholder="" required="required">
                                 </div>
                              </div>
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">About The Assignments</label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="aboutAssignment" name="aboutAssignment" placeholder="" >
                                   
                                 </div>
                              </div>   
                             
                            <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reference Framework</label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="referenceFramework" name="referenceFramework" placeholder="">
                                   
                                 </div>
                              </div>
                           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reference Handout</label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="referenceHandout" name="referenceHandout" placeholder="">
                                   
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reference Materials</label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="referenceMaterial" name="referenceMaterial" placeholder="">
                                   
                                 </div>
                              </div>   
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Reference Questions</label> 
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="referenceQuestion" name="referenceQuestion" placeholder="">
                                   
                                 </div>
                              </div>
                            
                                <div class="row">
                                 <div class="col-sm-offset-3"> 
                                    <button style="float:right" type="button"  id="moduleplansave"   class="btn btn-success">Add Module Plan</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" class="btn btn-danger" onclick="location.reload();">Cancel</button>
                                 </div>
                              </div>
                                </form>
                     
                  
                        
                      
                     </div>
                  </div>
               </div>
            </div>
           <div id="SetupDiv" style="display:none;">
            
            <div class="forms">
                  <div class="row">
                     <h3 class="title1">Create New Module Plan Schedule</h3>
                     <div class="form-three widget-shadow">
                        <form class="form-horizontal" id="moduleplanscheduleform">
                        <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Module Plan Id/Name <span class="at-required-highlight">*</span> </label> 
                                       <div class="col-sm-6">
                                        
                                           <select name="moduleId" id="moduleId" class="form-control1" required="required">
                                      <option value="" disabled selected>Select Module </option>
                                      <c:if test="${!empty modules}">
                                           <c:forEach items="${modules}" var="module">
                                             <option value="${module.getModuleId()}">${module.getModuleName()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                       </div>
                                    </div> 
                                           <div class="form-group">
                              <label for="" class="col-sm-3 control-label"> Schedule Start Date<span class="at-required-highlight">*</span></label> 
                               <div class="col-sm-6"> 
                                <input type="text" name="scheduleStartDate" id="scheduleStartDate" class="form-control form-control-firststep" required="required" placeholder="">
 							</div>
                              </div>
                                <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Schedule End Date<span class="at-required-highlight">*</span></label> 
                                
                                 <div class="col-sm-6">
												
												<input name="scheduleEndDate" id="scheduleEndDate" class="form-control form-control-firststep" type="text" required="required" placeholder="">
											</div>
                                 </div>
                        <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Remarks</label> 
                                
                                 <div class="col-sm-6">
												
												<input class="form-control" type="text" placeholder="">
											</div>
                                 </div>
                                   <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Hours Required<span class="at-required-highlight">*</span></label> 
                                
                                 <div class="col-sm-6">
												
												<input class="form-control" type="text" placeholder="" required="required" onkeypress="return decimalAmount(this, event, 2)">
											</div>
                                 </div>
                              
                        
                          <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Status<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-6">
                                          <select name="selector1" id="selector" class="form-control1" required="required">
                                             <option value="" disabled selected>Please Select </option>
                                               <option value="1">Active</option>
                                                 <option value="0">Inactive</option>
                                            
                                              
                                               
                                          </select>
                                       </div>
                                    </div> 
                                 
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button"  id="moduleplanschedulesave"  class="btn btn-success">Add Module Plan Schedule</button>
                                    <button style="float:right" type="reset" class="btn btn-info">Clear</button>
                                    <button style="float: right" class="btn btn-danger" onclick="location.reload();">Cancel</button>
                                 </div>
                              </div>
                        
                        </form>
                        </div>
            
            </div>
            </div>
            
            
            
            
            
            
            
            </div> 
            <div id="EditFormDiv" style="display:none;">
               <div class="forms">
                  <div class="row">
                     <h3 class="title1">View Plan</h3>
                     <div class="form-three widget-shadow">
                     <div class="alert alert-info">
							<h5>Messages:</h5>
                                    <p>"No Plan Available"</p>
                  			
                  			
                  			 <div class="row">
                                 <div class="col-sm-offset-3">
                                   
                                   <button style="float: right" class="btn btn-danger" onclick="location.reload()">Cancel</button>
                                 </div>
                              </div>
                        				</div>
                        
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <!-- Classie -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
      
      <script>
         $(document).ready(function() {
                 $("#fileUpload").on('change', function() {
                   //Get count of selected files
                   var countFiles = $(this)[0].files.length;
                   var imgPath = $(this)[0].value;
                   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
                   var image_holder = $("#image-holder");
                   
                   image_holder.empty();
                   if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
                     if (typeof(FileReader) != "undefined") {
                       //loop for each file selected for uploaded.
                       for (var i = 0; i < countFiles; i++) 
                       {
                         var reader = new FileReader();
                         reader.onload = function(e) {
                           $("<img />", {
                             "src": e.target.result,
                             "class": "thumb-image"
                           }).appendTo(image_holder);
                         }
                         image_holder.show();
                         reader.readAsDataURL($(this)[0].files[i]);
                       }
                     } else {
                       alert("This browser does not support FileReader.");
                     }
                   } else {
                     alert("Pls select only images");
                   }
                 });
               });
      </script>
     <!--  	<script type="text/javascript">
$(function() {

  $('input[name="datefilter"]').daterangepicker({
      autoUpdateInput: false,
      locale: {
          cancelLabel: 'Clear'
      }
  });

  $('input[name="datefilter"]').on('apply.daterangepicker', function(ev, picker) {
      $(this).val(picker.startDate.format('MM/DD/YYYY') + ' - ' + picker.endDate.format('MM/DD/YYYY'));
  });

  $('input[name="datefilter"]').on('cancel.daterangepicker', function(ev, picker) {
      $(this).val('');
  });

});
</script> -->
<!--       <script>
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
      </script> -->
      <!-- Bootstrap Core JavaScript -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/moduleplan.js" type="text/javascript"></script>
      <!--scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/cbp_menu.js"></script> 
      <script src="${pageContext.request.contextPath}/resources/themes/js/datepicker/js/datepicker.js"></script> 
      <!-- Classie -->	
       <script src="${pageContext.request.contextPath}/resources/edumaatalert/edumaatalert.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/select2.full.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/resetselect.js"></script> 
      <!--scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>
      <!--//scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/site.js" type="text/javascript"></script>
   </body>
</html>