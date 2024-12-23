	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
	  var datatable = $('#inventoryItemLists').DataTable();
	$("#purchaseOrderId").change(function() {
	
		   var poid = $(this).val();
	 	   $('.loader').show();
	 			   $.ajax({
	 				   url:ctx+'/inventoryandpurchase/purchaseOrderEager/'+poid,
	 				   type:'GET',
	 				    contentType: "application/json; charset=utf-8",
				        dataType: "json",
				        cache: false,
	 				   success: function(response){
	 					   $('.loader').hide();
	 					  
	 					     datatable.clear().draw();
	 						  unitofmeasure='<select name="" id="" class="selectpicker unitOfmemt" data-live-search="true"  data-style="btn-white" required="required"><option value="" disabled selected>Select Measurement</option><option value="0">Kilogram(Kg)</option><option value="1">Meter(m)</option><option value="2">Units(q)</option><option value="3">Area(sq ft)</option><option value="4">Volume(l)</option></select>';
	 					    taxclass='<input type="text" class="form-control taxamount" id=""  onkeypress="return decimalAmount(this, event, 2)" name="" placeholder="">';
	 					   amount='<input type="text" readonly class="form-control rowamount" id=""  onkeypress="return decimalAmount(this, event, 2)" name="" placeholder="">';
	 		
	 					   
	 					   $.each(response.inventoryPurchaseOrderDetails, function(key,data)
	 				                        {   
	 					    	
	 					    	
	 					    	datatable.row.add([data.inventoryItemMaster.itemId,data.inventoryItemMaster.itemCode,data.inventoryItemMaster.itemName,unitofmeasure,data.quantity,taxclass,amount]).draw( false );
	 					    	 $('.unitOfmemt').selectpicker('show');
	 				                       
	 				                        });
	 					   
	 					 
	 					  
	 					    
	 					  
	 				   },
	 				   error: function(){
	 					 
	 					
	 					   window.location.href=ctx+"/inventoryandpurchase/purchasereceipt";
	 			       }
	 				});
		
		
});
	
	
	
	 $('#inventoryItemLists tbody').on( 'change', '.taxamount', function () {
		 
		 
		 	var data = datatable.row( $(this).parents('tr') ).data();
	      
	        	var cell = datatable.row( $(this).parents('tr') ).node();
	        	$('input.rowamount', cell).val(($(this).val() * data[4]).toFixed(2))
	        	
	    } );

	 $('#receiptform').on( 'change', '#taxClass', function () {
		  var taxRate = $(this).val();
	     var sumofrowamount=0.0;
		 
		 datatable.rows().every( function ( rowIdx, tableLoop, rowLoop ) {       
		        var cell = datatable.cell({ row: rowIdx, column: 6 }).node();

		        sumofrowamount += parseFloat($('input', cell).val());
		    });
		
		 $("#totalamount").val(Math.round(sumofrowamount+(taxRate/100)+1));
	        
	        	
	    } );
	
	
	
$("#generatereceipt").click(function(event) {
		 if($("#receiptform").valid())
			{
			 
			 
			 var itemdetails= [];

		  		$('table#inventoryItemLists tbody').find('tr').each(function () {
		  			
				        var $tds = $(this).find('td');
				        itemdetails.push($.trim($tds.eq(0).text())+"-"+$tds.eq(3).find("option:selected").attr('value')+"-"+$.trim($tds.eq(4).text())+"-"+$tds.eq(6).find('input').val());
				            });

		  		
					    $("#itemDetailsInPR").val(itemdetails);
			 
			 
			 
				$("#generatereceiptconfirmation").modal('show');
				$("#generatereceiptconfirm").click(function() {
					$("#receiptform").submit();
				});
				
			}
});





$('#inventoryReceiptList').on( 'click', 'tr td a#delete', function () {
	 var prid = $(this).attr('data-id');
	 $('#deletereceiptconfirmation').on('show.bs.modal', function (e) {
		$("#confirmdeletereceipt").click(function(event) {
			 $("#deletePRId").val(prid);
			$("#deletereceiptform").submit();  
		});
		});
	   
});

$("#paymentMode").change(function() {
	 
    var val = $(this).val();
   
    if(val ==="2") {
    	    $(".form-group-dd").hide();
    	    $(".form-group-dd-input").prop('required',false);
	        $(".form-group-cheque").show();
	        $(".form-group-cheque-input").prop('required',true);
       }
   
    
    else if(val ==="3") {
    	
    	 $(".form-group-dd-input").prop('required',true);
    	 $(".form-group-dd").show();
	     $(".form-group-cheque").hide();
	     $(".form-group-cheque-input").prop('required',false);
     }
    
  });

});
