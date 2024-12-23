var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
$(document).ready(function() {
	  $('#complaintApprovePendingLists').on( 'click', 'tr td a#complaintApprove', function (event) {
        		 var textboxval=$("#complaintApproverComment"+$(this).attr('data-id')).val();
        		 textboxval=textboxval.trim();
        		 if(textboxval.length>0)
        		 {
        			 $('#confirm-approved').modal('show');
             		var complaintId=$(this).attr('data-id');
             		  var complaintStatus="Resolved";
             		  $("#complaintApproverComment").val(textboxval);
             		  $("#complaintId").val(complaintId);
         			  $("#complaintStatus").val(complaintStatus);
             		  $("#confirmation-approved").click(function(event)
             				  {
             			  $("#approvedRequisition").submit();
                      	}); 
        		 }else
        		 {
        			 $("#complaintApproverComment"+$(this).attr('data-id')).val("");
        			 edumaatAlert({
		    			  title: "Info !",
		    			  text: "Please Enter Comment..!",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
        		 }
        		 
          		  
        	 });
	  $('#complaintApprovePendingLists').on( 'click', 'tr td a#complaintRejection', function (event) {
        		 var textboxval=$("#complaintApproverComment"+$(this).attr('data-id')).val();
        		 textboxval=textboxval.trim();
        		 if(textboxval.length>0)
        		 {
        		 
       		  $('#confirm-rejected').modal('show');
       		var complaintId=$(this).attr('data-id');
  		  var complaintStatus="Rejected";
  		  $("#complaintApproverComment").val(textboxval);
  		 $("#complaintId").val(complaintId);
		  $("#complaintStatus").val(complaintStatus);
       		$("#confirmation-rejected").click(function()
       			{
       		
			  $("#approvedRequisition").submit();
           	}); 
        		 }else
        		 {
        			 $("#complaintApproverComment"+$(this).attr('data-id')).val("");
        			 edumaatAlert({
		    			  title: "Info !",
		    			  text: "Please Enter Comment..!",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
        		 }
        		 
       		
       	 });
        	
	      });
     
     
  	
      
      
      
    