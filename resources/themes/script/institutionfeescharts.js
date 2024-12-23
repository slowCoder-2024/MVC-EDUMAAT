var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));


var institutionId=$("#institutionId").val();
!function($) {
    "use strict";

    var ChartC3 = function() {};

    ChartC3.prototype.init = function () {
 
    	 
    	var academicYearId=$("#academicYearWiseFeesPaidAndPending").val();
    	var charttype=$('#chart-type-academicYear').val();
    	academicYearWiseFeesPaidAndPending(academicYearId,charttype,institutionId);
    	
    	
    	$('#academicYearWiseFeesPaidAndPending').on('change',function(event){
    		var academicYearId=$(this).val();
    		var charttype=$('#chart-type-academicYear').val();
   		 academicYearWiseFeesPaidAndPending(academicYearId,charttype,institutionId);
    		 $('#donut-chart-academicYear').remove();
    	   	   
    	 });
    	
         $('#chart-type-academicYear').on('change',function(event){
 	       var academicYearId=$('#academicYearWiseFeesPaidAndPending').val();
     		var charttype=$(this).val();
     			academicYearWiseFeesPaidAndPending(academicYearId,charttype,institutionId);
     			 $('#donut-chart-academicYear').remove();
     		 });
        
       
        
    

    },
    $.ChartC3 = new ChartC3, $.ChartC3.Constructor = ChartC3

}(window.jQuery),

//initializing 
function($) {
    "use strict";
    $.ChartC3.init()
}(window.jQuery);



function academicYearWiseFeesPaidAndPending(academicYearId,charttype,institutionId){
	if(academicYearId!=null){	
$.ajax({
	   url:ctx+'/dashboard/pendingAndPaidStudentRatioFromAcademicYearAndInstitution',
	   data:{academicYear:academicYearId,institutionId:institutionId},
	   type:'GET',
	   cache: false,
	   dataType: 'json',
	     success: function(response){
	    		if(!$.trim(response))
				 {
				 edumaatAlert({
			    		 title:"Message !",
			    		 text:"No Data Found",
			    		 type:"info",
			    	});
				 }else{
		   if(response.f1>0 | response.f2>0){
		   
			   document.getElementById('academicYearImage').style.display="none";
			  
			   $('#academicYearChart').append('<div id="donut-chart-academicYear"></div>');
			
			   
c3.generate({
     bindto: '#donut-chart-academicYear',
    data: {
        columns: [
            ['Paid', response.f1],
            ['Pending', response.f2],
        ],
        type : charttype
    },
    donut: {
        title: "",
        width: 50,
		label: { 
			show:true
		}
    },
    color: {
    	pattern: ['#4CAF50','#F44336']
    }
});
	   }else{
			   
			   document.getElementById('academicYearImage').style.display="block";
		   }	   
			   
		
				 }
	   }
});


}else{
		   document.getElementById('academicYearImage').style.display="block";
		   document.getElementById('academicYearChart').style.display="none";
		   document.getElementById('academicYearDiv').style.display="none";

		
	}	
}



