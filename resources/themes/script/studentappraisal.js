 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
$(document).ready(function() {
	
	 var stuId=null;
		$('#class').change(function(event) {
	  	    var classId = $("#class").val();
	  	  $(".form-group-section").hide();
	  	 $(".form-group-studentid").hide();
	  	    if(classId!=="all"){
	  	    	 $(".form-group-section").show();
	 
	  	    	$.ajax({
					   url:ctx+'/classSection/'+classId,
					   type:'GET',
					   success: function(response){
						   var select = $('#section');
				    	   if(response.length>0)
				        	  {
				        		  select.find('option').remove(); 
				        		  $('#section').selectpicker('destroy');
				        	  }
				        	  else
				        	  {
				        		  select.find('option').remove();
				        		  $('#section').selectpicker('destroy');
				        		  select.append('<option value="" disabled >Select Section</option>');
				        	  }
						   $.each(response, function(key,value) {
						  		 if(key==0){
						     	    		select.append('<option value="" disabled >Select Section</option>');
						     	    	}
						  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
						  	 }); 
						   $('#section').selectpicker('show');
					   },
					   error: function(){
						   alert('ERROR OCCURED');
						  
				       }
					});
	  	    }
	  	  
	       
	 });
		
		$("#admissionNumber").click(function(event) {
	        $(".form-group-groupcriteria").hide();  
});
	 $('#getStudentAppraisal').click(function(event) {
		
		 if($('#getDetails').valid())
		 {
				$('.loader').show();
			 var data1=$('#getDetails').serialize();
			 var status=null;
				stuId=$('#admissionNumber').val();
				
				$.ajax(	
					 	{
					        type: 'GET',
					        url:ctx+"/student/studentAppraisalList" ,
					        data: data1,
					       dataType: "json",
					        cache:false,
					        success: function (data) {
						
					
						
						if (!$.trim(data))
						{ 
							 $('.loader').hide();
			        		 edumaatAlert({
					    			  title: "Info !",
					    			  text:"Data Not Found",
					    			  type: "info",
					    			  confirmButtonText: "Cool"
					    			}).then(function(){
					    				window.location.href=ctx+'/student/studentappraisal';
						        		
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
					 			 if(value.student.lastName!=null)
					 			 {
					 				name= value.student.firstName+' '+value.student.lastName;
					 			 }
					 			 else
					 			 {
					 				name= value.student.firstName; 
					 			 }
					 			 t.row.add( [
									            value.student.admissionNo ,
									            value.academicYear.academicYearTitle,
										        name,
										        value.studentClass.className+'/'+value.section.sectionName,
									           value.appraisalTerm ,
									            status ,
									            '<a href="#" id="edit" class="edit" type="button" data-href="#" data-id='+value.studentAppraisalId+' data-toggle="modal" onclick="showeditDiv();" ><span class="glyphicon glyphicon-edit"></span> </a><a href="#"  id="delete" class="delete" type="button" data-href="#"  data-id='+value.studentAppraisalId+' data-target="#deletestudentappraisalconfirmation"><span class="glyphicon glyphicon-trash"></span></a>'
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
	 
	   	 $("#addStudentAppraisal").click(function(event){
	   		 if($('#appraisal').valid())
			 {
					
  		 $('#saveConfirmation').modal('show');
			$('#saveConfirm').click(function(){
				$('.loader').show();
        	$('#appraisal').submit();		
			});
			 }
               });
	
	 
  	 $("#updateStudentAppraisal").click(function(event){
  		 if($('#editAppraisal').valid())
		 {
		$("#updateStudentAppraisalId").val($(this).attr('data-id'));
		 $('#saveConfirmation').modal('show');
		$('#saveConfirm').click(function(){
			$('.loader').show();
    	$('#editAppraisal').submit();		
		});
		 }
               });
 	 
	
	 
  	 $('#studentAppraisalList').on( 'click', 'tr td a#edit', function () {
  		var studentAppraisalId = $(this).attr('data-id');
		$.ajax(	
			 	{
			        type: "GET",
			        url:ctx+"/student/editStudentPerformance" ,
			        data: {studentAppraisalId:studentAppraisalId},
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
			    				window.location.href=ctx+'/student/studentappraisal';
				        		
				        	});
	        	 
				}
				else
			 	{
					 $('.loader').hide();
					 $('#editStudentAdmissionNumber').selectpicker('destroy');
				$("[name=editStudentAdmissionNumber]").val(response.student.admissionNo);
				 $('#editStudentAdmissionNumber').selectpicker('show');
  				$("[name=editAppraisalTerm]").val(response.appraisalTerm);
  				 $('#editRelationshipRating').selectpicker('destroy');
  				$("[name=editRelationshipRating]").find('option[value='+response.relationshipRating+']').attr('selected','selected');
  				 $('#editRelationshipRating').selectpicker('show');
  				$("[name=editRelationshipComments]").val(response.relationshipComments);
  				 $('#editAttitudeRating').selectpicker('destroy');
  				$("[name=editAttitudeRating]").find('option[value='+response.attitudeRating+']').attr('selected','selected');
  				 $('#editAttitudeRating').selectpicker('show');
  				$("[name=editAttitudeComments]").val(response.attitudeComments);
  				 $('#editAcademicRating').selectpicker('destroy');
  				$("[name=editAcademicRating]").find('option[value='+response.academicRating+']').attr('selected','selected');
  				 $('#editAcademicRating').selectpicker('show');
  				$("[name=editAcademicComments]").val(response.academicComments);
  				 $('#editInitiativeRating').selectpicker('destroy');
  				$("[name=editInitiativeRating]").find('option[value='+response.initiativeRating+']').attr('selected','selected');
  				 $('#editInitiativeRating').selectpicker('show');
  				$("[name=editInitiativeComments]").val(response.initiativeComments);
  				 $('#editCreativityRating').selectpicker('destroy');
  				$("[name=editCreativityRating]").find('option[value='+response.creativityRating+']').attr('selected','selected');
  				 $('#editCreativityRating').selectpicker('show');
  				$("[name=editCreativityComments]").val(response.creativityComments);
  				 $('#editPunctualityRating').selectpicker('destroy');
  				$("[name=editPunctualityRating]").find('option[value='+response.punctualityRating+']').attr('selected','selected');
  				 $('#editPunctualityRating').selectpicker('show');
  				$("[name=editPunctualityComments]").val(response.punctualityComments);
  				 $('#editSportsAndSocialRating').selectpicker('destroy');
  				$("[name=editSportsAndSocialRating]").find('option[value='+response.sportsAndSocialRating+']').attr('selected','selected');
  				 $('#editSportsAndSocialRating').selectpicker('show');
  				$("[name=editSportsAndSocialComments]").val(response.sportsAndSocialComments);
  				$("[name=editRecommentation]").val(response.recommendations);
  				 $('#editAppraisalStatus').selectpicker('destroy');
  				$("[name=editAppraisalStatus]").find('option[value='+response.appraisalStatus+']').attr('selected','selected');
  				 $('#editAppraisalStatus').selectpicker('show');
  			    $('#updateStudentAppraisal').attr('data-id',response.studentAppraisalId);
			 	}
			 	  },
			 	 	error:function(){
			 	 		$('.loader').hide();
			 	 		alert("Error Occured");
			          }
		      
			 	});
  		 });
  
  	 $('#studentAppraisalList').on( 'click', 'tr td a#delete', function () {
  		 var studentAppraisalId = $(this).attr('data-id');
	 $('#deletestudentappraisalconfirmation').modal('show');
		 $("#confirmdeletestudentappraisal").click(function(event) {
			 $("#deleteStudentAppraisalId").val(studentAppraisalId);
			 $('.loader').show();
			 $("#deletestudentappraisalform").submit();  
		});
		});
  	
  	
         });


 
 