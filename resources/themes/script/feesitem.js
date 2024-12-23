
         $(document).ready(function() {
        	 
        	 
        	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
        	//deleting 
        	 $('#templateitemlist').on( 'click', 'tr td a#delete', function () {
        		 var templateitemid = $(this).attr('data-id');
        		 $('#confirm-delete').on('show.bs.modal', function (e) {
        			 $("#confirmDeleteTemplateItem").click(function(event) {
        				 $("#deleteFeesItemId").val(templateitemid);
        				 $('.loader').show();
        				 $("#deleteTemplateItemForm").submit();
        			});
        			});
        		   
        	});
        	//adding 
        	 $("#templateitemSave").click(function(event){
        		$('#templateitemform').validate();
        		if($('#templateitemform').valid()){
        	 			$("#templateitemSaveConfirmation").modal('show');
        	 			$("#templateitemSaveConfirm").click(function(){
        	 				 $('.loader').show();
        	 				$('#templateitemform').submit();
        		 		});
        	 		}
  			  });	   

         	
        	 $('#templateitemlist').on( 'click', 'tr td a#edit', function () {
         		   var templateitemid = $(this).attr('data-id');
         		  $('.loader').show();
        		   $.get(ctx+'/feesItem/'+templateitemid, function(response) 
          	        {
        			   $('.loader').hide();
          	        	if(response.feesItemName && response.feesItemName!=null)
          	        	{
          	        		$("[name=editFeesItemName]").val(response.feesItemName);    
          	        	}
          	        	if(response.feesItemPrice && response.feesItemPrice!=null)
          	        	{
          	        		$("[name=editFeesItemPrice]").val(response.feesItemPrice);
          	        	}
          	        	if(response.ledgerAccount && response.ledgerAccount!=null)
          	        	{
          	        		 $('#editLedgerAccountId').selectpicker('destroy');
          	        		$("[name=editLedgerAccountId]").val(response.ledgerAccount.ledgerAccountId);
          	        		 $('#editLedgerAccountId').selectpicker('show');
          	        	}
          	        	
          	        	if(response.taxClasses)
        		 		{
        		 			var selectedValues=[];
            				$.each(response.taxClasses, function(key,value) 
          	        			{ 
          	        				selectedValues[key]=value.taxId;
          	        			});
            				$('#editTaxClassId').selectpicker('destroy');
            				$("#editTaxClassId").val(selectedValues);
            				$('#editTaxClassId').selectpicker('show');
        		 		}
          	        	if(response.feesItemId && response.feesItemId!=null)
          	        	{
          	        		$('#updateFeesItem').attr('data-id',response.feesItemId);
          	        	}
          	        	
          				
          	        });
        		   
        		});
        	 
        		$("#updateFeesItem").click(function(event){
     				 var templateItemId = $(this).attr('data-id');
     				 $("#updateFeesItemId").val(templateItemId);
     				if($('#updateTemplateItemForm').valid()){
     					$('#saveConfirmation').modal('show');
     					$('#saveConfirm').click(function(){
     						 $('.loader').show();
         				$('#updateTemplateItemForm').submit();
         			  });
     				} 
     				});
        		
        		
        		
        	 });
        	
        	
        	
      		
      
     
     
     
     
     
    
     
     