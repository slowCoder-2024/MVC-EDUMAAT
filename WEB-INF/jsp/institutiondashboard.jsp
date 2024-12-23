

<!DOCTYPE html>
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
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/script/dashboard.js"></script>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/assets/plugins/morris/morris.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/assets/plugins/chartist/css/chartist.min.css">
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/c3/c3.min.css" rel="stylesheet" type="text/css"  />
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
      <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/timepicker/bootstrap-timepicker.min.css" rel="stylesheet">
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet">
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/clockpicker/css/bootstrap-clockpicker.min.css" rel="stylesheet">
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
      <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/css/monthly.css" type="text/css" />
      <script src="${pageContext.request.contextPath}/resources/themes/js/monthly.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/jquery.mtz.monthpicker.js"></script>
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css"/>
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css"/>
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css"/>
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css"/>
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.colVis.css" rel="stylesheet" type="text/css"/>
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/datatables/fixedColumns.dataTables.min.css" rel="stylesheet" type="text/css"/>
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/hopscotch/css/hopscotch.min.css" rel="stylesheet" type="text/css" />
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-circliful/css/jquery.circliful.css" rel="stylesheet" type="text/css" />
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/animationeffect/css/component.css" />
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
         .splitflap {
         margin: 0 auto;
         -webkit-perspective-origin: top center;
         -moz-perspective-origin: top center;
         -ms-perspective-origin: top center;
         perspective-origin: top center;
         -webkit-perspective: 900px;
         -moz-perspective: 900px;
         -ms-perspective: 900px;
         perspective: 900px;
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
      <!-- Begin page -->
      <div id="wrapper">
         <%@ include file="master_header.jsp" %>
         <%@ include file="master_menu.jsp" %>
         <div class="content-page">
            <!-- Start content -->
            <div class="content">
               <div class="container">
                  <div class="loader"  style="display: none"></div>
                <div class="row">
                  <c:if test="${!empty institutionList}">
                <c:forEach items="${institutionList}" var="institutionList">
                
                   <c:if test="${institutionList.getInstitutionId()!=institutionId}">
                      <div class="col-lg-12">
                           <div class="card-box" style="height: 250px">
                              <h4 class="m-t-0 m-b-35 header-title"><b>${institutionList.getInstitutionName()}</b>    </h4>
                              <div class="form-horizontal" id="specialCategoryDiv" style="display:block;">
                              <br/>
                              <br/>
                               <div class="col-lg-4 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="location.href='<c:url value='/staff/charts/${institutionList.getInstitutionId()}'/>';" >
                                    <i class="md  md-mode-edit text-primary"></i>
                                    <h4 class="m-0 text-dark counter font-600">FEES</h4>
                                    <div class="text-muted m-t-5">View Report</div>
                                  
                                </div>
                            </div>
                        <%--     <div class="col-lg-4 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="location.href='<c:url value='/staff/inventorycharts/${institutionList.getInstitutionId()}'/>';" >
                                    <i class="ion ion-ios7-cog  text-pink"></i>
                                    <h4 class="m-0 text-dark counter font-600">INVENTORY</h4>
                                    <div class="text-muted m-t-5">View Report</div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-sm-6">
                                <div class="widget-panel widget-style-2 bg-white" onclick="location.href='<c:url value='/dashboard/todayattendance/${institutionList.getInstitutionId()}'/>';">
                                    <i class="md  md-face-unlock text-info"></i>
                                    <h4 class="m-0 text-dark counter font-600">ATTENDANCE</h4>
                                    <div class="text-muted m-t-5">View Report</div>
                                </div>
                            </div> --%>
                          
                              
                              </div>
                            </div>
                        </div>
                        </c:if>
                        
                  </c:forEach>
     			 </c:if>
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
      <script src="${pageContext.request.contextPath}/resources/themes/script/institutiondashboard.js"></script>
      <script type="text/javascript">
         TableManageButtons.init();
         
      </script>
 
   </body>
</html>

