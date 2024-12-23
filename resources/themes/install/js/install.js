var resizefunc = [];
        var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
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
        			+' <div class="form-group clearfix"><label for="" class="col-lg-3 control-label">Organization Name<span>*</span></label><div class="col-lg-9"><input type="text" name="organizationName'+i+'" class="form-control" id="organizationName'+i+'" placeholder="" maxlength="225" required="required"></div></div>'
        			+'<div class="form-group clearfix"><label for="" class="col-lg-3 control-label">Experience<span>*</span></label> <div class="col-lg-9"> <input type="text" name="workExp'+i+'" class="form-control" id="workExp'+i+'" placeholder="" onkeypress="return isFloatNumber(this,event)" required="required"></div></div>'
        	        +'<div class="form-group clearfix"><label for="" class="col-lg-3 control-label">Experience Start Date<span>*</span></label> <div class="col-lg-9"> <input type="text" name="staffESD'+i+'" class="form-control form-control-datepicker" id="staffESD'+i+'" placeholder="" required="required"></div></div>'
        	        +' <div class="form-group clearfix"><label for="" class="col-lg-3 control-label">Experience End Date<span>*</span></label> <div class="col-lg-9"> <input type="text" name="staffEED'+i+'" class="form-control form-control-datepicker" id="staffEED'+i+'" placeholder="" required="required"></div></div>'
        	        +'  <div class="form-group clearfix"><label for="" class="col-lg-3 control-label">Designation<span>*</span></label> <div class="col-lg-9"><input type="text" name="workDesignation'+i+'" class="form-control" id="workDesignation'+i+'" placeholder="" maxlength="200" required="required"></div></div>'
        	        +'<br>'
        	        +'<br>'
        	        +'</div>'
        	).find('.form-control-datepicker').removeClass('hasDatepicker').datepicker({
            	  format: "dd/mm/yyyy",
              	autoclose: true,
              	todayHighlight: true
              });
        	});
        	
        	
        	$('#expdelete').on('click', '.btnDel', function () {
        		if($('#experiencedetails').children().length<2){
        		    		
        			$(".alert-info").show();

        		    	}
        		    	
        		$('#experiencedetails').children('div.deleteexp').last().remove();
        			});
        	
        });
         $(document).ready(function() {
                 $("#institutionProfilePic").on('change', function() {
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
                    	  $('#institutionProfilePic').val(''); 
                       alert("This browser does not support FileReader.");
                     }
                   } else {
                	   $('#institutionProfilePic').val(''); 
                     alert("Please select only images");
                   }
                 });
               });
         $(document).ready(function() {
             $("#staffProfilePic").on('change', function() {
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
                	  $('#staffProfilePic').val(''); 
                   alert("This browser does not support FileReader.");
                 }
               } else {
            	   $('#staffProfilePic').val(''); 
                 alert("Please select only images");
               }
             });
           });
         
         $(document).ready(function() {
             $("#institutionAuthorizedSignaturePic").on('change', function() {
               //Get count of selected files
               var countFiles = $(this)[0].files.length;
               var imgPath = $(this)[0].value;
               var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
               var image_holder = $("#image-holder13");
               
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
                	  $('#institutionAuthorizedSignaturePic').val(''); 
                   alert("This browser does not support FileReader.");
                 }
               } else {
            	   $('#institutionAuthorizedSignaturePic').val(''); 
                 alert("Please select only images");
               }
             });
           });
         
         $(document).ready(function() {
        	 $('#geographicallocationstaff').change(function(event) {
   	    	  $('#geographicallocationstatestaff').attr('disabled', false);
        		  $('#geographicallocationcitystaff').attr('disabled', false);
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
    	$('#isMultiInstitutions').change(function() {
           		
           	    
           	    
             if($(this).val()==1){
            	 
            	 $(".criteria").show();
            	
            	 $(".criteriaforsingle").hide();
            	 
             }else{
            	
            
            	 $(".criteria").hide();
            	 $(".criteriaforsingle").show();
             	
             }
           	   
           	    });
		 });