
$(document).ready(
           
           /* This is the function that will get executed after the DOM is fully loaded */
           function () {
        		
            $('.form-control-datepicker').datepicker({
              
               changeMonth: true,//this option for allowing user to select month
               changeYear: true, //this option for allowing user to select from year range
   
               yearRange: "-100:+20"// range for year
             });
           }
         
         );
$(document).ready(
        
        /* This is the function that will get executed after the DOM is fully loaded */
        function () {
     		
         $('.form-control-birth-datepicker').datepicker({
           
            changeMonth: true,//this option for allowing user to select month
            changeYear: true, //this option for allowing user to select from year range

            yearRange: "-150:+0"// range for year
          });
        }
      
      );

/*$(document).ready(

This is the function that will get executed after the DOM is fully loaded 
function () {
	
$('.form-control-birth-datepicker').datepicker({
  
   changeMonth: true,//this option for allowing user to select month
   changeYear: true, //this option for allowing user to select from year range

   yearRange: "-150:+0"// range for year
 });
}

);*/