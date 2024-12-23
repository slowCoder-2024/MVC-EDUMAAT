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
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/jquery.form-advanced.init.js"></script>
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.11.2.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.7.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
      <style>
         .thumbnail {
         height: 200px;
         overflow: hidden;
         }
         .thumbnail
          {
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
         
.inbox-page {
    width: 80%;
    margin: 0 auto;
}
.inbox-row {
	padding: 0.5em 1em;
}
.inbox-page h4 {
    font-size: 1.2em;
    color: #A2A0A0;
    margin-bottom: 1em;
}
.mail {
    float: left;
    margin-right: 1em;
}
.mail.mail-name {
    width: 20%;
}
.mail-right {
    float: right;
    margin-left: 1.5em;
}
.inbox-page h6 {
    font-size: 1em;
    color: #555;
}
.inbox-page input.checkbox {
    margin: 13px 0 0;
}
.inbox-page img {
    width: 100%;
    vertical-align: bottom;
}
.inbox-page p {
    font-size: 1em;
    color: #000;
    line-height: 2em;
}
.inbox-page h6 {
    font-size: 1em;
    color: #555;
    line-height: 2em;
}
.inbox-page ul.dropdown-menu {
    padding: 5px 0;
    min-width: 105px;
    top: 0;
    left: -110px;
}
.inbox-page .dropdown-menu > li > a {
    padding: 4px 15px;
    font-size: 0.9em;
}
.inbox-page .dropdown-menu > li > a:hover, .inbox-page .dropdown-menu > li > a:focus {
    color: #e94e02;
}
.mail-icon {
    margin-right: 7px;
}
.inbox-page.row {
    margin-top: 2em;
}
.inbox-page .checkbox {
    position: relative;
    top: -3px;
    margin: 0 1rem 0 0;
    cursor: pointer;
}
.inbox-page .checkbox:before {
    -webkit-transition: all 0.3s ease-in-out;
    -moz-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out;
    content: "";
    position: absolute;
    left: 0;
    z-index: 1;
    width: 15px;
    height: 15px;
    border: 1px solid #A0A0A0;
}
.inbox-page .checkbox:after {
    content: "";
    position: absolute;
    top: -0.125rem;
    left: 0;
    width: 1.1rem;
    height: 1.1rem;
    background: #fff;
    cursor: pointer;
}
.inbox-page .checkbox:checked:before {
    -webkit-transform: rotate(-45deg);
    -moz-transform: rotate(-45deg);
    -ms-transform: rotate(-45deg);
    -o-transform: rotate(-45deg);
    transform: rotate(-45deg);
    height: .4rem;
    width: .8rem;
    border-color: #4F52BA;
    border-top-style: none;
    border-right-style: none;
    border-width: 2px;
}
.mail-body {
    padding: 1em 2em;
    border: 1px solid #D4D4D4;
    margin: 10px 0;
    transition: .5s all;
}
.mail-body p{
    font-size: 0.9em;
    line-height: 1.8em;
}
.mail-body input[type="text"]{
    width: 100%;
    border: none;
    border-bottom: 1px solid #F5F5F5;
    padding: 1em 0;
	outline:none;
	transition:.5s all;
	-webkit-transition:.5s all;
	-moz-transition:.5s all;
	font-size:1em;
}
.mail-body input[type="text"]:focus{
	padding: 2em 0;
	border-bottom: 1px solid #C7C5C5;
}
.mail-body input[type="submit"] {
    border: none;
    background: none;
    font-size: 1em;
    margin-top: 0.5em;
    color: #4F52BA;
	outline:none;
	font-weight: 600;
}
      </style>
      <!--//Metis Menu -->
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
                <div class="row">
                            <div class="col-sm-12">
                             <!--    <div class="btn-group pull-right m-t-15">
                                    <button type="button" class="btn btn-default dropdown-toggle waves-effect" data-toggle="dropdown" aria-expanded="false">Settings <span class="m-l-5"><i class="fa fa-cog"></i></span></button>
                                    <ul class="dropdown-menu drop-menu-right" role="menu">
                                        <li><a href="#">Action</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a></li>
                                    </ul>
                                </div> -->

                                <h4 class="page-title">   Communication From Institution</h4>
                                <br><br>
                            </div>
                        </div>
                      
						       <div class="panel panel-default m-t-20">
                                    <div class="panel-body p-0">
                                       <div class="table-responsive">
                                            <table class="table table-hover mails m-0">
                                                <tbody>
                                             
             <form class="form-horizontal" id="updateCommunicationNotificationForm">
         <input type="hidden" name="currentuseremail" id="currentuseremail" value="${user.getEmail()}">
                   <c:choose>         
                 <c:when test="${!empty receivedCommunicationNotifications.getCommunicationNotifications()}">
                 
               <c:forEach items="${receivedCommunicationNotifications.getCommunicationNotifications()}" var="communicationNotifications">
               <tr class="unread">
               <td>
        		<div class="inbox-row" id="accordion1" role="tablist" aria-multiselectable="true">
					
						<div class="mail"><i class="fa fa-bell text-info" aria-hidden="true"></i></div>
						<div class="mail mail-name "><h5>${communicationNotifications.getCreatedBy()}</h5></div>
						<a role="button" data-toggle="collapse" data-parent="#accordion" href="#receivednotification${communicationNotifications.getCommunicationNotificationId()}" aria-expanded="true" aria-controls="collapseTwo">
							<div class="mail"><p>${communicationNotifications.getCommunicationNotificationSubject()} </p></div>
						</a>
					<div class="mail-right"><p>${communicationNotifications.getCreatedDate()}</p></div>
						<div class="clearfix"> </div>	
						<div id="receivednotification${communicationNotifications.getCommunicationNotificationId()}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
							<div class=" mail-body">
							<p class="mail">${communicationNotifications.getCommunicationNotificationMessage()} </p>	
											 <br />
               <br />
									<input type="hidden" name="communicationNotificationId" id="communicationNotificationId" value="${communicationNotifications.getCommunicationNotificationId()}">
										 
								</div>
						</div>
					</div>
			</td>
			</tr>
				 </c:forEach>
            </c:when>
				
           <c:otherwise>
             <tr class="unread ">
               <td>
            <div class="alert alert-info ">
							<h5>Messages:</h5>
                                    <p>"No Messages Available"</p>
                  							</div>
                  							</td>
                  							</tr>
             </c:otherwise>
              </c:choose>
              </form>
                                           
               
 </tbody>
                                            </table>
                                        </div>
                                    
                                    </div> 
                                </div>
                                     
		<%-- 			  <form class="form-horizontal" id="updateCommunicationNotificationForm">
         <input type="hidden" name="currentuseremail" id="currentuseremail" value="${user.getEmail()}">
                   <c:choose>         
                 <c:when test="${!empty receivedCommunicationNotifications.getCommunicationNotifications()}">
                 
               <c:forEach items="${receivedCommunicationNotifications.getCommunicationNotifications()}" var="communicationNotifications">
              
                 <tr class="unread">
                                                        <td class="mail-select">
                                                            <div class="checkbox checkbox-primary m-r-15">
                                                                <input id="checkbox1" type="checkbox">
                                                                <label for="checkbox1"></label>
                                                            </div>
                                                            
                                                            <i class="fa fa-star m-r-15 text-muted"></i>
                                                            
                                                            <i class="fa fa-circle m-l-5 text-warning"></i>
                                                        </td>
                                                        
                                                        <td>
                                                            <a href="email-read.html" class="email-name">${communicationNotifications.getCreatedBy()}</a>
                                                        </td>
                                                        
                                                        <td class="hidden-xs">
                                                        <div class="inbox-row" id="accordion1" role="tablist" aria-multiselectable="true">
                                                        	<a role="button" data-toggle="collapse" data-parent="#accordion" href="#receivednotification${communicationNotifications.getCommunicationNotificationId()}" aria-expanded="true" aria-controls="collapseTwo">
							<div class="mail"><p>${communicationNotifications.getCommunicationNotificationSubject()} </p></div>
						</a>
                                                        <div id="receivednotification${communicationNotifications.getCommunicationNotificationId()}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
							<div class="mail-body">
							<p>${communicationNotifications.getCommunicationNotificationMessage()} </p>	
											 <br />
               <br />
									<input type="hidden" name="communicationNotificationId" id="communicationNotificationId" value="${communicationNotifications.getCommunicationNotificationId()}">
										 
								</div>
						</div></div>
                                                            <a href="email-read.html" class="email-msg">Lorem ipsum dolor sit amet, consectetuer adipiscing elit</a>
                                                        </td>
                                                        <td style="width: 20px;">
                                                            <i class="fa fa-paperclip"></i>
                                                        </td>
                                                        <td class="text-right">
                                                          ${communicationNotifications.getCreatedDate()}
                                                        </td>
                                                    </tr>
              
         		<div class="inbox-row" id="accordion1" role="tablist" aria-multiselectable="true">
					
					
						<a role="button" data-toggle="collapse" data-parent="#accordion" href="#receivednotification${communicationNotifications.getCommunicationNotificationId()}" aria-expanded="true" aria-controls="collapseTwo">
							<div class="mail"><p>${communicationNotifications.getCommunicationNotificationSubject()} </p></div>
						</a>
						<div class="mail-right">
							<div class="dropdown">
								<a href="#"  data-toggle="dropdown" aria-expanded="false">
									<p><i class="fa fa-ellipsis-v mail-icon"></i></p>
								</a>
								<ul class="dropdown-menu float-right">
									<li>
										<a href="#" class="font-red deletenotification" id="${communicationNotifications.getCommunicationNotificationId()}" title="">
											<i class="fa fa-trash-o mail-icon"></i>
											Delete
										</a>
									</li>
								</ul>
							</div> 
						</div>
						<div class="mail-right"><p>${communicationNotifications.getCreatedDate()}</p></div>
						<div class="clearfix"> </div>	
						<div id="receivednotification${communicationNotifications.getCommunicationNotificationId()}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
							<div class="mail-body">
							<p>${communicationNotifications.getCommunicationNotificationMessage()} </p>	
											 <br />
               <br />
									<input type="hidden" name="communicationNotificationId" id="communicationNotificationId" value="${communicationNotifications.getCommunicationNotificationId()}">
										 
								</div>
						</div>
					</div>
				
				
				
				
				 </c:forEach>
            </c:when>
				
           <c:otherwise>
            <div class="alert alert-info">
							<h5>Messages:</h5>
                                    <p>"No Messages Available"</p>
                  							</div>
             </c:otherwise>
              </c:choose>
              </form> --%>
      </div>
 </div>	
   </div>
							</div>
			<!-- 		</div>
					   </div>
                                 </div>
                                 </div>
                                 </div>
                                 </div>
        </div>  -->  
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
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.autocomplete.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/countries.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/pages/autocomplete.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.core.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/js/jquery.app.js"></script>
   </body>
</html>