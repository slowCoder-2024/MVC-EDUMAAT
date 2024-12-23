var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
	
	
$("#savefeespenaltysettingdetails").click(function(event) {

		 if($("#addfeespenaltysettingdetailsform").valid())
			{
					$("#feespenaltydetailssaveconfirmation").modal('show');
					$("#feespenaltydetailssaveconfirm").click(function(event) {
						$("#addfeespenaltysettingdetailsform").submit();
					});
			}
});

$('#feesPenaltySettingList').on( 'click', 'tr td a#edit', function () {
	
	 var updateFeesPenaltySettingId = $(this).attr('data-id');
	 $("#updateFeesPenaltySettingId").val(updateFeesPenaltySettingId);
	 	$('.loader').show();
	 
			   $.ajax({
				   url:ctx+"/feesStructure/feesPenaltySetting/"+updateFeesPenaltySettingId,
				   type:'GET',
				   success: function(response)
				   {
					 $('#multiEditFormDiv').show();   
					 $('.loader').hide();
					 $('#editpenaltycriteriaid').selectpicker('destroy');
					 $("#editpenaltycriteriaid").val(response.feesPenaltySettingType);
					 $('#editpenaltycriteriaid').selectpicker('show');
					 $("#editduedays").val(response.dueDays);
					 $('#editpenaltycategoryid').selectpicker('destroy');
					 $("#editpenaltycategoryid").val(response.penaltyCategory);
					 $('#editpenaltycategoryid').selectpicker('show');
					 
					 if(response.penaltyType=="percentage")
					 {
						 $("#editpercentage").val(response.percentage);
						 $(".form-group-edit-amount").hide();
						 $(".form-group-edit-percentage").show();
					 }
					 else if(response.penaltyType=="amount")
					 {
						 $("#editamount").val(response.amount);
						 $(".form-group-edit-amount").show();
						 $(".form-group-edit-percentage").hide();
					 }
					 $('#editpenaltytypeid').selectpicker('destroy');
					 $("#editpenaltytypeid").val(response.penaltyType);
					 $('#editpenaltytypeid').selectpicker('show');
				   },
			   	   error: function(){
				     alert('ERROR OCCURED');
				     window.location.href=ctx+"/feesStructure/feesPenaltySetting";
				   }
				 });
});


$("#updatefeespenaltysettingdetails").click(function(event){

	 if($("#updatefeespenaltysettingdetailsform").valid())
		{
			 $('#feespenaltysettingdetailsupdateconfirmation').modal('show');
			 $('#feespenaltysettingdetailsupdateconfirm').click(function(){
				 $("#updatefeespenaltysettingdetailsform").submit();
	});
		}
});

$('#feesPenaltySettingList').on( 'click', 'tr td a#delete', function () {
	 var deletefeespenaltysettingId = $(this).attr('data-id');
	 $("#deletefeespenaltysettingId").val(deletefeespenaltysettingId);
	 $('#deletefeespenaltysettingdetailsconfirmation').on('show.bs.modal', function (e) {
		 $("#confirmdeletefeespenaltysettingdetails").click(function(event) {
			$("#deletefeespenaltysettingdetailsForm").submit();  
		});
		});
	   
});



$('#penaltytypeid').change(function(event) {
    var criteriaId = $("#penaltytypeid").val();
      if(criteriaId=="percentage")
	  {
		  $(".form-group-percentage").show();
		  $(".form-group-amount").hide();
	  }
	  else if(criteriaId=="amount")
	  {
		 $(".form-group-amount").show();
		 $(".form-group-percentage").hide();
	  }
	});


$('#editpenaltytypeid').change(function(event) {
    var criteriaId = $("#editpenaltytypeid").val();
      if(criteriaId=="percentage")
	  {
		  $(".form-group-edit-percentage").show();
		  $(".form-group-edit-amount").hide();
	  }
	  else if(criteriaId=="amount")
	  {
		 $(".form-group-edit-amount").show();
		 $(".form-group-edit-percentage").hide();
	  }
	});



});
function handleChange(input) {
    if (input.value < 0) input.value = 0;
    if (input.value > 100) input.value = 100;
  }