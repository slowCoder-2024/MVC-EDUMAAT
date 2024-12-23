 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));	 
 
$(document).ready(function() {
 

 	$('#monthClassId').change(function(event) {
	    var classId = $("#monthClassId").val();
  	    $.ajax({
			   url:ctx+'/classSection/'+classId,
			   type:'GET',
			   success: function(response){
				   var select = $('#monthSectionId');
				   if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#monthSectionId').selectpicker('destroy');
		        	  }
		        	  else
		        	  { 
		        		  select.find('option').remove();
		        		  $('#monthSectionId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Section</option>');
		        	  }
				   
				   
				   
				 
				   $.each(response, function(key,value) {
				  		 if(key==0){
				     	    		select.append('<option value="" disabled selected>Select Section</option>');
				     	    		
				     	    	}
				  		 
				  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
		            	  
				  	 }); 
				   
				   $('#monthSectionId').selectpicker('show');
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
 

		var currentMonthDays = [];
		  var table="";
		  var column=0;
		 
		   
			$('#getMonthDetails').click(function(event) 
			{
				 var row=0;
				   column=0;
				 if($("#monthattendance").valid())
					{
					 
					 $('.loader').show();
					 document.getElementById('monthattendancedetails').style.display="block";
					  	 var reportType=$("#reportType").val();
					  	 var monthDate=$("#monthlyDateReport").val();
					  	 var fromDate=$("#fromDate").val();
					  	 var toDate=$("#toDate").val();
					  	 $("#monthattendancedetailslist").empty();  
					  	if(reportType=="dateRange")
						{
					  		currentMonthDays=getDaysInFromDateAndToDate($("#fromDate").datepicker("getDate"),$("#toDate").datepicker("getDate"));
						}
						else if(reportType=="monthly")
						{
							 var arr=monthDate.split("/");
							 currentMonthDays=getDaysInMonth(arr[0],arr[1]);  	
						}
					
					  	 var classId=$("#monthClassId").val();
					  	var sectionId=$("#monthSectionId").val();
						 $.ajax({
							   url:ctx+'/studentattendance/retrieveClassAndSectionStudentAttendanceByMonth',
							   type:'GET',
							   data:{reportType:reportType,monthDate:monthDate,classId:classId,sectionId:sectionId,fromDate:fromDate,toDate:toDate},
							   success: function(response){
								 
								   $('.loader').hide();
								  
								 //var  t= $("#monthattendancedetailslist").DataTable();
								   $("#monthattendancedetailslist").empty();
			       						table = $('<table id="monthattendancedetailslist1" class="table table-bordered table-responsive " style="display:block;overflow-x: auto;"><thead><tr id="th"><th></th></tr></thead><tbody>');
			       					
			       						   $.each(response, function(key,value) 
			       	      	      	        { 
			       							 var attendanceDates=[];
				       							$.each(value.studentAttendances, function(key1,value1) 
				       	      				    		{
				       										attendanceDates.push(value1.studentAttendanceDate);
				       	      				    		});
				       							var name="";
			       								if(value.lastName!=null)
			       								{
			       									name=value.firstName+" "+value.lastName;
			       								}
			       								else
			       								{
			       									name=value.firstName;
			       								}
			       							var tr = $('<tr>');	
			       							$('<td class="text-info">'+ value.admissionNo+'</td>').appendTo(tr);
			       							$('<td class="text-pink">'+name+'</td>').appendTo(tr);  
			       						 
			       							var presentcount=0;
			       							var absentcount=0;
			       							var ondutycount=0;
			       							for(jk=0;jk<currentMonthDays.length;jk++)
				       	      				  {
			       							
			       								
				       	      				   var selDate=currentMonthDays[jk].split("-");
			       							   if(selDate[1]<10)
				       	      					{
				       	      					     selDate[1]=changeFormat(selDate[1]);
				       	      					}
				       	      				    if(selDate[0]<10)
			       	      					    {
			       	      					         selDate[0]=changeFormat(selDate[0]);
			       	      					    }
				       	      				    var formatChangedDate=selDate[2]+"-"+selDate[1]+"-"+selDate[0];
				       	      				    
				       	      				    if(value.studentAttendances.length>0)
				       	      				    	{
				       	      				    		
			       							
				       	      				  //var check=$.inArray(formatChangedDate, attendanceDates);
				       	      				 
				       	      				    		    if( attendanceDates.includes(formatChangedDate))
				       	      				    			{
				       	      				    		   $.each(value.studentAttendances, function(key1,value1) 
							       	      				    		{
				       	      				    			   if(formatChangedDate==value1.studentAttendanceDate)
				       	      				    				   {
			       								             var attendanceid="";
				       	      								  if(value1.studentAttendanceType && value1.studentAttendanceType!=null)
				       	      								  {
				       	      									  attendanceid=value1.studentAttendanceType.studentAttendaceTypeId;
				       	      								  }
				       	      							 
				       	      								  /*if(attendanceid=="2")
						    								   {
				       	      									  $('<td><span class="absent">A</span></td>').appendTo(tr);      
								    						   }
						    							      else if(attendanceid=="1")
						    								  {
						    								     $('<td><span class="present">P</span></td>').appendTo(tr);            
								    						  }
						    								  else if(attendanceid=="3")
						    								  {
						    									  $('<td>OD</td>').appendTo(tr);            
										    				  }*/
				       	      								if(attendanceid=="2")
						    								   {
				       	      									  $('<td><span class="label label-table label-danger">'+ value1.studentAttendanceType.studentAttendanceTypeName+'</span></td>').appendTo(tr);      
				       	      									  absentcount=absentcount+1;
						    								   }
						    							      else if(attendanceid=="1")
						    								  {
						    								     $('<td><span class="label label-table label-success">'+ value1.studentAttendanceType.studentAttendanceTypeName+'</span></td>').appendTo(tr);            
						    								     if(value1.dayAttendanceType=="HalfDay")
						    								     {
						    								    	 presentcount=presentcount+0.5;
						    								     }
						    								     else if(value1.dayAttendanceType=="FullDay")
						    								     {
						    								    	 presentcount=presentcount+1;
						    								     }
						    								  }
						    								  else if(attendanceid=="3")
						    								  {
						    									  $('<td> <span class="label label-table label-inverse">'+ value1.studentAttendanceType.studentAttendanceTypeName+'</span></td>').appendTo(tr);            
						    									  ondutycount=ondutycount+1;
						    								  }
				       	      				    				   }
							       	      				    	 });
				       	      				    				
				       	      				    			}
				       	      				    			else
				       	      				    			{
				       	      				    			  $('<td></td>').appendTo(tr);	
				       	      				    		  	
				       	      				    			}
				       	      				    	  		
				       	      				    }
				       	      				    else
				       	      				    {
				       	      				      $('<td></td>').appendTo(tr);
				       	      				    }
				       	      				 }	 
			       						var presentpercentagecalculate=(presentcount+ondutycount)/currentMonthDays.length;
			       						presentpercentagecalculate=presentpercentagecalculate*100;
			       						presentpercentagecalculate=(Math.round((presentpercentagecalculate * 1000)/10)/100).toFixed(2);
			       						 $('<td><span class="label label-table label-success">Present-'+presentcount+'</span>&nbsp;<span class="label label-table label-danger">Absent-'+absentcount+'</span>&nbsp;<span class="label label-table label-inverse">OnDuty-'+ondutycount+'</span>&nbsp;<span class="label label-table label-warning">Percentage='+presentpercentagecalculate+'%</span></td>').appendTo(tr);
							       	      
			       							tr.appendTo(table);
			       	      	      	        			});
			       						 
			       	      						
			       	      						
			       	      					 column=column/row;
			       	      						 $("#row").show();
			       	      					$("#monthattendancedetailslist").append(table);
			       	      					
			       	      				   $("#th").empty();
			       	      				 $('#th').append( $('<th />', {text : 'AdmissionNo'}));
			       	      			 $('#th').append( $('<th />', {text : 'StudentName'}));
			       	      				for(jk=0;jk<currentMonthDays.length;jk++)
			       	      				{
			       	      				var selDate=currentMonthDays[jk].split("-");
		       							
			       	      				   if(selDate[1]<10)
			       	      					   {
			       	      					     selDate[1]=changeFormat(selDate[1]);
			       	      					   }
			       	      				    if(selDate[0]<10)
		       	      					    {
		       	      					         selDate[0]=changeFormat(selDate[0]);
		       	      					     }
			       	      				 /*   var jc=jk;
			       	      				    jc=jc+1;*/
			       	      					$('#th').append( $('<th />', {text : selDate[0]+"-"+selDate[1]+"-"+selDate[2] }));
			       	      					
			       	      				}
			       	      			$('#th').append( $('<th />', {text : 'AttendanceDetails'}));
			       	      			 var te=$("#monthattendancedetailslist1").DataTable();
									/*$.each(response, function(key,value) 
			    					 		{
			    							
			    							if(value.studentAttendanceType.studentAttendaceTypeId=="2")
			    								{ t.row.add( [   value.student.admissionNo,value.student.firstName, value.studentAttendanceDate ,
				    					 			                  '<span class="absent">'+ value.studentAttendanceType.studentAttendanceTypeName+'</span>' ,
					    									            ]).draw( false );
			    								}
			    							else if(value.studentAttendanceType.studentAttendaceTypeId=="1")
			    								{ t.row.add( [    value.student.admissionNo,value.student.firstName, value.studentAttendanceDate ,
				    					 			                   '<span class="present">'+ value.studentAttendanceType.studentAttendanceTypeName+'</span>' ,
					    									            ]).draw( false );
			    								}
			    								else 
			    								{
			    									t.row.add( [   value.student.admissionNo,value.student.firstName,  value.studentAttendanceDate ,
				    					 			                    value.studentAttendanceType.studentAttendanceTypeName ,
					    									            ]).draw( false );
			    								}
			    									
								 			});*/
							   },
							   error: function(){
								   alert('ERROR OCCURED');
								}
							});
					}
				
				 
				    
				 	/*$("#monthattendancedetailslist1").DataTable();*/
			});
 });
 
function showmodulewiseattendance()
{
	document.getElementById('OpenFormDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('OpenMonthDiv').style.display="none";
}
function showmonthwiseattendance()
{
	document.getElementById('OpenFormDiv').style.display="none";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('OpenMonthDiv').style.display="block";
	$('#monthlyDateReport').monthpicker();
}

function getDaysInMonth(month, year) {
    // Since no month has fewer than 28 days
	var months=month-1;
	  var date = new Date(year, months, 1);
	var days = [];
  	while (date.getMonth() == months) {
		var currentdate = new Date(date); 
	    var datetime = currentdate.getDate()  + "-"
	                + (currentdate.getMonth()+1)  + "-" 
	                + currentdate.getFullYear() ;
	  
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
    var datetime = currentdate1.getDate() + "-"
                + (currentdate1.getMonth()+1)  + "-" 
                +  currentdate1.getFullYear();
    between.push(datetime);
    currentDate.setDate(currentDate.getDate() + 1);
}	
return between;

}