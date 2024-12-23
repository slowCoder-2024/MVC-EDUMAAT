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


   
  $('#classList').change(function(event) {
	    var classId = $("#classList").val();
	    
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
			        		  select.append('<option value="" disabled >Select Section</option>');
			        	  }
					   $.each(response, function(key,value) {
					  		 if(key==0){
					     	    		select.append('<option value="" disabled >Select Section</option>');
					     	    	}
					  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
					  	 }); 
					   $('#sectionList').selectpicker('show');
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/student/managestudent";
			       }
				});
	   
		  
}	  
	  
	
     
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
			        url:ctx+"/student/editReterive" ,
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
					    				window.location.href=ctx+'/student/managestudent';
						        		
						        	});
			        	 }
			        	 else
			        	 {	
			        	
			        	 $('.loader').hide();
			        	var datatable = $('#studentsList').DataTable();
			        	$(".form-horizontal").trigger('reset'); 
			        	 $('.selectpicker').val('');
			             $('.selectpicker').selectpicker('refresh');
			        	 
						
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
								datatable.row.add(['<div class="checkbox checkbox-pink"><input type="checkbox" value='+value.studentId+' name='+value.studentId+' class="case" id='+value.studentId+'></input><label for='+value.studentId+'></label></div>',value.admissionNo,name,value.studentClass.className+"/"+value.section.sectionName,studentcontact,parentContact,'<a href="#" id="edit" class="edit" type="button" data-href="#" data-id='+value.studentId+' data-toggle="modal" onclick="showeditDiv();" >	<i class="fa fa-pencil" style="margin-right: 15px"></i> </a><a href="#"  id="delete" class="delete" type="button" data-href="#"  data-id='+value.studentId+' data-toggle="modal" data-target="#deletestudentconfirmation"><i class="fa fa-trash-o"></i></a>']).draw( false );
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
		    				 $('.loader').show();
				$("#deleteStudentForms").submit();
		    			});
				 }
				 else{
					 edumaatAlert({
		    			  title: "Info !",
		    			  text: "You have to select atleast one student for delete",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
				 }
		
			   }  
		  });
  var documentcounts=1;
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
					   if(response.houses!=null)
					   {
		        			$('#editHouseId').selectpicker('destroy');
		        	    	$("[name=editHouseId]").val(response.houses.houseId);
		        	    	$('#editHouseId').selectpicker('show');
						   
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
						  /* $('#geographicallocation1').selectpicker('destroy');*/
		     	        	$("[name=editStudentCountry]").val(response.country);
		     	          /* $('#geographicallocation1').selectpicker('show');*/
						   
					   }
					   if(response.state!=null)
					   {
						  /* $('#geographicallocationstate1').selectpicker('destroy');*/
		     	        	$("[name=editStudentState]").val(response.state);
		     	        	/*$('#geographicallocationstate1').selectpicker('show');
		     	        	$("#geographicallocationstate1").prop('disabled', true);*/
	  				   }
					  /* else
					   {
						   $("#geographicallocationstate1").prop('disabled', true);	
					   }*/
	  				
					   if(response.city!=null)
					   {
						  /* $('#geographicallocationcity1').selectpicker('destroy');*/
		     	        	$("[name=editStudentCity]").val(response.city);
		     	        	/*$('#geographicallocationcity1').selectpicker('show');
		     	        	$("#geographicallocationcity1").prop('disabled', true);*/
		  				}
		  				/*else
		  				{
		  					$("#geographicallocationcity1").prop('disabled', true);
		  				}*/
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
					   if(response.aadharCardNumber!=null)
					   {
							$("[name=editAadharCardNumber]").val(response.aadharCardNumber);
						   
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
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/student/managestudent";
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

	  $("#saveStudent").click(function(event) {
			
			$('#addstudentform').validate({
		        ignore: [],
		        // any other options and/or rules
		    });
				 if($("#addstudentform").valid())
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
	           			$("#studentsaveconfirmation").modal('show');
						$("#studentsaveconfirm").click(function(event) {
							$('.loader').show();
							$("#addstudentform").submit();
						});
						
					}
		});
      

	  
	  $('table tbody').on( 'click', 'tr td a#delete', function () {
			 var studentid = $(this).attr('data-id');
			 $("#deleteStudentId").val(studentid);
			 $('#deletestudentconfirmation').on('show.bs.modal', function (e) {
				 $("#confirmdeletestudent").click(function(event) {
				
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
	  
   	
   /*   $('#geographicallocation1').change(function(event) {
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
	  */
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
					 $('#updateconfirmation').modal('show');
					 $('#studentupdateconfirm').click(function(){
					 	
					/*  $('#geographicallocationstate1').attr('disabled', false);
		     		  $('#geographicallocationcity1').attr('disabled', false);*/
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
