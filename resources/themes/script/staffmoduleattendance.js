var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2)); 

$(document).ready(function(){
	
	  $( "#attendanceTime" ).timeDropper(
			  {
				format:'HH:mm',
				autoswitch:true  
			  });
	$('#staffModuleList').DataTable();
	 $('#staffModuleList').on( 'click', 'tr td a#edit', function () {
		  
			var classSectionModuleId = $(this).attr('data-id');
		  $("#classSectionModuleId").val(classSectionModuleId);
		  $('.loader').show();
		    $.ajax({
		    	  url:ctx+'/student/classsection/'+classSectionModuleId,
				   type:'GET',
				   success: function(response){
					   $('#saffmoduletableview').hide();
					   $('#tableview').show();
					   
					    var t = $('#staffModuleAttendanceList').DataTable({"paging": false});
						t.clear().draw();
						var studentAttendanceTypeList=null;
						
						$.each(response, function(key,value) 
						 		{
							var count=key+1;
							var lastName="";
							if(value.lastName && value.lastName!=null)
							{
								lastName=value.lastName;
							}
						 			 t.row.add( [
										            value.studentId ,
										            value.firstName+' '+lastName ,
										   '  <div class="pure-radiobutton radio-'+ value.studentId+'" >'+
						                '   </div>'] ).draw( false );
		 				studentAttendanceTypeList=appendStudentAttendanceType();
		 				$.each(studentAttendanceTypeList,function(key1,studentAttendanceType){
		 				if(studentAttendanceType.defaultSelected==true){
		 					$(".radio-"+ value.studentId+"").append('<input type="radio" class="radio"  name="group'+ value.studentId+'" checked="checked" value="'+studentAttendanceType.studentAttendaceTypeId+'" id="group'+ value.studentId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"><label  for="group'+ value.studentId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> '+studentAttendanceType.studentAttendanceTypeName+'</label>   ');
		 				}else{
		 					$(".radio-"+ value.studentId+"").append('<input type="radio" class="radio" name="group'+ value.studentId+'" value="'+studentAttendanceType.studentAttendaceTypeId+'" id="group'+ value.studentId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> <label for="group'+ value.studentId+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> '+studentAttendanceType.studentAttendanceTypeName+'</label>  ');
		 				}
		 				 });
						 			
						 			
						 		});
						
						  $('.loader').hide();
							 
				   }
		    });
		    
		 
	 });
	 
	 $('#staffModuleList').on( 'click', 'tr td a#delete', function () {
		  
			var classSectionModuleId = $(this).attr('data-id');
		
		    $.ajax({
		    	  url:ctx+'/classSection/classSectionModuleDetails',
				   type:'GET',
				   data:{classSectionModuleId:classSectionModuleId},
				   success: function(response){
					  
					   
					    var t = $('#timetableviewlist').DataTable();
						t.clear().draw();
						var studentAttendanceTypeList=null;
					
							$.each(response.module.timeTableGeneratorHours, function(key1,value1) 
							 		{
								 t.row.add( [
									          
									            response.classSection.classSection.className,
									            response.classSection.sectionClass.sectionName,
									            response.module.moduleCode ,
									            response.module.moduleName,
									            value1.timeTableGeneratorDays.timeTableGeneratorDayName,
									            value1.hourTitle]
									 ).draw( false );
									
						 		});
				   }
		    });
	 });
	/*$('#classSectionModuleId').change(function(){
		var classSectionModuleId=$(this).val();
		 $.ajax({
			   url:ctx+'/student/classsection/'+classSectionModuleId,
			   type:'GET',
			   success: function(response){
				   $('#tableview').show();
				   
				    var t = $('#staffModuleAttendanceList').DataTable();
					t.clear().draw();
					var studentAttendanceTypeList=null;
					
					$.each(response, function(key,value) 
					 		{
						var count=key+1;
					 			 t.row.add( [
									            value.studentId ,
									            value.firstName+' '+value.lastName ,
									   '  <div class="pure-radiobutton radio-'+count+'" >'+
					                '   </div>'] ).draw( false );
	 				studentAttendanceTypeList=appendStudentAttendanceType();
	 				$.each(studentAttendanceTypeList,function(key1,studentAttendanceType){
	 				if(studentAttendanceType.defaultSelected==true){
	 					$(".radio-"+count+"").append('<input type="radio" class="radio"  name="group'+count+'" checked="checked" value="'+studentAttendanceType.studentAttendaceTypeId+'" id="group'+count+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"><label  for="group'+count+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> '+studentAttendanceType.studentAttendanceTypeName+'</label>   ');
	 				}else{
	 					$(".radio-"+count+"").append('<input type="radio" class="radio" name="group'+count+'" value="'+studentAttendanceType.studentAttendaceTypeId+'" id="group'+count+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> <label for="group'+count+'radio-'+studentAttendanceType.studentAttendaceTypeId+'"> '+studentAttendanceType.studentAttendanceTypeName+'</label>  ');
	 				}
	 				 });
					 			
					 			
					 		});
					
			   },
			   error: function(){
				   alert('ERROR OCCURED');
				   window.location.href=ctx+"/studentattendance";
		       }
			
		});
		 
	}); */
		 $('#updateStaffModuleAttendance').click(function(event)
				 {
				
			 if($('#staffModuleAttendanceForm').valid()){
			 
			 var attendancedetails= [];
			
	      	
			 var table = document.getElementById('staffModuleAttendanceList'), 
			    rows = table.getElementsByTagName('tr'),
			    i, j, cells, studentId,attendance;

			 	for (i = 0, j = rows.length; i < j; ++i) {
			    cells = rows[i].getElementsByTagName('td');
			    if (!cells.length) {
			        continue;
			    }
			    
			    studentId = cells[0].innerHTML;
			    attendance = $('input[name=group'+studentId+']:checked').val();
			     attendancedetails.push(studentId+"-"+attendance);
			 	}
				
			  $("#studentAndAttendanceIds").val(attendancedetails);
			   $('#updateStaffModuleAttendanceConfirmation').modal('show');
				  $('#updateStaffModuleAttendanceConfirm').click(function(){
					  $('.loader').show();
					  $('#staffModuleAttendanceForm').submit();
				  });
			 }
		 });
	
	
	
		 $('.back').click(function(){
			 document.getElementById('staffmoduletableview').style.display="block";
				document.getElementById('tableview').style.display="none";
				document.getElementById('tabletableview').style.display="none";
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
function showdiv()
{
	if(document.getElementById('tableview').style.display=="none"){
		document.getElementById('tableview').style.display="block";
		document.getElementById('staffmoduletableview').style.display="none";
		document.getElementById('tabletableview').style.display="none";
		}
	else{
		document.getElementById('tableview').style.display="none";
		document.getElementById('staffmoduletableview').style.display="block";
		document.getElementById('tabletableview').style.display="none";
	}
}

function showeditdiv()
{
	document.getElementById('staffmoduletableview').style.display="none";
	document.getElementById('tableview').style.display="none";
	document.getElementById('tabletableview').style.display="block";
}