var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function(){
	
	$("#backup").click(function(event) {
		
		$("#backupform").submit();
				
	});

	$("#restore").click(function(event) {
		
		$("#browse-file").modal('show');	
		 $("#confirmUpload").click(function(){
			 $("#restoreform").submit();
			
	});
	});

});
