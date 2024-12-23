$(document).ready(function() {
     
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
	 $( ".form-control-firststep" ).dateDropper({
			minYear:'1930',
			init_animation:'bounce',
			dropWidth:'500'
		});
        	 
        	//adding department
        	 $("#moduleplanschedulesave").click(function(event){
        		 if($("#moduleplanscheduleform").valid())
        		 {
        			  $('#confirm-save').modal('show');
        		 }
        		
        		// $('#addDepartmentForm').validate({
  				 //  submitHandler: function(form) {
                 //   $('#departmentAddingConfirmation').modal('show');
  	        	/*	$('#confirmAddDepartment').click(function(){
  	        			var data=$('#addDepartmentForm').serialize();
  	        				$.post("department/add",data,function(data) {
  	        					window.location.href="department";
  	                 });
  	               });*/
  			           
  			     //   }
  			   // });	   
        		 
        	 });
        	 
         	//adding department
         	 $("#moduleplansave").click(function(event){
         		 if($("#moduleplanform").valid())
         		 {
         			  $('#confirm-save').modal('show');
         		 }
         		
         		// $('#addDepartmentForm').validate({
   				 //  submitHandler: function(form) {
                  //   $('#departmentAddingConfirmation').modal('show');
   	        	/*	$('#confirmAddDepartment').click(function(){
   	        			var data=$('#addDepartmentForm').serialize();
   	        				$.post("department/add",data,function(data) {
   	        					window.location.href="department";
   	                 });
   	               });*/
   			           
   			     //   }
   			   // });	   
         		 
         	 });
 });
/** Numbers Only**/
function isNumber(evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	    	$("#gradeSystemForm").before(
    		        '<div class="alert alert-warning alert-dismissable">'+
    		            '<button type="button" class="close" ' + 
    		                    'data-dismiss="alert" aria-hidden="true">' + 
    		                '&times;' + 
    		            '</button>' + 
    		            'Numbers Only Allowed.' + 
    		            '</div>'+
    		         '</div>');
    	
    	window.setTimeout(function() {
    	    $(".alert").fadeTo(500, 0).slideUp(500, function(){
    	        $(this).remove(); 
    	    });
    	},800);
	    	
	        return false;
	    }
	    return true;
	}
       