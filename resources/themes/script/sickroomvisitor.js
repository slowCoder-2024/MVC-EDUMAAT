 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

	
$(document).ready(function() {
	
	 $( "#checkInTime" ).timeDropper(
			  {
				format:'HH:mm',
				autoswitch:true  
			  });
     $( "#checkOutTime" ).timeDropper(
			  {
				format:'HH:mm',
				autoswitch:true  
			  });
     $( "#requisitionDate" ).dateDropper({
			minYear:'1930',
			init_animation:'bounce',
			dropWidth:'500'
		});
	 
     $('#savesickroomvisitor').click(function(event){
		 if($('#sickRoomVisitorForm').valid())
		 {
			 $("#visitorSaveConfirmation").modal('show');
	 			$("#visitorSaveConfirm").click(function(e){
	 				 $('.loader').show();
	 				$('#sickRoomVisitorForm').submit();
		 		});
		 }
     });
     $('#sickRoomVisitorLists').on( 'click', 'tr td a#delete', function () {
		 var sickRoomVisitorId = $(this).attr('data-id');
		 $("#deleteSickRoomVisitorId").val(sickRoomVisitorId);
		/* $("#deletesickroomconfirmation").modal('show');*/
		 $('#deletesickroomconfirmation').on('show.bs.modal', function (e) {
			$("#confirmdeletesickroom").click(function(event){
				 $('.loader').show();
				$('#deletesickroomform').submit();
	 		});
		 });
		}); 
		 
    
  });



