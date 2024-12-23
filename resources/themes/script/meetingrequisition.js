 $(document).ready(function() {
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 $("#requisitionType").change(function(event) {
		    var val = $(this).val();
		   if(val == "4")
		    	{
		    	   $("#meetingrequisition").show();
			        $("#fromTime").timeDropper(
			  			  {
			  				format:'HH:mm',
			  				autoswitch:true ,
			  				setCurrentTime: false 
			  			  });
			  	  $("#toTime").timeDropper(
			  			  {
			  				format:'HH:mm',
			  				autoswitch:true ,
			  				setCurrentTime: false
			  			  });
			  		$("#meetingRequisitionDate").dateDropper({
			  			minYear:'1930',
			  			init_animation:'bounce',
			  			dropWidth:'500'
			  		});

		    	}
		    });
      $("#addMeetingRequisition").click(function(event){
    	  $("#selectedMeetingRequisitionTypeId").val($("#requisitionType").val());
    	  $("#addMeetingRequisitionForm").validate();
    	  if( $("#addMeetingRequisitionForm").valid()){
    		  $("#addRequisitionConfirmation").modal('show');
      		$("#addRequisitionConfirm").click(function(){
      			$('.loader').show();
      			$('#addMeetingRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
		 
	  });
      $("#addStaffMomentRequisition").click(function(event){
    	  $("#selectedMomentRequisitionTypeId").val($("#requisitionType").val());
    	  $("#addStaffMomentRequisitionForm").validate();
    	  if( $("#addStaffMomentRequisitionForm").valid()){
    		  $("#addStaffMomentRequisitionConfirmation").modal('show');
      		$("#addStaffMomentRequisitionConfirm").click(function(){
      			$('.loader').show();
      			$('#addStaffMomentRequisitionForm').submit();
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
     
		   var staffLeaveRequisitionId = $(this).attr('data-id');
		   $("#leaveCancelConfirmation").on('show.bs.modal', function (e) {
			   $("#leaveCancelConfirm").click(function(){
				   $('.loader').show();
				   $.post(ctx+"/staff/requisition/staffLeaveRequest/cancel",{staffLeaveRequisitionId:staffLeaveRequisitionId},function(){
					   window.location.href=ctx+"/staff/requisition";
				   });
				});
			});
		   
		});
      $('#meetingRequisitionsList').on( 'click', 'tr td a#meetingCancel', function () {
 	     
		   var studentLeaveRequisitionId = $(this).attr('data-id');
		   $("#meetingRequisitionId").val(studentLeaveRequisitionId);
		   $("#meetingCancelConfirmation").on('show.bs.modal', function (e) {
			   $("#meetingCancelConfirm").click(function(){
				   $('.loader').show();
				   $('#cancelmeetingform').submit();
				});
			});
		   
		});
  });
  	
      
      
      
    