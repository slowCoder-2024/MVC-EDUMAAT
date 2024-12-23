	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
$("#savedocumenttype").click(function(event) {
		 if($("#adddocumenttypeform").valid())
			{
				$("#documenttypesaveconfirmation").modal('show');
				$("#documenttypesaveconfirm").click(function(event) {
					$("#adddocumenttypeform").submit();
				});
				
			}
});

$('#documentTypelist').on( 'click', 'tr td a#edit', function () {
	   var documentTypeId = $(this).attr('data-id');
	   $("#updateDocumentTypeId").val(documentTypeId);
	   $('.loader').show();
			   $.ajax({
				   url:ctx+'/document/type/'+documentTypeId,
				   type:'GET',
				   success: function(response){
					   $('.loader').hide();
					   if(response.documentTypeTitle && response.documentTypeTitle!=null)
					   {
						   $("#editDocumentTypeName").val(response.documentTypeTitle);
					   }
					  
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/document/type";
			       }
				});
});

$("#updatedocumenttype").click(function(event){
	 if($("#updatedocumenttypeform").valid())
		{
	 $('#documenttypeupdateconfirmation').modal('show');
	 $('#documentTypeUpdateConfirm').click(function(){
		 $("#updatedocumenttypeform").submit();
		
   });
		}
});

$('#documentTypelist').on( 'click', 'tr td a#delete', function () {
	   var documentTypeId = $(this).attr('data-id');
	 $('#deletedocumenttypeconfirmation').on('show.bs.modal', function (e) {
		$("#confirmdeletedocumenttype").click(function(event) {
			 $("#deleteDocumentTypeId").val(documentTypeId);
			$("#deletedocumenttypeform").submit();  
		});
		});
	   
});

});
