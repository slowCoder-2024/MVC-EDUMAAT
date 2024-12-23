$(document).ready(function() {
	 
	 
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
	      $('#geographicallocation').change(function(event) {
	    	  $('#geographicallocationstate').prop('disabled', false);
     		  $('#geographicallocationcity').prop('disabled', false);
        	        var country = $("#geographicallocation").val();
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
        	            		 $('<option>').val(value.name).text(value.name).appendTo(select);
        	            	
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
        	        		 $('<option>').val(value.name).text(value.name).appendTo(select);
        	        	  
        	        	 }); 
        	       	   $('#geographicallocationcity').selectpicker('show');
        	    });
        	   
        	    });
        	 
        	 
        	    
    });
 
 