	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
$("#saveassettype").click(function(event) {
		 if($("#addassettypeform").valid())
			{
				$("#assettypesaveconfirmation").modal('show');
				$("#assettypesaveconfirm").click(function(event) {
					$("#addassettypeform").submit();
				});
				
			}
});

$('#assetTypelist').on( 'click', 'tr td a#edit', function () {
	   var assetid = $(this).attr('data-id');
	   $("#updateAssetTypeId").val(assetid);
	   $('.loader').show();
			   $.ajax({
				   url:ctx+'/asset/type/'+assetid,
				   type:'GET',
				   success: function(response){
					   $('.loader').hide();
					   if(response.assetType && response.assetType!=null)
					   {
						   $("#editAssetType").val(response.assetType);
					   }
					  
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/asset/type";
			       }
				});
});

$("#updateAssetType").click(function(event){
	 if($("#updateAssetTypeform").valid())
		{
	 $('#assettypeupdateconfirmation').modal('show');
	 $('#assetTypeUpdateConfirm').click(function(){
		 $("#updateAssetTypeform").submit();
		
   });
		}
});

$('#assetTypelist').on( 'click', 'tr td a#delete', function () {
	 var assetid = $(this).attr('data-id');
	 $('#deleteassettypeconfirmation').on('show.bs.modal', function (e) {
		$("#confirmdeleteassettype").click(function(event) {
			 $("#deleteAssetTypeId").val(assetid);
			$("#deleteassettypeform").submit();  
		});
		});
	   
});

});


function showEditDiv()
{

	$("#FormDiv").hide();
	$("#EditFormDiv").show();
}
