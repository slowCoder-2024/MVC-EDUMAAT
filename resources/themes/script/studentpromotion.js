 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));	
	
$(document).ready(function() {
	 
	 $('#example-select-all').on('click', function(){
	      // Check/uncheck all checkboxes in the table
	   var datatable = $('#studentsList').DataTable();
	      var rows = datatable.rows({ 'search': 'applied' }).nodes();
	      $('input[type="checkbox"]', rows).prop('checked', this.checked);
	     });
  $('#studentsList').on('change', 'input[type="checkbox"]', function(){
	      // If checkbox is not checked
	      if(!this.checked){
	         var el = $('#example-select-all').get(0);
	         // If "Select all" control is checked and has 'indeterminate' property
	         if(el && el.checked && ('indeterminate' in el)){
	            // Set visual state of "Select all" control 
	            // as 'indeterminate'
	            el.indeterminate = true;
	         }
	      }
	   });
  $("#secionDIV").hide();
	$("#categoryDIV").hide();
  $('#classList').change(function(event) {
	    var classId = $("#classList").val();
	    $("#currentclassId").val(classId);
	    if(classId=="all"){
	    	
	    	$("#secionDIV").hide();
	    	$("#categoryDIV").hide();
	    	$(".form-group-student-id").hide();
	    	$(".form-group-special-category").hide();
	    	
	    }
	    else{
	    $("#secionDIV").show();
	    	$("#categoryDIV").show();
	        $.ajax({
				   url:ctx+'/classSection/'+classId,
				   type:'GET',
				   success: function(response){
					   $('#sectionList').attr('disabled', false);
			    	   var select = $('#sectionList');
			    	   if(response.length>0)
			        	  {
			        		  select.find('option').remove(); 
			        		  $('#sectionList').selectpicker('destroy');
			        	  }
			        	  else
			        	  {
			        		  select.find('option').remove();
			        		  $('#sectionList').selectpicker('destroy');
			        		  select.append('<option value="" disabled selected>Select Section</option>');
			        	  }
					   $.each(response, function(key,value) {
					  		 if(key==0){
					     	    		select.append('<option value="" disabled selected>Select Section</option>');
					     	    	}
					  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
					  	 }); 
					   $('#sectionList').selectpicker('show');
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/student/studentpromotion";
			       }
				});
	   
		  
}	  
	  
	
     
});
  
  $('#promotionclassList').change(function(event) {
	    var classId = $("#promotionclassList").val();
	        $.ajax({
				   url:ctx+'/classSection/'+classId,
				   type:'GET',
				   success: function(response){
					   $('#promotionsectionList').attr('disabled', false);
			    	   var select = $('#promotionsectionList');
			    	   if(response.length>0)
			        	  {
			        		  select.find('option').remove(); 
			        		  $('#promotionsectionList').selectpicker('destroy');
			        	  }
			        	  else
			        	  {
			        		  select.find('option').remove();
			        		  $('#promotionsectionList').selectpicker('destroy');
			        		  select.append('<option value="" disabled selected>Select Section</option>');
			        	  }
					   $.each(response, function(key,value) {
					  		 if(key==0){
					     	    		select.append('<option value="" disabled selected>Select Section</option>');
					     	    	}
					  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
					  	 }); 
					   $('#promotionsectionList').selectpicker('show');
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/student/studentpromotion";
			       }
				});
	   
		  
});
  $('#studentsList').DataTable();
	$("#categoryList").change(function() {
		
		
		 var value = $(this).val();
		 
		 if(value ==="specificstudent"){
			 
			 $(".form-group-student-id").show();
		        $(".form-group-special-category").hide(); 
			 
		 }
		 else if(value==="specialcategory"){
			 
				 $(".form-group-student-id").hide();
		        $(".form-group-special-category").show();  
			 
		 }
		 else
			 {
			  $(".form-group-student-id").hide();
		        $(".form-group-special-category").hide();  
			 
			 
			 }
		
	});
  $('#studentDataExcel').click(function(event)
		  {
		 if($("#getDetails").valid())
		 {
			 var url=ctx+'/student/excelDownload';
			 $('#getDetails').attr('action',url).submit(); 
		 }
			
		 
	 });
	 
  
	 $("#getDetailsFromSelectedCriteria").click(function(event){
		 if($("#getDetails").valid())
			 {
			 $('.loader').show();
			 	var data=$('#getDetails').serialize();
			 	$.ajax(	
			 	{
			        type: "GET",
			        url:ctx+"/student/studentpromotionlist" ,
			        data: data,
			        contentType: "application/json; charset=utf-8",
			        dataType: "json",
			        cache: false,
			        success: function (data) {
			        	
			        	 if(!$.trim(data))
			        	 {
			        		 $('.loader').hide();
			        			$(".form-horizontal").trigger('reset'); 
					         edumaatAlert({
					    			  title: "Info !",
					    			  text:"Data Not Found",
					    			  type: "info",
					    			  confirmButtonText: "Cool"
					    			}).then(function(){
					    				window.location.href=ctx+'/student/studentpromotion';
						        		
						        	});
			        	 }
			        	 else
			        	 {	
			        	
			        	 $('.loader').hide();
			        	var datatable = $('#studentsList').DataTable();
			        	$(".form-horizontal").trigger('reset'); 
			        	 
						
			        	datatable.clear().draw();
						
						
							$.each(data, function (i, value) {
								var name;
								if(value.lastName!=null){
									
									name=value.firstName +' '+value.lastName;
								}
								else{
									name=value.firstName;
								}
								var studentcontact="";
								if(value.contact)
								{
									studentcontact=value.contact;
									
								}else
								{
									studentcontact="";
								}
								var parentContact="";
								if(value.parentContact)
									{
									parentContact=value.parentContact;
									}
								datatable.row.add(['<div class="checkbox checkbox-pink"><input type="checkbox" value='+value.studentId+' name='+value.studentId+' class="case" id='+value.studentId+'></input><label for='+value.studentId+'></label></div>',value.admissionNo,name,value.studentClass.className+"/"+value.section.sectionName,studentcontact,parentContact]).draw( false );
								});
			         	
							
			        	 }
			        },
			 	 	error:function(){
			 	 		$('.loader').hide();
			        	$(".form-horizontal").trigger('reset'); 
			 	    }
		      
			 	});
			  }
		  });	
  $('#deleteStudents').click(function() {
		
		if($("#deleteStudentForms").valid()){
			 var selectedstudentid = [];
			
			 var oTable = $('#studentsList').dataTable();
			 var rowcollection =  oTable.$(".case:checked", {"page": "all"});
			 rowcollection.each(function(index,elem){
			     selectedstudentid.push($(elem).val());
			 });
			
		 $("#selectedStudentIds").val(selectedstudentid);	  
			
				if((selectedstudentid.length)>0)
				 {
					 $('#bulkConfirmation').modal('show');
		    			$('#bulkConfirm').click(function(){
				$("#deleteStudentForms").submit();
		    			});
				 }
				 else{
					 edumaatAlert({
		    			  title: "Info !",
		    			  text: "You have to select atleast one student for promotion",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
				 }
		
			   }  
		  });
	 $('table tbody').on( 'click', 'tr td a#edit', function () {
		  
		  var studentId = $(this).attr('data-id');
		  $('.loader').show();
		    $.ajax({
				   url:ctx+'/student/'+studentId,
				   type:'GET',
				   success: function(response){
					   $('.loader').hide();
					   if(response.firstName!=null)
					   {
						   $("[name=editFirstName]").val(response.firstName);
		     	        	   
					   }
					   if(response.lastName!=null)
					   {
						   $("[name=editLastName]").val(response.lastName);
				
					   }
					   if(response.parentGuardianFirstName!=null)
					   {
		     	        	$("[name=editParentOrGuardianFirstName]").val(response.parentGuardianFirstName);
						   
					   }
					   if(response.parentGuardianLastName!=null)
					   {
		     	        	$("[name=editParentOrGuardianLastName]").val(response.parentGuardianLastName);
						   
					   }

					   if(response.parentGuardianEmail!=null)
					   {
		     	        	$("[name=editParentOrGuardianEmail]").val(response.parentGuardianEmail);
						   
					   }
					   if(response.sex!=null)
					   {
						   $('#editStudentGender').selectpicker('destroy');
							$("[name=editStudentGender]").val(response.sex);
							 $('#editStudentGender').selectpicker('show');
					   }
					   if(response.birthDate!=null)
					   {
		     	        	/*$("[name=editDateOfBirth]").val($.datepicker.formatDate('mm/dd/yy',new Date(response.birthDate)));*/
		     	        	$("#editDateOfBirth").datepicker('update',new Date(response.birthDate));
						   
					   }
					   if(response.email!=null)
					   {
		     	        	$("[name=editEMail]").val(response.email);
						   
					   }
					   if(response.contact!=null)
					   {
		     	        	$("[name=editContact]").val(response.contact);
						   
					   }
					   if(response.parentContact!=null)
					   {
		     	        	$("[name=editParentContact]").val(response.parentContact);
						   
					   }
					   if(response.category!=null)
					   {
						   $('#editCategoryId').selectpicker('destroy');
		     	        	$("[name=editCategoryId]").val(response.category.categoryId);
		     	        	$('#editCategoryId').selectpicker('show');
						   
					   }
					   if(response.specialCategories!=null)
					   {
		        			 var selectedValues = new Array();
		        	         $.each(response.specialCategories, function(key,value) 
		        					 { 
		        	        	 		selectedValues[key]=value.specialCategoryId;
									 });
		        	         $('#editSpecialCategoryId').selectpicker('destroy');
		        	    	$("[name=editSpecialCategoryId]").val(selectedValues);
		        	    	$('#editSpecialCategoryId').selectpicker('show');
						   
					   }
					   if(response.fathersIncome!=null)
					   {
		     	        	$("[name=editFatherIncome]").val(response.fathersIncome);
						   
					   }
					   if(response.mothersIncome!=null)
					   {
		     	        	$("[name=editMotherIncome]").val(response.mothersIncome);
						   
					   }
					   if(response.addressLine1!=null)
					   {
		     	        	$("[name=editStudentAddressLine1]").val(response.addressLine1);
						   
					   }
					   if(response.addressLine2!=null)
					   {
		     	        	$("[name=editStudentAddressLine2]").val(response.addressLine2);
						   
					   }
					   if(response.country!=null)
					   {
						   $('#geographicallocation1').selectpicker('destroy');
		     	        	$("[name=editStudentCountry]").val(response.country);
		     	           $('#geographicallocation1').selectpicker('show');
						   
					   }
					   if(response.state!=null)
					   {
						   $('#geographicallocationstate1').selectpicker('destroy');
		     	        	$("[name=editStudentState]").val(response.state);
		     	        	$('#geographicallocationstate1').selectpicker('show');
		     	        	$("#geographicallocationstate1").prop('disabled', true);
	  				   }
					   else
					   {
						   $("#geographicallocationstate1").prop('disabled', true);	
					   }
	  				
					   if(response.city!=null)
					   {
						   $('#geographicallocationcity1').selectpicker('destroy');
		     	        	$("[name=editStudentCity]").val(response.city);
		     	        	$('#geographicallocationcity1').selectpicker('show');
		     	        	$("#geographicallocationcity1").prop('disabled', true);
		  				}
		  				else
		  				{
		  					$("#geographicallocationcity1").prop('disabled', true);
		  				}
					   if(response.postcode!=null)
					   {
							$("[name=editStudentPostCode]").val(response.postcode);
		     	           
					   }
					   if(response.joinedClass!=null)
					   {
						   $('#editJoinedClass').selectpicker('destroy');
							$("[name=editJoinedClass]").val(response.joinedClass.classId);
							$('#editJoinedClass').selectpicker('show');
			     	        
					   }
					   if(response.studentClass!=null)
					   {
						   $('#editStudentClass').selectpicker('destroy');
							$("[name=editStudentClass]").val(response.studentClass.classId);
							 $('#editStudentClass').selectpicker('show');
			     	        
					   }
					   if(response.section!=null)
					   {
						   $('#editJoinedSection').selectpicker('destroy');
							$("[name=editJoinedSection]").val(response.section.sectionId);   
							$('#editJoinedSection').selectpicker('show');
							$("#editJoinedSection").prop('disabled', true);
		  				}
					   else
					   {
							$("#editJoinedSection").prop('disabled', true);
					   }
					   
					  
					   if(response.joinedAcademicYear!=null)
					   {
						   $('#editAcademicYearId').selectpicker('destroy');
							$("[name=editAcademicYearId]").val(response.joinedAcademicYear.academicYearId);
							$('#editAcademicYearId').selectpicker('show');
						   
					   }
					   if(response.rollNo!=null)
					   {
							$("[name=editRollNo]").val(response.rollNo);
						   
					   }
					   if(response.joinedDate!=null)
					   {
							/*$("[name=editJoinedDate]").val($.datepicker.formatDate('mm/dd/yy',new Date(response.joinedDate)));*/
							$("#editJoinedDate").datepicker('update',new Date(response.joinedDate));
						   
					   }
					   if(response.accessNo!=null)
					   {
							$("[name=editStudentAccessNo]").val(response.accessNo);
						      
					   }
					   if(response.admissionNo!=null)
					   {
							$("[name=editStudentAdmissionNo]").val(response.admissionNo);
						   
					   }
					  
					   
					  if(response.user.profilePicturePath!=null)
					   {
							$("#editStudentImage").show();
	        				$("#editStudentImage").attr('src',ctx+response.user.profilePicturePath);
	        	
					   }
					   if(response.scannedSignature!=null)
					   {
							$("#editStudentSignature").show();
	        				$("#editStudentSignature").attr('src',ctx+response.scannedSignature);
	        	   
					   }
					 
					   if(response.passportNumber!=null)
					   {
							$("[name=editPassportNo]").val(response.passportNumber);
						   
					   }
					   if(response.bloodGroup!=null)
					   {
						   $('#editBloodGroupId').selectpicker('destroy');
							$("[name=editBloodGroupId]").val(response.bloodGroup.bloodGroupId);
							$('#editBloodGroupId').selectpicker('show');
						      
					   }
					   if(response.studentStatus!=null)
					   {
						   $('#editStudentStatus').selectpicker('destroy');
						  $("[name=editStudentStatus]").val(response.studentStatus.studentStatusId);
						  $('#editStudentStatus').selectpicker('show');
						   
					   }
			  	    
					   if(response.studentId!=null)
					   {
						   $('#updateStudent').attr('data-id',response.studentId);
				       }
					   if(response.user!=null)
					   {
						   $("#updateUserId").val(response.user.userId);
				   		}
					 if(response.parentUser!=null)
					   {
						   $("#updateParentUserId").val(response.parentUser.userId);
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
		        		
		        		if(response.user.status!=null)
		        		{
		        			 $('#userStatus').selectpicker('destroy');
		        			$("[name=userStatus]").val(response.user.status);
		        			 $('#userStatus').selectpicker('show');
		        		}
						   
						   
						   
		        		if(response.parentUser.name!=null)
		        		{
		        			$("[name=parentAdminName]").val(response.parentUser.name);
	  	        			
		        		}
		        		if(response.parentUser.email!=null)
		        		{
		        			$("[name=parentAdminEmail]").val(response.parentUser.email);
	  	        		      	        			
		        		}
		        		if(response.parentUser.password!=null)
		        		{
		        			$("[name=parentAdminPassword]").val(response.parentUser.password);
		        			$("[name=parentAdminConfirmPassword]").val(response.parentUser.password);
	  	        		
		        		}
		        		if(response.parentUser.profilePicturePath!=null)
						   {
								$("#editParentProfile").show();
		        				$("#editParentProfile").attr('src',ctx+response.parentUser.profilePicturePath);
		        	
						   }
		        		if(response.parentUser.status!=null)
		        		{
		        			 $('#parentStatus').selectpicker('destroy');
		        			$("[name=parentStatus]").val(response.parentUser.status);
		        			$('#parentStatus').selectpicker('show');
		        		}
						  
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/student/managestudent";
			       }
				});
	   
			    	 });
	 
	 
	  $("#saveStudent").click(function(event) {
			
			$('#addstudentform').validate({
		        ignore: [],
		        // any other options and/or rules
		    });
				 if($("#addstudentform").valid())
					{
						$("#studentsaveconfirmation").modal('show');
						$("#studentsaveconfirm").click(function(event) {
							$('.loader').show();
							$("#addstudentform").submit();
						});
						
					}
		});
      

	  
	  $('table tbody').on( 'click', 'tr td a#delete', function () {
			 var studentid = $(this).attr('data-id');
			 $('#deletestudentconfirmation').on('show.bs.modal', function (e) {
				 $("#confirmdeletestudent").click(function(event) {
					 $("#deleteStudentId").val(studentid);
					 $('.loader').show();
					 $("#deletestudentform").submit();  
				});
				});
			   
		});
	  $('#joinedClass').change(function(event) {
	  	    var classId = $("#joinedClass").val();
	  	    $.ajax({
				   url:ctx+'/classSection/'+classId,
				   type:'GET',
				   success: function(response){
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
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/student/managestudent";
			       }
				});
	   
	  	    });
	  
	  $('#editStudentClass').change(function(event) {
	  	    var classId = $("#editJoinedClass").val();
	  	    $.ajax({
				   url:ctx+'/classSection/'+classId,
				   type:'GET',
				   success: function(response){
					   $('#editJoinedSection').attr('disabled', false);
			    	   var select = $('#editJoinedSection');
			    	   if(response.length>0)
			        	  {
			        		  select.find('option').remove(); 
			        		  $('#editJoinedSection').selectpicker('destroy');
			        	  }
			        	  else
			        	  {
			        		  select.find('option').remove();
			        		  $('#editJoinedSection').selectpicker('destroy');
			        		  select.append('<option value="" disabled selected>Select Section</option>');
			        	  }
					   $.each(response, function(key,value) {
					  		 if(key==0){
					     	    		select.append('<option value="" disabled selected>Select Section</option>');
					     	    	}
					  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
					  	 }); 
					   $('#editJoinedSection').selectpicker('show');
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/student/managestudent";
			       }
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
	  
	  $("#updateStudent").click(function(event){
		  $("#updateStudentId").val( $(this).attr('data-id'));
      	
			 $('#updateStudentForm').validate({
			        ignore: [],
			        // any other options and/or rules
			    });
			 if($("#updateStudentForm").valid())
				{
				 var password = $("#adminPassword").val();
			     var confirmPassword = $("#adminConfirmPassword").val();

			     var parentpassword = $("#parentAdminPassword").val();
			     var parentconfirmPassword = $("#parentAdminConfirmPassword").val();
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
				 else if(parentpassword != parentconfirmPassword)
				 {
					 edumaatAlert({
		    			  title: "Info !",
		    			  text: "Parent User Passwords do not match!",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
				 }
				 else
				 {
					 $('#updateconfirmation').modal('show');
					 $('#studentupdateconfirm').click(function(){
					 	
					  $('#geographicallocationstate1').attr('disabled', false);
		     		  $('#geographicallocationcity1').attr('disabled', false);
		        	 $('#editJoinedSection').attr('disabled', false);
		        	 $('.loader').show();
					 $("#updateStudentForm").submit();
					 	});
				 }
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
     	
     else
     	$(".error1").hide();
 }
 
 function parentCheckPasswordMatch() {
	 var password = $("#parentAdminPassword").val();
     var confirmPassword = $("#parentAdminConfirmPassword").val();

     if (password != confirmPassword){
     	$(".error2").show();
         $(".error2").html("Passwords do not match!");
     }
     	
     else
     	$(".error2").hide();
 }
