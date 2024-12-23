var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
$(document).ready(function() {
	  $('#approvalsList').on( 'click', 'tr td a#studentLeaveApprove', function (event) {
        		 var textboxval=$("#approverComment"+$(this).attr('data-id')).val();
        		 textboxval=textboxval.trim();
        		 if(textboxval.length>0)
        		 {
        		
        		var studentLeaveRequisitionId=$(this).attr('data-id');
        		  var studentLeaveRequisitionStatus="Approved";
        		  $("#approverComment").val(textboxval);
          		  $("#studentLeaveRequisitionId").val(studentLeaveRequisitionId);
    			  $("#studentLeaveRequisitionStatus").val(studentLeaveRequisitionStatus);
    			  $('#confirm-approved').modal('show');
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
	  $('#approvalsList').on( 'click', 'tr td a#studentLeaveRejection', function (event) {
        		 
        		 var textboxval=$("#approverComment"+$(this).attr('data-id')).val();
        		 textboxval=textboxval.trim();
        		 if(textboxval.length>0)
        		 {
        			 
       		 
       		var studentLeaveRequisitionId=$(this).attr('data-id');
  		  var studentLeaveRequisitionStatus="Rejected";
  		  $("#approverComment").val(textboxval);
  		 $("#studentLeaveRequisitionId").val(studentLeaveRequisitionId);
		  $("#studentLeaveRequisitionStatus").val(studentLeaveRequisitionStatus);
		  $('#confirm-rejected').modal('show');
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
        	
        
	  
	  $('#movementapprovalsList').on( 'click', 'tr td a#studentMovementApprove', function (event) {
 		 var textboxval=$("#movementApproverComment"+$(this).attr('data-id')).val();
 		 textboxval=textboxval.trim();
 		 if(textboxval.length>0)
 		 {
 			var requisitionId=$(this).attr('data-id');
 	 		  var requisitionStatus="Approved";
 	 		
 			 $("#studentMovementApproverComment").val(textboxval);
 			  $("#studentMovementRequisitionId").val(requisitionId);
			  $("#studentMovementRequisitionStatus").val(requisitionStatus);
			  
 	   	  $('#movementconfirm-approved').modal('show');
 		
			 
				
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
$('#movementapprovalsList').on( 'click', 'tr td a#studentMovementRejection', function (event) {
 		 
 		 var textboxval=$("#movementApproverComment"+$(this).attr('data-id')).val();
 		 textboxval=textboxval.trim();
 		 if(textboxval.length>0)
 		 {
 			var requisitionId=$(this).attr('data-id');
 			  var requisitionStatus="Rejected";
 			  $("#studentMovementApproverComment").val(textboxval);
 			 $("#studentMovementRequisitionId").val(requisitionId);
 			  $("#studentMovementRequisitionStatus").val(requisitionStatus);
 			 
		  $('#movementconfirm-rejected').modal('show');
	
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
     
     
  	
      
      
      
    