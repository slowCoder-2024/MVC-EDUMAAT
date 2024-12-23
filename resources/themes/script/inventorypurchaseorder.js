

var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));


$(document).ready(function() {
	
	

	$('#inventoryItem').selectpicker('show');
	
	
	$(document).on("click",".btnadd-item",function(event){
		
		var cloneIndex = $(".clonedinputitem").length;
     	 var newNum =cloneIndex + 1;
     	$('#inventoryItem').selectpicker('destroy');
        $('.btndel-item:disabled').removeAttr('disabled');
        var c = $('.clonedinputitem:first').clone(true).attr('id',"clonedinputitem"+newNum);
        
        c.find('td select').each (function () {
            this.id =this.id+newNum;
            this.name=this.id;
            $(this).selectpicker('show');
        });
        c.find('td input').each (function () {
            this.id =this.id+newNum;
            this.name=this.id;
        });
        
        $('.clonedinputitem:last').after(c);
        $('#inventoryItem').selectpicker('show');
      
    });
    $('.btndel-item').click(function() {
       
            $('.clonedinputitem:last').remove();
            $('.btndel-item').attr('disabled', ($('.clonedinputitem').length < 2));      
});
    
    
    
 	$('#savepurchaseorder').click(function(){
     	
 		if($("#purchaseOrderForm").valid()){
 			
 			
 	
  		  var podetails= [];
  	 
  		$('#iteminfo').find('tr').each(function () {
		        var $tds = $(this).find('td');
		        podetails.push($tds.eq(0).find("option:selected").attr('value')+"-"+$tds.eq(1).find('input').val());
		            });

  		

			    $("#poDetails").val(podetails);
			    
  		
 			
			
    		

    	
 			$("#posaveconfirmation").modal('show');
			$("#posaveconfirm").click(function(event) {
				$("#purchaseOrderForm").submit();
			});
 		}      				
     }); 
    
 	$('#purchaseOrderlists').on( 'click', 'tr td a#delete', function () {
 		 var poid = $(this).attr('data-id');
 		 $('#deleteconfirmation').on('show.bs.modal', function (e) {
 			$("#confirmdeletepo").click(function(event) {
 				 $("#deletePOId").val(poid);
 				$("#deletePOform").submit();  
 			});
 			});
 		   
 	});
 	$('#purchaseOrderlists').on( 'click', 'tr td a#edit', function () {
 	   var poid = $(this).attr('data-id');
 	   $('.loader').show();
 			   $.ajax({
 				   url:ctx+'/inventoryandpurchase/purchaseOrderEager/'+poid,
 				   type:'GET',
 				    contentType: "application/json; charset=utf-8",
			        dataType: "json",
			        cache: false,
 				   success: function(response){
 					   $('.loader').hide();
 					   var datatable = $('#inventoryItemLists').DataTable();
 					     datatable.clear().draw();
 					    
 			
 					    	
 					    $.each(response.inventoryPurchaseOrderDetails, function(key,data)
 				                        {   
 					    	
 					    	
 					    	datatable.row.add([data.inventoryItemMaster.itemCode,data.inventoryItemMaster.itemName,data.quantity]).draw( false );
 						   			
 				                       
 				                        });
 					  
 					    
 					  
 				   },
 				   error: function(){
 					 
 					
 					   window.location.href=ctx+"/inventoryandpurchase/purchaseorder";
 			       }
 				});
 });
    
});
function backtolist()
{
	if(document.getElementById('EditFormDiv').style.display=="block")
	{
		document.getElementById('ListDiv').style.display="block";
		document.getElementById('EditFormDiv').style.display="none";
		
	}
}