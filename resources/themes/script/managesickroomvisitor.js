 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));	 
 
$(document).ready(function() {
 	$('#getDetails').click(function(event) 
			{
					if($("#managesickroomvisitorform").valid())
					{
						var academicYearId=$("#academicYearId").val();
						 $('.loader').show();
							
						 $.ajax({
							   url:ctx+'/sickroomvisitor/managesickroomvisitor/academicYear',
							   type:'GET',
							   data:{academicYearId:academicYearId},
							   success: function(response){
								  
								   if(!$.trim(response))
						        	 {
						        		 $('.loader').hide();
						        		   edumaatAlert({
								    			  title: "Info !",
								    			  text:"Data Not Found",
								    			  type: "info",
								    			  confirmButtonText: "Cool"
								    			}).then(function(){
								    				window.location.href=ctx+'/sickroomvisitor/managesickroomvisitor';
									        		
									        	});
						        	 }
						        	 else
						        	 {	
						        		 $('.loader').hide();
						        		$('#academicYearSickRoomVisitorList').show();
						        		 var datatable = $('#sickroomvisitorlist').DataTable();
						        		 datatable.clear().draw();
						        		  $.each(response, function (i, value) {
						        			  
											  var reason="";
											  if(value.requestReason2!=null)
											  {
												  reason=value.requestReason1+','+value.requestReason2;
											  }
											  else
											  {
												  reason=value.requestReason1;
											  }
											  var action="";
											  if(value.actionTaken2!=null)
											  {
												  action=value.actionTaken1+','+value.actionTaken2;
											  }
											  else
											  {
												  action=value.actionTaken1;
											  }
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
								        	var date = $.date(value.requisitionDate);
								        	datatable.row.add([value.academicYear.academicYearTitle,reason,action,date,value.startTime,value.endTime]).draw( false );
											 });
						        		  
						        	 }
								   
									
							   },
							   error: function(){
								   alert('ERROR OCCURED');
								}
							});
					}
				
					});
 });
