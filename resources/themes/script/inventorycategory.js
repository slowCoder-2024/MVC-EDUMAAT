	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
$("#saveInventoryCategory").click(function(event) {
		 if($("#addInventoryCategoryform").valid())
			{
				$("#inventorycategorysaveconfirmation").modal('show');
				$("#inventorycategorysaveconfirm").click(function(event) {
					$("#addInventoryCategoryform").submit();
				});
				
			}
});

$('#inventoryCategoryList').on( 'click', 'tr td a#edit', function () {
	   var sectionid = $(this).attr('data-id');
	   $("#updateInventoryCategoryId").val(sectionid);
	   $('.loader').show();
			   $.ajax({
				   url:ctx+'/inventoryandpurchase/category/'+sectionid,
				   type:'GET',
				   success: function(response){
					   $('.loader').hide();
					   if(response.inventoryCategoryName && response.inventoryCategoryName!=null)
					   {
						   $("#editInventoryCategoryName").val(response.inventoryCategoryName);
					   }
					  
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/inventoryandpurchase/category";
			       }
				});
});

$("#updateInventoryCategory").click(function(event){
	 if($("#updateinventorycategoryform").valid())
		{
	 $('#inventorycategoryupdateconfirmation').modal('show');
	 $('#inventoryCategoryUpdateConfirm').click(function(){
		 $("#updateinventorycategoryform").submit();
		
   });
		}
});

$('#inventoryCategoryList').on( 'click', 'tr td a#delete', function () {
	 var sectionid = $(this).attr('data-id');
	 $('#deleteInventoryCategoryConfirmation').on('show.bs.modal', function (e) {
		$("#confirmdeleteinventorycategory").click(function(event) {
			 $("#deleteInventoryCategoryId").val(sectionid);
			$("#deleteInventoryCategoryform").submit();  
		});
		});
	   
});

});
