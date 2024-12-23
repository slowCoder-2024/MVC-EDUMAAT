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
 	
 	
 	$('#hostelidgenerationcriteriaId').change(function(event) {
	    var criteriaId = $("#hostelidgenerationcriteriaId").val();
  	  if(criteriaId=="academicyear")
  	  {
  		  $(".form-group-academic-year").show();
  		  $(".form-group-fees-category").hide();
  	  }
  	  else if(criteriaId=="feescategory")
  	  {
  		 $(".form-group-fees-category").show();
   		 $(".form-group-academic-year").hide();
  	  }
		});
 	
 	$('#hostelidviewcriteriaId').change(function(event) {
	    var criteriaId = $("#hostelidviewcriteriaId").val();
  	  if(criteriaId=="academicyear")
  	  {
  		  $(".form-group-academic-year").show();
  		  $(".form-group-fees-category").hide();
  	  }
  	  else if(criteriaId=="feescategory")
  	  {
  		 $(".form-group-fees-category").show();
   		 $(".form-group-academic-year").hide();
  	  }
		});
 	
 	$('#hosteliddeletecriteriaId').change(function(event) {
	    var criteriaId = $("#hosteliddeletecriteriaId").val();
  	  if(criteriaId=="academicyear")
  	  {
  		  $(".form-group-academic-year").show();
  		  $(".form-group-fees-category").hide();
  	  }
  	  else if(criteriaId=="feescategory")
  	  {
  		 $(".form-group-fees-category").show();
   		 $(".form-group-academic-year").hide();
  	  }
		});
 	
 	
 	$('#transportidgenerationcriteriaId').change(function(event) {
	    var criteriaId = $("#transportidgenerationcriteriaId").val();
  	  if(criteriaId=="academicyear")
  	  {
  		  $(".form-group-academic-year").show();
  		  $(".form-group-fees-category").hide();
  	  }
  	  else if(criteriaId=="feescategory")
  	  {
  		 $(".form-group-fees-category").show();
   		 $(".form-group-academic-year").hide();
  	  }
		});
 	
 	$('#transportidviewcriteriaId').change(function(event) {
	    var criteriaId = $("#transportidviewcriteriaId").val();
  	  if(criteriaId=="academicyear")
  	  {
  		  $(".form-group-academic-year").show();
  		  $(".form-group-fees-category").hide();
  	  }
  	  else if(criteriaId=="feescategory")
  	  {
  		 $(".form-group-fees-category").show();
   		 $(".form-group-academic-year").hide();
  	  }
		});
 	
 	$('#transportiddeletecriteriaId').change(function(event) {
	    var criteriaId = $("#transportiddeletecriteriaId").val();
  	  if(criteriaId=="academicyear")
  	  {
  		  $(".form-group-academic-year").show();
  		  $(".form-group-fees-category").hide();
  	  }
  	  else if(criteriaId=="feescategory")
  	  {
  		 $(".form-group-fees-category").show();
   		 $(".form-group-academic-year").hide();
  	  }
		});
 	
 	
	$('#classId').change(function(event) {
	    var classId = $("#classId").val();
  	    $.ajax({
			   url:ctx+'/classSection/'+classId,
			   type:'GET',
			   success: function(response){
				   var select = $('#sectionId');
				   if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#sectionId').selectpicker('destroy');
		        	  }
		        	  else
		        	  { 
		        		  select.find('option').remove();
		        		  $('#sectionId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Section</option>');
		        	  }
					   $.each(response, function(key,value) {
				  		 if(key==0){
				     	    		select.append('<option value="" disabled selected>Select Section</option>');
				     	    		
				     	    	}
				  		 
				  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
		            	  
				  	 }); 
				   
				   $('#sectionId').selectpicker('show');
			   },
			   error: function(){
				   alert('ERROR OCCURED');
			 }
			});
		});
 	
	
	$('#transportIDCardViewClassId').change(function(event) {
	    var classId = $("#transportIDCardViewClassId").val();
  	    $.ajax({
			   url:ctx+'/classSection/'+classId,
			   type:'GET',
			   success: function(response){
				   var select = $('#transportIDCardViewSectionId');
				   if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#transportIDCardViewSectionId').selectpicker('destroy');
		        	  }
		        	  else
		        	  { 
		        		  select.find('option').remove();
		        		  $('#transportIDCardViewSectionId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Section</option>');
		        	  }
					   $.each(response, function(key,value) {
				  		 if(key==0){
				     	    		select.append('<option value="" disabled selected>Select Section</option>');
				     	    		
				     	    	}
				  		 
				  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
		            	  
				  	 }); 
				   
				   $('#transportIDCardViewSectionId').selectpicker('show');
			   },
			   error: function(){
				   alert('ERROR OCCURED');
			 }
			});
		});
	
	
	$('#hostelIDCardViewClassId').change(function(event) {
	    var classId = $("#hostelIDCardViewClassId").val();
  	    $.ajax({
			   url:ctx+'/classSection/'+classId,
			   type:'GET',
			   success: function(response){
				   var select = $('#hostelIDCardViewSectionId');
				   if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#hostelIDCardViewSectionId').selectpicker('destroy');
		        	  }
		        	  else
		        	  { 
		        		  select.find('option').remove();
		        		  $('#hostelIDCardViewSectionId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Section</option>');
		        	  }
					   $.each(response, function(key,value) {
				  		 if(key==0){
				     	    		select.append('<option value="" disabled selected>Select Section</option>');
				     	    		
				     	    	}
				  		 
				  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
		            	  
				  	 }); 
				   
				   $('#hostelIDCardViewSectionId').selectpicker('show');
			   },
			   error: function(){
				   alert('ERROR OCCURED');
			 }
			});
		});
	
	$('#transportIDCardDeleteClassId').change(function(event) {
	    var classId = $("#transportIDCardDeleteClassId").val();
  	    $.ajax({
			   url:ctx+'/classSection/'+classId,
			   type:'GET',
			   success: function(response){
				   var select = $('#transportIDCardDeleteSectionId');
				   if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#transportIDCardDeleteSectionId').selectpicker('destroy');
		        	  }
		        	  else
		        	  { 
		        		  select.find('option').remove();
		        		  $('#transportIDCardDeleteSectionId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Section</option>');
		        	  }
					   $.each(response, function(key,value) {
				  		 if(key==0){
				     	    		select.append('<option value="" disabled selected>Select Section</option>');
				     	    		
				     	    	}
				  		 
				  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
		            	  
				  	 }); 
				   
				   $('#transportIDCardDeleteSectionId').selectpicker('show');
			   },
			   error: function(){
				   alert('ERROR OCCURED');
			 }
			});
		});
	
	
	$('#hostelIDCardDeleteClassId').change(function(event) {
	    var classId = $("#hostelIDCardDeleteClassId").val();
  	    $.ajax({
			   url:ctx+'/classSection/'+classId,
			   type:'GET',
			   success: function(response){
				   var select = $('#hostelIDCardDeleteSectionId');
				   if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#hostelIDCardDeleteSectionId').selectpicker('destroy');
		        	  }
		        	  else
		        	  { 
		        		  select.find('option').remove();
		        		  $('#hostelIDCardDeleteSectionId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Section</option>');
		        	  }
					   $.each(response, function(key,value) {
				  		 if(key==0){
				     	    		select.append('<option value="" disabled selected>Select Section</option>');
				     	    		
				     	    	}
				  		 
				  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
		            	  
				  	 }); 
				   
				   $('#hostelIDCardDeleteSectionId').selectpicker('show');
			   },
			   error: function(){
				   alert('ERROR OCCURED');
			 }
			});
		});
	
	$('#getOverAllDetails').click(function(event) {
		
		if($("#overallattendanceform").valid())
			{
		
			$("#currentselectedclassid").val( $('#overAllClassId').val());
			$("#currentselectedsectionid").val( $('#overAllSectionId').val());
			$("#currentselectedacademicyearid").val( $('#overAllAcademicYearId').val());
			
		$('.loader').show();
		  var data=$("#overallattendanceform").serialize();
	    $.ajax({
			   url:ctx+'/student/studentidcardgeneration/view',
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
				    				window.location.href=ctx+'/student/studentidcardgeneration';
					        		
					        	});
		        	 }
		        	 else
		        	 {	
		        		 $('.loader').hide();
		        		 
		        		 	$("#studentIDCardGenerationDiv").empty();
		        		 	  $.each(response, function(key,value) {
		        		 		  
		        		 		  var name="";
		        		 		  if(value.student.lastName!=null)
		        		 		  {
		        		 			 name=value.student.firstName+" "+value.student.lastName;
		        		 		  }
		        		 		  else
		        		 		  {
		        		 			 name=value.student.firstName;
		        		 		  }
		        		 		  var fatherName="";
		        		 		  if(value.student.parentGuardianLastName!=null)
		        		 		  {
		        		 			  fatherName=value.student.parentGuardianFirstName+" "+value.student.parentGuardianLastName;
		        		 		  }
		        		 		  else
		        		 		  {
		        		 			  fatherName=value.student.parentGuardianFirstName;
		        		 		  }
		        		 		  var bloodgroup="-";
		        		 		  if(value.bloodGroup!=null)
		        		 		  {
		        		 			 bloodgroup=value.bloodGroup.bloodGroupName;
		        		 		  }	  
		        		 		  
		        		 		 $.date = function(dateObject) {
									    var d = new Date(dateObject);
									    var day = d.getDate();
									    var month = d.getMonth() + 1;
									    var year = d.getFullYear();
									    if (day < 10) {
									        day = "0" + day;
									    }
									    if (month < 10) {
									        month = "0" + month;
									    }
									    var date = day + "/" + month + "/" + year;

									    return date;
									};
					        	var date = $.date(value.student.birthDate);
					        	var string="Student ID Card";
					        	string=string.toUpperCase();
					        	 $("#studentIDCardGenerationDiv").append('<div class="row"  ><div style="height:450px;border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black; " class="col-lg-6"><br/><table class="table table-responsive" style="background-color:white;"><thread ><tr ><td style="text-align:left;"><img width="120px" height="100px" src="'+ ctx+value.institution.institutionLogo+'"></img></td><td style="margin-left:-150px;"><h4 ><label >'+value.institution.institutionName.toUpperCase()+'</label></h4><h5><label >'+value.institution.institutionAddressline1+','+value.institution.institutionAddressline2+','+value.institution.institutionCity+'-'+value.institution.institutionPostcode+'</label></h5></td></tr></thead><tbody></tbody></table><div  style="border-top:2px solid black;"><table class="table table-responsive"><tbody style="height:201px;"><tr><td style="text-align:center;" colspan="2"><h5><label >'+string+'</label></h5></td></tr><tr><td rowspan="6"><img width="180px" height="200px" src="'+ ctx+value.student.user.profilePicturePath+'"></img></td><td style="text-align:left;">Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+name+'</label></td></tr><tr><td style="text-align:left;">Class Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.studentClass.className+'</label></td></tr><tr><td style="text-align:left;">Section Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.section.sectionName+'</label></td></tr><tr><td style="text-align:left;">Admission No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.admissionNo+'</label></td></tr><tr><td style="text-align:center;"><img width="200px" height="40px" src="'+ ctx+value.institution.authorizedSignature+'"></img><br/>Principal</td></tr></tbody></table></div></div><div class="col-lg-6" style="height:450px;border-top:2px solid black;border-left:2px solid black;border-bottom:2px solid black;border-right:2px solid black;"><br/><table class="table table-responsive"><tbody><tr><td style="text-align:left;">Date of Birth&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+date+'</label></td></tr><tr><td style="text-align:left;">Blood Group&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+bloodgroup+'</label></td></tr><tr><td style="text-align:left;">Father Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+fatherName+'</label></td></tr><tr><td style="text-align:left;">Address&nbsp;&nbsp;:&nbsp;&nbsp;<label>'+value.student.addressLine1+','+value.student.addressLine2+'</label></td><tr><td style="text-align:left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style="text-align:right;">'+value.student.city+'-'+value.student.postcode+'</label></td></tr><tr><td style="text-align:left;">Student Contact No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.student.contact+'</label></td></tr><tr><td style="text-align:left;">Parent Contact No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.student.parentContact+'</label></td></tr><tr><td><img width="250px" height="50px" src="'+ ctx+value.barCodeImage+'"></img><br/>'+value.barCode+'</td></tr></tbody></table></div></div><br/>');
		        		 		/* $("#studentIDCardGenerationDiv").append( '<div class="col-lg-12">'+
		        		 				 '<table class="table table-responsive"><thead style="border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black; ">'+
		 			        '  <tr style="border-bottom: 2px solid black;>'+
		 			          '   <th style="font-weight: bold;border-bottom:2px solid black;"><td style="text-align:left;"><img width="100px" height="100px" src="'+ ctx+value.institutionLogo+'"></img></td><td style="text-align:left;"><h2 ><label >'+value.institutionName+'</label></h2><h4 ><label >'+value.institutionAddressLine1+','+value.institutionAddressLine2+','+value.institutionCity+'-'+value.institutionPostcode+'</label></h4></td><td style="width:600px;border-left:2px solid black"></td></th>'+
		 			           ' </tr>'+
		 			   	'</thead>'+
		 			       '  		<tbody style="height:250px;border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;">'+
	 			         '    <tr>'+
	 			   	 '	<td  style="text-align:left;width:400px;"><img width="150px" height="200px" src="'+ ctx+value.student.user.profilePicturePath+'"></img> <div style="margin-bottom: 4px;">Name:<label style="text-align:right;">'+name+'</label></div> <div style="margin-bottom: 4px;">Class Name:<label style="text-align:right;">'+value.studentClass.className+'</label></div> <div style="margin-bottom: 4px;">Section Name:<label style="text-align:right;">'+value.section.sectionName+'</label></div> <div style="margin-bottom: 4px;">Admission No:<label style="text-align:right;">'+value.admissionNo+'</label></div></td>'+
	 			   '<td  style="border-left:2px solid black;width:600px;"></td>'+
	 			   	 '   </tr>'+	
	 			 		'</tbody'+
	 				'</table></div><br/><br/>');*/
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
 	
	
	
	$('#hostelidcardpreview').click(function(event) 
			{
		
					var studentHostelIDCardManagementDetails=$("#currentselectedclassid").val()+"-"+$("#currentselectedsectionid").val()+"-"+$("#currentselectedcriteriaid").val()+"-"+$("#currentselectedacademicyearid").val()+"-"+$("#currentselectedfeestermid").val();
				  $('#hostelidcardpreview').attr("href", ctx+"/student/studenthostelidcardgeneration/preview?studentHostelIDCardManagementDetails="+studentHostelIDCardManagementDetails);
			
			});
	$('#transportidcardpreview').click(function(event) 
			{
		
					var studentTransportIDCardManagementDetails=$("#currentselectedclassid").val()+"-"+$("#currentselectedsectionid").val()+"-"+$("#currentselectedcriteriaid").val()+"-"+$("#currentselectedacademicyearid").val()+"-"+$("#currentselectedfeestermid").val();
				  $('#transportidcardpreview').attr("href", ctx+"/student/studenttransportidcardgeneration/preview?studentTransportIDCardManagementDetails="+studentTransportIDCardManagementDetails);
			
			});
	$('#preview').click(function(event) 
	{
		var studentIDCardManagementDetails=$("#currentselectedclassid").val()+"-"+$("#currentselectedsectionid").val()+"-"+$("#currentselectedacademicyearid").val();
		  $('#preview').attr("href", ctx+"/student/studentidcardgeneration/preview?studentIDCardManagementDetails="+studentIDCardManagementDetails);
	
	});
	
	
$('#transportidcardprint').click(function(event) {
		
	var studentTransportIDCardManagementDetails=$("#currentselectedclassid").val()+"-"+$("#currentselectedsectionid").val()+"-"+$("#currentselectedcriteriaid").val()+"-"+$("#currentselectedacademicyearid").val()+"-"+$("#currentselectedfeestermid").val();
	 	$("#recprint").modal('show');
		  $('#printrec').attr("href", ctx+"/student/studenttransportidcardgeneration/preview?studentTransportIDCardManagementDetails="+studentTransportIDCardManagementDetails);
		  $("#printrec").printPage();
		$("#printrec").click(function(event) {
			$('#recprint').modal('hide');
			});
	});

$('#hostelidcardprint').click(function(event) {
	
	var studentHostelIDCardManagementDetails=$("#currentselectedclassid").val()+"-"+$("#currentselectedsectionid").val()+"-"+$("#currentselectedcriteriaid").val()+"-"+$("#currentselectedacademicyearid").val()+"-"+$("#currentselectedfeestermid").val();
	 	$("#recprint").modal('show');
		  $('#printrec').attr("href", ctx+"/student/studenthostelidcardgeneration/preview?studentHostelIDCardManagementDetails="+studentHostelIDCardManagementDetails);
		  $("#printrec").printPage();
		$("#printrec").click(function(event) {
			$('#recprint').modal('hide');
			});
	});
	$('#print').click(function(event) {
		
		var studentIDCardManagementDetails=$("#currentselectedclassid").val()+"-"+$("#currentselectedsectionid").val()+"-"+$("#currentselectedacademicyearid").val();
		$("#recprint").modal('show');
		  $('#printrec').attr("href", ctx+"/student/studentidcardgeneration/preview?studentIDCardManagementDetails="+studentIDCardManagementDetails);
		  $("#printrec").printPage();
		$("#printrec").click(function(event) {
			$('#recprint').modal('hide');
			});
	});
	
$('#viewStudentHostelIDCard').click(function(event) {
		
		if($("#viewStudentHostelIDCardForm").valid())
			{
		
			$("#currentselectedclassid").val( $('#hostelIDCardViewClassId').val());
			$("#currentselectedsectionid").val( $('#hostelIDCardViewSectionId').val());
			  var criteriaId = $("#hostelidviewcriteriaId").val();
			  $("#currentselectedcriteriaid").val( $("#hostelidviewcriteriaId").val());
		  	  if(criteriaId=="academicyear")
		  	  {
		  		$("#currentselectedacademicyearid").val( $('#hostelIDCardViewAcademicYearId').val());
		  	  }
		  	  else if(criteriaId=="feescategory")
		  	  {
		  		$("#currentselectedfeestermid").val( $('#hostelIDCardViewFeesTermId').val());
			  }
			
			
			
		$('.loader').show();
		  var data=$("#viewStudentHostelIDCardForm").serialize();
	    $.ajax({
			   url:ctx+'/student/studenthostelidcardgeneration/view',
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
				    				window.location.href=ctx+'/student/studentidcardgeneration';
					        		
					        	});
		        	 }
		        	 else
		        	 {	
		        		 $('.loader').hide();
		        		 
		        		 	$("#studentHostelIDCardViewDiv").empty();
		        		 	  $.each(response, function(key,value) {
		        		 		  
		        		 		  var name="";
		        		 		  if(value.student.lastName!=null)
		        		 		  {
		        		 			 name=value.student.firstName+" "+value.student.lastName;
		        		 		  }
		        		 		  else
		        		 		  {
		        		 			 name=value.student.firstName;
		        		 		  }
		        		 		  var fatherName="";
		        		 		  if(value.student.parentGuardianLastName!=null)
		        		 		  {
		        		 			  fatherName=value.student.parentGuardianFirstName+" "+value.student.parentGuardianLastName;
		        		 		  }
		        		 		  else
		        		 		  {
		        		 			  fatherName=value.student.parentGuardianFirstName;
		        		 		  }
		        		 		  var bloodgroup="-";
		        		 		  if(value.student.bloodGroup!=null)
		        		 		  {
		        		 			 bloodgroup=value.student.bloodGroup.bloodGroupName;
		        		 		  }	  
		        		 		  
		        		 		 $.date = function(dateObject) {
									    var d = new Date(dateObject);
									    var day = d.getDate();
									    var month = d.getMonth() + 1;
									    var year = d.getFullYear();
									    if (day < 10) {
									        day = "0" + day;
									    }
									    if (month < 10) {
									        month = "0" + month;
									    }
									    var date = day + "/" + month + "/" + year;

									    return date;
									};
					        	var date = $.date(value.student.birthDate);
		        		 		/* $("#studentTransportIDCardViewDiv").append('<div class="row"  ><div style="height:450px;border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black; " class="col-lg-6"><br/><table class="table table-responsive" style="background-color:white;"><thread ><tr ><td style="text-align:left;"><img width="120px" height="100px" src="'+ ctx+value.institution.institutionLogo+'"></img></td><td style="margin-left:-150px;"><h2 ><label >'+value.institution.institutionName+'</label></h2><h4 ><label >'+value.institution.institutionAddressline1+','+value.institution.institutionAddressline2+','+value.institution.institutionCity+'-'+value.institution.institutionPostcode+'</label></h4></td></tr></thead><tbody></tbody></table><div  style="border-top:2px solid black;"><table class="table table-responsive"><tbody style="height:201px;"><tr><td style="text-align:center;" colspan="2"><h5><label >Student Transport ID Card</label></h5></td></tr><tr><td rowspan="6"><img width="180px" height="200px" src="'+ ctx+value.student.user.profilePicturePath+'"></img></td><td style="text-align:left;">Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+name+'</label></td></tr><tr><td style="text-align:left;">Class Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.studentClass.className+'</label></td></tr><tr><td style="text-align:left;">Section Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.section.sectionName+'</label></td></tr><tr><td style="text-align:left;">Admission No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.student.admissionNo+'</label></td></tr><tr><td style="text-align:center;"><img width="200px" height="40px" src="'+ ctx+value.institution.authorizedSignature+'"></img><br/>Principal</td></tr></tbody></table></div></div><div class="col-lg-6" style="height:450px;border-top:2px solid black;border-left:2px solid black;border-bottom:2px solid black;border-right:2px solid black;"><br/><table class="table table-responsive"><tbody><tr><td style="text-align:left;">Date of Birth&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+date+'</label></td></tr><tr><td style="text-align:left;">Blood Group&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+bloodgroup+'</label></td></tr><tr><td style="text-align:left;">Father Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+fatherName+'</label></td></tr><tr><td style="text-align:left;">Address&nbsp;&nbsp;:&nbsp;&nbsp;<label>'+value.student.addressLine1+','+value.student.addressLine2+'</label></td><tr><td style="text-align:left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style="text-align:right;">'+value.student.city+'-'+value.student.postcode+'</label></td></tr><tr><td style="text-align:left;">Student Contact No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.student.contact+'</label></td></tr><tr><td style="text-align:left;">Parent Contact No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.student.parentContact+'</label></td></tr><tr><td><img width="250px" height="50px" src="'+ ctx+value.barCodeImage+'"></img><br/>'+value.barCode+'</td></tr></tbody></table></div></div><br/>');
		        		 		*/
					        	var string="Student Hostel ID Card";
					        	string=string.toUpperCase();
					        	$("#studentHostelIDCardViewDiv").append('<div class="row"  ><div style="height:450px;border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black; " class="col-lg-6"><br/><table class="table table-responsive" style="background-color:white;"><thread ><tr ><td style="text-align:left;"><img width="120px" height="100px" src="'+ ctx+value.institution.institutionLogo+'"></img></td><td style="margin-left:-150px;"><h4 ><label >'+value.institution.institutionName.toUpperCase()+'</label></h4><h5 ><label >'+value.institution.institutionAddressline1+','+value.institution.institutionAddressline2+','+value.institution.institutionCity+'-'+value.institution.institutionPostcode+'</label></h5></td></tr></thead><tbody></tbody></table><div  style="border-top:2px solid black;"><table class="table table-responsive"><tbody style="height:201px;"><tr><td style="text-align:center;" colspan="2"><h5><label >'+string+'</label></h5></td></tr><tr><td rowspan="6"><img width="180px" height="200px" src="'+ ctx+value.student.user.profilePicturePath+'"></img></td><td style="text-align:left;">Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+name+'</label></td></tr><tr><td style="text-align:left;">Class Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.studentClass.className+'</label></td></tr><tr><td style="text-align:left;">Section Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.section.sectionName+'</label></td></tr><tr><td style="text-align:left;">Admission No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.student.admissionNo+'</label></td></tr><tr><td style="text-align:center;"><img width="200px" height="40px" src="'+ ctx+value.institution.authorizedSignature+'"></img><br/>Authorized Signature</td></tr></tbody></table></div></div><div class="col-lg-6" style="height:450px;border-top:2px solid black;border-left:2px solid black;border-bottom:2px solid black;border-right:2px solid black;"><br/><table class="table table-responsive"><tbody><tr><td><img width="150px" height="150px" src="'+ ctx+'/resources/themes/images/hostel.png"></img></td></tr><tr><td style="text-align:left;">Address&nbsp;&nbsp;:&nbsp;&nbsp;<label>'+value.student.addressLine1+','+value.student.addressLine2+'</label></td><tr><td style="text-align:left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style="text-align:right;">'+value.student.city+'-'+value.student.postcode+'</label></td></tr><tr><td style="text-align:left;">Student Contact No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.student.contact+'</label></td></tr><tr><td style="text-align:left;">Parent Contact No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.student.parentContact+'</label></td></tr><tr><td><img width="250px" height="50px" src="'+ ctx+value.barCodeImage+'"></img><br/>'+value.barCode+'</td></tr></tbody></table></div></div><br/>');
		        		 		
		        		 	  });
		        		 	
					   $("#viewstudenthostelidcarddetails").show();
		        	 }
			   },
			   error: function(){
				   alert('ERROR OCCURED');
			 }
			});
			}
		});
	
$('#viewStudentTrasportIDCard').click(function(event) {
		
		if($("#viewStudentTrasportIDCardForm").valid())
			{
		
			$("#currentselectedclassid").val( $('#transportIDCardViewClassId').val());
			$("#currentselectedsectionid").val( $('#transportIDCardViewSectionId').val());
			  var criteriaId = $("#transportidviewcriteriaId").val();
			  $("#currentselectedcriteriaid").val( $("#transportidviewcriteriaId").val());
		  	  if(criteriaId=="academicyear")
		  	  {
		  		$("#currentselectedacademicyearid").val( $('#transportIDCardViewAcademicYearId').val());
		  	  }
		  	  else if(criteriaId=="feescategory")
		  	  {
		  		$("#currentselectedfeestermid").val( $('#transportIDCardViewFeesTermId').val());
			  }
			
			
			
		$('.loader').show();
		  var data=$("#viewStudentTrasportIDCardForm").serialize();
	    $.ajax({
			   url:ctx+'/student/studenttransportidcardgeneration/view',
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
				    				window.location.href=ctx+'/student/studentidcardgeneration';
					        		
					        	});
		        	 }
		        	 else
		        	 {	
		        		 $('.loader').hide();
		        		 
		        		 	$("#studentTransportIDCardViewDiv").empty();
		        		 	  $.each(response, function(key,value) {
		        		 		  
		        		 		  var name="";
		        		 		  if(value.student.lastName!=null)
		        		 		  {
		        		 			 name=value.student.firstName+" "+value.student.lastName;
		        		 		  }
		        		 		  else
		        		 		  {
		        		 			 name=value.student.firstName;
		        		 		  }
		        		 		  var fatherName="";
		        		 		  if(value.student.parentGuardianLastName!=null)
		        		 		  {
		        		 			  fatherName=value.student.parentGuardianFirstName+" "+value.student.parentGuardianLastName;
		        		 		  }
		        		 		  else
		        		 		  {
		        		 			  fatherName=value.student.parentGuardianFirstName;
		        		 		  }
		        		 		  var bloodgroup="-";
		        		 		  if(value.student.bloodGroup!=null)
		        		 		  {
		        		 			 bloodgroup=value.student.bloodGroup.bloodGroupName;
		        		 		  }	  
		        		 		  
		        		 		 $.date = function(dateObject) {
									    var d = new Date(dateObject);
									    var day = d.getDate();
									    var month = d.getMonth() + 1;
									    var year = d.getFullYear();
									    if (day < 10) {
									        day = "0" + day;
									    }
									    if (month < 10) {
									        month = "0" + month;
									    }
									    var date = day + "/" + month + "/" + year;

									    return date;
									};
					        	var date = $.date(value.student.birthDate);
		        		 		/* $("#studentTransportIDCardViewDiv").append('<div class="row"  ><div style="height:450px;border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black; " class="col-lg-6"><br/><table class="table table-responsive" style="background-color:white;"><thread ><tr ><td style="text-align:left;"><img width="120px" height="100px" src="'+ ctx+value.institution.institutionLogo+'"></img></td><td style="margin-left:-150px;"><h2 ><label >'+value.institution.institutionName+'</label></h2><h4 ><label >'+value.institution.institutionAddressline1+','+value.institution.institutionAddressline2+','+value.institution.institutionCity+'-'+value.institution.institutionPostcode+'</label></h4></td></tr></thead><tbody></tbody></table><div  style="border-top:2px solid black;"><table class="table table-responsive"><tbody style="height:201px;"><tr><td style="text-align:center;" colspan="2"><h5><label >Student Transport ID Card</label></h5></td></tr><tr><td rowspan="6"><img width="180px" height="200px" src="'+ ctx+value.student.user.profilePicturePath+'"></img></td><td style="text-align:left;">Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+name+'</label></td></tr><tr><td style="text-align:left;">Class Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.studentClass.className+'</label></td></tr><tr><td style="text-align:left;">Section Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.section.sectionName+'</label></td></tr><tr><td style="text-align:left;">Admission No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.student.admissionNo+'</label></td></tr><tr><td style="text-align:center;"><img width="200px" height="40px" src="'+ ctx+value.institution.authorizedSignature+'"></img><br/>Principal</td></tr></tbody></table></div></div><div class="col-lg-6" style="height:450px;border-top:2px solid black;border-left:2px solid black;border-bottom:2px solid black;border-right:2px solid black;"><br/><table class="table table-responsive"><tbody><tr><td style="text-align:left;">Date of Birth&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+date+'</label></td></tr><tr><td style="text-align:left;">Blood Group&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+bloodgroup+'</label></td></tr><tr><td style="text-align:left;">Father Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+fatherName+'</label></td></tr><tr><td style="text-align:left;">Address&nbsp;&nbsp;:&nbsp;&nbsp;<label>'+value.student.addressLine1+','+value.student.addressLine2+'</label></td><tr><td style="text-align:left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style="text-align:right;">'+value.student.city+'-'+value.student.postcode+'</label></td></tr><tr><td style="text-align:left;">Student Contact No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.student.contact+'</label></td></tr><tr><td style="text-align:left;">Parent Contact No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.student.parentContact+'</label></td></tr><tr><td><img width="250px" height="50px" src="'+ ctx+value.barCodeImage+'"></img><br/>'+value.barCode+'</td></tr></tbody></table></div></div><br/>');
		        		 		*/
					        	var string="Student Transport ID Card";
					        	string=string.toUpperCase();
					        	$("#studentTransportIDCardViewDiv").append('<div class="row"  ><div style="height:450px;border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black; " class="col-lg-6"><br/><table class="table table-responsive" style="background-color:white;"><thread ><tr ><td style="text-align:left;"><img width="120px" height="100px" src="'+ ctx+value.institution.institutionLogo+'"></img></td><td style="margin-left:-150px;"><h4 ><label >'+value.institution.institutionName.toUpperCase()+'</label></h4><h5 ><label >'+value.institution.institutionAddressline1+','+value.institution.institutionAddressline2+','+value.institution.institutionCity+'-'+value.institution.institutionPostcode+'</label></h5></td></tr></thead><tbody></tbody></table><div  style="border-top:2px solid black;"><table class="table table-responsive"><tbody style="height:201px;"><tr><td style="text-align:center;" colspan="2"><h5><label >'+string+'</label></h5></td></tr><tr><td rowspan="6"><img width="180px" height="200px" src="'+ ctx+value.student.user.profilePicturePath+'"></img></td><td style="text-align:left;">Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+name+'</label></td></tr><tr><td style="text-align:left;">Class Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.studentClass.className+'</label></td></tr><tr><td style="text-align:left;">Section Name&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.section.sectionName+'</label></td></tr><tr><td style="text-align:left;">Admission No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.student.admissionNo+'</label></td></tr><tr><td style="text-align:center;"><img width="200px" height="40px" src="'+ ctx+value.institution.authorizedSignature+'"></img><br/>Authorized Signature</td></tr></tbody></table></div></div><div class="col-lg-6" style="height:450px;border-top:2px solid black;border-left:2px solid black;border-bottom:2px solid black;border-right:2px solid black;"><br/><table class="table table-responsive"><tbody><tr><td><img width="150px" height="150px" src="'+ ctx+'/resources/themes/images/bus.png"></img></td></tr><tr><td style="text-align:left;">Address&nbsp;&nbsp;:&nbsp;&nbsp;<label>'+value.student.addressLine1+','+value.student.addressLine2+'</label></td><tr><td style="text-align:left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style="text-align:right;">'+value.student.city+'-'+value.student.postcode+'</label></td></tr><tr><td style="text-align:left;">Student Contact No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.student.contact+'</label></td></tr><tr><td style="text-align:left;">Parent Contact No&nbsp;&nbsp;:&nbsp;&nbsp;<label style="text-align:right;">'+value.student.parentContact+'</label></td></tr><tr><td><img width="250px" height="50px" src="'+ ctx+value.barCodeImage+'"></img><br/>'+value.barCode+'</td></tr></tbody></table></div></div><br/>');
		        		 		
		        		 	  });
		        		 	
					   $("#viewstudenttransportidcarddetails").show();
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
				$("#moduleattendanceform").submit();
			}
		});
$('#generateStudentTrasportIDCard').click(function(event) {
		
		if($("#generatestudenttransportidcardform").valid())
			{
				$('.loader').show();
				$("#generatestudenttransportidcardform").submit();
			}
		});
	

$('#generateStudentHostelIDCard').click(function(event) {
	
	if($("#generatestudenthostelidcardform").valid())
		{
			$('.loader').show();
			$("#generatestudenthostelidcardform").submit();
		}
	});
	
$('#getDeleteIDCardDetails').click(function(event) {
		
		if($("#deleteidcardform").valid())
			{
				$('.loader').show();
				$("#deleteidcardform").submit();
			}
		});

$('#deleteHostelIDCardDetails').click(function(event) {
	
	if($("#deletehostelidcardform").valid())
		{
			$('.loader').show();
			$("#deletehostelidcardform").submit();
		}
	});

$('#deleteTransportIDCardDetails').click(function(event) {
	
	if($("#deletetransportidcardform").valid())
		{
			$('.loader').show();
			$("#deletetransportidcardform").submit();
		}
	});

});

function showmodulewiseattendance()
{
	document.getElementById('OpenModuleAttendanceDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('OpenOverAllDiv').style.display="none";
	document.getElementById('OpenDeleteIDCardDiv').style.display="none";
}
function showmonthwiseattendance()
{
	document.getElementById('OpenModuleAttendanceDiv').style.display="none";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('OpenOverAllDiv').style.display="block";
	document.getElementById('OpenDeleteIDCardDiv').style.display="none";
}

function showdeleteidcard()
{
	document.getElementById('OpenDeleteIDCardDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('OpenOverAllDiv').style.display="none";
	document.getElementById('OpenModuleAttendanceDiv').style.display="none";
}

function showtransportidcardgeneration()
{
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('showtransportidgenerateDiv').style.display="block";
}
function showtransportidcardview()
{
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('showtransportidviewDiv').style.display="block";
}
function showtransportidcarddelete()
{
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('showtransportiddeleteDiv').style.display="block";
}
function showhostelidcardgeneration()
{
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('showhostelidgenerateDiv').style.display="block";
}
function showhostelidcardview()
{
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('showhostelidviewDiv').style.display="block";
}
function showhostelidcarddelete()
{
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('showhosteliddeleteDiv').style.display="block";
}
