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
   <div class="loader" style="display: none"></div>      
        <div id="ListDiv" style="display:block;">
     		 <div class="forms">
                  <div class="row">
                        
                      
               <security:authorize access="hasRole('editinstitution/view')">
                      <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-warning">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Institution Profile</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                    		
                        <form class="form-horizontal" id="editinstitutionform" action="${pageContext.request.contextPath}/institution/editinstitution/update" method="post" enctype='multipart/form-data'>
                         
								<c:if test="${!empty institutionDetails}">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" for="institutionName"> Institution Name <span class="at-required-highlight">*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="institutionName" name="institutionName" type="text" class="form-control" required="required" maxlength="255" value="${institutionDetails.getInstitutionName()}">
                                                    </div>
                                                </div>
                                          
					    						<div class="form-group">
                                                    <label class="col-sm-3 control-label" for=""> Institution Code <span>*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="institutionCode" name="institutionCode" type="text" required="required" class="form-control" value="${institutionDetails.getInstitutionCode()}" maxlength="100">
                                                    </div>
                                                </div>
                                                
                                 <div class="form-group">
                                 <label for="institutionProfilePic" class="col-sm-3 control-label">Institution Logo</label> 
                                 <div class="col-sm-7">
                                    <input name="institutionProfilePic" id="institutionProfilePic" class="filestyle" data-size="md" type="file"/>
                                    <br>
                                    <div id="image-holder2" >

                                    
                                     <img src="..${institutionDetails.getInstitutionLogo()}" class="thumb-image"  id="userImage"></img>
                                    </div>
                                   
                                 </div>
                              </div>
                              <div class="form-group">
                                 <label for="institutionProfilePic" class="col-sm-3 control-label">Institution Authorized Signature</label> 
                                <div class="col-sm-7">
                                    <input name="institutionAuthorizedSignaturePic" id="institutionAuthorizedSignaturePic" class="filestyle" data-size="md" type="file"/>
                                    <br> 
                                    <div id="image-aaholder1">
                                   <img src="..${institutionDetails.getAuthorizedSignature()}" class="thumb-image"  id="userImage"></img>
                                    
                                   </div>
									</div>
								</div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label " for="institutionEmail">Institution Email (without any space) <span class="at-required-highlight">*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="institutionEmail" name="institutionEmail" type="text" class="required email form-control" required="required"  maxlength="100" value="${institutionDetails.getInstitutionEmail()}">
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-sm-3 control-label " for="institutionContact"> Institution Contact<span class="at-required-highlight">*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="institutionContact" name="institutionContact" type="text" class="form-control" required="required" onkeypress="return isNumber(event)" maxlength="10"  value="${institutionDetails.getInstitutionContact()}">

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label " for="institutionAddressLine1">Institution Address Line 1 <span class="at-required-highlight">*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="institutionAddressLine1" name="institutionAddressLine1" type="text" class="form-control"  maxlength="255" value="${institutionDetails.getInstitutionAddressline1()}" required="required">
                                                    </div>
                                                </div>
												
												<div class="form-group">
                                                    <label class="col-sm-3 control-label " for="institutionAddressLine2">Institution Address Line 2 <span class="at-required-highlight">*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="institutionAddressLine2" name="institutionAddressLine2" type="text" class="form-control"  maxlength="255" value="${institutionDetails.getInstitutionAddressline2()}" required="required">
                                                    </div>
                                                </div>
										             <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Institution Country<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="institutionCountry" id="geographicallocation" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                           
                                              		<c:if test="${!empty geographicallocationList}">
		                                       			<c:forEach items="${geographicallocationList}" var="country">
		                                       			<c:if test="${institutionDetails.getInstitutionCountry()== country.getName()}">
		                                       			<option id="${country.getGeographicalLocationId()}" value="${country.getName()}" selected>${country.getName()}</option>
		                                       			
					                                    	</c:if>
					                                    	<c:if test="${institutionDetails.getInstitutionCountry()!=country.getName()}">
		                                       				<option id="${country.getName()}" value="${country.getName()}">${country.getName()}</option>
		                                       				</c:if>
		                                       			</c:forEach>
		                                       		</c:if>
                                              
                                             </select>     
                                       </div>
                                    </div>                                
                                         <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution State<span class="at-required-highlight">*</span> </label> 
                                 <div class="col-sm-7">                                   
                                     <select name="institutionState" id="geographicallocationstate" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                   <c:if test="${!empty geographicallocationStateList}">
		                                       			<c:forEach items="${geographicallocationStateList}" var="stateList">
		                                       			<c:if test="${institutionDetails.getInstitutionState()==stateList.getName()}">
		                                       			<option id="${stateList.getName()}" value="${stateList.getName()}" selected>${stateList.getName()}</option>
		                                       			
					                                    	</c:if>
					                                    		
		                                       			</c:forEach>
		                                       		</c:if>
                                    </select>
                                 </div>
                              </div>   
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution City <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">                                   
                                     <select name="institutionCity" id="geographicallocationcity" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                      <c:if test="${!empty geographicallocationCityList}">
		                                       			<c:forEach items="${geographicallocationCityList}" var="cityList">
		                                       					<c:if test="${institutionDetails.getInstitutionCity()==cityList.getName()}">
		                                       			<option id="${cityList.getName()}" value="${cityList.getName()}" selected>${cityList.getName()}</option>
		     
					                                    	</c:if>
					                                    	
		                                       			</c:forEach>
		                                       		</c:if>
                                     </select>
                                 </div>
</div> 									
                                                       <div class="form-group">
                                                    	<label class="col-sm-3 control-label " for="institutionCurrencyCode">Institution Currency Code <span class="at-required-highlight">*</span></label>
                                                		    <div class="col-sm-7">
                                                     		<select name="institutionCurrencyCode" id="institutionCurrency" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
					                                      
					                                       <c:if test="${!empty currencyList}">
					                                          <c:forEach items="${currencyList}" var="currency">
					                                         	<c:if test="${institutionDetails.getCurrencyCode()==currency.getIsoCode()}">
		                                       			   <option  value="${currency.getIsoCode()}" selected>${currency.getIsoCode()}</option>
					                                    	 </c:if>
					                                    	 	<c:if test="${institutionDetails.getCurrencyCode()!=currency.getIsoCode()}">
		                                       			   <option  value="${currency.getIsoCode()}">${currency.getIsoCode()}</option>
					                                    	 </c:if>
					                                          </c:forEach>
					                                       </c:if>
                                    					</select>
                                    					 </div>
													</div>
             											
             																				      <div class="form-group">
                                                    <label class="col-sm-3 control-label " for="institutionPostCode">Institution Post Code <span class="at-required-highlight">*</span></label>
                                                    <div class="col-sm-7">
                                                        <input id="institutionPostCode" name="institutionPostCode" type="text" class="form-control" onkeypress="return isNumber(event)" maxlength="6"  value="${institutionDetails.getInstitutionPostcode()}">

                                                    </div>
                                                </div>
             										
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Institution Status<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="institutionStatus" id="institutionStatus" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Status</option>
                 	 <c:if test="${institutionDetails.getInstitutionStatus()==1}"><option value="1" selected>Active</option><option value="0">Inactive</option></c:if> 
                      <c:if test="${institutionDetails.getInstitutionStatus()==0}"> <option value="1">Active</option><option value="0" selected>Inactive</option></c:if> 
                                    </select>
                                 </div>
                              </div>	
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Collect Receipts InOrder<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7">
                                    <select name="collectReceiptsInOrder" id="collectReceiptsInOrder" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Collect Receipts InOrder</option>
                                        <c:if test="${institutionDetails.isCollectReceiptsInOrder()==true}"><option value="1" selected>Yes</option><option value="0">No</option></c:if> 
                      <c:if test="${institutionDetails.isCollectReceiptsInOrder()==false}"> <option value="1">Yes</option><option value="0" selected>No</option></c:if> 
                    
                                      </select>
                                 </div>
                              </div>
											<input id="updateInstitutionId" name="updateInstitutionId" type="hidden">
                                 <security:authorize access="hasRole('editinstitution/update')">
                             
                          <div class="row">
                             
                                <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                               <a href="#" id="updateinstitution" style="float:right" class="btn btn-success btn-custom waves-effect waves-light" type="button" data-id="${institutionDetails.getInstitutionId()}" >
                                    				Update
                                    			</a>    
                                     <button style="float:right" type="button" onclick="location.reload();" class="btn btn-danger btn-custom waves-effect waves-light">Cancel</button>
                                                          </div>
                                                       </div>
                                                          </security:authorize>
                              
                                 </c:if>
                                   
                        </form>
                   </div>
                   </div>
                   </div>
                   </div>
                   
                  </div>
                  
                  </security:authorize>
                  
               </div>
            </div>
        </div>
 
       
       
       
       
       
                <div class="modal fade" id="institutionupdateconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
               <div class="modal-dialog" role="document">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                     </div>
                     <div class="modal-body">
                        <h5>Are you sure ? You are about to update institution ??</h5>
                     </div>
                     <div class="modal-footer">
                        <button type="button" id="institutionupdateconfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                     </div>
                  </div>
               </div>
            </div>
           
         </div>
		</div>
		
	</div>
	</div>
	
	
 <script> 
         $(document).ready(function() {
                 $("#institutionProfilePic").on('change', function() {
                   //Get count of selected files
                   var countFiles = $(this)[0].files.length;
                   var imgPath = $(this)[0].value;
                  
                   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
                   var image_holder = $("#image-holder2");
                   
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
                     }  else {
                  	   $('#institutionProfilePic').filestyle('clear');
                       // alert("This browser does not support FileReader.");
                        edumaatAlert({
              			  title: "Info !",
              			  text: "This browser does not support FileReader!",
              			  type: "info",
              			  confirmButtonText: "Cool"
              			});
                      }
                    } else {
                 	 
                 	 $('#institutionProfilePic').filestyle('clear');
                    //  alert("Please select only images");
                      edumaatAlert({
            			  title: "Info !",
            			  text: "Please select only images!",
            			  type: "info",
            			  confirmButtonText: "Cool"
            			});
                    }
                 });
               });
      </script>
       <script> 
         $(document).ready(function() {
                 $("#institutionAuthorizedSignaturePic").on('change', function() {
                   //Get count of selected files
                   var countFiles = $(this)[0].files.length;
                   var imgPath = $(this)[0].value;
                  
                   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
                   var image_holder = $("#image-aaholder1");
                   
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
                     }  else {
                  	   $('#institutionAuthorizedSignaturePic').filestyle('clear');
                       // alert("This browser does not support FileReader.");
                        edumaatAlert({
              			  title: "Info !",
              			  text: "This browser does not support FileReader!",
              			  type: "info",
              			  confirmButtonText: "Cool"
              			});
                      }
                    } else {
                 	 
                 	 $('#institutionAuthorizedSignaturePic').filestyle('clear');
                    //  alert("Please select only images");
                      edumaatAlert({
            			  title: "Info !",
            			  text: "Please select only images!",
            			  type: "info",
            			  confirmButtonText: "Cool"
            			});
                    }
                 });
               });
      </script>
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
          

<script src="${pageContext.request.contextPath}/resources/themes/script/editinstitution.js" type="text/javascript"></script> 

</body>
</html>