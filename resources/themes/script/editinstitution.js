$(document).ready(function() 
		{
	
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
	$("#updateinstitution").click(function(event) {
		 var updateInstitutionId = $(this).attr('data-id');
				 $("#updateInstitutionId").val(updateInstitutionId);
			if($("#editinstitutionform").valid()){
				
				$("#institutionupdateconfirmation").modal('show');	
				 $("#institutionupdateconfirm").click(function(){
				
					 $("#editinstitutionform").submit();
			});		
				
			} 
			
	
	});
	
 	
    $('#geographicallocation').change(function(event) {
   	    var country = $("#geographicallocation").val();
   	  $('#geographicallocationstate').attr('disabled', false);
	  $('#geographicallocationcity').attr('disabled', false);
   	    $.get(ctx+'/geographicallocation/state', {
	                country : country
	        }, function(response) {
	        	  var select = $('#geographicallocationstate');
	        	   select.find('option').remove();
	        	   var select1=$('#geographicallocationcity');
	        	   		select1.find('option').remove();
	        	   	  $('#geographicallocationstate').selectpicker('destroy');
    	        	  $('#geographicallocationcity').selectpicker('destroy');
	            	 $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select State</option>');
	   	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
	   	        	    	}
	            		 $('#geographicallocationstate').append('<option id="'+value.name+'" value="'+value.name+'">'+value.name+'</option>');
	            	}); 
	            	  $('#geographicallocationstate').selectpicker('show');
    	        	  $('#geographicallocationcity').selectpicker('show'); 
	        });
	       
	 });
	        
	        
	$('#geographicallocationstate').change(function(event) {
	    var state = $("#geographicallocationstate").val();

	    $.get(ctx+'/geographicallocation/city', {
	            state : state
	    }, function(response) {
	    	
	    	  var select = $('#geographicallocationcity');
	        	 select.find('option').remove();
	        	 $('#geographicallocationcity').selectpicker('destroy');
	        	 $.each(response, function(key,value) {
	        		 if(key==0){
	        	    		select.append('<option value="" disabled selected>Select City</option>');
	        	    	}
	        		 $('#geographicallocationcity').append('<option id="'+value.name+'" value="'+value.name+'">'+value.name+'</option>');
	        	  
	        	 }); 
	        	 $('#geographicallocationcity').selectpicker('show');
	    });
	   
	    });	

 	
	
    /*$('#geographicallocation').change(function(event) {
  	  $('#geographicallocationstate').attr('disabled', false);
		  $('#geographicallocationcity').attr('disabled', false);
  	        var country = $("#geographicallocation").val();
  	        $.get(ctx+'/geographicallocation/state', {
  	                country : country
  	        }, function(response) {
  	        	  var select = $('#geographicallocationstate');
  	        	   select.find('option').remove();
  	        	   var select1=$('#geographicallocationcity');
	        	   		select1.find('option').remove();
  	            	 $.each(response, function(key,value) {
  	            		 if(key==0){
  	   	        	    		select.append('<option value="" disabled selected>Select State</option>');
  	   	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
  	   	        	    	}
  	            		 $('<option>').val(value.name).text(value.name).appendTo(select);
  	            	  
  	            	 }); 
  	        });
  	       
  	 });
  	        
  	        
  	$('#geographicallocationstate').change(function(event) {
  		
  	    var state = $("#geographicallocationstate").val();
          $.get(ctx+'/geographicallocation/city', {
  	            state : state
  	    }, function(response) {
  	    	 var select = $('#geographicallocationcity');
  	        	 select.find('option').remove();
  	        	 $.each(response, function(key,value) {
  	        		 if(key==0){
  	        	    		select.append('<option value="" disabled selected>Select City</option>');
  	        	    	}
  	        		 $('<option>').val(value.name).text(value.name).appendTo(select);
  	        	  
  	        	 }); 
  	    });
  	   
  	    });*/
  	 
/*     $('#geographicallocation').change(function(event) {
   	    var countryid = $(this).children(':selected').attr('id');
   	    $.get(ctx+'/geographicallocation/state', {
	                countryId : countryid
	        }, function(response) {
	        	  var select = $('#geographicallocationstate');
	        	   select.find('option').remove();
	        	   var select1=$('#geographicallocationcity');
	        	   		select1.find('option').remove();
	            	 var obj = jQuery.parseJSON(response);
	            	
	            	 $.each(obj, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select State</option>');
	   	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
	   	        	    	}
	            		 $('#geographicallocationstate').append('<option id="'+value.geographicalLocationId+'" value="'+value.name+'">'+value.name+'</option>');
	            	}); 
	        });
	       
	 });
	        
	        
	$('#geographicallocationstate').change(function(event) {
	    var stateid = $(this).children(':selected').attr('id'); 

	    $.get(ctx+'/geographicallocation/city', {
	            stateId : stateid
	    }, function(response) {
	    	
	    	  var select = $('#geographicallocationcity');
	        	 select.find('option').remove();
	        	 var obj = jQuery.parseJSON(response);
	        	
	        	 $.each(obj, function(key,value) {
	        		 if(key==0){
	        	    		select.append('<option value="" disabled selected>Select City</option>');
	        	    	}
	        		 $('#geographicallocationcity').append('<option id="'+value.geographicalLocationId+'" value="'+value.name+'">'+value.name+'</option>');
	        	  
	        	 }); 
	    });
	   
	    });	*/
	
	
});

/*function showimage()
{
	var folder = "images/";


	        $(data).find("a").attr("href", function (i, val) {
	            if( val.match(/\.(jpe?g|png|gif)$/) ) { 
	                $("body").append( "<img src='"+ folder + val +"'>" );
	            } 
	        });
}
*/


