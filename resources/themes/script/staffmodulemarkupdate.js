var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2)); 

$(document).ready(function(){
	
	
	
	/*$("[name=selectall]").click(function(e){
		alert();
	    var table= $(e.target).closest('table');
	    $('td input:checkbox',table).attr('checked',e.target.checked);
	});*/
		 $('#marksandgradeupload').on( 'click', 'thead tr th input#example-select-all', function (e) {
			 
			 var table= $(e.target).closest('table');
				$('tr td input:checkbox',table).attr('checked',e.target.checked);
			// select_all();
		 });
	 $('#staffModuleList').on( 'click', 'tr td a#edit', function () {
		 
		 
		 var classId = $(this).attr('data-class');
		 var sectionId = $(this).attr('data-section');
		 var moduleId = $(this).attr('data-module');
		 var classSectionModuleId = $(this).attr('data-id');
		  $("#classId").val(classId);
		  $("#sectionId").val(sectionId);
		  $("#classSectionModuleId").val(classSectionModuleId);
		 $.ajax({
			   url:ctx+'/exam/assessmentType',
			   type:'GET',
			   data:{classId:classId,sectionId:sectionId},
			   success: function(response){
				   
				   
				 if(response.length>0){
					 var select = $('#assessmentType');
					  
					   if(response.length>0)
			        	  {
			        		  select.find('option').remove(); 
			        		  $('#assessmentType').selectpicker('destroy');
			        	  }
			        	  else
			        	  {
			        		  select.find('option').remove();
			        		  $('#assessmentType').selectpicker('destroy');
			        		  select.append('<option value="" disabled selected>Select Assessment Type</option>');
			        	  }
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
							  window.location.href = ctx+"/staff/modulemarkupdate";
							  
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
		        	    	   window.location.href = ctx+"/staff/modulemarkupdate";
		        	    	   
		        	       }		
		        		)
		       }
			
	});
		 
		  $.get(ctx+'/classSection/termAndExam', {
				 classId   : classId,
				 sectionId : sectionId
	        },function(response){
	        	 var select = $('#classSectionTermExamId');
	        	 if(response.length>0)
	        	  {
	        		  select.find('option').remove(); 
	        		  $('#classSectionTermExamId').selectpicker('destroy');
	        	  }
	        	  else
	        	  {
	        		  select.find('option').remove();
	        		  $('#classSectionTermExamId').selectpicker('destroy');
	        		  select.append('<option value="" disabled selected>Select Term Exam</option>');
	        	  }
				   $.each(response, function(key,value) {
				  		 if(key==0){
				     	    		select.append('<option value="" disabled selected>Select Term Exam</option>');
				     	    	}
				  		$('<option>').val(value.classSectionTermExamId).text(value.classSectionTermExamName).appendTo(select);
	        			

				  	 }); 
				   $('#classSectionTermExamId').selectpicker('show');
	        });
		 
		 
	 });
		 
		 
		  $("#assessmentType").change(function() {
				
				/*$('#classSectionTermExamId').prop('selectedIndex',0);		*/
				 $('.selectpicker').selectpicker('deselectAll');
			});
			
		 
			$("#classSectionTermExamId").change(function() {
				
				
				if($("#assessmentType").val()!=null){
					
					
					 var AssessmentTypeName = $('#assessmentType option:selected').text().trim();
					 var classSectionTermExamId = $("#classSectionTermExamId").val();
					var classSectionModuleId=$("#classSectionModuleId").val();
					 $("#showtabledata").show();
					 $("#studentmarksdata,#tableheaddata").empty();
					
					
					 if(AssessmentTypeName=="ModulesBased"){
						 $("#tableheaddata").append(' <tr id="activitynamelist"><th style="width: 2px"><div class="checkbox checkbox-primary"> <input name="select_all" value="1" id="example-select-all" type="checkbox"/> <label for="example-select-all"></label></div></th></tr>');
						 $("#activitynamelist").append(' <th style="width: 2px">Student Id/Exam Activity</th>');
						 
						 $.get(ctx+'/student/classsection/'+classSectionModuleId,function(response){
					        	 if(response.length>0){
					        	 $.each(response, function(key,value) {
					        		 $("#studentmarksdata").append('<tr><td><div class="checkbox checkbox-primary"><input type="checkbox" value='+value.studentId+' name='+value.studentId+' class="case" id='+value.studentId+'></input><label for='+value.studentId+'></label></div></td><td style="width:10px;">'+value.firstName+'('+ value.studentId+')</td></tr>');
										
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
												        			
												        			
												        			$( "#studentmarksdata tr").append('<td><input type="text" onkeypress="return isNumber(event)" name="" class="form-control" id='+value.classSectionTermExamActivityId+' required="required"></input></td>');
												        				
											        		
															  	 });
														
												 
												
											 }else{
												 edumaatAlert({
													  title: 'warning',
													  type:'warning',
													  text: 'Activity Not Found '
													}).then(
													  function () {
														  window.location.href = ctx+"/staff/modulemarkupdate";
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
									        	    	   window.location.href = ctx+"/staff/modulemarkupdate";
									        	    	   
									        	       }		
									        		)
									       }
										
								});
								 
								 }else{
					        		 
					        		 edumaatAlert({
										  title: 'warning',
										  type:'warning',
										  text: 'Student Not Found'
										}).then(
										  function () {
											  window.location.href = ctx+"/staff/modulemarkupdate";
											  
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
					var data1=$tds.eq(0).find('input').attr('id');
				    var data2=$tds.eq(2).find('input').val();
					var datah=$tds.eq(2).find('input').attr('id');
				
					madulebasedmarkupdatedetails.push(datah+'-'+data1+"-"+data2);
					      });
				
				$("#moduleBasedMarksUpdateDetails").val(madulebasedmarkupdatedetails);
				$("#savestudentmarkconfirmation").modal('show');
				$("#savestudentmarkconfirm").click(function(event) {
				
								$("#markupdateform").submit();
					});
				});
		
});
function select_all()
{
$('input[class=case]:checkbox').each(function()
		{ 
		if($('input[class=case]:checkbox:checked').length == 0)
		{ 
			$(this).prop("checked", false); 
		}
		else 
		{ 
			$(this).prop("checked", true); 
		} 
		
		
		
	});
}


function showdiv()
{
	if(document.getElementById('tableview').style.display=="none"){
		document.getElementById('tableview').style.display="block";
		document.getElementById('staffmoduletableview').style.display="none";
		document.getElementById('tabletableview').style.display="none";
		}
	else{
		document.getElementById('tableview').style.display="none";
		document.getElementById('staffmoduletableview').style.display="block";
		document.getElementById('tabletableview').style.display="none";
	}
}

function showeditdiv()
{
	document.getElementById('staffmoduletableview').style.display="none";
	document.getElementById('tableview').style.display="none";
	document.getElementById('tabletableview').style.display="block";
}