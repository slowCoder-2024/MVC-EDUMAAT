	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

$(document).ready(function(){
	myalert();
	   setInterval(function() {
			myalert();
			
		}, 60000);
	 	  
	  
	function myalert()
	{
		
		
		$("#inventoryItemPercentage,#inventoryItemIssuedPercentage,#inventoryItemReturnedPercentage").empty();
		$(".inventoryItemPercentage").append('<div id="inventoryItemPercentage" class="circliful-chart m-b-30 circliful-chart1" data-dimension="200"  data-text="" data-info="Inventory Item" data-width="20" data-fontsize="24" data-percent="" data-fgcolor="#5fbeaa" data-bgcolor="#ebeff2" data-fill="#f4f8fb"></div>');
        $(".inventoryItemIssuedPercentage").append('<div id="inventoryItemIssuedPercentage" class="circliful-chart m-b-30 circliful-chart2" data-dimension="200" data-text="" data-info="Inventory Item Issued" data-width="30" data-fontsize="24" data-percent="" data-fgcolor="#7266ba" data-bgcolor="#ebeff2"></div>');
        $(".inventoryItemReturnedPercentage").append('<div id="inventoryItemReturnedPercentage" class="circliful-chart m-b-30 circliful-chart3" data-startdegree="90" data-dimension="200" data-text="" data-info="Inventory Item Returned" data-width="30" data-fontsize="24" data-percent="" data-fgcolor="#61a9dc" data-bgcolor="#ebeff2"></div>');
		

		$.ajax({
			   url:ctx+'/dashboard/inventoryItemPercentage',
			   type:'GET',
			   async:false,
			   dataType:'JSON',
			   success: function(response){
				   

				   $("#inventoryItemPercentage").attr("data-percent",response.replace(/[^0-9\.]/g,''));
				   $("#inventoryItemPercentage").attr("data-text",response);
				   
				   $('.circliful-chart1').circliful();
				  
			   },
			   error: function(){
				   alert('ERROR OCCURED');
				   window.location.href=ctx+"/home";
		       }
			});
		
		$.ajax({
			   url:ctx+'/dashboard/inventoryItemIssuedPercentage',
			   type:'GET',
			   async:false,
			   dataType:'JSON',
			   success: function(response){
				  
				   $("#inventoryItemIssuedPercentage").attr("data-percent",response.replace(/[^0-9\.]/g,''));
				   $("#inventoryItemIssuedPercentage").attr("data-text",response);
				   $('.circliful-chart2').circliful();

			   },
			   error: function(){
				   alert('ERROR OCCURED');
				   window.location.href=ctx+"/home";
		       }
			});
		
		$.ajax({
			   url:ctx+'/dashboard/inventoryItemReturnedPercentage',
			   type:'GET',
			   async:false,
			   dataType:'JSON',
			   success: function(response){
	
				   $("#inventoryItemReturnedPercentage").attr("data-percent",response.replace(/[^0-9\.]/g,''));
				   $("#inventoryItemReturnedPercentage").attr("data-text",response);
				   $('.circliful-chart3').circliful();

			   },
			   error: function(){
				   alert('ERROR OCCURED');
				   window.location.href=ctx+"/home";
		       }
			});
		
		
		
	}
});



