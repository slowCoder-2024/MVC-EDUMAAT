 $(document).ready(function() {
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 $("#requisitionType").change(function(event) {
		    var val = $(this).val();
		   if(val == "5")
		    	{
		    	   $("#inventoryrequisition").show();
		    	   $("#purchaserequisition").hide();
			        
		    	  
		    	}
		   else if(val == "6")
			   {
			   $("#inventoryrequisition").hide();
	    	   $("#purchaserequisition").show();
	    	    $("#expectedDate").dateDropper({
	  			minYear:'1930',
	  			init_animation:'bounce',
	  			dropWidth:'500'
	  		});
			   }
		    });
      $("#addInventoryRequisition").click(function(event){
    	  $("#addInventoryRequisitionForm").validate();
    	  if( $("#addInventoryRequisitionForm").valid()){
    		  $("#addRequisitionConfirmation").modal('show');
      		$("#addRequisitionConfirm").click(function(){
      			$('.loader').show();
      			$('#addInventoryRequisitionForm').submit();
           	}); 
    		  
    		  
    	  }
		 
	  });
      
      $("#addPurchaseRequisition").click(function(event){
    	  $("#selectedRequisitionTypeId").val($("#requisitionType").val());
    	  $("#addPurchaseRequisitionForm").validate();
    	  if( $("#addPurchaseRequisitionForm").valid()){
    		  $("#addRequisitionConfirmation").modal('show');
      		$("#addRequisitionConfirm").click(function(){
      			$('.loader').show();
      			$('#addPurchaseRequisitionForm').submit();
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
     
      $('#inventoryRequisitionsList').on( 'click', 'tr td a#inventoryRequisitionCancel', function () {
 	     
		   var studentLeaveRequisitionId = $(this).attr('data-id');
		   $("#inventoryRequisitionId").val(studentLeaveRequisitionId);
		   $("#inventoryCancelConfirmation").on('show.bs.modal', function (e) {
			   $("#inventoryCancelConfirm").click(function(){
				   $('.loader').show();
				   $('#cancelinventoryform').submit();
				});
			});
		   
		});
      
      $('#purchaseRequisitionsList').on( 'click', 'tr td a#purchaseRequisitionCancel', function () {
  	     
		   var studentLeaveRequisitionId = $(this).attr('data-id');
		   $("#purchaseRequisitionId").val(studentLeaveRequisitionId);
		   $("#purchaseRequisitionCancelConfirmation").on('show.bs.modal', function (e) {
			   $("#purchaseCancelConfirm").click(function(){
				   $('.loader').show();
				   $('#cancelpurchaseform').submit();
				});
			});
		   
		});
  });
  	
      
      
      
    