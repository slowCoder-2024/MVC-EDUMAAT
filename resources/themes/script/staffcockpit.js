	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

$(document).ready(function(){
	   $('#staffAcademicYearList').change(function(event){
		   var academicYear=$("#staffAcademicYearList").val();
		   	$.ajax({
		   		   url:ctx+'/dashboard/staffAppraisalList',
		   		   type:'GET',
		   		  data:{academicYear:academicYear},
		   		   success: function(response){
		   			   
		   			if(response.length>0)
		   			{
		   				document.getElementById('staffPerformanceImage').style.display="none";
		   				$("#staffvisibility").empty();
		   				$("#staffvisibility").append('<div id="staff-morris-bar-stacked" style="height: 300px;"></div>');
		   			var totalrelationshipRating=0;
		   			var totalteachingRating=0;
		   			var totalresearchAndHigherQualificationRating=0;
		   			var totalinitiativeAndOrganizationRating=0;
		   			var totalinnovationRating=0;
		   			var totalpunctualityRating=0;
		   			var totalgoalAlignmentRating=0;
		   			var count=0;
		   			  $.each(response, function(key,value) 
			        			{ 
		   				  			count=count+1;
		   				  			if(value.relationshipRating!=null)
		   				  	  		{
		   				  			totalrelationshipRating=parseFloat(totalrelationshipRating)+parseFloat(value.relationshipRating);
		   				  	  		}
		   				  			if(value.teachingRating!=null)
		   				  	  		{
		   				  			totalteachingRating=parseFloat(totalteachingRating)+parseFloat(value.teachingRating);
		   				  	  		}
		   				  			if(value.researchAndHigherQualificationRating!=null)
		   				  	  		{
		   				  			totalresearchAndHigherQualificationRating=parseFloat(totalresearchAndHigherQualificationRating)+parseFloat(value.researchAndHigherQualificationRating);
		   				  	  		}
		   				  	  		if(value.initiativeAndOrganizationRating!=null)
		   				  	  		{
		   				  	  		totalinitiativeAndOrganizationRating=parseFloat(totalinitiativeAndOrganizationRating)+parseFloat(value.initiativeAndOrganizationRating);
		   				  	  		}
		   				  	  		if(value.innovationRating!=null)
		   				  	  		{
		   				  	  		totalinnovationRating=parseFloat(totalinnovationRating)+parseFloat(value.innovationRating);
		   				  	  		}
		   				  	  		if(value.punctualityRating!=null)
		   				  	  		{
		   				  	  		totalpunctualityRating=parseFloat(totalpunctualityRating)+parseFloat(value.punctualityRating);
		   				  	  		}
		   				  	  		if(value.goalAlignmentRating!=null)
		   				  	  		{
		   				  	  		totalgoalAlignmentRating=parseFloat(totalgoalAlignmentRating)+parseFloat(value.goalAlignmentRating);
		   				  	  		}
		   				
			        			});
		   			
		   			count=count*5;
		   			

	   				var array=[];
	   				array.push({y:"Relationship",a:totalrelationshipRating,b:count});
	   				array.push({y:"Teaching",a:totalteachingRating,b:count});
	   				array.push({y:"Research And HigherQualification",a:totalresearchAndHigherQualificationRating,b:count});
	   				array.push({y:"Initiative And Organization",a:totalinitiativeAndOrganizationRating,b:count});
	   				array.push({y:"Innovation",a:totalinnovationRating,b:count});
	   				array.push({y:"Punctuality",a:totalpunctualityRating,b:count});
	   				array.push({y:"Goal Alignment",a:totalgoalAlignmentRating,b:count});
		   		
		   				
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

		   				    	 this.createStackedChart('staff-morris-bar-stacked', array, 'y', ['a', 'b'], ['Obtained Rating', 'Total Rating'], ['#7e57c2', "#ebeff2"]);
		   				         
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
		   			$("#staffvisibility").empty();
		   			}
		   			
		   		   },
		   		   error: function(){
		   			   alert('ERROR OCCURED');
		   			   window.location.href=ctx+"/home";
		   	       }
		   		});
	   });
	
});

