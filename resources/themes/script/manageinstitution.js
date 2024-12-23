 $(document).ready(function() {
		 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 var j=0;	
	 $("#staffgeographicallocationstate").prop('disabled', false);
	 $("#staffgeographicallocationcity").prop('disabled', false);

        	 $("#institutionSave").click(function(event)
        	 {
           		if( $('#newInstitutionForm').valid()){
           		var password = $("#adminPassword").val();
   			     var confirmPassword = $("#adminConfirmPassword").val();
   			   if (password != confirmPassword)
   				 {
   					// alert("Student Passwords do not match!");
   					 edumaatAlert({
   		    			  title: "Info !",
   		    			  text: "User Passwords do not match!",
   		    			  type: "info",
   		    			  confirmButtonText: "Cool"
   		    			});
   				 }
   			   else
   				 {
   				   
   				var staffExperiencearr=[];
				
   			 for(m=1;m<=j;m++)
   				{
   					var staffExperienceId="experience"+m;
   					if(document.getElementById(staffExperienceId))
   					{
   					var container = document.getElementById(staffExperienceId);
   				    var collection = container.getElementsByTagName('input');
   				    var names = "";
   				   for (var aj = 0; aj < collection.length; ++aj) 
   				    {
   				    	
   				    	if (collection[aj].getAttribute('id') != null)
   				    		{
   				    		  if($("#"+collection[aj].getAttribute('id')).val()!="")
   	             			  {
   				    			  	names += collection[aj].getAttribute('id') + ",";
   	             			  }
   				    		}
   				    }
   				 
   				    
   				    names = names.substring(0, names.length - 1);
   				   // alert(names);
   				    staffExperiencearr.push(names+"/"); 
   					}
   				}
   		//	alert(staffExperiencearr);
   			 $("#staffExperienceIdArray").val(staffExperiencearr);
   			 
        		  $('#institutionSaveConfirmation').modal('show');
        			$('#institutionsSaveConfirm').click(function(){
        				$('.loader').show();
  	        			$('#newInstitutionForm').submit();		
  	                
  	               });
   				 }
    			        }
    			 });	   
        			
        	 
        	 
        	 $("#updateInstitution").click(function(event){
        		 $("#updateInstitutionId").val( $(this).attr('data-id'));
        		// $("#updateUserId").val( $("#editAdmin").val());
         		
        		 if($("#updateInstitutionDetails").valid())
        			{
        			 
        			 var password = $("#editAdminPassword").val();
       			     var confirmPassword = $("#editAdminConfirmPassword").val();
       			   if (password != confirmPassword)
       				 {
       					 edumaatAlert({
       		    			  title: "Info !",
       		    			  text: "User Passwords do not match!",
       		    			  type: "info",
       		    			  confirmButtonText: "Cool"
       		    			});
       				 }
       			   else
       				 {
       				   
       				var staffExperiencearr=[];
    			//	alert(j);
          			 for(m=1;m<=j;m++)
          				{
          					var staffExperienceId="editexperience"+m;
          					if(document.getElementById(staffExperienceId))
          					{
          					var container = document.getElementById(staffExperienceId);
          				    var collection = container.getElementsByTagName('input');
          				    var names = "";
          				   for (var aj = 0; aj < collection.length; ++aj) 
          				    {
          				    	
          				    	if (collection[aj].getAttribute('id') != null)
          				    		{
          				    		  if($("#"+collection[aj].getAttribute('id')).val()!="")
          	             			  {
          				    			  	names += collection[aj].getAttribute('id') + ",";
          	             			  }
          				    		}
          				    }
          				 
          				    
          				    names = names.substring(0, names.length - 1);
          				   // alert(names);
          				    staffExperiencearr.push(names+"/"); 
          					}
          				}
          		//	alert(staffExperiencearr);
          			 $("#editStaffExperienceIdArray").val(staffExperiencearr);
          			 
        			 $('#saveConfirmation').modal('show');
        			 $('#saveConfirm').click(function(){
        				 $('#geographicallocationstate1').attr('disabled', false);
                		 $('#geographicallocationcity1').attr('disabled', false);
                		 $('#staffgeographicallocationstate').attr('disabled', false);
                 		  $('#staffgeographicallocationcity').attr('disabled', false);
                 			$('.loader').show();
       					$("#updateInstitutionDetails").submit();
        			 });
        			 }
       			}
      	 });
        	 
        
        	 $('#institutionlist').on( 'click', 'tr td a#delete', function () {
      		   $('#deleteInstitutionId').val($(this).attr('data-id'));
      		   $("#confirm-delete").on('show.bs.modal', function (e) {
      			 $('#confirmInstitutionDelete').click(function(){
      				$("#deleteInstitutionForm").submit();
      			 });
      			});
      		 
      		 });
        	 
          	 $('#institutionlist').on( 'click', 'tr td a#edit', function () {
          		$('.loader').show();
        		   var institutionid = $(this).attr('data-id');
        		   $.get(ctx+'/institution/manageinstitution/retrieveinstitution', {
        			   institutionId : institutionid
      	        }, function(response) {
      	      	$('.loader').hide();
      	        	if(response.institutionId!=null)
      	        	{
      	        		$('#updateInstitution').attr('data-id',response.institutionId);
      	        	}
      	        	
      	        	if(response.institutionName!=null)
      	        	{
      	        		$("[name=editInstitutionName]").val(response.institutionName);
      	        	}
      	        	if(response.institutionCode!=null)
      	        	{
      	        		$("[name=editInstitutionCode]").val(response.institutionCode);
      	        	}
      	        	if(response.institutionDescription!=null)
      	        	{
      	        		$("[name=editInstitutionDescription]").val(response.institutionDescription);
      	        	}
      	        	if(response.institutionEmail!=null)
      	        	{
      	        		$("[name=editInstitutionEmail]").val(response.institutionEmail);
      	        	}
      	        	if(response.institutionContact!=null)
      	        	{
      	        		$("[name=editInstitutionContact]").val(response.institutionContact);
      	        	}
      	        	if(response.institutionAddressline1!=null)
      	        	{
      	        		$("[name=editInstitutionAddressLine1]").val(response.institutionAddressline1);
      	        	}
      	        	if(response.institutionAddressline2!=null)
      	        	{
      	        		$("[name=editInstitutionAddressLine2]").val(response.institutionAddressline2);
      	        	}
      	        	if(response.institutionAdminName!=null)
      	        	{
      	        		$("[name=editInstitutionAdminName]").val(response.institutionAdminName);
      	        	}
      	        	if(response.institutionAccountName!=null)
      	        	{
      	        		$("[name=editInstitutionAccountName]").val(response.institutionAccountName);
          	        	
      	        	}
      	        	if(response.institutionAccountNumber!=null)
      	        	{
      	        		$("[name=editInstitutionAccountNo]").val(response.institutionAccountNumber);
      	        	}
      	        	if(response.institutionPostcode!=null)
      	        	{
      	        		$("[name=editInstitutionPostCode]").val(response.institutionPostcode);    
      	        	}
      	        	if(response.currencyCode!=null)
      	        	{
      	        	  $('#editCurrencyCode').selectpicker('destroy');
      	        		$("[name=editCurrencyCode]").val(response.currencyCode);	
      	        	  $('#editCurrencyCode').selectpicker('show');
      	        	}
      	        	if(response.institutionCountry!=null)
      	        	{
      	        	  $('#geographicallocation1').selectpicker('destroy');
      	        		$("[name=editInstitutionCountry]").val(response.institutionCountry);
      	        	  $('#geographicallocation1').selectpicker('show');
      	        	}
      	        	if(response.institutionState!=null)
      	        	{
      	        	  $('#geographicallocationstate1').selectpicker('destroy');
      	        		 $("[name=editInstitutionState]").val(response.institutionState);
      	        		 $('#geographicallocationstate1').selectpicker('show');
      	        		 $('#geographicallocationstate1').attr('disabled', true);
      	        		 
      	         	  
	  				 }
	  				else
	  				{
	  				 	$('#geographicallocationstate1').attr('disabled', true);
	  				}
      	        	if(response.institutionCity!=null)
      	        	{
      	        	  $('#geographicallocationcity1').selectpicker('destroy');
      	        		$("[name=editInstitutionCity]").val(response.institutionCity);
      	        		 $('#geographicallocationcity1').selectpicker('show');
      	        		$('#geographicallocationcity1').attr('disabled', true);
      	        	 
	  				 }
	  				else
	  				{
	  					$('#geographicallocationcity1').attr('disabled', true);
	  				}
      	        	if(response.institutionStatus!=null)
      	        	{
      	        	  $('#editInstitutionStatus').selectpicker('destroy');
      	        		$("[name=editInstitutionStatus]").val(response.institutionStatus);
      	        	  $('#editInstitutionStatus').selectpicker('show');
      	        	}
      	        	if(response.collectReceiptsInOrder!=null)
      	        	{
      	        		var collectReceiptsInOrder="0";
      	        		if(response.collectReceiptsInOrder)
      	        			{
      	        			collectReceiptsInOrder="1";
      	        			}
      	        		else
      	        		{
      	        			collectReceiptsInOrder="0";
      	        		}
      	        		 $('#editCollectReceiptsInOrder').selectpicker('destroy');
        	        		$("[name=editCollectReceiptsInOrder]").val(collectReceiptsInOrder);
        	        	  $('#editCollectReceiptsInOrder').selectpicker('show');
      	        	}
      	        	if(response.institutionLogo!=null)
      	        	{
      	        		$("#institutionImage").attr('src',ctx+response.institutionLogo); 
      	        	}
      	        	
      	        	if(response.authorizedSignature!=null)
      	        	{
      	        		$("#institutionAuthorizedSignatureImage").attr('src',ctx+response.authorizedSignature); 
      	        	}
      	        	if(response.users)
      	        	{
      	        		
      	        		var select = $('#editAdmin');
      	        		select.find('option').remove();
      	        		select.append('<option value="" disabled selected>Select Admin</option>');
      	        		$('#editAdmin').selectpicker('destroy'); 	
      	        		$.each(response.users, function(index,value)
      	        				{
      	        			select.append('<option value="'+value.email+'">'+value.name+'['+value.email+']'+'</option>');
      	        				});
      	        		$('#editAdmin').selectpicker('show');
      	        	}
      	        });
        		 });
        	 
        	 
          	$('#editAdmin').change(function(event) {
           	    var email = $("#editAdmin").val();
           	  
           		$('.loader').show();
           	  $.get(ctx+'/staff/staffdetailsbyemail', {
           		email : email
	        }, function(response) {
	        	
	        	$('.loader').hide();
	        	if($.trim(response)&&response!=null)
	        	{
	        		$("#currentstaff").show();
	        		if(response.firstName!=null)
					   {
						   $("[name=editStaffFirstName]").val(response.firstName);
		     	        	   
					   }
					   if(response.lastName!=null)
					   {
						   $("[name=editStaffLastName]").val(response.lastName);
		     	        	   
					   }
					   if(response.parentOrGuardianFirstName!=null)
					   {
						   $("[name=editStaffParentOrGuardianFirstName]").val(response.parentOrGuardianFirstName);
		     	        	   
					   }
					   if(response.parentOrGuardianLastName!=null)
					   {
						   $("[name=editStaffParentOrGuardianLastName]").val(response.parentOrGuardianLastName);
		     	        	   
					   }
					   if(response.gender!=null)
					   {
						   $('#editStaffGender').selectpicker('destroy');
						   $("[name=editStaffGender]").val(response.gender);
						   $('#editStaffGender').selectpicker('show');
		     	        	   
					   }
					   if(response.dateOfBirth!=null)
					   {
						 /*  $("[name=editStaffDOB]").val($.datepicker.formatDate('mm/dd/yy',new Date(response.dateOfBirth)));*/
							$("#editStaffDOB").datepicker('update',new Date(response.dateOfBirth));
					   }
					   if(response.email!=null)
					   {
						   $("[name=editStaffEmail]").val(response.email);
		     	        	   
					   }
					   if(response.contact!=null)
					   {
						   $("[name=editStaffContact]").val(response.contact);
		     	        	   
					   }
					   if(response.category!=null)
					   {
						   $('#editCategoryId').selectpicker('destroy');
						   $("[name=editCategoryId]").val(response.category.categoryId);
						   $('#editCategoryId').selectpicker('show');
		     	        	   
					   }
					   if(response.user.profilePicturePath!=null)
					   {
						   	$("#editStaffImage").show();
	        				$("#editStaffImage").attr('src',ctx+response.user.profilePicturePath);
		     	        	   
					   }
					   if(response.staffAddressLine1!=null)
					   {
						   $("[name=editStaffAddressLine1]").val(response.staffAddressLine1);
		     	        	   
					   }
					   if(response.staffAddressLine2!=null)
					   {
						   $("[name=editStaffAddressLine2]").val(response.staffAddressLine2);
		     	        	   
					   }
					   if(response.country!=null)
					   {
						   $('#staffgeographicallocation').selectpicker('destroy');
						   $("[name=editStaffCountry]").val(response.country);
						   $('#staffgeographicallocation').selectpicker('show');
		     	        	   
					   }
					   if(response.state!=null)
					   {
						   $('#staffgeographicallocationstate').selectpicker('destroy');
						   $("[name=editStaffState]").val(response.state);
						   $('#staffgeographicallocationstate').selectpicker('show');
						   $("#staffgeographicallocationstate").prop('disabled', true);
						 
	  				   }
					   else
					   {
						  $("#staffgeographicallocationstate").prop('disabled', true);	
					   }
					   if(response.city!=null)
					   {
						   $('#staffgeographicallocationcity').selectpicker('destroy');
						   $("[name=editStaffCity]").val(response.city);
						   $('#staffgeographicallocationcity').selectpicker('show'); 
						   $("#staffgeographicallocationcity").prop('disabled', true);
		  				}
		  				else
		  				{
		  					$("#staffgeographicallocationcity").prop('disabled', true);
		  				}
					   
					   if(response.postCode!=null)
					   {
						   $("[name=editStaffPostCode]").val(response.postCode);
		     	        	   
					   }
					   if(response.staffBankDetail.bankName!=null)
					   {
						   $("[name=editStaffBankName]").val(response.staffBankDetail.bankName);
		     	        	   
					   }
					   if(response.staffBankDetail.bankAccountNo!=null)
					   {
						   $("[name=editStaffBankAccountNo]").val(response.staffBankDetail.bankAccountNo);
		     	        	   
					   }
					   if(response.staffBankDetail.bankIFSCCode!=null)
					   {
						   $("[name=editStaffBankIFSC]").val(response.staffBankDetail.bankIFSCCode);
		     	        	   
					   }
					  
					   if(response.staffCode!=null)
					   {
						   $("[name=editStaffCode]").val(response.staffCode);
		     	        	   
					   }
					  
					  
					  
					   if(response.accessNo!=null)
					   {
						   $("[name=editStaffAccessId]").val(response.accessNo);
		     	        	   
					   }
					   if(response.joinedDate!=null)
					   {
						  /* $("[name=editStaffJoinedDate]").val($.datepicker.formatDate('mm/dd/yy',new Date(response.joinedDate)));*/
						   $("#editStaffJoinedDate").datepicker('update',new Date(response.joinedDate));
					   }
					   if(response.staffPANNumber!=null)
					   {
						   $("[name=editStaffPANNo]").val(response.staffPANNumber);
		     	        	   
					   }
					   if(response.staffPFNumber!=null)
					   {
						   $("[name=editStaffPFAccountNo]").val(response.staffPFNumber);
		     	        	   
					   }
					   if(response.bloodGroup!=null)
					   {
						   $('#editStaffBloodGroupId').selectpicker('destroy');
						   $("[name=editStaffBloodGroupId]").val(response.bloodGroup.bloodGroupId);
						   $('#editStaffBloodGroupId').selectpicker('show');
		     	        	   
					   }
					   if(response.status!=null)
					   {
						   $('#editStaffStatus').selectpicker('destroy');
						   $("[name=editStaffStatus]").val(response.status);
						   $('#editStaffStatus').selectpicker('show');
		     	        	   
					   }
					   if(response.user.password!=null)
		        		{
		        			$("[name=editAdminPassword]").val(response.user.password);
		        			$("[name=editAdminConfirmPassword]").val(response.user.password);
	  	        		
		        		}
		        		if($.trim(response.staffExperienceDetails)&&response.staffExperienceDetails!=null)
		  			    {
					   $.each(response.staffExperienceDetails, function(key,value) 
								{
								   j=key+1;
							   $("#editexperiencedetails").append('<div id="editexperience'+j+'" name="editexperience'+j+'" class="editdeleteexp">'
										+' <button style="float:right" type="button" class="btn btn-danger editbtnDel"><i class="fa fa-times-circle" aria-hidden="true"></i></button>'
										+' <div class="form-group"><label for="" class="col-sm-3 control-label">Organization Name<span class="at-required-highlight">*</span></label><div class="col-sm-7"><input type="text" name="editOrganizationName'+j+'-'+value.staffExperienceDetailId+'" class="form-control" id="editOrganizationName'+j+'-'+value.staffExperienceDetailId+'" placeholder="" maxlength="225" required="required"></div></div>'
										+'<div class="form-group"><label for="" class="col-sm-3 control-label">Experience<span class="at-required-highlight">*</span></label> <div class="col-sm-7"> <input type="text" name="editWorkExp'+j+'" class="form-control" id="editWorkExp'+j+'" placeholder="" onkeypress="return isFloatNumber(this,event)" required="required"></div></div>'
								        +'<div class="form-group"><label for="" class="col-sm-3 control-label">Experience Start Date<span class="at-required-highlight">*</span></label> <div class="col-sm-7"> <input type="text" name="editStaffESD'+j+'" class="form-control form-control-datepicker" id="editStaffESD'+j+'" placeholder="" required="required"></div></div>'
								        +' <div class="form-group"><label for="" class="col-sm-3 control-label">Experience End Date<span class="at-required-highlight">*</span></label> <div class="col-sm-7"> <input type="text" name="editStaffEED'+j+'" class="form-control form-control-datepicker" id="editStaffEED'+j+'" placeholder="" required="required"></div></div>'
								        +'  <div class="form-group"><label for="" class="col-sm-3 control-label">Designation<span class="at-required-highlight">*</span></label> <div class="col-sm-7"><input type="text" name="editWorkDesignation'+j+'" class="form-control" id="editWorkDesignation'+j+'" placeholder="" maxlength="200" required="required"></div></div>'
								        +'<br>'
								        +'</div>'
								).find('.form-control-datepicker').removeClass('hasDatepicker').datepicker({
				                	  format: "dd/mm/yyyy",
				                  	autoclose: true,
				                  	todayHighlight: true
				                  });
							   
							   if(value.workedOrganisation!=null)
							   {
								  $("#editOrganizationName"+j+"-"+value.staffExperienceDetailId).val(value.workedOrganisation); 
							   }
							   if(value.inPreviousExperience!=null)
							   {
								  $("#editWorkExp"+j).val(value.inPreviousExperience); 
							   }
							   if(value.startDate!=null)
							   {
								  /*$("#editStaffESD"+j).val($.datepicker.formatDate('mm/dd/yy',new Date(value.startDate))); */
								  $("#editStaffESD"+j).datepicker('update',new Date(value.startDate));
							   }
							   if(value.endDate!=null)
							   {
								 /* $("#editStaffEED"+j).val($.datepicker.formatDate('mm/dd/yy',new Date(value.endDate))); */
								  $("#editStaffEED"+j).datepicker('update',new Date(value.endDate));
							   }
							   if(value.staffPreviousDesignation!=null)
							   {
								  $("#editWorkDesignation"+j).val(value.staffPreviousDesignation); 
							   }
							   
							   });
					   	} 
					   else{
						   $("#editexperiencedetails").empty(); 
							   $("#editexperiencedetails").append('<div class="alert alert-info" role="alert" style="display: block">'+
								'<strong>Info!</strong>&nbsp;You want to add your experience details, Please click "Add More Experience Details" button.'+
								'</div>');    
						   
						   }
			
					   if(response.staffId!=null)
					   {
						   $('#updateStaffId').val(response.staffId);
				       }
					   if(response.user.userId!=null)
					   {
						   $('#updateUserId').val(response.user.userId);
				       }
					   if(response.staffBankDetail.staffBankDetailId!=null)
					   {
						   $('#updateStaffBankDetailId').val(response.staffBankDetail.staffBankDetailId);
				       }
		        		
					
	
	        	}
	        	
	        	
	        });
/*           	 $.ajax({
				   url:ctx+'/staff/staffdetails',
				   type:'GET',
				   data:email,
				   success: function(response){

					   alert(response);
	              		if(response.name!=null)
		        		{
		        			$("[name=editAdminName]").val(response.name);
	  	        			
		        		}
		        		if(response.email!=null)
		        		{
		        			$("[name=editAdminEmail]").val(response.email);
	  	        		      	        			
		        		}
		        		if(response.password!=null)
		        		{
		        			$("[name=editAdminPassword]").val(response.password);
		        			$("[name=editAdminConfirmPassword]").val(response.password);
	  	        		
		        		}

		        		if(response.profilePicturePath!=null)
		        			{
		        				$("#adminImage").show();
		        				$("#adminImage").attr('src',ctx+response.profilePicturePath);
		        			}

				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/institution/manageinstitution";
			       }
				});*/
        	   
          	}); 
        

           	
            $('#geographicallocation').change(function(event) {
           	    var country = $("#geographicallocation").val();
           	  $('#geographicallocationstate').attr('disabled', false);
        	  $('#geographicallocationcity').attr('disabled', false);
           	    $.get(ctx+'/geographicallocation/state', {
        	                country : country
        	        }, function(response) {
        	        	  var select = $('#geographicallocationstate');
        	        	   select.find('option').remove();
        	        	   var select1=$('#geographicallocationcity');
        	        	   		select1.find('option').remove();
        	        	   	  $('#geographicallocationstate').selectpicker('destroy');
            	        	  $('#geographicallocationcity').selectpicker('destroy');
        	            	 $.each(response, function(key,value) {
        	            		 if(key==0){
        	   	        	    		select.append('<option value="" disabled selected>Select State</option>');
        	   	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
        	   	        	    	}
        	            		 $('#geographicallocationstate').append('<option id="'+value.name+'" value="'+value.name+'">'+value.name+'</option>');
        	            	}); 
        	            	  $('#geographicallocationstate').selectpicker('show');
            	        	  $('#geographicallocationcity').selectpicker('show'); 
        	        });
        	       
        	 });
        	        
        	        
        	$('#geographicallocationstate').change(function(event) {
        	    var state = $("#geographicallocationstate").val();

        	    $.get(ctx+'/geographicallocation/city', {
        	            state : state
        	    }, function(response) {
        	    	
        	    	  var select = $('#geographicallocationcity');
        	        	 select.find('option').remove();
        	        	 $('#geographicallocationcity').selectpicker('destroy');
        	        	 $.each(response, function(key,value) {
        	        		 if(key==0){
        	        	    		select.append('<option value="" disabled selected>Select City</option>');
        	        	    	}
        	        		 $('#geographicallocationcity').append('<option id="'+value.name+'" value="'+value.name+'">'+value.name+'</option>');
        	        	  
        	        	 }); 
        	        	 $('#geographicallocationcity').selectpicker('show');
        	    });
        	   
        	    });	

         	
            $('#geographicallocation1').change(function(event) {
           	    var country = $("#geographicallocation1").val();
           	  $('#geographicallocationstate1').attr('disabled', false);
        	  $('#geographicallocationcity1').attr('disabled', false);
           	    $.get(ctx+'/geographicallocation/state', {
        	                country : country
        	        }, function(response) {
        	        	  var select = $('#geographicallocationstate1');
        	        	   select.find('option').remove();
        	        	   var select1=$('#geographicallocationcity1');
        	        	   		select1.find('option').remove();
        	        	  	  $('#geographicallocationstate1').selectpicker('destroy');
            	        	  $('#geographicallocationcity1').selectpicker('destroy');
        	            	 $.each(response, function(key,value) {
        	            		 if(key==0){
        	   	        	    		select.append('<option value="" disabled selected>Select State</option>');
        	   	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
        	   	        	    	}
        	            		 $('#geographicallocationstate1').append('<option id="'+value.name+'" value="'+value.name+'">'+value.name+'</option>');
        	            	}); 
        	           	  $('#geographicallocationstate1').selectpicker('show');
        	        	  $('#geographicallocationcity1').selectpicker('show');
        	        });
        	       
        	 });
        	        
        	        
        	$('#geographicallocationstate1').change(function(event) {
        	    var state = $("#geographicallocationstate1").val();

        	    $.get(ctx+'/geographicallocation/city', {
        	            state : state
        	    }, function(response) {
        	    	
        	    	  var select = $('#geographicallocationcity1');
        	        	 select.find('option').remove();
        	        	  $('#geographicallocationcity1').selectpicker('destroy');
        	        	 $.each(response, function(key,value) {
        	        		 if(key==0){
        	        	    		select.append('<option value="" disabled selected>Select City</option>');
        	        	    	}
        	        		 $('#geographicallocationcity1').append('<option id="'+value.name+'" value="'+value.name+'">'+value.name+'</option>');
        	        	  
        	        	 }); 
        	        	 $('#geographicallocationcity1').selectpicker('show');
        	    });
        	   
        	    });	
        	
        	 $('#geographicallocationstaff').change(function(event) {
     		    var country = $("#geographicallocationstaff").val();
      	        $.get(ctx+'/geographicallocation/state', {
      	                country : country
      	        }, function(response) {
      	        	  var select = $('#geographicallocationstatestaff');
      	        	   select.find('option').remove();
      	        	   var select1=$('#geographicallocationcitystaff');
     	        	   		select1.find('option').remove();
     	        	   	  $('#geographicallocationstatestaff').selectpicker('destroy');
        	        	  $('#geographicallocationcitystaff').selectpicker('destroy');
     	        	   		$.each(response, function(key,value) {
      	            		 if(key==0){
      	   	        	    		select.append('<option value="" disabled selected>Select State</option>');
      	   	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
      	   	        	    	}
      	            		 $('<option>').val(value.name).text(value.name).appendTo(select);
      	            	
      	            	 }); 
     	        	 	  $('#geographicallocationstatestaff').selectpicker('show');
        	        	  $('#geographicallocationcitystaff').selectpicker('show');
      	        });
      	       
      	 });
      	        
      	        
      	$('#geographicallocationstatestaff').change(function(event) {
      		
      	    var state = $("#geographicallocationstatestaff").val();
              $.get(ctx+'/geographicallocation/city', {
      	            state : state
      	    }, function(response) {
      	    	 var select = $('#geographicallocationcitystaff');
      	        	 select.find('option').remove();
      	     	  $('#geographicallocationcitystaff').selectpicker('destroy');
      	        	 $.each(response, function(key,value) {
      	        		 if(key==0){
      	        	    		select.append('<option value="" disabled selected>Select City</option>');
      	        	    	}
      	        		 $('<option>').val(value.name).text(value.name).appendTo(select);
      	        	  
      	        	 }); 
      	     	   $('#geographicallocationcitystaff').selectpicker('show');
      	    });
      	   
      	    });
      	
      	 $('#staffgeographicallocation').change(function(event) {
      		 $('#staffgeographicallocationstate').attr('disabled', false);
      		  $('#staffgeographicallocationcity').attr('disabled', false);
  		    var country = $("#staffgeographicallocation").val();
   	        $.get(ctx+'/geographicallocation/state', {
   	                country : country
   	        }, function(response) {
   	        	  var select = $('#staffgeographicallocationstate');
   	        	   select.find('option').remove();
   	        	   var select1=$('#staffgeographicallocationcity');
  	        	   		select1.find('option').remove();
  	        		  $('#staffgeographicallocationstate').selectpicker('destroy');
    	        	  $('#staffgeographicallocationcity').selectpicker('destroy');
  	        	   		$.each(response, function(key,value) {
   	            		 if(key==0){
   	   	        	    		select.append('<option value="" disabled selected>Select State</option>');
   	   	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
   	   	        	    	}
   	            		 $('<option>').val(value.name).text(value.name).appendTo(select);
   	            	
   	            	 }); 
  	        	   	  $('#staffgeographicallocationstate').selectpicker('show');
    	        	  $('#staffgeographicallocationcity').selectpicker('show');
   	        });
   	       
   	 });
   	        
   	        
   	$('#staffgeographicallocationstate').change(function(event) {
   		
   	    var state = $("#staffgeographicallocationstate").val();
           $.get(ctx+'/geographicallocation/city', {
   	            state : state
   	    }, function(response) {
   	    	 var select = $('#staffgeographicallocationcity');
   	        	 select.find('option').remove();
   	          $('#staffgeographicallocationcity').selectpicker('destroy');
   	        	 $.each(response, function(key,value) {
   	        		 if(key==0){
   	        	    		select.append('<option value="" disabled selected>Select City</option>');
   	        	    	}
   	        		 $('<option>').val(value.name).text(value.name).appendTo(select);
   	        	  
   	        	 }); 
   	          $('#staffgeographicallocationcity').selectpicker('show');
   	    });
   	   
   	    });
 
 $('.btnAdd').click(function()
		 {
 	j=j+1;
 		$(".alert-info").hide();
 		 $("#experiencedetails").append('<div id="experience'+j+'" name="experience'+j+'" class="deleteexp">'
 					+' <button style="float:right" type="button" class="btn btn-danger btnDel"><i class="fa fa-times-circle" aria-hidden="true"></i></button>'
 					+' <div class="form-group"><label for="" class="col-sm-3 control-label">Organization Name<span class="at-required-highlight">*</span></label><div class="col-sm-7"><input type="text" name="organizationName'+j+'" class="form-control" id="organizationName'+j+'" placeholder="" maxlength="225" required="required"></div></div>'
 					+'<div class="form-group"><label for="" class="col-sm-3 control-label">Experience<span class="at-required-highlight">*</span></label> <div class="col-sm-7"> <input type="text" name="workExp'+j+'" class="form-control" id="workExp'+j+'" placeholder="" onkeypress="return isFloatNumber(this,event)" required="required"></div></div>'
 			        +'<div class="form-group"><label for="" class="col-sm-3 control-label">Experience Start Date<span class="at-required-highlight">*</span></label> <div class="col-sm-7"> <input type="text" name="staffESD'+j+'" class="form-control form-control-datepicker" id="staffESD'+j+'" placeholder="" required="required"></div></div>'
 			        +' <div class="form-group"><label for="" class="col-sm-3 control-label">Experience End Date<span class="at-required-highlight">*</span></label> <div class="col-sm-7"> <input type="text" name="staffEED'+j+'" class="form-control form-control-datepicker" id="staffEED'+j+'" placeholder="" required="required"></div></div>'
 			        +'  <div class="form-group"><label for="" class="col-sm-3 control-label">Designation<span class="at-required-highlight">*</span></label> <div class="col-sm-7"><input type="text" name="workDesignation'+j+'" class="form-control" id="workDesignation'+j+'" placeholder="" maxlength="200" required="required"></div></div>'
 			        +'<br>'
 			        +'</div>'
 			).find('.form-control-datepicker').removeClass('hasDatepicker').datepicker({
          	  format: "dd/mm/yyyy",
            	autoclose: true,
            	todayHighlight: true
            });
 		   
 });
 $('body').on('click', '.btnDel', function () {
 	  $(this).parent('.deleteexp').remove();
 		 
 		if($('.deleteexp').length==0){
   		
 			   $("#experiencedetails").append('<div class="alert alert-info" role="alert" style="display: block">'+
 						'<strong>Info!</strong>&nbsp;You want to add your experience details, Please click "Add More Experience Details" button.'+
 						'</div>');  

   	}
   	else{
   		
   		$(".alert-info").hide();    		
   		
   	}
 	});
 
 $('.editbtnAdd').click(function() {
		j=j+1;
			$(".alert-info").hide();
			 $("#editexperiencedetails").append('<div id="editexperience'+j+'" name="editexperience'+j+'" class="editdeleteexp">'
						+' <button style="float:right" type="button" class="btn btn-danger editbtnDel"><i class="fa fa-times-circle" aria-hidden="true"></i></button>'
						+' <div class="form-group"><label for="" class="col-sm-3 control-label">Organization Name<span class="at-required-highlight">*</span></label><div class="col-sm-7"><input type="text" name="editOrganizationName'+j+'" class="form-control" id="editOrganizationName'+j+'" placeholder="" maxlength="225" required="required"></div></div>'
						+'<div class="form-group"><label for="" class="col-sm-3 control-label">Experience<span class="at-required-highlight">*</span></label> <div class="col-sm-7"> <input type="text" name="editWorkExp'+j+'" class="form-control" id="editWorkExp'+j+'" placeholder="" onkeypress="return isFloatNumber(this,event)" required="required"></div></div>'
				        +'<div class="form-group"><label for="" class="col-sm-3 control-label">Experience Start Date<span class="at-required-highlight">*</span></label> <div class="col-sm-7"> <input type="text" name="editStaffESD'+j+'" class="form-control form-control-datepicker" id="editStaffESD'+j+'" placeholder="" required="required"></div></div>'
				        +' <div class="form-group"><label for="" class="col-sm-3 control-label">Experience End Date<span class="at-required-highlight">*</span></label> <div class="col-sm-7"> <input type="text" name="editStaffEED'+j+'" class="form-control form-control-datepicker" id="editStaffEED'+j+'" placeholder="" required="required"></div></div>'
				        +'  <div class="form-group"><label for="" class="col-sm-3 control-label">Designation<span class="at-required-highlight">*</span></label> <div class="col-sm-7"><input type="text" name="editWorkDesignation'+j+'" class="form-control" id="editWorkDesignation'+j+'" placeholder="" maxlength="200" required="required"></div></div>'
				        +'<br>'
				        +'</div>'
				).find('.form-control-datepicker').removeClass('valid').datepicker({
              	  format: "dd/mm/yyyy",
                	autoclose: true,
                	todayHighlight: true
                });
			   
	});
	$('body').on('click', '.editbtnDel', function () {
		  $(this).parent('.editdeleteexp').remove();
			 
			if($('.editdeleteexp').length==0){
	  		
				   $("#editexperiencedetails").append('<div class="alert alert-info" role="alert" style="display: block">'+
							'<strong>Info!</strong>&nbsp;You want to add your experience details, Please click "Add More Experience Details" button.'+
							'</div>');  

	  	}
	  	else{
	  		
	  		$(".alert-info").hide();    		
	  		
	  	}
		});
 
 });


$(document).ready(function() {
	
	
	 $("#institutionAuthorizedSignaturePic").on('change', function() {
         //Get count of selected files
         var countFiles = $(this)[0].files.length;
         var imgPath = $(this)[0].value;
         var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
         var image_holder = $("#image-aaholder1");
         
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
        	   $('#institutionAuthorizedSignaturePic').filestyle('clear');
            // alert("This browser does not support FileReader.");
             edumaatAlert({
   			  title: "Info !",
   			  text: "This browser does not support FileReader!",
   			  type: "info",
   			  confirmButtonText: "Cool"
   			});
           }
         } else {
      	 
      	 $('#institutionAuthorizedSignaturePic').filestyle('clear');
         //  alert("Please select only images");
           edumaatAlert({
 			  title: "Info !",
 			  text: "Please select only images!",
 			  type: "info",
 			  confirmButtonText: "Cool"
 			});
         }
       });
		 $("#institutionProfilePic").on('change', function() {
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
        	   $('#institutionProfilePic').filestyle('clear');
            // alert("This browser does not support FileReader.");
             edumaatAlert({
   			  title: "Info !",
   			  text: "This browser does not support FileReader!",
   			  type: "info",
   			  confirmButtonText: "Cool"
   			});
           }
         } else {
      	 
      	 $('#institutionProfilePic').filestyle('clear');
         //  alert("Please select only images");
           edumaatAlert({
 			  title: "Info !",
 			  text: "Please select only images!",
 			  type: "info",
 			  confirmButtonText: "Cool"
 			});
         }
       });
   $("#staffProfilePic").on('change', function() {
     //Get count of selected files
     var countFiles = $(this)[0].files.length;
     var imgPath = $(this)[0].value;
     var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
     var image_holder = $("#image-holder7");
     
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
      	  $('#staffProfilePic').filestyle('clear');
       //  alert("This browser does not support FileReader.");
         edumaatAlert({
			  title: "Info !",
			  text: "This browser does not support FileReader!",
			  type: "info",
			  confirmButtonText: "Cool"
			});
       }
     } else {
  	  $('#staffProfilePic').filestyle('clear');
      // alert("Please select only images");
       edumaatAlert({
			  title: "Info !",
			  text: "Please select only images!",
			  type: "info",
			  confirmButtonText: "Cool"
			});
     }
   });
 });

   
      
 function checkPasswordMatch() {
	 var password = $("#adminPassword").val();
     var confirmPassword = $("#adminConfirmPassword").val();

     if (password != confirmPassword){
     	$(".error1").show();
         $(".error1").html("Passwords do not match!");
     }
     else{
     	$(".error1").hide();}
 }
 
 function editCheckPasswordMatch() {
	 var password = $("#editAdminPassword").val();
     var confirmPassword = $("#editAdminConfirmPassword").val();

     if (password != confirmPassword){
     	$(".error2").show();
         $(".error2").html("Passwords do not match!");
     }else
     {
     	$(".error2").hide();
     }
 }
