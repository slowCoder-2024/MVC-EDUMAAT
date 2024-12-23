	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
$("#saveinventorytype").click(function(event) {
		 if($("#addinventorytypeform").valid())
			{
				$("#inventorytypesaveconfirmation").modal('show');
				$("#inventorytypesaveconfirm").click(function(event) {
					$("#addinventorytypeform").submit();
				});
				
			}
});

$('#inventoryTypelist').on( 'click', 'tr td a#edit', function () {
	   var sectionid = $(this).attr('data-id');
	   $("#updateInventoryTypeId").val(sectionid);
	   $('.loader').show();
			   $.ajax({
				   url:ctx+'/inventoryandpurchase/type/'+sectionid,
				   type:'GET',
				   success: function(response){
					   $('.loader').hide();
					   if(response.inventoryType && response.inventoryType!=null)
					   {
						   $("#editInventoryType").val(response.inventoryType);
					   }
					  
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/inventoryandpurchase/type";
			       }
				});
});

$("#updateInventoryType").click(function(event){
	 if($("#updateInventoryTypeform").valid())
		{
	 $('#inventorytypeupdateconfirmation').modal('show');
	 $('#inventoryTypeUpdateConfirm').click(function(){
		 $("#updateInventoryTypeform").submit();
		
   });
		}
});

$('#inventoryTypelist').on( 'click', 'tr td a#delete', function () {
	 var sectionid = $(this).attr('data-id');
	 $('#deleteinventorytypeconfirmation').on('show.bs.modal', function (e) {
		$("#confirmdeleteinventorytype").click(function(event) {
			 $("#deleteInventoryTypeId").val(sectionid);
			$("#deleteinventorytypeform").submit();  
		});
		});
	   
});

});
