 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2)); 
$(document).ready(function() {
	 
	
	/* var datas=[];
	datas.push($("#editTargetUser").val());
	 
	 $("label[for=datas]").html(datas);*/
	 
	 
	 $("#targetUserId").prop('disabled', true);
 	 $("#saveCommunicationMessage").click(function(event)
 			 {
 		$("#communicationForm").validate();
 		if($("#communicationForm").valid())
 			{
 			 $('#targetUserId').attr('disabled', false);
 			
 				$('#communicationForm').submit();
 			}
				
				 return false;
 			
 		});
 	 
 	 $("#close").click(function(event){	
  		$('#close').submit();
 		 });
 	 
 	 $(document).on('click',".deletenotification",function (event){   
 		var communicationNotificationId=this.id;
 		 $("#communicationNotificationId").val(communicationNotificationId);
 		var data=$("#updateCommunicationNotificationForm").serialize();
		$.post(ctx+"/communication/usercommunicationnotification",data,function(data) {
			window.location.href=ctx+"/communication";
		});
		 
 	 });
 	 $(document).on('click',".deletesentnotification",function (event){   
  		var communicationNotificationId=this.id;
  		 $("#communicationNotificationId").val(communicationNotificationId);
  		var data=$("#updateSentCommunicationNotificationForm").serialize();
			$.post(ctx+"/communication/deletesentnotification",data,function(data) {
				window.location.href=ctx+"/communication";
			});
  	 });
 	 $(document).on('click',".movetoarchive",function (event){   
   		var communicationNotificationId=this.id;
   		 $("#communicationNotificationId").val(communicationNotificationId);
   		var data=$("#updateSentCommunicationNotificationForm").serialize();
		$.post(ctx+"/communication/sentnotificationmovetoarchive",data,function(data) {
			window.location.href=ctx+"/communication";
		});
  		 
   	 });
 	 
 	 
 	 $(document).on('click',".deletemessage",function (event){   
  		var communicationMessageId=this.id;
  		 $("#communicationMessageId").val(communicationMessageId);
  		var data=$("#updateCommunicationMessageForm").serialize();
 		$.post(ctx+"/communication/usercommunicationmessage",data,function(data) {
 			window.location.href=ctx+"/communication";
 		});
 		 
  	 });
  	 $(document).on('click',".deletesentmessage",function (event){   
   		var communicationMessageId=this.id;
   			 $("#communicationMessageId").val(communicationMessageId);
   		var data=$("#updateSentCommunicationMessageForm").serialize();
 			$.post(ctx+"/communication/deletesentmessage",data,function(data) {
 				window.location.href=ctx+"/communication";
 			});
   	 });
  	 $(document).on('click',".messagemovetoarchive",function (event){   
    		var communicationMessageId=this.id;
    		 $("#communicationMessageId").val(communicationMessageId);
    		var data=$("#updateSentCommunicationMessageForm").serialize();
 		$.post(ctx+"/communication/sentmessagemovetoarchive",data,function(data) {
 			window.location.href=ctx+"/communication";
 		});
   		 
    	 });
  	 
  	$(document).on('click',".replymessage",function (event){  
  		
		var communicationMessageId=this.id;
		$("#replyMessage").val($("#replymessage"+communicationMessageId).val());
		 $("#communicationMessageId").val(communicationMessageId);
		var data=$("#updateCommunicationMessageForm").serialize();
		$.post(ctx+"/communication/replycommunicationmessage",data,function(data) {
			window.location.href=ctx+"/communication";
		});
		 
	 });
  	
	$(document).on('click',".chatreplymessage",function (event){  
  		
		var communicationMessageId=this.id;
		$("#replyMessages").val($("#replymessage"+communicationMessageId).val());
		 $("#communicationRepliedMessageId").val(communicationMessageId);
		var data=$("#updateCommunicationReplyForm").serialize();
		$.post(ctx+"/communication/repliedmessage",data,function(data) {
			window.location.href=ctx+"/communication";
		});
		 
	 });
 	$(document).on('click',".deleterepliedmessage",function (event){  
  		
		var communicationMessageId=this.id;
		//	$("#communicationRepliedMessageId").val($("#repliedmessage"+communicationMessageId).val());
		 $("#communicationRepliedMessageId").val(communicationMessageId);
		var data=$("#updateCommunicationReplyForm").serialize();
		$.post(ctx+"/communication/deleterepliedmessage",data,function(data) {
			window.location.href=ctx+"/communication";
		});
		 
	 });
 	
 	
$(document).on('click',".deletesentreplymessage",function (event){  
  		
		var communicationMessageId=this.id;
		//	$("#communicationRepliedMessageId").val($("#repliedmessage"+communicationMessageId).val());
		 $("#communicationRepliedMessageId").val(communicationMessageId);
		var data=$("#updateCommunicationSentForm").serialize();
		$.post(ctx+"/communication/deletesentreplymessage",data,function(data) {
			window.location.href=ctx+"/communication";
		});
		 
	 });
 	var name="updateCommunicationReplyForm";
	if(document.getElementById(name))
	{
	var container = document.getElementById(name);
    var collection = container.getElementsByTagName('label');
    $("#replycount").html(collection.length);
    if(collection.length==0)
	{
	$("#updateCommunicationReplyForm").append( '<div class="alert alert-info">'+
		'<h5>Messages:</h5>'+
           '  <p>"No Messages Available"</p>'+
					'	</div>');
	}
	}
 	
	
	var name="updateCommunicationSentForm";
	if(document.getElementById(name))
	{
	var container = document.getElementById(name);
    var collection = container.getElementsByTagName('label');
    $("#sentcount").html(collection.length);
    if(collection.length==0)
    	{
    	$("#updateCommunicationSentForm").append( '<div class="alert alert-info">'+
			'<h5>Messages:</h5>'+
               '  <p>"No Messages Available"</p>'+
						'	</div>');
    	}
	}
	
 	$('#communicationTargetGroupId').change(function(event) 
 	{
 		
 		
 		
 		 $("#targetUserId").prop('disabled', true);
 		var val=$('#communicationTargetGroupId').val();
 		if(val==="6")
 		{
 			
 			$(".form-group-student").hide();
 			$(".form-group-parent").hide();
 			$(".form-group-staff").show();
 		
 		}
 		else if(val==="2")
 		{
 			$(".form-group-student").hide();
 			$(".form-group-parent").hide();
 			
 			$(".form-group-staff").hide();
 		
 		}
 		else if(val==="1" || val==="8")
 			{
 			$(".form-group-student").hide();
				$(".form-group-staff").hide();
				$(".form-group-parent").hide();
 		}
 		else if(val==="4")
 			{
 			$(".form-group-student").hide();
 				$(".form-group-staff").hide();
 				$(".form-group-parent").hide();
			
				
 			}
 		else if(val==="5")
			{
 			$(".form-group-student").hide();
				$(".form-group-staff").hide();
				$(".form-group-parent").show();
		
			 $.ajax({
 				   url:ctx+'/student/list',
 				   type:'GET',
 				   success: function(response)
 				   {
 					   var select = $('#targetAllParentId');
 		        	  if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#targetAllParentId').selectpicker('destroy');
		        	  }
		        	  else
		        	  {
		        		  select.find('option').remove();
		        		  $('#targetAllParentId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Users</option>');
		        	  }
 		        	   var composerId=$("#currentCommunicationComposerUserId").val();
 		        	 
 		        	   $.each(response, function(key,value) {
 		            		 if(key==0){
 		   	        	    	//	select.append('<option value="" disabled>Select Users</option>');
 		   	        	      }
 		            		 
 		            		 if(composer!=value.parentUser.email)
 		            			 $('<option>').val(value.parentUser.userId).text(value.parentUser.name+'['+value.parentUser.email+']').appendTo(select);
 		            		
 		            	 });
 		        	  var name="targetAllParentId";
 		        	 $('#targetAllParentId').selectpicker('show');
		        	 //  dynamicmultiselect(name);
 		        		},
 				   error:function(){
 					   alert("Error Occured");
 					  
 				   }
			 });
			}
 		else if(val==="3")
		{
			$(".form-group-staff").hide();
			$(".form-group-parent").hide();
			$(".form-group-student").hide();
				}
 		else if(val==="7")
		{
			$(".form-group-staff").hide();
			$(".form-group-parent").hide();
		$(".form-group-student").show();
		}
 	});
 	  $('.parentClass').change(function(event) {
	  	    var classId = $("#parentClass").val();
	  	     $.ajax({
				   url:ctx+'/classSection/'+classId,
				   type:'GET',
				   success: function(response){
					   var select = $('#parentSection');
					   if(response.length>0)
			        	  {
			        		  select.find('option').remove(); 
			        		  $('#parentSection').selectpicker('destroy');
			        	  }
			        	  else
			        	  {
			        		  select.find('option').remove();
			        		  $('#parentSection').selectpicker('destroy');
			        		  select.append('<option value="" disabled selected>Select Section</option>');
			        	  }
					   $.each(response, function(key,value) {
					  		 if(key==0){
					     	    		select.append('<option value="" disabled selected>Select Section</option>');
					     	    	}
					  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
					  	 }); 
					   $('#parentSection').selectpicker('show');
					 
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					}
				});
	   
	  	    });
	  $('.studentClass').change(function(event) {
	  	    var classId = $("#studentClass").val();
	  	    $.ajax({
				   url:ctx+'/classSection/'+classId,
				   type:'GET',
				   success: function(response){
					
					   
					   var select1 = $('#studentSection');
					   if(response.length>0)
			        	  {
			        		  select1.find('option').remove(); 
			        		  $('#studentSection').selectpicker('destroy');
			        	  }
			        	  else
			        	  {
			        		  select1.find('option').remove();
			        		  $('#studentSection').selectpicker('destroy');
			        		  select1.append('<option value="" disabled selected>Select Section</option>');
			        	  }
					   $.each(response, function(key,value) {
					  		 if(key==0){
					     	    		select1.append('<option value="" disabled selected>Select Section</option>');
					     	    	}
					  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select1);
					  	 }); 
					   $('#studentSection').selectpicker('show');
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					}
				});
	   
	  	    });
	
	  $('.parentSection').change(function(event)
			  {
	
	  	var classId=$("#parentClass").val();
	  	 var sectionId=$("#parentSection").val();
			 $.ajax({
				   url:ctx+'/student/classAndSection',
				   type:'GET',
				   data:{classId:classId,sectionId:sectionId},
				   success: function(response){
					   var composerId=$("#currentCommunicationComposerUserId").val();
	     	        	
	            		   
					   var select = $('#targetParentId');
					   if(response.length>0)
			        	  {
			        		  select.find('option').remove(); 
			        		  $('#targetParentId').selectpicker('destroy');
			        	  }
			        	  else
			        	  {
			        		  select.find('option').remove();
			        		  $('#targetParentId').selectpicker('destroy');
			        		  select.append('<option value="" disabled selected>Select User</option>');
			        	  }
						   $.each(response, function(key,value) {
					  		 if(key==0){
					     	    	//select.append('<option value="" disabled >Select User</option>');
					     	    	}
					  		 if(composerId!=value.parentUser.email)
					  			 $('<option>').val(value.parentUser.userId).text(value.parentUser.name+'['+value.parentUser.email+']').appendTo(select).trigger("change");
		            			
		            	 });
					   var name="targetParentId";
					   $('#targetParentId').selectpicker('show');
			        	// dynamicmultiselect(name);
					 
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					}
				});
	   
	  	    });
	  
	  $('.studentSection').change(function(event) {
		  	
			var classId=$("#studentClass").val();
		  	 var sectionId=$("#studentSection").val();
				 $.ajax({
					   url:ctx+'/student/classAndSection',
					   type:'GET',
					   data:{classId:classId,sectionId:sectionId},
					   success: function(response){
						   
						   var select1 = $('#targetStudentId');
						   if(response.length>0)
				        	  {
				        		  select1.find('option').remove(); 
				        		  $('#targetStudentId').selectpicker('destroy');
				        	  }
				        	  else
				        	  {
				        		  select1.find('option').remove();
				        		  $('#targetStudentId').selectpicker('destroy');
				        		  select1.append('<option value="" disabled selected>Select User</option>');
				        	  }
			        	   var composerId=$("#currentCommunicationComposerUserId").val();
		     	        	
			        	   $.each(response, function(key,value) {
			            		 if(key==0){
			   	        	    		//select.append('<option value="" disabled >Select Users</option>');
			   	        	      }
			            		
			            		 if(composerId!=value.user.email)
			            			 $('<option>').val(value.user.userId).text(value.user.name+'['+value.user.email+']').appendTo(select1);
			            		
			            	 });
			        	   
			        	   var name="targetStudentId";
			        	   $('#targetStudentId').selectpicker('show');
	 		        	//   dynamicmultiselect(name);
						 
					   },
					   error: function(){
						   alert('ERROR OCCURED');
						}
					});
		   
		  	    });
		  
 	$('#staffTypeId').change(function(event) {
		var staffTypeId=$('#staffTypeId').val();
		$('#targetUserId').attr('disabled', true);
		 $.ajax({
			   url:ctx+'/staffdesignation/stafftype/'+staffTypeId,
			   type:'GET',
			   success: function(response)
			   {
				   var select = $('#staffDesignationId');
	        	   select.find('option').remove();
	        	  
	        	   if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#staffDesignationId').selectpicker('destroy');
		        	  }
		        	  else
		        	  {
		        		  select.find('option').remove();
		        		  $('#staffDesignationId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Staff Designation</option>');
		        	  }
	        	   $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select Staff Designation</option>');
	   	        	    		//select1.append('<option value="" disabled selected>Select Users</option>');
	   	        	      }
	            		 $('<option>').val(value.staffDesignationId).text(value.staffDesignationName).appendTo(select);
	            	  
	            	 });
	        	   $('#staffDesignationId').selectpicker('show');
	        		},
			   error:function(){
				   alert("Error Occured");
				  
			   }
		});
	});
 	
	$('#staffDesignationId').change(function(event) {
		var staffDesignationId=$('#staffDesignationId').val();
		 $.ajax({
			   url:ctx+'/staff/staffdesignation/'+staffDesignationId,
			   type:'GET',
			   success: function(response)
			   {
				   //alert(response);
					 $('#targetUserId').attr('disabled', false);
				   var select = $('#targetUserId');
				   if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#targetUserId').selectpicker('destroy');
		        	  }
		        	  else
		        	  {
		        		  select.find('option').remove();
		        		  $('#targetUserId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select User</option>');
		        	  }	        	var composerId=$("#currentCommunicationComposerUserId").val();
	        	  $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		//select.append('<option value="" disabled>Select User</option>');
	   	        	    		//data[key] = new Option(value.user.name+'['+value.user.email+']', value.user.userId);
	   	        	      }
	            		
	            		 	
	            		   // $('<option/>').attr('value',optionValue).text(optionName).appendTo('#targetUserId');
	            		 if(composerId!=value.user.email)   
	            			 {
	            		 $('<option>').val( value.user.userId).text(value.user.name+'['+value.user.email+']').appendTo(select);
	            			 }
	            		
						 });
	        	  $('#targetUserId').selectpicker('show');
	        	   var name="targetUserId";
		        	  
		        	   //dynamicmultiselect(name);
	        		},
			   error:function(){
				   alert("Error Occured");
				 
			   }
		});
	});
 	
	     });

 function dynamicmultiselect(selectid) {
		$('.'+selectid).multiselect({
			columns:2,
		    placeholder: 'Select Users',
		    search: true,
		    selectAll: true
		});
	}

