var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
$(document).ready(function() {
	
	  $('#inventoryApprovePendingList').on( 'click', 'tr td a#inventoryChecking', function (event) {
 		
		  var inventoryItemMasterId=$(this).attr('data-id');
		  $tds=$(this).closest("td").siblings("td");
		var quantity=$tds.eq(3).text();
		  $('.loader').show();
		   $.ajax({
			   url:ctx+'/inventoryandpurchase/item/'+inventoryItemMasterId,
			   type:'GET',
			   success: function(response)
			   {
				   $('.loader').hide();
				  
				   var itemquantity=response.totalQuantityInStock;
				   if(parseFloat(quantity) > parseFloat(itemquantity))
					{
					   edumaatAlert({
				    			  title: "Info !",
				    			  text: "Quantity Not Available...!",
				    			  type: "info",
				    			  confirmButtonText: "Cool"
				    			});
					}else
					{
						edumaatAlert({
			    			  title: "Info !",
			    			  text: itemquantity+" Quantity Available",
			    			  type: "info",
			    			  confirmButtonText: "Cool"
			    			});
					}
			   },
			   error: function(){
				   alert('ERROR OCCURED');
				   window.location.href=ctx+"/inventoryandpurchase/approvals";
		       }
			});
		
 		 
   		  
 	 });
	
	  $('#inventoryApprovePendingList').on( 'click', 'tr td a#inventoryApprove', function (event) {
        		 var textboxval=$("#inventoryApproverComment"+$(this).attr('data-id')).val();
        		 textboxval=textboxval.trim();
        		 if(textboxval.length>0)
        		 {
        			 $('#confirm-approved').modal('show');
             		var staffLeaveRequisitionId=$(this).attr('data-id');
             		  var staffLeaveRequisitionStatus="Approved";
             		  $("#approverComment").val(textboxval);
             		  $("#requisitionId").val(staffLeaveRequisitionId);
         			  $("#requisitionStatus").val(staffLeaveRequisitionStatus);
         			  $("#approvedRequisition").attr('action',ctx+'/inventoryandpurchase/approvals/inventory/updatestatus');
             		  $("#confirmation-approved").click(function(event)
             				  {
             			  $("#approvedRequisition").submit();
                      	}); 
        		 }else
        		 {
        			 $("#inventoryApproverComment"+$(this).attr('data-id')).val("");
        			 edumaatAlert({
		    			  title: "Info !",
		    			  text: "Please Enter Comment..!",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
        		 }
        		 
          		  
        	 });
	  $('#inventoryApprovePendingList').on( 'click', 'tr td a#inventoryRejection', function (event) {
        		 var textboxval=$("#inventoryApproverComment"+$(this).attr('data-id')).val();
        		 textboxval=textboxval.trim();
        		 if(textboxval.length>0)
        		 {
        		 
       		  $('#confirm-rejected').modal('show');
       		var staffLeaveRequisitionId=$(this).attr('data-id');
  		  var staffLeaveRequisitionStatus="Rejected";
  		  $("#approverComment").val(textboxval);
  		 $("#requisitionId").val(staffLeaveRequisitionId);
		  $("#requisitionStatus").val(staffLeaveRequisitionStatus);
		  $("#approvedRequisition").attr('action',ctx+'/inventoryandpurchase/approvals/inventory/updatestatus');
       		$("#confirmation-rejected").click(function()
       			{
       		
			  $("#approvedRequisition").submit();
           	}); 
        		 }else
        		 {
        			 $("#inventoryApproverComment"+$(this).attr('data-id')).val("");
        			 edumaatAlert({
		    			  title: "Info !",
		    			  text: "Please Enter Comment..!",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
        		 }
        		 
       		
       	 });
        	
	  
	  
	  $('#purchaseApprovalPendingList').on( 'click', 'tr td a#purchaseApprove', function (event) {
 		 var textboxval=$("#purchaseApproverComment"+$(this).attr('data-id')).val();
 		 textboxval=textboxval.trim();
 		 if(textboxval.length>0)
 		 {
 			 $('#confirm-approved').modal('show');
      		var staffLeaveRequisitionId=$(this).attr('data-id');
      		  var staffLeaveRequisitionStatus="Approved";
      		  $("#approverComment").val(textboxval);
      		  $("#requisitionId").val(staffLeaveRequisitionId);
  			  $("#requisitionStatus").val(staffLeaveRequisitionStatus);
  			  $("#approvedRequisition").attr('action',ctx+'/inventoryandpurchase/approvals/purchase/updatestatus');
      		  $("#confirmation-approved").click(function(event)
      				  {
      			  $("#approvedRequisition").submit();
               	}); 
 		 }else
 		 {
 			 $("#purchaseApproverComment"+$(this).attr('data-id')).val("");
 			 edumaatAlert({
	    			  title: "Info !",
	    			  text: "Please Enter Comment..!",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
 		 }
 		 
   		  
 	 });
$('#purchaseApprovalPendingList').on( 'click', 'tr td a#purchaseRejection', function (event) {
 		 var textboxval=$("#purchaseApproverComment"+$(this).attr('data-id')).val();
 		 textboxval=textboxval.trim();
 		 if(textboxval.length>0)
 		 {
 		 
		  $('#confirm-rejected').modal('show');
		var staffLeaveRequisitionId=$(this).attr('data-id');
	  var staffLeaveRequisitionStatus="Rejected";
	  $("#approverComment").val(textboxval);
	 $("#requisitionId").val(staffLeaveRequisitionId);
	  $("#requisitionStatus").val(staffLeaveRequisitionStatus);
	  $("#approvedRequisition").attr('action',ctx+'/inventoryandpurchase/approvals/purchase/updatestatus');
		$("#confirmation-rejected").click(function()
			{
		
		  $("#approvedRequisition").submit();
    	}); 
 		 }else
 		 {
 			 $("#purchaseApproverComment"+$(this).attr('data-id')).val("");
 			 edumaatAlert({
	    			  title: "Info !",
	    			  text: "Please Enter Comment..!",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
 		 }
 		 
		
	 });
	      });
     
     
  	
      
      
      
    