 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));	 
 
$(document).ready(function() {
 
	
	var currentdate = new Date(); 
    var datetime = currentdate.getDate() + "-"
                + (currentdate.getMonth()+1)  + "-" 
                + currentdate.getFullYear() + "_"  
                + currentdate.getHours() + "-"  
                + currentdate.getMinutes() + "-" 
                + currentdate.getSeconds();
var exportfilename='tc_applied_student_list_'+datetime;
	$('#overAllStudentAttendancePercentage').DataTable({
		dom: 'Bfrtip',
		 buttons: [
		            {
		                extend: 'copy',
		                title: exportfilename
		                
		            },
		            {
		                extend: 'excel',
		                title: exportfilename
		            },
		            {
		                extend: 'pdf',
		               title: exportfilename
		            },
		            {
		            	 extend: 'csv',
		                title: exportfilename
		            },
		            {
		            	 extend: 'print',
		                title: exportfilename
		            }
		        ]
	});

	
 

	$('#class').change(function(event) {
  	    var classId = $("#class").val();
  	  $(".form-group-section").hide();
  	 $(".form-group-studentid").hide();
  
  	    if(classId!=="all"){
  	    	 $(".form-group-section").show();
  	    	  $.get(ctx+'/classSection/'+classId, function(response) {
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
	        });
  	    	
  	    }
  	    else
  	    {
  	      $(".form-group-section").hide();
  	    }
       
 });
	$("#admissionNo").click(function(event) 
			{
		  $(".form-group-groupcriteria").hide();  
		    	
	});

	
	$('#getOverAllDetails').click(function(event) {
		
		if($("#overallattendanceform").valid())
			{
		
		$('.loader').show();
		  var data=$("#overallattendanceform").serialize();
	    $.ajax({
			   url:ctx+'/student/tcapprovedlist',
			   type:'GET',
			   data:data,
			   success: function(response){
				   if(!$.trim(response))
		        	 {
		        		 $('.loader').hide();
		        		 edumaatAlert({
				    			  title: "Info !",
				    			  text:"Data Not Found",
				    			  type: "info",
				    			  confirmButtonText: "Cool"
				    			}).then(function(){
				    				window.location.href=ctx+'/staff/tcapprovedreport';
					        		
					        	});
		        	 }
		        	 else
		        	 {	
		        		 $('.loader').hide();
				   var datatable = $('#overAllStudentAttendancePercentage').DataTable();
				   datatable.clear().draw();
					   $.each(response, function(key,value) 
     	      	        { 
						   var name="";
						   if(value.student.lastName!=null)
						   {
							   name=value.student.firstName+" "+value.student.lastName;
						   }
						   else
						   {
							   name=value.student.firstName;
						   }
						   datatable.row.add(['<span class="text-info">'+value.student.admissionNo+'</span>','<span class="text-pink">'+name+'</span>',value.institution.institutionName,value.studentClass.className,value.section.sectionName,value.academicYear.academicYearTitle,value.approvalStatus]).draw( false );
     	      	        });
					   $("#overallattendancedetails").show();
		        	 }
			   },
			   error: function(){
				   alert('ERROR OCCURED');
			 }
			});
			}
		});
 	
	
	

});

