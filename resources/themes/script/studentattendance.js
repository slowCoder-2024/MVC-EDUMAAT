$(document).ready(function() {
	
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	/*  $('body').on('focus',".timedropper", function(){
			$(this).timeDropper({
				format:'HH:mm',
				autoswitch:true
			});
		 });*/
	 $('#uploadStudentAttendance').click(function(event){
		 if($("#studentAttendanceUploadForm").valid())
			 {
			 $('.loader').show();
			 	$("#studentAttendanceUploadForm").submit();
			 }
	 });
	  $( "#attendanceTime" ).timeDropper(
			  {
				format:'HH:mm',
				autoswitch:true  
			  });
		var t = $('#studentAttendanceList').DataTable({"paging":false});
		   $('#getstudentlist').click(function(){
				 if($('#studentAttendanceForm').valid())
				 {
					var data=$("#studentAttendanceForm").serialize();
					 $('.loader').show();
    				$.get(ctx+"/student/retrieveStudentList",data,function(data) {
    					 $('.loader').hide();
    				
    					t.clear().draw();
    					var studentAttendanceTypeList=null;
    					
    					var selectedDate=$("#attendanceDate").val();
    					
 	      				var c = selectedDate.split("/");
 	      				var check = new Date(c[2], parseInt(c[1])-1, c[0]);
 	      				var studentAdmissionNumberList=[];
 	      				    $.each(data, function(key,value) 
    					 		{
    							
    							$.each(value.studentLeaveRequistions, function(key1,value1) 
    	    					 		{
    								if(value1.approvalStatus=="Approved")
    									{
    										
    				 	      				var d1 = value1.studentLeaveStartDate.split("-");
    				 	      				var d2 = value1.studentLeaveEndDate.split("-");
    				 	      				var from = new Date(d1[0], parseInt(d1[1])-1, d1[2]);  
    				 	      				var to   = new Date(d2[0], parseInt(d2[1])-1, d2[2]);
    				 	      				if(check >= from && check <= to)
    										{
    				 	      					studentAdmissionNumberList.push(value.studentId);
    										}
    									}
    	    					 		});
    							var firstName="";
    							var lastName="";
    							if(value.lastName)
    								{
    								lastName=value.lastName;
    								}
    							if(studentAdmissionNumberList.includes(value.studentId))
    								{
    					 		 t.row.add( [   value.studentId ,
    									            value.firstName+' '+lastName ,
    									             '  <div class="pure-radiobutton radio-'+value.studentId+'" ></div>','<div class="radio radio-warning" ><input type="radio" name="groupAttendance'+value.studentId+'" value="HalfDay"><label>Half Day</label>&nbsp;&nbsp;<input type="radio" checked="checked" name="groupAttendance'+value.studentId+'" value="FullDay"> <label>Full Day</label></div>'] ).draw( false );
    					 				studentAttendanceTypeList=appendStudentAttendanceType();
    					 				$.each(studentAttendanceTypeList,function(key1,studentAttendanceType){
    					 						if(studentAttendanceType.studentAttendaceTypeId==2)
    	    					 				{
    	    					 					$(".radio-"+value.studentId+"").append('<input type="radio" class="radio"  name="group'+value.studentId+'" checked="checked" value="'+studentAttendanceType.studentAttendaceTypeId+'" id="group'+value.studentId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"><label  for="group'+value.studentId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> '+studentAttendanceType.studentAttendanceTypeName+'</label>');
    	    					 				}
    	    					 				else
    	    					 				{
    	    					 					$(".radio-"+value.studentId+"").append('<input type="radio" class="radio" name="group'+value.studentId+'" value="'+studentAttendanceType.studentAttendaceTypeId+'" id="group'+value.studentId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> <label for="group'+value.studentId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> '+studentAttendanceType.studentAttendanceTypeName+'</label>');
    	    					 				}
    	    					 				 });
    								}else
    								{
    									 t.row.add( [   value.studentId ,
        									            value.firstName+' '+lastName ,
        									             '  <div class="pure-radiobutton radio-'+value.studentId+'" ></div>','<div class="radio radio-warning" ><input type="radio" name="groupAttendance'+value.studentId+'" value="HalfDay"><label>Half Day</label>&nbsp;&nbsp;<input type="radio" checked="checked" name="groupAttendance'+value.studentId+'" value="FullDay"> <label>Full Day</label></div>'] ).draw( false );
        					 				studentAttendanceTypeList=appendStudentAttendanceType();
        					 				$.each(studentAttendanceTypeList,function(key1,studentAttendanceType){
        					 						if(studentAttendanceType.defaultSelected==true)
        	    					 				{
        	    					 					$(".radio-"+value.studentId+"").append('<input type="radio" class="radio"  name="group'+value.studentId+'" checked="checked" value="'+studentAttendanceType.studentAttendaceTypeId+'" id="group'+value.studentId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"><label  for="group'+value.studentId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> '+studentAttendanceType.studentAttendanceTypeName+'</label>');
        	    					 				}
        	    					 				else
        	    					 				{
        	    					 					$(".radio-"+value.studentId+"").append('<input type="radio" class="radio" name="group'+value.studentId+'" value="'+studentAttendanceType.studentAttendaceTypeId+'" id="group'+value.studentId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> <label for="group'+value.studentId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> '+studentAttendanceType.studentAttendanceTypeName+'</label>');
        	    					 				}
        	    					 				 });
    								}
    					 		});
 	      				    
 	      				    	if(studentAdmissionNumberList.length>0)
 	      				    	{
 	      				 edumaatAlert({
			    			  title: "Info !",
			    			  text:"Today Leave Requisition Applied Student Id List "+studentAdmissionNumberList,
			    			  type: "info",
			    			  confirmButtonText: "Cool"
			    			});
 	      				    	}
    					/*  $("#presentabsent-select-all").attr('checked', true);
    					   $(".radio").attr('checked', true); // Deprecated
    					  // $(".case").prop('checked', true);
    					 var rows = t.rows({ 'search': 'applied' }).nodes();
 					      $('.radio', rows).attr('checked', true); */
    					 $("#tableview").show();
    						
             });
				 }	
    				
	   });
			   $('#section').change(function(event) {
				   $("#tableview").hide();
			   });
			   
			   
	 $('#class').change(function(event) {
		var classId = $("#class").val();
	  	    $.ajax({
				   url:ctx+'/classSection/'+classId,
				   type:'GET',
				   success: function(response){
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
			        		  select.append('<option value="" disabled selected>Select Section</option>');
			        	  }
					   $.each(response, function(key,value) {
					  		 if(key==0){
					     	    		select.append('<option value="" disabled selected>Select Section</option>');
					     	    	}
					  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
					  	 }); 
					   $('#section').selectpicker('show');
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/studentattendance";
			       }
				
   		});

	  		       
	 });
	 
	   
		$( "#attendanceDate" ).dateDropper({
			minYear:'1930',
			init_animation:'bounce',
			dropWidth:'500'
		});
		
	 function appendStudentAttendanceType(){
		 
		 $.ajax({
			   url:ctx+'/studentattendance/type',
			   async: false,
			   type:'GET',
			   success: function(response){
				   studentAttendanceTypeList=response;
				},
			   error: function(){
				   alert('ERROR OCCURED');
				   window.location.href=ctx+"/studentattendance";
		       }
			
		});
		 
		 return studentAttendanceTypeList;
    }
	 
	 
	 
	 $('#updateStudentAttendance').click(function(event){
	
		  var attendancedetails= [];
		
      	
		 var table = document.getElementById('studentAttendanceList'), 
		    rows = table.getElementsByTagName('tr'),
		    i, j, cells, customerId,customerName,attendance,dayattendancetype;

		for (i = 0, j = rows.length; i < j; ++i) {
		    cells = rows[i].getElementsByTagName('td');
		    if (!cells.length) {
		        continue;
		    }
		
		    customerId = cells[0].innerHTML;
		    customerName = cells[1].innerHTML;
		   attendance = $('input[name=group'+customerId+']:checked').val();
		   dayattendancetype=$('input[name=groupAttendance'+customerId+']:checked').val();
		    attendancedetails.push(customerId+"-"+attendance+"-"+dayattendancetype);
		 
		}
		   $("#attendanceStudentId").val(attendancedetails);
		   $('#updateStudentAttendanceConfirmation').modal('show');
			  $('#updateStudentAttendanceConfirm').click(function(){
				  $('.loader').show();
				 $('#studentAttendanceForm').submit();
				 // window.location.href=ctx+"/studentattendance";
			  });
	 });
	 
	 
  });


function getDaysInFromDateAndToDate(fromDate,toDate)
{
	var start = fromDate;
   var end = toDate;
   var currentDate = new Date(start);
   var between = [];
while (currentDate <= end) {
	var currentdate1 = new Date(currentDate); 
    var datetime = currentdate1.getDate() + "-"
                + (currentdate1.getMonth()+1)  + "-" 
                +  currentdate1.getFullYear();
    between.push(datetime);
    currentDate.setDate(currentDate.getDate() + 1);
}	
return between;

}
function changeFormat(month) 
{
	var changeMonthFormat;
 if(month==1)
 {
	 changeMonthFormat="01";
 }
 else if(month==2)
 {
	 changeMonthFormat="02";
 }
 else if(month==3)
 {
	 changeMonthFormat="03";
 }
 else if(month==4)
 {
	 changeMonthFormat="04";
 }
 else if(month==5)
 {
	 changeMonthFormat="05";
 }
 else if(month==6)
 {
	 changeMonthFormat="06";
 }
 else if(month==7)
 {
	 changeMonthFormat="07";
 }
 else if(month==8)
 {
	 changeMonthFormat="08";
 }
 else if(month==9)
 {
	 changeMonthFormat="09";
 }
 
return changeMonthFormat;
}

