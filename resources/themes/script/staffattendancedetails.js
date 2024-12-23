 $(document).ready(function() {
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));	 
 
	 $('#attendancedetailslist').DataTable();
	 $('#attendanceleavedetailslist').DataTable();
	/* $('#reportType').change(function(event) 
				{
			alert();
			var type=$("#reportType").val();
			alert(type);
				if(type=="weekly")
				{
					$("#weekly").show();
					$("#monthly").hide();
				}
				else if(type=="monthly")
				{
					$("#weekly").hide();
					$("#monthly").show();
				}
				});*/
		$('#getDetails').click(function(event) 
		{
			 if($("#attendance").valid())
				{
				 document.getElementById('attendancedetails').style.display="block";
				 var data=$("#attendance").serialize();
				  	 
					 $.ajax({
						   url:ctx+'/staffattendance/retrieveStaffAttendanceByMonth',
						   type:'GET',
						   data:data,
						   success: function(response){
							   $(".form-horizontal").trigger('reset'); 
								var t = $('#attendancedetailslist').DataTable();
		    					t.clear().draw();
		    					/*	$.each(response.staffLeaveRequisitions, function(key,value) 
		    					 		{
		    							
		    									t.row.add( [    value.staffLeaveType.staffLeaveType ,
			    					 			                value.staffLeaveReason,
				    					 			               value.staffLeaveStartDate+" - "+value.staffLeaveEndDate
				    									            ]).draw( false );
		    								
							 			});*/
		    					$.each(response.staffAttendance, function(key,value) 
		    					 		{
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
						        	var date = $.date(value.date);
		    									t.row.add( [ date    ,
			    					 			                value.startTime,
				    					 			               value.endTime
				    									            ]).draw( false );
		    								
							 			});
						   },
						   error: function(){
							   alert('ERROR OCCURED');
							}
						});
				}
			
		});
		 $('.back').click(function(){
			 document.getElementById('attendancedetails').style.display="block";
				document.getElementById('attendanceleavedetails').style.display="none";
				});
 });
 
 function showdiv()
 {
 	if(document.getElementById('attendanceleavedetails').style.display=="none"){
 		document.getElementById('attendanceleavedetails').style.display="block";
 		document.getElementById('attendancedetails').style.display="none";
 		}
 	else{
 		document.getElementById('attendanceleavedetails').style.display="none";
 		document.getElementById('attendancedetails').style.display="block";
 	}
 }
