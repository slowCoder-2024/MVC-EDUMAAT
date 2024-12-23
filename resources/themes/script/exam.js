$(document).ready(function() {
var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));		
	 $('#class').change(function(event) {
			var classId = $("#class").val();
		  	    $.ajax({
					   url:ctx+'/classSection/'+classId,
					   type:'GET',
					   success: function(response){
						   var select = $('#section');
						 
						   
						   
						   if(response.length>0)
				        	  {
							   select.find('option').remove();
				        		  $('#section').selectpicker('destroy');
				        	  }
				        	  else
				        	  {
				        		  select.find('option').remove();
				        		  $('#section').selectpicker('destroy');
				        		  select.append('<option value="" disabled selected>Select Section</option>');
				        	  }
						   $.each(response, function(key,value) {
						  		 if(key==0){
						     	    		select.append('<option value="" disabled selected>Select Section</option>');
						     	    	}
						  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
						  	 }); 
						   $('#section').selectpicker('show');
					   },
					   error: function(){
						   edumaatAlert({
				        		  title: 'Error!',
				        		  text: 'Do you want to continue',
				        		  type: 'error',
				        		}).then(
				        	       function(){
				        	    	   window.location.href = ctx+"/exam";
				        	    	   
				        	       }		
				        		)
				       }
					
	   		});

		  		       
		 });
		$("#section").change(function() {
			 var classId = $("#class").val();
			 var sectionId = $("#section").val();
		   $.get(ctx+'/classSection/termAndExam', {
				 classId   : classId,
				 sectionId : sectionId
	        },function(response){
	        	 var select = $('#classSectionTermExamId');
				   select.find('option').remove();
				   if(response.length>0)
		        	  {
					   select.find('option').remove();
		        		  $('#classSectionTermExamId').selectpicker('destroy');
		        	  }
		        	  else
		        	  {
		        		  select.find('option').remove();
		        		  $('#classSectionTermExamId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Section</option>');
		        	  }
				   $.each(response, function(key,value) {
				  		 if(key==0){
				     	    		select.append('<option value="" disabled selected>Select Term Exam</option>');
				     	    	}
				  		$('<option>').val(value.classSectionTermExamId).text(value.classSectionTermExamName).appendTo(select);
	        			

				  	 }); 
				   $('#classSectionTermExamId').selectpicker('show');
	     
	        });

			  //
	  	    $.ajax({
				   url:ctx+'/exam/assessmentType',
				   type:'GET',
				   data:{classId:classId,sectionId:sectionId},
				   success: function(response){
					   
					   
					 if(response.length>0){
						 var select = $('#assessmentType');
						   select.find('option').remove();
						   $('#assessmentType').selectpicker('destroy');
						 $.each(response, function(key,value) {
					  		 
							 if(key==0){
				     	    		select.append('<option value="" disabled selected>Select Assessment Type</option>');
				     	    	}
				  		$('<option>').val(value.classSectionAssesmentTypeId).text(value.classSectionAssesmentName).appendTo(select);
							

						  	 }); 
						 
						 $('#assessmentType').selectpicker('show');
					 }else{
						 edumaatAlert({
							  title: 'warning',
							  type:'warning',
							  text: 'Assessment Type Not Found'
							}).then(
							  function () {
								  window.location.href = ctx+"/exam";
								  
							  }
							 
							)
						 
					 }
					  
				   },
				   error: function(){
					   edumaatAlert({
			        		  title: 'Error!',
			        		  text: 'Do you want to continue',
			        		  type: 'error',
			        		}).then(
			        	       function(){
			        	    	   window.location.href = ctx+"/exam";
			        	    	   
			        	       }		
			        		)
			       }
				
		});
		});	
		
		
		$("#assessmentType").change(function() {
			
			$('#classSectionTermExamId').selectpicker('show');
						
		});
		
		$("#classSectionTermExamId").change(function() {
			
			if($("#assessmentType").val()!=null && $("#classSectionTermExamId").val()!=null){
				
				
				 var AssessmentTypeName = $('#assessmentType option:selected').text().trim();
				 var classSectionTermExamId = $("#classSectionTermExamId").val();
	             $("#showtabledata").show();
	             $("#studentmarksdata,#tableheaddata").empty();
	             
				 if(AssessmentTypeName=="ModulesBased"){
					 
					 $("#tableheaddata").append(' <tr id="activitynamelist"><th style="width: 5px">Module Name/Exam Activity</th></tr>')
					 
					 
					 $.get(ctx+'/exam/classSectionModuleExamEager', {
						   classSectionTermExamId   : classSectionTermExamId
				        },function(response){
				        	 if(response.length>0){
				        	 $.each(response, function(key,value) {
							 $("#studentmarksdata").append('<tr><th scope="row" id="">'+value.classSectionModule.module.moduleName+'</th><td style="display:none">'+value.classSectionModule.classSectionModuleId+'</td></tr>');
							  	 }); 
							 
				        	 //term exam activity
							    $.ajax({
									   url:ctx+'/exam/classSectionTermExamActivity',
									   type:'GET',
									   data:{classSectionTermExamId:classSectionTermExamId},
									   success: function(response1){
										 if(response1.length>0){
											
													  
													  
													  
														
														   
													   
														   $.each(response1, function(key,value) {
													
											        			$("#activitynamelist").append('<th style="width: 50px" id='+value.classSectionTermExamActivityId+'>'+value.activityName+'</th>');
											        			
											        			$( "#studentmarksdata tr th").after('<td><input type="text" onkeypress="return isNumber(event)" name="" class="form-control" id='+value.classSectionTermExamActivityId+' required="required"></input></td>');
											        			
										        		
														  	 });
													
											 
											
										 }else{
											 edumaatAlert({
												  title: 'warning',
												  type:'warning',
												  text: 'Activity Not Found '
												}).then(
												  function () {
													  window.location.href = ctx+"/exam";
												  }
												 
												)
											 
										 }
										  
									   },
									   error: function(){
										   edumaatAlert({
								        		  title: 'Error!',
								        		  text: 'Do you want to continue',
								        		  type: 'error',
								        		}).then(
								        	       function(){
								        	    	   window.location.href = ctx+"/exam";
								        	    	   
								        	       }		
								        		)
								       }
									
							});
							 
							 
							 
							 
				        	 }else{
				        		 
				        		 edumaatAlert({
									  title: 'warning',
									  type:'warning',
									  text: 'Module Not Found'
									}).then(
									  function () {
										  window.location.href = ctx+"/exam";
										  
									  }
									 
									)
				        		 
				        	 }
				        });
			  	
				 }
				 
				 if(AssessmentTypeName=="ModuleAndSkillBased"){
					 $("#tableheaddata").append(' <tr id="activitynamelist"><th style="width: 5px">Module Name/Exam Activity</th></tr>')

					 $.get(ctx+'/exam/classSectionModuleSkillExamEager', {
						   classSectionTermExamId   : classSectionTermExamId
				        },function(response){
				        	 if(response.length>0){ 
							 $.each(response, function(key,value1) {
									

								 $.each(value1.classSectionModuleSkill.moduleSkill.moduleSkillIndicators, function(key,value) {
									 
									 $("#studentmarksdata").append('<tr><th scope="row"><p style="color:red"><u>'+value1.classSectionModuleSkill.moduleSkill.moduleSkillName+'</u></p>'+value.moduleSkillIndicatorName+'</th></tr>');

									 
									 
								 });
					      		 });
							 
						  	 //term exam activity
							    $.ajax({
									   url:ctx+'/exam/classSectionTermExamActivity',
									   type:'GET',
									   data:{classSectionTermExamId:classSectionTermExamId},
									   success: function(response1){
										 if(response1.length>0){
											
													  
													  
													  
														
														   
													   
														   $.each(response1, function(key,value) {
													
											        			$("#activitynamelist").append('<th style="width: 50px">'+value.activityName+'</th>');
											        			
											        			$( "#studentmarksdata tr th").after('<td><input type="text" onkeypress="return isNumber(event)" name="" class="form-control" id="" required="required"></input></td>');
											        			
										        		
														  	 });
													
											 
											
										 }else{
											 edumaatAlert({
												  title: 'warning',
												  type:'warning',
												  text: 'Exam Activity Not Found '
												}).then(
												  function () {
													  window.location.href = ctx+"/exam";
												  }
												 
												)
											 
										 }
										  
									   },
									   error: function(){
										   edumaatAlert({
								        		  title: 'Error!',
								        		  text: 'Do you want to continue',
								        		  type: 'error',
								        		}).then(
								        	       function(){
								        	    	   window.location.href = ctx+"/exam";
								        	    	   
								        	       }		
								        		)
								       }
									
							});
							 
							 
							 
							 
				        	 }else{
				        		 
				        		 edumaatAlert({
									  title: 'warning',
									  type:'warning',
									  text: 'Module Skill Not Found'
									}).then(
									  function () {
										  window.location.href = ctx+"/exam";
										  
									  }
									 
									)
				        		 
				        	 }
				        });
					 
					 
				 }
				 
	 if(AssessmentTypeName=="CoScholasticArea"){
		 $("#tableheaddata").append(' <tr id="activitynamelist"><th style="width: 5px">Module Name/Exam Activity</th></tr>')

		 $.get(ctx+'/exam/classSectionCoScholasticAreaExamEager', {
			   classSectionTermExamId   : classSectionTermExamId
	      },function(response){
	      	 if(response.length>0){
	      		 
	      		 $.each(response, function(key,value1) {
					

				 $.each(value1.classSectionCoScholasticArea.coScholasticArea.coScholasticAreaIndicators, function(key,value) {
					 
					 $("#studentmarksdata").append('<tr><th scope="row"><p style="color:red"><u>'+value1.classSectionCoScholasticArea.coScholasticArea.coScholasticAreaName+'</u></p>'+value.coScholasticAreaIndicatorName+'</th></tr>');

					 
					 
				 });
	      		 });
	      		
			  	 //term exam activity
				    $.ajax({
						   url:ctx+'/exam/classSectionTermExamActivity',
						   type:'GET',
						   data:{classSectionTermExamId:classSectionTermExamId},
						   success: function(response1){
							 if(response1.length>0){
								
										  
										  
										  
											
											   
										   
											   $.each(response1, function(key,value) {
										
								        			$("#activitynamelist").append('<th style="width: 50px">'+value.activityName+'</th>');
								        			
								        			$( "#studentmarksdata tr th").after('<td><input type="text" onkeypress="return isNumber(event)" name="" class="form-control" id="" required="required"></input></td>');
								        			
							        		
											  	 });
										
								 
								
							 }else{
								 edumaatAlert({
									  title: 'warning',
									  type:'warning',
									  text: 'Exam Activity Not Found '
									}).then(
									  function () {
										  window.location.href = ctx+"/exam";
									  }
									 
									)
								 
							 }
							  
						   },
						   error: function(){
							   edumaatAlert({
					        		  title: 'Error!',
					        		  text: 'Do you want to continue',
					        		  type: 'error',
					        		}).then(
					        	       function(){
					        	    	   window.location.href = ctx+"/exam";
					        	    	   
					        	       }		
					        		)
					       }
						
				});
	      		 
	      		 
	      		 
	      	 }else{
	      		 
	      		edumaatAlert({
					  title: 'warning',
					  type:'warning',
					  text: 'Co-Scholastic Area And Indicator Not Found'
					}).then(
					  function () {
						  window.location.href = ctx+"/exam";
						  
					  }
					 
					)
	      		 
	      	 }
	      });
					 
					 
				 }
	 if(AssessmentTypeName=="CoScholasticActivity"){
		 $("#tableheaddata").append(' <tr id="activitynamelist"><th style="width: 5px">Module Name/Exam Activity</th></tr>')
		 
		 $.get(ctx+'/exam/classSectionCoScholasticActivityExamEager', {
			   classSectionTermExamId   : classSectionTermExamId
	    },function(response){
	    	 if(response.length>0){
				 $.each(response, function(key,value1) {
			  		 
					 $.each(value1.classSectionCoScholasticActivity.coScholasticActivity.coScholasticActivityIndicators, function(key,value) {
						 
						 $("#studentmarksdata").append('<tr><th scope="row"><p style="color:red"><u>'+value1.classSectionCoScholasticActivity.coScholasticActivity.coScholasticActivityName+'</u></p>'+value.coScholasticActivityIndicatorName+'</th></tr>');

						 
						 
					 });
					

				  	 }); 
				 
				 
				//term exam activity
				    $.ajax({
						   url:ctx+'/exam/classSectionTermExamActivity',
						   type:'GET',
						   data:{classSectionTermExamId:classSectionTermExamId},
						   success: function(response1){
							 if(response1.length>0){
								
										  
										  
										  
											
											   
										   
											   $.each(response1, function(key,value) {
										
								        			$("#activitynamelist").append('<th style="width: 50px">'+value.activityName+'</th>');
								        			
								        			$( "#studentmarksdata tr th").after('<td><input type="text" onkeypress="return isNumber(event)" name="" class="form-control" id="" required="required"></input></td>');
								        			
							        		
											  	 });
										
								 
								
							 }else{
								 edumaatAlert({
									  title: 'warning',
									  type:'warning',
									  text: 'Exam Activity Not Found '
									}).then(
									  function () {
										  window.location.href = ctx+"/exam";
									  }
									 
									)
								 
							 }
							  
						   },
						   error: function(){
							   edumaatAlert({
					        		  title: 'Error!',
					        		  text: 'Do you want to continue',
					        		  type: 'error',
					        		}).then(
					        	       function(){
					        	    	   window.location.href = ctx+"/exam";
					        	    	   
					        	       }		
					        		)
					       }
						
				});
				 
	    	 }else{
	    		 
	    		 edumaatAlert({
					  title: 'warning',
					  type:'warning',
					  text: 'Co-Scholastic Activity And Indicator Not Found'
					}).then(
					  function () {
						  window.location.href = ctx+"/exam";
						  
					  }
					 
					)
	    		 
	    	 }
	    });
		 
		 
	 } 
				
				
				
			}

			
		});
		
	
		
	$("#updatemarksvalid").click(function(){
			
			
		var madulebasedmarkupdatedetails= [];
		$('tbody#studentmarksdata tr').each(function () {
			var $tds = $(this).find('td');
			var data1=$tds.eq(1).text()
		    var data2=$tds.eq(0).find('input').val();
			var datah=$tds.eq(0).find('input').attr('id');
		
			madulebasedmarkupdatedetails.push(datah+'-'+data1+"-"+data2);
	            });
		$("#moduleBasedMarksUpdateDetails").val(madulebasedmarkupdatedetails);
		
	
			
				
		$("#savestudentmarkconfirmation").modal('show');
		$("#savestudentmarkconfirm").click(function(event) {
			 var studentId = $("#studentId").val();
			 var classId = $("#classId").val();
			 var sectionId = $("#sectionId").val();
			 var assessmentType = $("#assessmentType").val();
			 var classSectionTermExamId = $("#classSectionTermExamId").val();
			 var moduleBasedMarksUpdateDetails = $("#moduleBasedMarksUpdateDetails").val();
			 
			
			 
			 ajaxSent=$.post(ctx+"/exam/save", {
			        studentId:studentId,classId:classId,sectionId:sectionId,assessmentType:assessmentType,classSectionTermExamId:classSectionTermExamId,moduleBasedMarksUpdateDetails:moduleBasedMarksUpdateDetails
				 }, function(data) {
				 /*alert(data);*/
							 });
			 
			/* if(ajaxSent){
	               ajaxSent.abort();
	            }*/
			
			
		  /*  $.ajax(	
			    {
			        type: "POST",
			        url:ctx+"/exam/save",
			        data: {studentId:studentId,classId:classId,sectionId:sectionId,assessmentType:assessmentType,classSectionTermExamId:classSectionTermExamId,moduleBasedMarksUpdateDetails:moduleBasedMarksUpdateDetails},
			        contentType: "application/json; charset=utf-8",
			        dataType: "json",
			        cache: false,
			        success:function (data) {
			        	
			        	
			        	alert(data)
			     
			        }	
			    });
			*/
			
			
		});
			    
	  	    
	  	    
		});
	
	
	
	 $('#currClass').change(function(event) {
			var currClassId = $("#currClass").val();
		  	    $.ajax({
					   url:ctx+'/classSection/'+currClassId,
					   type:'GET',
					   success: function(response){
						   var select = $('#currSection');
						  
						   
						   if(response.length>0)
				        	  {
							   select.find('option').remove();
				        		  $('#currSection').selectpicker('destroy');
				        	  }
				        	  else
				        	  {
				        		  select.find('option').remove();
				        		  $('#currSection').selectpicker('destroy');
				        		  select.append('<option value="" disabled selected>Select Section</option>');
				        	  }
						   
						   
						   $.each(response, function(key,value) {
						  		 if(key==0){
						     	    		select.append('<option value="" disabled selected>Select Section</option>');
						     	    	}
						  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
						  	 }); 
						   
						   $('#currSection').selectpicker('show');
					   },
					   error: function(){
						   edumaatAlert({
				        		  title: 'Error!',
				        		  text: 'Do you want to continue',
				        		  type: 'error',
				        		}).then(
				        	       function(){
				        	    	   window.location.href = ctx+"/exam";
				        	    	   
				        	       }		
				        		)
				       }
					
	   		});

		  		       
		 });
	
	
	
	 $("#getStudentReport").click(function(event){
		 
		
		 
		
					 var classId = $("#currClass").val();
		        	 var sectionId = $("#currSection").val();
			 
		  		 
			 
			 
			   $.ajax(	
					    {
					        type: "POST",
					        url:ctx+"/exam/getStudentMarkDetails" ,
					        data:{currClass:classId,currSection:sectionId},
					        contentType: "application/json; charset=utf-8",
					        dataType: "json",
					        cache: false,
					        success:function (data) {
					        /*	$('.loader').hide();
					        	if(data.length>0){
						        	var datatable = $('#invoiceList').DataTable();
						        	 $(".form-horizontal").trigger('reset'); 
										      datatable.clear().draw();
										  $.each(data, function (i, item) {
											  if(item!=null){
												  var name;
										        	if(item.lastName!=null){
										        		name=item.firstName+' '+item.lastName;
										        	}else{
										        		name=item.firstName;
										        	}
										        	datatable.row.add(['<input type="checkbox" value='+item.studentId+' name="studentId" class="case" id='+item.studentId+'></input>',item.admissionNo,name,item.studentClass.className,item.section.sectionName]).draw( false );
											  }
											 });
					        	}
					        	else{
					        		edumaatAlert({
										 type:'success',
										 text:'Invoice Already Generated'
									 }).then(function(){
							        		window.location.href=ctx+'/invoice';
							        		
							        	});
					        	}*/
					      },
					        error:function(){
					        	
					        	alert("cool")
					        /*	 $('.loader').hide();
					        	$(".form-horizontal").trigger('reset'); 
					        	document.getElementById('invoicedetailsdiv').style.display="none";
					        	edumaatAlert({
									 type:'error',
									 text:'Invalid Student'
								 }).then(function(){
						        		window.location.href=ctx+'/invoice';
						        		
						        });*/
					        }
					      
					    });
			 
		
});
	 
	 
		$("#currSection").change(function() {
	 
	 var classId = $("#currClass").val();
	 var sectionId = $("#currSection").val();

	   $.get(ctx+'/classSection/termAndExam', {
		 classId   : classId,
		 sectionId : sectionId
    },function(response){
    	
    	$(".assessment").show();
    	 var select = $('#formativeassessment');
    	 if(response.length>0)
   	  {
		   select.find('option').remove();
   		  $('#formativeassessment').selectpicker('destroy');
   	  }
   	  else
   	  {
   		  select.find('option').remove();
   		  $('#formativeassessment').selectpicker('destroy');
   		  select.append('<option value="" disabled>Select Formative Assessment Only</option>');
   	  }
		   
		   $.each(response, function(key,value) {
		  		 if(key==0){
		     	    		select.append('<option value="" disabled>Select Formative Assessment Only</option>');
		     	    	}
		  		$('<option>').val(value.classSectionTermExamId).text(value.classSectionTermExamName).appendTo(select);
    			

		  	 }); 
		   $('#formativeassessment').selectpicker('show');
			 var select = $('#summativeassessment');
			 if(response.length>0)
		   	  {
				   select.find('option').remove();
		   		  $('#summativeassessment').selectpicker('destroy');
		   	  }
		   	  else
		   	  {
		   		  select.find('option').remove();
		   		  $('#summativeassessment').selectpicker('destroy');
		   		  select.append('<option value="" disabled >Select Summative Assessment Only</option>');
		   	  }
			   $.each(response, function(key,value) {
			  		 if(key==0){
			     	    		select.append('<option value="" disabled >Select Summative Assessment Only</option>');
			     	    	}
			  		$('<option>').val(value.classSectionTermExamId).text(value.classSectionTermExamName).appendTo(select);
        			

			  	 }); 
			   $('#summativeassessment').selectpicker('show');
    });
		 });
		
		
		
		
		$("#getStudentMarkDetails").click(function(event) {
			 if($("#studentGPAndCGPACalculationForm").valid())
				{
					$("#getStudentMarkDetailsConfirmation").modal('show');
					$("#getStudentMarkDetailsConfirm").click(function(event) {
						$("#studentGPAndCGPACalculationForm").submit();
					});
					
				}
	});
		
		
		 $('#displayClass').change(function(event) {
				var displayClassId = $("#displayClass").val();
			  	    $.ajax({
						   url:ctx+'/classSection/'+displayClassId,
						   type:'GET',
						   success: function(response){
							   var select = $('#displaySection');
							   if(response.length>0)
							   	  {
									   select.find('option').remove();
							   		  $('#displaySection').selectpicker('destroy');
							   	  }
							   	  else
							   	  {
							   		  select.find('option').remove();
							   		  $('#displaySection').selectpicker('destroy');
							   		  select.append('<option value="" disabled>Select Section</option>');
							   	  }
							   $.each(response, function(key,value) {
							  		 if(key==0){
							     	    		select.append('<option value="" disabled selected>Select Section</option>');
							     	    	}
							  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
							  	 }); 
							   $('#displaySection').selectpicker('show');
						   },
						   error: function(){
							   edumaatAlert({
					        		  title: 'Error!',
					        		  text: 'Do you want to continue',
					        		  type: 'error',
					        		}).then(
					        	       function(){
					        	    	   window.location.href = ctx+"/exam";
					        	    	   
					        	       }		
					        		)
					       }
						
		   		});

			  		       
			 });	
		
		 
		 
			$("#getDisplayStudentMarkDetails").click(function(event) {
				
				 if($("#getDisplayStudentMarkDetailForm").valid())
					{
						 var classId=$("#displayClass").val();
						 var sectionId=$("#displaySection").val();
						 
						 $(".loader").show();
					   $.ajax(	
							    {
							        type: "GET",
							        url:ctx+"/student/classAndSection" ,
							        data:{classId:classId,sectionId:sectionId},
							        contentType: "application/json; charset=utf-8",
							        dataType: "json",
							        cache: false,
							        success:function (data) {
							        	 $(".loader").hide();
							        	
							        	
								        	var datatable = $('#reportcardtable').DataTable();
                                            $("#reportcardtablediv").show();
								        	 
											
								        	datatable.clear().draw();
											
											
												$.each(data, function (i, value) {
													var name;
													if(value.lastName!=null){
														
														name=value.firstName +' '+value.lastName;
													}
													else{
														name=value.firstName;
													}
													var studentcontact="";
													if(value.contact)
													{
														studentcontact=value.contact;
														
													}else
													{
														studentcontact="";
													}
													var parentContact="";
													if(value.parentContact)
														{
														parentContact=value.parentContact;
														}
													datatable.row.add([value.admissionNo,name,studentcontact,parentContact,'<a href="#" id="eachreportcardid" class="" type="button" data-href="#" data-id='+value.studentId+' data-toggle="modal" onclick="showreportDiv()"><span class="glyphicon glyphicon-eye-open"></span> </a>']).draw( false );
													});
								         	
								        },
							        error:function(){
							        	 $("#reportcardtablediv").hide();
							        	
							 	    }
							       
							      
							    });
						
					}
		});
			$('#reportcardtable').on( 'click', 'tr td a#eachreportcardid', function () {
				
				 var studentId = $(this).attr('data-id');
				 
			
					   $.ajax(	
							    {
							        type: "GET",
							        url:ctx+'/exam/reportCard/'+studentId ,
							        contentType: "application/json; charset=utf-8",
							        dataType: "json",
							        cache: false,
							        success:function (data) {
							        	
							        	
							        	
							        	if(data.student.lastName!=null){
								    		name=data.student.firstName+' '+data.student.lastName;
								    	}else{
								    		name=data.student.firstName;
								    	}
							        	if(data.student.parentGuardianLastName!=null){
								    		pgname=data.student.parentGuardianFirstName+' '+data.student.parentGuardianLastName;
								    	}else{
								    		pgname=data.student.parentGuardianFirstName;
								    	}
									    $("#reportCardStudentName").text(name);
									    $("#reportCardStudentAdmissionNo").text(data.student.admissionNo);
									    $("#studentRollNo").text(data.student.rollNo);
									    $("#reportCardStudentDateOfBirth").text(data.student.birthDate);
									    $("#reportCardStudentGender").text(data.student.sex);
									    $("#studentEmail").text(data.student.email);
									    $("#reportCardPGName").text(pgname);
									    $("#reportCardAddress").text(data.student.city);
									    $("#reportCardStudentEmail").text(data.student.email);
									    $("#reportCardStudentPhoneNumber").text(data.student.parentContact);
									    $("#reportCardJoinedAcademicYear").text(data.student.joinedAcademicYear.academicYearTitle);
									    $("#reportCardStudentStatus").text(data.student.studentStatus.statusTitle);
									    
									    $("#reportCardStudentPhoto").attr("src",ctx+data.student.user.profilePicturePath);
							        	
									    
									
							       
							        
							        	$("#appendModule").empty();
							        	$("#overallpercentmodule").empty();
							        	$("#overallpercent").empty();
							        	$("#overallpercent").append('<div class="col-sm-6 col-lg-3 text-center col-sm-offset-4"><div class="p-20"><input class="demo-p" data-width="150" data-height="150" data-angleOffset="90" data-linecap="round" data-fgColor="#EA9F78" value="" data-readOnly=true/><h5 class="font-600 text-muted">Percent</h5></div></div>');
							        	
									    $('div').find('.demo-p').val((data.cGPAGradePercentageObtained).toFixed(2));
									 
									    $('.demo-p').knob();
							        	$.ajax(	
											    {
											        type: "GET",
											        url:ctx+'/exam/studentMark/'+studentId ,
											        contentType: "application/json; charset=utf-8",
											        dataType: "json",
											        cache: false,
											        success:function (data1) {
											        	
											        	
											        
											        	
											        	
											        	$.each(data.reportCardGeneratorDetails,function(key,index){
										        			 
										        			 
											        	
											        		
											        		
											        		$("#appendModule").append('<div class="panel panel-default" >'
											        		
											        			+'<div class="panel-heading" role="tab" id="headingOne'+key+'" style="background-color: #1bb4af;">'
											        			+' <h4 style="color:white;text-align:center" class="panel-title"><a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne'+key+'" aria-expanded="true" aria-controls="collapseOne'+key+'">'+index.classSectionModule.module.moduleName+'</a></h4>'
											        			+'</div>'
											        			+'<div id="collapseOne'+key+'" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne'+key+'">'
											        			+'<div class="panel-body" id="panelModuleDetails'+key+'"></div>'	   
											        			+'</div>'	   
											        			+'</div>'	
																 
																);	 
																
																
																  	$.each(data1,function(parentkey,parentindex){
																  		
																  	
																  		$.each(parentindex.studentMarksDetails,function(childkey,childindex){
																  			
																  				if((index.classSectionModule.module.moduleId)==(childindex.classSectionModule.module.moduleId)){
													        				
													        				$("#panelModuleDetails"+key).append('<h3 class="title" style="color:red">'+parentindex.classSectionTermExam.classSectionTermExamName+'</h3>'
														        					+'GRADE:'+childindex.termExamGradeObtained+''
														        					+'<br>'
														        					 +'<div class="col-sm-6 col-lg-3 text-center">'
														        					 +'<div class="p-20">'
														        					 +' <input class="demo-'+childkey+parentindex.classSectionTermExam.classSectionTermExamName+'" data-width="150" data-height="150" data-angleOffset="90" data-linecap="round" data-fgColor="#ffbd4a" value="" data-readOnly=true/> <h5 class="font-600 text-muted">Percent</h5>'
														        					 +' </div>'
														        					 +' </div>'
														        					 
										                               
													        				);
													        				$('div').find('.demo-'+childkey+parentindex.classSectionTermExam.classSectionTermExamName).val(((childindex.termExamGradePointObtained)*(9.5)).toFixed(2));
													        				$('.demo-'+childkey+parentindex.classSectionTermExam.classSectionTermExamName).knob();
													        			}
													        			
																  				
																  			
																  		});
											        			
																  		
												        			
											        		
											        		
											        			
											        			
											        		});
														        	$("#overallpercentmodule").append(' <div class="col-sm-6 col-lg-3 text-center"><div class="p-20"><input class="demo-'+key+'" data-width="150" data-height="150" data-angleOffset="90" data-linecap="round" data-fgColor="rgb(40, 232, 239)" value=""/ data-readOnly=true><h5 class="font-600 text-muted">'+index.classSectionModule.module.moduleName+'</h5></div></div>');
																
											        		   
											        			 
															   $('div').find('.demo-'+key).val(((index.overAllGradePointInPoint)*9.5).toFixed(2));
															    $('.demo-'+key).knob();
											        		  
											        		   	     	        	
											        		   	     	        });
											        	
											        	
											        	
											        	
											        }
											    });
							        	   
							        	
							        	
							        	
							        
								        },
							        error:function(){
							        	
							        	alert("Student Data Not Found...!")
							        	
							 	    }
							       
							      
							    });
						
					
		});
		
});













