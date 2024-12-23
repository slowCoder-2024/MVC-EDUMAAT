 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));	 
 
$(document).ready(function() {
	
	 $('#example-select-all').on('click', function(){
	      // Check/uncheck all checkboxes in the table
	   var datatable = $('#studentsList').DataTable();
	      var rows = datatable.rows({ 'search': 'applied' }).nodes();
	      $('input[type="checkbox"]', rows).prop('checked', this.checked);
	     });
 $('#studentsList').on('change', 'input[type="checkbox"]', function(){
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
			
			 var oTable = $('#studentsList').dataTable();
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
 
	$('#staffModuleList').on( 'click', 'tr td a#delete', function (event) {
		  
			var classSectionModuleId = $(this).attr('data-id');
		  $("#classSectionModuleId").val(classSectionModuleId);
				
		   
			 });

	$('#studentsList').on( 'click', 'tr td a#delete', function (event) {
		 var studentid = $(this).attr('data-id');
		 $('#deleteStudentAttendanceConfirmation').on('show.bs.modal', function (e) {
			 $("#confirmDeleteStudent").click(function(event) {
				 $("#deleteStudentAttendanceId").val(studentid);
				 $('.loader').show();
				 $("#deleteStudentForm").submit();  
			});
			});
	});
	
	
	

	$('#staffModuleAttendanceList').on( 'click', 'tr td a#edit', function (event) {
		 var staffModuleAttendanceId = $(this).attr('data-id');
		 var attendancedetails= [];
		 var table = document.getElementById('staffModuleAttendanceList'), 
		    rows = table.getElementsByTagName('tr'),
		    i, j, cells, attendance;

		 	for (i = 0, j = rows.length; i < j; ++i) 
		 	{
		    cells = rows[i].getElementsByTagName('td');
		    if (!cells.length) {
		        continue;
		    }
		    
		    attendance = $('input[name=group'+staffModuleAttendanceId+']:checked').val();
		     attendancedetails.push(staffModuleAttendanceId+"-"+attendance);
		 	}
		 $('#updateStudentAttendanceConfirmation').on('show.bs.modal', function (e) {
			 $("#confirmUpdateStudent").click(function(event) {
				 $("#updateStudentAttendanceId").val(attendancedetails);
				 $('.loader').show();
				 $("#updateStudentForm").submit();  
			});
			});
	});
	
	 $('#studentsList').on( 'click', 'tr td a#edit', function (event) {
		  	var staffModuleAttendanceId = $(this).attr('data-id');
			$.ajax({
				   url:ctx+'/staff/moduleattendance/retreiveModuleAttendance',
				   type:'GET',
				   data:{staffModuleAttendanceId:staffModuleAttendanceId},
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
					    				window.location.href=ctx+'/staff/moduleattendancereport';
						        		
						        	});
			        	 }
			        	 else
			        	 {	
			        		 $('.loader').hide();
					   var datatable = $('#staffModuleAttendanceList').DataTable();
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
	 										           data.attendanceDate,
	 										           data.attendanceTime,
	 										   '  <div class="pure-radiobutton radio-'+ data.staffModuleAttendanceId +'" >'+
	 						                '   </div>','<a href="#" id="edit" class="edit" type="button" data-href="#" data-id='+data.staffModuleAttendanceId+' data-toggle="modal" data-target="#updateStudentAttendanceConfirmation">	<i class="glyphicon  glyphicon-refresh " style="margin-right: 15px"></i> </a>'] ).draw( false );
	       	      								  
	       	      								studentAttendanceTypeList=appendStudentAttendanceType();
	       	      			 				$.each(studentAttendanceTypeList,function(key1,studentAttendanceType){
	       	      			 				if(studentAttendanceType.studentAttendaceTypeId==attendanceid)
	       	      			 				 {
	       	      			 					$(".radio-"+ data.staffModuleAttendanceId+"").append('<input type="radio" class="radio"  name="group'+ data.staffModuleAttendanceId +'" checked="checked" value="'+studentAttendanceType.studentAttendaceTypeId+'" id="group'+ data.staffModuleAttendanceId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"><label  for="group'+ data.staffModuleAttendanceId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> '+studentAttendanceType.studentAttendanceTypeName+'</label>   ');
	       	      			 				}
	       	      			 				else
	       	      			 				{
	       	      			 					$(".radio-"+ data.staffModuleAttendanceId+"").append('<input type="radio" class="radio" name="group'+ data.staffModuleAttendanceId+'" value="'+studentAttendanceType.studentAttendaceTypeId+'" id="group'+ data.staffModuleAttendanceId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> <label for="group'+ data.staffModuleAttendanceId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> '+studentAttendanceType.studentAttendanceTypeName+'</label>  ');
	       	      			 				}
	       	      			 				 });
	       	      								
	       	      				    		
			        	 }
    			   },
				   error: function(){
					   alert('ERROR OCCURED');
					}
				});
		   
			 });

	 
 	
	$('#reportType').change(function(event) 
			{
		var type=$("#reportType").val();
			if(type=="dateRange")
			{
				$("#dateRange").show();
				$("#monthly").hide();
				$("#monthattendancedetailslist").empty();
			}
			else if(type=="monthly")
			{
				$("#dateRange").hide();
				$("#monthly").show();
				$('#monthlyDateReport').monthpicker();
				$("#monthattendancedetailslist").empty();
			}
			else
			{
				$("#dateRange").hide();
				$("#monthly").hide();	
			}
			});
 

		 
		   
			$('#getMonthDetails').click(function(event) 
			{
				 if($("#monthattendance").valid())
					{
					 $('.loader').show();
					 document.getElementById('monthattendancedetails').style.display="block";
					  	 var reportType=$("#reportType").val();
					  	 var monthDate=$("#monthlyDateReport").val();
					  	 var fromDate=$("#fromDate").val();
					  	 var toDate=$("#toDate").val();
						 var classSectionModuleId=$("#classSectionModuleId").val();
					  	 
					  	$.ajax({
							   url:ctx+'/studentattendance/retrieveClassSectionModuleAndStudentAttendanceByMonth',
							   type:'GET',
							   data:{reportType:reportType,monthDate:monthDate,classSectionModuleId:classSectionModuleId,fromDate:fromDate,toDate:toDate},
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
								    				window.location.href=ctx+'/staff/moduleattendancereport';
									        		
									        	});
						        	 }
						        	 else
						        	 {	
						        		 $('.loader').hide();
								   var datatable = $('#studentsList').DataTable();
						        	datatable.clear().draw();
						        		   $.each(data, function(key,value) 
			       	      	      	        { 
											   
											   var name="";
												if(value.lastName!=null){
													
													name=value.firstName +' '+value.lastName;
												}
												else{
													name=value.firstName;
												}
											  $.each(value.staffModuleAttendances, function(key1,value1) 
							       	      				 {
			       									          var attendanceid="";
				       	      				    	     var attendancestatus="";
				       	      								  if(value1.studentAttendanceType && value1.studentAttendanceType!=null)
				       	      								  {
				       	      									  attendanceid=value1.studentAttendanceType.studentAttendaceTypeId;
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
				       	      								datatable.row.add(['<div class="checkbox checkbox-pink"><input type="checkbox" value='+value1.staffModuleAttendanceId+' name='+value1.staffModuleAttendanceId+' class="case" id='+value1.staffModuleAttendanceId+'></input><label for='+value1.staffModuleAttendanceId+'></label></div>',value.admissionNo,name,value1.attendanceDate,value1.attendanceTime,attendancestatus,'<a href="#" id="edit" class="edit" type="button" data-href="#" data-id='+value1.staffModuleAttendanceId+' data-toggle="modal" onclick="showeditattendancediv();" >	<i class="fa fa-pencil" style="margin-right: 15px"></i> </a><a href="#"  id="delete" class="delete" type="button" data-href="#"  data-id='+value1.staffModuleAttendanceId+' data-toggle="modal" data-target="#deleteStudentAttendanceConfirmation"><i class="fa fa-trash-o"></i></a>']).draw( false );
				       	 								
				       	      				    		 });
				       	      		 });
						        	 }
			       			   },
							   error: function(){
								   alert('ERROR OCCURED');
								}
							});
					}
				
				 
				    
				 	/*$("#monthattendancedetailslist1").DataTable();*/
			});
 });
 


function getDaysInMonth(month, year) {
    // Since no month has fewer than 28 days
	var months=month-1;
	  var date = new Date(year, months, 1);
	var days = [];
  	while (date.getMonth() == months) {
		var currentdate = new Date(date); 
	    var datetime =currentdate.getFullYear()  + "-"
	                + (currentdate.getMonth()+1)  + "-" 
	                + currentdate.getDate() ;
	   days.push(datetime);
       date.setDate(date.getDate() + 1);
    }
	return days;
}


function changeFormat(month) 
{
	var changeMonthFormat;
 if(month==1)
 {
	 changeMonthFormat="01";
 }
 else if(month==2)
 {
	 changeMonthFormat="02";
 }
 else if(month==3)
 {
	 changeMonthFormat="03";
 }
 else if(month==4)
 {
	 changeMonthFormat="04";
 }
 else if(month==5)
 {
	 changeMonthFormat="05";
 }
 else if(month==6)
 {
	 changeMonthFormat="06";
 }
 else if(month==7)
 {
	 changeMonthFormat="07";
 }
 else if(month==8)
 {
	 changeMonthFormat="08";
 }
 else if(month==9)
 {
	 changeMonthFormat="09";
 }
 
return changeMonthFormat;
}

function getDaysInFromDateAndToDate(fromDate,toDate)
{
	var start = fromDate;
   var end = toDate;
  var currentDate = new Date(start);
   var between = [];

while (currentDate <= end) {
	var currentdate1 = new Date(currentDate); 
    var datetime =currentdate1.getFullYear()  + "-"
                + (currentdate1.getMonth()+1)  + "-" 
                + currentdate1.getDate() ;
    between.push(datetime);
    currentDate.setDate(currentDate.getDate() + 1);
}	
return between;
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
function showeditdiv()
{
	document.getElementById('staffmoduletableview').style.display="none";
	document.getElementById('tableview').style.display="block";
	document.getElementById('monthattendancedetails').style.display="none";
	document.getElementById('editattendancedetails').style.display="none";
}

function showeditattendancediv()
{
	document.getElementById('staffmoduletableview').style.display="none";
	document.getElementById('tableview').style.display="none";
	document.getElementById('monthattendancedetails').style.display="none";
	document.getElementById('editattendancedetails').style.display="block";
	
}


function showeattendancediv()
{
	document.getElementById('staffmoduletableview').style.display="none";
	document.getElementById('tableview').style.display="block";
	document.getElementById('monthattendancedetails').style.display="block";
	document.getElementById('editattendancedetails').style.display="none";
	
}