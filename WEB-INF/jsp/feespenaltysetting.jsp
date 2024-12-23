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
        
         <style>
     #privileges { 
    list-style: none;
    margin:0; 
    }  
#privileges li {

   vertical-align: top;
    display: inline-block; }
#privileges li img { width: 60px; }
       </style>
        
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
      <div class="loader"  style="display: none"></div>
        
               <div id="ListDiv" style="display:block;">
               
                        <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-warning">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Penalty Setting Details</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="addfeespenaltysettingdetailsform" action="${pageContext.request.contextPath}/feesStructure/feespenaltysetting/add" method="post">
                             
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
                                 <label for="" class="col-sm-3 control-label">Due Days From Invoice Generated Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="duedays" class="form-control" id="duedays" placeholder="" required="required" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Penalty Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="penaltycategoryid" id="penaltycategoryid"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Penalty Category</option>
                                         <option value="perday">Per Day</option>
                                          <option value="annual">Annual</option>
                                     </select>
                                 </div>
                              </div>
                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Penalty Type<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="penaltytypeid" id="penaltytypeid"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Penalty Type</option>
                                         <option value="percentage">Percentage</option>
                                          <option value="amount">Amount</option>
                                     </select>
                                 </div>
                              </div>
                           
                            <div class="form-group form-group-percentage" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Percentage<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <input type="text" id="percentage" onchange="handleChange(this);" name="percentage" class="form-control" required="required" onkeypress="return decimalAmount(this, event, 2)">
                                 </div>
                              </div>
                          
                           <div class="form-group form-group-amount" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Amount<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <input type="text" id="amount" name="amount" class="form-control" required="required" onkeypress="return decimalAmount(this, event, 2)">
                                 </div>
                              </div>
                              
                       
                        
                              <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                  <button style="float:right" type="button" id="savefeespenaltysettingdetails"  class="btn btn-success btn-custom waves-effect waves-light">Save Penalty Setting</button>
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
                 
                 
                     	
         <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Penalty Setting Details</b></h4>
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
                                          <th>S.No.</th>
                                           <th>Penalty Criteria</th>
                                          <th>Due Days From Invoice Generated Date</th>
                                            <th>Penalty Category</th>
                                            <th>Penalty Type</th>
                                  	<th>Action</th>
                                  	    </tr>
                                    </thead>
                                    <tbody id="feesPenaltySettingList">
                                       <c:if test="${!empty feesPenaltySettingList}">
                                       <c:set var="sno" value="1"/>	
                                          <c:forEach items="${feesPenaltySettingList}" var="feesPenaltySetting">
                                             <tr>
                                                <td>${sno}</td>
                                                 <c:if test="${feesPenaltySetting.getFeesPenaltySettingType()=='fees'}">
                                                  <td><span class="label label-table label-info">Fees</span></td>
                                                 </c:if>
                                                  <c:if test="${feesPenaltySetting.getFeesPenaltySettingType()=='library'}">
                                                  <td><span class="label label-table label-pink">Library</span></td>
                                                 </c:if>
                                                  <c:if test="${feesPenaltySetting.getFeesPenaltySettingType()=='inventory'}">
                                                  <td><span class="label label-table label-success">Inventory</span></td>
                                                 </c:if>
                                                  <c:if test="${feesPenaltySetting.getFeesPenaltySettingType()=='transport'}">
                                                  <td><span class="label label-table label-warning">Transport</span></td>
                                                 </c:if>
                                                  <c:if test="${feesPenaltySetting.getFeesPenaltySettingType()=='hostel'}">
                                                  <td><span class="label label-table label-primary">Hostel</span></td>
                                                 </c:if>
                                                <td>${feesPenaltySetting.getDueDays()}</td>
                                                 <c:if test="${feesPenaltySetting.getPenaltyCategory()=='perday'}">
                                               <td>Per Day</td>
                                               </c:if>
                                                <c:if test="${feesPenaltySetting.getPenaltyCategory()=='annual'}">
                                               <td>Annual</td>
                                               </c:if>
                                                <c:if test="${feesPenaltySetting.getPenaltyType()=='amount'}">
                                                  <td>Amount</td>
                                                </c:if>
                                                 <c:if test="${feesPenaltySetting.getPenaltyType()=='percentage'}">
                                                  <td>Percentage</td>
                                                </c:if>
                                                <td>
                                                   <a href="#" id="edit"  type="button"data-href="#" data-id="${feesPenaltySetting.getFeesPenaltySettingId()}" data-toggle="modal" onclick="showmultieditDiv()">
                                                    <i class="fa fa-pencil" style="margin-right: 15px"></i>
                                                   </a>
                                                   <a href="#"  id="delete"  type="button" data-href="#"  data-id="${feesPenaltySetting.getFeesPenaltySettingId()}" data-toggle="modal" data-target="#deletefeespenaltysettingdetailsconfirmation">
                                                  <i class="fa fa-trash-o"></i>
                                                   </a>
                                                </td>
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
                <div class="modal fade" id="deletefeespenaltysettingdetailsconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                           <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                 <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                                 </div>
                                 <div class="modal-body">
                                    <h5>Are you sure you want to delete this Penalty Setting Detail ?</h5>
                                 </div>
                                  <div class="modal-footer">
                                 <form id="deletefeespenaltysettingdetailsForm" action="${pageContext.request.contextPath}/feesStructure/feesPenaltySetting/delete" method="post">
                              <input type="hidden" id="deletefeespenaltysettingId" name="deletefeespenaltysettingId">
                              <button type="button" id="confirmdeletefeespenaltysettingdetails"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                           </div>
                              </div>
                           </div>
                        </div>
             
              
               <div id="multiEditFormDiv" style="display:none;">
                           <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-primary">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Edit Penalty Setting Detail</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="updatefeespenaltysettingdetailsform" action="${pageContext.request.contextPath}/feesStructure/feesPenaltySetting/update" method="post">
                  <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Penalty Criteria<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="editpenaltycriteriaid" id="editpenaltycriteriaid"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
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
                                 <label for="" class="col-sm-3 control-label">Due Days From Invoice Generated Date<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editduedays" class="form-control" id="editduedays" placeholder="" required="required" onkeypress="return isNumber(event)">
                                 </div>
                              </div>
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Penalty Category<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="editpenaltycategoryid" id="editpenaltycategoryid"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Penalty Category</option>
                                         <option value="perday">Per Day</option>
                                          <option value="annual">Annual</option>
                                     </select>
                                 </div>
                              </div>
                      <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Select Penalty Type<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="editpenaltytypeid" id="editpenaltytypeid"  class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                       <option value="" disabled selected>Select Penalty Type</option>
                                         <option value="percentage">Percentage</option>
                                          <option value="amount">Amount</option>
                                     </select>
                                 </div>
                              </div>
                           
                            <div class="form-group form-group-edit-percentage" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Percentage<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <input type="text" id="editpercentage" onchange="handleChange(this);" name="editpercentage" class="form-control" required="required" onkeypress="return decimalAmount(this, event, 2)">
                                 </div>
                              </div>
                          
                           <div class="form-group form-group-edit-amount" style="display: none;">
                                 <label for="" class="col-sm-3 control-label">Amount<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <input type="text" id="editamount" name="editamount" class="form-control" required="required" onkeypress="return decimalAmount(this, event, 2)">
                                 </div>
                              </div>
                              
                              <input type="hidden" id="updateFeesPenaltySettingId" name="updateFeesPenaltySettingId">
                              <div class="row">
                                 <div class="col-sm-offset-3">
                                   <a href="#" id="updatefeespenaltysettingdetails" style="float:right" class="btn btn-success btn-custom waves-effect waves-light" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>   
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
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
                <div class="modal fade" id="feespenaltydetailssaveconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="exampleModalLabelEdit">Confirmation?</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure you want to save this Penalty Details ?</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="feespenaltydetailssaveconfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                     </div>
                  </div>
                <div class="modal fade" id="feespenaltysettingdetailsupdateconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabeledit2">Confirmation?</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure you want to update this Penalty Setting Detail ?</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="feespenaltysettingdetailsupdateconfirm" id="feespenaltysettingdetailsupdateconfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
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
         
      <script src="${pageContext.request.contextPath}/resources/themes/script/feespenaltysetting.js" type="text/javascript"></script>
    
   </body>
</html>

