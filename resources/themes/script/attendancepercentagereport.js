 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));	 
 
$(document).ready(function() {
 
	
	var currentdate = new Date(); 
    var datetime = currentdate.getDate() + "-"
                + (currentdate.getMonth()+1)  + "-" 
                + currentdate.getFullYear() + "_"  
                + currentdate.getHours() + "-"  
                + currentdate.getMinutes() + "-" 
                + currentdate.getSeconds();
var exportfilename='OverAll_StudentAttendance_Percentage'+datetime;
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

	var exportfilename1='OverAll_StudentAttendance_Percentage_Module'+datetime;
	$('#moduleStudentAttendancePercentage').DataTable({
		dom: 'Bfrtip',
		 buttons: [
		            {
		                extend: 'copy',
		                title: exportfilename1
		                
		            },
		            {
		                extend: 'excel',
		                title: exportfilename1
		            },
		            {
		                extend: 'pdf',
		               title: exportfilename1
		            },
		            {
		            	 extend: 'csv',
		                title: exportfilename1
		            },
		            {
		            	 extend: 'print',
		                title: exportfilename1
		            }
		        ]
	});
 	$('#moduleClassId').change(function(event) {
	    var classId = $("#moduleClassId").val();
  	    $.ajax({
			   url:ctx+'/classSection/'+classId,
			   type:'GET',
			   success: function(response){
				   var select = $('#moduleSectionId');
				   if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#moduleSectionId').selectpicker('destroy');
		        	  }
		        	  else
		        	  { 
		        		  select.find('option').remove();
		        		  $('#moduleSectionId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Section</option>');
		        	  }
					   $.each(response, function(key,value) {
				  		 if(key==0){
				     	    		select.append('<option value="" disabled selected>Select Section</option>');
				     	    		
				     	    	}
				  		 
				  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
		            	  
				  	 }); 
				   
				   $('#moduleSectionId').selectpicker('show');
			   },
			   error: function(){
				   alert('ERROR OCCURED');
			 }
			});
		});
 	
 	$('#moduleSectionId').change(function(event) {
 	    var classId = $("#moduleClassId").val();
	    var sectionId = $("#moduleSectionId").val();
  	    $.ajax({
			   url:ctx+'/classSection/classSectionModule',
			   type:'GET',
			   data:{classId:classId,sectionId:sectionId},
			   success: function(response){
				   var select = $('#moduleId');
				   if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#moduleId').selectpicker('destroy');
		        	  }
		        	  else
		        	  { 
		        		  select.find('option').remove();
		        		  $('#moduleId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Module</option>');
		        	  }
				   
				   
				   
				 
				   $.each(response, function(key,value) {
				  		 if(key==0){
				     	    		select.append('<option value="" disabled selected>Select Module</option>');
				     	    		
				     	    	}
				  		 
				  		$('<option>').val(value.module.moduleId).text(value.module.moduleName).appendTo(select);
		            	  
				  	 }); 
				   
				   $('#moduleId').selectpicker('show');
			   },
			   error: function(){
				   alert('ERROR OCCURED');
			 }
			});
		});
 

	$('#overAllClassId').change(function(event) {
	    var classId = $("#overAllClassId").val();
  	    $.ajax({
			   url:ctx+'/classSection/'+classId,
			   type:'GET',
			   success: function(response){
				   var select = $('#overAllSectionId');
				   if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#overAllSectionId').selectpicker('destroy');
		        	  }
		        	  else
		        	  { 
		        		  select.find('option').remove();
		        		  $('#overAllSectionId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Section</option>');
		        	  }
					   $.each(response, function(key,value) {
				  		 if(key==0){
				     	    		select.append('<option value="" disabled selected>Select Section</option>');
				     	    		
				     	    	}
				  		 
				  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
		            	  
				  	 }); 
				   
				   $('#overAllSectionId').selectpicker('show');
			   },
			   error: function(){
				   alert('ERROR OCCURED');
			 }
			});
		});
 	
	
	$('#getOverAllDetails').click(function(event) {
		
		if($("#overallattendanceform").valid())
			{
		
		$('.loader').show();
		  var data=$("#overallattendanceform").serialize();
	    $.ajax({
			   url:ctx+'/studentattendance/retrieveStudentAttendanceByAcademicYearAndClassAndSection',
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
				    				window.location.href=ctx+'/staff/attendancepercentagereport';
					        		
					        	});
		        	 }
		        	 else
		        	 {	
		        		 $('.loader').hide();
				   var datatable = $('#overAllStudentAttendancePercentage').DataTable();
				   datatable.clear().draw();
					   $.each(response, function(key,value) 
     	      	        { 
						   datatable.row.add(['<span class="text-info">'+value.f1+'</span>','<span class="text-pink">'+value.f2+'</span>','<span class="label label-table label-success">'+value.f3+'</span>','<span class="label label-table label-danger">'+value.f4+'</span>','<span class="label label-table label-inverse">'+value.f5+'</span>','<span class="label label-table label-primary">'+value.f6+'</span>','<span class="label label-table label-warning">'+value.f7+'</span>']).draw( false );
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
 	
	
	$('#getModuleAttendanceDetails').click(function(event) {
		
		if($("#moduleattendanceform").valid())
			{
		$('.loader').show();
		  var data=$("#moduleattendanceform").serialize();
	    $.ajax({
			   url:ctx+'/staff/retrieveStaffModuleAttendanceByAcademicYearAndClassAndSectionAndModule',
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
				    				window.location.href=ctx+'/staff/attendancepercentagereport';
					        		
					        	});
		        	 }
		        	 else
		        	 {	
		        		 $('.loader').hide();
				   var datatable = $('#moduleStudentAttendancePercentage').DataTable();
				   datatable.clear().draw();
					   $.each(response, function(key,value) 
     	      	        { 
						   datatable.row.add(['<span class="text-info">'+value.f1+'</span>','<span class="text-pink">'+value.f2+'</span>','<span class="label label-table label-success">'+value.f3+'</span>','<span class="label label-table label-danger">'+value.f4+'</span>','<span class="label label-table label-inverse">'+value.f5+'</span>','<span class="label label-table label-primary">'+value.f6+'</span>','<span class="label label-table label-warning">'+value.f7+'</span>']).draw( false );
     	      	        });
					   $("#moduleattendancedetails").show();
		        	 }
			   },
			   error: function(){
				   alert('ERROR OCCURED');
			 }
			});
			}
		});

});

function showmodulewiseattendance()
{
	document.getElementById('OpenModuleAttendanceDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('OpenOverAllDiv').style.display="none";
}
function showmonthwiseattendance()
{
	document.getElementById('OpenModuleAttendanceDiv').style.display="none";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('OpenOverAllDiv').style.display="block";
}