	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
	
	
	
	$('input[type=radio][name=option1]').change(function() {
		if (this.value == "yes") {
			$("#optionData1Div").show();
        }
        else if (this.value == "no") {
        	$("#optionData1Div").hide();
        }
    });
	$('input[type=radio][name=option2]').change(function() {
		if (this.value == "yes") {
			$("#optionData2Div").show();
        }
        else if (this.value == "no") {
        	$("#optionData2Div").hide();
        }
    });
	


	$('input[type=radio][name=editsalerateoption]').change(function() {
		if (this.value == "yes") {
			$("#editsaleratediv").show();
	    }
	    else if (this.value == "no") {
	    	$("#editsaleratediv").hide();
	    }
	});

$("#saveinventoryitem").click(function(event) {
		 if($("#addInventoryItemform").valid())
			{
				$("#itemsaveconfirmation").modal('show');
				$("#itemsaveconfirm").click(function(event) {
					$("#addInventoryItemform").submit();
				});
				
			}
});

$('#inventoryItemMasterList').on( 'click', 'tr td a#edit', function () {
	   var sectionid = $(this).attr('data-id');
	   $("#updateInventoryItemMasterId").val(sectionid);
	   $('.loader').show();
			   $.ajax({
				   url:ctx+'/inventoryandpurchase/item/'+sectionid,
				   type:'GET',
				   success: function(response){
					   $('.loader').hide();
					  if(response.itemName && response.itemName!=null)
					   {
						   $("#editItemName").val(response.itemName);
					   }
					  
					   if(response.location && response.location!=null)
					   {
						   $("#editLocation").val(response.location);
					   }
					   
					   if(response.itemDescription && response.itemDescription!=null)
					   {
						   $("#editItemDescription").val(response.itemDescription);
					   }
					   if(response.inventoryType && response.inventoryType!=null)
					   {
						   $('#editInventoryTypeId').selectpicker('destroy');
						   $("#editInventoryTypeId").val(response.inventoryType.inventoryTypeId);
						   $('#editInventoryTypeId').selectpicker('show');
					   }
					   if(response.inventoryCategory && response.inventoryCategory!=null)
					   {
						   $('#editInventoryCategoryId').selectpicker('destroy');
						   $("#editInventoryCategoryId").val(response.inventoryCategory.inventoryCategoryId);
						   $('#editInventoryCategoryId').selectpicker('show');
					   }
					   
					   if(response.inCharge && response.inCharge!=null)
					   {
						   $('#editInChargeUserId').selectpicker('destroy');
						   $("#editInChargeUserId").val(response.inCharge.userId);
						   $('#editInChargeUserId').selectpicker('show');
					   }
					    
					   if(response.purchaseItem!=null)
					   {
						   var purchaseitem=response.purchaseItem;
						   if(purchaseitem===true)
							{
							   $('input[name="editpurchaserateoption"][value="yes"]').prop('checked', true);
							   
							}
						   else
						   {
							   $('input[name="editpurchaserateoption"][value="no"]').prop('checked', true);
								
						   }
						  
					   }
					   if(response.salesItem!=null)
					   {
						   var saleitem=response.salesItem;
						   if(saleitem===true)
							{
							   $('input[name="editsalerateoption"][value="yes"]').prop('checked', true);
							   $("#editsalerate").val(response.salesRate);
							}
						   else
						   {
							   $('input[name="editsalerateoption"][value="no"]').prop('checked', true);
								$("#editsaleratediv").hide();
						   }
						  
					   }
					   if(response.inventoryItem!=null)
					   {
						   var inventoryitem=response.inventoryItem;
						   if(inventoryitem===true)
							{
							   $('input[name="editinventoryitemoption"][value="yes"]').prop('checked', true);
							}
						   else
						   {
							   $('input[name="editinventoryitemoption"][value="no"]').prop('checked', true);
						   }
						  
					   }
					    
					   if(response.assetItem!=null)
					   {
						   var assetItem=response.assetItem;
						   if(assetItem===true)
							{
							   $('input[name="editfixedassetoption"][value="yes"]').prop('checked', true);
							}
						   else
						   {
							   $('input[name="editfixedassetoption"][value="no"]').prop('checked', true);
						   }
						  
					   }
					  
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/inventoryandpurchase/item";
			       }
				});
});

$("#updateInventoryItem").click(function(event){
	 if($("#updateinventoryitemform").valid())
		{
	 $('#inventoryitemupdateconfirmation').modal('show');
	 $('#inventoryItemUpdateConfirm').click(function(){
		 $("#updateinventoryitemform").submit();
		
   });
		}
});

$('#inventoryItemMasterList').on( 'click', 'tr td a#delete', function () {
	 var sectionid = $(this).attr('data-id');
	 $('#deleteinventoryitemconfirmation').on('show.bs.modal', function (e) {
		$("#confirmdeleteinventoryitem").click(function(event) {
			 $("#deleteInventoryItemMasterId").val(sectionid);
			$("#deleteinventoryitemform").submit();  
		});
		});
	   
});
});
