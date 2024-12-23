	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

$(document).ready(function(){
	mytimetable();
	   setInterval(function() {
			mytimetable();
		}, 60000);
	
	   
	   $('#studentAcademicYearList').change(function(event){
		   var academicYear=$("#studentAcademicYearList").val();
		   	$.ajax({
		   		   url:ctx+'/dashboard/studentAppraisalList',
		   		   type:'GET',
		   		  data:{academicYear:academicYear},
		   		   success: function(response){
		   			   
		   			if(response.length>0)
		   			{
		   				$("#studentPerformanceImage").hide();
		   				$("#visibility").empty();
		   				$("#visibility").append('<div id="student-morris-bar-stacked" style="height: 300px;"></div>');
		   			var totalrelationshipRating=0;
		   			var totalattitudeRating=0;
		   			var totalacademicRating=0;
		   			var totalinitiativeRating=0;
		   			var totalcreativityRating=0;
		   			var totalpunctualityRating=0;
		   			var totalsportsAndSocialRating=0;
		   			var count=0;
		   			  $.each(response, function(key,value) 
			        			{ 
		   				  			count=count+1;
		   				  			if(value.relationshipRating!=null)
		   				  	  		{
		   				  	  			totalrelationshipRating=parseFloat(totalrelationshipRating)+parseFloat(value.relationshipRating);
		   				  	  		}
		   				  			if(value.attitudeRating!=null)
		   				  	  		{
		   				  	  			totalattitudeRating=parseFloat(totalattitudeRating)+parseFloat(value.attitudeRating);
		   				  	  		}
		   				  			if(value.academicRating!=null)
		   				  	  		{
		   				  				totalacademicRating=parseFloat(totalacademicRating)+parseFloat(value.academicRating);
		   				  	  		}
		   				  	  		if(value.initiativeRating!=null)
		   				  	  		{
		   				  	  			totalinitiativeRating=parseFloat(totalinitiativeRating)+parseFloat(value.initiativeRating);
		   				  	  		}
		   				  	  		if(value.creativityRating!=null)
		   				  	  		{
		   				  	  			totalcreativityRating=parseFloat(totalcreativityRating)+parseFloat(value.creativityRating);
		   				  	  		}
		   				  	  		if(value.punctualityRating!=null)
		   				  	  		{
		   				  	  			totalpunctualityRating=parseFloat(totalpunctualityRating)+parseFloat(value.punctualityRating);
		   				  	  		}
		   				  	  		if(value.sportsAndSocialRating!=null)
		   				  	  		{
		   				  	  			totalsportsAndSocialRating=parseFloat(totalsportsAndSocialRating)+parseFloat(value.sportsAndSocialRating);
		   				  	  		}
		   				
			        			});
		   			
		   			count=count*5;
		   			

	   				var array=[];
	   				array.push({y:"Relationship",a:totalrelationshipRating,b:count});
	   				array.push({y:"Attitude",a:totalattitudeRating,b:count});
	   				array.push({y:"Academic",a:totalacademicRating,b:count});
	   				array.push({y:"Initiative",a:totalinitiativeRating,b:count});
	   				array.push({y:"Creativity",a:totalcreativityRating,b:count});
	   				array.push({y:"Punctuality",a:totalpunctualityRating,b:count});
	   				array.push({y:"SportsAndSocial",a:totalsportsAndSocialRating,b:count});
		   		
		   				
		   				!function($) {
		   				    "use strict";

		   				    var MorrisCharts = function() {};
		   				    //creates Stacked chart
		   				    MorrisCharts.prototype.createStackedChart  = function(element, data, xkey, ykeys, labels, lineColors) {
		   				        Morris.Bar({
		   				            element: element,
		   				            data: data,
		   				            xkey: xkey,
		   				            ykeys: ykeys,
		   				            stacked: true,
		   				            labels: labels,
		   				            hideHover: 'auto',
		   				            resize: true, //defaulted to true
		   				            gridLineColor: '#eeeeee',
		   				            barColors: lineColors
		   				        });
		   				    },
		   				      MorrisCharts.prototype.init = function() {

		   				    	 this.createStackedChart('student-morris-bar-stacked', array, 'y', ['a', 'b'], ['Obtained Rating', 'Total Rating'], ['#7e57c2', "#ebeff2"]);
		   				         
		   				    },
		   				    //init
		   				    $.MorrisCharts = new MorrisCharts, $.MorrisCharts.Constructor = MorrisCharts
		   				}(window.jQuery),

		   				//initializing 
		   				function($) {
		   				    "use strict";
		   				    $.MorrisCharts.init();
		   				   
		   				}(window.jQuery);
		   			}
		   			else
		   			{
		   				edumaatAlert({
			    			  title: "Info !",
			    			  text:"Data Not Found",
			    			  type: "info",
			    			  confirmButtonText: "Cool"
			    			});
		   				$("#visibility").empty();
		   			}
		   			
		   		   },
		   		   error: function(){
		   			   alert('ERROR OCCURED');
		   			   window.location.href=ctx+"/home";
		   	       }
		   		});
	   });
	   
	 

});

function mytimetable(){
	   $("#dailyTimeTableStudent").empty();  
		var classId=$("#classId").val();
		var sectionId=$("#sectionId").val();
		   var timetablegeneratorhourstitle = new Array();
		  
if(classId!=" " && classId!=null  && sectionId!=" " && sectionId!=null ){
$.get(ctx+"/timetable/generator/classAndSection",{classId:classId,sectionId:sectionId},function(response){
		 var  timeTableGeneratorDays=[];
			 var  timeTableGeneratorHours=[];
			 /*<thead><tr id="th"><th></th></tr></thead>*/
		 	  table = $('<table id="table1"  class="table table-bordered" style="display:block;overflow-x: auto;"><thead><tr id="th"><th>DAY/HOUR</th></tr></thead><tbody>');
		 	timetabletemplatehours=[];
			timetabletemplatedaystitle=[];
			timetabletemplatedays=[];
			timetablegeneratorhourstitle=[];
			  var columncount=0; 
				  var rowcount=0;
			if(response.timeTableGeneratorDays)	
				{
				$("#dailyTimeTableStudent").append('<h3 class="m-t-0 header-title" style="color:purple;">Today TimeTable</h3><br>');
			   $.each(response.timeTableGeneratorDays, function(key,value) 
	        			{ 
				   
				   var d = new Date();
				    var weekday = new Array(7);
				    weekday[0] = "Sunday";
				    weekday[1] = "Monday";
				    weekday[2] = "Tuesday";
				    weekday[3] = "Wednesday";
				    weekday[4] = "Thursday";
				    weekday[5] = "Friday";
				    weekday[6] = "Saturday";
				    var n = weekday[d.getDay()];
				    if(n==value.timeTableGeneratorDayName)
				    	{
				timetabletemplatedays[key]=key;
				timetabletemplatedaystitle[key]=value.timeTableGeneratorDayName;
				rowcount=rowcount+1;
     			
				var tr = $('<tr>');
					$('<td style="width:200px;font-size:15px;" class="text-pink">'+value.timeTableGeneratorDayName+'</td>').appendTo(tr); 
					   			$.each(value.timeTableGeneratorHours, function(key1,value1) 
   	        			{
					   				columncount=columncount+1;
	       	        				
					   				timetabletemplatehours[key1]=key1;
					   				var dynamicid=key+""+key1;
				   				var labelvalue=key+""+key1+"label";
				   				
				   				$('<td class="edittdd" id='+dynamicid+"td"+'><label for="'+dynamicid+"label"+'" id="'+dynamicid+"label"+'" required="required" ></label><div class="error'+dynamicid+' " style="color:red"></div></td>').appendTo(tr); 
				   			
   	        			});
				   	   tr.appendTo(table);
				    	}
						});
			$("#dailyTimeTableStudent").append(table);
		   $.each(response.timeTableGeneratorDays, function(key,value) 
     			{ 
			   	$.each(value.timeTableGeneratorHours, function(key1,value1) 
     			{
			   	timetablegeneratorhourstitle[key1]=value1.hourTitle;
			   			var labelvalue=key+""+key1+"label";
			   			$("label[for="+labelvalue+"]").html(value1.subjectName);
     			});
				
     			});
		   
		var uniqueHourNames = [];
		$.each(timetablegeneratorhourstitle, function(i, el){
		    if($.inArray(el, uniqueHourNames) === -1) uniqueHourNames.push(el);
		});
	 $("#th").empty();
		   $('#th').append( $('<th />', {text : 'DAY/HOUR'}));
		   for(l=0;l<uniqueHourNames.length;l++)
			 {
		   		$('#th').append( $('<th />', {text :uniqueHourNames[l]}));
			 }
			
				}else
				{
					$(".alert-info").show();
				}
     		
});

}
else
{
	$(".alert-info").hide();
}
}

