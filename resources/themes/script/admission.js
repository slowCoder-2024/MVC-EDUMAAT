	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
					
$(document).ready(function() {
	
	 $('#studentAdmissionDetailsExcel').click(function(event)
			  {
			 	 var url=ctx+'/student/studentAdmissionDetailExcelFormat';
				 $('#getDetails').attr('action',url).submit(); 
			 });
	
				 $('#classId').change(function(event) {
					   var classId = $("#classId").val();
					    $.get(ctx+'/admissions/getAdmissionByClass', {
				                classId : classId
				        }, function(response) {
				        	  var select = $('#admissionCodeFormat');
				        	
				        	  if(response.length>0)
				        	  {
				        		  select.find('option').remove(); 
				        		  $('#admissionCodeFormat').selectpicker('destroy');
				        	  }
				        	  else
				        	  { 
				        		  select.find('option').remove();
				        		  $('#admissionCodeFormat').selectpicker('destroy');
				        		  select.append('<option value="" disabled selected>Select Admission Code Format</option>');
				        	  }
				        	  
				        	   $.each(response, function(key,value) {
				            		 if(key==0)
				            		 {
				   	        	    		select.append('<option value="" disabled selected>Select Admission Code Format</option>');
				   	        	     }
				            		 $('<option>').val(value.admissionConfigId).text(value.applicationCodeFormat).appendTo(select);
				            	  }); 
				        	   $('#admissionCodeFormat').selectpicker('show');
				        });
				       
				 });
				 $("#admissionSave").click(function(event){
					
					/* $('#newadmissionForm').validate({
		  				 submitHandler: function(form) {
					  $("#admissionSaveConfirmation").modal('show');
					  	$("#admissionSaveConfirm").click(function(){
			     			 var data=$("#newadmissionForm").serialize();
			     			 $.post(ctx+"/candidate/newAdmission/save",data,function(data) {
			          			window.location.href="applyforadmission";
			                   });
			     		});
				         }
		  			  });	*/
					 $('#newadmissionForm').validate({
					        ignore: [],
					        // any other options and/or rules
					    });
					 if( $('#newadmissionForm').valid())
					 {
						 
						 $("#admissionSaveConfirmation").modal('show');
						  	$("#admissionSaveConfirm").click(function(event){
						  		$('.loader').show();
						  		$("#newadmissionForm").submit();
						  		$('.loader').hide();
				     	});
					 }
				});
				
				 
				//edit
				 
	        	 $('#applicationList td a#edit').click(function(){
	        		 $('.loader').show();
	        		 var admissionid = $(this).attr('data-id');
	        			if(document.getElementById('editFormDiv').style.display=="none"){
	        				document.getElementById('editFormDiv').style.display="block";
	        				document.getElementById('ListDiv').style.display="none";
	        				
	        				$.get(ctx+'/admissions/candidate/newAdmission/edit', {
	        					admissionId:admissionid
	        						}, function(response) {
	        							$('.loader').hide();
	        							if(response.candidateFirstName && response.candidateFirstName!=null)
	        							{
	        								$("[name=editcandidateFirstName]").val(response.candidateFirstName);
	        							}
	        							if(response.candidateLastName && response.candidateLastName!=null)
	        							{
	        								$("[name=editcandidateLastName]").val(response.candidateLastName);
	        							}
	        							if(response.candidateGender && response.candidateGender!=null)
	        							{
	        								$('#editcandidateGender').selectpicker('destroy');
	        								$("[name=editcandidateGender]").find('option[value='+response.candidateGender+']').attr('selected','selected');
	        								$('#editcandidateGender').selectpicker('show');
	            							
	        							}
	        							if(response.dateOfBirth && response.dateOfBirth!=null)
	        							{
	        								/*$("[name=editdateOfBirth]").val($.datepicker.formatDate("dd/mm/yy", new Date(response.dateOfBirth)));*/
	        								$("#editdateOfBirth").datepicker('update',new Date(response.dateOfBirth));
	        							}
	        							if(response.religion && response.religion.religionId!=null)
	        							{
	        								$('#editreligionId').selectpicker('destroy');
	        								$("[name=editreligionId]").find('option[value='+response.religion.religionId+']').attr('selected','selected');
	        								$('#editreligionId').selectpicker('show');
	            							
	        							}
	        							if(response.category && response.category.categoryId!=null)
	        							{
	        								$('#editcategoryId').selectpicker('destroy');
	        								$("[name=editcategoryId]").find('option[value='+response.category.categoryId+']').attr('selected','selected');
	        								$('#editcategoryId').selectpicker('show');
	            							
	        							}
	        							if(response.specialCategory && response.specialCategory.specialCategoryId!=null)
	        							{
	        								$('#editspecialCategoryId').selectpicker('destroy');
	        								$("[name=editspecialCategoryId]").find('option[value='+response.specialCategory.specialCategoryId+']').attr('selected','selected');
	        								$('#editspecialCategoryId').selectpicker('show');
	        							}
	        							if(response.passportNo && response.passportNo!=null)
	        							{
	        								$("[name=editpassportNo]").val(response.passportNo);
	            							
	        							}
	        							if( response.passportIssuedCountry && response.passportIssuedCountry!=null)
	        							{
	        								$('#editpassportissuedCountryId').selectpicker('destroy');
	        								$("[name=editpassportissuedCountryId]").find('option[value='+response.passportIssuedCountry+']').attr('selected','selected');
	        								$('#editpassportissuedCountryId').selectpicker('show');
	        							}
	        							if(response.studiedHereBefore && response.studiedHereBefore!=null)
	        							{
	        								$('#editIsStudiedBefore').selectpicker('destroy');
	        								$("[name=editIsStudiedBefore]").find('option[value='+response.studiedHereBefore+']').attr('selected','selected');
	        								$('#editIsStudiedBefore').selectpicker('show');
	        							}
	        							if(response.previousStudentIdOfThisInstitute && response.previousStudentIdOfThisInstitute!=null)
	        							{
	        								$("[name=editpreviousStudentId]").val(response.previousStudentIdOfThisInstitute);
	            							
	        							}
	        							if(response.sponser && response.sponser.sponserId!=null)
	        							{
	        								$('#editsponserId').selectpicker('destroy');
	        								$("[name=editsponserId]").find('option[value='+response.sponser.sponserId+']').attr('selected','selected');
	        								$('#editsponserId').selectpicker('show');
	            							
	        							}
	        						
	        							if(response.disability && response.disability!=null )
	        							{
	        								$('#editisDisability').selectpicker('destroy');
	        								$("[name=editisDisability]").find('option[value='+response.disability+']').attr('selected','selected');
	        								$('#editisDisability').selectpicker('show');
	            							
	        							}
	        							if(response.fatherFirstName && response.fatherFirstName!=null)
	        							{
	        								$("[name=editfatherFirstName]").val(response.fatherFirstName);
	            							
	        							}
	        							if(response.fatherLastName && response.fatherLastName!=null)
	        							{
	        								$("[name=editfatherLastName]").val(response.fatherLastName);
	            							
	        							}
	        							if(response.fatherOccupation && response.fatherOccupation!=null)
	        							{
	        								$("[name=editfatherOccupation]").val(response.fatherOccupation);
	            							
	        							}
	        							if(response.motherFirstName && response.motherFirstName!=null)
	        							{
	        								$("[name=editmotherFirstName]").val(response.motherFirstName);
	            							
	        							}
	        							if(response.motherLastName && response.motherLastName!=null)
	        							{
	        								$("[name=editmotherLastName]").val(response.motherLastName);
	            							
	        							}
	        							if(response.motherOccupation && response.motherOccupation!=null)
	        							{
	        								$("[name=editmotherOccupation]").val(response.motherOccupation);
	            							
	        							}
	        							if(response.fatherIncome && response.fatherIncome!=null)
	        							{
	        								$("[name=editfatherIncome]").val(response.fatherIncome);
	            							
	        							}
	        							if(response.motherIncome && response.motherIncome!=null)
	        							{
	        								$("[name=editmotherIncome]").val(response.motherIncome);
	            							
	        							}
	        							if(response.guardianFirstName && response.guardianFirstName!=null)
	        							{
	        								$("[name=editguardianFirstName]").val(response.guardianFirstName);
	            							
	        							}
	        							if(response.guardianLastName && response.guardianLastName!=null)
	        							{
	        								$("[name=editguardianLastName]").val(response.guardianLastName);
	            							
	        							}
	        							if(response.referenceOneFirstName && response.referenceOneFirstName!=null)
	        							{
	        								$("[name=editreference1FirstName]").val(response.referenceOneFirstName);
	            							
	        							}
	        							if(response.referenceOneLastName && response.referenceOneLastName!=null)
	        							{
	        								$("[name=editreference1LastName]").val(response.referenceOneLastName);
	        							}
	        							if(response.referenceOneEmail && response.referenceOneEmail!=null)
	        							{
	        								$("[name=editreference1Email]").val(response.referenceOneEmail);
	        							}
	        							if(response.referenceOneMobile && response.referenceOneMobile!=null)
	        							{
	        								$("[name=editreference1Mobile]").val(response.referenceOneMobile);
	            							
	        							}
	        							if(response.referenceOneAddressLineOne && response.referenceOneAddressLineOne!=null)
	        							{
	        								$("[name=editreference1AddressLine1]").val(response.referenceOneAddressLineOne);
	            							
	        							}
	        							if(response.referenceOneAddressLineTwo && response.referenceOneAddressLineTwo!=null)
	        							{
	        								$("[name=editreference1AddressLine2]").val(response.referenceOneAddressLineTwo);
	            							
	        							}
	        							if(response.referenceOneCountry && response.referenceOneCountry!=null)
	        							{
	        								$('#editreference1CountryId').selectpicker('destroy');
	        								$("[name=editreference1CountryId]").find('option[value='+response.referenceOneCountry+']').attr('selected','selected');
	        								$('#editreference1CountryId').selectpicker('show');
	        							}
	        							if(response.referenceOnePincode && response.referenceOnePincode!=null)
	        							{
	        								$("[name=editreference1Pincode]").val(response.referenceOnePincode);
	            							
	        							}
	        							if(response.referenceTwoFirstName && response.referenceTwoFirstName!=null)
	        							{
	        								$("[name=editreference2FirstName]").val(response.referenceTwoFirstName);
	            							
	        							}
	        						
	        							if(response.referenceTwoLastName && response.referenceTwoLastName!=null)
	        							{
	        								$("[name=editreference2LastName]").val(response.referenceTwoLastName);
	            							
	        							}
	        							if(response.referenceTwoEmail && response.referenceTwoEmail!=null)
	        							{
	        								$("[name=editreference2Email]").val(response.referenceTwoEmail);
	            							
	        							}
	        							if(response.referenceTwoMobile && response.referenceTwoMobile!=null)
	        							{
	        								$("[name=editreference2Mobile]").val(response.referenceTwoMobile);
	            							
	        							}
	        							if(response.referenceTwoAddressLineOne && response.referenceTwoAddressLineOne!=null)
	        							{
	        								$("[name=editreference2AddressLine1]").val(response.referenceTwoAddressLineOne);
	            							
	        							}
	        							if(response.referenceTwoAddressLineTwo && response.referenceTwoAddressLineTwo!=null)
	        							{
	        								$("[name=editreference2AddressLine2]").val(response.referenceTwoAddressLineTwo);
	            							
	        							}
	        							if(response.referenceTwoCountry && response.referenceTwoCountry!=null)
	        							{
	        								$('#editreference2CountryId').selectpicker('destroy');
	        								$("[name=editreference2CountryId]").find('option[value='+response.referenceTwoCountry+']').attr('selected','selected');
	        								$('#editreference2CountryId').selectpicker('show');
	        							}
	        							if(response.referenceTwoPincode && response.referenceTwoPincode!=null)
	        							{
	        								$("[name=editreference2Pincode]").val(response.referenceTwoPincode);
	                						
	        							}
	        							if(response.hearedUs && response.hearedUs.hearedUsId!=null)
	        							{
	        								$('#edithearedUsid').selectpicker('destroy');
	        								$("[name=edithearedUsid]").find('option[value='+response.hearedUs.hearedUsId+']').attr('selected','selected');
	        								$('#edithearedUsid').selectpicker('show');
	        							}
	        							if(response.candidateAddressLineOne && response.candidateAddressLineOne!=null)
	        							{
	        								$("[name=editcandidateAddressLine1]").val(response.candidateAddressLineOne);
	            							
	        							}
	        							if(response.candidateAddressLineTwo && response.candidateAddressLineTwo!=null)
	        							{
	        								$("[name=editcandidateAddressLine2]").val(response.candidateAddressLineTwo);
	            							
	        							}
	        						
	        							if(response.candidateContactNo && response.candidateContactNo!=null)
	        							{
	        								$("[name=editmobileNumber]").val(response.candidateContactNo);
	            							
	        							}
	        							if(response.candidateEmail && response.candidateEmail!=null)
	        							{
	        								$("[name=editcandidateEmail]").val(response.candidateEmail);
	                						
	        							}
	        							if(response.candidateCountry && response.candidateCountry!=null)
	        							{
	        								$('#editgeographicallocation').selectpicker('destroy');
	        								$("[name=editcandidateCountryid]").find('option[value='+response.candidateCountry+']').attr('selected','selected');
	        								$('#editgeographicallocation').selectpicker('show');
	        							}
	        							if(response.candidateState && response.candidateState!=null)
	        							{
	        								$('#editgeographicallocationstate').selectpicker('destroy');
	        								$("#editgeographicallocationstate").val(response.candidateState);
	        								$('#editgeographicallocationstate').selectpicker('show');
	        								$("#editgeographicallocationstate").prop('disabled', true);
	        								
	        			  				 }
	        			  				else
	        			  				{
	        			  					$("#editgeographicallocationstate").prop('disabled', true);	
	        			  				}
	        							if(response.candidateCity && response.candidateCity!=null)
	        							{
	        								$('#editgeographicallocationcity').selectpicker('destroy');
	        								$("[name=editcandidateCityid]").val(response.candidateCity);
	        								$('#editgeographicallocationcity').selectpicker('show');
	        								$("#editgeographicallocationcity").prop('disabled', true);
	        			  				}
	        			  				else
	        			  				{
	        			  					$("#editgeographicallocationcity").prop('disabled', true);
	        			  				}
	        							if(response.candidatePostcode && response.candidatePostcode!=null)
	        							{
	        								$("[name=editcandidatePostCode]").val(response.candidatePostcode);
	                						
	        							}
	        							
	        						
	        							 if(response.classz!=null)
        								 {
        									 $('#editclassId').selectpicker('destroy');
        									 $("#editclassId").val(response.classz.classId);
        									 $('#editclassId').selectpicker('show');
        									 $("#editclassId").prop('disabled', true);	
                      					 }
        								 if(response.admissionConfig!=null)
        								 {
        									 $('#editadmissionCodeFormat').selectpicker('destroy');
        									 $("#editadmissionCodeFormat").val(response.admissionConfig.admissionConfigId);
        									 $('#editadmissionCodeFormat').selectpicker('show');
        									 $("#editadmissionCodeFormat").prop('disabled', true);	
                      					 }
	        							 $.each(response.admissionAcademicsDetails, function(key,value) 
	        							 {
	        								 if(value.educationLevel.educationLevelId!=null)
	        								 {
	        									 $('#editeducationLevelId').selectpicker('destroy');
	        										$("[name=editeducationLevelId]").find('option[value='+value.educationLevel.educationLevelId+']').attr('selected','selected');
	        										 $('#editeducationLevelId').selectpicker('show');
	        										 $("#editeducationLevelId").prop('disabled', true);	
	        								 }
	        								 if(value.degreeName!=null)
	        								 {
	        										$("[name=editnameofDegree]").val(value.degreeName);
	        		                				
	        								 }
	        								 if(value.boardOrUniversity!=null)
	        								 {
	        									    $("[name=editboardAndUniversity]").val(value.boardOrUniversity);
	        								 }
	        								 if(value.institutionName!=null)
	        								 {
	        									 $("[name=editinstitutionName]").val(value.institutionName); 
	        								 }
	        								 if(value.institutionCountry && value.institutionCountry!=null)
	             							{
	        									 $('#editinstitutionCountryId').selectpicker('destroy');
	             								$("[name=editinstitutionCountryId]").find('option[value='+value.institutionCountry+']').attr('selected','selected');
	             								 $('#editinstitutionCountryId').selectpicker('show');
	             							}
	             							if(value.institutionState && value.institutionState!=null)
	             							{
	             								 $('#editinstitutionStateId').selectpicker('destroy');
	             								$("[name=editinstitutionStateId]").val(value.institutionState);
	             								 $('#editinstitutionStateId').selectpicker('show');
	             								$("#editinstitutionStateId").prop('disabled', true);
	             			  				 }
	             			  				else
	             			  				{
	             			  					$("#editinstitutionStateId").prop('disabled', true);	
	             			  				}
	             							if(value.institutionCity && value.institutionCity!=null)
	             							{
	             								 $('#editinstitutionCityId').selectpicker('destroy');
	             								$("[name=editinstitutionCityId]").val(value.institutionCity);
	             								 $('#editinstitutionCityId').selectpicker('show');
	             								$("#editinstitutionCityId").prop('disabled', true);
	             			  				}
	             			  				else
	             			  				{
	             			  					$("#editinstitutionCityId").prop('disabled', true);
	             			  				}
	        								 if(value.startedDate!=null)
	        								 {
	        									/* $("[name=editstartDate]").val($.datepicker.formatDate("dd/mm/yy", new Date(value.startedDate)));*/
	        									 $("#editstartDate").datepicker('update',new Date(value.startedDate));
	        								 }
	        								 if(value.completedDate!=null)
	        								 {
	        									/* $("[name=editendDate]").val($.datepicker.formatDate("dd/mm/yy", new Date(value.completedDate)));*/
	        									 $("#editendDate").datepicker('update',new Date(value.completedDate));
	        								 }
	        								 if(value.yearOfPassing!=null)
	        								 {
	        									 $("[name=edityearOfPassing]").val(value.yearOfPassing);
	        								 }
	        								 if(value.markType!=null)
	        								 {
	        									 $('#editmarkType').selectpicker('destroy');
	        									 $("[name=editmarkType]").find('option[value='+value.markType+']').attr('selected','selected');
	        									 $('#editmarkType').selectpicker('show');
	                      					 }
	        								 if(value.marksObtained!=null)
	        								 {
	        									 $("[name=editmarksObtained]").val(value.marksObtained);
	        								 }
	        								 if(value.rollNo!=null)
	        								 {
	        									 $("[name=editregistrationNumber]").val(value.rollNo);
	        								 }
	        								 if(value.certificateNo!=null)
	        								 {
	        									 $("[name=editcertificateNumber]").val(value.certificateNo);
	        								 }
	        								
	        								 $.each(value.admissionEducationLevelSubjects, function(key1,value1) 
	        	        							 {
	        									   var id=key+1
	        					        	    	 $('#editeducationLevelSubject').append('<div class="form-group" name=editsubject'+id+'>'
	        					        	    			 +'<label for="" class="col-sm-3 control-label">'+value1.admissionEducationLevelSubjectTitle+'<span class="at-required-highlight">*</span></label>'
	        					        	             	 +'<div class="col-sm-7">' 
	        					        	             		 +'<input type="text" class="form-control" id="editsubject'+value1.admissionEducationLevelSubjectTitle+'" name="editsubject'+value1.admissionEducationLevelSubjectTitle+'" value="'+value1.subjectMarks+'" placeholder="">'
	        					        	             	 +'</div>'
	        					        	             	 +'</div>');
	        	        							 });
	        							 });
	        							  $("#editcandidateProfilePhotoImage").attr('src',ctx+response.candidatePhotoPath); 
	        							  $("#editcandidateSignatureImage").attr('src',ctx+response.scannedSignaturePath); 
	        							  $.each(response.admissionDocuments, function(key,value) 
	        	        					{
	        								  	if(key==0)
	        								  		{$("#editcandidateHSCertificateImage").attr('src',ctx+value.documentPath); }
	        									
	        								  	if(key==1)
	        								  		{$("#editcandidateSSLCCertificateImage").attr('src',ctx+value.documentPath); }
	        								  	
	        								  	if(key==2)
	        								  	{	$("#editcandidateTransferCertificateImage").attr('src',ctx+value.documentPath); }
	        								  	if(key==3)
		        								{$("#editcandidatePreviousMarkSheetCertificateImage").attr('src',ctx+value.documentPath);} 
	        	        					});
	        						});
	        				
	        			}
	        			
	              });
		
				 
				 

		
				$('#educationLevelId').change(function(event) {
					$('#educationLevelSubject').empty();
			  	   var educationLevelid = $("#educationLevelId").val();
			  	   $.get(ctx+'/admissions/educationLevelSubject/list', {
			      	educationLevelId : educationLevelid
			        }, function(jsonresponse) {
			        	if(jsonresponse){
			        		 $.each(jsonresponse, function(key,value) {
			               	      var id=key+1
			        	    	 $('#educationLevelSubject').append('<div class="form-group" name=subject'+id+'>'
			        	    			 +'<label for="" class="col-sm-3 control-label">'+value.educationLevelSubjectTitle+'<span class="at-required-highlight">*</span></label>'
			        	             	 +'<div class="col-sm-7">' 
			        	             		 +'<input type="text" class="form-control" onkeypress="return isNumber(event)" id="subject'+value.educationLevelSubjectTitle+'" name="subject'+value.educationLevelSubjectTitle+'" required="required" placeholder="">'
			        	             	 +'</div>'
			        	             	 +'</div>');
			          		 });
			            }
			        	});
			  	   
			 /* 	   if(educationLevelid=="1")
			  	   {
			  		   $(".form-control-hsc").show();
			  		   $(".form-control-sslc").hide();
			  	   }
			  	   else if(educationLevelid=="2")
			  	   {
			  		   $(".form-control-hsc").hide();
			  		   $(".form-control-sslc").show();
			  	   }
			  	   else
			  	   {
			  		   $(".form-control-hsc").hide();
			  		   $(".form-control-sslc").hide();
			  	   }*/
			  	   
			  	   });
				
				/* $('#geographicallocationstate').attr('disabled', false);
				 $('#geographicallocationcity').attr('disabled', false);*/
				
				$("#newadmissionForm").bind("change", function() {
				  
				        // Exist text in your input
				        $("#admissionSave").show();
				 
				});
				
		          $('#institutionCountryId').change(function(event) {
		        	  
	      	        var countryid = $("#institutionCountryId").val();
	      	        $.get(ctx+'/geographicallocation/state', {
	      	                country : countryid
	      	        }, function(response) {
	      	        	  var select = $('#institutionStateId');
	      	        	   select.find('option').remove();
	      	        	   var select1=$('#institutionCityId');
	    	        	   		select1.find('option').remove();
	    	        	   	  $('#institutionStateId').selectpicker('destroy');
	        	        	  $('#institutionCityId').selectpicker('destroy');
	      	            	 $.each(response, function(key,value) {
	      	            		 if(key==0){
	      	   	        	    		select.append('<option value="" disabled selected>Select State</option>');
	      	   	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
	      	   	        	    	}
	      	            		 $('<option>').val(value.name).text(value.name).appendTo(select);
	      	            	  
	      	            	 }); 
	      	            	  $('#institutionStateId').selectpicker('show');
	        	        	  $('#institutionCityId').selectpicker('show');
	      	        });
	      	       
	      	 });
	      	        
	      	        
	      	$('#institutionStateId').change(function(event) {
	      	    var stateid = $("#institutionStateId").val();

	      	    $.get(ctx+'/geographicallocation/city', {
	      	            state : stateid
	      	    }, function(response) {
	      	    	
	      	    	  var select = $('#institutionCityId');
	      	        	 select.find('option').remove();
	      	        	  $('#institutionCityId').selectpicker('destroy');
	      	        	 $.each(response, function(key,value) {
	      	        		 if(key==0){
		   	        	    		select.append('<option value="" disabled selected>Select City</option>');
		   	        	    	}
	      	        		 $('<option>').val(value.name).text(value.name).appendTo(select);
	      	        	  
	      	        	 }); 
	      	        	  $('#institutionCityId').selectpicker('show');
	      	    });
	      	   
	      	    });
	        $('#editinstitutionCountryId').change(function(event) {
	      	  
	  	        var countryid = $("#editinstitutionCountryId").val();
	  	        $.get(ctx+'/geographicallocation/state', {
	  	                country : countryid
	  	        }, function(response) {
	  	        	 $('#editinstitutionStateId').attr('disabled', false);
		    		 $('#editinstitutionCityId').attr('disabled', false);
	  	        	  var select = $('#editinstitutionStateId');
	  	        	   select.find('option').remove();
	  	        	   var select1=$('#editinstitutionCityId');
		        	   		select1.find('option').remove();
	  	            	  $('#editinstitutionStateId').selectpicker('destroy');
        	        	  $('#editinstitutionCityId').selectpicker('destroy');
	  	            	 $.each(response, function(key,value) {
	  	            		 if(key==0){
	  	   	        	    		select.append('<option value="" disabled selected>Select State</option>');
	  	   	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
	  	   	        	    	}
	  	            		 $('<option>').val(value.geographicalLocationId).text(value.name).appendTo(select);
	  	            	  
	  	            	 }); 
	  	            	  $('#editinstitutionStateId').selectpicker('show');
        	        	  $('#editinstitutionCityId').selectpicker('show');
	  	        });
	  	       
	  	 });
	  	        
	  	        
	  	$('#editinstitutionStateId').change(function(event) {
	  	    var stateid = $("#editinstitutionStateId").val();

	  	    $.get(ctx+'/geographicallocation/city', {
	  	            state : stateid
	  	    }, function(response) {
	  	    	
	  	    	  var select = $('#editinstitutionCityId');
	  	        	 select.find('option').remove();
	  	        	  $('#editinstitutionCityId').selectpicker('destroy');
	  	        	 $.each(response, function(key,value) {
	  	        		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select City</option>');
	   	        	    	}
	  	        		 $('<option>').val(value.geographicalLocationId).text(value.name).appendTo(select);
	  	        	  
	  	        	 }); 
	  	        	  $('#editinstitutionCityId').selectpicker('show');
	  	    });
	  	   
	  	    });
	    $('#editgeographicallocation').change(function(event) {
	  	  
		        var countryid = $("#editgeographicallocation").val();
		        $.get(ctx+'/geographicallocation/state', {
		                country : countryid
		        }, function(response) {
		        	 $('#editgeographicallocationstate').attr('disabled', false);
		    		 $('#editgeographicallocationcity').attr('disabled', false);
		        	  var select = $('#editgeographicallocationstate');
		        	   select.find('option').remove();
		        	   var select1=$('#editgeographicallocationcity');
	        	   		select1.find('option').remove();
		            	  $('#editgeographicallocationstate').selectpicker('destroy');
        	        	  $('#editgeographicallocationcity').selectpicker('destroy');
		            	 $.each(response, function(key,value) {
		            		 if(key==0){
		   	        	    		select.append('<option value="" disabled selected>Select State</option>');
		   	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
		   	        	    	}
		            		 $('<option>').val(value.name).text(value.name).appendTo(select);
		            	  
		            	 }); 
		            	  $('#editgeographicallocationstate').selectpicker('show');
        	        	  $('#editgeographicallocationcity').selectpicker('show');
		        });
		       
		 });
		        
		        
		$('#editgeographicallocationstate').change(function(event) {
		    var stateid = $("#editgeographicallocationstate").val();

		    $.get(ctx+'/geographicallocation/city', {
		            state : stateid
		    }, function(response) {
		    	
		    	  var select = $('#editgeographicallocationcity');
		        	 select.find('option').remove();
		        	  $('#editgeographicallocationcity').selectpicker('destroy');
		        	 $.each(response, function(key,value) {
		        		 if(key==0){
		        	    		select.append('<option value="" disabled selected>Select City</option>');
		        	    	}
		        		 $('<option>').val(value.name).text(value.name).appendTo(select);
		        	  
		        	 }); 
		        	   $('#editgeographicallocationcity').selectpicker('show');
		    });
		   
		    });
		
		  $("#candidateSSLCCertificate").on('change', function() {
	          //Get count of selected files
	          var countFiles = $(this)[0].files.length;
	          var imgPath = $(this)[0].value;
	         
	          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
	          var image_holder = $("#image-holder3");
	          
	          image_holder.empty();
	          if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
	            if (typeof(FileReader) != "undefined") {
	              //loop for each file selected for uploaded.
	              for (var i = 0; i < countFiles; i++) 
	              {
	                var reader = new FileReader();
	                reader.onload = function(e) {
	                  $("<img />", {
	                    "src": e.target.result,
	                    "class": "thumb-image"
	                  }).appendTo(image_holder);
	                }
	                image_holder.show();
	                reader.readAsDataURL($(this)[0].files[i]);
	              }
	            } else {
	          /* 	 $('#candidateSSLCCertificate').val(''); */
	           	 $('#candidateSSLCCertificate').filestyle('clear');
	         edumaatAlert({
	    			  title: "Info !",
	    			  text: "This browser does not support FileReader.",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
	            }
	          } else {
	       	 /*  $('#candidateSSLCCertificate').val(''); */
	       	 $('#candidateSSLCCertificate').filestyle('clear');
	       edumaatAlert({
  			  title: "Info !",
  			  text: "Please select only images",
  			  type: "info",
  			  confirmButtonText: "Cool"
  			});
	          }
	        });
		  $("#candidatePreviousMarkSheetCertificate").on('change', function() {
	          //Get count of selected files
	          var countFiles = $(this)[0].files.length;
	          var imgPath = $(this)[0].value;
	         
	          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
	          var image_holder = $("#image-holder6");
	          
	          image_holder.empty();
	          if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
	            if (typeof(FileReader) != "undefined") {
	              //loop for each file selected for uploaded.
	              for (var i = 0; i < countFiles; i++) 
	              {
	                var reader = new FileReader();
	                reader.onload = function(e) {
	                  $("<img />", {
	                    "src": e.target.result,
	                    "class": "thumb-image"
	                  }).appendTo(image_holder);
	                }
	                image_holder.show();
	                reader.readAsDataURL($(this)[0].files[i]);
	              }
	            } else {
	           /*	 $('#candidatePreviousMarkSheetCertificate').val('');*/
	        	 $('#candidatePreviousMarkSheetCertificate').filestyle('clear');
	        	 edumaatAlert({
	    			  title: "Info !",
	    			  text: "This browser does not support FileReader.",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
	            }
	          } else {
	       	  /* $('#candidatePreviousMarkSheetCertificate').val(''); */
	      	 $('#candidatePreviousMarkSheetCertificate').filestyle('clear');
	       edumaatAlert({
  			  title: "Info !",
  			  text: "Please select only images",
  			  type: "info",
  			  confirmButtonText: "Cool"
  			});
	          }
	        });
	
		  $("#candidateHSCertificate").on('change', function() {
	          //Get count of selected files
	          var countFiles = $(this)[0].files.length;
	          var imgPath = $(this)[0].value;
	         
	          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
	          var image_holder = $("#image-holder4");
	          
	          image_holder.empty();
	          if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
	            if (typeof(FileReader) != "undefined") {
	              //loop for each file selected for uploaded.
	              for (var i = 0; i < countFiles; i++) 
	              {
	                var reader = new FileReader();
	                reader.onload = function(e) {
	                  $("<img />", {
	                    "src": e.target.result,
	                    "class": "thumb-image"
	                  }).appendTo(image_holder);
	                }
	                image_holder.show();
	                reader.readAsDataURL($(this)[0].files[i]);
	              }
	            } else {
	           	/* $('#candidateHSCertificate').val(''); */
	        	 $('#candidateHSCertificate').filestyle('clear');
	        	 edumaatAlert({
	    			  title: "Info !",
	    			  text: "This browser does not support FileReader.",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
	            }
	          } else {
	       	/*   $('#candidateHSCertificate').val(''); */
	      	 $('#candidateHSCertificate').filestyle('clear');
	       edumaatAlert({
  			  title: "Info !",
  			  text: "Please select only images",
  			  type: "info",
  			  confirmButtonText: "Cool"
  			});
	          }
	        });
		  $("#candidateTransferCertificate").on('change', function() {
	          //Get count of selected files
	          var countFiles = $(this)[0].files.length;
	          var imgPath = $(this)[0].value;
	         
	          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
	          var image_holder = $("#image-holder5");
	          
	          image_holder.empty();
	          if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
	            if (typeof(FileReader) != "undefined") {
	              //loop for each file selected for uploaded.
	              for (var i = 0; i < countFiles; i++) 
	              {
	                var reader = new FileReader();
	                reader.onload = function(e) {
	                  $("<img />", {
	                    "src": e.target.result,
	                    "class": "thumb-image"
	                  }).appendTo(image_holder);
	                }
	                image_holder.show();
	                reader.readAsDataURL($(this)[0].files[i]);
	              }
	            } else {
	           	/* $('#candidateHSCertificate').val(''); */
	        	 $('#candidateHSCertificate').filestyle('clear');
	        	 edumaatAlert({
	    			  title: "Info !",
	    			  text: "This browser does not support FileReader.",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
	            }
	          } else {
	       	 /*  $('#candidateTransferCertificate').val(''); */
	      	 $('#candidateHSCertificate').filestyle('clear');
	       edumaatAlert({
  			  title: "Info !",
  			  text: "Please select only images",
  			  type: "info",
  			  confirmButtonText: "Cool"
  			});
	          }
	        });
		  $("#candidateProfilePicture").on('change', function() {
	          //Get count of selected files
	          var countFiles = $(this)[0].files.length;
	          var imgPath = $(this)[0].value;
	         
	          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
	          var image_holder = $("#image-holder1");
	          
	          image_holder.empty();
	          if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
	            if (typeof(FileReader) != "undefined") {
	              //loop for each file selected for uploaded.
	              for (var i = 0; i < countFiles; i++) 
	              {
	                var reader = new FileReader();
	                reader.onload = function(e) {
	                  $("<img />", {
	                    "src": e.target.result,
	                    "class": "thumb-image"
	                  }).appendTo(image_holder);
	                }
	                image_holder.show();
	                reader.readAsDataURL($(this)[0].files[i]);
	              }
	            } else {
	          /* 	 $('#candidateProfilePicture').val(''); */
	           	$('#candidateProfilePicture').filestyle('clear');
	         edumaatAlert({
	    			  title: "Info !",
	    			  text: "This browser does not support FileReader.",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
	            }
	          } else {
	        	 $('#candidateProfilePicture').filestyle('clear');
	          edumaatAlert({
	    			  title: "Info !",
	    			  text: "Please select only images",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
	          }
	        });
		  $("#candidateSignature").on('change', function() {
	          //Get count of selected files
	          var countFiles = $(this)[0].files.length;
	          var imgPath = $(this)[0].value;
	         
	          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
	          var image_holder = $("#image-holder2");
	          
	          image_holder.empty();
	          if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
	            if (typeof(FileReader) != "undefined") {
	              //loop for each file selected for uploaded.
	              for (var i = 0; i < countFiles; i++) 
	              {
	                var reader = new FileReader();
	                reader.onload = function(e) {
	                  $("<img />", {
	                    "src": e.target.result,
	                    "class": "thumb-image"
	                  }).appendTo(image_holder);
	                }
	                image_holder.show();
	                reader.readAsDataURL($(this)[0].files[i]);
	              }
	            } else {
	           	/* $('#candidateSignature').val(''); */
	           	 $('#candidateSignature').filestyle('clear');
	         edumaatAlert({
	    			  title: "Info !",
	    			  text: "This browser does not support FileReader.",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
	            }
	          } else {
	       	 /*  $('#candidateSignature').val(''); */
	       	 $('#candidateSignature').filestyle('clear');
	       edumaatAlert({
  			  title: "Info !",
  			  text: "Please select only images",
  			  type: "info",
  			  confirmButtonText: "Cool"
  			});
	          }
	        });
		  
		  $("#studentBulkUpdate").on('change', function() {
	          //Get count of selected files
	          var countFiles = $(this)[0].files.length;
	          var imgPath = $(this)[0].value;
	         
	          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
	           if (extn == "xls" || extn == "xlsx" ) {
	            if (typeof(FileReader) != "undefined")
	            {
	              
	            } else {
	            	 $('#studentBulkUpdate').filestyle('clear');
	         edumaatAlert({
	    			  title: "Info !",
	    			  text: "This browser does not support FileReader.",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
	            }
	          } else {
	       	 /*  $('#candidateSignature').val(''); */
	       	 $('#studentBulkUpdate').filestyle('clear');
	       edumaatAlert({
  			  title: "Info !",
  			  text: "Please select only excel files",
  			  type: "info",
  			  confirmButtonText: "Cool"
  			});
	          }
	        });
	});
	//** Numbers Only**/

	function isNumber(evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	   	$("#templateitemform").before(
		        '<div class="alert alert-warning alert-dismissable">'+
		            '<button type="button" class="close" ' + 
		                    'data-dismiss="alert" aria-hidden="true">' + 
		                '&times;' + 
		            '</button>' + 
		            'Numbers Only Allowed.' + 
		            '</div>'+
		         '</div>');

	window.setTimeout(function() {
	   $(".alert").fadeTo(500, 0).slideUp(500, function(){
	       $(this).remove(); 
	   });
	},800);
	        return false;
	    }
	    return true;
	}

	/** currency Only**/
	function isFloatNumber(item,evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode==46)
	    {
	        var regex = new RegExp(/\./g)
	        var count = $(item).val().match(regex).length;
	        if (count > 1)
	        {
	            return false;
	        }
	    }
	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	        return false;
	    }
	    return true;
	}

	///email validation

	$(document).ready(function(){
		$('.form-control-email').keyup(function() {
		    $('span.error-keyup-7').remove();
		    var inputVal = $(this).val();
		    var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		    if(!emailReg.test(inputVal)) {
		        $(this).after('<span class="error error-keyup-7">Invalid Email Format</span>');
		    }
		});
		    });






