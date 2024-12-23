 	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
$(document).ready(function() {
	
	
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
			        $("#studentInTime").timeDropper(
			  			  {
			  				format:'HH:mm',
			  				autoswitch:true ,
			  				setCurrentTime: false 
			  			  });
			  	  $("#studentOutTime").timeDropper(
			  			  {
			  				format:'HH:mm',
			  				autoswitch:true ,
			  				setCurrentTime: false
			  			  });
			  		$("#studentMovementRequisitionDate").dateDropper({
			  			minYear:'1930',
			  			init_animation:'bounce',
			  			dropWidth:'500'
			  		});

		    	}
		    });
	
		 
      $("#addStudentLeaveRequisition").click(function(event){
    	  
    	  $("#selectedRequisitionTypeId").val($("#requisitionType").val());
    	  $("#addStudentLeaveRequisitionForm").validate();
    	  if( $("#addStudentLeaveRequisitionForm").valid()){
    		  $("#addStudentLeaveRequisitionConfirmation").modal('show');
      		$("#addStudentLeaveRequisitionConfirm").click(function(){
      			$('.loader').show();
      			$('#addStudentLeaveRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
		 
	  });
      
      
  $("#addStudentMovementRequisition").click(function(event){
    	  
    	  $("#selectedMovementRequisitionTypeId").val($("#requisitionType").val());
    	  $("#addStudentMovementRequisitionForm").validate();
    	  if( $("#addStudentMovementRequisitionForm").valid()){
    		  $("#addStudentMovementRequisitionConfirmation").modal('show');
      		$("#addStudentMovementRequisitionConfirm").click(function(){
      			$('.loader').show();
      			$('#addStudentMovementRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
		 
	  });
     /* $("#addStaffPurchaseRequisition").click(function(event){
    	  $("#addStaffPurchaseRequisitionForm").validate();
    	  if( $("#addStaffPurchaseRequisitionForm").valid()){
    		  $("#addStaffPurchaseRequisitionConfirmation").modal('show');
      		$("#addStaffPurchaseRequisitionConfirm").click(function(){
      			$('#addStaffPurchaseRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
			 
	  });*/
     /* $("#addStaffTravelRequisition").click(function(event){
    	  $("#addStaffTravelRequisitionForm").validate();
    	  if( $("#addStaffTravelRequisitionForm").valid()){
    		  $("#addStaffTravelRequisitionConfirmation").modal('show');
      		$("#addStaffTravelRequisitionConfirm").click(function(){
      			$('#addStaffTravelRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
		 return false;
		        
		 
	  });*/
     /* $("#addStaffFacilityRequisition").click(function(event){
    	  $("#addStaffFacilityRequisitionForm").validate();
    	  if( $("#addStaffFacilityRequisitionForm").valid()){
    		  $("#addStaffFacilityRequisitionConfirmation").modal('show');
      		$("#addStaffFacilityRequisitionConfirm").click(function(){
      			$('#addStaffFacilityRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
		 return false;
		        
		 
	  });*/
      $('#leaveRequisitionsList').on( 'click', 'tr td a#leaveCancel', function () {
     
		   var studentLeaveRequisitionId = $(this).attr('data-id');
		   $("#studentLeaveRequisitionId").val(studentLeaveRequisitionId);
		   $("#leaveCancelConfirmation").on('show.bs.modal', function (e) {
			   $("#leaveCancelConfirm").click(function(){
				   $('.loader').show();
				   $('#cancelstudentform').submit();
				});
			});
		   
		});
      
      $('#movementRequisitionsList').on( 'click', 'tr td a#movementCancel', function () {
    	     
		   var requisitionId = $(this).attr('data-id');
		   $("#studentMovementRequisitionId").val(requisitionId);
		   $("#movementCancelConfirmation").on('show.bs.modal', function (e) {
			   $("#movementCancelConfirm").click(function(event){
				   $('.loader').show();
				   $('#cancelstudentmovementform').submit();
				});
			});
		   
		});
  });
  	
      
      
      
    