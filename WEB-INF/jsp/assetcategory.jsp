<!DOCTYPE HTML>
<html>
<head>    <meta charset="utf-8">
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
      
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/assets/plugins/magnific-popup/css/magnific-popup.css" />
        
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
             
               <div class="modal fade" id="deleteassetcategoryconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure you want to delete this asset category ?</h5>
                        </div>
                        <div class="modal-footer">
                           <form id="deleteassetcategoryform" action="${pageContext.request.contextPath}/asset/category/delete" method="post">
                              <input type="hidden" id="deleteAssetCategoryId" name="deleteAssetCategoryId">
                              <button type="button" id="confirmdeleteassetcategory"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="modal fade" id="assetcategoryupdateconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                  <div class="modal-dialog" role="document">
                     <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                           <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                        </div>
                        <div class="modal-body">
                           <h5>Are you sure you want to update this asset category ?</h5>
                        </div>
                        <div class="modal-footer">
                           <button type="button" name="assetCategoryUpdateConfirm" id="assetCategoryUpdateConfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                        </div>
                     </div>
                  </div>
               </div>
               <div id="FormDiv" style="display:block;" >
                  <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-primary">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Create New Asset Category</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="addassetcategoryform" action="${pageContext.request.contextPath}/asset/category/add" method="post">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Asset Category Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="assetCategoryName" class="form-control" id="assetCategoryName" placeholder="" required maxlength="100">
                                 </div>
                              </div>
                              
	                              	<div class="row">
	                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
	                                 <div class="col-sm-offset-3">
	                                 <button style="float:right"  type="button"  id="saveassetcategory" class="btn btn-default btn-custom waves-effect waves-light"><i class="fa fa-plus m-r-5"></i> Add New Asset Category</button>
	                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
	                                    <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload();">Cancel</button>
	                                 </div>
	                              </div>
                             
                           </form>
                           </div>
                           </div>
                           
                           
                          
                        </div>
                     </div>
                  </div>
                  	 <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Asset Category</b></h4>
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
                              	 <th>S.NO</th>
                                 <th>Asset Type Category</th>
                                <%--  <security:authorize access="hasAnyRole('section/view','section/delete')"> --%>
                                 	<th>Action</th>
                               <%--   </security:authorize> --%>
                              </tr>
                           </thead>
                          <tbody id="assetCategorylist">
                          
                         <c:if test="${!empty assetCategoryList}">
                              <c:set var="sno" value="1"/>
                              <c:forEach items="${assetCategoryList}" var="assetCategory">
                                <tr>
                                    <td>${sno}</td>
                                    <td>${assetCategory.getAssetCategoryName()}</td>
                                    <%-- <security:authorize access="hasAnyRole('section/view','section/delete')"> --%>
	                                    <td>
	                                  <%--   <security:authorize access="hasRole('section/view')"> --%>
	                                   		<a href="#" id="edit"  type="button"data-href="#" data-id="${assetCategory.getAssetCategoryId()}" data-toggle="modal" onclick="showEditDiv()">
	                                       	  <i class="demo-delete-row btn btn-warning btn-xs btn-icon fa fa-pencil" style="margin-right: 15px"></i>
	                                        </a>
	                                   <%--  </security:authorize>
	                                    <security:authorize access="hasRole('section/delete')"> --%>
	                                    	<a href="#"  id="delete"  type="button" data-href="#"  data-id="${assetCategory.getAssetCategoryId()}" data-toggle="modal" data-target="#deleteassetcategoryconfirmation">
	                                     <button class="demo-delete-row btn btn-danger btn-xs btn-icon fa fa-times"></button>
	                                       </a>
	                                   <%--  </security:authorize> --%>
	                                    </td>
                                	<%-- </security:authorize> --%>
                                 </tr>
                                 <c:set var="sno" value="${sno+1}"/>
                              </c:forEach>
                           </c:if> 
                          
                          </tbody>
                        </table>
                        </div>
                         </div>
                  </div>
                 
               </div>
                <div class="modal fade" id="assetcategorysaveconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure you want to add this asset category ?</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="assetcategorysaveconfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                     </div>
                  </div>
                  
               <div id="EditFormDiv" style="display:none;" >
                     <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-warning">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Edit Asset Category</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="updateAssetCategoryform" action="${pageContext.request.contextPath}/asset/category/update" method="post">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Asset Category Name<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editAssetCategoryName" class="form-control" id="editAssetCategoryName" placeholder="" required maxlength="40">
                                 </div>
                              </div>
                              <input type="hidden" id="updateAssetCategoryId" name="updateAssetCategoryId">
                            <%--   <security:authorize access="hasRole('section/update')"> --%>
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3"> 
                                    <a href="#" id="updateAssetCategory" style="float:right" class="btn btn-success btn-custom waves-effect waves-light" type="button" data-id="">
                                    Update Asset Category
                                    </a>   
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                    <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                 </div>
                              </div>
                            <%--   </security:authorize> --%>
                              
                           </form>
                           </div>
                           </div>
                           </div>
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
          
      <script src="${pageContext.request.contextPath}/resources/themes/script/assetcategory.js" type="text/javascript"></script>
    
 
	      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/magnific-popup/js/jquery.magnific-popup.min.js"></script>
	  
    
   </body>
</html>

