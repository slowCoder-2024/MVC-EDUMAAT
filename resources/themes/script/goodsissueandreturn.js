	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
$("#saveitemissue").click(function(event) {
		 if($("#additemissueform").valid())
			{
			 var itemquantity=0.0;
			 var inventoryItemMasterId=$("#inventoryItem").val();
			   $.ajax({
				   url:ctx+'/inventoryandpurchase/item/'+inventoryItemMasterId,
				   type:'GET',
				   success: function(response)
				   {
					   itemquantity=response.totalQuantityInStock;
					   if( parseFloat(itemquantity)<=parseFloat(0.0))
						{
						   edumaatAlert({
					    			  title: "Info !",
					    			  text: "Quantity Not Available...!",
					    			  type: "info",
					    			  confirmButtonText: "Cool"
					    			});
						}
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/inventoryandpurchase/goodsissueandreturn";
			       }
				});
			 if((parseFloat($("#noOfQuantityIssue").val()) >parseFloat( 0)) && (parseFloat($("#noOfQuantityIssue").val()) <=parseFloat(itemquantity)) )
			 {
				 $("#itemissuesaveconfirmation").modal('show');
					$("#itemissuesaveconfirm").click(function(event) {
						$("#additemissueform").submit();
					});
			 }else
			 {
				  edumaatAlert({
	    			  title: "Info !",
	    			  text: "Enter Valid Quantity Return...!",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
		   $("#noOfQuantityIssue").val('');
			 }
				
				
			}
});

$("#inventoryItem").change(function(event) {
		
	 var inventoryItemMasterId=$(this).val();
	  $('.loader').show();
	   $.ajax({
		   url:ctx+'/inventoryandpurchase/item/'+inventoryItemMasterId,
		   type:'GET',
		   success: function(response)
		   {
			   $('.loader').hide();
			  
			   var itemquantity=response.totalQuantityInStock;
			   if( parseFloat(itemquantity)<=parseFloat(0.0))
				{
				   edumaatAlert({
			    			  title: "Info !",
			    			  text: "Quantity Not Available...!",
			    			  type: "info",
			    			  confirmButtonText: "Cool"
			    			});
				}
		   },
		   error: function(){
			   alert('ERROR OCCURED');
			   window.location.href=ctx+"/inventoryandpurchase/goodsissueandreturn";
	       }
		});
	
});

$("#noOfQuantityIssue").change(function(event) {
	
	 if( parseFloat($("#noOfQuantityIssue").val())<=parseFloat(0))
		{
		   edumaatAlert({
	    			  title: "Info !",
	    			  text: "Enter Valid Quantity Return...!",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
		   $("#noOfQuantityIssue").val('');
		}
	 else{
	  var inventoryItemMasterId=$("#inventoryItem").val();
	 
	  if(inventoryItemMasterId!=null && inventoryItemMasterId>0)
	  {
	  
	  $('.loader').show();
	   $.ajax({
		   url:ctx+'/inventoryandpurchase/item/'+inventoryItemMasterId,
		   type:'GET',
		   success: function(response)
		   {
			   $('.loader').hide();
			  
			   var itemquantity=response.totalQuantityInStock;
			   if( parseFloat(itemquantity)<parseFloat($("#noOfQuantityIssue").val()))
				{
				   edumaatAlert({
			    			  title: "Info !",
			    			  text: "Enter Valid Quantity Return...!",
			    			  type: "info",
			    			  confirmButtonText: "Cool"
			    			});
				   $("#noOfQuantityIssue").val('');
				}
		   },
		   error: function(){
			   alert('ERROR OCCURED');
			   window.location.href=ctx+"/inventoryandpurchase/goodsissueandreturn";
	       }
		});
	  }
	   
	 }
});
$("#noOfQuantityReturn").change(function(event) {
	
		   if( parseFloat($("#noOfQuantityReturn").val())<=parseFloat(0))
				{
				   edumaatAlert({
			    			  title: "Info !",
			    			  text: "Enter Valid Quantity Return...!",
			    			  type: "info",
			    			  confirmButtonText: "Cool"
			    			});
				   $("#noOfQuantityReturn").val('');
				}else{
		   		
		   			$.ajax({
		   			   url:ctx+'/inventoryandpurchase/goodsissueandreturn/'+ $("#inventoryItemIssueAndReturnMasterId").val(),
		   			   type:'GET',
		   			   success: function(response)
		   			   {
		   				   $('.loader').hide();
		   				 var itemquantity=0;
		   				 $.each(response, function(key,value) 
		   						 {
		   					itemquantity+=value.noOfQtyReturn; 
		   	          	}); 
		   				 var quantity=$("#noOfQuantityReturn").val();
		   				itemquantity += parseFloat(quantity);
		   				   if( parseFloat($("#itemQuantityIssued").val()) < parseFloat(itemquantity))
		   					{
		   					   edumaatAlert({
		   				    			  title: "Info !",
		   				    			  text: "Enter Valid Quantity Return...!",
		   				    			  type: "info",
		   				    			  confirmButtonText: "Cool"
		   				    			});
		   					   $("#noOfQuantityReturn").val('');
		   					}
		   			   },
		   			   error: function(){
		   				   alert('ERROR OCCURED');
		   				   window.location.href=ctx+"/inventoryandpurchase/goodsissueandreturn";
		   		       }
		   			});
				}
		  
});

$('#goodsissueandreturnlist').on( 'click', 'tr td a#edit', function () {
	   var sectionid = $(this).attr('data-id');
	   $("#inventoryItemIssueAndReturnMasterId").val(sectionid);
	   $tds=$(this).closest("td").siblings("td");
		$("#itemQuantityIssued").val($tds.eq(1).text());
			
});


$('#goodsreturnlist').on( 'click', 'tr td a#viewgoodsreturndetails', function () {
	   var inventoryItemIssueMasterId = $(this).attr('data-id');
	   $.ajax({
			   url:ctx+'/inventoryandpurchase/goodsissueandreturn/'+ inventoryItemIssueMasterId,
			   type:'GET',
			   success: function(response)
			   {
				   $('.loader').hide();
				  if(!$.trim(response))
		        	 {
		        		
		        		 edumaatAlert({
				    			  title: "Info !",
				    			  text:"Data Not Found",
				    			  type: "info",
				    			  confirmButtonText: "Cool"
				    			}).then(function(){
				    				window.location.href=ctx+'/inventoryandpurchase/goodsissueandreturn';
					        		
					        	});
		        	 }
		        	 else
		        	 {	
				var  datatable = $('#goodsreturnhistoryList').DataTable();
				 datatable.clear().draw();
				 $.each(response, function(key,value) 
						 {
					 datatable.row.add([value.noOfQtyReturn,value.returnedBy.name,value.itemReturnedAcademicYear.academicYearTitle,value.itemReturnDate]).draw( false );
	          	}); 
				  
				   } 
			   },
			   error: function(){
				   alert('ERROR OCCURED');
				   window.location.href=ctx+"/inventoryandpurchase/goodsissueandreturn";
		       }
			});
			
});

$("#savereturnitem").click(function(event){
	 if($("#addreturnitemform").valid())
		{
	 $('#itemupdateconfirmation').modal('show');
	 $('#itemUpdateConfirm').click(function(){
		 $("#addreturnitemform").submit();
		
   });
		}
});

$('#goodsissueandreturnlist').on( 'click', 'tr td a#goodsdelete', function (event) {
	 var sectionid = $(this).attr('data-id');
	 $('#deletegoodsissueconfirmation').modal('show');
		$("#confirmdeletegoodsissue").click(function() {
			 $("#deleteInventoryItemIssueMasterId").val(sectionid);
			$("#deletegoodsissueform").submit();  
		
		});
	   
});

});

function showGoodsIssue()
{
	$("#ListDiv").hide();
	$("#FormDiv").show();
	$("#goodsreturndiv").hide();
	$("#goodsreturnhistorydiv").hide();
}
function showGoodsReturn()
{
	$("#ListDiv").hide();
	$("#FormDiv").hide();
	$("#goodsreturndiv").show();
	$("#goodsreturnhistorydiv").hide();
}
function viewGoodsReturnList()
{
	$("#ListDiv").hide();
	$("#FormDiv").hide();
	$("#goodsreturndiv").hide();
	$("#goodsreturnhistorydiv").show();
}