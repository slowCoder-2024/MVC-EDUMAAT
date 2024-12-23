 $(document).ready(function() {
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 $("#requisitionType").change(function(event) {
		    var val = $(this).val();
		    if(val == "1") {
		        $("#leaverequisition").show();
		        $("#movementrequisition").hide();
		    }
		    else if(val == "2")
		    	{
		    	  $("#leaverequisition").hide();
			        $("#movementrequisition").show();
			        $("#staffInTime").timeDropper(
			  			  {
			  				format:'HH:mm',
			  				autoswitch:true ,
			  				setCurrentTime: false 
			  			  });
			  	  $("#staffOutTime").timeDropper(
			  			  {
			  				format:'HH:mm',
			  				autoswitch:true ,
			  				setCurrentTime: false
			  			  });
			  		$("#staffMovementRequisitionDate").dateDropper({
			  			minYear:'1930',
			  			init_animation:'bounce',
			  			dropWidth:'500'
			  		});

		    	}
		    });
      $("#addStaffLeaveRequisition").click(function(event){
    	  $("#selectedRequisitionTypeId").val($("#requisitionType").val());
    	  $("#addStaffLeaveRequisitionForm").validate();
    	  if( $("#addStaffLeaveRequisitionForm").valid()){
    		  $("#addStaffLeaveRequisitionConfirmation").modal('show');
      		$("#addStaffLeaveRequisitionConfirm").click(function(){
      			$('.loader').show();
      			$('#addStaffLeaveRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
		 
	  });
      $("#addStaffMovementRequisition").click(function(event){
    	  $("#selectedMovementRequisitionTypeId").val($("#requisitionType").val());
    	  $("#addStaffMovementRequisitionForm").validate();
    	  if( $("#addStaffMovementRequisitionForm").valid()){
    		  $("#addStaffMovementRequisitionConfirmation").modal('show');
      		$("#addStaffMovementRequisitionConfirm").click(function(){
      			$('.loader').show();
      			$('#addStaffMovementRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
		 
	  });
      $("#addStaffPurchaseRequisition").click(function(event){
    	  $("#addStaffPurchaseRequisitionForm").validate();
    	  if( $("#addStaffPurchaseRequisitionForm").valid()){
    		  $("#addStaffPurchaseRequisitionConfirmation").modal('show');
      		$("#addStaffPurchaseRequisitionConfirm").click(function(){
      			$('#addStaffPurchaseRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
			 
	  });
      $("#addStaffTravelRequisition").click(function(event){
    	  $("#addStaffTravelRequisitionForm").validate();
    	  if( $("#addStaffTravelRequisitionForm").valid()){
    		  $("#addStaffTravelRequisitionConfirmation").modal('show');
      		$("#addStaffTravelRequisitionConfirm").click(function(){
      			$('#addStaffTravelRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
		 return false;
		        
		 
	  });
      $("#addStaffFacilityRequisition").click(function(event){
    	  $("#addStaffFacilityRequisitionForm").validate();
    	  if( $("#addStaffFacilityRequisitionForm").valid()){
    		  $("#addStaffFacilityRequisitionConfirmation").modal('show');
      		$("#addStaffFacilityRequisitionConfirm").click(function(){
      			$('#addStaffFacilityRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
		 return false;
		        
		 
	  });
      $('#leaveRequisitionsList').on( 'click', 'tr td a#leaveCancel', function () {
     
		   var requisitionId = $(this).attr('data-id');
		   $("#leaveCancelConfirmation").on('show.bs.modal', function (e) {
			   $("#leaveCancelConfirm").click(function(){
				   $('.loader').show();
				   $.post(ctx+"/staff/requisition/staffLeaveRequest/cancel",{staffLeaveRequisitionId:requisitionId},function(){
					   window.location.href=ctx+"/staff/requisition";
				   });
				});
			});
		   
		});
      $('#movementRequisitionsList').on( 'click', 'tr td a#movementCancel', function () {
 	     
		   var requisitionId = $(this).attr('data-id');
		   $("#staffMovementRequisitionId").val(requisitionId);
		   $("#movementCancelConfirmation").on('show.bs.modal', function (e) {
			   $("#movementCancelConfirm").click(function(){
				   $('.loader').show();
				   $('#cancelstaffmovementform').submit();
				});
			});
		   
		});
  });
  	
      
      
      
    