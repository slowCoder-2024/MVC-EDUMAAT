var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
var jsonData;
 $(document).ready(function() {
	 
	 $("#getdetailsinupload").click(function(){
		 
		 
		 if($("#markorgradeuploaddetailsform").valid()){
			 
			 
			 $(".loader").show();
			
			 
		 var classId = $("#class").val();
		 var sectionId = $("#section").val();
	 $.ajax({
		   url:ctx+'/exam/classAndSection',
		   type:'GET',
		   data:{classId:classId,sectionId:sectionId},
		   success: function(response){
			   $(".loader").hide();
			   $("#markorgradeuploaddetailsform").trigger('reset'); 
			   jsonData=response;
			   
			   if(response.length>0){
			   
				   $("#showMarksUploadDiv").show();
			   var item = response[0];
			   if(item.lastName!=null){
		    		name=item.firstName+' '+item.lastName;
		    	}else{
		    		name=item.firstName;
		    	}
			   $("#studentId").val(item.studentId);
			   $("#classId").val(item.studentClass.classId);
			   $("#sectionId").val(item.section.sectionId);
			    $("#studentName").text(name);
			    $("#studentAdmissionNo").text(item.admissionNo);
			    $("#studentRollNo").text(item.rollNo);
			    $("#studentDateOfBirth").text(item.birthDate);
			    $("#studentGender").text(item.sex);
			    $("#studentEmail").text(item.email);
			    $("#studentPhoneNumber").text(item.contact);
			    $("#joinedAcademicYear").text(item.joinedAcademicYear.academicYearTitle);
			    $("#studentStatus").text(item.studentStatus.statusTitle);
			    
			    $("#studentPhoto").attr("src",ctx+item.user.profilePicturePath);
			   }
			   else{
				   
				   edumaatAlert({
						  title: 'warning',
						  type:'warning',
						  text: 'Student Not Found '
						}).then(
						  function () {
							  window.location.href = ctx+"/exam";
						  }
						 
						)
				   
			   }
		   }, error: function(){
			   edumaatAlert({
	        		  title: 'Error!',
	        		  text: 'Do you want to continue',
	        		  type: 'error',
	        		}).then(
	        	       function(){
	        	    	   window.location.href = ctx+"/exam";
	        	    	   
	        	       }		
	        		)
	       }
	 });
		 }
 });
	 
	 var clickIndex = 0;
	 $('#detailsbackward').click(function() {
         $('#detailsforward').removeAttr('disabled');
		 $('#detailsbackward').attr('disabled', (clickIndex==1));
	     if(clickIndex >=0) {
	         clickIndex -= 1;
	     }
	     get(clickIndex);
	 });
	 $('#detailsforward').click(function() {
		 $('#detailsbackward').removeAttr('disabled');
		 $('#detailsforward').attr('disabled', (clickIndex==jsonData.length-1));
	     get(clickIndex);
	     clickIndex++;
	 }); 
	 
 });
 function get(i) {	
	    var item = jsonData[i];
	    
	    if(item.lastName!=null){
    		name=item.firstName+' '+item.lastName;
    	}else{
    		name=item.firstName;
    	}
	    $("#studentId").val(item.studentId);
	    $("#classId").val(item.studentClass.classId);
		   $("#sectionId").val(item.section.sectionId);
	    $("#studentName").text(name);
	    $("#studentAdmissionNo").text(item.admissionNo);
	    $("#studentRollNo").text(item.rollNo);
	    $("#studentDateOfBirth").text(item.birthDate);
	    $("#studentGender").text(item.sex);
	    $("#studentEmail").text(item.email);
	    $("#studentPhoneNumber").text(item.contact);
	    $("#joinedAcademicYear").text(item.joinedAcademicYear.academicYearTitle);
	    $("#studentStatus").text(item.studentStatus.statusTitle);
	    
	    $("#studentPhoto").attr("src",ctx+item.user.profilePicturePath);
	    
	    
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	}