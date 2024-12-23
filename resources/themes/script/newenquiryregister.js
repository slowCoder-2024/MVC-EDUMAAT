 $(document).ready(function() {
	 
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
		myalert();
	 setInterval(function() {
			myalert();
			}, 60000);
	
	 $("#geographicallocationstate").prop('disabled', true);
		$("#geographicallocationcity").prop('disabled', true);
	function myalert()
	{
		$.ajax({
			   url:ctx+'/admissions/getApplicantList',
			   type:'GET',
			   success: function(response){
				   var select = $('#applicantCode');
		        	  if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#applicantCode').selectpicker('destroy');
		        	  }
		        	  else
		        	  { 
		        		  select.find('option').remove();
		        		  $('#applicantCode').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Applicant Code</option>');
		        	  }
		        	  $.each(response, function(key,value) {
		            		 if(key==0){
		   	        	    	select.append('<option value="" disabled selected>Select Applicant Code</option>');
		   	        	    	}
		            		
		            		 $('<option>').val(value).text(value).appendTo(select);
		            		
		            	  }); 
		        	   $('#applicantCode').selectpicker('show');
					
			   },
			   error: function(){
				   alert('ERROR OCCURED');
				   window.location.href=ctx+"/admissions/newadmission";
		       }
			});
	
	
		
	}
	 
	 $('#joinedClass').change(function(event) {
		   var classId = $("#joinedClass").val();
		    $.get(ctx+'/classSection/'+classId , function(response) {
	        	  var select = $('#joinedSection');
	        	  if(response.length>0)
	        	  {
	        		  select.find('option').remove(); 
	        		  $('#joinedSection').selectpicker('destroy');
	        	  }
	        	  else
	        	  { 
	        		  select.find('option').remove();
	        		  $('#joinedSection').selectpicker('destroy');
	        		  select.append('<option value="" disabled selected>Select Section</option>');
	        	  }
	        	  $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    	select.append('<option value="" disabled selected>Select Section</option>');
	   	        	    	}
	            		
	            		 $('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
	            		
	            	  }); 
	        	   $('#joinedSection').selectpicker('show');
	        });
	       
	 });

	  $('#studentList td a#edit').click(function() {
		  
		  var studentId = $(this).attr('data-id');
		  if(document.getElementById('EditFormDiv').style.display=="none")
			{
			document.getElementById('EditFormDiv').style.display="block";
			document.getElementById('ListDiv').style.display="none";
			
     	        $.get(ctx+'/student/editAdmission', {
     	        	studentId : studentId
     	        }, function(response) {
     	        	
     	        	$("[name=editFirstName]").val(response.firstName);
     	        	$("[name=editLastName]").val(response.lastName);
     	        	$("[name=editParentOrGuardianFirstName]").val(response.parentGuardianFirstName);
     	        	$("[name=editParentOrGuardianLastName]").val(response.parentGuardianLastName);
     	        	$("[name=editDateOfBirth]").val($.datepicker.formatDate('dd/mm/yy',new Date(response.birthDate)));
     	        	$("[name=editParentOrGuardianEmail]").val(response.parentGuardianEmail);
     	        	$("[name=editEMail]").val(response.email);
     	        	$("[name=editContact]").val(response.contact);
     	        	$("[name=editFatherIncome]").val(response.fathersIncome);
     	        	$("[name=editMotherIncome]").val(response.mothersIncome);
     	        	$("[name=editAddressLine1]").val(response.addressLine1);
     	        	$("[name=editAddressLine2]").val(response.addressLine2);
     	        	$("[name=editPostCode]").val(response.postcode);
     	        	$("[name=editPassportNo]").val(response.passportNumber);
     	        	$("[name=editBankName]").val(response.bankName);
     	        	$("[name=editBankAccountNo]").val(response.bankAccountNo);
     	        	$("[name=editBankIFSCCode]").val(response.bankIfsc);	
     	        	$("[name=editBankAddress]").val(response.bankAddress);
     	        	$("[name=editTallyAccountNo]").val(response.tallyAccountNo);    	
     	        	$("[name=editBatch]").val(response.batch);
     	        	$("[name=editCurrentSemester]").val(response.currentSemester);
     	        	$("[name=editJoinedSemester]").val(response.joinedSemester);
     	        	$("[name=editJoinedDate]").val($.datepicker.formatDate('dd/mm/yy',new Date(response.joinedDate)));
     	        	$("[name=editAchievement]").val(response.achievement);
     	        	$("[name=editAllergy]").val(response.allergy);
     	        	$("[name=editStudentAccessNo]").val(response.accessNo);
     	        	$("[name=editMedicineAllergy]").val(response.medicineAllergy);
     	        	$("[name=editMyStrength]").val(response.myStrengths);
     	        	$("[name=editStudentGender]").find('option[value='+response.sex+']').attr('selected','selected');
     	        	$("[name=editCategoryId]").find('option[value='+response.category.categoryId+']').attr('selected','selected');
     	        	$("[name=editSpecialCategoryId]").find('option[value='+response.specialCategory.specialCategoryId+']').attr('selected','selected');
     	        	$("[name=editCountryId]").find('option[value='+response.countryId+']').attr('selected','selected'); 	
     	        	$("[name=editStateId]").find('option[value='+response.stateId+']').attr('selected','selected');
     	        	$("[name=editCityId]").find('option[value='+response.cityId+']').attr('selected','selected');
     	        	$("[name=editScholarShip]").find('option[value='+response.scholarship+']').attr('selected','selected');
     	        	$("[name=editCourseTypeId]").find('option[value='+response.courseType.courseTypeId+']').attr('selected','selected');
     	        	$("[name=editCourseCategoryId]").find('option[value='+response.courseCategory.courseCategoryId+']').attr('selected','selected');
     	        	$("[name=editDepartmentId]").find('option[value='+response.department.departmentId+']').attr('selected','selected');
     	        	$("[name=editCourseId]").find('option[value='+response.courses.courseId+']').attr('selected','selected');
     	        	$("[name=editApproverId]").find('option[value='+response.approver.userId+']').attr('selected','selected');
     	        	$("[name=editStudentStatus]").find('option[value='+response.studentStatus.studentStatusId+']').attr('selected','selected');
     	        	$("[name=editBloodGroupListId]").find('option[value='+response.bloodGroup.bloodGroupId+']').attr('selected','selected');
     	        	$("[name=editAtRiskCategory]").find('option[value='+response.atRiskCategory+']').attr('selected','selected');
     	        	
     	        	
     	        	
     	        });
			}
     	 });
	 
	 
      $("#saveStudent").click(function(event){
    	  
    		$('#addstudentform').validate({
		        ignore: [],
		        // any other options and/or rules
		    });
    	 if( $('#addstudentform').valid()){
    		  
    		  $('#studentsaveconfirmation').modal('show');	
        	  $('#studentsaveconfirm').click(function(){
        		   $("#geographicallocationstate").prop('disabled', false);
        		  $("#geographicallocationcity").prop('disabled', false);
        		  $("#addstudentform").submit();
        		
             	 }); 
    		  
    	  }
    	  return false;
    	  	 });
      

	  
	  $('#studentList td a#delete').click(function() {
		  
		  var studentId = $(this).attr('data-id');
		  $('#confirm-save').modal('show');	
	 	  $('#confirmSave').click(function(){
	 		 var data=$(this).attr('data-id');
		 $.post(ctx+"/student/deleteAdmission?studentId="+studentId,data,function(data) {
				window.location.href=ctx+"/admissions/newadmission";    
		   });
	 	  });
	  
		    });
      
 
             $('#country').change(function(event) {
           	  
     	        var countryid = $("#country").val();
     	        $.get(ctx+'/geographicallocation/state', {
     	                countryId : countryid
     	        }, function(response) {
     	        	  var select = $('#state');
     	        	   select.find('option').remove();
     	        	   var select1=$('#city');
   	        	   		select1.find('option').remove();
     	            	 var obj = jQuery.parseJSON(response);
     	            	 $('#state').selectpicker('destroy');
     	            	 $('#city').selectpicker('destroy');
     	            	 $.each(obj, function(key,value) {
     	            		 if(key==0){
     	   	        	    		select.append('<option value="" disabled selected>Select State</option>');
     	   	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
     	   	        	    	}
     	            		 $('<option>').val(value.geographicalLocationId).text(value.name).appendTo(select);
     	            	  
     	            	 }); 
     	            	 $('#state').selectpicker('show');
     	            	 $('#city').selectpicker('show');
     	        });
     	       
     	 });
     	        
     	        
     	$('#state').change(function(event) {
     	    var stateid = $("#state").val();

     	    $.get(ctx+'/geographicallocation/city', {
     	            stateId : stateid
     	    }, function(response) {
     	    	
     	    	  var select = $('#city');
     	        	 select.find('option').remove();
     	        	 var obj = jQuery.parseJSON(response);
     	        	 $('#city').selectpicker('destroy');
     	        	 $.each(obj, function(key,value) {
     	        		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select City</option>');
	   	        	    	}
     	        		 $('<option>').val(value.geographicalLocationId).text(value.name).appendTo(select);
     	        	  
     	        	 }); 
     	        	 $('#city').selectpicker('show');
     	    });
     	   
     	    });
     	 

	    $('#editgeographicallocation').change(function(event) {
      	  
	        var countryid = $("#editgeographicallocation").val();
	        $.get(ctx+'/geographicallocation/state', {
	                countryId : countryid
	        }, function(response) {
	        	  var select = $('#editgeographicallocationstate');
	        	   select.find('option').remove();
	        	   var select1=$('#editgeographicallocationcity');
	        	   		select1.find('option').remove();
	            	 var obj = jQuery.parseJSON(response);
	            	 $('#editgeographicallocationstate').selectpicker('destroy');
 	            	 $('#editgeographicallocationcity').selectpicker('destroy');
	            	 $.each(obj, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select State</option>');
	   	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
	   	        	    	}
	            		 $('<option>').val(value.geographicalLocationId).text(value.name).appendTo(select);
	            	  
	            	 }); 
	            	 $('#editgeographicallocationstate').selectpicker('show');
 	            	 $('#editgeographicallocationcity').selectpicker('show');
	        });
	       
	 });
	        
	        
	$('#editgeographicallocationstate').change(function(event) {
	    var stateid = $("#editgeographicallocationstate").val();

	    $.get(ctx+'/geographicallocation/city', {
	            stateId : stateid
	    }, function(response) {
	    	
	    	  var select = $('#editgeographicallocationcity');
	        	 select.find('option').remove();
	        	 var obj = jQuery.parseJSON(response);
	        	 	 $('#editgeographicallocationcity').selectpicker('destroy');
	        	 $.each(obj, function(key,value) {
	        		 if(key==0){
	        	    		select.append('<option value="" disabled selected>Select City</option>');
	        	    	}
	        		 $('<option>').val(value.geographicalLocationId).text(value.name).appendTo(select);
	        	  
	        	 }); 
	        		 $('#editgeographicallocationcity').selectpicker('show');
	    });
	   
	    });
	 $('#geographicallocationstate').attr('disabled', false);
	  $('#geographicallocationcity').attr('disabled', false);
	  
	  
	  
	  
	  
	  
	  
	  $('input[type=radio][name=salerateoption]').change(function() {
			if (this.value == "yes") {
				$("#saleratediv").show();
	        }
	        else if (this.value == "no") {
	        	$("#saleratediv").hide();
	        }
	    });
	  
	  
	  
	  
	  
         });
 
 
 
 
 
 
 
 
 
