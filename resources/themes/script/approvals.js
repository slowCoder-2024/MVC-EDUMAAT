var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
$(document).ready(function() {
	  $('#approvalsList').on( 'click', 'tr td a#staffLeaveApprove', function (event) {
        		 var textboxval=$("#approverComment"+$(this).attr('data-id')).val();
        		 textboxval=textboxval.trim();
        		 if(textboxval.length>0)
        		 {
        			 $('#confirm-approved').modal('show');
             		var requisitionId=$(this).attr('data-id');
             		  var requisitionStatus="Approved";
             		  $("#approverComment").val(textboxval);
             		  $("#staffLeaveRequisitionId").val(requisitionId);
         			  $("#staffLeaveRequisitionStatus").val(requisitionStatus);
             		  $("#confirmation-approved").click(function(event)
             				  {
             			  $("#approvedLeaveRequisition").submit();
                      	}); 
        		 }else
        		 {
        			 $("#approverComment"+$(this).attr('data-id')).val("");
        			 edumaatAlert({
		    			  title: "Info !",
		    			  text: "Please Enter Comment..!",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
        		 }
        		 
          		  
        	 });
	  $('#approvalsList').on( 'click', 'tr td a#staffLeaveRejection', function (event) {
        		 var textboxval=$("#approverComment"+$(this).attr('data-id')).val();
        		 textboxval=textboxval.trim();
        		 if(textboxval.length>0)
        		 {
        		 
       		  $('#confirm-rejected').modal('show');
       		var requisitionId=$(this).attr('data-id');
  		  var requisitionStatus="Rejected";
  		  $("#approverComment").val(textboxval);
  		 $("#staffLeaveRequisitionId").val(requisitionId);
		  $("#staffLeaveRequisitionStatus").val(requisitionStatus);
       		$("#confirmation-rejected").click(function()
       			{
       		
			  $("#approvedLeaveRequisition").submit();
           	}); 
        		 }else
        		 {
        			 $("#approverComment"+$(this).attr('data-id')).val("");
        			 edumaatAlert({
		    			  title: "Info !",
		    			  text: "Please Enter Comment..!",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
        		 }
        		 
       		
       	 });
        	
	  
	  
	  
	  
	  
	  $('#transfercertificateapprovalsList').on( 'click', 'tr td a#tcApprove', function (event) {
 		 var textboxval=$("#tcApproverComment"+$(this).attr('data-id')).val();
 		 textboxval=textboxval.trim();
 		 if(textboxval.length>0)
 		 {
 			 $('#tcconfirm-approved').modal('show');
      		var requisitionId=$(this).attr('data-id');
      		  var requisitionStatus="Approved";
      		  $("#tcApproverComment").val(textboxval);
      		  $("#tcRequisitionId").val(requisitionId);
  			  $("#tcRequisitionStatus").val(requisitionStatus);
      		  $("#tcconfirmation-approved").click(function(event)
      				  {
      			  $("#approvedTCRequisition").submit();
               	}); 
 		 }else
 		 {
 			 $("#tcApproverComment"+$(this).attr('data-id')).val("");
 			 edumaatAlert({
	    			  title: "Info !",
	    			  text: "Please Enter Comment..!",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
 		 }
 		 
   		  
 	 });
$('#transfercertificateapprovalsList').on( 'click', 'tr td a#tcRejection', function (event) {
 		 var textboxval=$("#tcApproverComment"+$(this).attr('data-id')).val();
 		 textboxval=textboxval.trim();
 		 if(textboxval.length>0)
 		 {
 		 
		  $('#tcconfirm-rejected').modal('show');
		var requisitionId=$(this).attr('data-id');
	  var requisitionStatus="Rejected";
	  $("#tcApproverComment").val(textboxval);
	 $("#tcRequisitionId").val(requisitionId);
	  $("#tcRequisitionStatus").val(requisitionStatus);
		$("#tcconfirmation-rejected").click(function()
			{
		
		  $("#approvedTCRequisition").submit();
    	}); 
 		 }else
 		 {
 			 $("#tcApproverComment"+$(this).attr('data-id')).val("");
 			 edumaatAlert({
	    			  title: "Info !",
	    			  text: "Please Enter Comment..!",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
 		 }
 		 
		
	 });
        	 
$('#movementapprovalsList').on( 'click', 'tr td a#staffMovementApprove', function (event) {
	 var textboxval=$("#movementApproverComment"+$(this).attr('data-id')).val();
	 textboxval=textboxval.trim();
	 if(textboxval.length>0)
	 {
	  $('#movementconfirm-approved').modal('show');
	var requisitionId=$(this).attr('data-id');
	  var requisitionStatus="Approved";
	  $("#staffMovementApproverComment").val(textboxval);
		  $("#staffMovementRequisitionId").val(requisitionId);
		  $("#staffMovementRequisitionStatus").val(requisitionStatus);
	  $("#movementconfirmation-approved").click(function(event)
			  {
		  $("#approvedMovementRequisition").submit();
     	}); 
	 }else
	 {
		 $("#movementApproverComment"+$(this).attr('data-id')).val("");
		 edumaatAlert({
   			  title: "Info !",
   			  text: "Please Enter Comment..!",
   			  type: "info",
   			  confirmButtonText: "Cool"
   			});
	 }
 });
$('#movementapprovalsList').on( 'click', 'tr td a#staffMovementRejection', function (event) {
	 
	 var textboxval=$("#movementApproverComment"+$(this).attr('data-id')).val();
	 textboxval=textboxval.trim();
	 if(textboxval.length>0)
	 {
		 
	  $('#movementconfirm-rejected').modal('show');
	var requisitionId=$(this).attr('data-id');
 var requisitionStatus="Rejected";
 $("#staffMovementApproverComment").val(textboxval);
$("#staffMovementRequisitionId").val(requisitionId);
 $("#staffMovementRequisitionStatus").val(requisitionStatus);
	$("#movementconfirmation-rejected").click(function()
		{
	
	  $("#approvedMovementRequisition").submit();
	}); 
	 }else
	 {
		 $("#movementApproverComment"+$(this).attr('data-id')).val("");
		 edumaatAlert({
   			  title: "Info !",
   			  text: "Please Enter Comment..!",
   			  type: "info",
   			  confirmButtonText: "Cool"
   			});
	 }
	 
});

         });
     
     
  	
      
      
      
    