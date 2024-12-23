$(document).ready(function() {
        	 
        	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
         
        	 $('#feestemplatelist').on( 'click', 'tr td a#edit', function () {
        		 
        		 var feestemplatestuctid = $(this).attr('data-id');
        		 $(".loader").show();
        		 $.get(ctx+'/feesStructure/'+feestemplatestuctid, function(response) {
      	        
        			 $(".loader").hide();
        		 		if(response.feesStructureName && response.feesStructureName!=null)
        		 		{
        		 			$("[name=editFeesStructureName]").val(response.feesStructureName); 
        		 		}
        		 		if(response.feesStructureId && response.feesStructureId!=null)
        		 		{
        		 			$('#updateFeesStructure').attr('data-id',response.feesStructureId);
        		 		}
        		 		if(response.feesItems)
        		 		{
        		 			var selectedValues=[];
            				$.each(response.feesItems, function(key,value) 
          	        			{ 
          	        				selectedValues[key]=value.feesItemId;
          	        			});
            				$('#editFeesItemList').selectpicker('destroy');
            				$("#editFeesItemList").val(selectedValues);
            				$('#editFeesItemList').selectpicker('show');
        		 		}
        				
      	        		/*editmultiselect();*/
      	        		
      	        		
      	        		
      	        		/*$("#editTemplateItemList").val(selectedValues).trigger("change"); */
      	        		
      	        		/*$("[name=editTemplateItemList]").val(selectedValues);*/
      	        		});
       		});
        	 
        	 
        	//adding 
        	 $("#feesStructureSave").click(function(event){
        	 	
        		if($('#feestemplateform').valid()){
        	 			$("#feesStructureSaveConfirmation").modal('show');
        	 			$("#feesStructureConfirmSave").click(function(){
        	 				$('.loader').show();
        		 			$('#feestemplateform').submit();
        		 			
        		 		});
        	 		}
        			
  			 });
        	 
        	//deleting 
        	 $('#feestemplatelist').on( 'click', 'tr td a#delete', function () {   
        		   var feestemplatestuctid = $(this).attr('data-id');
        		   $('#deleteFeesStructureConfirmation').on('show.bs.modal', function (e) {
        				 $("#confirmFeesTemplateDelete").click(function(event) {
        					 $("#deleteFeesStructureId").val(feestemplatestuctid);
        					 $('.loader').show();
        					 $("#deleteFeesStructureForm").submit();
        				});
        				});
        		 	});
        	
        	 $("#updateFeesStructure").click(function(event){
        		 var feesTemplateStuctId = $(this).attr('data-id');
        		 $("#updateFeesStructureId").val(feesTemplateStuctId);
        		 
        		
        		 if($('#updateFeesStructureDetails').valid())
        		 {
        			 $('#saveConfirmation').modal('show');
        			 $('#saveConfirm').click(function(){
        				 $('.loader').show();
        				 $('#updateFeesStructureDetails').submit();
       			     });
        		 }
 			 });
             });
         
       