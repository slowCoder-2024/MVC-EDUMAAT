	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
	
	var i=0;
	
	
	/*var dob=$('#staffDOB').val();
	$('#staffDOB').val($.datepicker.formatDate('mm/dd/yy',new Date(dob)));*/
	 var dob=$('#staffDOB').val();
		$("#staffDOB").datepicker('update',new Date(dob));
	
	 $('#editDetails').click(function(event) {
		 var documentcounts=1;
		 
		 var staffId = $("#updateStaffId").val();
		    $.ajax({
				   url:ctx+'/staff/'+staffId,
				   type:'GET',
				   success: function(response){
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
					   window.location.href=ctx+"/staff/profile";
			       }
				});
		 $("#editDetailss").show();
		 $("#profileindex").hide();
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

	
    var staffId = $("#updateStaffId").val();
	    $.ajax({
		   url:ctx+'/staff/'+staffId,
		   type:'GET',
		   success: function(response){
			 
			   if($.trim(response.staffExperienceDetails)&&response.staffExperienceDetails!=null)
			   {
				
				   $.each(response.staffExperienceDetails, function(key,value) 
							{
							   i=key+1;
						   $("#experiencedetails").append('<div id="experience'+i+'" name="experience'+i+'" class="deleteexp">'
									+' <button style="float:right" type="button" class="btn btn-danger btnDel"><i class="fa fa-times-circle" aria-hidden="true"></i></button>'
									+' <div class="form-group"><label for="" class="col-sm-3 control-label">Organization Name<span class="at-required-highlight">*</span></label><div class="col-sm-6"><input type="text" name="organizationName'+i+'-'+value.staffExperienceDetailId+'" class="form-control" id="organizationName'+i+'-'+value.staffExperienceDetailId+'" placeholder="" maxlength="225" required="required"></div></div>'
									+'<div class="form-group"><label for="" class="col-sm-3 control-label">Experience<span class="at-required-highlight">*</span></label> <div class="col-sm-6"> <input type="text" name="workExp'+i+'" class="form-control" id="workExp'+i+'" placeholder="" onkeypress="return isFloatNumber(this,event)" required="required"></div></div>'
							        +'<div class="form-group"><label for="" class="col-sm-3 control-label">Experience Start Date<span class="at-required-highlight">*</span></label> <div class="col-sm-6"> <input type="text" name="staffESD'+i+'" class="form-control form-control-datepicker" id="staffESD'+i+'" placeholder="" required="required"></div></div>'
							        +' <div class="form-group"><label for="" class="col-sm-3 control-label">Experience End Date<span class="at-required-highlight">*</span></label> <div class="col-sm-6"> <input type="text" name="staffEED'+i+'" class="form-control form-control-datepicker" id="staffEED'+i+'" placeholder="" required="required"></div></div>'
							        +'  <div class="form-group"><label for="" class="col-sm-3 control-label">Designation<span class="at-required-highlight">*</span></label> <div class="col-sm-6"><input type="text" name="workDesignation'+i+'" class="form-control" id="workDesignation'+i+'" placeholder="" maxlength="200" required="required"></div></div>'
							        +'<br>'
							        +'</div>'
							).find('.form-control-datepicker').removeClass('hasDatepicker').datepicker({
					          	  format: "dd/mm/yyyy",
					            	autoclose: true,
					            	todayHighlight: true
					            });
						   
						   if(value.workedOrganisation!=null)
						   {
							  $("#organizationName"+i+"-"+value.staffExperienceDetailId).val(value.workedOrganisation); 
						   }
						   if(value.inPreviousExperience!=null)
						   {
							  $("#workExp"+i).val(value.inPreviousExperience); 
						   }
						   if(value.startDate!=null)
						   {
							 /* $("#staffESD"+i).val($.datepicker.formatDate('mm/dd/yy',new Date(value.startDate))); */
							  $("#staffESD"+i).datepicker('update',new Date(value.startDate));
						   }
						   if(value.endDate!=null)
						   {
							 /* $("#staffEED"+i).val($.datepicker.formatDate('mm/dd/yy',new Date(value.endDate))); */
							  $("#staffEED"+i).datepicker('update',new Date(value.endDate));
						   }
						   if(value.staffPreviousDesignation!=null)
						   {
							  $("#workDesignation"+i).val(value.staffPreviousDesignation); 
						   }
						   
						   });
			   }
			   else
			   {
				   
				   $("#experiencedetails").append('<div class="alert alert-info" role="alert" style="display: block">'+
					'<strong>Info!</strong>&nbsp;You want to add your experience details, Please click "Add More Experience Details" button.'+
					'</div>');    
			   
			   }
			 		   },
		   error: function(){
			   alert('ERROR OCCURED');
			   window.location.href=ctx+"/staff/profile";
	       }
		});
	    
		$('.btnAdd').click(function() {
			
			i=i+1;
	    		
	    		$(".alert-info").hide();
	    	
		$("#experiencedetails").append('<div id="experience'+i+'" name="experience'+i+'" class="deleteexp">'
				+' <button style="float:right" type="button" class="btn btn-danger btnDel"><i class="fa fa-times-circle" aria-hidden="true"></i></button>'
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
		$('body').on('click', '.btnDel', function () 
				{
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
		   var editi=1;
			
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
     	 edumaatAlert({
	    			  title: "Info !",
	    			  text: "This browser does not support FileReader.",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
      }
    } else {
 	   $('#staffProfilePic').filestyle('clear');
 	   edumaatAlert({
 			  title: "Info !",
 			  text: "Please select only images",
 			  type: "info",
 			  confirmButtonText: "Cool"
 			});
    }
  });
	


$("#updateStaff").click(function(event){
	
	$('#updatestaffform').validate({
	        ignore: [],
	        // any other options and/or rules
	    });
	 if($("#updatestaffform").valid())
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
		
		 for(m=1;m<=i;m++)
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
			$("#staffExperienceIdArray").val(staffExperiencearr);
			
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
			$('#staffupdateconfirmation').modal('show');
			$('#staffUpdateConfirm').click(function(){
		    $("#updatestaffform").submit();
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