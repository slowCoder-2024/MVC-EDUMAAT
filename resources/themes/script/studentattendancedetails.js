var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));	 
 
$(document).ready(function() {

	
	var currentdate = new Date(); 
    var datetime = currentdate.getDate() + "-"
                + (currentdate.getMonth()+1)  + "-" 
                + currentdate.getFullYear() + "_"  
                + currentdate.getHours() + "-"  
                + currentdate.getMinutes() + "-" 
                + currentdate.getSeconds();
var exportfilename='Attendance_Percentage_'+datetime;
	$('#attendancedetailslist').DataTable({
		dom: 'Bfrtip',
		 buttons: [
		            {
		                extend: 'copy',
		                title: exportfilename
		                
		            },
		            {
		                extend: 'excel',
		                title: exportfilename
		            },
		            {
		                extend: 'pdf',
		               title: exportfilename
		            },
		            {
		            	 extend: 'csv',
		                title: exportfilename
		            },
		            {
		            	 extend: 'print',
		                title: exportfilename
		            }
		        ]
	});
	
	$('#monthattendancedetailslist').DataTable({
		dom: 'Bfrtip',
		 buttons: [
		            {
		                extend: 'copy',
		                title: exportfilename
		                
		            },
		            {
		                extend: 'excel',
		                title: exportfilename
		            },
		            {
		                extend: 'pdf',
		               title: exportfilename
		            },
		            {
		            	 extend: 'csv',
		                title: exportfilename
		            },
		            {
		            	 extend: 'print',
		                title: exportfilename
		            }
		        ]
	});
	$('#overalldatewiseattendancepercentagedetailslist').DataTable({
		dom: 'Bfrtip',
		 buttons: [
		            {
		                extend: 'copy',
		                title: exportfilename
		                
		            },
		            {
		                extend: 'excel',
		                title: exportfilename
		            },
		            {
		                extend: 'pdf',
		               title: exportfilename
		            },
		            {
		            	 extend: 'csv',
		                title: exportfilename
		            },
		            {
		            	 extend: 'print',
		                title: exportfilename
		            }
		        ]
	});
	$('#overallmodulewiseattendancepercentagedetailslist').DataTable({
		dom: 'Bfrtip',
		 buttons: [
		            {
		                extend: 'copy',
		                title: exportfilename
		                
		            },
		            {
		                extend: 'excel',
		                title: exportfilename
		            },
		            {
		                extend: 'pdf',
		               title: exportfilename
		            },
		            {
		            	 extend: 'csv',
		                title: exportfilename
		            },
		            {
		            	 extend: 'print',
		                title: exportfilename
		            }
		        ]
	});

	$('#reportType').change(function(event) 
				{
			var type=$("#reportType").val();
				if(type=="dateRange")
				{
					var t = $('#attendancedetailslist').DataTable();
					t.clear().draw();
					 document.getElementById('attendancedetails').style.display="none";
					$("#dateRange").show();
					$("#monthly").hide();
				}
				else if(type=="monthly")
				{
					var t = $('#attendancedetailslist').DataTable();
					t.clear().draw();
					 document.getElementById('attendancedetails').style.display="none";
					$("#dateRange").hide();
					$("#monthly").show();
					$('#monthDate').monthpicker();
				}
				});
	
	$('#studentReportType').change(function(event) 
			{
		var type=$("#studentReportType").val();
			if(type=="dateRange")
			{
				var t = $('#monthattendancedetailslist').DataTable();
				t.clear().draw();
				 document.getElementById('monthattendancedetails').style.display="none";
				$("#studentDateRange").show();
				$("#studentMonthly").hide();
			}
			else if(type=="monthly")
			{
				var t = $('#monthattendancedetailslist').DataTable();
				t.clear().draw();
				 document.getElementById('monthattendancedetails').style.display="none";
				$("#studentDateRange").hide();
				$("#studentMonthly").show();
				$('#studentMonthDate').monthpicker();
			}
			});
	$("#attendancedetailslist").DataTable();
		$('#getDetails').click(function(event) 
		{
			 /* $('#attendance').validate({
			        ignore: [],
			       });*/
			 if($("#attendance").valid())
				{
				 $('.loader').show();
				 document.getElementById('attendancedetails').style.display="block";
				 document.getElementById('monthattendancedetails').style.display="none";
					var data=$("#attendance").serialize();
				  	 
					 $.ajax({
						   url:ctx+'/staff/retrieveStaffModuleAttendanceList',
						   type:'GET',
						   data:data,
						   success: function(response){
							   $('.loader').hide();
							 /*  $(".form-horizontal").trigger('reset'); */
								var t = $('#attendancedetailslist').DataTable();
		    					t.clear().draw();
		    						$.each(response, function(key,value) 
		    					 		{
		    							if(value.studentAttendanceType.studentAttendaceTypeId=="2")
		    								{ t.row.add( [    value.attendanceDate ,
			    					 			                value.classSectionModule.module.moduleName ,
				    					 			               value.attendanceTime ,
				    									           '<span class="label label-table label-danger">'+ value.studentAttendanceType.studentAttendanceTypeName+'</span>' ,
				    									            ]).draw( false );
		    								}
		    							else if(value.studentAttendanceType.studentAttendaceTypeId=="1")
		    								{ t.row.add( [    value.attendanceDate ,
			    					 			                value.classSectionModule.module.moduleName ,
				    					 			               value.attendanceTime ,
				    									           '<span class="label label-table label-success">'+ value.studentAttendanceType.studentAttendanceTypeName+'</span>' ,
				    									            ]).draw( false );
		    								}
		    								else 
		    								{
		    									t.row.add( [    value.attendanceDate ,
			    					 			                value.classSectionModule.module.moduleName ,
				    					 			               value.attendanceTime ,
				    									           '<span class="label label-table label-inverse">'+ value.studentAttendanceType.studentAttendanceTypeName +'</span>',
				    									            ]).draw( false );
		    								}
		    								
		    					 				
							 			});
						   },
						   error: function(){
							   alert('ERROR OCCURED');
							   $('.loader').hide();
							}
						});
				}
		
		});

	

		$("#overalldatewiseattendancepercentagedetailslist").DataTable();
			$('#getOverAllDateWiseAttendancePercentageDetails').click(function(event) 
			{
				
				 if($("#overalldatewiseattendancepercentageform").valid())
					{
					 $('.loader').show();
					 document.getElementById('overalldatewiseattendancepercentagedetails').style.display="block";
					 var data=$("#overalldatewiseattendancepercentageform").serialize();
						 $.ajax({
							   url:ctx+'/studentattendance/retrieveStudentAttendanceByOverAllDateWise',
							   type:'GET',
							   data:data,
							   success: function(value){
								 
								 
								   if(!$.trim(value))
						        	 {
						        		 $('.loader').hide();
						        		 edumaatAlert({
								    			  title: "Info !",
								    			  text:"Data Not Found",
								    			  type: "info",
								    			  confirmButtonText: "Cool"
								    			}).then(function(){
								    				window.location.href=ctx+'/student/studentattendancedetails';
									        		
									        	});
						        	 }
						        	 else
						        	 {	
								   
								  /* $(".form-horizontal").trigger('reset'); */
									var t = $('#overalldatewiseattendancepercentagedetailslist').DataTable();
			    					t.clear().draw();
			    									t.row.add( [ '<span class="text-info">'+value.f1+'</span>','<span class="text-pink">'+value.f2+'</span>','<span class="label label-table label-success">'+value.f3+'</span>','<span class="label label-table label-danger">'+value.f4+'</span>','<span class="label label-table label-inverse">'+value.f5+'</span>','<span class="label label-table label-primary">'+value.f6+'</span>','<span class="label label-table label-warning">'+value.f7+'</span>' ]).draw( false );
			    									  $('.loader').hide();
			    									  var percent=value.f7 ;
			    									  $("#chartpercentage").empty();
			    									  $("#chartpercentage").attr("data-dimension",200);
			    									  $("#chartpercentage").attr("data-width",30);
			    									  $("#chartpercentage").attr("data-fontsize",24);
			    									  $("#chartpercentage").attr("data-fgcolor","#5fbeaa");
			    									  $("#chartpercentage").attr("data-bgcolor","#ebeff2");
			    									  $("#chartpercentage").attr("data-text",value.f7);
			    									  $("#chartpercentage").attr("data-percent",percent.replace(/[^0-9\.]/g,''));
			    									  $("#chartpercentage").attr("data-info",value.f2);
			    									  $('.circliful-chart2').circliful();
			    					 }
							   
							   },
							   error: function(){
								   alert('ERROR OCCURED');
								   $('.loader').hide();
								}
							});
					}
			
			});
			
			
			

			$("#overallmodulewiseattendancepercentagedetailslist").DataTable();
				$('#getOverAllModuleWiseAttendancePercentageDetails').click(function(event) 
				{
					
					 if($("#overallmodulewiseattendancepercentageform").valid())
						{
						 $('.loader').show();
						 document.getElementById('overallmodulewiseattendancepercentagedetails').style.display="block";
						 var data=$("#overallmodulewiseattendancepercentageform").serialize();
							 $.ajax({
								   url:ctx+'/staff/retrieveStaffModuleAttendanceByAcademicYearAndStudentEmail',
								   type:'GET',
								   data:data,
								   success: function(value){
									 
									   if(!$.trim(value))
							        	 {
							        		 $('.loader').hide();
							        		 edumaatAlert({
									    			  title: "Info !",
									    			  text:"Data Not Found",
									    			  type: "info",
									    			  confirmButtonText: "Cool"
									    			}).then(function(){
									    				window.location.href=ctx+'/student/studentattendancedetails';
										        		
										        	});
							        	 }
							        	 else
							        	 {	
									   
									  /* $(".form-horizontal").trigger('reset'); */
										var t = $('#overallmodulewiseattendancepercentagedetailslist').DataTable();
				    					t.clear().draw();
				    					$('.easypie').empty();
				    					$.each(value, function(key,data) 
				    					 		{
				    									var percent=data.f7;
				    										$('.easypie').append('<div class="col-sm-6 col-lg-4"> <div id="chartpercentage'+key+'" class="circliful-chart2 m-b-30 " data-dimension="200" data-text="0%" data-info="No Data Found" data-width="30" data-fontsize="24" data-percent="0" data-fgcolor="#ffbd4a" data-bgcolor="#ebeff2" ></div></div>');
				    										  $("#chartpercentage"+key).attr("data-text",data.f7);
					    									  $("#chartpercentage"+key).attr("data-percent",percent.replace(/[^0-9\.]/g,''));
					    									  $("#chartpercentage"+key).attr("data-info",data.f2);
					    									 
				    									t.row.add( [ '<span class="text-info">'+data.f1+'</span>','<span class="text-pink">'+data.f2+'</span>','<span class="label label-table label-success">'+data.f3+'</span>','<span class="label label-table label-danger">'+data.f4+'</span>','<span class="label label-table label-inverse">'+data.f5+'</span>','<span class="label label-table label-primary">'+data.f6+'</span>','<span class="label label-table label-warning">'+data.f7+'</span>' ]).draw( false );
				    					 		});
				    					 $('.circliful-chart2').circliful();
				    					  $('.loader').hide();
											 
							        	 }
								   
								   },
								   error: function(){
									   alert('ERROR OCCURED');
									   $('.loader').hide();
									}
								});
						}
				
				});
				
			
			$("#monthattendancedetailslist").DataTable();
			$('#getMonthDetails').click(function(event) 
			{
				
				 if($("#monthattendance").valid())
					{
					 $('.loader').show();
					 document.getElementById('monthattendancedetails').style.display="block";
					 document.getElementById('attendancedetails').style.display="none";
					 var data=$("#monthattendance").serialize();
						 $.ajax({
							   url:ctx+'/studentattendance/retrieveStudentAttendanceByMonth',
							   type:'GET',
							   data:data,
							   success: function(response){
								   $('.loader').hide();
								  /* $(".form-horizontal").trigger('reset'); */
									var t = $('#monthattendancedetailslist').DataTable();
			    					t.clear().draw();
			    					
			    						$.each(response, function(key,value) 
			    					 		{
			    							
			    							if(value.studentAttendanceType.studentAttendaceTypeId=="2")
			    								{ t.row.add( [    value.studentAttendanceDate ,
				    					 			                  '<span class="label label-table label-danger">'+ value.studentAttendanceType.studentAttendanceTypeName+'</span>' ,
					    									            ]).draw( false );
			    								}
			    							else if(value.studentAttendanceType.studentAttendaceTypeId=="1")
			    								{ t.row.add( [    value.studentAttendanceDate ,
				    					 			                   '<span class="label label-table label-success">'+ value.studentAttendanceType.studentAttendanceTypeName+'</span>' ,
					    									            ]).draw( false );
			    								}
			    								else 
			    								{
			    									t.row.add( [    value.studentAttendanceDate ,
			    									                '<span class="label label-table label-inverse">'+   value.studentAttendanceType.studentAttendanceTypeName +'</span>',
					    									            ]).draw( false );
			    								}
			    								
			    					 				
								 			});
							   },
							   error: function(){
								   alert('ERROR OCCURED');
								   $('.loader').hide();
								}
							});
					}
			
			});
 });
 
function showmodulewiseattendance()
{
	document.getElementById('OpenFormDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('OpenMonthDiv').style.display="none";
	document.getElementById('overAllDateWiseAttendnacePercentage').style.display="none";
	document.getElementById('overAllModuleWiseAttendnacePercentage').style.display="none";
}
function showmonthwiseattendance()
{
	document.getElementById('OpenFormDiv').style.display="none";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('OpenMonthDiv').style.display="block";
	document.getElementById('overAllDateWiseAttendnacePercentage').style.display="none";
	document.getElementById('overAllModuleWiseAttendnacePercentage').style.display="none";
	$('#monthlyDateReport').monthpicker();
}



function showoverallmodulewiseattendancepercentage()
{
	document.getElementById('OpenFormDiv').style.display="none";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('OpenMonthDiv').style.display="none";
	document.getElementById('overAllDateWiseAttendnacePercentage').style.display="none";
	document.getElementById('overAllModuleWiseAttendnacePercentage').style.display="block";
}
function showoveralldatewiseattendancepercentage()
{

	document.getElementById('overAllModuleWiseAttendnacePercentage').style.display="none";
	document.getElementById('overAllDateWiseAttendnacePercentage').style.display="block";
	document.getElementById('OpenFormDiv').style.display="none";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('OpenMonthDiv').style.display="none";
}

