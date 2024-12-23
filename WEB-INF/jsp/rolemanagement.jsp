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

     #editprivileges { 
    list-style: none;
    margin:0; 
    }  
  
#editprivileges li {

   vertical-align: top;
    display: inline-block; }
#editprivileges li img { width: 60px; }
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
               <security:authorize access="hasRole('rolemanagement/add')">
               
                        <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Create User Role</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="adduserroleform" action="${pageContext.request.contextPath}/rolemanagement/add" method="post">
                              <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Role Name <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="roleName" class="form-control" id="roleName" placeholder="" required="required" maxlength="100">
                                 </div>
                              </div>
                       <div class="form-group">
                               <label for="" class="col-sm-3 control-label">Privilege - TargetType<span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-8">
                              <c:if test="${!empty privileges}">
                                    <ul id="privileges" >
                                 <li style="color:violet;font-size: 18px;padding: 3px; "> <div class="checkbox checkbox-primary"> <input name="select_all" value="1" id="example-select-all" type="checkbox"/>&nbsp;&nbsp;<label>all</label></div></li>
		                               </ul> 
		                                </c:if>
		                                </div>
                              </div>
 
		                          <div class="form-group ">
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==1}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                      <div class="form-group">
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==2}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                      <div class="form-group">
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==3}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                      <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==4}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==5}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==6}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==7}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==8}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==9}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==10}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==11}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==12}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==13}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==14}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==15}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==16}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==17}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==18}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==19}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==20}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==21}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==22}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==23}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==24}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==25}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==26}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==27}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==28}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==29}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==30}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==31}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==32}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==33}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==34}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==35}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==36}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==37}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                           <div class="row">
                                 <span style="float:left;margin-top:0px;"class="at-required-highlight">Mandatory fields are marked with an asterisk (*)</span>
                                 <div class="col-sm-offset-3">
                                   <input type="hidden" id="selectedPrivilegeId" name="selectedPrivilegeId">
                                    <button style="float: right;" type="button" id="saveuserrole"  class="btn btn-success btn-custom waves-effect waves-light">Save</button>
                                    <button style="float: right;" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                    <button style="float: right;" type="button"class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                    </div>
                              </div>
                           </form>
                        </div>
                        </div>
                        </div>
                      </div>
                  </div>
                 
               </security:authorize>  
               
               <security:authorize access="hasRole('rolemanagement/viewlist')">
                   	
         <div class="row">
                        <div class="col-sm-12">
                           <div class="card-box">
                              <h4 class="m-t-0 header-title" style="color:purple;"><b>User Role(s)</b></h4>
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
                                          <th>Sr.No.</th>
                                          <th>User Role Name(s)</th>
                                         <security:authorize access="hasAnyRole('rolemanagement/view','rolemanagement/delete')">
                                  	<th>Action</th>
                                  	</security:authorize>
                                       </tr>
                                    </thead>
                                    <tbody id="userrolelist">
                                       <c:if test="${!empty userRoles}">
                                       <c:set var="sno" value="1"/>	
                                          <c:forEach items="${userRoles}" var="userRole">
                                             <tr>
                                                <td>${sno}</td>
                                                <td>${userRole.getRoleName()}</td>
                                                 <security:authorize access="hasAnyRole('rolemanagement/view','rolemanagement/delete')">
                                                <td>
                                                 <security:authorize access="hasRole('rolemanagement/view')">
                                                   <a href="#" id="edit"  type="button"data-href="#" data-id="${userRole.getRoleId()}" data-toggle="modal" onclick="showmultieditDiv()">
                                                    <i class="fa fa-pencil" style="margin-right: 15px"></i>
                                                   </a>
                                                   </security:authorize>
                                                     <security:authorize access="hasRole('rolemanagement/delete')">
                                                   <a href="#"  id="delete"  type="button" data-href="#"  data-id="${userRole.getRoleId()}" data-toggle="modal" data-target="#deleteuserroleconfirmation">
                                                  <i class="fa fa-trash-o"></i>
                                                   </a>
                                                   </security:authorize>
                                                </td>
                                                </security:authorize>
                                             </tr>
                                              <c:set var="sno" value="${sno+1}"/>
                                          </c:forEach>
                                       </c:if>
                                    </tbody>
                                 </table>
                              </div>
                       </div>
                        </div>
                       	</security:authorize>
               </div>
                <div class="modal fade" id="deleteuserroleconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                           <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                 <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="exampleModalLabel">Confirmation?</h4>
                                 </div>
                                 <div class="modal-body">
                                    <h5>Are you sure you want to delete this user role ?</h5>
                                 </div>
                                  <div class="modal-footer">
                                 <form id="deleteUserRoleForm" action="${pageContext.request.contextPath}/rolemanagement/delete" method="post">
                              <input type="hidden" id="deleteUserRoleId" name="deleteUserRoleId">
                              <button type="button" id="confirmdeleteuserrole"  class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </form>
                           </div>
                              </div>
                           </div>
                        </div>
             
              
               <div id="multiEditFormDiv" style="display:none;">
                           <div class="row">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Edit User Role</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                           <form class="form-horizontal" id="updateuserroleform" action="${pageContext.request.contextPath}/rolemanagement/update" method="post">
                               <div class="form-group">
                                 <label for="" class="col-sm-3 control-label">Role Name <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-7"> 
                                    <input type="text" name="editRoleName" class="form-control" id="editRoleName" placeholder="" required="required" maxlength="100">
                                 </div>
                              </div>
                     <%--   <div class="form-group">
                               <label for="" class="col-sm-3 control-label">Privilege <span class="at-required-highlight">*</span></label> 
                                 <div class="col-sm-9">
                                 <ul id="editprivileges">
                                 <c:if test="${!empty privileges}">
										<li style="color:violet;font-size: 18px;padding: 3px; ">  <div class="checkbox checkbox-warning"><input name="select_all" value="1" id="editexample-select-all" type="checkbox"/>&nbsp;&nbsp;<label>all</label>
										</div></li>
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       	<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getPrivilegeName()}</label>
		                                       		  
		                                       		  </div>
		                                       		  </li>
		                                         	</c:forEach>
		                                  </c:if>
								</ul>
								
								</div>
								</div> --%>
								
								 <div class="form-group">
                               <label for="" class="col-sm-3 control-label">Privilege - TargetType<span class="at-required-highlight">*</span></label> 
                              <div class="col-sm-8">
                              <c:if test="${!empty privileges}">
                                    <ul id="editprivileges" >
                                 <li style="color:violet;font-size: 18px;padding: 3px; "> <div class="checkbox checkbox-primary"> <input name="select_all" value="1" id="editexample-select-all" type="checkbox"/>&nbsp;&nbsp;<label>all</label></div></li>
		                               </ul> 
		                                </c:if>
		                                </div>
                              </div>
 
		                          <div class="form-group ">
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==1}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                      <div class="form-group">
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==2}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                      <div class="form-group">
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==3}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                      <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==4}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==5}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==6}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==7}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==8}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==9}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==10}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==11}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==12}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==13}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==14}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="${privilege.getPrivilegeId()}" class="case" id="${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==15}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==16}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==17}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==18}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==19}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==20}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==21}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==22}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==23}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==24}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==25}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==26}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==27}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==28}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==29}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==30}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="privileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==31}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==32}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==33}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==34}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==35}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==36}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
		                                     <div class="form-group" >
                                     <label for="" class="col-sm-3 control-label"></label>
                                     <div class="col-sm-8">
                                      <c:if test="${!empty privileges}">
                                  <ul id="editprivileges" >
										       	 <c:set var="sno" value="1"/>	
		                                       	<c:forEach items="${privileges}" var="privilege">
		                                       	 <c:if test="${privilege.getPrivilegeCategory().getPrivilegeCategoryId()==37}">
		                                       	  <c:if test="${sno==1}">
		                                       		 <label for="" class="col-sm-3 control-label text-pink">${privilege.getPrivilegeCategory().getPrivilegeCategoryName()}</label>	
		                                        	</c:if>
		                                        	 <c:set var="sno" value="0"/>	
		                                       		<li style="font-size: 15px;padding: 3px; " value="${privilege.getPrivilegeId()}">
		                                       		<div class="checkbox checkbox-warning">
		                                       		  <input type="checkbox" value="${privilege.getPrivilegeId()}" name="edit${privilege.getPrivilegeId()}" class="case1" id="edit${privilege.getPrivilegeId()}"></input>&nbsp;&nbsp;<label>${privilege.getAliasName()}-${privilege.getTargetType() }</label>
		                                         </div>
		                                       		  </li>
		                                       		</c:if> 
		                                       		</c:forEach>
		                                       		</ul>
		                                       		 </c:if>	
		                                       		</div>
		                                     </div>
                              <input type="hidden" id="updateUserRoleId" name="updateUserRoleId">
                               <input type="hidden" id="selectedEditPrivilegeId" name="selectedEditPrivilegeId">
                                <security:authorize access="hasRole('rolemanagement/update')">
                              <div class="row">
                                 <div class="col-sm-offset-3">
                                   <a href="#" id="updateuserrole" style="float:right" class="btn btn-success btn-custom waves-effect waves-light" type="button" data-href="#" data-id="" data-toggle="modal" >
                                    				Update
                                    			</a>   
                                   
                                    <button style="float:right" type="reset" class="btn btn-info btn-custom waves-effect waves-light">Clear</button>
                                     <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                                 </div>
                              </div>
                                </security:authorize>
                           </form>
                           </div>
                           </div>
                          
                        </div>
                     </div>
                  </div>
               </div>
                <div class="modal fade" id="userrolesaveconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
                     <div class="modal-dialog" role="document">
                        <div class="modal-content">
                           <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="exampleModalLabelEdit">Confirmation?</h4>
                           </div>
                           <div class="modal-body">
                              <h5>Are you sure you want to add this user role ?</h5>
                           </div>
                           <div class="modal-footer">
                              <button type="button" id="userrolesaveconfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
                           </div>
                        </div>
                     </div>
                  </div>
                <div class="modal fade" id="userroleupdateconfirmation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" data-backdrop="static" data-keyboard="false">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabeledit2">Confirmation?</h4>
									</div>
									<div class="modal-body">
										 <h5>Are you sure you want to update this user role ?</h5>
									</div>
									<div class="modal-footer">
										<button type="button" name="userroleupdateconfirm" id="userroleupdateconfirm" class="btn btn-primary" data-dismiss="modal">Yes</button>
										
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
         
      <script src="${pageContext.request.contextPath}/resources/themes/script/rolemanagement.js" type="text/javascript"></script>
    
   </body>
</html>

