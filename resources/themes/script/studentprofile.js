 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));	
	
$(document).ready(function() {
	    var editi=1;
			
	 var dob=$('#editDateOfBirth').val();
	$("#editDateOfBirth").datepicker('update',new Date(dob));
		
	 $('#editDetails').click(function(event) {
		 var documentcounts=1;
		 var studentId = $("#updateStudentId").val();
		    $.ajax({
				   url:ctx+'/student/'+studentId,
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
					   window.location.href=ctx+"/student/profile";
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

/*      $('#geographicallocation1').change(function(event) {
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
		  $('#updateStudentForm').validate({
			        ignore: [],
			        // any other options and/or rules
			    });
			 if($("#updateStudentForm").valid())
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
				     $('#geographicallocationstate1').attr('disabled', false);
	     		     $('#geographicallocationcity1').attr('disabled', false);
	        	     $("#updateStudentForm").submit();
					 });
				 }
				}
		});
	   $("#editStudentProfilePic").on('change', function() {
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
            	 $('#editStudentProfilePic').filestyle('clear');
            	 edumaatAlert({
		    			  title: "Info !",
		    			  text: "This browser does not support FileReader.",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
             }
           } else {
        	   $('#editStudentProfilePic').filestyle('clear');
        	   edumaatAlert({
	    			  title: "Info !",
	    			  text: "Please select only images",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
           }
         });
	   $("#editScannedSignature").on('change', function() {
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
            	 $('#editScannedSignature').filestyle('clear');
            	 edumaatAlert({
		    			  title: "Info !",
		    			  text: "This browser does not support FileReader.",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
             }
           } else {
        	   $('#editScannedSignature').filestyle('clear');
        	   edumaatAlert({
	    			  title: "Info !",
	    			  text: "Please select only images",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
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