$(document).ready(function() {
var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

$("#academicYearSave").click(function(event) {
	$('#academicYearform').validate({
 		ignore:null,
 		 errorPlacement: function ($error, $element) {
             var name = $element.attr("name");   	             
 	             $("#error" + name).append($error);
         }
 		
          
 	});
	if($("#academicYearform").valid())
		{
			$("#academicYearSaveConfirmation").modal('show');
			$("#academicYearSaveConfirm").click(function(event) {
				$("#academicYearform").submit();
			});
			return false;
		}
});

$('#academicYearList').on( 'click', 'tr td a#delete', function () {
	 var academicYearid = $(this).attr('data-id');
	
	 $('#deleteAcademicYearConfirmation').on('show.bs.modal', function (e) {
		 $("#deleteAcademicYearConfirm").click(function(event) {
			 $("#deleteAcademicYearId").val(academicYearid);
			 $("#deleteAcademicYearForm").submit();
		});
		});
	   
});

$('#academicYearList').on( 'click', 'tr td a#edit', function () {
	var academicYearid = $(this).attr('data-id');
	
	$.ajax({
		  url:ctx+'/academicYear/'+academicYearid,
		   type:'GET',
		   success: function(response)
		   {
			   if(response.academicYearTitle!=null)
			   {
				   $("[name=editAcademicYearTitle]").val(response.academicYearTitle);
			   }
			   
			   if(response.totalWorkingDays!=null)
			   {
				   $("[name=editAcademicYearTotalWorkingDays]").val(response.totalWorkingDays);
			   }
			  
			   if(response.academicYearStatus!=null)
			   {
				   $('#editAcademicYearStatus').selectpicker('destroy');
				   $("[name=editAcademicYearStatus]").find('option[value='+response.academicYearStatus+']').attr('selected','selected');
				   $('#editAcademicYearStatus').selectpicker('show');
			   }
			   if(response.academicYearId && response.academicYearId!=null)
			   {
				   $("#updateAcademicYear").attr('data-id',response.academicYearId);
			   }
			   
			   
		   },
		   error: function(){
		     alert('ERROR OCCURED');
		     window.location.href=ctx+"/academicYear";
		   }
		 });
});

$("#updateAcademicYear").click(function(event){
	
		$('#updateAcademicYearform').validate({
	 		ignore:null,
	 		 errorPlacement: function ($error, $element) {
	             var name = $element.attr("name");   	             
	 	             $("#error" + name).append($error);
	         }
	 		
	          
	 	});
	var academicYearId = $(this).attr('data-id');
	 $("#updateAcademicYearId").val(academicYearId);	
	 if($("#updateAcademicYearform").valid())
		{
			$("#updateAcademicYearConfirmation").modal('show');
			$("#updateAcademicYearConfirm").click(function(event) {
				$("#updateAcademicYearform").submit();
			});		
		}
  });



  
    $(".select2_multiple").select2({
        maximumSelectionLength: null,
        placeholder: "Select Fees Terms",
        allowClear: true
    });
    


});