var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

$("#ledgerAccountSave").click(function(event) {
	$(this).validate();
	if($("#ledgerAccountform").valid())
		{
			$("#ledgerAccountSaveConfirmation").modal('show');
			$("#ledgerAccountSaveConfirm").click(function(event) {
				$("#ledgerAccountform").submit();
			});
			return false;
		}
});

$('#ledgerAccountList').on( 'click', 'tr td a#delete', function () {
	 var ledgerAccountid = $(this).attr('data-id');
	 $('#confirm-delete').on('show.bs.modal', function (e) {
		 $("#confirmDeleteLedger").click(function(event) {
			 $("#deleteLedgerId").val(ledgerAccountid);
			 $("#deleteLedgerForm").submit();
		});
		});
	   
});

$('#ledgerAccountList').on( 'click', 'tr td a#edit', function () {
	var ledgerAccountid = $(this).attr('data-id');
	$('.loader').show();
	$.ajax({
		   url:ctx+'/institution/ledgerAccount/editReterive',
		   data:{ledgerAccountId:ledgerAccountid},
		   type:'GET',
		   success: function(response){
			   $('.loader').hide();
			   if(response.ledgerAccountName!=null)
			   {
				   $("[name=editLedgerAccountName]").val(response.ledgerAccountName); 
			   }
			   if(response.ledgerReferenceNo!=null)
			   {
				   $("[name=editLedgerAccountReferenceNo]").val(response.ledgerReferenceNo);
			   }
			   if(response.ledgerAccountId!=null)
			   {
				   $("#updateLedgerAccount").attr('data-id',response.ledgerAccountId);
			   }
		   },
		   error: function(){
		     alert('ERROR OCCURED');
		     window.location.href=ctx+"/class";
		   }
		 });
});

$("#updateLedgerAccount").click(function(event){
	var ledgerAccountId = $(this).attr('data-id');
	$(this).validate();
	 $("#updateLedgerId").val(ledgerAccountId);
	 if($("#updateLedgerAccountForm").valid())
		{
			$("#updateConfirmation").modal('show');
			$("#updateConfirm").click(function(event) {
				
				$('#updateLedgerAccountForm').submit();
			});
		
		}
  });


