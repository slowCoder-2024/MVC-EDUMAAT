
/**
* Theme: Ubold Admin Template
* Author: Coderthemes
* Morris Chart
*/
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

    	/* this.createBarChart('morris-bar-example', todayStudentAttendanceByClass(), 'y', ['a', 'b', 'c'], ['Present', 'OnDuty', 'Absent'], ['#7e57c2', '#34d3eb', "#ebeff2"]);*/
    	 this.createStackedChart('morris-bar-stacked', allClassWiseFeesPaidAndPending(institutionId), 'y', ['a', 'b'], ['Paid', 'Pending'], ['#7e57c2', "#ebeff2"]);
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




function allClassWiseFeesPaidAndPending(institutionId){
	var $areaData = [];
$.ajax({
	   url:ctx+'/dashboard/pendingAndPaidStudentRatioFromAllClassByInstitution',
	  type:'GET',
	  data:{institutionId:institutionId},
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