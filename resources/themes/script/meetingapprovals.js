var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
$(document).ready(function() {
	  $('#meetingapprovalsList').on( 'click', 'tr td a#meetingApprove', function (event) {
        		 var textboxval=$("#meetingApproverComment"+$(this).attr('data-id')).val();
        		 textboxval=textboxval.trim();
        		 if(textboxval.length>0)
        		 {
        			 $('#confirm-approved').modal('show');
             		var staffLeaveRequisitionId=$(this).attr('data-id');
             		  var staffLeaveRequisitionStatus="Approved";
             		  $("#meetingApproverComment").val(textboxval);
             		  $("#meetingRequisitionId").val(staffLeaveRequisitionId);
         			  $("#meetingRequisitionStatus").val(staffLeaveRequisitionStatus);
             		  $("#confirmation-approved").click(function(event)
             				  {
             			  $("#approvedRequisition").submit();
                      	}); 
        		 }else
        		 {
        			 $("#meetingApproverComment"+$(this).attr('data-id')).val("");
        			 edumaatAlert({
		    			  title: "Info !",
		    			  text: "Please Enter Comment..!",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
        		 }
        		 
          		  
        	 });
	  $('#meetingapprovalsList').on( 'click', 'tr td a#meetingRejection', function (event) {
        		 var textboxval=$("#meetingApproverComment"+$(this).attr('data-id')).val();
        		 textboxval=textboxval.trim();
        		 if(textboxval.length>0)
        		 {
        		 
       		  $('#confirm-rejected').modal('show');
       		var staffLeaveRequisitionId=$(this).attr('data-id');
  		  var staffLeaveRequisitionStatus="Rejected";
  		  $("#meetingApproverComment").val(textboxval);
  		 $("#meetingRequisitionId").val(staffLeaveRequisitionId);
		  $("#meetingRequisitionStatus").val(staffLeaveRequisitionStatus);
       		$("#confirmation-rejected").click(function()
       			{
       		
			  $("#approvedRequisition").submit();
           	}); 
        		 }else
        		 {
        			 $("#meetingApproverComment"+$(this).attr('data-id')).val("");
        			 edumaatAlert({
		    			  title: "Info !",
		    			  text: "Please Enter Comment..!",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
        		 }
        		 
       		
       	 });
        	
	      });
     
     
  	
      
      
      
    