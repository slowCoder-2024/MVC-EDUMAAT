 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
$(document).ready(function() {
	 
	 var staId=null;
	 $('#academicYearId').change(function(event) {
	 $("#academicYearFormGroup").show();
	 $("#staffCodeFormGroup").hide();
	 });
	 $('#getStaffCode').change(function(event) {
		 $("#academicYearFormGroup").hide();
		 $("#staffCodeFormGroup").show();
	 });
	 $('#getStaffPerformance').click(function(event) {
		 
		 if($('#getDetails').valid())
		 {
				$('.loader').show();
  		 var data1=$('#getDetails').serialize();
			var status=null;
			staId=$('#getStaffCode').val();
			
			$.ajax(	
				 	{
				        type: 'GET',
				        url:ctx+"/staff/getStaffAppraisalList" ,
				        data: data1,
				       dataType: "json",
				        cache:false,
				        success: function (data) {
					
						if (!$.trim(data)){ 
					 	
						 $('.loader').hide();
		        		 edumaatAlert({
				    			  title: "Info !",
				    			  text:"Data Not Found",
				    			  type: "info",
				    			  confirmButtonText: "Cool"
				    			}).then(function(){
				    				window.location.href=ctx+'/staff/staffappraisal';
					        		
					        	});
				 		
				 	}
					else
				 	{
						 $('.loader').hide();
							var t = $('#datatable').DataTable();
							t.clear().draw();
					    $.each(data, function(key,value) 
				 			{
				 			 if(value.appraisalStatus==1)
							 {
								status="Completed";
							 }
							 else 
							 {
								status="In-Process";
							 }
				 			 var name="";
				 			 if(value.staff.lastName!=null)
				 			 {
				 				name= value.staff.firstName+' '+value.staff.lastName;
				 			 }
				 			 else
				 			 {
				 				name= value.staff.firstName; 
				 			 }
				 			 t.row.add( [
								            value.staff.staffCode ,
								            name,
								            value.academicYear.academicYearTitle,
								            value.appraisalTerm ,
								            status ,
								            '<a href="#" id="edit" class="edit" type="button" data-href="#" data-id='+value.staffAppraisalId+' data-toggle="modal" onclick="showeditDiv();" ><span class="glyphicon glyphicon-edit"></span> </a><a href="#"  id="delete" class="delete" type="button" data-href="#"  data-id='+value.staffAppraisalId+' data-target="#confirm-delete"><span class="glyphicon glyphicon-trash"></span></a>'
								        ] ).draw( false );
				 			});
					    
				   
				 	}
			    },
				 	 	error:function(){
				 	 		$('.loader').hide();
				 	 		alert("Error Occured");
				          }
			      
				 	});
		 }
		});
	 
	   	 $("#addStaffAppraisal").click(function(event){
	   		 if($('#addAppraisal').valid())
			 {
  		 $('#saveConfirmation').modal('show');
			$('#saveConfirm').click(function(){
				$('.loader').show();
        	$('#addAppraisal').submit();		
			});
			 }
               });
	
	 
  /*	 $("#updateStaffAppraisal").click(function(event){
  		 $('#saveConfirmation').modal('show');
  		 var staffPerformanceId = $(this).attr('data-id');
			$('#saveConfirm').click(function(){
				var data=$('#editAppraisal').serialize();	
        	$.post(ctx+"/staff/updateStaffPerformance?staffPerformanceId="+staffPerformanceId,data,function(data) {
					window.location.href=ctx+"/staff/staffappraisal";       				
      });
			});
               });
 	 */

	  	 $("#updateStaffAppraisal").click(function(event){
	  		 if($('#editAppraisal').valid())
			 {
			$("#updateStaffAppraisalId").val($(this).attr('data-id'));
			 $('#saveConfirmation').modal('show');
			$('#saveConfirm').click(function(){
				$('.loader').show();
	    	$('#editAppraisal').submit();		
			});
			 }
	               });
	 
	 $('#staffPerformance').on( 'click', 'tr td a#edit', function () {
  		var staffAppraisalId = $(this).attr('data-id');
  		$.ajax({
			        type: "GET",
			        url:ctx+"/staff/editStaffAppraisal" ,
			        data: {staffAppraisalId:staffAppraisalId},
			        contentType: "application/json; charset=utf-8",
			        dataType: "json",
			        success: function (response) {
			   if (!$.trim(response))
				{ 
					 $('.loader').hide();
	        		 edumaatAlert({
			    			  title: "Info !",
			    			  text:"Data Not Found",
			    			  type: "info",
			    			  confirmButtonText: "Cool"
			    			}).then(function(){
			    				window.location.href=ctx+'/staff/staffappraisal';
				        	});
	        	}
				else
			 	{
					 $('.loader').hide();
					 $('#editStaffId').selectpicker('destroy');
  	     		$("[name=editStaffId]").val(response.staff.staffCode);
  	     	 $('#editStaffId').selectpicker('show');
  				$("[name=editAppraisalTerm]").val(response.appraisalTerm);
  				 $('#editRelationshipRating').selectpicker('destroy');
  				$("[name=editRelationshipRating]").find('option[value='+response.relationshipRating+']').attr('selected','selected');
  				 $('#editRelationshipRating').selectpicker('show');
  				$("[name=editRelationshipComments]").val(response.relationshipComments);
  				 $('#editTeachingRating').selectpicker('destroy');
  				$("[name=editTeachingRating]").find('option[value='+response.teachingRating+']').attr('selected','selected');
  				 $('#editTeachingRating').selectpicker('show');
  				$("[name=editTeachingComments]").val(response.teachingComments);
  				 $('#editResearchAndHigherQualificationRating').selectpicker('destroy');
  				$("[name=editResearchAndHigherQualificationRating]").find('option[value='+response.researchAndHigherQualificationRating+']').attr('selected','selected');
  				 $('#editResearchAndHigherQualificationRating').selectpicker('show');
  				$("[name=editResearchAndHigherQualificationComments]").val(response.researchAndHigherQualificationComments);
  				 $('#editInitiativeAndOrganizationRating').selectpicker('destroy');
  				$("[name=editInitiativeAndOrganizationRating]").find('option[value='+response.initiativeAndOrganizationRating+']').attr('selected','selected');
  				 $('#editInitiativeAndOrganizationRating').selectpicker('show');
  				$("[name=editInitiativeAndOrganizationComments]").val(response.initiativeAndOrganizationComments);
  				 $('#editInnovationRating').selectpicker('destroy');
  				$("[name=editInnovationRating]").find('option[value='+response.innovationRating+']').attr('selected','selected');
  				 $('#editInnovationRating').selectpicker('show');
  				$("[name=editInnovationComments]").val(response.innovationComments);
  				 $('#editPunctualityRating').selectpicker('destroy');
  				$("[name=editPunctualityRating]").find('option[value='+response.punctualityRating+']').attr('selected','selected');
  				 $('#editPunctualityRating').selectpicker('show');
  				$("[name=editPunctualityComments]").val(response.punctualityComments);
  				 $('#editGoalAlignmentRating').selectpicker('destroy');
  				$("[name=editGoalAlignmentRating]").find('option[value='+response.goalAlignmentRating+']').attr('selected','selected');
  				 $('#editGoalAlignmentRating').selectpicker('show');
  				$("[name=editGoalAlignmentcomments]").val(response.goalAlignmentComments);
  				$("[name=editRecommendations]").val(response.recommendations);
  				 $('#editAppraisalStatus').selectpicker('destroy');
  				$("[name=editAppraisalStatus]").find('option[value='+response.appraisalStatus+']').attr('selected','selected');
  				 $('#editAppraisalStatus').selectpicker('show');
  			    $('#updateStaffAppraisal').attr('data-id',response.staffAppraisalId);
			 	}
  	    },
 	 	error:function(){
 	 		$('.loader').hide();
 	 		alert("Error Occured");
          }
  
 	});
});
  
  /*	$(document).on('click',".delete",function (){   
  		var staffPerformanceId = $(this).attr('data-id');
  		 $('#saveConfirmation').modal('show');
			$('#saveConfirm').click(function(){
				 $.get(ctx+'/staff/deleteStaffPerformance', {
		  	    	  staffPerformanceId : staffPerformanceId
		  	      }, function(response) {   
		  	    	window.location.href=ctx+"/staff/staffappraisal";     
		  	      });
			});
    	  
  		 });*/
  
  	 $('#staffPerformance').on( 'click', 'tr td a#delete', function () {
  		 var staffAppraisalId = $(this).attr('data-id');
	 $('#deletestaffappraisalconfirmation').modal('show');
		 $("#confirmdeletestaffappraisal").click(function(event) {
			 $("#deleteStaffAppraisalId").val(staffAppraisalId);
			 $('.loader').show();
			 $("#deletestaffappraisalform").submit();  
		});
		});
         });


 
 