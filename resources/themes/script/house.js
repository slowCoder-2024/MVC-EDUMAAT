	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
$("#savehouse").click(function(event) {
		 if($("#addhouseform").valid())
			{
				$("#housesaveconfirmation").modal('show');
				$("#housesaveconfirm").click(function(event) {
					$("#addhouseform").submit();
				});
				
			}
});

$('#houselist').on( 'click', 'tr td a#edit', function (event) {
	   var houseid = $(this).attr('data-id');
	   $("#updateHouseId").val(houseid);
	   $('.loader').show();
			   $.ajax({
				   url:ctx+'/house/'+houseid,
				   type:'GET',
				   success: function(response){
					   $('.loader').hide();
					  if(response.houseName && response.houseName!=null)
					   {
						   $("#editHouseName").val(response.houseName);
					   }
					  
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/house";
			       }
				});
});

$("#updatehouse").click(function(event){
	 if($("#updatehouseform").valid())
		{
	 $('#houseupdateconfirmation').modal('show');
	 $('#houseUpdateConfirm').click(function(){
		 $("#updatehouseform").submit();
		
   });
		}
});

$('#houselist').on( 'click', 'tr td a#delete', function (event) {
	 var sectionid = $(this).attr('data-id');
	 $("#deleteHouseId").val(sectionid);
	 $('#deletehouseconfirmation').on('show.bs.modal', function (e) {
		$("#confirmdeletehouse").click(function(event) {
			
			$("#deletehouseform").submit();  
		});
		});
	   
});

});
