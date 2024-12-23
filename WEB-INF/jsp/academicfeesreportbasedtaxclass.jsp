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
	
			<c:if test="${!empty currencycode}">
		<input id="currecyCodeData" type="hidden" value="${currencycode}">
        </c:if>
       
		 <div id="ListDiv" style="display:block;">	
      <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                              <h2 class="panel-title">
				Academic Year Total Fees Report
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 
						<div class="panel-body">
               <form class="form-horizontal" id="dateDetailForm" action="${pageContext.request.contextPath}/report/accountingfeesreportlist" method="post">
             		           <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Academic Year<span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                   <select name="category" id="category" class="selectpicker" data-style="btn-white"  data-live-search="true" required="required">
                                                <option value="" disabled selected>Select Academic Year</option>
                                                  <option value="0">All</option>
                                           		 <c:if test="${!empty academicYears}">
		                                       			<c:forEach items="${academicYears}" var="academicYear">
		                                       				<option value="${academicYear.getAcademicYearId()}">${academicYear.getAcademicYearTitle()}</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                </select>
                                         
                                  </div>
                              </div>
                               <div class="col-sm-offset-3">
                                 <button style="float:right"  type="button" id="getLedgerList" class="btn btn-success btn-custom waves-effect waves-light">Get List</button>
                               </div>
                               </form>
                               </div>
                               </div>
                               </div></div></div>
                               </div>
                               </div>
               <!--                          <div class="row">
                        	
		                    
                            <div class="col-lg-12">
		                        <div class="portlet">/primary heading
		                            <div class="portlet-heading">
		                                <h3 class="portlet-title text-dark">
		                                    (Default) Current Academic Year Fees Report
		                                </h3>
		                                <div class="portlet-widgets">
		                                    <a href="javascript:;" data-toggle="reload"><i class="ion-refresh"></i></a>
		                                    <span class="divider"></span>
		                                    <a data-toggle="collapse" data-parent="#accordion1" href="#portlet7"><i class="ion-minus-round"></i></a>
		                                    <span class="divider"></span>
		                                    <a href="#" data-toggle="remove"><i class="ion-close-round"></i></a>
		                                </div>
		                                <div class="clearfix"></div>
		                            </div>
		                            <div id="portlet7" class="panel-collapse collapse in">
		                                <div class="portlet-body">
		                                    <div id="ordered-bars-chart" style="height: 320px;">
	                                            
	                                        </div>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
                            
                        </div>
                         <div class="row" style="display:hidden;">
                        	<div class="col-lg-6">
		                        <div class="portlet">/primary heading
		                            <div class="portlet-heading">
		                                <h3 class="portlet-title text-dark">
		                                    Multiple Statistics
		                                </h3>
		                                <div class="portlet-widgets">
		                                    <a href="javascript:;" data-toggle="reload"><i class="ion-refresh"></i></a>
		                                    <span class="divider"></span>
		                                    <a data-toggle="collapse" data-parent="#accordion1" href="#portlet1"><i class="ion-minus-round"></i></a>
		                                    <span class="divider"></span>
		                                    <a href="#" data-toggle="remove"><i class="ion-close-round"></i></a>
		                                </div>
		                                <div class="clearfix"></div>
		                            </div>
		                            <div id="portlet1" class="panel-collapse collapse in">
		                                <div class="portlet-body">
		                                    <div id="website-stats" style="height: 320px;" class="flot-chart"></div>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                    
		                    <div class="col-lg-6">
		                        <div class="portlet">/primary heading
		                            <div class="portlet-heading">
		                                <h3 class="portlet-title text-dark">
		                                    Realtime Statistics
		                                </h3>
		                                <div class="portlet-widgets">
		                                    <a href="javascript:;" data-toggle="reload"><i class="ion-refresh"></i></a>
		                                    <span class="divider"></span>
		                                    <a data-toggle="collapse" data-parent="#accordion1" href="#portlet2"><i class="ion-minus-round"></i></a>
		                                    <span class="divider"></span>
		                                    <a href="#" data-toggle="remove"><i class="ion-close-round"></i></a>
		                                </div>
		                                <div class="clearfix"></div>
		                            </div>
		                            <div id="portlet2" class="panel-collapse collapse in">
		                                <div class="portlet-body">
		                                    <div id="flotRealTime" style="height: 320px;" class="flot-chart"></div>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
                        </div>

                        <div class="row" style="display:hidden;">
                        	<div class="col-lg-6">
		                        <div class="portlet">/primary heading
		                            <div class="portlet-heading">
		                                <h3 class="portlet-title text-dark">
		                                    Donut Pie
		                                </h3>
		                                <div class="portlet-widgets">
		                                    <a href="javascript:;" data-toggle="reload"><i class="ion-refresh"></i></a>
		                                    <span class="divider"></span>
		                                    <a data-toggle="collapse" data-parent="#accordion1" href="#portlet3"><i class="ion-minus-round"></i></a>
		                                    <span class="divider"></span>
		                                    <a href="#" data-toggle="remove"><i class="ion-close-round"></i></a>
		                                </div>
		                                <div class="clearfix"></div>
		                            </div>
		                            <div id="portlet3" class="panel-collapse collapse in">
		                                <div class="portlet-body">
		                                    <div id="donut-chart">
	                                            <div id="donut-chart-container" class="flot-chart" style="height: 320px;">
	                                            </div>
	                                        </div>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                    
                            <div class="col-lg-6">
		                        <div class="portlet">/primary heading
		                            <div class="portlet-heading">
		                                <h3 class="portlet-title text-dark">
		                                    Pie Chart
		                                </h3>
		                                <div class="portlet-widgets">
		                                    <a href="javascript:;" data-toggle="reload"><i class="ion-refresh"></i></a>
		                                    <span class="divider"></span>
		                                    <a data-toggle="collapse" data-parent="#accordion1" href="#portlet4"><i class="ion-minus-round"></i></a>
		                                    <span class="divider"></span>
		                                    <a href="#" data-toggle="remove"><i class="ion-close-round"></i></a>
		                                </div>
		                                <div class="clearfix"></div>
		                            </div>
		                            <div id="portlet4" class="panel-collapse collapse in">
		                                <div class="portlet-body">
		                                    <div id="pie-chart">
	                                            <div id="pie-chart-container" class="flot-chart" style="height: 320px;">
	                                            </div>
	                                        </div>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
                            
                        </div>
                        
                       



                        <div class="row">
                        	<div class="col-lg-12">
		                        <div class="portlet">/primary heading
		                            <div class="portlet-heading">
		                                <h3 class="portlet-title text-dark">
		                                    Combine Statistics
		                                </h3>
		                                <div class="portlet-widgets">
		                                    <a href="javascript:;" data-toggle="reload"><i class="ion-refresh"></i></a>
		                                    <span class="divider"></span>
		                                    <a data-toggle="collapse" data-parent="#accordion1" href="#portlet5"><i class="ion-minus-round"></i></a>
		                                    <span class="divider"></span>
		                                    <a href="#" data-toggle="remove"><i class="ion-close-round"></i></a>
		                                </div>
		                                <div class="clearfix"></div>
		                            </div>
		                            <div id="portlet5" class="panel-collapse collapse in">
		                                <div class="portlet-body">
		                                    <div id="combine-chart">
	                                            <div id="combine-chart-container" class="flot-chart" style="height: 320px;">
	                                            </div>
	                                        </div>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
                         
                        </div>
                         -->
                               
                                 
               <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                               <h2 class="panel-title m-t-0 header-title" style="color:purple;">
				<!-- 	SELECT CRITERIA -->
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
                   <h3 class="title1">   <label for="default" id="default" ></label></h3>
                   <table class="table table-striped table-bordered" id="ledgerAccountHeadList">
                        <thead>
                           <tr>
                            <th>Ledger Id</th>
                              <th>Ledger Name</th>
                              <th >Total Amount(TAX Included)</th>
                                <th >Total Paid Amount</th>
                              <th >Total Discount</th>
                              <th >Total OutStanding Amount</th>
                              <th >Total Amount(Without TAX)</th>
                              <th >Total TAX Amount</th>
                              <th >Total TAX Percentage</th>
                              <th>Action</th>
                           </tr>
                        </thead>
                         <tbody>
                                   
                                 </tbody>
                                 
                     <!--   <tfoot>
            <tr>
                <th colspan="2" style="text-align:right">Totals</th>
                <th ></th>
                <th></th>
                 <th></th>
                  <th></th>
                   <th></th>
            </tr>
         
        </tfoot> -->
              <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="academicgrandtotal" style="text-align:center;border: none;"></th>
                   <th id="academicgrandpaidamount" style="text-align:center;border: none;"></th> 
                  <th id="academicgranddiscount" style="text-align:center;border: none;"></th> 
                  <th  id="academicgrandoutstanding" style="text-align:center;border: none;"></th>
                     <th  id="academicgrandtotalwithouttax" style="text-align:center;border: none;"></th>
                        <th  id="academicgrandtotaltaxamount" style="text-align:center;border: none;"></th>
                           <th  id="academicgrandtotaltaxpercentage" style="text-align:center;border: none;"></th>
                   <th  style="text-align:center;border: none;"></th>
          
                
            </tr>
               <tr style=" background-color:silver;">
            <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="academicpagetotal" style="text-align:center;border: none;"></th>
                   <th id="academicpagepaidamount" style="text-align:center;border: none;"></th> 
                  <th id="academicpagediscount" style="text-align:center;border: none;"></th> 
                  <th  id="academicpageoutstanding" style="text-align:center;border: none;"></th>
                  <th  id="academicpagetotalwithouttax" style="text-align:center;border: none;"></th>
                  <th  id="academicpagetotaltaxamount" style="text-align:center;border: none;"></th>
                  <th  id="academicpagetotaltaxpercentage" style="text-align:center;border: none;"></th>
                   <th  style="text-align:center;border: none;"></th>
        
            </tr>
         
            </tfoot>
                     </table>
                     </div>
                     </div>
                     </div>
                     </div>
                     
                  </div>
               </div>
               
             
                        <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                               <h2 class="panel-title m-t-0 header-title" style="color:purple;">
				<!-- 	SELECT CRITERIA -->
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
                   <h3 class="title1"><label for="defaultFineDetails" id="defaultFineDetails"></label></h3>
	         <table class="table table-bordered" id="fineList">
                        <thead>
                           <tr>
                           <th>Academic Year Id</th>
                           <th>Academic Year Name</th>
                                <th>Total Fine Amount</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                      <!--  <tfoot>
            <tr>
                <th colspan="2" style="text-align:right">Totals</th>
                <th ></th>
               <th></th>
            </tr>
        </tfoot> -->
            <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="academicfinegrandtotal" style="text-align:center;border: none;"></th>
                     <th  style="text-align:center;border: none;"></th>
          
                
            </tr>
               <tr style=" background-color:silver;">
            <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="academicfinepagetotal" style="text-align:center;border: none;"></th>
                 <th  style="text-align:center;border: none;"></th>
        
            </tr>
         
            </tfoot>
                     </table>
                     </div>
                     </div>
                     </div>
                     </div>
                     
                  </div>
               </div>
               
              </div>   
             <div id="listFineDetails" style="display:none;">
	  <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                              <h2 class="panel-title">
					Fine Details
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 
						<div class="panel-body"> 
             				<form class="form-horizontal">
             				
                <div class="tables">
                  <div class="table-responsive bs-example widget-shadow">
                     <table class="table table-bordered" id="fineDetails">
                        <thead>
                           <tr>
                              <th>Fine Receipt Id</th>
                                <th>Admission No</th>
                                  <th>Student Name</th>
                                  <th>Fees Category Name</th>
                              <th>Fine Amount</th>
                            </tr>
                        </thead>
                 <!--       <tfoot>
            <tr>
                <th colspan="4" style="text-align:right">Totals</th>
                <th ></th>
                
                   </tr>
        </tfoot> -->
          <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
              <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="academicfineamountgrandtotal" style="text-align:center;border: none;"></th>
                   
                
            </tr>
               <tr style=" background-color:silver;">
             <th style="border: none;"> </th>
              <th style="border: none;"> </th>
               <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="academicfineamountpagetotal" style="text-align:center;border: none;"></th>
                   </tr>
         
            </tfoot>
                     </table>
                  </div>
               </div>
	
	
	  <div class="row">
                              <div class="col-sm-offset-3">
                                  <button style="float:right" type="button" class="btn btn-info btn-custom waves-effect waves-light" onclick="showEditFineList()">Back</button>
                                  
                                 <button style="float:right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this)">Cancel</button>
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
		</div>
		
		<div id="listFeesTemplateItem" style="display:none;">
		  <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                              <h2 class="panel-title">
					Fees Item Details
		           </h2>
                                </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                 	<div class="panel-default">
						 
						<div class="panel-body">
             				<form class="form-horizontal">
                   <table class="table table-bordered" id="feesTemplateItemList">
                        <thead>
                           <tr>
                              <th>Fees Item Id</th>
                              <th>Fees Item Name</th>
                              <th>Total Amount(TAX Included)</th>
                                <th>Total Paid Amount</th>
                              <th>Total Discount</th>
                               <th >Total OutStanding Amount</th>
                                <th >Total Amount(Without TAX)</th>
                              <th >Total TAX Amount</th>
                              <th >Total TAX Percentage</th>
                            </tr>
                        </thead>
                        <!-- <tfoot>
            <tr>
                <th colspan="2" style="text-align:right">Totals</th>
                <th ></th>
                   <th ></th>
                      <th ></th>
                         <th ></th>
               
            </tr>
        </tfoot> -->
                           <tfoot >
            <tr style=" background-color: aqua;">
             <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Grand Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="feesgrandtotal" style="text-align:center;border: none;"></th>
                   <th id="feesgrandpaidamount" style="text-align:center;border: none;"></th> 
                  <th id="feesgranddiscount" style="text-align:center;border: none;"></th> 
                  <th  id="feesgrandoutstanding" style="text-align:center;border: none;"></th>
                   <th  id="feesgrandtotalwithouttax" style="text-align:center;border: none;"></th>
                        <th  id="feesgrandtotaltaxamount" style="text-align:center;border: none;"></th>
                           <th  id="feesgrandtotaltaxpercentage" style="text-align:center;border: none;"></th>
                 </tr>
               <tr style=" background-color:silver;">
            <th style="border: none;"> </th>
                   <th  style="text-align:center;border: none;">Current Page Total(<c:if test="${!empty currencycode}"><label>${currencycode}</label></c:if>)  </th>
                  <th id="feespagetotal" style="text-align:center;border: none;"></th>
                   <th id="feespagepaidamount" style="text-align:center;border: none;"></th> 
                  <th id="feespagediscount" style="text-align:center;border: none;"></th> 
                  <th  id="feespageoutstanding" style="text-align:center;border: none;"></th>
                        <th  id="feespagetotalwithouttax" style="text-align:center;border: none;"></th>
                  <th  id="feespagetotaltaxamount" style="text-align:center;border: none;"></th>
                  <th  id="feespagetotaltaxpercentage" style="text-align:center;border: none;"></th>
               </tr>
         
            </tfoot>
                     </table>
                  
	
	
	  <div class="row">
                           <!--    <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                            -->  
                             <div class="col-sm-offset-3">
                             <!--     <button style="float:right"  type="button" id="classandsectionsavebutton" class="btn btn-success">Save</button> -->
                                  <button style="float:right" type="button" class="btn btn-info btn-custom waves-effect waves-light" onclick="showeditFeesTemplateItemDiv()">Back</button>
                                  
                                 <button style="float:right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload(this)">Cancel</button>
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
		</div>
		
	

                
                        
               


                     
		</div>
		</div>
	</div>
		</div>
	 	 <script>
         var resizefunc = [];
      </script>
 
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
    <%--   <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/select2/js/select2.min.js" type="text/javascript"></script> --%>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-select/js/bootstrap-select.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-filestyle/js/bootstrap-filestyle.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-touchspin/js/jquery.bootstrap-touchspin.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-maxlength/bootstrap-maxlength.min.js" type="text/javascript"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.mockjax.js"></script>
     <%--  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.autocomplete.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/countries.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/autocomplete.js"></script> --%>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.core.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.app.js"></script>
       
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
   <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/flot-chart/jquery.flot.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/flot-chart/jquery.flot.time.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/flot-chart/jquery.flot.tooltip.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/flot-chart/jquery.flot.resize.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/flot-chart/jquery.flot.pie.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/flot-chart/jquery.flot.selection.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/flot-chart/jquery.flot.stack.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/flot-chart/jquery.flot.orderBars.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/flot-chart/jquery.flot.crosshair.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/script/dashboard/academicyearfeesreport.js"></script>
 <script src="${pageContext.request.contextPath}/resources/themes/script/academicfeesreportbasedtaxclass.js"></script>
<script type="text/javascript">
  
    TableManageButtons.init();

</script>

 
</body>
</html>