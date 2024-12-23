 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

	
$(document).ready(function() {
	
	 $( "#visitorcheckintime" ).timeDropper(
			  {
				format:'HH:mm',
				autoswitch:true  
			  });
     $( "#visitorcheckouttime" ).timeDropper(
			  {
				format:'HH:mm',
				autoswitch:true  
			  });
     $( "#visitorDate" ).dateDropper({
			minYear:'1930',
			init_animation:'bounce',
			dropWidth:'500'
		});
	 
     $('#savevisitormanagement').click(function(event){
		 if($('#visitorManagementForm').valid())
		 {
			 $("#visitorSaveConfirmation").modal('show');
	 			$("#visitorSaveConfirm").click(function(){
	 				 $('.loader').show();
	 				$('#visitorManagementForm').submit();
		 		});
		 }
     });
     $('#visitorManagementLists').on( 'click', 'tr td a#delete', function () {
		 var visitorManagementId = $(this).attr('data-id');
		    $('#printrec').attr("href", ctx+"/visitormanagement/printPage?visitorManagementId="+visitorManagementId);
		  $("#printrec").printPage();
			$("#printrec").click(function() {
      			$('#recprint').modal('hide');
				
			});
		}); 
		 
    
  });



