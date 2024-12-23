var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
var institutionId=$("#institutionId").val();
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
    //creates Bar chart
    MorrisCharts.prototype.createBarChart  = function(element, data, xkey, ykeys, labels, lineColors) {
        Morris.Bar({
            element: element,
            data: data,
            xkey: xkey,
            ykeys: ykeys,
            labels: labels,
            hideHover: 'auto',
            resize: true, //defaulted to true
            gridLineColor: '#eeeeee',
            barColors: lineColors
        });
    },
   
      MorrisCharts.prototype.init = function() {

    	/* this.createBarChart('morris-bar-example', todayStudentAttendanceByClass(institutionId), 'y', ['a', 'b', 'c'], ['Present', 'OnDuty', 'Absent'], ['#7e57c2', '#34d3eb', "#ebeff2"]);*/
    	 this.createStackedChart('morris-bar-stacked', allClassWiseFeesPaidAndPending(), 'y', ['a', 'b'], ['Paid', 'Pending'], ['#7e57c2', "#ebeff2"]);
    	/* this.createStackedChart('morris-bar-stacked1', allClassWiseFeesPaidAndPending(), 'y', ['a', 'b'], ['Paid', 'Pending'], ['#7e57c2', "#ebeff2"]);*/
         
    },
    //init
    $.MorrisCharts = new MorrisCharts, $.MorrisCharts.Constructor = MorrisCharts
}(window.jQuery),

//initializing 
function($) {
    "use strict";
    $.MorrisCharts.init();
   
}(window.jQuery);

function allAcademicYearWiseFeesPaidAndPending(){
	var $areaData = [];
$.ajax({
	   url:ctx+'/dashboard/pendingAndPaidStudentRatioFromAllAcademicYear',
	  type:'GET',
	  async: false,
      cache: false,
      dataType:  'json',
       success: function(response){
			$.each(response, function(key,data)
                    {   
    			 //creating area chart
    		$areaData.push({ y: data.f1, a: data.f2 , b: data.f3 });
    		   });
		 
		 	   
	   }
});	
return $areaData;
}

function todayStudentAttendanceByClass(institutionId){
	var $areaData = [];
$.ajax({
	   url:ctx+'/dashboard/todayStudentAttendanceRadioFromClassByInstitution',
	  type:'GET',
	  data:{institutionId:institutionId},
	  async: false,
      cache: false,
      dataType:  'json',
       success: function(response){
			$.each(response, function(key,data)
                    {   
    			 //creating area chart
    		$areaData.push({ y: data.f1, a: data.f2 , b: data.f3,c: data.f4 });
    		   });
		 
		 	   
	   }
});	
return $areaData;
}

function allClassWiseFeesPaidAndPending(){
	var $areaData = [];
$.ajax({
	   url:ctx+'/dashboard/pendingAndPaidStudentRatioFromAllClass',
	  type:'GET',
	  async: false,
      cache: false,
      dataType:  'json',
       success: function(response){
			$.each(response, function(key,data)
                    {   
    			 //creating area chart
    		$areaData.push({ y: data.f1, a: data.f2 , b: data.f3 });
    		   });
		 
		 	   
	   }
});	
return $areaData;
}
var totalCount=[];
	var actualCount=[];
$('#academicYearList').change(function(event){
	   var academicYear=$("#academicYearList").val();
	   	$.ajax({
	   		   url:ctx+'/dashboard/studentAppraisalList',
	   		   type:'GET',
	   		  data:{academicYear:academicYear},
	   		   success: function(response){
	   			   
	   			if(response.length>0)
	   			{
	   			$("#radarr").empty();	
	   			$("#radarr").append('<canvas id="radar" ></canvas>');
	   		
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
	   			for(var i=1;i<=7;i++)
	   			{
	   				totalCount.push(count);
	   			}
	   			actualCount.push(totalrelationshipRating);
	   			actualCount.push(totalattitudeRating);
	   			actualCount.push(totalacademicRating);
	   			actualCount.push(totalinitiativeRating);
	   			actualCount.push(totalcreativityRating);
	   			actualCount.push(totalpunctualityRating);
	   			actualCount.push(totalsportsAndSocialRating);
	   			   var radarChartData = {
	   						labels : ["Relationship Rating","Attitude Rating","Academic Rating","Initiative Rating","Creativity Rating","Punctuality Rating","SportsAndSocial Rating"],
	   						datasets : [
	   									{
	   										fillColor : "rgba(239, 85, 58, 0.87)",
	   									strokeColor : "#e94e02",
	   									 pointColor : "#e94e02",
	   										pointStrokeColor : "#fff", 
	   										data : actualCount ,
	   										 label:"Optained Rating" 
	   										
	   										
	   									},
	   									{
	   										fillColor : "rgba(79, 82, 186, 0.87)",
	   										strokeColor : "#4F52BA",
	   										 pointColor : "#4F52BA",
	   										pointStrokeColor : "#fff",
	   										data : totalCount,
	   										 label:"Total Rating" 
	   									}
	   								]
	   						
	   					};
	   				var r=new Chart(document.getElementById("radar").getContext("2d")).Radar(radarChartData);
	   				document.getElementById('r-legend').innerHTML = r.generateLegend();
	   			}
	   			else
	   			{
	   			 var radarChartData = {
	   						labels : ["Relationship Rating","Attitude Rating","Academic Rating","Initiative Rating","Creativity Rating","Punctuality Rating","SportsAndSocial Rating"],
	   						datasets : [
	   									{
	   										fillColor : "rgba(239, 85, 58, 0.87)",
	   									strokeColor : "#e94e02",
	   									 pointColor : "#e94e02",
	   										pointStrokeColor : "#fff", 
	   										data : [0,0,0,0,0,0,0],
	   										 label:"Optained Rating" 
	   									},
	   									{
	   										fillColor : "rgba(79, 82, 186, 0.87)",
	   										strokeColor : "#4F52BA",
	   										 pointColor : "#4F52BA",
	   										pointStrokeColor : "#fff",
	   										data : [0,0,0,0,0,0,0],
	   										 label:"Total Rating" 
	   									}
	   								]
	   						
	   					};
	   				var r=new Chart(document.getElementById("radar").getContext("2d")).Radar(radarChartData);	
	   				document.getElementById('r-legend').innerHTML = r.generateLegend();
	   			}
	   			
	   		   },
	   		   error: function(){
	   			   alert('ERROR OCCURED');
	   			   window.location.href=ctx+"/home";
	   	       }
	   		});
});