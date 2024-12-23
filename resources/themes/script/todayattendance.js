	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

$(document).ready(function(){

	myalert();
	 setInterval(function() {
			myalert();
		}, 60000);
	function myalert()
	{
		
		
		$("#studentAttendancePercentage,#tstaffAttendancePercentage,#ostaffAttendancePercentage").empty();
		$(".studentAttendancePercentage").append('<div id="studentAttendancePercentage" class="circliful-chart m-b-30 circliful-chart1" data-dimension="200"  data-text="" data-info="Student" data-width="20" data-fontsize="24" data-percent="" data-fgcolor="#5fbeaa" data-bgcolor="#ebeff2" data-fill="#f4f8fb"></div>');
        $(".tstaffAttendancePercentage").append('<div id="tstaffAttendancePercentage" class="circliful-chart m-b-30 circliful-chart2" data-dimension="200" data-text="" data-info="Teaching Staff" data-width="30" data-fontsize="24" data-percent="" data-fgcolor="#7266ba" data-bgcolor="#ebeff2"></div>');
        $(".ostaffAttendancePercentage").append('<div id="ostaffAttendancePercentage" class="circliful-chart m-b-30 circliful-chart3" data-startdegree="90" data-dimension="200" data-text="" data-info="Non-Teaching Staff" data-width="30" data-fontsize="24" data-percent="" data-fgcolor="#61a9dc" data-bgcolor="#ebeff2"></div>');
		
        var institutionId=$("#institutionId").val();
		$.ajax({
			   url:ctx+'/dashboard/studentAttendanceInPercentage/today',
			   type:'GET',
			   data:{institutionId:institutionId},
			   async:false,
			   dataType:'JSON',
			   success: function(response){
				   

				   $("#studentAttendancePercentage").attr("data-percent",response.replace(/[^0-9\.]/g,''));
				   $("#studentAttendancePercentage").attr("data-text",response);
				   
				   $('.circliful-chart1').circliful();
				  
			   },
			   error: function(){
				   alert('ERROR OCCURED');
				   window.location.href=ctx+"/home";
		       }
			});
		
		$.ajax({
			   url:ctx+'/dashboard/teachingStaffAttendanceInPercentage/today',
			   type:'GET',
			   data:{institutionId:institutionId},
			   async:false,
			   dataType:'JSON',
			   success: function(response){
				  
				   $("#tstaffAttendancePercentage").attr("data-percent",response.replace(/[^0-9\.]/g,''));
				   $("#tstaffAttendancePercentage").attr("data-text",response);
				   $('.circliful-chart2').circliful();

			   },
			   error: function(){
				   alert('ERROR OCCURED');
				   window.location.href=ctx+"/home";
		       }
			});
		
		$.ajax({
			   url:ctx+'/dashboard/otherStaffAttendanceInPercentage/today',
			   type:'GET',
			   data:{institutionId:institutionId},
			   async:false,
			   dataType:'JSON',
			   success: function(response){
	
				   $("#ostaffAttendancePercentage").attr("data-percent",response.replace(/[^0-9\.]/g,''));
				   $("#ostaffAttendancePercentage").attr("data-text",response);
				   $('.circliful-chart3').circliful();

			   },
			   error: function(){
				   alert('ERROR OCCURED');
				   window.location.href=ctx+"/home";
		       }
			});
		
		
		
	}
});

