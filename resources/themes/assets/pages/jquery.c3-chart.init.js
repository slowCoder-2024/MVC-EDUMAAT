var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
!function($) {
    "use strict";

    var ChartC3 = function() {};

    ChartC3.prototype.init = function () {
 
    	
    	 //Special Category Chart
    	var specialCategoryId=$("#specialCategory").val();
    	var charttype=$('#chart-type-specialcategory').val();
    	specialCategoryWiseStudentComponentData(specialCategoryId,charttype);
    	$('#specialCategory').on('change',function(){
    		
    		var specialCategoryId=$(this).val();
    		var charttype=$('#chart-type-specialcategory').val();
    		specialCategoryWiseStudentComponentData(specialCategoryId,charttype);
    		 $('#donut-chart').remove();
    	 });
    	
    /*	var academicYearId=$("#academicYearWiseFeesPaidAndPending").val();
    	var charttype=$('#chart-type-academicYear').val();
    	academicYearWiseFeesPaidAndPending(academicYearId,charttype);
    	$('#academicYearWiseFeesPaidAndPending').on('change',function(){
    		
    		var academicYearId=$(this).val();
    		var charttype=$('#chart-type-academicYear').val();
    		academicYearWiseFeesPaidAndPending(academicYearId,charttype);
    		 $('#donut-chart-academicYear').remove();
    	 });*/
        $('#chart-type-specialcategory').on('change',function(){
	       var specialCategoryId=$('#specialCategory').val();
    		var charttype=$(this).val();
    		specialCategoryWiseStudentComponentData(specialCategoryId,charttype);
    		 $('#donut-chart').remove();
    	 });
     
      /*  $('#chart-type-academicYear').on('change',function(){
 	       var academicYearId=$('#academicYearWiseFeesPaidAndPending').val();
     		var charttype=$(this).val();
     		academicYearWiseFeesPaidAndPending(academicYearId,charttype);
     		 $('#donut-chart-academicYear').remove();
     	 });
        */
  /*      function academicYearWiseFeesPaidAndPending(academicYearId,charttype){
    		if(academicYearId!=null){	
        $.ajax({
			   url:ctx+'/dashboard/pendingAndPaidStudentRatioFromAcademicYear',
			   data:{academicYear:academicYearId},
			   type:'GET',
			   success: function(response){
				 
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
            	pattern: ['#4F8A10','#D8000C']
            }
        });
			   }
				   
				   else{
					   
					   document.getElementById('academicYearImage').style.display="block";
				   }	   
					   
				
				   
			   }
        });
  

    	}
    		
    		else{
    			   document.getElementById('academicYearImage').style.display="block";
    			   document.getElementById('academicYearChart').style.display="none";
    			   document.getElementById('academicYearDiv').style.display="none";

    			
    		}	
    	}*/
        
     
        
    	function specialCategoryWiseStudentComponentData(specialCategoryId,charttype){
    		if(specialCategoryId!=null){	
        $.ajax({
			   url:ctx+'/dashboard/studentRatioFromSpecialCategory',
			   data:{specialCategory:specialCategoryId},
			   type:'GET',
			   success: function(response){
				 
				   if(response.f1>0 | response.f2>0| response.f3>0){
				   
					   document.getElementById('specialCateoryImage').style.display="none";
					  
					   $('#specialCategoryChart').append('<div id="donut-chart"></div>');
					
					   
        c3.generate({
             bindto: '#donut-chart',
            data: {
                columns: [
                    ['Male', response.f1],
                    ['Female', response.f2],
                    ['Others',response.f3]
                ],
                type : charttype
            },
            donut: {
                title: "Special Category",
                width: 50,
				label: { 
					show:true
				}
            },
            color: {
            	pattern: ['#DEB948','#FF80AB', '#5d9cec']
            }
        });
			   }
				   
				   else{
					   
					   document.getElementById('specialCateoryImage').style.display="block";
				   }	   
					   
				
				   
			   }
        });
  

    	}
    		
    		else{
    			   document.getElementById('specialCateoryImage').style.display="block";
    			   document.getElementById('specialCategoryChart').style.display="none";
    			   document.getElementById('specialCategoryDiv').style.display="none";

    			
    		}	
    	} 
    	
    	
        //Pie Chart to Donut
    	
    	
    	   $('#chart-type-bloodG').on('change',function(){
    	     
        		var charttype=$(this).val();
        		bloodGroupWiseStudentCount(charttype);
        		
        	 });
    	   var bgcharttype=$('#chart-type-bloodG').val();
    	bloodGroupWiseStudentCount(bgcharttype);
        function bloodGroupWiseStudentCount(bgcharttype){
       	 
        	
        	$.ajax({
        		   url:ctx+'/dashboard/studentRatioFromBloodGroup',
        		   type:'GET',
        		   success: function(response){
        				   var tmp=new Array();
     
                      	$.each(response, function(key,data)
                                      {   
                             tmp.push(data.f1,data.f2);
                           
                              });
           
                   
                      	 c3.generate({
                             bindto: '#pie-chart',
                            data: {
                            	
                                columns: [[tmp[0],tmp[1]],[tmp[2],tmp[3]],[tmp[4],tmp[5]],[tmp[6],tmp[7]],[tmp[8],tmp[9]],[tmp[10],tmp[11]],[tmp[12],tmp[13]],[tmp[14],tmp[15]],[tmp[16],tmp[17]]
                                          
                                          ],
                                type : bgcharttype
                            },
                            color: {
                            	pattern: ['#B388FF', '#DEB948', '#FF80AB','#5d9cec','#8674A6','#578EBE','#A1887F','#FFAB00','#FFAB70']
                            },
                            pie: {
                		        label: {
                		          show: true
                		        }
                		    }
                        });
              
        			
        			}
        		 });
        }
        
        
        
        
        
   	 // Category Chart
    	var CategoryId=$("#Category").val();
    	
    	var categorycharttype=$('#chart-type-category').val();
    	
    	categoryWiseComponentData(CategoryId,categorycharttype);
    	$('#Category').on('change',function(){
    		
    		var CategoryId=$(this).val();
    		var categorycharttype=$('#chart-type-category').val();
    		categoryWiseComponentData(CategoryId,categorycharttype);
    		 $('#donut-chart-category').remove();
    	 });
        $('#chart-type-category').on('change',function(){
	       var CategoryId=$('#Category').val();
    		var categorycharttype=$(this).val();
    		categoryWiseComponentData(CategoryId,categorycharttype);
    		 $('#donut-chart-category').remove();
    	 });
    	function categoryWiseComponentData(CategoryId,categorycharttype){
    		
    		if(CategoryId!=null){	
    			
    			
        $.ajax({
			   url:ctx+'/dashboard/studentRatioFromCategory',
			   data:{categoryId:CategoryId},
			   type:'GET',
			   success: function(response){
				 
				   if(response.f1>0 | response.f2>0| response.f3>0){
				   
					   document.getElementById('cateoryImage').style.display="none";
					  
					   $('#categoryChart').append('<div id="donut-chart-category"></div>');
					
					   
        c3.generate({
             bindto: '#donut-chart-category',
            data: {
                columns: [
                    ['Male', response.f1],
                    ['Female', response.f2],
                    ['Others',response.f3]
                ],
                type : categorycharttype
            },
            donut: {
                title: "Category",
                width: 50,
				label: { 
					show:true
				}
            },
            color: {
            	pattern: ['#DEB948','#FF80AB', '#5d9cec']
            }
        });
			   }
				   
				   else{
					   
					   document.getElementById('cateoryImage').style.display="block";
				   }	   
					   
				
				   
			   }
        });
  

    	}
    		
    		else{
    			   document.getElementById('cateoryImage').style.display="block";
    			   document.getElementById('categoryChart').style.display="none";
    			   document.getElementById('categoryDiv').style.display="none";

    			
    		}	
    	} 
    	
        
        
        
        
        
        
        //generating chart 
        c3.generate({
            bindto: '#chart',
            data: {
                columns: [
                    ['SC', 30, 20, 50, 40, 60, 50],
                    ['BC', 200, 130, 90, 240, 130, 220],
                    ['MBC', 300, 200, 160, 400, 250, 250]
                ],
                type: 'bar',
                colors: {
                    data1: '#ebeff2',
                    data2: '#7e57c2',
                    data3: '#34d3eb'
                }
                
            }
        });
        //combined chart
        c3.generate({
            bindto: '#combine-chart',
            data: {
                columns: [
                    ['data1', 30, 20, 50, 40, 60, 50],
                    ['data2', 200, 130, 90, 240, 130, 220],
                    ['data3', 300, 200, 160, 400, 250, 250],
                    ['data4', 200, 130, 90, 240, 130, 220],
                    ['data5', 130, 120, 150, 140, 160, 150]
                ],
                types: {
                    data1: 'bar',
                    data2: 'bar',
                    data3: 'spline',
                    data4: 'line',
                    data5: 'bar'
                },
                colors: {
                    data1: '#ebeff2',
                    data2: '#7e57c2',
                    data3: '#34d3eb',
                    data4: '#fb6d9d',
                    data5: '#5fbeaa'
                },
                groups: [
                    ['data1','data2']
                ]
            },
            axis: {
                x: {
                    type: 'categorized'
                }
            }
        });
        //roated chart
        c3.generate({
            bindto: '#roated-chart',
            data: {
                columns: [
                ['INVOICES', 30, 200, 100, 400, 150, 250],
                ['OUTSTANDING', 50, 20, 10, 40, 15, 25]
                ],
                types: {
                	INVOICES: 'bar'
                },
                colors: {
                	INVOICES: '#34d3eb',
                	OUTSTANDING: '#EF5350'
	            },
            },
            axis: {
                rotated: true,
                x: {
                type: 'categorized'
                }
            }
        });

        //stacked chart
     /*   c3.generate({
            bindto: '#chart-stacked',
            data: {
                columns: [
                    ['Male', 30, 20, 50, 40, 60, 50],
                    ['Female', 200, 130, 90, 240, 130, 220],
                    ['Others', 200, 100, 90, 20, 130, 220]
                    
                ],
                types: {
                    data1: 'area-spline',
                    data2: 'area-spline',
                    data3: 'area-spline'
                    // 'line', 'spline', 'step', 'area', 'area-step' are also available to stack
                },
                colors: {
                    data1: '#DEB948',
	                data2: '#FF80AB',
	                data3: '#5d9cec'
                }
            }
        });*/
        c3.generate({
            bindto: '#chart1-stacked',
            data: {
                columns: [
                    ['Present', 30, 20, 50, 40, 60, 50,50,50,50,50,50,50,50,50],
                    ['Absent', 200, 130, 90, 240, 130, 220,50,50,50,50,50,50,50,50],
                    ['On Duty', 200, 100, 90, 20, 130, 220,50,50,50,50,50,50,50,50]
                    
                ],
                types: {
                    data1: 'area-spline',
                    data2: 'area-spline',
                    data3: 'area-spline'
                    // 'line', 'spline', 'step', 'area', 'area-step' are also available to stack
                },
                colors: {
                    data1: '#7e5ee2',
	                data2: '#7e57c2',
	                data3: '#34d3eb'
                }
            }
        });
        //Line regions
        c3.generate({
             bindto: '#line-regions',
            data: {
                columns: [
		            ['Attention Required', 30, 200, 100, 400, 150, 250],
		            ['Okay', 50, 20, 10, 40, 15, 25]
		        ],
		        regions: {
		            'data1': [{'start':1, 'end':2, 'style':'dashed'},{'start':3}], // currently 'dashed' style only
		            'data2': [{'end':3}]
		        },
		        colors: {
	                data1: '#34d3eb',
	                data2: '#7e57c2'
	            },
            },
            
        });
        //Scatter Plot
        c3.generate({
             bindto: '#scatter-plot',
             data: {
		        xs: {
		        	PreviousTerm: 'PreviousTerm_x',
		        	LastTerm: 'LastTerm_x',
		        },
		        // iris data from R
		        columns: [
		            ["PreviousTerm_x", 3.5, 3.0, 3.2, 3.1, 3.6, 3.9, 3.4, 3.4, 2.9, 3.1, 3.7, 3.4, 3.0, 3.0, 4.0, 4.4, 3.9, 3.5, 3.8, 3.8, 3.4, 3.7, 3.6, 3.3, 3.4, 3.0, 3.4, 3.5, 3.4, 3.2, 3.1, 3.4, 4.1, 4.2, 3.1, 3.2, 3.5, 3.6, 3.0, 3.4, 3.5, 2.3, 3.2, 3.5, 3.8, 3.0, 3.8, 3.2, 3.7, 3.3],
		            ["LastTerm_x", 3.2, 3.2, 3.1, 2.3, 2.8, 2.8, 3.3, 2.4, 2.9, 2.7, 2.0, 3.0, 2.2, 2.9, 2.9, 3.1, 3.0, 2.7, 2.2, 2.5, 3.2, 2.8, 2.5, 2.8, 2.9, 3.0, 2.8, 3.0, 2.9, 2.6, 2.4, 2.4, 2.7, 2.7, 3.0, 3.4, 3.1, 2.3, 3.0, 2.5, 2.6, 3.0, 2.6, 2.3, 2.7, 3.0, 2.9, 2.9, 2.5, 2.8],
		            ["PreviousTerm", 0.2, 0.2, 0.2, 0.2, 0.2, 0.4, 0.3, 0.2, 0.2, 0.1, 0.2, 0.2, 0.1, 0.1, 0.2, 0.4, 0.4, 0.3, 0.3, 0.3, 0.2, 0.4, 0.2, 0.5, 0.2, 0.2, 0.4, 0.2, 0.2, 0.2, 0.2, 0.4, 0.1, 0.2, 0.2, 0.2, 0.2, 0.1, 0.2, 0.2, 0.3, 0.3, 0.2, 0.6, 0.4, 0.3, 0.2, 0.2, 0.2, 0.2],
		            ["LastTerm", 1.4, 1.5, 1.5, 1.3, 1.5, 1.3, 1.6, 1.0, 1.3, 1.4, 1.0, 1.5, 1.0, 1.4, 1.3, 1.4, 1.5, 1.0, 1.5, 1.1, 1.8, 1.3, 1.5, 1.2, 1.3, 1.4, 1.4, 1.7, 1.5, 1.0, 1.1, 1.0, 1.2, 1.6, 1.5, 1.6, 1.5, 1.3, 1.3, 1.3, 1.2, 1.4, 1.2, 1.0, 1.3, 1.2, 1.3, 1.3, 1.1, 1.3],
		        ],
		        
		        type: 'scatter'
		    },
		    color: {
            	pattern: ["#5d9cec", "#5fbeaa", "#5d9cec", "#5fbeaa"]
            },
		    axis: {
		        x: {
		            label: 'Sepal.Width',
		            tick: {
		                fit: false
		            }
		            
		        },
		        y: {
		            label: 'Petal.Width'
		        }
		    }
            
        });

 


    },
    $.ChartC3 = new ChartC3, $.ChartC3.Constructor = ChartC3

}(window.jQuery),

//initializing 
function($) {
    "use strict";
    $.ChartC3.init()
}(window.jQuery);



