 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));	 
 
$(document).ready(function() {
 
	
	var currentdate = new Date(); 
    var datetime = currentdate.getDate() + "-"
                + (currentdate.getMonth()+1)  + "-" 
                + currentdate.getFullYear() + "_"  
                + currentdate.getHours() + "-"  
                + currentdate.getMinutes() + "-" 
                + currentdate.getSeconds();
var exportfilename='OverAll_StudentAttendance_Percentage_Module'+datetime;
	$('#moduleStudentAttendancePercentage').DataTable({
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

	

 	
 	


 	
	
	$('#staffModuleList').on( 'click', 'tr td a#delete', function (event) {
		
		$tds=$(this).closest("td").siblings("td");
			 $("#defaultClass").html($tds.eq(0).text());
				$("#defaultSection").html($tds.eq(1).text());
				$("#defaultModule").html($tds.eq(3).text());
		var classSectionModuleId = $(this).attr('data-id');
	  $("#classSectionModuleId").val(classSectionModuleId);
		$('.loader').show();
		  var data=$("#moduleattendanceform").serialize();
	    $.ajax({
			   url:ctx+'/staff/retrieveParticularStaffModuleAttendancePercentageReports',
			   type:'GET',
			   data:data,
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
				    				window.location.href=ctx+'/staff/moduleattendancepercentagereport';
					        		
					        	});
		        	 }
		        	 else
		        	 {	
		        		 $('.loader').hide();
		        			$("#visibilityForClassSectionModule").show();
				   var datatable = $('#moduleStudentAttendancePercentage').DataTable();
				   datatable.clear().draw();
					   $.each(response, function(key,value) 
     	      	        { 
						   datatable.row.add(['<span class="text-info">'+value.f1+'</span>','<span class="text-pink">'+value.f2+'</span>','<span class="label label-table label-success">'+value.f3+'</span>','<span class="label label-table label-danger">'+value.f4+'</span>','<span class="label label-table label-inverse">'+value.f5+'</span>','<span class="label label-table label-primary">'+value.f6+'</span>','<span class="label label-table label-warning">'+value.f7+'</span>']).draw( false );
     	      	        });
					 }
			   },
			   error: function(){
				   alert('ERROR OCCURED');
			 }
			});
		});

});

function showmodulewiseattendance()
{
	document.getElementById('staffmoduletableview').style.display="none";
	document.getElementById('moduleattendancedetails').style.display="block";
}
