
var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2)); 
$(document).ready(function() {


	 myalert();
		setInterval(function() {
			/*var notificationcountfortask=$("#notificationcountfortask").val();
			var notificationcountformessage=$("#notificationcountformessage").val();
			var notificationcountforreplymessage=$("#notificationcountforreplymessage").val();
			var notificationcountfornotification=$("#notificationcountfornotification").val();*/
			myalert();
		/*	if($("#notificationcountfornotification").val()>notificationcountfornotification)
				{
				$.Notification.autoHideNotify('info', 'top right', 'You Have New Notification...','Check Your Inbox..')
               }
			if($("#notificationcountfortask").val()>notificationcountfortask)
			{
		 $.Notification.autoHideNotify('success', 'top right', 'You Have New Task...','Check Your Inbox..')
           }
			if($("#notificationcountformessage").val()>notificationcountformessage)
			{
		  $.Notification.autoHideNotify('warning', 'top right', 'You Have New Message...','Check Your Inbox..')
           }
			if($("#notificationcountforreplymessage").val()>notificationcountforreplymessage)
			{
			  $.Notification.autoHideNotify('error', 'top right', 'You Have New ReplyMessage...','Check Your Inbox..')
           }*/
		}, 20000);
		
		
	
});

function myalert(){
	
	 $.ajax({
		   url:ctx+'/user/userdetails/',
		   type:'GET',
		   success: function(response)
		   {
			    $("#currentmessages").empty();
			   $("#currentnotifications").empty();
			   $("#currentreplymessages").empty();
			   $("#currenttask").empty();
			   var messagescount=0;
			   var messageslink="";
			  /* $("#currentmessages").append('<li>'+
						'<div class="notification_header">'+
						'	<h3>You have <label for="messagecount1" id="messagecount1"></label> new messages</h3>'+
						'</div>'+
					'</li>'
			   );*/
			      $.each(response.portalMessages, function(key1,index)
					   {
			 
			    	  if(index.portalMessageStatus=="1")
			    	  { 
			    		  messagescount=messagescount+1;
			    	  }
			    	 messageslink=ctx+index.portalMessageLink;
			    	 /* var date=$.datepicker.formatDate('mm/dd/yy',new Date(index.createdDate));*/
			    	 $.date = function(dateObject) {
						    var d = new Date(dateObject);
						    var day = d.getDate();
						    var month = d.getMonth() + 1;
						    var year = d.getFullYear();
						    if (day < 10) {
						        day = "0" + day;
						    }
						    if (month < 10) {
						        month = "0" + month;
						    }
						    var date = day + "/" + month + "/" + year;

						    return date;
						};
		        	var date = $.date(index.createdDate);
			    	  if(messagescount<=5){
			    		  $("#currentmessages").append('<a href="'+messageslink+'" data-id='+index.portalMessageId+' class="list-group-item messageClick">'+
					                 '  <div class="media">'+
				                     ' <div class="pull-left p-r-10">'+
				                     '    <em class="fa fa-diamond noti-primary"></em>'+
				                     ' </div>'+
				                     ' <div class="media-body">'+
				                       '  <h5 class="media-heading">'+index.portalMessageSubject+'</h5>'+
				                      '   <p class="m-0">'+
				                        '     <small>'+date+'</small>'+
				                       '  </p>'+
				                     ' </div>'+
				                  ' </div>'+
				              '  </a>'); 
			    		  
			    	  }
			    	  
			    	  	}); 
			 /*  $("#notificationcountformessage").val(messagescount);*/
			   $("#messagecount").html(messagescount);
			   $("#messagecountcopy").html(messagescount);
			   $("#currentmessages").append( ' <li>'+
	             '  <a href="'+messageslink+'" class="list-group-item text-right messageClickAll">'+
	                '   <small class="font-600">See all messages</small>'+
	              ' </a>'+
	          ' </li>');
			  
			   var count=0;
			   var link="";
			   var dataid="";
			 /*  $("#currentnotifications").append(  ' <li>'+
						'<div class="notification_header">'+
						'	<h3>You have <label for="notificationcount1" id="notificationcount1"></label> new notifications</h3>'+
						'</div>'+
				'	</li>'
					  );*/
			 
			  	   $.each(response.portalNotifications, function(key,value)
					   {
				 
			  		 
			  		 if(value.portalNotificationStatus=="1")
			  		 { 
			  			 count=count+1;
			  		 }
			  		link=ctx+value.portalNotificationLink;
				  /* var date=$.datepicker.formatDate('mm/dd/yy',new Date(value.createdDate));*/
			  	  	 $.date = function(dateObject) {
						    var d = new Date(dateObject);
						    var day = d.getDate();
						    var month = d.getMonth() + 1;
						    var year = d.getFullYear();
						    if (day < 10) {
						        day = "0" + day;
						    }
						    if (month < 10) {
						        month = "0" + month;
						    }
						    var date = day + "/" + month + "/" + year;

						    return date;
						};
		        	var date = $.date(value.createdDate);
				   if(count<=5){
				   $("#currentnotifications").append(	'  <a href="'+link+'" data-id='+value.portalNotificationId+' class="list-group-item notificationClick">'+
					                 '  <div class="media">'+
				                     ' <div class="pull-left p-r-10">'+
				                     '    <em class="fa fa-diamond noti-primary"></em>'+
				                     ' </div>'+
				                     ' <div class="media-body">'+
				                       '  <h5 class="media-heading">'+value.portalNotificationSubject+'</h5>'+
				                      '   <p class="m-0">'+
				                        '     <small>'+date+'</small>'+
				                       '  </p>'+
				                     ' </div>'+
				                  ' </div>'+
				              '  </a>'); 
				   }
			  	 }); 
			  	/*  $("#notificationcountfornotification").val(count);*/
			   $("#notificationcount").html(count);
			   $("#notificationcountcopy").html(count);
			   $("#currentnotifications").append(' <li>'+
	             '  <a href="'+link+'" class="list-group-item text-right notificationClickAll">'+
	                '   <small class="font-600">See all notifications</small>'+
	              ' </a>'+
	          ' </li>');
			 
			
			   var replycount=0;
			   var replylink="";
			  /* $("#currentreplymessages").append(
					   
						'<li>'+
						'<div class="notification_header">'+
						'<h3>You have <label for="replymessagecount1" id="replymessagecount1"></label> replied messages</h3>'+
				'	</div>'+
				'</li>'
					);*/
			  	   $.each(response.portalReplyMessages, function(key,value)
					   {
					 if(value.portalReplyMessageStatus=="1")
			  		 { 
			  			replycount=replycount+1;
			  		
			  		replylink=ctx+value.portalReplyMessageLink;
				 /*  var date=$.datepicker.formatDate('mm/dd/yy',new Date(value.createdDate));*/
			  	  	 $.date = function(dateObject) {
						    var d = new Date(dateObject);
						    var day = d.getDate();
						    var month = d.getMonth() + 1;
						    var year = d.getFullYear();
						    if (day < 10) {
						        day = "0" + day;
						    }
						    if (month < 10) {
						        month = "0" + month;
						    }
						    var date = day + "/" + month + "/" + year;

						    return date;
						};
		        	var date = $.date(value.createdDate);
				   if(replycount<=5){
				   $("#currentreplymessages").append('  <a href="'+replylink+'" data-id='+value.portalReplyMessageId+' class="list-group-item replyClick">'+
					                 '  <div class="media">'+
				                     ' <div class="pull-left p-r-10">'+
				                     '    <em class="fa fa-diamond noti-primary"></em>'+
				                     ' </div>'+
				                     ' <div class="media-body">'+
				                       '  <h5 class="media-heading">'+value.portalReplyMessageSubject+'</h5>'+
				                      '   <p class="m-0">'+
				                        '     <small>'+date+'</small>'+
				                       '  </p>'+
				                     ' </div>'+
				                  ' </div>'+
				              '  </a>'); 
				   }
			  		  }
			  	 }); 
			 	/*  $("#notificationcountforreplymessage").val(replycount);*/
			   $("#replymessagecount").html(replycount);
			   $("#replymessagecountcopy").html(replycount);
			   $("#currentreplymessages").append(' <li>'+
	             '  <a href="'+replylink+'" class="list-group-item text-right replyClickAll">'+
	                '   <small class="font-600">See all replied messages</small>'+
	              ' </a>'+
	          ' </li>');
			   var tasklink="";
			   var taskCount=0;
			 /*  $("#currenttask").append('<li>'+
						'<div class="notification_header">'+
						'	<h3>You have <label for="taskcount" id="taskcount"></label> new task</h3>'+
						'</div>'+
					'</li>'
			   );*/
			   $.each(response.portalTasks, function(key,value)
					   {
					 if(value.portalTaskStatus=="1")
			  		 { 
						 taskCount=taskCount+1;
			  		
			  			tasklink=ctx+value.portalTaskLink;
			  			//$.datepicker.formatDate('mm/dd/yy',new Date(value.createdDate));
			  			 $.date = function(dateObject) {
							    var d = new Date(dateObject);
							    var day = d.getDate();
							    var month = d.getMonth() + 1;
							    var year = d.getFullYear();
							    if (day < 10) {
							        day = "0" + day;
							    }
							    if (month < 10) {
							        month = "0" + month;
							    }
							    var date = day + "/" + month + "/" + year;

							    return date;
							};
			        	var date = $.date(value.createdDate);
				    if(taskCount<=5){
				   $("#currenttask").append( '  <a href="'+tasklink+'" data-id='+value.portalTaskId+' class="list-group-item taskClick">'+
			                 '  <div class="media">'+
		                     ' <div class="pull-left p-r-10">'+
		                     '    <em class="fa fa-diamond noti-primary"></em>'+
		                     ' </div>'+
		                     ' <div class="media-body">'+
		                       '  <h5 class="media-heading">'+value.portalTaskSubject+'</h5>'+
		                      '   <p class="m-0">'+
		                        '     <small>'+date+'</small>'+
		                       '  </p>'+
		                     ' </div>'+
		                  ' </div>'+
		              '  </a>'); 
				   
				
				   }
			  		  }
			  	 }); 
				 /* $("#notificationcountfortask").val(taskCount);*/
			   $("#taskcount").html(taskCount);
			   $("#taskcountcopy").html(taskCount);
			/*   $("#taskcount1").html(taskCount);*/
			   $("#currenttask").append( ' <li>'+
			             '  <a href="'+tasklink+'" class="list-group-item text-right taskClickAll">'+
			                '   <small class="font-600">See all tasks</small>'+
			              ' </a>'+
			          ' </li>');
			  
      		},
		   error:function()
		   {
			  /* edumaatAlert({
	    			  title: "Info !",
	    			  text: "Error Occured!",
	    			  type: "info",
	    			  confirmButtonText: "OK"
	    			});*/
			 
		   }
      		
	 });
		}
	 

 $(document).on('click',".notificationClick",function (event)
		 {   
			 var portalNotificationId=$(this).attr('data-id');
			 $("#portalNotificationId").val(portalNotificationId);
			  var data=$("#menuHeaderForm").serialize();
			 $.ajax({
				   url:ctx+'/communication/userportalnotification',
				   type:'POST',
				   data:data,
				   success: function(response)
				   {}
			 	});
		 	 });
		 	
		 $(document).on('click',".notificationClickAll",function (event)
				 {   
					 $.ajax({
						   url:ctx+'/communication/userallportalnotification',
						   type:'POST',
						   success: function(response)
						   {}
					 	});
				 	 });
		 
		 $(document).on('click',".messageClick",function (event)
				 {   
					 var portalMessageId=$(this).attr('data-id');
					 $("#portalMessageId").val(portalMessageId);
					 var data=$("#menuHeaderForm").serialize();
					 $.ajax({
						   url:ctx+'/communication/userportalmessage',
						   type:'POST',
						   data:data,
						   success: function(response)
						   {}
					 	});
				 	 });
				 	
				 $(document).on('click',".messageClickAll",function (event)
						 {   
							 $.ajax({
								   url:ctx+'/communication/userallportalmessage',
								   type:'POST',
								   success: function(response)
								   {}
							 	});
						 	 });
				 
				 
				 
				 $(document).on('click',".replyClick",function (event)
						 {   
							 var replylMessageId=$(this).attr('data-id');
							 $("#replyMessageId").val(replylMessageId);
							 var data=$("#menuHeaderForm").serialize();
							 $.ajax({
								   url:ctx+'/communication/userreplymessage',
								   type:'POST',
								   data:data,
								   success: function(response)
								   {}
							 	});
						 	 });
				 
				 $(document).on('click',".replyClickAll",function (event)
						 {   
							 $.ajax({
								   url:ctx+'/communication/userallreplymessage',
								   type:'POST',
								   success: function(response)
								   {}
							 	});
						 	 });
				 $(document).on('click',".taskClick",function (event)
						 {   
							 var portalTaskId=$(this).attr('data-id');
							 $("#portalTaskId").val(portalTaskId);
							 var data=$("#menuHeaderForm").serialize();
							 $.ajax({
								   url:ctx+'/communication/userportaltask',
								   type:'POST',
								   data:data,
								   success: function(response)
								   {}
							 	});
						 	 });
				 
				 $(document).on('click',".taskClickAll",function (event)
						 {   
							 $.ajax({
								   url:ctx+'/communication/userallportaltask',
								   type:'POST',
								   success: function(response)
								   {}
							 	});
						 	 });