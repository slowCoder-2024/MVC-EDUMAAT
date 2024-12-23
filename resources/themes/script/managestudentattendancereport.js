 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
$(document).ready(function() {
	
	
	
	 $('#example-select-all').on('click', function(){
	      // Check/uncheck all checkboxes in the table
	   var datatable = $('#studentsDateAttendanceList').DataTable();
	      var rows = datatable.rows({ 'search': 'applied' }).nodes();
	      $('input[type="checkbox"]', rows).prop('checked', this.checked);
	     });
$('#studentsDateAttendanceList').on('change', 'input[type="checkbox"]', function(){
	      // If checkbox is not checked
	      if(!this.checked){
	         var el = $('#example-select-all').get(0);
	         // If "Select all" control is checked and has 'indeterminate' property
	         if(el && el.checked && ('indeterminate' in el)){
	            // Set visual state of "Select all" control 
	            // as 'indeterminate'
	            el.indeterminate = true;
	         }
	      }
	   });

$('#deleteStudents').click(function(event) {
	
	 var selectedstudentid = [];
	
	 var oTable = $('#studentsDateAttendanceList').dataTable();
	 var rowcollection =  oTable.$(".case:checked", {"page": "all"});
	 rowcollection.each(function(index,elem){
	     selectedstudentid.push($(elem).val());
	 });
	
	 

$("#selectedStudentAttendanceIds").val(selectedstudentid);	  
	
		if((selectedstudentid.length)>0)
		 {
			 $('#bulkConfirmation').modal('show');
   			$('#bulkConfirm').click(function(){
		$("#deleteStudentAttendanceForm").submit();
   			});
		 }
		 else{
			 edumaatAlert({
   			  title: "Info !",
   			  text: "You have to select atleast one attendance for delete",
   			  type: "info",
   			  confirmButtonText: "Cool"
   			});
		 }

	 
 });

		   $('#getstudentlist').click(function(){
				 if($('#studentAttendanceForm').valid())
				 {
					var data=$("#studentAttendanceForm").serialize();
					 $('.loader').show();
    			 	$.ajax({
 							   url:ctx+'/studentattendance/managestudentattendancereport/retreiveDateAttendanceDetails',
 							   type:'GET',
 							   data:data,
 							   contentType: "application/json; charset=utf-8",
 						        dataType: "json",
 							   cache: false,
 							   success: function(data){
 								   
 								   if(!$.trim(data))
 						        	 {
 										 $('.loader').hide();
 						        		  edumaatAlert({
 								    			  title: "Info !",
 								    			  text:"Data Not Found",
 								    			  type: "info",
 								    			  confirmButtonText: "Cool"
 								    			}).then(function(){
 								    				window.location.href=ctx+'/studentattendance/managestudentattendancereport';
 									        		
 									        	});
 						        	 }
 						        	 else
 						        	 {	
 						        		 $('.loader').hide();
 						        		var t = $('#studentsDateAttendanceList').DataTable({"paging":false});
 				    					t.clear().draw();
 				    					var studentAttendanceTypeList=null;
 				    					
 				    						$.each(data, function(key,value) 
 				    					 		{
 				    							  var name="";
 													if(value.student.lastName!=null){
 														
 														name=value.student.firstName +' '+value.student.lastName;
 													}
 													else{
 														name=value.student.firstName;
 													}
 				    					        var attendanceid="";
		       	      				    	     var attendancestatus="";
		       	      				    	 		  if(value.studentAttendanceType && value.studentAttendanceType!=null)
		       	      								  {
		       	      									  attendanceid=value.studentAttendanceType.studentAttendaceTypeId;
		       	      								  }
		       	      							 
		       	      								  if(attendanceid=="2")
				    								   {
		       	      									attendancestatus='<span class="label label-table label-danger">Absent</span>';
		       	      								   }
				    							      else if(attendanceid=="1")
				    								  {
				    							    	  attendancestatus='<span class="label label-table label-success">Present</span>';
				    								  }
				    								  else if(attendanceid=="3")
				    								  {
				    									  attendancestatus='<span class="label label-table label-inverse">OnDuty</span>';
				    								  }
		       	      								  
		       	      							 var dayattendancetype="";
				       	      						  if(value.dayAttendanceType=="HalfDay")
		       	      								  {
		       	      									dayattendancetype="Half Day";
			       	      							  }
		       	      								  else if(value.dayAttendanceType=="FullDay")
		       	      								  {
		       	      									dayattendancetype="Full Day";
		       	      								  }
		       	      								t.row.add(['<div class="checkbox checkbox-pink"><input type="checkbox" value='+value.studentAttendanceId+' name='+value.studentAttendanceId+' class="case" id='+value.studentAttendanceId+'></input><label for='+value.studentAttendanceId+'></label></div>',value.student.admissionNo,name,value.studentAttendanceDate,attendancestatus,dayattendancetype,'<a href="#" id="edit" class="edit" type="button" data-href="#" data-id='+value.studentAttendanceId+' data-toggle="modal" onclick="showeditattendancediv();" >	<i class="fa fa-pencil" style="margin-right: 15px"></i> </a>']).draw( false );
		       	 										
 				    					 			
 				    					 		});
 				    						 $("#dateattendancedetails").show();		       	     
 						        	 }
 			       			   },
 							   error: function(){
 								   alert('ERROR OCCURED');
 								  $('.loader').hide();
 								}
 							});

    					
    						
           
				 }	
    				
	   });
		   
			 $('#studentsDateAttendanceList').on( 'click', 'tr td a#edit', function (event) {
				  	var studentAttendanceId = $(this).attr('data-id');
				  $.ajax({
						   url:ctx+'/studentattendance/managestudentattendancereport/retreiveModuleAttendance',
						   type:'GET',
						   data:{studentAttendanceId:studentAttendanceId},
						  success: function(data){
							   
							   if(!$.trim(data))
					        	 {
									 $('.loader').hide();
					        		  edumaatAlert({
							    			  title: "Info !",
							    			  text:"Data Not Found",
							    			  type: "info",
							    			  confirmButtonText: "Cool"
							    			}).then(function(){
							    				window.location.href=ctx+'/studentattendance/managestudentattendancereport';
								        		
								        	});
					        	 }
					        	 else
					        	 {	
					        		 $('.loader').hide();
							   var datatable = $('#studentAttendanceList').DataTable();
					        	datatable.clear().draw();
					        		    var name="";
											if(data.student.lastName!=null){
												
												name=data.student.firstName +' '+data.student.lastName;
											}
											else{
												name=data.student.firstName;
											}
											var studentAttendanceTypeList=null;
										      var attendanceid="";
			       	      				    	     var attendancestatus="";
			       	      								  if(data.studentAttendanceType && data.studentAttendanceType!=null)
			       	      								  {
			       	      									  attendanceid=data.studentAttendanceType.studentAttendaceTypeId;
			       	      								  }
			       	      							 	datatable.row.add( [
			 										           name ,
			 										           data.studentAttendanceDate,
			 										   '  <div class="pure-radiobutton radio-'+ data.studentAttendanceId +'" >'+
			 						                '   </div>','<div class="radio radio-warning" ><input type="radio" name="groupAttendance'+data.studentAttendanceId+'" value="HalfDay"><label>Half Day</label>&nbsp;&nbsp;<input type="radio" name="groupAttendance'+data.studentAttendanceId+'" value="FullDay"> <label>Full Day</label></div>','<a href="#" id="edit" class="edit" type="button" data-href="#" data-id='+data.studentAttendanceId+' data-toggle="modal" data-target="#updateStudentAttendanceConfirmation">	<i class="glyphicon  glyphicon-refresh " style="margin-right: 15px"></i> </a>'] ).draw( false );
			       	      							 $('input[name="groupAttendance'+data.studentAttendanceId+'"][value="'+data.dayAttendanceType+'"]').prop('checked', true);
		       	      								 studentAttendanceTypeList=appendStudentAttendanceType();
			       	      			 				$.each(studentAttendanceTypeList,function(key1,studentAttendanceType){
			       	      			 				if(studentAttendanceType.studentAttendaceTypeId==attendanceid)
			       	      			 				 {
			       	      			 					$(".radio-"+ data.studentAttendanceId+"").append('<input type="radio" class="radio"  name="group'+ data.studentAttendanceId +'" checked="checked" value="'+studentAttendanceType.studentAttendaceTypeId+'" id="group'+ data.studentAttendanceId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"><label  for="group'+ data.studentAttendanceId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> '+studentAttendanceType.studentAttendanceTypeName+'</label>   ');
			       	      			 				}
			       	      			 				else
			       	      			 				{
			       	      			 					$(".radio-"+ data.studentAttendanceId+"").append('<input type="radio" class="radio" name="group'+ data.studentAttendanceId+'" value="'+studentAttendanceType.studentAttendaceTypeId+'" id="group'+ data.studentAttendanceId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> <label for="group'+ data.studentAttendanceId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> '+studentAttendanceType.studentAttendanceTypeName+'</label>  ');
			       	      			 				}
			       	      			 				 });
			       	      								
			       	      				    		
					        	 }
		 			   },
						   error: function(){
							   alert('ERROR OCCURED');
							}
						});
				   
					 });
			 
				$('#studentAttendanceList').on( 'click', 'tr td a#edit', function (event) {
					 var studentAttendanceId = $(this).attr('data-id');
					 var attendancedetails= [];
					 var table = document.getElementById('studentAttendanceList'), 
					    rows = table.getElementsByTagName('tr'),
					    i, j, cells, attendance,dayattendancetype;

					 	for (i = 0, j = rows.length; i < j; ++i) 
					 	{
					    cells = rows[i].getElementsByTagName('td');
					    if (!cells.length) {
					        continue;
					    }
					    
					    attendance = $('input[name=group'+studentAttendanceId+']:checked').val();
					    dayattendancetype=$('input[name=groupAttendance'+studentAttendanceId+']:checked').val();
					     attendancedetails.push(studentAttendanceId+"-"+attendance+"-"+dayattendancetype);
					     
					   }
					 $('#updateStudentAttendanceConfirmation').on('show.bs.modal', function (e) {
						 $("#confirmUpdateStudent").click(function(event) {
							 $("#updateStudentAttendanceId").val(attendancedetails);
							 $('.loader').show();
							 $("#updateStudentForm").submit();  
						});
						});
				});
			   $('#section').change(function(event) {
				   $("#tableview").hide();
			   });
			   
			   
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
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/studentattendance";
			       }
				
   		});

	  		       
	 });
	 
	   
		$( "#attendanceDate" ).dateDropper({
			minYear:'1930',
			init_animation:'bounce',
			dropWidth:'500'
		});
		
	 function appendStudentAttendanceType(){
		 
		 $.ajax({
			   url:ctx+'/studentattendance/type',
			   async: false,
			   type:'GET',
			   success: function(response){
				   studentAttendanceTypeList=response;
				},
			   error: function(){
				   alert('ERROR OCCURED');
				   window.location.href=ctx+"/studentattendance";
		       }
			
		});
		 
		 return studentAttendanceTypeList;
    }
	 
	 
	 
	 $('#updateStudentAttendance').click(function(event){
	
		  var attendancedetails= [];
		
      	
		 var table = document.getElementById('studentAttendanceList'), 
		    rows = table.getElementsByTagName('tr'),
		    i, j, cells, customerId,customerName,attendance;

		for (i = 0, j = rows.length; i < j; ++i) {
		    cells = rows[i].getElementsByTagName('td');
		    if (!cells.length) {
		        continue;
		    }
		
		    customerId = cells[0].innerHTML;
		    customerName = cells[1].innerHTML;
		   attendance = $('input[name=group'+customerId+']:checked').val();
		  
		    attendancedetails.push(customerId+"-"+attendance);
		 
		}
		   $("#attendanceStudentId").val(attendancedetails);
		   $('#updateStudentAttendanceConfirmation').modal('show');
			  $('#updateStudentAttendanceConfirm').click(function(){
				  $('.loader').show();
				 $('#studentAttendanceForm').submit();
				 // window.location.href=ctx+"/studentattendance";
			  });
	 });
	 
	 
  });


function showeditattendancediv()
{
	document.getElementById('dateattendancedetails').style.display="none";
	document.getElementById('tableview').style.display="block";
	document.getElementById('studentAttendanceDiv').style.display="none";
}

function showeattendancediv()
{
	document.getElementById('dateattendancedetails').style.display="block";
	document.getElementById('tableview').style.display="none";
	document.getElementById('studentAttendanceDiv').style.display="block";
}
function appendStudentAttendanceType(){
	 
	 $.ajax({
		   url:ctx+'/studentattendance/type',
		   async: false,
		   type:'GET',
		   success: function(response){
			   studentAttendanceTypeList=response;
			},
		   error: function(){
			   alert('ERROR OCCURED');
			   window.location.href=ctx+"/studentattendance";
	       }
		
	});
	 
	 return studentAttendanceTypeList;
}