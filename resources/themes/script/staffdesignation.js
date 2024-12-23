	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
$("#savedesignation").click(function(event) {
		 if($("#adddesignationform").valid())
			{
				$("#designationsaveconfirmation").modal('show');
				$("#designationsaveconfirm").click(function(event) {
					 $('.loader').show();
					$("#adddesignationform").submit();
				});
				
			}
});

$('#designationlist').on( 'click', 'tr td a#edit', function () {
	 var staffDesignationid = $(this).attr('data-id');
	 $("#updateDesignationId").val(staffDesignationid);
	 	$('.loader').show();
			   $.ajax({
				   url:ctx+'/staffdesignation/'+staffDesignationid,
				   type:'GET',
				   success: function(response)
				   {
					   $('.loader').hide();
					   if(response.staffDesignationName!=null)
					   {
						   $("#editStaffDesignationyName").val(response.staffDesignationName);
					   }
					   if(response.staffType!=null)
					   {
						   $('#editStaffTypeId').selectpicker('destroy');
						   $("[name=editStaffTypeId]").val(response.staffType.staffTypeId);
						   $('#editStaffTypeId').selectpicker('show');
					   }
					  
					   
				   },
			   	   error: function(){
				     alert('ERROR OCCURED');
				     window.location.href=ctx+"/staffdesignation";
				   }
				 });
});


$("#updatedesignation").click(function(event){
	 if($("#updatedesignationform").valid())
		{
			 $('#designationupdateconfirmation').modal('show');
			 $('#designationupdateconfirm').click(function(){
				 $('.loader').show();
				 $("#updatedesignationform").submit();
				
		      });
		}
});

$('#designationlist').on( 'click', 'tr td a#delete', function (event) {
	 var designationid = $(this).attr('data-id');
	 $("#deleteStaffDesignationId").val(designationid);
	 $('#deletedesignationconfirmation').on('show.bs.modal', function (e) {
		 $("#confirmdeletedesignation").click(function(event) {
			$("#deletedesignationform").submit();  
		});
		});
	   
});

});
