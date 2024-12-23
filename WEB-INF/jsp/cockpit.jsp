

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
                  <security:authorize access="hasAnyRole('dashboard/admin/attendancepercentage','dashboard/principal')">
                   
                     <div class="row">
                        <div class="col-lg-6">
                           <div class="card-box" style="height: 460px">
                              <h4 class="m-t-0 m-b-35 header-title"><b>Special Category Wise Student Count</b>    </h4>
                              <div class="form-horizontal" id="specialCategoryDiv" style="display:block;">
                                 <div class="form-group">
                                    <div class="col-sm-6">
                                       <select name="specialCategory" id="specialCategory" class="selectpicker"  data-live-search="true" required="required" data-style="btn-warning btn-custom">
                                          <c:if test="${!empty specialCategoryList}">
                                             <c:forEach items="${specialCategoryList}" var="specialCategory">
                                                <option  value="${specialCategory.getSpecialCategoryId()}">${specialCategory.getSpecialCategoryName()}</option>
                                             </c:forEach>
                                          </c:if>
                                       </select>
                                    </div>
                                    <div class="col-sm-6">
                                       <select id="chart-type-specialcategory" class="selectpicker" data-style="btn-primary btn-custom">
                                          <option value="donut">Donut</option>
                                          <option value="line">Line</option>
                                          <option value="pie">Pie</option>
                                          <option value="bar">Bar</option>
                                          <option value="scatter">Scatter</option>
                                       </select>
                                    </div>
                                 </div>
                              </div>
                              <div class="doughnut-grid" id="specialCategoryChart" style="display:block;">
                                 <div id="donut-chart"></div>
                              </div>
                              <div id="specialCateoryImage" style="width:400px; height: 400px;display:none;">
                                 <br><br><br>
                                 <br><br><br><br>
                                 <div class="col-sm-12 col-md-12 col-xs-8">
                                    <div class="alert alert-info" style="margin-left: 200px">
                                       <p style="text-align: center;">No Data Available</p>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-6">
                           <div class="card-box" style="height: 460px">
                              <h4 class="m-t-0 m-b-30 header-title"><b>Blood Group Wise Students</b></h4>
                              <div class="form-group">
                                 <div class="col-sm-12">
                                    <select id="chart-type-bloodG" class="selectpicker" data-style="btn-primary btn-custom">
                                       <option value="pie">Pie</option>
                                       <option value="donut">Donut</option>
                                       <option value="line">Line</option>
                                       <option value="bar">Bar</option>
                                       <option value="scatter">Scatter</option>
                                    </select>
                                 </div>
                              </div>
                              <div id="pie-chart"></div>
                           </div>
                        </div>
                     </div>
                     <div class="row">
                        <div class="col-lg-6">
                           <div class="card-box" style="height: 460px">
                              <h4 class="m-t-0 m-b-30 header-title"><b>Category Wise Student Count</b></h4>
                              <div class="form-horizontal" id="categoryDiv" style="display:block;">
                                 <div class="form-group">
                                    <div class="col-sm-6">
                                       <select name="Category" id="Category" class="selectpicker"  data-live-search="true" required="required" data-style="btn-warning btn-custom">
                                          <c:if test="${!empty categories}">
                                             <c:forEach items="${categories}" var="categories">
                                                <option  value="${categories.getCategoryId()}">${categories.getCategoryName()}</option>
                                             </c:forEach>
                                          </c:if>
                                       </select>
                                    </div>
                                    <div class="col-sm-6">
                                       <select id="chart-type-category" class="selectpicker" data-style="btn-primary btn-custom">
                                          <option value="bar">Bar</option>
                                          <option value="line">Line</option>
                                          <option value="donut">Donut</option>
                                          <option value="pie">Pie</option>
                                          <option value="scatter">Scatter</option>
                                       </select>
                                    </div>
                                 </div>
                              </div>
                              <div class="doughnut-grid" id="categoryChart" style="display:block;">
                                 <div id="donut-chart-category"></div>
                              </div>
                              <div id="cateoryImage" style="width:400px; height: 400px;display:none;">
                                 <br><br><br>
                                 <br><br><br><br>
                                 <div class="col-sm-12 col-md-12 col-xs-8">
                                    <div class="alert alert-info" style="margin-left: 200px">
                                       <p style="text-align: center;">No Data Available</p>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-6">
                           <div class="card-box" style="height: 460px">
                              <h4 class="m-t-0 header-title"><b>Class Wise Students</b></h4>
                              <div id="line-chart-tooltips" class="ct-chart ct-golden-section"></div>
                           </div>
                        </div>
                     </div>
            
                  </security:authorize>
                
                  <c:if test="${!empty student}">     
                     <input id="classId" name="classId" type="hidden" value="${student.getStudentClass().getClassId()}">
                     <input id="sectionId" name="sectionId" type="hidden" value="${student.getSection().getSectionId()}">
                  </c:if>
                  <c:if test="${!empty institution}">     
                     <input id="institutionId" name="institutionId" type="hidden" value="${institution.getInstitutionId()}">
                   </c:if>
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
      <script src="${pageContext.request.contextPath}/resources/themes/script/cockpit.js"></script>
      <script type="text/javascript">
         TableManageButtons.init();
         
      </script>
      <!-- EASY PIE CHART JS -->
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery.easy-pie-chart/dist/easypiechart.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery.easy-pie-chart/dist/jquery.easypiechart.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/pages/easy-pie-chart.init.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-knob/jquery.knob.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/hopscotch/js/hopscotch.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/jquery-circliful/js/jquery.circliful.min.js"></script>
      <%--    <script src="${pageContext.request.contextPath}/resources/themes/animationeffect/js/jquery.splitflap.js"></script> --%>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/chartist/js/chartist.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/chartist/js/chartist-plugin-tooltip.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/jquery.chartist.init.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/d3/d3.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/c3/c3.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/pages/jquery.c3-chart.init.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/morris/morris.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/raphael/raphael-min.js"></script>
<%--       <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/morris.init.js"></script> --%>
  <%--  <script src="${pageContext.request.contextPath}/resources/themes/script/cockpitmorris.js"></script> --%>
   </body>
</html>

