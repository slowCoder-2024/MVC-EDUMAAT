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
         <script src="${pageContext.request.contextPath}/resources/themes/js/resetselect.js"></script> 
<%--       <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/jquery.form-advanced.init.js"></script> --%>
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.11.2.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.7.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
      
      
      
        <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.colVis.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/fixedColumns.dataTables.min.css" rel="stylesheet" type="text/css"/>
    
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
      
      
      </style>
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/edumaatalert/edumaatalert.css"/>
              
      
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
          
		<fieldset class="form-three widget-shadow" id="criteriaForm">
		       <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                               <h2 class="panel-title">
                             Generate Invoices
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 
						<div class="panel-body">
		   <form class="form-horizontal" id="studentDetailsForm">
                                  <div class="form-group form-group-groupcriteria" style="display: block">
                                 <div class="form-group">
                                 <label for="" class="col-sm-3 control-label"> Class<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="class" id="class" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                  <option value="" disabled selected>Select Class</option>
                                  
                                  <c:if test="${!empty classes}">
                                  		<option value="all">All</option>
                                       <c:forEach items="${classes}" var="clazz">
                                       		<option value="${clazz.getClassId()}">${clazz.getClassName()}(${clazz.getInstitution().getInstitutionCode()})</option>
                                       </c:forEach>
                                   </c:if>
                                    </select>
                                 </div>
                               
                              </div>
                             
                              <div class="form-group form-group-section" style="display: none">
                                 <label for="" class="col-sm-3 control-label"> Section <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="section" id="section" class="selectpicker" multiple data-style="btn-white"  data-live-search="true" required="required">
                                            <option value="" disabled selected>Select Class First</option>
                                   </select>
                                 </div>
                              </div>
                              
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Criteria<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="criteria" id="criteria" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                            <option value="" disabled selected>Select Category</option>
                                            <option value="all">All</option>
                                            	
                                             <option value="specialcategory">Special Category</option>
                                          </select>
                                    
                                 </div>
                              </div>
                              
                              <div class="form-group form-group-special-category "style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Special Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <select name="specialCategoryId" id="specialCategoryId" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                  	<c:if test="${!empty specialCategories}">
                                  		 <option value="" disabled selected>Select Special Category</option>
                                      		 <c:forEach items="${specialCategories}" var="specialCategory">
                                      			 <option value="${specialCategory.getSpecialCategoryId()}">${specialCategory.getSpecialCategoryName()}</option>
                                            </c:forEach>
                                      </c:if>
                                    </select>
                                    
                                 </div>
                              </div>
                              </div>
                                <div class="form-group form-group-studentid" style="display:block;">
                                 <label for="" class="col-sm-3 control-label">Admission No (Unique Student Id)<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                  <input type="text" id="admissionNo" name="admissionNo" class="form-control" required="required"/>
                                 </div>
                              </div>
                             
                                <div class="row">
                                 <div class="col-sm-offset-3">
                                   <button style="float:right" type="submit"  id="getdetailsfromselectedcriteria" class="btn btn-success btn-custom waves-effect waves-light">Get Student List</button>
                             <!--     <button style="float:right; margin-right: 20px " type="button" class="btn btn-danger" onclick="location.reload(true)">Back</button>
                               -->    
                                 <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                 
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
               
               </fieldset>
               
                 <fieldset id="invoicedetailsdiv" style="display:none;">
                   <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel ">
                              <div class="panel-heading">
                                <h2 class="panel-heading m-t-0 header-title" style="color:purple;">
						  Select Student(s) to Generate Invoices
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						
						<div class="panel-body">
                   
                    
                    
                    <form class="form-horizontal" id="applyfeestructureform">
                      
                             <table class="table table-bordered table-striped toggle-circle m-b-0" id="invoiceList">
                              <thead>
                                 <tr>
                                 <th><div class="checkbox checkbox-primary"> <input name="select_all" value="1" id="example-select-all" type="checkbox"/> <label for="example-select-all"></label></div>
                                   </th>
                                    <th>Admission No</th>
                                  	<th>Student Name</th>
                                   	<th>Class/Section</th>
                               	   </tr>
                              </thead>
                           </table>
                     
                         <!--  <input id="selectedStudentIds" name="selectedStudentIds" type="hidden"> -->
             					 <div class="row">
                                 		<div class="col-sm-offset-3">
                                            <button style="float:right" type="button" id="createTermFees" class="btn btn-danger btn-custom waves-effect waves-light">Next</button>
									   </div>
                              </div>
                        </form>  
                       </div></div></div></div></div>
                       </div>
                       </div>
                        
       </fieldset>  
       
       <fieldset id="termFeesSetup" style="display:none;">
               <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						  <!-- <h4 class="panel-title">
		           </h4>
					 -->	<div class="panel-body">
                   	 <form class="form-horizontal" id="applyTermFeesform" action="${pageContext.request.contextPath}/invoice/generate" method="post">
        		   
        		     <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Penalty Criteria<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="penaltycriteriaid" id="penaltycriteriaid"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Penalty Criteria</option>
                                       <option value="fees">Fees</option>
                                       <option value="library">Library</option>
                                       <option value="inventory">Inventory</option>
                                       <option value="transport">Transport</option>
                                         <option value="hostel">Hostel</option>
                                     </select>
                                 </div>
                              </div>
        		   
        		   	 <div class="form-group">
                              <label for="" class="col-sm-3 control-label">Fees Category<span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-7">
                                 <select name="feesTermId" multiple id="feesTerms" data-live-search="true"  class="selectpicker" data-style="btn-white" required="required">
										 <c:if test="${!empty feesTerms}">
		                                       	<c:forEach items="${feesTerms}" var="feesTerm">
		                                       		<option value="${feesTerm.getFeesTermId()}">${feesTerm.getFeesTermName()}</option>
		                                       	</c:forEach>
		                                  </c:if>
								</select>
								<span id="errorprivilegeId" class="error"></span>
                                
                              </div>
                           </div>
                           
                        <br>
                           
                         <input id="selectedStudentIds" name="selectedStudentIds" type="hidden">
                            <input id="selectedFeesStructureDetails" name="selectedFeesStructureDetails" type="hidden">
                         <div class="row">
                               <div class="col-sm-offset-3">
                                  <button style="float:right" type="button" onclick="location.reload();" class="btn btn-success btn-custom waves-effect waves-light">Cancel</button>						      </div>
                          </div>
                        <br>
	                	     <!-- Dynamically added fees category -->
                           <div id="terms" style="display: none">
                           
                             <table class="table table-bordered table-striped toggle-circle m-b-0" id="termsList">
                              <thead>
                                 <tr>
                                 <th>Fees Category Id</th>
                                   <th>Fees Category</th>
                                  	<th>Fees Structure</th>
                                  	<th>Fees Item</th>
                                    </tr>
                              </thead>
                                <tbody id="termsValues">
                                           
									</tbody>
                              </table>
                       
             					<div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right" type="button" id="generatecharges" class="btn btn-info btn-custom waves-effect waves-light">Generate Fees</button>
								 </div>
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
                        
       			</fieldset>
       
       
      
</div>
         </div>
		</div>
		
	</div>
		</div>
	
      <script>
         var resizefunc = [];
      </script>
      <!-- jQuery  -->
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/edumaatalert/edumaatalert.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/bootstrap.min.js"></script> 
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/detect.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/fastclick.js"></script>
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
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/multiselect/js/jquery.multi-select.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-quicksearch/jquery.quicksearch.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/select2/js/select2.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-select/js/bootstrap-select.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-filestyle/js/bootstrap-filestyle.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-touchspin/js/jquery.bootstrap-touchspin.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-maxlength/bootstrap-maxlength.min.js" type="text/javascript"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.mockjax.js"></script>
<%--       <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.autocomplete.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/countries.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/autocomplete.js"></script> --%>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.core.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.app.js"></script>
       <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-validation/js/jquery.validate.min.js"></script>
      
<script src="${pageContext.request.contextPath}/resources/themes/script/generatecharges.js"></script>

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



</body>
</html>