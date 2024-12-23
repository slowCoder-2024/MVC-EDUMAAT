<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form  id="menuHeaderForm">
 <input type="hidden" name="portalNotificationId" id="portalNotificationId">
 <input type="hidden" name="portalMessageId" id="portalMessageId">
  <input type="hidden" name="replyMessageId" id="replyMessageId">
   <input type="hidden" name="portalTaskId" id="portalTaskId">
   
   
    <input type="hidden" name="notificationcountfortask" id="notificationcountfortask">
     <input type="hidden" name="notificationcountformessage" id="notificationcountformessage">
      <input type="hidden" name="notificationcountforreplymessage" id="notificationcountforreplymessage">
       <input type="hidden" name="notificationcountfornotification" id="notificationcountfornotification">
   	   <!-- Top Bar Start -->
            <div class="topbar">

                <!-- LOGO -->
                <div class="topbar-left" id="logo-tour">
                    <div class="text-center">
<!--                         <a href="" class="logo"><i class="icon-magnet icon-c-logo"></i><span>Edumaat</span></a>
 -->                        <!-- Image Logo here -->
                        <a href="index.html" class="logo">
                            <i class="icon-c-logo"> <img src="${pageContext.request.contextPath}${logo}" height="42"/> </i>
                            <span>EDUMAAT</span>
                        </a>
                    </div>
                </div>

                <!-- Button mobile view to collapse sidebar menu -->
                <div class="navbar navbar-default" role="navigation">
                    <div class="container">
                        <div class="">
                            <div class="pull-left" id="navigation-tour">
                                <button class="button-menu-mobile open-left waves-effect waves-light" type="button">
                                    <i class="md md-menu"></i>
                                </button>
                                <span class="clearfix"></span>
                            </div>

                           

                            <div role="search" class="navbar-left app-search pull-left hidden-xs">
			                     <input type="text" placeholder="Search..." class="form-control">
			                     <a href="#"><i class="fa fa-search"></i></a>
			                </div>




                            <ul class="nav navbar-nav navbar-right pull-right">
                            
                        <%--     <security:authorize access="hasAnyRole('communication/admin','communication/staff','communication/student','communication/parent')">
                         --%>    
                           <!--      <li class="dropdown top-menu-item-xs" id="notification-tour">
                                    <a href="#" data-target="#" class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="true" id="notificationcount">
                                        <i class="icon-bell"></i> <span class="badge badge-xs badge-danger">3</span>
                                    </a>
                                    <ul class="dropdown-menu dropdown-menu-lg" id="currentnotifications">
                                        <li class="notifi-title"><span class="label label-default pull-right">New 3</span>Alert</li>
                                        <li class="list-group slimscroll-noti notification-list">
                                        
                                        
                                           list item
                                           <a href="javascript:void(0);" class="list-group-item">
                                              <div class="media">
                                                 <div class="pull-left p-r-10">
                                                    <em class="fa fa-diamond noti-primary"></em>
                                                 </div>
                                                 <div class="media-body">
                                                    <h5 class="media-heading">A new order has been placed A new order has been placed</h5>
                                                    <p class="m-0">
                                                        <small>There are new settings available</small>
                                                    </p>
                                                 </div>
                                              </div>
                                           </a>

                                        
                                        <li>
                                            <a href="javascript:void(0);" class="list-group-item text-right">
                                                <small class="font-600">See all alerts</small>
                                            </a>
                                        </li>
                                    </ul>
                                </li> -->
                                
                           
                                
                                       <li class="dropdown top-menu-item-xs">
                                    <a href="#" data-target="#" class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="true">
                                       <i class=" icon-envelope-open"></i><span class="badge badge-xs badge-danger"><label for="messagecount" id="messagecount"></label></span> 
                                    </a>
                                    <ul class="dropdown-menu dropdown-menu-lg">
                                        <li class="notifi-title"><span class="label label-default pull-right">New <label for="messagecountcopy" id="messagecountcopy"></label></span>Message</li>
                                        <li class="list-group slimscroll-noti notification-list" id="currentmessages">
                                        
                                        
                                    </ul>
                                </li>
                                  <li class="dropdown top-menu-item-xs">
                                    <a href="#" data-target="#" class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="true">
                                        <i class="icon-bell"></i><span class="badge badge-xs badge-danger"><label for="notificationcount" id="notificationcount"></label></span> 
                                    </a>
                                    <ul class="dropdown-menu dropdown-menu-lg">
                                        <li class="notifi-title"><span class="label label-default pull-right">New <label for="notificationcountcopy" id="notificationcountcopy"></label></span>Notification</li>
                                        <li class="list-group slimscroll-noti notification-list" id="currentnotifications">
                                        
                                        
                                    </ul>
                                </li>
                                  <li class="dropdown top-menu-item-xs">
                                    <a href="#" data-target="#" class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="true">
                                       <i class="fa fa-reply"></i><span class="badge badge-xs badge-danger"><label for="replymessagecount" id="replymessagecount"></label></span> 
                                    </a>
                                    <ul class="dropdown-menu dropdown-menu-lg">
                                        <li class="notifi-title"><span class="label label-default pull-right">New <label for="replymessagecountcopy" id="replymessagecountcopy"></label></span>Replied Message</li>
                                        <li class="list-group slimscroll-noti notification-list" id="currentreplymessages">
                                        
                                        
                                    </ul>
                                </li>
                                
                               <%--  </security:authorize> --%>
                                
                           
                                
                                 <li class="dropdown top-menu-item-xs">
                                    <a href="#" data-target="#" class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="true">
                                        <i class="md md-view-headline"></i><span class="badge badge-xs badge-danger"><label for="taskcount" id="taskcount"></label></span> 
                                    </a>
                                    <ul class="dropdown-menu dropdown-menu-lg">
                                        <li class="notifi-title"><span class="label label-default pull-right">New <label for="taskcountcopy" id="taskcountcopy"></label></span>Task</li>
                                        <li class="list-group slimscroll-noti notification-list" id="currenttask">
                                        
                                        
                                    </ul>
                                </li>
                                
                                
                                <li class="hidden-xs">
                                    <a href="#" id="btn-fullscreen" class="waves-effect waves-light"><i class="icon-size-fullscreen"></i></a>
                                </li>
                                <li class="hidden-xs">
                                    <a href="#" class="right-bar-toggle waves-effect waves-light"><i class="icon-settings"></i></a>
                                </li>
                                <li class="dropdown top-menu-item-xs">
                                    <a href="#" class="dropdown-toggle profile waves-effect waves-light" data-toggle="dropdown" aria-expanded="true"><img src="${pageContext.request.contextPath}${profile}" alt="user-img" class="img-circle"> </a>
                                    <ul class="dropdown-menu">
                                    <%-- <h4><c:out value="${name}"></c:out></h4> --%>
										<%-- <span><c:out value="${type}"></c:out></span> --%>
                                        <li><a href="javascript:void(0)"><i class="ti-user m-r-10 text-custom"></i> Profile</a></li>
                                        <li><a href="javascript:void(0)"><i class="ti-settings m-r-10 text-custom"></i> Settings</a></li>
                                        <li><a href="javascript:void(0)"><i class="ti-lock m-r-10 text-custom"></i> Lock screen</a></li>
                                        <li><a href="<c:url value='/edumaat/helpdesk'/>"><i class="ti-help m-r-10 text-custom"></i>Help Desk</a></li>
                                        <li class="divider"></li>
                                        <li> <a id="logout" href="<c:url value="/do_logout"/>"><i class="ti-power-off m-r-10 text-danger"></i> Logout</a> </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <!--/.nav-collapse -->
                    </div>
                </div>
            </div>
            <!-- Top Bar End -->	
			<div class="clearfix"> </div>	
			</form>
		
		
		<script src="${pageContext.request.contextPath}/resources/themes/script/menuheader.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/notifyjs/js/notify.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/notifications/notify-metro.js"></script>
            
		<!-- //header-ends -->