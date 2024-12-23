 $(document).ready(function() {
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
      $("#addComplaint").click(function(event){
    	  $("#addComplaintForm").validate();
    	  if( $("#addComplaintForm").valid()){
    		  $("#addComplaintConfirmation").modal('show');
      		$("#addComplaintConfirm").click(function(){
      			$('.loader').show();
      			$('#addComplaintForm').submit();
           	}); 
    		  
    		  
    	  }
		 
	  });
     
     
   $('#complaintManagementLists').on( 'click', 'tr td a#complaintCancel', function () {
 	     
		   var complaintId = $(this).attr('data-id');
		   $("#complaintId").val(complaintId);
		   $("#complaintCancelConfirmation").on('show.bs.modal', function (e) {
			   $("#complaintCancelConfirm").click(function(){
				   $('.loader').show();
				   $('#cancelcomplaintform').submit();
				});
			});
		   
		});
  });
  	
      
      
      
    