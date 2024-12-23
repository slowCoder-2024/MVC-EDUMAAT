	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
$("#saveassetcategory").click(function(event) {
		 if($("#addassetcategoryform").valid())
			{
				$("#assetcategorysaveconfirmation").modal('show');
				$("#assetcategorysaveconfirm").click(function(event) {
					$("#addassetcategoryform").submit();
				});
				
			}
});

$('#assetCategorylist').on( 'click', 'tr td a#edit', function () {
	   var assetid = $(this).attr('data-id');
	   $("#updateAssetCategoryId").val(assetid);
	   $('.loader').show();
			   $.ajax({
				   url:ctx+'/asset/category/'+assetid,
				   category:'GET',
				   success: function(response){
					   $('.loader').hide();
					   if(response.assetCategoryName && response.assetCategoryName!=null)
					   {
						   $("#editAssetCategoryName").val(response.assetCategoryName);
					   }
					  
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/asset/category";
			       }
				});
});

$("#updateAssetCategory").click(function(event){
	 if($("#updateAssetCategoryform").valid())
		{
	 $('#assetcategoryupdateconfirmation').modal('show');
	 $('#assetCategoryUpdateConfirm').click(function(){
		 
		 $("#updateAssetCategoryform").submit();
		
   });
		}
});

$('#assetCategorylist').on( 'click', 'tr td a#delete', function () {
	 var assetid = $(this).attr('data-id');
	 $('#deleteassetcategoryconfirmation').on('show.bs.modal', function (e) {
		$("#confirmdeleteassetcategory").click(function(event) {
			 $("#deleteAssetCategoryId").val(assetid);
			$("#deleteassetcategoryform").submit();  
		});
		});
	   
});

});


function showEditDiv()
{

	$("#FormDiv").hide();
	$("#EditFormDiv").show();
}
