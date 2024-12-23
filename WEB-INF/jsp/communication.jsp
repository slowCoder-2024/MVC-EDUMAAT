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


/*--inbox--*/
.inbox-page {
    width: 100%;
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
    width: 27%;
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
/*--//inbox--*/
/*--compose mail--*/
.compose-left{
    width: 28%;
	padding: 0;
}
.compose-right{
    width: 95%;
    margin-left: 2%;
	padding: 0;
	margin-bottom:20px;
}
.compose-left a i.fa {
    margin-right: 0.7em;
}
.compose-left ul li{
	display:block;
}
.compose-left ul li.head {
    padding: 0.5em 1.5em;
    border-bottom: 1px solid #DCDCDC;
    color: #000;
    font-size: 1.2em;
    background-color: #F5F5F5;
}
.compose-left ul li a {
    display: block;
    font-size: 1em;
    color: #555;
    border-bottom: 1px solid #DCDCDC;
    padding: 0.7em 1.5em;
}
.compose-left ul li a:hover {
    background-color: rgb(241, 241, 241);
}
.compose-left span {
    float: right;
    background-color: rgba(233, 78, 2, 0.73);
    padding: 3px 10px;
    font-size: .7em;
    border-radius: 4px;
    color: #fff;
}
.chat-left {
    position: relative;
    float: left;
    width: 25%;
}
.chat-right {
    float: left;
}
.small-badge {
    position: absolute;
    left: 27px;
    top: 1px;
    overflow: hidden;
    width: 12px;
    height: 12px;
    padding: 0;
    border: 2px solid #fff!important;
    border-radius: 20px;
    background-color: red;
}
.small-badge.bg-green {
    background-color: green;
}
.chat-grid.widget-shadow {
    margin-top: 2em;
}
.chat-right p {
    font-size: 1em;
    color: #000;
	line-height: 1.2em;
}
.chat-right h6 {
    font-size: 0.8em;
    color: #999;
    line-height: 1.4em;
}
.compose-right .panel-heading {
    padding: 0.8em 2em;
}
.compose-right .panel-body {
    padding: 2em;
}
.compose-right .alert.alert-info {
    padding: 10px 20px;
    font-size: 0.9em;
    color: #6164C1;
	background-color: rgba(212, 213, 243, 0.98);
    border-color: rgba(151, 153, 230, 0.41);
	border-radius: inherit;
}
.compose-right .form-group {
    margin: .5em 0;
}
.compose-right .btn.btn-file {
    position: relative;
    overflow: hidden;
	border-radius: inherit;
}
.compose-right .btn.btn-file>input[type='file'] {
    position: absolute;
    top: 0;
    right: 0;
    opacity: 0;
    filter: alpha(opacity=0);
    outline: none;
    background: white;
    cursor: inherit;
    display: inline-flex;
    width: 100%;
    padding: 0.4em;
}
.compose-right p.help-block {
    display: inline-block;
    margin-left: 0.5em;
    font-size: 0.9em;
    color: #6F6F6F;
}
.compose-right input[type="submit"] {
    font-size: 0.9em;
    background-color: #6164C1;
    border: 1px solid #4F52BA;
    color: #fff;
    padding: 0.4em 1em;
    margin-top: 1em;
}
.widget-shadow {
    background-color: #ffffff;
    box-shadow: 0 -1px 3px rgba(0,0,0,.12),0 1px 2px rgba(0,0,0,.24);
	-webkit-box-shadow: 0 -1px 3px #673AB7,0 1px 2px rgba(0,0,0,.24);
	-moz-box-shadow: 0 -1px 3px rgba(0,0,0,.12),0 1px 2px rgba(0,0,0,.24);
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
               <%-- <security:authorize access="hasAnyRole('communication/admin/add','communication/staff/add','communication/student/add','communication/parent/add')">   --%>
               <div class="form-group">
                  <button type="button" class="btn btn-primary btn-custom waves-effect waves-light col-md-3" onclick="showDiv()">Compose New Communication</button>
               </div>
            
               <br />
               <br />
             
               <br />
               <%--   </security:authorize> --%>
<%--                  <security:authorize access="hasAnyRole('communication/admin/view','communication/staff/view','communication/student/view','communication/parent/view')">  
 --%>                  <h3 class="title1">Inbox</h3>
                   <div class="forms">
                  <div class="row">
                    <div class="form-three">
                 
            <!--    <div class="inbox-page"> -->
               <ul id="myTabs" class="nav nav-tabs" role="tablist">
      <li role="presentation" class="active"><a href="#notification-information" id="notification-information-tab" role="tab" data-toggle="tab" aria-controls="notification-information" aria-expanded="true"><i class="fa fa-bell" aria-hidden="true"></i>
      Notifications[<label>${receivedCommunicationNotifications.getCommunicationNotifications().size()}</label>]</a></li>
      <li role="presentation" class=""><a href="#feedback-issue-others-information" role="tab" id="feedback-issue-others-information-tab" data-toggle="tab" aria-controls="feedback-issue-others-information" aria-expanded="false"><i class="fa fa-envelope" aria-hidden="true"></i>
      Feedback/Issue/Others[<label>${receivedCommunicationFeedBackAndOthers.getCommunicationFeedBackAndOthers().size() }</label>]</a></li>
      <security:authorize access="hasAnyRole('communication/staff','communication/admin','communication/principal','communication/feesadmin','communication/inventoryandassetadmin','communication/libraryadmin')">  
      <li role="presentation" class=""><a href="#sent-notification-information" role="tab" id="sent-notification-information-tab" data-toggle="tab" aria-controls="sent-notification-information" aria-expanded="false"><i class="fa fa-send" aria-hidden="true"></i>
      Sent Notifications[<label>${communicationSentNotifications.size()}</label>]</a></li>
       </security:authorize>
        <li role="presentation" class=""><a href="#sent-issue-others-information" role="tab" id="sent-issue-others-information-tab" data-toggle="tab" aria-controls="sent-issue-others-information" aria-expanded="false"><i class="fa fa-mail-forward" aria-hidden="true"></i>
      Sent Feedback/Issue/Others[<label>${communicationSentMessages.size()}</label>] </a></li>
       <li role="presentation" class=""><a href="#sent-reply-message-information" role="tab" id="sent-reply-message-information-tab" data-toggle="tab" aria-controls="sent-reply-message-information" aria-expanded="false"><i class="fa fa-reply" aria-hidden="true"></i>
      Replied Messages [<label for="replycount" id="replycount"></label>]</a></li>
       <li role="presentation" class=""><a href="#sent-message-information" role="tab" id="sent-message-information-tab" data-toggle="tab" aria-controls="sent-message-information" aria-expanded="false"><i class="fa fa-arrow-up " aria-hidden="true"></i>
      Sent Messages[<label for="sentcount" id="sentcount"></label>] </a></li>
   </ul>
   <div id="myTabContent" class="tab-content">
    <div role="tabpanel" class="tab-pane fade active in" id="notification-information" aria-labelledby="notification-information-tab">
      <form class="form-horizontal" id="updateCommunicationNotificationForm">
     <br>
        <h4>Today</h4>
         <input type="hidden" name="currentuseremail" id="currentuseremail" value="${user.getEmail()}">
                   <c:choose>         
                 <c:when test="${!empty receivedCommunicationNotifications.getCommunicationNotifications()}">
                 
               <c:forEach items="${receivedCommunicationNotifications.getCommunicationNotifications()}" var="communicationNotifications">
              
        <%--   <c:if test="${communicationNotifications.getCommunicationMessageMode().getCommunicationMessageModeId()==1 }"> --%>
          		<div class="inbox-row widget-shadow" id="accordion1" role="tablist" aria-multiselectable="true">
					
						<div class="mail"><i class="fa fa-bell" aria-hidden="true"></i></div>
						<div class="mail mail-name"><h6>${communicationNotifications.getCreatedBy()}</h6></div>
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
										 <security:authorize access="hasAnyRole('communication/admin/delete','communication/staff/delete','communication/student/delete','communication/parent/delete')">  
										<input type="button" class="btn btn-danger deletenotification" name="${communicationNotifications.getCommunicationNotificationId()}" id="${communicationNotifications.getCommunicationNotificationId()}" value="Delete">
								</security:authorize>
								</div>
						</div>
					</div>
				<%-- </c:if> --%>
				 </c:forEach>
            </c:when>
				
           <c:otherwise>
            <div class="alert alert-info">
							<h5>Messages:</h5>
                                    <p>"No Messages Available"</p>
                  							</div>
             </c:otherwise>
              </c:choose>
       </form>
      </div>
       <div role="tabpanel" class="tab-pane fade" id="feedback-issue-others-information" aria-labelledby="feedback-issue-others-information-tab">
        <form class="form-horizontal" id="updateCommunicationMessageForm">
   
      <br>
      <h4>Today</h4>
        
                        <c:choose>         
                 <c:when test="${!empty receivedCommunicationFeedBackAndOthers.getCommunicationFeedBackAndOthers()}">
                 
               <c:forEach items="${receivedCommunicationFeedBackAndOthers.getCommunicationFeedBackAndOthers()}" var="communicationMessages" >
              
        <%--   <c:if test="${communicationMessages.getCommunicationMessageMode().getCommunicationMessageModeId() !=1 }"> --%>
          
            
          		<div class="inbox-row widget-shadow" id="accordion1" role="tablist" aria-multiselectable="true">
					
						<div class="mail"><i class="fa fa-envelope" aria-hidden="true"></i></div>
						<div class="mail mail-name"><h6 >${communicationMessages.getCreatedBy()}</h6></div>
						<a role="button" data-toggle="collapse" data-parent="#accordion" href="#receivedmessage${communicationMessages.getCommunicationFeedBackAndOthersId()}" aria-expanded="true" aria-controls="collapseTwo">
							<div class="mail"><p>${communicationMessages.getCommunicationFeedBackAndOthersSubject()} </p></div>
						</a>
						<div class="mail-right">
							<div class="dropdown">
								<a href="#"  data-toggle="dropdown" aria-expanded="false">
									<p><i class="fa fa-ellipsis-v mail-icon"></i></p>
								</a>
								<ul class="dropdown-menu float-right">
									
									<li>
										<a href="#" class="font-red deletemessage" id="${communicationMessages.getCommunicationFeedBackAndOthersId()}" title="">
											<i class="fa fa-trash-o mail-icon"></i>
											Delete
										</a>
									</li>
								</ul>
							</div> 
						</div>
						<div class="mail-right"><p>${communicationMessages.getCreatedDate()}</p></div>
						<div class="clearfix"> </div>	
						<div id="receivedmessage${communicationMessages.getCommunicationFeedBackAndOthersId()}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
							<div class="mail-body">
							<p>${communicationMessages.getCommunicationFeedBackAndOthersMessage()} </p>	
								   <c:forEach items="${communicationRepliedMessages}" var="communicationReplyMessages">
								   <c:if test="${communicationMessages.getCommunicationFeedBackAndOthersId()==communicationReplyMessages.getCommunicationFeedBackAndOthers().getCommunicationFeedBackAndOthersId()}">
              		   <p><i class="fa fa-send" aria-hidden="true"></i> SentBy [ ${communicationReplyMessages.getCreatedBy()} ] : ${communicationReplyMessages.getCommunicationFeedBackAndOthersHistoryMessage()} </p>	
       				  </c:if>	</c:forEach>		 <br />    
       				   <div class="form-group">
                                       	  <textarea rows="3" class="form-control" placeholder="Message :"  name="replymessage${communicationMessages.getCommunicationFeedBackAndOthersId()}" id="replymessage${communicationMessages.getCommunicationFeedBackAndOthersId()}"></textarea>
                                </div>   <br />
									<input type="hidden" name="communicationMessageId" id="communicationMessageId" value="${communicationMessages.getCommunicationFeedBackAndOthersId()}">
									<input type="hidden" name="replyMessage" id="replyMessage">
								
										 <security:authorize access="hasAnyRole('communication/admin/delete','communication/staff/delete','communication/student/delete','communication/parent/delete')">  
										<input type="button" class="btn btn-danger deletemessage" name="${communicationMessages.getCommunicationFeedBackAndOthersId()}" id="${communicationMessages.getCommunicationFeedBackAndOthersId()}" value="Delete">
								</security:authorize>
								
								   <button class="btn btn-info" type="reset">Clear</button>
                                  
										<input type="button" class="btn btn-success replymessage" name="${communicationMessages.getCommunicationFeedBackAndOthersId()}" id="${communicationMessages.getCommunicationFeedBackAndOthersId()}" value="Reply">
								
								</div>
						</div>
					</div>
				
			<%-- 	</c:if> --%>
							 </c:forEach>
				   
            </c:when>
				
           <c:otherwise>
            <div class="alert alert-info">
							<h5>Messages:</h5>
                                    <p>"No Messages Available"</p>
                  							</div>
             </c:otherwise>
              </c:choose>
           
      </form>
      </div>
       <div role="tabpanel" class="tab-pane fade" id="sent-notification-information" aria-labelledby="sent-notification-information-tab">
      <form class="form-horizontal" id="updateSentCommunicationNotificationForm">
    <br>
       <h4>Today</h4>
                   <c:choose>         
                 <c:when test="${!empty communicationSentNotifications}">
               <c:forEach items="${communicationSentNotifications}" var="communicationSentNotifications">
          		<div class="inbox-row widget-shadow" id="accordion1" role="tablist" aria-multiselectable="true">
						<div class="mail"><i class="fa fa-send" aria-hidden="true"></i></div>
						<div class="mail mail-name"><h6>${communicationSentNotifications.getCreatedBy()}</h6></div>
						<a role="button" data-toggle="collapse" data-parent="#accordion" href="#sentnotification${communicationSentNotifications.getCommunicationNotificationId()}" aria-expanded="true" aria-controls="collapseTwo">
							<div class="mail"><p>${communicationSentNotifications.getCommunicationNotificationSubject()} </p></div>
						</a>
						<div class="mail-right">
							<div class="dropdown">
								<a href="#"  data-toggle="dropdown" aria-expanded="false">
									<p><i class="fa fa-ellipsis-v mail-icon"></i></p>
								</a>
								<ul class="dropdown-menu float-right">
									<li>
										<a href="#" title="" class="movetoarchive" id="${communicationSentNotifications.getCommunicationNotificationId()}">
											<i class="fa fa-download mail-icon"></i>
											Archive
										</a>
									</li>
									<li>
										<a href="#" class="font-red deletesentnotification" id="${communicationSentNotifications.getCommunicationNotificationId()}" title="">
											<i class="fa fa-trash-o mail-icon"></i>
											Delete
										</a>
									</li>
								</ul>
							</div> 
						</div>
				
						<div class="mail-right"><p>${communicationSentNotifications.getCreatedDate()}</p></div>
						<div class="clearfix"> </div>	
						<div id="sentnotification${communicationSentNotifications.getCommunicationNotificationId()}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
							<div class="mail-body">
							<p>${communicationSentNotifications.getCommunicationNotificationMessage()} </p>	
							 
						
							   <input type="hidden" name="communicationNotificationId" id="communicationNotificationId" value="${communicationSentNotifications.getCommunicationNotificationId()}">
								     <br />
               <br />  <security:authorize access="hasAnyRole('communication/admin/delete','communication/staff/delete','communication/student/delete','communication/parent/delete')">  
										
										<input type="button" class="btn btn-danger deletesentnotification" name="${communicationSentNotifications.getCommunicationNotificationId()}" id="${communicationSentNotifications.getCommunicationNotificationId()}" value="Delete">
								</security:authorize>
								<input type="button" class="btn btn-info movetoarchive" name="${communicationSentNotifications.getCommunicationNotificationId()}" id="${communicationSentNotifications.getCommunicationNotificationId()}" value="Move To Archive">
							
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
      </form>
      </div>
         <div role="tabpanel" class="tab-pane fade" id="sent-issue-others-information" aria-labelledby="sent-issue-others-information-tab">
      <form class="form-horizontal" id="updateSentCommunicationMessageForm">
    <br>
       <h4>Today</h4>
                   <c:choose>         
                 <c:when test="${!empty communicationSentMessages}">
               <c:forEach items="${communicationSentMessages}" var="communicationSentMessages">
          		<div class="inbox-row widget-shadow" id="accordion1" role="tablist" aria-multiselectable="true">
						<div class="mail"><i class="fa fa-mail-forward" aria-hidden="true"></i></div>
						<div class="mail mail-name"><h6>${communicationSentMessages.getCreatedBy()}</h6></div>
						<a role="button" data-toggle="collapse" data-parent="#accordion" href="#sentmessage${communicationSentMessages.getCommunicationFeedBackAndOthersId()}" aria-expanded="true" aria-controls="collapseTwo">
							<div class="mail"><p>${communicationSentMessages.getCommunicationFeedBackAndOthersSubject() } </p></div>
						</a>
						<div class="mail-right">
							<div class="dropdown">
								<a href="#"  data-toggle="dropdown" aria-expanded="false">
									<p><i class="fa fa-ellipsis-v mail-icon"></i></p>
								</a>
								<ul class="dropdown-menu float-right">
									<li>
										<a href="#" title="" class="messagemovetoarchive" id="${communicationSentMessages.getCommunicationFeedBackAndOthersId()}" >
											<i class="fa fa-download mail-icon"></i>
											Archive
										</a>
									</li>
									<li>
										<a href="#" class="font-red deletesentmessage"  id="${communicationSentMessages.getCommunicationFeedBackAndOthersId()}" title="">
											<i class="fa fa-trash-o mail-icon"></i>
											Delete
										</a>
									</li>
								</ul>
							</div> 
						</div>
				
						<div class="mail-right"><p>${communicationSentMessages.getCreatedDate()}</p></div>
						<div class="clearfix"> </div>	
						<div id="sentmessage${communicationSentMessages.getCommunicationFeedBackAndOthersId()}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
							<div class="mail-body">
							<p>Sent Message : ${communicationSentMessages.getCommunicationFeedBackAndOthersMessage()} </p>	
							    <c:forEach items="${user.getCommunicationFeedBackAndOthersHistory()}" var="communicationRepliedMessages">
              		   <c:if test="${ communicationSentMessages.getCommunicationFeedBackAndOthersId() == communicationRepliedMessages.getCommunicationFeedBackAndOthers().getCommunicationFeedBackAndOthersId()}">
       				   <p><i class="fa fa-reply" aria-hidden="true"></i> RepliedBy [ ${communicationRepliedMessages.getCreatedBy() } ] : ${communicationRepliedMessages.getCommunicationFeedBackAndOthersHistoryMessage()} </p>	
        			  </c:if>
         				 </c:forEach>
						
							   <input type="hidden" name="communicationMessageId" id="communicationMessageId" value="${communicationSentMessages.getCommunicationFeedBackAndOthersId()}">
								     <br />
               <br /> <security:authorize access="hasAnyRole('communication/admin/delete','communication/staff/delete','communication/student/delete','communication/parent/delete')">  
										<input type="button" class="btn btn-danger deletesentmessage" name="${communicationSentMessages.getCommunicationFeedBackAndOthersId()}" id="${communicationSentMessages.getCommunicationFeedBackAndOthersId()}" value="Delete">
								</security:authorize>
								<input type="button" class="btn btn-info messagemovetoarchive" name="${communicationSentMessages.getCommunicationFeedBackAndOthersId()}" id="${communicationSentMessages.getCommunicationFeedBackAndOthersId()}" value="Move To Archive">
							
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
        
      </form>
    
      </div>
      
      
       <div role="tabpanel" class="tab-pane fade" id="sent-reply-message-information" aria-labelledby="sent-reply-message-information-tab">
      <form class="form-horizontal" id="updateCommunicationReplyForm">
   
      <br>
        <h4>Today</h4>
        	<input type="hidden" name="replyMessages" id="replyMessages">
								
          		     <c:choose>         
                 <c:when test="${!empty repliedCommunicationFeedBackAndOthers.getCommunicationFeedBackAndOthersHistory()}">
                 
               <c:forEach items="${repliedCommunicationFeedBackAndOthers.getCommunicationFeedBackAndOthersHistory()}" var="communicationRepliedMessage">
            <%--   <c:if test="${communicationRepliedMessage.getStatus()!=2}"> --%>
            	<div class="inbox-row widget-shadow" id="accordion1" role="tablist" aria-multiselectable="true">
					<label for="${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}" id="${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}"></label>
          	
						<div class="mail"><i class="fa fa-envelope" aria-hidden="true"></i></div>
						<div class="mail mail-name"><h6>${communicationRepliedMessage.getCreatedBy()}</h6></div>
						<a role="button" data-toggle="collapse" data-parent="#accordion" href="#repliedmessage${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}" aria-expanded="true" aria-controls="collapseTwo">
							<div class="mail"><p>${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistorySubject()} </p></div>
						</a>
						<div class="mail-right">
							<div class="dropdown">
								<a href="#"  data-toggle="dropdown" aria-expanded="false">
									<p><i class="fa fa-ellipsis-v mail-icon"></i></p>
								</a>
								<ul class="dropdown-menu float-right">
									
									<li>
										<a href="#" class="font-red deleterepliedmessage" id="${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}" title="">
											<i class="fa fa-trash-o mail-icon"></i>
											Delete
										</a>
									</li>
								</ul>
							</div> 
						</div>
						<div class="mail-right"><p>${communicationRepliedMessage.getCreatedDate()}</p></div>
						<div class="clearfix"> </div>	
						<div id="repliedmessage${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
							<div class="mail-body">
							
							<p><i class="fa fa-reply" aria-hidden="true"></i>RepliedBy [${communicationRepliedMessage.getCreatedBy()}] : ${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryMessage()} </p>	
									<%--  <c:forEach items="${communicationRepliedMessages}" var="communicationReplyMessages">
								   <c:if test="${communicationReplyMessages.getCommunicationFeedBackAndOthers().getCommunicationFeedBackAndOthersId()==communicationRepliedMessage.getCommunicationFeedBackAndOthers().getCommunicationFeedBackAndOthersId() && communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId() == communicationReplyMessages.getCommunicationFeedBackAndOthersHistoryId()}">
              		   <p><i class="fa fa-reply" aria-hidden="true"></i>  SentBy [ ${communicationReplyMessages.getCreatedBy()} ] : ${communicationReplyMessages.getCommunicationFeedBackAndOthersHistoryMessage()} </p>	
       				  </c:if>	</c:forEach>  --%>
									   	 <br />
									   	 <div class="form-group">
              						 <textarea rows="3" class="form-control" placeholder="Message :"  name="replymessage${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}" id="replymessage${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}"></textarea>
                               </div>   <br />
								
									  <input type="hidden" name="communicationRepliedMessageId" id="communicationRepliedMessageId" value="${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}">
										 <security:authorize access="hasAnyRole('communication/admin/delete','communication/staff/delete','communication/student/delete','communication/parent/delete')">  
										<input type="button" class="btn btn-danger deleterepliedmessage" name="${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}" id="${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}" value="Delete">
								</security:authorize>
								   <button class="btn btn-info" type="reset">Clear</button>
                                  
										<input type="button" class="btn btn-success chatreplymessage" name="${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}" id="${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}" value="Reply">
							
								</div>
						</div>
					</div>
					<%--  </c:if> --%>
					 </c:forEach>
				
            </c:when>
				
           <c:otherwise>
            <!-- div class="alert alert-info">
							<h5>Messages:</h5>
                                    <p>"No Messages Available"</p>
                  							</div> -->
             </c:otherwise>
              </c:choose>
              </form>
      </div>
      
       <div role="tabpanel" class="tab-pane fade" id="sent-message-information" aria-labelledby="sent-message-information-tab">
      <form class="form-horizontal" id="updateCommunicationSentForm">
   
      <br>
        <h4>Today</h4>
        						
          		     <c:choose>         
                 <c:when test="${!empty communicationRepliedMessages}">
                 
               <c:forEach items="${communicationRepliedMessages}" var="communicationRepliedMessage">
              <c:if test="${communicationRepliedMessage.getStatus()!=0 && communicationRepliedMessage.getStatus() !=2 }">
            	<div class="inbox-row widget-shadow" id="accordion1" role="tablist" aria-multiselectable="true">
					<label for="${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}" id="${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}"></label>
          	
						<div class="mail"><i class="fa fa-envelope" aria-hidden="true"></i></div>
						<div class="mail mail-name"><h6>${communicationRepliedMessage.getCreatedBy()}</h6></div>
						<a role="button" data-toggle="collapse" data-parent="#accordion" href="#sentrepliedmessage${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}" aria-expanded="true" aria-controls="collapseTwo">
							<div class="mail"><p>${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistorySubject()} </p></div>
						</a>
						<div class="mail-right">
							<div class="dropdown">
								<a href="#"  data-toggle="dropdown" aria-expanded="false">
									<p><i class="fa fa-ellipsis-v mail-icon"></i></p>
								</a>
								<ul class="dropdown-menu float-right">
									
									<li>
										<a href="#" class="font-red deletesentreplymessage" id="${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}" title="">
											<i class="fa fa-trash-o mail-icon"></i>
											Delete
										</a>
									</li>
								</ul>
							</div> 
						</div>
						<div class="mail-right"><p>${communicationRepliedMessage.getCreatedDate()}</p></div>
						<div class="clearfix"> </div>	
						<div id="sentrepliedmessage${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
							<div class="mail-body">
							
							<p> ${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryMessage()} </p>	
								
									   	 <br>
									  <input type="hidden" name="communicationRepliedMessageId" id="communicationRepliedMessageId" value="${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}">
										 <security:authorize access="hasAnyRole('communication/admin/delete','communication/staff/delete','communication/student/delete','communication/parent/delete')">  
										<input type="button" class="btn btn-danger deletesentreplymessage" name="${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}" id="${communicationRepliedMessage.getCommunicationFeedBackAndOthersHistoryId()}" value="Delete">
								</security:authorize>
								  
								</div>
						</div>
					</div>
					 </c:if>
					 </c:forEach>
				
            </c:when>
				
           <c:otherwise>
           <!--  <div class="alert alert-info">
							<h5>Messages:</h5>
                                    <p>"No Messages Available"</p>
                  							</div> -->
             </c:otherwise>
              </c:choose>
              </form>
      </div>
   
   </div>
             
				
			<!-- </div>		 -->
		
			</div>
			</div>
			</div>
				<%-- </security:authorize> --%>
             
            </div>
         
            
            <div id="FormDiv" style="display:none;">
           <div class="row" id="error">
                        <div class="col-lg-12">
                           <div class="panel panel-border panel-pink">
                              <div class="panel-heading">
                                 <h2 class="panel-title">Create New Message</h2>
                              </div>
                              <div class="panel-body">
                                 <div class="col-lg-12">
                              
                              <form class="form-horizontal" id="communicationForm" action="${pageContext.request.contextPath}/communication/newcommunication" method="post">
                                  <input type="hidden" name="currentCommunicationComposerUserId" id="currentCommunicationComposerUserId" class="form-control" value="${user.email}">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Select Message Mode<span class="at-required-highlight">*</span></label>
                                    <div class="col-sm-7">
                                        <select name="messageModeId" id="messageModeId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                          <option value="" disabled selected>Select Message Mode</option>
                                           <option value="portal" >Portal</option>
                                            <option value="email" >Email</option>
                                             <option value="sms" >SMS</option>
                                           </select>
                                    </div>
                                 </div>
                                  <div class="form-group">
                                    <label class="col-md-3 control-label">Select Message Type<span class="at-required-highlight">*</span></label>
                                    <div class="col-sm-7">
                                        <select name="messageTypeId" id="messageTypeId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                          <c:if test="${!empty communicationMessageMode}">
                                          <option value="" disabled selected>Select Message Type</option>
                                          <c:forEach items="${communicationMessageMode}" var="communicationMessageMode">
                                             <option value="${communicationMessageMode.getCommunicationMessageModeId()}">${communicationMessageMode.getCommunicationMessageModeTitle()}</option>
                                          </c:forEach>
                                       </c:if>
                                         </select>
                                    </div>
                                 </div>
                               
                                 <div class="form-group">
                                    <label for="" class="col-md-3 control-label">Select Communication Target Group<span class="at-required-highlight">*</span></label> 
                                   <div class="col-sm-7">
                                     <select name="communicationTargetGroupId" id="communicationTargetGroupId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                      <c:if test="${!empty commnunicationTargetGroup}">
                                          <option value="" disabled selected>Select Communication Target Group </option>
                                          <c:forEach items="${commnunicationTargetGroup}" var="commnunicationTargetGroup">
                                             <option value="${commnunicationTargetGroup.getCommunicationTargetGroupId()}">${commnunicationTargetGroup.getCommunicationTagetGroupTitle()}</option>
                                          </c:forEach>
                                       </c:if>
                                    
                                    </select>
                                 </div>
                                 </div>
                                 
                               
                                 <div class="row">
                                  <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Message Subject<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                         <input type="text" name="communicationSubject" id="communicationSubject" required="required" class="form-control">
                                                                                   </div>
                                     </div>
                                      
                                 <div class="form-group form-group-staff" style="display:none;">
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Staff Type<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="staffTypeId" id="staffTypeId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Type</option>
                                             <c:if test="${!empty staffTypes}">
		                                       		<c:forEach items="${staffTypes}" var="staffType">
		                                       			<option value="${staffType.getStaffTypeId()}">${staffType.getStaffTypeName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                   
                                     <div class="form-group ">
                                       <label for="" class="col-sm-3 control-label">Staff Designation<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                          			     <select name="staffDesignationId" id="staffDesignationId" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                             <option value="" disabled selected>Select Designation</option>
                                             
                                          </select>
                                       </div>
                                    </div>
                                  
                                  <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Users<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="targetUserId" id="targetUserId" class="selectpicker targetUserId" data-live-search="true"  data-style="btn-white" multiple required="required">
                                            <option value="" disabled selected>Select Users</option>
                                            </select>
                                       </div>
                                     </div>
                                 </div>
                                 
                                 
                                   <div class="form-group form-group-parent" style="display:none;">
                                  <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Class<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                        <select name="parentClass" id="parentClass" class="selectpicker parentClass" data-live-search="true"  data-style="btn-white" required="required">
                                                <option value="" disabled selected>Select Class</option>
                                           		 <c:if test="${!empty classes}">
		                                       			<c:forEach items="${classes}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}(${clazz.getInstitution().getInstitutionCode()})</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
                                   
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Section<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="parentSection" id="parentSection" class="selectpicker parentSection" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                          </select>
                                       </div>
                                    </div>
                                  
                                  <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Users<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="targetParentId" id="targetParentId" class="selectpicker parentUser targetParentId" data-live-search="true"  data-style="btn-white" multiple required="required">
                                            <option value="" disabled selected>Select Users</option>
                                            </select>
                                       </div>
                                     </div>
                                  </div>
                               
                                   <div class="form-group form-group-student" style="display:none;">
                                  <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Class<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                        <select name="studentClass" id="studentClass" class="selectpicker studentClass" data-live-search="true"  data-style="btn-white" required="required">
                                                <option value="" disabled selected>Select Class</option>
                                           		 <c:if test="${!empty classes}">
		                                       			<c:forEach items="${classes}" var="clazz">
		                                       				<option value="${clazz.getClassId()}">${clazz.getClassName()}(${clazz.getInstitution().getInstitutionCode()})</option>
		                                       			</c:forEach>
		                                       		</c:if>
                                          </select>
                                       </div>
                                    </div>
                                    
                                 
                                     
                                    <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Section<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="studentSection" id="studentSection" class="selectpicker studentSection" data-live-search="true"  data-style="btn-white" required="required">
                                            	<option value="" disabled selected>Select Class First</option>
                                          </select>
                                       </div>
                                    </div>
                                 
                                   
                                  <div class="form-group">
                                       <label for="" class="col-sm-3 control-label">Select Users<span class="at-required-highlight">*</span></label> 
                                       <div class="col-sm-7">
                                          <select name="targetStudentId" id="targetStudentId" class="selectpicker studentUser targetStudentId" data-live-search="true"  data-style="btn-white" multiple required="required">
                                            <option value="" disabled selected>Select Users</option>
                                            </select>
                                       </div>
                                     </div>
                                  </div>
                                   
                                   <div class="form-group">
                                       <label for="" class="col-sm-3 control-label"></label>
                                        <div class="col-sm-7"> 
                                    <textarea rows="6" class="form-control" placeholder="Message :"  name="message" id="message"></textarea>
                                    </div>
                                </div>
                                 </div>
                               <br>
                                   <button style="float:right"   type="submit" name="saveCommunicationMessage" id="saveCommunicationMessage" class="btn btn-success btn-custom waves-effect waves-light">Send Message</button>
                                
                                 
                                    <button style="float: right" type="button" class="btn btn-danger btn-custom waves-effect waves-light" onclick="location.reload()">Cancel</button>
                              
                              </form>
                             
                           </div>
                        </div>
                     </div>
                     <div class="clearfix"> </div>
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
    <%--   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.mockjax.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/jquery.autocomplete.min.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autocomplete/countries.js"></script> --%>
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
        
     
      
      
    
           <script src="${pageContext.request.contextPath}/resources/themes/script/communication.js" type="text/javascript"></script>
   
  
   </body>
</html>