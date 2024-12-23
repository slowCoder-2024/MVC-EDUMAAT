var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2)); 

$(document).ready(function(){
	
 $('#staffAttendancePunch').click(function(){
		 if($("#punchForm").valid())
			 {
			 	$("#punchForm").submit();
			 }
	 });
 
 $('#uploadStaffAttendance').click(function(event){
	 if($("#staffAttendanceUploadForm").valid())
		 {
		 	$("#staffAttendanceUploadForm").submit();
		 }
 });
	 $('#punchdetailstable').on( 'click', 'tr td a#edit', function () {
		  $('.loader').show();
			var staffCode = $(this).attr('data-id');
		   $.ajax({
		    	  url:ctx+'/staffattendance/retrieveStaffAttendanceByStaffCode',
				   type:'GET',
				   data:{staffCode:staffCode},
				   success: function(response){
					  /* $('#stafftableview').hide();
					   $('#tableview').show();*/
					   $('.loader').hide();
					   document.getElementById('stafftableview').style.display="none";
						document.getElementById('tableview').style.display="block";
						 document.getElementById('ListDiv').style.display="none";
						
					    var t = $('#staffAttendanceList').DataTable();
						t.clear().draw();
						$.each(response.staffAttendance, function(key,value) 
						 		{
							$.each(value.staffAttendancePunches, function(key1,value1) 
							 		{
								var lastName="";
								if(response.lastName)
									{
									 lastName=response.lastName;
									}
								 t.row.add( [
									            response.staffCode ,
									            response.firstName+' '+lastName,
									            value1.punchTime
									             ]
									    ).draw( false );
							 		});
							
									
		 			 			
						 			
						 		});
				   }
		    });
		    
		 
	 });
	 
	
	 
				 $('.back').click(function(){
			 document.getElementById('stafftableview').style.display="block";
				document.getElementById('tableview').style.display="none";
				
		 });
				   		             
});

function showdiv()
{
	
		document.getElementById('stafftableview').style.display="none";
		document.getElementById('tableview').style.display="block";
	
}

function showeditdiv()
{
	document.getElementById('staffmoduletableview').style.display="none";
	document.getElementById('tableview').style.display="none";
	document.getElementById('tabletableview').style.display="block";
}