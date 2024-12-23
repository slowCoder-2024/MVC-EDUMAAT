	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
$("#savetaxclass").click(function(event) {
		 if($("#addtaxclassform").valid())
			{
				$("#taxclasssaveconfirmation").modal('show');
				$("#taxclasssaveconfirm").click(function(event) {
					$("#addtaxclassform").submit();
				});
				
			}
});

$('#taxclasslist').on( 'click', 'tr td a#edit', function () {
	   var taxclassid = $(this).attr('data-id');
	   $("#updateTaxClassId").val(taxclassid);
	   $('.loader').show();
			   $.ajax({
				   url:ctx+'/inventoryandpurchase/taxclass/'+taxclassid,
				   type:'GET',
				   success: function(response){
					   $('.loader').hide();
					   if(response.taxTypeName && response.taxTypeName!=null)
					   {
						   $("#editTaxClassName").val(response.taxTypeName);
					   }
					  
					   if(response.taxRate && response.taxRate!=null)
					   {
						   $("#editTaxRate").val(response.taxRate);
					   }
					  
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/taxclass";
			       }
				});
});

$("#updatetaxclass").click(function(event){
	 if($("#updatetaxclassform").valid())
		{
	 $('#taxclassupdateconfirmation').modal('show');
	 $('#taxclassUpdateConfirm').click(function(){
		 $("#updatetaxclassform").submit();
		
   });
		}
});

$('#taxclasslist').on( 'click', 'tr td a#delete', function () {
	 var taxclassid = $(this).attr('data-id');
	 $('#deletetaxclassconfirmation').on('show.bs.modal', function (e) {
		$("#confirmdeletetaxclass").click(function(event) {
			 $("#deleteTaxClassId").val(taxclassid);
			$("#deletetaxclassform").submit();  
		});
		});
	   
});

});
