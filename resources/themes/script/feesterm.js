$(document).ready(function(){
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

	$("#feesTermSave").click(function(event) {
		if($("#feesTermform").valid())
			{
				$("#feesTermSaveConfirmation").modal('show');
				$("#feesTermSaveConfirm").click(function(event) {
					$("#feesTermform").submit();
				});
			}
	});

	$('#feestermList').on( 'click', 'tr td a#edit', function () {
		 var feesTermid = $(this).attr('data-id');
		   $("#updateFeesTermId").val(feesTermid);
		   $('.loader').show();
				   $.ajax({
					   url:ctx+'/feesTerm/'+feesTermid,
					   type:'GET',
					   success: function(response){
						   $('.loader').hide();
						   if(response.feesTermName!=null)
						   {
							   $("#editFeesTermName").val(response.feesTermName);  
						   }
						  
					   },
					   error: function(){
						   alert('ERROR OCCURED');
						   window.location.href=ctx+"/feesTerm";
				       }
					});
	});
	
	
	
	$('#feestermList').on( 'click', 'tr td a#delete', function () {
		 var feesTermid = $(this).attr('data-id');
		 $('#confirm-delete').on('show.bs.modal', function (e) {
			 $("#confirmDeleteFeesTerm").click(function(event) {
				 $("#feesTermid").val(feesTermid);
				 $("#deleteFeesTermForm").submit();
			});
			});
		   
	});

	

	$("#updateFeesTerm").click(function(event){
		if($("#updateFeesTermForm").valid())
		{
				$("#updateConfirmation").modal('show');
				$("#updateConfirm").click(function(event) {
					$('#updateFeesTermForm').submit();
				});
			
		}
	  });



});