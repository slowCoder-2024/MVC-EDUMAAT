$(document).ready(function(){
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
	$("#savestaffattendanceconfiguration").click(function(event) {
		if($("#savestaffattendanceconfigurationform").valid())
			{
				$("#staffattendanceconfigurationupdateconfirmation").modal('show');
				$("#staffattendanceconfigurationupdateconfirm").click(function(event) {
					 $('.loader').show();
					$("#savestaffattendanceconfigurationform").submit();
				});
			}
	});
	
	
	

	 $( "#start_time" ).timeDropper(
			  {
				format:'HH:mm',
				autoswitch:true  
			  });
    $( "#end_time" ).timeDropper(
			  {
				format:'HH:mm',
				autoswitch:true  
			  });
	 
	 $("#enable_permission_hours").change(function(){
		 var enable_permission_hours=$(this).val();
		 if(enable_permission_hours=="true"){
			 $("#permission_hours_div").show();
		 }else{
			 $("#permission_hours_div").hide();
		 }
		 
	 });
	 
	 $("#enable_leave_permission").change(function(){
		 var enable_leave_permission=$(this).val();
		 if(enable_leave_permission=="true"){
			 $("#leave_days_div").show();
		 }else{
			 $("#leave_days_div").hide();
		 }
		 
	 });
});