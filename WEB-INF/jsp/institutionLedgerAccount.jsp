

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
		
	  <style type="text/css">
         .thumb-image {
         width:250px;
         height:250px;
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
            }
            else
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
                 <div class="loader" style="display: none"></div>
                  <div id="ListDiv" style="display:block;">
                     <div class="form-group">
                        <div class="col-md-4 col-sm-4 col-xs-12"> 
                           <button type="button" class="btn btn-primary btn-custom waves-effect waves-light" onclick="showDiv()"> Add New Ledger Head</button>
                        </div>
                     </div>
                     <br>
                     <br><br>
                     <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>Ledger Accounts</b></h4>
                              <table data-toggle="table"
                                 data-show-columns="true"
                                 data-page-list="[5, 10, 20]"
                                 data-page-size="5"
                                 data-search="true"
										   data-show-refresh="true"
										   data-show-toggle="true"
										   data-show-columns="true"
                                 data-pagination="true" data-show-pagination-switch="true" class="table-bordered ">
                                 <thead>
                                    <tr>
                                       <th data-field="Ledger_Head_Name" data-switchable="false">Ledger Head Name</th>
                                       <th data-field="Account_Reference">Account Reference</th>
                                       <th data-field="Action">Action</th>
                                    </tr>
                                 </thead>
                                 <tbody id="ledgerAccountList">
                             
                                   <c:if test="${!empty institutionAccountsList}">
                                 <c:forEach items="${institutionAccountsList}" var="institutionAccount">
                                    <tr >
                                       <td>${institutionAccount.getLedgerAccountName()}</td>
                                       <td>${institutionAccount.getLedgerReferenceNo()}</td>
                                       <td>
                                          <a href="#" id="edit"  type="button"data-href="#" data-id="${institutionAccount.getLedgerAccountId()}" data-toggle="modal" onclick="showeditDiv()" class="on-default edit-row"><i class="fa fa-pencil" style="margin-right: 15px"></i>
                                           
                                          </a>
                                          <a href="#" class="test" id="delete"  type="button" data-href="#"  data-id="${institutionAccount.getLedgerAccountId()}" data-toggle="modal" data-target="#confirm-delete" class="on-default remove-row"><i class="fa fa-trash-o"></i>
                                       
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
                  <div id="confirm-delete" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="custom-width-modalLabel" aria-hidden="true" style="display: none;"data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                              <h4 class="modal-title" >Confirmation?</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure, You want to delete this Ledger ?</h5>
                           </div>
                           <div class="modal-footer">
                              <form id="deleteLedgerForm" action="${pageContext.request.contextPath}/institution/ledgerAccount/delete" method="post">
                                 <input type="hidden" id="deleteLedgerId" name="deleteLedgerId">
                                 <button type="button" id="confirmDeleteLedger" class="btn btn-primary waves-effect waves-light" data-dismiss="modal">Yes</button>
                              </form>
                           </div>
                        </div>
                        <!-- /.modal-content -->
                     </div>
                     <!-- /.modal-dialog -->
                  </div>
                  <!-- /.modal -->     
                  <div id="updateConfirmation" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="custom-width-modalLabel" aria-hidden="true" style="display: none;"data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                              <h4 class="modal-title" >Confirmation?</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure, You want to update ledger head ?</h5>
                           </div>
                           <div class="modal-footer">
                              
                                 
                                 <button type="button" id="updateConfirm"  name="updateConfirm" class="btn btn-primary waves-effect waves-light" data-dismiss="modal">Yes</button>
                             
                           </div>
                        </div>
                        <!-- /.modal-content -->
                     </div>
                     <!-- /.modal-dialog -->
                  </div>
                  <!-- /.modal -->
                  <div id="FormDiv" style="display:none;">
                     <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Create New Ledger Head</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                    <form class="form-horizontal" action="${pageContext.request.contextPath}/institution/ledgerAccount/add" method="post" id="ledgerAccountform">
                                       <div class="form-group">
                                          <label for="ledgerAccountName" class="col-sm-3 control-label">Ledger Head Name*</label>
                                          <div class="col-sm-7">
                                             <input type="text" required class="form-control" id="ledgerAccountName" name="ledgerAccountName"  maxlength="100">
                                             
                                          </div>
                                       </div>
                                         <div class="form-group">
                                          <label for="ledgerAccountReferenceNo" class="col-sm-3 control-label">Ledger Head Reference(Unique)*</label>
                                          <div class="col-sm-7">
                                             <input type="text" required class="form-control" id="ledgerAccountReferenceNo" name="ledgerAccountReferenceNo"  maxlength="100">
                                             
                                          </div>
                                       </div>
                                     
                                       <div class="form-group">
                                        
                                          <div class="col-sm-offset-4 col-sm-8">
                                             <button style="float:right"  type="button" id="ledgerAccountSave" class="btn btn-primary btn-custom waves-effect waves-light ">Save</button>
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
                  <div id="ledgerAccountSaveConfirmation" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="custom-width-modalLabel" aria-hidden="true" style="display: none;"data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                              <h4 class="modal-title" >Confirmation?</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure, You want to create new ledger head ?</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="ledgerAccountSaveConfirm" class="btn btn-primary waves-effect waves-light" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                        <!-- /.modal-content -->
                     </div>
                     <!-- /.modal-dialog -->
                  </div>
                  <!-- /.modal -->
         
                <div id="EditFormDiv" style="display:none;">
                     <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Edit Ledger Account</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                                    <form class="form-horizontal" action="${pageContext.request.contextPath}/institution/ledgerAccount/editUpdate" method="post" id="updateLedgerAccountForm">
                                       <div class="form-group">
                                          <label for="editSpecialCategoryName" class="col-sm-3 control-label">Ledger Head Name*</label>
                                          <div class="col-sm-7">
                                             <input type="text" required="required" class="form-control" id="editLedgerAccountName" name="editLedgerAccountName"  maxlength="100">
                                           
                                          </div>
                                       </div>
                                   <div class="form-group">
                                          <label for="editLedgerAccountReferenceNo" class="col-sm-3 control-label">Ledger Head Reference(Unique)*</label>
                                          <div class="col-sm-7">
                                             <input type="text" required class="form-control" id="editLedgerAccountReferenceNo" name="editLedgerAccountReferenceNo"  maxlength="100">
                                             
                                          </div>
                                       </div>
                                       <div class="form-group">
                                        <input type="hidden" id="updateLedgerId" name="updateLedgerId">
                                          <div class="col-sm-offset-4 col-sm-8">
                                             <a href="#" id="updateLedgerAccount" style="float:right" class="btn btn-primary btn-custom waves-effect waves-light" type="button" data-id="" >
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
   
          <script src="${pageContext.request.contextPath}/resources/themes/script/institutionLedgerAccount.js" type="text/javascript"></script>


   </body>
</html>

