	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
	
	/*$('input[type=radio][name=purchaserateoption]').change(function() {
		if (this.value == "yes") {
			$("#purchaseratediv").show();
        }
        else if (this.value == "no") {
        	$("#purchaseratediv").hide();
        }
    });*/
	
	$('input[type=radio][name=inventoryitemoption]').change(function() {
		if (this.value == "yes") {
			$("#inventoryitemdiv").show();
        }
        else if (this.value == "no") {
        	$("#inventoryitemdiv").hide();
        }
    });
	
	
	/*$('input[type=radio][name=editpurchaserateoption]').change(function() {
		if (this.value == "yes") {
			$("#editpurchaseratediv").show();
	    }
	    else if (this.value == "no") {
	    	$("#editpurchaseratediv").hide();
	    }
	});

	$('input[type=radio][name=editsalerateoption]').change(function() {
		if (this.value == "yes") {
			$("#editsaleratediv").show();
	    }
	    else if (this.value == "no") {
	    	$("#editsaleratediv").hide();
	    }
	});*/

$("#saveassetitem").click(function(event) {
		 if($("#addAssetItemform").valid())
			{
				$("#assetitemsaveconfirmation").modal('show');
				$("#assetitemsaveconfirm").click(function(event) {
					$("#addAssetItemform").submit();
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
					   if(response.totalQuantityInStock && response.totalQuantityInStock!=null)
					   {
						   $("#editQuantity").val(response.totalQuantityInStock);
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
					   if(response.taxClass && response.taxClass!=null)
					   {
						   $('#editTaxClassId').selectpicker('destroy');
						   $("#editTaxClassId").val(response.taxClass.taxId);
						   $('#editTaxClassId').selectpicker('show');
					   }
					   
					   if(response.purchaseItem!=null)
					   {
						   var purchaseitem=response.purchaseItem;
						   if(purchaseitem===true)
							{
							   $('input[name="editpurchaserateoption"][value="yes"]').prop('checked', true);
							   $("#editpurchaserate").val(response.purchaseRate);
							}
						   else
						   {
							   $('input[name="editpurchaserateoption"][value="no"]').prop('checked', true);
								$("#editpurchaseratediv").hide();
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
					    
					   if(response.assetCategory!=null)
					   {
						   var assetCategory=response.assetCategory;
						   if(assetCategory===true)
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
