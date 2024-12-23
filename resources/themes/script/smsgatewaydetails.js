var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
	
	
$("#savesmsgatewaydetails").click(function(event) {

		 if($("#addsmsgatewaydetailsform").valid())
			{
					$("#smsgatewaydetailssaveconfirmation").modal('show');
					$("#smsgatewaydetailssaveconfirm").click(function(event) {
						$("#addsmsgatewaydetailsform").submit();
					});
		}
});

$('#sMSGatewaylist').on( 'click', 'tr td a#edit', function () {
	
	 var smsgatewaydetailsid = $(this).attr('data-id');
	 $("#smsgatewaydetailsId").val(smsgatewaydetailsid);
	 	$('.loader').show();
	 
			   $.ajax({
				   url:ctx+"/smsgatewaydetails/"+smsgatewaydetailsid,
				   type:'GET',
				   success: function(response)
				   {
					 $('#multiEditFormDiv').show();   
					 $('.loader').hide();
					 $("#editsmsgatewayusername").val(response.smsGatewayUserName);
					 $("#editsmsgatewaypassword").val(response.smsGatewayPassword);
					 $("#editsmsgatewaysenderid").val(response.smsGatewaySenderId);
				
				   },
			   	   error: function(){
				     alert('ERROR OCCURED');
				     window.location.href=ctx+"/smsgatewaydetails";
				   }
				 });
});


$("#updatesmsgatewaydetails").click(function(event){

	 if($("#updatesmsgatewaydetailsform").valid())
		{
			 $('#smsgatewaydetailsupdateconfirmation').modal('show');
			 $('#smsgatewaydetailsupdateconfirm').click(function(){
				 $("#updatesmsgatewaydetailsform").submit();
	});
		}
});

$('#sMSGatewaylist').on( 'click', 'tr td a#delete', function () {
	 var smsgatewaydetailsid = $(this).attr('data-id');
	 $("#deletesmsgatewaydetailsId").val(smsgatewaydetailsid);
	 $('#deletesmsgatewaydetailsconfirmation').on('show.bs.modal', function (e) {
		 $("#confirmdeletesmsgatewaydetails").click(function(event) {
			$("#deletesmsgatewaydetailsForm").submit();  
		});
		});
	   
});

});
