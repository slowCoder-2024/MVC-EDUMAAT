	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	


$(document).on("click",".img",function(event)
		{
	  $("#"+this.id).on('change', function() {
          //Get count of selected files
          var countFiles = $(this)[0].files.length;
          var imgPath = $(this)[0].value;
         
          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
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
                  });
                }
                reader.readAsDataURL($(this)[0].files[i]);
              }
            } else {
            	$("#"+this.id).filestyle('clear');
              edumaatAlert({
    			  title: "Info !",
    			  text: "This browser does not support FileReader.",
    			  type: "info",
    			  confirmButtonText: "Cool"
    			});
            }
          } else {
        	  $("#"+this.id).filestyle('clear');
            edumaatAlert({
    			  title: "Info !",
    			  text: "Please select only images",
    			  type: "info",
    			  confirmButtonText: "Cool"
    			});
          }
        });
		});

   var editi=1;
$(document).on("click",".btnadd-document",function(event)
		{
	editi=editi+1;
		$('#documentinfo').append('<tr class="dismiss'+editi+'"><td><div id="div'+editi+'"></div><div class="form-group col-sm-12"><select name="documentType'+editi+'"  id="documentType'+editi+'" data-style="btn-white" class="selectpicker" required="required" ></select></div></td><td><div id="divimage'+editi+'"></div></td></tr>');
		selectimage(editi);
		 $("#document"+editi).filestyle('clear');
		selectoption(editi);
	/*	
		selectdropdown(editi);
	$('#documentType'+editi).selectpicker('show');*/
});
 $('.btndel-document').attr('disabled', ( editi < 1));      
	$(document).on("click",".btndel-document",function(event)
			   {
			if(editi>1)
			{
		   		$(".dismiss"+editi).remove();
		   		editi=editi-1;
			}else
			{
				  edumaatAlert({
	    			  title: "Info !",
	    			  text:"No Record Found",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
			}
			   });

	$("#savestaff").click(function(event) {
		
		$('#addstaffform').validate({
	        ignore: []
	    });
			 if($("#addstaffform").valid())
				{
				 var docarr=[];
				 var doctypearr=[];
	       			for(k=2;k<=editi;k++)
	       			{
	       				
	       				var docTypeId="documentType"+k;
	       				if(document.getElementById(docTypeId))
	       				{    
	       					doctypearr.push(docTypeId);
	       				}
	       				var docId="document"+k;
	       				if(document.getElementById(docId))
	       				{    
	       					docarr.push(docId);
	       					/*$("#dynamicdocument").append('<input type="file" id="documents'+docId+'" name="documents" value="'+$("#"+docId).val()+'">');*/
	       				}
	       			}
	       			
	       			if(editi<=1)
	       			{
	       				$("#dynamicdocument").append('<input type="file" id="documents" name="documents">');
	       				
	       			}
	       			$("#documenttypes").val(doctypearr);
					$("#staffsaveconfirmation").modal('show');
					$("#staffsaveconfirm").click(function(event) {
						 $('.loader').show();
						$("#addstaffform").submit();
					});
					
				}
	});

/*	
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
 
  });	*/
var j=0;
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
			).find('.form-control-datepicker').removeClass('hasDatepicker').datepicker({
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

var documentcounts=1;
$('table tbody').on( 'click', 'tr td a#edit', function () {
	 var staffId = $(this).attr('data-id');
	 $('.loader').show();
			   $.ajax({
				   url:ctx+'/staff/'+staffId,
				   type:'GET',
				   success: function(response)
				   {
					   $('.loader').hide();
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
						  /* $("[name=editStaffDOB]").val($.datepicker.formatDate('mm/dd/yy',new Date(response.dateOfBirth)));*/
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
						  /* $('#geographicallocation1').selectpicker('destroy');*/
						   $("[name=editStaffCountry]").val(response.country);
						  /* $('#geographicallocation1').selectpicker('show');*/
		     	        	   
					   }
					   if(response.state!=null)
					   {
						 /*  $('#geographicallocationstate1').selectpicker('destroy');*/
						   $("[name=editStaffState]").val(response.state);
					   }
						  /* $('#geographicallocationstate1').selectpicker('show');
						   $("#geographicallocationstate1").prop('disabled', true);
	  				  
					   else
					   {
						   $("#geographicallocationstate1").prop('disabled', true);	
					   }*/
					   if(response.city!=null)
					   {
						   
						/*   $('#geographicallocationcity1').selectpicker('destroy');*/
						   $("[name=editStaffCity]").val(response.city);
						 /*  $('#geographicallocationcity1').selectpicker('show');
						   $("#geographicallocationcity1").prop('disabled', true);*/
		  				}
		  				/*else
		  				{
		  					$("#geographicallocationcity1").prop('disabled', true);
		  				}
					   */
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
					   if(response.staffType.staffTypeId!=null)
					   {
						   $('#editStaffTypeId').selectpicker('destroy');
						   $("[name=editStaffTypeId]").val(response.staffType.staffTypeId);
						   $('#editStaffTypeId').selectpicker('show');
		     	        	   
					   }
					   if(response.staffDesignation.staffDesignationId!=null)
					   {
						   $('#editStaffDesignationId').selectpicker('destroy');
						   $("[name=editStaffDesignationId]").val(response.staffDesignation.staffDesignationId);
						   $('#editStaffDesignationId').selectpicker('show');
						   $("#editStaffDesignationId").prop('disabled', true);
	  				   }
					   else
					   {
						   $("#editStaffDesignationId").prop('disabled', true);	
					   }
					   if(response.staffCode!=null)
					   {
						   $("[name=editStaffCode]").val(response.staffCode);
		     	        	   
					   }
					  
					   if(response.approver.userId!=null)
					   {
						   $('#editApproverId').selectpicker('destroy');
						   $("[name=editApproverId]").val(response.approver.userId);
						   $('#editApproverId').selectpicker('show');
		     	        	   
					   }
					   if(response.user.userRoles!=null)
					   {
						   var selectedRoles=[];
						   $.each(response.user.userRoles, function(key,value) 
								   {
							   selectedRoles[key]=value.roleId;
							  
						   });
						   $('#editUserRoleId').selectpicker('destroy');
						   $("#editUserRoleId").val(selectedRoles);
						   $('#editUserRoleId').selectpicker('show');
						   //$("#editUserRoleId").val(userRoles).trigger("change");
		     	        	   
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
					   if(response.user.name!=null)
		        		{
		        			$("[name=adminName]").val(response.user.name);
	  	        			
		        		}
		        		if(response.user.email!=null)
		        		{
		        			$("[name=adminEmail]").val(response.user.email);
	  	        		      	        			
		        		}
		        		if(response.user.password!=null)
		        		{
		        			$("[name=adminPassword]").val(response.user.password);
		        			$("[name=adminConfirmPassword]").val(response.user.password);
	  	        		
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
								 /* $("#editStaffEED"+j).val($.datepicker.formatDate('mm/dd/yy',new Date(value.endDate)));*/ 
								  $("#editStaffEED"+j).datepicker('update',new Date(value.endDate));
							   }
							   if(value.staffPreviousDesignation!=null)
							   {
								  $("#editWorkDesignation"+j).val(value.staffPreviousDesignation); 
							   }
							   
							   });
					   	} 
					   else{
							   
							   $("#editexperiencedetails").append('<div class="alert alert-info" role="alert" style="display: block">'+
								'<strong>Info!</strong>&nbsp;You want to add your experience details, Please click "Add More Experience Details" button.'+
								'</div>');    
						   
						   }
			
					   if(response.staffId!=null)
					   {
						   $('#updateStaff').attr('data-id',response.staffId);
				       }
					   if(response.user.userId!=null)
					   {
						   $('#updateUserId').val(response.user.userId);
				       }
					   if(response.staffBankDetail.staffBankDetailId!=null)
					   {
						   $('#updateStaffBankDetailId').val(response.staffBankDetail.staffBankDetailId);
				       }
					   
					   
					   if(response.documents)
		        		{
		        			 $.each(response.documents, function(key,value) 
		        					 { 
		        				 documentcounts=parseFloat(documentcounts)+1;
		        					$('#editdocumentinfo').append('<tr class="dismiss'+documentcounts+'"><td><div id="div'+documentcounts+'"></div><div class="form-group col-sm-12"><select name="documentType'+documentcounts+'"  id="documentType'+documentcounts+'" data-style="btn-white" class="selectpicker" required="required" ></select></div></td><td><div id="divimage'+documentcounts+'"></div></td></tr>');
		        					editselectimage(documentcounts);
		        					 $("#document"+documentcounts).filestyle('clear');
		        					selectoption(documentcounts,value.documentType.documentTypeId);
		        					 });
		        		}
		        		$("#documentsCount").val(documentcounts);
				   },
				   error:function()
				   {
					   alert("ERROR OCCURED");
				   }
				 });
	   
});

var documentediti;

$(document).on("click",".edit-btnadd-document",function(event)
			{
	   documentediti= $("#documentsCount").val();
		documentediti=parseFloat(documentediti)+1;
		$("#documentsCount").val(documentediti);
			$('#editdocumentinfo').append('<tr class="dismiss'+documentediti+'"><td><div id="div'+documentediti+'"></div><div class="form-group col-sm-12"><select name="documentType'+documentediti+'"  id="documentType'+documentediti+'" data-style="btn-white" class="selectpicker" required="required" ></select></div></td><td><div id="divimage'+documentediti+'"></div></td></tr>');
			editselectimage(documentediti);
			 $("#document"+documentediti).filestyle('clear');
			selectoption(documentediti);
	 });
		$(document).on("click",".edit-btndel-document",function(event)
			   {
			documentediti=$("#documentsCount").val();
				if(documentediti>1)
 			{
 		$(".dismiss"+documentediti).remove();
		   	documentediti=parseFloat(documentediti)-1;
		   $("#documentsCount").val(documentediti);
		  		}else
 			{
 				  edumaatAlert({
		    			  title: "Info !",
		    			  text:"No Record Found",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
 			}
			   });

$("#updateStaff").click(function(event){
	 var staffId = $(this).attr('data-id');
	 $("#updateStaffId").val(staffId);
	 $('#updateStaffForm').validate({
	        ignore: [],
	        // any other options and/or rules
	    });
	 if($("#updateStaffForm").valid())
		{
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
		 }else
		 {
			 var staffExperiencearr=[];
				
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
			 
			 var docarr=[];
			 var imagelabel=[];
			 var doctypearr=[];
			 var count=$("#documentsCount").val();
       			for(k=2;k<=count;k++)
       			{
       				
       				var docTypeId="documentType"+k;
       				if(document.getElementById(docTypeId))
       				{    
       					doctypearr.push(docTypeId);
       				}
       				var docId="document"+k;
       				if(document.getElementById(docId))
       				{    
       					docarr.push(docId);
       					$("#dynamicdocument").append('<input type="file" id="documents'+docId+'" name="documents" value="'+$("#"+docId).val()+'">');
       				}
       			
       			}
       			
       			if(count<=1)
       			{
       				$("#editdynamicdocument").append('<input type="file" id="documents" name="documents">');
       				
       			}
       			//alert(doctypearr);
       			$("#editdocumenttypes").val(doctypearr);
			 $("#staffExperienceIdArray").val(staffExperiencearr);
			 $('#staffUpdateConfirmation').modal('show');
			 $('#staffUpdateConfirm').click(function(){
				  $('#editStaffDesignationId').attr('disabled', false);
				  $('#geographicallocationstate1').attr('disabled', false);
				  $('#geographicallocationcity1').attr('disabled', false);
				  $('.loader').show();
			 $("#updateStaffForm").submit();
			 });
		 }
		
  
		}
});
$('table tbody').on( 'click', 'tr td a#delete', function () {
	 var staffid = $(this).attr('data-id');
	 $("#deleteStaffId").val(staffid);
	 $('#deletestaffconfirmation').on('show.bs.modal', function (e) {
		 $("#confirmdeletestaff").click(function(event) {
			 $('.loader').show();
			  $("#deletestaffform").submit();  
		});
		});
	   
});

	
	
	$('#staffTypeId').change(function(event) {
		var staffTypeId=$(this).val();
		 $.ajax({
			   url:ctx+'/staffdesignation/stafftype/'+staffTypeId,
			   type:'GET',
			   success: function(response)
			   {
				   var select = $('#staffDesignationId');
				   if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#staffDesignationId').selectpicker('destroy');
		        	  }
		        	  else
		        	  {
		        		  select.find('option').remove();
		        		  $('#staffDesignationId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Section</option>');
		        	  }
	        	   $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select Staff Designation</option>');
	   	        	      }
	            		 $('<option>').val(value.staffDesignationId).text(value.staffDesignationName).appendTo(select);
	            	  
	            	 });
	        	   
	        	   $('#staffDesignationId').selectpicker('show');
	        	   
				},
			   error:function(){
				   alert("Error Occured");
				   window.location.href=ctx+"/staff/manage";
			   }
		});
	});
	
	$('#editStaffTypeId').change(function(event) {
		var staffTypeId=$(this).val();
		 $.ajax({
			   url:ctx+'/staffdesignation/stafftype/'+staffTypeId,
			   type:'GET',
			   success: function(response)
			   {
				   var select = $('#editStaffDesignationId');
				   if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#editStaffDesignationId').selectpicker('destroy');
		        	  }
		        	  else
		        	  {
		        		  select.find('option').remove();
		        		  $('#editStaffDesignationId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Section</option>');
		        	  }
	        	   $('#editStaffDesignationId').attr('disabled', false);
	        	   $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select Staff Designation</option>');
	   	        	      }
	            		 $('<option>').val(value.staffDesignationId).text(value.staffDesignationName).appendTo(select);
	            	  
	            	 });
	        	   
	        	   $('#editStaffDesignationId').selectpicker('show');
	        	   
				},
			   error:function(){
				   alert("Error Occured");
				   window.location.href=ctx+"/staff/manage";
			   }
		});
	});
});
$(document).ready(function() {
    var i=0;
	$('.btnAdd').click(function() {
		
		i=i+1;
    		
		if($('#experiencedetails').children('div.deleteexp').length <0){
    		
			$(".alert-info").show();

		    	}
		    	else{
		    		
		    		$(".alert-info").hide();    		
		    		
		    	}

    	
	$("#experiencedetails").append('<div id="" class="deleteexp">'
			+'<input type="hidden" id="experience" name="experience">'
			+' <div class="form-group"><label for="" class="col-sm-3 control-label">Organization Name<span class="at-required-highlight">*</span></label><div class="col-sm-7"><input type="text" name="organizationName'+i+'" class="form-control" id="organizationName'+i+'" placeholder="" maxlength="225" required="required"></div></div>'
			+'<div class="form-group"><label for="" class="col-sm-3 control-label">Experience<span class="at-required-highlight">*</span></label> <div class="col-sm-7"> <input type="text" name="workExp'+i+'" class="form-control" id="workExp'+i+'" placeholder="" onkeypress="return isFloatNumber(this,event)" required="required"></div></div>'
	        +'<div class="form-group"><label for="" class="col-sm-3 control-label">Experience Start Date<span class="at-required-highlight">*</span></label> <div class="col-sm-7"> <input type="text" name="staffESD'+i+'" class="form-control form-control-datepicker" id="staffESD'+i+'" placeholder="" required="required"></div></div>'
	        +' <div class="form-group"><label for="" class="col-sm-3 control-label">Experience End Date<span class="at-required-highlight">*</span></label> <div class="col-sm-7"> <input type="text" name="staffEED'+i+'" class="form-control form-control-datepicker" id="staffEED'+i+'" placeholder="" required="required"></div></div>'
	        +'  <div class="form-group"><label for="" class="col-sm-3 control-label">Designation<span class="at-required-highlight">*</span></label> <div class="col-sm-7"><input type="text" name="workDesignation'+i+'" class="form-control" id="workDesignation'+i+'" placeholder="" maxlength="200" required="required"></div></div>'
	        +'<br>'
	        +'</div>'
	).find('.form-control-datepicker').removeClass('hasDatepicker').datepicker({
  	  format: "dd/mm/yyyy",
    	autoclose: true,
    	todayHighlight: true
    });
	});
	
	
	$('#expdelete').on('click', '.btnDel', function () {
		if($('#experiencedetails').children().length <=1){
		    		
			$(".alert-info").show();

		    	}
		    	
		$('#experiencedetails').children('div.deleteexp').last().remove();
			});
	
});
$("#staffProfilePic").on('change', function() {
    //Get count of selected files
    var countFiles = $(this)[0].files.length;
    var imgPath = $(this)[0].value;
    var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
    var image_holder = $(".viewimage1");
    
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
$("#editStaffProfilePic").on('change', function() {
    //Get count of selected files
    var countFiles = $(this)[0].files.length;
    var imgPath = $(this)[0].value;
    var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
    var image_holder = $(".viewimage2");
    
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
     	  $('#editStaffProfilePic').filestyle('clear');
      //  alert("This browser does not support FileReader.");
        edumaatAlert({
			  title: "Info !",
			  text: "This browser does not support FileReader!",
			  type: "info",
			  confirmButtonText: "Cool"
			});
      }
    } else {
 	  $('#editStaffProfilePic').filestyle('clear');
     // alert("Please select only images");
      edumaatAlert({
			  title: "Info !",
			  text: "Please select only images!",
			  type: "info",
			  confirmButtonText: "Cool"
			});
    }
  });
$(document).ready(function() {
	$("#edit-experience-information").find('.form-control-datepicker').removeClass('hasDatepicker').datepicker();
    var inputs = 1;
    $('.editbtnAdd').click(function() {
    	var cloneIndex = $(".editclonedInput").length;
    	 ++inputs;
    	 var newNum =cloneIndex + 1;
        $('.editbtnDel:disabled').removeAttr('disabled');
        var c = $('.editclonedInput:first').clone(true).attr('id',"editclonedInput"+"-"+inputs);
        c.find('div input').each (function (i) {
            this.id = this.id + (newNum*5 + i);
            this.name =this.id;
        });
        c.find('.form-control-datepicker').removeClass('hasDatepicker').datepicker();
        $('.editclonedInput:last').after(c);
    });

    $('.editbtnDel').click(function() {
        if (confirm('Are You Sure?')) {
            --inputs;
            $(this).closest('.editclonedInput').remove();
            $('.editbtnDel').attr('disabled', ($('.editclonedInput').length <2));
        }
    });
});
/*$(document).ready(function() {
	var options = $('#staffDesignationId option');
    var arr = options.map(function (_, o) { return { t: $(o).text(), v: o.value }; }).get();
    arr.sort(function (o1, o2) { return o1.t.toUpperCase() > o2.t.toUpperCase() ? 1 : o1.t.toUpperCase() < o2.t.toUpperCase() ? -1 : 0; });         
    options.each(function (i, o) {
        o.value = arr[i].v;
        $(o).text(arr[i].t);
    });
});*/
/*function editmultiselect() {
	$('.editmultiselect').multiselect({
		columns:1,
	    placeholder: 'Select Privilege',
	    search: true,
	    selectAll: true
	});
}*/
function checkPasswordMatch() {
	 var password = $("#adminPassword").val();
    var confirmPassword = $("#adminConfirmPassword").val();

    if (password != confirmPassword){
    	$(".error1").show();
        $(".error1").html("Passwords do not match!");
    }
   else
   {    	$(".error1").hide();}
}

function selectoption(id)
{
	    $.get(ctx+'/document/type/list', function(response)
	    		{
	    	var selectid="documentType"+id;
	      var select = $('#'+selectid);
  	  if(response.length>0)
  	  {
  		  select.find('option').remove(); 
  		  $('#'+selectid).selectpicker('destroy');
  	  }
  	  else
  	  { 
  		  select.find('option').remove();
  		  $('#'+selectid).selectpicker('destroy');
  		  select.append('<option value="" disabled selected>Select Document Type</option>');
  	  }
  	 
  	   $.each(response, function(key,value) {
      		 if(key==0){
	        	    	select.append('<option value="" disabled selected>Select Document Type</option>');
	        	    	}
      		 $('<option>').val(value.documentTypeId).text(value.documentTypeTitle).appendTo(select);
      	  }); 
  	   $('#'+selectid).selectpicker('show');
  });
}

function selectoption(id,selectedid)
{
	    $.get(ctx+'/document/type/list', function(response)
	    		{
	    	var selectid="documentType"+id;
	      var select = $('#'+selectid);
  	  if(response.length>0)
  	  {
  		  select.find('option').remove(); 
  		  $('#'+selectid).selectpicker('destroy');
  	  }
  	  else
  	  { 
  		  select.find('option').remove();
  		  $('#'+selectid).selectpicker('destroy');
  		  select.append('<option value="" disabled selected>Select Document Type</option>');
  	  }
  	 
  	   $.each(response, function(key,value) {
      		 if(key==0){
	        	    	select.append('<option value="" disabled selected>Select Document Type</option>');
	        	    	}
      		 $('<option>').val(value.documentTypeId).text(value.documentTypeTitle).appendTo(select);
      	  }); 
  	  $("[name='"+selectid+"']").val(selectedid);
  	   $('#'+selectid).selectpicker('show');
   });
}
