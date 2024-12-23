 $(document).ready(function() {
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 $("#requisitionType").change(function() {
		    var val = $(this).val();
		    if(val == "3") {
		        $("#tcrequisition").show();
		    }
		    });
      $("#addTCRequisition").click(function(event){
    	  $("#selectedRequisitionTypeId").val($("#requisitionType").val());
    	  $("#addTCRequisitionForm").validate();
    	  if( $("#addTCRequisitionForm").valid()){
    		  $("#addTCRequisitionConfirmation").modal('show');
      		$("#addTCRequisitionConfirm").click(function(){
      			$('.loader').show();
      			$('#addTCRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
		 
	  });
  
      $('#tcRequisitionsList').on( 'click', 'tr td a#tcCancel', function () {
    	     
		   var tcRequisitionId = $(this).attr('data-id');
		   $("#tcCancelConfirmation").on('show.bs.modal', function (e) {
			   $("#tcCancelConfirm").click(function(){
				   $('.loader').show();
				   $.post(ctx+"/student/transfercertificate/requestcancel",{tcRequisitionId:tcRequisitionId},function(){
					   window.location.href=ctx+"/student/transfercertificate/requisition";
				   });
				});
			});
		   
		});
  });
  	
      
      
      
    